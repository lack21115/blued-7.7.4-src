package android.support.v4.os;

import android.os.Bundle;

final class ResultReceiver$MyResultReceiver extends IResultReceiver$Stub {
  public final void send(int paramInt, Bundle paramBundle) {
    if (ResultReceiver.this.mHandler != null) {
      ResultReceiver.this.mHandler.post(new ResultReceiver$MyRunnable(ResultReceiver.this, paramInt, paramBundle));
      return;
    } 
    ResultReceiver.this.onReceiveResult(paramInt, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\os\ResultReceiver$MyResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */