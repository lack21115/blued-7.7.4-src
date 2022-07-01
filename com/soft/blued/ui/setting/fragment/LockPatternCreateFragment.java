package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class LockPatternCreateFragment extends BaseFragment implements View.OnClickListener {
  private View d;
  
  private TextView e;
  
  private void a() {
    this.e = (TextView)this.d.findViewById(2131296599);
    this.e.setOnClickListener(this);
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setTitleBackgroundDrawable(2131100528);
    commonTopTitleNoTrans.setCenterText(getString(2131757809));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296599) {
      if (i != 2131296863)
        return; 
      getActivity().finish();
      return;
    } 
    TerminalActivity.d((Context)getActivity(), LockPatternSetupFragment.class, null);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493208, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\LockPatternCreateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */