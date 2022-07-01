package org.chromium.ui.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ObserverList;
import org.chromium.base.StrictModeContext;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.ui.VSyncMonitor;
import org.chromium.ui.display.DisplayAndroid;

public class WindowAndroid implements AndroidPermissionDelegate {
  private final AccessibilityManager mAccessibilityManager;
  
  public ObserverList mActivityStateObservers;
  
  private WeakReference mContextRef;
  
  public final DisplayAndroid mDisplayAndroid;
  
  protected HashMap mIntentErrors;
  
  boolean mIsKeyboardShowing;
  
  ObserverList mKeyboardVisibilityListeners;
  
  public long mNativeWindowAndroid;
  
  protected SparseArray mOutstandingIntents;
  
  AndroidPermissionDelegate mPermissionDelegate;
  
  public WindowAndroid$TouchExplorationMonitor mTouchExplorationMonitor;
  
  private final VSyncMonitor.Listener mVSyncListener;
  
  public final VSyncMonitor mVSyncMonitor;
  
  private boolean mVSyncPaused;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public WindowAndroid(Context paramContext) {
    this(paramContext, DisplayAndroid.getNonMultiDisplay(paramContext));
  }
  
  @SuppressLint({"UseSparseArrays"})
  private WindowAndroid(Context paramContext, DisplayAndroid paramDisplayAndroid) {
    new HashSet();
    this.mKeyboardVisibilityListeners = new ObserverList();
    this.mActivityStateObservers = new ObserverList();
    new ObserverList();
    this.mVSyncListener = new WindowAndroid$1(this);
    this.mContextRef = new WeakReference<Context>(paramContext);
    this.mOutstandingIntents = new SparseArray();
    this.mIntentErrors = new HashMap<Object, Object>();
    StrictModeContext strictModeContext = StrictModeContext.allowDiskReads();
    Throwable throwable2 = null;
    Throwable throwable1 = throwable2;
    try {
      this.mVSyncMonitor = new VSyncMonitor(paramContext, this.mVSyncListener);
      throwable1 = throwable2;
      this.mAccessibilityManager = (AccessibilityManager)ContextUtils.sApplicationContext.getSystemService("accessibility");
      if (strictModeContext != null)
        strictModeContext.close(); 
      this.mDisplayAndroid = paramDisplayAndroid;
      if (Build.VERSION.SDK_INT >= 26 && !Build.VERSION.RELEASE.equals("8.0.0") && activityFromContext(paramContext) != null)
        paramDisplayAndroid.updateIsDisplayServerWideColorGamut(Boolean.valueOf(paramContext.getResources().getConfiguration().isScreenWideColorGamut())); 
      return;
    } catch (Throwable throwable) {
      throwable1 = throwable;
      throw throwable;
    } finally {}
    if (strictModeContext != null)
      if (throwable1 != null) {
        try {
          strictModeContext.close();
        } catch (Throwable throwable) {
          ThrowableExtension.addSuppressed(throwable1, throwable);
        } 
      } else {
        strictModeContext.close();
      }  
    throw paramContext;
  }
  
  public static Activity activityFromContext(Context paramContext) {
    while (true) {
      if (paramContext instanceof Activity)
        return (Activity)paramContext; 
      if (paramContext instanceof ContextWrapper) {
        paramContext = ((ContextWrapper)paramContext).getBaseContext();
        continue;
      } 
      return null;
    } 
  }
  
  public static boolean canResolveActivity(Intent paramIntent) {
    return (ContextUtils.sApplicationContext.getPackageManager().queryIntentActivities(paramIntent, 0).size() > 0);
  }
  
  @CalledByNative
  private void clearNativePointer() {
    this.mNativeWindowAndroid = 0L;
  }
  
  @CalledByNative
  private static long createForTesting() {
    return (new WindowAndroid(ContextUtils.sApplicationContext)).getNativePointer();
  }
  
  @CalledByNative
  private long getNativePointer() {
    if (this.mNativeWindowAndroid == 0L) {
      float f;
      int i = this.mDisplayAndroid.mDisplayId;
      TypedValue typedValue = new TypedValue();
      Context context = getContext().get();
      if (context != null && context.getTheme().resolveAttribute(16842829, typedValue, true)) {
        f = typedValue.getDimension(context.getResources().getDisplayMetrics());
      } else {
        f = 0.0F;
      } 
      this.mNativeWindowAndroid = nativeInit(i, f);
      nativeSetVSyncPaused(this.mNativeWindowAndroid, this.mVSyncPaused);
    } 
    return this.mNativeWindowAndroid;
  }
  
  public static View getReadbackView() {
    return null;
  }
  
  @CalledByNative
  private IBinder getWindowToken() {
    Activity activity = activityFromContext(this.mContextRef.get());
    if (activity == null)
      return null; 
    Window window = activity.getWindow();
    if (window == null)
      return null; 
    View view = window.peekDecorView();
    return (view == null) ? null : view.getWindowToken();
  }
  
  private native long nativeInit(int paramInt, float paramFloat);
  
  private native void nativeOnActivityStarted(long paramLong);
  
  private native void nativeOnActivityStopped(long paramLong);
  
  private native void nativeOnVSync(long paramLong1, long paramLong2, long paramLong3);
  
  private native void nativeOnVisibilityChanged(long paramLong, boolean paramBoolean);
  
  private native void nativeSetVSyncPaused(long paramLong, boolean paramBoolean);
  
  @CalledByNative
  private void requestVSyncUpdate() {
    if (this.mVSyncPaused)
      return; 
    VSyncMonitor vSyncMonitor = this.mVSyncMonitor;
    if (VSyncMonitor.$assertionsDisabled || vSyncMonitor.mHandler.getLooper() == Looper.myLooper()) {
      if (!vSyncMonitor.mHaveRequestInFlight) {
        vSyncMonitor.mHaveRequestInFlight = true;
        vSyncMonitor.mConsecutiveVSync = vSyncMonitor.mInsideVSync;
        vSyncMonitor.mChoreographer.postFrameCallback(vSyncMonitor.mVSyncFrameCallback);
      } 
      return;
    } 
    throw new AssertionError();
  }
  
  @CalledByNative
  public final boolean canRequestPermission(String paramString) {
    if (this.mPermissionDelegate != null)
      return this.mPermissionDelegate.canRequestPermission(paramString); 
    Log.w("WindowAndroid", "Cannot determine the request permission state as the context is not an Activity", new Object[0]);
    assert false;
    throw new AssertionError("Failed to determine the request permission state using a WindowAndroid without an Activity");
  }
  
  public WeakReference getActivity() {
    return new WeakReference(null);
  }
  
  public int getActivityState() {
    return 6;
  }
  
  public final WeakReference getContext() {
    return new WeakReference<Context>(this.mContextRef.get());
  }
  
  @CalledByNative
  public final boolean hasPermission(String paramString) {
    return (this.mPermissionDelegate != null) ? this.mPermissionDelegate.hasPermission(paramString) : ((ApiCompatibilityUtils.checkPermission(ContextUtils.sApplicationContext, paramString, Process.myPid(), Process.myUid()) == 0));
  }
  
  public native void nativeDestroy(long paramLong);
  
  public final void requestPermissions(String[] paramArrayOfString, PermissionCallback paramPermissionCallback) {
    if (this.mPermissionDelegate != null) {
      this.mPermissionDelegate.requestPermissions(paramArrayOfString, paramPermissionCallback);
      return;
    } 
    Log.w("WindowAndroid", "Cannot request permissions as the context is not an Activity", new Object[0]);
    assert false;
    throw new AssertionError("Failed to request permissions using a WindowAndroid without an Activity");
  }
  
  public int showCancelableIntent(Intent paramIntent, WindowAndroid$IntentCallback paramWindowAndroid$IntentCallback, Integer paramInteger) {
    (new StringBuilder("Can't show intent as context is not an Activity: ")).append(paramIntent);
    return -1;
  }
  
  public final boolean showIntent(Intent paramIntent, WindowAndroid$IntentCallback paramWindowAndroid$IntentCallback, Integer paramInteger) {
    return (showCancelableIntent(paramIntent, paramWindowAndroid$IntentCallback, paramInteger) >= 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\WindowAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */