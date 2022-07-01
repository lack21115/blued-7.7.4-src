package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class Nfc_Internal$NfcCancelPushResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final Nfc$CancelPushResponse mCallback;
  
  Nfc_Internal$NfcCancelPushResponseParamsForwardToCallback(Nfc$CancelPushResponse paramNfc$CancelPushResponse) {
    this.mCallback = paramNfc$CancelPushResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(2, 2))
        return false; 
      Nfc_Internal$NfcCancelPushResponseParams nfc_Internal$NfcCancelPushResponseParams = Nfc_Internal$NfcCancelPushResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(nfc_Internal$NfcCancelPushResponseParams.error);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcCancelPushResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */