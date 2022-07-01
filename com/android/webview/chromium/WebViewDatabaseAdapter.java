package com.android.webview.chromium;

import android.os.Build;
import android.webkit.WebViewDatabase;
import org.chromium.android_webview.AwFormDatabase;
import org.chromium.android_webview.HttpAuthDatabase;
import org.chromium.base.ThreadUtils;

final class WebViewDatabaseAdapter extends WebViewDatabase {
  private final WebViewChromiumFactoryProvider mFactory;
  
  private final HttpAuthDatabase mHttpAuthDatabase;
  
  public WebViewDatabaseAdapter(WebViewChromiumFactoryProvider paramWebViewChromiumFactoryProvider, HttpAuthDatabase paramHttpAuthDatabase) {
    this.mFactory = paramWebViewChromiumFactoryProvider;
    this.mHttpAuthDatabase = paramHttpAuthDatabase;
  }
  
  private static boolean checkNeedsPost() {
    return !ThreadUtils.runningOnUiThread();
  }
  
  public final void clearFormData() {
    if (Build.VERSION.SDK_INT >= 26)
      return; 
    if (checkNeedsPost()) {
      this.mFactory.addTask(new WebViewDatabaseAdapter$6());
      return;
    } 
    AwFormDatabase.clearFormData();
  }
  
  public final void clearHttpAuthUsernamePassword() {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new WebViewDatabaseAdapter$2(this));
      return;
    } 
    this.mHttpAuthDatabase.clearHttpAuthUsernamePassword();
  }
  
  public final void clearUsernamePassword() {}
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2) {
    return checkNeedsPost() ? (String[])this.mFactory.runOnUiThreadBlocking(new WebViewDatabaseAdapter$4(this, paramString1, paramString2)) : this.mHttpAuthDatabase.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  public final boolean hasFormData() {
    return (Build.VERSION.SDK_INT >= 26) ? false : (checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewDatabaseAdapter$5())).booleanValue() : AwFormDatabase.hasFormData());
  }
  
  public final boolean hasHttpAuthUsernamePassword() {
    return checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewDatabaseAdapter$1(this))).booleanValue() : this.mHttpAuthDatabase.hasHttpAuthUsernamePassword();
  }
  
  public final boolean hasUsernamePassword() {
    return false;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4) {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new WebViewDatabaseAdapter$3(this, paramString1, paramString2, paramString3, paramString4));
      return;
    } 
    this.mHttpAuthDatabase.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewDatabaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */