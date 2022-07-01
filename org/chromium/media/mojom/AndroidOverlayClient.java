package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AndroidOverlayClient extends Interface {
  public static final Interface.Manager MANAGER = AndroidOverlayClient_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void onDestroyed();
  
  void onPowerEfficientState(boolean paramBoolean);
  
  void onSurfaceReady(long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */