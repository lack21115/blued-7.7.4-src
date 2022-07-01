package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class OaidResp extends AbstractMessageEntity {
  @Packed
  public String id;
  
  @Packed
  public boolean isTrackLimited;
  
  @Packed
  public PendingIntent settingIntent;
  
  public String getId() {
    return this.id;
  }
  
  public PendingIntent getSettingIntent() {
    return this.settingIntent;
  }
  
  public boolean isTrackLimited() {
    return this.isTrackLimited;
  }
  
  public void setId(String paramString) {
    this.id = paramString;
  }
  
  public void setSettingIntent(PendingIntent paramPendingIntent) {
    this.settingIntent = paramPendingIntent;
  }
  
  public void setTrackLimited(boolean paramBoolean) {
    this.isTrackLimited = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\opendevice\OaidResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */