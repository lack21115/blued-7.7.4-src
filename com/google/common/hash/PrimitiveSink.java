package com.google.common.hash;

import java.nio.charset.Charset;

public interface PrimitiveSink {
  PrimitiveSink b(int paramInt);
  
  PrimitiveSink b(long paramLong);
  
  PrimitiveSink b(CharSequence paramCharSequence);
  
  PrimitiveSink b(CharSequence paramCharSequence, Charset paramCharset);
  
  PrimitiveSink c(byte paramByte);
  
  PrimitiveSink c(byte[] paramArrayOfbyte);
  
  PrimitiveSink c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\PrimitiveSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */