package com.blued.android.module.chat.model;

import android.text.TextUtils;
import com.blued.android.module.chat.ModuleChatConstant;
import java.lang.reflect.Field;
import java.util.Map;

public class SessionSetting extends SessionRelationModel {
  private String chatBgUri = "";
  
  private String groupAdiminIDs;
  
  private long groupCreateId;
  
  private int groupNumberNum = 0;
  
  private int id;
  
  private int lietop = 0;
  
  private int remindAudio = ModuleChatConstant.DEFAULT_REMIND_AUDIO_VALUE;
  
  private String sessinoNote;
  
  private int sessionMsgBoxMsgNum = 0;
  
  private int uiStatus = 0;
  
  private boolean setField(Object paramObject1, String paramString, Object paramObject2) {
    try {
      Field field = paramObject1.getClass().getDeclaredField(paramString);
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException = null;
    } 
    Class<?> clazz = paramObject1.getClass().getSuperclass();
    while (true) {
      Field field;
      if (noSuchFieldException == null && clazz != null) {
        try {
          Field field1 = clazz.getDeclaredField(paramString);
          field = field1;
        } catch (NoSuchFieldException noSuchFieldException1) {
          clazz = clazz.getSuperclass();
        } 
        continue;
      } 
      if (field == null)
        return false; 
      field.setAccessible(true);
      try {
        field.set(paramObject1, paramObject2);
        return true;
      } catch (IllegalAccessException illegalAccessException) {
        return false;
      } 
    } 
  }
  
  public String getChatBgUri() {
    return this.chatBgUri;
  }
  
  public int getDBId() {
    return this.id;
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
  
  public int getLietop() {
    return this.lietop;
  }
  
  public int getRemindAudio() {
    return this.remindAudio;
  }
  
  public String getSessinoNote() {
    return this.sessinoNote;
  }
  
  public int getSessionMsgBoxMsgNum() {
    return this.sessionMsgBoxMsgNum;
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
  
  public void setLietop(int paramInt) {
    this.lietop = paramInt;
  }
  
  public void setRemindAudio(int paramInt) {
    this.remindAudio = paramInt;
  }
  
  public void setSessinoNote(String paramString) {
    this.sessinoNote = paramString;
  }
  
  public void setSessionMsgBoxMsgNum(int paramInt) {
    this.sessionMsgBoxMsgNum = paramInt;
  }
  
  public void setUiStatus(int paramInt) {
    this.uiStatus = paramInt;
  }
  
  public String toString() {
    return super.toString();
  }
  
  public void updateValues(Map<String, Object> paramMap) {
    if (paramMap != null)
      try {
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
          String str = (String)entry.getKey();
          if (!TextUtils.isEmpty(str))
            setField(this, str, entry.getValue()); 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\model\SessionSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */