package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface FaceDetectionProvider extends Interface {
  public static final Interface.Manager MANAGER = FaceDetectionProvider_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void createFaceDetection(InterfaceRequest paramInterfaceRequest, FaceDetectorOptions paramFaceDetectorOptions);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetectionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */