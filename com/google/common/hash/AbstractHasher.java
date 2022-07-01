package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.charset.Charset;

abstract class AbstractHasher implements Hasher {
  public Hasher a(char paramChar) {
    b((byte)paramChar);
    b((byte)(paramChar >>> 8));
    return this;
  }
  
  public Hasher a(int paramInt) {
    b((byte)paramInt);
    b((byte)(paramInt >>> 8));
    b((byte)(paramInt >>> 16));
    b((byte)(paramInt >>> 24));
    return this;
  }
  
  public Hasher a(long paramLong) {
    for (int i = 0; i < 64; i += 8)
      b((byte)(int)(paramLong >>> i)); 
    return this;
  }
  
  public Hasher a(CharSequence paramCharSequence) {
    int j = paramCharSequence.length();
    for (int i = 0; i < j; i++)
      a(paramCharSequence.charAt(i)); 
    return this;
  }
  
  public Hasher a(CharSequence paramCharSequence, Charset paramCharset) {
    return b(paramCharSequence.toString().getBytes(paramCharset));
  }
  
  public <T> Hasher a(T paramT, Funnel<? super T> paramFunnel) {
    paramFunnel.a(paramT, this);
    return this;
  }
  
  public Hasher b(byte[] paramArrayOfbyte) {
    return b(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public Hasher b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    int i;
    for (i = 0; i < paramInt2; i++)
      b(paramArrayOfbyte[paramInt1 + i]); 
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\AbstractHasher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */