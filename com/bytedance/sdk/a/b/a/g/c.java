package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

class c extends e {
  private final Method a;
  
  private final Method b;
  
  private final Method c;
  
  private final Class<?> d;
  
  private final Class<?> e;
  
  c(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2) {
    this.a = paramMethod1;
    this.b = paramMethod2;
    this.c = paramMethod3;
    this.d = paramClass1;
    this.e = paramClass2;
  }
  
  public static e a() {
    try {
      Class<?> clazz1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("org.eclipse.jetty.alpn.ALPN");
      stringBuilder1.append("$Provider");
      Class<?> clazz2 = Class.forName(stringBuilder1.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("org.eclipse.jetty.alpn.ALPN");
      stringBuilder2.append("$ClientProvider");
      Class<?> clazz3 = Class.forName(stringBuilder2.toString());
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("org.eclipse.jetty.alpn.ALPN");
      stringBuilder3.append("$ServerProvider");
      Class<?> clazz4 = Class.forName(stringBuilder3.toString());
      return new c(clazz1.getMethod("put", new Class[] { SSLSocket.class, clazz2 }), clazz1.getMethod("get", new Class[] { SSLSocket.class }), clazz1.getMethod("remove", new Class[] { SSLSocket.class }), clazz3, clazz4);
    } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException) {
      return null;
    } 
  }
  
  public String a(SSLSocket paramSSLSocket) {
    try {
      a a = (a)Proxy.getInvocationHandler(this.b.invoke(null, new Object[] { paramSSLSocket }));
      if (!a.a && a.b == null) {
        e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable)null);
        return null;
      } 
      return a.a ? null : a.b;
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    throw com.bytedance.sdk.a.b.a.c.a("unable to get selected protocol", illegalAccessException);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<w> paramList) {
    List<String> list = a(paramList);
    try {
      ClassLoader classLoader = e.class.getClassLoader();
      Class<?> clazz1 = this.d;
      Class<?> clazz2 = this.e;
      a a = new a(list);
      Object object = Proxy.newProxyInstance(classLoader, new Class[] { clazz1, clazz2 }, a);
      this.a.invoke(null, new Object[] { paramSSLSocket, object });
      return;
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    throw com.bytedance.sdk.a.b.a.c.a("unable to set alpn", illegalAccessException);
  }
  
  public void b(SSLSocket paramSSLSocket) {
    try {
      this.c.invoke(null, new Object[] { paramSSLSocket });
      return;
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw com.bytedance.sdk.a.b.a.c.a("unable to remove alpn", invocationTargetException);
  }
  
  static class a implements InvocationHandler {
    boolean a;
    
    String b;
    
    private final List<String> c;
    
    a(List<String> param1List) {
      this.c = param1List;
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      String str = param1Method.getName();
      Class<?> clazz = param1Method.getReturnType();
      param1Object = param1ArrayOfObject;
      if (param1ArrayOfObject == null)
        param1Object = com.bytedance.sdk.a.b.a.c.b; 
      if (str.equals("supports") && boolean.class == clazz)
        return Boolean.valueOf(true); 
      if (str.equals("unsupported") && void.class == clazz) {
        this.a = true;
        return null;
      } 
      if (str.equals("protocols") && param1Object.length == 0)
        return this.c; 
      if ((str.equals("selectProtocol") || str.equals("select")) && String.class == clazz && param1Object.length == 1 && param1Object[0] instanceof List) {
        param1Object = param1Object[0];
        int j = param1Object.size();
        int i;
        for (i = 0; i < j; i++) {
          if (this.c.contains(param1Object.get(i))) {
            param1Object = param1Object.get(i);
            this.b = (String)param1Object;
            return param1Object;
          } 
        } 
        param1Object = this.c.get(0);
        this.b = (String)param1Object;
        return param1Object;
      } 
      if ((str.equals("protocolSelected") || str.equals("selected")) && param1Object.length == 1) {
        this.b = (String)param1Object[0];
        return null;
      } 
      return param1Method.invoke(this, (Object[])param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */