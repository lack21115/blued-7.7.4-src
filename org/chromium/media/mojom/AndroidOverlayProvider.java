package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface AndroidOverlayProvider extends Interface {
  public static final Interface.Manager MANAGER = AndroidOverlayProvider_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void createOverlay(InterfaceRequest paramInterfaceRequest, AndroidOverlayClient paramAndroidOverlayClient, AndroidOverlayConfig paramAndroidOverlayConfig);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */