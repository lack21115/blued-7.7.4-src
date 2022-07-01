package org.chromium.device.power_save_blocker;

import android.view.View;
import java.lang.ref.WeakReference;
import org.chromium.base.annotations.CalledByNative;

class PowerSaveBlocker {
  private WeakReference mKeepScreenOnView;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private void applyBlock(View paramView) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private static PowerSaveBlocker create() {
    return new PowerSaveBlocker();
  }
  
  @CalledByNative
  private void removeBlock() {
    if (this.mKeepScreenOnView == null)
      return; 
    View view = this.mKeepScreenOnView.get();
    this.mKeepScreenOnView = null;
    if (view == null)
      return; 
    view.setKeepScreenOn(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\power_save_blocker\PowerSaveBlocker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */