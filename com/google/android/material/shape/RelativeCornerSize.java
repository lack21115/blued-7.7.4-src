package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class RelativeCornerSize implements CornerSize {
  private final float a;
  
  public RelativeCornerSize(float paramFloat) {
    this.a = paramFloat;
  }
  
  public float a(RectF paramRectF) {
    return this.a * paramRectF.height();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof RelativeCornerSize))
      return false; 
    paramObject = paramObject;
    return (this.a == ((RelativeCornerSize)paramObject).a);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { Float.valueOf(this.a) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\RelativeCornerSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */