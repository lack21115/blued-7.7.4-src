package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.Bitmap;

public interface BarcodeDetection extends Interface {
  public static final Interface.Manager MANAGER = BarcodeDetection_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void detect(Bitmap paramBitmap, BarcodeDetection$DetectResponse paramBarcodeDetection$DetectResponse);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */