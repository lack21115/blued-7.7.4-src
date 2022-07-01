package com.pgl.sys.a.b;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class c {
  private static boolean a = false;
  
  private static HostnameVerifier b = new a();
  
  public static String a(String paramString, Map paramMap, byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    while (true) {
      Map map;
      if (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (entry.getValue() == null)
          continue; 
        try {
          stringBuilder.append((String)entry.getKey());
          stringBuilder.append("=");
          stringBuilder.append(URLEncoder.encode((String)entry.getValue(), "utf-8"));
          stringBuilder.append("&");
        } finally {}
        continue;
      } 
      if (!paramMap.isEmpty())
        stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
      paramMap = null;
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append("?");
        stringBuilder1.append(stringBuilder.toString());
      } finally {
        paramString = null;
      } 
      return a((URL)map, paramArrayOfbyte, "application/octet-stream");
    } 
  }
  
  private static String a(URL paramURL, byte[] paramArrayOfbyte, String paramString) {
    b b = new b();
    try {
      URLConnection uRLConnection;
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      SecureRandom secureRandom = new SecureRandom();
      sSLContext.init(null, new TrustManager[] { b }, secureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
      if ("https".equals(paramURL.getProtocol().toLowerCase())) {
        if (a) {
          uRLConnection = paramURL.openConnection(Proxy.NO_PROXY);
        } else {
          uRLConnection = uRLConnection.openConnection();
        } 
        uRLConnection = uRLConnection;
        ((HttpsURLConnection)uRLConnection).setHostnameVerifier(b);
      } else {
        uRLConnection = uRLConnection.openConnection();
      } 
      uRLConnection.setRequestProperty("Content-Type", paramString);
      uRLConnection.setConnectTimeout(10000);
      uRLConnection.setReadTimeout(5000);
      uRLConnection.setDoOutput(true);
      uRLConnection.setRequestMethod("POST");
      OutputStream outputStream = uRLConnection.getOutputStream();
      outputStream.write(paramArrayOfbyte);
      outputStream.flush();
      int i = uRLConnection.getResponseCode();
      if (i != 200)
        return String.format("{\"code\":%d}", new Object[] { Integer.valueOf(i) }); 
      InputStream inputStream = uRLConnection.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
      StringBuilder stringBuilder = new StringBuilder();
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          stringBuilder.append(str);
          continue;
        } 
        inputStream.close();
        return stringBuilder.toString();
      } 
    } finally {
      paramURL = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */