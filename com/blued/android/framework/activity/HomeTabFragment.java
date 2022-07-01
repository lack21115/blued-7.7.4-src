package com.blued.android.framework.activity;

import android.os.Bundle;
import android.view.View;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;

public abstract class HomeTabFragment extends BaseFragment {
  public boolean d = false;
  
  public abstract boolean C_();
  
  public boolean W_() {
    return super.W_();
  }
  
  public String X_() {
    return super.X_();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    if (!this.d) {
      if (!C_()) {
        int i = StatusBarHelper.a(getContext());
        paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop() + i, paramView.getPaddingRight(), paramView.getPaddingBottom());
      } 
      this.d = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\activity\HomeTabFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */