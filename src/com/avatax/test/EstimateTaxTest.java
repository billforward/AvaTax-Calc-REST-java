package com.avatax.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.avatax.common.Message;
import com.avatax.common.SeverityLevel;
import com.avatax.tax.GeoTaxResult;
import com.avatax.tax.TaxDetail;
import com.avatax.tax.TaxSvc;


public class EstimateTaxTest {
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

        TaxSvc taxSvc = new TaxSvc(accountNumber, licenseKey, serviceURL);

        // Required Request Parameters
        Double latitude = 47.627935;
        Double longitude = -122.51702;
        Double saleAmount = 10.0;

        GeoTaxResult geoTaxResult = taxSvc.EstimateTax(latitude, longitude, saleAmount);

        // Print results
        System.out.println("EstimateTaxTest Result: " + geoTaxResult.ResultCode.toString());
        if (geoTaxResult.getResultCode() != SeverityLevel.Success)
        {
            for (Message message : geoTaxResult.getMessages())
            {
                System.out.println(message.Summary);
            }
        }
        else
        {
            System.out.println("Total Rate: " + geoTaxResult.Rate + " Total Tax: " + geoTaxResult.Tax);

            for (TaxDetail taxDetail : (geoTaxResult.getTaxDetails() == null ? new TaxDetail[0] : geoTaxResult.getTaxDetails()))
            {
                System.out.println("    " + "Jurisdiction: " + taxDetail.JurisName + " Tax: " + taxDetail.Tax);
            }              
        }
    }

}
