package com.meizu.flyme.openidsdk;

public class ValueData {
  public String a;
  
  public int b;
  
  public long c;
  
  public ValueData(String paramString, int paramInt) {
    this.a = paramString;
    this.b = paramInt;
    this.c = System.currentTimeMillis() + 86400000L;
  }
  
  public native String toString();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\meizu\flyme\openidsdk\ValueData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */