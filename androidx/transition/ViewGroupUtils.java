package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.Method;

class ViewGroupUtils {
  private static boolean a = true;
  
  private static Method b;
  
  private static boolean c;
  
  static int a(ViewGroup paramViewGroup, int paramInt) {
    if (Build.VERSION.SDK_INT >= 29)
      return paramViewGroup.getChildDrawingOrder(paramInt); 
    if (!c) {
      try {
        b = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[] { int.class, int.class });
        b.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {}
      c = true;
    } 
    Method method = b;
    if (method != null)
      try {
        return ((Integer)method.invoke(paramViewGroup, new Object[] { Integer.valueOf(paramViewGroup.getChildCount()), Integer.valueOf(paramInt) })).intValue();
      } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
        return paramInt;
      }  
    return paramInt;
  }
  
  static ViewGroupOverlayImpl a(ViewGroup paramViewGroup) {
    return (ViewGroupOverlayImpl)((Build.VERSION.SDK_INT >= 18) ? new ViewGroupOverlayApi18(paramViewGroup) : ViewGroupOverlayApi14.a(paramViewGroup));
  }
  
  static void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 29) {
      paramViewGroup.suppressLayout(paramBoolean);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 18) {
      b(paramViewGroup, paramBoolean);
      return;
    } 
    ViewGroupUtilsApi14.a(paramViewGroup, paramBoolean);
  }
  
  private static void b(ViewGroup paramViewGroup, boolean paramBoolean) {
    if (a)
      try {
        paramViewGroup.suppressLayout(paramBoolean);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        a = false;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewGroupUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */