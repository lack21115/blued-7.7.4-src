package android.support.v7.widget;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

final class ActionMenuPresenter$OverflowMenuButton$1 extends ForwardingListener {
  ActionMenuPresenter$OverflowMenuButton$1(View paramView) {
    super(paramView);
  }
  
  public final ShowableListMenu getPopup() {
    return (ShowableListMenu)((this.this$1.this$0.mOverflowPopup == null) ? null : this.this$1.this$0.mOverflowPopup.getPopup());
  }
  
  public final boolean onForwardingStarted() {
    this.this$1.this$0.showOverflowMenu();
    return true;
  }
  
  public final boolean onForwardingStopped() {
    if (this.this$1.this$0.mPostedOpenRunnable != null)
      return false; 
    this.this$1.this$0.hideOverflowMenu();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter$OverflowMenuButton$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */