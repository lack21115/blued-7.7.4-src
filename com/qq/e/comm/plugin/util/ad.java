package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ad {
  public static String a() {
    Context context = GDTADManager.getInstance().getAppContext();
    StringBuilder stringBuilder = null;
    try {
      String str;
      NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
      StringBuilder stringBuilder1 = stringBuilder;
      if (networkInfo != null) {
        stringBuilder1 = stringBuilder;
        if (networkInfo.getType() == 0) {
          int j = ((TelephonyManager)context.getSystemService("phone")).getNetworkType();
          int i = j;
          if (j == 0)
            i = networkInfo.getSubtype(); 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("");
          stringBuilder1.append(i);
          str = stringBuilder1.toString();
        } 
      } 
      return str;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static HttpURLConnection a(HttpURLConnection paramHttpURLConnection) throws IOException {
    if (paramHttpURLConnection == null)
      return null; 
    int j = GDTADManager.getInstance().getSM().getInteger("httpRedirectMax", 3);
    int k = paramHttpURLConnection.getConnectTimeout();
    int m = paramHttpURLConnection.getReadTimeout();
    Map<String, List<String>> map = paramHttpURLConnection.getRequestProperties();
    int i = 0;
    HttpURLConnection httpURLConnection = paramHttpURLConnection;
    while (i < j) {
      httpURLConnection.connect();
      try {
        int n = httpURLConnection.getResponseCode();
        if (a(n)) {
          String str = httpURLConnection.getHeaderField("location");
          httpURLConnection.disconnect();
          httpURLConnection = (HttpURLConnection)(new URL(str)).openConnection();
          httpURLConnection.setConnectTimeout(k);
          httpURLConnection.setReadTimeout(m);
          if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
              String str1 = (String)entry.getKey();
              List list = (List)entry.getValue();
              if (list != null && !list.isEmpty()) {
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext())
                  httpURLConnection.addRequestProperty(str1, iterator.next()); 
              } 
            }  
          i++;
        } 
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new IOException(indexOutOfBoundsException.getMessage());
      } 
    } 
    if (i != j) {
      if (i > 0) {
        d d = new d();
        d.a("http_from", indexOutOfBoundsException.getURL().toString());
        d.a("http_to", httpURLConnection.getURL().toString());
        u.a(100342, i, null, d);
      } 
      return httpURLConnection;
    } 
    u.a(100322, j, null);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HttpURLConnection exceed max redirect ");
    stringBuilder.append(j);
    stringBuilder.append(" ");
    stringBuilder.append(httpURLConnection.getURL());
    throw new IOException(stringBuilder.toString());
  }
  
  public static boolean a(int paramInt) {
    return (paramInt == 302 || paramInt == 301 || paramInt == 303);
  }
  
  public static boolean a(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (connectivityManager != null)
      try {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        bool1 = bool2;
        return bool1;
      } finally {
        connectivityManager = null;
      }  
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */