package com.huawei.hianalytics.ab.bc.de;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.ij.ab;
import com.huawei.hianalytics.ab.bc.kl.ef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class de {
  public static Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> ab(Context paramContext, String paramString) {
    if (paramContext == null)
      return null; 
    Map<String, ?> map = ab.bc(paramContext, paramString);
    bc(map);
    return ab(map);
  }
  
  public static Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> ab(Context paramContext, String paramString1, String paramString2) {
    if ("alltype".equals(paramString2) || TextUtils.isEmpty(paramString1)) {
      ab.cd("hmsSdk", "read all event records");
      map2 = ab(paramContext, "stat_v2_1");
      map1 = ab(paramContext, "cached_v2_1");
      return ab(map2, map1);
    } 
    paramString2 = ef.ab((String)map2, paramString2);
    Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> map2 = bc((Context)map1, "stat_v2_1", paramString2);
    Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> map1 = bc((Context)map1, "cached_v2_1", paramString2);
    return ab(map2, map1);
  }
  
  private static Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> ab(Map<String, ?> paramMap) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Map.Entry<String, ?> entry : paramMap.entrySet()) {
      String str = (String)entry.getKey();
      if (entry.getValue() instanceof String)
        ab(str, (String)entry.getValue(), (Map)hashMap); 
    } 
    return (Map)hashMap;
  }
  
  private static Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> ab(Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> paramMap1, Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> paramMap2) {
    if (paramMap1.size() == 0 && paramMap2.size() == 0)
      return new HashMap<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>>(); 
    if (paramMap1.size() == 0)
      return paramMap2; 
    if (paramMap2.size() == 0)
      return paramMap1; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Map.Entry<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> entry : paramMap1.entrySet()) {
      String str = (String)entry.getKey();
      List list1 = (List)entry.getValue();
      List list2 = paramMap2.get(str);
      if (list2 != null && list2.size() > 0)
        list1.addAll(list2); 
      hashMap.put(str, list1);
    } 
    return (Map)hashMap;
  }
  
  private static void ab(String paramString1, String paramString2, Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> paramMap) {
    ArrayList<com.huawei.hianalytics.ab.bc.cd.bc.de> arrayList = new ArrayList();
    try {
      if (TextUtils.isEmpty(paramString2))
        return; 
      JSONArray jSONArray = new JSONArray(paramString2);
      if (jSONArray.length() == 0)
        return; 
      int i = 0;
      while (true) {
        if (i < jSONArray.length()) {
          com.huawei.hianalytics.ab.bc.cd.bc.de de1 = new com.huawei.hianalytics.ab.bc.cd.bc.de();
          try {
            de1.ab(jSONArray.getJSONObject(i));
            arrayList.add(de1);
          } catch (JSONException jSONException) {
            ab.ef("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
          } 
          i++;
          continue;
        } 
        paramMap.put(paramString1, arrayList);
        return;
      } 
    } catch (JSONException jSONException) {
      ab.ef("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
      return;
    } 
  }
  
  public static Map<String, List<com.huawei.hianalytics.ab.bc.cd.bc.de>> bc(Context paramContext, String paramString1, String paramString2) {
    String str = ab.ab(paramContext, paramString1, paramString2, "");
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    ab(paramString2, str, (Map)hashMap);
    return (Map)hashMap;
  }
  
  private static void bc(Map<String, ?> paramMap) {
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    Set set = ef.ab(bc.ab());
    while (iterator.hasNext()) {
      if (!set.contains(((Map.Entry)iterator.next()).getKey()))
        iterator.remove(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\de\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */