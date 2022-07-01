package com.soft.blued.db.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Map;

@DatabaseTable(tableName = "ChattingModel")
public class ChattingModelDB {
  @DatabaseField
  public int app;
  
  @DatabaseField(columnName = "id", generatedId = true)
  public int dbId;
  
  @DatabaseField(columnName = "avatar")
  public String fromAvatar;
  
  @DatabaseField(columnName = "distance")
  public String fromDistance;
  
  @DatabaseField
  public int fromHideVipLook;
  
  @DatabaseField
  public long fromId;
  
  @DatabaseField(columnName = "nickName")
  public String fromNickName;
  
  @DatabaseField(columnName = "online", defaultValue = "1")
  public int fromOnline;
  
  @DatabaseField(columnName = "vBadge")
  public int fromVBadge;
  
  @DatabaseField
  public int fromVipAnnual;
  
  @DatabaseField
  public int fromVipExpLvl;
  
  @DatabaseField
  public int fromVipGrade;
  
  @DatabaseField(index = true)
  public long loadName;
  
  @DatabaseField
  public String msgContent;
  
  @DatabaseField
  private String msgExtra;
  
  @DatabaseField(index = true)
  public long msgId;
  
  @DatabaseField
  public boolean msgIsDelete;
  
  @DatabaseField(index = true)
  public long msgLocalId;
  
  public Map<String, Object> msgMapExtra;
  
  @DatabaseField(columnName = "previousMsgId")
  public long msgPreviousId;
  
  @DatabaseField(index = true)
  public short msgStateCode;
  
  @DatabaseField
  public String msgTextTranslateContent;
  
  @DatabaseField
  public int msgTextTranslateIsShow;
  
  @DatabaseField
  public int msgTextTranslateStatus;
  
  @DatabaseField
  public long msgTimestamp;
  
  @DatabaseField
  public short msgType;
  
  @DatabaseField
  public String msgVideoCoverUrlLocal;
  
  @DatabaseField(index = true)
  public long sessionId;
  
  @DatabaseField
  public short sessionType;
  
  @DatabaseField
  public long toId;
  
  public String getMsgExtra() {
    if (TextUtils.isEmpty(this.msgExtra) && this.msgMapExtra != null)
      this.msgExtra = AppInfo.f().toJson(this.msgMapExtra); 
    return this.msgExtra;
  }
  
  public boolean isFromSelf() {
    return (ChatManager.userInfo.uid == this.fromId);
  }
  
  public void setMsgExtra(String paramString) {
    this.msgExtra = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\model\ChattingModelDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */