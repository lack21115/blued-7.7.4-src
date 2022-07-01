package com.github.chrisbanes.photoview;

import android.widget.ImageView;

class Util {
  static int a(int paramInt) {
    return (paramInt & 0xFF00) >> 8;
  }
  
  static void a(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (paramFloat1 < paramFloat2) {
      if (paramFloat2 < paramFloat3)
        return; 
      throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    } 
    throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
  }
  
  static boolean a(ImageView.ScaleType paramScaleType) {
    if (paramScaleType == null)
      return false; 
    if (null.a[paramScaleType.ordinal()] != 1)
      return true; 
    throw new IllegalStateException("Matrix scale type is not supported");
  }
  
  static boolean a(ImageView paramImageView) {
    return (paramImageView.getDrawable() != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\chrisbanes\photoview\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */