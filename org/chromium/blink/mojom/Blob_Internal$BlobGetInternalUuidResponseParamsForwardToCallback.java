package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class Blob_Internal$BlobGetInternalUuidResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final Blob$GetInternalUuidResponse mCallback;
  
  Blob_Internal$BlobGetInternalUuidResponseParamsForwardToCallback(Blob$GetInternalUuidResponse paramBlob$GetInternalUuidResponse) {
    this.mCallback = paramBlob$GetInternalUuidResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(5, 2))
        return false; 
      Blob_Internal$BlobGetInternalUuidResponseParams blob_Internal$BlobGetInternalUuidResponseParams = Blob_Internal$BlobGetInternalUuidResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(blob_Internal$BlobGetInternalUuidResponseParams.uuid);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob_Internal$BlobGetInternalUuidResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */