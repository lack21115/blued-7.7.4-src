package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

public class PasswordSettingFragment extends BaseFragment implements View.OnClickListener {
  private View d;
  
  private Dialog e;
  
  private TextView f;
  
  private LinearLayout g;
  
  private LinearLayout h;
  
  private LinearLayout i;
  
  private Context j;
  
  protected void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131755147));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  protected void k() {
    this.g = (LinearLayout)this.d.findViewById(2131298954);
    this.g.setOnClickListener(this);
    LoginRegisterTools.a((View)this.g);
    this.h = (LinearLayout)this.d.findViewById(2131299011);
    this.h.setOnClickListener(this);
    this.e = DialogUtils.a((Context)getActivity());
    this.i = (LinearLayout)this.d.findViewById(2131298928);
    this.i.setOnClickListener(this);
    this.f = (TextView)this.d.findViewById(2131301001);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131299011:
        EventTrackSettings.a(SettingsProtos.Event.PAY_PWD_SETTINGS_CLICK);
        TerminalActivity.d((Context)getActivity(), PayPasswordSettingFragment.class, null);
        return;
      case 2131298954:
        EventTrackSettings.a(SettingsProtos.Event.ACCOUNT_PWD_SETTINGS_CLICK);
        TerminalActivity.d((Context)getActivity(), ModifyPasswordFragment.class, null);
        return;
      case 2131298928:
        EventTrackSettings.a(SettingsProtos.Event.GESTURE_PWD_SETTINGS_CLICK);
        if (!StringUtils.e(BluedPreferences.bc())) {
          TerminalActivity.d((Context)getActivity(), GestureLockSettingFragment.class, null);
          return;
        } 
        TerminalActivity.d((Context)getActivity(), LockPatternCreateFragment.class, null);
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.j = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493259, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  public void onResume() {
    super.onResume();
    if (!StringUtils.e(BluedPreferences.bc())) {
      if (!BluedPreferences.aZ()) {
        this.f.setText(getResources().getText(2131757806));
        this.f.setTextColor(BluedSkinUtils.a(this.j, 2131100838));
        return;
      } 
      this.f.setText(getResources().getText(2131757807));
      this.f.setTextColor(BluedSkinUtils.a(this.j, 2131100716));
      return;
    } 
    BluedPreferences.y(false);
    this.f.setText(getResources().getText(2131757803));
    this.f.setTextColor(BluedSkinUtils.a(this.j, 2131100838));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\PasswordSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */