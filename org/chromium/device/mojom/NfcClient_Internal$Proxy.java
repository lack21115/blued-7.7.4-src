package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class NfcClient_Internal$Proxy extends Interface.AbstractProxy implements NfcClient$Proxy {
  NfcClient_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void onWatch(int[] paramArrayOfint, NfcMessage paramNfcMessage) {
    NfcClient_Internal$NfcClientOnWatchParams nfcClient_Internal$NfcClientOnWatchParams = new NfcClient_Internal$NfcClientOnWatchParams((byte)0);
    nfcClient_Internal$NfcClientOnWatchParams.watchIds = paramArrayOfint;
    nfcClient_Internal$NfcClientOnWatchParams.message = paramNfcMessage;
    this.mHandler.mMessageReceiver.accept((Message)nfcClient_Internal$NfcClientOnWatchParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcClient_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */