package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.system.Core;

final class Nfc_Internal$NfcCancelAllWatchesResponseParamsProxyToResponder implements Nfc$CancelAllWatchesResponse {
  private final Core mCore;
  
  private final MessageReceiver mMessageReceiver;
  
  private final long mRequestId;
  
  Nfc_Internal$NfcCancelAllWatchesResponseParamsProxyToResponder(Core paramCore, MessageReceiver paramMessageReceiver, long paramLong) {
    this.mCore = paramCore;
    this.mMessageReceiver = paramMessageReceiver;
    this.mRequestId = paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcCancelAllWatchesResponseParamsProxyToResponder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */