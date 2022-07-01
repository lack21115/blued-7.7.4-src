package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import java.lang.reflect.Method;

public final class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
  public static Method sSetTouchModalMethod;
  
  public MenuItemHoverListener mHoverListener;
  
  static {
    try {
      Class<boolean> clazz = boolean.class;
      throw new VerifyError("bad dex opcode");
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public MenuPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  final DropDownListView createDropDownListView(Context paramContext, boolean paramBoolean) {
    MenuPopupWindow$MenuDropDownListView menuPopupWindow$MenuDropDownListView = new MenuPopupWindow$MenuDropDownListView(paramContext, paramBoolean);
    menuPopupWindow$MenuDropDownListView.mHoverListener = this;
    return menuPopupWindow$MenuDropDownListView;
  }
  
  public final void onItemHoverEnter(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    if (this.mHoverListener != null)
      this.mHoverListener.onItemHoverEnter(paramMenuBuilder, paramMenuItem); 
  }
  
  public final void onItemHoverExit(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    if (this.mHoverListener != null)
      this.mHoverListener.onItemHoverExit(paramMenuBuilder, paramMenuItem); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\MenuPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */