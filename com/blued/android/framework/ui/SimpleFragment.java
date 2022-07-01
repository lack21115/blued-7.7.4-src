package com.blued.android.framework.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.R;
import com.blued.android.framework.utils.Logger;

public abstract class SimpleFragment extends BaseFragment {
  private static final String h = SimpleFragment.class.getName();
  
  protected View d;
  
  protected LayoutInflater e;
  
  protected Bundle f;
  
  protected Dialog g;
  
  public boolean a() {
    return w_().isActive();
  }
  
  public abstract int k();
  
  public void l() {}
  
  protected void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    Logger.b(h, new Object[] { " onActivityCreated()" });
    q();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Logger.b(h, new Object[] { " onCreate()" });
    m();
    this.f = getArguments();
    if (this.f == null)
      this.f = new Bundle(); 
    l();
    Logger.b(h, new Object[] { " getArguments: ", this.f.toString() });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Logger.b(h, new Object[] { " onCreateView()" });
    this.e = paramLayoutInflater;
    View view = this.d;
    if (view != null && view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
      Logger.b(h, new Object[] { "rootView.getParent()).removeView(rootView)" });
      return this.d;
    } 
    this.d = this.e.inflate(k(), paramViewGroup, false);
    this.g = new Dialog(getContext(), R.style.TranslucentBackground);
    this.g.setContentView(R.layout.common_loading_dialog);
    StatusBarHelper.a(this.g.getWindow());
    this.g.setCancelable(true);
    return this.d;
  }
  
  public void onDestroy() {
    Dialog dialog = this.g;
    if (dialog != null && dialog.isShowing())
      this.g.dismiss(); 
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    Logger.b(h, new Object[] { " onViewCreated()" });
    n();
    o();
    p();
  }
  
  public void p() {}
  
  public void q() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\SimpleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */