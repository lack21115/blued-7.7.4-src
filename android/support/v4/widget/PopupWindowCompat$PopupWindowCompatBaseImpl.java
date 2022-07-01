package android.support.v4.widget;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

class PopupWindowCompat$PopupWindowCompatBaseImpl {
  private static Method sSetWindowLayoutTypeMethod;
  
  private static boolean sSetWindowLayoutTypeMethodAttempted;
  
  public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {}
  
  public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt) {
    if (!sSetWindowLayoutTypeMethodAttempted) {
      try {
        Method method = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { int.class });
        sSetWindowLayoutTypeMethod = method;
        method.setAccessible(true);
      } catch (Exception exception) {}
      sSetWindowLayoutTypeMethodAttempted = true;
    } 
    if (sSetWindowLayoutTypeMethod != null)
      try {
        sSetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
        return;
      } catch (Exception exception) {} 
  }
  
  public void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt1;
    if ((GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(paramView)) & 0x7) == 5)
      i = paramInt1 - paramPopupWindow.getWidth() - paramView.getWidth(); 
    paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\PopupWindowCompat$PopupWindowCompatBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */