package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class Blob_Internal$BlobAsDataPipeGetterParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public InterfaceRequest dataPipeGetter;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Blob_Internal$BlobAsDataPipeGetterParams() {
    super(16);
  }
  
  public Blob_Internal$BlobAsDataPipeGetterParams(byte paramByte) {
    this();
  }
  
  private static Blob_Internal$BlobAsDataPipeGetterParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Blob_Internal$BlobAsDataPipeGetterParams blob_Internal$BlobAsDataPipeGetterParams = new Blob_Internal$BlobAsDataPipeGetterParams();
      blob_Internal$BlobAsDataPipeGetterParams.dataPipeGetter = paramDecoder.readInterfaceRequest(8, false);
      return blob_Internal$BlobAsDataPipeGetterParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static Blob_Internal$BlobAsDataPipeGetterParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.dataPipeGetter, 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\Blob_Internal$BlobAsDataPipeGetterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */