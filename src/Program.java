public class Program {	
	public static void main(String args[]){
		 try
         {
             // Each test is managed in its own class 
             // Make sure you enter your valid credentials in that test class.
             GetTaxTest.Test();
             CancelTaxTest.Test();
             EstimateTaxTest.Test();
             PingTest.Test();
             ValidateAddressTest.Test();
         }
         catch (Exception ex)
         { 
             System.out.println("An Exception Occured: " + ex.getMessage()); 
         }
         finally
         {
        	 System.out.println("Done");
        	 System.out.println();
         }
	}
	

}
