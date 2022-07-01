package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.yy_china.R;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYRankFragment extends BaseDialogFragment {
  private Context a;
  
  private LinearLayout b;
  
  private TextView c;
  
  private FrameLayout d;
  
  private ImageView e;
  
  private RankPagerAdapter f;
  
  private TabPageIndicatorWithDot g;
  
  private ViewPager h;
  
  private FrameLayout i;
  
  private void a(View paramView) {
    this.b = (LinearLayout)paramView.findViewById(R.id.ll_common_title);
    this.e = (ImageView)paramView.findViewById(R.id.ctt_left);
    this.c = (TextView)paramView.findViewById(R.id.ctt_right_text);
    this.d = (FrameLayout)paramView.findViewById(R.id.ctt_right_menu);
    this.i = (FrameLayout)paramView.findViewById(R.id.img_right);
    this.g = (TabPageIndicatorWithDot)paramView.findViewById(R.id.common_indicator);
    this.g.setIndicatorColor(R.color.syc_dark_b);
    this.g.setTextColor(R.color.syc_dark_b);
    this.g.setTabTextColorUnfocused(R.color.syc_dark_b);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.b.setBackgroundColor(getResources().getColor(R.color.transparent));
    if (StatusBarHelper.a()) {
      this.b.setPadding(0, StatusBarHelper.a((Context)getActivity()), 0, 0);
      ((FrameLayout.LayoutParams)this.i.getLayoutParams()).topMargin = DensityUtils.a(getContext(), 35.0F) + StatusBarHelper.a(getContext());
    } 
    this.e.setVisibility(0);
    this.e.setImageDrawable(BluedSkinUtils.b(this.a, R.drawable.icon_yy_close));
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.dismiss();
          }
        });
  }
  
  private void b(View paramView) {
    this.h = (ViewPager)paramView.findViewById(R.id.rank_viewpager);
    this.f = new RankPagerAdapter(getChildFragmentManager());
    this.h.setAdapter((PagerAdapter)this.f);
    this.g.setViewPager(this.h);
    this.h.setCurrentItem(1);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    getDialog().getWindow().requestFeature(1);
    super.onActivityCreated(paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
      getDialog().getWindow().getDecorView().setSystemUiVisibility(9216); 
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    getDialog().getWindow().setLayout(-1, -1);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.a = (Context)getActivity();
    setStyle(0, R.style.Dialog_FullScreen);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(R.layout.fragment_yy_rank_layout, paramViewGroup, false);
    a(view);
    b(view);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveEventBus.get("inner_fragment_close").post("");
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
  
  public static class RankPagerAdapter extends FragmentPagerAdapter {
    public RankPagerAdapter(FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return 2;
    }
    
    public Fragment getItem(int param1Int) {
      YYRankItemFragment yYRankItemFragment = new YYRankItemFragment();
      Bundle bundle = new Bundle();
      bundle.putInt("position", param1Int);
      yYRankItemFragment.setArguments(bundle);
      return (Fragment)yYRankItemFragment;
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return (param1Int == 0) ? "获赠榜" : ((param1Int == 1) ? "赠送榜" : "");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYRankFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */