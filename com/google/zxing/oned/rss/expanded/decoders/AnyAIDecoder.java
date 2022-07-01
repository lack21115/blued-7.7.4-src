package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AnyAIDecoder extends AbstractExpandedDecoder {
  AnyAIDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String a() throws NotFoundException, FormatException {
    StringBuilder stringBuilder = new StringBuilder();
    return c().a(stringBuilder, 5);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AnyAIDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */