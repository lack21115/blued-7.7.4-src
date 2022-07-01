package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.a;

public class i {
  public static final String a = "pref_trade_token";
  
  public static final String b = ";";
  
  public static final String c = "result={";
  
  public static final String d = "}";
  
  public static final String e = "trade_token=\"";
  
  public static final String f = "\"";
  
  public static final String g = "trade_token=";
  
  public static String a(a parama, Context paramContext) {
    String str = j.b(parama, paramContext, "pref_trade_token", "");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("get trade token: ");
    stringBuilder.append(str);
    c.a("mspl", stringBuilder.toString());
    return str;
  }
  
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    String[] arrayOfString = paramString.split(";");
    String str = null;
    int j = 0;
    while (j < arrayOfString.length) {
      paramString = str;
      if (arrayOfString[j].startsWith("result={")) {
        paramString = str;
        if (arrayOfString[j].endsWith("}")) {
          String[] arrayOfString1 = arrayOfString[j].substring(8, arrayOfString[j].length() - 1).split("&");
          int k = 0;
          while (true) {
            paramString = str;
            if (k < arrayOfString1.length) {
              if (arrayOfString1[k].startsWith("trade_token=\"") && arrayOfString1[k].endsWith("\"")) {
                paramString = arrayOfString1[k].substring(13, arrayOfString1[k].length() - 1);
                break;
              } 
              if (arrayOfString1[k].startsWith("trade_token=")) {
                paramString = arrayOfString1[k].substring(12);
                break;
              } 
              k++;
              continue;
            } 
            break;
          } 
        } 
      } 
      j++;
      str = paramString;
    } 
    return str;
  }
  
  public static void a(a parama, Context paramContext, String paramString) {
    try {
      paramString = a(paramString);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("trade token: ");
      stringBuilder.append(paramString);
      c.a("mspl", stringBuilder.toString());
      if (!TextUtils.isEmpty(paramString))
        return; 
    } finally {
      paramContext = null;
      a.a(parama, "biz", "SaveTradeTokenError", (Throwable)paramContext);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */