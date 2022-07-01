package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01decoder extends AbstractExpandedDecoder {
  AI01decoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt) {
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < 13) {
      int m = paramStringBuilder.charAt(i + paramInt) - 48;
      int k = m;
      if ((i & 0x1) == 0)
        k = m * 3; 
      j += k;
      i++;
    } 
    paramInt = 10 - j % 10;
    if (paramInt == 10)
      paramInt = bool; 
    paramStringBuilder.append(paramInt);
  }
  
  final void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
    int i;
    for (i = 0; i < 4; i++) {
      int j = c().a(i * 10 + paramInt1, 10);
      if (j / 100 == 0)
        paramStringBuilder.append('0'); 
      if (j / 10 == 0)
        paramStringBuilder.append('0'); 
      paramStringBuilder.append(j);
    } 
    a(paramStringBuilder, paramInt2);
  }
  
  final void b(StringBuilder paramStringBuilder, int paramInt) {
    paramStringBuilder.append("(01)");
    int i = paramStringBuilder.length();
    paramStringBuilder.append('9');
    a(paramStringBuilder, paramInt, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */