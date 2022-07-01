package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HianalyticsBaseData {
  private static final String SDK_NAME = "sdk_name";
  
  private static final String SDK_TYPE = "sdk_type";
  
  private static final String TAG = "HianalyticsBaseData";
  
  private LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
  
  public HianalyticsBaseData() {
    this.data.put("sdk_type", "UxPP");
    this.data.put("sdk_name", "Restclient");
  }
  
  public LinkedHashMap<String, String> get() {
    return this.data;
  }
  
  public HianalyticsBaseData put(String paramString, long paramLong) {
    StringBuilder stringBuilder1;
    if (paramString == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("key = null : value = ");
      stringBuilder1.append(paramLong);
      Logger.v("HianalyticsBaseData", stringBuilder1.toString());
      return this;
    } 
    LinkedHashMap<String, String> linkedHashMap = this.data;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(paramLong);
    linkedHashMap.put(stringBuilder1, stringBuilder2.toString());
    return this;
  }
  
  public HianalyticsBaseData put(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("key = ");
      stringBuilder.append(paramString1);
      stringBuilder.append(" : value = ");
      stringBuilder.append(paramString2);
      Logger.v("HianalyticsBaseData", stringBuilder.toString());
      return this;
    } 
    this.data.put(paramString1, paramString2);
    return this;
  }
  
  public HianalyticsBaseData put(LinkedHashMap<String, String> paramLinkedHashMap) {
    if (paramLinkedHashMap == null || paramLinkedHashMap.isEmpty()) {
      Logger.v("HianalyticsBaseData", "data is null");
      return this;
    } 
    this.data.putAll(paramLinkedHashMap);
    return this;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    LinkedHashMap<String, String> linkedHashMap = get();
    try {
      for (Map.Entry<String, String> entry : linkedHashMap.entrySet())
        jSONObject.put((String)entry.getKey(), entry.getValue()); 
    } catch (JSONException jSONException) {
      Logger.w("HianalyticsBaseData", "catch JSONException", (Throwable)jSONException);
    } 
    return jSONObject.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\hianalytics\HianalyticsBaseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */