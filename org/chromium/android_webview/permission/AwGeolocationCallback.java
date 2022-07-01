package org.chromium.android_webview.permission;

import org.chromium.android_webview.AwContents;
import org.chromium.android_webview.AwGeolocationPermissions;
import org.chromium.android_webview.CleanupReference;
import org.chromium.base.Log;

public class AwGeolocationCallback implements AwGeolocationPermissions.Callback {
  private CleanupReference mCleanupReference;
  
  private AwGeolocationCallback$CleanupRunable mCleanupRunable;
  
  public AwGeolocationCallback(String paramString, AwContents paramAwContents) {
    this.mCleanupRunable = new AwGeolocationCallback$CleanupRunable(paramAwContents, paramString);
    this.mCleanupReference = new CleanupReference(this, this.mCleanupRunable);
  }
  
  public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mCleanupRunable == null || this.mCleanupReference == null) {
      Log.w("cr.Geolocation", "Response for this geolocation request has been received. Ignoring subsequent responses", new Object[0]);
      return;
    } 
    AwGeolocationCallback$CleanupRunable awGeolocationCallback$CleanupRunable = this.mCleanupRunable;
    awGeolocationCallback$CleanupRunable.mOrigin = paramString;
    awGeolocationCallback$CleanupRunable.mAllow = paramBoolean1;
    awGeolocationCallback$CleanupRunable.mRetain = paramBoolean2;
    this.mCleanupReference.handleOnUiThread(2);
    this.mCleanupReference = null;
    this.mCleanupRunable = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\permission\AwGeolocationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */