package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

abstract class Striped64 extends Number {
  static final ThreadLocal<int[]> a = (ThreadLocal)new ThreadLocal<int>();
  
  static final Random b = new Random();
  
  static final int c = Runtime.getRuntime().availableProcessors();
  
  private static final Unsafe g;
  
  private static final long h;
  
  private static final long i;
  
  @NullableDecl
  volatile transient Cell[] d;
  
  volatile transient long e;
  
  volatile transient int f;
  
  static {
    try {
      g = a();
      h = g.objectFieldOffset(Striped64.class.getDeclaredField("base"));
      i = g.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
      return;
    } catch (Exception exception) {
      throw new Error(exception);
    } 
  }
  
  private static Unsafe a() {
    try {
      return Unsafe.getUnsafe();
    } catch (SecurityException securityException) {
      try {
        return AccessController.<Unsafe>doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
              public Unsafe a() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                  field.setAccessible(true);
                  Object object = field.get((Object)null);
                  if (Unsafe.class.isInstance(object))
                    return Unsafe.class.cast(object); 
                } 
                throw new NoSuchFieldError("the Unsafe");
              }
            });
      } catch (PrivilegedActionException privilegedActionException) {
        throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
      } 
    } 
  }
  
  abstract long a(long paramLong1, long paramLong2);
  
  final void a(long paramLong, int[] paramArrayOfint, boolean paramBoolean) {
    int i;
    ThreadLocal<int[]> threadLocal;
    if (paramArrayOfint == null) {
      threadLocal = a;
      paramArrayOfint = new int[1];
      threadLocal.set(paramArrayOfint);
      int j = b.nextInt();
      i = j;
      if (j == 0)
        i = 1; 
      paramArrayOfint[0] = i;
    } else {
      i = paramArrayOfint[0];
    } 
    while (true) {
      Cell[] arrayOfCell;
      boolean bool = false;
      int j = i;
      while (true) {
        arrayOfCell = this.d;
        try {
          if (this.d == threadLocal) {
            arrayOfCell = new Cell[2];
            arrayOfCell[j & 0x1] = new Cell(paramLong);
            this.d = arrayOfCell;
            i = 1;
          } else {
            i = 0;
          } 
          this.f = 0;
        } finally {
          this.f = 0;
        } 
      } 
      while (true) {
        if (i < SYNTHETIC_LOCAL_VARIABLE_8) {
          SYNTHETIC_LOCAL_VARIABLE_13[i] = arrayOfCell[i];
          i++;
          continue;
        } 
        this.d = (Cell[])SYNTHETIC_LOCAL_VARIABLE_13;
        this.f = 0;
        i = j;
      } 
      break;
    } 
  }
  
  final boolean b(long paramLong1, long paramLong2) {
    return g.compareAndSwapLong(this, h, paramLong1, paramLong2);
  }
  
  final boolean c() {
    return g.compareAndSwapInt(this, i, 0, 1);
  }
  
  static final class Cell {
    private static final Unsafe b;
    
    private static final long c;
    
    volatile long a;
    
    static {
      try {
        b = Striped64.d();
        c = b.objectFieldOffset(Cell.class.getDeclaredField("value"));
        return;
      } catch (Exception exception) {
        throw new Error(exception);
      } 
    }
    
    Cell(long param1Long) {
      this.a = param1Long;
    }
    
    final boolean a(long param1Long1, long param1Long2) {
      return b.compareAndSwapLong(this, c, param1Long1, param1Long2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\Striped64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */