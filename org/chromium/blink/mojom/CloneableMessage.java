package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.BigBuffer;

public final class CloneableMessage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public SerializedBlob[] blobs;
  
  public BigBuffer encodedMessage;
  
  private long stackTraceDebuggerIdFirst;
  
  private long stackTraceDebuggerIdSecond;
  
  private long stackTraceId;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(56, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private CloneableMessage() {
    super(56);
  }
  
  public CloneableMessage(byte paramByte) {
    this();
  }
  
  public static CloneableMessage decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      CloneableMessage cloneableMessage = new CloneableMessage();
      cloneableMessage.encodedMessage = BigBuffer.decode(paramDecoder, 8);
      Decoder decoder = paramDecoder.readPointer(24, false);
      DataHeader dataHeader = decoder.readDataHeaderForPointerArray(-1);
      cloneableMessage.blobs = new SerializedBlob[dataHeader.elementsOrVersion];
      for (int i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder1 = decoder.readPointer((i << 3) + 8, false);
        cloneableMessage.blobs[i] = SerializedBlob.decode(decoder1);
      } 
      cloneableMessage.stackTraceId = paramDecoder.readLong(32);
      cloneableMessage.stackTraceDebuggerIdFirst = paramDecoder.readLong(40);
      cloneableMessage.stackTraceDebuggerIdSecond = paramDecoder.readLong(48);
      return cloneableMessage;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode((Union)this.encodedMessage, 8, false);
    if (this.blobs == null) {
      paramEncoder.encodeNullPointer(24, false);
    } else {
      Encoder encoder = paramEncoder.encodePointerArray(this.blobs.length, 24, -1);
      for (int i = 0; i < this.blobs.length; i++)
        encoder.encode(this.blobs[i], (i << 3) + 8, false); 
    } 
    paramEncoder.encode(this.stackTraceId, 32);
    paramEncoder.encode(this.stackTraceDebuggerIdFirst, 40);
    paramEncoder.encode(this.stackTraceDebuggerIdSecond, 48);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\CloneableMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */