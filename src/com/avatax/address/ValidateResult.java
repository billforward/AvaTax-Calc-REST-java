package com.avatax.address;

public class ValidateResult {
	public Address Address;
	public CommonResponse.SeverityLevel ResultCode;
	public CommonResponse.Message[] Messages;
	
	public Address getAddress(){return Address;};
	public CommonResponse.SeverityLevel getResultCode(){return ResultCode;}
	public CommonResponse.Message[] getMessages(){return Messages;}
	
	public void setAddress(Address address){Address = address;	}
	public void setResultCode(CommonResponse.SeverityLevel resultCode){ResultCode = resultCode;}
	public void setMessages(CommonResponse.Message[] messages){Messages = messages;}
}
