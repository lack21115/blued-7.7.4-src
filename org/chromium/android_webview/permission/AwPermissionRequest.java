package org.chromium.android_webview.permission;

import android.net.Uri;
import org.chromium.android_webview.CleanupReference;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class AwPermissionRequest {
  private CleanupReference mCleanupReference;
  
  public long mNativeAwPermissionRequest;
  
  public final Uri mOrigin;
  
  public boolean mProcessed;
  
  public final long mResources;
  
  private AwPermissionRequest(long paramLong1, Uri paramUri, long paramLong2) {
    this.mNativeAwPermissionRequest = paramLong1;
    this.mOrigin = paramUri;
    this.mResources = paramLong2;
    this.mCleanupReference = new CleanupReference(this, new AwPermissionRequest$DestroyRunnable(this.mNativeAwPermissionRequest, (byte)0));
  }
  
  @CalledByNative
  private static AwPermissionRequest create(long paramLong1, String paramString, long paramLong2) {
    return (paramLong1 == 0L) ? null : new AwPermissionRequest(paramLong1, Uri.parse(paramString), paramLong2);
  }
  
  private static native void nativeDestroy(long paramLong);
  
  public final void deny() {
    validate();
    if (this.mNativeAwPermissionRequest != 0L) {
      nativeOnAccept(this.mNativeAwPermissionRequest, false);
      destroyNative();
    } 
    this.mProcessed = true;
  }
  
  @CalledByNative
  public void destroyNative() {
    this.mCleanupReference.handleOnUiThread(2);
    this.mCleanupReference = null;
    this.mNativeAwPermissionRequest = 0L;
  }
  
  public native void nativeOnAccept(long paramLong, boolean paramBoolean);
  
  public final void validate() {
    if (ThreadUtils.runningOnUiThread()) {
      if (!this.mProcessed)
        return; 
      throw new IllegalStateException("Either grant() or deny() has been already called.");
    } 
    throw new IllegalStateException("Either grant() or deny() should be called on UI thread");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\permission\AwPermissionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */