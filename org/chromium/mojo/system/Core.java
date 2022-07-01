package org.chromium.mojo.system;

public interface Core {
  UntypedHandle acquireNativeHandle(int paramInt);
  
  Pair createMessagePipe(MessagePipeHandle$CreateOptions paramMessagePipeHandle$CreateOptions);
  
  SharedBufferHandle createSharedBuffer(SharedBufferHandle$CreateOptions paramSharedBufferHandle$CreateOptions, long paramLong);
  
  Watcher getWatcher();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\Core.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */