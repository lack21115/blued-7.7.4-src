package com.huawei.hms.opendevice;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {
  public static final OpenDeviceHmsClientBuilder a = new OpenDeviceHmsClientBuilder();
  
  public static final Api<OpenDeviceOptions> b = new Api("HuaweiOpenDevice.API");
  
  public static OpenDeviceOptions c = new OpenDeviceOptions();
  
  public OpenDeviceClientImpl(Activity paramActivity) {
    super(paramActivity, b, (Api.ApiOptions)c, a);
    setKitSdkVersion(50004300);
  }
  
  public OpenDeviceClientImpl(Context paramContext) {
    super(paramContext, b, (Api.ApiOptions)c, a);
    setKitSdkVersion(50004300);
  }
  
  public Task<OdidResult> getOdid() {
    String str = HiAnalyticsClient.reportEntry(getContext(), "opendevice.getodid", 50004300);
    return doWrite(new OpenDeviceTaskApiCall("opendevice.getodid", JsonUtil.createJsonString(null), str));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\OpenDeviceClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */