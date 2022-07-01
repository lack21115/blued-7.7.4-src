package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class VibrationManager_Internal$VibrationManagerVibrateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final VibrationManager$VibrateResponse mCallback;
  
  VibrationManager_Internal$VibrationManagerVibrateResponseParamsForwardToCallback(VibrationManager$VibrateResponse paramVibrationManager$VibrateResponse) {
    this.mCallback = paramVibrationManager$VibrateResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      if (!(paramMessage.asServiceMessage()).mHeader.validateHeader(0, 2))
        return false; 
      this.mCallback.call();
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\VibrationManager_Internal$VibrationManagerVibrateResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */