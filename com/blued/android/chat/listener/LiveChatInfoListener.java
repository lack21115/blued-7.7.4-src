package com.blued.android.chat.listener;

import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.model.ChattingModel;
import java.util.List;

public interface LiveChatInfoListener {
  void onClose(LiveCloseReason paramLiveCloseReason, LiveChatStatistics paramLiveChatStatistics);
  
  void onJoinLive(JoinLiveResult paramJoinLiveResult, String paramString1, String paramString2, String paramString3);
  
  void onRecvNewMsg(ChattingModel paramChattingModel);
  
  void onViewerDataChanged(long paramLong, List<ProfileData> paramList);
  
  void onViewerEntrance(EntranceData paramEntranceData, long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\listener\LiveChatInfoListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */