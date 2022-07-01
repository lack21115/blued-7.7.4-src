package com.facebook.stetho.inspector.console;

import com.facebook.stetho.inspector.helper.ChromePeerManager;
import javax.annotation.Nullable;

public class ConsolePeerManager extends ChromePeerManager {
  private static ConsolePeerManager sInstance;
  
  @Nullable
  public static ConsolePeerManager getInstanceOrNull() {
    // Byte code:
    //   0: ldc com/facebook/stetho/inspector/console/ConsolePeerManager
    //   2: monitorenter
    //   3: getstatic com/facebook/stetho/inspector/console/ConsolePeerManager.sInstance : Lcom/facebook/stetho/inspector/console/ConsolePeerManager;
    //   6: astore_0
    //   7: ldc com/facebook/stetho/inspector/console/ConsolePeerManager
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/facebook/stetho/inspector/console/ConsolePeerManager
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static ConsolePeerManager getOrCreateInstance() {
    // Byte code:
    //   0: ldc com/facebook/stetho/inspector/console/ConsolePeerManager
    //   2: monitorenter
    //   3: getstatic com/facebook/stetho/inspector/console/ConsolePeerManager.sInstance : Lcom/facebook/stetho/inspector/console/ConsolePeerManager;
    //   6: ifnonnull -> 19
    //   9: new com/facebook/stetho/inspector/console/ConsolePeerManager
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/facebook/stetho/inspector/console/ConsolePeerManager.sInstance : Lcom/facebook/stetho/inspector/console/ConsolePeerManager;
    //   19: getstatic com/facebook/stetho/inspector/console/ConsolePeerManager.sInstance : Lcom/facebook/stetho/inspector/console/ConsolePeerManager;
    //   22: astore_0
    //   23: ldc com/facebook/stetho/inspector/console/ConsolePeerManager
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/facebook/stetho/inspector/console/ConsolePeerManager
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\console\ConsolePeerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */