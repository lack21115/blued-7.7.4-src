package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class HashCode {
  private static final char[] a = "0123456789abcdef".toCharArray();
  
  public static HashCode a(int paramInt) {
    return new IntHashCode(paramInt);
  }
  
  public static HashCode a(long paramLong) {
    return new LongHashCode(paramLong);
  }
  
  static HashCode a(byte[] paramArrayOfbyte) {
    return new BytesHashCode(paramArrayOfbyte);
  }
  
  public abstract int a();
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramInt2 = Ints.a(new int[] { paramInt2, a() / 8 });
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    b(paramArrayOfbyte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  abstract boolean a(HashCode paramHashCode);
  
  public abstract int b();
  
  abstract void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public abstract long c();
  
  public abstract byte[] d();
  
  byte[] e() {
    return d();
  }
  
  public final boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof HashCode;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (a() == paramObject.a()) {
        bool1 = bool2;
        if (a((HashCode)paramObject))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public final int hashCode() {
    if (a() >= 32)
      return b(); 
    byte[] arrayOfByte = e();
    int j = arrayOfByte[0] & 0xFF;
    for (int i = 1; i < arrayOfByte.length; i++)
      j |= (arrayOfByte[i] & 0xFF) << i * 8; 
    return j;
  }
  
  public final String toString() {
    byte[] arrayOfByte = e();
    StringBuilder stringBuilder = new StringBuilder(arrayOfByte.length * 2);
    int j = arrayOfByte.length;
    for (int i = 0; i < j; i++) {
      byte b = arrayOfByte[i];
      stringBuilder.append(a[b >> 4 & 0xF]);
      stringBuilder.append(a[b & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  static final class BytesHashCode extends HashCode implements Serializable {
    final byte[] a;
    
    BytesHashCode(byte[] param1ArrayOfbyte) {
      this.a = (byte[])Preconditions.a(param1ArrayOfbyte);
    }
    
    public int a() {
      return this.a.length * 8;
    }
    
    boolean a(HashCode param1HashCode) {
      if (this.a.length != (param1HashCode.e()).length)
        return false; 
      int i = 0;
      int j = 1;
      while (true) {
        byte[] arrayOfByte = this.a;
        if (i < arrayOfByte.length) {
          byte b;
          if (arrayOfByte[i] == param1HashCode.e()[i]) {
            b = 1;
          } else {
            b = 0;
          } 
          j &= b;
          i++;
          continue;
        } 
        return j;
      } 
    }
    
    public int b() {
      boolean bool;
      if (this.a.length >= 4) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.a.length);
      byte[] arrayOfByte = this.a;
      byte b1 = arrayOfByte[0];
      byte b2 = arrayOfByte[1];
      byte b3 = arrayOfByte[2];
      return (arrayOfByte[3] & 0xFF) << 24 | (b2 & 0xFF) << 8 | b1 & 0xFF | (b3 & 0xFF) << 16;
    }
    
    void b(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      System.arraycopy(this.a, 0, param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public long c() {
      boolean bool;
      if (this.a.length >= 8) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.a.length);
      return f();
    }
    
    public byte[] d() {
      return (byte[])this.a.clone();
    }
    
    byte[] e() {
      return this.a;
    }
    
    public long f() {
      long l = (this.a[0] & 0xFF);
      for (int i = 1; i < Math.min(this.a.length, 8); i++)
        l |= (this.a[i] & 0xFFL) << i * 8; 
      return l;
    }
  }
  
  static final class IntHashCode extends HashCode implements Serializable {
    final int a;
    
    IntHashCode(int param1Int) {
      this.a = param1Int;
    }
    
    public int a() {
      return 32;
    }
    
    boolean a(HashCode param1HashCode) {
      return (this.a == param1HashCode.b());
    }
    
    public int b() {
      return this.a;
    }
    
    void b(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      int i;
      for (i = 0; i < param1Int2; i++)
        param1ArrayOfbyte[param1Int1 + i] = (byte)(this.a >> i * 8); 
    }
    
    public long c() {
      throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
    }
    
    public byte[] d() {
      int i = this.a;
      return new byte[] { (byte)i, (byte)(i >> 8), (byte)(i >> 16), (byte)(i >> 24) };
    }
  }
  
  static final class LongHashCode extends HashCode implements Serializable {
    final long a;
    
    LongHashCode(long param1Long) {
      this.a = param1Long;
    }
    
    public int a() {
      return 64;
    }
    
    boolean a(HashCode param1HashCode) {
      return (this.a == param1HashCode.c());
    }
    
    public int b() {
      return (int)this.a;
    }
    
    void b(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      int i;
      for (i = 0; i < param1Int2; i++)
        param1ArrayOfbyte[param1Int1 + i] = (byte)(int)(this.a >> i * 8); 
    }
    
    public long c() {
      return this.a;
    }
    
    public byte[] d() {
      long l = this.a;
      return new byte[] { (byte)(int)l, (byte)(int)(l >> 8L), (byte)(int)(l >> 16L), (byte)(int)(l >> 24L), (byte)(int)(l >> 32L), (byte)(int)(l >> 40L), (byte)(int)(l >> 48L), (byte)(int)(l >> 56L) };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\HashCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */