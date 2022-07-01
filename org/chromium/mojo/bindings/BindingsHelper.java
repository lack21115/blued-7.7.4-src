package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.Watcher;

public final class BindingsHelper {
  static {
    new DataHeader(24, 0);
    throw new VerifyError("bad dex opcode");
  }
  
  public static int align(int paramInt) {
    return paramInt + 8 - 1 & 0xFFFFFFF8;
  }
  
  public static long align(long paramLong) {
    return paramLong + 8L - 1L & 0xFFFFFFFFFFFFFFF8L;
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2) ? true : ((paramObject1 == null) ? false : paramObject1.equals(paramObject2));
  }
  
  static Watcher getWatcherForHandle(Handle paramHandle) {
    return (paramHandle.getCore() != null) ? paramHandle.getCore().getWatcher() : null;
  }
  
  public static boolean isArrayNullable(int paramInt) {
    return ((paramInt & 0x1) > 0);
  }
  
  public static boolean isElementNullable(int paramInt) {
    return ((paramInt & 0x2) > 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\BindingsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */