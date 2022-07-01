package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.stats.a;
import com.huawei.hms.stats.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class HiAnalyticsUtils {
  private static final Object LOCK_INST = new Object();
  
  private static final Object LOCK_REPORT = new Object();
  
  private static final String TAG = "HiAnalyticsUtils";
  
  private static HiAnalyticsUtils sInstance;
  
  private int count = 0;
  
  private static LinkedHashMap<String, String> convertToLinkedHashMap(Map<String, String> paramMap) {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    for (String str : paramMap.keySet())
      linkedHashMap.put(str, paramMap.get(str)); 
    return (LinkedHashMap)linkedHashMap;
  }
  
  public static HiAnalyticsUtils getInstance() {
    synchronized (LOCK_INST) {
      if (sInstance == null)
        sInstance = new HiAnalyticsUtils(); 
      return sInstance;
    } 
  }
  
  private String getReportJson(Map<String, String> paramMap) {
    if (paramMap == null)
      return null; 
    JSONObject jSONObject = new JSONObject();
    try {
      for (Map.Entry<String, String> entry : paramMap.entrySet())
        jSONObject.put((String)entry.getKey(), entry.getValue()); 
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AnalyticsHelper create json exception");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("HiAnalyticsUtils", stringBuilder.toString());
    } 
    return jSONObject.toString();
  }
  
  private void reportOnNeed() {
    synchronized (LOCK_REPORT) {
      if (this.count < 60) {
        this.count++;
      } else {
        this.count = 0;
        a.a();
      } 
      return;
    } 
  }
  
  public static String versionCodeToName(String paramString) {
    if (!TextUtils.isEmpty(paramString) && (paramString.length() == 8 || paramString.length() == 9))
      try {
        Integer.parseInt(paramString);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.parseInt(paramString.substring(0, paramString.length() - 7)));
        stringBuilder.append(".");
        stringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 7, paramString.length() - 5)));
        stringBuilder.append(".");
        stringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 5, paramString.length() - 3)));
        stringBuilder.append(".");
        stringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 3)));
        return stringBuilder.toString();
      } catch (NumberFormatException numberFormatException) {
        return "";
      }  
    return "";
  }
  
  public void enableLog() {
    HMSLog.i("HiAnalyticsUtils", "Enable Log");
    b.a();
  }
  
  public boolean getInitFlag() {
    HMSLog.i("HiAnalyticsUtils", "Get the init flag");
    return a.b();
  }
  
  public boolean hasError(Context paramContext) {
    return AnalyticsSwitchHolder.isAnalyticsDisabled(paramContext);
  }
  
  public void onBuoyEvent(Context paramContext, String paramString1, String paramString2) {
    if (hasError(paramContext))
      return; 
    if (paramContext != null)
      onEvent2(paramContext, paramString1, paramString2); 
  }
  
  public void onEvent(Context paramContext, String paramString, Map<String, String> paramMap) {
    if (hasError(paramContext))
      return; 
    String str = getReportJson(paramMap);
    if (!TextUtils.isEmpty(str)) {
      onEvent2(paramContext, paramString, str);
      a.a(1, paramString, convertToLinkedHashMap(paramMap));
      reportOnNeed();
    } 
  }
  
  public void onEvent2(Context paramContext, String paramString1, String paramString2) {
    if (hasError(paramContext))
      return; 
    if (paramContext != null && a.b())
      a.a(paramContext, paramString1, paramString2); 
  }
  
  public void onNewEvent(Context paramContext, String paramString, Map<String, String> paramMap) {
    if (hasError(paramContext))
      return; 
    String str = getReportJson(paramMap);
    if (paramContext != null && a.b()) {
      a.a(paramContext, paramString, str);
      a.a(1, paramString, convertToLinkedHashMap(paramMap));
      reportOnNeed();
    } 
  }
  
  public void onReport(Context paramContext, String paramString, Map<String, String> paramMap) {
    if (hasError(paramContext))
      return; 
    String str = getReportJson(paramMap);
    if (!TextUtils.isEmpty(str)) {
      HMSLog.i("HiAnalyticsUtils", "Report the data");
      onEvent2(paramContext, paramString, str);
      a.a(1, paramString, convertToLinkedHashMap(paramMap));
      a.a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\hianalytics\HiAnalyticsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */