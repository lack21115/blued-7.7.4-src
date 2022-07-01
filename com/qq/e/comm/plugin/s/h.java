package com.qq.e.comm.plugin.s;

import android.graphics.Point;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {
  private String a;
  
  private List<Integer> b;
  
  private List<Point> c;
  
  private List<String> d;
  
  private boolean e;
  
  public static h a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      h h1 = new h();
      h1.a(paramJSONObject.optString("date"));
      h1.a(d.b(paramJSONObject.optJSONArray("index")));
      JSONArray jSONArray = paramJSONObject.optJSONArray("effectivetime");
      ArrayList<Point> arrayList = new ArrayList();
      if (jSONArray != null && jSONArray.length() > 0)
        for (int j = 0; j < jSONArray.length(); j++) {
          JSONObject jSONObject = jSONArray.optJSONObject(j);
          if (jSONObject != null) {
            Point point = new Point();
            point.x = jSONObject.optInt("start");
            point.y = jSONObject.optInt("end");
            arrayList.add(point);
          } 
        }  
      h1.b(arrayList);
      h1.c(d.a(paramJSONObject.optJSONArray("server_data")));
      int i = paramJSONObject.optInt("is_first_play");
      boolean bool = true;
      if (i != 1)
        bool = false; 
      h1.a(bool);
      return h1;
    } 
    return null;
  }
  
  public static List<h> a(JSONArray paramJSONArray) {
    ArrayList<Object> arrayList = new ArrayList();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++) {
        Object object = paramJSONArray.opt(i);
        if (object instanceof JSONObject) {
          object = a((JSONObject)object);
          if (object != null)
            arrayList.add(object); 
        } else {
          GDTLogger.e("Slot.parseList error !");
        } 
      }  
    return arrayList;
  }
  
  public String a() {
    return this.a;
  }
  
  public String a(Integer paramInteger) {
    List<Integer> list = b();
    List<String> list1 = d();
    if (list != null && list1 != null) {
      int i = list.indexOf(paramInteger);
      if (i >= 0 && i < list1.size())
        return list1.get(i); 
    } 
    if (list1 != null && list1.size() > 0) {
      boolean bool = false;
      return list1.get(bool);
    } 
    return null;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(List<Integer> paramList) {
    this.b = paramList;
  }
  
  public void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public List<Integer> b() {
    return this.b;
  }
  
  public void b(List<Point> paramList) {
    this.c = paramList;
  }
  
  public List<Point> c() {
    return this.c;
  }
  
  public void c(List<String> paramList) {
    this.d = paramList;
  }
  
  public List<String> d() {
    return this.d;
  }
  
  public boolean e() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\s\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */