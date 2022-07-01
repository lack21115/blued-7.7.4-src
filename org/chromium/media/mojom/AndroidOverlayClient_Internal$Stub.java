package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class AndroidOverlayClient_Internal$Stub extends Interface.Stub {
  AndroidOverlayClient_Internal$Stub(Core paramCore, AndroidOverlayClient paramAndroidOverlayClient) {
    super(paramCore, paramAndroidOverlayClient);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams;
        switch (i) {
          case 2:
            androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams = AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams.deserialize(serviceMessage.getPayload());
            ((AndroidOverlayClient)this.mImpl).onPowerEfficientState(androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams.isPowerEfficient);
            return true;
          case 1:
            AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams.deserialize(androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams.getPayload());
            ((AndroidOverlayClient)this.mImpl).onDestroyed();
            return true;
          case 0:
            androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams = AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams.deserialize(androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams.getPayload());
            ((AndroidOverlayClient)this.mImpl).onSurfaceReady(androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams.surfaceKey);
            return true;
        } 
      } else {
        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AndroidOverlayClient_Internal.MANAGER, (ServiceMessage)androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(1) ? false : ((messageHeader.mType != -1) ? false : InterfaceControlMessagesHelper.handleRun(this.mCore, AndroidOverlayClient_Internal.MANAGER, serviceMessage, paramMessageReceiver));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayClient_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */