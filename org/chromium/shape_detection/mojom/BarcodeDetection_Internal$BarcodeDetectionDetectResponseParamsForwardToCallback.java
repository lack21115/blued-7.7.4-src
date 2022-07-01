package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class BarcodeDetection_Internal$BarcodeDetectionDetectResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final BarcodeDetection$DetectResponse mCallback;
  
  BarcodeDetection_Internal$BarcodeDetectionDetectResponseParamsForwardToCallback(BarcodeDetection$DetectResponse paramBarcodeDetection$DetectResponse) {
    this.mCallback = paramBarcodeDetection$DetectResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(0, 2))
        return false; 
      BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams barcodeDetection_Internal$BarcodeDetectionDetectResponseParams = BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(barcodeDetection_Internal$BarcodeDetectionDetectResponseParams.results);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetection_Internal$BarcodeDetectionDetectResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */