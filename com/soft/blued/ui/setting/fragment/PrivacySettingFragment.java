package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.settings.SettingsProtos;
import com.blued.das.vip.VipProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter;
import com.soft.blued.ui.user.fragment.VipInvisibleDialogFragment;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;

public class PrivacySettingFragment extends BaseFragment implements View.OnClickListener, IPrivacySettingContract.IView {
  private TwoWaysBar A;
  
  private ShapeTextView B;
  
  private View C;
  
  private Context d;
  
  private View e;
  
  private ToggleButton f;
  
  private ToggleButton g;
  
  private ToggleButton h;
  
  private ToggleButton i;
  
  private ToggleButton j;
  
  private ToggleButton k;
  
  private ToggleButton l;
  
  private ToggleButton m;
  
  private ToggleButton n;
  
  private ToggleButton o;
  
  private LinearLayout p;
  
  private LinearLayout q;
  
  private TextView r;
  
  private TextView s;
  
  private PrivacySettingPresenter t;
  
  private LinearLayout u;
  
  private View v;
  
  private View w;
  
  private LinearLayout x;
  
  private LinearLayout y;
  
  private TextView z;
  
  private void l() {
    this.t.b(this.f.isChecked());
    this.t.c(this.h.isChecked());
    this.t.e(this.i.isChecked());
    this.t.g(this.j.isChecked());
    this.t.h(this.k.isChecked());
    this.t.i(this.l.isChecked());
    this.t.f(this.m.isChecked() ^ true);
    this.t.j(this.n.isChecked());
    this.t.k(this.o.isChecked());
    this.t.e();
    getActivity().finish();
  }
  
  public boolean M() {
    return false;
  }
  
  public boolean N() {
    return this.n.isChecked();
  }
  
  public boolean V_() {
    l();
    return true;
  }
  
  public String X_() {
    return super.X_();
  }
  
  public void a() {
    if (BluedConfig.b().D()) {
      this.x = (LinearLayout)this.e.findViewById(2131298867);
      this.x.setVisibility(0);
    } 
    this.q = (LinearLayout)this.e.findViewById(2131298768);
    this.q.setOnClickListener(new -$$Lambda$PrivacySettingFragment$Hq3qFzobyiRUzlgqrtnS-ACf52I(this));
    String str = BluedPreferences.Z();
    this.t.b = str;
    this.y = (LinearLayout)this.e.findViewById(2131298868);
    this.z = (TextView)this.e.findViewById(2131300875);
    this.A = (TwoWaysBar)this.e.findViewById(2131297354);
    this.A.a(str, 100);
    this.z.setText(TwoWaysBar.a(this.d, str, 1));
    this.A.setTwoWaysBarListner((TwoWaysBar.TwoWaysBarListner)new TwoWaysBar.TowWaysBarListenerAdapter(this) {
          public void a(int param1Int1, int param1Int2) {
            Integer integer;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int1);
            stringBuilder.append("-");
            if (param1Int2 >= 100) {
              String str1 = "max";
            } else {
              integer = Integer.valueOf(param1Int2);
            } 
            stringBuilder.append(integer);
            String str = stringBuilder.toString();
            BluedPreferences.u(str);
            (PrivacySettingFragment.a(this.a)).b = str;
            PrivacySettingFragment.c(this.a).setText(TwoWaysBar.a(PrivacySettingFragment.b(this.a), param1Int1, param1Int2, 1));
          }
          
          public void a(boolean param1Boolean) {}
          
          public void b(boolean param1Boolean) {
            if (param1Boolean) {
              String str = BluedPreferences.Z();
              EventTrackVIP.a(VipProtos.Event.STEALTH_BTN_CLICK, VipProtos.StealthType.HALF, str.contains("max") ^ true);
            } 
          }
        });
    this.v = this.e.findViewById(2131298960);
    this.w = this.e.findViewById(2131301058);
    if (BluedConfig.b().B()) {
      this.v.setVisibility(0);
      this.w.setVisibility(0);
      this.v.setOnClickListener(new -$$Lambda$PrivacySettingFragment$zvF2qKxskAXMk3DdLTvfyY0VP2o(this));
    } else {
      this.v.setVisibility(8);
      this.w.setVisibility(8);
    } 
    this.C = this.e.findViewById(2131298767);
    this.C.setOnClickListener(new -$$Lambda$PrivacySettingFragment$6lYtELJx045TcWRcq5f86RSicVc(this));
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131758443));
    commonTopTitleNoTrans.setLeftClickListener(new -$$Lambda$PrivacySettingFragment$wZHs1JkS0hJ61mtZ1MVeM7HN5EM(this));
    this.f = (ToggleButton)this.e.findViewById(2131300239);
    this.f.setChecked(true);
    this.h = (ToggleButton)this.e.findViewById(2131300242);
    this.h.setChecked(true);
    this.g = (ToggleButton)this.e.findViewById(2131300258);
    this.g.setOnCheckedChangeListener(new -$$Lambda$PrivacySettingFragment$hfyAIrt5E0mqb6cycm0ApmcPAeU(this));
    this.i = (ToggleButton)this.e.findViewById(2131300247);
    this.i.setChecked(true);
    this.j = (ToggleButton)this.e.findViewById(2131300245);
    this.j.setOnCheckedChangeListener(-$$Lambda$PrivacySettingFragment$JD_0z2ItiAwM6VKmzjE8b2S2UPA.INSTANCE);
    this.k = (ToggleButton)this.e.findViewById(2131300241);
    this.k.setOnCheckedChangeListener(-$$Lambda$PrivacySettingFragment$Ae8lV45Fm5Y52xlsS6LhpeypwlI.INSTANCE);
    this.n = (ToggleButton)this.e.findViewById(2131300244);
    this.l = (ToggleButton)this.e.findViewById(2131300243);
    this.l.setOnCheckedChangeListener(-$$Lambda$PrivacySettingFragment$Ri8BmA0pRCHySDLchNps08JRTlo.INSTANCE);
    this.m = (ToggleButton)this.e.findViewById(2131300259);
    this.o = (ToggleButton)this.e.findViewById(2131300248);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.p = (LinearLayout)this.e.findViewById(2131298723);
    this.p.setOnClickListener(new -$$Lambda$PrivacySettingFragment$FVZ2kL8qLMyvKiAUBROsDQJgCL4(this));
    this.r = (TextView)this.e.findViewById(2131300573);
    this.s = (TextView)this.e.findViewById(2131300570);
    this.t.c();
    this.u = (LinearLayout)this.e.findViewById(2131298702);
    if ((BluedConfig.b().c()).allow_selected_setting == 1) {
      this.u.setVisibility(0);
    } else {
      this.u.setVisibility(8);
    } 
    this.B = (ShapeTextView)this.e.findViewById(2131300746);
    if (!BluedPreferences.dv())
      this.B.setVisibility(0); 
  }
  
  public void a(String paramString1, String paramString2) {
    this.r.setText(paramString1);
    TextView textView = this.s;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/");
    stringBuilder.append(paramString2);
    textView.setText(stringBuilder.toString());
  }
  
  public void b(boolean paramBoolean, String paramString) {
    BluedPreferences.u(paramString);
    this.A.a(paramString, 100);
    this.n.setChecked(paramBoolean);
    if (!paramBoolean) {
      this.y.setVisibility(8);
      this.A.setVisibility(8);
      return;
    } 
    this.y.setVisibility(0);
    this.A.setVisibility(0);
  }
  
  public void f(boolean paramBoolean) {
    this.f.setChecked(paramBoolean);
  }
  
  public void g(boolean paramBoolean) {
    this.h.setChecked(paramBoolean);
  }
  
  public void h(boolean paramBoolean) {
    BluedPreferences.v(paramBoolean);
    this.g.setChecked(paramBoolean);
  }
  
  public void i(boolean paramBoolean) {
    this.i.setChecked(paramBoolean);
  }
  
  public void j(boolean paramBoolean) {
    this.j.setChecked(paramBoolean);
  }
  
  public void k() {}
  
  public void k(boolean paramBoolean) {
    this.k.setChecked(paramBoolean);
  }
  
  public void l(boolean paramBoolean) {
    this.l.setChecked(paramBoolean);
  }
  
  public void m(boolean paramBoolean) {
    this.m.setChecked(paramBoolean ^ true);
  }
  
  public void n(boolean paramBoolean) {
    this.o.setChecked(paramBoolean);
  }
  
  public void onClick(View paramView) {
    int i = (UserInfo.a().i()).vip_grade;
    switch (paramView.getId()) {
      default:
        return;
      case 2131300245:
        if (i == 0 && (BluedConfig.b().j()).is_hide_last_operate == 0) {
          this.j.setChecked(false);
          EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK, false);
          PayUtils.a((Context)getActivity(), 0, "setting_hide_operate");
          InstantLog.a("setting_hide_last_operate_click", 0);
          return;
        } 
        InstantLog.a("setting_hide_last_operate_click", 1);
        return;
      case 2131300244:
        if (i == 0 && (BluedConfig.b().j()).is_invisible_half == 0) {
          this.n.setChecked(false);
          PayUtils.a((Context)getActivity(), 3, "setting_half_invisible");
          InstantLog.a("setting_half_invisible_click", 0);
          return;
        } 
        if (this.n.isChecked()) {
          String str1 = this.d.getResources().getString(2131758322);
          String str2 = this.d.getResources().getString(2131758323);
          CommonAlertDialog.a(this.d, str1, str2, null, new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  InstantLog.a("setting_half_invisible_click", 1);
                  if (PrivacySettingFragment.d(this.a).isChecked()) {
                    PrivacySettingFragment.e(this.a).setVisibility(0);
                    PrivacySettingFragment.f(this.a).setVisibility(0);
                    PrivacySettingFragment.f(this.a).a(BluedPreferences.Z(), 100);
                    return;
                  } 
                  PrivacySettingFragment.e(this.a).setVisibility(8);
                  PrivacySettingFragment.f(this.a).setVisibility(8);
                }
              }null, new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  PrivacySettingFragment.d(this.a).setChecked(false);
                  PrivacySettingFragment.e(this.a).setVisibility(8);
                  PrivacySettingFragment.f(this.a).setVisibility(8);
                }
              },  null);
          return;
        } 
        this.y.setVisibility(8);
        this.A.setVisibility(8);
        return;
      case 2131300243:
        if (i != 2 && (BluedConfig.b().j()).is_traceless_access == 0) {
          this.l.setChecked(false);
          EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_ACCESS_CLICK, false);
          PayUtils.a((Context)getActivity(), 11, "setting_traceless");
          InstantLog.a("setting_traceless_visit_click", 0);
          return;
        } 
        InstantLog.a("setting_traceless_visit_click", 1);
        return;
      case 2131300242:
        BluedPreferences.dw();
        this.B.setVisibility(8);
        EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_ANTI_HARASS, this.o.isChecked());
        return;
      case 2131300241:
        break;
    } 
    if (i == 0 && (BluedConfig.b().j()).is_hide_distance == 0) {
      this.k.setChecked(false);
      EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK, false);
      PayUtils.a((Context)getActivity(), 1, "setting_hide_distance");
      InstantLog.a("setting_hide_distance_click", 0);
      return;
    } 
    InstantLog.a("setting_hide_distance_click", 1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493278, paramViewGroup, false);
      this.d = (Context)getActivity();
      this.t = new PrivacySettingPresenter((Context)getActivity(), (IRequestHost)w_(), this);
      a();
      this.t.b();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onStart() {
    super.onStart();
    k();
    this.t.d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\PrivacySettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */