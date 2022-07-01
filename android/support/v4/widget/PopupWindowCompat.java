package android.support.v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

public final class PopupWindowCompat {
  private static PopupWindowCompat$PopupWindowCompatBaseImpl IMPL = new PopupWindowCompat$PopupWindowCompatBaseImpl();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {
    IMPL.setOverlapAnchor(paramPopupWindow, paramBoolean);
  }
  
  public static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt) {
    IMPL.setWindowLayoutType(paramPopupWindow, paramInt);
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3) {
    IMPL.showAsDropDown(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 23) {
      IMPL = new PopupWindowCompat$PopupWindowCompatApi23Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new PopupWindowCompat$PopupWindowCompatApi21Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new PopupWindowCompat$PopupWindowCompatApi19Impl();
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\PopupWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */