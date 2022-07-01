package com.blued.android.framework.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.R;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;

public abstract class PreloadFragment extends KeyBoardFragment {
  protected View e;
  
  public boolean f;
  
  private boolean o;
  
  public boolean W_() {
    return false;
  }
  
  public String X_() {
    return null;
  }
  
  public abstract void a(View paramView);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(R.layout.fragment_preload, paramViewGroup, false);
      boolean bool = this.o;
      if (bool)
        setUserVisibleHint(bool); 
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    this.o = paramBoolean;
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && !this.f) {
      View view = this.e;
      if (view != null) {
        a(view);
        this.f = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\activity\PreloadFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */