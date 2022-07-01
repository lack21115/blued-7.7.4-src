package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface BarcodeDetectionProvider extends Interface {
  public static final Interface.Manager MANAGER = BarcodeDetectionProvider_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void createBarcodeDetection(InterfaceRequest paramInterfaceRequest, BarcodeDetectorOptions paramBarcodeDetectorOptions);
  
  void enumerateSupportedFormats(BarcodeDetectionProvider$EnumerateSupportedFormatsResponse paramBarcodeDetectionProvider$EnumerateSupportedFormatsResponse);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetectionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */