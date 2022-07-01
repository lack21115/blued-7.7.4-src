package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.model.BluedCheckResult;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.setting.fragment.BindingSecureEmailFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.security.NoSuchAlgorithmException;

public class RegisterV1ForPhone2Fragment extends BaseFragment implements View.OnClickListener {
  private String A;
  
  private String B;
  
  private String C;
  
  private String D;
  
  private int E;
  
  Runnable d = new Runnable(this) {
      public void run() {
        if (RegisterV1ForPhone2Fragment.b(this.a) == 0) {
          RegisterV1ForPhone2Fragment.c(this.a).setEnabled(true);
          RegisterV1ForPhone2Fragment.c(this.a).setClickable(true);
          RegisterV1ForPhone2Fragment.c(this.a).setText(this.a.getResources().getString(2131758621));
          RegisterV1ForPhone2Fragment.c(this.a).setTextColor(this.a.getResources().getColor(2131100527));
          return;
        } 
        RegisterV1ForPhone2Fragment.c(this.a).setEnabled(false);
        RegisterV1ForPhone2Fragment.c(this.a).setClickable(false);
        String str = String.format(this.a.getResources().getString(2131755568), new Object[] { Integer.valueOf(RegisterV1ForPhone2Fragment.b(this.a)) });
        RegisterV1ForPhone2Fragment.c(this.a).setText(str);
        RegisterV1ForPhone2Fragment.c(this.a).setTextColor(this.a.getResources().getColor(2131100543));
        RegisterV1ForPhone2Fragment.d(this.a);
        if (RegisterV1ForPhone2Fragment.b(this.a) == 0) {
          this.a.a(this);
          return;
        } 
        this.a.a(this, 1000L);
      }
    };
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this) {
      String a = "";
      
      protected BluedEntityA<BluedLoginResult> a(String param1String) {
        this.a = param1String;
        BluedEntityA<BluedLoginResult> bluedEntityA = (BluedEntityA)super.parseData(param1String);
        if (bluedEntityA != null)
          try {
            if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
              String str = AesCrypto.c(((BluedLoginResult)bluedEntityA.data.get(0)).get_());
              Logger.b(RegisterV1ForPhone2Fragment.h(this.b), new Object[] { "解密：deData===", str });
              BluedLoginResult bluedLoginResult = (BluedLoginResult)AppInfo.f().fromJson(str, BluedLoginResult.class);
              bluedEntityA.data.set(0, bluedLoginResult);
              return bluedEntityA;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            AppMethods.d(2131756082);
          }  
        return bluedEntityA;
      }
      
      public void a(BluedEntityA<BluedLoginResult> param1BluedEntityA) {
        try {
          Logger.b(RegisterV1ForPhone2Fragment.h(this.b), new Object[] { "===success", "加密：responseJson:", param1BluedEntityA });
          if (param1BluedEntityA.data.get(0) != null) {
            BluedLoginResult bluedLoginResult = param1BluedEntityA.data.get(0);
            UserInfo userInfo = UserInfo.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(RegisterV1ForPhone2Fragment.i(this.b));
            stringBuilder.append("-");
            stringBuilder.append(RegisterV1ForPhone2Fragment.j(this.b));
            userInfo.a(stringBuilder.toString(), 1, this.a, bluedLoginResult, new String[0]);
            Bundle bundle = new Bundle();
            bundle.putString("from_tag_page", "from_tag_register");
            HomeArgumentHelper.a(RegisterV1ForPhone2Fragment.g(this.b), null, bundle);
            return;
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
          AppMethods.d(2131756082);
        } 
      }
      
      public void onUIFinish() {
        DialogUtils.b(RegisterV1ForPhone2Fragment.e(this.b));
      }
      
      public void onUIStart() {
        DialogUtils.a(RegisterV1ForPhone2Fragment.e(this.b));
      }
    };
  
  public BluedUIHttpResponse f = new BluedUIHttpResponse(this) {
      int a;
      
      String b;
      
      String c;
      
      public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
        this.a = param1Int;
        this.b = param1String1;
        this.c = param1String2;
        int i = this.a;
        if (i == 4036202 || i == 4036712) {
          i = 1;
        } else {
          i = 0;
        } 
        return (i != 0) ? true : onUIFailure(param1Int, param1String1);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(RegisterV1ForPhone2Fragment.e(this.d));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(":");
        stringBuilder.append(this.b);
        stringBuilder.append(";;");
        stringBuilder.append(this.c);
        Logger.b("ljx", new Object[] { stringBuilder.toString() });
        int i = this.a;
        if (i > 0) {
          String str1;
          String str2;
          switch (i) {
            default:
              if (i == 4036007)
                LoginRegisterHttpUtils.a("wrong_acode"); 
              break;
            case 4036712:
              CommonAlertDialog.a(RegisterV1ForPhone2Fragment.g(this.d), this.d.getString(2131756094), this.b, this.d.getString(2131756086), new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      SignInActivity.d = RegisterV1ForPhone2Fragment.j(this.a.d);
                      SignInActivity.e = RegisterV1ForPhone2Fragment.i(this.a.d);
                      SignInActivity.a(RegisterV1ForPhone2Fragment.g(this.a.d), new Bundle[0]);
                    }
                  }null, 0);
              return;
            case 4036205:
              try {
                Gson gson = AppInfo.f();
                BluedEntityA bluedEntityA = (BluedEntityA)gson.fromJson(this.c, (new TypeToken<BluedEntityA<BluedCheckResult>>(this) {
                    
                    }).getType());
                if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                  BluedCheckResult bluedCheckResult = (BluedCheckResult)gson.fromJson(AesCrypto.c(((BluedCheckResult)bluedEntityA.data.get(0)).get_()), BluedCheckResult.class);
                  if (bluedCheckResult != null) {
                    RegisterV1ForPhone2Fragment.a(this.d, bluedCheckResult.getCaptcha());
                    if (!StringUtils.e(RegisterV1ForPhone2Fragment.l(this.d)))
                      LoginRegisterTools.a((IRequestHost)this.d.w_(), RegisterV1ForPhone2Fragment.m(this.d), RegisterV1ForPhone2Fragment.l(this.d)); 
                    RegisterV1ForPhone2Fragment.n(this.d).setVisibility(0);
                    return;
                  } 
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                return;
              } 
              return;
            case 4036202:
              str2 = this.b;
              str1 = str2;
              if (StringUtils.e(str2))
                str1 = ""; 
              CommonAlertDialog.a(RegisterV1ForPhone2Fragment.g(this.d), "", str1, RegisterV1ForPhone2Fragment.g(this.d).getResources().getString(2131755464), new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      RegisterV1ForPhone2Fragment.o(this.a.d);
                    }
                  },  RegisterV1ForPhone2Fragment.g(this.d).getResources().getString(2131755577), new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {}
                  },  null);
              return;
            case 4036002:
              RegisterV1ForPhone2Fragment.a(this.d, LoginRegisterTools.a(this.c));
              return;
            case 4036001:
              this.d.getActivity().finish();
              return;
          } 
          if (!StringUtils.e(RegisterV1ForPhone2Fragment.l(this.d)))
            LoginRegisterTools.a((IRequestHost)this.d.w_(), RegisterV1ForPhone2Fragment.m(this.d), RegisterV1ForPhone2Fragment.l(this.d)); 
        } 
      }
      
      public void onUIStart() {
        DialogUtils.a(RegisterV1ForPhone2Fragment.e(this.d));
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        RegisterV1ForPhone2Fragment.k(this.d);
      }
    };
  
  public BluedUIHttpResponse g = new BluedUIHttpResponse(this) {
      int a;
      
      String b;
      
      String c;
      
      public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
        this.a = param1Int;
        this.b = param1String1;
        this.c = param1String2;
        return onUIFailure(param1Int, param1String1);
      }
      
      public void onUIFinish() {
        DialogUtils.b(RegisterV1ForPhone2Fragment.e(this.d));
        int i = this.a;
        if (i > 0)
          switch (i) {
            default:
              if (!StringUtils.e(RegisterV1ForPhone2Fragment.l(this.d)))
                LoginRegisterTools.a((IRequestHost)this.d.w_(), RegisterV1ForPhone2Fragment.m(this.d), RegisterV1ForPhone2Fragment.l(this.d)); 
              break;
            case 4036204:
              RegisterV1ForPhone2Fragment.q(this.d);
              break;
            case 4036002:
              RegisterV1ForPhone2Fragment.b(this.d, LoginRegisterTools.a(this.c));
              RegisterV1ForPhone2Fragment.p(this.d);
              break;
            case 4036001:
              this.d.getActivity().finish();
              break;
          }  
        super.onUIFinish();
      }
      
      public void onUIStart() {
        DialogUtils.a(RegisterV1ForPhone2Fragment.e(this.d));
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        AppMethods.a(RegisterV1ForPhone2Fragment.g(this.d).getResources().getString(2131755575));
        RegisterV1ForPhone2Fragment.f(this.d);
      }
      
      public BluedEntity parseData(String param1String) {
        this.c = param1String;
        return super.parseData(param1String);
      }
    };
  
  private String h = RegisterV1ForPhone2Fragment.class.getSimpleName();
  
  private View i;
  
  private Context j;
  
  private Dialog k;
  
  private CommonTopTitleNoTrans l;
  
  private View m;
  
  private ImageView n;
  
  private ClearEditText o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private String s = "";
  
  private LinearLayout t;
  
  private TextWatcher u;
  
  private TextView v;
  
  private TextView w;
  
  private ShapeTextView x;
  
  private GridCodeEditText y;
  
  private TextView z;
  
  private void a() {
    this.l = (CommonTopTitleNoTrans)this.i.findViewById(2131300300);
    this.l.a();
    this.l.e();
    this.l.setLeftClickListener(this);
    if (getArguments() != null) {
      this.D = getArguments().getString("binding_type");
      if ("change".equals(this.D)) {
        this.l.setCenterText("");
        this.l.setTitleBackgroundDrawable(2131100528);
        return;
      } 
      this.l.setCenterText(this.j.getString(2131755491));
    } 
  }
  
  private void a(String paramString) {
    BluedUIHttpResponse bluedUIHttpResponse = this.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.r);
    stringBuilder.append("-");
    stringBuilder.append(this.p);
    LoginRegisterHttpUtils.a(bluedUIHttpResponse, stringBuilder.toString(), this.A, paramString, "mobile", "identify", "", (IRequestHost)w_());
  }
  
  private void k() {
    this.w = (TextView)this.i.findViewById(2131300704);
    this.k = DialogUtils.a(this.j);
    this.t = (LinearLayout)this.i.findViewById(2131299067);
    this.t.setOnClickListener(this);
    this.z = (TextView)this.i.findViewById(2131301270);
    this.z.setOnClickListener(this);
    this.x = (ShapeTextView)this.i.findViewById(2131300656);
    this.x.setOnClickListener(this);
    this.y = (GridCodeEditText)this.i.findViewById(2131297236);
    this.y.setPasswordVisibility(true);
    this.m = this.i.findViewById(2131298740);
    this.n = (ImageView)this.i.findViewById(2131296341);
    this.n.setOnClickListener(this);
    this.o = ((CommonEdittextView)this.i.findViewById(2131296680)).getEditText();
    this.v = (TextView)this.i.findViewById(2131301270);
    this.v.setOnClickListener(this);
    this.u = new TextWatcher(this) {
        public void afterTextChanged(Editable param1Editable) {}
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
          RegisterV1ForPhone2Fragment.a(this.a);
        }
      };
    this.y.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener(this) {
          public void a(String param1String) {
            RegisterV1ForPhone2Fragment.a(this.a);
          }
          
          public void b(String param1String) {}
        });
  }
  
  private void l() {
    if (this.m.getVisibility() == 8) {
      if (this.y.getPassWord() != null && this.y.getPassWord().length() == 6) {
        this.x.setEnabled(true);
        return;
      } 
      this.x.setEnabled(false);
      return;
    } 
    if (this.y.getPassWord() != null && this.y.getPassWord().length() == 6 && !StringUtils.e(this.o.getText().toString())) {
      this.x.setEnabled(true);
      return;
    } 
    this.x.setEnabled(false);
  }
  
  private void m() {
    if (getArguments() != null) {
      this.p = getArguments().getString(LoginRegisterTools.e);
      this.q = getArguments().getString(LoginRegisterTools.h);
      try {
        this.s = BluedHttpTools.b(this.q);
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        noSuchAlgorithmException.printStackTrace();
      } 
      TextView textView = this.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getResources().getString(2131755564));
      stringBuilder.append(LoginRegisterTools.e(this.p));
      stringBuilder.append("\n");
      stringBuilder.append(getResources().getString(2131755566));
      textView.setText(stringBuilder.toString());
      this.r = getArguments().getString(LoginRegisterTools.g);
      this.A = getArguments().getString(LoginRegisterTools.d);
      this.B = getArguments().getString(LoginRegisterTools.c);
    } 
    p();
  }
  
  private void n() {
    this.o.addTextChangedListener(this.u);
  }
  
  private void o() {
    this.o.removeTextChangedListener(this.u);
  }
  
  private void p() {
    this.E = 60;
    a(this.d);
  }
  
  private void q() {
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            RegisterV1ForPhone2Fragment.f(this.a);
            AppMethods.d(2131755575);
          }
          
          public void onUIFinish() {
            DialogUtils.b(RegisterV1ForPhone2Fragment.e(this.a));
          }
          
          public void onUIStart() {
            DialogUtils.a(RegisterV1ForPhone2Fragment.e(this.a));
          }
        },  "mobile", "", null);
  }
  
  private void r() {
    LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            try {
              (new Bundle()).putString("binding_type", "add");
              TerminalActivity.d(RegisterV1ForPhone2Fragment.g(this.a), BindingSecureEmailFragment.class, null);
              this.a.getActivity().finish();
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.d(2131756082);
              return;
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(RegisterV1ForPhone2Fragment.e(this.a));
          }
          
          public void onUIStart() {
            DialogUtils.a(RegisterV1ForPhone2Fragment.e(this.a));
          }
        }1, this.y.getPassWord(), null);
  }
  
  private void s() {
    LoginRegisterHttpUtils.b(this.f, this.A, this.y.getPassWord(), this.o.getText().toString(), "mobile", (IRequestHost)w_());
  }
  
  private void t() {
    LoginRegisterHttpUtils.b(this.e, this.A, "mobile", this.q, (IRequestHost)w_());
  }
  
  private void u() {
    this.m.setVisibility(8);
    this.o.setText("");
    p();
  }
  
  private void v() {
    this.v.setEnabled(false);
    this.v.setText(this.j.getResources().getString(2131758621));
    this.v.setTextColor(this.j.getResources().getColor(2131100607));
  }
  
  private void w() {
    Bundle bundle = new Bundle();
    bundle.putString(LoginRegisterTools.d, this.A);
    bundle.putString(LoginRegisterTools.c, this.B);
    Logger.b(this.h, new Object[] { "tokenVer===", this.A });
    Logger.b(this.h, new Object[] { "captchaFromOne===", this.B });
    TerminalActivity.a((Fragment)this, RegisterV1ForCaptchaCodeFragment.class, bundle, 1000);
  }
  
  private void x() {
    Context context = this.j;
    String str1 = this.A;
    String str2 = this.q;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.r);
    stringBuilder.append("-");
    stringBuilder.append(this.p);
    RegisterV1FinishInfoFragment.a(context, str1, str2, stringBuilder.toString(), LoginAndRegisterProtos.Source.PHONE);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1000)
      return; 
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra(LoginRegisterTools.c);
      if (!StringUtils.e(str))
        a(str); 
    } 
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131301270:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.AUTHCODE_RESEND_BTN_CLICK);
        this.y.a();
        LoginRegisterHttpUtils.a("resend_acode");
        if ("change".equals(this.D)) {
          q();
          return;
        } 
        w();
        return;
      case 2131300656:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.AUTHCODE_CONFIRM_BTN_CLICK);
        if (!TextUtils.isEmpty(this.D) && "change".equals(this.D)) {
          r();
          return;
        } 
        if (!StringUtils.e(this.y.getPassWord())) {
          if (this.m.getVisibility() == 0) {
            if (!StringUtils.e(this.o.getText().toString())) {
              s();
            } else {
              AppMethods.d(2131755462);
            } 
          } else {
            s();
          } 
          LoginRegisterHttpUtils.a("resend_acode_mo");
          return;
        } 
        AppMethods.d(2131755462);
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
    if (!StringUtils.e(this.C))
      LoginRegisterTools.a((IRequestHost)w_(), this.n, this.C); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.j = (Context)getActivity();
    View view = this.i;
    if (view == null) {
      this.i = paramLayoutInflater.inflate(2131493294, paramViewGroup, false);
      a();
      k();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.i.getParent()).removeView(this.i);
    } 
    return this.i;
  }
  
  public void onResume() {
    super.onResume();
    n();
  }
  
  public void onStop() {
    o();
    super.onStop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\RegisterV1ForPhone2Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */