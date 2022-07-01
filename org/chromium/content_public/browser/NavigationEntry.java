package org.chromium.content_public.browser;

import android.graphics.Bitmap;

public class NavigationEntry {
  public Bitmap mFavicon;
  
  public final String mOriginalUrl;
  
  public final String mTitle;
  
  public final String mUrl;
  
  public NavigationEntry(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap) {
    this.mUrl = paramString1;
    this.mOriginalUrl = paramString2;
    this.mTitle = paramString3;
    this.mFavicon = paramBitmap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\NavigationEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */