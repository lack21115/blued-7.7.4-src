package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.chat.utils.BlueAppChatLocal;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.google.gson.reflect.TypeToken;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.model.BluedCheckResult;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.user.fragment.AccountLockedFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.password.PasswordCheckUtils;
import com.soft.blued.utils.password.PasswordStatusView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class RegisterV1ForPhoneFragment extends BaseFragment implements View.OnClickListener {
  private ImageView A;
  
  private CommonEdittextView B;
  
  private ClearEditText C;
  
  private FrameLayout D;
  
  private ImageView E;
  
  private SmCaptchaWebView F;
  
  private SmCaptchaWebView.ResultListener G;
  
  private SmCaptchaWebView.SmOption H;
  
  private boolean I = true;
  
  private boolean J = false;
  
  private String K;
  
  private TextWatcher L;
  
  private TextWatcher M;
  
  private final int N = 11;
  
  private PasswordStatusView O;
  
  private boolean P = true;
  
  public BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntityA<BluedCheckResult>>(this) {
      protected BluedEntityA<BluedCheckResult> a(String param1String) {
        BluedEntityA<BluedCheckResult> bluedEntityA = (BluedEntityA)super.parseData(param1String);
        if (bluedEntityA != null)
          try {
            if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
              String str = AesCrypto.c(((BluedCheckResult)bluedEntityA.data.get(0)).get_());
              Logger.b(RegisterV1ForPhoneFragment.j(this.a), new Object[] { "解密：deData===", str });
              BluedCheckResult bluedCheckResult = (BluedCheckResult)AppInfo.f().fromJson(str, BluedCheckResult.class);
              bluedEntityA.data.set(0, bluedCheckResult);
              return bluedEntityA;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            AppMethods.d(2131756082);
          }  
        return bluedEntityA;
      }
      
      public void a(BluedEntityA<BluedCheckResult> param1BluedEntityA) {
        try {
          String str = RegisterV1ForPhoneFragment.j(this.a);
          boolean bool = true;
          Logger.b(str, new Object[] { "===success", "加密：responseJson:", param1BluedEntityA });
          if (param1BluedEntityA.data.get(0) != null) {
            BluedCheckResult bluedCheckResult = param1BluedEntityA.data.get(0);
            if (bluedCheckResult != null) {
              RegisterV1ForPhoneFragment.b(this.a, bluedCheckResult.getToken());
              RegisterV1ForPhoneFragment.c(this.a, bluedCheckResult.getCaptcha());
              RegisterV1ForPhoneFragment.m(this.a).a((EditText)RegisterV1ForPhoneFragment.f(this.a), (EditText)RegisterV1ForPhoneFragment.k(this.a), RegisterV1ForPhoneFragment.l(this.a), PasswordCheckUtils.PWD_CHECK_PAGE.a, (IRequestHost)this.a.w_(), new -$$Lambda$RegisterV1ForPhoneFragment$10$2WhY5pZYaAsH5eDqh36Tegge5Lk(this));
              RegisterV1ForPhoneFragment registerV1ForPhoneFragment = this.a;
              if (bluedCheckResult.getIs_sm_captcha() != 1)
                bool = false; 
              RegisterV1ForPhoneFragment.b(registerV1ForPhoneFragment, bool);
              if (RegisterV1ForPhoneFragment.c(this.a)) {
                RegisterV1ForPhoneFragment.n(this.a).setVisibility(8);
                RegisterV1ForPhoneFragment.o(this.a).setVisibility(0);
                RegisterV1ForPhoneFragment.p(this.a);
                return;
              } 
              RegisterV1ForPhoneFragment.n(this.a).setVisibility(0);
              RegisterV1ForPhoneFragment.o(this.a).setVisibility(8);
              if (!StringUtils.e(RegisterV1ForPhoneFragment.q(this.a))) {
                LoginRegisterTools.a((IRequestHost)this.a.w_(), RegisterV1ForPhoneFragment.r(this.a), RegisterV1ForPhoneFragment.q(this.a));
                return;
              } 
            } 
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
          AppMethods.d(2131756082);
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
        if (param1Int != 4036005 && param1Int != 4036501)
          return onUIFailure(param1Int, param1String1); 
        try {
          BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(param1String2, (new TypeToken<BluedEntityA<BluedLoginResult>>(this) {
              
              }).getType());
          if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
            BluedLoginResult bluedLoginResult = bluedEntityA.data.get(0);
            String str1 = bluedLoginResult.reason;
            String str2 = bluedLoginResult.uid;
            AccountLockedFragment.a(RegisterV1ForPhoneFragment.a(this.a), str1, str2);
          } 
        } catch (Exception exception) {}
        DialogUtils.b(RegisterV1ForPhoneFragment.i(this.a));
        this.a.getActivity().finish();
        return true;
      }
      
      public void onUIFinish() {
        DialogUtils.b(RegisterV1ForPhoneFragment.i(this.a));
      }
      
      public void onUIStart() {
        DialogUtils.a(RegisterV1ForPhoneFragment.i(this.a));
      }
    };
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse(this) {
      public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
        switch (param1Int) {
          default:
            return onUIFailure(param1Int, param1String1);
          case 4036002:
            if (RegisterV1ForPhoneFragment.c(this.a)) {
              RegisterV1ForPhoneFragment.h(this.a).reloadCaptcha();
              RegisterV1ForPhoneFragment.b(this.a);
              return true;
            } 
            RegisterV1ForPhoneFragment.c(this.a, LoginRegisterTools.a(param1String2));
            if (!StringUtils.e(RegisterV1ForPhoneFragment.q(this.a)))
              LoginRegisterTools.a((IRequestHost)this.a.w_(), RegisterV1ForPhoneFragment.r(this.a), RegisterV1ForPhoneFragment.q(this.a)); 
            return true;
          case 4036001:
            break;
        } 
        RegisterV1ForPhoneFragment.t(this.a);
        return true;
      }
      
      public void onUIFinish() {
        DialogUtils.b(RegisterV1ForPhoneFragment.i(this.a));
        super.onUIFinish();
      }
      
      public void onUIStart() {
        DialogUtils.a(RegisterV1ForPhoneFragment.i(this.a));
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        AppMethods.a(RegisterV1ForPhoneFragment.a(this.a).getResources().getString(2131755575));
        RegisterV1ForPhoneFragment.s(this.a);
      }
    };
  
  private String f = RegisterV1ForPhoneFragment.class.getSimpleName();
  
  private View g;
  
  private Context h;
  
  private ScrollView i;
  
  private CommonEdittextView j;
  
  private ClearEditText k;
  
  private CommonEdittextView l;
  
  private ClearEditText m;
  
  private LinearLayout n;
  
  private CheckBox o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private CommonTopTitleNoTrans s;
  
  private Dialog t;
  
  private ShapeTextView u;
  
  private LinearLayout v;
  
  private TextView w;
  
  private String x;
  
  private String y;
  
  private LinearLayout z;
  
  private void l() {
    this.s = (CommonTopTitleNoTrans)this.g.findViewById(2131300300);
    this.s.a();
    this.s.e();
    this.s.setCenterText(this.h.getString(2131755491));
    this.s.setLeftClickListener(this);
  }
  
  private void m() {
    this.O = (PasswordStatusView)this.g.findViewById(2131299547);
    this.t = DialogUtils.a(this.h);
    this.l = (CommonEdittextView)this.g.findViewById(2131296682);
    this.m = this.l.getEditText();
    this.m.setInputType(2);
    this.m.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(11) });
    this.j = (CommonEdittextView)this.g.findViewById(2131296683);
    this.k = this.j.getEditText();
    this.k.setTypeface(Typeface.DEFAULT);
    this.k.setTransformationMethod((TransformationMethod)HideReturnsTransformationMethod.getInstance());
    this.v = (LinearLayout)this.g.findViewById(2131299067);
    this.v.setOnClickListener(this);
    this.q = (TextView)this.g.findViewById(2131301376);
    this.o = (CheckBox)this.g.findViewById(2131296672);
    this.p = (TextView)this.g.findViewById(2131301375);
    this.n = (LinearLayout)this.g.findViewById(2131299097);
    this.r = (TextView)this.g.findViewById(2131301527);
    this.r.setOnClickListener(this);
    this.u = (ShapeTextView)this.g.findViewById(2131301422);
    this.u.setOnClickListener(this);
    this.w = this.l.getAreaCodeText();
    this.w.setOnClickListener(this);
    if (BlueAppChatLocal.isZh()) {
      this.q.setVisibility(8);
      this.p.setVisibility(0);
    } else {
      this.q.setVisibility(0);
      this.p.setVisibility(8);
    } 
    String str = AreaUtils.a(AreaUtils.b());
    if (!StringUtils.e(str)) {
      this.w.setText(str);
    } else {
      this.w.setText("+86");
    } 
    this.A = (ImageView)this.g.findViewById(2131296341);
    this.A.setOnClickListener(this);
    this.B = (CommonEdittextView)this.g.findViewById(2131296680);
    this.C = this.B.getEditText();
    this.z = (LinearLayout)this.g.findViewById(2131298740);
    this.D = (FrameLayout)this.g.findViewById(2131299085);
    this.E = (ImageView)this.g.findViewById(2131299984);
    this.E.setOnClickListener(this);
    n();
    t();
    if (BlueAppChatLocal.isZh()) {
      this.q.setVisibility(8);
      this.p.setVisibility(0);
      TypefaceUtils.a(this.h, this.p, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              String str = H5Url.a(20);
              WebViewShowInfoFragment.show(RegisterV1ForPhoneFragment.a(this.a), str, 0);
            }
          }new TypefaceUtils.SpannIndex(12, 26), new TypefaceUtils.SpannIndex(77, 97));
      TypefaceUtils.a(this.h, this.p, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(RegisterV1ForPhoneFragment.a(this.a), H5Url.a(21), 0);
            }
          }new TypefaceUtils.SpannIndex(27, 37), new TypefaceUtils.SpannIndex(102, 116));
    } else {
      this.q.setVisibility(0);
      this.p.setVisibility(8);
      TypefaceUtils.a(this.h, this.q, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              String str = H5Url.a(20);
              WebViewShowInfoFragment.show(RegisterV1ForPhoneFragment.a(this.a), str, 0);
            }
          }new TypefaceUtils.SpannIndex(12, 26), new TypefaceUtils.SpannIndex(77, 97));
      TypefaceUtils.a(this.h, this.q, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(RegisterV1ForPhoneFragment.a(this.a), H5Url.a(21), 0);
            }
          }new TypefaceUtils.SpannIndex(27, 34), new TypefaceUtils.SpannIndex(99, 113));
    } 
    this.o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            RegisterV1ForPhoneFragment.b(this.a);
          }
        });
    p();
    this.L = new TextWatcher(this) {
        public void afterTextChanged(Editable param1Editable) {
          RegisterV1ForPhoneFragment.b(this.a);
          if (RegisterV1ForPhoneFragment.c(this.a))
            RegisterV1ForPhoneFragment.d(this.a); 
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
    this.M = new TextWatcher(this) {
        private int b;
        
        private int c;
        
        public void afterTextChanged(Editable param1Editable) {
          RegisterV1ForPhoneFragment.b(this.a);
          if (RegisterV1ForPhoneFragment.c(this.a))
            RegisterV1ForPhoneFragment.d(this.a); 
          RegisterV1ForPhoneFragment.f(this.a).removeTextChangedListener(RegisterV1ForPhoneFragment.e(this.a));
          this.b = RegisterV1ForPhoneFragment.f(this.a).getSelectionStart();
          this.c = RegisterV1ForPhoneFragment.f(this.a).getSelectionEnd();
          RegisterV1ForPhoneFragment.f(this.a).setSelection(this.b);
          RegisterV1ForPhoneFragment.f(this.a).addTextChangedListener(RegisterV1ForPhoneFragment.e(this.a));
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
  }
  
  private void n() {
    String str = getString(2131755574);
    this.F = (SmCaptchaWebView)this.g.findViewById(2131299983);
    this.H = new SmCaptchaWebView.SmOption();
    this.H.setOrganization("qRLrIEyYwqE1vOhOACQy");
    this.H.setMode("slide");
    this.H.setAppId("1");
    this.H.setChannel(AppInfo.c);
    if (!BlueAppLocal.d()) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("lang", "en");
      this.H.setExtOption(hashMap);
    } 
    if (!TextUtils.isEmpty(str))
      this.H.setTipMessage(str); 
    this.F.setBackgroundColor(0);
    ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
    layoutParams.width = AppInfo.l - DensityUtils.a(this.h, 80.0F);
    layoutParams.height = (int)(layoutParams.width / 300.0D * 234.0D);
    this.F.setLayoutParams(layoutParams);
    this.i = (ScrollView)this.g.findViewById(2131299842);
    this.F.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            RegisterV1ForPhoneFragment.g(this.a).requestDisallowInterceptTouchEvent(true);
            return false;
          }
        });
    this.G = new SmCaptchaWebView.ResultListener(this) {
        public void onError(int param1Int) {}
        
        public void onReady() {
          RegisterV1ForPhoneFragment.d(this.a);
          RegisterV1ForPhoneFragment.h(this.a).setVisibility(0);
        }
        
        public void onSuccess(CharSequence param1CharSequence, boolean param1Boolean) {
          RegisterV1ForPhoneFragment.a(this.a, param1CharSequence.toString());
          RegisterV1ForPhoneFragment.a(this.a, param1Boolean);
          RegisterV1ForPhoneFragment.b(this.a);
        }
      };
    this.D.setVisibility(8);
  }
  
  private void o() {
    this.F.initWithOption(this.H, this.G);
    int i = SmCaptchaWebView.SMCAPTCHA_SUCCESS;
  }
  
  private void p() {
    if (!StringUtils.e(this.m.getText().toString()) && !StringUtils.e(this.k.getText().toString()) && this.o.isChecked() && ((this.I && this.J) || (!this.I && !StringUtils.e(this.C.getText().toString()))) && !this.P) {
      this.u.setEnabled(true);
      return;
    } 
    this.u.setEnabled(false);
  }
  
  private void q() {
    if (this.J)
      return; 
    if (!StringUtils.e(this.m.getText().toString()) && !StringUtils.e(this.k.getText().toString())) {
      this.F.enableCaptcha();
      return;
    } 
    this.F.disableCaptcha();
  }
  
  private void r() {
    this.m.addTextChangedListener(this.L);
    this.k.addTextChangedListener(this.M);
    this.C.addTextChangedListener(this.L);
  }
  
  private void s() {
    this.m.removeTextChangedListener(this.L);
    this.k.removeTextChangedListener(this.M);
    this.C.removeTextChangedListener(this.L);
  }
  
  private void t() {
    LoginRegisterHttpUtils.a(this.d, "mobile", (IRequestHost)w_());
  }
  
  private void u() {
    Bundle bundle = new Bundle();
    bundle.putString(LoginRegisterTools.d, this.x);
    bundle.putString(LoginRegisterTools.c, this.y);
    bundle.putString(LoginRegisterTools.e, this.m.getText().toString());
    bundle.putString(LoginRegisterTools.g, this.w.getText().toString());
    bundle.putString(LoginRegisterTools.h, this.k.getText().toString());
    Logger.b(this.f, new Object[] { "tokenVer===", this.x });
    Logger.b(this.f, new Object[] { "captcha===", this.y });
    Logger.b(this.f, new Object[] { "phonenum===", this.m.getText().toString() });
    Logger.b(this.f, new Object[] { "areacode===", this.w.getText().toString() });
    Logger.b(this.f, new Object[] { "password===", this.k.getText().toString() });
    TerminalActivity.d((Context)getActivity(), RegisterV1ForPhone2Fragment.class, bundle);
  }
  
  public String a() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
    Date date = new Date(System.currentTimeMillis());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(simpleDateFormat.format(date));
    return stringBuilder.toString();
  }
  
  public void k() {
    String str;
    if (TextUtils.isEmpty((CharSequence)this.k.getText()))
      return; 
    int i = this.k.getText().toString().length();
    if (this.I) {
      str = "identify_sm";
    } else {
      str = "identify";
    } 
    if (i >= 6) {
      if (!StringUtils.e(this.m.getText().toString()) && !StringUtils.e(this.k.getText().toString()) && (!StringUtils.e(this.C.getText().toString()) || this.J)) {
        BluedUIHttpResponse bluedUIHttpResponse = this.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.w.getText().toString());
        stringBuilder.append("-");
        stringBuilder.append(this.m.getText().toString());
        LoginRegisterHttpUtils.a(bluedUIHttpResponse, stringBuilder.toString(), this.x, this.C.getText().toString(), "mobile", str, this.K, (IRequestHost)w_());
        return;
      } 
      AppMethods.d(2131755462);
      return;
    } 
    AppMethods.a(this.h.getResources().getString(2131755572));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 100)
      return; 
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra(RegisterV1AreaCodeFragment.o);
      if (!StringUtils.e(str))
        this.w.setText(str); 
    } 
  }
  
  public void onClick(View paramView) {
    Intent intent;
    Bundle bundle;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301527:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK);
        intent = new Intent(this.h, LoginV1ForThreeActivity.class);
        intent.putExtra("from_three_plat", "plat_weixin");
        this.h.startActivity(intent);
        return;
      case 2131301422:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.REGISTER_PAGE_REGISTER_BTN_CLICK);
        LoginRegisterHttpUtils.a("reg_mo");
        BluedPreferences.av(a());
        k();
        return;
      case 2131300528:
        LoginRegisterHttpUtils.a("country_mo");
        bundle = new Bundle();
        bundle.putString(RegisterV1AreaCodeFragment.p, RegisterV1ForPhoneFragment.class.getSimpleName());
        TerminalActivity.a((Fragment)this, RegisterV1AreaCodeFragment.class, bundle, 100);
        return;
      case 2131299984:
        o();
        return;
      case 2131299067:
        KeyboardUtils.a((Activity)getActivity());
        return;
      case 2131296863:
        getActivity().finish();
        return;
      case 2131296341:
        break;
    } 
    if (!StringUtils.e(this.y))
      LoginRegisterTools.a((IRequestHost)w_(), this.A, this.y); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.h = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493293, paramViewGroup, false);
      l();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
  
  public void onResume() {
    super.onResume();
    p();
    r();
  }
  
  public void onStop() {
    s();
    super.onStop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\RegisterV1ForPhoneFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */