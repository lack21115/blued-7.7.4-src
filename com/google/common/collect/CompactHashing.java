package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class CompactHashing {
  static int a(int paramInt) {
    return Math.max(4, Hashing.a(paramInt + 1, 1.0D));
  }
  
  static int a(int paramInt1, int paramInt2) {
    return paramInt1 & paramInt2;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3) {
    return paramInt1 & paramInt3 | paramInt2 & paramInt3;
  }
  
  static int a(Object paramObject, int paramInt) {
    return (paramObject instanceof byte[]) ? (((byte[])paramObject)[paramInt] & 0xFF) : ((paramObject instanceof short[]) ? (((short[])paramObject)[paramInt] & 0xFFFF) : ((int[])paramObject)[paramInt]);
  }
  
  static int a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2, int paramInt, Object paramObject3, int[] paramArrayOfint, Object[] paramArrayOfObject1, @NullableDecl Object[] paramArrayOfObject2) {
    int i = Hashing.a(paramObject1);
    int k = i & paramInt;
    int j = a(paramObject3, k);
    if (j == 0)
      return -1; 
    int m = a(i, paramInt);
    i = -1;
    while (true) {
      int n = paramArrayOfint[--j];
      if (a(n, paramInt) == m && Objects.a(paramObject1, paramArrayOfObject1[j]) && (paramArrayOfObject2 == null || Objects.a(paramObject2, paramArrayOfObject2[j]))) {
        n = b(n, paramInt);
        if (i == -1) {
          a(paramObject3, k, n);
          return j;
        } 
        paramArrayOfint[i] = a(paramArrayOfint[i], n, paramInt);
        return j;
      } 
      n = b(n, paramInt);
      if (n == 0)
        return -1; 
      i = j;
      j = n;
    } 
  }
  
  static void a(Object paramObject) {
    if (paramObject instanceof byte[]) {
      Arrays.fill((byte[])paramObject, (byte)0);
      return;
    } 
    if (paramObject instanceof short[]) {
      Arrays.fill((short[])paramObject, (short)0);
      return;
    } 
    Arrays.fill((int[])paramObject, 0);
  }
  
  static void a(Object paramObject, int paramInt1, int paramInt2) {
    if (paramObject instanceof byte[]) {
      ((byte[])paramObject)[paramInt1] = (byte)paramInt2;
      return;
    } 
    if (paramObject instanceof short[]) {
      ((short[])paramObject)[paramInt1] = (short)paramInt2;
      return;
    } 
    ((int[])paramObject)[paramInt1] = paramInt2;
  }
  
  static int b(int paramInt1, int paramInt2) {
    return paramInt1 & paramInt2;
  }
  
  static Object b(int paramInt) {
    if (paramInt >= 2 && paramInt <= 1073741824 && Integer.highestOneBit(paramInt) == paramInt)
      return (paramInt <= 256) ? new byte[paramInt] : ((paramInt <= 65536) ? new short[paramInt] : new int[paramInt]); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("must be power of 2 between 2^1 and 2^30: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static int c(int paramInt) {
    byte b;
    if (paramInt < 32) {
      b = 4;
    } else {
      b = 2;
    } 
    return b * (paramInt + 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\CompactHashing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */