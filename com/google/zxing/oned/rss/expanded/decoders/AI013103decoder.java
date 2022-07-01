package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI013103decoder extends AI013x0xDecoder {
  AI013103decoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  protected int a(int paramInt) {
    return paramInt;
  }
  
  protected void a(StringBuilder paramStringBuilder, int paramInt) {
    paramStringBuilder.append("(3103)");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI013103decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */