package androidx.lifecycle;

import android.os.Handler;

public class ServiceLifecycleDispatcher {
  private final Handler mHandler;
  
  private DispatchRunnable mLastDispatchRunnable;
  
  private final LifecycleRegistry mRegistry;
  
  public ServiceLifecycleDispatcher(LifecycleOwner paramLifecycleOwner) {
    this.mRegistry = new LifecycleRegistry(paramLifecycleOwner);
    this.mHandler = new Handler();
  }
  
  private void postDispatchRunnable(Lifecycle.Event paramEvent) {
    DispatchRunnable dispatchRunnable = this.mLastDispatchRunnable;
    if (dispatchRunnable != null)
      dispatchRunnable.run(); 
    this.mLastDispatchRunnable = new DispatchRunnable(this.mRegistry, paramEvent);
    this.mHandler.postAtFrontOfQueue(this.mLastDispatchRunnable);
  }
  
  public Lifecycle getLifecycle() {
    return this.mRegistry;
  }
  
  public void onServicePreSuperOnBind() {
    postDispatchRunnable(Lifecycle.Event.ON_START);
  }
  
  public void onServicePreSuperOnCreate() {
    postDispatchRunnable(Lifecycle.Event.ON_CREATE);
  }
  
  public void onServicePreSuperOnDestroy() {
    postDispatchRunnable(Lifecycle.Event.ON_STOP);
    postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
  }
  
  public void onServicePreSuperOnStart() {
    postDispatchRunnable(Lifecycle.Event.ON_START);
  }
  
  static class DispatchRunnable implements Runnable {
    final Lifecycle.Event mEvent;
    
    private final LifecycleRegistry mRegistry;
    
    private boolean mWasExecuted = false;
    
    DispatchRunnable(LifecycleRegistry param1LifecycleRegistry, Lifecycle.Event param1Event) {
      this.mRegistry = param1LifecycleRegistry;
      this.mEvent = param1Event;
    }
    
    public void run() {
      if (!this.mWasExecuted) {
        this.mRegistry.handleLifecycleEvent(this.mEvent);
        this.mWasExecuted = true;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\ServiceLifecycleDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */