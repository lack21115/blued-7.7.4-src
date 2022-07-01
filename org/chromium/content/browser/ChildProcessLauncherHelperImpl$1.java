package org.chromium.content.browser;

import android.os.Bundle;
import org.chromium.base.CpuFeatures;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.library_loader.Linker;
import org.chromium.base.process_launcher.ChildConnectionAllocator;
import org.chromium.base.process_launcher.ChildProcessConnection;
import org.chromium.base.process_launcher.ChildProcessLauncher;

final class ChildProcessLauncherHelperImpl$1 extends ChildProcessLauncher.Delegate {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final ChildProcessConnection getBoundConnection(ChildConnectionAllocator paramChildConnectionAllocator, ChildProcessConnection.ServiceCallback paramServiceCallback) {
    if (ChildProcessLauncherHelperImpl.access$000() == null)
      return null; 
    SpareChildConnection spareChildConnection = ChildProcessLauncherHelperImpl.access$000();
    if (SpareChildConnection.$assertionsDisabled || LauncherThread.runningOnLauncherThread()) {
      if (!spareChildConnection.isEmpty() && spareChildConnection.mConnectionAllocator == paramChildConnectionAllocator) {
        if (spareChildConnection.mConnectionServiceCallback != null)
          return null; 
        spareChildConnection.mConnectionServiceCallback = paramServiceCallback;
        ChildProcessConnection childProcessConnection = spareChildConnection.mConnection;
        if (spareChildConnection.mConnectionReady) {
          if (paramServiceCallback != null)
            LauncherThread.post(new SpareChildConnection$2(paramServiceCallback)); 
          spareChildConnection.clearConnection();
        } 
        return childProcessConnection;
      } 
      return null;
    } 
    throw new AssertionError();
  }
  
  public final void onBeforeConnectionAllocated(Bundle paramBundle) {
    ChildProcessLauncherHelperImpl.access$100(paramBundle);
  }
  
  public final void onBeforeConnectionSetup(Bundle paramBundle) {
    paramBundle.putInt("com.google.android.apps.chrome.extra.cpu_count", CpuFeatures.getCount());
    paramBundle.putLong("com.google.android.apps.chrome.extra.cpu_features", CpuFeatures.getMask());
    if (LibraryLoader.useCrazyLinker())
      paramBundle.putBundle("org.chromium.base.android.linker.shared_relros", Linker.getInstance().getSharedRelros()); 
  }
  
  public final void onConnectionEstablished(ChildProcessConnection paramChildProcessConnection) {
    int i = paramChildProcessConnection.getPid();
    assert false;
    throw new AssertionError();
  }
  
  public final void onConnectionLost(ChildProcessConnection paramChildProcessConnection) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ChildProcessLauncherHelperImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */