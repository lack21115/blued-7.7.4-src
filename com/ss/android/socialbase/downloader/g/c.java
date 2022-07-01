package com.ss.android.socialbase.downloader.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.b.b;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.b.g;
import com.ss.android.socialbase.downloader.b.i;
import com.ss.android.socialbase.downloader.b.j;
import com.ss.android.socialbase.downloader.d.ae;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.m.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements Parcelable {
  public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
      public c a(Parcel param1Parcel) {
        return new c(param1Parcel);
      }
      
      public c[] a(int param1Int) {
        return new c[param1Int];
      }
    };
  
  private boolean A;
  
  private boolean B;
  
  private String C;
  
  private int D;
  
  private j E = j.a;
  
  private boolean F;
  
  private com.ss.android.socialbase.downloader.b.a G;
  
  private boolean H;
  
  private boolean I;
  
  private boolean J;
  
  private String K;
  
  private int L;
  
  private int M;
  
  private int N;
  
  private AtomicLong O;
  
  private long P;
  
  private AtomicInteger Q;
  
  private boolean R;
  
  private boolean S;
  
  private long T;
  
  private long U;
  
  private boolean V;
  
  private boolean W;
  
  private long X;
  
  private long Y;
  
  private StringBuffer Z;
  
  private int a;
  
  private Bundle aA;
  
  private int aa;
  
  private boolean ab;
  
  private boolean ac;
  
  private boolean ad;
  
  private List<String> ae;
  
  private b af;
  
  private boolean ag;
  
  private g ah;
  
  private String ai;
  
  private int aj;
  
  private String ak;
  
  private AtomicLong al;
  
  private volatile boolean am;
  
  private volatile List<ae> an;
  
  private boolean ao;
  
  private boolean ap;
  
  private boolean aq;
  
  private boolean ar;
  
  private boolean as;
  
  private boolean at;
  
  private String au;
  
  private com.ss.android.socialbase.downloader.e.a av;
  
  @Deprecated
  private int aw;
  
  private JSONObject ax;
  
  private JSONObject ay;
  
  private String az;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private boolean g;
  
  private String h;
  
  private List<e> i;
  
  private int j;
  
  private String[] k;
  
  private int[] l;
  
  private int m;
  
  private int n;
  
  private boolean o;
  
  private boolean p;
  
  private int q;
  
  private int r;
  
  private List<String> s;
  
  private boolean t;
  
  private String u;
  
  private boolean v;
  
  private String w;
  
  private String x;
  
  private boolean y;
  
  private String z;
  
  public c() {
    this.F = false;
    this.G = com.ss.android.socialbase.downloader.b.a.a;
    this.N = 1;
    this.R = true;
    this.S = true;
    this.af = b.a;
    this.ah = g.a;
    this.al = new AtomicLong(0L);
    this.ap = true;
    this.aq = true;
  }
  
  public c(Cursor paramCursor) {
    boolean bool = false;
    this.F = false;
    this.G = com.ss.android.socialbase.downloader.b.a.a;
    this.N = 1;
    this.R = true;
    this.S = true;
    this.af = b.a;
    this.ah = g.a;
    this.al = new AtomicLong(0L);
    this.ap = true;
    this.aq = true;
    if (paramCursor == null)
      return; 
    try {
      int i = paramCursor.getColumnIndex("_id");
      if (i != -1)
        this.a = paramCursor.getInt(i); 
      i = paramCursor.getColumnIndex("name");
      if (i != -1)
        this.b = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("title");
      if (i != -1)
        this.c = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("url");
      if (i != -1)
        this.d = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("savePath");
      if (i != -1)
        this.e = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("tempPath");
      if (i != -1)
        this.f = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("chunkCount");
      if (i != -1)
        this.N = paramCursor.getInt(i); 
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        this.Q = new AtomicInteger(paramCursor.getInt(i));
      } else {
        this.Q = new AtomicInteger(0);
      } 
      i = paramCursor.getColumnIndex("curBytes");
      if (i != -1) {
        this.O = new AtomicLong(paramCursor.getLong(i));
      } else {
        this.O = new AtomicLong(0L);
      } 
      i = paramCursor.getColumnIndex("totalBytes");
      if (i != -1)
        this.P = paramCursor.getLong(i); 
      i = paramCursor.getColumnIndex("eTag");
      if (i != -1)
        this.C = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("onlyWifi");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.g = bool1;
      } 
      i = paramCursor.getColumnIndex("force");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.o = bool1;
      } 
      i = paramCursor.getColumnIndex("retryCount");
      if (i != -1)
        this.m = paramCursor.getInt(i); 
      i = paramCursor.getColumnIndex("extra");
      if (i != -1)
        this.h = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("mimeType");
      if (i != -1)
        this.u = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("notificationEnable");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.t = bool1;
      } 
      i = paramCursor.getColumnIndex("notificationVisibility");
      if (i != -1)
        this.M = paramCursor.getInt(i); 
      i = paramCursor.getColumnIndex("isFirstDownload");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.R = bool1;
      } 
      i = paramCursor.getColumnIndex("isFirstSuccess");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.S = bool1;
      } 
      i = paramCursor.getColumnIndex("needHttpsToHttpRetry");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.v = bool1;
      } 
      i = paramCursor.getColumnIndex("downloadTime");
      if (i != -1)
        this.T = paramCursor.getLong(i); 
      i = paramCursor.getColumnIndex("packageName");
      if (i != -1)
        this.w = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("md5");
      if (i != -1)
        this.x = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("retryDelay");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.y = bool1;
      } 
      i = paramCursor.getColumnIndex("curRetryTime");
      if (i != -1)
        this.D = paramCursor.getInt(i); 
      i = paramCursor.getColumnIndex("retryDelayStatus");
      if (i != -1) {
        i = paramCursor.getInt(i);
        if (i == j.b.ordinal()) {
          this.E = j.b;
        } else if (i == j.c.ordinal()) {
          this.E = j.c;
        } else if (i == j.d.ordinal()) {
          this.E = j.d;
        } else {
          this.E = j.a;
        } 
      } 
      i = paramCursor.getColumnIndex("defaultHttpServiceBackUp");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.A = bool1;
      } 
      i = paramCursor.getColumnIndex("chunkRunnableReuse");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.B = bool1;
      } 
      i = paramCursor.getColumnIndex("retryDelayTimeArray");
      if (i != -1)
        this.z = paramCursor.getString(i); 
      i = paramCursor.getColumnIndex("chunkDowngradeRetry");
      if (i != -1) {
        boolean bool1;
        if (paramCursor.getInt(i) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.as = bool1;
      } 
      i = paramCursor.getColumnIndex("backUpUrlsStr");
      if (i != -1)
        i(paramCursor.getString(i)); 
      i = paramCursor.getColumnIndex("backUpUrlRetryCount");
      if (i != -1)
        this.n = paramCursor.getInt(i); 
      i = paramCursor.getColumnIndex("realDownloadTime");
      if (i != -1)
        this.U = paramCursor.getLong(i); 
      i = paramCursor.getColumnIndex("retryScheduleMinutes");
      if (i != -1)
        this.aw = paramCursor.getInt(i); 
      i = paramCursor.getColumnIndex("independentProcess");
      if (i != -1) {
        boolean bool1 = bool;
        if (paramCursor.getInt(i) == 1)
          bool1 = true; 
        this.ag = bool1;
      } 
      i = paramCursor.getColumnIndex("auxiliaryJsonobjectString");
      if (i != -1) {
        this.az = paramCursor.getString(i);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  protected c(Parcel paramParcel) {
    this.F = false;
    this.G = com.ss.android.socialbase.downloader.b.a.a;
    this.N = 1;
    this.R = true;
    this.S = true;
    this.af = b.a;
    this.ah = g.a;
    this.al = new AtomicLong(0L);
    this.ap = true;
    this.aq = true;
    a(paramParcel);
  }
  
  private c(a parama) {
    this.F = false;
    this.G = com.ss.android.socialbase.downloader.b.a.a;
    this.N = 1;
    this.R = true;
    this.S = true;
    this.af = b.a;
    this.ah = g.a;
    this.al = new AtomicLong(0L);
    this.ap = true;
    this.aq = true;
    if (parama == null)
      return; 
    this.b = a.a(parama);
    this.c = a.b(parama);
    this.d = a.c(parama);
    this.e = a.d(parama);
    this.f = a.e(parama);
    this.Q = new AtomicInteger(0);
    this.O = new AtomicLong(0L);
    this.h = a.f(parama);
    this.g = a.g(parama);
    this.i = a.h(parama);
    this.j = a.i(parama);
    this.m = a.j(parama);
    this.n = a.k(parama);
    this.o = a.l(parama);
    this.k = a.m(parama);
    this.l = a.n(parama);
    this.p = a.o(parama);
    this.q = a.p(parama);
    this.r = a.q(parama);
    this.s = a.r(parama);
    this.t = a.s(parama);
    this.u = a.t(parama);
    this.v = a.u(parama);
    this.y = a.v(parama);
    this.z = a.w(parama);
    this.ab = a.x(parama);
    this.ac = a.y(parama);
    this.A = a.z(parama);
    this.B = a.A(parama);
    this.w = a.B(parama);
    this.x = a.C(parama);
    this.F = a.D(parama);
    this.ag = a.E(parama);
    this.ah = a.F(parama);
    this.H = a.G(parama);
    this.I = a.H(parama);
    this.aq = a.I(parama);
    this.ar = a.J(parama);
    this.as = a.K(parama);
    JSONObject jSONObject = a.L(parama);
    if (jSONObject != null)
      a("download_setting", jSONObject.toString()); 
  }
  
  private void a(String paramString, Object paramObject) {
    bi();
    try {
      this.ay.put(paramString, paramObject);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    bi();
    try {
      Iterator<String> iterator = paramJSONObject.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        Object object = paramJSONObject.opt(str);
        if (this.ay.has(str) || object == null)
          continue; 
        this.ay.put(str, object);
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private String bh() {
    if (this.au == null) {
      List<String> list = this.s;
      if (list != null && !list.isEmpty())
        try {
          JSONArray jSONArray = new JSONArray();
          for (String str : this.s) {
            if (!TextUtils.isEmpty(str))
              jSONArray.put(str); 
          } 
          this.au = jSONArray.toString();
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
    } 
    if (this.au == null)
      this.au = ""; 
    return this.au;
  }
  
  private void bi() {
    if (this.ay == null)
      try {
        if (!TextUtils.isEmpty(this.az)) {
          this.ay = new JSONObject(this.az);
          return;
        } 
        this.ay = new JSONObject();
        return;
      } catch (Exception exception) {
        this.ay = new JSONObject();
      }  
  }
  
  private void bj() {
    if (this.ax == null) {
      Context context = b.B();
      if (context != null) {
        String str = context.getSharedPreferences("sp_download_info", 0).getString(Long.toString(g()), "");
        if (!TextUtils.isEmpty(str))
          try {
            this.ax = new JSONObject(str);
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
          }  
      } 
      if (this.ax == null)
        this.ax = new JSONObject(); 
    } 
  }
  
  private void bk() {
    // Byte code:
    //   0: aload_0
    //   1: getfield aA : Landroid/os/Bundle;
    //   4: ifnonnull -> 35
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield aA : Landroid/os/Bundle;
    //   13: ifnonnull -> 27
    //   16: aload_0
    //   17: new android/os/Bundle
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: putfield aA : Landroid/os/Bundle;
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    //   35: return
    // Exception table:
    //   from	to	target	type
    //   9	27	30	finally
    //   27	29	30	finally
    //   31	33	30	finally
  }
  
  private void i(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.au = paramString;
    try {
      JSONArray jSONArray = new JSONArray(paramString);
      if (jSONArray.length() > 0) {
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 0;; i++) {
          if (i < jSONArray.length()) {
            String str = jSONArray.optString(i);
            if (!TextUtils.isEmpty(str))
              arrayList.add(str); 
          } else {
            this.s = arrayList;
            return;
          } 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void m(int paramInt) {
    if (paramInt == g.b.ordinal()) {
      this.ah = g.b;
      return;
    } 
    if (paramInt == g.c.ordinal()) {
      this.ah = g.c;
      return;
    } 
    this.ah = g.a;
  }
  
  private void n(int paramInt) {
    if (paramInt == j.b.ordinal()) {
      this.E = j.b;
      return;
    } 
    if (paramInt == j.c.ordinal()) {
      this.E = j.c;
      return;
    } 
    if (paramInt == j.d.ordinal()) {
      this.E = j.d;
      return;
    } 
    this.E = j.a;
  }
  
  private void n(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String A() {
    return this.x;
  }
  
  public List<e> B() {
    return this.i;
  }
  
  public int C() {
    return this.j;
  }
  
  public int D() {
    return this.m;
  }
  
  public int E() {
    return this.n;
  }
  
  public int F() {
    int k = this.m;
    List<String> list = this.s;
    int i = k;
    if (list != null) {
      i = k;
      if (!list.isEmpty())
        i = k + this.n * this.s.size(); 
    } 
    return i;
  }
  
  public int G() {
    int k = this.D;
    int i = k;
    if (this.V) {
      k += this.m;
      int m = this.L;
      i = k;
      if (m > 0)
        i = k + m * this.n; 
    } 
    return i;
  }
  
  public List<String> H() {
    return this.ae;
  }
  
  public String I() {
    String str2 = this.d;
    if (q() == 8) {
      List<String> list = this.ae;
      if (list != null && !list.isEmpty() && !this.V)
        return this.ae.get(0); 
    } 
    if (this.V) {
      List<String> list = this.s;
      if (list != null && list.size() > 0) {
        int i = this.L;
        if (i >= 0 && i < this.s.size()) {
          String str4 = this.s.get(this.L);
          String str3 = str2;
          return !TextUtils.isEmpty(str4) ? str4 : str3;
        } 
      } 
    } 
    String str1 = str2;
    if (!TextUtils.isEmpty(this.d)) {
      str1 = str2;
      if (this.d.startsWith("https")) {
        str1 = str2;
        if (this.v) {
          str1 = str2;
          if (this.W)
            str1 = this.d.replaceFirst("https", "http"); 
        } 
      } 
    } 
    return str1;
  }
  
  public boolean J() {
    return this.V;
  }
  
  public String K() {
    if (this.V) {
      List<String> list = this.s;
      if (list != null && list.size() > 0) {
        int i = this.L;
        if (i >= 0 && i < this.s.size()) {
          String str = this.s.get(this.L);
          if (!TextUtils.isEmpty(str))
            return str; 
        } 
      } 
    } 
    return "";
  }
  
  public void L() {
    this.X = SystemClock.uptimeMillis();
    a("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
  }
  
  public String M() {
    bi();
    return this.ay.optString("download_setting");
  }
  
  public int N() {
    bi();
    return this.ay.optInt("retry_schedule_count", 0);
  }
  
  public boolean O() {
    bi();
    JSONObject jSONObject = this.ay;
    boolean bool = false;
    if (jSONObject.optInt("rw_concurrent", 0) == 1)
      bool = true; 
    return bool;
  }
  
  public void P() {
    if (this.X == 0L)
      return; 
    long l = SystemClock.uptimeMillis() - this.X;
    if (this.T < 0L)
      this.T = 0L; 
    if (l > 0L)
      this.T = l; 
  }
  
  public void Q() {
    if (this.Y == 0L)
      this.Y = System.nanoTime(); 
  }
  
  public void R() {
    this.Y = 0L;
  }
  
  public boolean S() {
    return this.F;
  }
  
  public boolean T() {
    return this.ag;
  }
  
  public boolean U() {
    return this.H;
  }
  
  public boolean V() {
    return this.I;
  }
  
  public boolean W() {
    return this.aq;
  }
  
  public boolean X() {
    return this.ar;
  }
  
  public boolean Y() {
    return this.o;
  }
  
  public long Z() {
    AtomicLong atomicLong = this.O;
    return (atomicLong != null) ? atomicLong.get() : 0L;
  }
  
  public void a(int paramInt) {
    bi();
    try {
      this.ay.put("retry_schedule_count", paramInt);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(long paramLong) {
    AtomicLong atomicLong = this.O;
    if (atomicLong != null) {
      atomicLong.set(paramLong);
      return;
    } 
    this.O = new AtomicLong(paramLong);
  }
  
  public void a(long paramLong, boolean paramBoolean) {
    if (paramBoolean) {
      a(paramLong);
      return;
    } 
    if (paramLong > Z())
      a(paramLong); 
  }
  
  public void a(SQLiteStatement paramSQLiteStatement) {
    long l1;
    String str1;
    if (paramSQLiteStatement == null)
      return; 
    this.aa = 0;
    paramSQLiteStatement.clearBindings();
    int i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.a);
    i = this.aa + 1;
    this.aa = i;
    String str3 = this.d;
    String str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.e;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.f;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.b;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.N);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, q());
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, Z());
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.P);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.C;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    boolean bool = this.g;
    long l2 = 1L;
    if (bool) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    if (this.o) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.m);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.h;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.u;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.c;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    if (this.t) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.M);
    i = this.aa + 1;
    this.aa = i;
    if (this.R) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    if (this.S) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    if (this.v) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.T);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.w;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.x;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    if (this.y) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.D);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.E.ordinal());
    i = this.aa + 1;
    this.aa = i;
    if (this.A) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    if (this.B) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    str3 = this.z;
    str2 = str3;
    if (str3 == null)
      str2 = ""; 
    paramSQLiteStatement.bindString(i, str2);
    i = this.aa + 1;
    this.aa = i;
    if (this.as) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindString(i, bh());
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.n);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.U);
    i = this.aa + 1;
    this.aa = i;
    paramSQLiteStatement.bindLong(i, this.aw);
    i = this.aa + 1;
    this.aa = i;
    if (this.ag) {
      l1 = l2;
    } else {
      l1 = 0L;
    } 
    paramSQLiteStatement.bindLong(i, l1);
    i = this.aa + 1;
    this.aa = i;
    JSONObject jSONObject = this.ay;
    if (jSONObject == null) {
      str1 = this.az;
    } else {
      str1 = str1.toString();
    } 
    paramSQLiteStatement.bindString(i, str1);
  }
  
  public void a(Parcel paramParcel) {
    boolean bool1;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    byte b1 = paramParcel.readByte();
    boolean bool2 = true;
    if (b1 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.g = bool1;
    this.h = paramParcel.readString();
    this.i = paramParcel.createTypedArrayList(e.CREATOR);
    this.j = paramParcel.readInt();
    this.k = paramParcel.createStringArray();
    this.l = paramParcel.createIntArray();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.o = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.p = bool1;
    this.q = paramParcel.readInt();
    this.r = paramParcel.readInt();
    this.s = paramParcel.createStringArrayList();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.t = bool1;
    this.u = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.v = bool1;
    this.w = paramParcel.readString();
    this.x = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.y = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.A = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.B = bool1;
    this.z = paramParcel.readString();
    this.C = paramParcel.readString();
    this.D = paramParcel.readInt();
    n(paramParcel.readInt());
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.F = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.J = bool1;
    this.K = paramParcel.readString();
    this.L = paramParcel.readInt();
    this.M = paramParcel.readInt();
    this.N = paramParcel.readInt();
    a(paramParcel.readLong());
    this.P = paramParcel.readLong();
    b(paramParcel.readInt());
    this.T = paramParcel.readLong();
    this.U = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.V = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.W = bool1;
    try {
      if (this.Z == null) {
        this.Z = new StringBuffer(paramParcel.readString());
      } else {
        this.Z.delete(0, this.Z.length()).append(paramParcel.readString());
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.ab = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.ac = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.ad = bool1;
    this.ae = paramParcel.createStringArrayList();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.ag = bool1;
    m(paramParcel.readInt());
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.H = bool1;
    this.aj = paramParcel.readInt();
    this.ak = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.am = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.ao = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.aq = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.ar = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.as = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.at = bool1;
    this.av = (com.ss.android.socialbase.downloader.e.a)paramParcel.readParcelable(com.ss.android.socialbase.downloader.e.a.class.getClassLoader());
    this.aw = paramParcel.readInt();
    this.az = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    this.ap = bool1;
  }
  
  public void a(com.ss.android.socialbase.downloader.b.a parama) {
    this.G = parama;
  }
  
  public void a(b paramb) {
    this.af = paramb;
  }
  
  public void a(j paramj) {
    this.E = paramj;
  }
  
  public void a(ae paramae) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: ldc_w 'DownloadInfo'
    //   12: ldc_w 'registerTempFileSaveCallback'
    //   15: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield an : Ljava/util/List;
    //   22: ifnonnull -> 36
    //   25: aload_0
    //   26: new java/util/ArrayList
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: putfield an : Ljava/util/List;
    //   36: aload_0
    //   37: getfield an : Ljava/util/List;
    //   40: aload_1
    //   41: invokeinterface contains : (Ljava/lang/Object;)Z
    //   46: ifne -> 91
    //   49: aload_0
    //   50: getfield an : Ljava/util/List;
    //   53: aload_1
    //   54: invokeinterface add : (Ljava/lang/Object;)Z
    //   59: pop
    //   60: goto -> 91
    //   63: astore_2
    //   64: aload_2
    //   65: invokevirtual printStackTrace : ()V
    //   68: aload_1
    //   69: new com/ss/android/socialbase/downloader/e/a
    //   72: dup
    //   73: sipush #1038
    //   76: aload_2
    //   77: ldc_w 'registerTempFileSaveCallback'
    //   80: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;)Ljava/lang/String;
    //   83: invokespecial <init> : (ILjava/lang/String;)V
    //   86: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Exception table:
    //   from	to	target	type
    //   9	36	63	finally
    //   36	60	63	finally
    //   64	91	94	finally
  }
  
  public void a(com.ss.android.socialbase.downloader.e.a parama) {
    this.av = parama;
  }
  
  public void a(c paramc, boolean paramBoolean) {
    if (paramc == null)
      return; 
    c(paramc.aV());
    c(paramc.ab());
    a(paramc.Z(), true);
    this.U = paramc.U;
    if (!paramc.as() && !as()) {
      this.D = 0;
      this.ao = false;
      this.V = false;
      this.L = 0;
      this.W = false;
    } else {
      this.D = paramc.al();
    } 
    b(paramc.ac());
    if (paramBoolean)
      b(paramc.q()); 
    this.R = paramc.ay();
    this.S = paramc.az();
    this.E = paramc.aq();
    a(paramc.ay);
  }
  
  public void a(String paramString) {
    this.ai = paramString;
  }
  
  public void a(List<String> paramList, boolean paramBoolean) {
    this.ae = paramList;
    n(paramBoolean);
  }
  
  public void a(boolean paramBoolean) {
    this.ab = paramBoolean;
  }
  
  public void a(boolean paramBoolean, com.ss.android.socialbase.downloader.e.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield am : Z
    //   7: aload_0
    //   8: getfield an : Ljava/util/List;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore_3
    //   27: aload_3
    //   28: ldc_w 'handleTempSaveCallback isSuccess '
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: iload_1
    //   37: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: ldc_w ' callback size:'
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: aload_0
    //   51: getfield an : Ljava/util/List;
    //   54: invokeinterface size : ()I
    //   59: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc_w 'DownloadInfo'
    //   66: aload_3
    //   67: invokevirtual toString : ()Ljava/lang/String;
    //   70: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield an : Ljava/util/List;
    //   77: invokeinterface iterator : ()Ljava/util/Iterator;
    //   82: astore_3
    //   83: aload_3
    //   84: invokeinterface hasNext : ()Z
    //   89: ifeq -> 133
    //   92: aload_3
    //   93: invokeinterface next : ()Ljava/lang/Object;
    //   98: checkcast com/ss/android/socialbase/downloader/d/ae
    //   101: astore #4
    //   103: aload #4
    //   105: ifnull -> 83
    //   108: iload_1
    //   109: ifeq -> 122
    //   112: aload #4
    //   114: invokeinterface a : ()V
    //   119: goto -> 83
    //   122: aload #4
    //   124: aload_2
    //   125: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   130: goto -> 83
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_2
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	136	finally
    //   19	83	136	finally
    //   83	103	136	finally
    //   112	119	136	finally
    //   122	130	136	finally
  }
  
  public boolean a() {
    long l = this.al.get();
    return (l == 0L || SystemClock.uptimeMillis() - l > 20L);
  }
  
  public boolean a(c paramc) {
    boolean bool2 = false;
    if (paramc == null)
      return false; 
    String str = this.d;
    boolean bool1 = bool2;
    if (str != null) {
      bool1 = bool2;
      if (str.equals(paramc.j())) {
        str = this.e;
        bool1 = bool2;
        if (str != null) {
          bool1 = bool2;
          if (str.equals(paramc.k()))
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  public boolean aA() {
    return (!x() || f.a(b.B()));
  }
  
  public boolean aB() {
    return f.a(q());
  }
  
  public List<String> aC() {
    return this.s;
  }
  
  public boolean aD() {
    return f.b(this.P);
  }
  
  public boolean aE() {
    return this.p;
  }
  
  public int aF() {
    return this.q;
  }
  
  public int aG() {
    int k = this.r;
    int i = k;
    if (k < 1000)
      i = 1000; 
    return i;
  }
  
  public boolean aH() {
    return (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.e));
  }
  
  public boolean aI() {
    return f.c(this);
  }
  
  public boolean aJ() {
    if (this.V)
      this.L++; 
    List<String> list = this.s;
    if (list != null && list.size() != 0) {
      if (this.L < 0)
        return false; 
      while (this.L < this.s.size()) {
        if (!TextUtils.isEmpty(this.s.get(this.L))) {
          this.V = true;
          return true;
        } 
        this.L++;
      } 
    } 
    return false;
  }
  
  public boolean aK() {
    List<String> list = this.s;
    null = true;
    if (list != null && list.size() > 0)
      if (this.V) {
        int i = this.L;
        if (i >= 0 && i < this.s.size() - 1)
          return true; 
      } else {
        return null;
      }  
    return false;
  }
  
  public boolean aL() {
    return (!TextUtils.isEmpty(this.d) && this.d.startsWith("https") && this.v && !this.W);
  }
  
  public void aM() {
    a(0L, true);
    this.P = 0L;
    this.N = 1;
    this.T = 0L;
    this.Y = 0L;
    this.U = 0L;
  }
  
  public boolean aN() {
    if (aH())
      return false; 
    File file = new File(l(), m());
    boolean bool1 = file.exists();
    boolean bool2 = file.isDirectory();
    if (bool1) {
      if (bool2)
        return false; 
      long l1 = file.length();
      long l2 = Z();
      if (l1 > 0L && l2 > 0L) {
        long l = this.P;
        if (l > 0L && this.N > 0 && l1 >= l2 && l1 <= l)
          return !(l2 >= l); 
      } 
    } 
    return false;
  }
  
  public boolean aO() {
    if (this.N > 1) {
      k k = b.p();
      if (k != null) {
        List list = k.c(g());
        if (list == null || list.size() != this.N)
          return false; 
        long l = 0L;
        for (b b1 : list) {
          if (b1 != null)
            l += b1.o(); 
        } 
        if (l != Z()) {
          a(l);
          return true;
        } 
      } 
    } 
    return true;
  }
  
  public boolean aP() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield am : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public boolean aQ() {
    return !aN() ? false : aO();
  }
  
  public boolean aR() {
    return !this.R ? false : (!TextUtils.isEmpty(l()) ? (TextUtils.isEmpty(m()) ? false : ((new File(l(), m())).exists() ^ true)) : false);
  }
  
  public i aS() {
    return f.a(k(), h(), this.x);
  }
  
  public boolean aT() {
    int i = q();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 4) {
      bool1 = bool2;
      if (i != 3) {
        bool1 = bool2;
        if (i != -1) {
          bool1 = bool2;
          if (i != 5) {
            bool1 = bool2;
            if (i != 8) {
              if ((i == 1 || i == 2) && Z() > 0L)
                return true; 
              bool1 = false;
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public boolean aU() {
    return (q() == 0);
  }
  
  public int aV() {
    return this.N;
  }
  
  public com.ss.android.socialbase.downloader.e.a aW() {
    return this.av;
  }
  
  public void aX() {
    if (this.ax == null)
      return; 
    Context context = b.B();
    if (context != null)
      context.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(g()), this.ax.toString()).apply(); 
  }
  
  public void aY() {
    Context context = b.B();
    if (context != null)
      try {
        return;
      } finally {
        context = null;
      }  
  }
  
  public int aZ() {
    bj();
    return this.ax.optInt("failed_resume_count", 0);
  }
  
  public b aa() {
    return this.af;
  }
  
  public long ab() {
    return this.P;
  }
  
  public String ac() {
    return this.C;
  }
  
  public String ad() {
    return this.K;
  }
  
  public int ae() {
    return this.M;
  }
  
  public boolean af() {
    return ((!this.ab && this.t) || (this.ab && (this.ac || this.ad)));
  }
  
  public boolean ag() {
    return this.t;
  }
  
  public String ah() {
    return this.u;
  }
  
  public boolean ai() {
    return this.v;
  }
  
  public boolean aj() {
    return this.y;
  }
  
  public String ak() {
    return this.z;
  }
  
  public int al() {
    return this.D;
  }
  
  public boolean am() {
    return this.ao;
  }
  
  public void an() {
    this.ao = true;
  }
  
  public boolean ao() {
    return this.as;
  }
  
  public boolean ap() {
    return this.at;
  }
  
  public j aq() {
    return this.E;
  }
  
  public com.ss.android.socialbase.downloader.b.a ar() {
    return this.G;
  }
  
  public boolean as() {
    int i = q();
    return (i == 7 || this.E == j.b || i == 8 || this.G == com.ss.android.socialbase.downloader.b.a.b || this.G == com.ss.android.socialbase.downloader.b.a.c || this.af == b.b);
  }
  
  public void at() {
    int i = q();
    if (i == 7 || this.E == j.b)
      a(j.c); 
    if (i == 8 || this.G == com.ss.android.socialbase.downloader.b.a.b || this.G == com.ss.android.socialbase.downloader.b.a.c)
      a(com.ss.android.socialbase.downloader.b.a.d); 
    if (this.af == b.b)
      a(b.c); 
  }
  
  public boolean au() {
    return (this.y && q() != -3 && this.E == j.b);
  }
  
  public boolean av() {
    return (q() != -3 && this.G == com.ss.android.socialbase.downloader.b.a.b);
  }
  
  public long aw() {
    return this.T;
  }
  
  public long ax() {
    return TimeUnit.NANOSECONDS.toMillis(this.U);
  }
  
  public boolean ay() {
    return this.R;
  }
  
  public boolean az() {
    return this.S;
  }
  
  public void b() {
    this.al.set(SystemClock.uptimeMillis());
  }
  
  public void b(int paramInt) {
    AtomicInteger atomicInteger = this.Q;
    if (atomicInteger != null) {
      atomicInteger.set(paramInt);
      return;
    } 
    this.Q = new AtomicInteger(paramInt);
  }
  
  public void b(long paramLong) {
    this.O.addAndGet(paramLong);
  }
  
  public void b(String paramString) {
    this.C = paramString;
  }
  
  public void b(boolean paramBoolean) {
    this.ad = paramBoolean;
  }
  
  public long ba() {
    bj();
    return this.ax.optLong("last_failed_resume_time", 0L);
  }
  
  public int bb() {
    bj();
    return this.ax.optInt("uninstall_resume_count", 0);
  }
  
  public long bc() {
    bj();
    return this.ax.optLong("last_uninstall_resume_time", 0L);
  }
  
  public long bd() {
    bi();
    return this.ay.optLong("dbjson_last_start_download_time", 0L);
  }
  
  public boolean be() {
    bi();
    return this.ay.optBoolean("is_save_path_redirected", false);
  }
  
  public int bf() {
    bi();
    return this.ay.optInt("dbjson_key_preconnect_level", 0);
  }
  
  public Bundle bg() {
    bk();
    return this.aA;
  }
  
  public String c() {
    return this.ai;
  }
  
  public void c(int paramInt) {
    this.N = paramInt;
  }
  
  public void c(long paramLong) {
    this.P = paramLong;
  }
  
  public void c(String paramString) {
    this.b = paramString;
  }
  
  public void c(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public long d(long paramLong) {
    int k = this.q;
    int i = k;
    if (k <= 0)
      i = 100; 
    long l = paramLong / (i + 1);
    paramLong = l;
    if (l <= 0L)
      paramLong = 1048576L; 
    return paramLong;
  }
  
  public String d() {
    StringBuffer stringBuffer = this.Z;
    return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.Z.toString();
  }
  
  public void d(int paramInt) {
    this.M = paramInt;
  }
  
  public void d(String paramString) {
    this.w = paramString;
  }
  
  public void d(boolean paramBoolean) {
    bi();
    try {
      boolean bool;
      JSONObject jSONObject = this.ay;
      if (paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.put("rw_concurrent", bool);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public int describeContents() {
    return 0;
  }
  
  public ContentValues e() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void e(int paramInt) {
    this.aj = paramInt;
  }
  
  public void e(long paramLong) {
    bj();
    try {
      this.ax.put("last_failed_resume_time", paramLong);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void e(String paramString) {
    this.K = paramString;
  }
  
  public void e(boolean paramBoolean) {
    long l1 = System.nanoTime();
    long l2 = this.Y;
    if (l2 <= 0L) {
      if (paramBoolean)
        this.Y = l1; 
      return;
    } 
    l2 = l1 - l2;
    if (paramBoolean) {
      this.Y = l1;
    } else {
      this.Y = 0L;
    } 
    if (l2 > 0L)
      this.U += l2; 
  }
  
  public int f() {
    return this.aa;
  }
  
  public void f(int paramInt) {
    int i;
    if (this.V) {
      i = this.n;
    } else {
      i = this.m;
    } 
    this.D = i - paramInt;
    if (this.D < 0)
      this.D = 0; 
  }
  
  public void f(long paramLong) {
    bj();
    try {
      this.ax.put("last_uninstall_resume_time", paramLong);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void f(String paramString) {
    this.ak = paramString;
  }
  
  public void f(boolean paramBoolean) {
    this.R = paramBoolean;
  }
  
  public int g() {
    if (this.a == 0)
      this.a = b.a(this); 
    return this.a;
  }
  
  public void g(int paramInt) {
    this.a = paramInt;
  }
  
  public void g(String paramString) {
    this.u = paramString;
  }
  
  public void g(boolean paramBoolean) {
    this.S = paramBoolean;
  }
  
  public String h() {
    return this.b;
  }
  
  public void h(int paramInt) {
    bj();
    try {
      this.ax.put("failed_resume_count", paramInt);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void h(String paramString) {
    a(0L, true);
    c(0L);
    b(paramString);
    c(1);
    this.T = 0L;
    this.Y = 0L;
    this.U = 0L;
  }
  
  public void h(boolean paramBoolean) {
    this.ap = paramBoolean;
  }
  
  public String i() {
    return TextUtils.isEmpty(this.c) ? this.b : this.c;
  }
  
  public void i(int paramInt) {
    bj();
    try {
      this.ax.put("uninstall_resume_count", paramInt);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void i(boolean paramBoolean) {
    this.J = paramBoolean;
  }
  
  public int j(int paramInt) {
    bi();
    return this.ay.optInt("anti_hijack_error_code", paramInt);
  }
  
  public String j() {
    return this.d;
  }
  
  public void j(boolean paramBoolean) {
    this.W = paramBoolean;
  }
  
  public String k() {
    return this.e;
  }
  
  public void k(int paramInt) {
    bi();
    try {
      this.ay.put("anti_hijack_error_code", paramInt);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void k(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield am : Z
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public String l() {
    return f.b(this.e, this.f);
  }
  
  public void l(int paramInt) {
    bi();
    a("dbjson_key_preconnect_level", Integer.valueOf(paramInt));
  }
  
  public void l(boolean paramBoolean) {
    this.at = paramBoolean;
  }
  
  public String m() {
    return f.b(this.b);
  }
  
  public void m(boolean paramBoolean) {
    bi();
    try {
      this.ay.put("is_save_path_redirected", paramBoolean);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public String n() {
    return f.a(this.e, this.b);
  }
  
  public boolean o() {
    return this.A;
  }
  
  public boolean p() {
    return this.B;
  }
  
  public int q() {
    AtomicInteger atomicInteger = this.Q;
    if (atomicInteger != null) {
      int k = atomicInteger.get();
      int i = k;
      if (k == -5)
        i = -2; 
      return i;
    } 
    return 0;
  }
  
  public g r() {
    return this.ah;
  }
  
  public int s() {
    return this.L;
  }
  
  public boolean t() {
    return this.W;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DownloadInfo{id=");
    stringBuilder.append(this.a);
    stringBuilder.append(", name='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", title='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", url='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", savePath='");
    stringBuilder.append(this.e);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public boolean u() {
    return this.ab;
  }
  
  public boolean v() {
    return this.ad;
  }
  
  public int w() {
    AtomicInteger atomicInteger = this.Q;
    return (atomicInteger != null) ? atomicInteger.get() : 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    String str2;
    String str1;
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeTypedList(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeStringArray(this.k);
    paramParcel.writeIntArray(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeByte((byte)this.o);
    paramParcel.writeByte((byte)this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.r);
    paramParcel.writeStringList(this.s);
    paramParcel.writeByte((byte)this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeByte((byte)this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeString(this.x);
    paramParcel.writeByte((byte)this.y);
    paramParcel.writeByte((byte)this.A);
    paramParcel.writeByte((byte)this.B);
    paramParcel.writeString(this.z);
    paramParcel.writeString(this.C);
    paramParcel.writeInt(this.D);
    paramParcel.writeInt(this.E.ordinal());
    paramParcel.writeByte((byte)this.F);
    paramParcel.writeByte((byte)this.J);
    paramParcel.writeString(this.K);
    paramParcel.writeInt(this.L);
    paramParcel.writeInt(this.M);
    paramParcel.writeInt(this.N);
    paramParcel.writeLong(Z());
    paramParcel.writeLong(this.P);
    paramParcel.writeInt(w());
    paramParcel.writeLong(this.T);
    paramParcel.writeLong(this.U);
    paramParcel.writeByte((byte)this.V);
    paramParcel.writeByte((byte)this.W);
    StringBuffer stringBuffer = this.Z;
    if (stringBuffer != null) {
      str2 = stringBuffer.toString();
    } else {
      str2 = "";
    } 
    paramParcel.writeString(str2);
    paramParcel.writeByte((byte)this.ab);
    paramParcel.writeByte((byte)this.ac);
    paramParcel.writeByte((byte)this.ad);
    paramParcel.writeStringList(this.ae);
    paramParcel.writeByte((byte)this.ag);
    paramParcel.writeInt(this.ah.ordinal());
    paramParcel.writeByte((byte)this.H);
    paramParcel.writeInt(this.aj);
    paramParcel.writeString(this.ak);
    paramParcel.writeByte((byte)this.am);
    paramParcel.writeByte((byte)this.ao);
    paramParcel.writeByte((byte)this.aq);
    paramParcel.writeByte((byte)this.ar);
    paramParcel.writeByte((byte)this.as);
    paramParcel.writeByte((byte)this.at);
    paramParcel.writeParcelable((Parcelable)this.av, paramInt);
    paramParcel.writeInt(this.aw);
    JSONObject jSONObject = this.ay;
    if (jSONObject == null) {
      str1 = this.az;
    } else {
      str1 = str1.toString();
    } 
    paramParcel.writeString(str1);
    paramParcel.writeByte((byte)this.ap);
  }
  
  public boolean x() {
    return this.g;
  }
  
  public String y() {
    return this.h;
  }
  
  public String z() {
    return this.w;
  }
  
  public static class a {
    private String A;
    
    private boolean B;
    
    private String C;
    
    private boolean D;
    
    private boolean E;
    
    private g F = g.a;
    
    private boolean G;
    
    private boolean H;
    
    private boolean I;
    
    private boolean J = true;
    
    private boolean K;
    
    private JSONObject L;
    
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    private boolean f;
    
    private String g;
    
    private List<e> h;
    
    private int i;
    
    private String[] j;
    
    private int[] k;
    
    private int l;
    
    private int m;
    
    private boolean n;
    
    private boolean o = true;
    
    private int p;
    
    private int q;
    
    private List<String> r;
    
    private boolean s;
    
    private String t;
    
    private boolean u;
    
    private boolean v;
    
    private boolean w;
    
    private boolean x;
    
    private boolean y;
    
    private String z;
    
    public a() {}
    
    public a(String param1String) {
      this.c = param1String;
    }
    
    public a a(int param1Int) {
      this.l = param1Int;
      return this;
    }
    
    public a a(g param1g) {
      this.F = param1g;
      return this;
    }
    
    public a a(String param1String) {
      this.a = param1String;
      return this;
    }
    
    public a a(List<e> param1List) {
      this.h = param1List;
      return this;
    }
    
    public a a(JSONObject param1JSONObject) {
      this.L = param1JSONObject;
      return this;
    }
    
    public a a(boolean param1Boolean) {
      this.f = param1Boolean;
      return this;
    }
    
    public c a() {
      return new c(this);
    }
    
    public a b(int param1Int) {
      this.m = param1Int;
      return this;
    }
    
    public a b(String param1String) {
      this.b = param1String;
      return this;
    }
    
    public a b(List<String> param1List) {
      this.r = param1List;
      return this;
    }
    
    public a b(boolean param1Boolean) {
      this.n = param1Boolean;
      return this;
    }
    
    public a c(int param1Int) {
      this.p = param1Int;
      return this;
    }
    
    public a c(String param1String) {
      this.c = param1String;
      return this;
    }
    
    public a c(boolean param1Boolean) {
      this.u = param1Boolean;
      return this;
    }
    
    public a d(int param1Int) {
      this.q = param1Int;
      return this;
    }
    
    public a d(String param1String) {
      this.d = param1String;
      return this;
    }
    
    public a d(boolean param1Boolean) {
      this.s = param1Boolean;
      return this;
    }
    
    public a e(String param1String) {
      this.g = param1String;
      return this;
    }
    
    public a e(boolean param1Boolean) {
      this.v = param1Boolean;
      return this;
    }
    
    public a f(String param1String) {
      this.t = param1String;
      return this;
    }
    
    public a f(boolean param1Boolean) {
      this.w = param1Boolean;
      return this;
    }
    
    public a g(String param1String) {
      this.z = param1String;
      return this;
    }
    
    public a g(boolean param1Boolean) {
      this.x = param1Boolean;
      return this;
    }
    
    public a h(String param1String) {
      this.A = param1String;
      return this;
    }
    
    public a h(boolean param1Boolean) {
      this.y = param1Boolean;
      return this;
    }
    
    public a i(String param1String) {
      this.C = param1String;
      return this;
    }
    
    public a i(boolean param1Boolean) {
      this.B = param1Boolean;
      return this;
    }
    
    public a j(boolean param1Boolean) {
      this.D = param1Boolean;
      return this;
    }
    
    public a k(boolean param1Boolean) {
      this.E = param1Boolean;
      return this;
    }
    
    public a l(boolean param1Boolean) {
      this.G = param1Boolean;
      return this;
    }
    
    public a m(boolean param1Boolean) {
      this.I = param1Boolean;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */