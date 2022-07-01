package com.huawei.hms.common.internal;

import com.huawei.hms.common.HuaweiApi;

class HandlerMessageWrapper {
  final HuaweiApi<?> mApi;
  
  final BaseContentWrapper mContentWrapper;
  
  public HandlerMessageWrapper(BaseContentWrapper paramBaseContentWrapper, int paramInt, HuaweiApi<?> paramHuaweiApi) {
    this.mContentWrapper = paramBaseContentWrapper;
    this.mApi = paramHuaweiApi;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\HandlerMessageWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */