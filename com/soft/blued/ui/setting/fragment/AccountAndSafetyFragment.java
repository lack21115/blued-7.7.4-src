package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.share.Util;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.login_register.LinkMobileSuccessFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.setting.Contract.AccountAndSafetyContract;
import com.soft.blued.ui.setting.Presenter.AccountAndSafetyPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class AccountAndSafetyFragment extends BaseFragment implements View.OnClickListener, AccountAndSafetyContract.IView {
  private View d;
  
  private Context e;
  
  private AccountAndSafetyContract.IPresenter f;
  
  private Dialog g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private LinearLayout k;
  
  private LinearLayout l;
  
  private LinearLayout m;
  
  private LinearLayout n;
  
  private LinearLayout o;
  
  private LinearLayout p;
  
  private CommonTopTitleNoTrans q;
  
  private String r;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, AccountAndSafetyFragment.class, null);
  }
  
  private void k() {
    this.q = (CommonTopTitleNoTrans)this.d.findViewById(2131300300);
    this.q.a();
    this.q.setLeftImg(2131232743);
    this.q.setCenterText(getString(2131755218));
    this.q.setLeftClickListener(this);
    this.k = (LinearLayout)this.d.findViewById(2131298954);
    this.l = (LinearLayout)this.d.findViewById(2131298720);
    this.m = (LinearLayout)this.d.findViewById(2131298721);
    this.n = (LinearLayout)this.d.findViewById(2131299050);
    this.o = (LinearLayout)this.d.findViewById(2131298930);
    this.p = (LinearLayout)this.d.findViewById(2131298719);
    this.h = (TextView)this.d.findViewById(2131300566);
    this.i = (TextView)this.d.findViewById(2131300568);
    this.j = (TextView)this.d.findViewById(2131301004);
    this.g = DialogUtils.a(this.e);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    if (BluedConfig.b().s()) {
      this.n.setVisibility(0);
      return;
    } 
    this.n.setVisibility(8);
  }
  
  public void a() {
    DialogUtils.a(this.g);
  }
  
  public void a(String paramString) {
    this.r = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      this.i.setText(2131755049);
      this.i.setTextColor(getActivity().getResources().getColor(2131100543));
      return;
    } 
    this.i.setText(2131759097);
    this.i.setTextColor(getActivity().getResources().getColor(2131100538));
  }
  
  public void b() {
    DialogUtils.b(this.g);
  }
  
  public void b(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (BlueAppLocal.d()) {
        this.h.setText(paramString);
      } else {
        this.h.setText(ChatManager.context.getString(2131755049));
      } 
      this.h.setTextColor(getActivity().getResources().getColor(2131100543));
      return;
    } 
    this.h.setText(2131759097);
    this.h.setTextColor(getActivity().getResources().getColor(2131100538));
  }
  
  public void onClick(View paramView) {
    String str;
    Bundle bundle;
    switch (paramView.getId()) {
      default:
        return;
      case 2131299050:
        EventTrackSettings.a(SettingsProtos.Event.CANCEL_ACCOUNT_BTN_CLICK);
        WebViewShowInfoFragment.show(this.e, H5Url.a(9), -1);
        return;
      case 2131298954:
        EventTrackSettings.a(SettingsProtos.Event.PWD_SETTINGS_CLICK);
        TerminalActivity.d(this.e, PasswordSettingFragment.class, null);
        return;
      case 2131298930:
        InstantLog.a("login_protection");
        EventTrackSettings.a(SettingsProtos.Event.LOGIN_PROTECTION);
        LoginDeviceListFragment.a(this.e);
        return;
      case 2131298721:
        if (!StringUtils.e(LoginRegisterTools.c())) {
          CommonAlertDialog.a(this.e, getString(2131759346), getString(2131759355), getString(2131759353), getString(2131755577), new View.OnClickListener(this) {
                public void onClick(View param1View) {
                  AccountAndSafetyFragment.a(this.a).c();
                }
              },  null);
        } else if (!Util.isClientAvailable(ChatManager.context, "com.tencent.mm")) {
          AppMethods.a(getString(2131759359));
        } else {
          this.f.b();
        } 
        if (!TextUtils.isEmpty(this.r)) {
          InstantLog.a("bound_wechat");
          EventTrackSettings.a(SettingsProtos.Event.BOUND_WECHAT);
          return;
        } 
        InstantLog.a("unbound_wechat");
        EventTrackSettings.a(SettingsProtos.Event.UNBOUND_WECHAT);
        return;
      case 2131298720:
        str = LoginRegisterTools.d();
        bundle = new Bundle();
        bundle.putString(LoginRegisterTools.f, str);
        bundle.putInt(LoginRegisterTools.a, 0);
        if (TextUtils.isEmpty(str)) {
          bundle.putString("binding_type", "add");
          TerminalActivity.d(this.e, BindingSecureEmailFragment.class, bundle);
          return;
        } 
        TerminalActivity.d(this.e, LinkMobileSuccessFragment.class, bundle);
        return;
      case 2131298719:
        WebViewShowInfoFragment.show(this.e, H5Url.a(8), -1);
        return;
      case 2131296863:
        break;
    } 
    a(new Runnable(this) {
          public void run() {
            this.a.getActivity().finish();
          }
        });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493070, paramViewGroup, false);
      this.f = (AccountAndSafetyContract.IPresenter)new AccountAndSafetyPresenter(this.e, this, (IRequestHost)w_());
      k();
    } else {
      ((ViewGroup)view.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  public void onStart() {
    super.onStart();
    this.f.bb_();
    if (BluedPreferences.bF()) {
      this.j.setText(getResources().getString(2131758328));
      this.j.setTextColor(getResources().getColor(2131100543));
      return;
    } 
    this.j.setText(getResources().getString(2131756024));
    this.j.setTextColor(getResources().getColor(2131100538));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\AccountAndSafetyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */