package com.alipay.sdk.app;

public enum k {
  a(9000, "处理成功"),
  b(4000, "系统繁忙，请稍后再试"),
  c(6001, "用户取消"),
  d(6002, "网络连接异常"),
  e(4001, "参数错误"),
  f(5000, "重复请求"),
  g(8000, "支付结果确认中");
  
  private int h;
  
  private String i;
  
  k(int paramInt1, String paramString1) {
    this.h = paramInt1;
    this.i = paramString1;
  }
  
  public static k b(int paramInt) {
    return (paramInt != 4001) ? ((paramInt != 5000) ? ((paramInt != 8000) ? ((paramInt != 9000) ? ((paramInt != 6001) ? ((paramInt != 6002) ? b : d) : c) : a) : g) : f) : e;
  }
  
  public int a() {
    return this.h;
  }
  
  public void a(int paramInt) {
    this.h = paramInt;
  }
  
  public void a(String paramString) {
    this.i = paramString;
  }
  
  public String b() {
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */