package com.google.zxing.client.result;

public final class GeoParsedResult extends ParsedResult {
  private final double a;
  
  private final double b;
  
  private final double c;
  
  private final String d;
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder(20);
    stringBuilder.append(this.a);
    stringBuilder.append(", ");
    stringBuilder.append(this.b);
    if (this.c > 0.0D) {
      stringBuilder.append(", ");
      stringBuilder.append(this.c);
      stringBuilder.append('m');
    } 
    if (this.d != null) {
      stringBuilder.append(" (");
      stringBuilder.append(this.d);
      stringBuilder.append(')');
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\GeoParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */