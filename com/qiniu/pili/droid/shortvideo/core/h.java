package com.qiniu.pili.droid.shortvideo.core;

import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
  public File a;
  
  public int b;
  
  public int c;
  
  public long d;
  
  public long e;
  
  public int f;
  
  public int g;
  
  public h() {}
  
  public h(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4) {
    this.a = new File(paramString);
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramInt3;
    this.g = paramInt4;
  }
  
  public static h a(JSONObject paramJSONObject) {
    return new h(paramJSONObject.optString("fileName"), paramJSONObject.optInt("audioIndex"), paramJSONObject.optInt("videoIndex"), paramJSONObject.optLong("startTimeMs"), paramJSONObject.optLong("durationMs"), paramJSONObject.optInt("audioFrameNum"), paramJSONObject.optInt("videoFrameNum"));
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("fileName", this.a.getPath());
      jSONObject.put("audioIndex", this.b);
      jSONObject.put("videoIndex", this.c);
      jSONObject.put("startTimeMs", this.d);
      jSONObject.put("durationMs", this.e);
      jSONObject.put("audioFrameNum", this.f);
      jSONObject.put("videoFrameNum", this.g);
      return jSONObject;
    } catch (JSONException jSONException) {
      e.f.e("SectionInfo", "Error on saving to json string");
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */