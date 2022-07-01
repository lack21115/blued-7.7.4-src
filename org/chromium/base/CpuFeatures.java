package org.chromium.base;

public abstract class CpuFeatures {
  public static int getCount() {
    return nativeGetCoreCount();
  }
  
  public static long getMask() {
    return nativeGetCpuFeatures();
  }
  
  private static native int nativeGetCoreCount();
  
  private static native long nativeGetCpuFeatures();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\CpuFeatures.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */