package com.geetest.onelogin.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.config.AuthRegisterViewConfig;
import com.geetest.onelogin.config.OneLoginThemeConfig;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.g.c;
import com.geetest.onelogin.g.d;
import com.geetest.onelogin.h.a;
import com.geetest.onelogin.h.b;
import com.geetest.onelogin.j.d;
import com.geetest.onelogin.j.e;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.k;
import com.geetest.onelogin.j.r;
import com.geetest.onelogin.listener.a;
import com.geetest.onelogin.listener.a.a;
import com.geetest.onelogin.listener.c;
import com.geetest.onelogin.listener.e;
import com.geetest.onelogin.view.GTGifView;
import com.geetest.onelogin.view.GTVideoView;
import com.geetest.onelogin.view.LoadingImageView;
import com.geetest.onelogin.view.a;
import com.geetest.onelogin.view.b;
import com.geetest.onelogin.view.c;
import java.util.HashMap;

public class OneLoginActivity extends Activity implements View.OnClickListener, a.a {
  private TextView a;
  
  private TextView b;
  
  private TextView c;
  
  private TextView d;
  
  private TextView e;
  
  private TextView f;
  
  private CheckBox g;
  
  private Context h;
  
  private RelativeLayout i;
  
  private RelativeLayout j;
  
  private RelativeLayout k;
  
  private LinearLayout l;
  
  private ImageView m;
  
  private ImageView n;
  
  private boolean o = false;
  
  private c p;
  
  private GTVideoView q;
  
  private LoadingImageView r;
  
  private GTGifView s;
  
  private RelativeLayout t;
  
  private RelativeLayout u;
  
  private OneLoginThemeConfig v;
  
  private d w;
  
  private int x;
  
  private int y;
  
  private b z;
  
  private void a(String paramString1, String paramString2) {
    b.w().a(a.a(paramString1), paramString2);
  }
  
  private void e() throws Exception {
    this.k = (RelativeLayout)findViewById(a.a("gt_one_login_main_layout", this.h));
    this.i = (RelativeLayout)findViewById(a.a("gt_one_login_nav_layout", this.h));
    this.a = (TextView)findViewById(a.a("gt_one_login_nav_title", this.h));
    this.m = (ImageView)findViewById(a.a("gt_one_login_nav_iv", this.h));
    this.n = (ImageView)findViewById(a.a("gt_one_login_logo", this.h));
    this.c = (TextView)findViewById(a.a("gt_one_login_switch_tv", this.h));
    this.b = (TextView)findViewById(a.a("gt_one_login_number_tv", this.h));
    this.f = (TextView)findViewById(a.a("gt_one_login_param_tv", this.h));
    this.d = (TextView)findViewById(a.a("gt_one_login_login_tv", this.h));
    this.g = (CheckBox)findViewById(a.a("gt_one_login_check", this.h));
    this.j = (RelativeLayout)findViewById(a.a("gt_one_login_bg_layout", this.h));
    this.u = (RelativeLayout)findViewById(a.a("gt_one_login_switch_layout", this.h));
    this.t = (RelativeLayout)findViewById(a.a("gt_one_login_submit_layout", this.h));
    this.e = (TextView)findViewById(a.a("gt_one_login_submit_tv", this.h));
    this.l = (LinearLayout)findViewById(a.a("gt_one_login_privacy_ll", this.h));
    f();
    g();
    h();
    i();
    j();
    k();
    l();
  }
  
  private void f() throws Exception {
    String str3 = this.v.getAuthBGImgPath();
    String str2 = this.v.getAuthBgVideoUri();
    this.p = new c((View)this.j);
    this.p.a(this.h, str3);
    if (!TextUtils.isEmpty(str2)) {
      this.q = new GTVideoView(this.h);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
      this.j.addView((View)this.q, 0, (ViewGroup.LayoutParams)layoutParams2);
      r.a((VideoView)this.q, this.h, str2);
    } 
    this.a.setText(this.v.getNavText());
    this.a.setTextColor(this.v.getNavTextColor());
    this.a.setTextSize(this.v.getNavTextSize());
    this.a.setTypeface(this.v.getNavTextTypeface());
    if (this.v.isAuthNavGone()) {
      this.i.setVisibility(8);
      return;
    } 
    this.i.setBackgroundColor(this.v.getNavColor());
    if (this.v.isAuthNavTransparent())
      this.i.getBackground().setAlpha(0); 
    ViewGroup.LayoutParams layoutParams1 = this.i.getLayoutParams();
    layoutParams1.height = d.a(getApplicationContext(), this.v.getAuthNavHeight());
    this.i.setLayoutParams(layoutParams1);
    this.m.setBackgroundColor(0);
    if (this.v.isNavReturnImgHidden()) {
      this.m.setVisibility(4);
      return;
    } 
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.m.getLayoutParams();
    layoutParams.width = d.a(getApplicationContext(), this.v.getReturnImgWidth());
    layoutParams.height = d.a(getApplicationContext(), this.v.getReturnImgHeight());
    layoutParams.leftMargin = d.a(getApplicationContext(), this.v.getReturnImgOffsetX());
    if (this.v.isReturnImgCenterInVertical()) {
      layoutParams.gravity = 16;
    } else {
      layoutParams.topMargin = d.a(getApplicationContext(), this.v.getReturnImgOffsetY());
    } 
    this.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    String str1 = this.v.getNavReturnImgPath();
    if (TextUtils.isEmpty(str1)) {
      h.c("NavReturnImgPath is null");
      return;
    } 
    this.m.setImageResource(a.b(str1, this.h));
  }
  
  private void g() throws Exception {
    if (this.v.isLogoHidden()) {
      this.n.setVisibility(4);
      return;
    } 
    String str = this.v.getLogoImgPath();
    if (TextUtils.isEmpty(str)) {
      h.c("LogoImgPath is null");
    } else {
      this.n.setImageResource(a.b(str, this.h));
    } 
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
    layoutParams.width = d.a(getApplicationContext(), this.v.getLogoWidth());
    layoutParams.height = d.a(getApplicationContext(), this.v.getLogoHeight());
    if (this.v.getLogoOffsetX() != 0) {
      layoutParams.leftMargin = d.a(getApplicationContext(), this.v.getLogoOffsetX());
      if (this.v.getLogoOffsetY_B() == 0) {
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = d.a(getApplicationContext(), this.v.getLogoOffsetY());
      } else {
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.bottomMargin = d.a(getApplicationContext(), this.v.getLogoOffsetY_B());
      } 
    } else if (this.v.getLogoOffsetY_B() == 0) {
      layoutParams.addRule(10);
      layoutParams.topMargin = d.a(getApplicationContext(), this.v.getLogoOffsetY());
    } else {
      layoutParams.addRule(12);
      layoutParams.bottomMargin = d.a(getApplicationContext(), this.v.getLogoOffsetY_B());
    } 
    this.n.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void h() throws Exception {
    this.c.setTextColor(this.v.getSwitchColor());
    this.c.setText(this.v.getSwitchText());
    this.c.setTextSize(this.v.getSwitchSize());
    this.c.setTypeface(this.v.getSwitchViewTypeface());
    if (this.v.isSwitchAccHidden()) {
      this.u.setVisibility(4);
      this.c.setVisibility(4);
      return;
    } 
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
    String str = this.v.getSwitchImgPath();
    if (!TextUtils.isEmpty(str))
      this.u.setBackgroundResource(a.b(str, this.h)); 
    layoutParams.width = d.a(getApplicationContext(), this.v.getSwitchWidth());
    layoutParams.height = d.a(getApplicationContext(), this.v.getSwitchHeight());
    if (this.v.getSwitchOffsetX() != 0) {
      layoutParams.leftMargin = d.a(getApplicationContext(), this.v.getSwitchOffsetX());
      if (this.v.getSwitchOffsetY_B() == 0) {
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = d.a(getApplicationContext(), this.v.getSwitchAccOffsetY());
      } else {
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.bottomMargin = d.a(getApplicationContext(), this.v.getSwitchOffsetY_B());
      } 
    } else if (this.v.getSwitchOffsetY_B() == 0) {
      layoutParams.addRule(10);
      layoutParams.topMargin = d.a(getApplicationContext(), this.v.getSwitchAccOffsetY());
    } else {
      layoutParams.addRule(12);
      layoutParams.bottomMargin = d.a(getApplicationContext(), this.v.getSwitchOffsetY_B());
    } 
    this.u.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void i() throws Exception {
    String str2 = this.v.getLoginImgPath();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "gt_one_login_btn_normal"; 
    this.t.setBackgroundResource(a.b(str1, this.h));
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
    layoutParams.width = d.a(getApplicationContext(), this.v.getLogBtnWidth());
    layoutParams.height = d.a(getApplicationContext(), this.v.getLogBtnHeight());
    if (this.v.getLogBtnOffsetX() != 0) {
      layoutParams.leftMargin = d.a(getApplicationContext(), this.v.getLogBtnOffsetX());
      if (this.v.getLogBtnOffsetY_B() == 0) {
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = d.a(getApplicationContext(), this.v.getLogBtnOffsetY());
      } else {
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.bottomMargin = d.a(getApplicationContext(), this.v.getLogBtnOffsetY_B());
      } 
    } else {
      layoutParams.addRule(14);
      if (this.v.getLogBtnOffsetY_B() == 0) {
        layoutParams.addRule(10);
        layoutParams.topMargin = d.a(getApplicationContext(), this.v.getLogBtnOffsetY());
      } else {
        layoutParams.addRule(12);
        layoutParams.bottomMargin = d.a(getApplicationContext(), this.v.getLogBtnOffsetY_B());
      } 
    } 
    this.t.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.e.setText(this.v.getLoginButtonText());
    this.e.setTextColor(this.v.getLoginButtonColor());
    this.e.setTextSize(this.v.getLogBtnTextSize());
    this.e.setTypeface(this.v.getLogBtnTextViewTypeface());
    if (this.v.isDisableBtnIfUnChecked())
      this.t.setEnabled(this.v.isPrivacyState()); 
  }
  
  private void j() throws Exception {
    LinearLayout.LayoutParams layoutParams;
    String str = this.v.getLoadingView();
    if (TextUtils.isEmpty(str))
      return; 
    int i = a.b(str, this.h);
    str = e.a(this.h.getResources().openRawResource(i));
    if (e.a(str)) {
      this.s = (GTGifView)findViewById(a.a("gt_one_login_submit_gif", this.h));
      this.s.setGifResource(i);
      layoutParams = (LinearLayout.LayoutParams)this.s.getLayoutParams();
    } else if (e.b((String)layoutParams)) {
      this.r = (LoadingImageView)findViewById(a.a("gt_one_login_submit_iv", this.h));
      this.r.setImageResource(i);
      layoutParams = (LinearLayout.LayoutParams)this.r.getLayoutParams();
    } else {
      return;
    } 
    layoutParams.width = d.a(getApplicationContext(), this.v.getLoadingViewWidth());
    layoutParams.rightMargin = d.a(getApplicationContext(), this.v.getLoadingViewOffsetRight());
    layoutParams.height = d.a(getApplicationContext(), this.v.getLoadingViewHeight());
    if (this.v.isLoadingViewCenterInVertical()) {
      layoutParams.gravity = 21;
    } else {
      layoutParams.topMargin = d.a(getApplicationContext(), this.v.getLoadingViewOffsetY());
    } 
    GTGifView gTGifView = this.s;
    if (gTGifView != null) {
      gTGifView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      return;
    } 
    LoadingImageView loadingImageView = this.r;
    if (loadingImageView != null)
      loadingImageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams); 
  }
  
  private void k() throws Exception {
    this.b.setText(this.w.getNumber());
    this.b.setTypeface(this.v.getNumberViewTypeface());
    this.b.setTextColor(this.v.getNumberColor());
    this.b.setTextSize(this.v.getNumberSize());
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    layoutParams.width = -2;
    layoutParams.height = -2;
    if (this.v.getNumFieldOffsetX() != 0) {
      layoutParams.leftMargin = d.a(getApplicationContext(), this.v.getNumFieldOffsetX());
      if (this.v.getNumFieldOffsetY_B() == 0) {
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = d.a(getApplicationContext(), this.v.getNumFieldOffsetY());
      } else {
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.bottomMargin = d.a(getApplicationContext(), this.v.getNumFieldOffsetY_B());
      } 
    } else if (this.v.getNumFieldOffsetY_B() == 0) {
      layoutParams.addRule(10);
      layoutParams.topMargin = d.a(getApplicationContext(), this.v.getNumFieldOffsetY());
    } else {
      layoutParams.addRule(12);
      layoutParams.bottomMargin = d.a(getApplicationContext(), this.v.getNumFieldOffsetY_B());
    } 
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void l() throws Exception {
    this.d.setTextColor(this.v.getSloganColor());
    this.d.setTextSize(this.v.getSloganSize());
    this.d.setTypeface(this.v.getSloganViewTypeface());
    RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    layoutParams1.width = -2;
    layoutParams1.height = -2;
    if (this.v.getSloganOffsetX() != 0) {
      layoutParams1.leftMargin = d.a(getApplicationContext(), this.v.getSloganOffsetX());
      if (this.v.getSloganOffsetY_B() == 0) {
        layoutParams1.addRule(10);
        layoutParams1.addRule(9);
        layoutParams1.topMargin = d.a(getApplicationContext(), this.v.getSloganOffsetY());
      } else {
        layoutParams1.addRule(12);
        layoutParams1.addRule(9);
        layoutParams1.bottomMargin = d.a(getApplicationContext(), this.v.getSloganOffsetY_B());
      } 
    } else if (this.v.getSloganOffsetY_B() == 0) {
      layoutParams1.addRule(10);
      layoutParams1.topMargin = d.a(getApplicationContext(), this.v.getSloganOffsetY());
    } else {
      layoutParams1.addRule(12);
      layoutParams1.bottomMargin = d.a(getApplicationContext(), this.v.getSloganOffsetY_B());
    } 
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
    layoutParams1.width = d.a(getApplicationContext(), this.v.getPrivacyLayoutWidth());
    layoutParams1.height = -2;
    if (this.v.getPrivacyOffsetX() == 0) {
      layoutParams1.addRule(14);
    } else {
      layoutParams1.addRule(5);
      layoutParams1.leftMargin = d.a(getApplicationContext(), this.v.getPrivacyOffsetX());
    } 
    if (this.v.getPrivacyOffsetY_B() == 0) {
      layoutParams1.addRule(10);
      layoutParams1.topMargin = d.a(getApplicationContext(), this.v.getPrivacyOffsetY());
    } else {
      layoutParams1.addRule(12);
      layoutParams1.bottomMargin = d.a(getApplicationContext(), this.v.getPrivacyOffsetY_B());
    } 
    this.l.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.f.setTextColor(this.v.getBaseClauseColor());
    this.f.setTextSize(this.v.getPrivacyClauseTextSize());
    this.f.setGravity(this.v.getPrivacyTextGravity());
    c c1 = d.a(this.w.getOperator());
    if (c1 != null) {
      this.d.setText(c1.a());
      k.b(this.f, c1.b(), c1.c(), this.v, getApplicationContext());
    } 
    String str2 = this.v.getCheckedImgPath();
    String str3 = this.v.getUnCheckedImgPath();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "gt_one_login_checked"; 
    str2 = str3;
    if (TextUtils.isEmpty(str3))
      str2 = "gt_one_login_unchecked"; 
    this.x = a.b(str1, this.h);
    this.y = a.b(str2, this.h);
    if (this.v.isPrivacyState()) {
      this.g.setChecked(true);
      this.g.setBackgroundResource(this.x);
    } else {
      this.g.setChecked(false);
      this.g.setBackgroundResource(this.y);
    } 
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.g.getLayoutParams();
    layoutParams.width = d.a(getApplicationContext(), this.v.getPrivacyCheckBoxWidth());
    layoutParams.height = d.a(getApplicationContext(), this.v.getPrivacyCheckBoxHeight());
    layoutParams.topMargin = d.a(getApplicationContext(), this.v.getPrivacyCheckBoxOffsetY());
    this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void m() {
    this.m.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            b.w().a(param1Boolean);
            if (param1Boolean) {
              try {
                OneLoginActivity.b(this.a).setBackgroundResource(OneLoginActivity.a(this.a));
                if (OneLoginActivity.d(this.a).isDisableBtnIfUnChecked()) {
                  OneLoginActivity.e(this.a).setEnabled(OneLoginActivity.b(this.a).isChecked());
                  return;
                } 
              } catch (Exception exception) {
                h.c(exception.toString());
              } 
            } else {
              OneLoginActivity.b(this.a).setBackgroundResource(OneLoginActivity.c(this.a));
              if (OneLoginActivity.d(this.a).isDisableBtnIfUnChecked()) {
                OneLoginActivity.e(this.a).setEnabled(OneLoginActivity.b(this.a).isChecked());
                return;
              } 
            } 
          }
        });
    this.g.setOnClickListener(this);
    if (a.a()) {
      this.z = new b();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Captcha 参数配置 api1=");
      stringBuilder.append(a.b());
      stringBuilder.append(", api2=");
      stringBuilder.append(a.c());
      stringBuilder.append(", timeout=");
      stringBuilder.append(a.d());
      h.b(stringBuilder.toString());
      this.z.a((Context)this, a.b(), a.c(), a.d(), new e(this) {
            public void a() {
              h.b("requestToken mode: 2");
              b.w().B();
            }
            
            public void b() {}
          });
    } 
  }
  
  private void n() {
    if (!b.w().f())
      return; 
    try {
      HashMap hashMap = b.w().g();
      if (hashMap == null)
        return; 
      for (String str : hashMap.keySet()) {
        try {
          View view = ((AuthRegisterViewConfig)hashMap.get(str)).getView();
          view.setOnClickListener(new View.OnClickListener(this, hashMap, str) {
                public void onClick(View param1View) {
                  try {
                    ((AuthRegisterViewConfig)this.a.get(this.b)).getCustomInterface().onClick(this.c.getApplicationContext());
                    return;
                  } catch (Exception exception) {
                    h.c(exception.toString());
                    return;
                  } 
                }
              });
          if (((AuthRegisterViewConfig)hashMap.get(str)).getRootViewId() == 1) {
            this.i.addView(view);
            continue;
          } 
          this.k.addView(view);
        } catch (Exception exception) {
          h.c(exception.toString());
        } 
      } 
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
  }
  
  private void o() {
    if (!b.w().f())
      return; 
    try {
      HashMap hashMap = b.w().g();
      if (hashMap != null && this.i != null) {
        if (this.k == null)
          return; 
        for (String str : hashMap.keySet()) {
          try {
            View view = ((AuthRegisterViewConfig)hashMap.get(str)).getView();
            if (((AuthRegisterViewConfig)hashMap.get(str)).getRootViewId() == 1) {
              this.i.removeView(view);
              continue;
            } 
            this.k.removeView(view);
          } catch (Exception exception) {
            h.c(exception.toString());
          } 
        } 
      } else {
        return;
      } 
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
    b.w().N();
  }
  
  private void p() {
    try {
      this.w = b.w().l();
      if (this.w == null) {
        h.c("the OneLoginBean is null");
        finish();
      } 
      this.v = b.w().A();
      if (this.v == null) {
        h.c("the OneLoginThemeConfig is null");
        a("activity error: the OneLoginThemeConfig is null", "-20503");
        return;
      } 
      if (TextUtils.isEmpty(this.w.getNumber())) {
        h.c("the Number is null");
        a("activity error: the Number is null", "-20503");
        return;
      } 
    } catch (Exception exception) {
      h.c(exception.toString());
      finish();
    } 
    try {
      e();
      m();
      n();
      t();
      return;
    } catch (Exception exception) {
      h.c(exception.toString());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("activity error: ");
      stringBuilder.append(exception.toString());
      a(stringBuilder.toString(), "-20503");
      return;
    } 
  }
  
  private void q() {
    u();
    c.f();
    try {
      if (this.r != null)
        this.r.a(); 
      if (this.s != null) {
        this.s.a();
        return;
      } 
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
  }
  
  private void r() {
    try {
      if (this.r != null)
        this.r.b(); 
      if (this.s != null)
        this.s.b(); 
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
    t();
  }
  
  private void s() {
    if (this.z != null) {
      h.b("SenseBot verify mode: 2");
      this.z.a();
      return;
    } 
    if (c.g()) {
      h.b("SenseBot verify mode: 1");
      return;
    } 
    h.b("requestToken mode: 0");
    b.w().B();
  }
  
  private void t() {
    try {
      this.g.setEnabled(true);
      this.u.setEnabled(true);
      this.c.setEnabled(true);
      this.f.setEnabled(true);
      if (!this.v.isDisableBtnIfUnChecked() || this.v.isPrivacyState()) {
        this.t.setEnabled(true);
        return;
      } 
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
  }
  
  private void u() {
    try {
      this.g.setEnabled(false);
      this.u.setEnabled(false);
      this.c.setEnabled(false);
      this.f.setEnabled(false);
      this.t.setEnabled(false);
      return;
    } catch (Exception exception) {
      h.c(exception.toString());
      return;
    } 
  }
  
  public void a() {
    finish();
  }
  
  public void b() {
    try {
      q();
      return;
    } catch (Exception exception) {
      h.c(exception.toString());
      return;
    } 
  }
  
  public void c() {
    try {
      r();
      return;
    } catch (Exception exception) {
      h.c(exception.toString());
      return;
    } 
  }
  
  public void d() {
    if (this.v == null) {
      h.c("授权页配置为空");
      return;
    } 
    if (!this.g.isChecked()) {
      Toast.makeText(getApplicationContext(), this.v.getPrivacyUnCheckedToastText(), 0).show();
      return;
    } 
    h.b("requestToken mode: 1");
    b.w().B();
  }
  
  public void finish() {
    h.b("OneLoginActivity finish");
    a.a().b();
    super.finish();
    b.w().S();
    try {
      o();
      return;
    } catch (Exception exception) {
      h.c(exception.toString());
      return;
    } 
  }
  
  public void onBackPressed() {
    if (!this.o) {
      h.b("Return key to exit");
      a("Return key to exit", "-20301");
    } 
    c.e();
    super.onBackPressed();
  }
  
  public void onClick(View paramView) {
    if (paramView.equals(this.u) || paramView.equals(this.c)) {
      a("Change login method", "-20303");
      c.d();
      return;
    } 
    if (paramView.equals(this.t)) {
      c.c();
      if (!this.g.isChecked()) {
        Toast.makeText(getApplicationContext(), this.v.getPrivacyUnCheckedToastText(), 0).show();
        return;
      } 
      s();
      return;
    } 
    if (paramView.equals(this.g)) {
      c.a(this.g.isChecked());
      return;
    } 
    if (paramView.equals(this.m)) {
      this.o = true;
      h.b("User cancels login");
      a("User cancels login", "-20302");
      onBackPressed();
      return;
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    h.b("OneLoginActivity onCreate");
    c.a(this);
    b.w().b(true);
    this.h = (Context)this;
    try {
      setContentView(a.a("gt_activity_one_login", this));
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("the OneLoginActivity is null: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      finish();
    } 
    p();
    a.a().a(this);
  }
  
  protected void onDestroy() {
    h.b("OneLoginActivity onDestroy");
    b.w().b(false);
    try {
      if (this.r != null)
        this.r.b(); 
      if (this.s != null)
        this.s.b(); 
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
    super.onDestroy();
  }
  
  protected void onResume() {
    super.onResume();
    b.b(this, this.v);
  }
  
  protected void onStart() {
    super.onStart();
    b.a(this, this.v);
    GTVideoView gTVideoView = this.q;
    if (gTVideoView != null)
      r.a((VideoView)gTVideoView, this.h, this.v.getAuthBgVideoUri()); 
  }
  
  protected void onStop() {
    super.onStop();
    GTVideoView gTVideoView = this.q;
    if (gTVideoView != null)
      gTVideoView.stopPlayback(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\activity\OneLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */