package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

final class FragmentActivity$1 extends Handler {
  public final void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        super.handleMessage(paramMessage);
        return;
      case 2:
        FragmentActivity.this.onResumeFragments();
        FragmentActivity.this.mFragments.execPendingActions();
        return;
      case 1:
        break;
    } 
    if (FragmentActivity.this.mStopped) {
      FragmentActivity.this.doReallyStop(false);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */