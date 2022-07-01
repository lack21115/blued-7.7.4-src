package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.model.PayRemaining;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.login_register.LinkMobile2Fragment;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.setting.model.PayPWDStatusModel;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

public class PayPasswordSettingFragment extends BaseFragment implements View.OnClickListener {
  private static final String e = PayPasswordSettingFragment.class.getSimpleName();
  
  public BluedUIHttpResponse d = new BluedUIHttpResponse(this) {
      public void onUIFinish() {
        DialogUtils.b(PayPasswordSettingFragment.b(this.a));
        super.onUIFinish();
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(PayPasswordSettingFragment.b(this.a));
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        AppMethods.a(this.a.getActivity().getResources().getString(2131755575));
        Bundle bundle = new Bundle();
        bundle.putString(LoginRegisterTools.g, PayPasswordSettingFragment.i(this.a));
        bundle.putString(LoginRegisterTools.e, PayPasswordSettingFragment.j(this.a));
        bundle.putString(LoginRegisterTools.k, LoginRegisterTools.n);
        bundle.putString(LoginRegisterTools.m, "");
        TerminalActivity.d((Context)this.a.getActivity(), LinkMobile2Fragment.class, bundle);
        this.a.getActivity().finish();
      }
    };
  
  private View f;
  
  private Dialog g;
  
  private TextView h;
  
  private TextView i;
  
  private ClearEditText j;
  
  private TextView k;
  
  private CommonTopTitleNoTrans l;
  
  private String m;
  
  private String n;
  
  private LinearLayout o;
  
  private LinearLayout p;
  
  private LinearLayout q;
  
  private boolean r;
  
  private GridCodeEditText s;
  
  private CommonEdittextView t;
  
  private void a(String paramString) {
    PayHttpUtils.a(paramString, Boolean.valueOf(false), 2, new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(this) {
          protected void a(BluedEntityA<PayRemaining> param1BluedEntityA) {
            AppMethods.a(this.a.getString(2131755028));
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              PayRemaining payRemaining = param1BluedEntityA.data.get(0);
              try {
                String str = AesCrypto.c(payRemaining._);
                BluedPreferences.V(((DecryptJson)AppInfo.f().fromJson(str, DecryptJson.class)).token);
              } catch (Exception exception) {}
            } 
            this.a.getActivity().finish();
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(PayPasswordSettingFragment.b(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(PayPasswordSettingFragment.b(this.a));
          }
        }(IRequestHost)w_());
  }
  
  private void b(String paramString) {
    PayHttpUtils.a(paramString, new BluedUIHttpResponse(this) {
          public boolean onUIFailure(int param1Int, String param1String) {
            PayPasswordSettingFragment.h(this.a).a();
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(PayPasswordSettingFragment.b(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            if (!PayPasswordSettingFragment.b(this.a).isShowing())
              DialogUtils.a(PayPasswordSettingFragment.b(this.a)); 
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.a(this.a.getString(2131755028));
            this.a.getActivity().finish();
          }
        }(IRequestHost)w_());
  }
  
  private void l() {
    if (getArguments() != null) {
      this.r = getArguments().getBoolean("RECOME");
      if (this.r) {
        this.o.setVisibility(0);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
      } 
    } else {
      n();
    } 
    this.s = (GridCodeEditText)this.f.findViewById(2131297272);
    this.s.setPasswordVisibility(true);
    this.s.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener(this) {
          public void a(String param1String) {}
          
          public void b(String param1String) {
            if (PayPasswordSettingFragment.a(this.a)) {
              PayPasswordSettingFragment.a(this.a, param1String);
              return;
            } 
            PayPasswordSettingFragment.b(this.a, param1String);
          }
        });
  }
  
  private void m() {
    this.j.setText(this.n);
    this.j.b();
    this.j.setEnabled(false);
    if (!StringUtils.e(this.m)) {
      this.k.setText(this.m);
      return;
    } 
    String str = AreaUtils.a(AreaUtils.b());
    if (!StringUtils.e(str)) {
      this.k.setText(str);
      return;
    } 
    this.k.setText("+86");
  }
  
  private void n() {
    PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<PayPWDStatusModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<PayPWDStatusModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData() && ((PayPWDStatusModel)param1BluedEntityA.getSingleData()).status == 1) {
              String str = LoginRegisterTools.b();
              if (!StringUtils.e(str)) {
                String[] arrayOfString = LoginRegisterTools.h(str);
                PayPasswordSettingFragment.c(this.a, arrayOfString[0]);
                PayPasswordSettingFragment.d(this.a, arrayOfString[1]);
                if (arrayOfString.length >= 2) {
                  PayPasswordSettingFragment.c(this.a);
                  PayPasswordSettingFragment.d(this.a).setCenterText(2131755157);
                  PayPasswordSettingFragment.e(this.a).setVisibility(8);
                  PayPasswordSettingFragment.f(this.a).setVisibility(8);
                  PayPasswordSettingFragment.g(this.a).setVisibility(0);
                  return;
                } 
                PayPasswordSettingFragment.d(this.a).setCenterText(2131755148);
                PayPasswordSettingFragment.e(this.a).setVisibility(8);
                PayPasswordSettingFragment.f(this.a).setVisibility(0);
                PayPasswordSettingFragment.g(this.a).setVisibility(8);
                return;
              } 
              PayPasswordSettingFragment.d(this.a).setCenterText(2131755148);
              PayPasswordSettingFragment.e(this.a).setVisibility(8);
              PayPasswordSettingFragment.f(this.a).setVisibility(0);
              PayPasswordSettingFragment.g(this.a).setVisibility(8);
              return;
            } 
            PayPasswordSettingFragment.d(this.a).setCenterText(2131755148);
            PayPasswordSettingFragment.e(this.a).setVisibility(0);
            PayPasswordSettingFragment.f(this.a).setVisibility(8);
            PayPasswordSettingFragment.g(this.a).setVisibility(8);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(PayPasswordSettingFragment.b(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(PayPasswordSettingFragment.b(this.a));
          }
        }(IRequestHost)w_());
  }
  
  protected void a() {
    this.l = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    this.l.a();
    this.l.e();
    this.l.setTitleBackgroundDrawable(2131100528);
    this.l.setLeftClickListener(this);
  }
  
  protected void k() {
    this.o = (LinearLayout)this.f.findViewById(2131298954);
    LoginRegisterTools.a((View)this.o);
    this.p = (LinearLayout)this.f.findViewById(2131299009);
    this.g = DialogUtils.a((Context)getActivity());
    this.q = (LinearLayout)this.f.findViewById(2131299012);
    this.h = (TextView)this.f.findViewById(2131296584);
    this.h.setOnClickListener(this);
    this.i = (TextView)this.f.findViewById(2131296609);
    this.i.setOnClickListener(this);
    this.t = (CommonEdittextView)this.f.findViewById(2131296682);
    this.j = this.t.getEditText();
    this.k = this.t.getAreaCodeText();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296584) {
      if (i != 2131296609) {
        if (i != 2131296863)
          return; 
        getActivity().finish();
        return;
      } 
      BluedUIHttpResponse bluedUIHttpResponse = this.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.m);
      stringBuilder.append("-");
      stringBuilder.append(this.n);
      LoginRegisterHttpUtils.a(bluedUIHttpResponse, stringBuilder.toString(), "mobile", "", "", 1, (IRequestHost)w_());
      return;
    } 
    Bundle bundle = new Bundle();
    bundle.putString(LoginRegisterTools.k, LoginRegisterTools.o);
    bundle.putString(LoginRegisterTools.e, this.n);
    bundle.putString(LoginRegisterTools.g, this.m);
    TerminalActivity.d((Context)getActivity(), LinkMobileFragment.class, bundle);
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493260, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onDestroy() {
    super.onDestroy();
    DialogUtils.b(this.g);
  }
  
  public void onResume() {
    super.onResume();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\PayPasswordSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */