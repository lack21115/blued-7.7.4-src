package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

public class MaterialAttributes {
  public static int a(Context paramContext, int paramInt, String paramString) {
    TypedValue typedValue = a(paramContext, paramInt);
    if (typedValue != null)
      return typedValue.data; 
    throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[] { paramString, paramContext.getResources().getResourceName(paramInt) }));
  }
  
  public static int a(View paramView, int paramInt) {
    return a(paramView.getContext(), paramInt, paramView.getClass().getCanonicalName());
  }
  
  public static TypedValue a(Context paramContext, int paramInt) {
    TypedValue typedValue = new TypedValue();
    return paramContext.getTheme().resolveAttribute(paramInt, typedValue, true) ? typedValue : null;
  }
  
  public static boolean a(Context paramContext, int paramInt, boolean paramBoolean) {
    TypedValue typedValue = a(paramContext, paramInt);
    boolean bool = paramBoolean;
    if (typedValue != null) {
      bool = paramBoolean;
      if (typedValue.type == 18) {
        if (typedValue.data != 0)
          return true; 
        bool = false;
      } 
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\resources\MaterialAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */