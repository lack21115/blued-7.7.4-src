package com.loc;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class bd {
  public static ax a(WeakReference<ax> paramWeakReference) {
    if (paramWeakReference != null) {
      WeakReference<ax> weakReference1 = paramWeakReference;
      if (paramWeakReference.get() == null) {
        weakReference1 = new WeakReference<ax>(new ax());
        return weakReference1.get();
      } 
      return weakReference1.get();
    } 
    WeakReference<ax> weakReference = new WeakReference<ax>(new ax());
    return weakReference.get();
  }
  
  public static String a(Context paramContext, t paramt) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      String str = n.f(paramContext);
      stringBuilder.append("\"sim\":\"");
      stringBuilder.append(str);
      stringBuilder.append("\",\"sdkversion\":\"");
      stringBuilder.append(paramt.c());
      stringBuilder.append("\",\"product\":\"");
      stringBuilder.append(paramt.a());
      stringBuilder.append("\",\"ed\":\"");
      stringBuilder.append(paramt.d());
      stringBuilder.append("\",\"nt\":\"");
      stringBuilder.append(n.d(paramContext));
      stringBuilder.append("\",\"np\":\"");
      stringBuilder.append(n.b(paramContext));
      stringBuilder.append("\",\"mnc\":\"");
      stringBuilder.append(n.c(paramContext));
      stringBuilder.append("\",\"ant\":\"");
      stringBuilder.append(n.e(paramContext));
      stringBuilder.append("\"");
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a(Context paramContext, ax paramax, String paramString1, int paramInt1, int paramInt2, String paramString2) {
    paramax.a = z.c(paramContext, paramString1);
    paramax.d = paramInt1;
    paramax.b = paramInt2;
    paramax.c = paramString2;
  }
  
  static byte[] a(ao paramao, String paramString) {
    InputStream inputStream1;
    Exception exception;
    null = new byte[0];
    InputStream inputStream2 = null;
    String str = null;
    try {
      InputStream inputStream;
    } finally {
      exception = null;
      paramao = null;
    } 
    try {
      ab.b(exception, "sui", "rdS");
      return null;
    } finally {
      if (inputStream1 != null)
        try {
          inputStream1.close();
        } finally {
          inputStream1 = null;
        }  
      if (paramao != null)
        try {
          paramao.close();
        } finally {
          paramao = null;
        }  
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */