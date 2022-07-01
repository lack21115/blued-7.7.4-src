package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment;
import com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment;

public class VerifyOriginalAccountDetailFragment extends BaseFragment implements View.OnClickListener {
  private final String d = VerifyOriginalAccountDetailFragment.class.getSimpleName();
  
  private Context e;
  
  private Dialog f;
  
  private ClearEditText g;
  
  private CommonTopTitleNoTrans h;
  
  private TextView i;
  
  private TextView j;
  
  private CommonEdittextView k;
  
  private View l;
  
  private String m;
  
  private void a() {
    this.h = (CommonTopTitleNoTrans)this.l.findViewById(2131300300);
    this.h.a();
    this.h.e();
    this.h.setTitleBackgroundDrawable(2131100528);
    this.h.setCenterText("");
    this.h.setLeftClickListener(this);
  }
  
  private void k() {
    this.f = DialogUtils.a(this.e);
    this.i = (TextView)this.l.findViewById(2131300656);
    this.j = (TextView)this.l.findViewById(2131301419);
    this.k = (CommonEdittextView)this.l.findViewById(2131296681);
    this.g = this.k.getEditText();
    this.g.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            VerifyOriginalAccountDetailFragment.a(this.a);
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  private void l() {
    if (getArguments() != null)
      this.m = getArguments().getString("binding_type"); 
  }
  
  private void m() {
    if (!TextUtils.isEmpty(this.g.getText().toString())) {
      this.i.setEnabled(true);
      this.i.setClickable(true);
      return;
    } 
    this.i.setEnabled(false);
    this.i.setClickable(false);
  }
  
  private void n() {
    String str = LoginRegisterTools.b();
    Bundle bundle = new Bundle();
    bundle.putString("binding_type", "change");
    bundle.putString(LoginRegisterTools.e, str);
    if (!TextUtils.isEmpty(str)) {
      LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, bundle) {
            public void a(BluedEntityA<Object> param1BluedEntityA) {
              try {
                TerminalActivity.d(VerifyOriginalAccountDetailFragment.c(this.b), RegisterV1ForPhone2Fragment.class, this.a);
                this.b.getActivity().finish();
                return;
              } catch (Exception exception) {
                AppMethods.d(2131756082);
                exception.printStackTrace();
                return;
              } 
            }
            
            public void onUIFinish() {
              DialogUtils.b(VerifyOriginalAccountDetailFragment.b(this.b));
            }
            
            public void onUIStart() {
              DialogUtils.a(VerifyOriginalAccountDetailFragment.b(this.b));
            }
          }"mobile", "", null);
      return;
    } 
    AppMethods.d(2131759019);
  }
  
  private void o() {
    String str = this.g.getText().toString();
    Bundle bundle = new Bundle();
    bundle.putString("original_email", str);
    bundle.putString("binding_type", "change");
    if (!TextUtils.isEmpty(str))
      LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, bundle) {
            public void a(BluedEntityA<Object> param1BluedEntityA) {
              try {
                TerminalActivity.d(VerifyOriginalAccountDetailFragment.c(this.b), RegisterV1ForEmail2Fragment.class, this.a);
                this.b.getActivity().finish();
                return;
              } catch (Exception exception) {
                AppMethods.d(2131756082);
                exception.printStackTrace();
                return;
              } 
            }
            
            public void onUIFinish() {
              DialogUtils.b(VerifyOriginalAccountDetailFragment.b(this.b));
            }
            
            public void onUIStart() {
              DialogUtils.a(VerifyOriginalAccountDetailFragment.b(this.b));
            }
          }"email", str, null); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131300656) {
        if (i != 2131301419)
          return; 
        n();
        return;
      } 
      o();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.l;
    if (view == null) {
      this.l = paramLayoutInflater.inflate(2131493350, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.l.getParent()).removeView(this.l);
    } 
    return this.l;
  }
  
  public void onStart() {
    super.onStart();
    m();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\VerifyOriginalAccountDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */