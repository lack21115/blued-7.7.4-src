package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;

public class LiveFansWebDialogFragment extends BaseDialogFragment implements PopLiveActivityWebView.PopLiveWebEvent {
  public Context a;
  
  public PopLiveActivityWebView b;
  
  public String c;
  
  public int d;
  
  private ILiveWebDialog e;
  
  private void g() {
    if (getArguments() != null) {
      this.c = getArguments().getString("url");
      this.d = getArguments().getInt("type");
    } 
  }
  
  public void f() {
    dismiss();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_web, null);
    int i = getActivity().getWindowManager().getDefaultDisplay().getHeight() - DensityUtils.a((Activity)getActivity()) - DensityUtils.a(this.a, 0.0F);
    Dialog dialog = new Dialog((Context)getActivity(), R.style.transparentFrameWindowStyleLive);
    dialog.requestWindowFeature(1);
    dialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    dialog.setContentView(view, new ViewGroup.LayoutParams(-1, i));
    Window window = dialog.getWindow();
    window.setWindowAnimations(R.style.main_menu_animstyle);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.width = -1;
    layoutParams.height = i;
    layoutParams.x = 0;
    layoutParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - i;
    dialog.onWindowAttributesChanged(layoutParams);
    g();
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    View view = paramLayoutInflater.inflate(R.layout.dialog_live_web, paramViewGroup);
    this.b = (PopLiveActivityWebView)view.findViewById(R.id.live_activity_web_view);
    this.b.a((Fragment)this);
    this.b.setPopLiveWebEvent(this);
    this.b.b(this.c, this.d);
    ILiveWebDialog iLiveWebDialog = this.e;
    if (iLiveWebDialog != null)
      iLiveWebDialog.a(); 
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ILiveWebDialog iLiveWebDialog = this.e;
    if (iLiveWebDialog != null)
      iLiveWebDialog.b(); 
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    try {
      ReflectionUtils.a(this, "mDismissed", Boolean.valueOf(false));
      ReflectionUtils.a(this, "mShownByMe", Boolean.valueOf(true));
      FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
      fragmentTransaction.add((Fragment)this, paramString);
      fragmentTransaction.commitAllowingStateLoss();
      return;
    } catch (Exception exception) {
      super.show(paramFragmentManager, paramString);
      return;
    } 
  }
  
  public static interface ILiveWebDialog {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveFansWebDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */