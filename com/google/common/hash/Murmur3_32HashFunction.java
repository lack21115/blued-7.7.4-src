package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
  static final HashFunction a = new Murmur3_32HashFunction(0);
  
  static final HashFunction b = new Murmur3_32HashFunction(Hashing.a);
  
  private final int c;
  
  Murmur3_32HashFunction(int paramInt) {
    this.c = paramInt;
  }
  
  private static int b(byte[] paramArrayOfbyte, int paramInt) {
    return Ints.a(paramArrayOfbyte[paramInt + 3], paramArrayOfbyte[paramInt + 2], paramArrayOfbyte[paramInt + 1], paramArrayOfbyte[paramInt]);
  }
  
  private static int c(int paramInt1, int paramInt2) {
    return Integer.rotateLeft(paramInt1 ^ paramInt2, 13) * 5 - 430675100;
  }
  
  private static long c(char paramChar) {
    return ((paramChar & 0x3F | 0x80) << 16 | (paramChar >>> 12 | 0x1E0) & 0xFF | (paramChar >>> 6 & 0x3F | 0x80) << 8);
  }
  
  private static int d(int paramInt) {
    return Integer.rotateLeft(paramInt * -862048943, 15) * 461845907;
  }
  
  private static long d(char paramChar) {
    return ((paramChar & 0x3F | 0x80) << 8 | (paramChar >>> 6 | 0x3C0) & 0xFF);
  }
  
  private static HashCode d(int paramInt1, int paramInt2) {
    paramInt1 ^= paramInt2;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 16) * -2048144789;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 13) * -1028477387;
    return HashCode.a(paramInt1 ^ paramInt1 >>> 16);
  }
  
  private static long e(int paramInt) {
    return ((paramInt >>> 18) | 0xF0L) & 0xFFL | ((paramInt >>> 12 & 0x3F) | 0x80L) << 8L | ((paramInt >>> 6 & 0x3F) | 0x80L) << 16L | ((paramInt & 0x3F) | 0x80L) << 24L;
  }
  
  public HashCode a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    int j = this.c;
    int k = 0;
    int i = 0;
    while (true) {
      int m = i + 4;
      if (m <= paramInt2) {
        j = c(j, d(b(paramArrayOfbyte, i + paramInt1)));
        i = m;
        continue;
      } 
      for (m = 0; i < paramInt2; m += 8) {
        k ^= UnsignedBytes.a(paramArrayOfbyte[paramInt1 + i]) << m;
        i++;
      } 
      return d(d(k) ^ j, paramInt2);
    } 
  }
  
  public Hasher a() {
    return new Murmur3_32Hasher(this.c);
  }
  
  public int b() {
    return 32;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Murmur3_32HashFunction;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.c == ((Murmur3_32HashFunction)paramObject).c)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return getClass().hashCode() ^ this.c;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Hashing.murmur3_32(");
    stringBuilder.append(this.c);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  static final class Murmur3_32Hasher extends AbstractHasher {
    private int a;
    
    private long b;
    
    private int c;
    
    private int d;
    
    private boolean e;
    
    Murmur3_32Hasher(int param1Int) {
      this.a = param1Int;
      this.d = 0;
      this.e = false;
    }
    
    private void a(int param1Int, long param1Long) {
      long l = this.b;
      int i = this.c;
      this.b = (param1Long & 0xFFFFFFFFL) << i | l;
      this.c = i + param1Int * 8;
      this.d += param1Int;
      if (this.c >= 32) {
        this.a = Murmur3_32HashFunction.a(this.a, Murmur3_32HashFunction.b((int)this.b));
        this.b >>>= 32L;
        this.c -= 32;
      } 
    }
    
    public HashCode a() {
      Preconditions.b(this.e ^ true);
      this.e = true;
      this.a ^= Murmur3_32HashFunction.b((int)this.b);
      return Murmur3_32HashFunction.b(this.a, this.d);
    }
    
    public Hasher a(char param1Char) {
      a(2, param1Char);
      return this;
    }
    
    public Hasher a(int param1Int) {
      a(4, param1Int);
      return this;
    }
    
    public Hasher a(long param1Long) {
      a(4, (int)param1Long);
      a(4, param1Long >>> 32L);
      return this;
    }
    
    public Hasher a(CharSequence param1CharSequence, Charset param1Charset) {
      if (Charsets.c.equals(param1Charset)) {
        int i;
        int k = param1CharSequence.length();
        int j = 0;
        while (true) {
          int m = j + 4;
          i = j;
          if (m <= k) {
            char c1 = param1CharSequence.charAt(j);
            char c2 = param1CharSequence.charAt(j + 1);
            char c3 = param1CharSequence.charAt(j + 2);
            char c4 = param1CharSequence.charAt(j + 3);
            i = j;
            if (c1 < '') {
              i = j;
              if (c2 < '') {
                i = j;
                if (c3 < '') {
                  i = j;
                  if (c4 < '') {
                    a(4, (c2 << 8 | c1 | c3 << 16 | c4 << 24));
                    j = m;
                    continue;
                  } 
                } 
              } 
            } 
          } 
          break;
        } 
        while (i < k) {
          char c = param1CharSequence.charAt(i);
          if (c < '') {
            a(1, c);
          } else if (c < 'ࠀ') {
            a(2, Murmur3_32HashFunction.a(c));
          } else if (c < '?' || c > '?') {
            a(3, Murmur3_32HashFunction.b(c));
          } else {
            j = Character.codePointAt(param1CharSequence, i);
            if (j == c) {
              b(param1CharSequence.subSequence(i, k).toString().getBytes(param1Charset));
              return this;
            } 
            i++;
            a(4, Murmur3_32HashFunction.c(j));
          } 
          i++;
        } 
        return this;
      } 
      return super.a(param1CharSequence, param1Charset);
    }
    
    public Hasher b(byte param1Byte) {
      a(1, (param1Byte & 0xFF));
      return this;
    }
    
    public Hasher b(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      int j;
      Preconditions.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
      int i = 0;
      while (true) {
        int k = i + 4;
        j = i;
        if (k <= param1Int2) {
          a(4, Murmur3_32HashFunction.a(param1ArrayOfbyte, i + param1Int1));
          i = k;
          continue;
        } 
        break;
      } 
      while (j < param1Int2) {
        b(param1ArrayOfbyte[param1Int1 + j]);
        j++;
      } 
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\Murmur3_32HashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */