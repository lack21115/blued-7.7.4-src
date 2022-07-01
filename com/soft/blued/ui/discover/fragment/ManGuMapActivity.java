package com.soft.blued.ui.discover.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.utils.CommonTools;
import com.soft.blued.control.LocationHelperNew;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.H5Url;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;

public class ManGuMapActivity extends BaseFragmentActivity implements View.OnClickListener {
  private String c;
  
  private String d;
  
  private WebViewShowInfoFragment e = new WebViewShowInfoFragment();
  
  private CommonTopTitleNoTrans f;
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.c = BluedPreferences.t();
    this.d = BluedPreferences.s();
    setContentView(2131492905);
    this.f = (CommonTopTitleNoTrans)findViewById(2131300158);
    this.f.setCenterText(getResources().getString(2131757793));
    this.f.a();
    this.f.setLeftClickListener(this);
    paramBundle = new Bundle();
    paramBundle.putString("web_url", H5Url.a(14));
    paramBundle.putString("title_name", getResources().getString(2131756190));
    this.e.setArguments(paramBundle);
    DeviceUtils.a(new LocationHelperNew.LocationFinishListener(this) {
          public void a() {
            if (CommonTools.a((Activity)this.a)) {
              FragmentTransaction fragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
              fragmentTransaction.replace(2131299960, (Fragment)ManGuMapActivity.a(this.a));
              fragmentTransaction.commitAllowingStateLoss();
              ManGuMapActivity.b(this.a).setVisibility(8);
            } 
          }
          
          public void a(int param1Int) {
            if (CommonTools.a((Activity)this.a)) {
              FragmentTransaction fragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
              fragmentTransaction.replace(2131299960, (Fragment)ManGuMapActivity.a(this.a));
              fragmentTransaction.commitAllowingStateLoss();
              ManGuMapActivity.b(this.a).setVisibility(8);
            } 
          }
        }true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\ManGuMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */