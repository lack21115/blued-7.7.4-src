package com.android.webview.chromium;

import android.content.ContentResolver;
import android.webkit.WebIconDatabase;
import org.chromium.android_webview.AwContents;

final class WebIconDatabaseAdapter extends WebIconDatabase {
  public final void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, WebIconDatabase.IconListener paramIconListener) {}
  
  public final void close() {}
  
  public final void open(String paramString) {
    AwContents.setShouldDownloadFavicons();
  }
  
  public final void releaseIconForPageUrl(String paramString) {}
  
  public final void removeAllIcons() {}
  
  public final void requestIconForPageUrl(String paramString, WebIconDatabase.IconListener paramIconListener) {}
  
  public final void retainIconForPageUrl(String paramString) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebIconDatabaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */