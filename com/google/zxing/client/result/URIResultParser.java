package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class URIResultParser extends ResultParser {
  private static final Pattern a = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
  
  private static final Pattern b = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\URIResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */