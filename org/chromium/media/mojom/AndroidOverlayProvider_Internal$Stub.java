package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class AndroidOverlayProvider_Internal$Stub extends Interface.Stub {
  AndroidOverlayProvider_Internal$Stub(Core paramCore, AndroidOverlayProvider paramAndroidOverlayProvider) {
    super(paramCore, paramAndroidOverlayProvider);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        if (i != 0)
          return false; 
        androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams = AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.deserialize(serviceMessage.getPayload());
        ((AndroidOverlayProvider)this.mImpl).createOverlay(androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.overlay, androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.client, androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.config);
        return true;
      } 
      return InterfaceControlMessagesHelper.handleRunOrClosePipe(AndroidOverlayProvider_Internal.MANAGER, (ServiceMessage)androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams);
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(1) ? false : ((messageHeader.mType != -1) ? false : InterfaceControlMessagesHelper.handleRun(this.mCore, AndroidOverlayProvider_Internal.MANAGER, serviceMessage, paramMessageReceiver));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayProvider_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */