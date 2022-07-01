package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class VCardResultParser extends ResultParser {
  private static final Pattern a = Pattern.compile("BEGIN:VCARD", 2);
  
  private static final Pattern b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
  
  private static final Pattern c = Pattern.compile("\r\n[ \t]");
  
  private static final Pattern d = Pattern.compile("\\\\[nN]");
  
  private static final Pattern e = Pattern.compile("\\\\([,;\\\\])");
  
  private static final Pattern f = Pattern.compile("=");
  
  private static final Pattern g = Pattern.compile(";");
  
  private static final Pattern h = Pattern.compile("(?<!\\\\);+");
  
  private static final Pattern i = Pattern.compile(",");
  
  private static final Pattern j = Pattern.compile("[;,]");
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\VCardResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */