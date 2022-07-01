package org.chromium.shape_detection;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.services.service_manager.InterfaceRegistry;
import org.chromium.shape_detection.mojom.BarcodeDetectionProvider;
import org.chromium.shape_detection.mojom.FaceDetectionProvider;
import org.chromium.shape_detection.mojom.TextDetection;

class InterfaceRegistrar {
  @CalledByNative
  static void createInterfaceRegistryForContext(int paramInt) {
    InterfaceRegistry interfaceRegistry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(paramInt).toMessagePipeHandle());
    interfaceRegistry.addInterface(BarcodeDetectionProvider.MANAGER, new BarcodeDetectionProviderImpl$Factory());
    interfaceRegistry.addInterface(FaceDetectionProvider.MANAGER, new FaceDetectionProviderImpl$Factory());
    interfaceRegistry.addInterface(TextDetection.MANAGER, new TextDetectionImpl$Factory());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\InterfaceRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */