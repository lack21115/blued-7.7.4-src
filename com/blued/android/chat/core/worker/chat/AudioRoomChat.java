package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.SendAckPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.BaseWorker;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.AudioRoomChatData;
import com.blued.android.chat.listener.AudioRoomChatInfoListener;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.ChatHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class AudioRoomChat extends BaseWorker implements ConnectListener {
  private static final String TAG = "Chat_AudioChat";
  
  private final ArrayList<AudioRoomChatInfoListener> audioChatInfoListeners = new ArrayList<AudioRoomChatInfoListener>();
  
  Chat chat;
  
  Connector connector;
  
  PackSendHelper packSendHelper;
  
  SendMsgPackage sendPackage;
  
  private Object sessionLock = new Object();
  
  public AudioRoomChat(Connector paramConnector, Chat paramChat) {
    if (ChatManager.debug)
      Log.v("Chat_AudioChat", "AudioRoomChat() create"); 
    this.chat = paramChat;
    this.connector = paramConnector;
    this.packSendHelper = paramConnector.getPackageSendHelper();
    paramChat.audioRoomChat = this;
    this.connector.registerConnectListener(this);
  }
  
  private void notifyApplyAnchor(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyApplyAnchor(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onApplyAnchor(paramAudioRoomChatData); 
      return;
    } 
  }
  
  private void notifyCloseRoom(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyCloseRoom(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onCloseRoom(paramAudioRoomChatData); 
      return;
    } 
  }
  
  private void notifyKickedOut(ChattingModel paramChattingModel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyKickedOut(), msgData:");
    stringBuilder.append(paramChattingModel.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onKickedOut(paramChattingModel); 
      return;
    } 
  }
  
  private void notifyMemebersDecrease(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyAudioMemebersDecrease(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onMemebersDecrease(paramAudioRoomChatData); 
      return;
    } 
  }
  
  private void notifyMemebersIncrease(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyAudioMemebersIncrease(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onMemebersIncrease(paramAudioRoomChatData); 
      return;
    } 
  }
  
  private void notifyNewMsg(ChattingModel paramChattingModel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyNewMsg(), chattingModel:");
    stringBuilder.append(paramChattingModel.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onRecvNewMsg(paramChattingModel); 
      return;
    } 
  }
  
  private void notifyOffAnchor(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyOffAnchor(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onOffAnchor(paramAudioRoomChatData); 
      return;
    } 
  }
  
  private void notifyOnAnchor(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyOnAnchor(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onOnAnchor(paramAudioRoomChatData); 
      return;
    } 
  }
  
  private void notifyRefuseAnchor(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyRefuseAnchor(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onRefuseAnchor(paramAudioRoomChatData); 
      return;
    } 
  }
  
  private void notifySeatDecrease(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifySeatDecrease(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onSeatDecrease(paramAudioRoomChatData); 
      return;
    } 
  }
  
  private void notifySeatIncrease(AudioRoomChatData paramAudioRoomChatData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifySeatIncrease(), audioRoomChatData:");
    stringBuilder.append(paramAudioRoomChatData.toString());
    Log.v("Chat_AudioChat", stringBuilder.toString());
    synchronized (this.audioChatInfoListeners) {
      Iterator<AudioRoomChatInfoListener> iterator = this.audioChatInfoListeners.iterator();
      while (iterator.hasNext())
        ((AudioRoomChatInfoListener)iterator.next()).onSeatIncrease(paramAudioRoomChatData); 
      return;
    } 
  }
  
  public String getWorkerName() {
    return "AudioRoomChat";
  }
  
  public void onConnected() {}
  
  public void onConnecting() {}
  
  public void onDisconnected() {}
  
  protected void recvPushMsgPackage(PushMsgPackage paramPushMsgPackage) {
    ChattingModel chattingModel = PushMsgPackage.toMsgData(paramPushMsgPackage);
    if (chattingModel != null) {
      if (chattingModel.msgType == 1) {
        notifyNewMsg(chattingModel);
        return;
      } 
      if (chattingModel.msgType == 162) {
        notifyKickedOut(chattingModel);
        return;
      } 
      if (chattingModel.msgMapExtra != null) {
        AudioRoomChatData audioRoomChatData = new AudioRoomChatData();
        audioRoomChatData.session_id = chattingModel.sessionId;
        audioRoomChatData.session_type = chattingModel.sessionType;
        audioRoomChatData.msg_type = chattingModel.msgType;
        audioRoomChatData.parseExtraData(chattingModel.msgMapExtra);
        if (audioRoomChatData.room_data != null && audioRoomChatData.room_data.room_members != null) {
          short s = chattingModel.msgType;
          switch (s) {
            default:
              switch (s) {
                default:
                  return;
                case 199:
                  notifyCloseRoom(audioRoomChatData);
                  return;
                case 198:
                  notifyRefuseAnchor(audioRoomChatData);
                  notifyNewMsg(chattingModel);
                  return;
                case 197:
                  notifyOnAnchor(audioRoomChatData);
                  notifyNewMsg(chattingModel);
                  return;
                case 196:
                  notifyOffAnchor(audioRoomChatData);
                  return;
                case 195:
                  break;
              } 
              notifyApplyAnchor(audioRoomChatData);
              return;
            case 161:
              notifySeatIncrease(audioRoomChatData);
              return;
            case 160:
              notifySeatDecrease(audioRoomChatData);
              return;
            case 159:
              notifyMemebersDecrease(audioRoomChatData);
              return;
            case 158:
              break;
          } 
          notifyMemebersIncrease(audioRoomChatData);
        } 
      } 
    } 
  }
  
  protected void recvSendAckPackage(SendAckPackage paramSendAckPackage) {
    if (paramSendAckPackage.result != 0) {
      ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
      if (chatTipsListener != null)
        chatTipsListener.onSendMsgFailed(this.sendPackage.sessionType, this.sendPackage.sessionId, paramSendAckPackage.result); 
    } 
  }
  
  public void registerAudioRoomChatListener(AudioRoomChatInfoListener paramAudioRoomChatInfoListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerLiveChatListener(), audioChatInfoListener:");
      stringBuilder.append(paramAudioRoomChatInfoListener.hashCode());
      Log.v("Chat_AudioChat", stringBuilder.toString());
    } 
    synchronized (this.audioChatInfoListeners) {
      if (!this.audioChatInfoListeners.contains(paramAudioRoomChatInfoListener))
        this.audioChatInfoListeners.add(paramAudioRoomChatInfoListener); 
      return;
    } 
  }
  
  protected void sendMsg(ChattingModel paramChattingModel, MsgPreProcesser paramMsgPreProcesser) {
    if (ChatManager.debug)
      Log.v("Chat_AudioChat", "sendMsg()"); 
    paramChattingModel.msgStateCode = 1;
    paramChattingModel.msgId = 0L;
    paramChattingModel.msgPreviousId = 0L;
    paramChattingModel.msgLocalId = ChatHelper.getLocalId();
    paramChattingModel.msgTimestamp = System.currentTimeMillis();
    synchronized (this.sessionLock) {
      notifyNewMsg(paramChattingModel);
      this.sendPackage = ChatHelper.getSendMsgPackageFromChattingModel(paramChattingModel);
      this.packSendHelper.sendPackage((BasePackage)this.sendPackage, new PackSendHelper.PackCallback() {
            public void onAckTimeout(BasePackage param1BasePackage) {}
            
            public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {
              if (param1BasePackage2 instanceof SendAckPackage)
                AudioRoomChat.this.recvSendAckPackage((SendAckPackage)param1BasePackage2); 
            }
            
            public void onSendFailed(BasePackage param1BasePackage) {}
            
            public void onSendFinish(BasePackage param1BasePackage) {}
            
            public void onSendTimeout(BasePackage param1BasePackage) {}
          });
      return;
    } 
  }
  
  public void unregisterAudioRoomChatListener(AudioRoomChatInfoListener paramAudioRoomChatInfoListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterLiveChatListener(),  audioChatInfoListener:");
      stringBuilder.append(paramAudioRoomChatInfoListener.hashCode());
      Log.v("Chat_AudioChat", stringBuilder.toString());
    } 
    synchronized (this.audioChatInfoListeners) {
      if (this.audioChatInfoListeners.contains(paramAudioRoomChatInfoListener))
        this.audioChatInfoListeners.remove(paramAudioRoomChatInfoListener); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\AudioRoomChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */