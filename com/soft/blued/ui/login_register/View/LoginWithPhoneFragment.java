package com.soft.blued.ui.login_register.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
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
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.geetest.onelogin.OneLoginHelper;
import com.geetest.onelogin.listener.SecurityPhoneListener;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.soft.blued.app.InitTaskUtil;
import com.soft.blued.constant.LoginConstants;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.db.model.UserAccountsModel;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.Contract.LoginWithTypeContract;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.RegisterV1AreaCodeFragment;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginWithPhoneFragment extends BaseFragment implements View.OnClickListener, LoginWithTypeContract.IView {
  public View d;
  
  public ImageView e;
  
  public CommonEdittextView f;
  
  public CommonEdittextView g;
  
  public CommonEdittextView h;
  
  public ClearEditText i;
  
  public ClearEditText j;
  
  public ClearEditText k;
  
  public TextView l;
  
  public View m;
  
  public TextView n;
  
  public TextView o;
  
  public ClearEditText p;
  
  private Context q;
  
  private LoginWithTypeContract.IPresenter r;
  
  private View s;
  
  private Dialog t;
  
  private TextView u;
  
  private TextView v;
  
  private Bundle w;
  
  private CountDownTimer x;
  
  private boolean y;
  
  private boolean z;
  
  private void o() {
    this.t = DialogUtils.a(this.q);
    this.h = (CommonEdittextView)this.s.findViewById(2131296680);
    this.h.a();
    this.e = (ImageView)this.s.findViewById(2131296341);
    this.i = this.h.getEditText();
    this.v = (TextView)this.s.findViewById(2131301132);
    this.v.setVisibility(8);
    this.v.setOnClickListener(new -$$Lambda$LoginWithPhoneFragment$7habrtWBxe9wEcgYnnN-ioUSfRc(this));
    this.g = (CommonEdittextView)this.s.findViewById(2131296683);
    this.g.a();
    this.k = this.g.getEditText();
    this.k.setInputType(128);
    this.k.setTypeface(Typeface.DEFAULT);
    this.k.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.f = (CommonEdittextView)this.s.findViewById(2131296682);
    this.f.a();
    this.j = this.f.getEditText();
    this.j.setInputType(2);
    this.d = this.s.findViewById(2131298740);
    this.l = this.f.getAreaCodeText();
    this.u = (TextView)this.s.findViewById(2131301002);
    this.m = this.s.findViewById(2131299015);
    this.n = (TextView)this.s.findViewById(2131301482);
    this.o = (TextView)this.s.findViewById(2131301171);
    this.p = (ClearEditText)this.s.findViewById(2131296979);
    this.p.setInputType(2);
    this.o.setOnClickListener(new -$$Lambda$LoginWithPhoneFragment$QnleLOK1hji1lsN35vQygHkzV1g(this));
    this.n.setOnClickListener(new -$$Lambda$LoginWithPhoneFragment$0PXAlfMLxFE8KP5S3UPRrgrB6GA(this));
    n();
    this.x = new CountDownTimer(this, 60000L, 1000L, this.q.getResources().getString(2131756586)) {
        public void onFinish() {
          this.b.n.setTextColor(BluedSkinUtils.a(LoginWithPhoneFragment.c(this.b), 2131100716));
          this.b.n.setEnabled(true);
          this.b.n.setText(2131756585);
        }
        
        public void onTick(long param1Long) {
          TextView textView = this.b.n;
          String str = this.a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1Long / 1000L);
          stringBuilder.append("");
          textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
        }
      };
  }
  
  private void p() {
    this.e.setOnClickListener(this);
    TextWatcher textWatcher = new TextWatcher(this) {
        public void afterTextChanged(Editable param1Editable) {
          this.a.n();
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
    this.i.addTextChangedListener(textWatcher);
    this.j.addTextChangedListener(textWatcher);
    this.k.addTextChangedListener(textWatcher);
    this.p.addTextChangedListener(textWatcher);
    this.l.setOnClickListener(this);
    this.u.setOnClickListener(this);
  }
  
  private void q() {
    String str = AreaUtils.a(AreaUtils.b());
    if (!StringUtils.e(str)) {
      this.l.setText(str);
    } else {
      this.l.setText("+86");
    } 
    if (this.w != null)
      return; 
    UserAccountsModel userAccountsModel = UserAccountsVDao.a().a(1);
    if (userAccountsModel != null && !StringUtils.e(userAccountsModel.getUsername()) && userAccountsModel.getUsername().contains("-")) {
      String[] arrayOfString = userAccountsModel.getUsername().split("-");
      this.l.setText(arrayOfString[0]);
      this.j.setText(arrayOfString[1]);
      this.j.setSelection(arrayOfString[1].length());
    } 
  }
  
  public void a() {
    DialogUtils.b(this.t);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    LoginRegisterTools.a((IRequestHost)w_(), this.e, paramString);
    this.d.setVisibility(0);
    this.i.requestFocus();
    if (paramBoolean) {
      this.y = true;
      return;
    } 
    this.z = true;
  }
  
  public void a(boolean paramBoolean) {
    LoginRegisterTools.a(this.q, new SmCaptchaWebView.ResultListener(this) {
          public void onError(int param1Int) {}
          
          public void onReady() {}
          
          public void onSuccess(CharSequence param1CharSequence, boolean param1Boolean) {
            if (param1Boolean) {
              LoginWithPhoneFragment.d(this.a).b(param1CharSequence.toString());
              LoginWithPhoneFragment.e(this.a).callOnClick();
            } 
          }
        });
    if (paramBoolean) {
      this.y = true;
      return;
    } 
    this.z = true;
  }
  
  public void b() {
    DialogUtils.a(this.t);
  }
  
  public void c() {
    LoginRegisterTools.a(getActivity(), 0);
  }
  
  public void d() {
    this.n.setTextColor(BluedSkinUtils.a(this.q, 2131100842));
    this.n.setEnabled(false);
    String str = this.q.getResources().getString(2131756586);
    this.n.setText(String.format(str, new Object[] { "60" }));
    this.x.start();
  }
  
  public int e() {
    return (this.m.getVisibility() == 0) ? 1 : 0;
  }
  
  public void k() {
    LoginRegisterHttpUtils.a((IRequestHost)w_(), new BluedUIHttpResponse<BluedEntityA<AppConfigModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<AppConfigModel> param1BluedEntityA) {
            if (param1BluedEntityA == null || !param1BluedEntityA.hasData() || ((AppConfigModel)param1BluedEntityA.getSingleData()).oneclick == 1) {
              if (((LoginFragment)this.a.getParentFragment()).t()) {
                LoginWithPhoneFragment.a(this.a).setVisibility(8);
                return;
              } 
              LoginWithPhoneFragment.a(this.a).setVisibility(0);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
        });
  }
  
  public void l() {
    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.ONE_CLICK_LOGIN_BTN_CLICK);
    DialogUtils.a(this.t);
    OneLoginHelper.with().requestSecurityPhone(new SecurityPhoneListener(this) {
          public void onFailed(JSONObject param1JSONObject) {
            byte b;
            try {
              b = param1JSONObject.getInt("errorCode");
            } catch (JSONException jSONException) {
              b = -1;
            } 
            if (b == -20201) {
              AppMethods.d(2131758306);
            } else {
              AppMethods.d(2131758305);
            } 
            DialogUtils.b(LoginWithPhoneFragment.b(this.a));
          }
          
          public void onSuccess(String param1String) {
            DialogUtils.b(LoginWithPhoneFragment.b(this.a));
            OneLoginPop.a(LoginWithPhoneFragment.c(this.a), param1String, (IRequestHost)this.a.w_());
          }
        });
  }
  
  public void m() {
    LoginWithTypeContract.IPresenter iPresenter = this.r;
    LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE pHONE_CODE_LOGIN_STAGE = LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.l.getText().toString());
    stringBuilder.append("-");
    stringBuilder.append(this.j.getText().toString());
    iPresenter.a(pHONE_CODE_LOGIN_STAGE, stringBuilder.toString(), this.i.getText().toString(), this.p.getText().toString());
  }
  
  public void n() {
    if (this.q.getResources().getString(2131758378).equals(this.o.getText().toString())) {
      if (!StringUtils.e(this.j.getText().toString()) && !StringUtils.e(this.p.getText().toString())) {
        if (this.d.getVisibility() == 0) {
          if (!StringUtils.e(this.i.getText().toString())) {
            this.u.setEnabled(true);
            return;
          } 
          this.u.setEnabled(false);
          return;
        } 
        this.u.setEnabled(true);
        return;
      } 
      this.u.setEnabled(false);
      return;
    } 
    if (!StringUtils.e(this.j.getText().toString()) && !StringUtils.e(this.k.getText().toString())) {
      if (this.d.getVisibility() == 0) {
        if (!StringUtils.e(this.i.getText().toString())) {
          this.u.setEnabled(true);
          return;
        } 
        this.u.setEnabled(false);
        return;
      } 
      this.u.setEnabled(true);
      return;
    } 
    this.u.setEnabled(false);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296341) {
      if (i != 2131300528) {
        if (i != 2131301002)
          return; 
        if (this.q.getResources().getString(2131758378).equals(this.o.getText().toString())) {
          if (!StringUtils.e(this.j.getText().toString()) && !StringUtils.e(this.p.getText().toString())) {
            LoginWithTypeContract.IPresenter iPresenter = this.r;
            LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE pHONE_CODE_LOGIN_STAGE = LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.l.getText().toString());
            stringBuilder.append("-");
            stringBuilder.append(this.j.getText().toString());
            iPresenter.a(pHONE_CODE_LOGIN_STAGE, stringBuilder.toString(), this.i.getText().toString(), this.p.getText().toString());
            return;
          } 
          AppMethods.a(AppInfo.d().getResources().getString(2131758402));
          return;
        } 
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.PHONE);
        if (!StringUtils.e(this.j.getText().toString()) && !StringUtils.e(this.k.getText().toString())) {
          LoginWithTypeContract.IPresenter iPresenter = this.r;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.l.getText().toString());
          stringBuilder.append("-");
          stringBuilder.append(this.j.getText().toString());
          iPresenter.a("mobile", stringBuilder.toString(), this.k.getText().toString(), this.r.d(), this.i.getText().toString());
          return;
        } 
        AppMethods.a(AppInfo.d().getResources().getString(2131759176));
        return;
      } 
      Bundle bundle = new Bundle();
      bundle.putString(RegisterV1AreaCodeFragment.p, LoginWithPhoneFragment.class.getSimpleName());
      TerminalActivity.a(getParentFragment(), RegisterV1AreaCodeFragment.class, bundle, 100);
      return;
    } 
    if (this.q.getResources().getString(2131758378).equals(this.o.getText().toString())) {
      if (!StringUtils.e(this.r.c())) {
        a(this.r.c(), false);
        return;
      } 
    } else if (!StringUtils.e(this.r.b())) {
      a(this.r.b(), true);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    InitTaskUtil.initGeeTestSDK();
    this.q = (Context)getActivity();
    View view = this.s;
    if (view == null) {
      this.s = paramLayoutInflater.inflate(2131493214, paramViewGroup, false);
      this.w = getArguments();
      o();
      q();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.s.getParent()).removeView(this.s);
    } 
    return this.s;
  }
  
  public void onDestroy() {
    super.onDestroy();
    a();
    CountDownTimer countDownTimer = this.x;
    if (countDownTimer != null) {
      countDownTimer.cancel();
      this.x = null;
    } 
  }
  
  public void onResume() {
    super.onResume();
    if (!TextUtils.isEmpty(SignInActivity.d) && !TextUtils.isEmpty(SignInActivity.e)) {
      this.l.setText(SignInActivity.e);
      this.j.setText(SignInActivity.d);
      this.j.setSelection(SignInActivity.d.length());
      SignInActivity.d = null;
      SignInActivity.e = null;
      return;
    } 
    if (this.l != null && !StringUtils.e(LoginConstants.a))
      this.l.setText(LoginConstants.a); 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.r = (LoginWithTypeContract.IPresenter)new LoginWithTypePresenter(this.q, this, (IRequestHost)w_());
    Bundle bundle = this.w;
    if (bundle != null)
      this.r.a(bundle.getString("aliasUserId")); 
    p();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\View\LoginWithPhoneFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */