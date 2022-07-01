package com.qq.e.comm.plugin.rewardvideo.a;

import android.view.View;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.rewardvideo.l;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends c {
  private final l a;
  
  public b(l paraml) {
    this.a = paraml;
  }
  
  public f<String> a(e parame, View paramView, String paramString1, String paramString2, String paramString3, String paramString4) {
    if ("onClick".equals(paramString2)) {
      int i = 3;
      try {
        String str = (new JSONObject(paramString3)).optString("antiSpam");
        try {
          int j = Integer.parseInt((new JSONObject(str)).optString("click_area"));
          i = j;
        } catch (JSONException null) {}
      } catch (JSONException jSONException) {
        parame = null;
      } 
      jSONException.printStackTrace();
    } 
    return new f(1000, "Unsupported action");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */