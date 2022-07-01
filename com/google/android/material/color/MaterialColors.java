package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors {
  public static int a(int paramInt1, int paramInt2) {
    return ColorUtils.compositeColors(paramInt2, paramInt1);
  }
  
  public static int a(int paramInt1, int paramInt2, float paramFloat) {
    return a(paramInt1, ColorUtils.setAlphaComponent(paramInt2, Math.round(Color.alpha(paramInt2) * paramFloat)));
  }
  
  public static int a(Context paramContext, int paramInt1, int paramInt2) {
    TypedValue typedValue = MaterialAttributes.a(paramContext, paramInt1);
    return (typedValue != null) ? typedValue.data : paramInt2;
  }
  
  public static int a(Context paramContext, int paramInt, String paramString) {
    return MaterialAttributes.a(paramContext, paramInt, paramString);
  }
  
  public static int a(View paramView, int paramInt) {
    return MaterialAttributes.a(paramView, paramInt);
  }
  
  public static int a(View paramView, int paramInt1, int paramInt2) {
    return a(paramView.getContext(), paramInt1, paramInt2);
  }
  
  public static int a(View paramView, int paramInt1, int paramInt2, float paramFloat) {
    return a(a(paramView, paramInt1), a(paramView, paramInt2), paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\color\MaterialColors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */