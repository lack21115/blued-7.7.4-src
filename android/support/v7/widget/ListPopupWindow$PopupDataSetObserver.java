package android.support.v7.widget;

import android.database.DataSetObserver;

final class ListPopupWindow$PopupDataSetObserver extends DataSetObserver {
  public final void onChanged() {
    if (ListPopupWindow.this.mPopup.isShowing())
      ListPopupWindow.this.show(); 
  }
  
  public final void onInvalidated() {
    ListPopupWindow.this.dismiss();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ListPopupWindow$PopupDataSetObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */