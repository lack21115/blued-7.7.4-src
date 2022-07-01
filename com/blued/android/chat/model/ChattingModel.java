package com.blued.android.chat.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.google.gson.Gson;
import java.util.Map;

public class ChattingModel {
  public PushMsgPackage _pushMsgPackage;
  
  public int app;
  
  public String avatarPendant;
  
  public int dbId;
  
  public String fromAvatar;
  
  public String fromDistance;
  
  public int fromFriend;
  
  public int fromHideVipLook;
  
  public long fromId;
  
  public int fromLiveManager;
  
  public String fromNickName;
  
  public int fromOnline;
  
  public int fromRichLevel;
  
  public int fromVBadge;
  
  public int fromVipAnnual;
  
  public int fromVipExpLvl;
  
  public int fromVipGrade;
  
  public boolean isShowTime;
  
  public boolean liveChatListFollowed;
  
  public String msgAt;
  
  public String msgContent;
  
  private String msgExtra;
  
  public long msgId;
  
  public boolean msgIsDelete;
  
  public long msgLocalId;
  
  public Map<String, Object> msgMapExtra;
  
  public long msgPreviousId;
  
  public short msgStateCode;
  
  public String msgTextTranslateContent;
  
  public int msgTextTranslateIsShow;
  
  public int msgTextTranslateStatus;
  
  public long msgTimestamp;
  
  public short msgType;
  
  public String msgVideoCoverUrlLocal;
  
  public int oFromFaceStatus;
  
  public int ofromHideVipLook;
  
  public int ofromVipGrade;
  
  public long sessionId;
  
  public short sessionType;
  
  public int status;
  
  public long toId;
  
  public ChattingModel() {}
  
  public ChattingModel(ChattingModel paramChattingModel) {
    this.app = paramChattingModel.app;
    this.dbId = paramChattingModel.dbId;
    this.toId = paramChattingModel.toId;
    this.fromId = paramChattingModel.fromId;
    this.fromNickName = paramChattingModel.fromNickName;
    this.fromAvatar = paramChattingModel.fromAvatar;
    this.fromDistance = paramChattingModel.fromDistance;
    this.fromVBadge = paramChattingModel.fromVBadge;
    this.fromRichLevel = paramChattingModel.fromRichLevel;
    this.fromVipGrade = paramChattingModel.fromVipGrade;
    this.fromVipAnnual = paramChattingModel.fromVipAnnual;
    this.fromVipExpLvl = paramChattingModel.fromVipExpLvl;
    this.ofromVipGrade = paramChattingModel.ofromVipGrade;
    this.ofromHideVipLook = paramChattingModel.ofromHideVipLook;
    this.oFromFaceStatus = paramChattingModel.oFromFaceStatus;
    this.fromLiveManager = paramChattingModel.fromLiveManager;
    this.fromHideVipLook = paramChattingModel.fromHideVipLook;
    this.fromOnline = paramChattingModel.fromOnline;
    this.msgMapExtra = paramChattingModel.msgMapExtra;
    this.sessionId = paramChattingModel.sessionId;
    this.sessionType = paramChattingModel.sessionType;
    this.msgPreviousId = paramChattingModel.msgPreviousId;
    this.msgIsDelete = paramChattingModel.msgIsDelete;
    this.msgContent = paramChattingModel.msgContent;
    this.msgTimestamp = paramChattingModel.msgTimestamp;
    this.msgLocalId = paramChattingModel.msgLocalId;
    this.msgId = paramChattingModel.msgId;
    this.msgType = paramChattingModel.msgType;
    this.msgStateCode = paramChattingModel.msgStateCode;
    this.msgVideoCoverUrlLocal = paramChattingModel.msgVideoCoverUrlLocal;
    this.msgTextTranslateIsShow = paramChattingModel.msgTextTranslateIsShow;
    this.msgTextTranslateContent = paramChattingModel.msgTextTranslateContent;
    this.msgTextTranslateStatus = paramChattingModel.msgTextTranslateStatus;
    this._pushMsgPackage = paramChattingModel._pushMsgPackage;
    this.avatarPendant = paramChattingModel.avatarPendant;
  }
  
  public String getMsgExtra() {
    if (TextUtils.isEmpty(this.msgExtra) && this.msgMapExtra != null)
      this.msgExtra = (new Gson()).toJson(this.msgMapExtra); 
    return this.msgExtra;
  }
  
  public boolean isFromSelf() {
    return (ChatManager.userInfo.uid == this.fromId);
  }
  
  public void setMsgExtra(String paramString) {
    this.msgExtra = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\model\ChattingModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */