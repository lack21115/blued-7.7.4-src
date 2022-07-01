package com.soft.blued.ui.setting.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.settings.SettingsProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.qr_scan.CaptureActivity;
import com.soft.blued.ui.setting.Contract.SettingContract;
import com.soft.blued.ui.setting.Presenter.SettingPresenter;
import com.soft.blued.ui.setting.activity.SwitchAccountActivity;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import skin.support.observe.SkinObservable;

public class SettingFragment extends BaseFragment implements View.OnClickListener, BluedSkinObserver, SettingContract.IView {
  private Context d;
  
  private SettingContract.IPresenter e;
  
  private View f;
  
  private Dialog g;
  
  private LinearLayout h;
  
  private LinearLayout i;
  
  private LinearLayout j;
  
  private LinearLayout k;
  
  private LinearLayout l;
  
  private LinearLayout m;
  
  private LinearLayout n;
  
  private LinearLayout o;
  
  private LinearLayout p;
  
  private LinearLayout q;
  
  private CommonTopTitleNoTrans r;
  
  private TextView s;
  
  private TextView t;
  
  private TextView u;
  
  private View v;
  
  private RelativeLayout w;
  
  private ShapeTextView x;
  
  private ShapeTextView y;
  
  private ShapeTextView z;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, SettingFragment.class, null);
  }
  
  private void l() {
    this.r = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    this.r.e();
    this.r.a();
    this.r.setLeftImg(2131232743);
    this.r.setCenterText(getString(2131758707));
    this.r.setLeftClickListener(this);
    this.r.e();
    this.r.setCenterTextColor(2131100838);
    this.h = (LinearLayout)this.f.findViewById(2131298688);
    this.i = (LinearLayout)this.f.findViewById(2131298792);
    this.j = (LinearLayout)this.f.findViewById(2131298818);
    this.k = (LinearLayout)this.f.findViewById(2131299025);
    this.l = (LinearLayout)this.f.findViewById(2131299069);
    this.m = (LinearLayout)this.f.findViewById(2131299049);
    this.n = (LinearLayout)this.f.findViewById(2131299068);
    this.o = (LinearLayout)this.f.findViewById(2131298689);
    this.p = (LinearLayout)this.f.findViewById(2131298770);
    this.s = (TextView)this.f.findViewById(2131301211);
    this.t = (TextView)this.f.findViewById(2131301487);
    this.v = this.f.findViewById(2131301488);
    this.q = (LinearLayout)this.f.findViewById(2131299022);
    this.x = (ShapeTextView)this.f.findViewById(2131297934);
    this.u = (TextView)this.f.findViewById(2131301489);
    this.w = (RelativeLayout)this.f.findViewById(2131299731);
    this.y = (ShapeTextView)this.f.findViewById(2131297933);
    this.g = DialogUtils.a(this.d);
    this.z = (ShapeTextView)this.f.findViewById(2131301459);
    if (!BluedPreferences.cw())
      this.x.setVisibility(0); 
    if (!BluedPreferences.cA())
      this.y.setVisibility(0); 
    if (BluedPreferences.el()) {
      this.z.setVisibility(0);
      BluedPreferences.T(false);
      int i = BluedPreferences.ej();
      if (i != 1) {
        if (i != 2) {
          if (i == 3)
            this.z.setText(2131758712); 
        } else {
          this.z.setText(2131758711);
        } 
      } else {
        this.z.setText(2131755225);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("v");
    stringBuilder.append(DeviceUtils.c());
    String str2 = stringBuilder.toString();
    String str1 = str2;
    if ("a8888a".equals(AppInfo.c)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(" beta");
      str1 = stringBuilder1.toString();
    } 
    this.u.setText(str1);
    LiveEventBus.get("finish_setting", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            this.a.getActivity().finish();
          }
        });
  }
  
  private void m() {
    this.r.setLeftClickListener(this);
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.w.setOnClickListener(this);
  }
  
  public void a() {
    AppMethods.a(AppInfo.d().getResources().getString(2131756082));
  }
  
  public void a(SkinObservable paramSkinObservable, Object paramObject) {
    Log.e("skin", "SettingFragment updateSkin");
    CommonTopTitleNoTrans commonTopTitleNoTrans = this.r;
    if (commonTopTitleNoTrans != null) {
      commonTopTitleNoTrans.setCenterTextColor(2131100838);
      int i = BluedSkinUtils.a(getContext(), 2131100728);
      getActivity().findViewById(16908290).setBackgroundColor(i);
    } 
    StatusBarHelper.a((Activity)getActivity());
    StatusBarHelper.a((Activity)getActivity(), BluedSkinUtils.a(getContext(), AppInfo.k()));
  }
  
  public void a(VerifyStatus[] paramArrayOfVerifyStatus) {
    if (paramArrayOfVerifyStatus != null && paramArrayOfVerifyStatus.length > 0) {
      String str = (paramArrayOfVerifyStatus[0]).has_audited;
      this.t.setTextColor(BluedSkinUtils.a(this.d, 2131100838));
      if ("1".equals(str)) {
        this.t.setText(getResources().getString(2131759196));
        return;
      } 
      if ("2".equals(str)) {
        this.t.setText(getResources().getString(2131759105));
        if (!BluedPreferences.aN().equals((paramArrayOfVerifyStatus[0]).verified_time)) {
          this.v.setVisibility(0);
          BluedPreferences.y((paramArrayOfVerifyStatus[0]).verified_time);
        } 
        this.t.setTextColor(getResources().getColor(2131100538));
        return;
      } 
      if ("0".equals(str)) {
        this.t.setText(getResources().getString(2131759209));
        return;
      } 
      this.t.setText(getResources().getString(2131759198));
    } 
  }
  
  public void a(VerifyStatus[] paramArrayOfVerifyStatus, String paramString1, String paramString2, String paramString3, String paramString4) {
    if (this.v.getVisibility() != 8) {
      this.v.setVisibility(8);
      if (paramArrayOfVerifyStatus != null && paramArrayOfVerifyStatus.length > 0)
        BluedPreferences.y((paramArrayOfVerifyStatus[0]).verified_time); 
    } 
    if (paramArrayOfVerifyStatus != null && paramArrayOfVerifyStatus.length > 0 && "1".equals((paramArrayOfVerifyStatus[0]).has_audited)) {
      String str = (paramArrayOfVerifyStatus[0]).verified_time;
      ShowVerifyFragment.a((Context)getActivity(), paramString2, paramString3, str, paramString4, false);
      return;
    } 
    PersonalVerifyFragment.a((Context)getActivity(), 2);
  }
  
  public void k() {
    CommonAlertDialog.a((Context)getActivity(), getResources().getString(2131756094), getResources().getString(2131756107), getString(2131755609), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            SettingFragment.a(this.a).c();
          }
        },  getString(2131755577), null, null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 != -1 || paramIntent != null);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    Intent intent;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301211:
        InstantLog.a("logout_btn_click");
        EventTrackSettings.a(SettingsProtos.Event.LOGOUT_BTN_CLICK);
        k();
        return;
      case 2131299731:
        startActivity((new Intent()).setClass((Context)getActivity(), SwitchAccountActivity.class));
        if (!BluedPreferences.cA()) {
          BluedPreferences.cB();
          this.y.setVisibility(8);
          return;
        } 
        return;
      case 2131299069:
        intent = new Intent((Context)getActivity(), CaptureActivity.class);
        getActivity().startActivity(intent);
        return;
      case 2131299068:
        InstantLog.b("my_model", 9);
        WebViewShowInfoFragment.show(this.d, BluedHttpUrl.f(), -1);
        return;
      case 2131299049:
        InstantLog.b("my_model", 6);
        TerminalActivity.d((Context)getActivity(), RemindSettingFragment.class, null);
        return;
      case 2131299025:
        InstantLog.b("my_model", 7);
        TerminalActivity.d(this.d, PrivacySettingFragment.class, null);
        return;
      case 2131299022:
        WebViewShowInfoFragment.show((Context)getActivity(), H5Url.a(21), 0);
        return;
      case 2131298818:
        InstantLog.b("my_model", 8);
        GeneralFragment.a((Context)getActivity());
        if (!BluedPreferences.cw()) {
          BluedPreferences.cx();
          this.x.setVisibility(8);
          return;
        } 
        return;
      case 2131298792:
        InstantLog.b("my_model", 4);
        this.e.b();
        return;
      case 2131298770:
        DebugFragment.a(this.d);
        return;
      case 2131298689:
        InstantLog.b("my_model", 5);
        AccountAndSafetyFragment.a(this.d);
        return;
      case 2131298688:
        InstantLog.b("my_model", 10);
        TerminalActivity.d((Context)getActivity(), AboutBluedFragment.class, null);
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    getActivity().findViewById(16908290).setBackgroundColor(BluedSkinUtils.a(this.d, 2131100728));
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493313, paramViewGroup, false);
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    BluedSkinUtils.b(this);
  }
  
  public void onResume() {
    super.onResume();
    BluedSkinUtils.a(this);
  }
  
  public void onStart() {
    super.onStart();
    this.e.bb_();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    m();
    this.e = (SettingContract.IPresenter)new SettingPresenter(this, this.d, w_());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\SettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */