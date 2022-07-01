package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

public final class q {
  public static String a(Context paramContext, String paramString) {
    return HiAnalyticsClient.reportEntry(paramContext, paramString, 50004300);
  }
  
  public static void a(Context paramContext, String paramString, ResponseErrorCode paramResponseErrorCode) {
    HiAnalyticsClient.reportExit(paramContext, paramString, paramResponseErrorCode.getTransactionId(), paramResponseErrorCode.getStatusCode(), paramResponseErrorCode.getErrorCode(), 50004300);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    HiAnalyticsClient.reportExit(paramContext, paramString1, paramString2, Status.SUCCESS.getStatusCode(), paramInt, 50004300);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, ErrorEnum paramErrorEnum) {
    HiAnalyticsClient.reportExit(paramContext, paramString1, paramString2, Status.SUCCESS.getStatusCode(), paramErrorEnum.getExternalCode(), 50004300);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */