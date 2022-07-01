package org.chromium.device.nfc;

import org.chromium.device.mojom.Nfc;
import org.chromium.device.mojom.NfcError;
import org.chromium.device.mojom.NfcMessage;
import org.chromium.device.mojom.NfcPushOptions;

final class NfcImpl$PendingPushOperation {
  private final Nfc.PushResponse mPushResponseCallback;
  
  public final NfcMessage nfcMessage;
  
  public final NfcPushOptions nfcPushOptions;
  
  public NfcImpl$PendingPushOperation(NfcMessage paramNfcMessage, NfcPushOptions paramNfcPushOptions, Nfc.PushResponse paramPushResponse) {
    this.nfcMessage = paramNfcMessage;
    this.nfcPushOptions = paramNfcPushOptions;
    this.mPushResponseCallback = paramPushResponse;
  }
  
  public final void complete(NfcError paramNfcError) {
    if (this.mPushResponseCallback != null)
      this.mPushResponseCallback.call(paramNfcError); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcImpl$PendingPushOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */