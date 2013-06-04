

import cancelTax.CancelTaxRequest;
import getTax.GetTaxRequest;
import getTax.GetTaxTest;
import validateAddress.ValidateAddressTest;



public class Program {
	static String baseURL = "https://development.avalara.net/1.0/";
	static String username = "account.admin.1100014690";	//TODO: this should be your Avatax Account Number e.g. 1100012345
	static String password = "avalara";						//TODO: this should be the license key for the account above, e.g. 23CF4C53939C9725
	
	public static void main(String args[]){
	
		System.out.print(">>Address Validation (should be error): ");	
		ValidateAddressTest.Validate(baseURL, username, password, DocumentLoader.LoadInvalidAddress());
		
		System.out.print(">>Address Validation (should be success): ");		
		ValidateAddressTest.Validate(baseURL, username, password, DocumentLoader.LoadValidAddress());

		
		GetTaxRequest taxreq = DocumentLoader.LoadTaxRequest();
		System.out.print(">>Tax Calculation: ");
		GetTaxTest.GetTax(baseURL, username, password, taxreq);
		
		System.out.print(">>Cancel Tax: ");
		CancelTaxRequest cancelReq = DocumentLoader.LoadCancelRequest(taxreq);
		cancelTax.CancelTaxTest.CancelTax(baseURL, username, password, cancelReq);

	}
	

}
