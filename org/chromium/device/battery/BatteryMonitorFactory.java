package org.chromium.device.battery;

import java.util.HashSet;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.mojo.bindings.Interface;
import org.chromium.services.service_manager.InterfaceFactory;

public class BatteryMonitorFactory implements InterfaceFactory {
  private final BatteryStatusManager$BatteryStatusCallback mCallback = new BatteryMonitorFactory$1(this);
  
  final BatteryStatusManager mManager = new BatteryStatusManager(this.mCallback);
  
  final HashSet mSubscribedMonitors = new HashSet();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\battery\BatteryMonitorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */