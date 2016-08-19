package com.avatax.tax;

public class TaxOverrideDef
{
	public String TaxOverrideType; //Limited permitted values: TaxAmount, Exemption, TaxDate
	public String Reason;
	public String TaxAmount; //If included, must be valid decimal
	public String TaxDate; //If included, must be valid date 
	   	
	
}
