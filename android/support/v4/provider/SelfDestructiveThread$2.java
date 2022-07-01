package android.support.v4.provider;

import android.os.Handler;
import java.util.concurrent.Callable;

final class SelfDestructiveThread$2 implements Runnable {
  public final void run() {
    try {
      exception = (Exception)callable.call();
    } catch (Exception exception) {
      exception = null;
    } 
    callingHandler.post(new SelfDestructiveThread$2$1(this, exception));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\provider\SelfDestructiveThread$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */