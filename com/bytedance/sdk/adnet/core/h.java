package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class h implements IHttpStack {
  private final b a;
  
  private final SSLSocketFactory b;
  
  public h() {
    this(null);
  }
  
  public h(b paramb) {
    this(paramb, null);
  }
  
  public h(b paramb, SSLSocketFactory paramSSLSocketFactory) {
    this.a = paramb;
    this.b = paramSSLSocketFactory;
  }
  
  private HttpURLConnection a(URL paramURL, Request<?> paramRequest) throws IOException {
    HttpURLConnection httpURLConnection = a(paramURL);
    a(paramRequest);
    int i = paramRequest.getTimeoutMs();
    httpURLConnection.setConnectTimeout(i);
    httpURLConnection.setReadTimeout(i);
    httpURLConnection.setUseCaches(false);
    httpURLConnection.setDoInput(true);
    if ("https".equals(paramURL.getProtocol())) {
      if (a(httpURLConnection)) {
        p.b("connection verify by inner", new Object[0]);
        return httpURLConnection;
      } 
      SSLSocketFactory sSLSocketFactory = this.b;
      if (sSLSocketFactory == null) {
        com.bytedance.sdk.adnet.d.b.a();
        return httpURLConnection;
      } 
      ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
    } 
    return httpURLConnection;
  }
  
  static List<Header> a(Map<String, List<String>> paramMap) {
    ArrayList<Header> arrayList = new ArrayList(paramMap.size());
    for (Map.Entry<String, List<String>> entry : paramMap.entrySet()) {
      if (entry.getKey() != null)
        for (String str : entry.getValue())
          arrayList.add(new Header((String)entry.getKey(), str));  
    } 
    return arrayList;
  }
  
  private void a(Request<?> paramRequest) {
    if (paramRequest != null)
      paramRequest.setIpAddrStr(b(paramRequest)); 
  }
  
  static void a(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest) throws IOException, com.bytedance.sdk.adnet.err.a {
    switch (paramRequest.getMethod()) {
      default:
        throw new IllegalStateException("Unknown method type.");
      case 7:
        paramHttpURLConnection.setRequestMethod("PATCH");
        b(paramHttpURLConnection, paramRequest);
        return;
      case 6:
        paramHttpURLConnection.setRequestMethod("TRACE");
        return;
      case 5:
        paramHttpURLConnection.setRequestMethod("OPTIONS");
        return;
      case 4:
        paramHttpURLConnection.setRequestMethod("HEAD");
        return;
      case 3:
        paramHttpURLConnection.setRequestMethod("DELETE");
        return;
      case 2:
        paramHttpURLConnection.setRequestMethod("PUT");
        b(paramHttpURLConnection, paramRequest);
        return;
      case 1:
        paramHttpURLConnection.setRequestMethod("POST");
        b(paramHttpURLConnection, paramRequest);
        return;
      case 0:
        paramHttpURLConnection.setRequestMethod("GET");
        return;
      case -1:
        break;
    } 
    byte[] arrayOfByte = paramRequest.getPostBody();
    if (arrayOfByte != null) {
      paramHttpURLConnection.setRequestMethod("POST");
      a(paramHttpURLConnection, paramRequest, arrayOfByte);
    } 
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest, byte[] paramArrayOfbyte) throws IOException {
    paramHttpURLConnection.setDoOutput(true);
    if (!paramHttpURLConnection.getRequestProperties().containsKey("Content-Type"))
      paramHttpURLConnection.setRequestProperty("Content-Type", paramRequest.getBodyContentType()); 
    DataOutputStream dataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
    dataOutputStream.write(paramArrayOfbyte);
    dataOutputStream.close();
  }
  
  private static boolean a(int paramInt1, int paramInt2) {
    return (paramInt1 != 4 && (100 > paramInt2 || paramInt2 >= 200) && paramInt2 != 204 && paramInt2 != 304);
  }
  
  private String b(Request<?> paramRequest) {
    String str = "";
    if (paramRequest != null) {
      if (paramRequest.getUrl() == null)
        return ""; 
      try {
        return InetAddress.getByName((new URL(paramRequest.getUrl())).getHost()).getHostAddress();
      } catch (Exception exception) {
        return "";
      } 
    } 
    return str;
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest) throws IOException, com.bytedance.sdk.adnet.err.a {
    byte[] arrayOfByte = paramRequest.getBody();
    if (arrayOfByte != null)
      a(paramHttpURLConnection, paramRequest, arrayOfByte); 
  }
  
  private static InputStream c(HttpURLConnection paramHttpURLConnection) {
    try {
      return paramHttpURLConnection.getInputStream();
    } catch (IOException iOException) {
      return paramHttpURLConnection.getErrorStream();
    } 
  }
  
  public HttpResponse a(Request<?> paramRequest, Map<String, String> paramMap) throws IOException, VAdError {
    String str1;
    String str2 = paramRequest.getUrl();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (!TextUtils.isEmpty(paramRequest.getUserAgent()))
      hashMap.put("User-Agent", paramRequest.getUserAgent()); 
    hashMap.putAll(paramMap);
    hashMap.putAll(paramRequest.getHeaders());
    b b1 = this.a;
    if (b1 != null) {
      str1 = b1.a(str2);
      if (str1 == null) {
        null = new StringBuilder();
        null.append("URL blocked by rewriter: ");
        null.append(str2);
        throw new IOException(null.toString());
      } 
    } else {
      str1 = str2;
    } 
    HttpURLConnection httpURLConnection = a(new URL(str1), (Request<?>)null);
    boolean bool2 = false;
    boolean bool1 = bool2;
    try {
      Iterator<String> iterator = hashMap.keySet().iterator();
      while (true) {
        bool1 = bool2;
        if (iterator.hasNext()) {
          bool1 = bool2;
          String str = iterator.next();
          bool1 = bool2;
          httpURLConnection.setRequestProperty(str, (String)hashMap.get(str));
          continue;
        } 
        bool1 = bool2;
        a(httpURLConnection, (Request<?>)null);
        bool1 = bool2;
        int i = httpURLConnection.getResponseCode();
        if (i != -1) {
          bool1 = bool2;
          if (!a(null.getMethod(), i)) {
            bool1 = bool2;
            return new HttpResponse(i, a(httpURLConnection.getHeaderFields()));
          } 
          return new HttpResponse(i, a(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new a(httpURLConnection));
        } 
        bool1 = bool2;
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      } 
    } finally {
      if (!bool1)
        httpURLConnection.disconnect(); 
    } 
  }
  
  protected HttpURLConnection a(URL paramURL) throws IOException {
    HttpURLConnection httpURLConnection;
    String str1 = null;
    if (paramURL == null)
      return null; 
    String str2 = paramURL.getHost();
    if (com.bytedance.sdk.adnet.a.a != null)
      str1 = com.bytedance.sdk.adnet.a.a.a(str2); 
    if (!TextUtils.isEmpty(str1)) {
      try {
        HttpURLConnection httpURLConnection1 = (HttpURLConnection)(new URL(paramURL.toString().replaceFirst(str2, str1))).openConnection();
        httpURLConnection1.setRequestProperty("Host", str2);
        httpURLConnection = httpURLConnection1;
        if (httpURLConnection1 == null)
          httpURLConnection = (HttpURLConnection)paramURL.openConnection(); 
      } catch (Exception exception) {
        httpURLConnection = (HttpURLConnection)paramURL.openConnection();
      } 
    } else {
      httpURLConnection = (HttpURLConnection)paramURL.openConnection();
    } 
    httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    return httpURLConnection;
  }
  
  protected boolean a(HttpURLConnection paramHttpURLConnection) {
    return false;
  }
  
  static class a extends FilterInputStream {
    private final HttpURLConnection a;
    
    a(HttpURLConnection param1HttpURLConnection) {
      super(h.b(param1HttpURLConnection));
      this.a = param1HttpURLConnection;
    }
    
    public void close() throws IOException {
      super.close();
      this.a.disconnect();
    }
  }
  
  public static interface b {
    String a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */