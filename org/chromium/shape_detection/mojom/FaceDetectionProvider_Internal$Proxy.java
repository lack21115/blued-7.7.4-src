package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class FaceDetectionProvider_Internal$Proxy extends Interface.AbstractProxy implements FaceDetectionProvider$Proxy {
  FaceDetectionProvider_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void createFaceDetection(InterfaceRequest paramInterfaceRequest, FaceDetectorOptions paramFaceDetectorOptions) {
    FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams = new FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams((byte)0);
    faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.request = paramInterfaceRequest;
    faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.options = paramFaceDetectorOptions;
    this.mHandler.mMessageReceiver.accept((Message)faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetectionProvider_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */