package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class VibrationManager_Internal$VibrationManagerVibrateResponseParamsProxyToResponder implements VibrationManager$VibrateResponse {
  private final Core mCore;
  
  private final MessageReceiver mMessageReceiver;
  
  private final long mRequestId;
  
  VibrationManager_Internal$VibrationManagerVibrateResponseParamsProxyToResponder(Core paramCore, MessageReceiver paramMessageReceiver, long paramLong) {
    this.mCore = paramCore;
    this.mMessageReceiver = paramMessageReceiver;
    this.mRequestId = paramLong;
  }
  
  public final void call() {
    ServiceMessage serviceMessage = (new VibrationManager_Internal$VibrationManagerVibrateResponseParams((byte)0)).serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
    this.mMessageReceiver.accept((Message)serviceMessage);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\VibrationManager_Internal$VibrationManagerVibrateResponseParamsProxyToResponder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */