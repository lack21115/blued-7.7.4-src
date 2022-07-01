package org.chromium.shape_detection;

import com.google.android.gms.common.GoogleApiAvailability;
import org.chromium.base.ContextUtils;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.FaceDetection;
import org.chromium.shape_detection.mojom.FaceDetectionProvider;
import org.chromium.shape_detection.mojom.FaceDetectorOptions;

public final class FaceDetectionProviderImpl implements FaceDetectionProvider {
  public final void close() {}
  
  public final void createFaceDetection(InterfaceRequest paramInterfaceRequest, FaceDetectorOptions paramFaceDetectorOptions) {
    boolean bool;
    if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ContextUtils.sApplicationContext) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      FaceDetection.MANAGER.bind((Interface)new FaceDetectionImplGmsCore(paramFaceDetectorOptions), paramInterfaceRequest);
      return;
    } 
    FaceDetection.MANAGER.bind((Interface)new FaceDetectionImpl(paramFaceDetectorOptions), paramInterfaceRequest);
  }
  
  public final void onConnectionError(MojoException paramMojoException) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\FaceDetectionProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */