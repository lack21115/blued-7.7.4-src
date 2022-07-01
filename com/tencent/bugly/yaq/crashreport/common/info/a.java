package com.tencent.bugly.yaq.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {
  private static a af = null;
  
  public HashMap<String, String> A;
  
  public boolean B;
  
  public List<String> C;
  
  public com.tencent.bugly.yaq.crashreport.a D;
  
  public SharedPreferences E;
  
  private final Context F;
  
  private String G;
  
  private String H;
  
  private String I;
  
  private String J;
  
  private String K;
  
  private String L;
  
  private String M;
  
  private String N;
  
  private String O;
  
  private String P;
  
  private long Q;
  
  private long R;
  
  private long S;
  
  private String T;
  
  private String U;
  
  private Map<String, PlugInBean> V;
  
  private boolean W;
  
  private String X;
  
  private String Y;
  
  private Boolean Z;
  
  public final long a;
  
  private String aa;
  
  private String ab;
  
  private String ac;
  
  private Map<String, PlugInBean> ad;
  
  private Map<String, PlugInBean> ae;
  
  private int ag;
  
  private int ah;
  
  private Map<String, String> ai;
  
  private Map<String, String> aj;
  
  private Map<String, String> ak;
  
  private boolean al;
  
  private Boolean am;
  
  private Boolean an;
  
  private String ao;
  
  private String ap;
  
  private String aq;
  
  private String ar;
  
  private String as;
  
  private final Object at;
  
  private final Object au;
  
  private final Object av;
  
  private final Object aw;
  
  private final Object ax;
  
  private final Object ay;
  
  private final Object az;
  
  public final byte b;
  
  public String c;
  
  public final String d;
  
  public boolean e;
  
  public final String f;
  
  public final String g;
  
  public final String h;
  
  public long i;
  
  public String j;
  
  public String k;
  
  public String l;
  
  public String m;
  
  public String n;
  
  public List<String> o;
  
  public String p;
  
  public long q;
  
  public long r;
  
  public long s;
  
  public long t;
  
  public boolean u;
  
  public String v;
  
  public String w;
  
  public String x;
  
  public boolean y;
  
  public boolean z;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private a(Context paramContext) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int K() {
    return b.c();
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/common/info/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/common/info/a.af : Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/bugly/yaq/crashreport/common/info/a
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/bugly/yaq/crashreport/common/info/a.af : Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   20: getstatic com/tencent/bugly/yaq/crashreport/common/info/a.af : Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   23: astore_0
    //   24: ldc com/tencent/bugly/yaq/crashreport/common/info/a
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/bugly/yaq/crashreport/common/info/a
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  public static a b() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/crashreport/common/info/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/crashreport/common/info/a.af : Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/yaq/crashreport/common/info/a
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/yaq/crashreport/common/info/a
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static String c() {
    return "2.8.8";
  }
  
  public final String A() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final Map<String, String> B() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void C() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final int D() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final Set<String> E() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final Map<String, String> F() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final Map<String, String> G() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final int H() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final int I() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final Map<String, PlugInBean> J() {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/yaq/crashreport/common/info/a}} */
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/yaq/crashreport/common/info/a}} */
    return null;
  }
  
  public final String L() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String M() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String N() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String O() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String P() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final long Q() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean R() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean S() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String T() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(boolean paramBoolean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b(String paramString1, String paramString2) {
    if (z.a(paramString1) || z.a(paramString2)) {
      Object[] arrayOfObject = new Object[2];
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b(boolean paramBoolean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void c(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void c(String paramString1, String paramString2) {
    if (z.a(paramString1) || z.a(paramString2)) {
      Object[] arrayOfObject = new Object[2];
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void d() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void d(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: pop
    //   10: new java/lang/VerifyError
    //   13: dup
    //   14: ldc 'bad dex opcode'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: athrow
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	20	finally
  }
  
  public final String e() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void e(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: pop
    //   10: new java/lang/VerifyError
    //   13: dup
    //   14: ldc 'bad dex opcode'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: athrow
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	20	finally
  }
  
  public final String f() {
    if (!z.a(null))
      return null; 
    throw new VerifyError("bad dex opcode");
  }
  
  public final String f(String paramString) {
    if (z.a(paramString)) {
      Object[] arrayOfObject = new Object[1];
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final String g() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String g(String paramString) {
    if (z.a(paramString)) {
      Object[] arrayOfObject = new Object[1];
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final String h() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String i() {
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
  
  public final String j() {
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
  
  public final String k() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String l() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String m() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String n() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final long o() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final long p() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final long q() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String r() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String s() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String t() {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.a(throwable);
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public final String u() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final Map<String, PlugInBean> v() {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/yaq/crashreport/common/info/a}} */
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/yaq/crashreport/common/info/a}} */
    return null;
  }
  
  public final String w() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final Boolean x() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String y() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String z() {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\common\info\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */