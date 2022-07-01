package com.soft.blued.ui.login_register;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.setting.fragment.VerifyOriginalAccountDetailFragment;

public class LinkMobileSuccessFragment extends BaseFragment implements View.OnClickListener {
  private String d = LinkMobileSuccessFragment.class.getSimpleName();
  
  private View e;
  
  private Context f;
  
  private CommonTopTitleNoTrans g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private String l;
  
  private String m;
  
  private String n;
  
  private int o;
  
  private void a() {
    this.g = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    this.g.a();
    this.g.e();
    this.g.setTitleBackgroundDrawable(2131100528);
    this.g.setLeftClickListener(this);
    this.g.setCenterText("");
    if (this.o == 1) {
      this.j.setText(this.f.getResources().getString(2131755112));
      return;
    } 
    this.j.setText(this.f.getResources().getString(2131759022));
  }
  
  private void k() {
    this.j = (TextView)this.e.findViewById(2131301162);
    this.k = (TextView)this.e.findViewById(2131300620);
    this.k.setOnClickListener(this);
    this.h = (TextView)this.e.findViewById(2131300565);
    this.i = (TextView)this.e.findViewById(2131300567);
  }
  
  private void l() {
    if (getArguments() != null) {
      this.o = getArguments().getInt(LoginRegisterTools.a);
      int i = this.o;
      if (i == 1) {
        this.l = getArguments().getString(LoginRegisterTools.e);
        this.l = LoginRegisterTools.e(this.l);
        this.m = getArguments().getString(LoginRegisterTools.g);
        TextView textView = this.i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131755564));
        stringBuilder.append(this.l);
        textView.setText(stringBuilder.toString());
        return;
      } 
      if (i == 0) {
        this.n = getArguments().getString(LoginRegisterTools.f);
        this.h.setText(2131755008);
        TextView textView = this.i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(2131755009));
        stringBuilder.append(this.n);
        textView.setText(stringBuilder.toString());
        this.k.setText(2131755745);
      } 
    } 
  }
  
  private void m() {
    Bundle bundle = new Bundle();
    bundle.putString(LoginRegisterTools.k, LoginRegisterTools.l);
    bundle.putString(LoginRegisterTools.e, this.l);
    bundle.putString(LoginRegisterTools.g, this.m);
    TerminalActivity.d((Context)getActivity(), LinkMobileFragment.class, bundle);
    getActivity().finish();
  }
  
  private void n() {
    Bundle bundle = new Bundle();
    bundle.putString("binding_type", "change");
    TerminalActivity.d(this.f, VerifyOriginalAccountDetailFragment.class, bundle);
    getActivity().finish();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131300620)
        return; 
      i = this.o;
      if (i == 1) {
        m();
        return;
      } 
      if (i == 0) {
        n();
        return;
      } 
    } else {
      getActivity().finish();
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493164, paramViewGroup, false);
      k();
      l();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\LinkMobileSuccessFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */