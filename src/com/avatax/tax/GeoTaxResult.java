package com.avatax.tax;

import com.avatax.common.Message;
import com.avatax.common.SeverityLevel;

public class GeoTaxResult // Result of tax/get verb GET
{
    public Double Rate;

    public Double Tax;

    public TaxDetail[] TaxDetails;

    public SeverityLevel ResultCode;

    public Message[] Messages;
    
	public Double getRate(){return Rate;};
	public Double getTax(){return Tax;};
	public TaxDetail[] getTaxDetails(){return TaxDetails;};
	public SeverityLevel getResultCode(){return ResultCode;}
	public Message[] getMessages(){return Messages;}
	
	public void setRate(Double rate){Rate = rate;	}
	public void setTax(Double tax){Tax = tax;	}
	public void setTaxDetails(TaxDetail[] taxDetails){TaxDetails = taxDetails;	}
	public void setResultCode(SeverityLevel resultCode){ResultCode = resultCode;}
	public void setMessages(Message[] messages){Messages = messages;}
}
