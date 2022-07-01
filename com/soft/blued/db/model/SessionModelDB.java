package com.soft.blued.db.model;

import android.text.TextUtils;
import com.blued.android.chat.model.ChattingModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.List;
import java.util.Set;

@DatabaseTable(tableName = "SessionModel")
public class SessionModelDB {
  public boolean _isRequestingInfo = false;
  
  public List<ChattingModel> _msgList;
  
  public Set<Long> _unreadedMsgIds;
  
  @DatabaseField(columnName = "sessionAvatar")
  public String avatar;
  
  public boolean checked = false;
  
  public boolean chooseable = true;
  
  @DatabaseField(columnName = "id", generatedId = true)
  public int dbId;
  
  @DatabaseField
  public long expireTime;
  
  @DatabaseField
  public int friend;
  
  @DatabaseField
  public int hasReply;
  
  @DatabaseField
  public int hideVipLook;
  
  @DatabaseField(columnName = "draft")
  public String lastDraft;
  
  @DatabaseField
  public long lastGiftMsgId;
  
  @DatabaseField
  public String lastMsgContent;
  
  @DatabaseField
  public String lastMsgExtra;
  
  @DatabaseField
  public int lastMsgFromApp;
  
  @DatabaseField
  public String lastMsgFromAvatar;
  
  @DatabaseField(columnName = "lastMsgDistance")
  public String lastMsgFromDistance;
  
  @DatabaseField
  public long lastMsgFromId;
  
  @DatabaseField
  public String lastMsgFromNickname;
  
  @DatabaseField(columnName = "lastMsgOnline", defaultValue = "1")
  public int lastMsgFromOnline;
  
  @DatabaseField
  public long lastMsgId;
  
  @DatabaseField
  public long lastMsgLocalId;
  
  @DatabaseField
  public short lastMsgStateCode;
  
  @DatabaseField
  public long lastMsgTime;
  
  @DatabaseField
  public short lastMsgType;
  
  @DatabaseField
  public int lieTop;
  
  @DatabaseField(index = true)
  public long loadName;
  
  @DatabaseField
  public long maxHasReadMsgID = 0L;
  
  @DatabaseField
  public long maxMsgId;
  
  @DatabaseField
  public long maxRcvOppMsgId;
  
  @DatabaseField(columnName = "sessionNickName")
  public String nickName;
  
  @DatabaseField
  public int noReadMsgCount = 0;
  
  @DatabaseField(defaultValue = "1")
  public int online;
  
  @DatabaseField
  public int secretLookStatus;
  
  @DatabaseField(index = true)
  public long sessionId;
  
  @DatabaseField
  public int sessionStatus;
  
  @DatabaseField(index = true)
  public short sessionType;
  
  @DatabaseField
  public int sourceFrom;
  
  @DatabaseField
  public float totalMoney;
  
  @DatabaseField
  public int unreadGiftCnt;
  
  @DatabaseField
  public int vBadge;
  
  @DatabaseField
  public int vipAnnual;
  
  @DatabaseField
  public int vipExpLvl;
  
  @DatabaseField
  public int vipGrade;
  
  public static boolean dataIsFull(SessionModelDB paramSessionModelDB) {
    return (paramSessionModelDB != null) ? (TextUtils.isEmpty(paramSessionModelDB.nickName) ^ true) : false;
  }
  
  public static void removeSessionLastMsg(SessionModelDB paramSessionModelDB) {
    paramSessionModelDB.lastMsgContent = "";
    paramSessionModelDB.lastMsgLocalId = 0L;
    paramSessionModelDB.lastMsgId = 0L;
    paramSessionModelDB.lastMsgType = 0;
    paramSessionModelDB.lastMsgStateCode = 0;
    paramSessionModelDB.lastMsgFromId = 0L;
    paramSessionModelDB.lastMsgFromNickname = "";
    paramSessionModelDB.lastMsgFromAvatar = "";
    paramSessionModelDB.lastMsgFromDistance = "";
    paramSessionModelDB.noReadMsgCount = 0;
    paramSessionModelDB.lastMsgExtra = "";
    paramSessionModelDB.lastMsgFromApp = 0;
  }
  
  public static void setSessionForLastMsg(SessionModelDB paramSessionModelDB, ChattingModel paramChattingModel) {
    paramSessionModelDB.lastMsgContent = paramChattingModel.msgContent;
    paramSessionModelDB.lastMsgTime = paramChattingModel.msgTimestamp;
    paramSessionModelDB.lastMsgLocalId = paramChattingModel.msgLocalId;
    paramSessionModelDB.lastMsgId = paramChattingModel.msgId;
    paramSessionModelDB.lastMsgType = paramChattingModel.msgType;
    paramSessionModelDB.lastMsgFromApp = paramChattingModel.app;
    paramSessionModelDB.lastMsgStateCode = paramChattingModel.msgStateCode;
    paramSessionModelDB.lastMsgFromId = paramChattingModel.fromId;
    if (!TextUtils.isEmpty(paramChattingModel.fromNickName))
      paramSessionModelDB.lastMsgFromNickname = paramChattingModel.fromNickName; 
    if (!TextUtils.isEmpty(paramChattingModel.fromAvatar))
      paramSessionModelDB.lastMsgFromAvatar = paramChattingModel.fromAvatar; 
    paramSessionModelDB.lastMsgFromDistance = paramChattingModel.fromDistance;
    paramSessionModelDB.lastMsgExtra = paramChattingModel.getMsgExtra();
    paramSessionModelDB.lastMsgFromOnline = paramChattingModel.fromOnline;
    if (paramChattingModel.msgType == 42) {
      paramSessionModelDB.sessionStatus = 1;
      return;
    } 
    if (paramChattingModel.msgType == 43)
      paramSessionModelDB.sessionStatus = 0; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\model\SessionModelDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */