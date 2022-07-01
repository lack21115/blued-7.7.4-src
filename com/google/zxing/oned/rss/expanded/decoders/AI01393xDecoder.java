package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01393xDecoder extends AI01decoder {
  AI01393xDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String a() throws NotFoundException, FormatException {
    if (b().a() >= 48) {
      StringBuilder stringBuilder = new StringBuilder();
      b(stringBuilder, 8);
      int i = c().a(48, 2);
      stringBuilder.append("(393");
      stringBuilder.append(i);
      stringBuilder.append(')');
      i = c().a(50, 10);
      if (i / 100 == 0)
        stringBuilder.append('0'); 
      if (i / 10 == 0)
        stringBuilder.append('0'); 
      stringBuilder.append(i);
      stringBuilder.append(c().a(60, (String)null).a());
      return stringBuilder.toString();
    } 
    throw NotFoundException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01393xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */