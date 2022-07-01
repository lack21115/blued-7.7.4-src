package android.support.v7.widget;

import android.widget.AbsListView;

final class ListPopupWindow$PopupScrollListener implements AbsListView.OnScrollListener {
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (paramInt == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
      ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
      ListPopupWindow.this.mResizePopupRunnable.run();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ListPopupWindow$PopupScrollListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */