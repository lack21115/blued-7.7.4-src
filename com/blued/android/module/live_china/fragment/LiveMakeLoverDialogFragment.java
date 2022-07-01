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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;

public class LiveMakeLoverDialogFragment extends BaseDialogFragment {
  public Context a;
  
  public int b = 1;
  
  private ViewPager c;
  
  private MyAdapter d;
  
  private long e;
  
  private String f;
  
  private int g;
  
  private ILiveMakeLoverDialog h;
  
  private void f() {
    if (getArguments() != null) {
      this.f = getArguments().getString("uid");
      this.e = getArguments().getLong("lid");
      this.g = getArguments().getInt("from");
    } 
  }
  
  public void a(ILiveMakeLoverDialog paramILiveMakeLoverDialog) {
    this.h = paramILiveMakeLoverDialog;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_make_lover, null);
    int i = DensityUtils.a((Context)getActivity(), 290.0F);
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
    f();
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    View view = paramLayoutInflater.inflate(R.layout.dialog_live_make_lover, paramViewGroup);
    this.c = (ViewPager)view.findViewById(R.id.lover_view_pager);
    this.d = new MyAdapter(this, getChildFragmentManager());
    this.c.setAdapter((PagerAdapter)this.d);
    this.c.setCurrentItem(0);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ILiveMakeLoverDialog iLiveMakeLoverDialog = this.h;
    if (iLiveMakeLoverDialog != null)
      iLiveMakeLoverDialog.a(); 
  }
  
  public void onPause() {
    super.onPause();
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
  
  public static interface ILiveMakeLoverDialog {
    void a();
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    FragmentManager a;
    
    public MyAdapter(LiveMakeLoverDialogFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
      this.a = param1FragmentManager;
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.b.b;
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int == 0) {
        if (LiveMakeLoverDialogFragment.a(this.b) == 0) {
          Bundle bundle = new Bundle();
          LiveMakeLoverApplyGuestFragment liveMakeLoverApplyGuestFragment = new LiveMakeLoverApplyGuestFragment();
          bundle.putString("uid", LiveMakeLoverDialogFragment.b(this.b));
          bundle.putLong("lid", LiveMakeLoverDialogFragment.c(this.b));
          liveMakeLoverApplyGuestFragment.setArguments(bundle);
          return (Fragment)liveMakeLoverApplyGuestFragment;
        } 
        if (LiveMakeLoverDialogFragment.a(this.b) == 1) {
          Bundle bundle = new Bundle();
          LiveMakeLoverApplyRecordFragment liveMakeLoverApplyRecordFragment = new LiveMakeLoverApplyRecordFragment();
          bundle.putString("uid", LiveMakeLoverDialogFragment.b(this.b));
          bundle.putLong("lid", LiveMakeLoverDialogFragment.c(this.b));
          liveMakeLoverApplyRecordFragment.setArguments(bundle);
          return (Fragment)liveMakeLoverApplyRecordFragment;
        } 
      } 
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMakeLoverDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */