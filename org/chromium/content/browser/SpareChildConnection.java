package org.chromium.content.browser;

import android.content.Context;
import android.os.Bundle;
import org.chromium.base.process_launcher.ChildConnectionAllocator;
import org.chromium.base.process_launcher.ChildProcessConnection;

public class SpareChildConnection {
  ChildProcessConnection mConnection;
  
  final ChildConnectionAllocator mConnectionAllocator;
  
  boolean mConnectionReady;
  
  ChildProcessConnection.ServiceCallback mConnectionServiceCallback;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SpareChildConnection(Context paramContext, ChildConnectionAllocator paramChildConnectionAllocator, Bundle paramBundle) {
    assert false;
    throw new AssertionError();
  }
  
  final void clearConnection() {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean isEmpty() {
    return (this.mConnection == null || this.mConnectionServiceCallback != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\SpareChildConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */