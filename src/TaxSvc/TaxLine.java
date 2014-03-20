package TaxSvc;

import TaxSvc.TaxDetail;

public class TaxLine //Nested in GetTaxResult object
{
    public String LineNo;
    public String TaxCode;
    public Boolean Taxability;
    public double Taxable;
    public double Rate;
    public double Tax;
    public double Discount;
    public double TaxCalculated;
    public double Exemption;
    public TaxDetail[] TaxDetails;
    public String BoundaryLevel;
    
    public String getLineNo() {return LineNo;}
    public String getTaxCode() {return TaxCode;}
    public Boolean getTaxability() {return Taxability;}
    public double getTaxable() {return  Taxable;}
    public double getRate() {return Rate;}
    public double getTax() {return Tax;}
    public double getDiscount() {return Discount;}
    public double getTaxCalculated() {return TaxCalculated;}
    public double getExemption() {return Exemption;}
    public TaxDetail[] getTaxDetails() {return TaxDetails;}
    public String getBoundaryLevel() {return BoundaryLevel;}
    
    public void setLineNo (String lineNo){LineNo = lineNo;}
    public void setTaxCode (String taxCode){TaxCode = taxCode;}
    public void setTaxability (Boolean taxability){Taxability = taxability;}
    public void setTaxable (double taxable){Taxable = taxable;}
    public void setRate (double rate){Rate = rate;}
    public void setTax (double tax){Tax = tax;}
    public void setDiscount (double discount){Discount = discount;}
    public void setTaxCalculated (double taxCalculated){TaxCalculated = taxCalculated;}
    public void setExemption (double exemption) {Exemption = exemption;}
    public void setTaxDetails (TaxDetail[] taxDetails){TaxDetails = taxDetails;}
    public void setBoundaryLevel (String boundaryLevel){BoundaryLevel = boundaryLevel;}
}
