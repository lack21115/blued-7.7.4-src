package com.geetest.onelogin.g;

import com.geetest.onelogin.a.d;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.p;
import com.geetest.onelogin.listener.a.b;
import com.geetest.onelogin.listener.c;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {
  public d a;
  
  public String b;
  
  private volatile boolean c;
  
  public a(d paramd) {
    this.a = paramd;
    this.c = false;
  }
  
  public String a(String paramString) {
    return c(this.a.getOperator(), paramString);
  }
  
  public void a(String paramString1, String paramString2) {
    JSONObject jSONObject;
    try {
      JSONObject jSONObject1 = com.geetest.onelogin.listener.a.a.a(paramString1, this.a, new JSONObject(paramString2));
      jSONObject = jSONObject1;
    } catch (JSONException jSONException) {
      jSONObject = com.geetest.onelogin.listener.a.a.a((String)jSONObject, this.a, com.geetest.onelogin.listener.a.a.a(paramString2));
    } 
    if (a())
      return; 
    c.b(this.a, jSONObject, true);
  }
  
  public void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean) {
    JSONObject jSONObject;
    if (paramBoolean) {
      jSONObject = com.geetest.onelogin.listener.a.a.a(paramString, this.a, paramJSONObject);
    } else {
      jSONObject = com.geetest.onelogin.listener.a.a.d((String)jSONObject, this.a, paramJSONObject);
    } 
    if (a())
      return; 
    c.b(this.a, jSONObject, paramBoolean);
  }
  
  public void a(boolean paramBoolean) {
    JSONObject jSONObject;
    if (paramBoolean) {
      jSONObject = b.a(this.a);
    } else {
      jSONObject = b.b(this.a);
    } 
    if (a())
      return; 
    c.b(this.a, jSONObject, paramBoolean);
  }
  
  public boolean a() {
    return this.c;
  }
  
  public void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append("运营商预取号开始请求");
    h.b(stringBuilder.toString());
    d();
  }
  
  protected void b(String paramString1, String paramString2) {
    JSONObject jSONObject;
    try {
      JSONObject jSONObject1 = com.geetest.onelogin.listener.a.a.d(paramString1, this.a, new JSONObject(paramString2));
      jSONObject = jSONObject1;
    } catch (JSONException jSONException) {
      jSONObject = com.geetest.onelogin.listener.a.a.d((String)jSONObject, this.a, com.geetest.onelogin.listener.a.a.a(paramString2));
    } 
    if (a())
      return; 
    c.b(this.a, jSONObject, false);
  }
  
  protected String c(String paramString1, String paramString2) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append("运营商取号开始请求");
    h.b(stringBuilder.toString());
    p.a().a("requestToken");
    e();
  }
  
  public abstract void d();
  
  public abstract void e();
  
  public void f() {
    this.c = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */