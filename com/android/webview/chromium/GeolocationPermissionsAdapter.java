package com.android.webview.chromium;

import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import org.chromium.android_webview.AwGeolocationPermissions;
import org.chromium.base.ThreadUtils;

final class GeolocationPermissionsAdapter extends GeolocationPermissions {
  private final AwGeolocationPermissions mChromeGeolocationPermissions;
  
  private final WebViewChromiumFactoryProvider mFactory;
  
  public GeolocationPermissionsAdapter(WebViewChromiumFactoryProvider paramWebViewChromiumFactoryProvider, AwGeolocationPermissions paramAwGeolocationPermissions) {
    this.mFactory = paramWebViewChromiumFactoryProvider;
    this.mChromeGeolocationPermissions = paramAwGeolocationPermissions;
  }
  
  private static boolean checkNeedsPost() {
    return !ThreadUtils.runningOnUiThread();
  }
  
  public final void allow(String paramString) {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new GeolocationPermissionsAdapter$1(this, paramString));
      return;
    } 
    this.mChromeGeolocationPermissions.allow(paramString);
  }
  
  public final void clear(String paramString) {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new GeolocationPermissionsAdapter$2(this, paramString));
      return;
    } 
    this.mChromeGeolocationPermissions.clear(paramString);
  }
  
  public final void clearAll() {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new GeolocationPermissionsAdapter$3(this));
      return;
    } 
    this.mChromeGeolocationPermissions.clearAll();
  }
  
  public final void getAllowed(String paramString, ValueCallback paramValueCallback) {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new GeolocationPermissionsAdapter$4(this, paramString, paramValueCallback));
      return;
    } 
    this.mChromeGeolocationPermissions.getAllowed(paramString, CallbackConverter.fromValueCallback(paramValueCallback));
  }
  
  public final void getOrigins(ValueCallback paramValueCallback) {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new GeolocationPermissionsAdapter$5(this, paramValueCallback));
      return;
    } 
    this.mChromeGeolocationPermissions.getOrigins(CallbackConverter.fromValueCallback(paramValueCallback));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\GeolocationPermissionsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */