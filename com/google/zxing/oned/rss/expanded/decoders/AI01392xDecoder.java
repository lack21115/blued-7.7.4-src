package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01392xDecoder extends AI01decoder {
  AI01392xDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String a() throws NotFoundException, FormatException {
    if (b().a() >= 48) {
      StringBuilder stringBuilder = new StringBuilder();
      b(stringBuilder, 8);
      int i = c().a(48, 2);
      stringBuilder.append("(392");
      stringBuilder.append(i);
      stringBuilder.append(')');
      stringBuilder.append(c().a(50, (String)null).a());
      return stringBuilder.toString();
    } 
    throw NotFoundException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01392xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */