package android.support.v4.provider;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class SelfDestructiveThread$3 implements Runnable {
  public final void run() {
    try {
      holder.set(callable.call());
    } catch (Exception exception) {}
    lock.lock();
    try {
      running.set(false);
      cond.signal();
      return;
    } finally {
      lock.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\provider\SelfDestructiveThread$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */