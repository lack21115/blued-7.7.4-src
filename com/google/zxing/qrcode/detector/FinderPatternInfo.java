package com.google.zxing.qrcode.detector;

public final class FinderPatternInfo {
  private final FinderPattern a;
  
  private final FinderPattern b;
  
  private final FinderPattern c;
  
  public FinderPatternInfo(FinderPattern[] paramArrayOfFinderPattern) {
    this.a = paramArrayOfFinderPattern[0];
    this.b = paramArrayOfFinderPattern[1];
    this.c = paramArrayOfFinderPattern[2];
  }
  
  public FinderPattern a() {
    return this.a;
  }
  
  public FinderPattern b() {
    return this.b;
  }
  
  public FinderPattern c() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\detector\FinderPatternInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */