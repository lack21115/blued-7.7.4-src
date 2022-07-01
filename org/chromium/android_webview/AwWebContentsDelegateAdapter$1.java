package org.chromium.android_webview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class AwWebContentsDelegateAdapter$1 extends Handler {
  AwWebContentsDelegateAdapter$1(Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    if ((AwWebContentsDelegateAdapter.access$000(AwWebContentsDelegateAdapter.this)).mNavigationController == null)
      return; 
    switch (paramMessage.what) {
      default:
        stringBuilder = new StringBuilder("WebContentsDelegateAdapter: unhandled message ");
        stringBuilder.append(paramMessage.what);
        throw new IllegalStateException(stringBuilder.toString());
      case 2:
        (AwWebContentsDelegateAdapter.access$000(AwWebContentsDelegateAdapter.this)).mNavigationController.cancelPendingReload();
        return;
      case 1:
        break;
    } 
    (AwWebContentsDelegateAdapter.access$000(AwWebContentsDelegateAdapter.this)).mNavigationController.continuePendingReload();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwWebContentsDelegateAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */