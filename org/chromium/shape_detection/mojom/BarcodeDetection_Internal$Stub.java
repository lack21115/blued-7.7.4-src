package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class BarcodeDetection_Internal$Stub extends Interface.Stub {
  BarcodeDetection_Internal$Stub(Core paramCore, BarcodeDetection paramBarcodeDetection) {
    super(paramCore, paramBarcodeDetection);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(0) ? false : ((messageHeader.mType != -2) ? false : InterfaceControlMessagesHelper.handleRunOrClosePipe(BarcodeDetection_Internal.MANAGER, serviceMessage));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      BarcodeDetection_Internal$BarcodeDetectionDetectParams barcodeDetection_Internal$BarcodeDetectionDetectParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(1))
        return false; 
      switch (messageHeader.mType) {
        case 0:
          barcodeDetection_Internal$BarcodeDetectionDetectParams = BarcodeDetection_Internal$BarcodeDetectionDetectParams.deserialize(serviceMessage.getPayload());
          ((BarcodeDetection)this.mImpl).detect(barcodeDetection_Internal$BarcodeDetectionDetectParams.bitmapData, new BarcodeDetection_Internal$BarcodeDetectionDetectResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
          return true;
        case -1:
          return InterfaceControlMessagesHelper.handleRun(this.mCore, BarcodeDetection_Internal.MANAGER, (ServiceMessage)barcodeDetection_Internal$BarcodeDetectionDetectParams, paramMessageReceiver);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetection_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */