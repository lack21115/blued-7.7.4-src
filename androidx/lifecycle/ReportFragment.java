package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;

public class ReportFragment extends Fragment {
  private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
  
  private ActivityInitializationListener mProcessListener;
  
  static void dispatch(Activity paramActivity, Lifecycle.Event paramEvent) {
    if (paramActivity instanceof LifecycleRegistryOwner) {
      ((LifecycleRegistryOwner)paramActivity).getLifecycle().handleLifecycleEvent(paramEvent);
      return;
    } 
    if (paramActivity instanceof LifecycleOwner) {
      Lifecycle lifecycle = ((LifecycleOwner)paramActivity).getLifecycle();
      if (lifecycle instanceof LifecycleRegistry)
        ((LifecycleRegistry)lifecycle).handleLifecycleEvent(paramEvent); 
    } 
  }
  
  private void dispatch(Lifecycle.Event paramEvent) {
    if (Build.VERSION.SDK_INT < 29)
      dispatch(getActivity(), paramEvent); 
  }
  
  private void dispatchCreate(ActivityInitializationListener paramActivityInitializationListener) {
    if (paramActivityInitializationListener != null)
      paramActivityInitializationListener.onCreate(); 
  }
  
  private void dispatchResume(ActivityInitializationListener paramActivityInitializationListener) {
    if (paramActivityInitializationListener != null)
      paramActivityInitializationListener.onResume(); 
  }
  
  private void dispatchStart(ActivityInitializationListener paramActivityInitializationListener) {
    if (paramActivityInitializationListener != null)
      paramActivityInitializationListener.onStart(); 
  }
  
  static ReportFragment get(Activity paramActivity) {
    return (ReportFragment)paramActivity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  public static void injectIfNeededIn(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 29)
      paramActivity.registerActivityLifecycleCallbacks(new LifecycleCallbacks()); 
    FragmentManager fragmentManager = paramActivity.getFragmentManager();
    if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
      fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      fragmentManager.executePendingTransactions();
    } 
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    dispatchCreate(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_CREATE);
  }
  
  public void onDestroy() {
    super.onDestroy();
    dispatch(Lifecycle.Event.ON_DESTROY);
    this.mProcessListener = null;
  }
  
  public void onPause() {
    super.onPause();
    dispatch(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume() {
    super.onResume();
    dispatchResume(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStart() {
    super.onStart();
    dispatchStart(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_START);
  }
  
  public void onStop() {
    super.onStop();
    dispatch(Lifecycle.Event.ON_STOP);
  }
  
  void setProcessListener(ActivityInitializationListener paramActivityInitializationListener) {
    this.mProcessListener = paramActivityInitializationListener;
  }
  
  static interface ActivityInitializationListener {
    void onCreate();
    
    void onResume();
    
    void onStart();
  }
  
  static class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityDestroyed(Activity param1Activity) {}
    
    public void onActivityPaused(Activity param1Activity) {}
    
    public void onActivityPostCreated(Activity param1Activity, Bundle param1Bundle) {
      ReportFragment.dispatch(param1Activity, Lifecycle.Event.ON_CREATE);
    }
    
    public void onActivityPostResumed(Activity param1Activity) {
      ReportFragment.dispatch(param1Activity, Lifecycle.Event.ON_RESUME);
    }
    
    public void onActivityPostStarted(Activity param1Activity) {
      ReportFragment.dispatch(param1Activity, Lifecycle.Event.ON_START);
    }
    
    public void onActivityPreDestroyed(Activity param1Activity) {
      ReportFragment.dispatch(param1Activity, Lifecycle.Event.ON_DESTROY);
    }
    
    public void onActivityPrePaused(Activity param1Activity) {
      ReportFragment.dispatch(param1Activity, Lifecycle.Event.ON_PAUSE);
    }
    
    public void onActivityPreStopped(Activity param1Activity) {
      ReportFragment.dispatch(param1Activity, Lifecycle.Event.ON_STOP);
    }
    
    public void onActivityResumed(Activity param1Activity) {}
    
    public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityStarted(Activity param1Activity) {}
    
    public void onActivityStopped(Activity param1Activity) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\ReportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */