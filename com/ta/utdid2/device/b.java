package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.a.a.g;
import java.util.zip.Adler32;

public class b {
  private static a a;
  
  static final Object d = new Object();
  
  static long a(a parama) {
    if (parama != null) {
      String str = String.format("%s%s%s%s%s", new Object[] { parama.f(), parama.getDeviceId(), Long.valueOf(parama.a()), parama.getImsi(), parama.e() });
      if (!g.a(str)) {
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
      } 
    } 
    return 0L;
  }
  
  private static a a(Context paramContext) {
    if (paramContext != null)
      synchronized (d) {
        String str = c.a(paramContext).getValue();
        if (!g.a(str)) {
          String str2 = str;
          if (str.endsWith("\n"))
            str2 = str.substring(0, str.length() - 1); 
          a a1 = new a();
          long l = System.currentTimeMillis();
          String str3 = e.a(paramContext);
          String str1 = e.c(paramContext);
          a1.d(str3);
          a1.b(str3);
          a1.b(l);
          a1.c(str1);
          a1.e(str2);
          a1.a(a(a1));
          return a1;
        } 
      }  
    return null;
  }
  
  public static a b(Context paramContext) {
    // Byte code:
    //   0: ldc com/ta/utdid2/device/b
    //   2: monitorenter
    //   3: getstatic com/ta/utdid2/device/b.a : Lcom/ta/utdid2/device/a;
    //   6: ifnull -> 18
    //   9: getstatic com/ta/utdid2/device/b.a : Lcom/ta/utdid2/device/a;
    //   12: astore_0
    //   13: ldc com/ta/utdid2/device/b
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: ifnull -> 36
    //   22: aload_0
    //   23: invokestatic a : (Landroid/content/Context;)Lcom/ta/utdid2/device/a;
    //   26: astore_0
    //   27: aload_0
    //   28: putstatic com/ta/utdid2/device/b.a : Lcom/ta/utdid2/device/a;
    //   31: ldc com/ta/utdid2/device/b
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: ldc com/ta/utdid2/device/b
    //   38: monitorexit
    //   39: aconst_null
    //   40: areturn
    //   41: astore_0
    //   42: ldc com/ta/utdid2/device/b
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	41	finally
    //   22	31	41	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\device\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */