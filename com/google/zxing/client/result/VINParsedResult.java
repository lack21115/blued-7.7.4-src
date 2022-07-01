package com.google.zxing.client.result;

public final class VINParsedResult extends ParsedResult {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private final String d;
  
  private final int e;
  
  private final char f;
  
  private final String g;
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder(50);
    stringBuilder.append(this.a);
    stringBuilder.append(' ');
    stringBuilder.append(this.b);
    stringBuilder.append(' ');
    stringBuilder.append(this.c);
    stringBuilder.append('\n');
    String str = this.d;
    if (str != null) {
      stringBuilder.append(str);
      stringBuilder.append(' ');
    } 
    stringBuilder.append(this.e);
    stringBuilder.append(' ');
    stringBuilder.append(this.f);
    stringBuilder.append(' ');
    stringBuilder.append(this.g);
    stringBuilder.append('\n');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\VINParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */