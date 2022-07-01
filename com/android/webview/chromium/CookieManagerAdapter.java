package com.android.webview.chromium;

import android.net.ParseException;
import android.net.WebAddress;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.chromium.android_webview.AwCookieManager;
import org.chromium.base.Callback;
import org.chromium.base.Log;

public final class CookieManagerAdapter extends CookieManager {
  private AwCookieManager mChromeCookieManager;
  
  public CookieManagerAdapter(AwCookieManager paramAwCookieManager) {
    this.mChromeCookieManager = paramAwCookieManager;
  }
  
  private static String fixupUrl(String paramString) {
    return (new WebAddress(paramString)).toString();
  }
  
  public final boolean acceptCookie() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mChromeCookieManager : Lorg/chromium/android_webview/AwCookieManager;
    //   6: invokevirtual nativeGetShouldAcceptCookies : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public final boolean acceptThirdPartyCookies(WebView paramWebView) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getSettings : ()Landroid/webkit/WebSettings;
    //   6: invokevirtual getAcceptThirdPartyCookies : ()Z
    //   9: istore_2
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_2
    //   13: ireturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  protected final boolean allowFileSchemeCookiesImpl() {
    return this.mChromeCookieManager.nativeAllowFileSchemeCookies();
  }
  
  public final void flush() {
    this.mChromeCookieManager.nativeFlushCookieStore();
  }
  
  public final String getCookie(WebAddress paramWebAddress) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mChromeCookieManager : Lorg/chromium/android_webview/AwCookieManager;
    //   6: aload_1
    //   7: invokevirtual toString : ()Ljava/lang/String;
    //   10: invokevirtual getCookie : (Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
  }
  
  public final String getCookie(String paramString) {
    try {
      return this.mChromeCookieManager.getCookie(fixupUrl(paramString));
    } catch (ParseException parseException) {
      Log.e("CookieManager", "Unable to get cookies due to error parsing URL: %s", new Object[] { paramString, parseException });
      return null;
    } 
  }
  
  public final String getCookie(String paramString, boolean paramBoolean) {
    return getCookie(paramString);
  }
  
  public final boolean hasCookies() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mChromeCookieManager : Lorg/chromium/android_webview/AwCookieManager;
    //   6: invokevirtual nativeHasCookies : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public final boolean hasCookies(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mChromeCookieManager : Lorg/chromium/android_webview/AwCookieManager;
    //   6: invokevirtual nativeHasCookies : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public final void removeAllCookie() {
    this.mChromeCookieManager.nativeRemoveAllCookiesSync();
  }
  
  public final void removeAllCookies(ValueCallback paramValueCallback) {
    AwCookieManager awCookieManager = this.mChromeCookieManager;
    Callback callback = CallbackConverter.fromValueCallback(paramValueCallback);
    try {
      awCookieManager.nativeRemoveAllCookies(AwCookieManager.CookieCallback.convert(callback));
      return;
    } catch (IllegalStateException illegalStateException) {
      throw new IllegalStateException("removeAllCookies must be called on a thread with a running Looper.");
    } 
  }
  
  public final void removeExpiredCookie() {
    this.mChromeCookieManager.nativeRemoveExpiredCookies();
  }
  
  public final void removeSessionCookie() {
    this.mChromeCookieManager.nativeRemoveSessionCookiesSync();
  }
  
  public final void removeSessionCookies(ValueCallback paramValueCallback) {
    AwCookieManager awCookieManager = this.mChromeCookieManager;
    Callback callback = CallbackConverter.fromValueCallback(paramValueCallback);
    try {
      awCookieManager.nativeRemoveSessionCookies(AwCookieManager.CookieCallback.convert(callback));
      return;
    } catch (IllegalStateException illegalStateException) {
      throw new IllegalStateException("removeSessionCookies must be called on a thread with a running Looper.");
    } 
  }
  
  public final void setAcceptCookie(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mChromeCookieManager : Lorg/chromium/android_webview/AwCookieManager;
    //   6: iload_1
    //   7: invokevirtual nativeSetShouldAcceptCookies : (Z)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  protected final void setAcceptFileSchemeCookiesImpl(boolean paramBoolean) {
    this.mChromeCookieManager.nativeSetAcceptFileSchemeCookies(paramBoolean);
  }
  
  public final void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getSettings : ()Landroid/webkit/WebSettings;
    //   6: iload_2
    //   7: invokevirtual setAcceptThirdPartyCookies : (Z)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public final void setCookie(String paramString1, String paramString2) {
    if (paramString2 == null) {
      Log.e("CookieManager", "Not setting cookie with null value for URL: %s", new Object[] { paramString1 });
      return;
    } 
    try {
      AwCookieManager awCookieManager = this.mChromeCookieManager;
      AwCookieManager.UrlValue urlValue = AwCookieManager.fixupUrlValue(fixupUrl(paramString1), paramString2);
      awCookieManager.nativeSetCookieSync(urlValue.mUrl, urlValue.mValue);
      return;
    } catch (ParseException parseException) {
      Log.e("CookieManager", "Not setting cookie due to error parsing URL: %s", new Object[] { paramString1, parseException });
      return;
    } 
  }
  
  public final void setCookie(String paramString1, String paramString2, ValueCallback paramValueCallback) {
    if (paramString2 == null) {
      Log.e("CookieManager", "Not setting cookie with null value for URL: %s", new Object[] { paramString1 });
      return;
    } 
    try {
      AwCookieManager awCookieManager = this.mChromeCookieManager;
      String str = fixupUrl(paramString1);
      Callback callback = CallbackConverter.fromValueCallback(paramValueCallback);
      try {
        AwCookieManager.UrlValue urlValue = AwCookieManager.fixupUrlValue(str, paramString2);
        awCookieManager.nativeSetCookie(urlValue.mUrl, urlValue.mValue, AwCookieManager.CookieCallback.convert(callback));
        return;
      } catch (IllegalStateException illegalStateException) {
        throw new IllegalStateException("SetCookie must be called on a thread with a running Looper.");
      } 
    } catch (ParseException parseException) {
      Log.e("CookieManager", "Not setting cookie due to error parsing URL: %s", new Object[] { paramString1, parseException });
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\CookieManagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */