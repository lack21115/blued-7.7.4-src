package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.List;

public class eh {
  public static int a(String paramString1, String paramString2) {
    String[] arrayOfString;
    try {
      String[] arrayOfString1 = paramString1.split("\\.");
      arrayOfString = paramString2.split("\\.");
      int m = Math.min(arrayOfString1.length, arrayOfString.length);
      int k = 0;
      i = 0;
      while (k < m) {
        int n = arrayOfString1[k].length() - arrayOfString[k].length();
        i = n;
        if (n == 0) {
          n = arrayOfString1[k].compareTo(arrayOfString[k]);
          i = n;
          if (n == 0) {
            k++;
            i = n;
          } 
        } 
      } 
    } catch (Exception exception) {
      dl.a(exception, "Utils", "compareVersion");
      return -1;
    } 
    if (i != 0)
      return i; 
    int i = exception.length;
    int j = arrayOfString.length;
    return i - j;
  }
  
  static PublicKey a() {
    Closeable closeable;
    try {
      CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
      closeable = new ByteArrayInputStream(cv.b("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5"));
    } finally {
      null = null;
    } 
    try {
      a(null, "DyLoader", "init");
    } finally {
      try {
        a(closeable);
      } finally {
        closeable = null;
      } 
    } 
  }
  
  private static void a(Context paramContext, dt paramdt, da paramda) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        return;
      } finally {
        paramCloseable = null;
      }  
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2) {
    dl.a(paramThrowable, paramString1, paramString2);
  }
  
  static void a(List<ee> paramList) {
    for (int i = 0; i < paramList.size() - 1; i = j) {
      int j = i + 1;
      for (int k = j; k < paramList.size(); k++) {
        ee ee1 = paramList.get(i);
        ee ee2 = paramList.get(k);
        String str = ee1.e();
        if (a(ee2.e(), str) > 0) {
          paramList.set(i, ee2);
          paramList.set(k, ee1);
        } 
      } 
    } 
  }
  
  static boolean a(Context paramContext) {
    return (cu.r(paramContext) == 1);
  }
  
  static boolean a(Context paramContext, da paramda, ea paramea) {
    return paramea.e() ? true : (db.a(paramContext, paramea.f()) ^ true);
  }
  
  private static boolean a(Context paramContext, dt paramdt, ee paramee, ea paramea, da paramda) {
    String str2 = paramea.c;
    String str4 = paramea.d;
    String str3 = paramea.e;
    if ("errorstatus".equals(paramee.f())) {
      a(paramContext, paramdt, paramda);
      return true;
    } 
    String str1 = eb.a(paramContext, paramea.b);
    if (!(new File(str1)).exists())
      return false; 
    List<ee> list = paramdt.b(ee.a(eb.a(paramContext, str2, str4), str2, str4, str3), ee.class);
    if (list != null && list.size() > 0)
      return true; 
    eb.a(paramContext, str2, paramda.b());
    try {
      return true;
    } finally {
      paramContext = null;
    } 
  }
  
  static boolean a(Context paramContext, dt paramdt, String paramString, da paramda) {
    return a(paramdt, paramString, eb.a(paramContext, paramString), paramda);
  }
  
  static boolean a(Context paramContext, ea paramea, da paramda) {
    dt dt = new dt(paramContext, ed.c());
    if (a(dt, paramea))
      return true; 
    ee ee = eb.a.a(dt, paramea.b);
    return (ee != null) ? a(paramContext, dt, ee, paramea, paramda) : false;
  }
  
  static boolean a(Context paramContext, boolean paramBoolean) {
    return (paramBoolean || a(paramContext));
  }
  
  static boolean a(da paramda, ea paramea) {
    boolean bool2 = false;
    if (paramda == null)
      return false; 
    boolean bool1 = bool2;
    if (paramda.a().equals(paramea.c)) {
      bool1 = bool2;
      if (paramda.b().equals(paramea.d))
        bool1 = true; 
    } 
    return bool1;
  }
  
  private static boolean a(dt paramdt, ea paramea) {
    try {
      List<ee> list = eb.a.a(paramdt, paramea.c, "used");
    } finally {
      paramdt = null;
    } 
    return false;
  }
  
  static boolean a(dt paramdt, String paramString1, String paramString2, da paramda) {
    ee ee = eb.a.a(paramdt, paramString1);
    if (ee != null) {
      if (!paramda.b().equals(ee.d()))
        return false; 
      if (b(paramString2, ee.b()))
        return true; 
    } 
    return false;
  }
  
  static boolean a(ea paramea) {
    return (Build.VERSION.SDK_INT >= paramea.g && Build.VERSION.SDK_INT <= paramea.f);
  }
  
  static boolean b(String paramString1, String paramString2) {
    paramString1 = cx.a(paramString1);
    return !(paramString1 == null || !paramString1.equalsIgnoreCase(paramString2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */