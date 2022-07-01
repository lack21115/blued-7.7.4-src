package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

public final class ThemeEnforcement {
  private static final int[] a = new int[] { R.attr.colorPrimary };
  
  private static final int[] b = new int[] { R.attr.colorPrimaryVariant };
  
  public static TypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfint1, int paramInt1, int paramInt2, int... paramVarArgs1) {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfint1, paramInt1, paramInt2, paramVarArgs1);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfint1, paramInt1, paramInt2);
  }
  
  public static void a(Context paramContext) {
    a(paramContext, a, "Theme.AppCompat");
  }
  
  private static void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = typedArray.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
    typedArray.recycle();
    if (bool) {
      TypedValue typedValue = new TypedValue();
      if (!paramContext.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0))
        b(paramContext); 
    } 
    a(paramContext);
  }
  
  private static void a(Context paramContext, int[] paramArrayOfint, String paramString) {
    if (a(paramContext, paramArrayOfint))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("The style on this component requires your app theme to be ");
    stringBuilder.append(paramString);
    stringBuilder.append(" (or a descendant).");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static boolean a(Context paramContext, int[] paramArrayOfint) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramArrayOfint);
    for (int i = 0; i < paramArrayOfint.length; i++) {
      if (!typedArray.hasValue(i)) {
        typedArray.recycle();
        return false;
      } 
    } 
    typedArray.recycle();
    return true;
  }
  
  public static TintTypedArray b(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfint1, int paramInt1, int paramInt2, int... paramVarArgs1) {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfint1, paramInt1, paramInt2, paramVarArgs1);
    return TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, paramArrayOfint1, paramInt1, paramInt2);
  }
  
  public static void b(Context paramContext) {
    a(paramContext, b, "Theme.MaterialComponents");
  }
  
  private static void c(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfint1, int paramInt1, int paramInt2, int... paramVarArgs1) {
    boolean bool;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    if (!typedArray.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
      typedArray.recycle();
      return;
    } 
    if (paramVarArgs1 == null || paramVarArgs1.length == 0) {
      if (typedArray.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
    } else {
      bool = d(paramContext, paramAttributeSet, paramArrayOfint1, paramInt1, paramInt2, paramVarArgs1);
    } 
    typedArray.recycle();
    if (bool)
      return; 
    throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
  }
  
  private static boolean d(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfint1, int paramInt1, int paramInt2, int... paramVarArgs1) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfint1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs1.length;
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      if (typedArray.getResourceId(paramVarArgs1[paramInt1], -1) == -1) {
        typedArray.recycle();
        return false;
      } 
    } 
    typedArray.recycle();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ThemeEnforcement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */