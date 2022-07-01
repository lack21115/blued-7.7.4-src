package org.chromium.android_webview;

import android.os.Message;
import org.chromium.base.Log;

final class CleanupReference$1 extends Thread {
  CleanupReference$1(String paramString) {
    super(paramString);
  }
  
  public final void run() {
    while (true) {
      try {
        null = (CleanupReference)CleanupReference.access$000().remove();
        synchronized (CleanupReference.access$100()) {
          Message.obtain(CleanupReference$LazyHolder.sHandler, 2, null).sendToTarget();
          CleanupReference.access$100().wait(500L);
        } 
      } catch (Exception exception) {
        Log.e("CleanupReference", "Queue remove exception:", new Object[] { exception });
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\CleanupReference$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */