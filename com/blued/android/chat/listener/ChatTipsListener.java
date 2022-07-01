package com.blued.android.chat.listener;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;

public interface ChatTipsListener {
  void onBusyCalling(long paramLong);
  
  void onConnectException(String paramString);
  
  void onDisconnect(int paramInt, String paramString);
  
  void onRecvNewMsg(SessionModel paramSessionModel, ChattingModel paramChattingModel);
  
  void onSendMsgFailed(short paramShort, long paramLong, int paramInt);
  
  void onVideoCalling(long paramLong, int paramInt);
  
  void onVideoCallingCancel(long paramLong, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\listener\ChatTipsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */