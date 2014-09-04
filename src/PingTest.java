import TaxSvc.*;
import TaxSvc.CommonResponse.*;
import java.io.*;
import java.util.Properties;


public class PingTest {
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
