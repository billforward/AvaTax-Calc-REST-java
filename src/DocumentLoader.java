
import getTax.GetTaxRequest;
import getTax.GetTaxRequest.DetailLevel;
import getTax.GetTaxRequest.DocType;
import getTax.GetTaxRequest.Line;

import java.math.BigDecimal;
import java.sql.Date;

import cancelTax.CancelTaxRequest;
import cancelTax.CancelTaxRequest.CancelCode;

import validateAddress.Address;


public class DocumentLoader {


	public static Address LoadInvalidAddress()
	{
		//Creates an invalid address for address validation testing
		Address address = new Address();
		address.Line1 = "PO Box 12345";
		address.City = "Bainbridge Island";
		address.Region = "WA";
		return address;
	}
	public static Address LoadValidAddress()
	{
		//Creates a valid address for address validation testing
		Address address = new Address();
		address.Line1 = "425 Ericksen Ave";
		address.City = "Bainbridge Island";
		address.Region = "WA";
		address.PostalCode = "98110";
		return address;
	}

	public static CancelTaxRequest LoadCancelRequest(GetTaxRequest taxreq)
	{
		CancelTaxRequest cancelTaxRequest = new CancelTaxRequest();

		cancelTaxRequest.CompanyCode=taxreq.CompanyCode;		// R: Company Code from the accounts Admin Console
        cancelTaxRequest.DocCode=taxreq.DocCode;              	// R: Invoice or document tracking number - Must be unique
        cancelTaxRequest.DocType=taxreq.DocType;    			// R: Typically SalesOrder,SalesInvoice, ReturnInvoice
        cancelTaxRequest.CancelCode=CancelCode.DocVoided;   	// R: Typically Unspecified, PostFailed, DocDeleted, 
                                                                //    DocVoided or AdjustmentCancelled
		
		return cancelTaxRequest;
		
	}
	public static GetTaxRequest LoadTaxRequest() {
		// creates test GetTaxRequest
		GetTaxRequest getTaxRequest = new GetTaxRequest();
	
		//Document Level Setup  
		//	     R: indicates Required Element
		//	     O: Indicates Optional Element
		//

	            // Set the tax document properties - Required unless noted as Optional
	            getTaxRequest.CompanyCode="SDK";                        	// R: Company Code from the accounts Admin Console
	            getTaxRequest.Client="AvaTaxCalcRESTJava Sample";
	            java.util.Date utilDate = new java.util.Date();
	            Date docDate = new Date(utilDate.getTime());                
	            getTaxRequest.DocCode= "SampleDoc: " + utilDate.toString(); // R: Invoice or document tracking number - Must be unique
	            getTaxRequest.DocType=DocType.SalesInvoice;                	// R: Typically SalesOrder,SalesInvoice, ReturnInvoice
	            getTaxRequest.DocDate = docDate;                            // R:  sets reporting date and default tax date
	            getTaxRequest.CustomerCode="TaxSvcTest";                   	// R: String - Customer Tracking number or Exemption Customer Code
	            getTaxRequest.DetailLevel=DetailLevel.Tax;             		// R: Chose Summary, Document, Line or Tax - varying levels of results detail 
	            getTaxRequest.Commit=false;                           		// O: Default is "false" - Set to "true" to commit the Document
	            //getTaxRequest.CustomerUsageType="G";						// O: Send for tax exempt transactions only.
	            //getTaxRequest.ExemptionNo="12334";						// O: Send for tax exempt transactions only.
	            //getTaxRequest.Discount=0;									// O: Send for document-level discounts only.
	            getTaxRequest.PurchaseOrderNo="PO 23423";					// O: Specifies the purchase order number associated with the transaction. This value can be used to track single-use exemption certficates.
	            getTaxRequest.ReferenceCode="";								// O: This is a reportable value that does not affect tax calculation.
	            getTaxRequest.PosLaneCode="";								// O: This is a reportable value that does not affect tax calculation.
	            //getTaxRequest.TaxOverride=new TaxOverrideDef();			// O: Allows the TaxDate =or other values) to be overridden for tax calculation. Situational only.				
	            //getTaxRequest.BusinessIdentificationNo="";				// O: Specified VAT ID of customer for international/VAT calculations and reporting.
	            
	            
//	          Begin Address Section
//	          Add the origin and destination addresses referred to by the
//	          "setOriginCode" and "setDestinationCode" properties above.

	            Address origin = new Address();
	            origin.AddressCode="Origin";
	            origin.Line1="Avalara";
	            origin.Line2="100 Ravine Lane NE";
	            origin.Line3="Suite 220";
	            origin.City="Bainbridge Island";
	            origin.Region="WA";
	            origin.PostalCode="98110";
	            origin.Country="USA";

	            Address destination = new Address();
	            destination.AddressCode="Dest";
	            destination.Line1="7462 Kearny Street";
	            destination.City="Commerce City";
	            destination.Region="CO";
	            destination.PostalCode="80022";
	            destination.Country="USA";
	            
	            Address[] addresses = {origin, destination};

	//
	// Alternate:  Latitude / Longitude addressing
	//	         
	//	            
//	            Address origin = new BaseAddress=;
//	            origin.AddressCode="Origin";
//	            origin.Latitude="47.6253";
//	            origin.Longitude="-122.515114";
//
//	            Address destination = new BaseAddress();
//	            destination.AddressCode="Destination";
//	            destination.Latitude="39.833597";
//	            destination.Longitude="-104.917220";
//				Address[] addresses = {origin, destination};	            

	 //	          End Address Section

	            getTaxRequest.Addresses=addresses;

	            // Add invoice lines
	            
	            Line line1 = new Line();                               		// New instance of a line                                
	            line1.LineNo="101";                              			// R: string - line Number of invoice - must be unique.
	            line1.ItemCode="Item001";                   				// R: string - SKU or short name of Item
	            line1.Qty=new BigDecimal(1);               					// R: decimal - The number of items -- Qty of product sold. Does not function as a mulitplier for Amount
	                                                         				//              see http://docs.oracle.com/javase/6/docs/api/java/math/BigDecimal.html regarding
	                                                        				//              the use of BigDecimal. BigDecimal class provides operations for arithmetic, scale
	                                                       					//              manipulation, rounding, comparison, hashing, and format conversion
	            line1.Amount=new BigDecimal(1000.00);  						// R: decimal - the "NET" amount -- Amount should be the 'extended' or 'net' amount
	            line1.CustomerUsageType="";           						// O: string - AKA Entity Use Code - Typically A - L =G = Reseller)
	            line1.Description="ITEM1";           						// O: string - Description or category of item sold.
	            line1.TaxCode="";                   						// O: string - Pass standard, custom or Pro-Tax code
	                                                  						//             Can be NULL to default to tangible personal property =P0000000)
	            line1.OriginCode="Origin";                      			// R: Value representing the Origin Address
	            line1.DestinationCode="Dest";                 	  			// R: Value representing the Destination Address

	            //Line 2 - Shipping/Freight line - See property descriptions above
	            Line line2 = new Line();                                   	// New instance of a line
	            line2.LineNo="102";                                   		// R: string - SKU or short name of Item
	            line2.ItemCode="Shipping";                       			// R: string - SKU or short name of Item
	            line2.Description="Shipping- Freight Charges";  			// O: string - Description or category of item sold.
	            line2.Qty=new BigDecimal(1);                   				// R: decimal - The number of items -- Qty of product sold. Does not function as a mulitplier for Amount
	                                                             			//              see http://docs.oracle.com/javase/6/docs/api/java/math/BigDecimal.html regarding
	                                                            			//              the use of BigDecimal. BigDecimal class provides operations for arithmetic, scale
	                                                           				//              manipulation, rounding, comparison, hashing, and format conversion
	            line2.Amount=new BigDecimal(10.00);        					// R: decimal - the "NET" amount -- Amount should be the 'extended' or 'net' amount
	            line2.TaxCode="FR";                       					// O: string - Pass standard, custom or Pro-Tax code FR020100
	            line2.OriginCode="Origin";                      			// R: Value representing the Origin Address
	            line2.DestinationCode="Dest";                 	  			// R: Value representing the Destination Address

	            Line[] lines = {line1, line2};
	            getTaxRequest.Lines = lines;            					// Sets array of lines
		
		
		return getTaxRequest;
	}
}
