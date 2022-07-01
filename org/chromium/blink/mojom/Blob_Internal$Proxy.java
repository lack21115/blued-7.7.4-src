package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;

final class Blob_Internal$Proxy extends Interface.AbstractProxy implements Blob$Proxy {
  Blob_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void asDataPipeGetter(InterfaceRequest paramInterfaceRequest) {
    Blob_Internal$BlobAsDataPipeGetterParams blob_Internal$BlobAsDataPipeGetterParams = new Blob_Internal$BlobAsDataPipeGetterParams((byte)0);
    blob_Internal$BlobAsDataPipeGetterParams.dataPipeGetter = paramInterfaceRequest;
    this.mHandler.mMessageReceiver.accept((Message)blob_Internal$BlobAsDataPipeGetterParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(1)));
  }
  
  public final void clone(InterfaceRequest paramInterfaceRequest) {
    Blob_Internal$BlobCloneParams blob_Internal$BlobCloneParams = new Blob_Internal$BlobCloneParams((byte)0);
    blob_Internal$BlobCloneParams.blob = paramInterfaceRequest;
    this.mHandler.mMessageReceiver.accept((Message)blob_Internal$BlobCloneParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
  
  public final void getInternalUuid(Blob$GetInternalUuidResponse paramBlob$GetInternalUuidResponse) {
    Blob_Internal$BlobGetInternalUuidParams blob_Internal$BlobGetInternalUuidParams = new Blob_Internal$BlobGetInternalUuidParams((byte)0);
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)blob_Internal$BlobGetInternalUuidParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(5, 1, 0L)), new Blob_Internal$BlobGetInternalUuidResponseParamsForwardToCallback(paramBlob$GetInternalUuidResponse));
  }
  
  public final void readAll(DataPipe.ProducerHandle paramProducerHandle, BlobReaderClient paramBlobReaderClient) {
    Blob_Internal$BlobReadAllParams blob_Internal$BlobReadAllParams = new Blob_Internal$BlobReadAllParams((byte)0);
    blob_Internal$BlobReadAllParams.pipe = paramProducerHandle;
    blob_Internal$BlobReadAllParams.client = paramBlobReaderClient;
    this.mHandler.mMessageReceiver.accept((Message)blob_Internal$BlobReadAllParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(2)));
  }
  
  public final void readRange(long paramLong1, long paramLong2, DataPipe.ProducerHandle paramProducerHandle, BlobReaderClient paramBlobReaderClient) {
    Blob_Internal$BlobReadRangeParams blob_Internal$BlobReadRangeParams = new Blob_Internal$BlobReadRangeParams((byte)0);
    blob_Internal$BlobReadRangeParams.offset = paramLong1;
    blob_Internal$BlobReadRangeParams.length = paramLong2;
    blob_Internal$BlobReadRangeParams.pipe = paramProducerHandle;
    blob_Internal$BlobReadRangeParams.client = paramBlobReaderClient;
    this.mHandler.mMessageReceiver.accept((Message)blob_Internal$BlobReadRangeParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(3)));
  }
  
  public final void readSideData(Blob$ReadSideDataResponse paramBlob$ReadSideDataResponse) {
    Blob_Internal$BlobReadSideDataParams blob_Internal$BlobReadSideDataParams = new Blob_Internal$BlobReadSideDataParams((byte)0);
    this.mHandler.mMessageReceiver.acceptWithResponder((Message)blob_Internal$BlobReadSideDataParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(4, 1, 0L)), new Blob_Internal$BlobReadSideDataResponseParamsForwardToCallback(paramBlob$ReadSideDataResponse));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */