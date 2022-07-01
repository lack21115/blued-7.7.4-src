package com.huawei.hms.update.b;

import android.content.Context;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class c {
  public static void a(HttpsURLConnection paramHttpsURLConnection, Context paramContext) {
    SocketFactory socketFactory = f.a(paramContext);
    if (socketFactory instanceof SSLSocketFactory)
      paramHttpsURLConnection.setSSLSocketFactory((SSLSocketFactory)socketFactory); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */