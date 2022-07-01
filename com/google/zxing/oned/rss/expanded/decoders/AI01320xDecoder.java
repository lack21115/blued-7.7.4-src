package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI01320xDecoder extends AI013x0xDecoder {
  AI01320xDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  protected int a(int paramInt) {
    return (paramInt < 10000) ? paramInt : (paramInt - 10000);
  }
  
  protected void a(StringBuilder paramStringBuilder, int paramInt) {
    if (paramInt < 10000) {
      paramStringBuilder.append("(3202)");
      return;
    } 
    paramStringBuilder.append("(3203)");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01320xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */