package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class NfcProvider_Internal$Proxy extends Interface.AbstractProxy implements NfcProvider$Proxy {
  NfcProvider_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void getNfcForHost(int paramInt, InterfaceRequest paramInterfaceRequest) {
    NfcProvider_Internal$NfcProviderGetNfcForHostParams nfcProvider_Internal$NfcProviderGetNfcForHostParams = new NfcProvider_Internal$NfcProviderGetNfcForHostParams((byte)0);
    nfcProvider_Internal$NfcProviderGetNfcForHostParams.hostId = paramInt;
    nfcProvider_Internal$NfcProviderGetNfcForHostParams.nfc = paramInterfaceRequest;
    this.mHandler.mMessageReceiver.accept((Message)nfcProvider_Internal$NfcProviderGetNfcForHostParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcProvider_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */