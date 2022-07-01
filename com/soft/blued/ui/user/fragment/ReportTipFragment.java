package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.user.observer.ReportObserver;

public class ReportTipFragment extends BaseFragment implements View.OnClickListener, ReportObserver.IReportObserver {
  private View d;
  
  private Context e;
  
  private TextView f;
  
  private TextView g;
  
  private ImageView h;
  
  private ShapeTextView i;
  
  private ShapeTextView j;
  
  private String k;
  
  private String l;
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putInt("type", paramInt);
    bundle.putString("KEY_REPORT_TARGET_ID", paramString1);
    bundle.putString("KEY_REPORT_TARGET_TEXT", paramString2);
    TerminalActivity.d(paramContext, ReportTipFragment.class, bundle);
  }
  
  private void k() {
    boolean bool;
    Bundle bundle = getArguments();
    if (bundle != null) {
      bool = bundle.getInt("type");
    } else {
      bool = false;
    } 
    if (bool != 2) {
      if (bool != 3) {
        this.f.setText(2131758608);
        this.g.setText(2131758609);
        this.h.setImageResource(2131233556);
        this.i.setText(2131758602);
        this.j.setVisibility(0);
        this.j.setText(2131758604);
        this.j.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                ReportFragmentNew.b(ReportTipFragment.a(this.a), 1, ReportTipFragment.b(this.a), ReportTipFragment.c(this.a));
              }
            });
        this.i.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                HomeArgumentHelper.a(ReportTipFragment.a(this.a), "msg", null);
              }
            });
        return;
      } 
      this.f.setText(2131758611);
      this.g.setText(2131758612);
      this.h.setImageResource(2131233557);
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      return;
    } 
    this.f.setText(2131758614);
    this.g.setText(2131758615);
    this.h.setImageResource(2131233558);
    this.i.setText(2131758603);
    this.j.setVisibility(8);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            BluedURIRouterAdapter.openUserInfoPage(ReportTipFragment.a(this.a), ReportTipFragment.b(this.a), ReportTipFragment.c(this.a), 0, 1, "");
          }
        });
  }
  
  public void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300273);
    commonTopTitleNoTrans.setCenterText(this.e.getResources().getString(2131758584));
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setLeftClickListener(this);
    this.f = (TextView)this.d.findViewById(2131301265);
    this.g = (TextView)this.d.findViewById(2131301268);
    this.h = (ImageView)this.d.findViewById(2131297912);
    this.i = (ShapeTextView)this.d.findViewById(2131301420);
    this.j = (ShapeTextView)this.d.findViewById(2131301423);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean && getActivity() != null)
      getActivity().finish(); 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    if (this.d == null) {
      this.d = paramLayoutInflater.inflate(2131493299, paramViewGroup, false);
      if (getArguments() != null) {
        this.k = getArguments().getString("KEY_REPORT_TARGET_ID");
        this.l = getArguments().getString("KEY_REPORT_TARGET_TEXT");
      } 
      a();
      k();
      ReportObserver.a().a(this);
    } 
    return this.d;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ReportObserver.a().b(this);
  }
  
  public static interface REPORT_TYPE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ReportTipFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */