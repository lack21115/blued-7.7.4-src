package com.huawei.hms.support.api.entity.core;

import android.content.Intent;
import com.huawei.hms.core.aidl.annotation.Packed;

public class JosGetNoticeResp extends JosBaseResp {
  @Packed
  private Intent noticeIntent;
  
  private static <T> T get(T paramT) {
    return paramT;
  }
  
  public Intent getNoticeIntent() {
    return get(this.noticeIntent);
  }
  
  public void setNoticeIntent(Intent paramIntent) {
    this.noticeIntent = paramIntent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\core\JosGetNoticeResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */