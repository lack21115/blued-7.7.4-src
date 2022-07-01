package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements e {
  private b() {}
  
  public static b a() {
    return a.a;
  }
  
  public void a(h paramh, d paramd) {
    JSONObject jSONObject = paramd.d().optJSONObject("adInfo");
    paramh.a(jSONObject);
    JSONArray jSONArray = jSONObject.optJSONArray("click_domain_whitelist");
    if (jSONArray == null)
      return; 
    HashSet<String> hashSet = new HashSet();
    for (int i = 0; i < jSONArray.length(); i++)
      hashSet.add(jSONArray.optString(i)); 
    paramh.a(hashSet);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CurrentWhiteList: ");
    stringBuilder.append(hashSet.toString());
    GDTLogger.d(stringBuilder.toString());
  }
  
  public String b() {
    return "addClickDomainWhiteList";
  }
  
  static final class a {
    static final b a = new b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */