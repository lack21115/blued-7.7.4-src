package com.soft.blued.ui.login_register.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.ui.login_register.Contract.VerifyCodeContract;
import com.soft.blued.ui.login_register.presenter.VerifyCodePresenter;

public class VerifyCodeFragment extends BaseFragment implements View.OnClickListener, VerifyCodeContract.IView {
  Runnable d = new Runnable(this) {
      public void run() {
        if (VerifyCodeFragment.b(this.a) == 0) {
          VerifyCodeFragment.c(this.a).setEnabled(true);
          VerifyCodeFragment.c(this.a).setClickable(true);
          VerifyCodeFragment.c(this.a).setText(this.a.getResources().getString(2131758621));
          VerifyCodeFragment.c(this.a).setTextColor(this.a.getResources().getColor(2131100527));
          return;
        } 
        VerifyCodeFragment.c(this.a).setEnabled(false);
        VerifyCodeFragment.c(this.a).setClickable(false);
        String str = String.format(this.a.getResources().getString(2131755568), new Object[] { Integer.valueOf(VerifyCodeFragment.b(this.a)) });
        VerifyCodeFragment.c(this.a).setText(str);
        VerifyCodeFragment.c(this.a).setTextColor(this.a.getResources().getColor(2131100543));
        VerifyCodeFragment.d(this.a);
        if (VerifyCodeFragment.b(this.a) == 0) {
          this.a.a(this);
          return;
        } 
        this.a.a(this, 1000L);
      }
    };
  
  private View e;
  
  private Dialog f;
  
  private Context g;
  
  private VerifyCodeContract.IPresenter h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private GridCodeEditText l;
  
  private CommonTopTitleNoTrans m;
  
  private String n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private String s;
  
  private int t;
  
  private int u;
  
  private String v;
  
  private String w;
  
  public static void a(Context paramContext, Bundle paramBundle) {
    TerminalActivity.d(paramContext, VerifyCodeFragment.class, paramBundle);
  }
  
  private void k() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.t = bundle.getInt("target_type");
      this.n = bundle.getString("token");
      this.o = bundle.getString("mobile");
      this.p = bundle.getString("password");
      this.q = bundle.getString("login_type");
      this.r = bundle.getString("login_account");
      this.s = bundle.getString("aliasUserId");
      this.v = bundle.getString("safe_device_type");
      this.w = bundle.getString("safe_device_number");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("mSafeDeviceType:");
      stringBuilder1.append(this.v);
      stringBuilder1.append(" -- mSafeDeviceNumber:");
      stringBuilder1.append(this.w);
      Log.v("drb", stringBuilder1.toString());
    } 
    this.f = DialogUtils.a(this.g);
    this.i = (TextView)this.e.findViewById(2131300656);
    this.j = (TextView)this.e.findViewById(2131300704);
    this.k = (TextView)this.e.findViewById(2131301270);
    this.m = (CommonTopTitleNoTrans)this.e.findViewById(2131300273);
    this.m.a();
    this.m.e();
    this.m.setCenterText("");
    this.m.setTitleBackgroundDrawable(2131100728);
    this.l = (GridCodeEditText)this.e.findViewById(2131297236);
    this.l.setPasswordVisibility(true);
    this.i.setOnClickListener(this);
    this.m.setLeftClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener(this) {
          public void a(String param1String) {
            if (param1String != null && param1String.length() == 6) {
              VerifyCodeFragment.a(this.a).setEnabled(true);
              VerifyCodeFragment.a(this.a).setClickable(true);
              return;
            } 
            VerifyCodeFragment.a(this.a).setEnabled(false);
            VerifyCodeFragment.a(this.a).setClickable(false);
          }
          
          public void b(String param1String) {}
        });
    l();
    if (TextUtils.equals(this.v, "relation_mobile") || TextUtils.equals(this.v, "login_mobile")) {
      this.m.setCenterText(this.g.getResources().getString(2131757909));
      TextView textView1 = this.j;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(getResources().getString(2131755564));
      stringBuilder1.append(this.w);
      stringBuilder1.append("\n");
      stringBuilder1.append(getResources().getString(2131755566));
      textView1.setText(stringBuilder1.toString());
      return;
    } 
    if (TextUtils.equals(this.v, "safe_email") || TextUtils.equals(this.v, "login_email")) {
      this.m.setCenterText(this.g.getResources().getString(2131756353));
      TextView textView1 = this.j;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(getResources().getString(2131755527));
      stringBuilder1.append("：");
      stringBuilder1.append(this.w);
      stringBuilder1.append("\n");
      stringBuilder1.append(getResources().getString(2131755566));
      textView1.setText(stringBuilder1.toString());
      return;
    } 
    this.m.setCenterText(this.g.getResources().getString(2131757909));
    TextView textView = this.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getResources().getString(2131755564));
    stringBuilder.append(this.o);
    stringBuilder.append("\n");
    stringBuilder.append(getResources().getString(2131755566));
    textView.setText(stringBuilder.toString());
  }
  
  private void l() {
    this.u = 60;
    a(this.d);
  }
  
  public void a() {
    DialogUtils.a(this.f);
  }
  
  public void b() {
    DialogUtils.b(this.f);
  }
  
  public void c() {
    getActivity().setResult(1, null);
    getActivity().finish();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131300656) {
        if (i != 2131301270)
          return; 
        l();
        this.h.a(this.n, this.t);
        return;
      } 
      String str = this.l.getPassWord();
      this.h.a(this.n, str, this.q, this.r, this.p, this.t, this.s);
      return;
    } 
    a(new Runnable(this) {
          public void run() {
            this.a.getActivity().finish();
          }
        });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.g = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493349, paramViewGroup, false);
      this.h = (VerifyCodeContract.IPresenter)new VerifyCodePresenter(this.g, this, (IRequestHost)w_());
      k();
    } else {
      ((ViewGroup)view.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\View\VerifyCodeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */