package com.google.zxing;

import java.util.Map;

public interface Reader {
  Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException;
  
  void a();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */