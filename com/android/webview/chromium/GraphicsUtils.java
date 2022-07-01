package com.android.webview.chromium;

abstract class GraphicsUtils {
  public static long getDrawGLFunctionTable() {
    return nativeGetDrawGLFunctionTable();
  }
  
  public static long getDrawSWFunctionTable() {
    return nativeGetDrawSWFunctionTable();
  }
  
  private static native long nativeGetDrawGLFunctionTable();
  
  private static native long nativeGetDrawSWFunctionTable();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\GraphicsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */