import TaxSvc.*;
import TaxSvc.CommonResponse.*;


public class EstimateTaxTest {
    public static void Test()
    {
        // Header Level Elements
        // Required Header Level Elements
        String accountNumber = "1234567890";
        String licenseKey = "A1B2C3D4E5F6G7H8";
        String serviceURL = "https://development.avalara.net";

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
