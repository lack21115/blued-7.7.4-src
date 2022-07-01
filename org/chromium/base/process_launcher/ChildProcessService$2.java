package org.chromium.base.process_launcher;

import org.chromium.base.Log;

final class ChildProcessService$2 implements Runnable {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void run() {
    try {
      synchronized (ChildProcessService.access$500(ChildProcessService.this)) {
        while (ChildProcessService.access$600(ChildProcessService.this) == null)
          ChildProcessService.access$500(ChildProcessService.this).wait(); 
        assert false;
        throw new AssertionError();
      } 
    } catch (InterruptedException interruptedException) {
      Log.w("ChildProcessService", "%s startup failed: %s", new Object[] { "ChildProcessMain", interruptedException });
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessService$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */