package com.qq.e.comm.plugin.s;

import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

class d {
  public static List<String> a(JSONArray paramJSONArray) {
    ArrayList<String> arrayList = new ArrayList();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++) {
        Object object = paramJSONArray.opt(i);
        if (object instanceof String) {
          arrayList.add((String)object);
        } else {
          GDTLogger.e("parseStringList error ! type wrong !");
        } 
      }  
    return arrayList;
  }
  
  public static List<Integer> b(JSONArray paramJSONArray) {
    ArrayList<Integer> arrayList = new ArrayList();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++) {
        Object object = paramJSONArray.opt(i);
        if (object instanceof Integer) {
          arrayList.add((Integer)object);
        } else {
          GDTLogger.e("parseIntegerList error ! type wrong !");
        } 
      }  
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\s\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */