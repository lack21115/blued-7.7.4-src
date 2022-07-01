package com.blued.android.chat.listener;

import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.data.LiveCreateFailedReason;
import java.util.Map;

public interface LiveChatCreateListener {
  void onCreateFailed(LiveCreateFailedReason paramLiveCreateFailedReason, String paramString);
  
  void onCreateSuccess(short paramShort, long paramLong, LiveChatInitData paramLiveChatInitData, Map<String, Object> paramMap);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\listener\LiveChatCreateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */