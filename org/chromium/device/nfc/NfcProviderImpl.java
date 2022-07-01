package org.chromium.device.nfc;

import org.chromium.device.mojom.Nfc;
import org.chromium.device.mojom.NfcProvider;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MojoException;

public final class NfcProviderImpl implements NfcProvider {
  private NfcDelegate mDelegate;
  
  public NfcProviderImpl(NfcDelegate paramNfcDelegate) {
    this.mDelegate = paramNfcDelegate;
  }
  
  public final void close() {}
  
  public final void getNfcForHost(int paramInt, InterfaceRequest paramInterfaceRequest) {
    Nfc.MANAGER.bind((Interface)new NfcImpl(paramInt, this.mDelegate), paramInterfaceRequest);
  }
  
  public final void onConnectionError(MojoException paramMojoException) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */