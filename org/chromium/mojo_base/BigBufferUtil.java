package org.chromium.mojo_base;

import java.nio.ByteBuffer;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.BigBufferSharedMemoryRegion;

public final class BigBufferUtil {
  public static byte[] getBytesFromBigBuffer(BigBuffer paramBigBuffer) {
    if (((Union)paramBigBuffer).mTag == 0) {
      if (BigBuffer.$assertionsDisabled || paramBigBuffer.mTag == 0)
        return paramBigBuffer.mBytes; 
      throw new AssertionError();
    } 
    if (BigBuffer.$assertionsDisabled || paramBigBuffer.mTag == 1) {
      BigBufferSharedMemoryRegion bigBufferSharedMemoryRegion = paramBigBuffer.mSharedMemory;
      ByteBuffer byteBuffer = bigBufferSharedMemoryRegion.bufferHandle.map(0L, bigBufferSharedMemoryRegion.size, SharedBufferHandle.MapFlags.NONE);
      byte[] arrayOfByte = new byte[bigBufferSharedMemoryRegion.size];
      byteBuffer.get(arrayOfByte);
      return arrayOfByte;
    } 
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo_base\BigBufferUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */