package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class VINResultParser extends ResultParser {
  private static final Pattern a = Pattern.compile("[IOQ]");
  
  private static final Pattern b = Pattern.compile("[A-Z0-9]{17}");
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\VINResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */