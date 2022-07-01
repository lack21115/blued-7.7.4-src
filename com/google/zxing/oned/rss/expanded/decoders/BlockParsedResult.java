package com.google.zxing.oned.rss.expanded.decoders;

final class BlockParsedResult {
  private final DecodedInformation a;
  
  private final boolean b;
  
  BlockParsedResult(DecodedInformation paramDecodedInformation, boolean paramBoolean) {
    this.b = paramBoolean;
    this.a = paramDecodedInformation;
  }
  
  BlockParsedResult(boolean paramBoolean) {
    this(null, paramBoolean);
  }
  
  DecodedInformation a() {
    return this.a;
  }
  
  boolean b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\BlockParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */