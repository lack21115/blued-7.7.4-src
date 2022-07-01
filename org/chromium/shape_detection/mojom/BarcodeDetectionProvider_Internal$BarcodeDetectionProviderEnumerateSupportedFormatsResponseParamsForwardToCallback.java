package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final BarcodeDetectionProvider$EnumerateSupportedFormatsResponse mCallback;
  
  BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsForwardToCallback(BarcodeDetectionProvider$EnumerateSupportedFormatsResponse paramBarcodeDetectionProvider$EnumerateSupportedFormatsResponse) {
    this.mCallback = paramBarcodeDetectionProvider$EnumerateSupportedFormatsResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(1, 2))
        return false; 
      BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams barcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams = BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(barcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams.supportedFormats);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */