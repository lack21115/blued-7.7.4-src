package com.huawei.updatesdk.a.a.c.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class b {
  private static String a = "NetworkUtil";
  
  private static int b = -1;
  
  private static int c = -1;
  
  private static Proxy d;
  
  private static int a(NetworkInfo paramNetworkInfo) {
    null = true;
    if (paramNetworkInfo != null && paramNetworkInfo.isConnected()) {
      int i = paramNetworkInfo.getType();
      if (1 != i) {
        if (13 == i)
          return 1; 
        if (i == 0)
          switch (paramNetworkInfo.getSubtype()) {
            case 13:
              return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
              return 3;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
              return 2;
          }  
      } else {
        return null;
      } 
    } 
    return 0;
  }
  
  private static NetworkInfo a(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    return (connectivityManager == null) ? null : connectivityManager.getActiveNetworkInfo();
  }
  
  public static Proxy a() {
    return d;
  }
  
  private static void a(int paramInt) {
    c = paramInt;
  }
  
  private static void a(Proxy paramProxy) {
    d = paramProxy;
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo, Context paramContext) {
    int i = paramNetworkInfo.getType();
    boolean bool = a.f(paramContext);
    if (i == 0 && bool) {
      Proxy proxy;
      String str = Proxy.getHost(paramContext);
      i = Proxy.getPort(paramContext);
      paramContext = null;
      Context context = paramContext;
      if (str != null) {
        context = paramContext;
        if (str.length() > 0) {
          context = paramContext;
          if (i != -1)
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i)); 
        } 
      } 
      a(proxy);
      return true;
    } 
    return false;
  }
  
  public static Proxy b(Context paramContext) {
    return e(paramContext) ? a() : null;
  }
  
  public static int c(Context paramContext) {
    if (-1 == b) {
      a.a(a, "getPsType() need init");
      if (paramContext != null)
        f(paramContext); 
    } 
    return b;
  }
  
  public static boolean d(Context paramContext) {
    if (paramContext != null) {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager != null) {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
          return true; 
      } 
    } 
    return false;
  }
  
  public static boolean e(Context paramContext) {
    if (-1 == c)
      c(paramContext); 
    return (c == -3);
  }
  
  private static void f(Context paramContext) {
    a(0);
    NetworkInfo networkInfo = a(paramContext);
    if (networkInfo == null) {
      a.a(a, "setPsType() info = null");
      return;
    } 
    b = a(networkInfo);
    if (1 != b) {
      byte b1;
      if (a(networkInfo, paramContext)) {
        b1 = -3;
      } else {
        b1 = -2;
      } 
      a(b1);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */