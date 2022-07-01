package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;

public class HelpCenterFragment extends BaseFragment implements View.OnClickListener {
  View d;
  
  Context e;
  
  private View f;
  
  private LinearLayout g;
  
  private TextView h;
  
  private LinearLayout i;
  
  private LinearLayout j;
  
  private LinearLayout k;
  
  private LinearLayout l;
  
  private LinearLayout m;
  
  private LinearLayout n;
  
  private void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131756915));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, HelpCenterFragment.class, null);
  }
  
  private void k() {
    this.f = this.d.findViewById(2131300297);
    this.g = (LinearLayout)this.d.findViewById(2131298756);
    this.h = (TextView)this.d.findViewById(2131300661);
    this.i = (LinearLayout)this.d.findViewById(2131299096);
    this.j = (LinearLayout)this.d.findViewById(2131298752);
    this.k = (LinearLayout)this.d.findViewById(2131298923);
    this.l = (LinearLayout)this.d.findViewById(2131298757);
    this.n = (LinearLayout)this.d.findViewById(2131298799);
    this.m = (LinearLayout)this.d.findViewById(2131299022);
    if (UserInfo.a().j()) {
      this.g.setVisibility(0);
      this.h.setVisibility(0);
      this.g.setOnClickListener(this);
      this.n.setVisibility(0);
      this.f.setVisibility(0);
    } else {
      this.g.setVisibility(8);
      this.h.setVisibility(8);
      this.n.setVisibility(8);
      this.f.setVisibility(8);
    } 
    this.k.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.m.setOnClickListener(this);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131299096:
        WebViewShowInfoFragment.a(this.e, H5Url.a(20), getResources().getString(2131758475), 7);
        return;
      case 2131299022:
        WebViewShowInfoFragment.show((Context)getActivity(), H5Url.a(21), 0);
        return;
      case 2131298923:
        WebViewShowInfoFragment.a(this.e, H5Url.a(23), getResources().getString(2131757736), 7);
        return;
      case 2131298799:
        InstantLog.a("my_suggestion");
        FeedbackFragment.a(this.e);
        return;
      case 2131298757:
        WebViewShowInfoFragment.show((Context)getActivity(), "https://app.blued.cn/customerservices", 0);
        return;
      case 2131298756:
        InstantLog.a("my_consultation");
        WebViewShowInfoFragment.a(this.e, BluedHttpUrl.a(1), getResources().getString(2131756120), 16);
        return;
      case 2131298752:
        WebViewShowInfoFragment.a(this.e, H5Url.a(22), getResources().getString(2131756039), 7);
        return;
      case 2131296863:
        break;
    } 
    if (getActivity() != null)
      getActivity().finish(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493153, paramViewGroup, false);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    a();
    k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\HelpCenterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */