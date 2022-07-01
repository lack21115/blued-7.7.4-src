package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.loc.ej;

public class UmidtokenInfo {
  static Handler a = new Handler();
  
  static String b = null;
  
  static boolean c;
  
  private static AMapLocationClient d;
  
  private static long e = 30000L;
  
  static {
    c = true;
  }
  
  public static String getUmidtoken() {
    return b;
  }
  
  public static void setLocAble(boolean paramBoolean) {
    c = paramBoolean;
  }
  
  public static void setUmidtoken(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/amap/api/location/UmidtokenInfo
    //   2: monitorenter
    //   3: aload_1
    //   4: putstatic com/amap/api/location/UmidtokenInfo.b : Ljava/lang/String;
    //   7: aload_1
    //   8: invokestatic a : (Ljava/lang/String;)V
    //   11: getstatic com/amap/api/location/UmidtokenInfo.d : Lcom/amap/api/location/AMapLocationClient;
    //   14: ifnonnull -> 99
    //   17: getstatic com/amap/api/location/UmidtokenInfo.c : Z
    //   20: ifeq -> 99
    //   23: new com/amap/api/location/UmidtokenInfo$a
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: astore_1
    //   31: new com/amap/api/location/AMapLocationClient
    //   34: dup
    //   35: aload_0
    //   36: invokespecial <init> : (Landroid/content/Context;)V
    //   39: putstatic com/amap/api/location/UmidtokenInfo.d : Lcom/amap/api/location/AMapLocationClient;
    //   42: new com/amap/api/location/AMapLocationClientOption
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_0
    //   50: aload_0
    //   51: iconst_1
    //   52: invokevirtual setOnceLocation : (Z)Lcom/amap/api/location/AMapLocationClientOption;
    //   55: pop
    //   56: aload_0
    //   57: iconst_0
    //   58: invokevirtual setNeedAddress : (Z)Lcom/amap/api/location/AMapLocationClientOption;
    //   61: pop
    //   62: getstatic com/amap/api/location/UmidtokenInfo.d : Lcom/amap/api/location/AMapLocationClient;
    //   65: aload_0
    //   66: invokevirtual setLocationOption : (Lcom/amap/api/location/AMapLocationClientOption;)V
    //   69: getstatic com/amap/api/location/UmidtokenInfo.d : Lcom/amap/api/location/AMapLocationClient;
    //   72: aload_1
    //   73: invokevirtual setLocationListener : (Lcom/amap/api/location/AMapLocationListener;)V
    //   76: getstatic com/amap/api/location/UmidtokenInfo.d : Lcom/amap/api/location/AMapLocationClient;
    //   79: invokevirtual startLocation : ()V
    //   82: getstatic com/amap/api/location/UmidtokenInfo.a : Landroid/os/Handler;
    //   85: new com/amap/api/location/UmidtokenInfo$1
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: ldc2_w 30000
    //   95: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   98: pop
    //   99: ldc com/amap/api/location/UmidtokenInfo
    //   101: monitorexit
    //   102: return
    //   103: astore_0
    //   104: aload_0
    //   105: ldc 'UmidListener'
    //   107: ldc 'setUmidtoken'
    //   109: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   112: ldc com/amap/api/location/UmidtokenInfo
    //   114: monitorexit
    //   115: return
    //   116: astore_0
    //   117: ldc com/amap/api/location/UmidtokenInfo
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    // Exception table:
    //   from	to	target	type
    //   3	99	103	finally
    //   104	112	116	finally
  }
  
  static final class a implements AMapLocationListener {
    public final void onLocationChanged(AMapLocation param1AMapLocation) {
      try {
        return;
      } finally {
        param1AMapLocation = null;
        ej.a((Throwable)param1AMapLocation, "UmidListener", "onLocationChanged");
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\location\UmidtokenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */