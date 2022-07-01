package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;
import org.chromium.skia.mojom.Bitmap;

final class TextDetection_Internal$Proxy extends Interface.AbstractProxy implements TextDetection$Proxy {
  TextDetection_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void detect(Bitmap paramBitmap, TextDetection$DetectResponse paramTextDetection$DetectResponse) {
    TextDetection_Internal$TextDetectionDetectParams textDetection_Internal$TextDetectionDetectParams = new TextDetection_Internal$TextDetectionDetectParams((byte)0);
    textDetection_Internal$TextDetectionDetectParams.bitmapData = paramBitmap;
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)textDetection_Internal$TextDetectionDetectParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0, 1, 0L)), new TextDetection_Internal$TextDetectionDetectResponseParamsForwardToCallback(paramTextDetection$DetectResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\TextDetection_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */