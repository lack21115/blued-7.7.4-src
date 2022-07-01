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
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;

public class LiveFansGuestDialogFragment extends BaseDialogFragment {
  public static int c;
  
  public Context a;
  
  public int b = 2;
  
  public LiveFansWebDialogFragment d;
  
  private ViewPager e;
  
  private MyAdapter f;
  
  private int g;
  
  private long h;
  
  private short i;
  
  private String j;
  
  private int k;
  
  private ILiveFansGuestDialog l;
  
  private ViewPager.OnPageChangeListener m = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        LiveFansGuestDialogFragment.a(this.a, param1Int);
        LiveFansGuestDialogFragment.e(this.a);
      }
    };
  
  private void g() {
    if (getArguments() != null) {
      this.j = getArguments().getString("uid");
      this.h = getArguments().getLong("lid");
      this.k = getArguments().getInt("level");
      this.i = getArguments().getShort("session_type");
      if (LiveRoomManager.a().k()) {
        this.b = 2;
        return;
      } 
      this.b = 1;
    } 
  }
  
  public void a(int paramInt) {
    this.e.setCurrentItem(paramInt);
  }
  
  public void a(ILiveFansGuestDialog paramILiveFansGuestDialog) {
    this.l = paramILiveFansGuestDialog;
  }
  
  public void f() {
    this.d = new LiveFansWebDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putString("url", LiveRoomInfo.a().B());
    bundle.putInt("type", 0);
    this.d.setArguments(bundle);
    this.d.show(getFragmentManager(), "webDialog");
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_fans_guest, null);
    int i = DensityUtils.a((Context)getActivity(), 360.0F);
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
    View view = paramLayoutInflater.inflate(R.layout.dialog_live_fans_guest, paramViewGroup);
    this.e = (ViewPager)view.findViewById(R.id.fans_view_pager);
    this.f = new MyAdapter(this, getChildFragmentManager());
    this.e.setAdapter((PagerAdapter)this.f);
    this.e.setOffscreenPageLimit(2);
    this.e.setOnPageChangeListener(this.m);
    ILiveFansGuestDialog iLiveFansGuestDialog = this.l;
    if (iLiveFansGuestDialog != null)
      iLiveFansGuestDialog.A_(); 
    int i = c;
    if (i == 0 || i == 1)
      this.e.setCurrentItem(c); 
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ILiveFansGuestDialog iLiveFansGuestDialog = this.l;
    if (iLiveFansGuestDialog != null)
      iLiveFansGuestDialog.B_(); 
  }
  
  public void onPause() {
    super.onPause();
    LiveFansWebDialogFragment liveFansWebDialogFragment = this.d;
    if (liveFansWebDialogFragment != null) {
      Dialog dialog = liveFansWebDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.d.dismiss(); 
    } 
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
  
  public static interface ILiveFansGuestDialog {
    void A_();
    
    void B_();
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    FragmentManager a;
    
    public MyAdapter(LiveFansGuestDialogFragment this$0, FragmentManager param1FragmentManager) {
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
      if (param1Int != 0) {
        if (param1Int != 1)
          return null; 
        Bundle bundle1 = new Bundle();
        bundle1.putLong("lid", LiveFansGuestDialogFragment.b(this.b));
        LiveFansMemberFragment liveFansMemberFragment = new LiveFansMemberFragment();
        liveFansMemberFragment.setArguments(bundle1);
        return (Fragment)liveFansMemberFragment;
      } 
      Bundle bundle = new Bundle();
      LiveFansGuestFragment liveFansGuestFragment = new LiveFansGuestFragment();
      bundle.putString("uid", LiveFansGuestDialogFragment.a(this.b));
      bundle.putLong("lid", LiveFansGuestDialogFragment.b(this.b));
      bundle.putInt("level", LiveFansGuestDialogFragment.c(this.b));
      bundle.putShort("session_type", LiveFansGuestDialogFragment.d(this.b));
      liveFansGuestFragment.setArguments(bundle);
      return (Fragment)liveFansGuestFragment;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveFansGuestDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */