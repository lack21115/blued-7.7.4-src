package org.chromium.content.browser.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public final class SelectPopupAdapter extends ArrayAdapter {
  private boolean mAreAllItemsEnabled;
  
  private List mItems;
  
  public SelectPopupAdapter(Context paramContext, int paramInt, List<?> paramList) {
    super(paramContext, paramInt, paramList);
    this.mItems = new ArrayList(paramList);
    this.mAreAllItemsEnabled = true;
    for (paramInt = 0; paramInt < this.mItems.size(); paramInt++) {
      if (((SelectPopupItem)this.mItems.get(paramInt)).mType != 2) {
        this.mAreAllItemsEnabled = false;
        return;
      } 
    } 
  }
  
  public final boolean areAllItemsEnabled() {
    return this.mAreAllItemsEnabled;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramInt >= 0) {
      if (paramInt >= getCount())
        return null; 
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      ((TextView)paramView).setText(((SelectPopupItem)this.mItems.get(paramInt)).mLabel);
      if (paramView instanceof CheckedTextView) {
        CheckedTextView checkedTextView = (CheckedTextView)paramView;
        if (((SelectPopupItem)this.mItems.get(paramInt)).mType == 0) {
          if (checkedTextView.getCheckMarkDrawable() != null) {
            checkedTextView.setTag(checkedTextView.getCheckMarkDrawable());
            checkedTextView.setCheckMarkDrawable(null);
          } 
        } else if (checkedTextView.getCheckMarkDrawable() == null) {
          checkedTextView.setCheckMarkDrawable((Drawable)checkedTextView.getTag());
        } 
      } 
      paramInt = ((SelectPopupItem)this.mItems.get(paramInt)).mType;
      boolean bool = true;
      if (paramInt == 1)
        bool = false; 
      paramView.setEnabled(bool);
      return paramView;
    } 
    return null;
  }
  
  public final boolean isEnabled(int paramInt) {
    return (paramInt >= 0) ? ((paramInt >= getCount()) ? false : ((((SelectPopupItem)this.mItems.get(paramInt)).mType == 2))) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SelectPopupAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */