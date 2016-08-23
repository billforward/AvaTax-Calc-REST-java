package com.avatax.tax;

import com.avatax.common.Message;
import com.avatax.common.SeverityLevel;

import java.util.Date;



public class GetTaxResult {
    public String DocCode;
    public Date DocDate;
    public Date Timestamp;
    public double TotalAmount;
    public double TotalDiscount;
    public double TotalExemption;
    public double TotalTaxable;
    public double TotalTax;
    public double TotalTaxCalculated;
    public Date TaxDate;
    public TaxLine[] TaxLines;
    public TaxLine[] TaxSummary;
    public TaxAddress[] TaxAddresses;
    public SeverityLevel ResultCode;
    public Message[] Messages;
    
    public String getDocCode(){return DocCode;}
    public Date getDocDate(){return DocDate;}
    public Date getTimestamp(){return Timestamp;}
    public double getTotalAmount(){return TotalAmount;}
    public double getTotalDiscount(){return TotalDiscount;}
    public double getTotalExemption(){return TotalExemption;}
    public double getTotalTaxable(){return TotalTaxable;}
    public double getTotalTax(){return TotalTax;}
    public double getTotalTaxCalculated(){return TotalTaxCalculated;}
    public Date getTaxDate(){return TaxDate;}
    public TaxLine[] getTaxLines(){return TaxLines;}
    public TaxLine[] getTaxSummary(){return TaxSummary;}
    public TaxAddress[] getTaxAddresses(){return TaxAddresses;}
	public SeverityLevel getResultCode(){return ResultCode;}
	public Message[] getMessages(){return Messages;}
    
    public void setDocCode(String docCode){DocCode = docCode;}
    public void setDocDate(Date docDate){DocDate = docDate;}
    public void setTimestamp(Date timestamp){Timestamp = timestamp;}
    public void setTotalAmount(double totalAmount){TotalAmount = totalAmount;}
    public void setTotalDiscount(double totalDiscount){TotalDiscount = totalDiscount;}
    public void setTotalExemption(double totalExemption){TotalExemption = totalExemption;}
    public void setTotalTaxable(double totalTaxable){TotalTaxable = totalTaxable;}
    public void setTotalTax(double totalTax){TotalTax = totalTax;}
    public void setTotalTaxCalculated(double totalTaxCalculated){TotalTaxCalculated = totalTaxCalculated;}
    public void setTaxDate(Date taxDate){TaxDate = taxDate;}
    public void setTaxLines(TaxLine[] taxLines){TaxLines = taxLines;}
    public void setTaxSummary(TaxLine[] taxSummary){TaxSummary = taxSummary;}
    public void setTaxAddresses(TaxAddress[] taxAddresses){TaxAddresses = taxAddresses;}
	public void setResultCode(SeverityLevel resultCode){ResultCode = resultCode;}
	public void setMessages(Message[] messages){Messages = messages;}

	
}
