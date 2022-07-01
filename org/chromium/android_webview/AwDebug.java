package org.chromium.android_webview;

import java.io.File;
import java.io.IOException;
import org.chromium.base.annotations.UsedByReflection;

@UsedByReflection
public class AwDebug {
  @UsedByReflection
  public static boolean dumpWithoutCrashing(File paramFile) {
    try {
      String str = paramFile.getCanonicalPath();
      return nativeDumpWithoutCrashing(str);
    } catch (IOException iOException) {
      return false;
    } 
  }
  
  private static native boolean nativeDumpWithoutCrashing(String paramString);
  
  private static native void nativeInitCrashKeysForWebViewTesting();
  
  private static native void nativeSetNonWhiteListedKeyForTesting();
  
  private static native void nativeSetWhiteListedKeyForTesting();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwDebug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */