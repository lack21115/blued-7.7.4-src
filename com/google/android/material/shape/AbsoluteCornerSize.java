package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class AbsoluteCornerSize implements CornerSize {
  private final float a;
  
  public AbsoluteCornerSize(float paramFloat) {
    this.a = paramFloat;
  }
  
  public float a(RectF paramRectF) {
    return this.a;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof AbsoluteCornerSize))
      return false; 
    paramObject = paramObject;
    return (this.a == ((AbsoluteCornerSize)paramObject).a);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { Float.valueOf(this.a) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\AbsoluteCornerSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */