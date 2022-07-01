package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;

final class ListPopupWindow$3 implements AdapterView.OnItemSelectedListener {
  public final void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt != -1) {
      DropDownListView dropDownListView = ListPopupWindow.this.mDropDownList;
      if (dropDownListView != null)
        dropDownListView.mListSelectionHidden = false; 
    } 
  }
  
  public final void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ListPopupWindow$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */