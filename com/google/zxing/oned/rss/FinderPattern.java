package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern {
  private final int a;
  
  private final int[] b;
  
  private final ResultPoint[] c;
  
  public FinderPattern(int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3, int paramInt4) {
    this.a = paramInt1;
    this.b = paramArrayOfint;
    float f1 = paramInt2;
    float f2 = paramInt4;
    this.c = new ResultPoint[] { new ResultPoint(f1, f2), new ResultPoint(paramInt3, f2) };
  }
  
  public int a() {
    return this.a;
  }
  
  public int[] b() {
    return this.b;
  }
  
  public ResultPoint[] c() {
    return this.c;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof FinderPattern))
      return false; 
    paramObject = paramObject;
    return (this.a == ((FinderPattern)paramObject).a);
  }
  
  public int hashCode() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\FinderPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */