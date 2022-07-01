package com.blued.android.module.live_china.fragment;

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
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.jeremyliao.liveeventbus.LiveEventBus;

public abstract class LiveBaseDialogFragment<T> extends BaseDialogFragment {
  public Context a;
  
  public View b;
  
  public IDialogEvent c;
  
  private ViewPager d;
  
  private FragmentPagerAdapter e;
  
  public void a(IDialogEvent paramIDialogEvent) {
    this.c = paramIDialogEvent;
  }
  
  public void a(T paramT) {}
  
  public void b(T paramT) {
    IDialogEvent<T> iDialogEvent = this.c;
    if (iDialogEvent != null)
      iDialogEvent.a(paramT); 
  }
  
  public abstract void f();
  
  public abstract int g();
  
  public abstract int h();
  
  public abstract int i();
  
  public abstract FragmentPagerAdapter j();
  
  public void k() {
    IDialogEvent iDialogEvent = this.c;
    if (iDialogEvent != null)
      iDialogEvent.a(); 
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    this.a = getContext();
    this.b = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_base_view, null);
    int i = h();
    Dialog dialog = new Dialog((Context)getActivity(), R.style.transparentFrameWindowStyleLive);
    dialog.requestWindowFeature(1);
    dialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    dialog.setContentView(this.b, new ViewGroup.LayoutParams(-1, i));
    Window window = dialog.getWindow();
    window.setWindowAnimations(i());
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.width = g();
    layoutParams.height = i;
    layoutParams.x = 0;
    layoutParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - i;
    dialog.onWindowAttributesChanged(layoutParams);
    LiveEventBus.get("live_dialog_cancel", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            this.a.dismiss();
          }
        });
    f();
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    View view = paramLayoutInflater.inflate(R.layout.dialog_live_base_view, paramViewGroup);
    this.d = (ViewPager)view.findViewById(R.id.lover_view_pager);
    this.e = j();
    this.d.setAdapter((PagerAdapter)this.e);
    this.d.setCurrentItem(0);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    k();
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
  
  public static interface IDialogEvent<T> {
    void a();
    
    void a(T param1T);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveBaseDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */