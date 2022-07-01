package com.google.zxing.client.result;

public final class TelParsedResult extends ParsedResult {
  private final String a;
  
  private final String b;
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder(20);
    a(this.a, stringBuilder);
    a(this.b, stringBuilder);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\TelParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */