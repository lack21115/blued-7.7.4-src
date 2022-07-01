package com.blued.android.chat.core.worker.chat;

import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.model.ChattingModel;
import java.util.ArrayList;
import java.util.List;

public class RoomChat {
  private static final String TAG = "Chat_RoomChat";
  
  Chat chat;
  
  private long singleRoomId;
  
  public RoomChat(Chat paramChat) {
    if (ChatManager.debug)
      Log.v("Chat_RoomChat", "LiveChat() create"); 
    this.chat = paramChat;
    this.chat.roomChat = this;
  }
  
  private boolean handleRoomPushMessage(PushMsgPackage paramPushMsgPackage) {
    if (paramPushMsgPackage.msgType == 110 || paramPushMsgPackage.msgType == 111 || paramPushMsgPackage.msgType == 112) {
      ChattingModel chattingModel = PushMsgPackage.toMsgData(paramPushMsgPackage);
      ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
      if (chatTipsListener != null)
        chatTipsListener.onRecvNewMsg(null, chattingModel); 
      return true;
    } 
    return false;
  }
  
  private boolean isRoomMessage(PushMsgPackage paramPushMsgPackage) {
    return (paramPushMsgPackage != null && paramPushMsgPackage.sessionType == 7 && paramPushMsgPackage.sessionId == this.singleRoomId);
  }
  
  private void removeRoomSessionAndMessage(long paramLong) {
    ArrayList<Pair> arrayList = new ArrayList();
    arrayList.add(new Pair(Short.valueOf((short)7), Long.valueOf(paramLong)));
    this.chat.deleteSessions((List)arrayList, true);
  }
  
  private void setupRoomSession(long paramLong) {
    this.chat.insertEmptySession((short)7, paramLong);
  }
  
  protected boolean handleRoomMessage(PushMsgPackage paramPushMsgPackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("handleRoomMessage() pushMsgPackage:");
      stringBuilder.append(paramPushMsgPackage);
      Log.v("Chat_RoomChat", stringBuilder.toString());
    } 
    if (!isRoomMessage(paramPushMsgPackage)) {
      if (ChatManager.debug)
        Log.v("Chat_RoomChat", "it is not current room message, drop it."); 
      return true;
    } 
    return handleRoomPushMessage(paramPushMsgPackage);
  }
  
  protected void setupRoomId(long paramLong) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setupRoomId() roomId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_RoomChat", stringBuilder.toString());
    } 
    this.singleRoomId = paramLong;
  }
  
  public void switchRoomId(long paramLong) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("switchRoomId(), currentRoomId:");
      stringBuilder.append(this.singleRoomId);
      stringBuilder.append(", newRoodId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_RoomChat", stringBuilder.toString());
    } 
    long l = this.singleRoomId;
    if (l == paramLong)
      return; 
    this.singleRoomId = paramLong;
    removeRoomSessionAndMessage(l);
    if (paramLong > 0L)
      setupRoomSession(paramLong); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\RoomChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */