package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class AsyncTask$InternalHandler extends Handler {
  public AsyncTask$InternalHandler(Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    AsyncTask$AsyncTaskResult asyncTask$AsyncTaskResult = (AsyncTask$AsyncTaskResult)paramMessage.obj;
    switch (paramMessage.what) {
      default:
        return;
      case 2:
        AsyncTask.onProgressUpdate$1b4f7664();
        return;
      case 1:
        break;
    } 
    AsyncTask.access$1000(asyncTask$AsyncTaskResult.mTask, asyncTask$AsyncTaskResult.mData[0]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\AsyncTask$InternalHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */