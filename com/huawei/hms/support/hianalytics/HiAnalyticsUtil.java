package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.HashMap;
import java.util.Map;

public class HiAnalyticsUtil {
  private static final Object LOCK_INST = new Object();
  
  private static final String TAG = "HiAnalyticsUtil";
  
  private static HiAnalyticsUtil sInstance;
  
  private static HiAnalyticsUtils sUtilsInstance;
  
  private String genValue(Context paramContext, String paramString) {
    String str = paramContext.getPackageName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("01|");
    stringBuilder.append("");
    stringBuilder.append("|");
    stringBuilder.append(str);
    stringBuilder.append("|");
    stringBuilder.append(Util.getAppId(paramContext));
    stringBuilder.append("|");
    stringBuilder.append(50004301);
    stringBuilder.append("|");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static HiAnalyticsUtil getInstance() {
    synchronized (LOCK_INST) {
      if (sInstance == null) {
        sInstance = new HiAnalyticsUtil();
        sUtilsInstance = HiAnalyticsUtils.getInstance();
      } 
      return sInstance;
    } 
  }
  
  public static Map<String, String> getMapFromForegroundResponseHeader(ResponseHeader paramResponseHeader) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramResponseHeader == null)
      return (Map)hashMap; 
    hashMap.put("transId", paramResponseHeader.getTransactionId());
    hashMap.put("appid", paramResponseHeader.getActualAppID());
    hashMap.put("service", paramResponseHeader.getSrvName());
    hashMap.put("apiName", paramResponseHeader.getApiName());
    hashMap.put("package", paramResponseHeader.getPkgName());
    hashMap.put("statusCode", String.valueOf(paramResponseHeader.getStatusCode()));
    hashMap.put("result", String.valueOf(paramResponseHeader.getErrorCode()));
    hashMap.put("errorReason", paramResponseHeader.getErrorReason());
    hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    hashMap.put("baseVersion", "5.0.4.301");
    return (Map)hashMap;
  }
  
  public static Map<String, String> getMapFromRequestHeader(ResponseHeader paramResponseHeader) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramResponseHeader == null)
      return (Map)hashMap; 
    hashMap.put("transId", paramResponseHeader.getTransactionId());
    hashMap.put("appid", paramResponseHeader.getActualAppID());
    hashMap.put("service", paramResponseHeader.getSrvName());
    String str = paramResponseHeader.getApiName();
    if (!TextUtils.isEmpty(str)) {
      String[] arrayOfString = str.split("\\.");
      if (arrayOfString.length >= 2)
        hashMap.put("apiName", arrayOfString[1]); 
    } 
    hashMap.put("package", paramResponseHeader.getPkgName());
    hashMap.put("statusCode", String.valueOf(paramResponseHeader.getStatusCode()));
    hashMap.put("result", String.valueOf(paramResponseHeader.getErrorCode()));
    hashMap.put("errorReason", paramResponseHeader.getErrorReason());
    hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    hashMap.put("baseVersion", "5.0.4.301");
    return (Map)hashMap;
  }
  
  public static String versionCodeToName(String paramString) {
    return HiAnalyticsUtils.versionCodeToName(paramString);
  }
  
  @Deprecated
  public Map<String, String> getMapForBi(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length >= 2) {
      String str1 = arrayOfString[0];
      String str2 = arrayOfString[1];
      String str3 = Util.getAppId(paramContext);
      hashMap.put("transId", TransactionIdCreater.getId(str3, paramString));
      hashMap.put("appid", str3);
      hashMap.put("service", str1);
      hashMap.put("apiName", str2);
      hashMap.put("package", paramContext.getPackageName());
      hashMap.put("version", "5.0.4.301");
      hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    } 
    return (Map)hashMap;
  }
  
  public Map<String, String> getMapFromForegroundRequestHeader(RequestHeader paramRequestHeader) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramRequestHeader == null)
      return (Map)hashMap; 
    hashMap.put("transId", paramRequestHeader.getTransactionId());
    hashMap.put("appid", paramRequestHeader.getActualAppID());
    hashMap.put("service", paramRequestHeader.getSrvName());
    hashMap.put("apiName", paramRequestHeader.getApiName());
    hashMap.put("package", paramRequestHeader.getPkgName());
    hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    hashMap.put("baseVersion", "5.0.4.301");
    return (Map)hashMap;
  }
  
  public Map<String, String> getMapFromRequestHeader(RequestHeader paramRequestHeader) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramRequestHeader == null)
      return (Map)hashMap; 
    hashMap.put("transId", paramRequestHeader.getTransactionId());
    hashMap.put("appid", paramRequestHeader.getActualAppID());
    hashMap.put("service", paramRequestHeader.getSrvName());
    String str = paramRequestHeader.getApiName();
    if (!TextUtils.isEmpty(str)) {
      String[] arrayOfString = str.split("\\.");
      if (arrayOfString.length >= 2)
        hashMap.put("apiName", arrayOfString[1]); 
    } 
    hashMap.put("package", paramRequestHeader.getPkgName());
    hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    hashMap.put("baseVersion", "5.0.4.301");
    return (Map)hashMap;
  }
  
  @Deprecated
  public boolean hasError() {
    if (!SystemUtils.isChinaROM()) {
      HMSLog.i("HiAnalyticsUtil", "not ChinaROM ");
      return true;
    } 
    return false;
  }
  
  public boolean hasError(Context paramContext) {
    return sUtilsInstance.hasError(paramContext);
  }
  
  public void onBuoyEvent(Context paramContext, String paramString1, String paramString2) {
    sUtilsInstance.onBuoyEvent(paramContext, paramString1, paramString2);
  }
  
  public void onEvent(Context paramContext, String paramString1, String paramString2) {
    if (paramContext != null)
      onEvent2(paramContext, paramString1, genValue(paramContext, paramString2)); 
  }
  
  public void onEvent(Context paramContext, String paramString, Map<String, String> paramMap) {
    sUtilsInstance.onEvent(paramContext, paramString, paramMap);
  }
  
  public void onEvent2(Context paramContext, String paramString1, String paramString2) {
    sUtilsInstance.onEvent2(paramContext, paramString1, paramString2);
  }
  
  public void onNewEvent(Context paramContext, String paramString, Map paramMap) {
    sUtilsInstance.onNewEvent(paramContext, paramString, paramMap);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\hianalytics\HiAnalyticsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */