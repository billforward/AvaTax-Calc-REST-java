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

		//Create URL
		String taxget = baseURL+"tax/get";
		URL url;
		
		HttpURLConnection conn;
		try {
			//Connect to URL with authorization header, request content.
			url = new URL(taxget);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
				
			String encoded = "Basic " + new String(Base64.encodeBase64((username+":"+password).getBytes())); //Create auth content
			conn.setRequestProperty ("Authorization", encoded); //Add authorization header
			conn.setRequestProperty("Content-Type",
				      "application/x-www-form-urlencoded");
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);  //Tells the serializer to only include those parameters that are not null
			String content = mapper.writeValueAsString(req);
			//System.out.println(content);   //Uncomment to see the content of the request object
			conn.setRequestProperty("Content-Length", Integer.toString(content.length()));
			
			
		    DataOutputStream wr = new DataOutputStream (conn.getOutputStream ());
		    wr.writeBytes (content);
		    wr.flush ();
		    wr.close ();
			
			
			conn.disconnect();


			if(conn.getResponseCode() != 200) //If we didn't get a success back, print out the error.
			{
				GetTaxResult res = mapper.readValue(conn.getErrorStream(), GetTaxResult.class); //Deserializes the response
				for(int i = 0; i<res.Messages.length; i++) //There may be more than one thing wrong with a tax calculation.
				{
				System.out.println(res.ResultCode +": "+res.Messages[i].Summary);
				}
				return res;
			}	

			else //Otherwise, print out the total tax calculated
			{
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			GetTaxResult res = mapper.readValue(conn.getInputStream(), GetTaxResult.class); //Deserializes the response
			System.out.println(res.ResultCode+ " >> Total Tax Calculated: "+res.TotalTax); 
			return res;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
}



}
