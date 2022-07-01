package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

public class e extends a {
  protected String h;
  
  private boolean i;
  
  private String j;
  
  public e(String paramString1, boolean paramBoolean, String paramString2) {
    this.j = paramString1;
    this.i = paramBoolean;
    this.h = paramString2;
  }
  
  public a a(Cursor paramCursor) {
    boolean bool = false;
    this.a = paramCursor.getLong(0);
    this.b = paramCursor.getLong(1);
    this.c = paramCursor.getString(2);
    this.d = paramCursor.getString(3);
    this.j = paramCursor.getString(4);
    this.h = paramCursor.getString(5);
    if (paramCursor.getInt(6) == 1)
      bool = true; 
    this.i = bool;
    this.e = paramCursor.getString(7);
    this.f = paramCursor.getString(8);
    return this;
  }
  
  protected void a(ContentValues paramContentValues) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(JSONObject paramJSONObject) {
    paramJSONObject.put("local_time_ms", this.a);
    paramJSONObject.put("tea_event_index", this.b);
    paramJSONObject.put("session_id", this.c);
    paramJSONObject.put("user_unique_id", this.d);
    paramJSONObject.put("event", this.j);
    if (this.i && this.h == null)
      i(); 
    paramJSONObject.put("params", this.h);
    paramJSONObject.put("is_bav", this.i);
    paramJSONObject.put("ab_version", this.e);
    paramJSONObject.put("ab_sdk_version", this.f);
  }
  
  protected String[] a() {
    return new String[] { 
        "local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event", "varchar", 
        "params", "varchar", "is_bav", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar" };
  }
  
  protected a b(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optLong("local_time_ms", 0L);
    this.b = paramJSONObject.optLong("tea_event_index", 0L);
    this.c = paramJSONObject.optString("session_id", null);
    this.d = paramJSONObject.optString("user_unique_id", null);
    this.j = paramJSONObject.optString("event", null);
    this.h = paramJSONObject.optString("params", null);
    this.i = paramJSONObject.optBoolean("is_bav", false);
    this.e = paramJSONObject.optString("ab_version", null);
    this.f = paramJSONObject.optString("ab_sdk_version", null);
    return this;
  }
  
  protected JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("local_time_ms", this.a);
    jSONObject.put("tea_event_index", this.b);
    jSONObject.put("session_id", this.c);
    if (!TextUtils.isEmpty(this.d))
      jSONObject.put("user_unique_id", this.d); 
    jSONObject.put("event", this.j);
    if (this.i)
      jSONObject.put("is_bav", 1); 
    if (!TextUtils.isEmpty(this.h))
      jSONObject.put("params", new JSONObject(this.h)); 
    jSONObject.put("datetime", this.g);
    if (!TextUtils.isEmpty(this.e))
      jSONObject.put("ab_version", this.e); 
    if (!TextUtils.isEmpty(this.f))
      jSONObject.put("ab_sdk_version", this.f); 
    return jSONObject;
  }
  
  String d() {
    return "eventv3";
  }
  
  protected String h() {
    return this.j;
  }
  
  protected void i() {}
  
  public String j() {
    return this.j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */