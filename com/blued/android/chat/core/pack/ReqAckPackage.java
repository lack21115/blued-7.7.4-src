package com.blued.android.chat.core.pack;

import com.blued.android.chat.data.PackageAckResult;
import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

public class ReqAckPackage extends BasePackage {
  public int error = 0;
  
  public String errorContent = null;
  
  public Map<String, Object> reqResponse;
  
  public int reqType = -1;
  
  public short result;
  
  protected void parseMsgData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.result = BytesUtils.byteTo1Number(paramArrayOfbyte, paramInt1);
    this.localId = BytesUtils.bytesTo4Number(paramArrayOfbyte, ++paramInt1);
    paramInt1 += 4;
    if (paramInt2 > paramInt1)
      this.reqResponse = MsgPackHelper.unpackMap(paramArrayOfbyte, paramInt1, paramInt2); 
    Map<String, Object> map = this.reqResponse;
    if (map != null) {
      this.reqType = MsgPackHelper.getIntValue(map, "req_type", -1);
      this.error = MsgPackHelper.getIntValue(this.reqResponse, "error");
      this.errorContent = MsgPackHelper.getStringValue(this.reqResponse, "error_contents");
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[result:");
    stringBuilder.append(this.result);
    stringBuilder.append(", localId:");
    stringBuilder.append(this.localId);
    stringBuilder.append(", reqType:");
    stringBuilder.append(this.reqType);
    stringBuilder.append(", error:");
    stringBuilder.append(this.error);
    stringBuilder.append(", reqResponse:");
    stringBuilder.append(this.reqResponse);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public static interface REQ_ERROR {
    public static final int ERROR_BLOCKED_BY_PEER = 3;
    
    public static final int ERROR_BLOCK_PEER = 4;
    
    public static final int ERROR_DESCRIPTION_INVALID = 7;
    
    public static final int ERROR_FLASHVIDEO_FUNCTION_LOCK = 13;
    
    public static final int ERROR_FLASHVIDEO_USER_BLOCK = 14;
    
    public static final int ERROR_FORBIDDEN_LIVE = 2;
    
    public static final int ERROR_JOINLIVE_CLOSE = 8;
    
    public static final int ERROR_JOINLIVE_FAILED = 11;
    
    public static final int ERROR_JOINLIVE_FULL = 9;
    
    public static final int ERROR_JOINLIVE_INVITE_OVERDUE = 10;
    
    public static final int ERROR_LIVEROOM_CLOSE = 6;
    
    public static final int ERROR_LIVEROOM_FULL = 5;
    
    public static final int ERROR_LIVEROOM_KICKED_OUT = 18;
    
    public static final int ERROR_NO_AUTHORITY_LIVE = 1;
    
    public static final int ERROR_REQ_SESSIONINFO_INVALID_USER = 12;
    
    public static final int ERROR_VIDEOCHAT_APP_NOT_SUPPORT = 15;
    
    public static final int ERROR_VIDEOCHAT_NOT_ONLINE = 16;
    
    public static final int ERROR_VIDEOCHAT_NOT_RECEIVE_MSG = 17;
    
    public static final int NO_ERROR = 0;
  }
  
  public static interface REQ_RESPONSE_KEY {
    public static final String AVATAR = "avatar";
    
    public static final String BADGES = "badges";
    
    public static final String BEANS_COUNT = "beans_count";
    
    public static final String BEANS_CURRENT_COUNT = "beans_current_count";
    
    public static final String BG_COLOR = "bg_color";
    
    public static final String BLUED_BADGE_PIC = "blued_badge_pic";
    
    public static final String ENTRANCE_EFFECTS = "effects";
    
    public static final String FLASH_REMAIN_NUM = "remain_num";
    
    public static final String ICON = "icon";
    
    public static final String IS_HIDE_VIP_LOOK = "is_hide_vip_look";
    
    public static final String LIVE_INFO = "live_info";
    
    public static final String MEMBER_ROLE = "member_role";
    
    public static final String NAME = "name";
    
    public static final String NOTE = "note";
    
    public static final String O_FACE_STATUS = "o_face_status";
    
    public static final String O_IS_HIDE_VIP_LOOK = "o_is_hide_vip_look";
    
    public static final String O_VIP_GRADE = "o_vip_grade";
    
    public static final String PUBLISH_URL = "publish_url";
    
    public static final String RANK = "rank";
    
    public static final String REQ_ERROR = "error";
    
    public static final String REQ_ERROR_CONTENTS = "error_contents";
    
    public static final String REQ_EXTRA = "extra";
    
    public static final String REQ_TYPE = "req_type";
    
    public static final String SESSION_ID = "session_id";
    
    public static final String SESSION_TYPE = "session_type";
    
    public static final String TOP_CARD_COUNT = "top_card_count";
    
    public static final String TOP_CARD_URL = "top_card_url";
    
    public static final String VBADGE = "vbadge";
    
    public static final String VIP_ANNUAL = "vip_annual";
    
    public static final String VIP_EXP_LVL = "vip_exp_lvl";
    
    public static final String VIP_GRADE = "vip_grade";
  }
  
  public static interface REQ_RESULT extends PackageAckResult {
    public static final int FAILED_UNKNOWN_REQ = 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqAckPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */