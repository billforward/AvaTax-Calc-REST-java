package AddressSvc;

public class CommonResponse {
	public static class Message{
		public String Summary;
		public String Details;
		public String RefersTo;
		public SeverityLevel Severity;
		public String Source;
		
		public String getSummary(){return Summary;}
		public String getDetails(){return Details;}
		public String getRefersTo(){return RefersTo;}
		public SeverityLevel getSeverity(){return Severity;}
		public String getSource(){return Source;}
		
		public void setSummary(String summary){Summary = summary;}
		public void setDetails(String details){Details = details;}
		public void setRefersTo(String refersTo){RefersTo= refersTo;}
		public void setSeverity(SeverityLevel severity){Severity = severity;}
		public void setSource(String source){Source = source;}
		
		
	}
	public enum SeverityLevel
	{Success, Warning, Error, Exception;}

}
