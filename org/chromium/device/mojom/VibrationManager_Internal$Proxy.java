package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class VibrationManager_Internal$Proxy extends Interface.AbstractProxy implements VibrationManager$Proxy {
  VibrationManager_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void cancel(VibrationManager$CancelResponse paramVibrationManager$CancelResponse) {
    VibrationManager_Internal$VibrationManagerCancelParams vibrationManager_Internal$VibrationManagerCancelParams = new VibrationManager_Internal$VibrationManagerCancelParams((byte)0);
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)vibrationManager_Internal$VibrationManagerCancelParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(1, 1, 0L)), new VibrationManager_Internal$VibrationManagerCancelResponseParamsForwardToCallback(paramVibrationManager$CancelResponse));
  }
  
  public final void vibrate(long paramLong, VibrationManager$VibrateResponse paramVibrationManager$VibrateResponse) {
    VibrationManager_Internal$VibrationManagerVibrateParams vibrationManager_Internal$VibrationManagerVibrateParams = new VibrationManager_Internal$VibrationManagerVibrateParams((byte)0);
    vibrationManager_Internal$VibrationManagerVibrateParams.milliseconds = paramLong;
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)vibrationManager_Internal$VibrationManagerVibrateParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0, 1, 0L)), new VibrationManager_Internal$VibrationManagerVibrateResponseParamsForwardToCallback(paramVibrationManager$VibrateResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\VibrationManager_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */