package com.qq.e.comm.plugin.ad;

import android.content.Context;

public class i {
  public static final String a;
  
  public static final String b;
  
  public static final String c;
  
  public static final String d;
  
  public static final String e;
  
  public static final String f;
  
  static {
    // Byte code:
    //   0: getstatic android/os/Build.BRAND : Ljava/lang/String;
    //   3: putstatic com/qq/e/comm/plugin/ad/i.a : Ljava/lang/String;
    //   6: getstatic android/os/Build.DEVICE : Ljava/lang/String;
    //   9: putstatic com/qq/e/comm/plugin/ad/i.b : Ljava/lang/String;
    //   12: getstatic android/os/Build.FINGERPRINT : Ljava/lang/String;
    //   15: putstatic com/qq/e/comm/plugin/ad/i.c : Ljava/lang/String;
    //   18: getstatic android/os/Build.HARDWARE : Ljava/lang/String;
    //   21: putstatic com/qq/e/comm/plugin/ad/i.d : Ljava/lang/String;
    //   24: getstatic android/os/Build.PRODUCT : Ljava/lang/String;
    //   27: putstatic com/qq/e/comm/plugin/ad/i.e : Ljava/lang/String;
    //   30: getstatic android/os/Build$VERSION.SDK_INT : I
    //   33: bipush #9
    //   35: if_icmple -> 45
    //   38: getstatic android/os/Build.SERIAL : Ljava/lang/String;
    //   41: astore_0
    //   42: goto -> 48
    //   45: ldc ''
    //   47: astore_0
    //   48: aload_0
    //   49: putstatic com/qq/e/comm/plugin/ad/i.f : Ljava/lang/String;
    //   52: return
    //   53: astore_0
    //   54: goto -> 45
    // Exception table:
    //   from	to	target	type
    //   30	42	53	finally
  }
  
  public static boolean a(Context paramContext) {
    return (((paramContext.getApplicationInfo()).flags & 0x2) != 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */