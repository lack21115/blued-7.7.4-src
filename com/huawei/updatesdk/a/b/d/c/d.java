package com.huawei.updatesdk.a.b.d.c;

public class d extends b {
  public static final int ERROR = 1;
  
  public static final int NETWORK_ERROR = 3;
  
  public static final int OK = 0;
  
  public static final int PROGUARD_ERROR = 6;
  
  public static final int REQ_PARAM_ERROR = 5;
  
  public static final int RTN_CODE_OK = 0;
  
  public static final int TIMEOUT = 2;
  
  private a errCause = a.a;
  
  private int httpRespondeCode = 0;
  
  private String reason;
  
  private int responseCode = 1;
  
  private int rtnCode_ = 0;
  
  public a a() {
    return this.errCause;
  }
  
  public void a(int paramInt) {
    this.httpRespondeCode = paramInt;
  }
  
  public void a(a parama) {
    this.errCause = parama;
  }
  
  public void a(String paramString) {
    this.reason = paramString;
  }
  
  public int b() {
    return this.httpRespondeCode;
  }
  
  public void b(int paramInt) {
    this.responseCode = paramInt;
  }
  
  public String c() {
    return this.reason;
  }
  
  public int d() {
    return this.responseCode;
  }
  
  public int e() {
    return this.rtnCode_;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" { \n\tresponseCode: ");
    stringBuilder.append(d());
    stringBuilder.append("\n\trtnCode_: ");
    stringBuilder.append(e());
    stringBuilder.append("\n\terrCause: ");
    stringBuilder.append(a());
    stringBuilder.append("\n}");
    return stringBuilder.toString();
  }
  
  public enum a {
    a, b, c, d, e, f, g, h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\d\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */