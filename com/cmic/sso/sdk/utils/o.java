package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.a.b;

public class o {
  private static final String a = o.class.getSimpleName();
  
  private static o c;
  
  private Context b;
  
  private o(Context paramContext) {
    this.b = paramContext.getApplicationContext();
  }
  
  public static o a(Context paramContext) {
    if (c == null)
      c = new o(paramContext); 
    return c;
  }
  
  private String a(String paramString) {
    int i = paramString.hashCode();
    if (i != 49679479) {
      if (i != 49679502) {
        switch (i) {
          default:
            i = -1;
            break;
          case 49679477:
            if (paramString.equals("46007")) {
              i = 2;
              break;
            } 
          case 49679476:
            if (paramString.equals("46006")) {
              i = 5;
              break;
            } 
          case 49679475:
            if (paramString.equals("46005")) {
              i = 8;
              break;
            } 
          case 49679474:
            if (paramString.equals("46004")) {
              i = 3;
              break;
            } 
          case 49679473:
            if (paramString.equals("46003")) {
              i = 7;
              break;
            } 
          case 49679472:
            if (paramString.equals("46002")) {
              i = 1;
              break;
            } 
          case 49679471:
            if (paramString.equals("46001")) {
              i = 4;
              break;
            } 
          case 49679470:
            if (paramString.equals("46000")) {
              i = 0;
              break;
            } 
        } 
      } else if (paramString.equals("46011")) {
        i = 9;
      } else {
      
      } 
    } else if (paramString.equals("46009")) {
      i = 6;
    } else {
    
    } 
    switch (i) {
      default:
        return "0";
      case 7:
      case 8:
      case 9:
        f.a(a, "中国电信");
        return "3";
      case 4:
      case 5:
      case 6:
        f.a(a, "中国联通");
        return "2";
      case 0:
      case 1:
      case 2:
      case 3:
        break;
    } 
    f.a(a, "中国移动");
    return "1";
  }
  
  public String a() {
    try {
      b.b b = b.a().b();
      return b.g(b.f());
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public String a(boolean paramBoolean) {
    b.b b = b.a().b();
    String str2 = b.i(b.f());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = str2;
      if (t.b(this.b)) {
        TelephonyManager telephonyManager = (TelephonyManager)this.b.getSystemService("phone");
        str1 = str2;
        if (telephonyManager != null) {
          String str = telephonyManager.getSimOperator();
          str1 = str;
          if (TextUtils.isEmpty(str)) {
            str1 = str;
            if (k.a(this.b, "android.permission.READ_PHONE_STATE")) {
              str1 = str;
              if (t.e()) {
                str2 = null;
                try {
                  str1 = telephonyManager.getSubscriberId();
                  str2 = str1;
                } catch (Exception exception) {
                  f.a(a, "getOperator失败");
                } 
                str1 = str;
                if (!TextUtils.isEmpty(str2)) {
                  str1 = str;
                  if (str2.length() >= 5)
                    str1 = str2.substring(0, 5); 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    str2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("operator: ");
    stringBuilder.append(str1);
    f.b(str2, stringBuilder.toString());
    return TextUtils.isEmpty(str1) ? (paramBoolean ? "0" : "") : a(str1);
  }
  
  public String b() {
    try {
      b.b b = b.a().b();
      String str = b.g((b.f() + 1) % 2);
      return (str == null) ? "" : str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String c() {
    try {
      b.b b = b.a().b();
      String str2 = b.h(b.f());
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = ((TelephonyManager)this.b.getSystemService("phone")).getDeviceId(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("imei is ");
      stringBuilder.append(str1);
      f.b("UMC_SDK", stringBuilder.toString());
      boolean bool = TextUtils.isEmpty(str1);
      return bool ? "none" : str1;
    } catch (Exception exception) {
      return "none";
    } 
  }
  
  public String d() {
    try {
      b.b b = b.a().b();
      String str = b.h((b.f() + 1) % 2);
      return (str == null) ? "" : str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String e() {
    b.b b = b.a().b();
    return b.a(b.f());
  }
  
  public String f() {
    TelephonyManager telephonyManager = (TelephonyManager)this.b.getSystemService("phone");
    if (telephonyManager != null) {
      String str1 = telephonyManager.getSimOperator();
      String str2 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SysOperType = ");
      stringBuilder.append(str1);
      f.b(str2, stringBuilder.toString());
      return a(str1);
    } 
    return "0";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */