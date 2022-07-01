package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class Blob_Internal$Stub extends Interface.Stub {
  Blob_Internal$Stub(Core paramCore, Blob paramBlob) {
    super(paramCore, paramBlob);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      Blob_Internal$BlobCloneParams blob_Internal$BlobCloneParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        Blob_Internal$BlobReadRangeParams blob_Internal$BlobReadRangeParams;
        Blob_Internal$BlobReadAllParams blob_Internal$BlobReadAllParams;
        Blob_Internal$BlobAsDataPipeGetterParams blob_Internal$BlobAsDataPipeGetterParams;
        switch (i) {
          case 3:
            blob_Internal$BlobReadRangeParams = Blob_Internal$BlobReadRangeParams.deserialize(serviceMessage.getPayload());
            ((Blob)this.mImpl).readRange(blob_Internal$BlobReadRangeParams.offset, blob_Internal$BlobReadRangeParams.length, blob_Internal$BlobReadRangeParams.pipe, blob_Internal$BlobReadRangeParams.client);
            return true;
          case 2:
            blob_Internal$BlobReadAllParams = Blob_Internal$BlobReadAllParams.deserialize(blob_Internal$BlobReadRangeParams.getPayload());
            ((Blob)this.mImpl).readAll(blob_Internal$BlobReadAllParams.pipe, blob_Internal$BlobReadAllParams.client);
            return true;
          case 1:
            blob_Internal$BlobAsDataPipeGetterParams = Blob_Internal$BlobAsDataPipeGetterParams.deserialize(blob_Internal$BlobReadAllParams.getPayload());
            ((Blob)this.mImpl).asDataPipeGetter(blob_Internal$BlobAsDataPipeGetterParams.dataPipeGetter);
            return true;
          case 0:
            blob_Internal$BlobCloneParams = Blob_Internal$BlobCloneParams.deserialize(blob_Internal$BlobAsDataPipeGetterParams.getPayload());
            ((Blob)this.mImpl).clone(blob_Internal$BlobCloneParams.blob);
            return true;
        } 
      } else {
        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Blob_Internal.MANAGER, (ServiceMessage)blob_Internal$BlobCloneParams);
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
      if (!messageHeader.validateHeader(1))
        return false; 
      int i = messageHeader.mType;
      if (i != -1) {
        switch (i) {
          case 5:
            Blob_Internal$BlobGetInternalUuidParams.deserialize(serviceMessage.getPayload());
            ((Blob)this.mImpl).getInternalUuid(new Blob_Internal$BlobGetInternalUuidResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
            return true;
          case 4:
            Blob_Internal$BlobReadSideDataParams.deserialize(serviceMessage.getPayload());
            ((Blob)this.mImpl).readSideData(new Blob_Internal$BlobReadSideDataResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
            return true;
        } 
      } else {
        return InterfaceControlMessagesHelper.handleRun(this.mCore, Blob_Internal.MANAGER, serviceMessage, paramMessageReceiver);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */