package com.blued.android.chat.core.pack;

import com.blued.android.chat.data.PackageAckResult;
import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

public class DisconnectPackage extends BasePackage {
  public short code;
  
  public String reason;
  
  protected BytesData msgDataToByte() {
    return null;
  }
  
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
  
  public static interface DISCONNECT_RESULT extends PackageAckResult {
    public static final int DUPLICATE_LOGIN = 4;
    
    public static final int FORBIDDEN = 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\DisconnectPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */