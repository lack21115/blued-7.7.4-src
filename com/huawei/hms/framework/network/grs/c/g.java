package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;

public class g {
  public static void a(ArrayList<e> paramArrayList, long paramLong, JSONArray paramJSONArray, Context paramContext) {
    if (paramContext != null && paramArrayList != null && paramArrayList.size() > 0 && HianalyticsHelper.getInstance().isEnableReportNoSeed(paramContext))
      HianalyticsHelper.getInstance().getReportExecutor().execute(new f(paramLong, paramContext, paramArrayList, paramJSONArray)); 
  }
  
  private static LinkedHashMap<String, String> b(e parame) {
    LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
    Exception exception = parame.d();
    if (exception != null) {
      linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(exception));
      linkedHashMapPack.put("exception_name", exception.getClass().getSimpleName());
      linkedHashMapPack.put("message", StringUtils.anonymizeMessage(exception.getMessage()));
    } else {
      linkedHashMapPack.put("error_code", parame.b());
      linkedHashMapPack.put("exception_name", parame.c());
    } 
    try {
      linkedHashMapPack.put("domain", (new URL(parame.k())).getHost());
    } catch (MalformedURLException malformedURLException) {
      Logger.w("HaReportHelper", "report host MalformedURLException", malformedURLException);
    } 
    linkedHashMapPack.put("req_start_time", parame.g());
    linkedHashMapPack.put("req_end_time", parame.f());
    linkedHashMapPack.put("req_total_time", parame.h());
    return linkedHashMapPack.getAll();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */