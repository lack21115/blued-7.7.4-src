package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface BatteryMonitor extends Interface {
  public static final Interface.Manager MANAGER = BatteryMonitor_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void queryNextStatus(BatteryMonitor$QueryNextStatusResponse paramBatteryMonitor$QueryNextStatusResponse);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\BatteryMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */