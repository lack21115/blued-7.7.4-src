package org.chromium.net;

public final class GURLUtils {
  public static String getOrigin(String paramString) {
    return nativeGetOrigin(paramString);
  }
  
  private static native String nativeGetOrigin(String paramString);
  
  private static native String nativeGetScheme(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\GURLUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */