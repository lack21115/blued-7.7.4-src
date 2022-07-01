package com.google.android.material.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

public final class DrawableUtils {
  public static PorterDuffColorFilter a(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode) {
    return (paramColorStateList == null || paramMode == null) ? null : new PorterDuffColorFilter(paramColorStateList.getColorForState(paramDrawable.getState(), 0), paramMode);
  }
  
  public static void a(RippleDrawable paramRippleDrawable, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23) {
      paramRippleDrawable.setRadius(paramInt);
      return;
    } 
    try {
      RippleDrawable.class.getDeclaredMethod("setMaxRadius", new Class[] { int.class }).invoke(paramRippleDrawable, new Object[] { Integer.valueOf(paramInt) });
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    throw new IllegalStateException("Couldn't set RippleDrawable radius", illegalAccessException);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\drawable\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */