package com.huawei.hianalytics.ab.bc.cd.bc;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ab.ab;
import com.huawei.hianalytics.ab.bc.gh.bc;
import org.json.JSONObject;

public class de implements fg {
  private String ab;
  
  private String bc;
  
  private String cd;
  
  private String de;
  
  private String ef;
  
  private String fg;
  
  public JSONObject ab() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("type", this.ab);
    jSONObject.put("eventtime", this.de);
    jSONObject.put("event", this.bc);
    jSONObject.put("event_session_name", this.ef);
    jSONObject.put("first_session_event", this.fg);
    if (TextUtils.isEmpty(this.cd))
      return null; 
    jSONObject.put("properties", new JSONObject(this.cd));
    return jSONObject;
  }
  
  public void ab(String paramString) {
    this.cd = paramString;
  }
  
  public void ab(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    this.bc = paramJSONObject.optString("event");
    this.cd = paramJSONObject.optString("properties");
    String str = bc.de().ab();
    this.cd = ab.ab(this.cd, str);
    this.ab = paramJSONObject.optString("type");
    this.de = paramJSONObject.optString("eventtime");
    this.ef = paramJSONObject.optString("event_session_name");
    this.fg = paramJSONObject.optString("first_session_event");
  }
  
  public String bc() {
    return this.de;
  }
  
  public void bc(String paramString) {
    this.bc = paramString;
  }
  
  public String cd() {
    return this.ab;
  }
  
  public void cd(String paramString) {
    this.de = paramString;
  }
  
  public JSONObject de() {
    JSONObject jSONObject = ab();
    String str = bc.de().ab();
    jSONObject.put("properties", ab.bc(this.cd, str));
    return jSONObject;
  }
  
  public void de(String paramString) {
    this.ab = paramString;
  }
  
  public void ef(String paramString) {
    this.fg = paramString;
  }
  
  public void fg(String paramString) {
    this.ef = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\cd\bc\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */