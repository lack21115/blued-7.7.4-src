package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class BarcodeDetectionProvider_Internal$Stub extends Interface.Stub {
  BarcodeDetectionProvider_Internal$Stub(Core paramCore, BarcodeDetectionProvider paramBarcodeDetectionProvider) {
    super(paramCore, paramBarcodeDetectionProvider);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        if (i != 0)
          return false; 
        barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams = BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.deserialize(serviceMessage.getPayload());
        ((BarcodeDetectionProvider)this.mImpl).createBarcodeDetection(barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.request, barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.options);
        return true;
      } 
      return InterfaceControlMessagesHelper.handleRunOrClosePipe(BarcodeDetectionProvider_Internal.MANAGER, (ServiceMessage)barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams);
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(1))
        return false; 
      int i = messageHeader.mType;
      if (i != -1) {
        if (i != 1)
          return false; 
        BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsParams.deserialize(serviceMessage.getPayload());
        ((BarcodeDetectionProvider)this.mImpl).enumerateSupportedFormats(new BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
        return true;
      } 
      return InterfaceControlMessagesHelper.handleRun(this.mCore, BarcodeDetectionProvider_Internal.MANAGER, serviceMessage, paramMessageReceiver);
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetectionProvider_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */