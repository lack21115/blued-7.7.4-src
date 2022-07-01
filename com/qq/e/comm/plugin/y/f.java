package com.qq.e.comm.plugin.y;

import java.util.Iterator;
import org.json.JSONObject;

class f {
  static String a(JSONObject paramJSONObject, String paramString) {
    int i = h.a();
    String str = paramJSONObject.toString();
    if (str.length() <= i)
      return str; 
    Object object = paramJSONObject.opt(paramString);
    if (!(object instanceof JSONObject))
      return str; 
    Iterator iterator = ((JSONObject)object).keys();
    while (iterator.hasNext()) {
      iterator.next();
      iterator.remove();
      object = paramJSONObject.toString();
      if (object.length() <= i)
        return (String)object; 
    } 
    paramJSONObject.remove(paramString);
    return paramJSONObject.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */