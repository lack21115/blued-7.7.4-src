package org.chromium.base.process_launcher;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.TraceEvent;

public class ChildProcessLauncher {
  private final List mClientInterfaces;
  
  private final String[] mCommandLine;
  
  public ChildProcessConnection mConnection;
  
  private final ChildConnectionAllocator mConnectionAllocator;
  
  private final ChildProcessLauncher$Delegate mDelegate;
  
  private final FileDescriptorInfo[] mFilesToBeMapped;
  
  private final Handler mLauncherHandler;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ChildProcessLauncher(Handler paramHandler, ChildProcessLauncher$Delegate paramChildProcessLauncher$Delegate, String[] paramArrayOfString, FileDescriptorInfo[] paramArrayOfFileDescriptorInfo, ChildConnectionAllocator paramChildConnectionAllocator, List paramList) {
    assert false;
    throw new AssertionError();
  }
  
  private void setupConnection() {
    ChildProcessLauncher$2 childProcessLauncher$2 = new ChildProcessLauncher$2(this);
    Bundle bundle = new Bundle();
    bundle.putStringArray("org.chromium.base.process_launcher.extra.command_line", this.mCommandLine);
    bundle.putParcelableArray("org.chromium.base.process_launcher.extra.extraFiles", (Parcelable[])this.mFilesToBeMapped);
    this.mDelegate.onBeforeConnectionSetup(bundle);
    ChildProcessConnection childProcessConnection = this.mConnection;
    List list = this.mClientInterfaces;
    if (ChildProcessConnection.$assertionsDisabled || childProcessConnection.isRunningOnLauncherThread()) {
      if (ChildProcessConnection.$assertionsDisabled || childProcessConnection.mConnectionParams == null) {
        if (childProcessConnection.mServiceDisconnected) {
          Log.w("ChildProcessConn", "Tried to setup a connection that already disconnected.", new Object[0]);
          childProcessLauncher$2.onConnected(null);
          return;
        } 
        try {
          TraceEvent.begin("ChildProcessConnection.setupConnection");
          childProcessConnection.mConnectionCallback = childProcessLauncher$2;
          childProcessConnection.mConnectionParams = new ChildProcessConnection$ConnectionParams(bundle, list);
          if (childProcessConnection.mServiceConnectComplete)
            childProcessConnection.doConnectionSetup(); 
          return;
        } finally {
          TraceEvent.end("ChildProcessConnection.setupConnection");
        } 
      } 
      throw new AssertionError();
    } 
    throw new AssertionError();
  }
  
  final boolean allocateAndSetupConnection(ChildProcessConnection$ServiceCallback paramChildProcessConnection$ServiceCallback, boolean paramBoolean1, boolean paramBoolean2) {
    assert false;
    throw new AssertionError();
  }
  
  public final int getPid() {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean isRunningOnLauncherThread() {
    return (this.mLauncherHandler.getLooper() == Looper.myLooper());
  }
  
  public final boolean start(boolean paramBoolean1, boolean paramBoolean2) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */