package com.blued.android.statistics.util;

import java.util.concurrent.atomic.AtomicInteger;

public class LoopQueue {
  private Object[] a;
  
  private AtomicInteger b;
  
  private AtomicInteger c = new AtomicInteger(0);
  
  private AtomicInteger d = new AtomicInteger(0);
  
  public LoopQueue(int paramInt) {
    this.b = new AtomicInteger(paramInt);
    this.a = new Object[paramInt];
  }
  
  public void a(Object paramObject) {
    synchronized (this.a) {
      this.a[this.d.get()] = paramObject;
      this.d.set((this.d.get() + 1) % this.b.get());
      return;
    } 
  }
  
  public boolean a() {
    synchronized (this.a) {
      if (this.c.get() == this.d.get())
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public Object[] a(int paramInt) {
    synchronized (this.a) {
      if (a())
        return null; 
      int i = b();
      if (paramInt >= i)
        paramInt = i; 
      Object[] arrayOfObject = new Object[paramInt];
      int j = (this.c.get() + paramInt) % this.b.get();
      int k = this.c.get();
      i = 0;
      if (j < k) {
        j = this.b.get() - this.c.get();
        System.arraycopy(this.a, this.c.get(), arrayOfObject, 0, j);
        System.arraycopy(this.a, 0, arrayOfObject, j, paramInt - j);
      } else {
        System.arraycopy(this.a, this.c.get(), arrayOfObject, 0, j - this.c.get());
      } 
      while (i < paramInt) {
        this.a[(this.c.get() + i) % this.b.get()] = null;
        i++;
      } 
      this.c.set((this.c.get() + paramInt) % this.b.get());
      return arrayOfObject;
    } 
  }
  
  public int b() {
    synchronized (this.a) {
      int i = this.d.get();
      int j = this.c.get();
      int k = this.b.get();
      int m = this.b.get();
      return (i - j + k) % m;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistic\\util\LoopQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */