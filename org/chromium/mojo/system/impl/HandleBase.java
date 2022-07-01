package org.chromium.mojo.system.impl;

import org.chromium.base.Log;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.UntypedHandle;

abstract class HandleBase implements Handle {
  protected CoreImpl mCore;
  
  int mMojoHandle;
  
  HandleBase(CoreImpl paramCoreImpl, int paramInt) {
    this.mCore = paramCoreImpl;
    this.mMojoHandle = paramInt;
  }
  
  protected HandleBase(HandleBase paramHandleBase) {
    this.mCore = paramHandleBase.mCore;
    int i = paramHandleBase.mMojoHandle;
    paramHandleBase.mMojoHandle = 0;
    this.mMojoHandle = i;
  }
  
  public void close() {
    if (this.mMojoHandle != 0) {
      int i = this.mMojoHandle;
      this.mMojoHandle = 0;
      i = this.mCore.nativeClose(i);
      if (i == 0)
        return; 
      throw new MojoException(i);
    } 
  }
  
  protected final void finalize() {
    if (isValid()) {
      Log.w("HandleImpl", "Handle was not closed.", new Object[0]);
      this.mCore.nativeClose(this.mMojoHandle);
    } 
    super.finalize();
  }
  
  public final Core getCore() {
    return this.mCore;
  }
  
  public final boolean isValid() {
    return (this.mMojoHandle != 0);
  }
  
  public final int releaseNativeHandle() {
    int i = this.mMojoHandle;
    this.mMojoHandle = 0;
    return i;
  }
  
  public final UntypedHandle toUntypedHandle() {
    return new UntypedHandleImpl(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\impl\HandleBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */