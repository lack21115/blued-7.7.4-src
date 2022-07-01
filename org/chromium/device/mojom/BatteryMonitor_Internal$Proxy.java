package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class BatteryMonitor_Internal$Proxy extends Interface.AbstractProxy implements BatteryMonitor$Proxy {
  BatteryMonitor_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void queryNextStatus(BatteryMonitor$QueryNextStatusResponse paramBatteryMonitor$QueryNextStatusResponse) {
    BatteryMonitor_Internal$BatteryMonitorQueryNextStatusParams batteryMonitor_Internal$BatteryMonitorQueryNextStatusParams = new BatteryMonitor_Internal$BatteryMonitorQueryNextStatusParams((byte)0);
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)batteryMonitor_Internal$BatteryMonitorQueryNextStatusParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0, 1, 0L)), new BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParamsForwardToCallback(paramBatteryMonitor$QueryNextStatusResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\BatteryMonitor_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */