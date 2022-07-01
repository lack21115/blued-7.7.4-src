package com.amap.api.col.s;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class dg {
  public static da a(WeakReference<da> paramWeakReference) {
    if (paramWeakReference != null) {
      WeakReference<da> weakReference1 = paramWeakReference;
      if (paramWeakReference.get() == null) {
        weakReference1 = new WeakReference<da>(new da());
        return weakReference1.get();
      } 
      return weakReference1.get();
    } 
    WeakReference<da> weakReference = new WeakReference<da>(new da());
    return weakReference.get();
  }
  
  public static String a(Context paramContext, br parambr) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      String str = bm.f(paramContext);
      stringBuilder.append("\"sim\":\"");
      stringBuilder.append(str);
      stringBuilder.append("\",\"sdkversion\":\"");
      stringBuilder.append(parambr.d());
      stringBuilder.append("\",\"product\":\"");
      stringBuilder.append(parambr.b());
      stringBuilder.append("\",\"ed\":\"");
      stringBuilder.append(parambr.e());
      stringBuilder.append("\",\"nt\":\"");
      stringBuilder.append(bm.d(paramContext));
      stringBuilder.append("\",\"np\":\"");
      stringBuilder.append(bm.b(paramContext));
      stringBuilder.append("\",\"mnc\":\"");
      stringBuilder.append(bm.c(paramContext));
      stringBuilder.append("\",\"ant\":\"");
      stringBuilder.append(bm.e(paramContext));
      stringBuilder.append("\"");
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a(Context paramContext, da paramda, String paramString1, int paramInt1, int paramInt2, String paramString2) {
    paramda.a = ce.c(paramContext, paramString1);
    paramda.d = paramInt1;
    paramda.b = paramInt2;
    paramda.c = paramString2;
  }
  
  static byte[] a(cp paramcp, String paramString) {
    InputStream inputStream1;
    Exception exception;
    null = new byte[0];
    InputStream inputStream2 = null;
    String str = null;
    try {
      InputStream inputStream;
    } finally {
      exception = null;
      paramcp = null;
    } 
    try {
      cg.c(exception, "sui", "rdS");
      return null;
    } finally {
      if (inputStream1 != null)
        try {
          inputStream1.close();
        } finally {
          inputStream1 = null;
        }  
      if (paramcp != null)
        try {
          paramcp.close();
        } finally {
          paramcp = null;
        }  
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */