package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
  private static Method a;
  
  private static boolean b;
  
  private static Method c;
  
  private static boolean d;
  
  private static Field e;
  
  private static boolean f;
  
  public static boolean getOverlapAnchor(PopupWindow paramPopupWindow) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramPopupWindow.getOverlapAnchor(); 
    if (Build.VERSION.SDK_INT >= 21) {
      if (!f) {
        try {
          e = PopupWindow.class.getDeclaredField("mOverlapAnchor");
          e.setAccessible(true);
        } catch (NoSuchFieldException noSuchFieldException) {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", noSuchFieldException);
        } 
        f = true;
      } 
      Field field = e;
      if (field != null)
        try {
          return ((Boolean)field.get(paramPopupWindow)).booleanValue();
        } catch (IllegalAccessException illegalAccessException) {
          Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", illegalAccessException);
        }  
    } 
    return false;
  }
  
  public static int getWindowLayoutType(PopupWindow paramPopupWindow) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramPopupWindow.getWindowLayoutType(); 
    if (!d) {
      try {
        c = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
        c.setAccessible(true);
      } catch (Exception exception) {}
      d = true;
    } 
    Method method = c;
    if (method != null)
      try {
        return ((Integer)method.invoke(paramPopupWindow, new Object[0])).intValue();
      } catch (Exception exception) {
        return 0;
      }  
    return 0;
  }
  
  public static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      if (!f) {
        try {
          e = PopupWindow.class.getDeclaredField("mOverlapAnchor");
          e.setAccessible(true);
        } catch (NoSuchFieldException noSuchFieldException) {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", noSuchFieldException);
        } 
        f = true;
      } 
      Field field = e;
      if (field != null)
        try {
          field.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          return;
        } catch (IllegalAccessException illegalAccessException) {
          Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", illegalAccessException);
        }  
    } 
  }
  
  public static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setWindowLayoutType(paramInt);
      return;
    } 
    if (!b) {
      try {
        a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { int.class });
        a.setAccessible(true);
      } catch (Exception exception) {}
      b = true;
    } 
    Method method = a;
    if (method != null)
      try {
        method.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3) {
    if (Build.VERSION.SDK_INT >= 19) {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
      return;
    } 
    int i = paramInt1;
    if ((GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(paramView)) & 0x7) == 5)
      i = paramInt1 - paramPopupWindow.getWidth() - paramView.getWidth(); 
    paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\PopupWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */