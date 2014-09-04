import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import TaxSvc.*;
import TaxSvc.CancelTaxRequest.CancelCode;
import TaxSvc.CommonResponse.*;

public class CancelTaxTest{
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

         CancelTaxRequest cancelTaxRequest = new CancelTaxRequest();

         // Required Request Parameters
         cancelTaxRequest.CompanyCode = "APITrialCompany";
         cancelTaxRequest.DocType = TaxSvc.DocType.SalesInvoice;
         cancelTaxRequest.DocCode = "INV001";
         cancelTaxRequest.CancelCode = CancelCode.DocVoided;

         CancelTaxResult cancelTaxResult = taxSvc.CancelTax(cancelTaxRequest);

         // Print results
         System.out.println("CancelTaxTest Result: " + cancelTaxResult.ResultCode.toString());
         if (cancelTaxResult.getResultCode() != SeverityLevel.Success)
         {
             for (Message message : cancelTaxResult.getMessages())
             {
                 System.out.println(message.Summary);
             }
         }
     }
	
	
}
