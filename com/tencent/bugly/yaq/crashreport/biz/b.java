package com.tencent.bugly.yaq.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.yaq.BuglyStrategy;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import com.tencent.bugly.yaq.proguard.w;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;

public class b {
  public static a a;
  
  private static boolean b;
  
  private static int c = 10;
  
  private static long d = 300000L;
  
  private static long e = 30000L;
  
  private static long f = 0L;
  
  private static int g;
  
  private static long h;
  
  private static long i;
  
  private static long j = 0L;
  
  private static Application.ActivityLifecycleCallbacks k = null;
  
  private static Class<?> l = null;
  
  private static boolean m = true;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public b() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a() {
    if (a != null) {
      a a1 = a;
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(long paramLong) {
    if (paramLong < 0L) {
      a.a();
      throw new VerifyError("bad dex opcode");
    } 
    f = paramLong;
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(Context paramContext) {
    if (b && paramContext != null) {
      if (Build.VERSION.SDK_INT >= 14)
        throw new VerifyError("bad dex opcode"); 
      b = false;
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    if (b)
      throw new VerifyError("bad dex opcode"); 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(StrategyBean paramStrategyBean, boolean paramBoolean) {
    if (a != null && !paramBoolean) {
      a a1 = a;
      if (w.a() != null) {
        new Object(a1);
        throw new VerifyError("bad dex opcode");
      } 
    } 
    if (paramStrategyBean == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  private static void c(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    if (paramBuglyStrategy != null)
      throw new VerifyError("bad dex opcode"); 
    if (false) {
      a.a(paramContext);
      throw new VerifyError("bad dex opcode");
    } 
    if (a.b() != null) {
      Thread.currentThread();
      throw new VerifyError("bad dex opcode");
    } 
    if (true && Build.VERSION.SDK_INT >= 14)
      throw new VerifyError("bad dex opcode"); 
    if (m) {
      i = System.currentTimeMillis();
      a a1 = a;
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\biz\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */