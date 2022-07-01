package com.qq.e.comm.plugin.v;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.ad.a;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.c.e;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

class c {
  private e a;
  
  private i b;
  
  private a c;
  
  public c(Context paramContext, e parame, i parami) {
    this.a = parame;
    this.b = parami;
    this.c = (a)new com.qq.e.comm.plugin.c.a.c(paramContext);
  }
  
  private int a(String paramString, int paramInt, View paramView, boolean paramBoolean) {
    d.a(paramView, i.a((a)this.a), new d.e(this.b.b, e.x, this.b.a), a(paramString, paramInt));
    return paramBoolean ? 405 : 402;
  }
  
  private d.b a(String paramString, int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString, int paramInt, View paramView) {
    paramInt = a(paramString, paramInt, paramView, false);
    this.b.c(paramInt);
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean, View paramView) {
    if (paramBoolean) {
      d.e e1 = new d.e(this.b.b, e.x, this.b.a);
      if (s.a((a)this.a, a.a().b(paramView), paramInt, paramString, e1, a(paramString, paramInt), this.a.y()))
        return; 
    } else {
      a(paramString, paramInt, paramView, true);
    } 
    this.b.a(101, new Object[0]);
  }
  
  void a(String paramString) {
    this.b.c(400);
    if (this.b.i == null) {
      View view = this.b.f.q();
    } else {
      View view = this.b.i;
    } 
    try {
      StringBuilder stringBuilder;
      paramString = (new JSONObject(paramString)).optString("clickInfo");
      int j = (new JSONObject(paramString)).optInt("click_area", 1);
      if (TextUtils.isEmpty(paramString) || this.b.f == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("RewardVideoDataController click error antiSpam: ");
        stringBuilder.append(paramString);
        stringBuilder.append("  mAdViewController: ");
        stringBuilder.append(this.b.f);
        GDTLogger.e(stringBuilder.toString());
        this.b.c(401);
        return;
      } 
      if (e.a((a)this.a)) {
        e.a((new f.a((a)this.a, (View)stringBuilder)).a(paramString).a(j).b(false).a(), this.c);
        this.b.c(402);
      } else {
        a(paramString, j, (View)stringBuilder);
      } 
      this.b.a(101, new Object[0]);
      return;
    } catch (JSONException jSONException) {
      GDTLogger.e("RewardVideoDataController click error json parse error");
      this.b.c(401);
      return;
    } 
  }
  
  void a(String paramString, boolean paramBoolean, View paramView) {
    byte b;
    this.b.c(403);
    if (paramBoolean) {
      b = 10;
    } else if (this.a.k_()) {
      b = 2;
    } else {
      b = 4;
    } 
    paramString = n.a(b, paramString, System.currentTimeMillis() - this.b.h);
    if (TextUtils.isEmpty(paramString) || this.b.f == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RewardVideoDataController click error antiSpam: ");
      stringBuilder.append(paramString);
      stringBuilder.append("  mAdViewController: ");
      stringBuilder.append(this.b.f);
      GDTLogger.e(stringBuilder.toString());
      this.b.c(404);
      return;
    } 
    if (e.a((a)this.a)) {
      if (!paramBoolean)
        if (this.b.i == null) {
          paramView = this.b.f.q();
        } else {
          paramView = this.b.i;
        }  
      e.a((new f.a((a)this.a, paramView)).a(paramString).a(b).b(false).a(), this.c);
      if (!paramBoolean) {
        this.b.a(101, new Object[0]);
        return;
      } 
    } else {
      a(paramString, b, paramBoolean, paramView);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\v\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */