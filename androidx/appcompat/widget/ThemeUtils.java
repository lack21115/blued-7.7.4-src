package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;

class ThemeUtils {
  static final int[] a;
  
  static final int[] b;
  
  static final int[] c;
  
  static final int[] d;
  
  static final int[] e;
  
  static final int[] f;
  
  static final int[] g;
  
  static final int[] h;
  
  private static final ThreadLocal<TypedValue> i = new ThreadLocal<TypedValue>();
  
  private static final int[] j;
  
  static {
    a = new int[] { -16842910 };
    b = new int[] { 16842908 };
    c = new int[] { 16843518 };
    d = new int[] { 16842919 };
    e = new int[] { 16842912 };
    f = new int[] { 16842913 };
    g = new int[] { -16842919, -16842908 };
    h = new int[0];
    j = new int[1];
  }
  
  static int a(Context paramContext, int paramInt, float paramFloat) {
    paramInt = getThemeAttrColor(paramContext, paramInt);
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  private static TypedValue a() {
    TypedValue typedValue2 = i.get();
    TypedValue typedValue1 = typedValue2;
    if (typedValue2 == null) {
      typedValue1 = new TypedValue();
      i.set(typedValue1);
    } 
    return typedValue1;
  }
  
  public static ColorStateList createDisabledStateList(int paramInt1, int paramInt2) {
    return new ColorStateList(new int[][] { a, h }, new int[] { paramInt2, paramInt1 });
  }
  
  public static int getDisabledThemeAttrColor(Context paramContext, int paramInt) {
    ColorStateList colorStateList = getThemeAttrColorStateList(paramContext, paramInt);
    if (colorStateList != null && colorStateList.isStateful())
      return colorStateList.getColorForState(a, colorStateList.getDefaultColor()); 
    TypedValue typedValue = a();
    paramContext.getTheme().resolveAttribute(16842803, typedValue, true);
    return a(paramContext, paramInt, typedValue.getFloat());
  }
  
  public static int getThemeAttrColor(Context paramContext, int paramInt) {
    null = j;
    null[0] = paramInt;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, (AttributeSet)null, null);
    try {
      paramInt = tintTypedArray.getColor(0, 0);
      return paramInt;
    } finally {
      tintTypedArray.recycle();
    } 
  }
  
  public static ColorStateList getThemeAttrColorStateList(Context paramContext, int paramInt) {
    null = j;
    null[0] = paramInt;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, (AttributeSet)null, null);
    try {
      return tintTypedArray.getColorStateList(0);
    } finally {
      tintTypedArray.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ThemeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */