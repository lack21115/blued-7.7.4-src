package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class Blob_Internal$BlobReadSideDataResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final Blob$ReadSideDataResponse mCallback;
  
  Blob_Internal$BlobReadSideDataResponseParamsForwardToCallback(Blob$ReadSideDataResponse paramBlob$ReadSideDataResponse) {
    this.mCallback = paramBlob$ReadSideDataResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(4, 2))
        return false; 
      Blob_Internal$BlobReadSideDataResponseParams blob_Internal$BlobReadSideDataResponseParams = Blob_Internal$BlobReadSideDataResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(blob_Internal$BlobReadSideDataResponseParams.data);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob_Internal$BlobReadSideDataResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */