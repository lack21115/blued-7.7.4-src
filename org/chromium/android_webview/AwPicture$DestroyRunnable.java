package org.chromium.android_webview;

final class AwPicture$DestroyRunnable implements Runnable {
  private long mNativeAwPicture;
  
  private AwPicture$DestroyRunnable(long paramLong) {
    this.mNativeAwPicture = paramLong;
  }
  
  public final void run() {
    AwPicture.access$000(this.mNativeAwPicture);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwPicture$DestroyRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */