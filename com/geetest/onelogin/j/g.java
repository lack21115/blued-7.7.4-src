package com.geetest.onelogin.j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import org.json.JSONObject;

public class g {
  public static String a(InputStream paramInputStream) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    try {
      while (true) {
        int i = paramInputStream.read(arrayOfByte);
        if (i != -1) {
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        paramInputStream.close();
        return new String(byteArrayOutputStream.toByteArray());
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return new String(byteArrayOutputStream.toByteArray());
  }
  
  public static String a(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("requestGet: ");
    stringBuilder.append(paramString);
    stringBuilder.append(", timeOut: ");
    stringBuilder.append(paramInt);
    c.a(stringBuilder.toString());
    URL uRL = a(paramString);
    try {
      SSLContext sSLContext2;
      boolean bool = "https".equals(uRL.getProtocol().toLowerCase());
      StringBuilder stringBuilder2 = null;
      stringBuilder = null;
      SSLContext sSLContext3 = null;
      StringBuilder stringBuilder1 = null;
      if (bool) {
        stringBuilder = stringBuilder1;
        try {
          sSLContext3 = SSLContext.getInstance("TLS");
          stringBuilder = stringBuilder1;
          sSLContext3.init(null, new TrustManager[] { new q() }, null);
          stringBuilder = stringBuilder1;
          HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext3.getSocketFactory());
          stringBuilder = stringBuilder1;
          HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String param1String, SSLSession param1SSLSession) {
                  return true;
                }
              });
          stringBuilder = stringBuilder1;
          HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
          try {
            httpsURLConnection.setConnectTimeout(paramInt);
            httpsURLConnection.setReadTimeout(paramInt);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(false);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.connect();
            String str = a(httpsURLConnection.getInputStream());
            return str;
          } catch (Exception null) {
          
          } finally {
            HttpsURLConnection httpsURLConnection1;
            paramString = null;
          } 
        } catch (Exception null) {
          stringBuilder1 = stringBuilder2;
        } finally {}
        stringBuilder = stringBuilder1;
        stringBuilder2 = new StringBuilder();
        stringBuilder = stringBuilder1;
        stringBuilder2.append("url: ");
        stringBuilder = stringBuilder1;
        stringBuilder2.append(paramString);
        stringBuilder = stringBuilder1;
        stringBuilder2.append(", error: ");
        stringBuilder = stringBuilder1;
        stringBuilder2.append(exception.toString());
        stringBuilder = stringBuilder1;
        paramString = stringBuilder2.toString();
        if (stringBuilder1 != null)
          try {
            stringBuilder1.disconnect();
            return paramString;
          } catch (Exception exception1) {
            return paramString;
          }  
        return paramString;
      } 
      try {
        HttpURLConnection httpURLConnection = (HttpURLConnection)exception.openConnection();
        try {
          httpURLConnection.setConnectTimeout(paramInt);
          httpURLConnection.setReadTimeout(paramInt);
          httpURLConnection.setDoInput(true);
          httpURLConnection.setDoOutput(false);
          httpURLConnection.setRequestMethod("GET");
          httpURLConnection.setUseCaches(false);
          httpURLConnection.connect();
          String str = a(httpURLConnection.getInputStream());
          return str;
        } catch (Exception exception1) {
        
        } finally {
          HttpURLConnection httpURLConnection1;
          paramString = null;
        } 
      } catch (Exception exception) {
        sSLContext2 = sSLContext3;
      } finally {}
      SSLContext sSLContext1 = sSLContext2;
      stringBuilder2 = new StringBuilder();
      sSLContext1 = sSLContext2;
      stringBuilder2.append("url: ");
      sSLContext1 = sSLContext2;
      stringBuilder2.append(paramString);
      sSLContext1 = sSLContext2;
      stringBuilder2.append(", error: ");
      sSLContext1 = sSLContext2;
      stringBuilder2.append(exception.toString());
      sSLContext1 = sSLContext2;
      paramString = stringBuilder2.toString();
      if (sSLContext2 != null)
        try {
          sSLContext2.disconnect();
          return paramString;
        } catch (Exception exception1) {
          return paramString;
        }  
      return paramString;
    } catch (Exception exception) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("请求错误, error: ");
      stringBuilder.append(exception.toString());
      return stringBuilder.toString();
    } 
  }
  
  public static String a(String paramString1, String paramString2) {
    if (paramString1.endsWith("/") && paramString2.startsWith("/")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append(paramString2.substring(1));
      return stringBuilder1.toString();
    } 
    if (!paramString1.endsWith("/") && !paramString2.startsWith("/")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append("/");
      stringBuilder1.append(paramString2);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("requestPost: ");
    stringBuilder.append(paramString1);
    stringBuilder.append(", params: ");
    stringBuilder.append(paramString2);
    stringBuilder.append(", timeOut: ");
    stringBuilder.append(paramInt);
    c.a(stringBuilder.toString());
    URL uRL = a(paramString1);
    try {
      SSLContext sSLContext1;
      boolean bool = "https".equals(uRL.getProtocol().toLowerCase());
      String str = null;
      stringBuilder = null;
      SSLContext sSLContext3 = null;
      StringBuilder stringBuilder1 = null;
      if (bool) {
        stringBuilder = stringBuilder1;
        try {
          sSLContext3 = SSLContext.getInstance("TLS");
          stringBuilder = stringBuilder1;
          sSLContext3.init(null, new TrustManager[] { new q() }, null);
          stringBuilder = stringBuilder1;
          HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext3.getSocketFactory());
          stringBuilder = stringBuilder1;
          HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String param1String, SSLSession param1SSLSession) {
                  return true;
                }
              });
          stringBuilder = stringBuilder1;
          HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
          try {
            httpsURLConnection.setConnectTimeout(paramInt);
            httpsURLConnection.setReadTimeout(paramInt);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.connect();
            if (paramString2 != null) {
              OutputStream outputStream = httpsURLConnection.getOutputStream();
              outputStream.write(paramString2.getBytes("utf-8"));
              outputStream.flush();
              outputStream.close();
            } 
            paramInt = httpsURLConnection.getResponseCode();
            if (paramInt == 200) {
              paramString2 = a(httpsURLConnection.getInputStream());
              return paramString2;
            } 
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("url: ");
            stringBuilder4.append((String)exception);
            stringBuilder4.append(", responseCode: ");
            stringBuilder4.append(paramInt);
            String str2 = stringBuilder4.toString();
            return str2;
          } catch (Exception exception) {
            HttpsURLConnection httpsURLConnection1 = httpsURLConnection;
          } finally {
            Exception exception;
            paramString1 = null;
          } 
        } catch (Exception null) {
          paramString2 = str;
        } finally {}
        String str1 = paramString2;
        StringBuilder stringBuilder3 = new StringBuilder();
        str1 = paramString2;
        stringBuilder3.append("url: ");
        str1 = paramString2;
        stringBuilder3.append(paramString1);
        str1 = paramString2;
        stringBuilder3.append(", error: ");
        str1 = paramString2;
        stringBuilder3.append(exception2.toString());
        str1 = paramString2;
        paramString1 = stringBuilder3.toString();
        if (paramString2 != null)
          try {
            paramString2.disconnect();
            return paramString1;
          } catch (Exception exception1) {
            return paramString1;
          }  
        return paramString1;
      } 
      try {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        try {
          httpURLConnection.setConnectTimeout(paramInt);
          httpURLConnection.setReadTimeout(paramInt);
          httpURLConnection.setDoInput(true);
          httpURLConnection.setDoOutput(true);
          httpURLConnection.setRequestMethod("POST");
          httpURLConnection.setUseCaches(false);
          httpURLConnection.setRequestProperty("Content-Type", "application/json");
          httpURLConnection.connect();
          if (exception1 != null) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(exception1.getBytes());
            outputStream.flush();
            outputStream.close();
          } 
          paramInt = httpURLConnection.getResponseCode();
          if (paramInt == 200) {
            String str2 = a(httpURLConnection.getInputStream());
            return str2;
          } 
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("url: ");
          stringBuilder3.append((String)exception);
          stringBuilder3.append(", responseCode: ");
          stringBuilder3.append(paramInt);
          String str1 = stringBuilder3.toString();
          return str1;
        } catch (Exception exception) {
          HttpURLConnection httpURLConnection1 = httpURLConnection;
        } finally {
          Exception exception;
          paramString1 = null;
        } 
      } catch (Exception exception2) {
        sSLContext1 = sSLContext3;
      } finally {}
      SSLContext sSLContext2 = sSLContext1;
      StringBuilder stringBuilder2 = new StringBuilder();
      sSLContext2 = sSLContext1;
      stringBuilder2.append("url: ");
      sSLContext2 = sSLContext1;
      stringBuilder2.append(paramString1);
      sSLContext2 = sSLContext1;
      stringBuilder2.append(", error: ");
      sSLContext2 = sSLContext1;
      stringBuilder2.append(exception2.toString());
      sSLContext2 = sSLContext1;
      paramString1 = stringBuilder2.toString();
      if (sSLContext1 != null)
        try {
          sSLContext1.disconnect();
          return paramString1;
        } catch (Exception exception) {
          return paramString1;
        }  
      return paramString1;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("请求错误, error: ");
      stringBuilder1.append(exception.toString());
      return stringBuilder1.toString();
    } 
  }
  
  public static String a(String paramString, JSONObject paramJSONObject, int paramInt) {
    String str;
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      str = paramJSONObject.toString();
    } 
    return a(paramString, str, paramInt);
  }
  
  public static URL a(String paramString) {
    try {
      return new URL(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("获取请求: ");
      stringBuilder.append(paramString);
      stringBuilder.append(" 失败: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */