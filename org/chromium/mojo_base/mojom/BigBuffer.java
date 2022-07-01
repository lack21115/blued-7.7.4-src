package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Union;

public final class BigBuffer extends Union {
  public byte[] mBytes;
  
  public BigBufferSharedMemoryRegion mSharedMemory;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static final BigBuffer decode(Decoder paramDecoder, int paramInt) {
    DataHeader dataHeader = paramDecoder.readDataHeaderForUnion(paramInt);
    if (dataHeader.size == 0)
      return null; 
    BigBuffer bigBuffer = new BigBuffer();
    switch (dataHeader.elementsOrVersion) {
      default:
        return bigBuffer;
      case 1:
        bigBuffer.mSharedMemory = BigBufferSharedMemoryRegion.decode(paramDecoder.readPointer(paramInt + 8, false));
        bigBuffer.mTag = 1;
        return bigBuffer;
      case 0:
        break;
    } 
    bigBuffer.mBytes = paramDecoder.readBytes(paramInt + 8, 0, -1);
    bigBuffer.mTag = 0;
    return bigBuffer;
  }
  
  protected final void encode(Encoder paramEncoder, int paramInt) {
    paramEncoder.encode(16, paramInt);
    paramEncoder.encode(this.mTag, paramInt + 4);
    switch (this.mTag) {
      default:
        return;
      case 1:
        paramEncoder.encode(this.mSharedMemory, paramInt + 8, false);
        return;
      case 0:
        break;
    } 
    paramEncoder.encode(this.mBytes, paramInt + 8, 0, -1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo_base\mojom\BigBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */