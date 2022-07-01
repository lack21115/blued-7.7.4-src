package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;

final class FaceDetection_Internal$FaceDetectionDetectResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
  private final FaceDetection$DetectResponse mCallback;
  
  FaceDetection_Internal$FaceDetectionDetectResponseParamsForwardToCallback(FaceDetection$DetectResponse paramFaceDetection$DetectResponse) {
    this.mCallback = paramFaceDetection$DetectResponse;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      if (!serviceMessage.mHeader.validateHeader(0, 2))
        return false; 
      FaceDetection_Internal$FaceDetectionDetectResponseParams faceDetection_Internal$FaceDetectionDetectResponseParams = FaceDetection_Internal$FaceDetectionDetectResponseParams.deserialize(serviceMessage.getPayload());
      this.mCallback.call(faceDetection_Internal$FaceDetectionDetectResponseParams.results);
      return true;
    } catch (DeserializationException deserializationException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetection_Internal$FaceDetectionDetectResponseParamsForwardToCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */