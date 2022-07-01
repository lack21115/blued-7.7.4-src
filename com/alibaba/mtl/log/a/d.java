package com.alibaba.mtl.log.a;

import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
  private static d a = new d();
  
  private String S;
  
  private Map<String, c> s = Collections.synchronizedMap(new HashMap<String, c>());
  
  public static d a() {
    return a;
  }
  
  public Map<String, c> b() {
    return this.s;
  }
  
  public void b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("host config:");
    stringBuilder.append(paramString);
    i.a("HostConfigMgr", new Object[] { stringBuilder.toString() });
    if (paramString != null)
      try {
        JSONObject jSONObject1 = new JSONObject(paramString);
        JSONObject jSONObject2 = jSONObject1.getJSONObject("content");
        if (jSONObject2 != null) {
          jSONObject2 = jSONObject2.getJSONObject("hosts");
          if (jSONObject2 != null) {
            Iterator<String> iterator = jSONObject2.keys();
            while (iterator.hasNext()) {
              String str = iterator.next();
              if (str != null) {
                c c = new c();
                JSONObject jSONObject = jSONObject2.getJSONObject(str);
                if (jSONObject != null) {
                  c.R = str.substring(1);
                  c.Q = jSONObject.getString("host");
                  JSONArray jSONArray = jSONObject.getJSONArray("eids");
                  if (jSONArray != null) {
                    c.a = new ArrayList<String>();
                    for (int i = 0; i < jSONArray.length(); i++)
                      c.a.add(jSONArray.getString(i)); 
                  } 
                } 
                Map<String, c> map = this.s;
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(c.R);
                stringBuilder1.append("");
                map.put(stringBuilder1.toString(), c);
              } 
            } 
          } 
        } 
        return;
      } finally {
        paramString = null;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */