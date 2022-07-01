package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class NfcClient_Internal$Stub extends Interface.Stub {
  NfcClient_Internal$Stub(Core paramCore, NfcClient paramNfcClient) {
    super(paramCore, paramNfcClient);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      NfcClient_Internal$NfcClientOnWatchParams nfcClient_Internal$NfcClientOnWatchParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        if (i != 0)
          return false; 
        nfcClient_Internal$NfcClientOnWatchParams = NfcClient_Internal$NfcClientOnWatchParams.deserialize(serviceMessage.getPayload());
        ((NfcClient)this.mImpl).onWatch(nfcClient_Internal$NfcClientOnWatchParams.watchIds, nfcClient_Internal$NfcClientOnWatchParams.message);
        return true;
      } 
      return InterfaceControlMessagesHelper.handleRunOrClosePipe(NfcClient_Internal.MANAGER, (ServiceMessage)nfcClient_Internal$NfcClientOnWatchParams);
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(1) ? false : ((messageHeader.mType != -1) ? false : InterfaceControlMessagesHelper.handleRun(this.mCore, NfcClient_Internal.MANAGER, serviceMessage, paramMessageReceiver));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcClient_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */