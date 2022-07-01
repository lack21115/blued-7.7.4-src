package com.blued.android.chat.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.utils.ChatHelper;
import java.util.List;
import java.util.Set;

public class SessionModel {
  public boolean _isRequestingInfo = false;
  
  public List<ChattingModel> _msgList;
  
  public boolean _secretMsgListing;
  
  public Set<Long> _unreadedMsgIds;
  
  public long atMessageId;
  
  public String avatar;
  
  public boolean checked = false;
  
  public boolean chooseable = true;
  
  public int dbId;
  
  public long expireTime;
  
  public int friend;
  
  public int hasReply;
  
  public int hideVipLook;
  
  public boolean isFromSearch = false;
  
  public String lastDraft;
  
  public long lastGiftMsgId;
  
  public String lastMsgContent;
  
  public String lastMsgExtra;
  
  public int lastMsgFromApp;
  
  public String lastMsgFromAvatar;
  
  public String lastMsgFromDistance;
  
  public long lastMsgFromId;
  
  public String lastMsgFromNickname;
  
  public int lastMsgFromOnline;
  
  public long lastMsgId;
  
  public long lastMsgLocalId;
  
  public short lastMsgStateCode;
  
  public long lastMsgTime;
  
  public short lastMsgType;
  
  public int lieTop;
  
  public int likeNumUnread;
  
  public long maxHasReadMsgID = 0L;
  
  public long maxMsgId;
  
  public long maxRcvOppMsgId;
  
  public String nickName;
  
  public int noReadMsgCount = 0;
  
  public int oFaceStatus;
  
  public int ohideVipLook;
  
  public int onLineState = 0;
  
  public int online;
  
  public int ovipGrade;
  
  public int secretLookStatus = 0;
  
  public long sessionId;
  
  public SessionSettingBaseModel sessionSettingModel;
  
  public int sessionStatus;
  
  public short sessionType;
  
  public int sourceFrom = 0;
  
  public float totalMoney;
  
  public int unreadGiftCnt;
  
  public int vBadge;
  
  public int vipAnnual;
  
  public int vipExpLvl;
  
  public int vipGrade;
  
  public static boolean needRequestSessionInfo(SessionModel paramSessionModel) {
    if (paramSessionModel != null) {
      short s = paramSessionModel.sessionType;
      if (s != 2 && s != 3)
        return false; 
      if (!paramSessionModel._isRequestingInfo && TextUtils.isEmpty(paramSessionModel.nickName))
        return true; 
    } 
    return false;
  }
  
  public static void removeSessionLastMsg(SessionModel paramSessionModel) {
    paramSessionModel.lastMsgContent = "";
    paramSessionModel.lastMsgLocalId = 0L;
    paramSessionModel.lastMsgId = 0L;
    paramSessionModel.maxMsgId = 0L;
    paramSessionModel.lastMsgType = 0;
    paramSessionModel.lastMsgStateCode = 0;
    paramSessionModel.lastMsgFromId = 0L;
    paramSessionModel.lastMsgFromNickname = "";
    paramSessionModel.lastMsgFromAvatar = "";
    paramSessionModel.lastMsgFromDistance = "";
    paramSessionModel.noReadMsgCount = 0;
    ChatHelper.clearSessionLikeNum(paramSessionModel);
    paramSessionModel.lastMsgExtra = "";
    paramSessionModel.lastMsgFromApp = 0;
  }
  
  public static void setSessionForLastMsg(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    StringBuilder stringBuilder;
    paramSessionModel.maxMsgId = paramChattingModel.msgId;
    if (ChatHelper.isIgnoreNotifyMsgType(paramChattingModel) || paramChattingModel.msgIsDelete) {
      if (ChatManager.debug) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("isIgnoreNoticeMsgType, msgData:");
        stringBuilder.append(paramChattingModel);
        stringBuilder.append(", type:");
        stringBuilder.append(paramChattingModel.msgType);
        Log.v("setSessionForLastMsg", stringBuilder.toString());
      } 
      return;
    } 
    if (paramChattingModel.msgType == 169) {
      if (paramChattingModel.msgMapExtra != null)
        if (paramChattingModel.isFromSelf() && paramChattingModel.msgMapExtra.containsKey("sender_tips")) {
          ((SessionModel)stringBuilder).lastMsgContent = (String)paramChattingModel.msgMapExtra.get("sender_tips");
        } else if (!paramChattingModel.isFromSelf() && paramChattingModel.msgMapExtra.containsKey("receiver_tips")) {
          ((SessionModel)stringBuilder).lastMsgContent = (String)paramChattingModel.msgMapExtra.get("receiver_tips");
        }  
    } else {
      ((SessionModel)stringBuilder).lastMsgContent = paramChattingModel.msgContent;
    } 
    ((SessionModel)stringBuilder).lastMsgTime = paramChattingModel.msgTimestamp;
    ((SessionModel)stringBuilder).lastMsgLocalId = paramChattingModel.msgLocalId;
    ((SessionModel)stringBuilder).lastMsgId = paramChattingModel.msgId;
    ((SessionModel)stringBuilder).lastMsgType = paramChattingModel.msgType;
    ((SessionModel)stringBuilder).lastMsgFromApp = paramChattingModel.app;
    ((SessionModel)stringBuilder).lastMsgStateCode = paramChattingModel.msgStateCode;
    ((SessionModel)stringBuilder).lastMsgFromId = paramChattingModel.fromId;
    if (!TextUtils.isEmpty(paramChattingModel.fromNickName))
      ((SessionModel)stringBuilder).lastMsgFromNickname = paramChattingModel.fromNickName; 
    if (!TextUtils.isEmpty(paramChattingModel.fromAvatar))
      ((SessionModel)stringBuilder).lastMsgFromAvatar = paramChattingModel.fromAvatar; 
    ((SessionModel)stringBuilder).lastMsgFromDistance = paramChattingModel.fromDistance;
    ((SessionModel)stringBuilder).lastMsgExtra = paramChattingModel.getMsgExtra();
    ((SessionModel)stringBuilder).lastMsgFromOnline = paramChattingModel.fromOnline;
    if (paramChattingModel.msgType == 42) {
      ((SessionModel)stringBuilder).sessionStatus = 1;
    } else if (paramChattingModel.msgType == 43) {
      ((SessionModel)stringBuilder).sessionStatus = 0;
    } 
    if (paramChattingModel.isFromSelf()) {
      ((SessionModel)stringBuilder).friend = 1;
      ((SessionModel)stringBuilder).hasReply = 1;
      return;
    } 
    if (paramChattingModel.fromFriend > 0)
      ((SessionModel)stringBuilder).friend = 1; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\model\SessionModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */