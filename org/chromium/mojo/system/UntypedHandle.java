package org.chromium.mojo.system;

public interface UntypedHandle extends Handle {
  DataPipe$ProducerHandle toDataPipeProducerHandle();
  
  MessagePipeHandle toMessagePipeHandle();
  
  SharedBufferHandle toSharedBufferHandle();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\UntypedHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */