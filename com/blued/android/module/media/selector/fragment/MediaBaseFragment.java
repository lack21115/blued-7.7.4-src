package com.blued.android.module.media.selector.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.media.selector.utils.LogUtils;

public abstract class MediaBaseFragment<V, T extends MediaBasePresent<V>> extends BaseFragment {
  public T e;
  
  public Context f;
  
  protected abstract void B();
  
  protected abstract T C();
  
  public abstract boolean a(Bundle paramBundle);
  
  protected abstract void b(Bundle paramBundle);
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    T t = this.e;
    if (t != null)
      t.a((Activity)getActivity(), paramInt1, paramInt2, paramIntent); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.f = getContext();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    b(paramBundle);
    y();
    this.e = C();
    T t = this.e;
    if (t != null) {
      t.a(this);
      this.e.a(paramBundle);
    } 
    B();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    T t = this.e;
    if (t != null)
      t.q(); 
    super.onDestroy();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(MediaBaseFragment.class.getSimpleName());
    stringBuilder.append(" onDestroy()");
    LogUtils.a(new Object[] { stringBuilder.toString() });
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    if (!a(paramBundle)) {
      T t = this.e;
      if (t != null)
        t.b(paramBundle); 
    } 
  }
  
  protected abstract void y();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\fragment\MediaBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */