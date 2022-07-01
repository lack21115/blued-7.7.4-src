package com.qq.e.comm.plugin.rewardvideo;

import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.a;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.c.a.c;
import com.qq.e.comm.plugin.c.e;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.i;

class f {
  private c a;
  
  public f(c paramc) {
    this.a = paramc;
  }
  
  private void a(d paramd, String paramString, View paramView, int paramInt, boolean paramBoolean) {
    boolean bool;
    int i = GDTADManager.getInstance().getSM().getIntegerForPlacement("download_confirm", paramd.B(), 0);
    if (paramBoolean && !b.g(paramd.E())) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    d.a a = i.a(paramd);
    d.e e = new d.e(paramd.D(), e.k, paramd.B());
    if (bb.b(b.e(a.a))) {
      bool = true;
    } else {
      bool = true;
    } 
    d.b b = (new d.b(paramInt, d.c.a)).a(bool).a(paramString).b(i).c(5).a(true);
    b.i = a.a().b(paramView);
    b.k = false;
    d.a(paramView, a, e, b);
  }
  
  private void b(d paramd, int paramInt, View paramView, String paramString) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(d paramd, int paramInt, View paramView, String paramString) {
    if (e.a(paramd)) {
      e.a((new com.qq.e.comm.plugin.c.f.a(paramd, paramView)).a(paramString).a(paramInt).d(s.a(paramInt)).b(false).e(true).a(), (a)this.a);
      return;
    } 
    b(paramd, paramInt, paramView, paramString);
  }
  
  void a(d paramd, String paramString, View paramView) {
    boolean bool = d.a(paramd);
    if (e.a(paramd)) {
      e.a((new com.qq.e.comm.plugin.c.f.a(paramd, paramView)).a(paramString).a(5).b(false).e(true).a(), (a)this.a);
      return;
    } 
    a(paramd, paramString, paramView, 5, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */