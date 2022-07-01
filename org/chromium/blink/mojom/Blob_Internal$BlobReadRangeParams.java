package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

final class Blob_Internal$BlobReadRangeParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public BlobReaderClient client;
  
  public long length;
  
  public long offset;
  
  public DataPipe.ProducerHandle pipe = (DataPipe.ProducerHandle)InvalidHandle.INSTANCE;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(40, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Blob_Internal$BlobReadRangeParams() {
    super(40);
  }
  
  public Blob_Internal$BlobReadRangeParams(byte paramByte) {
    this();
  }
  
  private static Blob_Internal$BlobReadRangeParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Blob_Internal$BlobReadRangeParams blob_Internal$BlobReadRangeParams = new Blob_Internal$BlobReadRangeParams();
      blob_Internal$BlobReadRangeParams.offset = paramDecoder.readLong(8);
      blob_Internal$BlobReadRangeParams.length = paramDecoder.readLong(16);
      blob_Internal$BlobReadRangeParams.pipe = paramDecoder.readProducerHandle(24, false);
      blob_Internal$BlobReadRangeParams.client = (BlobReaderClient)paramDecoder.readServiceInterface(28, true, BlobReaderClient.MANAGER);
      return blob_Internal$BlobReadRangeParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static Blob_Internal$BlobReadRangeParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.offset, 8);
    paramEncoder.encode(this.length, 16);
    paramEncoder.encode((Handle)this.pipe, 24, false);
    paramEncoder.encode(this.client, 28, true, BlobReaderClient.MANAGER);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob_Internal$BlobReadRangeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */