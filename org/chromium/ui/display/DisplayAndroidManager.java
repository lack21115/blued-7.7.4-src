package org.chromium.ui.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class DisplayAndroidManager {
  private static DisplayAndroidManager sDisplayAndroidManager;
  
  DisplayAndroidManager$DisplayListenerBackend mBackend;
  
  final SparseArray mIdMap = new SparseArray();
  
  private int mMainSdkDisplayId;
  
  private long mNativePointer;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Display getDefaultDisplayForContext(Context paramContext) {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  private static DisplayManager getDisplayManager() {
    return (DisplayManager)ContextUtils.sApplicationContext.getSystemService("display");
  }
  
  static DisplayAndroidManager getInstance() {
    ThreadUtils.assertOnUiThread();
    if (sDisplayAndroidManager == null) {
      Display display;
      DisplayAndroidManager displayAndroidManager = new DisplayAndroidManager();
      sDisplayAndroidManager = displayAndroidManager;
      if (Build.VERSION.SDK_INT >= 17) {
        displayAndroidManager.mBackend = new DisplayAndroidManager$DisplayListenerBackendImpl(displayAndroidManager, (byte)0);
        Display display1 = getDisplayManager().getDisplay(0);
        display = display1;
        if (display1 == null)
          display = getDefaultDisplayForContext(ContextUtils.sApplicationContext); 
      } else {
        displayAndroidManager.mBackend = new DisplayAndroidManager$DisplayListenerAPI16(displayAndroidManager, (byte)0);
        display = getDefaultDisplayForContext(ContextUtils.sApplicationContext);
      } 
      displayAndroidManager.mMainSdkDisplayId = display.getDisplayId();
      displayAndroidManager.addDisplay(display);
      displayAndroidManager.mBackend.startListening();
    } 
    return sDisplayAndroidManager;
  }
  
  private native void nativeRemoveDisplay(long paramLong, int paramInt);
  
  private native void nativeSetPrimaryDisplayId(long paramLong, int paramInt);
  
  private native void nativeUpdateDisplay(long paramLong, int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);
  
  @CalledByNative
  private static void onNativeSideCreated(long paramLong) {
    DisplayAndroidManager displayAndroidManager = getInstance();
    displayAndroidManager.mNativePointer = paramLong;
    displayAndroidManager.nativeSetPrimaryDisplayId(displayAndroidManager.mNativePointer, displayAndroidManager.mMainSdkDisplayId);
    for (int i = 0; i < displayAndroidManager.mIdMap.size(); i++)
      displayAndroidManager.updateDisplayOnNativeSide((DisplayAndroid)displayAndroidManager.mIdMap.valueAt(i)); 
  }
  
  final DisplayAndroid addDisplay(Display paramDisplay) {
    int i = paramDisplay.getDisplayId();
    PhysicalDisplayAndroid physicalDisplayAndroid = new PhysicalDisplayAndroid(paramDisplay);
    assert false;
    throw new AssertionError();
  }
  
  final void updateDisplayOnNativeSide(DisplayAndroid paramDisplayAndroid) {
    char c;
    boolean bool;
    if (this.mNativePointer == 0L)
      return; 
    long l = this.mNativePointer;
    int i = paramDisplayAndroid.mDisplayId;
    int j = paramDisplayAndroid.mSize.x;
    int k = paramDisplayAndroid.mSize.y;
    float f = paramDisplayAndroid.mDipScale;
    switch (paramDisplayAndroid.mRotation) {
      default:
        if (!DisplayAndroid.$assertionsDisabled)
          throw new AssertionError(); 
      case 3:
        c = 'Ď';
        break;
      case 2:
        c = '´';
        break;
      case 1:
        c = 'Z';
        break;
      case 0:
        c = Character.MIN_VALUE;
        break;
    } 
    int m = paramDisplayAndroid.mBitsPerPixel;
    int n = paramDisplayAndroid.mBitsPerComponent;
    if (paramDisplayAndroid.mIsDisplayWideColorGamut && paramDisplayAndroid.mIsDisplayServerWideColorGamut) {
      bool = true;
    } else {
      bool = false;
    } 
    nativeUpdateDisplay(l, i, j, k, f, c, m, n, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\display\DisplayAndroidManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */