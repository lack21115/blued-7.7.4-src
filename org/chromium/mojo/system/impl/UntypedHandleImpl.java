package org.chromium.mojo.system.impl;

import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo.system.UntypedHandle;

final class UntypedHandleImpl extends HandleBase implements UntypedHandle {
  UntypedHandleImpl(CoreImpl paramCoreImpl, int paramInt) {
    super(paramCoreImpl, paramInt);
  }
  
  UntypedHandleImpl(HandleBase paramHandleBase) {
    super(paramHandleBase);
  }
  
  public final DataPipe.ProducerHandle toDataPipeProducerHandle() {
    return new DataPipeProducerHandleImpl(this);
  }
  
  public final MessagePipeHandle toMessagePipeHandle() {
    return new MessagePipeHandleImpl(this);
  }
  
  public final SharedBufferHandle toSharedBufferHandle() {
    return new SharedBufferHandleImpl(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\impl\UntypedHandleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */