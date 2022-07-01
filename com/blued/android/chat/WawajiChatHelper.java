package com.blued.android.chat;

import android.os.Handler;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.chat.WawajiChat;
import com.blued.android.chat.data.ProfileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WawajiChatHelper implements WawajiChat.IWawajiChatCallback {
  public static int MAX_VIEWER_COUNT_CALLBACK = 3;
  
  public static int MAX_VIEWER_COUNT_MEMORY = 30;
  
  private static final String TAG = "Chat_WawajiChat";
  
  private WawajiChatCallback callback;
  
  private Handler callbackHandler;
  
  private ChatState chatState = ChatState.IDLE;
  
  private long sessionId;
  
  private List<ProfileData> viewerList = new ArrayList<ProfileData>();
  
  private List<ProfileData> viewerListCallback = new ArrayList<ProfileData>();
  
  private WawajiChat wawajiChat;
  
  public WawajiChatHelper(long paramLong, WawajiChatCallback paramWawajiChatCallback, Handler paramHandler) {
    this.callback = paramWawajiChatCallback;
    this.callbackHandler = paramHandler;
    this.sessionId = paramLong;
    this.wawajiChat = ChatManager.getInstance().registerWawajiHelper(this);
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("初始化娃娃机直播间, sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
  }
  
  private void addViewer(ProfileData paramProfileData) {
    synchronized (this.viewerList) {
      this.viewerList.add(0, paramProfileData);
      return;
    } 
  }
  
  private boolean checkOperation(long paramLong, ChatState paramChatState) {
    StringBuilder stringBuilder;
    if (this.sessionId != paramLong) {
      if (ChatManager.debug) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("sessionId不匹配, 不进行该操作, 当前sessionId:");
        stringBuilder.append(this.sessionId);
        stringBuilder.append(", 通知sessionId:");
        stringBuilder.append(paramLong);
        Log.e("Chat_WawajiChat", stringBuilder.toString());
      } 
      return false;
    } 
    if (this.chatState != stringBuilder) {
      if (ChatManager.debug) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("当前状态不对, 不进行该操作, 当前chatState:");
        stringBuilder.append(this.chatState);
        stringBuilder.append(", 期待:");
        stringBuilder.append(ChatState.ENTER);
        Log.e("Chat_WawajiChat", stringBuilder.toString());
      } 
      return false;
    } 
    return true;
  }
  
  private void collateViewerCallback() {
    // Byte code:
    //   0: aload_0
    //   1: getfield viewerListCallback : Ljava/util/List;
    //   4: invokeinterface clear : ()V
    //   9: aload_0
    //   10: getfield viewerList : Ljava/util/List;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: iconst_0
    //   17: istore_1
    //   18: iload_1
    //   19: getstatic com/blued/android/chat/WawajiChatHelper.MAX_VIEWER_COUNT_CALLBACK : I
    //   22: if_icmpge -> 65
    //   25: aload_0
    //   26: getfield viewerList : Ljava/util/List;
    //   29: invokeinterface size : ()I
    //   34: iload_1
    //   35: if_icmple -> 65
    //   38: aload_0
    //   39: getfield viewerListCallback : Ljava/util/List;
    //   42: aload_0
    //   43: getfield viewerList : Ljava/util/List;
    //   46: iload_1
    //   47: invokeinterface get : (I)Ljava/lang/Object;
    //   52: invokeinterface add : (Ljava/lang/Object;)Z
    //   57: pop
    //   58: iload_1
    //   59: iconst_1
    //   60: iadd
    //   61: istore_1
    //   62: goto -> 18
    //   65: aload_2
    //   66: monitorexit
    //   67: return
    //   68: astore_3
    //   69: aload_2
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   18	58	68	finally
    //   65	67	68	finally
    //   69	71	68	finally
  }
  
  private void initViewerList(List<ProfileData> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: getfield viewerList : Ljava/util/List;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull -> 31
    //   11: aload_0
    //   12: getfield viewerList : Ljava/util/List;
    //   15: invokeinterface clear : ()V
    //   20: aload_0
    //   21: getfield viewerList : Ljava/util/List;
    //   24: aload_1
    //   25: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   30: pop
    //   31: aload_2
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   11	31	34	finally
    //   31	33	34	finally
    //   35	37	34	finally
  }
  
  private void leaveRoom() {
    setState(ChatState.DEAD);
    this.wawajiChat.leaveRoom(this.sessionId);
  }
  
  private void notifyCallback(Runnable paramRunnable) {
    Handler handler = this.callbackHandler;
    if (handler != null) {
      handler.post(paramRunnable);
      return;
    } 
    paramRunnable.run();
  }
  
  private void removeViewer(ProfileData paramProfileData) {
    synchronized (this.viewerList) {
      Iterator<ProfileData> iterator = this.viewerList.iterator();
      while (iterator.hasNext()) {
        if (((ProfileData)iterator.next()).uid == paramProfileData.uid) {
          iterator.remove();
          break;
        } 
      } 
      return;
    } 
  }
  
  private void setState(ChatState paramChatState) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("current state:");
      stringBuilder.append(this.chatState);
      stringBuilder.append(", change to:");
      stringBuilder.append(paramChatState);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    this.chatState = paramChatState;
  }
  
  private void trimViewerList() {
    synchronized (this.viewerList) {
      while (this.viewerList.size() > MAX_VIEWER_COUNT_MEMORY)
        this.viewerList.remove(this.viewerList.size() - 1); 
      return;
    } 
  }
  
  public void cancelQueueUp() {
    if (ChatManager.debug)
      Log.v("Chat_WawajiChat", "执行取消抢位操作"); 
    if (checkOperation(this.sessionId, ChatState.ENTER))
      this.wawajiChat.cancelQueueUp(this.sessionId); 
  }
  
  public void destroy() {
    if (ChatManager.debug)
      Log.v("Chat_WawajiChat", "销毁娃娃机直播间"); 
    setState(ChatState.DEAD);
    leaveRoom();
    this.wawajiChat = null;
    ChatManager.getInstance().unregisterWawajiHelper(this);
  }
  
  public void enter() {
    if (ChatManager.debug)
      Log.v("Chat_WawajiChat", "执行加入房间"); 
    if (checkOperation(this.sessionId, ChatState.IDLE))
      this.wawajiChat.enterRoom(this.sessionId); 
  }
  
  public void onCancelQueueUpFailed(long paramLong, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("取消排队抢位失败, errorMsg:");
      stringBuilder.append(paramString);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
  }
  
  public void onCancelQueueUpSuccess(long paramLong) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("取消排队抢位成功, sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
  }
  
  public void onEnterRoomFailed(long paramLong, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("进入房间失败, errorMsg:");
      stringBuilder.append(paramString);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.e("Chat_WawajiChat", stringBuilder.toString());
    } 
    if (checkOperation(paramLong, ChatState.IDLE))
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.callback.onEnterFailed();
            }
          }); 
  }
  
  public void onEnterRoomSuccess(long paramLong, final int price, final int goodsId, final int lifetimeSec, final int rank, final int queueUpCount, final int beans, final String roomId, final String stream1, final String stream2, final Map<String, Object> extraMapValues) {
    if (ChatManager.debug)
      Log.v("Chat_WawajiChat", "进入房间成功"); 
    if (checkOperation(paramLong, ChatState.IDLE)) {
      setState(ChatState.ENTER);
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.callback.onEnterSuccess(price, goodsId, lifetimeSec, rank, queueUpCount, beans, roomId, stream1, stream2, extraMapValues);
            }
          });
      this.wawajiChat.getRoomInfo(paramLong);
    } 
  }
  
  public void onGameResultUpdate(long paramLong, final int result, final ProfileData player, final String tips, String paramString2, final String wawaImage, final String wawaName, final int giftBonus, final Map<String, Object> extraMapValues) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("娃娃机游戏结果通知, sessionId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", result:");
      stringBuilder.append(result);
      stringBuilder.append(", tipsPlayer:");
      stringBuilder.append(tips);
      stringBuilder.append(", tipsViewer:");
      stringBuilder.append(paramString2);
      stringBuilder.append(", wawaImage:");
      stringBuilder.append(wawaImage);
      stringBuilder.append(", wawaName:");
      stringBuilder.append(wawaName);
      stringBuilder.append(", giftBonus:");
      stringBuilder.append(giftBonus);
      stringBuilder.append(", player:");
      stringBuilder.append(player);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    if (checkOperation(paramLong, ChatState.ENTER)) {
      if (player == null || player.uid != ChatManager.getInstance().getUid())
        tips = paramString2; 
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.callback.onGameResultUpdate(player, result, tips, wawaImage, wawaName, giftBonus, extraMapValues);
            }
          });
    } 
  }
  
  public void onGetInfoFailed(long paramLong, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("获取房间信息失败, errorMsg:");
      stringBuilder.append(paramString);
      Log.e("Chat_WawajiChat", stringBuilder.toString());
    } 
    checkOperation(paramLong, ChatState.ENTER);
  }
  
  public void onGetInfoSuccess(long paramLong) {
    if (ChatManager.debug)
      Log.v("Chat_WawajiChat", "获取房间信息成功"); 
    checkOperation(paramLong, ChatState.ENTER);
  }
  
  public void onIMConnected() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("IM重新连接上了，娃娃机尝试recover, sessionId:");
      stringBuilder.append(this.sessionId);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    this.wawajiChat.recover(this.sessionId);
    this.wawajiChat.getRoomInfo(this.sessionId);
  }
  
  public void onLeaveRoomFailed(long paramLong, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("离开房间失败, errorMsg:");
      stringBuilder.append(paramString);
      Log.e("Chat_WawajiChat", stringBuilder.toString());
    } 
    checkOperation(paramLong, ChatState.DEAD);
  }
  
  public void onLeaveRoomSuccess(long paramLong) {
    if (ChatManager.debug)
      Log.v("Chat_WawajiChat", "离开房间成功"); 
    checkOperation(paramLong, ChatState.DEAD);
  }
  
  public void onPlayerUpdate(long paramLong, final ProfileData playerData) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("玩家变化通知, sessionId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", playerData:");
      stringBuilder.append(playerData);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    if (checkOperation(paramLong, ChatState.ENTER))
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.callback.onPlayerUpdate(playerData);
            }
          }); 
  }
  
  public void onQueueCountUpdate(long paramLong, final int count) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("排队总数变化通知, count:");
      stringBuilder.append(count);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    if (checkOperation(paramLong, ChatState.ENTER))
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.callback.onQueueUpCountUpdate(count);
            }
          }); 
  }
  
  public void onQueueRankUpdate(long paramLong, final int rank) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("自己的排位变化通知, rank:");
      stringBuilder.append(rank);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    if (checkOperation(paramLong, ChatState.ENTER))
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.callback.onQueueUpRankUpdate(rank);
            }
          }); 
  }
  
  public void onQueueUpFailed(long paramLong, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("排队抢位失败, errorMsg:");
      stringBuilder.append(paramString);
      Log.e("Chat_WawajiChat", stringBuilder.toString());
    } 
    if (checkOperation(paramLong, ChatState.ENTER))
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.callback.onQueueUpFailed();
            }
          }); 
  }
  
  public void onQueueUpSuccess(long paramLong, final int rank) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("排队抢位成功, rank:");
      stringBuilder.append(rank);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    if (checkOperation(paramLong, ChatState.ENTER))
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.callback.onQueueUpSuccess(rank);
            }
          }); 
  }
  
  public void onViewIn(long paramLong, final ProfileData viewerIn, final int count) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("加入娃娃机, count:");
      stringBuilder.append(count);
      stringBuilder.append(", viewerIn:");
      stringBuilder.append(viewerIn);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    removeViewer(viewerIn);
    addViewer(viewerIn);
    trimViewerList();
    notifyCallback(new Runnable() {
          public void run() {
            WawajiChatHelper.this.collateViewerCallback();
            WawajiChatHelper.this.callback.onViewerUpdate(count, WawajiChatHelper.this.viewerListCallback);
            WawajiChatHelper.this.callback.onViewerIn(viewerIn);
          }
        });
  }
  
  public void onViewOut(long paramLong, ProfileData paramProfileData, final int count) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("退出娃娃机, count:");
      stringBuilder.append(count);
      stringBuilder.append(", viewerOut:");
      stringBuilder.append(paramProfileData);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    removeViewer(paramProfileData);
    trimViewerList();
    notifyCallback(new Runnable() {
          public void run() {
            WawajiChatHelper.this.collateViewerCallback();
            WawajiChatHelper.this.callback.onViewerUpdate(count, WawajiChatHelper.this.viewerListCallback);
          }
        });
  }
  
  public void onViewerUpdate(long paramLong, final int count, List<ProfileData> paramList) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("娃娃机房间观众更新, sessionId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", count:");
      stringBuilder.append(count);
      Log.v("Chat_WawajiChat", stringBuilder.toString());
    } 
    if (checkOperation(paramLong, ChatState.ENTER)) {
      initViewerList(paramList);
      trimViewerList();
      notifyCallback(new Runnable() {
            public void run() {
              WawajiChatHelper.this.collateViewerCallback();
              WawajiChatHelper.this.callback.onViewerUpdate(count, WawajiChatHelper.this.viewerListCallback);
            }
          });
    } 
  }
  
  public void queueUp() {
    if (ChatManager.debug)
      Log.v("Chat_WawajiChat", "执行抢位操作"); 
    if (checkOperation(this.sessionId, ChatState.ENTER))
      this.wawajiChat.queueUp(this.sessionId); 
  }
  
  enum ChatState {
    DEAD, ENTER, IDLE;
    
    static {
      DEAD = new ChatState("DEAD", 2);
      $VALUES = new ChatState[] { IDLE, ENTER, DEAD };
    }
  }
  
  public static interface WawajiChatCallback {
    void onEnterFailed();
    
    void onEnterSuccess(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, String param1String1, String param1String2, String param1String3, Map<String, Object> param1Map);
    
    void onGameResultUpdate(ProfileData param1ProfileData, int param1Int1, String param1String1, String param1String2, String param1String3, int param1Int2, Map<String, Object> param1Map);
    
    void onPlayerUpdate(ProfileData param1ProfileData);
    
    void onQueueUpCountUpdate(int param1Int);
    
    void onQueueUpFailed();
    
    void onQueueUpRankUpdate(int param1Int);
    
    void onQueueUpSuccess(int param1Int);
    
    void onViewerIn(ProfileData param1ProfileData);
    
    void onViewerUpdate(int param1Int, List<ProfileData> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\WawajiChatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */