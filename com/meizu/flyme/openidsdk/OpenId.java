package com.meizu.flyme.openidsdk;

public class OpenId {
  public long a;
  
  public String b;
  
  public String c;
  
  public int d;
  
  public OpenId(String paramString) {
    this.c = paramString;
  }
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  public void a(long paramLong) {
    this.a = paramLong;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public boolean a() {
    return (this.a > System.currentTimeMillis());
  }
  
  public void b() {
    this.a = 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\meizu\flyme\openidsdk\OpenId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */