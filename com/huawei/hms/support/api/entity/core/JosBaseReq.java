package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class JosBaseReq implements IMessageEntity {
  @Packed
  private String channelId;
  
  @Packed
  private String cpId;
  
  @Packed
  private String hmsSdkVersionName;
  
  private static <T> T get(T paramT) {
    return paramT;
  }
  
  public String getChannelId() {
    return get(this.channelId);
  }
  
  public String getCpID() {
    return get(this.cpId);
  }
  
  public String getHmsSdkVersionName() {
    return get(this.hmsSdkVersionName);
  }
  
  public void setChannelId(String paramString) {
    this.channelId = paramString;
  }
  
  public void setCpID(String paramString) {
    this.cpId = paramString;
  }
  
  public void setHmsSdkVersionName(String paramString) {
    this.hmsSdkVersionName = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\core\JosBaseReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */