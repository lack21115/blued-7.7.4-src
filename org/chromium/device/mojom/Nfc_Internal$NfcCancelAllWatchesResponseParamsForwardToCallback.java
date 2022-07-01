package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class Nfc_Internal$NfcCancelAllWatchesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final Nfc$CancelAllWatchesResponse mCallback;
  
  Nfc_Internal$NfcCancelAllWatchesResponseParamsForwardToCallback(Nfc$CancelAllWatchesResponse paramNfc$CancelAllWatchesResponse) {
    this.mCallback = paramNfc$CancelAllWatchesResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(5, 2))
        return false; 
      Nfc_Internal$NfcCancelAllWatchesResponseParams nfc_Internal$NfcCancelAllWatchesResponseParams = Nfc_Internal$NfcCancelAllWatchesResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(nfc_Internal$NfcCancelAllWatchesResponseParams.error);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcCancelAllWatchesResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */