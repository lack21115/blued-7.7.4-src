package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu {
  final MenuPopupHelper a;
  
  OnMenuItemClickListener b;
  
  OnDismissListener c;
  
  private final Context d;
  
  private final MenuBuilder e;
  
  private final View f;
  
  private View.OnTouchListener g;
  
  public PopupMenu(Context paramContext, View paramView) {
    this(paramContext, paramView, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt) {
    this(paramContext, paramView, paramInt, R.attr.popupMenuStyle, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3) {
    this.d = paramContext;
    this.f = paramView;
    this.e = new MenuBuilder(paramContext);
    this.e.setCallback(new MenuBuilder.Callback(this) {
          public boolean onMenuItemSelected(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
            return (this.a.b != null) ? this.a.b.onMenuItemClick(param1MenuItem) : false;
          }
          
          public void onMenuModeChange(MenuBuilder param1MenuBuilder) {}
        });
    this.a = new MenuPopupHelper(paramContext, this.e, paramView, false, paramInt2, paramInt3);
    this.a.setGravity(paramInt1);
    this.a.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
          public void onDismiss() {
            if (this.a.c != null)
              this.a.c.onDismiss(this.a); 
          }
        });
  }
  
  public void dismiss() {
    this.a.dismiss();
  }
  
  public View.OnTouchListener getDragToOpenListener() {
    if (this.g == null)
      this.g = new ForwardingListener(this, this.f) {
          public ShowableListMenu getPopup() {
            return (ShowableListMenu)this.a.a.getPopup();
          }
          
          protected boolean onForwardingStarted() {
            this.a.show();
            return true;
          }
          
          protected boolean onForwardingStopped() {
            this.a.dismiss();
            return true;
          }
        }; 
    return this.g;
  }
  
  public int getGravity() {
    return this.a.getGravity();
  }
  
  public Menu getMenu() {
    return (Menu)this.e;
  }
  
  public MenuInflater getMenuInflater() {
    return (MenuInflater)new SupportMenuInflater(this.d);
  }
  
  public void inflate(int paramInt) {
    getMenuInflater().inflate(paramInt, (Menu)this.e);
  }
  
  public void setGravity(int paramInt) {
    this.a.setGravity(paramInt);
  }
  
  public void setOnDismissListener(OnDismissListener paramOnDismissListener) {
    this.c = paramOnDismissListener;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.b = paramOnMenuItemClickListener;
  }
  
  public void show() {
    this.a.show();
  }
  
  public static interface OnDismissListener {
    void onDismiss(PopupMenu param1PopupMenu);
  }
  
  public static interface OnMenuItemClickListener {
    boolean onMenuItemClick(MenuItem param1MenuItem);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\PopupMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */