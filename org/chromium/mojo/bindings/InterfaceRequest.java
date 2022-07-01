package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;

public final class InterfaceRequest implements HandleOwner {
  private final MessagePipeHandle mHandle;
  
  InterfaceRequest(MessagePipeHandle paramMessagePipeHandle) {
    this.mHandle = paramMessagePipeHandle;
  }
  
  public final void close() {
    this.mHandle.close();
  }
  
  public final MessagePipeHandle passHandle() {
    return this.mHandle.pass();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\InterfaceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */