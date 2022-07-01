package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;
import org.chromium.skia.mojom.Bitmap;

final class FaceDetection_Internal$Proxy extends Interface.AbstractProxy implements FaceDetection$Proxy {
  FaceDetection_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void detect(Bitmap paramBitmap, FaceDetection$DetectResponse paramFaceDetection$DetectResponse) {
    FaceDetection_Internal$FaceDetectionDetectParams faceDetection_Internal$FaceDetectionDetectParams = new FaceDetection_Internal$FaceDetectionDetectParams((byte)0);
    faceDetection_Internal$FaceDetectionDetectParams.bitmapData = paramBitmap;
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)faceDetection_Internal$FaceDetectionDetectParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0, 1, 0L)), new FaceDetection_Internal$FaceDetectionDetectResponseParamsForwardToCallback(paramFaceDetection$DetectResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetection_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */