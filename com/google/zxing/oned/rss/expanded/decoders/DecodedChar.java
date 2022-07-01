package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedChar extends DecodedObject {
  private final char a;
  
  DecodedChar(int paramInt, char paramChar) {
    super(paramInt);
    this.a = paramChar;
  }
  
  char a() {
    return this.a;
  }
  
  boolean b() {
    return (this.a == '$');
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedChar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */