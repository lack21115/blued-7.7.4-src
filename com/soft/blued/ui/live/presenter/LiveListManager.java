package com.soft.blued.ui.live.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.soft.blued.ui.live.contract.LiveListContract;

public class LiveListManager implements LiveListContract.ServicePresenter {
  private static LiveListManager a;
  
  private LiveListPresenterHolder b = new LiveListPresenterHolder();
  
  private LiveListContract.IPresenter c;
  
  public static LiveListManager a() {
    // Byte code:
    //   0: ldc com/soft/blued/ui/live/presenter/LiveListManager
    //   2: monitorenter
    //   3: getstatic com/soft/blued/ui/live/presenter/LiveListManager.a : Lcom/soft/blued/ui/live/presenter/LiveListManager;
    //   6: ifnonnull -> 40
    //   9: ldc com/soft/blued/ui/live/presenter/LiveListManager
    //   11: monitorenter
    //   12: getstatic com/soft/blued/ui/live/presenter/LiveListManager.a : Lcom/soft/blued/ui/live/presenter/LiveListManager;
    //   15: ifnonnull -> 28
    //   18: new com/soft/blued/ui/live/presenter/LiveListManager
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: putstatic com/soft/blued/ui/live/presenter/LiveListManager.a : Lcom/soft/blued/ui/live/presenter/LiveListManager;
    //   28: ldc com/soft/blued/ui/live/presenter/LiveListManager
    //   30: monitorexit
    //   31: goto -> 40
    //   34: astore_0
    //   35: ldc com/soft/blued/ui/live/presenter/LiveListManager
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: ldc com/soft/blued/ui/live/presenter/LiveListManager
    //   42: monitorexit
    //   43: getstatic com/soft/blued/ui/live/presenter/LiveListManager.a : Lcom/soft/blued/ui/live/presenter/LiveListManager;
    //   46: areturn
    //   47: astore_0
    //   48: ldc com/soft/blued/ui/live/presenter/LiveListManager
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	47	finally
    //   12	28	34	finally
    //   28	31	34	finally
    //   35	38	34	finally
    //   38	40	47	finally
    //   40	43	47	finally
    //   48	51	47	finally
  }
  
  public BluedLiveState a(String paramString, int paramInt) {
    LiveListPresenterHolder liveListPresenterHolder = this.b;
    if (liveListPresenterHolder != null) {
      this.c = liveListPresenterHolder.a(paramString, paramInt);
      LiveListContract.IPresenter iPresenter = this.c;
      if (iPresenter != null)
        return iPresenter.a(); 
    } 
    return null;
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    if (paramLifecycleOwner != null)
      paramLifecycleOwner.getLifecycle().addObserver(new LifecycleObserver(this, paramLifecycleOwner) {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onOwnerDestroy() {
              LogUtils.b("onOwnerDestroy");
              if (LiveListManager.a(this.b) != null)
                LiveListManager.a(this.b).a(); 
              this.a.getLifecycle().removeObserver(this);
            }
            
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public void onOwnerStart() {
              LogUtils.b("onOwnerStart");
            }
          }); 
  }
  
  public void a(LiveListContract.IView paramIView, String paramString, int paramInt) {
    LiveListPresenterHolder liveListPresenterHolder = this.b;
    if (liveListPresenterHolder != null) {
      this.c = liveListPresenterHolder.a(paramString, paramInt);
      LiveListContract.IPresenter iPresenter = this.c;
      if (iPresenter != null)
        iPresenter.a(paramIView); 
    } 
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {
    LiveListPresenterHolder liveListPresenterHolder = this.b;
    if (liveListPresenterHolder != null) {
      this.c = liveListPresenterHolder.a(paramString, paramInt);
      LiveListContract.IPresenter iPresenter = this.c;
      if (iPresenter != null)
        iPresenter.a(paramBoolean); 
    } 
  }
  
  public void b(String paramString, int paramInt) {
    LiveListPresenterHolder liveListPresenterHolder = this.b;
    if (liveListPresenterHolder != null) {
      this.c = liveListPresenterHolder.a(paramString, paramInt);
      LiveListContract.IPresenter iPresenter = this.c;
      if (iPresenter != null)
        iPresenter.b(); 
    } 
  }
  
  public int c(String paramString, int paramInt) {
    LiveListPresenterHolder liveListPresenterHolder = this.b;
    if (liveListPresenterHolder != null) {
      this.c = liveListPresenterHolder.a(paramString, paramInt);
      LiveListContract.IPresenter iPresenter = this.c;
      if (iPresenter != null)
        return iPresenter.d(); 
    } 
    return 0;
  }
  
  public void d(String paramString, int paramInt) {
    LiveListPresenterHolder liveListPresenterHolder = this.b;
    if (liveListPresenterHolder != null)
      liveListPresenterHolder.b(paramString, paramInt); 
  }
  
  public void e(String paramString, int paramInt) {
    LiveListPresenterHolder liveListPresenterHolder = this.b;
    if (liveListPresenterHolder != null) {
      this.c = liveListPresenterHolder.a(paramString, paramInt);
      LiveListContract.IPresenter iPresenter = this.c;
      if (iPresenter != null)
        iPresenter.f(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveListManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */