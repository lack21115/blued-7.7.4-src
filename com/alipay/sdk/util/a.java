package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

public class a {
  private static final String a = "00:00:00:00:00:00";
  
  private static a c;
  
  private String b;
  
  private a(Context paramContext) {
    try {
      this.b = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if (TextUtils.isEmpty(this.b)) {
        this.b = "00:00:00:00:00:00";
        return;
      } 
    } catch (Exception exception) {
      c.a(exception);
      if (TextUtils.isEmpty(this.b)) {
        this.b = "00:00:00:00:00:00";
        return;
      } 
    } finally {}
  }
  
  public static a a(Context paramContext) {
    if (c == null)
      c = new a(paramContext); 
    return c;
  }
  
  public static d b(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    try {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      return (networkInfo != null && networkInfo.getType() == 0) ? d.a(networkInfo.getSubtype()) : ((networkInfo != null && networkInfo.getType() == 1) ? d.a : d.o);
    } catch (Exception exception) {
      return d.o;
    } 
  }
  
  public static String c(Context paramContext) {
    return a(paramContext).c().substring(0, 8);
  }
  
  public static String d(Context paramContext) {
    if (paramContext == null)
      return ""; 
    try {
      return (paramContext.getResources().getConfiguration()).locale.toString();
    } finally {
      paramContext = null;
    } 
  }
  
  public String a() {
    return "000000000000000";
  }
  
  public String b() {
    return "000000000000000";
  }
  
  public String c() {
    StringBuilder stringBuilder1;
    String str1 = b();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("|");
    str1 = stringBuilder2.toString();
    String str2 = a();
    if (TextUtils.isEmpty(str2)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("000000000000000");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str1);
    stringBuilder3.append((String)stringBuilder1);
    return stringBuilder3.toString();
  }
  
  public String d() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */