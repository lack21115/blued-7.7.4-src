package com.google.android.material.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

public class ContextUtils {
  public static Activity a(Context paramContext) {
    while (paramContext instanceof ContextWrapper) {
      if (paramContext instanceof Activity)
        return (Activity)paramContext; 
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ContextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */