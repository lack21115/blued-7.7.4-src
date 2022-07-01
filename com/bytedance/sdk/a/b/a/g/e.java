package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.b.a.i.a;
import com.bytedance.sdk.a.b.a.i.b;
import com.bytedance.sdk.a.b.a.i.c;
import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

public class e {
  private static final e a = a();
  
  private static final Logger b = Logger.getLogger(v.class.getName());
  
  private static e a() {
    e e1 = a.a();
    if (e1 != null)
      return e1; 
    e1 = b.a();
    if (e1 != null)
      return e1; 
    e1 = c.a();
    return (e1 != null) ? e1 : new e();
  }
  
  public static List<String> a(List<w> paramList) {
    ArrayList<String> arrayList = new ArrayList(paramList.size());
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      w w = paramList.get(i);
      if (w != w.a)
        arrayList.add(w.toString()); 
    } 
    return arrayList;
  }
  
  public static e b() {
    return a;
  }
  
  static byte[] b(List<w> paramList) {
    c c = new c();
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      w w = paramList.get(i);
      if (w != w.a) {
        c.b(w.toString().length());
        c.a(w.toString());
      } 
    } 
    return c.q();
  }
  
  public c a(X509TrustManager paramX509TrustManager) {
    return (c)new a(b(paramX509TrustManager));
  }
  
  public Object a(String paramString) {
    return b.isLoggable(Level.FINE) ? new Throwable(paramString) : null;
  }
  
  public String a(SSLSocket paramSSLSocket) {
    return null;
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable) {
    Level level;
    if (paramInt == 5) {
      level = Level.WARNING;
    } else {
      level = Level.INFO;
    } 
    b.log(level, paramString, paramThrowable);
  }
  
  public void a(String paramString, Object paramObject) {
    String str = paramString;
    if (paramObject == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
      str = stringBuilder.toString();
    } 
    a(5, str, (Throwable)paramObject);
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt) throws IOException {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<w> paramList) {}
  
  public f b(X509TrustManager paramX509TrustManager) {
    return (f)new b(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public void b(SSLSocket paramSSLSocket) {}
  
  public boolean b(String paramString) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */