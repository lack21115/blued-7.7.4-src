package com.blued.android.chat.listener;

import com.blued.android.chat.model.ChattingModel;

public interface MsgPreProcesserListener {
  void onProcessToSave(ChattingModel paramChattingModel);
  
  void onProcessToSend(ChattingModel paramChattingModel);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\listener\MsgPreProcesserListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */