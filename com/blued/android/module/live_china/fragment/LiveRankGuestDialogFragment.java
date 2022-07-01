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
import android.widget.TextView;
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
import com.blued.android.module.live_china.manager.LiveFloatManager;

public class LiveRankGuestDialogFragment extends BaseDialogFragment {
  public static String a = "LID";
  
  public static String d = "IF_USER_ANCHOR";
  
  public static int e;
  
  public Context b;
  
  public int c = 2;
  
  ILiveGuestDialog f;
  
  private TextView g;
  
  private TextView h;
  
  private ViewPager i;
  
  private MyAdapter j;
  
  private TextView k;
  
  private View l;
  
  private View m;
  
  private View n;
  
  private int o;
  
  private long p;
  
  private String q;
  
  private boolean r;
  
  private boolean s;
  
  private ViewPager.OnPageChangeListener t = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        LiveRankGuestDialogFragment.a(this.a, param1Int);
        param1Int = LiveRankGuestDialogFragment.d(this.a);
        if (param1Int != 0) {
          if (param1Int != 1)
            return; 
          LiveRankGuestDialogFragment.f(this.a);
          return;
        } 
        LiveRankGuestDialogFragment.e(this.a);
      }
    };
  
  private void f() {
    if (getArguments() != null) {
      this.q = getArguments().getString("UID");
      this.p = getArguments().getLong(a);
      this.s = getArguments().getBoolean(d);
      this.r = getArguments().getBoolean("isMakeLover");
      if (this.r)
        this.c = 1; 
    } 
  }
  
  private void g() {
    this.m.setVisibility(0);
    this.n.setVisibility(8);
    this.g.setTextColor(this.b.getResources().getColor(R.color.syc_dark_0a0a0a));
    e = 0;
    this.h.setTextColor(this.b.getResources().getColor(R.color.syc_dark_767676));
  }
  
  private void h() {
    this.m.setVisibility(8);
    this.n.setVisibility(0);
    this.g.setTextColor(this.b.getResources().getColor(R.color.syc_dark_767676));
    e = 1;
    this.h.setTextColor(this.b.getResources().getColor(R.color.syc_dark_0a0a0a));
  }
  
  public void a(ILiveGuestDialog paramILiveGuestDialog) {
    this.f = paramILiveGuestDialog;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    int i;
    this.b = (Context)getActivity();
    boolean bool = LiveFloatManager.a().B();
    LayoutInflater layoutInflater = getActivity().getLayoutInflater();
    if (bool) {
      i = R.layout.dialog_live_rank_land;
    } else {
      i = R.layout.dialog_live_rank;
    } 
    View view = layoutInflater.inflate(i, null);
    int j = DensityUtils.a((Context)getActivity(), 360.0F);
    Dialog dialog = new Dialog((Context)getActivity(), R.style.transparentFrameWindowStyleLive);
    dialog.requestWindowFeature(1);
    dialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    byte b = -1;
    if (bool) {
      dialog.setContentView(view, new ViewGroup.LayoutParams(DensityUtils.a((Context)getActivity(), 360.0F), -1));
    } else {
      dialog.setContentView(view, new ViewGroup.LayoutParams(-1, DensityUtils.a((Context)getActivity(), 360.0F)));
    } 
    Window window = dialog.getWindow();
    int k = getActivity().getWindowManager().getDefaultDisplay().getHeight();
    if (bool) {
      i = R.style.rank_menu_animstyle;
    } else {
      i = R.style.main_menu_animstyle;
    } 
    window.setWindowAnimations(i);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.x = 0;
    layoutParams.y = k - j;
    if (bool) {
      i = DensityUtils.a((Context)getActivity(), 360.0F);
    } else {
      i = -1;
    } 
    layoutParams.width = i;
    if (bool) {
      i = b;
    } else {
      i = DensityUtils.a((Context)getActivity(), 360.0F);
    } 
    layoutParams.height = i;
    layoutParams.gravity = 5;
    dialog.onWindowAttributesChanged(layoutParams);
    f();
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    View view = paramLayoutInflater.inflate(R.layout.dialog_live_rank, paramViewGroup);
    this.k = (TextView)view.findViewById(R.id.tv_title);
    this.g = (TextView)view.findViewById(R.id.rank_popular);
    this.h = (TextView)view.findViewById(R.id.rank_money);
    this.i = (ViewPager)view.findViewById(R.id.dialog_rank_viewpager);
    this.j = new MyAdapter(this, getChildFragmentManager());
    this.i.setAdapter((PagerAdapter)this.j);
    ViewPager viewPager = this.i;
    if (this.r) {
      i = 1;
    } else {
      i = 2;
    } 
    viewPager.setOffscreenPageLimit(i);
    this.i.setOnPageChangeListener(this.t);
    this.l = view.findViewById(R.id.ll_rank);
    this.m = view.findViewById(R.id.rank_left_line);
    this.n = view.findViewById(R.id.rank_right_line);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveRankGuestDialogFragment.g(this.a).setCurrentItem(0);
          }
        });
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveRankGuestDialogFragment.g(this.a).setCurrentItem(1);
          }
        });
    ILiveGuestDialog iLiveGuestDialog = this.f;
    if (iLiveGuestDialog != null)
      iLiveGuestDialog.y_(); 
    int i = e;
    if (i == 0 || i == 1) {
      this.i.setCurrentItem(e);
      if (e == 0) {
        g();
      } else {
        h();
      } 
    } 
    if (this.r) {
      this.l.setVisibility(8);
      this.k.setText(R.string.live_rank_consumption_this_short);
    } 
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ILiveGuestDialog iLiveGuestDialog = this.f;
    if (iLiveGuestDialog != null)
      iLiveGuestDialog.z_(); 
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
  
  public static interface ILiveGuestDialog {
    void y_();
    
    void z_();
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    FragmentManager a;
    
    public MyAdapter(LiveRankGuestDialogFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
      this.a = param1FragmentManager;
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.b.c;
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1)
          return null; 
        Bundle bundle1 = new Bundle();
        bundle1.putBoolean(LiveRankGuestFragment.d, false);
        bundle1.putString("UID", LiveRankGuestDialogFragment.a(this.b));
        bundle1.putLong(LiveRankGuestFragment.e, LiveRankGuestDialogFragment.b(this.b));
        bundle1.putBoolean(LiveRankGuestFragment.f, LiveRankGuestDialogFragment.c(this.b));
        LiveRankGuestFragment liveRankGuestFragment1 = new LiveRankGuestFragment();
        liveRankGuestFragment1.setArguments(bundle1);
        return (Fragment)liveRankGuestFragment1;
      } 
      Bundle bundle = new Bundle();
      bundle.putBoolean(LiveRankGuestFragment.d, true);
      bundle.putString("UID", LiveRankGuestDialogFragment.a(this.b));
      bundle.putLong(LiveRankGuestFragment.e, LiveRankGuestDialogFragment.b(this.b));
      bundle.putBoolean(LiveRankGuestFragment.f, LiveRankGuestDialogFragment.c(this.b));
      LiveRankGuestFragment liveRankGuestFragment = new LiveRankGuestFragment();
      liveRankGuestFragment.setArguments(bundle);
      return (Fragment)liveRankGuestFragment;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveRankGuestDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */