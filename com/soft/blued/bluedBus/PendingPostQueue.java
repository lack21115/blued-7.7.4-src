package com.soft.blued.bluedBus;

final class PendingPostQueue {
  private PendingPost a;
  
  private PendingPost b;
  
  PendingPost a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/soft/blued/bluedBus/PendingPost;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield a : Lcom/soft/blued/bluedBus/PendingPost;
    //   11: ifnull -> 37
    //   14: aload_0
    //   15: aload_0
    //   16: getfield a : Lcom/soft/blued/bluedBus/PendingPost;
    //   19: getfield c : Lcom/soft/blued/bluedBus/PendingPost;
    //   22: putfield a : Lcom/soft/blued/bluedBus/PendingPost;
    //   25: aload_0
    //   26: getfield a : Lcom/soft/blued/bluedBus/PendingPost;
    //   29: ifnonnull -> 37
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield b : Lcom/soft/blued/bluedBus/PendingPost;
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	41	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\bluedBus\PendingPostQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */