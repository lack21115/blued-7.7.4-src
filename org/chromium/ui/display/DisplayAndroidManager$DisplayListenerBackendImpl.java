package org.chromium.ui.display;

import android.annotation.SuppressLint;
import android.hardware.display.DisplayManager;
import android.view.Display;

@SuppressLint({"NewApi"})
final class DisplayAndroidManager$DisplayListenerBackendImpl implements DisplayManager.DisplayListener, DisplayAndroidManager$DisplayListenerBackend {
  private DisplayAndroidManager$DisplayListenerBackendImpl() {}
  
  public final void onDisplayAdded(int paramInt) {}
  
  public final void onDisplayChanged(int paramInt) {
    PhysicalDisplayAndroid physicalDisplayAndroid = (PhysicalDisplayAndroid)DisplayAndroidManager.access$300(DisplayAndroidManager.this).get(paramInt);
    Display display = DisplayAndroidManager.access$400().getDisplay(paramInt);
    if (physicalDisplayAndroid != null && display != null)
      physicalDisplayAndroid.updateFromDisplay(display); 
  }
  
  public final void onDisplayRemoved(int paramInt) {
    if (paramInt == DisplayAndroidManager.access$200(DisplayAndroidManager.this))
      return; 
    if ((DisplayAndroid)DisplayAndroidManager.access$300(DisplayAndroidManager.this).get(paramInt) == null)
      return; 
    if (DisplayAndroidManager.access$500(DisplayAndroidManager.this) != 0L)
      DisplayAndroidManager.access$600(DisplayAndroidManager.this, DisplayAndroidManager.access$500(DisplayAndroidManager.this), paramInt); 
    DisplayAndroidManager.access$300(DisplayAndroidManager.this).remove(paramInt);
  }
  
  public final void startAccurateListening() {}
  
  public final void startListening() {
    DisplayAndroidManager.access$400().registerDisplayListener(this, null);
  }
  
  public final void stopAccurateListening() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\display\DisplayAndroidManager$DisplayListenerBackendImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */