package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class Nfc_Internal$Proxy extends Interface.AbstractProxy implements Nfc$Proxy {
  Nfc_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void cancelAllWatches(Nfc$CancelAllWatchesResponse paramNfc$CancelAllWatchesResponse) {
    Nfc_Internal$NfcCancelAllWatchesParams nfc_Internal$NfcCancelAllWatchesParams = new Nfc_Internal$NfcCancelAllWatchesParams((byte)0);
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)nfc_Internal$NfcCancelAllWatchesParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(5, 1, 0L)), new Nfc_Internal$NfcCancelAllWatchesResponseParamsForwardToCallback(paramNfc$CancelAllWatchesResponse));
  }
  
  public final void cancelPush(int paramInt, Nfc$CancelPushResponse paramNfc$CancelPushResponse) {
    Nfc_Internal$NfcCancelPushParams nfc_Internal$NfcCancelPushParams = new Nfc_Internal$NfcCancelPushParams((byte)0);
    nfc_Internal$NfcCancelPushParams.target = paramInt;
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)nfc_Internal$NfcCancelPushParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(2, 1, 0L)), new Nfc_Internal$NfcCancelPushResponseParamsForwardToCallback(paramNfc$CancelPushResponse));
  }
  
  public final void cancelWatch(int paramInt, Nfc$CancelWatchResponse paramNfc$CancelWatchResponse) {
    Nfc_Internal$NfcCancelWatchParams nfc_Internal$NfcCancelWatchParams = new Nfc_Internal$NfcCancelWatchParams((byte)0);
    nfc_Internal$NfcCancelWatchParams.id = paramInt;
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)nfc_Internal$NfcCancelWatchParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(4, 1, 0L)), new Nfc_Internal$NfcCancelWatchResponseParamsForwardToCallback(paramNfc$CancelWatchResponse));
  }
  
  public final void push(NfcMessage paramNfcMessage, NfcPushOptions paramNfcPushOptions, Nfc$PushResponse paramNfc$PushResponse) {
    Nfc_Internal$NfcPushParams nfc_Internal$NfcPushParams = new Nfc_Internal$NfcPushParams((byte)0);
    nfc_Internal$NfcPushParams.message = paramNfcMessage;
    nfc_Internal$NfcPushParams.options = paramNfcPushOptions;
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)nfc_Internal$NfcPushParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(1, 1, 0L)), new Nfc_Internal$NfcPushResponseParamsForwardToCallback(paramNfc$PushResponse));
  }
  
  public final void resumeNfcOperations() {
    Nfc_Internal$NfcResumeNfcOperationsParams nfc_Internal$NfcResumeNfcOperationsParams = new Nfc_Internal$NfcResumeNfcOperationsParams((byte)0);
    this.mHandler.mMessageReceiver.accept((Message)nfc_Internal$NfcResumeNfcOperationsParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(7)));
  }
  
  public final void setClient(NfcClient paramNfcClient) {
    Nfc_Internal$NfcSetClientParams nfc_Internal$NfcSetClientParams = new Nfc_Internal$NfcSetClientParams((byte)0);
    nfc_Internal$NfcSetClientParams.client = paramNfcClient;
    this.mHandler.mMessageReceiver.accept((Message)nfc_Internal$NfcSetClientParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
  
  public final void suspendNfcOperations() {
    Nfc_Internal$NfcSuspendNfcOperationsParams nfc_Internal$NfcSuspendNfcOperationsParams = new Nfc_Internal$NfcSuspendNfcOperationsParams((byte)0);
    this.mHandler.mMessageReceiver.accept((Message)nfc_Internal$NfcSuspendNfcOperationsParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(6)));
  }
  
  public final void watch(NfcWatchOptions paramNfcWatchOptions, Nfc$WatchResponse paramNfc$WatchResponse) {
    Nfc_Internal$NfcWatchParams nfc_Internal$NfcWatchParams = new Nfc_Internal$NfcWatchParams((byte)0);
    nfc_Internal$NfcWatchParams.options = paramNfcWatchOptions;
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)nfc_Internal$NfcWatchParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(3, 1, 0L)), new Nfc_Internal$NfcWatchResponseParamsForwardToCallback(paramNfc$WatchResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */