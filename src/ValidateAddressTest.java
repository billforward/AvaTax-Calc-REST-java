import AddressSvc.CommonResponse.*;
import AddressSvc.*;

public class ValidateAddressTest {
    public static void Test()
    {
        // Header Level Elements
        // Required Header Level Elements
        String accountNumber = "1234567890";
        String licenseKey = "A1B2C3D4E5F6G7H8";
        String serviceURL = "https://development.avalara.net";

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
