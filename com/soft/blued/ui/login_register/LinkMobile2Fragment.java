package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.model.BluedLoginResultVerBinding;
import com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment;
import com.soft.blued.ui.setting.model.LoginProtectionModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class LinkMobile2Fragment extends BaseFragment implements View.OnClickListener {
  Runnable d = new Runnable(this) {
      public void run() {
        if (LinkMobile2Fragment.b(this.a) == 0) {
          LinkMobile2Fragment.c(this.a).setEnabled(true);
          LinkMobile2Fragment.c(this.a).setClickable(true);
          LinkMobile2Fragment.c(this.a).setText(this.a.getResources().getString(2131758621));
          LinkMobile2Fragment.c(this.a).setTextColor(this.a.getResources().getColor(2131100527));
          return;
        } 
        LinkMobile2Fragment.c(this.a).setEnabled(false);
        LinkMobile2Fragment.c(this.a).setClickable(false);
        String str = String.format(this.a.getResources().getString(2131755568), new Object[] { Integer.valueOf(LinkMobile2Fragment.b(this.a)) });
        LinkMobile2Fragment.c(this.a).setText(str);
        LinkMobile2Fragment.c(this.a).setTextColor(this.a.getResources().getColor(2131100543));
        LinkMobile2Fragment.d(this.a);
        if (LinkMobile2Fragment.b(this.a) == 0) {
          this.a.a(this);
          return;
        } 
        this.a.a(this, 1000L);
      }
    };
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
      protected void a(BluedEntityA<Object> param1BluedEntityA) {
        LinkMobile2Fragment.e(this.a);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        switch (param1Int) {
          default:
            return super.onUIFailure(param1Int, param1String);
          case 4036209:
            LinkMobile2Fragment.a(this.a, 4036209, param1String);
            return true;
          case 4036208:
            LinkMobile2Fragment.a(this.a, 4036208, param1String);
            return true;
          case 4036207:
          case 4036210:
            break;
        } 
        AppMethods.a(AppInfo.d().getResources().getString(2131756306));
        if (this.a.getActivity() != null)
          this.a.getActivity().finish(); 
        return true;
      }
      
      public void onUIFinish() {
        DialogUtils.b(LinkMobile2Fragment.f(this.a));
        super.onUIFinish();
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(LinkMobile2Fragment.f(this.a));
      }
    };
  
  public BluedUIHttpResponse f = new BluedUIHttpResponse(this) {
      public boolean onUIFailure(int param1Int, String param1String) {
        if (param1Int == 4036204) {
          LinkMobile2Fragment.i(this.a);
          AppMethods.d(2131756305);
          return true;
        } 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        DialogUtils.b(LinkMobile2Fragment.f(this.a));
        super.onUIFinish();
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(LinkMobile2Fragment.f(this.a));
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        AppMethods.a(LinkMobile2Fragment.g(this.a).getResources().getString(2131755575));
        LinkMobile2Fragment.h(this.a);
      }
    };
  
  public BluedUIHttpResponse g = new BluedUIHttpResponse(this, (IRequestHost)w_()) {
      public boolean onUIFailure(int param1Int, String param1String) {
        if (param1Int == 4036210)
          this.a.getActivity().finish(); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        DialogUtils.b(LinkMobile2Fragment.f(this.a));
        super.onUIFinish();
      }
      
      public void onUIStart() {
        DialogUtils.a(LinkMobile2Fragment.f(this.a));
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        LinkMobile2Fragment.e(this.a);
      }
    };
  
  private String h = LinkMobile2Fragment.class.getSimpleName();
  
  private View i;
  
  private Context j;
  
  private Dialog k;
  
  private CommonTopTitleNoTrans l;
  
  private TextView m;
  
  private String n;
  
  private String o;
  
  private GridCodeEditText p;
  
  private TextView q;
  
  private String r;
  
  private String s;
  
  private TextView t;
  
  private int u;
  
  private String v;
  
  private void a() {
    this.l = (CommonTopTitleNoTrans)this.i.findViewById(2131300300);
    this.l.a();
    this.l.e();
    this.l.setTitleBackgroundDrawable(2131100728);
    this.l.setLeftClickListener(this);
  }
  
  private void a(int paramInt, String paramString) {
    Context context = this.j;
    CommonAlertDialog.a(context, "", context.getResources().getString(2131757824), this.j.getResources().getString(2131755577), null, this.j.getResources().getString(2131755597), new DialogInterface.OnClickListener(this, paramInt, paramString) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            switch (this.a) {
              default:
                return;
              case 4036209:
                LinkMobile2Fragment.b(this.c, this.b);
                return;
              case 4036208:
                break;
            } 
            LinkMobile2Fragment.a(this.c, this.b);
          }
        }null);
  }
  
  private void a(String paramString) {
    Context context = this.j;
    CommonAlertDialog.a(context, "", paramString, context.getResources().getString(2131755577), null, this.j.getResources().getString(2131755609), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            LinkMobile2Fragment.j(this.a);
          }
        },  null);
  }
  
  private void b(String paramString) {
    Context context = this.j;
    CommonAlertDialog.a(context, "", paramString, context.getResources().getString(2131755577), null, this.j.getResources().getString(2131755609), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            LinkMobile2Fragment.j(this.a);
          }
        },  null);
  }
  
  private void k() {
    this.t = (TextView)this.i.findViewById(2131300704);
    this.k = DialogUtils.a(this.j);
    this.m = (TextView)this.i.findViewById(2131300656);
    this.m.setOnClickListener(this);
    this.p = (GridCodeEditText)this.i.findViewById(2131297019);
    this.p.setPasswordVisibility(true);
    this.p.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener(this) {
          public void a(String param1String) {
            if (param1String != null && param1String.length() == 6) {
              LinkMobile2Fragment.a(this.a).setEnabled(true);
              LinkMobile2Fragment.a(this.a).setClickable(true);
              return;
            } 
            LinkMobile2Fragment.a(this.a).setEnabled(false);
            LinkMobile2Fragment.a(this.a).setClickable(false);
          }
          
          public void b(String param1String) {}
        });
    this.q = (TextView)this.i.findViewById(2131299177);
    this.q.setOnClickListener(this);
  }
  
  private void l() {
    if (getArguments() != null) {
      this.v = getArguments().getString("from_page");
      this.n = getArguments().getString(LoginRegisterTools.e);
      this.o = getArguments().getString(LoginRegisterTools.g);
      this.r = getArguments().getString(LoginRegisterTools.k);
      TextView textView = this.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getResources().getString(2131755564));
      stringBuilder.append(LoginRegisterTools.e(this.n));
      stringBuilder.append("\n");
      stringBuilder.append(getResources().getString(2131755566));
      textView.setText(stringBuilder.toString());
      if (!StringUtils.e(this.r) && (this.r.equals(LoginRegisterTools.l) || this.r.equals(LoginRegisterTools.n))) {
        this.l.setCenterText(getResources().getString(2131757828));
        textView = this.t;
        stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131755565));
        stringBuilder.append(LoginRegisterTools.e(this.n));
        stringBuilder.append("\n");
        stringBuilder.append(getResources().getString(2131755566));
        textView.setText(stringBuilder.toString());
      } 
      this.s = getArguments().getString(LoginRegisterTools.m);
    } 
    m();
  }
  
  private void m() {
    this.u = 60;
    a(this.d);
  }
  
  private void n() {
    if (!StringUtils.e(this.r) && (this.r.equals(LoginRegisterTools.l) || this.r.equals(LoginRegisterTools.n))) {
      LoginRegisterHttpUtils.a(this.e, this.p.getPassWord(), 1, (IRequestHost)w_());
      return;
    } 
    LoginRegisterHttpUtils.a(this.e, this.p.getPassWord(), 0, (IRequestHost)w_());
  }
  
  private void o() {
    if (!StringUtils.e(this.r) && (this.r.equals(LoginRegisterTools.l) || this.r.equals(LoginRegisterTools.n))) {
      BluedUIHttpResponse bluedUIHttpResponse1 = this.f;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.o);
      stringBuilder1.append("-");
      stringBuilder1.append(this.n);
      LoginRegisterHttpUtils.a(bluedUIHttpResponse1, stringBuilder1.toString(), "mobile", "", this.s, 1, (IRequestHost)w_());
      return;
    } 
    BluedUIHttpResponse bluedUIHttpResponse = this.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.o);
    stringBuilder.append("-");
    stringBuilder.append(this.n);
    LoginRegisterHttpUtils.a(bluedUIHttpResponse, stringBuilder.toString(), "mobile", "", this.s, 0, (IRequestHost)w_());
  }
  
  private void p() {
    m();
  }
  
  private void q() {
    this.q.setEnabled(false);
    this.q.setText(this.j.getResources().getString(2131755567));
  }
  
  private void r() {
    if (!StringUtils.e(this.r) && this.r.equals(LoginRegisterTools.l)) {
      TerminalActivity.d((Context)getActivity(), LinkMobileFragment.class, null);
      getActivity().finish();
      return;
    } 
    BluedLoginResultVerBinding bluedLoginResultVerBinding2 = UserInfo.a().i().getVerified_bindings();
    BluedLoginResultVerBinding bluedLoginResultVerBinding1 = bluedLoginResultVerBinding2;
    if (bluedLoginResultVerBinding2 == null)
      bluedLoginResultVerBinding1 = new BluedLoginResultVerBinding(); 
    bluedLoginResultVerBinding1.mobile = LoginRegisterTools.a(this.o, this.n);
    UserInfo.a().i().setNeed_auth(0);
    if (!StringUtils.e(this.r) && (this.r.equals(LoginRegisterTools.n) || this.r.equals(LoginRegisterTools.o))) {
      Bundle bundle = new Bundle();
      bundle.putBoolean("RECOME", true);
      TerminalActivity.d((Context)getActivity(), PayPasswordSettingFragment.class, bundle);
      getActivity().finish();
      return;
    } 
    AppMethods.d(2131757827);
    t();
    if ("login_secure".equals(this.v)) {
      s();
      return;
    } 
    getActivity().finish();
  }
  
  private void s() {
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LoginProtectionModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<LoginProtectionModel> param1BluedEntityA) {
            this.a.getActivity().finish();
          }
        }"set", "", "", (IRequestHost)w_());
  }
  
  private void t() {
    UserInfo.a().c(LoginRegisterTools.a(this.o, this.n));
    BluedPreferences.J(LoginRegisterTools.a(this.o, this.n));
    BluedPreferences.g(1);
  }
  
  private void u() {
    LoginRegisterHttpUtils.c(this.g, (IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131299177) {
        if (i != 2131300656)
          return; 
        if (!StringUtils.e(this.p.getPassWord())) {
          n();
          return;
        } 
        AppMethods.d(2131755462);
        return;
      } 
      this.p.a();
      o();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.j = (Context)getActivity();
    View view = this.i;
    if (view == null) {
      this.i = paramLayoutInflater.inflate(2131493166, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.i.getParent()).removeView(this.i);
    } 
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\LinkMobile2Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */