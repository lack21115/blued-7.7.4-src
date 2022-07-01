package com.qq.e.comm.plugin.n;

import android.view.View;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.bf;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends c {
  private com.qq.e.comm.plugin.s.e a;
  
  private f.a b;
  
  public e(com.qq.e.comm.plugin.s.e parame, f.a parama) {
    this.a = parame;
    this.b = parama;
  }
  
  public f<String> a(com.qq.e.comm.plugin.ab.f.e parame, View paramView, String paramString1, String paramString2, String paramString3, String paramString4) {
    f.a a1;
    JSONObject jSONObject;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("EndCardView JS action : ");
    stringBuilder.append(paramString2);
    GDTLogger.d(stringBuilder.toString());
    a a2 = this.b.c();
    if ("getVideoAdInfo".equals(paramString2)) {
      JSONObject jSONObject1 = new JSONObject();
      try {
        JSONObject jSONObject2 = n.a(paramView.getContext(), a2);
        jSONObject1.put("code", 0);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject = this.a.a();
        jSONObject3.put("adInfo", jSONObject2);
        jSONObject3.put("cfg", jSONObject);
        jSONObject1.put("data", jSONObject3);
        return new f(jSONObject1.toString());
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("EndCardView getVideoAdInfo JSONException : ");
        stringBuilder1.append(jSONException.getMessage());
        GDTLogger.d(stringBuilder1.toString());
        return new f(null);
      } 
    } 
    if ("onClick".equals(jSONObject)) {
      try {
        String str = (new JSONObject(paramString3)).optString("antiSpam");
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      a1 = this.b;
      if (a1 != null)
        a1.a((String)jSONException, false); 
      return new f(null);
    } 
    if ("isViewable".equals(jSONObject)) {
      if (a1 == null)
        return new f(null); 
      boolean bool = bf.a(a1.getContext(), (View)a1, 100);
      stringBuilder = new StringBuilder();
      stringBuilder.append("isViewable : ");
      stringBuilder.append(bool);
      GDTLogger.d(stringBuilder.toString());
      JSONObject jSONObject1 = new JSONObject();
      try {
        jSONObject1.put("viewable", bool);
        return new f(jSONObject1.toString());
      } catch (Exception exception) {
        exception.printStackTrace();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("EndCardView isViewable JSONException : ");
        stringBuilder1.append(exception.getMessage());
        GDTLogger.d(stringBuilder1.toString());
        return new f(null);
      } 
    } 
    return new f(1000, "Unsupported action");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\n\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */