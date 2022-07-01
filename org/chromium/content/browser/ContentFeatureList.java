package org.chromium.content.browser;

public abstract class ContentFeatureList {
  public static boolean isEnabled(String paramString) {
    return nativeIsEnabled(paramString);
  }
  
  private static native boolean nativeIsEnabled(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ContentFeatureList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */