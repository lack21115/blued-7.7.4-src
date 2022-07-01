package com.google.android.material.theme.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.R;

public class MaterialThemeOverlay {
  private static final int[] a = new int[] { 16842752, R.attr.theme };
  
  private static final int[] b = new int[] { R.attr.materialThemeOverlay };
  
  private static int a(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    int j = typedArray.getResourceId(0, 0);
    int i = typedArray.getResourceId(1, 0);
    typedArray.recycle();
    if (j != 0)
      i = j; 
    return i;
  }
  
  public static Context a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    paramInt2 = b(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (paramContext instanceof ContextThemeWrapper && ((ContextThemeWrapper)paramContext).getThemeResId() == paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    if (paramInt2 != 0) {
      if (paramInt1 != 0)
        return paramContext; 
      ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(paramContext, paramInt2);
      paramInt1 = a(paramContext, paramAttributeSet);
      if (paramInt1 != 0)
        contextThemeWrapper.getTheme().applyStyle(paramInt1, true); 
      return (Context)contextThemeWrapper;
    } 
    return paramContext;
  }
  
  private static int b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, b, paramInt1, paramInt2);
    paramInt1 = typedArray.getResourceId(0, 0);
    typedArray.recycle();
    return paramInt1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\theme\overlay\MaterialThemeOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */