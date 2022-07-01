package com.blued.android.chat.listener;

import com.blued.android.chat.data.AudioRoomChatData;
import com.blued.android.chat.model.ChattingModel;

public interface AudioRoomChatInfoListener {
  void onApplyAnchor(AudioRoomChatData paramAudioRoomChatData);
  
  void onCloseRoom(AudioRoomChatData paramAudioRoomChatData);
  
  void onKickedOut(ChattingModel paramChattingModel);
  
  void onMemebersDecrease(AudioRoomChatData paramAudioRoomChatData);
  
  void onMemebersIncrease(AudioRoomChatData paramAudioRoomChatData);
  
  void onOffAnchor(AudioRoomChatData paramAudioRoomChatData);
  
  void onOnAnchor(AudioRoomChatData paramAudioRoomChatData);
  
  void onRecvNewMsg(ChattingModel paramChattingModel);
  
  void onRefuseAnchor(AudioRoomChatData paramAudioRoomChatData);
  
  void onSeatDecrease(AudioRoomChatData paramAudioRoomChatData);
  
  void onSeatIncrease(AudioRoomChatData paramAudioRoomChatData);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\listener\AudioRoomChatInfoListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */