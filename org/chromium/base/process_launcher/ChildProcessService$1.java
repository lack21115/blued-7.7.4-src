package org.chromium.base.process_launcher;

import android.os.Bundle;
import java.util.List;
import org.chromium.base.ThreadUtils;
import org.chromium.base.memory.MemoryPressureMonitor;

final class ChildProcessService$1 extends IChildProcessService$Stub {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean bindToCaller() {
    assert false;
    throw new AssertionError();
  }
  
  public final void forceKill() {
    assert false;
    throw new AssertionError();
  }
  
  public final void onMemoryPressure(int paramInt) {
    ThreadUtils.postOnUiThread(new ChildProcessService$1$$Lambda$0(paramInt));
  }
  
  public final void setupConnection(Bundle paramBundle, ICallbackInt paramICallbackInt, List paramList) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */