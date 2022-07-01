package com.amap.api.mapcore2d;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class er {
  public static int a = 0;
  
  public static String b = "";
  
  private static er c;
  
  public static er a() {
    if (c == null)
      c = new er(); 
    return c;
  }
  
  public ey a(ew paramew, boolean paramBoolean) throws cp {
    try {
      return (new eu(paramew.c, paramew.d, proxy, paramBoolean)).a(paramew.l(), paramew.n(), paramew.m(), paramew.f(), paramew.p(), paramew.o());
    } catch (cp cp) {
      throw cp;
    } finally {
      paramew = null;
      paramew.printStackTrace();
    } 
  }
  
  public byte[] a(ew paramew) throws cp {
    try {
      return (ey != null) ? ey.a : null;
    } catch (cp cp) {
      throw cp;
    } finally {
      paramew = null;
    } 
  }
  
  public byte[] b(ew paramew) throws cp {
    try {
      return (ey != null) ? ey.a : null;
    } catch (cp cp) {
      throw cp;
    } finally {
      paramew = null;
      dl.a((Throwable)paramew, "bm", "msp");
    } 
  }
  
  protected void c(ew paramew) throws cp {
    if (paramew != null) {
      if (paramew.h() != null && !"".equals(paramew.h()))
        return; 
      throw new cp("request url is empty");
    } 
    throw new cp("requeust is null");
  }
  
  public static interface a {
    URLConnection a(Proxy param1Proxy, URL param1URL);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */