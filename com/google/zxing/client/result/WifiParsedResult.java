package com.google.zxing.client.result;

public final class WifiParsedResult extends ParsedResult {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private final boolean d;
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder(80);
    a(this.a, stringBuilder);
    a(this.b, stringBuilder);
    a(this.c, stringBuilder);
    a(Boolean.toString(this.d), stringBuilder);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\WifiParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */