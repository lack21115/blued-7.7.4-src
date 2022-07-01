package com.google.common.hash;

import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

enum BloomFilterStrategies implements BloomFilter.Strategy {
  a {
    public <T> boolean a(T param1T, Funnel<? super T> param1Funnel, int param1Int, LockFreeBitArray param1LockFreeBitArray) {
      long l1 = param1LockFreeBitArray.a();
      long l2 = Hashing.a().<T>a(param1T, param1Funnel).c();
      int j = (int)l2;
      int k = (int)(l2 >>> 32L);
      int i;
      for (i = 1; i <= param1Int; i++) {
        int n = i * k + j;
        int m = n;
        if (n < 0)
          m = n; 
        if (!param1LockFreeBitArray.a(m % l1))
          return false; 
      } 
      return true;
    }
  },
  b {
    private long a(byte[] param1ArrayOfbyte) {
      return Longs.a(param1ArrayOfbyte[7], param1ArrayOfbyte[6], param1ArrayOfbyte[5], param1ArrayOfbyte[4], param1ArrayOfbyte[3], param1ArrayOfbyte[2], param1ArrayOfbyte[1], param1ArrayOfbyte[0]);
    }
    
    private long b(byte[] param1ArrayOfbyte) {
      return Longs.a(param1ArrayOfbyte[15], param1ArrayOfbyte[14], param1ArrayOfbyte[13], param1ArrayOfbyte[12], param1ArrayOfbyte[11], param1ArrayOfbyte[10], param1ArrayOfbyte[9], param1ArrayOfbyte[8]);
    }
    
    public <T> boolean a(T param1T, Funnel<? super T> param1Funnel, int param1Int, LockFreeBitArray param1LockFreeBitArray) {
      long l2 = param1LockFreeBitArray.a();
      byte[] arrayOfByte = Hashing.a().<T>a(param1T, param1Funnel).e();
      long l1 = a(arrayOfByte);
      long l3 = b(arrayOfByte);
      int i;
      for (i = 0; i < param1Int; i++) {
        if (!param1LockFreeBitArray.a((Long.MAX_VALUE & l1) % l2))
          return false; 
        l1 += l3;
      } 
      return true;
    }
  };
  
  static final class LockFreeBitArray {
    final AtomicLongArray a;
    
    public static long[] a(AtomicLongArray param1AtomicLongArray) {
      long[] arrayOfLong = new long[param1AtomicLongArray.length()];
      for (int i = 0; i < arrayOfLong.length; i++)
        arrayOfLong[i] = param1AtomicLongArray.get(i); 
      return arrayOfLong;
    }
    
    long a() {
      return this.a.length() * 64L;
    }
    
    boolean a(long param1Long) {
      long l = this.a.get((int)(param1Long >>> 6L));
      return ((1L << (int)param1Long & l) != 0L);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof LockFreeBitArray) {
        param1Object = param1Object;
        return Arrays.equals(a(this.a), a(((LockFreeBitArray)param1Object).a));
      } 
      return false;
    }
    
    public int hashCode() {
      return Arrays.hashCode(a(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\BloomFilterStrategies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */