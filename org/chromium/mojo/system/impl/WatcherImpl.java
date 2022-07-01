package org.chromium.mojo.system.impl;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Flags;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.Watcher;

class WatcherImpl implements Watcher {
  private Watcher.Callback mCallback;
  
  private long mImplPtr = nativeCreateWatcher();
  
  private native void nativeCancel(long paramLong);
  
  private native long nativeCreateWatcher();
  
  private native void nativeDelete(long paramLong);
  
  private native int nativeStart(long paramLong, int paramInt1, int paramInt2);
  
  @CalledByNative
  private void onHandleReady(int paramInt) {
    this.mCallback.onResult(paramInt);
  }
  
  public final void cancel() {
    if (this.mImplPtr == 0L)
      return; 
    this.mCallback = null;
    nativeCancel(this.mImplPtr);
  }
  
  public final void destroy() {
    if (this.mImplPtr == 0L)
      return; 
    nativeDelete(this.mImplPtr);
    this.mImplPtr = 0L;
  }
  
  public final int start(Handle paramHandle, Core.HandleSignals paramHandleSignals, Watcher.Callback paramCallback) {
    if (this.mImplPtr == 0L)
      return 3; 
    if (!(paramHandle instanceof HandleBase))
      return 3; 
    int i = nativeStart(this.mImplPtr, ((HandleBase)paramHandle).mMojoHandle, ((Flags)paramHandleSignals).mFlags);
    if (i == 0)
      this.mCallback = paramCallback; 
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\impl\WatcherImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */