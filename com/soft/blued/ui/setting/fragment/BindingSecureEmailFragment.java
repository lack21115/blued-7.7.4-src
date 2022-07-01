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
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.ClearEditText;
import com.soft.blued.customview.CommonEdittextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment;
import com.soft.blued.ui.setting.Contract.BindingSecureEmailContract;
import com.soft.blued.ui.setting.Presenter.BindingSecureEmailPresenter;
import com.soft.blued.utils.StringUtils;

public class BindingSecureEmailFragment extends BaseFragment implements View.OnClickListener, BindingSecureEmailContract.IView {
  private String d = BindingSecureEmailFragment.class.getSimpleName();
  
  private BindingSecureEmailContract.IPresenter e;
  
  private Context f;
  
  private ImageView g;
  
  private CommonEdittextView h;
  
  private CommonEdittextView i;
  
  private Dialog j;
  
  private ClearEditText k;
  
  private ClearEditText l;
  
  private TextView m;
  
  private View n;
  
  private TextWatcher o;
  
  private String p = "";
  
  private void l() {
    if (getArguments() != null)
      this.p = getArguments().getString("binding_type"); 
  }
  
  private void m() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.n.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.setTitleBackgroundDrawable(2131100528);
    commonTopTitleNoTrans.setCenterText("");
    commonTopTitleNoTrans.setLeftClickListener(this);
    if ("add".equals(this.p)) {
      commonTopTitleNoTrans.setCenterText(this.f.getString(2131759022));
    } else {
      commonTopTitleNoTrans.setCenterText(this.f.getString(2131755749));
    } 
    this.g = (ImageView)this.n.findViewById(2131296341);
    this.i = (CommonEdittextView)this.n.findViewById(2131296680);
    this.k = this.i.getEditText();
    this.h = (CommonEdittextView)this.n.findViewById(2131296681);
    this.l = this.h.getEditText();
    this.j = DialogUtils.a(this.f);
    this.m = (TextView)this.n.findViewById(2131301104);
  }
  
  private void n() {
    this.g.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.o = new TextWatcher(this) {
        public void afterTextChanged(Editable param1Editable) {
          this.a.k();
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
    this.k.addTextChangedListener(this.o);
    this.l.addTextChangedListener(this.o);
  }
  
  public void a() {
    DialogUtils.b(this.j);
  }
  
  public void a(Bundle paramBundle) {
    TerminalActivity.d(this.f, RegisterV1ForEmail2Fragment.class, paramBundle);
    getActivity().finish();
  }
  
  public void a(String paramString) {
    LoginRegisterTools.a((IRequestHost)w_(), this.g, paramString);
  }
  
  public void b() {
    DialogUtils.a(this.j);
  }
  
  public void c() {
    AppMethods.d(2131756082);
  }
  
  public void d() {
    AppMethods.d(2131755575);
  }
  
  public void e() {
    AppMethods.d(2131755536);
  }
  
  public void k() {
    if (!StringUtils.e(this.l.getText().toString()) && !StringUtils.e(this.k.getText().toString())) {
      this.m.setClickable(true);
      this.m.setEnabled(true);
      return;
    } 
    this.m.setClickable(false);
    this.m.setEnabled(false);
  }
  
  public void onClick(View paramView) {
    try {
      int i = paramView.getId();
      if (i != 2131296341) {
        if (i != 2131296863) {
          if (i != 2131301104)
            return; 
          String str1 = this.k.getText().toString();
          String str2 = this.l.getText().toString();
          if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
            this.e.a(str1, 0, str2, this.p);
            return;
          } 
        } else {
          getActivity().finish();
          return;
        } 
      } else if (!StringUtils.e(this.e.b())) {
        a(this.e.b());
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      AppMethods.a(this.f.getString(2131758329));
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.n;
    if (view == null) {
      this.n = paramLayoutInflater.inflate(2131493080, paramViewGroup, false);
      l();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.n.getParent()).removeView(this.n);
    } 
    return this.n;
  }
  
  public void onStart() {
    super.onStart();
    k();
    this.e.bb_();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    n();
    this.e = (BindingSecureEmailContract.IPresenter)new BindingSecureEmailPresenter(this.f, this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\BindingSecureEmailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */