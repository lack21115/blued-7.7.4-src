package com.huawei.updatesdk.b.b;

import android.content.Context;
import android.text.TextUtils;

public final class a {
  private static final Object c = new Object();
  
  private static a d;
  
  private b a;
  
  private String b;
  
  private a(Context paramContext) {
    this.a = b.a("DeviceSessionUpdateSDK_V1", paramContext);
  }
  
  public static a c() {
    synchronized (c) {
      if (d == null)
        d = new a(com.huawei.updatesdk.a.b.a.a.c().a()); 
      return d;
    } 
  }
  
  public String a() {
    return this.b;
  }
  
  public String a(String paramString) {
    b b1 = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updatesdk.lastAccountZone");
    stringBuilder.append(paramString);
    return b1.a(stringBuilder.toString(), "");
  }
  
  public void a(long paramLong) {
    this.a.b("updatesdk.lastCheckDate", paramLong);
  }
  
  public void a(String paramString, long paramLong) {
    b b1 = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updatesdk.lastInitAccountTime");
    stringBuilder.append(paramString);
    b1.b(stringBuilder.toString(), paramLong);
  }
  
  public void a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return; 
    this.a.b(paramString1, paramString2);
  }
  
  public long b() {
    return this.a.a("updatesdk.lastCheckDate", 0L);
  }
  
  public long b(String paramString) {
    b b1 = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updatesdk.lastInitAccountTime");
    stringBuilder.append(paramString);
    return b1.a(stringBuilder.toString(), 0L);
  }
  
  public void b(String paramString1, String paramString2) {
    b b1 = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updatesdk.lastAccountZone");
    stringBuilder.append(paramString1);
    b1.b(stringBuilder.toString(), paramString2);
  }
  
  public String c(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : this.a.a(paramString, "");
  }
  
  public void d(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */