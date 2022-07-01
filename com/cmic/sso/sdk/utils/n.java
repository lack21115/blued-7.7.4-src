package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.res.Resources;

public class n {
  public static int a(Context paramContext, String paramString) {
    int i = a(paramContext, paramString, "drawable");
    if (i != 0)
      return i; 
    throw new Resources.NotFoundException(paramString);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2) {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, paramContext.getPackageName());
  }
  
  public static int b(Context paramContext, String paramString) {
    int i = a(paramContext, paramString, "anim");
    if (i != 0)
      return i; 
    throw new Resources.NotFoundException(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */