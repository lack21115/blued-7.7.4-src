package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class Nfc_Internal$Stub extends Interface.Stub {
  Nfc_Internal$Stub(Core paramCore, Nfc paramNfc) {
    super(paramCore, paramNfc);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      Nfc_Internal$NfcSetClientParams nfc_Internal$NfcSetClientParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        if (i != 0) {
          switch (i) {
            case 7:
              Nfc_Internal$NfcResumeNfcOperationsParams.deserialize(serviceMessage.getPayload());
              ((Nfc)this.mImpl).resumeNfcOperations();
              return true;
            case 6:
              Nfc_Internal$NfcSuspendNfcOperationsParams.deserialize(serviceMessage.getPayload());
              ((Nfc)this.mImpl).suspendNfcOperations();
              return true;
          } 
        } else {
          nfc_Internal$NfcSetClientParams = Nfc_Internal$NfcSetClientParams.deserialize(serviceMessage.getPayload());
          ((Nfc)this.mImpl).setClient(nfc_Internal$NfcSetClientParams.client);
          return true;
        } 
      } else {
        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Nfc_Internal.MANAGER, (ServiceMessage)nfc_Internal$NfcSetClientParams);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      Nfc_Internal$NfcPushParams nfc_Internal$NfcPushParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(1))
        return false; 
      int i = messageHeader.mType;
      if (i != -1) {
        Nfc_Internal$NfcCancelWatchParams nfc_Internal$NfcCancelWatchParams;
        Nfc_Internal$NfcWatchParams nfc_Internal$NfcWatchParams;
        Nfc_Internal$NfcCancelPushParams nfc_Internal$NfcCancelPushParams;
        switch (i) {
          case 5:
            Nfc_Internal$NfcCancelAllWatchesParams.deserialize(serviceMessage.getPayload());
            ((Nfc)this.mImpl).cancelAllWatches(new Nfc_Internal$NfcCancelAllWatchesResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
            return true;
          case 4:
            nfc_Internal$NfcCancelWatchParams = Nfc_Internal$NfcCancelWatchParams.deserialize(serviceMessage.getPayload());
            ((Nfc)this.mImpl).cancelWatch(nfc_Internal$NfcCancelWatchParams.id, new Nfc_Internal$NfcCancelWatchResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
            return true;
          case 3:
            nfc_Internal$NfcWatchParams = Nfc_Internal$NfcWatchParams.deserialize(nfc_Internal$NfcCancelWatchParams.getPayload());
            ((Nfc)this.mImpl).watch(nfc_Internal$NfcWatchParams.options, new Nfc_Internal$NfcWatchResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
            return true;
          case 2:
            nfc_Internal$NfcCancelPushParams = Nfc_Internal$NfcCancelPushParams.deserialize(nfc_Internal$NfcWatchParams.getPayload());
            ((Nfc)this.mImpl).cancelPush(nfc_Internal$NfcCancelPushParams.target, new Nfc_Internal$NfcCancelPushResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
            return true;
          case 1:
            nfc_Internal$NfcPushParams = Nfc_Internal$NfcPushParams.deserialize(nfc_Internal$NfcCancelPushParams.getPayload());
            ((Nfc)this.mImpl).push(nfc_Internal$NfcPushParams.message, nfc_Internal$NfcPushParams.options, new Nfc_Internal$NfcPushResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
            return true;
        } 
      } else {
        return InterfaceControlMessagesHelper.handleRun(this.mCore, Nfc_Internal.MANAGER, (ServiceMessage)nfc_Internal$NfcPushParams, paramMessageReceiver);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */