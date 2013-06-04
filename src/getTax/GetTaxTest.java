package getTax;

import java.io.DataOutputStream;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetTaxTest {
	
	public static GetTaxResult GetTax(String baseURL, String username, String password, GetTaxRequest req){

		String taxget = baseURL+"tax/get";
		URL url;
		
		HttpURLConnection conn;
		try {			
			url = new URL(taxget);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
				
			String encoded = "Basic " + new String(Base64.encodeBase64((username+":"+password).getBytes()));
			conn.setRequestProperty ("Authorization", encoded);
			conn.setRequestProperty("Content-Type",
				      "application/x-www-form-urlencoded");
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			String content = mapper.writeValueAsString(req);
			//System.out.println(content);   //Uncomment to see the content of the request object
			conn.setRequestProperty("Content-Length", Integer.toString(content.length()));
			
			
		    DataOutputStream wr = new DataOutputStream (conn.getOutputStream ());
		    wr.writeBytes (content);
		    wr.flush ();
		    wr.close ();
			
			
			conn.disconnect();


			if(conn.getResponseCode() != 200)
			{
				GetTaxResult res = mapper.readValue(conn.getErrorStream(), GetTaxResult.class);
				for(int i = 0; i<res.Messages.length; i++)
				{
				System.out.println(res.ResultCode +": "+res.Messages[i].Summary);
				}
				return res;
			}	

			else
			{
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			GetTaxResult res = mapper.readValue(conn.getInputStream(), GetTaxResult.class);
			System.out.println(res.ResultCode+ " >> Total Tax Calculated: "+res.TotalTax);
			return res;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
}



}
