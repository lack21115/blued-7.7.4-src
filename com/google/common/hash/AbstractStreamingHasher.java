package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class AbstractStreamingHasher extends AbstractHasher {
  private final ByteBuffer a;
  
  private final int b;
  
  private final int c;
  
  protected AbstractStreamingHasher(int paramInt) {
    this(paramInt, paramInt);
  }
  
  protected AbstractStreamingHasher(int paramInt1, int paramInt2) {
    boolean bool;
    if (paramInt2 % paramInt1 == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    this.a = ByteBuffer.allocate(paramInt2 + 7).order(ByteOrder.LITTLE_ENDIAN);
    this.b = paramInt2;
    this.c = paramInt1;
  }
  
  private Hasher c(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.remaining() <= this.a.remaining()) {
      this.a.put(paramByteBuffer);
      c();
      return this;
    } 
    int j = this.b;
    int k = this.a.position();
    for (int i = 0; i < j - k; i++)
      this.a.put(paramByteBuffer.get()); 
    d();
    while (paramByteBuffer.remaining() >= this.c)
      a(paramByteBuffer); 
    this.a.put(paramByteBuffer);
    return this;
  }
  
  private void c() {
    if (this.a.remaining() < 8)
      d(); 
  }
  
  private void d() {
    this.a.flip();
    while (this.a.remaining() >= this.c)
      a(this.a); 
    this.a.compact();
  }
  
  public final HashCode a() {
    d();
    this.a.flip();
    if (this.a.remaining() > 0) {
      b(this.a);
      ByteBuffer byteBuffer = this.a;
      byteBuffer.position(byteBuffer.limit());
    } 
    return b();
  }
  
  public final Hasher a(char paramChar) {
    this.a.putChar(paramChar);
    c();
    return this;
  }
  
  public final Hasher a(int paramInt) {
    this.a.putInt(paramInt);
    c();
    return this;
  }
  
  public final Hasher a(long paramLong) {
    this.a.putLong(paramLong);
    c();
    return this;
  }
  
  protected abstract void a(ByteBuffer paramByteBuffer);
  
  protected abstract HashCode b();
  
  public final Hasher b(byte paramByte) {
    this.a.put(paramByte);
    c();
    return this;
  }
  
  public final Hasher b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return c(ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2).order(ByteOrder.LITTLE_ENDIAN));
  }
  
  protected void b(ByteBuffer paramByteBuffer) {
    paramByteBuffer.position(paramByteBuffer.limit());
    paramByteBuffer.limit(this.c + 7);
    while (true) {
      int i = paramByteBuffer.position();
      int j = this.c;
      if (i < j) {
        paramByteBuffer.putLong(0L);
        continue;
      } 
      paramByteBuffer.limit(j);
      paramByteBuffer.flip();
      a(paramByteBuffer);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\AbstractStreamingHasher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */