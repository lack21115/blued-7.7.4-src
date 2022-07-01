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
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;

public class LinkMobileFragment extends BaseFragment implements View.OnClickListener {
  public BluedUIHttpResponse d = new BluedUIHttpResponse(this) {
      public void onUIFinish() {
        DialogUtils.b(LinkMobileFragment.g(this.a));
        super.onUIFinish();
      }
      
      public void onUIStart() {
        DialogUtils.a(LinkMobileFragment.g(this.a));
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity param1BluedEntity) {
        AppMethods.a(LinkMobileFragment.e(this.a).getResources().getString(2131755575));
        LinkMobileFragment.f(this.a);
      }
    };
  
  private String e = LinkMobileFragment.class.getSimpleName();
  
  private View f;
  
  private Context g;
  
  private ClearEditText h;
  
  private Dialog i;
  
  private CommonTopTitleNoTrans j;
  
  private TextView k;
  
  private CommonEdittextView l;
  
  private TextView m;
  
  private String n;
  
  private String o;
  
  private String p;
  
  private TextView q;
  
  private TextView r;
  
  private CommonEdittextView s;
  
  private ClearEditText t;
  
  private String u;
  
  private int v;
  
  private void k() {
    this.j = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    this.j.a();
    this.j.setCenterText("");
    this.j.setLeftClickListener(this);
    this.j.e();
    this.j.setTitleBackgroundDrawable(2131100528);
  }
  
  private void l() {
    this.i = DialogUtils.a(this.g);
    this.j.setCenterText(2131755637);
    this.k = (TextView)this.f.findViewById(2131301422);
    this.k.setOnClickListener(this);
    this.s = (CommonEdittextView)this.f.findViewById(2131296981);
    this.t = this.s.getEditText();
    this.l = (CommonEdittextView)this.f.findViewById(2131296980);
    this.l.setAreaCodeClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Bundle bundle = new Bundle();
            bundle.putString(RegisterV1AreaCodeFragment.p, LinkMobileFragment.class.getSimpleName());
            TerminalActivity.a((Fragment)this.a, RegisterV1AreaCodeFragment.class, bundle, 100);
          }
        });
    this.m = this.l.getAreaCodeText();
    this.h = this.l.getEditText();
    this.h.setInputType(2);
    this.h.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            if (LinkMobileFragment.a(this.a).getVisibility() == 8) {
              if (TextUtils.isEmpty(LinkMobileFragment.b(this.a).getText().toString())) {
                LinkMobileFragment.c(this.a).setEnabled(false);
                LinkMobileFragment.c(this.a).setClickable(false);
                return;
              } 
              LinkMobileFragment.c(this.a).setEnabled(true);
              LinkMobileFragment.c(this.a).setClickable(true);
              return;
            } 
            if (!TextUtils.isEmpty(LinkMobileFragment.b(this.a).getText().toString()) && !TextUtils.isEmpty(LinkMobileFragment.d(this.a).getText().toString())) {
              LinkMobileFragment.c(this.a).setEnabled(true);
              LinkMobileFragment.c(this.a).setClickable(true);
              return;
            } 
            LinkMobileFragment.c(this.a).setEnabled(false);
            LinkMobileFragment.c(this.a).setClickable(false);
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
    this.q = (TextView)this.f.findViewById(2131296685);
    this.r = (TextView)this.f.findViewById(2131296535);
    this.v = UserInfo.a().e();
    if (this.v == 2) {
      this.r.setText(getResources().getString(2131757831));
      this.s.setVisibility(0);
      this.t.addTextChangedListener(new TextWatcher(this) {
            public void afterTextChanged(Editable param1Editable) {
              if (!TextUtils.isEmpty(LinkMobileFragment.b(this.a).getText().toString()) && !TextUtils.isEmpty(LinkMobileFragment.d(this.a).getText().toString())) {
                LinkMobileFragment.c(this.a).setEnabled(true);
                LinkMobileFragment.c(this.a).setClickable(true);
                return;
              } 
              LinkMobileFragment.c(this.a).setEnabled(false);
              LinkMobileFragment.c(this.a).setClickable(false);
            }
            
            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            
            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          });
      this.r.setText(String.format(getResources().getString(2131757831), new Object[] { getResources().getString(2131759358) }));
    } 
  }
  
  private void m() {
    if (getArguments() != null) {
      this.u = getArguments().getString("from_page");
      this.n = getArguments().getString(LoginRegisterTools.k);
      this.o = getArguments().getString(LoginRegisterTools.g);
      this.p = getArguments().getString(LoginRegisterTools.e);
      if (!StringUtils.e(this.n) && this.n.equals(LoginRegisterTools.l)) {
        this.j.setCenterText(this.g.getResources().getString(2131757822));
        this.q.setVisibility(0);
        this.r.setVisibility(8);
        this.h.setText(this.p);
        this.h.b();
        this.h.setEnabled(false);
        this.l.setAreaCodeClickListener(null);
      } 
    } 
    if (!StringUtils.e(this.o)) {
      this.m.setText(this.o);
      this.l.setEnabled(false);
      return;
    } 
    String str = AreaUtils.a(AreaUtils.b());
    if (!StringUtils.e(str)) {
      this.m.setText(str);
      return;
    } 
    this.m.setText("+86");
  }
  
  private void n() {
    if (!StringUtils.e(this.h.getText().toString())) {
      if (!StringUtils.e(this.n) && this.n.equals(LoginRegisterTools.l)) {
        BluedUIHttpResponse bluedUIHttpResponse1 = this.d;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.m.getText().toString());
        stringBuilder1.append("-");
        stringBuilder1.append(this.h.getText().toString());
        LoginRegisterHttpUtils.a(bluedUIHttpResponse1, stringBuilder1.toString(), "mobile", "", this.t.getText().toString(), 1, (IRequestHost)w_());
        return;
      } 
      if (!StringUtils.e(this.n) && this.n.equals(LoginRegisterTools.o)) {
        BluedUIHttpResponse bluedUIHttpResponse1 = this.d;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.m.getText().toString());
        stringBuilder1.append("-");
        stringBuilder1.append(this.h.getText().toString());
        LoginRegisterHttpUtils.a(bluedUIHttpResponse1, stringBuilder1.toString(), "mobile", "", this.t.getText().toString(), 0, (IRequestHost)w_());
        return;
      } 
      BluedUIHttpResponse bluedUIHttpResponse = this.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.m.getText().toString());
      stringBuilder.append("-");
      stringBuilder.append(this.h.getText().toString());
      LoginRegisterHttpUtils.a(bluedUIHttpResponse, stringBuilder.toString(), "mobile", "", this.t.getText().toString(), 0, (IRequestHost)w_());
      return;
    } 
    AppMethods.d(2131755462);
  }
  
  private void o() {
    Bundle bundle = new Bundle();
    bundle.putString(LoginRegisterTools.g, this.m.getText().toString());
    bundle.putString(LoginRegisterTools.e, this.h.getText().toString());
    bundle.putString(LoginRegisterTools.k, this.n);
    bundle.putString(LoginRegisterTools.m, this.t.getText().toString());
    bundle.putString("from_page", this.u);
    Logger.b(this.e, new Object[] { "areacode===", this.m.getText().toString() });
    Logger.b(this.e, new Object[] { "phonenum===", this.h.getText().toString() });
    TerminalActivity.d((Context)getActivity(), LinkMobile2Fragment.class, bundle);
    getActivity().finish();
  }
  
  public void a() {
    int i = this.t.getText().toString().length();
    if (this.v != 2) {
      n();
      return;
    } 
    if (i >= 6) {
      n();
      return;
    } 
    AppMethods.d(2131755572);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 100)
      return; 
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra(RegisterV1AreaCodeFragment.o);
      if (!StringUtils.e(str))
        this.m.setText(str); 
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131301422)
        return; 
      a();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.g = (Context)getActivity();
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493165, paramViewGroup, false);
      k();
      l();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\LinkMobileFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */