package com.blued.android.chat.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.MsgReceiveModelChina;
import com.blued.android.chat.model.MsgReceiveModelInter;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ChatHelper {
  private static final String TAG = ChatHelper.class.getSimpleName();
  
  private static long localId = System.currentTimeMillis() / 1000L;
  
  public static PushMsgPackage checkMsgType(PushMsgPackage paramPushMsgPackage) {
    if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
      if (paramPushMsgPackage.msgType == 41 || paramPushMsgPackage.msgType == 56 || paramPushMsgPackage.msgType == 57 || paramPushMsgPackage.msgType == 58 || paramPushMsgPackage.msgType == 67 || paramPushMsgPackage.msgType == 75 || paramPushMsgPackage.msgType == 105 || paramPushMsgPackage.msgType == 113 || paramPushMsgPackage.msgType == 124) {
        paramPushMsgPackage.pushBasePackage.msgHeader.isDeleted = true;
        return paramPushMsgPackage;
      } 
    } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL && paramPushMsgPackage.msgType == 205) {
      paramPushMsgPackage.pushBasePackage.msgHeader.isDeleted = true;
    } 
    return paramPushMsgPackage;
  }
  
  public static void clearSessionLikeNum(SessionModel paramSessionModel) {
    if (paramSessionModel != null)
      paramSessionModel.likeNumUnread = 0; 
  }
  
  public static SessionModel createEmptySessionModel(short paramShort, long paramLong) {
    SessionModel sessionModel = new SessionModel();
    sessionModel.sessionType = paramShort;
    sessionModel.sessionId = paramLong;
    ChatManager.dbOperImpl.saveSession(sessionModel);
    SessionSettingBaseModel sessionSettingBaseModel2 = ChatManager.dbOperImpl.getSessionSetting(sessionModel.sessionType, sessionModel.sessionId);
    SessionSettingBaseModel sessionSettingBaseModel1 = sessionSettingBaseModel2;
    if (sessionSettingBaseModel2 == null)
      sessionSettingBaseModel1 = ChatManager.dbOperImpl.createSessionSetting(paramShort, paramLong, null); 
    sessionModel.sessionSettingModel = sessionSettingBaseModel1;
    return sessionModel;
  }
  
  public static SessionModel createSessionModel(ChattingModel paramChattingModel, SessionProfileModel paramSessionProfileModel, boolean paramBoolean) {
    SessionModel sessionModel = new SessionModel();
    if (paramBoolean) {
      sessionModel.lastMsgStateCode = 1;
      sessionModel.noReadMsgCount = 0;
      clearSessionLikeNum(sessionModel);
      sessionModel.friend = 1;
      sessionModel.hasReply = 1;
    } else {
      sessionModel.lastMsgStateCode = 4;
      sessionModel.noReadMsgCount = 1;
      sessionModel.friend = paramChattingModel.fromFriend;
      if (AtRegExpUtils.isAtSelf(paramChattingModel.msgAt))
        sessionModel.atMessageId = paramChattingModel.msgId; 
    } 
    if (paramChattingModel.msgType == 42) {
      sessionModel.sessionStatus = 1;
    } else if (paramChattingModel.msgType == 43) {
      sessionModel.sessionStatus = 0;
    } 
    sessionModel.sessionId = paramChattingModel.sessionId;
    sessionModel.sessionType = paramChattingModel.sessionType;
    if (paramSessionProfileModel != null) {
      sessionModel.nickName = paramSessionProfileModel.nickname;
      sessionModel.avatar = paramSessionProfileModel.avatar;
      sessionModel.vBadge = paramSessionProfileModel.vBadge;
      sessionModel.online = paramSessionProfileModel.online;
      sessionModel.vipAnnual = paramSessionProfileModel.vipAnnual;
      sessionModel.vipExpLvl = paramSessionProfileModel.vipExpLvl;
      sessionModel.vipGrade = paramSessionProfileModel.vipGrade;
      sessionModel.hideVipLook = paramSessionProfileModel.hideVipLook;
      sessionModel.ovipGrade = paramSessionProfileModel.ovipGrade;
      sessionModel.ohideVipLook = paramSessionProfileModel.ohideVipLook;
      sessionModel.oFaceStatus = paramSessionProfileModel.oFaceStatus;
    } else if (paramChattingModel.sessionType == 2 && paramChattingModel.fromId != ChatManager.userInfo.uid) {
      sessionModel.nickName = paramChattingModel.fromNickName;
      sessionModel.avatar = paramChattingModel.fromAvatar;
      sessionModel.vBadge = paramChattingModel.fromVBadge;
      sessionModel.online = paramChattingModel.fromOnline;
      sessionModel.vipAnnual = paramChattingModel.fromVipAnnual;
      sessionModel.vipExpLvl = paramChattingModel.fromVipExpLvl;
      sessionModel.vipGrade = paramChattingModel.fromVipGrade;
      sessionModel.hideVipLook = paramChattingModel.fromHideVipLook;
      sessionModel.ovipGrade = paramChattingModel.ofromVipGrade;
      sessionModel.ohideVipLook = paramChattingModel.ofromHideVipLook;
      sessionModel.oFaceStatus = paramChattingModel.oFromFaceStatus;
    } 
    if (!paramChattingModel.msgIsDelete) {
      SessionModel.setSessionForLastMsg(sessionModel, paramChattingModel);
    } else {
      sessionModel.lastMsgTime = paramChattingModel.msgTimestamp;
    } 
    ChatManager.dbOperImpl.saveSession(sessionModel);
    SessionSettingBaseModel sessionSettingBaseModel2 = ChatManager.dbOperImpl.getSessionSetting(sessionModel.sessionType, sessionModel.sessionId);
    SessionSettingBaseModel sessionSettingBaseModel1 = sessionSettingBaseModel2;
    if (sessionSettingBaseModel2 == null)
      sessionSettingBaseModel1 = ChatManager.dbOperImpl.createSessionSetting(sessionModel.sessionType, sessionModel.sessionId, null); 
    sessionModel.sessionSettingModel = sessionSettingBaseModel1;
    return sessionModel;
  }
  
  public static ChattingModel findNotifyMsg(List<ChattingModel> paramList) {
    for (int i = paramList.size() - 1; i >= 0; i--) {
      if (!isIgnoreNotifyMsgType(paramList.get(i)))
        return paramList.get(i); 
    } 
    return paramList.get(paramList.size() - 1);
  }
  
  public static ChattingModel getChattingModelForSendmsg(long paramLong, short paramShort1, String paramString1, SessionProfileModel paramSessionProfileModel, String paramString2, short paramShort2) {
    ChattingModel chattingModel = new ChattingModel();
    chattingModel.fromId = Long.valueOf(ChatManager.userInfo.uid).longValue();
    chattingModel.toId = Long.valueOf(paramLong).longValue();
    if (paramSessionProfileModel != null) {
      chattingModel.fromNickName = paramSessionProfileModel.nickname;
      chattingModel.fromAvatar = paramSessionProfileModel.avatar;
      chattingModel.fromVBadge = paramSessionProfileModel.vBadge;
    } 
    chattingModel.sessionId = Long.valueOf(paramLong).longValue();
    chattingModel.sessionType = paramShort2;
    chattingModel.setMsgExtra(paramString2);
    chattingModel.msgId = 0L;
    chattingModel.msgPreviousId = 0L;
    chattingModel.msgLocalId = getLocalId();
    chattingModel.msgContent = paramString1;
    chattingModel.msgType = paramShort1;
    chattingModel.msgStateCode = 1;
    return chattingModel;
  }
  
  public static ChattingModel getChattingModelFromPushPackage(PushMsgPackage paramPushMsgPackage) {
    ChattingModel chattingModel = new ChattingModel();
    chattingModel._pushMsgPackage = paramPushMsgPackage;
    try {
      chattingModel.fromId = paramPushMsgPackage.fromId;
      chattingModel.toId = paramPushMsgPackage.sessionId;
      chattingModel.sessionId = paramPushMsgPackage.sessionId;
      chattingModel.sessionType = paramPushMsgPackage.sessionType;
      chattingModel.msgId = paramPushMsgPackage.msgId;
      chattingModel.msgPreviousId = paramPushMsgPackage.previousMsgId;
      chattingModel.msgTimestamp = paramPushMsgPackage.time * 1000L;
      chattingModel.msgType = paramPushMsgPackage.msgType;
      chattingModel.app = paramPushMsgPackage.app;
      if (MsgType.getClassify(chattingModel.msgType) == 1) {
        chattingModel.msgStateCode = 3;
      } else if (chattingModel.msgType == 216) {
        chattingModel.msgStateCode = 4;
      } else if (paramPushMsgPackage.fromId == ChatManager.userInfo.uid) {
        if (paramPushMsgPackage.pushBasePackage.msgHeader.isReaded) {
          chattingModel.msgStateCode = 3;
        } else {
          chattingModel.msgStateCode = 2;
        } 
      } else {
        chattingModel.msgStateCode = 4;
      } 
      chattingModel.msgContent = paramPushMsgPackage.msgContent;
      chattingModel.msgAt = paramPushMsgPackage.msgAt;
      chattingModel.fromNickName = paramPushMsgPackage.fromName;
      chattingModel.fromAvatar = paramPushMsgPackage.fromAvatar;
      chattingModel.fromVBadge = paramPushMsgPackage.fromVBadge;
      chattingModel.fromOnline = paramPushMsgPackage.fromOnline;
      chattingModel.fromFriend = paramPushMsgPackage.fromFriend;
      chattingModel.fromRichLevel = paramPushMsgPackage.fromRichLevel;
      chattingModel.fromVipGrade = paramPushMsgPackage.fromVipGrade;
      chattingModel.fromVipAnnual = paramPushMsgPackage.fromVipAnnual;
      chattingModel.fromVipExpLvl = paramPushMsgPackage.fromVipExpLvl;
      chattingModel.fromLiveManager = paramPushMsgPackage.fromLiveManager;
      chattingModel.fromHideVipLook = paramPushMsgPackage.fromHideVipLook;
      chattingModel.ofromVipGrade = paramPushMsgPackage.ofromVipGrade;
      chattingModel.ofromHideVipLook = paramPushMsgPackage.ofromHideVipLook;
      chattingModel.oFromFaceStatus = paramPushMsgPackage.oFaceStatus;
      chattingModel.msgIsDelete = paramPushMsgPackage.pushBasePackage.msgHeader.isDeleted;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((float)paramPushMsgPackage.distance / 1000.0F);
      stringBuilder.append("");
      chattingModel.fromDistance = stringBuilder.toString();
      chattingModel.avatarPendant = paramPushMsgPackage.avatarPendant;
      chattingModel.status = paramPushMsgPackage.status;
      chattingModel.msgMapExtra = paramPushMsgPackage.msgMapExtra;
      return chattingModel;
    } catch (Exception exception) {
      exception.printStackTrace();
      return chattingModel;
    } 
  }
  
  public static long getLocalId() {
    // Byte code:
    //   0: ldc com/blued/android/chat/utils/ChatHelper
    //   2: monitorenter
    //   3: getstatic com/blued/android/chat/utils/ChatHelper.localId : J
    //   6: lconst_1
    //   7: ladd
    //   8: lstore_0
    //   9: lload_0
    //   10: putstatic com/blued/android/chat/utils/ChatHelper.localId : J
    //   13: ldc com/blued/android/chat/utils/ChatHelper
    //   15: monitorexit
    //   16: lload_0
    //   17: lreturn
    //   18: astore_2
    //   19: ldc com/blued/android/chat/utils/ChatHelper
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	18	finally
  }
  
  public static int getMsgReceiveFrom(String paramString) {
    try {
      MsgReceiveModelInter msgReceiveModelInter;
      if (TextUtils.isEmpty(paramString))
        return -1; 
      JSONObject jSONObject = new JSONObject(paramString);
      if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL && !jSONObject.has("msg_receive_from"))
        return -1; 
      if (ChatManager.clientType == ChatManager.ClientType.CHINA && !jSONObject.has("msgSource"))
        return -1; 
      Gson gson = new Gson();
      if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
        msgReceiveModelInter = (MsgReceiveModelInter)gson.fromJson(paramString, MsgReceiveModelInter.class);
        if (msgReceiveModelInter != null)
          return msgReceiveModelInter.msg_receive_from; 
      } else if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
        MsgReceiveModelChina msgReceiveModelChina = (MsgReceiveModelChina)gson.fromJson((String)msgReceiveModelInter, MsgReceiveModelChina.class);
        if (msgReceiveModelChina != null && msgReceiveModelChina.msgSource != null)
          return msgReceiveModelChina.msgSource.type; 
      } 
      return -1;
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public static SendMsgPackage getSendMsgPackageFromChattingModel(ChattingModel paramChattingModel) {
    return new SendMsgPackage(paramChattingModel.sessionType, paramChattingModel.sessionId, paramChattingModel.msgLocalId, paramChattingModel.msgTimestamp, paramChattingModel.msgType, paramChattingModel.msgContent, paramChattingModel.msgAt, paramChattingModel.getMsgExtra(), paramChattingModel.fromId, paramChattingModel.fromNickName);
  }
  
  public static Pair<Short, Long> getSessionTypeAndId(String paramString) {
    Pair<Short, Long> pair;
    boolean bool = TextUtils.isEmpty(paramString);
    String str = null;
    if (bool)
      return null; 
    String[] arrayOfString = paramString.split("\\*");
    paramString = str;
    if (arrayOfString.length == 2)
      pair = new Pair(Short.valueOf(arrayOfString[0]), Long.valueOf(arrayOfString[1])); 
    return pair;
  }
  
  public static boolean isAtSelf(ChattingModel paramChattingModel) {
    return AtRegExpUtils.isAtSelf(paramChattingModel.msgAt);
  }
  
  public static boolean isHasAtValue(ChattingModel paramChattingModel) {
    return TextUtils.isEmpty(paramChattingModel.msgAt) ^ true;
  }
  
  public static boolean isIgnoreNotifyMsgType(ChattingModel paramChattingModel) {
    List list;
    if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL)
      if (paramChattingModel.msgType != 14) {
        if (paramChattingModel.msgType == 12)
          return true; 
        if (paramChattingModel.msgType == 13) {
          if (paramChattingModel.msgMapExtra != null) {
            list = MsgPackHelper.getListValue(paramChattingModel.msgMapExtra, "kicked_uid");
            if (list != null && list.contains(Long.valueOf(ChatManager.userInfo.uid)))
              return false; 
          } 
          return true;
        } 
      } else {
        return true;
      }  
    if (((ChattingModel)list).msgType != 169)
      return false; 
    if (((ChattingModel)list).msgMapExtra == null && !TextUtils.isEmpty(list.getMsgExtra()))
      ((ChattingModel)list).msgMapExtra = (Map)(new Gson()).fromJson(list.getMsgExtra(), HashMap.class); 
    return !(((ChattingModel)list).msgMapExtra != null && MsgPackHelper.getIntValue(((ChattingModel)list).msgMapExtra, "notify_flag") == 1);
  }
  
  public static boolean isLocalViewMsg(short paramShort) {
    return !(paramShort != -4 && paramShort != -3 && paramShort != -1);
  }
  
  public static void setLikeStatus(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    if (paramSessionModel.sessionType == 2 && paramChattingModel.msgType == 168) {
      if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL)
        paramSessionModel.friend = 1; 
      if (!paramChattingModel.isFromSelf())
        paramSessionModel.likeNumUnread++; 
    } 
  }
  
  public static void setSessionSourceFrom(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    if (paramSessionModel.sessionType == 2 && !TextUtils.isEmpty(paramChattingModel.getMsgExtra())) {
      int i = getMsgReceiveFrom(paramChattingModel.getMsgExtra());
      if (i != -1 && i != paramSessionModel.sourceFrom) {
        paramSessionModel.sourceFrom = i;
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sourceFrom:");
        stringBuilder.append(i);
        Log.v(str, stringBuilder.toString());
      } 
    } 
  }
  
  public static short transformIosSendStateToAndroid(short paramShort) {
    switch (paramShort) {
      default:
        return 0;
      case 7:
        return 5;
      case 5:
        return 7;
      case 4:
        return 3;
      case 3:
        return 2;
      case 2:
      case 6:
        return 6;
      case 1:
        break;
    } 
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cha\\utils\ChatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */