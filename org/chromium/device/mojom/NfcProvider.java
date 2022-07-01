package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface NfcProvider extends Interface {
  public static final Interface.Manager MANAGER = NfcProvider_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void getNfcForHost(int paramInt, InterfaceRequest paramInterfaceRequest);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */