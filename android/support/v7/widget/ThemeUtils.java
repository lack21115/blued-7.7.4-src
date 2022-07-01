package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

final class ThemeUtils {
  static final int[] CHECKED_STATE_SET;
  
  static final int[] DISABLED_STATE_SET;
  
  static final int[] EMPTY_STATE_SET;
  
  static final int[] FOCUSED_STATE_SET;
  
  static final int[] PRESSED_STATE_SET;
  
  private static final int[] TEMP_ARRAY;
  
  private static final ThreadLocal TL_TYPED_VALUE = new ThreadLocal();
  
  static {
    DISABLED_STATE_SET = new int[] { -16842910 };
    FOCUSED_STATE_SET = new int[] { 16842908 };
    PRESSED_STATE_SET = new int[] { 16842919 };
    CHECKED_STATE_SET = new int[] { 16842912 };
    EMPTY_STATE_SET = new int[0];
    TEMP_ARRAY = new int[1];
    throw new VerifyError("bad dex opcode");
  }
  
  public static int getDisabledThemeAttrColor(Context paramContext, int paramInt) {
    ColorStateList colorStateList = getThemeAttrColorStateList(paramContext, paramInt);
    if (colorStateList != null && colorStateList.isStateful())
      return colorStateList.getColorForState(DISABLED_STATE_SET, colorStateList.getDefaultColor()); 
    TypedValue typedValue2 = TL_TYPED_VALUE.get();
    TypedValue typedValue1 = typedValue2;
    if (typedValue2 == null) {
      typedValue1 = new TypedValue();
      TL_TYPED_VALUE.set(typedValue1);
    } 
    paramContext.getTheme().resolveAttribute(16842803, typedValue1, true);
    float f = typedValue1.getFloat();
    paramInt = getThemeAttrColor(paramContext, paramInt);
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * f));
  }
  
  public static int getThemeAttrColor(Context paramContext, int paramInt) {
    TEMP_ARRAY[0] = paramInt;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, (AttributeSet)null, TEMP_ARRAY);
    try {
      paramInt = tintTypedArray.getColor(0, 0);
      return paramInt;
    } finally {
      tintTypedArray.mWrapped.recycle();
    } 
  }
  
  public static ColorStateList getThemeAttrColorStateList(Context paramContext, int paramInt) {
    TEMP_ARRAY[0] = paramInt;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, (AttributeSet)null, TEMP_ARRAY);
    try {
      return tintTypedArray.getColorStateList(0);
    } finally {
      tintTypedArray.mWrapped.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ThemeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */