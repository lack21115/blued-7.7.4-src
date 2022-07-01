package com.soft.blued.ui.qr_scan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class ScanResultFragment extends BaseFragment implements View.OnClickListener {
  public static String d;
  
  private CommonTopTitleNoTrans e;
  
  private EditText f;
  
  private View g;
  
  private Bundle h;
  
  private String i;
  
  private void a() {
    this.e = (CommonTopTitleNoTrans)this.g.findViewById(2131300300);
    this.e.a();
    this.e.setCenterText(getString(2131758515));
    this.e.setLeftClickListener(this);
  }
  
  private void k() {
    this.f = (EditText)this.g.findViewById(2131299552);
  }
  
  private void l() {
    this.h = getArguments();
    Bundle bundle = this.h;
    if (bundle != null) {
      this.i = bundle.getString(d);
      this.f.setText(this.i);
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493303, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\qr_scan\ScanResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */