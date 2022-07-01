package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public final class ReportFragment extends Fragment {
  private void dispatch(Lifecycle$Event paramLifecycle$Event) {
    Activity activity = getActivity();
    if (activity instanceof LifecycleRegistryOwner) {
      ((LifecycleRegistryOwner)activity).getLifecycle().handleLifecycleEvent(paramLifecycle$Event);
      return;
    } 
    if (activity instanceof LifecycleOwner) {
      Lifecycle lifecycle = ((LifecycleOwner)activity).getLifecycle();
      if (lifecycle instanceof LifecycleRegistry)
        ((LifecycleRegistry)lifecycle).handleLifecycleEvent(paramLifecycle$Event); 
    } 
  }
  
  public static void injectIfNeededIn(Activity paramActivity) {
    FragmentManager fragmentManager = paramActivity.getFragmentManager();
    if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
      fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      fragmentManager.executePendingTransactions();
    } 
  }
  
  public final void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    dispatch(Lifecycle$Event.ON_CREATE);
  }
  
  public final void onDestroy() {
    super.onDestroy();
    dispatch(Lifecycle$Event.ON_DESTROY);
  }
  
  public final void onPause() {
    super.onPause();
    dispatch(Lifecycle$Event.ON_PAUSE);
  }
  
  public final void onResume() {
    super.onResume();
    dispatch(Lifecycle$Event.ON_RESUME);
  }
  
  public final void onStart() {
    super.onStart();
    dispatch(Lifecycle$Event.ON_START);
  }
  
  public final void onStop() {
    super.onStop();
    dispatch(Lifecycle$Event.ON_STOP);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\lifecycle\ReportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */