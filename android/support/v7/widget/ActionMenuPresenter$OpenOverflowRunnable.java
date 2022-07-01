package android.support.v7.widget;

import android.view.View;

final class ActionMenuPresenter$OpenOverflowRunnable implements Runnable {
  private ActionMenuPresenter$OverflowPopup mPopup;
  
  public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter$OverflowPopup paramActionMenuPresenter$OverflowPopup) {
    this.mPopup = paramActionMenuPresenter$OverflowPopup;
  }
  
  public final void run() {
    View view = (View)ActionMenuPresenter.this.mMenuView;
    if (view != null && view.getWindowToken() != null && this.mPopup.tryShow())
      ActionMenuPresenter.this.mOverflowPopup = this.mPopup; 
    ActionMenuPresenter.this.mPostedOpenRunnable = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter$OpenOverflowRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */