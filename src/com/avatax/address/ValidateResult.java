package com.avatax.address;

import com.avatax.common.Message;
import com.avatax.common.SeverityLevel;

public class ValidateResult {
	public Address Address;
	public SeverityLevel ResultCode;
	public Message[] Messages;
	
	public Address getAddress(){return Address;};
	public SeverityLevel getResultCode(){return ResultCode;}
	public Message[] getMessages(){return Messages;}
	
	public void setAddress(Address address){Address = address;	}
	public void setResultCode(SeverityLevel resultCode){ResultCode = resultCode;}
	public void setMessages(Message[] messages){Messages = messages;}
}
