package android.support.v4.provider;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class SelfDestructiveThread {
  private Handler.Callback mCallback = new SelfDestructiveThread$1(this);
  
  final int mDestructAfterMillisec;
  
  private int mGeneration;
  
  Handler mHandler;
  
  final Object mLock = new Object();
  
  private final int mPriority;
  
  HandlerThread mThread;
  
  private final String mThreadName;
  
  public SelfDestructiveThread(String paramString, int paramInt1, int paramInt2) {
    this.mThreadName = paramString;
    this.mPriority = paramInt1;
    this.mDestructAfterMillisec = paramInt2;
    this.mGeneration = 0;
  }
  
  final void post(Runnable paramRunnable) {
    synchronized (this.mLock) {
      if (this.mThread == null) {
        this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
        this.mGeneration++;
      } 
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramRunnable));
      return;
    } 
  }
  
  public final Object postAndWait(Callable paramCallable, int paramInt) {
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();
    AtomicReference<Callable> atomicReference = new AtomicReference();
    AtomicBoolean atomicBoolean = new AtomicBoolean(true);
    post(new SelfDestructiveThread$3(atomicReference, paramCallable, reentrantLock, atomicBoolean, condition));
    reentrantLock.lock();
    try {
      if (!atomicBoolean.get()) {
        paramCallable = atomicReference.get();
        return paramCallable;
      } 
      long l = TimeUnit.MILLISECONDS.toNanos(paramInt);
      while (true) {
        try {
          long l1 = condition.awaitNanos(l);
          l = l1;
        } catch (InterruptedException interruptedException) {}
        if (!atomicBoolean.get()) {
          paramCallable = atomicReference.get();
          return paramCallable;
        } 
        if (l > 0L)
          continue; 
        throw new InterruptedException("timeout");
      } 
    } finally {
      reentrantLock.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\provider\SelfDestructiveThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */