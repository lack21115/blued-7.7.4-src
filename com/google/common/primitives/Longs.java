package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Longs {
  public static int a(long paramLong) {
    return (int)(paramLong ^ paramLong >>> 32L);
  }
  
  public static int a(long paramLong1, long paramLong2) {
    int i = paramLong1 cmp paramLong2;
    return (i < 0) ? -1 : ((i > 0) ? 1 : 0);
  }
  
  public static long a(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8) {
    long l = paramByte1;
    return (paramByte2 & 0xFFL) << 48L | (l & 0xFFL) << 56L | (paramByte3 & 0xFFL) << 40L | (paramByte4 & 0xFFL) << 32L | (paramByte5 & 0xFFL) << 24L | (paramByte6 & 0xFFL) << 16L | (paramByte7 & 0xFFL) << 8L | paramByte8 & 0xFFL;
  }
  
  public static byte[] b(long paramLong) {
    byte[] arrayOfByte = new byte[8];
    for (int i = 7; i >= 0; i--) {
      arrayOfByte[i] = (byte)(int)(0xFFL & paramLong);
      paramLong >>= 8L;
    } 
    return arrayOfByte;
  }
  
  private static int c(long[] paramArrayOflong, long paramLong, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOflong[paramInt1] == paramLong)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  private static int d(long[] paramArrayOflong, long paramLong, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOflong[paramInt2] == paramLong)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  static final class AsciiDigits {
    private static final byte[] a;
    
    static {
      int j;
      byte[] arrayOfByte = new byte[128];
      Arrays.fill(arrayOfByte, (byte)-1);
      byte b = 0;
      int i = 0;
      while (true) {
        j = b;
        if (i < 10) {
          arrayOfByte[i + 48] = (byte)i;
          i++;
          continue;
        } 
        break;
      } 
      while (j < 26) {
        byte b1 = (byte)(j + 10);
        arrayOfByte[j + 65] = b1;
        arrayOfByte[j + 97] = b1;
        j++;
      } 
      a = arrayOfByte;
    }
  }
  
  enum LexicographicalComparator implements Comparator<long[]> {
    a;
    
    public int a(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
      int j = Math.min(param1ArrayOflong1.length, param1ArrayOflong2.length);
      for (int i = 0; i < j; i++) {
        int k = Longs.a(param1ArrayOflong1[i], param1ArrayOflong2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOflong1.length - param1ArrayOflong2.length;
    }
    
    public String toString() {
      return "Longs.lexicographicalComparator()";
    }
  }
  
  static class LongArrayAsList extends AbstractList<Long> implements Serializable, RandomAccess {
    final long[] a;
    
    final int b;
    
    final int c;
    
    LongArrayAsList(long[] param1ArrayOflong, int param1Int1, int param1Int2) {
      this.a = param1ArrayOflong;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public Long a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Long.valueOf(this.a[this.b + param1Int]);
    }
    
    public Long a(int param1Int, Long param1Long) {
      Preconditions.a(param1Int, size());
      long[] arrayOfLong = this.a;
      int i = this.b;
      long l = arrayOfLong[i + param1Int];
      arrayOfLong[i + param1Int] = ((Long)Preconditions.a(param1Long)).longValue();
      return Long.valueOf(l);
    }
    
    public boolean contains(Object param1Object) {
      return (param1Object instanceof Long && Longs.a(this.a, ((Long)param1Object).longValue(), this.b, this.c) != -1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof LongArrayAsList) {
        param1Object = param1Object;
        int j = size();
        if (param1Object.size() != j)
          return false; 
        for (int i = 0; i < j; i++) {
          if (this.a[this.b + i] != ((LongArrayAsList)param1Object).a[((LongArrayAsList)param1Object).b + i])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public int hashCode() {
      int i = this.b;
      int j = 1;
      while (i < this.c) {
        j = j * 31 + Longs.a(this.a[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Long) {
        int i = Longs.a(this.a, ((Long)param1Object).longValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Long) {
        int i = Longs.b(this.a, ((Long)param1Object).longValue(), this.b, this.c);
        if (i >= 0)
          return i - this.b; 
      } 
      return -1;
    }
    
    public int size() {
      return this.c - this.b;
    }
    
    public List<Long> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      long[] arrayOfLong = this.a;
      int i = this.b;
      return new LongArrayAsList(arrayOfLong, param1Int1 + i, i + param1Int2);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 10);
      stringBuilder.append('[');
      stringBuilder.append(this.a[this.b]);
      int i = this.b;
      while (true) {
        if (++i < this.c) {
          stringBuilder.append(", ");
          stringBuilder.append(this.a[i]);
          continue;
        } 
        stringBuilder.append(']');
        return stringBuilder.toString();
      } 
    }
  }
  
  static final class LongConverter extends Converter<String, Long> implements Serializable {
    static final LongConverter a = new LongConverter();
    
    protected Long a(String param1String) {
      return Long.decode(param1String);
    }
    
    protected String a(Long param1Long) {
      return param1Long.toString();
    }
    
    public String toString() {
      return "Longs.stringConverter()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\Longs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */