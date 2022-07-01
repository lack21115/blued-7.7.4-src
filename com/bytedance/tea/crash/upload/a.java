package com.bytedance.tea.crash.upload;

import android.content.Context;
import com.bytedance.tea.crash.g.d;
import com.bytedance.tea.crash.g.h;
import com.bytedance.tea.crash.h;
import org.json.JSONObject;

public class a {
  private static volatile a a;
  
  private volatile Context b;
  
  private a(Context paramContext) {
    this.b = paramContext;
  }
  
  public static a a() {
    if (a == null)
      a = new a(h.d()); 
    return a;
  }
  
  public String a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      if (paramJSONObject.length() <= 0)
        return null; 
      try {
        return d.a(h.a(this.b), h.a(), str, paramJSONObject, b.a());
      } finally {
        paramJSONObject = null;
      } 
    } 
    return null;
  }
  
  public void b(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      if (paramJSONObject.length() <= 0)
        return; 
      try {
        String str1 = b.a(h.a().a());
        String str2 = d.a(h.a(this.b), h.b(), str1, paramJSONObject, b.b());
        paramJSONObject.put("upload_scene", "direct");
        return;
      } finally {
        paramJSONObject = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\cras\\upload\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */