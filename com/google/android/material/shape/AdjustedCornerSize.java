package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class AdjustedCornerSize implements CornerSize {
  private final CornerSize a;
  
  private final float b;
  
  public AdjustedCornerSize(float paramFloat, CornerSize paramCornerSize) {
    while (paramCornerSize instanceof AdjustedCornerSize) {
      paramCornerSize = ((AdjustedCornerSize)paramCornerSize).a;
      paramFloat += ((AdjustedCornerSize)paramCornerSize).b;
    } 
    this.a = paramCornerSize;
    this.b = paramFloat;
  }
  
  public float a(RectF paramRectF) {
    return Math.max(0.0F, this.a.a(paramRectF) + this.b);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof AdjustedCornerSize))
      return false; 
    paramObject = paramObject;
    return (this.a.equals(((AdjustedCornerSize)paramObject).a) && this.b == ((AdjustedCornerSize)paramObject).b);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { this.a, Float.valueOf(this.b) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\AdjustedCornerSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */