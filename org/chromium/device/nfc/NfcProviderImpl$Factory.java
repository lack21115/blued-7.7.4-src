package org.chromium.device.nfc;

import org.chromium.mojo.bindings.Interface;
import org.chromium.services.service_manager.InterfaceFactory;

public final class NfcProviderImpl$Factory implements InterfaceFactory {
  private NfcDelegate mDelegate;
  
  public NfcProviderImpl$Factory(NfcDelegate paramNfcDelegate) {
    this.mDelegate = paramNfcDelegate;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcProviderImpl$Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */