package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class BlobReaderClient_Internal$Stub extends Interface.Stub {
  BlobReaderClient_Internal$Stub(Core paramCore, BlobReaderClient paramBlobReaderClient) {
    super(paramCore, paramBlobReaderClient);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        BlobReaderClient_Internal$BlobReaderClientOnCompleteParams blobReaderClient_Internal$BlobReaderClientOnCompleteParams;
        switch (i) {
          case 1:
            blobReaderClient_Internal$BlobReaderClientOnCompleteParams = BlobReaderClient_Internal$BlobReaderClientOnCompleteParams.deserialize(serviceMessage.getPayload());
            ((BlobReaderClient)this.mImpl).onComplete(blobReaderClient_Internal$BlobReaderClientOnCompleteParams.status, blobReaderClient_Internal$BlobReaderClientOnCompleteParams.dataLength);
            return true;
          case 0:
            blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams = BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.deserialize(blobReaderClient_Internal$BlobReaderClientOnCompleteParams.getPayload());
            ((BlobReaderClient)this.mImpl).onCalculatedSize(blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.totalSize, blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.expectedContentSize);
            return true;
        } 
      } else {
        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BlobReaderClient_Internal.MANAGER, (ServiceMessage)blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(1) ? false : ((messageHeader.mType != -1) ? false : InterfaceControlMessagesHelper.handleRun(this.mCore, BlobReaderClient_Internal.MANAGER, serviceMessage, paramMessageReceiver));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\BlobReaderClient_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */