AvaTax-REST-Java
=====================
[Other Samples](http://developer.avalara.com/avatax/sample-code)

This is a set of Java sample requests demonstrating the [AvaTax REST API](http://developer.avalara.com/avatax/tax/v1) methods:
 [tax/get POST](http://developer.avalara.com/avatax/tax/v1#getTax), [tax/get GET](http://developer.avalara.com/avatax/tax/v1#estimateTax), [tax/cancel POST](http://developer.avalara.com/avatax/tax/v1#cancelTax), and [address/validate GET](http://developer.avalara.com/avatax/tax/v1#validateAddress).
 
 For more information on the use of these methods and the AvaTax product, please visit our [developer site](http://developer.avalara.com/) or [Avalara homepage](http://www.avalara.com/)
 
Contents:
----------
 
<table>
<th colspan="2" align=left>Sample Files</th>
<tr><td>src/CancelTaxTest.java</td><td>Demonstrates the <a href="http://developer.avalara.com/avatax/tax/v1#cancelTax">CancelTax</a> method used to <a href="http://developer.avalara.com/avatax/voiding-documents">void a document</a>.</td></tr>
<tr><td>src/EstimateTaxTest.java</td><td>Demonstrates the <a href="http://developer.avalara.com/avatax/tax/v1#estimateTax">EstimateTax</a> method used for product- and line- indifferent tax estimates.</td></tr>
<tr><td>src/GetTaxTest.java</td><td>Demonstrates the <a href="http://developer.avalara.com/avatax/tax/v1#getTax">GetTax</a> method used for product- and line- specific <a href="http://developer.avalara.com/avatax/calculating-tax">calculation</a>.</td></tr>
<tr><td>src/PingTest.java</td><td>Uses a hardcoded EstimateTax call to test connectivity and credential information.</td></tr>
<tr><td>src/ValidateAddressTest.java</td><td>Demonstrates the <a href="http://developer.avalara.com/avatax/tax/v1#validateAddress">ValidateAddress</a> method to <a href="http://developer.avalara.com/avatax/address-validation">normalize an address</a>.</td></tr>
<th colspan="2" align=left>Other Files</th>
<tr><td>src/AddressSvc/</td><td>Contains the core classes that make the address validation service calls.</td></tr>
<tr><td>src/TaxSvc/</td><td>Contains the core classes that make the tax calculation service calls.</td></tr>
<tr><td>.gitattributes</td><td>-</td></tr>
<tr><td>.gitignore</td><td>-</td></tr>
<tr><td>LICENSE.md</td><td>-</td></tr>
<tr><td>README.md</td><td>-</td></tr>
</table>

Dependencies:
-----------
- JDK 5.0 or later
- [Jackson](https://github.com/FasterXML/jackson) is also required, and the pertinent libraries are included in /lib. It is provided here under the Apache License 2.0

Requirements:
----------
- Authentication requires an valid **Account Number** and **License Key**, which should be entered in the test file (e.g. GetTaxTest.rb) you would like to run.
- If you do not have an AvaTax account, a free trial account can be acquired through our [developer site](http://developer.avalara.com/avatax/get-started)
