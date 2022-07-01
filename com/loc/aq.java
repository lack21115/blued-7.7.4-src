package com.loc;

import java.net.URLConnection;
import java.util.Map;

public final class aq {
  public static int a = 0;
  
  public static String b = "";
  
  private static aq c;
  
  public static aq a() {
    if (c == null)
      c = new aq(); 
    return c;
  }
  
  public static aw a(av paramav, boolean paramBoolean) throws j {
    int i = at.a(paramav);
    try {
      aw aw = a(paramav, paramBoolean, i);
    } catch (j j) {
      if (at.a(i)) {
        j = null;
      } else {
        throw j;
      } 
    } 
    if ((j == null || ((aw)j).a == null || ((aw)j).a.length <= 0) && at.a(i))
      try {
        return a(paramav, paramBoolean, 3);
      } catch (j j1) {
        throw j1;
      }  
    return (aw)j;
  }
  
  public static aw a(av paramav, boolean paramBoolean, int paramInt) throws j {
    if (paramav != null)
      try {
        return at.a(str1, str2, paramBoolean, str3, map, arrayOfByte1, paramInt);
      } catch (j j) {
        throw j;
      } finally {
        paramav = null;
        paramav.printStackTrace();
      }  
    throw new j("requeust is null");
  }
  
  public static byte[] a(av paramav) throws j {
    try {
      return (aw != null) ? aw.a : null;
    } catch (j j) {
      throw j;
    } finally {
      paramav = null;
    } 
  }
  
  public static byte[] b(av paramav) throws j {
    try {
      return (aw != null) ? aw.a : null;
    } catch (j j) {
      throw j;
    } finally {
      paramav = null;
      y.a((Throwable)paramav, "bm", "msp");
    } 
  }
  
  public static aw c(av paramav) throws j {
    try {
      return (aw != null) ? aw : null;
    } catch (j j) {
      throw j;
    } finally {
      paramav = null;
      y.a((Throwable)paramav, "bm", "mp");
    } 
  }
  
  public static interface a {
    URLConnection a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */