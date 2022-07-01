package com.amap.api.mapcore2d;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class fh {
  public static fa a(WeakReference<fa> paramWeakReference) {
    if (paramWeakReference != null) {
      WeakReference<fa> weakReference1 = paramWeakReference;
      if (paramWeakReference.get() == null) {
        weakReference1 = new WeakReference<fa>(new fa());
        return weakReference1.get();
      } 
      return weakReference1.get();
    } 
    WeakReference<fa> weakReference = new WeakReference<fa>(new fa());
    return weakReference.get();
  }
  
  public static String a() {
    return db.a(System.currentTimeMillis());
  }
  
  public static String a(Context paramContext, da paramda) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      String str = cu.g(paramContext);
      stringBuilder.append("\"sim\":\"");
      stringBuilder.append(str);
      stringBuilder.append("\",\"sdkversion\":\"");
      stringBuilder.append(paramda.c());
      stringBuilder.append("\",\"product\":\"");
      stringBuilder.append(paramda.a());
      stringBuilder.append("\",\"ed\":\"");
      stringBuilder.append(paramda.e());
      stringBuilder.append("\",\"nt\":\"");
      stringBuilder.append(cu.e(paramContext));
      stringBuilder.append("\",\"np\":\"");
      stringBuilder.append(cu.c(paramContext));
      stringBuilder.append("\",\"mnc\":\"");
      stringBuilder.append(cu.d(paramContext));
      stringBuilder.append("\",\"ant\":\"");
      stringBuilder.append(cu.f(paramContext));
      stringBuilder.append("\"");
    } finally {
      paramContext = null;
    } 
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(paramString2);
    stringBuffer.append(",");
    stringBuffer.append("\"timestamp\":\"");
    stringBuffer.append(paramString3);
    stringBuffer.append("\",\"et\":\"");
    stringBuffer.append(paramInt);
    stringBuffer.append("\",\"classname\":\"");
    stringBuffer.append(paramString4);
    stringBuffer.append("\",");
    stringBuffer.append("\"detail\":\"");
    stringBuffer.append(paramString5);
    stringBuffer.append("\"");
    return stringBuffer.toString();
  }
  
  public static void a(Context paramContext, fa paramfa, String paramString1, int paramInt1, int paramInt2, String paramString2) {
    paramfa.a = dm.c(paramContext, paramString1);
    paramfa.d = paramInt1;
    paramfa.b = paramInt2;
    paramfa.c = paramString2;
  }
  
  static byte[] a(em paramem, String paramString, boolean paramBoolean) {
    byte[] arrayOfByte1;
    byte[] arrayOfByte2 = new byte[0];
    InputStream inputStream1 = null;
    InputStream inputStream2 = null;
    try {
      em.b b = paramem.a(paramString);
      if (b == null)
        return arrayOfByte2; 
      arrayOfByte1 = arrayOfByte2;
    } finally {
      paramString = null;
      paramem = null;
    } 
    try {
      do.c((Throwable)paramString, "sui", "rdS");
      return arrayOfByte1;
    } finally {
      if (inputStream1 != null)
        try {
          inputStream1.close();
        } finally {
          arrayOfByte1 = null;
        }  
      if (paramem != null)
        try {
          paramem.close();
        } finally {
          paramem = null;
        }  
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */