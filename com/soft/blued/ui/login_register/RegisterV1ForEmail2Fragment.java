package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.setting.fragment.BindingSecureEmailFragment;
import com.soft.blued.ui.setting.model.BindingModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;

public class RegisterV1ForEmail2Fragment extends BaseFragment implements View.OnClickListener {
  Runnable d = new Runnable(this) {
      public void run() {
        if (RegisterV1ForEmail2Fragment.c(this.a) == 0) {
          RegisterV1ForEmail2Fragment.d(this.a).setEnabled(true);
          RegisterV1ForEmail2Fragment.d(this.a).setClickable(true);
          RegisterV1ForEmail2Fragment.d(this.a).setText(this.a.getResources().getString(2131758621));
          RegisterV1ForEmail2Fragment.d(this.a).setTextColor(this.a.getResources().getColor(2131100527));
          return;
        } 
        RegisterV1ForEmail2Fragment.d(this.a).setEnabled(false);
        RegisterV1ForEmail2Fragment.d(this.a).setClickable(false);
        String str = String.format(this.a.getResources().getString(2131755568), new Object[] { Integer.valueOf(RegisterV1ForEmail2Fragment.c(this.a)) });
        RegisterV1ForEmail2Fragment.d(this.a).setText(str);
        RegisterV1ForEmail2Fragment.d(this.a).setTextColor(this.a.getResources().getColor(2131100844));
        RegisterV1ForEmail2Fragment.e(this.a);
        if (RegisterV1ForEmail2Fragment.c(this.a) == 0) {
          this.a.a(this);
          return;
        } 
        this.a.a(this, 1000L);
      }
    };
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this) {
      protected BluedEntityA<BluedLoginResult> a(String param1String) {
        RegisterV1ForEmail2Fragment.a(this.a, param1String);
        BluedEntityA<BluedLoginResult> bluedEntityA = (BluedEntityA)super.parseData(param1String);
        if (bluedEntityA != null)
          try {
            if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
              String str = AesCrypto.c(((BluedLoginResult)bluedEntityA.data.get(0)).get_());
              Logger.b(RegisterV1ForEmail2Fragment.h(this.a), new Object[] { "解密：deData===", str });
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
          Logger.b(RegisterV1ForEmail2Fragment.h(this.a), new Object[] { "===success", "加密：responseJson:", param1BluedEntityA });
          if (param1BluedEntityA.data.size() > 0 && param1BluedEntityA.data.get(0) != null) {
            Logger.b(RegisterV1ForEmail2Fragment.h(this.a), new Object[] { "===success", "加密：responseJson:", param1BluedEntityA });
            BluedLoginResult bluedLoginResult = param1BluedEntityA.data.get(0);
            UserInfo.a().a(RegisterV1ForEmail2Fragment.k(this.a), 0, RegisterV1ForEmail2Fragment.l(this.a), bluedLoginResult, new String[0]);
            Bundle bundle = new Bundle();
            bundle.putString("from_tag_page", "from_tag_register");
            HomeArgumentHelper.a(RegisterV1ForEmail2Fragment.j(this.a), null, bundle);
            return;
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
          AppMethods.d(2131756082);
        } 
      }
      
      public void onUIFinish() {
        DialogUtils.b(RegisterV1ForEmail2Fragment.f(this.a));
      }
      
      public void onUIStart() {
        DialogUtils.a(RegisterV1ForEmail2Fragment.f(this.a));
      }
    };
  
  private String f = RegisterV1ForEmail2Fragment.class.getSimpleName();
  
  private View g;
  
  private Context h;
  
  private Dialog i;
  
  private CommonTopTitleNoTrans j;
  
  private TextView k;
  
  private GridCodeEditText l;
  
  private TextView m;
  
  private TextView n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private String s;
  
  private String t = "";
  
  private String u;
  
  private String v;
  
  private int w;
  
  private int x;
  
  private TextWatcher y;
  
  private void a() {
    this.j = (CommonTopTitleNoTrans)this.g.findViewById(2131300300);
    this.j.a();
    this.j.e();
    this.j.setCenterText("");
    this.j.setTitleBackgroundDrawable(2131100528);
    this.j.setLeftClickListener(this);
  }
  
  private void k() {
    this.i = DialogUtils.a(this.h);
    this.n = (TextView)this.g.findViewById(2131300704);
    this.k = (TextView)this.g.findViewById(2131300656);
    this.k.setOnClickListener(this);
    this.l = (GridCodeEditText)this.g.findViewById(2131297019);
    this.l.setPasswordVisibility(true);
    this.l.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener(this) {
          public void a(String param1String) {
            if (param1String != null && param1String.length() == 6) {
              RegisterV1ForEmail2Fragment.a(this.a).setEnabled(true);
              RegisterV1ForEmail2Fragment.a(this.a).setClickable(true);
              return;
            } 
            RegisterV1ForEmail2Fragment.a(this.a).setEnabled(false);
            RegisterV1ForEmail2Fragment.a(this.a).setClickable(false);
          }
          
          public void b(String param1String) {}
        });
    this.m = (TextView)this.g.findViewById(2131299177);
    this.m.setOnClickListener(this);
    this.y = new TextWatcher(this) {
        public void afterTextChanged(Editable param1Editable) {
          RegisterV1ForEmail2Fragment.b(this.a);
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
  }
  
  private void l() {
    if (getArguments() != null) {
      this.p = getArguments().getString(LoginRegisterTools.c);
      this.s = getArguments().getString("original_email");
      this.r = getArguments().getString("secure_email");
      this.v = getArguments().getString("binding_type");
      if (!TextUtils.isEmpty(this.s)) {
        this.q = this.s;
        this.w = 1;
      } else {
        this.q = this.r;
        this.w = 0;
      } 
      if ("change".equals(this.v)) {
        this.j.setCenterText(this.h.getResources().getString(2131755749));
      } else if ("add".equals(this.v)) {
        this.j.setCenterText(this.h.getResources().getString(2131759022));
      } else {
        this.j.setCenterText(this.h.getResources().getString(2131755491));
      } 
      TextView textView = this.n;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getResources().getString(2131755527));
      stringBuilder.append(this.q);
      stringBuilder.append("\n");
      stringBuilder.append(getResources().getString(2131755528));
      textView.setText(stringBuilder.toString());
    } 
    n();
  }
  
  private void m() {
    if (!StringUtils.e(this.l.getPassWord())) {
      this.k.setClickable(true);
      this.k.setEnabled(true);
      return;
    } 
    this.k.setClickable(false);
    this.k.setEnabled(false);
  }
  
  private void n() {
    this.x = 60;
    a(this.d);
  }
  
  private void o() {
    LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BindingModel>>(this) {
          protected BluedEntityA<BindingModel> a(String param1String) {
            BluedEntityA<BindingModel> bluedEntityA = (BluedEntityA)super.parseData(param1String);
            if (RegisterV1ForEmail2Fragment.g(this.a) == 0 && bluedEntityA != null)
              try {
                if (bluedEntityA.hasData()) {
                  String str = AesCrypto.c(((BindingModel)bluedEntityA.data.get(0)).get_());
                  Logger.b(RegisterV1ForEmail2Fragment.h(this.a), new Object[] { "解密：deData===", str });
                  BindingModel bindingModel = (BindingModel)AppInfo.f().fromJson(str, BindingModel.class);
                  bluedEntityA.data.set(0, bindingModel);
                  return bluedEntityA;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.d(2131756082);
              }  
            return bluedEntityA;
          }
          
          public void a(BluedEntityA<BindingModel> param1BluedEntityA) {
            try {
              Bundle bundle;
              if (RegisterV1ForEmail2Fragment.g(this.a) == 1) {
                bundle = new Bundle();
                bundle.putString("binding_type", RegisterV1ForEmail2Fragment.i(this.a));
                TerminalActivity.d(RegisterV1ForEmail2Fragment.j(this.a), BindingSecureEmailFragment.class, bundle);
                this.a.getActivity().finish();
                return;
              } 
              if (((BluedEntityA)bundle).data.get(0) != null) {
                BindingModel bindingModel = ((BluedEntityA)bundle).data.get(0);
                if (bindingModel != null) {
                  String str = bindingModel.getSafeEmail();
                  UserInfo.a().d(str);
                } 
              } 
              AppMethods.d(2131757827);
              this.a.getActivity().finish();
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.d(2131756082);
              return;
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(RegisterV1ForEmail2Fragment.f(this.a));
          }
          
          public void onUIStart() {
            DialogUtils.a(RegisterV1ForEmail2Fragment.f(this.a));
          }
        }this.w, this.l.getPassWord(), null);
  }
  
  private void p() {
    LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BindingModel>>(this) {
          protected BluedEntityA<BindingModel> a(String param1String) {
            BluedEntityA<BindingModel> bluedEntityA = (BluedEntityA)super.parseData(param1String);
            if (bluedEntityA != null)
              try {
                if (bluedEntityA.hasData()) {
                  String str = AesCrypto.c(((BindingModel)bluedEntityA.data.get(0)).get_());
                  Logger.b(RegisterV1ForEmail2Fragment.h(this.a), new Object[] { "解密：deData===", str });
                  BindingModel bindingModel = (BindingModel)AppInfo.f().fromJson(str, BindingModel.class);
                  bluedEntityA.data.set(0, bindingModel);
                  return bluedEntityA;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.d(2131756082);
              }  
            return bluedEntityA;
          }
          
          public void a(BluedEntityA<BindingModel> param1BluedEntityA) {
            try {
              if (param1BluedEntityA.data.get(0) != null) {
                BindingModel bindingModel = param1BluedEntityA.data.get(0);
                if (bindingModel != null) {
                  String str = bindingModel.getSafeEmail();
                  UserInfo.a().d(str);
                } 
              } 
              AppMethods.d(2131757827);
              this.a.getActivity().finish();
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
          
          public void onUIFinish() {
            DialogUtils.b(RegisterV1ForEmail2Fragment.f(this.a));
          }
          
          public void onUIStart() {
            DialogUtils.a(RegisterV1ForEmail2Fragment.f(this.a));
          }
        }0, this.l.getPassWord(), null);
  }
  
  private void q() {
    n();
  }
  
  private void r() {
    this.m.setEnabled(false);
    this.m.setText(this.h.getResources().getString(2131755567));
  }
  
  private void s() {
    Bundle bundle = new Bundle();
    bundle.putString(LoginRegisterTools.d, this.o);
    bundle.putString(LoginRegisterTools.c, this.p);
    bundle.putString("binding_type", "add");
    Logger.b(this.f, new Object[] { "tokenVer===", this.o });
    Logger.b(this.f, new Object[] { "captcha===", this.p });
    TerminalActivity.a((Fragment)this, RegisterV1ForCaptchaCodeFragment.class, bundle, 1000);
  }
  
  private void t() {
    if (!TextUtils.isEmpty(this.q))
      LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
            public void a(BluedEntityA<Object> param1BluedEntityA) {
              RegisterV1ForEmail2Fragment.m(this.a);
              AppMethods.d(2131755575);
            }
            
            public void onUIFinish() {
              DialogUtils.b(RegisterV1ForEmail2Fragment.f(this.a));
            }
            
            public void onUIStart() {
              DialogUtils.a(RegisterV1ForEmail2Fragment.f(this.a));
            }
          },  "email", this.q, null); 
  }
  
  public void a(String paramString1, int paramInt, String paramString2) {
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          protected BluedEntityA<Object> a(String param1String) {
            Logger.b(RegisterV1ForEmail2Fragment.h(this.a), new Object[] { "===success", "responseJson:", param1String });
            return (BluedEntityA<Object>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            try {
              AppMethods.a(RegisterV1ForEmail2Fragment.j(this.a).getResources().getString(2131755575));
              RegisterV1ForEmail2Fragment.m(this.a);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              AppMethods.d(2131756082);
              return;
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int != 4036001) {
              if (param1Int != 4036204)
                return super.onUIFailure(param1Int, param1String); 
              RegisterV1ForEmail2Fragment.n(this.a);
              return true;
            } 
            if (this.a.getActivity() != null)
              this.a.getActivity().finish(); 
            return true;
          }
          
          public void onUIFinish() {
            DialogUtils.b(RegisterV1ForEmail2Fragment.f(this.a));
          }
          
          public void onUIStart() {
            DialogUtils.a(RegisterV1ForEmail2Fragment.f(this.a));
          }
        }paramString1, paramInt, paramString2, null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1000)
      return; 
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra(LoginRegisterTools.c);
      if (!StringUtils.e(str))
        a(str, 0, this.q); 
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131299177) {
        if (i != 2131300656)
          return; 
        if (!TextUtils.isEmpty(this.v) && "change".equals(this.v)) {
          o();
          return;
        } 
        if (!StringUtils.e(this.l.getPassWord())) {
          p();
          return;
        } 
        AppMethods.d(2131755462);
        return;
      } 
      this.l.a();
      LoginRegisterHttpUtils.a("resend_acode");
      if ("add".equals(this.v)) {
        s();
        return;
      } 
      if (this.w == 1) {
        t();
        return;
      } 
      s();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.h = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493292, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
  
  public void onResume() {
    super.onResume();
    m();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\RegisterV1ForEmail2Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */