package org.chromium.services.device;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.device.battery.BatteryMonitorFactory;
import org.chromium.device.mojom.BatteryMonitor;
import org.chromium.device.mojom.NfcProvider;
import org.chromium.device.mojom.VibrationManager;
import org.chromium.device.nfc.NfcDelegate;
import org.chromium.device.nfc.NfcProviderImpl;
import org.chromium.device.vibration.VibrationManagerImpl;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.services.service_manager.InterfaceFactory;
import org.chromium.services.service_manager.InterfaceRegistry;

class InterfaceRegistrar {
  @CalledByNative
  static void createInterfaceRegistryForContext(int paramInt, NfcDelegate paramNfcDelegate) {
    InterfaceRegistry interfaceRegistry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(paramInt).toMessagePipeHandle());
    interfaceRegistry.addInterface(BatteryMonitor.MANAGER, (InterfaceFactory)new BatteryMonitorFactory());
    interfaceRegistry.addInterface(NfcProvider.MANAGER, (InterfaceFactory)new NfcProviderImpl.Factory(paramNfcDelegate));
    interfaceRegistry.addInterface(VibrationManager.MANAGER, (InterfaceFactory)new VibrationManagerImpl.Factory());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\services\device\InterfaceRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */