package com.avatax.tax;

public class TaxAddress //Nested in GetTaxResult object
{
    public String Address;
    public String AddressCode;
    public String City;
    public String Region;
    public String Country;
    public String PostalCode;
    public String Latitude;
    public String Longitude;
    public String TaxRegionId;
    public String JurisCode;
    
    public String getAddressCode() {return AddressCode;}
    public String getAddress() {return Address;}
    public String getCity() {return City;}
    public String getRegion() {return Region;}
    public String getPostalCode() {return PostalCode;}
    public String getCountry() {return Country;}
    public String getLatitude() {return Latitude;}
    public String getLongitude() {return Longitude;}
    public String getTaxRegionId() {return TaxRegionId;}
    public String getJurisCode() {return JurisCode;}
    
    public void setAddressCode(String addressCode) {AddressCode = addressCode;}
    public void setLine1(String address) {  Address = address;}
    public void setCity(String city) {  City = city;}
    public void setRegion(String region) {  Region =region;}
    public void setPostalCode(String postalCode) {  PostalCode=postalCode;}
    public void setCountry(String country) {  Country = country;}
    public void setLatitude(String latitude) {  Latitude = latitude;}
    public void setLongitude(String longitude) {  Longitude = longitude;}
    public void setTaxRegionId(String taxRegionId) {  TaxRegionId = taxRegionId;}
    public void setJurisCode(String jurisCode) {JurisCode = jurisCode;}
}
