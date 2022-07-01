package org.chromium.content.browser;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.util.LinkedList;
import org.chromium.base.Log;
import org.chromium.base.process_launcher.ChildProcessConnection;

class BindingManager implements ComponentCallbacks2 {
  final LinkedList mConnections;
  
  private final int mMaxSize;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private void removeOldConnections(int paramInt) {
    assert false;
    throw new AssertionError();
  }
  
  final void addAndUseConnection(ChildProcessConnection paramChildProcessConnection) {
    if (!this.mConnections.removeFirstOccurrence(paramChildProcessConnection))
      paramChildProcessConnection.addModerateBinding(); 
    if (this.mConnections.size() == this.mMaxSize)
      removeOldConnections(1); 
    this.mConnections.add(0, paramChildProcessConnection);
    assert false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {
    LauncherThread.post(new BindingManager$2(this));
  }
  
  public void onTrimMemory(int paramInt) {
    LauncherThread.post(new BindingManager$1(this, paramInt));
  }
  
  final void removeAllConnections() {
    removeOldConnections(this.mConnections.size());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\BindingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */