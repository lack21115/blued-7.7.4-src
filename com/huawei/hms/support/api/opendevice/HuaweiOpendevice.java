package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.Api;

public class HuaweiOpendevice {
  public static final HuaweiOpendeviceApi HuaweiOpendeviceApi;
  
  public static final Api<Api.ApiOptions.NoOptions> OPEN_DEVICE_API = new Api("HuaweiOpenDevice.API");
  
  static {
    HuaweiOpendeviceApi = new HuaweiOpendeviceApiImpl();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\opendevice\HuaweiOpendevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */