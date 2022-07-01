package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class AndroidOverlay_Internal$Stub extends Interface.Stub {
  AndroidOverlay_Internal$Stub(Core paramCore, AndroidOverlay paramAndroidOverlay) {
    super(paramCore, paramAndroidOverlay);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams androidOverlay_Internal$AndroidOverlayScheduleLayoutParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        if (i != 0)
          return false; 
        androidOverlay_Internal$AndroidOverlayScheduleLayoutParams = AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams.deserialize(serviceMessage.getPayload());
        ((AndroidOverlay)this.mImpl).scheduleLayout(androidOverlay_Internal$AndroidOverlayScheduleLayoutParams.rect);
        return true;
      } 
      return InterfaceControlMessagesHelper.handleRunOrClosePipe(AndroidOverlay_Internal.MANAGER, (ServiceMessage)androidOverlay_Internal$AndroidOverlayScheduleLayoutParams);
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(1) ? false : ((messageHeader.mType != -1) ? false : InterfaceControlMessagesHelper.handleRun(this.mCore, AndroidOverlay_Internal.MANAGER, serviceMessage, paramMessageReceiver));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlay_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */