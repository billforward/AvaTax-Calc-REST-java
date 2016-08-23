package com.avatax.tax;


import com.avatax.common.Message;
import com.avatax.common.SeverityLevel;
import com.avatax.tax.CancelTaxResult;
import com.avatax.tax.TaxSvc;

public class CancelTaxResponse {
	public com.avatax.tax.CancelTaxResult CancelTaxResult;
	public SeverityLevel ResultCode;
	public Message[] Messages;
	
}
