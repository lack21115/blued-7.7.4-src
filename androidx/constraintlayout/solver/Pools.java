package androidx.constraintlayout.solver;

final class Pools {
  static interface Pool<T> {
    T acquire();
    
    boolean release(T param1T);
    
    void releaseAll(T[] param1ArrayOfT, int param1Int);
  }
  
  static class SimplePool<T> implements Pool<T> {
    private final Object[] a;
    
    private int b;
    
    SimplePool(int param1Int) {
      if (param1Int > 0) {
        this.a = new Object[param1Int];
        return;
      } 
      throw new IllegalArgumentException("The max pool size must be > 0");
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
      int i = this.b;
      Object[] arrayOfObject = this.a;
      if (i < arrayOfObject.length) {
        arrayOfObject[i] = param1T;
        this.b = i + 1;
        return true;
      } 
      return false;
    }
    
    public void releaseAll(T[] param1ArrayOfT, int param1Int) {
      int i = param1Int;
      if (param1Int > param1ArrayOfT.length)
        i = param1ArrayOfT.length; 
      for (param1Int = 0; param1Int < i; param1Int++) {
        T t = param1ArrayOfT[param1Int];
        int j = this.b;
        Object[] arrayOfObject = this.a;
        if (j < arrayOfObject.length) {
          arrayOfObject[j] = t;
          this.b = j + 1;
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\Pools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */