package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class ShadowFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private LinearLayout f;
  
  private TextView g;
  
  private TextView h;
  
  private LinearLayout i;
  
  private TextView j;
  
  private TextView k;
  
  private ImageView l;
  
  private LinearLayout m;
  
  private TextView n;
  
  private RelativeLayout o;
  
  private ImageView p;
  
  private TextView q;
  
  private TextView r;
  
  private LinearLayout s;
  
  private LinearLayout t;
  
  private TextView u;
  
  private RelativeLayout v;
  
  private RelativeLayout w;
  
  private void a() {
    this.f = (LinearLayout)this.e.findViewById(2131299922);
    this.g = (TextView)this.e.findViewById(2131299921);
    this.h = (TextView)this.e.findViewById(2131299923);
    this.i = (LinearLayout)this.e.findViewById(2131299928);
    this.j = (TextView)this.e.findViewById(2131299925);
    this.k = (TextView)this.e.findViewById(2131299927);
    this.l = (ImageView)this.e.findViewById(2131299933);
    this.m = (LinearLayout)this.e.findViewById(2131299919);
    this.o = (RelativeLayout)this.e.findViewById(2131299930);
    this.p = (ImageView)this.e.findViewById(2131299918);
    this.q = (TextView)this.e.findViewById(2131299916);
    this.r = (TextView)this.e.findViewById(2131299929);
    this.s = (LinearLayout)this.e.findViewById(2131299920);
    this.t = (LinearLayout)this.e.findViewById(2131299934);
    this.u = (TextView)this.e.findViewById(2131299932);
    this.n = (TextView)this.e.findViewById(2131299917);
    this.v = (RelativeLayout)this.e.findViewById(2131299924);
    this.w = (RelativeLayout)this.e.findViewById(2131299926);
    this.l.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131758740));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.getRightTextView().setVisibility(8);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131296863:
        getActivity().finish();
        break;
      case 2131299917:
      case 2131299924:
      case 2131299930:
      case 2131299933:
        break;
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493314, paramViewGroup, false);
      k();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ShadowFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */