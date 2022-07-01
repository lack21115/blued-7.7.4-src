package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class VibrationManager_Internal$Stub extends Interface.Stub {
  VibrationManager_Internal$Stub(Core paramCore, VibrationManager paramVibrationManager) {
    super(paramCore, paramVibrationManager);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(0) ? false : ((messageHeader.mType != -2) ? false : InterfaceControlMessagesHelper.handleRunOrClosePipe(VibrationManager_Internal.MANAGER, serviceMessage));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      VibrationManager_Internal$VibrationManagerVibrateParams vibrationManager_Internal$VibrationManagerVibrateParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(1))
        return false; 
      switch (messageHeader.mType) {
        case 1:
          VibrationManager_Internal$VibrationManagerCancelParams.deserialize(serviceMessage.getPayload());
          ((VibrationManager)this.mImpl).cancel(new VibrationManager_Internal$VibrationManagerCancelResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
          return true;
        case 0:
          vibrationManager_Internal$VibrationManagerVibrateParams = VibrationManager_Internal$VibrationManagerVibrateParams.deserialize(serviceMessage.getPayload());
          ((VibrationManager)this.mImpl).vibrate(vibrationManager_Internal$VibrationManagerVibrateParams.milliseconds, new VibrationManager_Internal$VibrationManagerVibrateResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
          return true;
        case -1:
          return InterfaceControlMessagesHelper.handleRun(this.mCore, VibrationManager_Internal.MANAGER, (ServiceMessage)vibrationManager_Internal$VibrationManagerVibrateParams, paramMessageReceiver);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\VibrationManager_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */