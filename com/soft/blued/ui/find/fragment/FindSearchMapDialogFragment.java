package com.soft.blued.ui.find.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.soft.blued.view.tip.dialog.CommonDialogFragment;

public class FindSearchMapDialogFragment extends CommonDialogFragment {
  public void a(View paramView) {}
  
  public int f() {
    return 2131492994;
  }
  
  public int g() {
    return (int)(AppInfo.m / 11.0F * 10.0F);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    FindSearchMapActivity findSearchMapActivity = new FindSearchMapActivity();
    findSearchMapActivity.setArguments(getArguments());
    getChildFragmentManager().beginTransaction().replace(2131297192, (Fragment)findSearchMapActivity).commitAllowingStateLoss();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\FindSearchMapDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */