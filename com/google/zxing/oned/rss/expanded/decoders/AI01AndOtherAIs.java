package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01AndOtherAIs extends AI01decoder {
  AI01AndOtherAIs(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String a() throws NotFoundException, FormatException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(01)");
    int i = stringBuilder.length();
    stringBuilder.append(c().a(4, 4));
    a(stringBuilder, 8, i);
    return c().a(stringBuilder, 48);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01AndOtherAIs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */