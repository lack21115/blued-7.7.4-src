package android.support.v7.widget;

final class Toolbar$2 implements Runnable {
  public final void run() {
    Toolbar toolbar = Toolbar.this;
    if (toolbar.mMenuView != null) {
      ActionMenuView actionMenuView = toolbar.mMenuView;
      if (actionMenuView.mPresenter != null)
        actionMenuView.mPresenter.showOverflowMenu(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\Toolbar$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */