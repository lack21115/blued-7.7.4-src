package com.blued.android.framework.ui.mvp;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

public class MvpPresenterManager {
  private Map<String, MvpPresenter> a = new HashMap<String, MvpPresenter>();
  
  public static MvpPresenterManager a() {
    return SingletonCreator.a;
  }
  
  public MvpPresenter a(String paramString) {
    return this.a.get(paramString);
  }
  
  public void a(MvpPresenter paramMvpPresenter, Lifecycle paramLifecycle) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSave, add mvpPresenter:");
    stringBuilder.append(paramMvpPresenter);
    stringBuilder.append(", for key:");
    stringBuilder.append(paramMvpPresenter.a);
    LogUtils.b(stringBuilder.toString());
    this.a.put(paramMvpPresenter.a, paramMvpPresenter);
    paramLifecycle.addObserver(new LifecycleObserver(this, paramMvpPresenter) {
          @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
          public void onDestroy() {
            MvpPresenter mvpPresenter = (MvpPresenter)MvpPresenterManager.a(this.b).remove(this.a.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onDestroy, remove mvpPresenter:");
            stringBuilder.append(mvpPresenter);
            stringBuilder.append(", for key:");
            stringBuilder.append(this.a.a);
            LogUtils.b(stringBuilder.toString());
          }
        });
  }
  
  static class SingletonCreator {
    public static final MvpPresenterManager a = new MvpPresenterManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\mvp\MvpPresenterManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */