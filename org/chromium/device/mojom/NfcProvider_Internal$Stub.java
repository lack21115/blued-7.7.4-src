package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class NfcProvider_Internal$Stub extends Interface.Stub {
  NfcProvider_Internal$Stub(Core paramCore, NfcProvider paramNfcProvider) {
    super(paramCore, paramNfcProvider);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      NfcProvider_Internal$NfcProviderGetNfcForHostParams nfcProvider_Internal$NfcProviderGetNfcForHostParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        if (i != 0)
          return false; 
        nfcProvider_Internal$NfcProviderGetNfcForHostParams = NfcProvider_Internal$NfcProviderGetNfcForHostParams.deserialize(serviceMessage.getPayload());
        ((NfcProvider)this.mImpl).getNfcForHost(nfcProvider_Internal$NfcProviderGetNfcForHostParams.hostId, nfcProvider_Internal$NfcProviderGetNfcForHostParams.nfc);
        return true;
      } 
      return InterfaceControlMessagesHelper.handleRunOrClosePipe(NfcProvider_Internal.MANAGER, (ServiceMessage)nfcProvider_Internal$NfcProviderGetNfcForHostParams);
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(1) ? false : ((messageHeader.mType != -1) ? false : InterfaceControlMessagesHelper.handleRun(this.mCore, NfcProvider_Internal.MANAGER, serviceMessage, paramMessageReceiver));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcProvider_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */