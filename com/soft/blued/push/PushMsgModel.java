package com.soft.blued.push;

import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import java.io.Serializable;

public class PushMsgModel implements Serializable {
  public LiveMsgShareEntity extra;
  
  public long session_id;
  
  public short session_type;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PushMsgModel{session_type=");
    stringBuilder.append(this.session_type);
    stringBuilder.append(", session_id=");
    stringBuilder.append(this.session_id);
    stringBuilder.append(", extra=");
    stringBuilder.append(this.extra);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\PushMsgModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */