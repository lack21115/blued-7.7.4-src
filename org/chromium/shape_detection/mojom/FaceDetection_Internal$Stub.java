package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class FaceDetection_Internal$Stub extends Interface.Stub {
  FaceDetection_Internal$Stub(Core paramCore, FaceDetection paramFaceDetection) {
    super(paramCore, paramFaceDetection);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(0) ? false : ((messageHeader.mType != -2) ? false : InterfaceControlMessagesHelper.handleRunOrClosePipe(FaceDetection_Internal.MANAGER, serviceMessage));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      FaceDetection_Internal$FaceDetectionDetectParams faceDetection_Internal$FaceDetectionDetectParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(1))
        return false; 
      switch (messageHeader.mType) {
        case 0:
          faceDetection_Internal$FaceDetectionDetectParams = FaceDetection_Internal$FaceDetectionDetectParams.deserialize(serviceMessage.getPayload());
          ((FaceDetection)this.mImpl).detect(faceDetection_Internal$FaceDetectionDetectParams.bitmapData, new FaceDetection_Internal$FaceDetectionDetectResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
          return true;
        case -1:
          return InterfaceControlMessagesHelper.handleRun(this.mCore, FaceDetection_Internal.MANAGER, (ServiceMessage)faceDetection_Internal$FaceDetectionDetectParams, paramMessageReceiver);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetection_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */