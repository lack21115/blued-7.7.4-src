package com.ss.android.downloadlib.a.b;

import com.ss.android.downloadlib.e.g;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public long a;
  
  public long b;
  
  public long c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  public String g;
  
  public volatile long h;
  
  public a() {}
  
  public a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4) {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
  }
  
  public static a a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    a a1 = new a();
    try {
      a1.a = g.a(paramJSONObject, "mDownloadId");
      a1.b = g.a(paramJSONObject, "mAdId");
      a1.c = g.a(paramJSONObject, "mExtValue");
      a1.d = paramJSONObject.optString("mPackageName");
      a1.e = paramJSONObject.optString("mAppName");
      a1.f = paramJSONObject.optString("mLogExtra");
      a1.g = paramJSONObject.optString("mFileName");
      a1.h = g.a(paramJSONObject, "mTimeStamp");
      return a1;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public void a() {
    this.h = System.currentTimeMillis();
  }
  
  public JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("mDownloadId", this.a);
      jSONObject.put("mAdId", this.b);
      jSONObject.put("mExtValue", this.c);
      jSONObject.put("mPackageName", this.d);
      jSONObject.put("mAppName", this.e);
      jSONObject.put("mLogExtra", this.f);
      jSONObject.put("mFileName", this.g);
      jSONObject.put("mTimeStamp", this.h);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */