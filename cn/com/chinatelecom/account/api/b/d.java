package cn.com.chinatelecom.account.api.b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class d extends ThreadPoolExecutor {
  private static final BlockingQueue<Runnable> a = new LinkedBlockingQueue<Runnable>(256);
  
  private static final ThreadFactory b = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);
      
      public Thread newThread(Runnable param1Runnable) {
        return new Thread(param1Runnable);
      }
    };
  
  public d() {
    this(5);
  }
  
  public d(int paramInt) {
    this(paramInt, paramInt * 2, 1L, TimeUnit.SECONDS, a, b);
  }
  
  public d(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory) {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  public void a(e parame) {
    execute(parame);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */