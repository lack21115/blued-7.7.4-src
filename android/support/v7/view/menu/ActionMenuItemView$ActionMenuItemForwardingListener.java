package android.support.v7.view.menu;

import android.support.v7.widget.ForwardingListener;
import android.view.View;

final class ActionMenuItemView$ActionMenuItemForwardingListener extends ForwardingListener {
  public ActionMenuItemView$ActionMenuItemForwardingListener() {
    super((View)paramActionMenuItemView);
  }
  
  public final ShowableListMenu getPopup() {
    return (ActionMenuItemView.this.mPopupCallback != null) ? ActionMenuItemView.this.mPopupCallback.getPopup() : null;
  }
  
  protected final boolean onForwardingStarted() {
    if (ActionMenuItemView.this.mItemInvoker != null && ActionMenuItemView.this.mItemInvoker.invokeItem(ActionMenuItemView.this.mItemData)) {
      ShowableListMenu showableListMenu = getPopup();
      return (showableListMenu != null && showableListMenu.isShowing());
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\ActionMenuItemView$ActionMenuItemForwardingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */