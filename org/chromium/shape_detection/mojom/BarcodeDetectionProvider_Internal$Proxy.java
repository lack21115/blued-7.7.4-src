package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class BarcodeDetectionProvider_Internal$Proxy extends Interface.AbstractProxy implements BarcodeDetectionProvider$Proxy {
  BarcodeDetectionProvider_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void createBarcodeDetection(InterfaceRequest paramInterfaceRequest, BarcodeDetectorOptions paramBarcodeDetectorOptions) {
    BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams = new BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams((byte)0);
    barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.request = paramInterfaceRequest;
    barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.options = paramBarcodeDetectorOptions;
    this.mHandler.mMessageReceiver.accept((Message)barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
  
  public final void enumerateSupportedFormats(BarcodeDetectionProvider$EnumerateSupportedFormatsResponse paramBarcodeDetectionProvider$EnumerateSupportedFormatsResponse) {
    BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsParams barcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsParams = new BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsParams((byte)0);
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)barcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(1, 1, 0L)), new BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsForwardToCallback(paramBarcodeDetectionProvider$EnumerateSupportedFormatsResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetectionProvider_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */