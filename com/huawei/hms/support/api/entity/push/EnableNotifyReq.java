package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class EnableNotifyReq implements IMessageEntity {
  @Packed
  public boolean enable;
  
  @Packed
  public String packageName;
  
  public String getPackageName() {
    return this.packageName;
  }
  
  public boolean isEnable() {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean) {
    this.enable = paramBoolean;
  }
  
  public void setPackageName(String paramString) {
    this.packageName = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("EnableNotifyReq{");
    stringBuilder.append("packageName='");
    stringBuilder.append(this.packageName);
    stringBuilder.append('\'');
    stringBuilder.append(", enable=");
    stringBuilder.append(this.enable);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\push\EnableNotifyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */