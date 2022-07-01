package com.blued.android.framework.ui.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.net.IRequestHost;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class MvpPresenter {
  String a;
  
  long b;
  
  FragmentActivity c;
  
  Set<MvpView> d;
  
  Set<MvpView> e;
  
  MemoryDataCache f;
  
  IRequestHost g;
  
  private final String h;
  
  public MvpPresenter() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_MVP_");
    stringBuilder.append(getClass().getSimpleName());
    this.h = stringBuilder.toString();
    this.b = 0L;
    this.d = new HashSet<MvpView>();
    this.e = new HashSet<MvpView>();
    this.f = new MemoryDataCache();
    this.g = new -$$Lambda$MvpPresenter$cr2dndZqSvaIULd2IKLibFwSADU(this);
  }
  
  private void a(FragmentActivity paramFragmentActivity) {
    if (this.c != paramFragmentActivity) {
      IRequestHost iRequestHost = this.g;
      if (iRequestHost != null)
        ImageLoaderHostManager.a(iRequestHost, paramFragmentActivity); 
      this.c = paramFragmentActivity;
      this.c.getLifecycle().addObserver(new LifecycleObserver(this) {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
              if (this.a.g != null)
                ImageLoaderHostManager.b(this.a.g); 
              if (this.a.c != null && this.a.c.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                MvpPresenter mvpPresenter = this.a;
                mvpPresenter.c = null;
                MvpPresenter.b(mvpPresenter, "_hostActivity onDestroy, remove it.");
              } 
            }
          });
    } 
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      m();
      return;
    } 
    n();
  }
  
  private void c(String paramString, List paramList) {
    for (MvpView mvpView : this.d) {
      if (mvpView.t()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showDataToUI(), type:");
        stringBuilder.append(paramString);
        f(stringBuilder.toString());
        mvpView.a(paramString, paramList);
      } 
    } 
  }
  
  private void c(String paramString, boolean paramBoolean) {
    for (MvpView mvpView : this.d) {
      if (mvpView.t())
        mvpView.a(paramString, paramBoolean); 
    } 
  }
  
  private boolean d(String paramString) {
    List list = this.f.a(paramString);
    return !(list == null || list.size() <= 0);
  }
  
  private void e(String paramString) {
    for (MvpView mvpView : this.d) {
      if (mvpView.t())
        mvpView.b(paramString); 
    } 
  }
  
  private void f(String paramString) {
    String str = this.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("--");
    stringBuilder.append(paramString);
    Log.v(str, stringBuilder.toString());
  }
  
  private void m() {
    for (MvpView mvpView : this.d) {
      if (mvpView.t())
        mvpView.x(); 
    } 
  }
  
  private void n() {
    for (MvpView mvpView : this.d) {
      if (mvpView.t())
        mvpView.y(); 
    } 
  }
  
  private boolean o() {
    synchronized (this.e) {
      Iterator<MvpView> iterator = this.e.iterator();
      while (iterator.hasNext()) {
        if (((MvpView)iterator.next()).t())
          return true; 
      } 
      return false;
    } 
  }
  
  private MvpView p() {
    for (MvpView mvpView : this.d) {
      if (mvpView.t())
        return mvpView; 
    } 
    return null;
  }
  
  List<Pair<String, List>> a() {
    return this.f.a();
  }
  
  List a(String paramString, List paramList) {
    return this.f.a(paramString, paramList);
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    a(paramFragmentActivity);
  }
  
  protected final void a(FragmentActivity paramFragmentActivity, MvpView paramMvpView) {
    this.d.add(paramMvpView);
    synchronized (this.e) {
      this.e.add(paramMvpView);
      a(paramFragmentActivity);
      return;
    } 
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {}
  
  protected abstract void a(IFetchDataListener paramIFetchDataListener);
  
  protected void a(MemoryDataCache paramMemoryDataCache) {
    this.f = paramMemoryDataCache;
  }
  
  protected final void a(MvpView paramMvpView) {
    this.d.remove(paramMvpView);
    synchronized (this.e) {
      this.e.remove(paramMvpView);
      return;
    } 
  }
  
  public final <T> void a(String paramString, T paramT) {
    a(paramString, paramT, true);
  }
  
  public final <T> void a(String paramString, T paramT, boolean paramBoolean) {
    List<List> list;
    if (paramT != null && paramT instanceof List) {
      list = (List)paramT;
    } else {
      ArrayList<List> arrayList = new ArrayList();
      if (list != null)
        arrayList.add(list); 
      list = arrayList;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setDataToUI_");
    stringBuilder.append(paramString);
    a(stringBuilder.toString(), new -$$Lambda$MvpPresenter$DgcLNqRJHvZ5XLr-r4V8pxNTirA(this, paramBoolean, paramString, list));
  }
  
  public void a(String paramString, Runnable paramRunnable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("runDataTask, taskName:");
    stringBuilder.append(paramString);
    f(stringBuilder.toString());
    if (MvpUtils.a()) {
      paramRunnable.run();
      return;
    } 
    AppInfo.n().post(new -$$Lambda$MvpPresenter$SCYBU8zirjl-mLfkLEccIOhhyZU(paramRunnable));
  }
  
  public final void a(String paramString, boolean paramBoolean) {
    a(paramString, (Object)null, paramBoolean);
  }
  
  List b(String paramString, List paramList) {
    return this.f.b(paramString, paramList);
  }
  
  protected abstract void b(IFetchDataListener paramIFetchDataListener);
  
  public final void b(String paramString) {
    a(paramString, true);
  }
  
  public void b(String paramString, Runnable paramRunnable) {
    StringBuilder stringBuilder1;
    String str = this.h;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("runUIViewTask, taskName:");
    stringBuilder2.append(paramString);
    Log.v(str, stringBuilder2.toString());
    if (MvpUtils.a()) {
      if (!o()) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("_mvpView is not ready, task can't deal, taskName:");
        stringBuilder1.append(paramString);
        f(stringBuilder1.toString());
        return;
      } 
      stringBuilder1.run();
      return;
    } 
    AppInfo.n().post(new -$$Lambda$MvpPresenter$Nj__fMdOeRBcvdQ1Pl-zAnXOk7M(this, paramString, (Runnable)stringBuilder1));
  }
  
  public final void b(String paramString, boolean paramBoolean) {
    b("dismissDataLoading", new -$$Lambda$MvpPresenter$9hAaTMdgeh4tE32dki4KnGN7hAU(this, paramString, paramBoolean));
  }
  
  public boolean b() {
    boolean bool;
    long l = this.b;
    int i = 0;
    if (l <= 0L || this.f.b()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      String[] arrayOfString = l();
      if (arrayOfString == null)
        return bool; 
      int j = arrayOfString.length;
      while (i < j) {
        if (!d(arrayOfString[i]))
          return true; 
        i++;
      } 
    } 
    return bool;
  }
  
  public boolean c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isNeedRefresh, _cacheTime:");
    stringBuilder.append(this.b);
    stringBuilder.append(", interval:");
    stringBuilder.append(SystemClock.uptimeMillis() - this.b);
    f(stringBuilder.toString());
    if (b()) {
      f("_refreshTime or _memoryDataCache need to refresh");
      return true;
    } 
    return (j() && SystemClock.uptimeMillis() - this.b >= 300000L);
  }
  
  protected void c_(String paramString) {
    this.a = paramString;
  }
  
  public void d() {
    f("refreshDataIfNeed");
    if (c()) {
      f("need refresh, refresh new data");
      MvpView mvpView = p();
      if (mvpView != null)
        mvpView.u(); 
    } 
  }
  
  public final void e() {
    f("refreshData");
    if (b()) {
      f("presenter has no cache data, so fetch cache first");
      k();
    } 
    this.b = SystemClock.uptimeMillis();
    a(new IFetchDataListener(this) {
          public void a() {
            this.a.b("refresh_start", new -$$Lambda$MvpPresenter$1$JMD3P73CgbPdgN6jvDZ7PzJPr2M(this));
          }
          
          public void a(String param1String, List param1List) {
            this.a.a("refresh_datafetch", new -$$Lambda$MvpPresenter$1$CzxHZDAv_1h6FE_8QPYZtYJJj74(this, param1String, param1List));
          }
          
          public void a(boolean param1Boolean) {
            this.a.b("refresh_end", new -$$Lambda$MvpPresenter$1$-0e1zIdIO7q6gp-cRERZCsYiWQI(this, param1Boolean));
          }
          
          public void b() {
            this.a.b("fetchmore_nomoredata", new -$$Lambda$MvpPresenter$1$iJXfeF6EsOXDlT0CTvz-jGLWPMo(this));
          }
        });
  }
  
  public final void e_(String paramString) {
    b("showDataLoading", new -$$Lambda$MvpPresenter$m64ViBcgH8kGOiiT2AjQbzydEc4(this, paramString));
  }
  
  public final void f() {
    Log.v(this.h, "fetchMoreData");
    b(new IFetchDataListener(this) {
          public void a() {
            this.a.b("fetchmore_start", new -$$Lambda$MvpPresenter$2$Q_0oRcmIKmass1BwARyxdZolQEE(this));
          }
          
          public void a(String param1String, List param1List) {
            this.a.a("fetchmore_datafetch", new -$$Lambda$MvpPresenter$2$QnRtpGZQ8D2vE1TFEIgkAb9C3yc(this, param1String, param1List));
          }
          
          public void a(boolean param1Boolean) {
            this.a.b("fetchmore_end", new -$$Lambda$MvpPresenter$2$1-TJU0UBNMRi0vHs5iKi6ZYc6X4(this, param1Boolean));
          }
          
          public void b() {
            this.a.b("fetchmore_onMoreData, onNoMoreData:", new -$$Lambda$MvpPresenter$2$16jXkNKp07jpHnajZxD1dKS-kIs(this));
          }
        });
  }
  
  public final IRequestHost g() {
    return this.g;
  }
  
  public final Activity h() {
    return (Activity)this.c;
  }
  
  public final void i() {
    FragmentActivity fragmentActivity = this.c;
    if (fragmentActivity != null)
      fragmentActivity.finish(); 
  }
  
  public boolean j() {
    return false;
  }
  
  public void k() {}
  
  protected String[] l() {
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\mvp\MvpPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */