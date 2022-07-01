package org.chromium.services.service_manager;

import org.chromium.mojo.bindings.ConnectionErrorHandler;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;

public final class InterfaceProvider implements ConnectionErrorHandler {
  private org.chromium.service_manager.mojom.InterfaceProvider.Proxy mInterfaceProvider;
  
  public InterfaceProvider(MessagePipeHandle paramMessagePipeHandle) {
    this.mInterfaceProvider = (org.chromium.service_manager.mojom.InterfaceProvider.Proxy)org.chromium.service_manager.mojom.InterfaceProvider.MANAGER.attachProxy(paramMessagePipeHandle, 0);
    this.mInterfaceProvider.getProxyHandler().setErrorHandler(this);
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    this.mInterfaceProvider.close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\services\service_manager\InterfaceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */