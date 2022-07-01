package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class SerializedBlob extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  private Blob blob;
  
  private String contentType;
  
  private long size;
  
  private String uuid;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(40, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private SerializedBlob() {
    super(40);
  }
  
  public static SerializedBlob decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      SerializedBlob serializedBlob = new SerializedBlob();
      serializedBlob.uuid = paramDecoder.readString(8, false);
      serializedBlob.contentType = paramDecoder.readString(16, false);
      serializedBlob.size = paramDecoder.readLong(24);
      serializedBlob.blob = (Blob)paramDecoder.readServiceInterface(32, false, Blob.MANAGER);
      return serializedBlob;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.uuid, 8, false);
    paramEncoder.encode(this.contentType, 16, false);
    paramEncoder.encode(this.size, 24);
    paramEncoder.encode(this.blob, 32, false, Blob.MANAGER);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\SerializedBlob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */