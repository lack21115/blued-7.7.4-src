package com.scwang.smartrefresh.layout.util;

import android.view.animation.Interpolator;

public class ViscousFluidInterpolator implements Interpolator {
  private static final float a = 1.0F / a(1.0F);
  
  private static final float b = 1.0F - a * a(1.0F);
  
  private static float a(float paramFloat) {
    paramFloat *= 8.0F;
    return (paramFloat < 1.0F) ? (paramFloat - 1.0F - (float)Math.exp(-paramFloat)) : ((1.0F - (float)Math.exp((1.0F - paramFloat))) * 0.63212055F + 0.36787945F);
  }
  
  public float getInterpolation(float paramFloat) {
    float f = a * a(paramFloat);
    paramFloat = f;
    if (f > 0.0F)
      paramFloat = f + b; 
    return paramFloat;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layou\\util\ViscousFluidInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */