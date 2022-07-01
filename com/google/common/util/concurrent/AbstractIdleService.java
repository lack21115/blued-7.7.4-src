package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Executor;

public abstract class AbstractIdleService implements Service {
  private final Supplier<String> a = new ThreadNameSupplier();
  
  private final Service b = new DelegateService();
  
  protected abstract void a() throws Exception;
  
  protected abstract void b() throws Exception;
  
  protected Executor c() {
    return new Executor(this) {
        public void execute(Runnable param1Runnable) {
          MoreExecutors.a((String)AbstractIdleService.a(this.a).get(), param1Runnable).start();
        }
      };
  }
  
  protected String d() {
    return getClass().getSimpleName();
  }
  
  public final Service.State e() {
    return this.b.e();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d());
    stringBuilder.append(" [");
    stringBuilder.append(e());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  final class DelegateService extends AbstractService {
    private DelegateService(AbstractIdleService this$0) {}
    
    protected final void a() {
      MoreExecutors.a(this.a.c(), AbstractIdleService.a(this.a)).execute(new Runnable(this) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                this.a.a(exception);
              } 
            }
          });
    }
    
    public String toString() {
      return this.a.toString();
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        this.a.a(exception);
      } 
    }
  }
  
  class null implements Runnable {
    null(AbstractIdleService this$0) {}
    
    public void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        this.a.a(exception);
      } 
    }
  }
  
  final class ThreadNameSupplier implements Supplier<String> {
    private ThreadNameSupplier(AbstractIdleService this$0) {}
    
    public String a() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.d());
      stringBuilder.append(" ");
      stringBuilder.append(this.a.e());
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractIdleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */