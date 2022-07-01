package org.chromium.android_webview;

public class AwFormDatabase {
  public static void clearFormData() {
    nativeClearFormData();
  }
  
  public static boolean hasFormData() {
    return nativeHasFormData();
  }
  
  private static native void nativeClearFormData();
  
  private static native boolean nativeHasFormData();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwFormDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */