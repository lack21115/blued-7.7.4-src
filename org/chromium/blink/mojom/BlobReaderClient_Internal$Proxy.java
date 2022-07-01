package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class BlobReaderClient_Internal$Proxy extends Interface.AbstractProxy implements BlobReaderClient$Proxy {
  BlobReaderClient_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void onCalculatedSize(long paramLong1, long paramLong2) {
    BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams = new BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams((byte)0);
    blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.totalSize = paramLong1;
    blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.expectedContentSize = paramLong2;
    this.mHandler.mMessageReceiver.accept((Message)blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
  
  public final void onComplete(int paramInt, long paramLong) {
    BlobReaderClient_Internal$BlobReaderClientOnCompleteParams blobReaderClient_Internal$BlobReaderClientOnCompleteParams = new BlobReaderClient_Internal$BlobReaderClientOnCompleteParams((byte)0);
    blobReaderClient_Internal$BlobReaderClientOnCompleteParams.status = paramInt;
    blobReaderClient_Internal$BlobReaderClientOnCompleteParams.dataLength = paramLong;
    this.mHandler.mMessageReceiver.accept((Message)blobReaderClient_Internal$BlobReaderClientOnCompleteParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(1)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\BlobReaderClient_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */