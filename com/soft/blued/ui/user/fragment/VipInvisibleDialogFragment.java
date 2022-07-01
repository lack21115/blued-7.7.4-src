package com.soft.blued.ui.user.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.soft.blued.view.tip.dialog.CommonDialogFragment;

public class VipInvisibleDialogFragment extends CommonDialogFragment {
  public String a;
  
  public String b;
  
  public void a(View paramView) {}
  
  public int f() {
    return 2131492994;
  }
  
  public int g() {
    return (int)(AppInfo.m / 6.0F * 5.0F);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    VipInvisibleFragment vipInvisibleFragment = new VipInvisibleFragment();
    vipInvisibleFragment.d = this;
    paramBundle = new Bundle();
    paramBundle.putString("title", this.a);
    paramBundle.putString("KEY_VIP_DETAIL", this.b);
    vipInvisibleFragment.setArguments(paramBundle);
    getChildFragmentManager().beginTransaction().replace(2131297192, (Fragment)vipInvisibleFragment).commitAllowingStateLoss();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VipInvisibleDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */