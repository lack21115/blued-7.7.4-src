package org.chromium.services.service_manager;

import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.service_manager.mojom.InterfaceProvider;

public final class InterfaceRegistry implements InterfaceProvider {
  private final Map mBinders = new HashMap<Object, Object>();
  
  public static InterfaceRegistry create(MessagePipeHandle paramMessagePipeHandle) {
    InterfaceRegistry interfaceRegistry = new InterfaceRegistry();
    InterfaceProvider.MANAGER.bind((Interface)interfaceRegistry, paramMessagePipeHandle);
    return interfaceRegistry;
  }
  
  public final void addInterface(Interface.Manager paramManager, InterfaceFactory paramInterfaceFactory) {
    this.mBinders.put(paramManager.getName(), new InterfaceRegistry$InterfaceBinder(paramManager, paramInterfaceFactory));
  }
  
  public final void close() {
    this.mBinders.clear();
  }
  
  public final void getInterface(String paramString, MessagePipeHandle paramMessagePipeHandle) {
    InterfaceRegistry$InterfaceBinder interfaceRegistry$InterfaceBinder = (InterfaceRegistry$InterfaceBinder)this.mBinders.get(paramString);
    if (interfaceRegistry$InterfaceBinder == null)
      return; 
    Interface interface_ = interfaceRegistry$InterfaceBinder.mFactory.createImpl();
    if (interface_ == null) {
      paramMessagePipeHandle.close();
      return;
    } 
    interfaceRegistry$InterfaceBinder.mManager.bind(interface_, paramMessagePipeHandle);
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\services\service_manager\InterfaceRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */