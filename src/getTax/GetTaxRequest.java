package getTax;


import java.math.BigDecimal;
import java.sql.Date;

import validateAddress.Address;

public class GetTaxRequest {
	//Required for tax calculation
	public Date DocDate; //Must be valid YYYY-MM-DD format
	public String CustomerCode;
    public Address[] Addresses;
    public Line[] Lines;
    //Best Practice for tax calculation
    public String DocCode;
    public DocType DocType;
    public String CompanyCode;
    public Boolean Commit;
    public DetailLevel DetailLevel;
    public String Client;
    //Use where appropriate to the situation
    public String CustomerUsageType;
    public String ExemptionNo;
    public BigDecimal Discount;
    public TaxOverrideDef TaxOverride;
    public String BusinessIdentificationNo;
    
    //Optional
    public String PurchaseOrderNo;
    public String PaymentDate;
    public String ReferenceCode;								
    public String PosLaneCode;								


    
    public static class Line{
        public String LineNo; //Required
        public String DestinationCode; //Required
        public String OriginCode; //Required
        public String ItemCode; //Required
        public BigDecimal Qty; //Required
        public BigDecimal Amount; //Required
        public String TaxCode; //Best practice
        public String CustomerUsageType;
        public String Description; //Best Practice
        public Boolean Discounted;
        public Boolean TaxIncluded;
        public String Ref1;
        public String Ref2;
        
        
    }
    public static class TaxOverrideDef
    {
    	public String TaxOverrideType; //Limited permitted values: TaxAmount, Exemption, TaxDate
    	public String Reason;
    	public String TaxAmount; //If included, must be valid decimal
    	public String TaxDate; //If included, must be valid date 
    	   	
    	
    }
    
    public enum DocType { SalesOrder, SalesInvoice, ReturnOrder, ReturnInvoice, PurchaseOrder, PurchaseInvoice };
    public enum DetailLevel { Tax, Document, Line, Diagnostic };
    public enum SystemCustomerUsageType
    { 
        L,//"Other",
        A,//"Federal government",
        B,//"State government",
        C,//"Tribe / Status Indian / Indian Band",
        D,//"Foreign diplomat",
        E,//"Charitable or benevolent organization",
        F,//"Religious or educational organization",
        G,//"Resale",
        H,//"Commercial agricultural production",
        I,// "Industrial production / manufacturer",
        J,// "Direct pay permit",
        K,// "Direct Mail",
        N,// "Local Government",
        P,// "Commercial Aquaculture",
        Q,// "Commercial Fishery",
        R// "Non-resident"
    }

}
