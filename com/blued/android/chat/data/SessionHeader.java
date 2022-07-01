package com.blued.android.chat.data;

public class SessionHeader {
  public static final short SESSION_TYPE_AUDIOROOM_INTERNATIONAL = 8;
  
  public static final short SESSION_TYPE_GROUP = 3;
  
  public static final short SESSION_TYPE_LIVECHAT = 4;
  
  public static final short SESSION_TYPE_LIVECHAT_INTERNATIONAL = 5;
  
  public static final short SESSION_TYPE_PRIVATE = 2;
  
  public static final short SESSION_TYPE_ROOMCHAT = 7;
  
  public static final short SESSION_TYPE_SYSTEM = 1;
  
  public static final short SESSION_TYPE_UNKNOWN = 0;
  
  public static final short SESSION_TYPE_WAWAJI = 6;
  
  public static final int STSTEM_ILLEGAL_ACCOUNTS_SESSION_DELETE = 19;
  
  public static final int STSTEM_PRIVATE_SESSION_ID = 1;
  
  public static final int SYSTEM_ACTIVITY_SESSION_ID = 12;
  
  public static final int SYSTEM_AD_REWARDED_SESSION_ID = 26;
  
  public static final int SYSTEM_ATTENTION_SESSION_ID = 5;
  
  public static final int SYSTEM_CIRCLE_SESSION_ID = 24;
  
  public static final int SYSTEM_COMMAND_SESSION_ID = 18;
  
  public static final int SYSTEM_FEED_SESSION_ID = 3;
  
  public static final int SYSTEM_FEED_UPDATE_SESSION_ID = 13;
  
  public static final int SYSTEM_GROUP_SESSION_ID = 2;
  
  public static final int SYSTEM_IMAGE_TEXT_PUSH_SESSION_ID = 16;
  
  public static final int SYSTEM_LIKE_SESSION_ID = 21;
  
  public static final int SYSTEM_LIVE_APPLY_RESULT_SESSION_ID = 7;
  
  public static final int SYSTEM_LIVE_FAMILY = 20;
  
  public static final int SYSTEM_LIVE_NOTIFY_SESSION_ID = 6;
  
  public static final int SYSTEM_LIVE_SHARE_PRIVATE_SESSION_ID = 17;
  
  public static final int SYSTEM_NOTIFY_GROUP_FOLLOW_NEW = 8;
  
  public static final int SYSTEM_NOTIFY_NEW_ACCOUNT = 9;
  
  public static final int SYSTEM_NOTIFY_USERINFO_UPDATE = 10;
  
  public static final int SYSTEM_SESSION_ID_FLASH_VIDEO = 23;
  
  public static final int SYSTEM_TASK_PROGRESS_SESSION_ID = 25;
  
  public static final int SYSTEM_VIEWPOINT_SESSION_ID = 11;
  
  public static final int SYSTEM_VIEWPOINT_UPDATE_SESSION_ID = 14;
  
  public static final int SYSTEM_VISITOR_SESSION_ID = 4;
  
  public static final int SYSTEM_VOTE_SESSION_ID = 22;
  
  public long id;
  
  public short type;
  
  public static String getSessionKey(int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramInt);
    stringBuilder.append("*");
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("type:");
    stringBuilder.append(this.type);
    stringBuilder.append(", id:");
    stringBuilder.append(this.id);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\SessionHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */