package org.chromium.shape_detection;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.BarcodeDetection;
import org.chromium.shape_detection.mojom.BarcodeDetectionProvider;
import org.chromium.shape_detection.mojom.BarcodeDetectorOptions;

public final class BarcodeDetectionProviderImpl implements BarcodeDetectionProvider {
  public final void close() {}
  
  public final void createBarcodeDetection(InterfaceRequest paramInterfaceRequest, BarcodeDetectorOptions paramBarcodeDetectorOptions) {
    BarcodeDetection.MANAGER.bind((Interface)new BarcodeDetectionImpl(), paramInterfaceRequest);
  }
  
  public final void enumerateSupportedFormats(BarcodeDetectionProvider.EnumerateSupportedFormatsResponse paramEnumerateSupportedFormatsResponse) {
    paramEnumerateSupportedFormatsResponse.call(new int[] { 
          4096, 1, 2, 4, 8, 16, 32, 64, 128, 2048, 
          256, 512, 1024 });
  }
  
  public final void onConnectionError(MojoException paramMojoException) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\BarcodeDetectionProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */