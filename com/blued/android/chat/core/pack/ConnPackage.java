package com.blued.android.chat.core.pack;

import android.util.Base64;
import com.blued.android.chat.data.PackageAckResult;
import com.blued.android.chat.utils.BytesUtils;

public class ConnPackage extends BasePackage {
  private static final String TAG = "Chat_ConnPackage";
  
  public final String token;
  
  public final long uid;
  
  public ConnPackage(long paramLong, String paramString) {
    this.uid = paramLong;
    this.token = paramString;
  }
  
  protected BytesData msgDataToByte() {
    byte[] arrayOfByte = Base64.decode(this.token, 2);
    BytesData bytesData = new BytesData(arrayOfByte.length + 4);
    BytesUtils.numberTo4Bytes(bytesData.data, 0, this.uid);
    BytesUtils.copy(arrayOfByte, 0, bytesData.data, 4, arrayOfByte.length);
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[uid:");
    stringBuilder.append(this.uid);
    stringBuilder.append(", token:");
    stringBuilder.append(this.token);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public static interface CONN_RESULT extends PackageAckResult {
    public static final int AUTH_FAILED = 5;
    
    public static final int CONNECT_DUPLICATE = 6;
    
    public static final int CONNECT_REJECT = 4;
    
    public static final int SERVICE_UNAVAIABLE = 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ConnPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */