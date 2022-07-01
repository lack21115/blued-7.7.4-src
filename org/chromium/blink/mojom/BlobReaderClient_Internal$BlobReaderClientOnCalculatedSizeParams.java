package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public long expectedContentSize;
  
  public long totalSize;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams() {
    super(24);
  }
  
  public BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams(byte paramByte) {
    this();
  }
  
  private static BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams = new BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams();
      blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.totalSize = paramDecoder.readLong(8);
      blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.expectedContentSize = paramDecoder.readLong(16);
      return blobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.totalSize, 8);
    paramEncoder.encode(this.expectedContentSize, 16);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\BlobReaderClient_Internal$BlobReaderClientOnCalculatedSizeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */