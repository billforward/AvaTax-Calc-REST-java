package com.avatax.tax;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaxSvc {
	private String accountNum;
	private String license;
	private String svcURL;

	public TaxSvc(String accountNumber, String licenseKey, String serviceURL)
	{
		accountNum = accountNumber;
		license = licenseKey;
		svcURL = serviceURL;
	}

	public GetTaxResult GetTax(GetTaxRequest req) throws IOException {
		//Create URL
		String taxget = svcURL+"/1.0/tax/get";

		//Connect to URL with authorization header, request content.
		URL url = new URL(taxget);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setAllowUserInteraction(false);

		String encoded = "Basic " + new String(Base64.encodeBase64((accountNum+":"+license).getBytes())); //Create auth content
		conn.setRequestProperty ("Authorization", encoded); //Add authorization header
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		ObjectMapper mapper = objectMapper();
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
			return res;
		}
		else //Otherwise, print out the total tax calculated
		{
			GetTaxResult res = mapper.readValue(conn.getInputStream(), GetTaxResult.class); //Deserializes the response
			return res;
		}
	}

	public CancelTaxResult CancelTax(CancelTaxRequest req) throws IOException {

		//Create URL
		String taxget = svcURL+"/1.0/tax/cancel";
		//Connect to URL with authorization header, request content.
		URL url = new URL(taxget);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setAllowUserInteraction(false);

		String encoded = "Basic " + new String(Base64.encodeBase64((accountNum+":"+license).getBytes())); //Create auth content
		conn.setRequestProperty ("Authorization", encoded); //Add authorization header
		conn.setRequestProperty("Content-Type",
				  "application/x-www-form-urlencoded");

		ObjectMapper mapper = objectMapper();
		String content = mapper.writeValueAsString(req);
		//System.out.println(content);			//Uncomment to see the content of the request object
		conn.setRequestProperty("Content-Length", Integer.toString(content.length()));

		DataOutputStream wr = new DataOutputStream (conn.getOutputStream ());
		wr.writeBytes (content);
		wr.flush ();
		wr.close ();

		conn.disconnect();

		if(conn.getResponseCode() != 200)   //Note: tax/cancel will return a 200 response even if the document could not be cancelled. Special attention needs to be paid to the ResultCode.
		{									//If we got a more serious error, print out the error message.
			CancelTaxResult res = mapper.readValue(conn.getErrorStream(), CancelTaxResult.class);  //Deserialize response
			return res;
		}
		else
		{
			CancelTaxResponse res = mapper.readValue(conn.getInputStream(), CancelTaxResponse.class); //Deserialize response
			return res.CancelTaxResult;
		}
	}

	public GeoTaxResult EstimateTax(Double latitude, Double longitude, Double saleAmount) throws IOException {
		//Create query/url
		String taxest = svcURL+ "/1.0/tax/" + latitude.toString() + "," + longitude.toString() + "/get?saleamount=" + saleAmount.toString();
			//Connect to specified URL with authorization header
		URL url = new URL(taxest);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String encoded = "Basic " + new String(Base64.encodeBase64((accountNum+":"+license).getBytes())); //Create auth content
		conn.setRequestProperty ("Authorization", encoded); //Add authorization header
		conn.disconnect();

		ObjectMapper mapper = objectMapper();

		if(conn.getResponseCode() != 200) //If we didn't get a success back, print out the error
		{
			GeoTaxResult res = mapper.readValue(conn.getErrorStream(), GeoTaxResult.class); //Deserializes the response object
			return res;
		}

		else //Otherwise, print out the validated address.
		{
			GeoTaxResult res = mapper.readValue(conn.getInputStream(), GeoTaxResult.class); //Deserializes the response object
			return res;
		}
	}

    public enum DetailLevel { Tax, Document, Line, Diagnostic };

    public enum DocType 
    { SalesOrder, SalesInvoice, ReturnOrder, ReturnInvoice, PurchaseOrder, PurchaseInvoice, ReverseChargeOrder, ReverseChargeInvoice }

	public GeoTaxResult Ping() throws IOException {
		return EstimateTax(47.627935,-122.51702,10.0);
	};
	
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);  //Tells the serializer to only include those parameters that are not null
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}
}