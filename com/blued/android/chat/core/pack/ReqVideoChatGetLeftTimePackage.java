package com.blued.android.chat.core.pack;

import java.util.HashMap;
import java.util.Map;

public class ReqVideoChatGetLeftTimePackage extends ReqBasePackage {
  public long invited_uid;
  
  public ReqVideoChatGetLeftTimePackage(long paramLong) {
    super((short)17, paramLong);
  }
  
  protected Map<String, Object> getReqInfo() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("invited_uid", Long.valueOf(this.invited_uid));
    return (Map)hashMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[invited_uid:");
    stringBuilder.append(this.invited_uid);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqVideoChatGetLeftTimePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */