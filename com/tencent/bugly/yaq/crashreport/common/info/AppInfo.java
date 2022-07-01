package com.tencent.bugly.yaq.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.List;
import java.util.Map;

public class AppInfo {
  private static ActivityManager a;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AppInfo() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a(int paramInt) {
    try {
      new StringBuilder("/proc/");
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      try {
        if (!x.a(throwable))
          throw new VerifyError("bad dex opcode"); 
        String str = String.valueOf(paramInt);
        if (false)
          try {
            throw new VerifyError("bad dex opcode");
          } catch (Throwable throwable1) {
            return str;
          }  
      } finally {}
    } finally {
      if (false)
        try {
          throw new VerifyError("bad dex opcode");
        } catch (Throwable throwable) {} 
    } 
  }
  
  public static String a(Context paramContext) {
    if (paramContext == null)
      return null; 
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return "fail";
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    new StringBuilder();
    if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0)
      try {
        if (CertificateFactory.getInstance("X.509") == null)
          return null; 
        new ByteArrayInputStream(paramArrayOfbyte);
        throw new VerifyError("bad dex opcode");
      } catch (CertificateException certificateException) {
        if (!x.a(certificateException))
          throw new VerifyError("bad dex opcode"); 
      } catch (Throwable throwable) {} 
    throw new VerifyError("bad dex opcode");
  }
  
  public static List<String> a(Map<String, String> paramMap) {
    if (paramMap == null)
      return null; 
    try {
      if ((String)paramMap.get("BUGLY_DISABLE") != null)
        throw new VerifyError("bad dex opcode"); 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString) {
    if (paramContext != null && paramString != null)
      throw new VerifyError("bad dex opcode"); 
    return false;
  }
  
  public static PackageInfo b(Context paramContext) {
    try {
      a(paramContext);
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static String c(Context paramContext) {
    if (paramContext != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public static Map<String, String> d(Context paramContext) {
    if (paramContext != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public static String e(Context paramContext) {
    if (a(paramContext) == null)
      return null; 
    try {
      throw new VerifyError("bad dex opcode");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static boolean f(Context paramContext) {
    if (paramContext == null)
      return false; 
    if (a == null)
      throw new VerifyError("bad dex opcode"); 
    try {
      new ActivityManager.MemoryInfo();
      ActivityManager activityManager = a;
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return false;
    } 
  }
  
  public static String g(Context paramContext) {
    if (paramContext == null)
      return ""; 
    String str2 = h(paramContext);
    String str1 = str2;
    return z.a(str2) ? i(paramContext) : str1;
  }
  
  private static String h(Context paramContext) {
    null = z.a("DENGTA_META", paramContext);
    try {
      if (z.a(null.getString("key_channelpath", "")));
      new StringBuilder("[AppInfo] Beacon channel file path: ");
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      x.d("[AppInfo] Failed to get get beacon channel", new Object[0]);
      return "";
    } finally {
      if (false)
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IOException iOException) {
          x.a(iOException);
        }  
    } 
  }
  
  private static String i(Context paramContext) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
      x.a(throwable);
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\common\info\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */