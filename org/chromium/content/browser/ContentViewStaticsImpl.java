package org.chromium.content.browser;

public class ContentViewStaticsImpl {
  private static native void nativeSetWebKitSharedTimersSuspended(boolean paramBoolean);
  
  public static void setWebKitSharedTimersSuspended(boolean paramBoolean) {
    nativeSetWebKitSharedTimersSuspended(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ContentViewStaticsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */