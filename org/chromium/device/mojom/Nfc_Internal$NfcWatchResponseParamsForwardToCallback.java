package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class Nfc_Internal$NfcWatchResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final Nfc$WatchResponse mCallback;
  
  Nfc_Internal$NfcWatchResponseParamsForwardToCallback(Nfc$WatchResponse paramNfc$WatchResponse) {
    this.mCallback = paramNfc$WatchResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(3, 2))
        return false; 
      Nfc_Internal$NfcWatchResponseParams nfc_Internal$NfcWatchResponseParams = Nfc_Internal$NfcWatchResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(Integer.valueOf(nfc_Internal$NfcWatchResponseParams.id), nfc_Internal$NfcWatchResponseParams.error);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcWatchResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */