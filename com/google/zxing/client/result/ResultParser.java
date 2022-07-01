package com.google.zxing.client.result;

import java.util.regex.Pattern;

public abstract class ResultParser {
  private static final ResultParser[] a = new ResultParser[] { 
      new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), 
      new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser() };
  
  private static final Pattern b = Pattern.compile("\\d+");
  
  private static final Pattern c = Pattern.compile("&");
  
  private static final Pattern d = Pattern.compile("=");
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\ResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */