package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class AbstractByteHasher extends AbstractHasher {
  private final ByteBuffer a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
  
  private Hasher c(int paramInt) {
    try {
      a(this.a.array(), 0, paramInt);
      return this;
    } finally {
      this.a.clear();
    } 
  }
  
  public Hasher a(char paramChar) {
    this.a.putChar(paramChar);
    return c(2);
  }
  
  public Hasher a(int paramInt) {
    this.a.putInt(paramInt);
    return c(4);
  }
  
  public Hasher a(long paramLong) {
    this.a.putLong(paramLong);
    return c(8);
  }
  
  protected abstract void a(byte paramByte);
  
  protected void a(byte[] paramArrayOfbyte) {
    a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  protected void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i;
    for (i = paramInt1; i < paramInt1 + paramInt2; i++)
      a(paramArrayOfbyte[i]); 
  }
  
  public Hasher b(byte paramByte) {
    a(paramByte);
    return this;
  }
  
  public Hasher b(byte[] paramArrayOfbyte) {
    Preconditions.a(paramArrayOfbyte);
    a(paramArrayOfbyte);
    return this;
  }
  
  public Hasher b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    a(paramArrayOfbyte, paramInt1, paramInt2);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\AbstractByteHasher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */