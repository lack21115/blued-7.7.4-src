package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.blued.android.module.shortvideo.contract.SysNetworkListener;
import com.blued.android.module.shortvideo.manager.NetWorkObserverManager;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class ShortVideoBasePresent<T> implements SysNetworkListener {
  protected WeakReference<T> e;
  
  protected List<StvThreadPoolHelper.StvThread> f = new ArrayList<StvThreadPoolHelper.StvThread>();
  
  public T D() {
    WeakReference<T> weakReference = this.e;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public void E() {
    b();
    WeakReference<T> weakReference = this.e;
    if (weakReference != null) {
      weakReference.clear();
      this.e = null;
    } 
    List<StvThreadPoolHelper.StvThread> list = this.f;
    if (list != null)
      for (StvThreadPoolHelper.StvThread stvThread : list)
        StvThreadPoolHelper.a().a(stvThread);  
    NetWorkObserverManager.a().b(this);
  }
  
  public abstract void a();
  
  public abstract void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Bundle paramBundle);
  
  public void a(T paramT) {
    NetWorkObserverManager.a().a(this);
    this.e = new WeakReference<T>(paramT);
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract boolean g();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\presenter\ShortVideoBasePresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */