package org.chromium.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import java.util.Map;
import org.chromium.base.annotations.CalledByNative;

public class ApplicationStatus {
  @SuppressLint({"StaticFieldLeak"})
  private static Activity sActivity;
  
  private static final Map sActivityInfo;
  
  private static final ObserverList sApplicationStateListeners;
  
  @SuppressLint({"SupportAnnotationUsage"})
  private static Integer sCurrentApplicationState;
  
  private static final Object sCurrentApplicationStateLock;
  
  private static boolean sIsInitialized;
  
  private static ApplicationStatus$ApplicationStateListener sNativeApplicationStateListener;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static void assertInitialized() {
    if (sIsInitialized)
      return; 
    throw new IllegalStateException("ApplicationStatus has not been initialized yet.");
  }
  
  public static Activity getLastTrackedFocusedActivity() {
    return sActivity;
  }
  
  public static int getStateForActivity(Activity paramActivity) {
    assertInitialized();
    if (paramActivity == null)
      return 6; 
    ApplicationStatus$ActivityInfo applicationStatus$ActivityInfo = (ApplicationStatus$ActivityInfo)sActivityInfo.get(paramActivity);
    return (applicationStatus$ActivityInfo != null) ? applicationStatus$ActivityInfo.mStatus : 6;
  }
  
  @CalledByNative
  public static int getStateForApplication() {
    synchronized (sCurrentApplicationStateLock) {
      return sCurrentApplicationState.intValue();
    } 
  }
  
  private static native void nativeOnApplicationStateChange(int paramInt);
  
  public static void registerApplicationStateListener(ApplicationStatus$ApplicationStateListener paramApplicationStatus$ApplicationStateListener) {
    sApplicationStateListeners.addObserver(paramApplicationStatus$ApplicationStateListener);
  }
  
  @SuppressLint({"NewApi"})
  public static void registerStateListenerForActivity(ApplicationStatus$ActivityStateListener paramApplicationStatus$ActivityStateListener, Activity paramActivity) {
    if (paramActivity != null) {
      assertInitialized();
      ApplicationStatus$ActivityInfo applicationStatus$ActivityInfo = (ApplicationStatus$ActivityInfo)sActivityInfo.get(paramActivity);
      if (applicationStatus$ActivityInfo != null) {
        assert false;
        throw new AssertionError();
      } 
      throw new IllegalStateException("Attempting to register listener on an untracked activity.");
    } 
    throw new IllegalStateException("Attempting to register listener on a null activity.");
  }
  
  @CalledByNative
  private static void registerThreadSafeNativeApplicationStateListener() {
    ThreadUtils.runOnUiThread(new ApplicationStatus$3());
  }
  
  public static void unregisterApplicationStateListener(ApplicationStatus$ApplicationStateListener paramApplicationStatus$ApplicationStateListener) {
    sApplicationStateListeners.removeObserver(paramApplicationStatus$ApplicationStateListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ApplicationStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */