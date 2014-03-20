package AddressSvc;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;

public class Address {
	public enum AddressType
	{
		F,//Firm or company address
        G,//General Delivery address
        H,//High-rise or business complex
        P,//PO box address
        R,//Rural route address
        S;//Street or residential address
		
	}
    //Address can be determined for tax calculation by Line1, City, Region, PostalCode, Country OR Latitude/Longitude OR TaxRegionId
    public String AddressCode; //Input for GetTax only, not by address validation
    public String Line1;
    public String Line2;
    public String Line3;
    public String City;
    public String Region;
    public String PostalCode;
    public String Country;
    public String County; //Output for ValidateAddress only
    public String FipsCode; //Output for ValidateAddress only
    public String CarrierRoute; //Output for ValidateAddress only
    public String PostNet;//Output for ValidateAddress only
    public AddressType AddressType; //Output for ValidateAddress only
    public BigDecimal Latitude; //Input for GetTax only
    public BigDecimal Longitude; //Input for GetTax only
    public String TaxRegionId; //Input for GetTax only
	
    public String toQuery(){ //Formats the address input information as a query string for address validation.
    	String query = "";
    	String[][] addressinfo = {{"Line1","Line2","Line3","City","Region","PostalCode","Country"},{Line1, Line2, Line3, City, Region, PostalCode, Country}};
    	for (int i=0; i<7; i++)
    	{
	        if(addressinfo[1][i] != null &&!addressinfo[1][i].isEmpty()){
	        	try {
					query = ampQuery(query) + addressinfo[0][i]+"="+ URLEncoder.encode(addressinfo[1][i], "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
    	}

    	
    	return query;
    }
    
    public String toAddrString(){
    	return Line1+ " "+ City + ", "+ Region+" "+PostalCode;
    }
    private String ampQuery(String sub)
    {
    	if(!sub.endsWith("&") && sub.length()>0)
    	{
    		return sub+"&";
    	}
    	else
    	{
    		return sub;
    	}
    	
    }
}
