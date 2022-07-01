package com.qiniu.pili.droid.crash;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
  private Throwable a;
  
  private Thread b;
  
  private Map<String, String> c = new HashMap<String, String>();
  
  private Map<String, String> d = new HashMap<String, String>();
  
  private Context e;
  
  i(Context paramContext) {
    this.e = paramContext;
  }
  
  i a(ReportField paramReportField, String paramString) {
    this.d.put(paramReportField.name(), paramString);
    return this;
  }
  
  i a(Thread paramThread) {
    this.b = paramThread;
    return this;
  }
  
  public i a(Throwable paramThrowable) {
    this.a = paramThrowable;
    return this;
  }
  
  String a(ReportField paramReportField) {
    return this.d.get(paramReportField.name());
  }
  
  String a(String paramString) {
    return this.c.get(paramString);
  }
  
  public Thread a() {
    return this.b;
  }
  
  public Throwable b() {
    return this.a;
  }
  
  JSONObject c() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    JSONArray jSONArray = new JSONArray();
    jSONArray.put(new JSONObject(this.d));
    jSONObject.put("__logs__", jSONArray);
    return jSONObject;
  }
  
  public void d() {
    d d = new d(this.e);
    try {
      if (d.a(this)) {
        d.b(this);
        f f = f.a();
        f.a(new File(f.c(), a(ReportField.a)), this);
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */