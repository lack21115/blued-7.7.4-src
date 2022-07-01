package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final BatteryMonitor$QueryNextStatusResponse mCallback;
  
  BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParamsForwardToCallback(BatteryMonitor$QueryNextStatusResponse paramBatteryMonitor$QueryNextStatusResponse) {
    this.mCallback = paramBatteryMonitor$QueryNextStatusResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(0, 2))
        return false; 
      BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams batteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams = BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(batteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams.status);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */