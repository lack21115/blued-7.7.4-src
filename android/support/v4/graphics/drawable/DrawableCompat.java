package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class DrawableCompat {
  private static Method sGetLayoutDirectionMethod;
  
  private static boolean sGetLayoutDirectionMethodFetched;
  
  public static void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme) {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.applyTheme(paramTheme); 
  }
  
  public static boolean canApplyTheme(Drawable paramDrawable) {
    return (Build.VERSION.SDK_INT >= 21) ? paramDrawable.canApplyTheme() : false;
  }
  
  public static int getAlpha(Drawable paramDrawable) {
    return (Build.VERSION.SDK_INT >= 19) ? paramDrawable.getAlpha() : 0;
  }
  
  public static int getLayoutDirection(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramDrawable.getLayoutDirection(); 
    if (Build.VERSION.SDK_INT >= 17) {
      if (!sGetLayoutDirectionMethodFetched) {
        try {
          Method method = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
          sGetLayoutDirectionMethod = method;
          method.setAccessible(true);
        } catch (NoSuchMethodException noSuchMethodException) {
          Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", noSuchMethodException);
        } 
        sGetLayoutDirectionMethodFetched = true;
      } 
      if (sGetLayoutDirectionMethod != null)
        try {
          return ((Integer)sGetLayoutDirectionMethod.invoke(paramDrawable, new Object[0])).intValue();
        } catch (Exception exception) {
          Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", exception);
          sGetLayoutDirectionMethod = null;
        }  
      return 0;
    } 
    return 0;
  }
  
  public static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable) {
    return (Build.VERSION.SDK_INT >= 19) ? paramDrawable.isAutoMirrored() : false;
  }
  
  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 19)
      paramDrawable.setAutoMirrored(paramBoolean); 
  }
  
  public static void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2) {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setHotspot(paramFloat1, paramFloat2); 
  }
  
  public static void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public static void setTint(Drawable paramDrawable, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTint(paramInt);
      return;
    } 
    if (paramDrawable instanceof TintAwareDrawable)
      ((TintAwareDrawable)paramDrawable).setTint(paramInt); 
  }
  
  public static void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTintList(paramColorStateList);
      return;
    } 
    if (paramDrawable instanceof TintAwareDrawable)
      ((TintAwareDrawable)paramDrawable).setTintList(paramColorStateList); 
  }
  
  public static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTintMode(paramMode);
      return;
    } 
    if (paramDrawable instanceof TintAwareDrawable)
      ((TintAwareDrawable)paramDrawable).setTintMode(paramMode); 
  }
  
  public static Drawable wrap(Drawable paramDrawable) {
    return (Build.VERSION.SDK_INT >= 23) ? paramDrawable : ((Build.VERSION.SDK_INT >= 21) ? (!(paramDrawable instanceof TintAwareDrawable) ? new DrawableWrapperApi21(paramDrawable) : paramDrawable) : ((Build.VERSION.SDK_INT >= 19) ? (!(paramDrawable instanceof TintAwareDrawable) ? new DrawableWrapperApi19(paramDrawable) : paramDrawable) : (!(paramDrawable instanceof TintAwareDrawable) ? new DrawableWrapperApi14(paramDrawable) : paramDrawable)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */