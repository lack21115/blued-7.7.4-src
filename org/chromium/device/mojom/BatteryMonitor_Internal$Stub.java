package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class BatteryMonitor_Internal$Stub extends Interface.Stub {
  BatteryMonitor_Internal$Stub(Core paramCore, BatteryMonitor paramBatteryMonitor) {
    super(paramCore, paramBatteryMonitor);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(0) ? false : ((messageHeader.mType != -2) ? false : InterfaceControlMessagesHelper.handleRunOrClosePipe(BatteryMonitor_Internal.MANAGER, serviceMessage));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(1))
        return false; 
      switch (messageHeader.mType) {
        case 0:
          BatteryMonitor_Internal$BatteryMonitorQueryNextStatusParams.deserialize(serviceMessage.getPayload());
          ((BatteryMonitor)this.mImpl).queryNextStatus(new BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
          return true;
        case -1:
          return InterfaceControlMessagesHelper.handleRun(this.mCore, BatteryMonitor_Internal.MANAGER, serviceMessage, paramMessageReceiver);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\BatteryMonitor_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */