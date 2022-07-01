package com.huawei.hms.framework.network.grs.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.d.b.c;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class a {
  public static HttpsURLConnection a(String paramString1, Context paramContext, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return null; 
    URLConnection uRLConnection = (new URL(paramString1)).openConnection();
    if (uRLConnection instanceof HttpsURLConnection) {
      uRLConnection = uRLConnection;
      try {
        uRLConnection.setSSLSocketFactory(com.huawei.hms.framework.network.grs.d.b.a.a(paramContext));
        uRLConnection.setHostnameVerifier((HostnameVerifier)c.b);
      } catch (IllegalArgumentException illegalArgumentException) {
        Logger.w("URLConnectionHelper", "init https ssl socket failed.");
      } 
      uRLConnection.setConnectTimeout(10000);
      uRLConnection.setReadTimeout(10000);
      String str = com.huawei.hms.framework.network.grs.d.a.b(paramContext, "NetworkKit-grs", paramString2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("request to grs server with a User-Agent header is:");
      stringBuilder.append(str);
      Logger.d("URLConnectionHelper", stringBuilder.toString());
      uRLConnection.setRequestProperty("User-Agent", str);
      return (HttpsURLConnection)uRLConnection;
    } 
    Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */