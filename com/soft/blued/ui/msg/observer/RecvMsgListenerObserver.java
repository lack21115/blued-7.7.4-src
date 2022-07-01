package com.soft.blued.ui.msg.observer;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import java.util.ArrayList;

public class RecvMsgListenerObserver {
  private static RecvMsgListenerObserver a;
  
  private ArrayList<IRecvMsgListener> b = new ArrayList<IRecvMsgListener>();
  
  public static RecvMsgListenerObserver a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/msg/observer/RecvMsgListenerObserver.a : Lcom/soft/blued/ui/msg/observer/RecvMsgListenerObserver;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/msg/observer/RecvMsgListenerObserver
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/msg/observer/RecvMsgListenerObserver.a : Lcom/soft/blued/ui/msg/observer/RecvMsgListenerObserver;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/msg/observer/RecvMsgListenerObserver
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/msg/observer/RecvMsgListenerObserver.a : Lcom/soft/blued/ui/msg/observer/RecvMsgListenerObserver;
    //   25: ldc com/soft/blued/ui/msg/observer/RecvMsgListenerObserver
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/msg/observer/RecvMsgListenerObserver
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/msg/observer/RecvMsgListenerObserver.a : Lcom/soft/blued/ui/msg/observer/RecvMsgListenerObserver;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    for (IRecvMsgListener iRecvMsgListener : this.b) {
      if (iRecvMsgListener != null)
        iRecvMsgListener.a(paramSessionModel, paramChattingModel); 
    } 
  }
  
  public static interface IRecvMsgListener {
    void a(SessionModel param1SessionModel, ChattingModel param1ChattingModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\observer\RecvMsgListenerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */