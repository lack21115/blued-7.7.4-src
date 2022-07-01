package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class VibrationManager_Internal$VibrationManagerCancelResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final VibrationManager$CancelResponse mCallback;
  
  VibrationManager_Internal$VibrationManagerCancelResponseParamsForwardToCallback(VibrationManager$CancelResponse paramVibrationManager$CancelResponse) {
    this.mCallback = paramVibrationManager$CancelResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      if (!(paramMessage.asServiceMessage()).mHeader.validateHeader(1, 2))
        return false; 
      this.mCallback.call();
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\VibrationManager_Internal$VibrationManagerCancelResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */