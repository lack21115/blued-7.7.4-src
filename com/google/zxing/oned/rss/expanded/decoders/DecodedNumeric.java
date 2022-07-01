package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

final class DecodedNumeric extends DecodedObject {
  private final int a;
  
  private final int b;
  
  DecodedNumeric(int paramInt1, int paramInt2, int paramInt3) throws FormatException {
    super(paramInt1);
    if (paramInt2 >= 0 && paramInt2 <= 10 && paramInt3 >= 0 && paramInt3 <= 10) {
      this.a = paramInt2;
      this.b = paramInt3;
      return;
    } 
    throw FormatException.a();
  }
  
  int a() {
    return this.a;
  }
  
  int b() {
    return this.b;
  }
  
  boolean c() {
    return (this.a == 10);
  }
  
  boolean d() {
    return (this.b == 10);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedNumeric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */