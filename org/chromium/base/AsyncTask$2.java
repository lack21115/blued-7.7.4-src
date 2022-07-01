package org.chromium.base;

import android.os.Process;

final class AsyncTask$2 extends AsyncTask$WorkerRunnable {
  AsyncTask$2() {
    super((byte)0);
  }
  
  public final Object call() {
    AsyncTask.access$700(AsyncTask.this).set(true);
    Throwable throwable = null;
    Object object2 = null;
    Object object1 = object2;
    try {
      Process.setThreadPriority(10);
      object1 = object2;
      object2 = AsyncTask.this.doInBackground$42af7916();
      try {
        return object2;
      } catch (Throwable throwable1) {
      
      } finally {
        throwable = null;
        object1 = object2;
      } 
    } catch (Throwable throwable1) {
      object2 = throwable;
      throwable = throwable1;
    } finally {}
    object1 = object2;
    AsyncTask.access$800(AsyncTask.this).set(true);
    object1 = object2;
    throw throwable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\AsyncTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */