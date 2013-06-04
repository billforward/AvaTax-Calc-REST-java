package validateAddress;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateAddressTest {
	
	public static ValidateResult Validate(String baseURL, String username, String password, Address address){

			String queryparams = address.toQuery();
			String addrval = baseURL+"address/validate?"+ queryparams;
			URL url;
			
			HttpURLConnection conn;
			try {			
				url = new URL(addrval);
				conn = (HttpURLConnection) url.openConnection();
				String encoded = "Basic " + new String(Base64.encodeBase64((username+":"+password).getBytes()));
				conn.setRequestProperty ("Authorization", encoded);
				conn.disconnect();
				ObjectMapper mapper = new ObjectMapper();
				
				if(conn.getResponseCode() != 200)
				{
					ValidateResult vres = mapper.readValue(conn.getErrorStream(), ValidateResult.class);
					System.out.println(vres.ResultCode +": "+vres.Messages[0].Summary);
					return vres;
				}	

				else
				{
					ValidateResult vres = mapper.readValue(conn.getInputStream(), ValidateResult.class);
					System.out.println(vres.ResultCode +": "+vres.Address.toAddrString());
				return vres;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				return null;
				
			}
	}

	
	
	
	
}
