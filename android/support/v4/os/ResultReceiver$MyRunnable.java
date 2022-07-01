package android.support.v4.os;

import android.os.Bundle;

final class ResultReceiver$MyRunnable implements Runnable {
  private int mResultCode;
  
  private Bundle mResultData;
  
  ResultReceiver$MyRunnable(int paramInt, Bundle paramBundle) {
    this.mResultCode = paramInt;
    this.mResultData = paramBundle;
  }
  
  public final void run() {
    ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\os\ResultReceiver$MyRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */