package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.setting.Presenter.MessageNotifyPresenter;
import com.soft.blued.utils.BluedPreferences;
import java.util.Map;

public class MessageNotifyFragment extends MvpFragment<MessageNotifyPresenter> implements CompoundButton.OnCheckedChangeListener {
  @BindView(2131298949)
  LinearLayout llMessageCommonLogin;
  
  @BindView(2131298950)
  LinearLayout llMessageMobileLogin;
  
  @BindView(2131300186)
  ToggleButton tbMessageCommonLogin;
  
  @BindView(2131300187)
  ToggleButton tbMessageMobileLogin;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans topTitle;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, MessageNotifyFragment.class, null);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.topTitle.setCenterText(getResources().getString(2131757877));
    this.topTitle.a();
    this.topTitle.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.llMessageMobileLogin.setVisibility(8);
    this.llMessageCommonLogin.setVisibility(8);
    boolean bool1 = BluedPreferences.dB();
    boolean bool2 = BluedPreferences.dC();
    if (bool1)
      this.llMessageMobileLogin.setVisibility(0); 
    if (bool2)
      this.llMessageCommonLogin.setVisibility(0); 
    if (!bool1 && !bool2) {
      this.llMessageMobileLogin.setVisibility(0);
      this.llMessageCommonLogin.setVisibility(0);
    } 
    this.tbMessageMobileLogin.setChecked(BluedPreferences.dh());
    this.tbMessageCommonLogin.setChecked(BluedPreferences.di());
    this.tbMessageMobileLogin.setOnCheckedChangeListener(this);
    this.tbMessageCommonLogin.setOnCheckedChangeListener(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    Map<String, String> map = BluedHttpTools.a();
    int i = paramCompoundButton.getId();
    String str = "1";
    switch (i) {
      default:
        str = "";
        break;
      case 2131300187:
        BluedPreferences.L(paramBoolean);
        if (!paramBoolean)
          str = "0"; 
        map.put("is_verify_mobile_push", str);
        EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK, paramBoolean);
        break;
      case 2131300186:
        BluedPreferences.M(paramBoolean);
        if (!paramBoolean)
          str = "0"; 
        map.put("is_used_mobile_push", str);
        EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK, paramBoolean);
        break;
    } 
    if (TextUtils.isEmpty(str))
      return; 
    ((MessageNotifyPresenter)s()).a(map);
  }
  
  public int p() {
    return 2131493220;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\MessageNotifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */