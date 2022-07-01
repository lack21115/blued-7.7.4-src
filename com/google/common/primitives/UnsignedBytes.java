package com.google.common.primitives;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import sun.misc.Unsafe;

public final class UnsignedBytes {
  public static int a(byte paramByte) {
    return paramByte & 0xFF;
  }
  
  public static int a(byte paramByte1, byte paramByte2) {
    return a(paramByte1) - a(paramByte2);
  }
  
  static Comparator<byte[]> a() {
    return LexicographicalComparatorHolder.PureJavaComparator.a;
  }
  
  static class LexicographicalComparatorHolder {
    static final String a;
    
    static final Comparator<byte[]> b = a();
    
    static Comparator<byte[]> a() {
      try {
        return (Comparator)Class.forName(a).getEnumConstants()[0];
      } finally {
        Exception exception = null;
      } 
    }
    
    static {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(LexicographicalComparatorHolder.class.getName());
      stringBuilder.append("$UnsafeComparator");
      a = stringBuilder.toString();
    }
    
    enum PureJavaComparator implements Comparator<byte[]> {
      a;
      
      public int a(byte[] param2ArrayOfbyte1, byte[] param2ArrayOfbyte2) {
        int j = Math.min(param2ArrayOfbyte1.length, param2ArrayOfbyte2.length);
        for (int i = 0; i < j; i++) {
          int k = UnsignedBytes.a(param2ArrayOfbyte1[i], param2ArrayOfbyte2[i]);
          if (k != 0)
            return k; 
        } 
        return param2ArrayOfbyte1.length - param2ArrayOfbyte2.length;
      }
      
      public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
      }
    }
    
    enum UnsafeComparator implements Comparator<byte[]> {
      a;
      
      static final boolean b = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
      
      static final Unsafe c = a();
      
      static final int d = c.arrayBaseOffset(byte[].class);
      
      static {
        if ("64".equals(System.getProperty("sun.arch.data.model")) && d % 8 == 0 && c.arrayIndexScale(byte[].class) == 1)
          return; 
        throw new Error();
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
      
      public int a(byte[] param2ArrayOfbyte1, byte[] param2ArrayOfbyte2) {
        int j;
        int k = Math.min(param2ArrayOfbyte1.length, param2ArrayOfbyte2.length);
        int i = 0;
        while (true) {
          j = i;
          if (i < (k & 0xFFFFFFF8)) {
            Unsafe unsafe = c;
            long l2 = d;
            long l1 = i;
            l2 = unsafe.getLong(param2ArrayOfbyte1, l2 + l1);
            l1 = c.getLong(param2ArrayOfbyte2, d + l1);
            if (l2 != l1) {
              if (b)
                return UnsignedLongs.a(l2, l1); 
              i = Long.numberOfTrailingZeros(l2 ^ l1) & 0xFFFFFFF8;
              return (int)(l2 >>> i & 0xFFL) - (int)(l1 >>> i & 0xFFL);
            } 
            i += 8;
            continue;
          } 
          break;
        } 
        while (j < k) {
          i = UnsignedBytes.a(param2ArrayOfbyte1[j], param2ArrayOfbyte2[j]);
          if (i != 0)
            return i; 
          j++;
        } 
        return param2ArrayOfbyte1.length - param2ArrayOfbyte2.length;
      }
      
      public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
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
  
  enum PureJavaComparator implements Comparator<byte[]> {
    a;
    
    public int a(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
      int j = Math.min(param1ArrayOfbyte1.length, param1ArrayOfbyte2.length);
      for (int i = 0; i < j; i++) {
        int k = UnsignedBytes.a(param1ArrayOfbyte1[i], param1ArrayOfbyte2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length;
    }
    
    public String toString() {
      return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }
  }
  
  enum UnsafeComparator implements Comparator<byte[]> {
    a;
    
    static final boolean b = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
    
    static final Unsafe c = a();
    
    static final int d = c.arrayBaseOffset(byte[].class);
    
    static {
      if ("64".equals(System.getProperty("sun.arch.data.model")) && d % 8 == 0 && c.arrayIndexScale(byte[].class) == 1)
        return; 
      throw new Error();
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
    
    public int a(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
      int j;
      int k = Math.min(param1ArrayOfbyte1.length, param1ArrayOfbyte2.length);
      int i = 0;
      while (true) {
        j = i;
        if (i < (k & 0xFFFFFFF8)) {
          Unsafe unsafe = c;
          long l2 = d;
          long l1 = i;
          l2 = unsafe.getLong(param1ArrayOfbyte1, l2 + l1);
          l1 = c.getLong(param1ArrayOfbyte2, d + l1);
          if (l2 != l1) {
            if (b)
              return UnsignedLongs.a(l2, l1); 
            i = Long.numberOfTrailingZeros(l2 ^ l1) & 0xFFFFFFF8;
            return (int)(l2 >>> i & 0xFFL) - (int)(l1 >>> i & 0xFFL);
          } 
          i += 8;
          continue;
        } 
        break;
      } 
      while (j < k) {
        i = UnsignedBytes.a(param1ArrayOfbyte1[j], param1ArrayOfbyte2[j]);
        if (i != 0)
          return i; 
        j++;
      } 
      return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length;
    }
    
    public String toString() {
      return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\UnsignedBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */