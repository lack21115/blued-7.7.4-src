package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.a.d;
import java.lang.reflect.Method;

public class g {
  public static String a;
  
  public static String b;
  
  public static String c;
  
  public static String d = "0";
  
  private static int a(int paramInt) {
    byte b = -101;
    if (paramInt != -101) {
      b = -1;
      if (paramInt != -1) {
        switch (paramInt) {
          default:
            return paramInt;
          case 13:
          case 18:
          case 19:
            return 3;
          case 3:
          case 5:
          case 6:
          case 8:
          case 9:
          case 10:
          case 12:
          case 14:
          case 15:
          case 17:
            return 2;
          case 1:
          case 2:
          case 4:
          case 7:
          case 11:
          case 16:
            break;
        } 
        return 1;
      } 
    } 
    return b;
  }
  
  public static NetworkInfo a(Context paramContext) {
    return (paramContext == null) ? null : ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static String a() {
    return a;
  }
  
  public static String b() {
    return (b != null) ? "https://open.e.189.cn/openapi/special/getTimeStamp.do".replace(d.a(b.f), b) : "https://open.e.189.cn/openapi/special/getTimeStamp.do";
  }
  
  public static boolean b(Context paramContext) {
    NetworkInfo networkInfo = a(paramContext);
    return (networkInfo != null && networkInfo.isAvailable());
  }
  
  public static String c() {
    return (c != null) ? "https://collect.ux.21cn.com/collect/custom/accountMsg".replace(d.a(b.g), c) : "https://collect.ux.21cn.com/collect/custom/accountMsg";
  }
  
  public static boolean c(Context paramContext) {
    NetworkInfo networkInfo = a(paramContext);
    return (networkInfo != null && networkInfo.getType() == 0);
  }
  
  public static boolean d(Context paramContext) {
    if (paramContext == null)
      return true; 
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      return ((Boolean)method.invoke(connectivityManager, new Object[0])).booleanValue();
    } finally {
      paramContext = null;
      CtAuth.warn("NetUtil", "isMobileEnable error ", (Throwable)paramContext);
    } 
  }
  
  public static String e(Context paramContext) {
    String str1;
    int i = h(paramContext);
    String str2 = "null";
    if (i != -101) {
      str1 = str2;
      if (i != -1) {
        str1 = str2;
        if (i != 0)
          return (i != 1) ? ((i != 2) ? ((i != 3) ? Integer.toString(i) : "4G") : "3G") : "2G"; 
      } 
    } else {
      str1 = "WIFI";
    } 
    return str1;
  }
  
  public static String f(Context paramContext) {
    String str = e(paramContext);
    return (str != null && str.equals("WIFI") && d(paramContext)) ? "BOTH" : str;
  }
  
  public static String g(Context paramContext) {
    String str = f(paramContext);
    if (!TextUtils.isEmpty(str)) {
      if (str.equals("null"))
        return "15"; 
      if (str.equals("2G"))
        return "10"; 
      if (str.equals("3G"))
        return "11"; 
      if (str.equals("4G"))
        return "12"; 
      if (str.equals("WIFI"))
        return "13"; 
      if (str.equals("BOTH"))
        return "14"; 
    } 
    return "15";
  }
  
  private static int h(Context paramContext) {
    byte b = 0;
    byte b1 = 0;
    byte b2 = 0;
    int k = 0;
    int i = b;
    int j = b1;
    try {
      NetworkInfo networkInfo = a(paramContext);
      if (networkInfo != null) {
        i = b;
        j = b1;
        if (networkInfo.isAvailable()) {
          i = b;
          j = b1;
          if (networkInfo.isConnected()) {
            i = b;
            j = b1;
            int m = networkInfo.getType();
            if (m == 1) {
              i = -101;
            } else {
              i = b2;
              if (m == 0) {
                j = b1;
                try {
                  i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
                  j = i;
                } catch (Exception exception) {
                  i = b;
                  j = b1;
                  exception.printStackTrace();
                  j = k;
                } 
                i = j;
                if (j == 0) {
                  i = j;
                  k = networkInfo.getSubtype();
                  i = k;
                } 
              } 
            } 
            return a(i);
          } 
        } 
      } 
      i = -1;
    } catch (NullPointerException nullPointerException) {
      nullPointerException.printStackTrace();
      i = j;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return a(i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */