package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class Nfc_Internal$NfcPushResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final Nfc$PushResponse mCallback;
  
  Nfc_Internal$NfcPushResponseParamsForwardToCallback(Nfc$PushResponse paramNfc$PushResponse) {
    this.mCallback = paramNfc$PushResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(1, 2))
        return false; 
      Nfc_Internal$NfcPushResponseParams nfc_Internal$NfcPushResponseParams = Nfc_Internal$NfcPushResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(nfc_Internal$NfcPushResponseParams.error);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcPushResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */