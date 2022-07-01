package org.chromium.content.browser;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.ScreenOrientationDelegate;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;

public class ScreenOrientationProviderImpl {
  private static ScreenOrientationDelegate sDelegate;
  
  private static int getOrientationFromWebScreenOrientations(byte paramByte, WindowAndroid paramWindowAndroid, Context paramContext) {
    int i;
    DisplayAndroid displayAndroid;
    switch (paramByte) {
      default:
        Log.w("cr.ScreenOrientation", "Trying to lock to unsupported orientation!", new Object[0]);
        return -1;
      case 8:
        if (paramWindowAndroid != null) {
          displayAndroid = paramWindowAndroid.mDisplayAndroid;
        } else {
          displayAndroid = DisplayAndroid.getNonMultiDisplay(paramContext);
        } 
        i = displayAndroid.mRotation;
        return (i == 0 || i == 2) ? ((displayAndroid.mSize.y >= displayAndroid.mSize.x) ? 1 : 0) : ((displayAndroid.mSize.y < displayAndroid.mSize.x) ? 1 : 0);
      case 7:
        return 7;
      case 6:
        return 6;
      case 5:
        return 10;
      case 4:
        return 8;
      case 3:
        return 0;
      case 2:
        return 9;
      case 1:
        return 1;
      case 0:
        break;
    } 
    return -1;
  }
  
  @CalledByNative
  private static boolean isOrientationLockEnabled() {
    return (sDelegate == null || sDelegate.canLockOrientation());
  }
  
  @CalledByNative
  public static void lockOrientation(WindowAndroid paramWindowAndroid, byte paramByte) {
    if (sDelegate != null && !sDelegate.canLockOrientation())
      return; 
    if (paramWindowAndroid == null)
      return; 
    Activity activity = paramWindowAndroid.getActivity().get();
    if (activity == null)
      return; 
    int i = getOrientationFromWebScreenOrientations(paramByte, paramWindowAndroid, (Context)activity);
    if (i == -1)
      return; 
    activity.setRequestedOrientation(i);
  }
  
  @CalledByNative
  public static void unlockOrientation(WindowAndroid paramWindowAndroid) {
    if (paramWindowAndroid == null)
      return; 
    Activity activity = paramWindowAndroid.getActivity().get();
    if (activity == null)
      return; 
    int j = getOrientationFromWebScreenOrientations((byte)activity.getIntent().getIntExtra("org.chromium.content_public.common.orientation", 0), paramWindowAndroid, (Context)activity);
    int i = j;
    if (j == -1)
      try {
        i = (activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128)).screenOrientation;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        int m = j;
        if (sDelegate != null)
          if (sDelegate.canUnlockOrientation$3ef636e0()) {
            m = j;
          } else {
            return;
          }  
        return;
      } finally {
        if (sDelegate == null || sDelegate.canUnlockOrientation$3ef636e0())
          activity.setRequestedOrientation(j); 
      }  
    int k = i;
    if (sDelegate != null)
      if (sDelegate.canUnlockOrientation$3ef636e0()) {
        k = i;
      } else {
        return;
      }  
    activity.setRequestedOrientation(k);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ScreenOrientationProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */