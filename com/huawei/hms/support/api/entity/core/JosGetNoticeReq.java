package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.annotation.Packed;

public class JosGetNoticeReq extends JosBaseReq {
  public static final int NOTICE_TYPE_CONN = 0;
  
  public static final int NOTICE_TYPE_SIGN = 1;
  
  @Packed
  private int noticeType;
  
  private static <T> T get(T paramT) {
    return paramT;
  }
  
  public int getNoticeType() {
    return ((Integer)get(Integer.valueOf(this.noticeType))).intValue();
  }
  
  public void setNoticeType(int paramInt) {
    this.noticeType = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\core\JosGetNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */