package com.qq.e.comm.plugin.splash;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.h;
import com.qq.e.comm.plugin.ad.q;
import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.s.f;
import com.qq.e.comm.util.GDTLogger;
import java.net.URLEncoder;

class e {
  private b a;
  
  private a b;
  
  public e(b paramb, a parama) {
    this.a = paramb;
    this.b = parama;
  }
  
  private int a(int paramInt) {
    return (paramInt == 7) ? 8 : ((paramInt == 8) ? 11 : 0);
  }
  
  private String a(int paramInt, q paramq, ViewGroup paramViewGroup, g paramg) {
    StringBuilder stringBuilder;
    try {
      paramg.b(System.currentTimeMillis());
      paramg.a().a("41");
      paramg.a().b(paramViewGroup.getWidth());
      paramg.a().a(paramViewGroup.getHeight());
      h h = paramg.a();
      if (paramq == q.a) {
        byte b1 = 2;
        h.c(b1);
        paramg.a().d(paramInt);
        return URLEncoder.encode(paramg.b(), "UTF-8");
      } 
    } catch (Exception exception) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("GetAntiSpamInfoException:");
      stringBuilder.append(exception.getMessage());
      GDTLogger.w(stringBuilder.toString());
      return null;
    } 
    boolean bool = true;
    stringBuilder.c(bool);
    paramg.a().d(paramInt);
    return URLEncoder.encode(paramg.b(), "UTF-8");
  }
  
  private void a(f paramf, String paramString, int paramInt1, boolean paramBoolean, int paramInt2) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void b(f paramf, String paramString, int paramInt1, boolean paramBoolean, int paramInt2) {
    com.qq.e.comm.plugin.c.e.a((new f.a((a)paramf, (View)this.a)).a(paramString).a(paramInt1).c(paramBoolean).b(false).e(true).a(), this.b);
  }
  
  void a(f paramf, int paramInt, q paramq, ViewGroup paramViewGroup, g paramg) {
    boolean bool = i.c(paramf.B());
    int i = i.d(paramf.B());
    paramInt = a(paramInt);
    String str = a(paramInt, paramq, paramViewGroup, paramg);
    if (com.qq.e.comm.plugin.c.e.a((a)paramf)) {
      b(paramf, str, paramInt, bool, i);
      return;
    } 
    a(paramf, str, paramInt, bool, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */