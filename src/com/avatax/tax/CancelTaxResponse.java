package com.avatax.tax;


import com.avatax.address.CommonResponse;
import com.avatax.tax.CancelTaxResult;
import com.avatax.tax.TaxSvc;

public class CancelTaxResponse {
	public com.avatax.tax.CancelTaxResult CancelTaxResult;
	public CommonResponse.SeverityLevel ResultCode;
	public CommonResponse.Message[] Messages;
	
}
