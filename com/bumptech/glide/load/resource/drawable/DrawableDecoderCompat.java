package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class DrawableDecoderCompat {
  private static volatile boolean a = true;
  
  public static Drawable a(Context paramContext, int paramInt, Resources.Theme paramTheme) {
    return a(paramContext, paramContext, paramInt, paramTheme);
  }
  
  public static Drawable a(Context paramContext1, Context paramContext2, int paramInt) {
    return a(paramContext1, paramContext2, paramInt, null);
  }
  
  private static Drawable a(Context paramContext1, Context paramContext2, int paramInt, Resources.Theme paramTheme) {
    Resources.Theme theme;
    try {
      if (a)
        return b(paramContext2, paramInt, paramTheme); 
    } catch (NoClassDefFoundError noClassDefFoundError) {
      a = false;
    } catch (IllegalStateException illegalStateException) {
      if (!noClassDefFoundError.getPackageName().equals(paramContext2.getPackageName()))
        return ContextCompat.getDrawable(paramContext2, paramInt); 
      throw illegalStateException;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {}
    if (illegalStateException == null)
      theme = paramContext2.getTheme(); 
    return c(paramContext2, paramInt, theme);
  }
  
  private static Drawable b(Context paramContext, int paramInt, Resources.Theme paramTheme) {
    ContextThemeWrapper contextThemeWrapper;
    Context context = paramContext;
    if (paramTheme != null)
      contextThemeWrapper = new ContextThemeWrapper(paramContext, paramTheme); 
    return AppCompatResources.getDrawable((Context)contextThemeWrapper, paramInt);
  }
  
  private static Drawable c(Context paramContext, int paramInt, Resources.Theme paramTheme) {
    return ResourcesCompat.getDrawable(paramContext.getResources(), paramInt, paramTheme);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\drawable\DrawableDecoderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */