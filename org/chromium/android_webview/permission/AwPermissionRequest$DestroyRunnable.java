package org.chromium.android_webview.permission;

final class AwPermissionRequest$DestroyRunnable implements Runnable {
  private final long mNativeAwPermissionRequest;
  
  private AwPermissionRequest$DestroyRunnable(long paramLong) {
    this.mNativeAwPermissionRequest = paramLong;
  }
  
  public final void run() {
    AwPermissionRequest.access$000(this.mNativeAwPermissionRequest);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\permission\AwPermissionRequest$DestroyRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */