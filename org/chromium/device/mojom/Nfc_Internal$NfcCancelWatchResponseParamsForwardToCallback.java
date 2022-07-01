package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class Nfc_Internal$NfcCancelWatchResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final Nfc$CancelWatchResponse mCallback;
  
  Nfc_Internal$NfcCancelWatchResponseParamsForwardToCallback(Nfc$CancelWatchResponse paramNfc$CancelWatchResponse) {
    this.mCallback = paramNfc$CancelWatchResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(4, 2))
        return false; 
      Nfc_Internal$NfcCancelWatchResponseParams nfc_Internal$NfcCancelWatchResponseParams = Nfc_Internal$NfcCancelWatchResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(nfc_Internal$NfcCancelWatchResponseParams.error);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcCancelWatchResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */