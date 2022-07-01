package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.utils.AppUtils;

public class GuideFragment extends BaseFragment {
  private View d;
  
  private ViewPager e;
  
  private NewfeatureGuideAdapter f;
  
  public static boolean a(Context paramContext) {
    return a(paramContext, false);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean) {
    return false;
  }
  
  public boolean V_() {
    AppUtils.a(AppInfo.d());
    return false;
  }
  
  public boolean j() {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493150, paramViewGroup, false);
      this.e = (ViewPager)this.d.findViewById(2131299379);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.f = new NewfeatureGuideAdapter((Activity)getActivity(), this.e);
    this.e.setAdapter(this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\GuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */