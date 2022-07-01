package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter;

public class MapFinderSettingFragment extends BaseFragment implements IPrivacySettingContract.IView {
  private Context d;
  
  private View e;
  
  private ToggleButton f;
  
  private IPrivacySettingContract.IPresenter g;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, MapFinderSettingFragment.class, null);
  }
  
  private void k() {
    this.g.a(this.f.isChecked());
    getActivity().finish();
  }
  
  public boolean M() {
    return false;
  }
  
  public boolean N() {
    return false;
  }
  
  public boolean V_() {
    k();
    return true;
  }
  
  public void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131757843));
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            MapFinderSettingFragment.a(this.a);
          }
        });
    this.f = (ToggleButton)this.e.findViewById(2131300247);
    this.f.setChecked(true);
    this.g.c();
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public void f(boolean paramBoolean) {}
  
  public void g(boolean paramBoolean) {}
  
  public void h(boolean paramBoolean) {}
  
  public void i(boolean paramBoolean) {
    this.f.setChecked(paramBoolean);
  }
  
  public void j(boolean paramBoolean) {}
  
  public void k(boolean paramBoolean) {}
  
  public void l(boolean paramBoolean) {}
  
  public void m(boolean paramBoolean) {}
  
  public void n(boolean paramBoolean) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493218, paramViewGroup, false);
      this.d = (Context)getActivity();
      this.g = (IPrivacySettingContract.IPresenter)new PrivacySettingPresenter((Context)getActivity(), (IRequestHost)w_(), this);
      a();
      this.g.b();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\MapFinderSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */