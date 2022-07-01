package com.qq.e.comm.plugin.r.a;

import android.text.TextUtils;
import com.qq.e.comm.plugin.f.a;
import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.comm.plugin.t.b.c;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.t.d;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class e {
  private String a;
  
  private String b;
  
  private String c;
  
  public e(String paramString1, String paramString2, String paramString3) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  private void a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("report mediation: ");
      stringBuilder.append(paramString);
      GDTLogger.d(stringBuilder.toString());
      c c = new c(this.a, com.qq.e.comm.plugin.t.b.e.a.b, paramString.getBytes(a.a));
      ak.a("gdt_tag_net", ak.a((com.qq.e.comm.plugin.t.b.e)c));
      d.a().a((com.qq.e.comm.plugin.t.b.e)c, c.a.a);
    } 
  }
  
  public void a(c paramc) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("app_view_id", this.b);
      jSONObject.put("pos_view_id", this.c);
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("view_id", paramc.f());
      jSONObject.put("click", jSONObject1);
      a(jSONObject.toString());
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  public void a(List<c> paramList, String paramString) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(c paramc) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("app_view_id", this.b);
      jSONObject.put("pos_view_id", this.c);
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("view_id", paramc.f());
      jSONObject.put("imp", jSONObject1);
      a(jSONObject.toString());
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\r\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */