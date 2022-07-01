package org.chromium.mojo.system;

import java.nio.ByteBuffer;

public interface SharedBufferHandle extends Handle {
  ByteBuffer map(long paramLong1, long paramLong2, SharedBufferHandle$MapFlags paramSharedBufferHandle$MapFlags);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\SharedBufferHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */