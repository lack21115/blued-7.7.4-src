package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.a.b.a.d;
import com.bytedance.sdk.a.b.a.i.e;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import com.bytedance.sdk.adnet.d.h;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class k implements IHttpStack {
  private final v a;
  
  public k() {
    this.a = (new v.a()).a(10000L, TimeUnit.MILLISECONDS).b(10000L, TimeUnit.MILLISECONDS).c(10000L, TimeUnit.MILLISECONDS).a();
  }
  
  public k(SSLSocketFactory paramSSLSocketFactory, X509TrustManager paramX509TrustManager, HostnameVerifier paramHostnameVerifier) {
    h h;
    e e;
    v.a a2 = (new v.a()).a(10000L, TimeUnit.MILLISECONDS).b(10000L, TimeUnit.MILLISECONDS).c(10000L, TimeUnit.MILLISECONDS);
    HostnameVerifier hostnameVerifier = paramHostnameVerifier;
    if (paramHostnameVerifier == null)
      e = e.a; 
    v.a a1 = a2.a((HostnameVerifier)e);
    SSLSocketFactory sSLSocketFactory = paramSSLSocketFactory;
    if (paramSSLSocketFactory == null)
      h = new h(); 
    X509TrustManager x509TrustManager = paramX509TrustManager;
    if (paramX509TrustManager == null)
      x509TrustManager = h.a; 
    this.a = a1.a((SSLSocketFactory)h, x509TrustManager).a();
  }
  
  private static List<Header> a(r paramr) {
    if (paramr == null)
      return new ArrayList<Header>(); 
    ArrayList<Header> arrayList = new ArrayList(paramr.a());
    int i = 0;
    int j = paramr.a();
    while (i < j) {
      String str1 = paramr.a(i);
      String str2 = paramr.b(i);
      if (str1 != null)
        arrayList.add(new Header(str1, str2)); 
      i++;
    } 
    return arrayList;
  }
  
  private static void a(y.a parama, Request<?> paramRequest) throws IOException, com.bytedance.sdk.adnet.err.a {
    switch (paramRequest.getMethod()) {
      default:
        throw new IllegalStateException("Unknown method type.");
      case 7:
        parama.d(d(paramRequest));
        return;
      case 6:
        parama.a("TRACE", null);
        return;
      case 5:
        parama.a("OPTIONS", null);
        return;
      case 4:
        parama.b();
        return;
      case 3:
        parama.c();
        return;
      case 2:
        parama.c(d(paramRequest));
        return;
      case 1:
        parama.a(d(paramRequest));
        return;
      case 0:
        parama.a();
        return;
      case -1:
        break;
    } 
    byte[] arrayOfByte = paramRequest.getPostBody();
    if (arrayOfByte != null)
      parama.a(z.a(u.a(paramRequest.getBodyContentType()), arrayOfByte)); 
  }
  
  private void a(Request<?> paramRequest) {
    if (paramRequest != null)
      paramRequest.setIpAddrStr(b(paramRequest)); 
  }
  
  private static boolean a(int paramInt1, int paramInt2) {
    return (paramInt1 != 4 && (100 > paramInt2 || paramInt2 >= 200) && paramInt2 != 204 && paramInt2 != 304);
  }
  
  private static InputStream b(ab paramab) {
    return (paramab == null) ? null : paramab.c();
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
  
  private y.a c(Request paramRequest) throws IOException {
    Request request = null;
    if (paramRequest != null) {
      String str1;
      if (paramRequest.getUrl() == null)
        return null; 
      y.a a = new y.a();
      URL uRL = new URL(paramRequest.getUrl());
      String str2 = uRL.getHost();
      paramRequest = request;
      if (com.bytedance.sdk.adnet.a.a != null)
        str1 = com.bytedance.sdk.adnet.a.a.a(str2); 
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(str1))
        try {
          a.a(new URL(uRL.toString().replaceFirst(str2, str1))).b("Host", str2);
          bool1 = true;
        } catch (Exception exception) {
          bool1 = bool2;
        }  
      if (!bool1)
        a.a(uRL); 
      return a;
    } 
    return null;
  }
  
  private static z d(Request paramRequest) throws com.bytedance.sdk.adnet.err.a {
    byte[] arrayOfByte2 = paramRequest.getBody();
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
      if (paramRequest.getMethod() == 1) {
        arrayOfByte1 = "".getBytes();
      } else {
        return null;
      }  
    return z.a(u.a(paramRequest.getBodyContentType()), arrayOfByte1);
  }
  
  public HttpResponse a(Request<?> paramRequest, Map<String, String> paramMap) throws IOException, VAdError {
    int i = paramRequest.getTimeoutMs();
    v.a a = this.a.y();
    long l = i;
    v v1 = a.a(l, TimeUnit.MILLISECONDS).b(l, TimeUnit.MILLISECONDS).c(l, TimeUnit.MILLISECONDS).b(true).a(true).a();
    y.a a1 = c(paramRequest);
    if (a1 != null) {
      a(paramRequest);
      if (!TextUtils.isEmpty(paramRequest.getUserAgent())) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramRequest.getUserAgent());
        stringBuilder.append(" ");
        stringBuilder.append(d.a());
        String str = stringBuilder.toString();
        a1.a("User-Agent").b("User-Agent", str);
      } 
      Map<String, String> map = paramRequest.getHeaders();
      if (map != null)
        for (String str : map.keySet())
          a1.b(str, map.get(str));  
      if (paramMap != null)
        for (String str : paramMap.keySet())
          a1.a(str, paramMap.get(str));  
      a(a1, paramRequest);
      aa aa = v1.a(a1.d()).a();
      com.bytedance.sdk.a.b.a.c.k k1 = com.bytedance.sdk.a.b.a.c.k.a(aa);
      ab ab = aa.g();
      i = 0;
      try {
        int j = k1.b;
        if (j != -1) {
          if (!a(paramRequest.getMethod(), j)) {
            HttpResponse httpResponse = new HttpResponse(j, a(aa.f()));
            ab.close();
            return httpResponse;
          } 
          try {
            return new HttpResponse(j, a(aa.f()), (int)ab.a(), new a(ab));
          } finally {
            paramRequest = null;
          } 
        } else {
          throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } 
      } finally {}
      if (i == 0)
        ab.close(); 
      throw paramRequest;
    } 
    throw new IllegalArgumentException("request params maybe null");
  }
  
  static class a extends FilterInputStream {
    private final ab a;
    
    a(ab param1ab) {
      super(k.a(param1ab));
      this.a = param1ab;
    }
    
    public void close() throws IOException {
      super.close();
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */