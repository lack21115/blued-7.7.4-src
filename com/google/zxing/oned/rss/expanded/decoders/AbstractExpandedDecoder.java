package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public abstract class AbstractExpandedDecoder {
  private final BitArray a;
  
  private final GeneralAppIdDecoder b;
  
  AbstractExpandedDecoder(BitArray paramBitArray) {
    this.a = paramBitArray;
    this.b = new GeneralAppIdDecoder(paramBitArray);
  }
  
  public static AbstractExpandedDecoder a(BitArray paramBitArray) {
    if (paramBitArray.a(1))
      return new AI01AndOtherAIs(paramBitArray); 
    if (!paramBitArray.a(2))
      return new AnyAIDecoder(paramBitArray); 
    int i = GeneralAppIdDecoder.a(paramBitArray, 1, 4);
    if (i != 4) {
      if (i != 5) {
        i = GeneralAppIdDecoder.a(paramBitArray, 1, 5);
        if (i != 12) {
          if (i != 13) {
            switch (GeneralAppIdDecoder.a(paramBitArray, 1, 7)) {
              default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(paramBitArray)));
              case 63:
                return new AI013x0x1xDecoder(paramBitArray, "320", "17");
              case 62:
                return new AI013x0x1xDecoder(paramBitArray, "310", "17");
              case 61:
                return new AI013x0x1xDecoder(paramBitArray, "320", "15");
              case 60:
                return new AI013x0x1xDecoder(paramBitArray, "310", "15");
              case 59:
                return new AI013x0x1xDecoder(paramBitArray, "320", "13");
              case 58:
                return new AI013x0x1xDecoder(paramBitArray, "310", "13");
              case 57:
                return new AI013x0x1xDecoder(paramBitArray, "320", "11");
              case 56:
                break;
            } 
            return new AI013x0x1xDecoder(paramBitArray, "310", "11");
          } 
          return new AI01393xDecoder(paramBitArray);
        } 
        return new AI01392xDecoder(paramBitArray);
      } 
      return new AI01320xDecoder(paramBitArray);
    } 
    return new AI013103decoder(paramBitArray);
  }
  
  public abstract String a() throws NotFoundException, FormatException;
  
  protected final BitArray b() {
    return this.a;
  }
  
  protected final GeneralAppIdDecoder c() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AbstractExpandedDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */