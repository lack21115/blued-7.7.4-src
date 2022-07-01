package com.google.zxing.client.result;

public final class EmailAddressParsedResult extends ParsedResult {
  private final String[] a;
  
  private final String[] b;
  
  private final String[] c;
  
  private final String d;
  
  private final String e;
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder(30);
    a(this.a, stringBuilder);
    a(this.b, stringBuilder);
    a(this.c, stringBuilder);
    a(this.d, stringBuilder);
    a(this.e, stringBuilder);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\EmailAddressParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */