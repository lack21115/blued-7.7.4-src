package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class Blob_Internal$BlobReadSideDataResponseParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public byte[] data;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Blob_Internal$BlobReadSideDataResponseParams() {
    super(16);
  }
  
  public Blob_Internal$BlobReadSideDataResponseParams(byte paramByte) {
    this();
  }
  
  private static Blob_Internal$BlobReadSideDataResponseParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Blob_Internal$BlobReadSideDataResponseParams blob_Internal$BlobReadSideDataResponseParams = new Blob_Internal$BlobReadSideDataResponseParams();
      blob_Internal$BlobReadSideDataResponseParams.data = paramDecoder.readBytes(8, 1, -1);
      return blob_Internal$BlobReadSideDataResponseParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static Blob_Internal$BlobReadSideDataResponseParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.data, 8, 1, -1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob_Internal$BlobReadSideDataResponseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */