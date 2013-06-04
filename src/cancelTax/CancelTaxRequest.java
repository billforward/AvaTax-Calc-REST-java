package cancelTax;

import getTax.GetTaxRequest.DocType;

public class CancelTaxRequest {
	public enum CancelCode { Unspecified, PostFailed, DocDeleted, DocVoided, AdjustmentCancelled; }
	
    public CancelCode CancelCode;
    //The document needs to be uniquely identified by DocCode/DocType/CompanyCode 
    public DocType DocType; //Note that the only *meaningful* values for this property here are SalesInvoice, ReturnInvoice, PurchaseInvoice.
    public String CompanyCode;
    public String DocCode;
   

}
