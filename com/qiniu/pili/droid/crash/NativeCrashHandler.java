package com.qiniu.pili.droid.crash;

import android.content.Context;
import android.os.Build;

public class NativeCrashHandler {
  private static NativeCrashHandler a = new NativeCrashHandler();
  
  private Context b;
  
  private boolean c = false;
  
  public static NativeCrashHandler a() {
    return a;
  }
  
  private static native int nativeInit(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, int paramInt5, String[] paramArrayOfString, boolean paramBoolean7, boolean paramBoolean8, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean9);
  
  private static native void nativeNotifyJavaCrashed();
  
  private static native void nativeTestCrash(int paramInt);
  
  public void a(Context paramContext) {
    try {
      System.loadLibrary("pldroid_crash");
      this.b = paramContext;
      if (nativeInit(Build.VERSION.SDK_INT, Build.VERSION.RELEASE, k.b(), Build.MANUFACTURER, Build.BRAND, Build.MODEL, Build.FINGERPRINT, paramContext.getPackageName(), k.e(paramContext), (paramContext.getApplicationInfo()).nativeLibraryDir, f.a().d().getAbsolutePath(), true, true, 50, 50, 200, true, true, true, true, 5, b.a, true, true, 50, 50, 200, true) != 0)
        return; 
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public void b() {
    if (this.c)
      nativeNotifyJavaCrashed(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\NativeCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */