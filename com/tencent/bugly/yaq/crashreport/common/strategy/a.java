package com.tencent.bugly.yaq.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.yaq.proguard.ap;
import com.tencent.bugly.yaq.proguard.p;
import com.tencent.bugly.yaq.proguard.w;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.util.List;

public final class a {
  public static int a = 1000;
  
  private static a b = null;
  
  private static String h = null;
  
  private final List<com.tencent.bugly.yaq.a> c;
  
  private final w d;
  
  private final StrategyBean e;
  
  private StrategyBean f;
  
  private Context g;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private a(Context paramContext, List<com.tencent.bugly.yaq.a> paramList) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static a a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/common/strategy/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/common/strategy/a.b : Lcom/tencent/bugly/yaq/crashreport/common/strategy/a;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/yaq/crashreport/common/strategy/a
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/yaq/crashreport/common/strategy/a
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static a a(Context paramContext, List<com.tencent.bugly.yaq.a> paramList) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/common/strategy/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/common/strategy/a.b : Lcom/tencent/bugly/yaq/crashreport/common/strategy/a;
    //   6: ifnonnull -> 21
    //   9: new com/tencent/bugly/yaq/crashreport/common/strategy/a
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/util/List;)V
    //   18: putstatic com/tencent/bugly/yaq/crashreport/common/strategy/a.b : Lcom/tencent/bugly/yaq/crashreport/common/strategy/a;
    //   21: getstatic com/tencent/bugly/yaq/crashreport/common/strategy/a.b : Lcom/tencent/bugly/yaq/crashreport/common/strategy/a;
    //   24: astore_0
    //   25: ldc com/tencent/bugly/yaq/crashreport/common/strategy/a
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/bugly/yaq/crashreport/common/strategy/a
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public static void a(String paramString) {
    if (z.a(paramString) || !z.c(paramString)) {
      x.d("URL user set is invalid.", new Object[0]);
      throw new VerifyError("bad dex opcode");
    } 
    h = paramString;
    throw new VerifyError("bad dex opcode");
  }
  
  public static StrategyBean d() {
    p.a();
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(long paramLong) {
    throw new VerifyError("bad dex opcode");
  }
  
  protected final void a(StrategyBean paramStrategyBean, boolean paramBoolean) {
    Object[] arrayOfObject = new Object[1];
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(ap paramap) {
    if (paramap == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
  
  public final StrategyBean c() {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\common\strategy\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */