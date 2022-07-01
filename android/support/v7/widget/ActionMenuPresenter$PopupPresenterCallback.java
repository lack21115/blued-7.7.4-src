package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.SubMenuBuilder;

final class ActionMenuPresenter$PopupPresenterCallback implements MenuPresenter.Callback {
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    if (paramMenuBuilder instanceof SubMenuBuilder)
      paramMenuBuilder.getRootMenu().close(false); 
    MenuPresenter.Callback callback = this.this$0.mCallback;
    if (callback != null)
      callback.onCloseMenu(paramMenuBuilder, paramBoolean); 
  }
  
  public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder) {
    if (paramMenuBuilder == null)
      return false; 
    ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
    MenuPresenter.Callback callback = this.this$0.mCallback;
    return (callback != null) ? callback.onOpenSubMenu(paramMenuBuilder) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter$PopupPresenterCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */