package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class TextDetection_Internal$TextDetectionDetectResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final TextDetection$DetectResponse mCallback;
  
  TextDetection_Internal$TextDetectionDetectResponseParamsForwardToCallback(TextDetection$DetectResponse paramTextDetection$DetectResponse) {
    this.mCallback = paramTextDetection$DetectResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(0, 2))
        return false; 
      TextDetection_Internal$TextDetectionDetectResponseParams textDetection_Internal$TextDetectionDetectResponseParams = TextDetection_Internal$TextDetectionDetectResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(textDetection_Internal$TextDetectionDetectResponseParams.results);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\TextDetection_Internal$TextDetectionDetectResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */