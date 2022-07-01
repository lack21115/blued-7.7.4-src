package com.tencent.bugly.yaq.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import com.tencent.bugly.yaq.proguard.w;
import com.tencent.bugly.yaq.proguard.x;
import java.util.Map;

public final class d {
  private static d a = null;
  
  private a b;
  
  private a c;
  
  private b d;
  
  private Context e;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private d(Context paramContext) {
    if (c.a() == null)
      throw new VerifyError("bad dex opcode"); 
    a.a();
    throw new VerifyError("bad dex opcode");
  }
  
  public static d a(Context paramContext) {
    if (a == null)
      a = new d(paramContext); 
    return a;
  }
  
  public static void a(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap) {
    w.a();
    new Runnable(paramThread, paramInt, paramString1, paramString2, paramString3, paramMap) {
        public final void run() {
          try {
            if (d.a() == null) {
              x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
              throw new VerifyError("bad dex opcode");
            } 
            d.a();
            throw new VerifyError("bad dex opcode");
          } catch (Throwable throwable) {
            if (!x.b(throwable))
              throw new VerifyError("bad dex opcode"); 
            Object[] arrayOfObject = new Object[3];
            throw new VerifyError("bad dex opcode");
          } 
        }
      };
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */