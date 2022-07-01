package org.chromium.base.process_launcher;

import android.os.Bundle;

public abstract class ChildProcessLauncher$Delegate {
  public ChildProcessConnection getBoundConnection(ChildConnectionAllocator paramChildConnectionAllocator, ChildProcessConnection$ServiceCallback paramChildProcessConnection$ServiceCallback) {
    return null;
  }
  
  public void onBeforeConnectionAllocated(Bundle paramBundle) {}
  
  public void onBeforeConnectionSetup(Bundle paramBundle) {}
  
  public void onConnectionEstablished(ChildProcessConnection paramChildProcessConnection) {}
  
  public void onConnectionLost(ChildProcessConnection paramChildProcessConnection) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessLauncher$Delegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */