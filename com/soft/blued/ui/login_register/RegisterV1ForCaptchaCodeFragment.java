package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.utils.StringUtils;

public class RegisterV1ForCaptchaCodeFragment extends BaseFragment implements View.OnClickListener {
  private String d = RegisterV1ForCaptchaCodeFragment.class.getSimpleName();
  
  private View e;
  
  private Context f;
  
  private CommonTopTitleNoTrans g;
  
  private TextView h;
  
  private LinearLayout i;
  
  private ImageView j;
  
  private EditText k;
  
  private String l;
  
  private String m;
  
  private TextWatcher n;
  
  private void a() {
    this.g = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    this.g.a();
    this.g.setCenterText(getString(2131755491));
    this.g.setLeftClickListener(this);
  }
  
  private void k() {
    if (!StringUtils.e(this.k.getText().toString())) {
      this.h.setEnabled(true);
      this.h.setClickable(true);
      return;
    } 
    this.h.setEnabled(true);
    this.h.setClickable(true);
  }
  
  private void l() {
    this.k.addTextChangedListener(this.n);
  }
  
  private void m() {
    this.k.removeTextChangedListener(this.n);
  }
  
  private void n() {
    this.i = (LinearLayout)this.e.findViewById(2131299067);
    this.i.setOnClickListener(this);
    this.h = (TextView)this.e.findViewById(2131300656);
    this.h.setOnClickListener(this);
    this.j = (ImageView)this.e.findViewById(2131296341);
    this.j.setOnClickListener(this);
    this.k = (EditText)this.e.findViewById(2131297003);
    this.k.setTextColor(BluedSkinUtils.a(this.f, 2131100838));
    this.n = new TextWatcher(this) {
        public void afterTextChanged(Editable param1Editable) {
          RegisterV1ForCaptchaCodeFragment.a(this.a);
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
  }
  
  private void o() {
    if (getArguments() != null) {
      this.l = getArguments().getString(LoginRegisterTools.d);
      this.m = getArguments().getString(LoginRegisterTools.c);
      if ("add".equals(getArguments().getString("binding_type")))
        this.g.setCenterText(this.f.getResources().getString(2131759022)); 
      if (!StringUtils.e(this.m))
        LoginRegisterTools.a((IRequestHost)w_(), this.j, this.m); 
    } 
  }
  
  private void p() {
    Intent intent = new Intent();
    intent.putExtra(LoginRegisterTools.c, "");
    getActivity().setResult(-1, intent);
    getActivity().finish();
  }
  
  public boolean V_() {
    p();
    return super.V_();
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131300656:
        LoginRegisterHttpUtils.a("captcha_acode");
        if (!StringUtils.e(this.k.getText().toString())) {
          Intent intent = new Intent();
          intent.putExtra(LoginRegisterTools.c, this.k.getText().toString());
          getActivity().setResult(-1, intent);
          getActivity().finish();
          return;
        } 
        AppMethods.d(2131755462);
        return;
      case 2131299067:
        KeyboardUtils.a((Activity)getActivity());
        return;
      case 2131296863:
        p();
        return;
      case 2131296341:
        break;
    } 
    if (!StringUtils.e(this.m))
      LoginRegisterTools.a((IRequestHost)w_(), this.j, this.m); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493295, paramViewGroup, false);
      a();
      n();
      o();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onResume() {
    super.onResume();
    k();
    l();
  }
  
  public void onStop() {
    m();
    super.onStop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\RegisterV1ForCaptchaCodeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */