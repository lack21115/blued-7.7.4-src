package org.chromium.base;

public abstract class PathService {
  private static native void nativeOverride(int paramInt, String paramString);
  
  public static void override(int paramInt, String paramString) {
    nativeOverride(paramInt, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\PathService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */