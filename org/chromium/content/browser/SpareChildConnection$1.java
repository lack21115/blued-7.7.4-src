package org.chromium.content.browser;

import org.chromium.base.process_launcher.ChildProcessConnection;

final class SpareChildConnection$1 implements ChildProcessConnection.ServiceCallback {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void onChildProcessDied(ChildProcessConnection paramChildProcessConnection) {
    if (SpareChildConnection.access$100(SpareChildConnection.this) != null)
      SpareChildConnection.access$100(SpareChildConnection.this).onChildProcessDied(paramChildProcessConnection); 
    if (SpareChildConnection.access$300(SpareChildConnection.this) != null) {
      assert false;
      throw new AssertionError();
    } 
  }
  
  public final void onChildStartFailed(ChildProcessConnection paramChildProcessConnection) {
    assert false;
    throw new AssertionError();
  }
  
  public final void onChildStarted() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\SpareChildConnection$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */