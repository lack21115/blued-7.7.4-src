package com.idlefish.flutterboost.containers;

import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;

class BoostViewUtils {
  private static volatile XPlatformPlugin a;
  
  public static XPlatformPlugin a(PlatformChannel paramPlatformChannel) {
    // Byte code:
    //   0: getstatic com/idlefish/flutterboost/containers/BoostViewUtils.a : Lcom/idlefish/flutterboost/XPlatformPlugin;
    //   3: ifnonnull -> 38
    //   6: ldc com/idlefish/flutterboost/containers/BoostViewUtils
    //   8: monitorenter
    //   9: getstatic com/idlefish/flutterboost/containers/BoostViewUtils.a : Lcom/idlefish/flutterboost/XPlatformPlugin;
    //   12: ifnonnull -> 26
    //   15: new com/idlefish/flutterboost/XPlatformPlugin
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Lio/flutter/embedding/engine/systemchannels/PlatformChannel;)V
    //   23: putstatic com/idlefish/flutterboost/containers/BoostViewUtils.a : Lcom/idlefish/flutterboost/XPlatformPlugin;
    //   26: ldc com/idlefish/flutterboost/containers/BoostViewUtils
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/idlefish/flutterboost/containers/BoostViewUtils
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/idlefish/flutterboost/containers/BoostViewUtils.a : Lcom/idlefish/flutterboost/XPlatformPlugin;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\containers\BoostViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */