package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

public class ConnAckPackage extends BasePackage {
  public int code = 0;
  
  public String reason;
  
  protected void parseMsgData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.code = BytesUtils.byteTo1Number(paramArrayOfbyte, paramInt1);
    if (paramInt2 > ++paramInt1) {
      Map map = MsgPackHelper.unpackMap(paramArrayOfbyte, paramInt1, paramInt2);
      if (map != null) {
        this.reason = MsgPackHelper.getStringValue(map, "error_msg", "");
        return;
      } 
      this.reason = "";
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[code:");
    stringBuilder.append(this.code);
    stringBuilder.append(", reason:");
    stringBuilder.append(this.reason);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ConnAckPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */