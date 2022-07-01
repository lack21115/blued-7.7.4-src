package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;

public class ElevationOverlayProvider {
  private final boolean a;
  
  private final int b;
  
  private final int c;
  
  private final float d;
  
  public ElevationOverlayProvider(Context paramContext) {
    this.a = MaterialAttributes.a(paramContext, R.attr.elevationOverlayEnabled, false);
    this.b = MaterialColors.a(paramContext, R.attr.elevationOverlayColor, 0);
    this.c = MaterialColors.a(paramContext, R.attr.colorSurface, 0);
    this.d = (paramContext.getResources().getDisplayMetrics()).density;
  }
  
  private boolean a(int paramInt) {
    return (ColorUtils.setAlphaComponent(paramInt, 255) == this.c);
  }
  
  public float a(float paramFloat) {
    float f = this.d;
    return (f > 0.0F) ? ((paramFloat <= 0.0F) ? 0.0F : Math.min(((float)Math.log1p((paramFloat / f)) * 4.5F + 2.0F) / 100.0F, 1.0F)) : 0.0F;
  }
  
  public int a(int paramInt, float paramFloat) {
    int i = paramInt;
    if (this.a) {
      i = paramInt;
      if (a(paramInt))
        i = b(paramInt, paramFloat); 
    } 
    return i;
  }
  
  public boolean a() {
    return this.a;
  }
  
  public int b(int paramInt, float paramFloat) {
    paramFloat = a(paramFloat);
    int i = Color.alpha(paramInt);
    return ColorUtils.setAlphaComponent(MaterialColors.a(ColorUtils.setAlphaComponent(paramInt, 255), this.b, paramFloat), i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\elevation\ElevationOverlayProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */