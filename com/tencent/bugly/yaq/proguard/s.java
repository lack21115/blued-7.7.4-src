package com.tencent.bugly.yaq.proguard;

import android.content.Context;
import android.os.Process;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class s {
  private static s b;
  
  public Map<String, String> a;
  
  private Context c;
  
  private s(Context paramContext) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static s a(Context paramContext) {
    if (b == null)
      b = new s(paramContext); 
    return b;
  }
  
  private static HttpURLConnection a(String paramString1, String paramString2) {
    try {
      new URL(paramString2);
      if (paramString1 != null) {
        Locale locale = Locale.US;
        throw new VerifyError("bad dex opcode");
      } 
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  private HttpURLConnection a(String paramString1, byte[] paramArrayOfbyte, String paramString2, Map<String, String> paramMap) {
    if (paramString1 == null) {
      x.e("destUrl is null.", new Object[0]);
      return null;
    } 
    if (a(paramString2, paramString1) == null) {
      x.e("Failed to get HttpURLConnection object.", new Object[0]);
      return null;
    } 
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      x.e("Failed to upload, please check your network.", new Object[0]);
      return null;
    } 
  }
  
  private static Map<String, String> a(HttpURLConnection paramHttpURLConnection) {
    new HashMap<Object, Object>();
    throw new VerifyError("bad dex opcode");
  }
  
  private static byte[] b(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {
      
      } finally {
        paramHttpURLConnection = null;
        if (false)
          try {
            throw new VerifyError("bad dex opcode");
          } catch (Throwable throwable) {
            throw new VerifyError("bad dex opcode");
          }  
      }  
    return null;
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfbyte, v paramv, Map<String, String> paramMap) {
    long l;
    if (paramString == null) {
      x.e("Failed for no URL.", new Object[0]);
      return null;
    } 
    if (paramArrayOfbyte == null) {
      l = 0L;
    } else {
      l = paramArrayOfbyte.length;
    } 
    x.c("request: %s, send: %d (pid=%d | tid=%d)", new Object[] { paramString, Long.valueOf(l), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (false && false) {
      if (!false && 0 + 1 > 1) {
        new StringBuilder("try time: ");
        throw new VerifyError("bad dex opcode");
      } 
      throw new VerifyError("bad dex opcode");
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */