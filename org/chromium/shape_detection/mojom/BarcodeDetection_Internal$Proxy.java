package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;
import org.chromium.skia.mojom.Bitmap;

final class BarcodeDetection_Internal$Proxy extends Interface.AbstractProxy implements BarcodeDetection$Proxy {
  BarcodeDetection_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void detect(Bitmap paramBitmap, BarcodeDetection$DetectResponse paramBarcodeDetection$DetectResponse) {
    BarcodeDetection_Internal$BarcodeDetectionDetectParams barcodeDetection_Internal$BarcodeDetectionDetectParams = new BarcodeDetection_Internal$BarcodeDetectionDetectParams((byte)0);
    barcodeDetection_Internal$BarcodeDetectionDetectParams.bitmapData = paramBitmap;
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)barcodeDetection_Internal$BarcodeDetectionDetectParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0, 1, 0L)), new BarcodeDetection_Internal$BarcodeDetectionDetectResponseParamsForwardToCallback(paramBarcodeDetection$DetectResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetection_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */