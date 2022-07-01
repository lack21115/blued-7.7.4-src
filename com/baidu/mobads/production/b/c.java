package com.baidu.mobads.production.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashSet;
import java.util.Set;

public class c {
  private Set<String> a;
  
  private Set<String> b;
  
  private Set<String> c;
  
  private CookieManager d;
  
  private IXAdSystemUtils e = XAdSDKFoundationFacade.getInstance().getSystemUtils();
  
  private IXAdCommonUtils f = (IXAdCommonUtils)XAdSDKFoundationFacade.getInstance().getCommonUtils();
  
  private Context g;
  
  private int h;
  
  private String i;
  
  private String j;
  
  public c(Context paramContext, int paramInt, String paramString) {
    this.g = paramContext;
    this.h = paramInt;
    this.i = paramString;
    this.j = null;
    b();
    c();
  }
  
  public c(Context paramContext, String paramString1, String paramString2) {
    this.g = paramContext;
    this.j = paramString1;
    this.i = paramString2;
    this.h = -1;
    b();
    c();
  }
  
  private String a(String paramString) {
    return (paramString == null) ? null : paramString.replace(":", "-");
  }
  
  private void a(String paramString, Object paramObject) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(paramString);
    stringBuffer.append("=");
    stringBuffer.append(paramObject);
    stringBuffer.append(";");
    try {
      return;
    } finally {
      paramString = null;
    } 
  }
  
  private void b() {
    try {
      CookieSyncManager.createInstance(this.g);
    } finally {
      Exception exception = null;
    } 
  }
  
  private void c() {
    this.a = new HashSet<String>();
    this.a.add("46000");
    this.a.add("46002");
    this.a.add("46007");
    this.b = new HashSet<String>();
    this.b.add("46001");
    this.b.add("46006");
    this.c = new HashSet<String>();
    this.c.add("46003");
    this.c.add("46005");
  }
  
  private void d() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean e() {
    boolean bool = false;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)this.g.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean bool1 = bool;
      if (networkInfo != null) {
        int i = networkInfo.getType();
        bool1 = bool;
        if (i == 1)
          bool1 = true; 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private int f() {
    try {
      WifiInfo wifiInfo = ((WifiManager)this.g.getSystemService("wifi")).getConnectionInfo();
      return (wifiInfo == null) ? 0 : wifiInfo.getRssi();
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  private String g() {
    return "";
  }
  
  private String h() {
    return "";
  }
  
  private String i() {
    String str = null;
    try {
      String str1;
      PackageInfo packageInfo = this.g.getPackageManager().getPackageInfo(this.g.getPackageName(), 0);
      if (packageInfo == null) {
        packageInfo = null;
      } else {
        str1 = packageInfo.versionName;
      } 
      if (str1 != null)
        str = str1.replace(".", "-"); 
      return str;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  private int j() {
    String str = this.e.getNetworkOperator(this.g);
    return (str == null) ? 0 : (this.a.contains(str) ? 1 : (this.c.contains(str) ? 2 : (this.b.contains(str) ? 3 : 99)));
  }
  
  public String a() {
    d();
    if (this.j != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("https://cpu.baidu.com/block/app/");
      stringBuilder1.append(this.i);
      stringBuilder1.append("/");
      stringBuilder1.append(this.j);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://cpu.baidu.com/");
    stringBuilder.append(this.h);
    stringBuilder.append("/");
    stringBuilder.append(this.i);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */