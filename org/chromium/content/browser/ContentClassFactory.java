package org.chromium.content.browser;

import org.chromium.base.ThreadUtils;

public final class ContentClassFactory {
  private static ContentClassFactory sSingleton;
  
  public static ContentClassFactory get() {
    ThreadUtils.assertOnUiThread();
    if (sSingleton == null)
      sSingleton = new ContentClassFactory(); 
    return sSingleton;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ContentClassFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */