package android.support.v7.view.menu;

import android.view.MenuItem;

final class CascadingMenuPopup$3$1 implements Runnable {
  public final void run() {
    if (nextInfo != null) {
      this.this$1.this$0.mShouldCloseImmediately = true;
      nextInfo.menu.close(false);
      this.this$1.this$0.mShouldCloseImmediately = false;
    } 
    if (item.isEnabled() && item.hasSubMenu())
      menu.performItemAction(item, null, 4); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\CascadingMenuPopup$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */