package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.discover.model.DiscoveryPageTabModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.controller.tools.IMManager;
import com.soft.blued.ui.msg.model.MessageTabModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import java.util.Locale;

public class LanguageSelectFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private CommonTopTitleNoTrans f;
  
  private Dialog g;
  
  private String h = LanguageSelectFragment.class.getSimpleName();
  
  private View i;
  
  private View j;
  
  private View k;
  
  private View l;
  
  private TextView m;
  
  private LinearLayout n;
  
  private LinearLayout o;
  
  private LinearLayout p;
  
  private LinearLayout q;
  
  private int r;
  
  private int s;
  
  private long t = 3000L;
  
  private Handler u = new Handler();
  
  private boolean v = false;
  
  private void a() {
    this.f = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    this.f.setCenterText(getString(2131757099));
    this.f.setRightText(2131758642);
    this.f.setRightTextColor(2131100720);
    this.f.setLeftClickListener(this);
    this.f.setRightClickListener(this);
  }
  
  private void a(int paramInt) {
    if (paramInt == 1) {
      this.k.setVisibility(0);
      this.j.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      return;
    } 
    if (paramInt == 2) {
      this.k.setVisibility(8);
      this.j.setVisibility(0);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      return;
    } 
    if (paramInt == 3) {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(0);
      this.l.setVisibility(8);
      return;
    } 
    if (paramInt == 4) {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(0);
      return;
    } 
    if (paramInt == 5) {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      return;
    } 
    if (paramInt == 6) {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      return;
    } 
    if (paramInt == 7) {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      return;
    } 
    if (paramInt == 8) {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      return;
    } 
    if (paramInt == 9) {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      return;
    } 
    if (paramInt == 10) {
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
    } 
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, LanguageSelectFragment.class, null);
  }
  
  private void a(String paramString1, String paramString2) {
    LocaleUtils.a(false);
    LocaleUtils.a(this.d, new Locale(paramString1, paramString2));
    BluedConfig.b().e();
    k();
  }
  
  private void k() {
    long l = System.currentTimeMillis();
    DialogUtils.a(this.g);
    MineHttpUtils.e(this.d, new BluedUIHttpResponse(this, l) {
          public void onUIFinish() {
            long l = System.currentTimeMillis() - this.a;
            if (l >= 3000L) {
              DialogUtils.b(LanguageSelectFragment.a(this.b));
              LocaleUtils.c(AppInfo.d());
              Intent intent = new Intent(LanguageSelectFragment.b(this.b), HomeActivity.class);
              intent.setFlags(268468224);
              LanguageSelectFragment.b(this.b).startActivity(intent);
              ChatManager.getInstance().initLanguage();
              IMManager.a().c();
              LiveMsgSendManager.a().c();
              return;
            } 
            LanguageSelectFragment.d(this.b).postDelayed(new Runnable(this) {
                  public void run() {
                    if (LanguageSelectFragment.b(this.a.b) != null) {
                      DialogUtils.b(LanguageSelectFragment.a(this.a.b));
                      LocaleUtils.c(AppInfo.d());
                      Intent intent = new Intent(LanguageSelectFragment.b(this.a.b), HomeActivity.class);
                      intent.setFlags(268468224);
                      LanguageSelectFragment.b(this.a.b).startActivity(intent);
                      ChatManager.getInstance().initLanguage();
                      LiveMsgSendManager.a().c();
                    } 
                  }
                }LanguageSelectFragment.c(this.b) - l);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  private void l() {
    String str1;
    this.g = DialogUtils.a(this.d);
    this.m = (TextView)this.e.findViewById(2131301366);
    this.l = this.e.findViewById(2131301318);
    this.j = this.e.findViewById(2131301323);
    this.i = this.e.findViewById(2131301324);
    this.k = this.e.findViewById(2131301321);
    Locale locale2 = LocaleUtils.e();
    String str2 = locale2.getLanguage();
    String str3 = locale2.getCountry();
    if (!TextUtils.isEmpty(str2)) {
      TextView textView;
      if (str2.equals("zh")) {
        if (!TextUtils.isEmpty(str3) && (str3.equals("TW") || str3.equals("HK"))) {
          textView = this.m;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(getResources().getString(2131757102));
          stringBuilder.append(" (");
          stringBuilder.append(getResources().getString(2131757105));
          stringBuilder.append(")");
          textView.setText(stringBuilder.toString());
        } else {
          textView = this.m;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(getResources().getString(2131757102));
          stringBuilder.append(" (");
          stringBuilder.append(getResources().getString(2131757104));
          stringBuilder.append(")");
          textView.setText(stringBuilder.toString());
        } 
      } else if (textView.equals("en")) {
        textView = this.m;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131757102));
        stringBuilder.append(" (");
        stringBuilder.append(getResources().getString(2131757094));
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
      } else {
        textView = this.m;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131757102));
        stringBuilder.append(" (");
        stringBuilder.append(getResources().getString(2131757094));
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
      } 
    } else {
      this.m.setText(getResources().getString(2131757102));
    } 
    Locale locale1 = LocaleUtils.c();
    boolean bool = LocaleUtils.a();
    str3 = "";
    if (!bool && locale1 != null) {
      str3 = locale1.getLanguage();
      str1 = locale1.getCountry();
    } else {
      str1 = "";
    } 
    if (!TextUtils.isEmpty(str3)) {
      if (str3.equals("zh")) {
        if (!TextUtils.isEmpty(str1) && (TextUtils.equals(str1, "TW") || TextUtils.equals(str1, "HK"))) {
          this.s = 3;
          this.r = 3;
        } else {
          this.s = 2;
          this.r = 2;
        } 
      } else if (str3.equals("en")) {
        this.s = 4;
        this.r = 4;
      } else if (str3.equals("ja")) {
        this.s = 4;
        this.r = 4;
      } else if (str3.equals("ko")) {
        this.s = 4;
        this.r = 4;
      } else if (str3.equals("th")) {
        this.s = 4;
        this.r = 4;
      } else if (str3.equals("fr")) {
        this.s = 4;
        this.r = 4;
      } else if (str3.equals("es")) {
        this.s = 4;
        this.r = 4;
      } else if (str3.equals("pt")) {
        this.s = 4;
        this.r = 4;
      } else {
        this.s = 1;
        this.r = 1;
      } 
    } else {
      this.s = 1;
      this.r = 1;
    } 
    a(this.r);
    this.n = (LinearLayout)this.e.findViewById(2131299090);
    this.n.setOnClickListener(this);
    this.o = (LinearLayout)this.e.findViewById(2131299147);
    this.o.setOnClickListener(this);
    this.p = (LinearLayout)this.e.findViewById(2131299148);
    this.p.setOnClickListener(this);
    this.q = (LinearLayout)this.e.findViewById(2131298784);
    this.q.setOnClickListener(this);
  }
  
  public boolean V_() {
    getActivity().finish();
    return true;
  }
  
  public void onClick(View paramView) {
    int i;
    switch (paramView.getId()) {
      default:
        return;
      case 2131299148:
        this.s = 3;
        a(this.s);
        this.v = true;
        this.f.setRightTextColor(2131100716);
        return;
      case 2131299147:
        this.s = 2;
        a(this.s);
        this.v = true;
        this.f.setRightTextColor(2131100716);
        return;
      case 2131299090:
        this.s = 1;
        a(this.s);
        this.v = true;
        this.f.setRightTextColor(2131100716);
        return;
      case 2131298784:
        this.s = 4;
        a(this.s);
        this.v = true;
        this.f.setRightTextColor(2131100716);
        return;
      case 2131296867:
        if (!this.v)
          return; 
        DiscoveryPageTabModel.clearTabs();
        MessageTabModel.clearTabs();
        i = this.s;
        if (i == 1) {
          LocaleUtils.a(true);
          LocaleUtils.a(this.d, LocaleUtils.e());
          BluedConfig.b().e();
          k();
          return;
        } 
        if (i == 2) {
          a("zh", "CN");
          return;
        } 
        if (i == 3) {
          a("zh", "TW");
          return;
        } 
        if (i == 4) {
          a("en", "US");
          return;
        } 
        if (i == 5) {
          a("ja", "JP");
          return;
        } 
        if (i == 6) {
          a("ko", "KR");
          return;
        } 
        if (i == 7) {
          a("th", "TH");
          return;
        } 
        if (i == 8) {
          a("fr", "FR");
          return;
        } 
        if (i == 9) {
          a("es", "ES");
          return;
        } 
        if (i == 10) {
          a("pt", "PT");
          return;
        } 
        return;
      case 2131296863:
        break;
    } 
    V_();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493162, paramViewGroup, false);
      a();
      l();
    } else {
      ((ViewGroup)view.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\LanguageSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */