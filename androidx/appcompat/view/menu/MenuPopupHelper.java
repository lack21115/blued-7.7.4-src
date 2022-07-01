package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class MenuPopupHelper implements MenuHelper {
  private final Context a;
  
  private final MenuBuilder b;
  
  private final boolean c;
  
  private final int d;
  
  private final int e;
  
  private View f;
  
  private int g = 8388611;
  
  private boolean h;
  
  private MenuPresenter.Callback i;
  
  private MenuPopup j;
  
  private PopupWindow.OnDismissListener k;
  
  private final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener(this) {
      public void onDismiss() {
        this.a.a();
      }
    };
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder) {
    this(paramContext, paramMenuBuilder, null, false, R.attr.popupMenuStyle, 0);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView) {
    this(paramContext, paramMenuBuilder, paramView, false, R.attr.popupMenuStyle, 0);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt) {
    this(paramContext, paramMenuBuilder, paramView, paramBoolean, paramInt, 0);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt1, int paramInt2) {
    this.a = paramContext;
    this.b = paramMenuBuilder;
    this.f = paramView;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    MenuPopup menuPopup = getPopup();
    menuPopup.setShowTitle(paramBoolean2);
    if (paramBoolean1) {
      int i = paramInt1;
      if ((GravityCompat.getAbsoluteGravity(this.g, ViewCompat.getLayoutDirection(this.f)) & 0x7) == 5)
        i = paramInt1 - this.f.getWidth(); 
      menuPopup.setHorizontalOffset(i);
      menuPopup.setVerticalOffset(paramInt2);
      paramInt1 = (int)((this.a.getResources().getDisplayMetrics()).density * 48.0F / 2.0F);
      menuPopup.setEpicenterBounds(new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1));
    } 
    menuPopup.show();
  }
  
  private MenuPopup b() {
    boolean bool;
    StandardMenuPopup standardMenuPopup;
    Display display = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
    Point point = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      display.getRealSize(point);
    } else {
      display.getSize(point);
    } 
    if (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      CascadingMenuPopup cascadingMenuPopup = new CascadingMenuPopup(this.a, this.f, this.d, this.e, this.c);
    } else {
      standardMenuPopup = new StandardMenuPopup(this.a, this.b, this.f, this.d, this.e, this.c);
    } 
    standardMenuPopup.addMenu(this.b);
    standardMenuPopup.setOnDismissListener(this.l);
    standardMenuPopup.setAnchorView(this.f);
    standardMenuPopup.setCallback(this.i);
    standardMenuPopup.setForceShowIcon(this.h);
    standardMenuPopup.setGravity(this.g);
    return standardMenuPopup;
  }
  
  public void a() {
    this.j = null;
    PopupWindow.OnDismissListener onDismissListener = this.k;
    if (onDismissListener != null)
      onDismissListener.onDismiss(); 
  }
  
  public void dismiss() {
    if (isShowing())
      this.j.dismiss(); 
  }
  
  public int getGravity() {
    return this.g;
  }
  
  public ListView getListView() {
    return getPopup().getListView();
  }
  
  public MenuPopup getPopup() {
    if (this.j == null)
      this.j = b(); 
    return this.j;
  }
  
  public boolean isShowing() {
    MenuPopup menuPopup = this.j;
    return (menuPopup != null && menuPopup.isShowing());
  }
  
  public void setAnchorView(View paramView) {
    this.f = paramView;
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.h = paramBoolean;
    MenuPopup menuPopup = this.j;
    if (menuPopup != null)
      menuPopup.setForceShowIcon(paramBoolean); 
  }
  
  public void setGravity(int paramInt) {
    this.g = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.k = paramOnDismissListener;
  }
  
  public void setPresenterCallback(MenuPresenter.Callback paramCallback) {
    this.i = paramCallback;
    MenuPopup menuPopup = this.j;
    if (menuPopup != null)
      menuPopup.setCallback(paramCallback); 
  }
  
  public void show() {
    if (tryShow())
      return; 
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public void show(int paramInt1, int paramInt2) {
    if (tryShow(paramInt1, paramInt2))
      return; 
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public boolean tryShow() {
    if (isShowing())
      return true; 
    if (this.f == null)
      return false; 
    a(0, 0, false, false);
    return true;
  }
  
  public boolean tryShow(int paramInt1, int paramInt2) {
    if (isShowing())
      return true; 
    if (this.f == null)
      return false; 
    a(paramInt1, paramInt2, true, true);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\MenuPopupHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */