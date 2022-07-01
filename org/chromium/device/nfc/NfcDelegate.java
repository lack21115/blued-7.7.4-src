package org.chromium.device.nfc;

import org.chromium.base.Callback;

public interface NfcDelegate {
  void stopTrackingActivityForHost(int paramInt);
  
  void trackActivityForHost(int paramInt, Callback paramCallback);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */