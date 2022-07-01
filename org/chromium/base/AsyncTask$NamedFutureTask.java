package org.chromium.base;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class AsyncTask$NamedFutureTask extends FutureTask {
  AsyncTask$NamedFutureTask(Callable<V> paramCallable) {
    super(paramCallable);
  }
  
  protected void done() {
    try {
      AsyncTask.access$1100(AsyncTask.this, get());
      return;
    } catch (InterruptedException interruptedException) {
      Log.w("AsyncTask", interruptedException);
      return;
    } catch (ExecutionException executionException) {
      throw new RuntimeException("An error occurred while executing doInBackground()", executionException.getCause());
    } catch (CancellationException cancellationException) {
      AsyncTask.access$1100(AsyncTask.this, null);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\AsyncTask$NamedFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */