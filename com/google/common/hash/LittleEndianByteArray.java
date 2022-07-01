package com.google.common.hash;

import com.google.common.primitives.Longs;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class LittleEndianByteArray {
  private static final LittleEndianBytes b;
  
  static {
    JavaLittleEndianBytes javaLittleEndianBytes2 = JavaLittleEndianBytes.a;
    JavaLittleEndianBytes javaLittleEndianBytes1 = javaLittleEndianBytes2;
    try {
    
    } finally {
      javaLittleEndianBytes1 = null;
    } 
    b = javaLittleEndianBytes1;
  }
  
  static long a(byte[] paramArrayOfbyte, int paramInt) {
    if (a || paramArrayOfbyte.length >= paramInt + 8)
      return b.a(paramArrayOfbyte, paramInt); 
    throw new AssertionError();
  }
  
  static int b(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
  }
  
  enum JavaLittleEndianBytes implements LittleEndianBytes {
    a {
      public long a(byte[] param2ArrayOfbyte, int param2Int) {
        return Longs.a(param2ArrayOfbyte[param2Int + 7], param2ArrayOfbyte[param2Int + 6], param2ArrayOfbyte[param2Int + 5], param2ArrayOfbyte[param2Int + 4], param2ArrayOfbyte[param2Int + 3], param2ArrayOfbyte[param2Int + 2], param2ArrayOfbyte[param2Int + 1], param2ArrayOfbyte[param2Int]);
      }
    };
  }
  
  enum null {
    public long a(byte[] param1ArrayOfbyte, int param1Int) {
      return Longs.a(param1ArrayOfbyte[param1Int + 7], param1ArrayOfbyte[param1Int + 6], param1ArrayOfbyte[param1Int + 5], param1ArrayOfbyte[param1Int + 4], param1ArrayOfbyte[param1Int + 3], param1ArrayOfbyte[param1Int + 2], param1ArrayOfbyte[param1Int + 1], param1ArrayOfbyte[param1Int]);
    }
  }
  
  static interface LittleEndianBytes {
    long a(byte[] param1ArrayOfbyte, int param1Int);
  }
  
  enum UnsafeByteArray implements LittleEndianBytes {
    a {
      public long a(byte[] param2ArrayOfbyte, int param2Int) {
        return b().getLong(param2ArrayOfbyte, param2Int + a());
      }
    },
    b {
      public long a(byte[] param2ArrayOfbyte, int param2Int) {
        return Long.reverseBytes(b().getLong(param2ArrayOfbyte, param2Int + a()));
      }
    };
    
    private static final Unsafe c = c();
    
    private static final int d = c.arrayBaseOffset(byte[].class);
    
    static {
      if (c.arrayIndexScale(byte[].class) == 1)
        return; 
      throw new AssertionError();
    }
    
    private static Unsafe c() {
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
  }
  
  enum null {
    public long a(byte[] param1ArrayOfbyte, int param1Int) {
      return LittleEndianByteArray.UnsafeByteArray.b().getLong(param1ArrayOfbyte, param1Int + LittleEndianByteArray.UnsafeByteArray.a());
    }
  }
  
  enum null {
    public long a(byte[] param1ArrayOfbyte, int param1Int) {
      return Long.reverseBytes(LittleEndianByteArray.UnsafeByteArray.b().getLong(param1ArrayOfbyte, param1Int + LittleEndianByteArray.UnsafeByteArray.a()));
    }
  }
  
  static final class null implements PrivilegedExceptionAction<Unsafe> {
    public Unsafe a() throws Exception {
      for (Field field : Unsafe.class.getDeclaredFields()) {
        field.setAccessible(true);
        Object object = field.get((Object)null);
        if (Unsafe.class.isInstance(object))
          return Unsafe.class.cast(object); 
      } 
      throw new NoSuchFieldError("the Unsafe");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\LittleEndianByteArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */