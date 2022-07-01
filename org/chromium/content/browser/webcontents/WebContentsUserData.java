package org.chromium.content.browser.webcontents;

import org.chromium.content_public.browser.WebContents;

public final class WebContentsUserData {
  final Object mObject;
  
  WebContentsUserData(Object paramObject) {
    this.mObject = paramObject;
  }
  
  public static Object fromWebContents(WebContents paramWebContents, Class paramClass, WebContents.UserDataFactory paramUserDataFactory) {
    return ((WebContentsImpl)paramWebContents).getOrSetUserData(paramClass, paramUserDataFactory);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\webcontents\WebContentsUserData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */