package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01weightDecoder extends AI01decoder {
  AI01weightDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  protected abstract int a(int paramInt);
  
  protected abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  final void b(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
    paramInt1 = c().a(paramInt1, paramInt2);
    a(paramStringBuilder, paramInt1);
    int i = a(paramInt1);
    paramInt2 = 100000;
    for (paramInt1 = 0; paramInt1 < 5; paramInt1++) {
      if (i / paramInt2 == 0)
        paramStringBuilder.append('0'); 
      paramInt2 /= 10;
    } 
    paramStringBuilder.append(i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01weightDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */