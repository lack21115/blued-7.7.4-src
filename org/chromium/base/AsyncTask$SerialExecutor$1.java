package org.chromium.base;

final class AsyncTask$SerialExecutor$1 implements Runnable {
  public final void run() {
    try {
      r.run();
      return;
    } finally {
      AsyncTask$SerialExecutor.this.scheduleNext();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\AsyncTask$SerialExecutor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */