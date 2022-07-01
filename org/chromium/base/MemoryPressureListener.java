package org.chromium.base;

import java.util.Iterator;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.memory.MemoryPressureCallback;

public class MemoryPressureListener {
  private static final ObserverList sCallbacks = new ObserverList();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void addCallback(MemoryPressureCallback paramMemoryPressureCallback) {
    sCallbacks.addObserver(paramMemoryPressureCallback);
  }
  
  @CalledByNative
  private static void addNativeCallback() {
    addCallback(MemoryPressureListener$$Lambda$0.$instance);
  }
  
  private static native void nativeOnMemoryPressure(int paramInt);
  
  public static void notifyMemoryPressure(int paramInt) {
    Iterator<MemoryPressureCallback> iterator = sCallbacks.iterator();
    while (iterator.hasNext())
      ((MemoryPressureCallback)iterator.next()).onPressure(paramInt); 
  }
  
  public static void removeCallback(MemoryPressureCallback paramMemoryPressureCallback) {
    sCallbacks.removeObserver(paramMemoryPressureCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\MemoryPressureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */