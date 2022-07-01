package com.soft.blued.db.model;

import android.text.TextUtils;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.soft.blued.constant.ChatConstants;

@DatabaseTable(tableName = "SessionSettingModel")
public class SessionSettingModel extends SessionSettingBaseModel {
  public int bubbleThemeId;
  
  @DatabaseField
  private String chatBgUri = "";
  
  @DatabaseField
  private int follower;
  
  @DatabaseField
  private String groupAdiminIDs;
  
  @DatabaseField
  private long groupCreateId;
  
  @DatabaseField
  private int groupNumberNum = 0;
  
  @DatabaseField(columnName = "id", generatedId = true)
  private int id;
  
  @DatabaseField
  private int initiator;
  
  @DatabaseField
  private int lietop = 0;
  
  @DatabaseField(index = true)
  private long loadName;
  
  @DatabaseField
  private int nearby;
  
  @DatabaseField
  private int online;
  
  @DatabaseField
  private int remindAudio = ChatConstants.b;
  
  @DatabaseField
  private String sessinoNote;
  
  @DatabaseField(index = true)
  private long sessionId;
  
  @DatabaseField(index = true)
  private short sessionType;
  
  @DatabaseField
  private int uiStatus = 0;
  
  public void copyValue(SessionSettingBaseModel paramSessionSettingBaseModel) {
    if (paramSessionSettingBaseModel == null)
      return; 
    paramSessionSettingBaseModel = paramSessionSettingBaseModel;
    this.remindAudio = ((SessionSettingModel)paramSessionSettingBaseModel).remindAudio;
    this.chatBgUri = ((SessionSettingModel)paramSessionSettingBaseModel).chatBgUri;
    if (!TextUtils.isEmpty(((SessionSettingModel)paramSessionSettingBaseModel).sessinoNote))
      this.sessinoNote = ((SessionSettingModel)paramSessionSettingBaseModel).sessinoNote; 
  }
  
  public String getChatBgUri() {
    return this.chatBgUri;
  }
  
  public int getDBId() {
    return this.id;
  }
  
  public int getFollower() {
    return this.follower;
  }
  
  public String getGroupAdiminIDs() {
    return this.groupAdiminIDs;
  }
  
  public long getGroupCreateId() {
    return this.groupCreateId;
  }
  
  public int getGroupNumberNum() {
    return this.groupNumberNum;
  }
  
  public int getId() {
    return this.id;
  }
  
  public int getInitiator() {
    return this.initiator;
  }
  
  public int getLietop() {
    return this.lietop;
  }
  
  public long getLoadName() {
    return this.loadName;
  }
  
  public int getNearby() {
    return this.nearby;
  }
  
  public int getOnline() {
    return this.online;
  }
  
  public int getRemindAudio() {
    return this.remindAudio;
  }
  
  public String getSessinoNote() {
    return this.sessinoNote;
  }
  
  public long getSessionId() {
    return this.sessionId;
  }
  
  public short getSessionType() {
    return this.sessionType;
  }
  
  public int getUiStatus() {
    return this.uiStatus;
  }
  
  public void setChatBgUri(String paramString) {
    this.chatBgUri = paramString;
  }
  
  public void setDBId(int paramInt) {
    this.id = paramInt;
  }
  
  public void setFollower(int paramInt) {
    this.follower = paramInt;
  }
  
  public void setGroupAdiminIDs(String paramString) {
    this.groupAdiminIDs = paramString;
  }
  
  public void setGroupCreateId(long paramLong) {
    this.groupCreateId = paramLong;
  }
  
  public void setGroupNumberNum(int paramInt) {
    this.groupNumberNum = paramInt;
  }
  
  public void setId(int paramInt) {
    this.id = paramInt;
  }
  
  public void setInitiator(int paramInt) {
    this.initiator = paramInt;
  }
  
  public void setLietop(int paramInt) {
    this.lietop = paramInt;
  }
  
  public void setLoadName(long paramLong) {
    this.loadName = paramLong;
  }
  
  public void setNearby(int paramInt) {
    this.nearby = paramInt;
  }
  
  public void setOnline(int paramInt) {
    this.online = paramInt;
  }
  
  public void setRemindAudio(int paramInt) {
    this.remindAudio = paramInt;
  }
  
  public void setSessinoNote(String paramString) {
    this.sessinoNote = paramString;
  }
  
  public void setSessionId(long paramLong) {
    this.sessionId = paramLong;
  }
  
  public void setSessionType(short paramShort) {
    this.sessionType = paramShort;
  }
  
  public void setUiStatus(int paramInt) {
    this.uiStatus = paramInt;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SessionSettingModel{id=");
    stringBuilder.append(this.id);
    stringBuilder.append(", sessionId=");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", sessionType=");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", loadName=");
    stringBuilder.append(this.loadName);
    stringBuilder.append(", remindAudio=");
    stringBuilder.append(this.remindAudio);
    stringBuilder.append(", groupCreateId=");
    stringBuilder.append(this.groupCreateId);
    stringBuilder.append(", groupNumberNum=");
    stringBuilder.append(this.groupNumberNum);
    stringBuilder.append(", groupAdiminIDs='");
    stringBuilder.append(this.groupAdiminIDs);
    stringBuilder.append('\'');
    stringBuilder.append(", lietop=");
    stringBuilder.append(this.lietop);
    stringBuilder.append(", uiStatus=");
    stringBuilder.append(this.uiStatus);
    stringBuilder.append(", chatBgUri='");
    stringBuilder.append(this.chatBgUri);
    stringBuilder.append('\'');
    stringBuilder.append(", sessinoNote='");
    stringBuilder.append(this.sessinoNote);
    stringBuilder.append('\'');
    stringBuilder.append(", nearby=");
    stringBuilder.append(this.nearby);
    stringBuilder.append(", online=");
    stringBuilder.append(this.online);
    stringBuilder.append(", follower=");
    stringBuilder.append(this.follower);
    stringBuilder.append(", initiator=");
    stringBuilder.append(this.initiator);
    stringBuilder.append("} ");
    stringBuilder.append(super.toString());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\model\SessionSettingModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */