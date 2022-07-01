package com.android.webview.chromium;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import org.chromium.content_public.browser.NavigationEntry;

public final class WebHistoryItemChromium extends WebHistoryItem {
  private final Bitmap mFavicon;
  
  private final String mOriginalUrl;
  
  private final String mTitle;
  
  private final String mUrl;
  
  private WebHistoryItemChromium(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap) {
    this.mUrl = paramString1;
    this.mOriginalUrl = paramString2;
    this.mTitle = paramString3;
    this.mFavicon = paramBitmap;
  }
  
  WebHistoryItemChromium(NavigationEntry paramNavigationEntry) {
    this.mUrl = paramNavigationEntry.mUrl;
    this.mOriginalUrl = paramNavigationEntry.mOriginalUrl;
    this.mTitle = paramNavigationEntry.mTitle;
    this.mFavicon = paramNavigationEntry.mFavicon;
  }
  
  public final WebHistoryItemChromium clone() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/android/webview/chromium/WebHistoryItemChromium
    //   5: dup
    //   6: aload_0
    //   7: getfield mUrl : Ljava/lang/String;
    //   10: aload_0
    //   11: getfield mOriginalUrl : Ljava/lang/String;
    //   14: aload_0
    //   15: getfield mTitle : Ljava/lang/String;
    //   18: aload_0
    //   19: getfield mFavicon : Landroid/graphics/Bitmap;
    //   22: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	30	finally
  }
  
  public final Bitmap getFavicon() {
    return this.mFavicon;
  }
  
  public final int getId() {
    return -1;
  }
  
  public final String getOriginalUrl() {
    return this.mOriginalUrl;
  }
  
  public final String getTitle() {
    return this.mTitle;
  }
  
  public final String getUrl() {
    return this.mUrl;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebHistoryItemChromium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */