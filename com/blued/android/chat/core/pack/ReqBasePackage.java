package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

public class ReqBasePackage extends BasePackage {
  public final short reqType;
  
  protected ReqBasePackage(short paramShort, long paramLong) {
    this.reqType = paramShort;
    this.localId = paramLong;
  }
  
  protected Map<String, Object> getReqInfo() {
    return null;
  }
  
  protected BytesData msgDataToByte() {
    int i;
    Map<String, Object> map = getReqInfo();
    if (map != null) {
      byte[] arrayOfByte = MsgPackHelper.packMap(map);
    } else {
      map = null;
    } 
    if (map == null) {
      i = 0;
    } else {
      i = map.length;
    } 
    BytesData bytesData = new BytesData(i + 5);
    BytesUtils.numberTo1Byte(bytesData.data, 0, this.reqType);
    BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
    if (i > 0)
      BytesUtils.copy((byte[])map, 0, bytesData.data, 5, i); 
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[reqType:");
    stringBuilder.append(this.reqType);
    stringBuilder.append(", localId:");
    stringBuilder.append(this.localId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public static interface REQ_TYPE {
    public static final short REQ_APPLY_JOINLIVE = 11;
    
    public static final short REQ_CLOSE_LIVECHAT = 4;
    
    public static final short REQ_CLOSE_VIDEOCHAT = 14;
    
    public static final short REQ_CREATE_LIVECHAT = 3;
    
    public static final short REQ_CREATE_VIDEOCHAT = 13;
    
    public static final short REQ_DESTROY_MSG = 2;
    
    public static final short REQ_ENTER_LIVECHAT = 6;
    
    public static final short REQ_FLASHVIDEO_APPLY_EXTRA_TIME = 37;
    
    public static final short REQ_FLASHVIDEO_APPLY_FRIEND = 36;
    
    public static final short REQ_FLASHVIDEO_CANCEL_MATCH = 19;
    
    public static final short REQ_FLASHVIDEO_CLOSE = 20;
    
    public static final short REQ_FLASHVIDEO_EMOJI = 40;
    
    public static final short REQ_FLASHVIDEO_MATCH_AGREE = 38;
    
    public static final short REQ_FLASHVIDEO_SAY_HI = 39;
    
    public static final short REQ_FLASHVIDEO_START_MATCH = 18;
    
    public static final short REQ_GET_LIVECHAT_INFO = 8;
    
    public static final short REQ_LEAVE_LIVECHAT = 7;
    
    public static final short REQ_LIVECHAT_STATUS_CHANGE = 35;
    
    public static final short REQ_LIVEJOIN_END_NOTIFY = 32;
    
    public static final short REQ_LIVEJOIN_START_NOTIFY = 31;
    
    public static final short REQ_RECOVER_LIVECHAT = 9;
    
    public static final short REQ_SESSION = 1;
    
    public static final short REQ_START_JOINLIVE = 10;
    
    public static final short REQ_STOP_TALK = 5;
    
    public static final short REQ_UNKNOWN = -1;
    
    public static final short REQ_UPDATE_CALL_TIME = 15;
    
    public static final short REQ_VIDEOCHAT_GET_LEFT_TIME = 17;
    
    public static final short REQ_VIDEOCHAT_SWITCH_TO_AUDIO = 16;
    
    public static final short REQ_WAWAJICONTROLLER_CHECK_PLAY = 29;
    
    public static final short REQ_WAWAJICONTROLLER_INIT = 21;
    
    public static final short REQ_WAWAJICONTROLLER_READY = 22;
    
    public static final short REQ_WAWAJICONTROLLER_UPLOAD_RESULT = 28;
    
    public static final short REQ_WAWAJI_CANCEL_QUEUEUP = 27;
    
    public static final short REQ_WAWAJI_ENTER = 23;
    
    public static final short REQ_WAWAJI_GETINFO = 25;
    
    public static final short REQ_WAWAJI_LEAVE = 24;
    
    public static final short REQ_WAWAJI_QUEUEUP = 26;
    
    public static final short REQ_WAWAJI_RECOVER = 30;
    
    public static final short REQ_WAWAJI_START_RECEIVE_GAME_RESULT = 33;
    
    public static final short REQ_WAWAJI_STOP_RECEIVE_GAME_RESULT = 34;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqBasePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */