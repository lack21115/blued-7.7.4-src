package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Core;

public abstract class Interface$Stub implements MessageReceiverWithResponder {
  public final Core mCore;
  
  public final Interface mImpl;
  
  public Interface$Stub(Core paramCore, Interface paramInterface) {
    this.mCore = paramCore;
    this.mImpl = paramInterface;
  }
  
  public void close() {
    this.mImpl.close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Interface$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */