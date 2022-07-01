package com.blued.android.module.media.audio.audio_manager;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ThreadUtils {
  public static void a() {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
      return; 
    throw new IllegalStateException("Not on main thread!");
  }
  
  public static interface BlockingOperation {}
  
  public static class ThreadChecker {
    private Thread a = Thread.currentThread();
    
    public void a() {
      if (this.a == null)
        this.a = Thread.currentThread(); 
      if (Thread.currentThread() == this.a)
        return; 
      throw new IllegalStateException("Wrong thread");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\audio\audio_manager\ThreadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */