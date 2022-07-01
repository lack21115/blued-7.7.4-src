package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public class ProcessLifecycleOwner implements LifecycleOwner {
  static final long TIMEOUT_MS = 700L;
  
  private static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();
  
  private Runnable mDelayedPauseRunnable = new Runnable() {
      public void run() {
        ProcessLifecycleOwner.this.dispatchPauseIfNeeded();
        ProcessLifecycleOwner.this.dispatchStopIfNeeded();
      }
    };
  
  private Handler mHandler;
  
  ReportFragment.ActivityInitializationListener mInitializationListener = new ReportFragment.ActivityInitializationListener() {
      public void onCreate() {}
      
      public void onResume() {
        ProcessLifecycleOwner.this.activityResumed();
      }
      
      public void onStart() {
        ProcessLifecycleOwner.this.activityStarted();
      }
    };
  
  private boolean mPauseSent = true;
  
  private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
  
  private int mResumedCounter = 0;
  
  private int mStartedCounter = 0;
  
  private boolean mStopSent = true;
  
  public static LifecycleOwner get() {
    return sInstance;
  }
  
  static void init(Context paramContext) {
    sInstance.attach(paramContext);
  }
  
  void activityPaused() {
    this.mResumedCounter--;
    if (this.mResumedCounter == 0)
      this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700L); 
  }
  
  void activityResumed() {
    this.mResumedCounter++;
    if (this.mResumedCounter == 1) {
      if (this.mPauseSent) {
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mPauseSent = false;
        return;
      } 
      this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
    } 
  }
  
  void activityStarted() {
    this.mStartedCounter++;
    if (this.mStartedCounter == 1 && this.mStopSent) {
      this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.mStopSent = false;
    } 
  }
  
  void activityStopped() {
    this.mStartedCounter--;
    dispatchStopIfNeeded();
  }
  
  void attach(Context paramContext) {
    this.mHandler = new Handler();
    this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
          public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {
            ReportFragment.get(param1Activity).setProcessListener(ProcessLifecycleOwner.this.mInitializationListener);
          }
          
          public void onActivityPaused(Activity param1Activity) {
            ProcessLifecycleOwner.this.activityPaused();
          }
          
          public void onActivityStopped(Activity param1Activity) {
            ProcessLifecycleOwner.this.activityStopped();
          }
        });
  }
  
  void dispatchPauseIfNeeded() {
    if (this.mResumedCounter == 0) {
      this.mPauseSent = true;
      this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    } 
  }
  
  void dispatchStopIfNeeded() {
    if (this.mStartedCounter == 0 && this.mPauseSent) {
      this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.mStopSent = true;
    } 
  }
  
  public Lifecycle getLifecycle() {
    return this.mRegistry;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\ProcessLifecycleOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */