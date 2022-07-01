package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.user.observer.ReportObserver;

public class ChooseReportReasonFragment extends BaseFragment implements View.OnClickListener, ReportObserver.IReportObserver {
  private View d;
  
  private Context e;
  
  private int f;
  
  private String g;
  
  private boolean h;
  
  private View i;
  
  private View j;
  
  private View k;
  
  private View l;
  
  private View m;
  
  private View n;
  
  private View o;
  
  private View p;
  
  private View q;
  
  public static void a(BaseFragment paramBaseFragment, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putBoolean("KEY_HIDE_RIGHT_ARROW", paramBoolean);
    TerminalActivity.a((Fragment)paramBaseFragment, ChooseReportReasonFragment.class, bundle, 1);
  }
  
  public boolean V_() {
    a(0);
    return false;
  }
  
  public void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300273);
    commonTopTitleNoTrans.setCenterText(this.e.getResources().getString(2131758584));
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a(0);
          }
        });
    this.i = this.d.findViewById(2131301631);
    ((TextView)this.i.findViewById(2131301377)).setText(2131755820);
    this.i.setOnClickListener(this);
    this.j = this.d.findViewById(2131301690);
    ((TextView)this.j.findViewById(2131301377)).setText(2131756126);
    this.j.setOnClickListener(this);
    this.k = this.d.findViewById(2131301673);
    ((TextView)this.k.findViewById(2131301377)).setText(2131758375);
    this.k.setOnClickListener(this);
    this.l = this.d.findViewById(2131301641);
    ((TextView)this.l.findViewById(2131301377)).setText(2131756219);
    this.l.setOnClickListener(this);
    this.m = this.d.findViewById(2131301674);
    ((TextView)this.m.findViewById(2131301377)).setText(2131758403);
    this.m.setOnClickListener(this);
    this.n = this.d.findViewById(2131301675);
    ((TextView)this.n.findViewById(2131301377)).setText(2131758404);
    this.n.setOnClickListener(this);
    this.o = this.d.findViewById(2131301619);
    ((TextView)this.o.findViewById(2131301377)).setText(2131755235);
    this.o.setOnClickListener(this);
    this.q = this.d.findViewById(2131301669);
    ((TextView)this.q.findViewById(2131301377)).setText(2131758335);
    this.q.setOnClickListener(this);
    this.p = this.d.findViewById(2131301660);
    ((TextView)this.p.findViewById(2131301377)).setText(2131757903);
    this.p.setOnClickListener(this);
    if (this.h) {
      this.i.findViewById(2131297550).setVisibility(8);
      this.j.findViewById(2131297550).setVisibility(8);
      this.k.findViewById(2131297550).setVisibility(8);
      this.l.findViewById(2131297550).setVisibility(8);
      this.m.findViewById(2131297550).setVisibility(8);
      this.n.findViewById(2131297550).setVisibility(8);
      this.o.findViewById(2131297550).setVisibility(8);
      this.q.findViewById(2131297550).setVisibility(8);
      this.p.findViewById(2131297550).setVisibility(8);
    } 
  }
  
  public void a(int paramInt) {
    if (paramInt == 0) {
      getActivity().setResult(paramInt);
    } else {
      Intent intent = new Intent();
      intent.putExtra("KEY_REPORT_ITEM_ID", this.f);
      intent.putExtra("KEY_REPORT_ITEM_TEXT", this.g);
      getActivity().setResult(-1, intent);
    } 
    getActivity().finish();
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean && getActivity() != null)
      getActivity().finish(); 
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      case 2131301690:
        this.f = 7;
        this.g = this.e.getResources().getString(2131756126);
        break;
      case 2131301675:
        this.f = 2;
        this.g = this.e.getResources().getString(2131758404);
        break;
      case 2131301674:
        this.f = 4;
        this.g = this.e.getResources().getString(2131758403);
        break;
      case 2131301673:
        this.f = 8;
        this.g = this.e.getResources().getString(2131758375);
        break;
      case 2131301669:
        this.f = 0;
        this.g = this.e.getResources().getString(2131758335);
        break;
      case 2131301660:
        this.f = 9;
        this.g = this.e.getResources().getString(2131757903);
        break;
      case 2131301641:
        this.f = 5;
        this.g = this.e.getResources().getString(2131756219);
        break;
      case 2131301631:
        this.f = 6;
        this.g = this.e.getResources().getString(2131755820);
        break;
      case 2131301619:
        this.f = 1;
        this.g = this.e.getResources().getString(2131755235);
        break;
    } 
    a(-1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    if (this.d == null) {
      this.d = paramLayoutInflater.inflate(2131493089, paramViewGroup, false);
      if (getArguments() != null)
        this.h = getArguments().getBoolean("KEY_HIDE_RIGHT_ARROW"); 
      a();
      ReportObserver.a().a(this);
    } 
    return this.d;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ReportObserver.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ChooseReportReasonFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */