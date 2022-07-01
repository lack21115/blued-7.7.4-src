package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedInformation extends DecodedObject {
  private final String a;
  
  private final int b;
  
  private final boolean c;
  
  DecodedInformation(int paramInt, String paramString) {
    super(paramInt);
    this.a = paramString;
    this.c = false;
    this.b = 0;
  }
  
  DecodedInformation(int paramInt1, String paramString, int paramInt2) {
    super(paramInt1);
    this.c = true;
    this.b = paramInt2;
    this.a = paramString;
  }
  
  String a() {
    return this.a;
  }
  
  boolean b() {
    return this.c;
  }
  
  int c() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */