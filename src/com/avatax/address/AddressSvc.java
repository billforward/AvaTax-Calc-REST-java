package com.avatax.address;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AddressSvc {
	private static String accountNum;
	private static String license;
	private static String svcURL;
	public AddressSvc(String accountNumber, String licenseKey, String serviceURL)
	{
		accountNum = accountNumber;
		license = licenseKey;
		svcURL = serviceURL;
	}
	public ValidateResult Validate(Address address){

		//Create query/url
		String queryparams = address.toQuery();
		String addrval = svcURL+"/1.0/address/validate?"+ queryparams;
		URL url;
		
		HttpURLConnection conn;
		try {			
			//Connect to specified URL with authorization header
			url = new URL(addrval);
			conn = (HttpURLConnection) url.openConnection();
			String encoded = "Basic " + new String(Base64.encodeBase64((accountNum+":"+license).getBytes())); //Create auth content
			conn.setRequestProperty ("Authorization", encoded); //Add authorization header
			conn.disconnect();
			
			
			ObjectMapper mapper = new ObjectMapper(); //Deserialization object
			
			if(conn.getResponseCode() != 200) //If we didn't get a success back, print out the error
			{
				ValidateResult vres = mapper.readValue(conn.getErrorStream(), ValidateResult.class); //Deserializes the response object
				return vres;
			}	

			else //Otherwise, print out the validated address.
			{
				ValidateResult vres = mapper.readValue(conn.getInputStream(), ValidateResult.class); //Deserializes the response object
				return vres;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
}

}
