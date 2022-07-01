package org.chromium.android_webview;

import android.os.Looper;
import android.os.Message;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Set;

public final class CleanupReference extends WeakReference {
  private static Object sCleanupMonitor;
  
  private static ReferenceQueue sGcQueue = new ReferenceQueue();
  
  private static final Thread sReaperThread;
  
  private static Set sRefs;
  
  Runnable mCleanupTask;
  
  static {
    sCleanupMonitor = new Object();
    sReaperThread = new CleanupReference$1("CleanupReference");
    throw new VerifyError("bad dex opcode");
  }
  
  public CleanupReference(Object paramObject, Runnable paramRunnable) {
    super((T)paramObject, sGcQueue);
    this.mCleanupTask = paramRunnable;
    handleOnUiThread(1);
  }
  
  public final void handleOnUiThread(int paramInt) {
    Message message = Message.obtain(CleanupReference$LazyHolder.sHandler, paramInt, this);
    if (Looper.myLooper() == message.getTarget().getLooper()) {
      message.getTarget().handleMessage(message);
      message.recycle();
      return;
    } 
    message.sendToTarget();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\CleanupReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */