package android.support.v4.provider;

import android.os.Handler;
import android.os.Message;

final class SelfDestructiveThread$1 implements Handler.Callback {
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return true;
      case 1:
        null = SelfDestructiveThread.this;
        ((Runnable)paramMessage.obj).run();
        synchronized (null.mLock) {
          null.mHandler.removeMessages(0);
          null.mHandler.sendMessageDelayed(null.mHandler.obtainMessage(0), null.mDestructAfterMillisec);
          return true;
        } 
      case 0:
        break;
    } 
    null = SelfDestructiveThread.this;
    synchronized (null.mLock) {
      if (null.mHandler.hasMessages(1))
        return true; 
      null.mThread.quit();
      null.mThread = null;
      null.mHandler = null;
      return true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\provider\SelfDestructiveThread$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */