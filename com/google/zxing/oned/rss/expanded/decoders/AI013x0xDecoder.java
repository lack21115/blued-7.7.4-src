package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

abstract class AI013x0xDecoder extends AI01weightDecoder {
  AI013x0xDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String a() throws NotFoundException {
    if (b().a() == 60) {
      StringBuilder stringBuilder = new StringBuilder();
      b(stringBuilder, 5);
      b(stringBuilder, 45, 15);
      return stringBuilder.toString();
    } 
    throw NotFoundException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI013x0xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */