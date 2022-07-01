package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class aa {
  static ConnectivityManager a;
  
  private static aa b;
  
  private Network c;
  
  private ConnectivityManager.NetworkCallback d;
  
  private boolean e;
  
  private aa(Context paramContext) {
    a = (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  static int a(String paramString) {
    try {
      InetAddress inetAddress = InetAddress.getByName(paramString);
      byte[] arrayOfByte = inetAddress.getAddress();
      byte b1 = arrayOfByte[3];
      byte b2 = arrayOfByte[2];
      byte b3 = arrayOfByte[1];
      return arrayOfByte[0] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
    } catch (UnknownHostException unknownHostException) {
      return -1;
    } 
  }
  
  public static aa a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/utils/aa.b : Lcom/cmic/sso/sdk/utils/aa;
    //   3: ifnonnull -> 38
    //   6: ldc com/cmic/sso/sdk/utils/aa
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/utils/aa.b : Lcom/cmic/sso/sdk/utils/aa;
    //   12: ifnonnull -> 26
    //   15: new com/cmic/sso/sdk/utils/aa
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/cmic/sso/sdk/utils/aa.b : Lcom/cmic/sso/sdk/utils/aa;
    //   26: ldc com/cmic/sso/sdk/utils/aa
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/cmic/sso/sdk/utils/aa
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/cmic/sso/sdk/utils/aa.b : Lcom/cmic/sso/sdk/utils/aa;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  static String b(String paramString) {
    int i = paramString.indexOf("://");
    String str = paramString;
    if (i > 0)
      str = paramString.substring(i + 3); 
    i = str.indexOf(':');
    paramString = str;
    if (i >= 0)
      paramString = str.substring(0, i); 
    i = paramString.indexOf('/');
    str = paramString;
    if (i >= 0)
      str = paramString.substring(0, i); 
    i = str.indexOf('?');
    paramString = str;
    if (i >= 0)
      paramString = str.substring(0, i); 
    return paramString;
  }
  
  public void a() {
    try {
      if (Build.VERSION.SDK_INT >= 21) {
        if (a != null) {
          if (this.d == null)
            return; 
          a.unregisterNetworkCallback(this.d);
          this.d = null;
          this.c = null;
          return;
        } 
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  void a(a parama) {
    if (Build.VERSION.SDK_INT < 21)
      return; 
    Network network = this.c;
    if (network != null && !this.e) {
      NetworkInfo networkInfo = a.getNetworkInfo(network);
      if (networkInfo != null && networkInfo.isAvailable()) {
        parama.a(this.c);
        return;
      } 
    } 
    ConnectivityManager.NetworkCallback networkCallback = this.d;
    if (networkCallback != null) {
      try {
        a.unregisterNetworkCallback(networkCallback);
      } catch (Exception exception) {
        exception.printStackTrace();
        this.d = null;
      } 
      f.a("HttpUtils", "clear: ");
    } 
    NetworkRequest networkRequest = (new NetworkRequest.Builder()).addCapability(12).addTransportType(0).build();
    this.d = new ConnectivityManager.NetworkCallback(this, parama) {
        public void onAvailable(Network param1Network) {
          aa.a(this.b, param1Network);
          this.a.a(param1Network);
          aa.a(this.b, false);
        }
        
        public void onLost(Network param1Network) {
          aa.a(this.b, true);
        }
      };
    a.requestNetwork(networkRequest, this.d);
  }
  
  public static interface a {
    void a(Network param1Network);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */