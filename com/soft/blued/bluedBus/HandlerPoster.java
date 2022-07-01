package com.soft.blued.bluedBus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class HandlerPoster extends Handler implements Poster {
  private final PendingPostQueue a;
  
  private final int b;
  
  private final BluedBus c;
  
  private boolean d;
  
  protected HandlerPoster(BluedBus paramBluedBus, Looper paramLooper, int paramInt) {
    super(paramLooper);
    this.c = paramBluedBus;
    this.b = paramInt;
    this.a = new PendingPostQueue();
  }
  
  public void handleMessage(Message paramMessage) {
    // Byte code:
    //   0: invokestatic uptimeMillis : ()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield a : Lcom/soft/blued/bluedBus/PendingPostQueue;
    //   8: invokevirtual a : ()Lcom/soft/blued/bluedBus/PendingPost;
    //   11: astore #5
    //   13: aload #5
    //   15: astore_1
    //   16: aload #5
    //   18: ifnonnull -> 58
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield a : Lcom/soft/blued/bluedBus/PendingPostQueue;
    //   27: invokevirtual a : ()Lcom/soft/blued/bluedBus/PendingPost;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull -> 48
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield d : Z
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield d : Z
    //   47: return
    //   48: aload_0
    //   49: monitorexit
    //   50: goto -> 58
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: aload_0
    //   59: getfield c : Lcom/soft/blued/bluedBus/BluedBus;
    //   62: aload_1
    //   63: invokevirtual a : (Lcom/soft/blued/bluedBus/PendingPost;)V
    //   66: invokestatic uptimeMillis : ()J
    //   69: lload_2
    //   70: lsub
    //   71: aload_0
    //   72: getfield b : I
    //   75: i2l
    //   76: lcmp
    //   77: iflt -> 4
    //   80: aload_0
    //   81: aload_0
    //   82: invokevirtual obtainMessage : ()Landroid/os/Message;
    //   85: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   88: istore #4
    //   90: iload #4
    //   92: ifeq -> 101
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield d : Z
    //   100: return
    //   101: new java/lang/RuntimeException
    //   104: dup
    //   105: ldc 'Could not send handler message'
    //   107: invokespecial <init> : (Ljava/lang/String;)V
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield d : Z
    //   117: aload_1
    //   118: athrow
    // Exception table:
    //   from	to	target	type
    //   0	4	111	finally
    //   4	13	111	finally
    //   21	23	111	finally
    //   23	31	53	finally
    //   35	42	53	finally
    //   48	50	53	finally
    //   54	56	53	finally
    //   56	58	111	finally
    //   58	90	111	finally
    //   101	111	111	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\bluedBus\HandlerPoster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */