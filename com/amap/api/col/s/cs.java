package com.amap.api.col.s;

import java.net.URLConnection;
import java.util.Map;

public class cs {
  public static int a = 0;
  
  public static String b = "";
  
  private static cs c;
  
  public static cs a() {
    if (c == null)
      c = new cs(); 
    return c;
  }
  
  public static cz a(cy paramcy, boolean paramBoolean) throws bh {
    int i = cv.a(paramcy);
    try {
      cz cz = a(paramcy, paramBoolean, i);
    } catch (bh bh) {
      if (cv.a(i)) {
        bh = null;
      } else {
        throw bh;
      } 
    } 
    if ((bh == null || ((cz)bh).a == null || ((cz)bh).a.length <= 0) && cv.a(i))
      try {
        return a(paramcy, paramBoolean, 3);
      } catch (bh bh1) {
        throw bh1;
      }  
    return (cz)bh;
  }
  
  private static cz a(cy paramcy, boolean paramBoolean, int paramInt) throws bh {
    byte[] arrayOfByte2;
    cv cv;
    String str1;
    String str2;
    String str3;
    Map<String, String> map;
    try {
      c(paramcy);
      cv = new cv(paramcy, paramBoolean);
      str1 = paramcy.m();
      str2 = paramcy.n();
      paramBoolean = paramcy.o();
      str3 = paramcy.j();
      map = paramcy.f();
    } catch (bh bh) {
      throw bh;
    } finally {
      paramcy = null;
      paramcy.printStackTrace();
    } 
    byte[] arrayOfByte1 = arrayOfByte2;
    return cv.a(str1, str2, paramBoolean, str3, map, arrayOfByte1, paramInt);
  }
  
  public static byte[] a(cy paramcy) throws bh {
    try {
      return (cz != null) ? cz.a : null;
    } catch (bh bh) {
      throw bh;
    } finally {
      paramcy = null;
    } 
  }
  
  protected static void c(cy paramcy) throws bh {
    if (paramcy != null) {
      if (paramcy.g() != null && !"".equals(paramcy.g()))
        return; 
      throw new bh("request url is empty");
    } 
    throw new bh("requeust is null");
  }
  
  public byte[] b(cy paramcy) throws bh {
    try {
      return (cz != null) ? cz.a : null;
    } catch (bh bh) {
      throw bh;
    } finally {
      paramcy = null;
      cd.a((Throwable)paramcy, "bm", "msp");
    } 
  }
  
  public static interface a {
    URLConnection a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */