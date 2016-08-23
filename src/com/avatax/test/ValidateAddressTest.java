package com.avatax.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.avatax.address.Address;
import com.avatax.address.AddressSvc;
import com.avatax.address.ValidateResult;
import com.avatax.common.Message;
import com.avatax.common.SeverityLevel;

public class ValidateAddressTest {
	public static void Test() throws IOException
    {	
		Properties properties = new Properties();
   
	    try {
	    	InputStream in = InputStream.class.getResourceAsStream("/configuration.properties");
	    	properties.load(in);
	    	in.close();
	    } catch (IOException e) {
	      System.out.println("Unable to locate configuration.properties");
	      throw e;
	    }

        // Header Level Elements
        // Required Header Level Elements
        String accountNumber = properties.getProperty("configuration.account");
        String licenseKey = properties.getProperty("configuration.license");
        String serviceURL = properties.getProperty("configuration.url");

        AddressSvc addressSvc = new AddressSvc(accountNumber, licenseKey, serviceURL);

        Address address = new Address();

        // Required Request Parameters
        address.Line1 = "118 N Clark St";
        address.City = "Chicago";
        address.Region = "IL";

        // Optional Request Parameters
        address.Line2 = "Suite 100";
        address.Line3 = "ATTN Accounts Payable";
        address.Country = "US";
        address.PostalCode = "60602";

        ValidateResult validateResult = addressSvc.Validate(address);

        // Print results
        System.out.println("ValidateAddressTest Result: " + validateResult.ResultCode.toString());
        if (validateResult.getResultCode() != SeverityLevel.Success)
        {
            for (Message message : validateResult.getMessages())
            {
                System.out.println(message.Summary);
            }
        }
        else
        {
            System.out.println(validateResult.Address.Line1 
                + " " 
                + validateResult.Address.City 
                + ", "
                + validateResult.Address.Region 
                + " " 
                + validateResult.Address.PostalCode);
        }
    }


	
	
	
	
}
