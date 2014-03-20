import TaxSvc.*;
import TaxSvc.CancelTaxRequest.CancelCode;
import TaxSvc.CommonResponse.*;

public class CancelTaxTest{
	 public static void Test()
     {
         // Header Level Elements
         // Required Header Level Elements
         String accountNumber = "1234567890";
         String licenseKey = "A1B2C3D4E5F6G7H8";
         String serviceURL = "https://development.avalara.net";

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
