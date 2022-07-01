package com.qq.e.comm.plugin.ab;

import android.net.Uri;
import com.qq.e.comm.util.GDTLogger;
import java.util.Set;
import org.json.JSONObject;

class a {
  private Set<String> a;
  
  private JSONObject b;
  
  public JSONObject a() {
    return this.b;
  }
  
  public void a(Set<String> paramSet) {
    this.a = paramSet;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.b = paramJSONObject;
  }
  
  public boolean a(String paramString) {
    Uri uri = Uri.parse(paramString);
    if (this.a == null || uri == null || !uri.isHierarchical())
      return false; 
    String str = uri.getAuthority();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("click url host is:");
    stringBuilder.append(str);
    GDTLogger.d(stringBuilder.toString());
    return this.a.contains(str);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */