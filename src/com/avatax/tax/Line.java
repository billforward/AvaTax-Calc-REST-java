package com.avatax.tax;

import java.math.BigDecimal;

public class Line{
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
    public String BusinessIdentificationNo;
    public TaxOverrideDef TaxOverride;
    
    
}
