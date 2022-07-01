package org.chromium.content.app;

public class ContentMain {
  private static native int nativeStart(boolean paramBoolean);
  
  public static int start(boolean paramBoolean) {
    return nativeStart(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\app\ContentMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */