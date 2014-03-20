package TaxSvc;


import java.math.BigDecimal;
import java.sql.Date;

import AddressSvc.Address;
import TaxSvc.TaxSvc.DocType;

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
    public TaxSvc.DetailLevel DetailLevel;
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
	public String CurrencyCode;								
 
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
