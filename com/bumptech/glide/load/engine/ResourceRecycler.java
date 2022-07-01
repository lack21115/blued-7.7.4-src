package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ResourceRecycler {
  private boolean a;
  
  private final Handler b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
  
  void a(Resource<?> paramResource, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Z
    //   6: ifne -> 35
    //   9: iload_2
    //   10: ifeq -> 16
    //   13: goto -> 35
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield a : Z
    //   21: aload_1
    //   22: invokeinterface c : ()V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield a : Z
    //   32: goto -> 47
    //   35: aload_0
    //   36: getfield b : Landroid/os/Handler;
    //   39: iconst_1
    //   40: aload_1
    //   41: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   44: invokevirtual sendToTarget : ()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	50	finally
    //   16	32	50	finally
    //   35	47	50	finally
  }
  
  static final class ResourceRecyclerCallback implements Handler.Callback {
    public boolean handleMessage(Message param1Message) {
      if (param1Message.what == 1) {
        ((Resource)param1Message.obj).c();
        return true;
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\ResourceRecycler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */