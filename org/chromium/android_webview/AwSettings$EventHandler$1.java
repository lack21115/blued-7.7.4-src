package org.chromium.android_webview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class AwSettings$EventHandler$1 extends Handler {
  AwSettings$EventHandler$1(Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    if (paramMessage.what != 0)
      return; 
    synchronized (AwSettings.access$100(this.this$1.this$0)) {
      if (AwSettings.access$200(this.this$1.this$0) != 0L)
        ((Runnable)paramMessage.obj).run(); 
      AwSettings$EventHandler.access$302(AwSettings$EventHandler.this, false);
      AwSettings.access$100(this.this$1.this$0).notifyAll();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwSettings$EventHandler$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */