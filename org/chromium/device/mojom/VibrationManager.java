package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface VibrationManager extends Interface {
  public static final Interface.Manager MANAGER = VibrationManager_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void cancel(VibrationManager$CancelResponse paramVibrationManager$CancelResponse);
  
  void vibrate(long paramLong, VibrationManager$VibrateResponse paramVibrationManager$VibrateResponse);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\VibrationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */