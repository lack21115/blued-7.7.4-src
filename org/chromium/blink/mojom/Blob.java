package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

public interface Blob extends Interface {
  public static final Interface.Manager MANAGER = Blob_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void asDataPipeGetter(InterfaceRequest paramInterfaceRequest);
  
  void clone(InterfaceRequest paramInterfaceRequest);
  
  void getInternalUuid(Blob$GetInternalUuidResponse paramBlob$GetInternalUuidResponse);
  
  void readAll(DataPipe.ProducerHandle paramProducerHandle, BlobReaderClient paramBlobReaderClient);
  
  void readRange(long paramLong1, long paramLong2, DataPipe.ProducerHandle paramProducerHandle, BlobReaderClient paramBlobReaderClient);
  
  void readSideData(Blob$ReadSideDataResponse paramBlob$ReadSideDataResponse);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */