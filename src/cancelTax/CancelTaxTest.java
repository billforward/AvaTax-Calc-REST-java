package cancelTax;



import java.io.DataOutputStream;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commonResponse.CommonResponse.SeverityLevel;

public class CancelTaxTest{
	public static CancelTaxResponse CancelTax(String baseURL, String username, String password, CancelTaxRequest req){

		String taxget = baseURL+"tax/cancel";
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
			//System.out.println(content);			//Uncomment to see the content of the request object
			conn.setRequestProperty("Content-Length", Integer.toString(content.length()));
			
			
		    DataOutputStream wr = new DataOutputStream (conn.getOutputStream ());
		    wr.writeBytes (content);
		    wr.flush ();
		    wr.close ();
			
			
			conn.disconnect();

			if(conn.getResponseCode() != 200) //Note: tax/cancel will return a 200 response even if the document could not be cancelled. Special attention needs to be paid to the ResultCode.
			{
				CancelTaxResponse res = mapper.readValue(conn.getErrorStream(), CancelTaxResponse.class);
				for(int i = 0; i<res.CancelTaxResult.Messages.length; i++)
				{
					System.out.println(res.CancelTaxResult.ResultCode +": "+res.CancelTaxResult.Messages[0].Summary);
				}
				return res;
			}	
			else
			{
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			CancelTaxResponse res = mapper.readValue(conn.getInputStream(), CancelTaxResponse.class);
			if(res.CancelTaxResult.ResultCode.equals(SeverityLevel.Error))
			{
				for(int i = 0; i<res.CancelTaxResult.Messages.length; i++)
				{
					System.out.println(res.CancelTaxResult.ResultCode +": "+res.CancelTaxResult.Messages[0].Summary);
				}
				
			}
			else
			{
				System.out.println(res.CancelTaxResult.ResultCode);
			}
			return res;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
}
	
	
	
}
