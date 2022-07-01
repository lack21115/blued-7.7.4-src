package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;

class MenuDialogHelper implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.Callback {
  ListMenuPresenter a;
  
  private MenuBuilder b;
  
  private AlertDialog c;
  
  private MenuPresenter.Callback d;
  
  public MenuDialogHelper(MenuBuilder paramMenuBuilder) {
    this.b = paramMenuBuilder;
  }
  
  public void dismiss() {
    AlertDialog alertDialog = this.c;
    if (alertDialog != null)
      alertDialog.dismiss(); 
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    this.b.performItemAction((MenuItem)this.a.getAdapter().getItem(paramInt), 0);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    if (paramBoolean || paramMenuBuilder == this.b)
      dismiss(); 
    MenuPresenter.Callback callback = this.d;
    if (callback != null)
      callback.onCloseMenu(paramMenuBuilder, paramBoolean); 
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    this.a.onCloseMenu(this.b, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 82 || paramInt == 4) {
      KeyEvent.DispatcherState dispatcherState;
      if (paramKeyEvent.getAction() == 0 && paramKeyEvent.getRepeatCount() == 0) {
        Window window = this.c.getWindow();
        if (window != null) {
          View view = window.getDecorView();
          if (view != null) {
            dispatcherState = view.getKeyDispatcherState();
            if (dispatcherState != null) {
              dispatcherState.startTracking(paramKeyEvent, this);
              return true;
            } 
          } 
        } 
      } else if (paramKeyEvent.getAction() == 1 && !paramKeyEvent.isCanceled()) {
        Window window = this.c.getWindow();
        if (window != null) {
          View view = window.getDecorView();
          if (view != null) {
            KeyEvent.DispatcherState dispatcherState1 = view.getKeyDispatcherState();
            if (dispatcherState1 != null && dispatcherState1.isTracking(paramKeyEvent)) {
              this.b.close(true);
              dispatcherState.dismiss();
              return true;
            } 
          } 
        } 
      } 
    } 
    return this.b.performShortcut(paramInt, paramKeyEvent, 0);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder) {
    MenuPresenter.Callback callback = this.d;
    return (callback != null) ? callback.onOpenSubMenu(paramMenuBuilder) : false;
  }
  
  public void setPresenterCallback(MenuPresenter.Callback paramCallback) {
    this.d = paramCallback;
  }
  
  public void show(IBinder paramIBinder) {
    MenuBuilder menuBuilder = this.b;
    AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
    this.a = new ListMenuPresenter(builder.getContext(), R.layout.abc_list_menu_item_layout);
    this.a.setCallback(this);
    this.b.addMenuPresenter(this.a);
    builder.setAdapter(this.a.getAdapter(), this);
    View view = menuBuilder.getHeaderView();
    if (view != null) {
      builder.setCustomTitle(view);
    } else {
      builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
    } 
    builder.setOnKeyListener(this);
    this.c = builder.create();
    this.c.setOnDismissListener(this);
    WindowManager.LayoutParams layoutParams = this.c.getWindow().getAttributes();
    layoutParams.type = 1003;
    if (paramIBinder != null)
      layoutParams.token = paramIBinder; 
    layoutParams.flags |= 0x20000;
    this.c.show();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\MenuDialogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */