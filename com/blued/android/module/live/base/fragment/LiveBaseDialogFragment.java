package com.blued.android.module.live.base.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live.base.R;

public abstract class LiveBaseDialogFragment extends BaseDialogFragment {
  protected String a;
  
  protected View b;
  
  protected Bundle c;
  
  protected LayoutInflater d;
  
  protected int e = -1;
  
  protected int f = -1;
  
  protected int g = 0;
  
  protected float h = 0.0F;
  
  private FrameLayout i;
  
  public abstract int f();
  
  protected abstract void g();
  
  protected abstract void h();
  
  public void i() {}
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    Dialog dialog = new Dialog(getContext(), R.style.transparentDialogFragmentStyle);
    FrameLayout frameLayout = (FrameLayout)LayoutInflater.from(getContext()).inflate(R.layout.fragment_live_base_dialog, null);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    dialog.setContentView((View)frameLayout, (ViewGroup.LayoutParams)layoutParams);
    Window window = dialog.getWindow();
    WindowManager.LayoutParams layoutParams1 = window.getAttributes();
    layoutParams1.gravity = 17;
    layoutParams.width = -1;
    layoutParams.height = -1;
    window.setAttributes(layoutParams1);
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    FrameLayout.LayoutParams layoutParams;
    this.a = getClass().getSimpleName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(".onCreateView");
    LogUtils.c(stringBuilder.toString());
    this.d = paramLayoutInflater;
    this.c = getArguments();
    if (this.c == null)
      this.c = new Bundle(); 
    Bundle bundle = this.c;
    int i = -1;
    this.e = bundle.getInt("dlg_width", -1);
    this.f = this.c.getInt("dlg_height", -1);
    this.g = this.c.getInt("dlg_gravity", 0);
    this.h = this.c.getInt("dlg_dim", 0);
    FrameLayout frameLayout = this.i;
    if (frameLayout == null) {
      this.i = (FrameLayout)this.d.inflate(R.layout.fragment_live_base_dialog, paramViewGroup, false);
      this.b = this.d.inflate(f(), null, false);
      int k = this.e;
      int j = k;
      if (k == -1)
        j = -1; 
      k = this.f;
      if (k != -1)
        i = k; 
      layoutParams = new FrameLayout.LayoutParams(j, i);
      j = this.g;
      if (j == 1) {
        layoutParams.gravity = 80;
      } else if (j == 2) {
        layoutParams.gravity = 48;
      } else {
        layoutParams.gravity = 17;
      } 
      this.i.addView(this.b, (ViewGroup.LayoutParams)layoutParams);
      h();
      g();
    } else if (layoutParams.getParent() != null) {
      ((ViewGroup)this.i.getParent()).removeView((View)this.i);
    } 
    return (View)this.i;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\fragment\LiveBaseDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */