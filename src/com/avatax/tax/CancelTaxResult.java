package com.avatax.tax;

import com.avatax.tax.CommonResponse.Message;
import com.avatax.tax.CommonResponse.SeverityLevel;

public class CancelTaxResult
{
	public SeverityLevel ResultCode;
	public String TransactionId;
	public String DocId;
	public Message[] Messages;
	
	public SeverityLevel getResultCode(){return ResultCode;}
	public String getTransactionId(){return TransactionId;}
	public String getDocId(){return DocId;}
	public Message[] getMessages(){return Messages;}
	
	public void setResultCode(SeverityLevel resultCode){ResultCode = resultCode;}
	public void setTransactionId(String transactionId){TransactionId = transactionId;}
	public void setDocId(String docId){DocId = docId;}
	public void setMessages(Message[] messages){Messages = messages;}
	
}
