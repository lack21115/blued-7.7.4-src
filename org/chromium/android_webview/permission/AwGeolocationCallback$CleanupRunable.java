package org.chromium.android_webview.permission;

import java.lang.ref.WeakReference;
import org.chromium.android_webview.AwContents;

final class AwGeolocationCallback$CleanupRunable implements Runnable {
  boolean mAllow;
  
  private WeakReference mAwContents;
  
  String mOrigin;
  
  boolean mRetain;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwGeolocationCallback$CleanupRunable(AwContents paramAwContents, String paramString) {
    this.mAwContents = new WeakReference<AwContents>(paramAwContents);
    this.mOrigin = paramString;
  }
  
  public final void run() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\permission\AwGeolocationCallback$CleanupRunable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */