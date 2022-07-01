package com.qq.e.comm.plugin.t;

import android.util.Pair;
import org.json.JSONObject;
import yaq.gdtadv;

public class e {
  private static String a() {
    return (String)gdtadv.getobjresult(190, 1, new Object[0]);
  }
  
  public static JSONObject a(int paramInt) {
    return (JSONObject)gdtadv.getobjresult(191, 1, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) throws b {
    return (byte[])gdtadv.getobjresult(192, 1, new Object[] { paramArrayOfbyte });
  }
  
  public static native byte[] a(byte[] paramArrayOfbyte, long paramLong);
  
  private static long b() {
    return gdtadv.getJresult(193, 1, new Object[0]);
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) throws b {
    return (byte[])gdtadv.getobjresult(194, 1, new Object[] { paramArrayOfbyte });
  }
  
  public static native byte[] c(byte[] paramArrayOfbyte);
  
  static class a extends Exception {
    public a(String param1String) {
      super(param1String);
    }
    
    public a(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
  
  public static class b extends Exception {
    public b(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
  
  static class c {
    static byte a() {
      return gdtadv.getBresult(195, 1, new Object[0]);
    }
    
    static Pair<Long, byte[]> a(byte[] param1ArrayOfbyte) throws e.a {
      return (Pair<Long, byte[]>)gdtadv.getobjresult(196, 1, new Object[] { param1ArrayOfbyte });
    }
    
    static byte[] a(String param1String, long param1Long, byte[] param1ArrayOfbyte) throws e.a {
      return (byte[])gdtadv.getobjresult(197, 1, new Object[] { param1String, Long.valueOf(param1Long), param1ArrayOfbyte });
    }
    
    static byte b() {
      return gdtadv.getBresult(198, 1, new Object[0]);
    }
    
    static byte c() {
      return gdtadv.getBresult(199, 1, new Object[0]);
    }
    
    static byte d() {
      return gdtadv.getBresult(200, 1, new Object[0]);
    }
    
    static int e() {
      return gdtadv.getIresult(201, 1, new Object[0]);
    }
    
    static int f() {
      return gdtadv.getIresult(202, 1, new Object[0]);
    }
    
    static int g() {
      return gdtadv.getIresult(203, 1, new Object[0]);
    }
    
    static int h() {
      return gdtadv.getIresult(204, 1, new Object[0]);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */