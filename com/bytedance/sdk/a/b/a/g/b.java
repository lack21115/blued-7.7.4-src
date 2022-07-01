package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

final class b extends e {
  final Method a;
  
  final Method b;
  
  b(Method paramMethod1, Method paramMethod2) {
    this.a = paramMethod1;
    this.b = paramMethod2;
  }
  
  public static b a() {
    try {
      return new b(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { String[].class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
    } catch (NoSuchMethodException noSuchMethodException) {
      return null;
    } 
  }
  
  public String a(SSLSocket paramSSLSocket) {
    try {
      String str = (String)this.b.invoke(paramSSLSocket, new Object[0]);
      if (str != null) {
        boolean bool = str.equals("");
        if (!bool)
          return str; 
      } 
      return null;
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw c.a("unable to get selected protocols", invocationTargetException);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<w> paramList) {
    try {
      SSLParameters sSLParameters = paramSSLSocket.getSSLParameters();
      paramList = (List)a(paramList);
      this.a.invoke(sSLParameters, new Object[] { paramList.toArray(new String[paramList.size()]) });
      paramSSLSocket.setSSLParameters(sSLParameters);
      return;
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw c.a("unable to set ssl parameters", invocationTargetException);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */