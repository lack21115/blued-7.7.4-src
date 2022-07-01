package com.qq.e.comm.plugin.ad;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.f.a;
import com.qq.e.comm.plugin.t.b.c;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.d;
import com.qq.e.comm.plugin.util.ak;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdFilterReporter {
  private JSONArray a = new JSONArray();
  
  private String b;
  
  public void a() {
    if (!TextUtils.isEmpty(this.b)) {
      if (this.a.length() <= 0)
        return; 
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.a);
        String str = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdFilterReporter url:");
        stringBuilder.append(this.b);
        stringBuilder.append(" data:");
        stringBuilder.append(str);
        ak.a(stringBuilder.toString(), new Object[0]);
        c c = new c(this.b, e.a.b, str.getBytes(a.a));
        c.a("Content-Type", "application/json");
        d.a().a((e)c);
      } catch (JSONException jSONException) {
        ak.a("AdFilterReporter report error", (Exception)jSONException);
      } 
      this.a = new JSONArray();
    } 
  }
  
  public void a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (TextUtils.isEmpty(this.b)) {
      int i = paramString.indexOf('?');
      if (i == -1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdFilterReporter fl is not valid:");
        stringBuilder.append(paramString);
        ak.a(stringBuilder.toString(), new Object[0]);
        return;
      } 
      this.b = paramString.substring(0, i);
    } 
    paramString = Uri.parse(paramString).getQueryParameter("viewid");
    if (!TextUtils.isEmpty(paramString)) {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("view_id", paramString);
        jSONObject.put("filter_code", paramInt);
        this.a.put(jSONObject);
        return;
      } catch (JSONException jSONException) {
        ak.a("AdFilterReporter addData error", (Exception)jSONException);
      } 
    } 
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FilterCode {
    public static final int FILTER_INSTALLED = 2;
    
    public static final int FILTER_NONE = 0;
    
    public static final int FILTER_SPLASH = 3;
    
    public static final int FILTER_UNINSTALLED = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\AdFilterReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */