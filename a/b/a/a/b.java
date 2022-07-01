package a.b.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b extends c {
  public final Object a;
  
  public final ExecutorService b;
  
  public volatile Handler c;
  
  public b() {
    new Object();
    throw new VerifyError("bad dex opcode");
  }
  
  public void a(Runnable paramRunnable) {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean a() {
    Looper.getMainLooper();
    throw new VerifyError("bad dex opcode");
  }
  
  public void b(Runnable paramRunnable) {
    if (this.c == null)
      throw new VerifyError("bad dex opcode"); 
    Handler handler = this.c;
    throw new VerifyError("bad dex opcode");
  }
  
  public class a implements ThreadFactory {
    public final AtomicInteger a;
    
    public a(b this$0) {
      new AtomicInteger(0);
      throw new VerifyError("bad dex opcode");
    }
    
    public Thread newThread(Runnable param1Runnable) {
      new Thread(param1Runnable);
      Object[] arrayOfObject = new Object[1];
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\b\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */