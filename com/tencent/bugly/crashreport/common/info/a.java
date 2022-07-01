package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class a {
  private static a ah;
  
  public boolean A = false;
  
  public boolean B = false;
  
  public HashMap<String, String> C = new HashMap<String, String>();
  
  public boolean D = true;
  
  public List<String> E = new ArrayList<String>();
  
  public com.tencent.bugly.crashreport.a F = null;
  
  public SharedPreferences G;
  
  private final Context H;
  
  private String I;
  
  private String J;
  
  private String K;
  
  private String L = "unknown";
  
  private String M = "unknown";
  
  private String N = "";
  
  private String O = null;
  
  private String P = null;
  
  private String Q = null;
  
  private String R = null;
  
  private long S = -1L;
  
  private long T = -1L;
  
  private long U = -1L;
  
  private String V = null;
  
  private String W = null;
  
  private Map<String, PlugInBean> X = null;
  
  private boolean Y = true;
  
  private String Z = null;
  
  public final long a = System.currentTimeMillis();
  
  private final Object aA = new Object();
  
  private final Object aB = new Object();
  
  private String aa = null;
  
  private Boolean ab = null;
  
  private String ac = null;
  
  private String ad = null;
  
  private String ae = null;
  
  private Map<String, PlugInBean> af = null;
  
  private Map<String, PlugInBean> ag = null;
  
  private int ai = -1;
  
  private int aj = -1;
  
  private Map<String, String> ak = new HashMap<String, String>();
  
  private Map<String, String> al = new HashMap<String, String>();
  
  private Map<String, String> am = new HashMap<String, String>();
  
  private boolean an = true;
  
  private Boolean ao = null;
  
  private Boolean ap = null;
  
  private String aq = null;
  
  private String ar = null;
  
  private String as = null;
  
  private String at = null;
  
  private String au = null;
  
  private final Object av = new Object();
  
  private final Object aw = new Object();
  
  private final Object ax = new Object();
  
  private final Object ay = new Object();
  
  private final Object az = new Object();
  
  public final byte b;
  
  public String c;
  
  public final String d;
  
  public boolean e = true;
  
  public String f = "3.2.3";
  
  public final String g;
  
  public final String h;
  
  public final String i;
  
  public long j;
  
  public String k = null;
  
  public String l = null;
  
  public String m = null;
  
  public String n = null;
  
  public String o = null;
  
  public List<String> p = null;
  
  public String q = "unknown";
  
  public long r = 0L;
  
  public long s = 0L;
  
  public long t = 0L;
  
  public long u = 0L;
  
  public boolean v = false;
  
  public String w = null;
  
  public String x = null;
  
  public String y = null;
  
  public String z = "";
  
  private a(Context paramContext) {
    this.H = z.a(paramContext);
    this.b = 1;
    PackageInfo packageInfo = AppInfo.b(paramContext);
    if (packageInfo != null)
      try {
        this.k = packageInfo.versionName;
        this.w = this.k;
        this.x = Integer.toString(packageInfo.versionCode);
      } finally {
        packageInfo = null;
      }  
    this.c = AppInfo.a(paramContext);
    this.d = AppInfo.a(Process.myPid());
    this.g = b.o();
    this.h = b.a();
    this.l = AppInfo.c(paramContext);
    StringBuilder stringBuilder = new StringBuilder("Android ");
    stringBuilder.append(b.b());
    stringBuilder.append(",level ");
    stringBuilder.append(b.c());
    this.i = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.h);
    stringBuilder.append(";");
    stringBuilder.append(this.i);
    stringBuilder.toString();
    Map<String, String> map = AppInfo.d(paramContext);
    if (map != null)
      try {
        this.p = AppInfo.a(map);
        String str2 = map.get("BUGLY_APPID");
        if (str2 != null) {
          this.aa = str2;
          c("APP_ID", this.aa);
        } 
        str2 = map.get("BUGLY_APP_VERSION");
        if (str2 != null)
          this.k = str2; 
        str2 = map.get("BUGLY_APP_CHANNEL");
        if (str2 != null)
          this.m = str2; 
        str2 = map.get("BUGLY_ENABLE_DEBUG");
        if (str2 != null)
          this.v = str2.equalsIgnoreCase("true"); 
        str2 = map.get("com.tencent.rdm.uuid");
        if (str2 != null)
          this.y = str2; 
        str2 = map.get("BUGLY_APP_BUILD_NO");
        if (!TextUtils.isEmpty(str2))
          Integer.parseInt(str2); 
        String str1 = map.get("BUGLY_AREA");
      } finally {
        map = null;
      }  
    try {
      if (!paramContext.getDatabasePath("bugly_db_").exists()) {
        this.B = true;
        x.c("App is first time to be installed on the device.", new Object[0]);
      } 
    } finally {
      map = null;
    } 
    x.c("com info create end", new Object[0]);
  }
  
  public static int K() {
    return b.c();
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/common/info/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/common/info/a.ah : Lcom/tencent/bugly/crashreport/common/info/a;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/bugly/crashreport/common/info/a
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/bugly/crashreport/common/info/a.ah : Lcom/tencent/bugly/crashreport/common/info/a;
    //   20: getstatic com/tencent/bugly/crashreport/common/info/a.ah : Lcom/tencent/bugly/crashreport/common/info/a;
    //   23: astore_0
    //   24: ldc com/tencent/bugly/crashreport/common/info/a
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/bugly/crashreport/common/info/a
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
    //   0: ldc com/tencent/bugly/crashreport/common/info/a
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/common/info/a.ah : Lcom/tencent/bugly/crashreport/common/info/a;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/crashreport/common/info/a
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/crashreport/common/info/a
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public final String A() {
    if (this.ae == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b.g());
      this.ae = stringBuilder.toString();
      x.a("Hardware serial number: %s", new Object[] { this.ae });
    } 
    return this.ae;
  }
  
  public final Map<String, String> B() {
    synchronized (this.ax) {
      if (this.ak.size() <= 0)
        return null; 
      return new HashMap<String, String>(this.ak);
    } 
  }
  
  public final void C() {
    synchronized (this.ax) {
      this.ak.clear();
      return;
    } 
  }
  
  public final int D() {
    synchronized (this.ax) {
      return this.ak.size();
    } 
  }
  
  public final Set<String> E() {
    synchronized (this.ax) {
      return this.ak.keySet();
    } 
  }
  
  public final Map<String, String> F() {
    synchronized (this.aB) {
      if (this.al.size() <= 0)
        return null; 
      return new HashMap<String, String>(this.al);
    } 
  }
  
  public final Map<String, String> G() {
    synchronized (this.ay) {
      if (this.am.size() <= 0)
        return null; 
      return new HashMap<String, String>(this.am);
    } 
  }
  
  public final int H() {
    synchronized (this.az) {
      return this.ai;
    } 
  }
  
  public final int I() {
    return this.aj;
  }
  
  public final Map<String, PlugInBean> J() {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/crashreport/common/info/a}} */
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/crashreport/common/info/a}} */
    return null;
  }
  
  public final String L() {
    if (this.aq == null)
      this.aq = b.q(); 
    return this.aq;
  }
  
  public final String M() {
    if (this.ar == null)
      this.ar = b.f(this.H); 
    return this.ar;
  }
  
  public final String N() {
    if (this.as == null)
      this.as = b.g(this.H); 
    return this.as;
  }
  
  public final String O() {
    Context context = this.H;
    return b.r();
  }
  
  public final String P() {
    if (this.at == null)
      this.at = b.h(this.H); 
    return this.at;
  }
  
  public final long Q() {
    Context context = this.H;
    return b.s();
  }
  
  public final boolean R() {
    if (this.ao == null) {
      this.ao = Boolean.valueOf(b.i(this.H));
      StringBuilder stringBuilder = new StringBuilder("Is it a virtual machine? ");
      stringBuilder.append(this.ao);
      x.a(stringBuilder.toString(), new Object[0]);
    } 
    return this.ao.booleanValue();
  }
  
  public final boolean S() {
    if (this.ap == null) {
      this.ap = Boolean.valueOf(b.j(this.H));
      StringBuilder stringBuilder = new StringBuilder("Does it has hook frame? ");
      stringBuilder.append(this.ap);
      x.a(stringBuilder.toString(), new Object[0]);
    } 
    return this.ap.booleanValue();
  }
  
  public final String T() {
    if (this.J == null) {
      this.J = AppInfo.g(this.H);
      StringBuilder stringBuilder = new StringBuilder("Beacon channel ");
      stringBuilder.append(this.J);
      x.a(stringBuilder.toString(), new Object[0]);
    } 
    return this.J;
  }
  
  public final void a(int paramInt) {
    synchronized (this.az) {
      int i = this.ai;
      if (i != paramInt) {
        this.ai = paramInt;
        x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ai) });
      } 
      return;
    } 
  }
  
  public final void a(String paramString) {
    this.aa = paramString;
    c("APP_ID", paramString);
  }
  
  public final void a(String paramString1, String paramString2) {
    if (paramString1 != null) {
      if (paramString2 == null)
        return; 
      synchronized (this.aw) {
        this.C.put(paramString1, paramString2);
        return;
      } 
    } 
  }
  
  public final void a(boolean paramBoolean) {
    this.an = paramBoolean;
    com.tencent.bugly.crashreport.a a1 = this.F;
    if (a1 != null)
      a1.setNativeIsAppForeground(paramBoolean); 
  }
  
  public final boolean a() {
    return this.an;
  }
  
  public final void b(int paramInt) {
    paramInt = this.aj;
    if (paramInt != 24096) {
      this.aj = 24096;
      x.a("server scene tag %d changed to tag %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.aj) });
    } 
  }
  
  public final void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield aA : Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: astore_2
    //   9: aload_1
    //   10: ifnonnull -> 17
    //   13: ldc_w '10000'
    //   16: astore_2
    //   17: new java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_2
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual toString : ()Ljava/lang/String;
    //   36: putfield L : Ljava/lang/String;
    //   39: aload_3
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_3
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   17	41	42	finally
  }
  
  public final void b(String paramString1, String paramString2) {
    if (z.a(paramString1) || z.a(paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      paramString1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      x.d("key&value should not be empty %s %s", new Object[] { paramString1, stringBuilder.toString() });
      return;
    } 
    synchronized (this.ax) {
      this.ak.put(paramString1, paramString2);
      return;
    } 
  }
  
  public final void b(boolean paramBoolean) {
    this.Y = paramBoolean;
  }
  
  public final String c() {
    return this.f;
  }
  
  public final void c(String paramString) {
    this.K = paramString;
    synchronized (this.aB) {
      this.al.put("E8", paramString);
      return;
    } 
  }
  
  public final void c(String paramString1, String paramString2) {
    if (z.a(paramString1) || z.a(paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      paramString1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      x.d("server key&value should not be empty %s %s", new Object[] { paramString1, stringBuilder.toString() });
      return;
    } 
    synchronized (this.ay) {
      this.am.put(paramString1, paramString2);
      return;
    } 
  }
  
  public final void d() {
    synchronized (this.av) {
      this.I = UUID.randomUUID().toString();
      return;
    } 
  }
  
  public final void d(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: putfield M : Ljava/lang/String;
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
  }
  
  public final String e() {
    synchronized (this.av) {
      if (this.I == null)
        synchronized (this.av) {
          this.I = UUID.randomUUID().toString();
        }  
      return this.I;
    } 
  }
  
  public final void e(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: putfield N : Ljava/lang/String;
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
  }
  
  public final String f() {
    return !z.a(null) ? null : this.aa;
  }
  
  public final String f(String paramString) {
    if (z.a(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      x.d("key should not be empty %s", new Object[] { stringBuilder.toString() });
      return null;
    } 
    synchronized (this.ax) {
      paramString = this.ak.remove(paramString);
      return paramString;
    } 
  }
  
  public final String g() {
    synchronized (this.aA) {
      return this.L;
    } 
  }
  
  public final String g(String paramString) {
    if (z.a(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      x.d("key should not be empty %s", new Object[] { stringBuilder.toString() });
      return null;
    } 
    synchronized (this.ax) {
      paramString = this.ak.get(paramString);
      return paramString;
    } 
  }
  
  public final String h() {
    String str = this.K;
    if (str != null)
      return str; 
    this.K = n();
    return this.K;
  }
  
  public final String i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield M : Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final String j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield N : Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final String k() {
    if (!this.Y)
      return ""; 
    if (this.O == null) {
      Context context = this.H;
      this.O = b.d();
    } 
    return this.O;
  }
  
  public final String l() {
    if (!this.Y)
      return ""; 
    String str = this.P;
    if (str == null || !str.contains(":")) {
      Context context = this.H;
      this.P = b.f();
    } 
    return this.P;
  }
  
  public final String m() {
    if (!this.Y)
      return ""; 
    if (this.Q == null) {
      Context context = this.H;
      this.Q = b.e();
    } 
    return this.Q;
  }
  
  public final String n() {
    if (!this.Y)
      return ""; 
    if (this.R == null)
      this.R = b.a(this.H); 
    return this.R;
  }
  
  public final long o() {
    if (this.S <= 0L)
      this.S = b.h(); 
    return this.S;
  }
  
  public final long p() {
    if (this.T <= 0L)
      this.T = b.j(); 
    return this.T;
  }
  
  public final long q() {
    if (this.U <= 0L)
      this.U = b.l(); 
    return this.U;
  }
  
  public final String r() {
    if (this.V == null)
      this.V = b.a(this.H, true); 
    return this.V;
  }
  
  public final String s() {
    if (this.W == null)
      this.W = b.e(this.H); 
    return this.W;
  }
  
  public final String t() {
    try {
      Map map = this.H.getSharedPreferences("BuglySdkInfos", 0).getAll();
      if (!map.isEmpty())
        synchronized (this.aw) {
          for (Map.Entry entry : map.entrySet()) {
            try {
              this.C.put((String)entry.getKey(), entry.getValue().toString());
            } finally {
              entry = null;
            } 
          } 
        }  
    } finally {
      Exception exception = null;
    } 
    x.c("SDK_INFO is empty", new Object[0]);
    return null;
  }
  
  public final String u() {
    if (this.au == null)
      this.au = AppInfo.e(this.H); 
    return this.au;
  }
  
  public final Map<String, PlugInBean> v() {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/crashreport/common/info/a}} */
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/crashreport/common/info/a}} */
    return null;
  }
  
  public final String w() {
    if (this.Z == null)
      this.Z = b.n(); 
    return this.Z;
  }
  
  public final Boolean x() {
    if (this.ab == null)
      this.ab = Boolean.valueOf(b.p()); 
    return this.ab;
  }
  
  public final String y() {
    if (this.ac == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b.d(this.H));
      this.ac = stringBuilder.toString();
      x.a("ROM ID: %s", new Object[] { this.ac });
    } 
    return this.ac;
  }
  
  public final String z() {
    if (this.ad == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b.b(this.H));
      this.ad = stringBuilder.toString();
      x.a("SIM serial number: %s", new Object[] { this.ad });
    } 
    return this.ad;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */