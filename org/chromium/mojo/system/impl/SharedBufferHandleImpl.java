package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.Flags;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.SharedBufferHandle;

final class SharedBufferHandleImpl extends HandleBase implements SharedBufferHandle {
  SharedBufferHandleImpl(CoreImpl paramCoreImpl, int paramInt) {
    super(paramCoreImpl, paramInt);
  }
  
  SharedBufferHandleImpl(HandleBase paramHandleBase) {
    super(paramHandleBase);
  }
  
  public final ByteBuffer map(long paramLong1, long paramLong2, SharedBufferHandle.MapFlags paramMapFlags) {
    ResultAnd resultAnd = this.mCore.nativeMap(this.mMojoHandle, paramLong1, paramLong2, ((Flags)paramMapFlags).mFlags);
    if (resultAnd.mMojoResult == 0)
      return (ByteBuffer)resultAnd.mValue; 
    throw new MojoException(resultAnd.mMojoResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\impl\SharedBufferHandleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */