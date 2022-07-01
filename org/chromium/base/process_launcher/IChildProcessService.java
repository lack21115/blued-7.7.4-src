package org.chromium.base.process_launcher;

import android.os.Bundle;
import android.os.IInterface;
import java.util.List;

public interface IChildProcessService extends IInterface {
  boolean bindToCaller();
  
  void forceKill();
  
  void onMemoryPressure(int paramInt);
  
  void setupConnection(Bundle paramBundle, ICallbackInt paramICallbackInt, List paramList);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\IChildProcessService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */