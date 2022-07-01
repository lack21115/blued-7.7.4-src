package com.bun.miitmdid.b;

import com.bun.lib.sysParamters;
import java.util.HashMap;
import java.util.Map;

public class c {
  private Map<String, String> a = new HashMap<String, String>();
  
  private Map<String, String> a() {
    if (this.a.isEmpty()) {
      this.a.put("av", sysParamters.f().a());
      this.a.put("sv", sysParamters.f().d());
      this.a.put("md", sysParamters.f().c());
      this.a.put("mf", sysParamters.f().b());
      this.a.put("pn", sysParamters.g());
    } 
    long l = System.currentTimeMillis();
    this.a.put("tm", String.valueOf(l));
    return this.a;
  }
  
  public boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  class a implements b.b {
    a(c this$0) {}
    
    public void a(Exception param1Exception, int param1Int, String param1String) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */