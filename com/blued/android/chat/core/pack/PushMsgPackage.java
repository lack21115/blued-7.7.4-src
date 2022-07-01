package com.blued.android.chat.core.pack;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.google.gson.Gson;
import java.util.Map;

public class PushMsgPackage {
  private static final String TAG = "Chat_PushMsgPackage";
  
  public int app;
  
  public String avatarPendant;
  
  public long distance;
  
  public String fromAvatar;
  
  public int fromFriend = 0;
  
  public int fromHideVipLook;
  
  public long fromId;
  
  public int fromLiveManager;
  
  public String fromName;
  
  public int fromOnline = -1;
  
  public int fromRichLevel = 0;
  
  public int fromVBadge = -1;
  
  public int fromVipAnnual;
  
  public int fromVipExpLvl;
  
  public int fromVipGrade;
  
  public String msgAt;
  
  public String msgContent;
  
  public long msgId;
  
  public Map<String, Object> msgMapExtra;
  
  public short msgType;
  
  public int oFaceStatus;
  
  public int ofromHideVipLook;
  
  public int ofromVipGrade;
  
  public long previousMsgId;
  
  public PushBasePackage pushBasePackage;
  
  public long sessionId;
  
  public short sessionType;
  
  public int status;
  
  public long time;
  
  public static ChattingModel toMsgData(PushMsgPackage paramPushMsgPackage) {
    return ChatHelper.getChattingModelFromPushPackage(paramPushMsgPackage);
  }
  
  public boolean isReaded() {
    PushBasePackage pushBasePackage = this.pushBasePackage;
    return (pushBasePackage != null && pushBasePackage.msgHeader != null) ? this.pushBasePackage.msgHeader.isReaded : false;
  }
  
  protected void parseSubPackageData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.sessionType = BytesUtils.byteTo1Number(paramArrayOfbyte, paramInt1);
    this.sessionId = BytesUtils.bytesTo4Number(paramArrayOfbyte, ++paramInt1);
    paramInt1 += 4;
    this.msgId = BytesUtils.byteTo8Number(paramArrayOfbyte, paramInt1);
    this.previousMsgId = this.msgId - 1L;
    paramInt1 += 8;
    this.time = BytesUtils.bytesTo4Number(paramArrayOfbyte, paramInt1);
    paramInt1 += 4;
    this.distance = BytesUtils.bytesTo4Number(paramArrayOfbyte, paramInt1);
    paramInt1 += 4;
    if (paramInt2 > paramInt1) {
      Map map = MsgPackHelper.unpackMap(paramArrayOfbyte, paramInt1, paramInt2);
      if (map != null) {
        this.msgType = MsgPackHelper.getShortValue(map, "type");
        this.fromId = MsgPackHelper.getLongValue(map, "from");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("contents_");
        stringBuilder.append(ChatManager.languageDetail);
        String str2 = MsgPackHelper.getStringValue(map, stringBuilder.toString());
        String str1 = str2;
        if (str2 == null) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("contents_");
          stringBuilder1.append(ChatManager.language);
          str2 = MsgPackHelper.getStringValue(map, stringBuilder1.toString());
          str1 = str2;
          if (str2 == null) {
            str2 = MsgPackHelper.getStringValue(map, "contents_en");
            str1 = str2;
            if (str2 == null)
              str1 = MsgPackHelper.getStringValue(map, "contents"); 
          } 
        } 
        if (str1 != null)
          this.msgContent = str1; 
        this.status = MsgPackHelper.getIntValue(map, "session_status");
        this.app = MsgPackHelper.getIntValue(map, "app");
        this.msgAt = MsgPackHelper.getStringValue(map, "at");
        this.msgMapExtra = MsgPackHelper.getMapValue(map, "extra");
        Map map1 = MsgPackHelper.getMapValue(map, "profile");
        if (map1 != null) {
          this.fromName = MsgPackHelper.getStringValue(map1, "name");
          this.fromAvatar = MsgPackHelper.getStringValue(map1, "avatar");
          this.fromVBadge = MsgPackHelper.getIntValue(map1, "vbadge");
          this.fromOnline = MsgPackHelper.getIntValue(map1, "online");
          this.fromFriend = MsgPackHelper.getIntValue(map1, "friend");
          if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
            this.fromRichLevel = MsgPackHelper.getIntValue(map1, "rich_level");
          } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
            this.fromRichLevel = MsgPackHelper.getIntValue(map1, "o_rich_level");
          } 
          this.fromVipGrade = MsgPackHelper.getIntValue(map1, "vip_grade");
          this.fromVipAnnual = MsgPackHelper.getIntValue(map1, "vip_annual");
          this.fromVipExpLvl = MsgPackHelper.getIntValue(map1, "vip_exp_lvl");
          this.fromLiveManager = MsgPackHelper.getIntValue(map1, "is_manager");
          this.fromHideVipLook = MsgPackHelper.getIntValue(map1, "is_hide_vip_look");
          this.ofromVipGrade = MsgPackHelper.getIntValue(map1, "o_vip_grade");
          this.ofromHideVipLook = MsgPackHelper.getIntValue(map1, "o_is_hide_vip_look");
          this.oFaceStatus = MsgPackHelper.getIntValue(map1, "o_face_status");
          this.avatarPendant = MsgPackHelper.getStringValue(map1, "avatar_pendant");
        } 
      } 
    } 
  }
  
  public String toString() {
    String str;
    if (this.msgMapExtra != null) {
      str = (new Gson()).toJson(this.msgMapExtra);
    } else {
      str = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", msgId:");
    stringBuilder.append(this.msgId);
    stringBuilder.append(", previousMsgId:");
    stringBuilder.append(this.previousMsgId);
    stringBuilder.append(", time:");
    stringBuilder.append(this.time);
    stringBuilder.append(", distance:");
    stringBuilder.append(this.distance);
    stringBuilder.append(", msgType:");
    stringBuilder.append(this.msgType);
    stringBuilder.append(", fromId:");
    stringBuilder.append(this.fromId);
    stringBuilder.append(", msgContent:");
    stringBuilder.append(this.msgContent);
    stringBuilder.append(", MsgAt:");
    stringBuilder.append(this.msgAt);
    stringBuilder.append(", status:");
    stringBuilder.append(this.status);
    stringBuilder.append(", app:");
    stringBuilder.append(this.app);
    stringBuilder.append(", fromName:");
    stringBuilder.append(this.fromName);
    stringBuilder.append(", fromAvatar:");
    stringBuilder.append(this.fromAvatar);
    stringBuilder.append(", fromVBadge:");
    stringBuilder.append(this.fromVBadge);
    stringBuilder.append(", fromOnline:");
    stringBuilder.append(this.fromOnline);
    stringBuilder.append(", fromFriend:");
    stringBuilder.append(this.fromFriend);
    stringBuilder.append(", fromRichLevel:");
    stringBuilder.append(this.fromRichLevel);
    stringBuilder.append(", fromVipGrade:");
    stringBuilder.append(this.fromVipGrade);
    stringBuilder.append(", fromVipAnnual:");
    stringBuilder.append(this.fromVipAnnual);
    stringBuilder.append(", fromVipExpLvl:");
    stringBuilder.append(this.fromVipExpLvl);
    stringBuilder.append(", fromLiveManager:");
    stringBuilder.append(this.fromLiveManager);
    stringBuilder.append(", ofromVipGrade:");
    stringBuilder.append(this.ofromVipGrade);
    stringBuilder.append(", ofromHideVipLook:");
    stringBuilder.append(this.ofromHideVipLook);
    stringBuilder.append(", oFaceStatus:");
    stringBuilder.append(this.oFaceStatus);
    stringBuilder.append(", fromHideVipLook:");
    stringBuilder.append(this.fromHideVipLook);
    stringBuilder.append(", avatarPendant:");
    stringBuilder.append(this.avatarPendant);
    stringBuilder.append(", msgExtra:");
    stringBuilder.append(str);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\PushMsgPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */