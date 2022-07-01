package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e<T, V> extends b<T, V> {
  public e(Context paramContext, T paramT) {
    super(paramContext, paramT);
  }
  
  protected static JSONArray a(JSONObject paramJSONObject) {
    paramJSONObject = paramJSONObject.optJSONObject("data");
    return (paramJSONObject != null) ? paramJSONObject.optJSONArray("list") : null;
  }
  
  protected static void a(CloudItem paramCloudItem, JSONObject paramJSONObject) {
    Iterator<Object> iterator = paramJSONObject.keys();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (iterator == null)
      return; 
    while (iterator.hasNext()) {
      Object object = iterator.next();
      if (object != null) {
        String str = paramJSONObject.optString(object.toString());
        hashMap.put(object.toString(), str);
      } 
    } 
    paramCloudItem.setCustomfield(hashMap);
  }
  
  protected static CloudItemDetail b(JSONObject paramJSONObject) throws JSONException {
    CloudItemDetail cloudItemDetail = new CloudItemDetail(p.a(paramJSONObject, "id"), new LatLonPoint(paramJSONObject.optDouble("point_y"), paramJSONObject.optDouble("point_x")), p.a(paramJSONObject, "title"), p.a(paramJSONObject, "address"));
    cloudItemDetail.setCreatetime(p.a(paramJSONObject, "gmt_create"));
    cloudItemDetail.setUpdatetime(p.a(paramJSONObject, "gmt_modified"));
    if (paramJSONObject.has("_distance")) {
      boolean bool;
      String str = paramJSONObject.optString("_distance");
      if (str == null || str.equals("") || str.equals("[]")) {
        bool = true;
      } else {
        bool = false;
      } 
      if (!bool)
        cloudItemDetail.setDistance(Integer.parseInt(str)); 
    } 
    return cloudItemDetail;
  }
  
  protected final V a(byte[] paramArrayOfbyte) throws AMapException {
    try {
      String str = new String(paramArrayOfbyte, "utf-8");
    } catch (Exception exception) {
      i.a(exception, "ProtocalHandler", "loadData");
      exception = null;
    } 
    if (exception != null) {
      if (exception.equals(""))
        return null; 
      i.c((String)exception);
      return a((String)exception);
    } 
    return null;
  }
  
  public final Map<String, String> f() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("Content-Type", "application/x-www-form-urlencoded");
    hashMap.put("Accept-Encoding", "gzip");
    hashMap.put("User-Agent", "AMAP SDK Android Search 7.7.0");
    hashMap.put("X-INFO", bl.a(this.e));
    hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { "7.7.0", "cloud" }));
    hashMap.put("logversion", "2.1");
    return (Map)hashMap;
  }
  
  public final byte[] i() {
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */