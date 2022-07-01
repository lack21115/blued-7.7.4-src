package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IView;
import com.blued.android.module.shortvideo.manager.StvFragmentManager;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent;
import com.blued.android.module.shortvideo.utils.StvDialogUtils;
import com.blued.android.module.shortvideo.utils.StvLogUtils;

public abstract class ShortVideoBaseFragment<V, T extends ShortVideoBasePresent<V>> extends KeyBoardFragment implements PermissionCallbacks, IView {
  protected static String o = ShortVideoBaseFragment.class.getSimpleName();
  
  private Dialog e;
  
  private boolean f = false;
  
  protected T p;
  
  protected Context q;
  
  protected ViewGroup r;
  
  public boolean V_() {
    T t = this.p;
    return (t != null) ? t.g() : super.V_();
  }
  
  public View a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.r = (ViewGroup)paramLayoutInflater.inflate(R.layout.activity_stv_base, paramViewGroup, false);
    View view = paramLayoutInflater.inflate(paramInt, paramViewGroup, false);
    this.r.addView(view);
    b(paramBundle);
    this.p = c(paramBundle);
    T t = this.p;
    if (t != null) {
      t.a(this);
      this.p.a();
    } 
    if (aG_().equals(ShineFragment.class.getSimpleName()) || aG_().equals(TrimFragment.class.getSimpleName())) {
      this.e = StvDialogUtils.a(getContext());
    } else {
      this.e = StvDialogUtils.b(getContext());
    } 
    if (!aG_().equals(AuthRecorderFragment.class.getSimpleName()) && !aG_().equals(AuthPreviewFragment.class.getSimpleName()))
      StvFragmentManager.a().a(getClass().getSimpleName()); 
    t();
    return (View)this.r;
  }
  
  public void a(float paramFloat) {}
  
  public void a(String[] paramArrayOfString) {
    getActivity().finish();
  }
  
  public void a_(Runnable paramRunnable) {
    a(paramRunnable);
  }
  
  public void aa_() {}
  
  public void ab_() {
    this.f = true;
  }
  
  protected abstract void b(Bundle paramBundle);
  
  public void b(boolean paramBoolean) {
    if (paramBoolean) {
      try {
        if (this.e != null && !this.e.isShowing())
          return; 
      } finally {
        Exception exception = null;
      } 
    } else if (this.e != null && this.e.isShowing()) {
      this.e.dismiss();
      return;
    } 
  }
  
  protected abstract T c(Bundle paramBundle);
  
  public void c(boolean paramBoolean) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    T t = this.p;
    if (t != null)
      t.a((Activity)getActivity(), paramInt1, paramInt2, paramIntent); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.q = getContext();
  }
  
  public void onDestroy() {
    T t = this.p;
    if (t != null)
      t.E(); 
    if (!aG_().equals(AuthRecorderFragment.class.getSimpleName()) && !aG_().equals(AuthPreviewFragment.class.getSimpleName()))
      StvFragmentManager.a().b(getClass().getSimpleName()); 
    super.onDestroy();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(ShortVideoBaseFragment.class.getSimpleName());
    stringBuilder.append(" onDestroy()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void onPause() {
    super.onPause();
    T t = this.p;
    if (t != null)
      t.e(); 
    AudioManagerUtils.a().a(this.f);
  }
  
  public void onResume() {
    super.onResume();
    T t = this.p;
    if (t != null)
      t.c(); 
    this.f = false;
    AudioManagerUtils.a().b();
    if (aG_().equals(ShineFragment.class.getSimpleName())) {
      PermissionHelper.c(this);
      return;
    } 
    PermissionHelper.b(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    T t = this.p;
    if (t != null)
      t.a(paramBundle); 
  }
  
  public void onStart() {
    super.onStart();
    T t = this.p;
    if (t != null)
      t.f(); 
  }
  
  public void onStop() {
    super.onStop();
    T t = this.p;
    if (t != null)
      t.d(); 
  }
  
  protected abstract void t();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\ShortVideoBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */