package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class GhostViewPlatform implements GhostView {
  private static Class<?> a;
  
  private static boolean b;
  
  private static Method c;
  
  private static boolean d;
  
  private static Method e;
  
  private static boolean f;
  
  private final View g;
  
  private GhostViewPlatform(View paramView) {
    this.g = paramView;
  }
  
  static GhostView a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix) {
    b();
    Method method = c;
    if (method != null)
      try {
        return new GhostViewPlatform((View)method.invoke((Object)null, new Object[] { paramView, paramViewGroup, paramMatrix }));
      } catch (IllegalAccessException illegalAccessException) {
        return null;
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      }  
    return null;
  }
  
  private static void a() {
    if (!b) {
      try {
        a = Class.forName("android.view.GhostView");
      } catch (ClassNotFoundException classNotFoundException) {
        Log.i("GhostViewApi21", "Failed to retrieve GhostView class", classNotFoundException);
      } 
      b = true;
    } 
  }
  
  static void a(View paramView) {
    c();
    Method method = e;
    if (method != null)
      try {
        method.invoke((Object)null, new Object[] { paramView });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        return;
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      }  
  }
  
  private static void b() {
    if (!d) {
      try {
        a();
        c = a.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
        c.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("GhostViewApi21", "Failed to retrieve addGhost method", noSuchMethodException);
      } 
      d = true;
    } 
  }
  
  private static void c() {
    if (!f) {
      try {
        a();
        e = a.getDeclaredMethod("removeGhost", new Class[] { View.class });
        e.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", noSuchMethodException);
      } 
      f = true;
    } 
  }
  
  public void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView) {}
  
  public void setVisibility(int paramInt) {
    this.g.setVisibility(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\GhostViewPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */