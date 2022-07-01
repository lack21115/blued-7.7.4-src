package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.sdk.util.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class a {
  private static final String a = "msp";
  
  private static final String b = "application/octet-stream;binary/octet-stream";
  
  private static final CookieManager c = new CookieManager();
  
  public static b a(Context paramContext, a parama) {
    if (paramContext == null)
      return null; 
    try {
      HttpURLConnection httpURLConnection;
      URL uRL1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("conn config: ");
      stringBuilder.append(parama);
      c.b("mspl", stringBuilder.toString());
      URL uRL2 = new URL(parama.a);
      Proxy proxy = a(paramContext);
      stringBuilder = new StringBuilder();
      stringBuilder.append("conn proxy: ");
      stringBuilder.append(proxy);
      c.b("mspl", stringBuilder.toString());
      if (proxy != null) {
        httpURLConnection = (HttpURLConnection)uRL2.openConnection(proxy);
      } else {
        httpURLConnection = (HttpURLConnection)uRL2.openConnection();
      } 
    } finally {
      paramContext = null;
    } 
    Object object = null;
    a a2 = null;
    a a1 = parama;
    parama = a2;
  }
  
  private static Proxy a(Context paramContext) {
    String str = c(paramContext);
    paramContext = null;
    if (str != null && !str.contains("wap"))
      return null; 
    try {
      str = System.getProperty("https.proxyHost");
      String str1 = System.getProperty("https.proxyPort");
      return proxy;
    } finally {
      paramContext = null;
    } 
  }
  
  private static byte[] a(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      byteArrayOutputStream.flush();
      return byteArrayOutputStream.toByteArray();
    } 
  }
  
  private static NetworkInfo b(Context paramContext) {
    if (paramContext == null)
      return null; 
    try {
      return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static String c(Context paramContext) {
    try {
      NetworkInfo networkInfo = b(paramContext);
      return (networkInfo != null && networkInfo.isAvailable()) ? ((networkInfo.getType() == 1) ? "wifi" : networkInfo.getExtraInfo().toLowerCase()) : "none";
    } catch (Exception exception) {
      return "none";
    } 
  }
  
  public static final class a {
    public final String a;
    
    public final byte[] b;
    
    public final Map<String, String> c;
    
    public a(String param1String, Map<String, String> param1Map, byte[] param1ArrayOfbyte) {
      this.a = param1String;
      this.b = param1ArrayOfbyte;
      this.c = param1Map;
    }
    
    public String toString() {
      return String.format("<UrlConnectionConfigure url=%s headers=%s>", new Object[] { this.a, this.c });
    }
  }
  
  public static final class b {
    public final Map<String, List<String>> a;
    
    public final String b;
    
    public final byte[] c;
    
    public b(Map<String, List<String>> param1Map, String param1String, byte[] param1ArrayOfbyte) {
      this.a = param1Map;
      this.b = param1String;
      this.c = param1ArrayOfbyte;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\net\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */