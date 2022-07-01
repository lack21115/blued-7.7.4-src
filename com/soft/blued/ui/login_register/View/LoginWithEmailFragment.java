package com.soft.blued.ui.login_register.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.db.model.UserAccountsModel;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.Contract.LoginWithTypeContract;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter;
import com.soft.blued.utils.StringUtils;

public class LoginWithEmailFragment extends BaseFragment implements View.OnClickListener, LoginWithTypeContract.IView {
  public View d;
  
  public ImageView e;
  
  public ClearEditText f;
  
  public ClearEditText g;
  
  public ClearEditText h;
  
  private Context i;
  
  private LoginWithTypeContract.IPresenter j;
  
  private View k;
  
  private CommonEdittextView l;
  
  private CommonEdittextView m;
  
  private CommonEdittextView n;
  
  private Dialog o;
  
  private TextView p;
  
  private Bundle q;
  
  private void l() {
    this.n = (CommonEdittextView)this.k.findViewById(2131296680);
    this.n.a();
    this.e = (ImageView)this.k.findViewById(2131296341);
    this.f = this.n.getEditText();
    this.m = (CommonEdittextView)this.k.findViewById(2131296683);
    this.m.a();
    this.h = this.m.getEditText();
    this.h.setInputType(128);
    this.h.setTypeface(Typeface.DEFAULT);
    this.h.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.l = (CommonEdittextView)this.k.findViewById(2131296681);
    this.l.a();
    this.g = this.l.getEditText();
    this.g.setInputType(524320);
    this.d = this.k.findViewById(2131298740);
    this.o = DialogUtils.a(this.i);
    this.p = (TextView)this.k.findViewById(2131301002);
    k();
  }
  
  private void m() {
    if (this.q != null)
      return; 
    UserAccountsModel userAccountsModel = UserAccountsVDao.a().a(0);
    if (userAccountsModel != null && !StringUtils.e(userAccountsModel.getUsername())) {
      this.g.setText(userAccountsModel.getUsername());
      this.g.setSelection(userAccountsModel.getUsername().length());
    } 
  }
  
  private void n() {
    this.e.setOnClickListener(this);
    TextWatcher textWatcher = new TextWatcher(this) {
        public void afterTextChanged(Editable param1Editable) {
          this.a.k();
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
    this.f.addTextChangedListener(textWatcher);
    this.g.addTextChangedListener(textWatcher);
    this.h.addTextChangedListener(textWatcher);
    this.p.setOnClickListener(this);
  }
  
  public void a() {
    DialogUtils.b(this.o);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    LoginRegisterTools.a((IRequestHost)w_(), this.e, paramString);
    this.d.setVisibility(0);
    this.f.requestFocus();
  }
  
  public void a(boolean paramBoolean) {
    LoginRegisterTools.a(this.i, new SmCaptchaWebView.ResultListener(this) {
          public void onError(int param1Int) {}
          
          public void onReady() {}
          
          public void onSuccess(CharSequence param1CharSequence, boolean param1Boolean) {
            if (param1Boolean) {
              LoginWithEmailFragment.a(this.a).b(param1CharSequence.toString());
              LoginWithEmailFragment.b(this.a).callOnClick();
            } 
          }
        });
  }
  
  public void b() {
    DialogUtils.a(this.o);
  }
  
  public void c() {
    LoginRegisterTools.a(getActivity(), 0);
  }
  
  public void d() {}
  
  public int e() {
    return 0;
  }
  
  public void k() {
    if (!StringUtils.e(this.g.getText().toString()) && !StringUtils.e(this.h.getText().toString())) {
      if (this.d.getVisibility() == 0) {
        if (!StringUtils.e(this.f.getText().toString())) {
          this.p.setEnabled(true);
          return;
        } 
        this.p.setEnabled(false);
        return;
      } 
      this.p.setEnabled(true);
      return;
    } 
    this.p.setEnabled(false);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296341) {
      if (i != 2131301002)
        return; 
      EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.EMAIL);
      if (!StringUtils.e(this.g.getText().toString()) && !StringUtils.e(this.h.getText().toString())) {
        this.j.a("email", this.g.getText().toString(), this.h.getText().toString(), this.j.d(), this.f.getText().toString());
        return;
      } 
      AppMethods.a(AppInfo.d().getResources().getString(2131759176));
      return;
    } 
    if (!StringUtils.e(this.j.b()))
      a(this.j.b(), true); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.i = (Context)getActivity();
    View view = this.k;
    if (view == null) {
      this.k = paramLayoutInflater.inflate(2131493213, paramViewGroup, false);
      this.q = getArguments();
      l();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.k.getParent()).removeView(this.k);
    } 
    return this.k;
  }
  
  public void onDestroy() {
    DialogUtils.b(this.o);
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.j = (LoginWithTypeContract.IPresenter)new LoginWithTypePresenter(this.i, this, (IRequestHost)w_());
    Bundle bundle = this.q;
    if (bundle != null)
      this.j.a(bundle.getString("aliasUserId")); 
    n();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\View\LoginWithEmailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */