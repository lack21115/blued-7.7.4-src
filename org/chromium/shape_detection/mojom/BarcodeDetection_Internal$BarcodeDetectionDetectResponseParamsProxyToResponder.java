package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.system.Core;

final class BarcodeDetection_Internal$BarcodeDetectionDetectResponseParamsProxyToResponder implements BarcodeDetection$DetectResponse {
  private final Core mCore;
  
  private final MessageReceiver mMessageReceiver;
  
  private final long mRequestId;
  
  BarcodeDetection_Internal$BarcodeDetectionDetectResponseParamsProxyToResponder(Core paramCore, MessageReceiver paramMessageReceiver, long paramLong) {
    this.mCore = paramCore;
    this.mMessageReceiver = paramMessageReceiver;
    this.mRequestId = paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetection_Internal$BarcodeDetectionDetectResponseParamsProxyToResponder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */