package org.chromium.android_webview;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.library_loader.ProcessInitException;

public final class AwCookieManager {
  public AwCookieManager() {
    try {
      LibraryLoader.getInstance().ensureInitialized(3);
      return;
    } catch (ProcessInitException processInitException) {
      throw new RuntimeException("Error initializing WebView library", processInitException);
    } 
  }
  
  public static AwCookieManager$UrlValue fixupUrlValue(String paramString1, String paramString2) {
    String str2 = paramString1;
    String str1 = paramString2;
    if (paramString1.startsWith("http:///.")) {
      str1 = paramString1.substring(8);
      StringBuilder stringBuilder = new StringBuilder("http://");
      stringBuilder.append(paramString1.substring(9));
      str2 = stringBuilder.toString();
      if (!paramString2.matches("^.*(?i);[\\t ]*Domain[\\t ]*=.*$"))
        if (paramString2.matches("^.*;\\s*$")) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString2);
          stringBuilder1.append(" Domain=");
          stringBuilder1.append(str1);
          paramString2 = stringBuilder1.toString();
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString2);
          stringBuilder1.append("; Domain=");
          stringBuilder1.append(str1);
          paramString2 = stringBuilder1.toString();
        }  
      str1 = paramString2;
    } 
    return new AwCookieManager$UrlValue(str2, str1);
  }
  
  @CalledByNative
  public static void invokeBooleanCookieCallback(AwCookieManager$CookieCallback paramAwCookieManager$CookieCallback, boolean paramBoolean) {
    paramAwCookieManager$CookieCallback.mHandler.post(new AwCookieManager$CookieCallback$$Lambda$0(paramAwCookieManager$CookieCallback, Boolean.valueOf(paramBoolean)));
  }
  
  private native String nativeGetCookie(String paramString);
  
  public final String getCookie(String paramString) {
    paramString = nativeGetCookie(paramString.toString());
    return (paramString == null || paramString.trim().isEmpty()) ? null : paramString;
  }
  
  public final native boolean nativeAllowFileSchemeCookies();
  
  public final native void nativeFlushCookieStore();
  
  public final native boolean nativeGetShouldAcceptCookies();
  
  public final native boolean nativeHasCookies();
  
  public final native void nativeRemoveAllCookies(AwCookieManager$CookieCallback paramAwCookieManager$CookieCallback);
  
  public final native void nativeRemoveAllCookiesSync();
  
  public final native void nativeRemoveExpiredCookies();
  
  public final native void nativeRemoveSessionCookies(AwCookieManager$CookieCallback paramAwCookieManager$CookieCallback);
  
  public final native void nativeRemoveSessionCookiesSync();
  
  public final native void nativeSetAcceptFileSchemeCookies(boolean paramBoolean);
  
  public final native void nativeSetCookie(String paramString1, String paramString2, AwCookieManager$CookieCallback paramAwCookieManager$CookieCallback);
  
  public final native void nativeSetCookieSync(String paramString1, String paramString2);
  
  public final native void nativeSetShouldAcceptCookies(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwCookieManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */