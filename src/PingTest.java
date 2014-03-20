import TaxSvc.*;
import TaxSvc.CommonResponse.*;


public class PingTest {
	public static void Test()
    {
        // Header Level Elements
        // Required Header Level Elements
        String accountNumber = "1234567890";
        String licenseKey = "A1B2C3D4E5F6G7H8";
        String serviceURL = "https://development.avalara.net";

        TaxSvc taxSvc = new TaxSvc(accountNumber, licenseKey, serviceURL);

        GeoTaxResult geoTaxResult = taxSvc.Ping();

        System.out.println("PingTest Result: " + geoTaxResult.ResultCode.toString());
        if (geoTaxResult.getResultCode() != SeverityLevel.Success)
        {
            for (Message message : geoTaxResult.getMessages())
            {
                System.out.println(message.Summary);
            }
        }
    }

}
