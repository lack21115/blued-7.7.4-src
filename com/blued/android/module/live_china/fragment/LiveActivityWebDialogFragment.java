package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class LiveActivityWebDialogFragment extends BaseDialogFragment implements PopLiveActivityWebView.PopLiveWebEvent {
  public Context a;
  
  public PopLiveActivityWebView b;
  
  private ILiveWebDialog c;
  
  private String d;
  
  private void g() {
    if (getArguments() != null)
      this.d = getArguments().getString("url"); 
  }
  
  private void h() {
    LiveEventBus.get("LIVE_WEB_PAGE_REFRESH", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            if (this.a.b != null)
              this.a.b.g(); 
          }
        });
  }
  
  public void f() {
    dismiss();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_activty_web, null);
    int i = getActivity().getWindowManager().getDefaultDisplay().getHeight() - DensityUtils.a((Activity)getActivity()) - DensityUtils.a(this.a, 200.0F);
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
    View view = paramLayoutInflater.inflate(R.layout.dialog_live_activty_web, paramViewGroup);
    this.b = (PopLiveActivityWebView)view.findViewById(R.id.live_activity_web_view);
    this.b.a((Fragment)this);
    this.b.setPopLiveWebEvent(this);
    if (!TextUtils.isEmpty(this.d) && !this.d.contains("?blued_mode=hide_nav")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.d);
      stringBuilder.append("?blued_mode=hide_nav");
      this.d = stringBuilder.toString();
    } 
    this.b.a(this.d, -1, false);
    ILiveWebDialog iLiveWebDialog = this.c;
    if (iLiveWebDialog != null)
      iLiveWebDialog.a(); 
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    h();
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
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveActivityWebDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */