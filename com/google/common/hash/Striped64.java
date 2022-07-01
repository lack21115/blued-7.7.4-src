package com.google.common.hash;

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
  
  private static final Unsafe f;
  
  private static final long g;
  
  private static final long h;
  
  @NullableDecl
  volatile transient Cell[] d;
  
  volatile transient long e;
  
  static {
    try {
      f = a();
      g = f.objectFieldOffset(Striped64.class.getDeclaredField("base"));
      h = f.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
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
  
  static final class Cell {
    private static final Unsafe b;
    
    private static final long c;
    
    volatile long a;
    
    static {
      try {
        b = Striped64.b();
        c = b.objectFieldOffset(Cell.class.getDeclaredField("value"));
        return;
      } catch (Exception exception) {
        throw new Error(exception);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\Striped64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */