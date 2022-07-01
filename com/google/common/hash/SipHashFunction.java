package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
  static final HashFunction a = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
  
  private final int b;
  
  private final int c;
  
  private final long d;
  
  private final long e;
  
  SipHashFunction(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
    boolean bool1;
    boolean bool2 = true;
    if (paramInt1 > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1, "The number of SipRound iterations (c=%s) during Compression must be positive.", paramInt1);
    if (paramInt2 > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1, "The number of SipRound iterations (d=%s) during Finalization must be positive.", paramInt2);
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong1;
    this.e = paramLong2;
  }
  
  public Hasher a() {
    return new SipHasher(this.b, this.c, this.d, this.e);
  }
  
  public int b() {
    return 64;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof SipHashFunction;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.b == ((SipHashFunction)paramObject).b) {
        bool1 = bool2;
        if (this.c == ((SipHashFunction)paramObject).c) {
          bool1 = bool2;
          if (this.d == ((SipHashFunction)paramObject).d) {
            bool1 = bool2;
            if (this.e == ((SipHashFunction)paramObject).e)
              bool1 = true; 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return (int)((getClass().hashCode() ^ this.b ^ this.c) ^ this.d ^ this.e);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Hashing.sipHash");
    stringBuilder.append(this.b);
    stringBuilder.append("");
    stringBuilder.append(this.c);
    stringBuilder.append("(");
    stringBuilder.append(this.d);
    stringBuilder.append(", ");
    stringBuilder.append(this.e);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  static final class SipHasher extends AbstractStreamingHasher {
    private final int a;
    
    private final int b;
    
    private long c = 8317987319222330741L;
    
    private long d = 7237128888997146477L;
    
    private long e = 7816392313619706465L;
    
    private long f = 8387220255154660723L;
    
    private long g = 0L;
    
    private long h = 0L;
    
    SipHasher(int param1Int1, int param1Int2, long param1Long1, long param1Long2) {
      super(8);
      this.a = param1Int1;
      this.b = param1Int2;
      this.c ^= param1Long1;
      this.d ^= param1Long2;
      this.e ^= param1Long1;
      this.f ^= param1Long2;
    }
    
    private void c(int param1Int) {
      for (int i = 0; i < param1Int; i++) {
        long l1 = this.c;
        long l2 = this.d;
        this.c = l1 + l2;
        this.e += this.f;
        this.d = Long.rotateLeft(l2, 13);
        this.f = Long.rotateLeft(this.f, 16);
        l1 = this.d;
        l2 = this.c;
        this.d = l1 ^ l2;
        this.f ^= this.e;
        this.c = Long.rotateLeft(l2, 32);
        l1 = this.e;
        l2 = this.d;
        this.e = l1 + l2;
        this.c += this.f;
        this.d = Long.rotateLeft(l2, 17);
        this.f = Long.rotateLeft(this.f, 21);
        l1 = this.d;
        l2 = this.e;
        this.d = l1 ^ l2;
        this.f ^= this.c;
        this.e = Long.rotateLeft(l2, 32);
      } 
    }
    
    private void c(long param1Long) {
      this.f ^= param1Long;
      c(this.a);
      this.c = param1Long ^ this.c;
    }
    
    protected void a(ByteBuffer param1ByteBuffer) {
      this.g += 8L;
      c(param1ByteBuffer.getLong());
    }
    
    protected HashCode b() {
      this.h ^= this.g << 56L;
      c(this.h);
      this.e ^= 0xFFL;
      c(this.b);
      return HashCode.a(this.c ^ this.d ^ this.e ^ this.f);
    }
    
    protected void b(ByteBuffer param1ByteBuffer) {
      this.g += param1ByteBuffer.remaining();
      for (int i = 0; param1ByteBuffer.hasRemaining(); i += 8)
        this.h ^= (param1ByteBuffer.get() & 0xFFL) << i; 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\SipHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */