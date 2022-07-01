package com.soft.blued.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;

public abstract class MVPBaseFragment<V, T extends MVPBasePresent<V>> extends BaseFragment implements MVPIView {
  public T d;
  
  protected Context e;
  
  protected RelativeLayout f;
  
  protected FrameLayout g;
  
  protected FrameLayout h;
  
  protected CommonTopTitleNoTrans i;
  
  protected NestedScrollView j;
  
  protected NoDataAndLoadFailView k;
  
  protected View l;
  
  public View a(int paramInt, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (RelativeLayout)paramLayoutInflater.inflate(2131493075, null);
    this.i = (CommonTopTitleNoTrans)this.f.findViewById(2131300273);
    this.i.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.g = (FrameLayout)this.f.findViewById(2131296837);
    paramLayoutInflater.inflate(paramInt, (ViewGroup)this.g);
    this.j = (NestedScrollView)this.f.findViewById(2131296994);
    this.k = (NoDataAndLoadFailView)this.f.findViewById(2131299395);
    this.k.setBackgroundColorRes(2131100528);
    this.h = (FrameLayout)this.f.findViewById(2131297335);
    this.l = this.f.findViewById(2131296517);
    b(paramBundle);
    this.d = n();
    T t = this.d;
    if (t != null) {
      t.a(this);
      this.d.a(paramBundle);
    } 
    o();
    return (View)this.f;
  }
  
  public void a() {
    FrameLayout frameLayout = this.h;
    if (frameLayout != null)
      frameLayout.setVisibility(8); 
  }
  
  public void a(View.OnClickListener paramOnClickListener) {
    NoDataAndLoadFailView noDataAndLoadFailView = this.k;
    if (noDataAndLoadFailView != null)
      noDataAndLoadFailView.setFailBtnListener(paramOnClickListener); 
  }
  
  public void a(boolean paramBoolean) {
    View view = this.l;
    if (view != null) {
      if (paramBoolean) {
        view.setVisibility(0);
        return;
      } 
      view.setVisibility(8);
    } 
  }
  
  public abstract boolean a(Bundle paramBundle);
  
  protected abstract void b(Bundle paramBundle);
  
  public void k() {
    FrameLayout frameLayout = this.g;
    if (frameLayout != null)
      frameLayout.setVisibility(0); 
    NestedScrollView nestedScrollView = this.j;
    if (nestedScrollView != null)
      nestedScrollView.setVisibility(8); 
  }
  
  public void l() {
    FrameLayout frameLayout = this.g;
    if (frameLayout != null)
      frameLayout.setVisibility(8); 
    a();
    NestedScrollView nestedScrollView = this.j;
    if (nestedScrollView != null)
      nestedScrollView.setVisibility(0); 
    NoDataAndLoadFailView noDataAndLoadFailView = this.k;
    if (noDataAndLoadFailView != null)
      noDataAndLoadFailView.a(); 
  }
  
  public void m() {
    FrameLayout frameLayout = this.g;
    if (frameLayout != null)
      frameLayout.setVisibility(8); 
    a();
    NestedScrollView nestedScrollView = this.j;
    if (nestedScrollView != null)
      nestedScrollView.setVisibility(0); 
    NoDataAndLoadFailView noDataAndLoadFailView = this.k;
    if (noDataAndLoadFailView != null)
      noDataAndLoadFailView.b(); 
  }
  
  protected abstract T n();
  
  protected abstract void o();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    T t = this.d;
    if (t != null)
      t.a((Activity)getActivity(), paramInt1, paramInt2, paramIntent); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.e = getContext();
  }
  
  public void onDestroy() {
    T t = this.d;
    if (t != null)
      t.b(); 
    super.onDestroy();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(MVPBaseFragment.class.getSimpleName());
    stringBuilder.append(" onDestroy()");
    LogUtils.b(stringBuilder.toString());
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    if (!a(paramBundle)) {
      T t = this.d;
      if (t != null)
        t.b(paramBundle); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\base\mvp\MVPBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */