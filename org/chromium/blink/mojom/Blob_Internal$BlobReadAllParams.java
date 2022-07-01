package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

final class Blob_Internal$BlobReadAllParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public BlobReaderClient client;
  
  public DataPipe.ProducerHandle pipe = (DataPipe.ProducerHandle)InvalidHandle.INSTANCE;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Blob_Internal$BlobReadAllParams() {
    super(24);
  }
  
  public Blob_Internal$BlobReadAllParams(byte paramByte) {
    this();
  }
  
  private static Blob_Internal$BlobReadAllParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Blob_Internal$BlobReadAllParams blob_Internal$BlobReadAllParams = new Blob_Internal$BlobReadAllParams();
      blob_Internal$BlobReadAllParams.pipe = paramDecoder.readProducerHandle(8, false);
      blob_Internal$BlobReadAllParams.client = (BlobReaderClient)paramDecoder.readServiceInterface(12, true, BlobReaderClient.MANAGER);
      return blob_Internal$BlobReadAllParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static Blob_Internal$BlobReadAllParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode((Handle)this.pipe, 8, false);
    paramEncoder.encode(this.client, 12, true, BlobReaderClient.MANAGER);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob_Internal$BlobReadAllParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */