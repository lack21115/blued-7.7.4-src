package org.chromium.ui.display;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import org.chromium.base.ThreadUtils;

final class DisplayAndroidManager$DisplayListenerAPI16 implements ComponentCallbacks, DisplayAndroidManager$DisplayListenerBackend {
  private int mAccurateCount;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private DisplayAndroidManager$DisplayListenerAPI16() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {
    ((PhysicalDisplayAndroid)DisplayAndroidManager.access$300(DisplayAndroidManager.this).get(DisplayAndroidManager.access$200(DisplayAndroidManager.this))).updateFromDisplay(DisplayAndroidManager.getDefaultDisplayForContext(DisplayAndroidManager.access$000()));
  }
  
  public final void onLowMemory() {}
  
  public final void startAccurateListening() {
    this.mAccurateCount++;
    if (this.mAccurateCount > 1)
      return; 
    ThreadUtils.postOnUiThreadDelayed(new DisplayAndroidManager$DisplayListenerAPI16$1(this), 500L);
  }
  
  public final void startListening() {
    DisplayAndroidManager.access$000().registerComponentCallbacks(this);
  }
  
  public final void stopAccurateListening() {
    this.mAccurateCount--;
    assert false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\display\DisplayAndroidManager$DisplayListenerAPI16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */