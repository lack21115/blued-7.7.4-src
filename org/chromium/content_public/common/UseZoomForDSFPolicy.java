package org.chromium.content_public.common;

public final class UseZoomForDSFPolicy {
  public static boolean isUseZoomForDSFEnabled() {
    return nativeIsUseZoomForDSFEnabled();
  }
  
  private static native boolean nativeIsUseZoomForDSFEnabled();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\common\UseZoomForDSFPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */