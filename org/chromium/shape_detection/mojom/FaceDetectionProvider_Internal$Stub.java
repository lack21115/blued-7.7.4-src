package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class FaceDetectionProvider_Internal$Stub extends Interface.Stub {
  FaceDetectionProvider_Internal$Stub(Core paramCore, FaceDetectionProvider paramFaceDetectionProvider) {
    super(paramCore, paramFaceDetectionProvider);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        if (i != 0)
          return false; 
        faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams = FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.deserialize(serviceMessage.getPayload());
        ((FaceDetectionProvider)this.mImpl).createFaceDetection(faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.request, faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.options);
        return true;
      } 
      return InterfaceControlMessagesHelper.handleRunOrClosePipe(FaceDetectionProvider_Internal.MANAGER, (ServiceMessage)faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams);
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(1) ? false : ((messageHeader.mType != -1) ? false : InterfaceControlMessagesHelper.handleRun(this.mCore, FaceDetectionProvider_Internal.MANAGER, serviceMessage, paramMessageReceiver));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetectionProvider_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */