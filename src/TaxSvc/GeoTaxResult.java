package TaxSvc;

public class GeoTaxResult // Result of tax/get verb GET
{
    public Double Rate;

    public Double Tax;

    public TaxDetail[] TaxDetails;

    public CommonResponse.SeverityLevel ResultCode;

    public CommonResponse.Message[] Messages;
    
	public Double getRate(){return Rate;};
	public Double getTax(){return Tax;};
	public TaxDetail[] getTaxDetails(){return TaxDetails;};
	public CommonResponse.SeverityLevel getResultCode(){return ResultCode;}
	public CommonResponse.Message[] getMessages(){return Messages;}
	
	public void setRate(Double rate){Rate = rate;	}
	public void setTax(Double tax){Tax = tax;	}
	public void setTaxDetails(TaxDetail[] taxDetails){TaxDetails = taxDetails;	}
	public void setResultCode(CommonResponse.SeverityLevel resultCode){ResultCode = resultCode;}
	public void setMessages(CommonResponse.Message[] messages){Messages = messages;}
}
