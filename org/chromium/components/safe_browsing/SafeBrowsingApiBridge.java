package org.chromium.components.safe_browsing;

import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

public final class SafeBrowsingApiBridge {
  private static Class sHandler;
  
  @CalledByNative
  private static SafeBrowsingApiHandler create() {
    try {
      SafeBrowsingApiHandler safeBrowsingApiHandler = sHandler.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      new SafeBrowsingApiBridge$1();
      return safeBrowsingApiHandler.init$66acacdb() ? safeBrowsingApiHandler : null;
    } catch (NullPointerException|InstantiationException|IllegalAccessException|NoSuchMethodException|java.lang.reflect.InvocationTargetException nullPointerException) {
      StringBuilder stringBuilder = new StringBuilder("Failed to init handler: ");
      stringBuilder.append(nullPointerException.getMessage());
      Log.e("ApiBridge", stringBuilder.toString(), new Object[0]);
      return null;
    } 
  }
  
  private static native void nativeOnUrlCheckDone(long paramLong1, int paramInt, String paramString, long paramLong2);
  
  @CalledByNative
  private static void startUriLookup(SafeBrowsingApiHandler paramSafeBrowsingApiHandler, long paramLong, String paramString, int[] paramArrayOfint) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\safe_browsing\SafeBrowsingApiBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */