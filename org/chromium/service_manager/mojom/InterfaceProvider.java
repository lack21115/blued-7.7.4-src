package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.MessagePipeHandle;

public interface InterfaceProvider extends Interface {
  public static final Interface.Manager MANAGER = InterfaceProvider_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void getInterface(String paramString, MessagePipeHandle paramMessagePipeHandle);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\service_manager\mojom\InterfaceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */