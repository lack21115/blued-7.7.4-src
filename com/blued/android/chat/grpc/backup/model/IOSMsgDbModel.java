package com.blued.android.chat.grpc.backup.model;

import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.backup.annotation.DbTableName;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.chat.utils.ChatHelper;

@DbTableName(name = "MessageTable")
public class IOSMsgDbModel {
  public int app;
  
  public String at;
  
  public short deleteState;
  
  public String distance;
  
  public long fromId;
  
  public String fromUserAvatar;
  
  public String fromUserName;
  
  public short is_hide_vip_look;
  
  public long lastMessageId;
  
  public String messageContent;
  
  public long messageId;
  
  public short messageType;
  
  public String msgExtra;
  
  public long msgLocalId;
  
  public short o_is_hide_vip_look;
  
  public short o_vip_grade;
  
  public int online;
  
  public int reason;
  
  public int roomType;
  
  public short sendState;
  
  public long sendTime;
  
  public long sessionId;
  
  public short sessionType;
  
  public int totalTime;
  
  public String translateInfo;
  
  public short vbadge;
  
  public short vip_annual;
  
  public short vip_exp_lvl;
  
  public short vip_grade;
  
  public ChattingModel covertToAndroidModel() {
    boolean bool;
    ChattingModel chattingModel = new ChattingModel();
    chattingModel.sessionType = this.sessionType;
    chattingModel.sessionId = this.sessionId;
    chattingModel.msgLocalId = this.msgLocalId;
    chattingModel.msgStateCode = ChatHelper.transformIosSendStateToAndroid(this.sendState);
    chattingModel.msgType = this.messageType;
    chattingModel.fromId = this.fromId;
    chattingModel.msgContent = this.messageContent;
    chattingModel.fromNickName = this.fromUserName;
    chattingModel.fromAvatar = this.fromUserAvatar;
    chattingModel.msgId = this.messageId;
    chattingModel.msgPreviousId = this.lastMessageId;
    chattingModel.msgTimestamp = this.sendTime;
    if (this.deleteState == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    chattingModel.msgIsDelete = bool;
    chattingModel.fromDistance = this.distance;
    chattingModel.fromVipGrade = this.vip_grade;
    chattingModel.fromVipAnnual = this.vip_annual;
    chattingModel.fromVipExpLvl = this.vip_exp_lvl;
    chattingModel.fromHideVipLook = this.is_hide_vip_look;
    chattingModel.ofromHideVipLook = this.o_is_hide_vip_look;
    chattingModel.ofromVipGrade = this.o_vip_grade;
    chattingModel.msgTextTranslateContent = this.translateInfo;
    chattingModel.fromOnline = this.online;
    chattingModel.msgAt = this.at;
    short s = this.messageType;
    if (s == 53 || s == 52) {
      VideoChatMsgContentModel videoChatMsgContentModel = new VideoChatMsgContentModel();
      videoChatMsgContentModel.room_type = this.roomType;
      videoChatMsgContentModel.total_time = this.totalTime;
      chattingModel.setMsgExtra(PrivateChatManager.getInstance().getGson().toJson(videoChatMsgContentModel));
    } else {
      chattingModel.setMsgExtra(this.msgExtra);
    } 
    if (this.messageType == 3 && this.fromId != this.sessionId) {
      try {
        String[] arrayOfString = this.messageContent.split("\\|\\|");
        String str = arrayOfString[0].split(",,")[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfString[1]);
        stringBuilder.append(",,");
        stringBuilder.append(str);
        return chattingModel;
      } finally {
        Exception exception = null;
      } 
    } else {
      s = this.messageType;
      if ((s == 5 || s == 2 || s == 24) && this.fromId != this.sessionId)
        try {
          return chattingModel;
        } finally {
          Exception exception = null;
        }  
    } 
    return chattingModel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\backup\model\IOSMsgDbModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */