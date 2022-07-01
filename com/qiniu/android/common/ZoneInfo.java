package com.qiniu.android.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ZoneInfo {
  private static int DOMAIN_FROZEN_SECONDS = 600;
  
  private final int ttl;
  
  public final List<String> upDomainsList;
  
  public final Map<String, Long> upDomainsMap;
  
  public ZoneInfo(int paramInt, List<String> paramList, Map<String, Long> paramMap) {
    this.ttl = paramInt;
    this.upDomainsList = paramList;
    this.upDomainsMap = paramMap;
  }
  
  public static ZoneInfo buildFromJson(JSONObject paramJSONObject) throws JSONException {
    int j = paramJSONObject.getInt("ttl");
    ArrayList<String> arrayList = new ArrayList();
    ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
    paramJSONObject = paramJSONObject.getJSONObject("up");
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "acc";
    arrayOfString[1] = "src";
    arrayOfString[2] = "old_acc";
    arrayOfString[3] = "old_src";
    int k = arrayOfString.length;
    int i = 0;
    while (true) {
      if (i < k) {
        JSONObject jSONObject = paramJSONObject.getJSONObject(arrayOfString[i]);
        JSONArray jSONArray = jSONObject.getJSONArray("main");
        int m;
        for (m = 0; m < jSONArray.length(); m++) {
          String str = jSONArray.getString(m);
          arrayList.add(str);
          concurrentHashMap.put(str, Long.valueOf(0L));
        } 
        try {
          JSONArray jSONArray1 = jSONObject.getJSONArray("backup");
          if (jSONArray1 != null)
            for (m = 0; m < jSONArray1.length(); m++) {
              String str = jSONArray1.getString(m);
              arrayList.add(str);
              concurrentHashMap.put(str, Long.valueOf(0L));
            }  
        } catch (JSONException jSONException) {}
        i++;
        continue;
      } 
      return new ZoneInfo(j, arrayList, (Map)concurrentHashMap);
    } 
  }
  
  public void frozenDomain(String paramString) {
    this.upDomainsMap.put(paramString, Long.valueOf(System.currentTimeMillis() / 1000L + DOMAIN_FROZEN_SECONDS));
  }
  
  public String toString() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("ttl", Integer.valueOf(this.ttl));
    hashMap.put("upDomainList", this.upDomainsList);
    hashMap.put("upDomainMap", this.upDomainsMap);
    return (new JSONObject(hashMap)).toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\common\ZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */