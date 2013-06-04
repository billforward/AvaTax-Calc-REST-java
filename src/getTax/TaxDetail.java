package getTax;

public class TaxDetail //Nested in GetTaxResult object
{
    public double Rate;
    public double Tax;
    public double Taxable;
    public String Country;
    public String Region;
    public String JurisType;
    public String JurisName;
    public String TaxName;
    
    public double getRate() {return Rate;}
    public double getTax() {return Tax;}
    public double getTaxable() {return Taxable;}
    public String getCountry() {return Country;}
    public String getRegion() {return Region;}
    public String getJurisType() {return JurisType;}
    public String getJurisName() {return JurisName;}
    public String getTaxName() {return TaxName;}
    
    public void setRate(double rate) {Rate = rate;}
    public void setTax(double tax) {Tax = tax;}
    public void setTaxable(double taxable) {Taxable = taxable;}
    public void setCountry(String country) {Country = country;}
    public void setRegion(String region) {Region = region;}
    public void setJurisType(String jurisType) {JurisType = jurisType;}
    public void setJurisName(String jurisName) {JurisName = jurisName;}
    public void setTaxName(String taxName) {TaxName = taxName;}
}
