package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.user.observer.ReportObserver;
import com.soft.blued.utils.Logger;

public class ReportUserFragment extends BaseFragment implements View.OnClickListener, ReportObserver.IReportObserver {
  private View d;
  
  private Context e;
  
  private View f;
  
  private View g;
  
  private View h;
  
  private View i;
  
  private String j;
  
  private String k;
  
  private boolean l = true;
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(";");
    stringBuilder.append(paramString2);
    stringBuilder.append(";");
    stringBuilder.append(paramBoolean);
    Logger.a("report", stringBuilder.toString());
    Bundle bundle = new Bundle();
    bundle.putString("KEY_REPORT_TARGET_ID", paramString1);
    bundle.putString("KEY_REPORT_TARGET_TEXT", paramString2);
    bundle.putBoolean("KEY_REPORT_SHOW_BLOCK", paramBoolean);
    TerminalActivity.d(paramContext, ReportUserFragment.class, bundle);
  }
  
  public void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300273);
    commonTopTitleNoTrans.setCenterText(this.e.getResources().getString(2131758584));
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setLeftClickListener(this);
    this.f = this.d.findViewById(2131301629);
    ((TextView)this.f.findViewById(2131301377)).setText(2131758607);
    this.f.setOnClickListener(this);
    this.g = this.d.findViewById(2131301651);
    ((TextView)this.g.findViewById(2131301377)).setText(2131758617);
    this.g.setOnClickListener(this);
    this.h = this.d.findViewById(2131301646);
    ((TextView)this.h.findViewById(2131301377)).setText(2131758613);
    this.h.setOnClickListener(this);
    this.i = this.d.findViewById(2131301633);
    ((TextView)this.i.findViewById(2131301377)).setText(2131758610);
    this.i.setOnClickListener(this);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean && getActivity() != null)
      getActivity().finish(); 
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131301651:
        if (this.l) {
          ReportFragmentNew.b(this.e, 1, this.j, this.k);
          return;
        } 
        ReportFragmentNew.a(this.e, 1, this.j, this.k);
        return;
      case 2131301646:
        ReportTipFragment.a(this.e, 2, this.j, this.k);
        return;
      case 2131301633:
        ReportTipFragment.a(this.e, 3, this.j, this.k);
        return;
      case 2131301629:
        ReportTipFragment.a(this.e, 1, this.j, this.k);
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    if (this.d == null) {
      this.d = paramLayoutInflater.inflate(2131493300, paramViewGroup, false);
      if (getArguments() != null) {
        this.j = getArguments().getString("KEY_REPORT_TARGET_ID");
        this.k = getArguments().getString("KEY_REPORT_TARGET_TEXT");
        this.l = getArguments().getBoolean("KEY_REPORT_SHOW_BLOCK", true);
      } 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ReportUserFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */