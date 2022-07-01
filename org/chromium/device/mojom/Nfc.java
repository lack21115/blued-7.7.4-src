package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface Nfc extends Interface {
  public static final Interface.Manager MANAGER = Nfc_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void cancelAllWatches(Nfc$CancelAllWatchesResponse paramNfc$CancelAllWatchesResponse);
  
  void cancelPush(int paramInt, Nfc$CancelPushResponse paramNfc$CancelPushResponse);
  
  void cancelWatch(int paramInt, Nfc$CancelWatchResponse paramNfc$CancelWatchResponse);
  
  void push(NfcMessage paramNfcMessage, NfcPushOptions paramNfcPushOptions, Nfc$PushResponse paramNfc$PushResponse);
  
  void resumeNfcOperations();
  
  void setClient(NfcClient paramNfcClient);
  
  void suspendNfcOperations();
  
  void watch(NfcWatchOptions paramNfcWatchOptions, Nfc$WatchResponse paramNfc$WatchResponse);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */