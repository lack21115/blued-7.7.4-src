package androidx.recyclerview.widget;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig<T> {
  private final Executor a;
  
  private final Executor b;
  
  private final DiffUtil.ItemCallback<T> c;
  
  AsyncDifferConfig(Executor paramExecutor1, Executor paramExecutor2, DiffUtil.ItemCallback<T> paramItemCallback) {
    this.a = paramExecutor1;
    this.b = paramExecutor2;
    this.c = paramItemCallback;
  }
  
  public Executor getBackgroundThreadExecutor() {
    return this.b;
  }
  
  public DiffUtil.ItemCallback<T> getDiffCallback() {
    return this.c;
  }
  
  public Executor getMainThreadExecutor() {
    return this.a;
  }
  
  public static final class Builder<T> {
    private static final Object d = new Object();
    
    private static Executor e = null;
    
    private Executor a;
    
    private Executor b;
    
    private final DiffUtil.ItemCallback<T> c;
    
    public Builder(DiffUtil.ItemCallback<T> param1ItemCallback) {
      this.c = param1ItemCallback;
    }
    
    public AsyncDifferConfig<T> build() {
      if (this.b == null)
        synchronized (d) {
          if (e == null)
            e = Executors.newFixedThreadPool(2); 
          this.b = e;
        }  
      return new AsyncDifferConfig<T>(this.a, this.b, this.c);
    }
    
    public Builder<T> setBackgroundThreadExecutor(Executor param1Executor) {
      this.b = param1Executor;
      return this;
    }
    
    public Builder<T> setMainThreadExecutor(Executor param1Executor) {
      this.a = param1Executor;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\AsyncDifferConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */