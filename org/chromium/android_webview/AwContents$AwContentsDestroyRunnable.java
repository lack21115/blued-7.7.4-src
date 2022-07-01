package org.chromium.android_webview;

final class AwContents$AwContentsDestroyRunnable implements Runnable {
  private final long mNativeAwContents;
  
  private AwContents$AwContentsDestroyRunnable(long paramLong) {
    this.mNativeAwContents = paramLong;
  }
  
  public final void run() {
    AwContents.access$200(this.mNativeAwContents);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$AwContentsDestroyRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */