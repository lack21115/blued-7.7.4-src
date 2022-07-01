package com.blued.android.chat;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.module.chat.model.SessionSetting;
import com.soft.blued.db.model.ChattingModelDB;
import com.soft.blued.db.model.SessionModelDB;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataTransform {
  public static ChattingModel transform(ChattingModelDB paramChattingModelDB) {
    if (paramChattingModelDB == null)
      return null; 
    ChattingModel chattingModel = new ChattingModel();
    chattingModel.dbId = paramChattingModelDB.dbId;
    chattingModel.fromId = paramChattingModelDB.fromId;
    chattingModel.toId = paramChattingModelDB.toId;
    chattingModel.fromNickName = paramChattingModelDB.fromNickName;
    chattingModel.fromAvatar = paramChattingModelDB.fromAvatar;
    chattingModel.fromDistance = paramChattingModelDB.fromDistance;
    chattingModel.fromVBadge = paramChattingModelDB.fromVBadge;
    chattingModel.fromOnline = paramChattingModelDB.fromOnline;
    chattingModel.fromVipGrade = paramChattingModelDB.fromVipGrade;
    chattingModel.fromVipAnnual = paramChattingModelDB.fromVipAnnual;
    chattingModel.fromVipExpLvl = paramChattingModelDB.fromVipExpLvl;
    chattingModel.fromHideVipLook = paramChattingModelDB.fromHideVipLook;
    chattingModel.setMsgExtra(paramChattingModelDB.getMsgExtra());
    chattingModel.sessionId = paramChattingModelDB.sessionId;
    chattingModel.sessionType = paramChattingModelDB.sessionType;
    chattingModel.msgPreviousId = paramChattingModelDB.msgPreviousId;
    chattingModel.msgIsDelete = paramChattingModelDB.msgIsDelete;
    chattingModel.msgContent = paramChattingModelDB.msgContent;
    chattingModel.msgTimestamp = paramChattingModelDB.msgTimestamp;
    chattingModel.msgLocalId = paramChattingModelDB.msgLocalId;
    chattingModel.msgId = paramChattingModelDB.msgId;
    chattingModel.msgType = paramChattingModelDB.msgType;
    chattingModel.app = paramChattingModelDB.app;
    chattingModel.msgStateCode = paramChattingModelDB.msgStateCode;
    chattingModel.msgVideoCoverUrlLocal = paramChattingModelDB.msgVideoCoverUrlLocal;
    chattingModel.msgTextTranslateIsShow = paramChattingModelDB.msgTextTranslateIsShow;
    chattingModel.msgTextTranslateContent = paramChattingModelDB.msgTextTranslateContent;
    chattingModel.msgTextTranslateStatus = paramChattingModelDB.msgTextTranslateStatus;
    return chattingModel;
  }
  
  public static SessionModel transform(SessionModelDB paramSessionModelDB) {
    if (paramSessionModelDB == null)
      return null; 
    SessionModel sessionModel = new SessionModel();
    sessionModel.dbId = paramSessionModelDB.dbId;
    sessionModel.sessionId = paramSessionModelDB.sessionId;
    sessionModel.sessionType = paramSessionModelDB.sessionType;
    sessionModel.nickName = paramSessionModelDB.nickName;
    sessionModel.avatar = paramSessionModelDB.avatar;
    sessionModel.sessionStatus = paramSessionModelDB.sessionStatus;
    sessionModel.online = paramSessionModelDB.online;
    sessionModel.vBadge = paramSessionModelDB.vBadge;
    sessionModel.vipGrade = paramSessionModelDB.vipGrade;
    sessionModel.vipAnnual = paramSessionModelDB.vipAnnual;
    sessionModel.vipExpLvl = paramSessionModelDB.vipExpLvl;
    sessionModel.hideVipLook = paramSessionModelDB.hideVipLook;
    sessionModel.noReadMsgCount = paramSessionModelDB.noReadMsgCount;
    sessionModel.maxHasReadMsgID = paramSessionModelDB.maxHasReadMsgID;
    sessionModel.lastMsgId = paramSessionModelDB.lastMsgId;
    sessionModel.lastMsgType = paramSessionModelDB.lastMsgType;
    sessionModel.lastMsgFromApp = paramSessionModelDB.lastMsgFromApp;
    sessionModel.lastMsgLocalId = paramSessionModelDB.lastMsgLocalId;
    sessionModel.lastMsgContent = paramSessionModelDB.lastMsgContent;
    sessionModel.lastMsgExtra = paramSessionModelDB.lastMsgExtra;
    sessionModel.lastMsgTime = paramSessionModelDB.lastMsgTime;
    sessionModel.lastMsgStateCode = paramSessionModelDB.lastMsgStateCode;
    sessionModel.lastMsgFromId = paramSessionModelDB.lastMsgFromId;
    sessionModel.lastMsgFromNickname = paramSessionModelDB.lastMsgFromNickname;
    sessionModel.lastMsgFromAvatar = paramSessionModelDB.lastMsgFromAvatar;
    sessionModel.lastMsgFromDistance = paramSessionModelDB.lastMsgFromDistance;
    sessionModel.lastMsgFromOnline = paramSessionModelDB.lastMsgFromOnline;
    sessionModel.maxRcvOppMsgId = paramSessionModelDB.maxRcvOppMsgId;
    sessionModel.lastDraft = paramSessionModelDB.lastDraft;
    sessionModel.sourceFrom = paramSessionModelDB.sourceFrom;
    sessionModel.lieTop = paramSessionModelDB.lieTop;
    sessionModel.lastGiftMsgId = paramSessionModelDB.lastGiftMsgId;
    sessionModel.unreadGiftCnt = paramSessionModelDB.unreadGiftCnt;
    sessionModel.friend = paramSessionModelDB.friend;
    sessionModel.expireTime = paramSessionModelDB.expireTime;
    sessionModel.totalMoney = paramSessionModelDB.totalMoney;
    sessionModel.maxMsgId = paramSessionModelDB.maxMsgId;
    sessionModel.hasReply = paramSessionModelDB.hasReply;
    sessionModel.secretLookStatus = paramSessionModelDB.secretLookStatus;
    return sessionModel;
  }
  
  public static SessionSetting transform(SessionSettingBaseModel paramSessionSettingBaseModel) {
    return (paramSessionSettingBaseModel == null) ? null : transform((SessionSettingModel)paramSessionSettingBaseModel);
  }
  
  public static SessionSetting transform(SessionSettingModel paramSessionSettingModel) {
    if (paramSessionSettingModel == null)
      return null; 
    SessionSetting sessionSetting = new SessionSetting();
    sessionSetting.setDBId(paramSessionSettingModel.getDBId());
    sessionSetting.setId(paramSessionSettingModel.getId());
    sessionSetting.setSessionId(paramSessionSettingModel.getSessionId());
    sessionSetting.setSessionType(paramSessionSettingModel.getSessionType());
    sessionSetting.setLoadName(paramSessionSettingModel.getLoadName());
    sessionSetting.setRemindAudio(paramSessionSettingModel.getRemindAudio());
    sessionSetting.setGroupCreateId(paramSessionSettingModel.getGroupCreateId());
    sessionSetting.setGroupNumberNum(paramSessionSettingModel.getGroupNumberNum());
    sessionSetting.setGroupAdiminIDs(paramSessionSettingModel.getGroupAdiminIDs());
    sessionSetting.setLietop(paramSessionSettingModel.getLietop());
    sessionSetting.setUiStatus(paramSessionSettingModel.getUiStatus());
    sessionSetting.setChatBgUri(paramSessionSettingModel.getChatBgUri());
    sessionSetting.setSessinoNote(paramSessionSettingModel.getSessinoNote());
    sessionSetting.setInitiator(paramSessionSettingModel.getInitiator());
    sessionSetting.setFollower(paramSessionSettingModel.getFollower());
    sessionSetting.setNearby(paramSessionSettingModel.getNearby());
    sessionSetting.setOnline(paramSessionSettingModel.getOnline());
    return sessionSetting;
  }
  
  public static ChattingModelDB transform(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return null; 
    ChattingModelDB chattingModelDB = new ChattingModelDB();
    chattingModelDB.dbId = paramChattingModel.dbId;
    chattingModelDB.loadName = CommonTools.e(UserInfo.a().i().getUid());
    chattingModelDB.fromId = paramChattingModel.fromId;
    chattingModelDB.toId = paramChattingModel.toId;
    chattingModelDB.fromNickName = paramChattingModel.fromNickName;
    chattingModelDB.fromAvatar = paramChattingModel.fromAvatar;
    chattingModelDB.fromDistance = paramChattingModel.fromDistance;
    chattingModelDB.fromVBadge = paramChattingModel.fromVBadge;
    chattingModelDB.fromOnline = paramChattingModel.fromOnline;
    chattingModelDB.fromVipGrade = paramChattingModel.fromVipGrade;
    chattingModelDB.fromVipAnnual = paramChattingModel.fromVipAnnual;
    chattingModelDB.fromVipExpLvl = paramChattingModel.fromVipExpLvl;
    chattingModelDB.fromHideVipLook = paramChattingModel.fromHideVipLook;
    chattingModelDB.setMsgExtra(paramChattingModel.getMsgExtra());
    chattingModelDB.sessionId = paramChattingModel.sessionId;
    chattingModelDB.sessionType = paramChattingModel.sessionType;
    chattingModelDB.msgPreviousId = paramChattingModel.msgPreviousId;
    chattingModelDB.msgIsDelete = paramChattingModel.msgIsDelete;
    chattingModelDB.msgContent = paramChattingModel.msgContent;
    chattingModelDB.msgTimestamp = paramChattingModel.msgTimestamp;
    chattingModelDB.msgLocalId = paramChattingModel.msgLocalId;
    chattingModelDB.msgId = paramChattingModel.msgId;
    chattingModelDB.msgType = paramChattingModel.msgType;
    chattingModelDB.app = paramChattingModel.app;
    chattingModelDB.msgStateCode = paramChattingModel.msgStateCode;
    chattingModelDB.msgVideoCoverUrlLocal = paramChattingModel.msgVideoCoverUrlLocal;
    chattingModelDB.msgTextTranslateIsShow = paramChattingModel.msgTextTranslateIsShow;
    chattingModelDB.msgTextTranslateContent = paramChattingModel.msgTextTranslateContent;
    chattingModelDB.msgTextTranslateStatus = paramChattingModel.msgTextTranslateStatus;
    return chattingModelDB;
  }
  
  public static SessionModelDB transform(SessionModel paramSessionModel) {
    if (paramSessionModel == null)
      return null; 
    SessionModelDB sessionModelDB = new SessionModelDB();
    sessionModelDB.dbId = paramSessionModel.dbId;
    sessionModelDB.sessionId = paramSessionModel.sessionId;
    sessionModelDB.sessionType = paramSessionModel.sessionType;
    if (UserInfo.a().i() != null)
      sessionModelDB.loadName = CommonTools.e(UserInfo.a().i().getUid()); 
    sessionModelDB.nickName = paramSessionModel.nickName;
    sessionModelDB.avatar = paramSessionModel.avatar;
    sessionModelDB.sessionStatus = paramSessionModel.sessionStatus;
    sessionModelDB.online = paramSessionModel.online;
    sessionModelDB.vBadge = paramSessionModel.vBadge;
    sessionModelDB.vipGrade = paramSessionModel.vipGrade;
    sessionModelDB.vipAnnual = paramSessionModel.vipAnnual;
    sessionModelDB.vipExpLvl = paramSessionModel.vipExpLvl;
    sessionModelDB.hideVipLook = paramSessionModel.hideVipLook;
    sessionModelDB.noReadMsgCount = paramSessionModel.noReadMsgCount;
    sessionModelDB.maxHasReadMsgID = paramSessionModel.maxHasReadMsgID;
    sessionModelDB.lastMsgId = paramSessionModel.lastMsgId;
    sessionModelDB.lastMsgType = paramSessionModel.lastMsgType;
    sessionModelDB.lastMsgFromApp = paramSessionModel.lastMsgFromApp;
    sessionModelDB.lastMsgLocalId = paramSessionModel.lastMsgLocalId;
    sessionModelDB.lastMsgContent = paramSessionModel.lastMsgContent;
    sessionModelDB.lastMsgExtra = paramSessionModel.lastMsgExtra;
    sessionModelDB.lastMsgTime = paramSessionModel.lastMsgTime;
    sessionModelDB.lastMsgStateCode = paramSessionModel.lastMsgStateCode;
    sessionModelDB.lastMsgFromId = paramSessionModel.lastMsgFromId;
    sessionModelDB.lastMsgFromNickname = paramSessionModel.lastMsgFromNickname;
    sessionModelDB.lastMsgFromAvatar = paramSessionModel.lastMsgFromAvatar;
    sessionModelDB.lastMsgFromDistance = paramSessionModel.lastMsgFromDistance;
    sessionModelDB.lastMsgFromOnline = paramSessionModel.lastMsgFromOnline;
    sessionModelDB.maxRcvOppMsgId = paramSessionModel.maxRcvOppMsgId;
    sessionModelDB.lastDraft = paramSessionModel.lastDraft;
    sessionModelDB.sourceFrom = paramSessionModel.sourceFrom;
    sessionModelDB.lieTop = paramSessionModel.lieTop;
    sessionModelDB.unreadGiftCnt = paramSessionModel.unreadGiftCnt;
    sessionModelDB.lastGiftMsgId = paramSessionModel.lastGiftMsgId;
    sessionModelDB.friend = paramSessionModel.friend;
    sessionModelDB.expireTime = paramSessionModel.expireTime;
    sessionModelDB.totalMoney = paramSessionModel.totalMoney;
    sessionModelDB.maxMsgId = paramSessionModel.maxMsgId;
    sessionModelDB.hasReply = paramSessionModel.hasReply;
    sessionModelDB.secretLookStatus = paramSessionModel.secretLookStatus;
    return sessionModelDB;
  }
  
  public static SessionSettingModel transform(SessionSetting paramSessionSetting) {
    if (paramSessionSetting == null)
      return null; 
    SessionSettingModel sessionSettingModel = new SessionSettingModel();
    sessionSettingModel.setDBId(paramSessionSetting.getDBId());
    sessionSettingModel.setId(paramSessionSetting.getId());
    sessionSettingModel.setSessionId(paramSessionSetting.getSessionId());
    sessionSettingModel.setSessionType(paramSessionSetting.getSessionType());
    sessionSettingModel.setLoadName(paramSessionSetting.getLoadName());
    sessionSettingModel.setRemindAudio(paramSessionSetting.getRemindAudio());
    sessionSettingModel.setGroupCreateId(paramSessionSetting.getGroupCreateId());
    sessionSettingModel.setGroupNumberNum(paramSessionSetting.getGroupNumberNum());
    sessionSettingModel.setGroupAdiminIDs(paramSessionSetting.getGroupAdiminIDs());
    sessionSettingModel.setLietop(paramSessionSetting.getLietop());
    sessionSettingModel.setUiStatus(paramSessionSetting.getUiStatus());
    sessionSettingModel.setChatBgUri(paramSessionSetting.getChatBgUri());
    sessionSettingModel.setSessinoNote(paramSessionSetting.getSessinoNote());
    sessionSettingModel.setInitiator(paramSessionSetting.getInitiator());
    sessionSettingModel.setFollower(paramSessionSetting.getFollower());
    sessionSettingModel.setNearby(paramSessionSetting.getNearby());
    sessionSettingModel.setOnline(paramSessionSetting.getOnline());
    return sessionSettingModel;
  }
  
  public static List<ChattingModel> transformMessage(List<ChattingModelDB> paramList) {
    if (paramList == null)
      return null; 
    ArrayList<ChattingModel> arrayList = new ArrayList(paramList.size());
    Iterator<ChattingModelDB> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(transform(iterator.next())); 
    return arrayList;
  }
  
  public static List<SessionModel> transformSession(List<SessionModelDB> paramList) {
    if (paramList == null)
      return null; 
    ArrayList<SessionModel> arrayList = new ArrayList(paramList.size());
    Iterator<SessionModelDB> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(transform(iterator.next())); 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\DataTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */