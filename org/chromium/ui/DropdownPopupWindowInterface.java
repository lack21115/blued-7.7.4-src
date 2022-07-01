package org.chromium.ui;

import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

public interface DropdownPopupWindowInterface {
  void disableHideOnOutsideTap();
  
  void dismiss();
  
  ListView getListView();
  
  void postShow();
  
  void setAdapter(ListAdapter paramListAdapter);
  
  void setContentDescriptionForAccessibility(CharSequence paramCharSequence);
  
  void setInitialSelection(int paramInt);
  
  void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener);
  
  void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener);
  
  void setRtl(boolean paramBoolean);
  
  void show();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownPopupWindowInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */