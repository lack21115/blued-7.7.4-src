package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class MenuPopupHelper {
  public View mAnchorView;
  
  private final Context mContext;
  
  public int mDropDownGravity = 8388611;
  
  private boolean mForceShowIcon;
  
  private final PopupWindow.OnDismissListener mInternalOnDismissListener = new MenuPopupHelper$1(this);
  
  private final MenuBuilder mMenu;
  
  PopupWindow.OnDismissListener mOnDismissListener;
  
  private final boolean mOverflowOnly;
  
  private MenuPopup mPopup;
  
  private final int mPopupStyleAttr;
  
  private final int mPopupStyleRes;
  
  private MenuPresenter$Callback mPresenterCallback;
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt) {
    this(paramContext, paramMenuBuilder, paramView, paramBoolean, paramInt, 0);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt1, int paramInt2) {
    this.mContext = paramContext;
    this.mMenu = paramMenuBuilder;
    this.mAnchorView = paramView;
    this.mOverflowOnly = paramBoolean;
    this.mPopupStyleAttr = paramInt1;
    this.mPopupStyleRes = paramInt2;
  }
  
  public final void dismiss() {
    if (isShowing())
      this.mPopup.dismiss(); 
  }
  
  public final MenuPopup getPopup() {
    if (this.mPopup == null) {
      boolean bool;
      StandardMenuPopup standardMenuPopup;
      Display display = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      Point point = new Point();
      if (Build.VERSION.SDK_INT >= 17) {
        display.getRealSize(point);
      } else {
        display.getSize(point);
      } 
      if (Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        CascadingMenuPopup cascadingMenuPopup = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
      } else {
        standardMenuPopup = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
      } 
      standardMenuPopup.addMenu(this.mMenu);
      standardMenuPopup.setOnDismissListener(this.mInternalOnDismissListener);
      standardMenuPopup.setAnchorView(this.mAnchorView);
      standardMenuPopup.setCallback(this.mPresenterCallback);
      standardMenuPopup.setForceShowIcon(this.mForceShowIcon);
      standardMenuPopup.setGravity(this.mDropDownGravity);
      this.mPopup = standardMenuPopup;
    } 
    return this.mPopup;
  }
  
  public final boolean isShowing() {
    return (this.mPopup != null && this.mPopup.isShowing());
  }
  
  public void onDismiss() {
    this.mPopup = null;
    if (this.mOnDismissListener != null)
      this.mOnDismissListener.onDismiss(); 
  }
  
  public final void setForceShowIcon(boolean paramBoolean) {
    this.mForceShowIcon = paramBoolean;
    if (this.mPopup != null)
      this.mPopup.setForceShowIcon(paramBoolean); 
  }
  
  public final void setPresenterCallback(MenuPresenter$Callback paramMenuPresenter$Callback) {
    this.mPresenterCallback = paramMenuPresenter$Callback;
    if (this.mPopup != null)
      this.mPopup.setCallback(paramMenuPresenter$Callback); 
  }
  
  final void showPopup(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    MenuPopup menuPopup = getPopup();
    menuPopup.setShowTitle(paramBoolean2);
    if (paramBoolean1) {
      int i = paramInt1;
      if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 0x7) == 5)
        i = paramInt1 + this.mAnchorView.getWidth(); 
      menuPopup.setHorizontalOffset(i);
      menuPopup.setVerticalOffset(paramInt2);
      paramInt1 = (int)((this.mContext.getResources().getDisplayMetrics()).density * 48.0F / 2.0F);
      menuPopup.mEpicenterBounds = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
    } 
    menuPopup.show();
  }
  
  public final boolean tryShow() {
    if (isShowing())
      return true; 
    if (this.mAnchorView == null)
      return false; 
    showPopup(0, 0, false, false);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\MenuPopupHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */