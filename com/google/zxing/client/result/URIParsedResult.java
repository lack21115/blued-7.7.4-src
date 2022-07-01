package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class URIParsedResult extends ParsedResult {
  private static final Pattern a = Pattern.compile(":/*([^/@]+)@[^/]+");
  
  private final String b;
  
  private final String c;
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder(30);
    a(this.c, stringBuilder);
    a(this.b, stringBuilder);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\URIParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */