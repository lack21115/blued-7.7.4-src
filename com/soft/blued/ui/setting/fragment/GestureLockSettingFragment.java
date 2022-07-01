package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

public class GestureLockSettingFragment extends BaseFragment implements View.OnClickListener {
  private View d;
  
  private LinearLayout e;
  
  private TextView f;
  
  private ToggleButton g;
  
  private void a() {
    this.e = (LinearLayout)this.d.findViewById(2131298927);
    this.f = (TextView)this.d.findViewById(2131301000);
    this.g = (ToggleButton)this.d.findViewById(2131300254);
    this.e.setOnClickListener(this);
    if (BluedPreferences.aZ()) {
      this.e.setVisibility(0);
    } else {
      this.e.setVisibility(8);
    } 
    this.g.setChecked(BluedPreferences.aZ());
    this.g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            BluedPreferences.z(param1Boolean);
            if (param1Boolean) {
              if (StringUtils.e(BluedPreferences.bc())) {
                BluedPreferences.z(false);
                GestureLockSettingFragment.a(this.a).setVisibility(8);
                TerminalActivity.d((Context)this.a.getActivity(), LockPatternSetupFragment.class, null);
                this.a.getActivity().finish();
                return;
              } 
              GestureLockSettingFragment.a(this.a).setVisibility(0);
              return;
            } 
            GestureLockSettingFragment.a(this.a).setVisibility(8);
          }
        });
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.setCenterText(getString(2131757809));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  private void l() {
    getActivity().setResult(-1);
    getActivity().finish();
  }
  
  public boolean V_() {
    l();
    return false;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131298927)
        return; 
      Bundle bundle = new Bundle();
      bundle.putString("FRAGMENT_NAME_KEY", GestureLockSettingFragment.class.getSimpleName());
      TerminalActivity.d((Context)getActivity(), LockPatternSetupFragment.class, bundle);
      getActivity().finish();
      return;
    } 
    l();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493132, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\GestureLockSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */