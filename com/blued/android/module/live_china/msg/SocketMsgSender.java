package com.blued.android.module.live_china.msg;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;

public class SocketMsgSender extends ILiveMsgSender {
  public void a() {}
  
  public void a(long paramLong) {
    ChatManager.getInstance().initLiveChatInfo(LiveRoomManager.a().f(), paramLong, true);
  }
  
  public void a(String paramString) {
    ChattingModel chattingModel = a((short)1, paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("roomId: ");
    stringBuilder.append(LiveRoomManager.a().b());
    stringBuilder.append(", getSessionType: ");
    stringBuilder.append(LiveRoomManager.a().f());
    stringBuilder.append(", content: ");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    LiveRoomInfo.a().a(chattingModel, false);
  }
  
  public void a(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    ChatManager.getInstance().registerLiveChatListener(paramShort, paramLong, paramLiveChatInfoListener);
  }
  
  public void a(boolean paramBoolean) {
    LiveRoomInfo.a().a(f(), false);
    if (paramBoolean)
      d(); 
  }
  
  public void b() {}
  
  public void b(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    ChatManager.getInstance().unregisterLiveChatListener(paramShort, paramLong, paramLiveChatInfoListener);
  }
  
  public void c() {}
  
  public void d() {
    LiveRoomInfo.a().a(g(), false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\msg\SocketMsgSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */