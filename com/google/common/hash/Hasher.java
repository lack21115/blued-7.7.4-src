package com.google.common.hash;

import java.nio.charset.Charset;

public interface Hasher extends PrimitiveSink {
  HashCode a();
  
  Hasher a(int paramInt);
  
  Hasher a(long paramLong);
  
  Hasher a(CharSequence paramCharSequence);
  
  Hasher a(CharSequence paramCharSequence, Charset paramCharset);
  
  <T> Hasher a(T paramT, Funnel<? super T> paramFunnel);
  
  Hasher b(byte paramByte);
  
  Hasher b(byte[] paramArrayOfbyte);
  
  Hasher b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\Hasher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */