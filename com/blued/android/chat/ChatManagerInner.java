package com.blued.android.chat;

import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.heart.Heart;

public class ChatManagerInner {
  public static Connector getConnector() {
    return (ChatManager.getInstance()).connector;
  }
  
  public static Heart getHeart() {
    return (ChatManager.getInstance()).heart;
  }
  
  public static boolean isStopped() {
    return (ChatManager.getInstance()).stopped;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\ChatManagerInner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */