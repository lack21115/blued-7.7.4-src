package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.SharedBufferHandle;

public final class BigBufferSharedMemoryRegion extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public SharedBufferHandle bufferHandle = (SharedBufferHandle)InvalidHandle.INSTANCE;
  
  public int size;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private BigBufferSharedMemoryRegion() {
    super(16);
  }
  
  public BigBufferSharedMemoryRegion(byte paramByte) {
    this();
  }
  
  public static BigBufferSharedMemoryRegion decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      BigBufferSharedMemoryRegion bigBufferSharedMemoryRegion = new BigBufferSharedMemoryRegion();
      bigBufferSharedMemoryRegion.bufferHandle = paramDecoder.readUntypedHandle(8, false).toSharedBufferHandle();
      bigBufferSharedMemoryRegion.size = paramDecoder.readInt(12);
      return bigBufferSharedMemoryRegion;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode((Handle)this.bufferHandle, 8, false);
    paramEncoder.encode(this.size, 12);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo_base\mojom\BigBufferSharedMemoryRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */