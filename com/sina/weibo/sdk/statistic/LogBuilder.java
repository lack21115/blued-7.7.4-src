package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class LogBuilder {
  private static final String APPKEY = "WEIBO_APPKEY";
  
  private static final String CHANNEL = "WEIBO_CHANNEL";
  
  public static final String KEY_AID = "aid";
  
  public static final String KEY_APPKEY = "appkey";
  
  public static final String KEY_CHANNEL = "channel";
  
  private static final String KEY_DURATION = "duration";
  
  public static final String KEY_END_TIME = "endtime";
  
  private static final String KEY_EVENT_ID = "event_id";
  
  private static final String KEY_EXTEND = "extend";
  
  public static final String KEY_HASH = "key_hash";
  
  public static final String KEY_PACKAGE_NAME = "packagename";
  
  private static final String KEY_PAGE_ID = "page_id";
  
  public static final String KEY_PLATFORM = "platform";
  
  public static final String KEY_START_TIME = "starttime";
  
  private static final String KEY_TIME = "time";
  
  public static final String KEY_TYPE = "type";
  
  public static final String KEY_VERSION = "version";
  
  private static final int MAX_COUNT = 500;
  
  public static final long MAX_INTERVAL = 86400000L;
  
  private static JSONObject addEventData(JSONObject paramJSONObject, EventLog paramEventLog) {
    try {
      paramJSONObject.put("event_id", paramEventLog.getEvent_id());
      if (paramEventLog.getExtend() != null) {
        Map<String, String> map = paramEventLog.getExtend();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
          if (i < 10) {
            if (!TextUtils.isEmpty(map.get(str))) {
              if (stringBuilder.length() > 0)
                stringBuilder.append("|"); 
              stringBuilder.append(str);
              stringBuilder.append(":");
              stringBuilder.append(map.get(str));
              i++;
            } 
            continue;
          } 
          break;
        } 
        paramJSONObject.put("extend", stringBuilder.toString());
        return paramJSONObject;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("add event log error.");
      stringBuilder.append(exception);
      LogUtil.e("WBAgent", stringBuilder.toString());
    } 
    return paramJSONObject;
  }
  
  private static String buildUploadLogs(String paramString) {
    String str = LogFileUtil.getAppLogs(LogFileUtil.getAppLogPath("app_logs"));
    if (TextUtils.isEmpty(str) && TextUtils.isEmpty(paramString))
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{applogs:[");
    if (!TextUtils.isEmpty(str))
      stringBuilder.append(str); 
    if (!TextUtils.isEmpty(paramString))
      stringBuilder.append(paramString); 
    if (stringBuilder.charAt(stringBuilder.length() - 1) == ',')
      stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), ""); 
    stringBuilder.append("]}");
    return stringBuilder.toString();
  }
  
  public static String getAppKey(Context paramContext) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null) {
        Object object = applicationInfo.metaData.get("WEIBO_APPKEY");
        if (object != null) {
          StringBuilder stringBuilder = new StringBuilder("APPKEY: ");
          stringBuilder.append(String.valueOf(object));
          LogUtil.i("WBAgent", stringBuilder.toString());
          return String.valueOf(object);
        } 
        LogUtil.e("WBAgent", "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
      stringBuilder.append(exception);
      LogUtil.e("WBAgent", stringBuilder.toString());
    } 
    return null;
  }
  
  public static String getChannel(Context paramContext) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null) {
        String str = applicationInfo.metaData.getString("WEIBO_CHANNEL");
        if (str != null) {
          StringBuilder stringBuilder = new StringBuilder("CHANNEL: ");
          stringBuilder.append(str.trim());
          LogUtil.i("WBAgent", stringBuilder.toString());
          return str.trim();
        } 
        LogUtil.e("WBAgent", "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
      stringBuilder.append(exception);
      LogUtil.e("WBAgent", stringBuilder.toString());
    } 
    return null;
  }
  
  private static JSONObject getLogInfo(PageLog paramPageLog) {
    JSONObject jSONObject = new JSONObject();
    try {
      int i = $SWITCH_TABLE$com$sina$weibo$sdk$statistic$LogType()[paramPageLog.getType().ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5)
                return jSONObject; 
              jSONObject.put("type", 4);
              jSONObject.put("page_id", paramPageLog.getPage_id());
              jSONObject.put("time", paramPageLog.getStartTime() / 1000L);
              jSONObject.put("duration", paramPageLog.getDuration() / 1000L);
              return jSONObject;
            } 
            jSONObject.put("type", 3);
            jSONObject.put("page_id", paramPageLog.getPage_id());
            jSONObject.put("time", paramPageLog.getStartTime() / 1000L);
            addEventData(jSONObject, (EventLog)paramPageLog);
            return jSONObject;
          } 
          jSONObject.put("type", 2);
          jSONObject.put("page_id", paramPageLog.getPage_id());
          jSONObject.put("time", paramPageLog.getStartTime() / 1000L);
          jSONObject.put("duration", paramPageLog.getDuration() / 1000L);
          return jSONObject;
        } 
        jSONObject.put("type", 1);
        jSONObject.put("time", paramPageLog.getEndTime() / 1000L);
        jSONObject.put("duration", paramPageLog.getDuration() / 1000L);
        return jSONObject;
      } 
      jSONObject.put("type", 0);
      jSONObject.put("time", paramPageLog.getStartTime() / 1000L);
      return jSONObject;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("get page log error.");
      stringBuilder.append(exception);
      LogUtil.e("WBAgent", stringBuilder.toString());
      return jSONObject;
    } 
  }
  
  public static String getPageLogs(List<PageLog> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<PageLog> iterator = paramList.iterator();
    while (true) {
      if (!iterator.hasNext())
        return stringBuilder.toString(); 
      stringBuilder.append(getLogInfo(iterator.next()).toString());
      stringBuilder.append(",");
    } 
  }
  
  public static List<JSONArray> getValidUploadLogs(String paramString) {
    String str = buildUploadLogs(paramString);
    if (TextUtils.isEmpty(str))
      return null; 
    ArrayList<JSONArray> arrayList = new ArrayList();
    JSONArray jSONArray = new JSONArray();
    long l = System.currentTimeMillis();
    try {
      JSONArray jSONArray1 = (new JSONObject(str)).getJSONArray("applogs");
      int i = 0;
      for (int j = 0;; j = k) {
        if (i >= jSONArray1.length()) {
          if (jSONArray.length() > 0) {
            arrayList.add(jSONArray);
            return arrayList;
          } 
          break;
        } 
        JSONObject jSONObject = jSONArray1.getJSONObject(i);
        JSONArray jSONArray2 = jSONArray;
        int k = j;
        if (isDataValid(l, jSONObject.getLong("time") * 1000L))
          if (j < 500) {
            jSONArray.put(jSONObject);
            k = j + 1;
            jSONArray2 = jSONArray;
          } else {
            arrayList.add(jSONArray);
            jSONArray2 = new JSONArray();
            k = 0;
          }  
        i++;
        jSONArray = jSONArray2;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return arrayList;
  }
  
  public static String getVersion(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      StringBuilder stringBuilder = new StringBuilder("versionName: ");
      stringBuilder.append(packageInfo.versionName);
      LogUtil.i("WBAgent", stringBuilder.toString());
      return packageInfo.versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder("Could not read versionName from AndroidManifest.xml.");
      stringBuilder.append(nameNotFoundException);
      LogUtil.e("WBAgent", stringBuilder.toString());
      return null;
    } 
  }
  
  private static boolean isDataValid(long paramLong1, long paramLong2) {
    return (paramLong1 - paramLong2 < 86400000L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\LogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */