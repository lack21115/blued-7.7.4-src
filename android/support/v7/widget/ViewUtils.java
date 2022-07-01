package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.lang.reflect.Method;

public final class ViewUtils {
  private static Method sComputeFitSystemWindowsMethod;
  
  static {
    if (Build.VERSION.SDK_INT >= 18)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchMethodException noSuchMethodException) {} 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void computeFitSystemWindows(View paramView, Rect paramRect1, Rect paramRect2) {
    if (sComputeFitSystemWindowsMethod != null)
      try {
        sComputeFitSystemWindowsMethod.invoke(paramView, new Object[] { paramRect1, paramRect2 });
        return;
      } catch (Exception exception) {} 
  }
  
  public static boolean isLayoutRtl(View paramView) {
    return (ViewCompat.getLayoutDirection(paramView) == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */