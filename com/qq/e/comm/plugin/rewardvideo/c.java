package com.qq.e.comm.plugin.rewardvideo;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ak;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
  public static Pair<Object, Object> a(String paramString, JSONObject paramJSONObject) {
    ak.a("gdt_tag_net", "LoadGDTRewardVideoADResponse: ", new Object[] { paramJSONObject });
    int i = paramJSONObject.optInt("ret");
    if (i != 0)
      return new Pair(Integer.valueOf(i), null); 
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null)
      return new Pair(Integer.valueOf(5004), null); 
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    if (paramJSONObject == null)
      return new Pair(Integer.valueOf(5004), null); 
    i = paramJSONObject.optInt("ret");
    if (i != 0)
      return new Pair(Integer.valueOf(i), null); 
    JSONObject jSONObject = paramJSONObject.optJSONObject("cfg");
    JSONArray jSONArray = paramJSONObject.optJSONArray("list");
    return (jSONArray == null || jSONArray.length() <= 0) ? new Pair(Integer.valueOf(5025), null) : new Pair(jSONArray, jSONObject);
  }
  
  public static Pair<Integer, List<JSONObject>> a(List<JSONObject> paramList) {
    if (paramList != null) {
      int i = paramList.size();
      if (i != 0) {
        Iterator<JSONObject> iterator = paramList.iterator();
        char c1;
        for (c1 = Character.MIN_VALUE; iterator.hasNext(); c1 = '᎜') {
          JSONObject jSONObject = iterator.next();
          if (TextUtils.isEmpty(jSONObject.optString("cl"))) {
            iterator.remove();
            c1 = 'Ꭾ';
            continue;
          } 
          if (!TextUtils.isEmpty(jSONObject.optString("video"))) {
            int j = jSONObject.optInt("video_width");
            int k = jSONObject.optInt("video_height");
            int m = jSONObject.optInt("video_duration");
            int n = GDTADManager.getInstance().getSM().getInteger("rewardVideoClientMaxDuration", 61);
            if (j <= 0 || k <= 0 || m <= 0 || (n > 0 && m > n)) {
              iterator.remove();
              c1 = 'Ꮀ';
            } 
            continue;
          } 
          if (!TextUtils.isEmpty(jSONObject.optString("landing_page")))
            continue; 
          iterator.remove();
        } 
        return (paramList.size() > 0) ? new Pair(Integer.valueOf(0), paramList) : ((i == 1) ? new Pair(Integer.valueOf(c1), null) : new Pair(Integer.valueOf(5039), null));
      } 
    } 
    return new Pair(Integer.valueOf(5025), null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */