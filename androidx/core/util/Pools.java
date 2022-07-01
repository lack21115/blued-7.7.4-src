package androidx.core.util;

public final class Pools {
  public static interface Pool<T> {
    T acquire();
    
    boolean release(T param1T);
  }
  
  public static class SimplePool<T> implements Pool<T> {
    private final Object[] a;
    
    private int b;
    
    public SimplePool(int param1Int) {
      if (param1Int > 0) {
        this.a = new Object[param1Int];
        return;
      } 
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    
    private boolean a(T param1T) {
      for (int i = 0; i < this.b; i++) {
        if (this.a[i] == param1T)
          return true; 
      } 
      return false;
    }
    
    public T acquire() {
      int i = this.b;
      if (i > 0) {
        int j = i - 1;
        Object[] arrayOfObject = this.a;
        Object object = arrayOfObject[j];
        arrayOfObject[j] = null;
        this.b = i - 1;
        return (T)object;
      } 
      return null;
    }
    
    public boolean release(T param1T) {
      if (!a(param1T)) {
        int i = this.b;
        Object[] arrayOfObject = this.a;
        if (i < arrayOfObject.length) {
          arrayOfObject[i] = param1T;
          this.b = i + 1;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException("Already in the pool!");
    }
  }
  
  public static class SynchronizedPool<T> extends SimplePool<T> {
    private final Object a = new Object();
    
    public SynchronizedPool(int param1Int) {
      super(param1Int);
    }
    
    public T acquire() {
      synchronized (this.a) {
        return super.acquire();
      } 
    }
    
    public boolean release(T param1T) {
      synchronized (this.a) {
        return super.release(param1T);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cor\\util\Pools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */