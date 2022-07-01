package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI013x0x1xDecoder extends AI01weightDecoder {
  private final String a;
  
  private final String b;
  
  AI013x0x1xDecoder(BitArray paramBitArray, String paramString1, String paramString2) {
    super(paramBitArray);
    this.a = paramString2;
    this.b = paramString1;
  }
  
  private void c(StringBuilder paramStringBuilder, int paramInt) {
    int i = c().a(paramInt, 16);
    if (i == 38400)
      return; 
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.a);
    paramStringBuilder.append(')');
    paramInt = i % 32;
    int j = i / 32;
    i = j % 12 + 1;
    j /= 12;
    if (j / 10 == 0)
      paramStringBuilder.append('0'); 
    paramStringBuilder.append(j);
    if (i / 10 == 0)
      paramStringBuilder.append('0'); 
    paramStringBuilder.append(i);
    if (paramInt / 10 == 0)
      paramStringBuilder.append('0'); 
    paramStringBuilder.append(paramInt);
  }
  
  protected int a(int paramInt) {
    return paramInt % 100000;
  }
  
  public String a() throws NotFoundException {
    if (b().a() == 84) {
      StringBuilder stringBuilder = new StringBuilder();
      b(stringBuilder, 8);
      b(stringBuilder, 48, 20);
      c(stringBuilder, 68);
      return stringBuilder.toString();
    } 
    throw NotFoundException.a();
  }
  
  protected void a(StringBuilder paramStringBuilder, int paramInt) {
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.b);
    paramStringBuilder.append(paramInt / 100000);
    paramStringBuilder.append(')');
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI013x0x1xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */