package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;

public class MaterialResources {
  public static int a(Context paramContext, TypedArray paramTypedArray, int paramInt1, int paramInt2) {
    TypedValue typedValue = new TypedValue();
    if (!paramTypedArray.getValue(paramInt1, typedValue) || typedValue.type != 2)
      return paramTypedArray.getDimensionPixelSize(paramInt1, paramInt2); 
    TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(new int[] { typedValue.data });
    paramInt1 = typedArray.getDimensionPixelSize(0, paramInt2);
    typedArray.recycle();
    return paramInt1;
  }
  
  static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2) {
    return paramTypedArray.hasValue(paramInt1) ? paramInt1 : paramInt2;
  }
  
  public static ColorStateList a(Context paramContext, TypedArray paramTypedArray, int paramInt) {
    if (paramTypedArray.hasValue(paramInt)) {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(paramContext, i);
        if (colorStateList != null)
          return colorStateList; 
      } 
    } 
    if (Build.VERSION.SDK_INT <= 15) {
      int i = paramTypedArray.getColor(paramInt, -1);
      if (i != -1)
        return ColorStateList.valueOf(i); 
    } 
    return paramTypedArray.getColorStateList(paramInt);
  }
  
  public static ColorStateList a(Context paramContext, TintTypedArray paramTintTypedArray, int paramInt) {
    if (paramTintTypedArray.hasValue(paramInt)) {
      int i = paramTintTypedArray.getResourceId(paramInt, 0);
      if (i != 0) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(paramContext, i);
        if (colorStateList != null)
          return colorStateList; 
      } 
    } 
    if (Build.VERSION.SDK_INT <= 15) {
      int i = paramTintTypedArray.getColor(paramInt, -1);
      if (i != -1)
        return ColorStateList.valueOf(i); 
    } 
    return paramTintTypedArray.getColorStateList(paramInt);
  }
  
  public static Drawable b(Context paramContext, TypedArray paramTypedArray, int paramInt) {
    if (paramTypedArray.hasValue(paramInt)) {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0) {
        Drawable drawable = AppCompatResources.getDrawable(paramContext, i);
        if (drawable != null)
          return drawable; 
      } 
    } 
    return paramTypedArray.getDrawable(paramInt);
  }
  
  public static TextAppearance c(Context paramContext, TypedArray paramTypedArray, int paramInt) {
    if (paramTypedArray.hasValue(paramInt)) {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0)
        return new TextAppearance(paramContext, paramInt); 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\resources\MaterialResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */