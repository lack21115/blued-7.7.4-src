package com.ss.android.downloadad.a.b;

import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.downloadad.a.a.c;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a {
  public AtomicBoolean a = new AtomicBoolean(false);
  
  private long b;
  
  private long c;
  
  private String d;
  
  private int e = 1;
  
  private String f;
  
  private String g;
  
  private int h;
  
  private String i;
  
  private boolean j = true;
  
  private long k;
  
  private JSONObject l;
  
  private int m;
  
  private boolean n = false;
  
  private String o;
  
  private String p;
  
  private boolean q;
  
  private int r;
  
  private a() {}
  
  public a(c paramc, b paramb, com.ss.android.a.a.b.a parama) {
    this(paramc, paramb, parama, 0);
  }
  
  public a(c paramc, b paramb, com.ss.android.a.a.b.a parama, int paramInt) {
    this.b = paramc.d();
    this.c = paramc.e();
    this.d = paramc.s();
    this.f = paramc.t();
    this.l = paramc.w();
    this.j = paramc.r();
    this.h = paramc.p();
    this.i = paramc.q();
    this.g = paramc.a();
    this.o = paramb.b();
    this.p = paramb.a();
    this.q = paramb.m();
    this.n = parama.c();
    this.m = paramInt;
    this.k = System.currentTimeMillis();
  }
  
  public static JSONObject a(a parama) {
    return (parama != null && parama.h() != null) ? parama.h() : new JSONObject();
  }
  
  public static a b(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    a a1 = new a();
    try {
      a1.a(com.ss.android.a.a.d.a.a(paramJSONObject, "mId"));
      a1.b(com.ss.android.a.a.d.a.a(paramJSONObject, "mExtValue"));
      a1.b(paramJSONObject.optString("mLogExtra"));
      a1.a(paramJSONObject.optInt("mDownloadStatus"));
      a1.a(paramJSONObject.optString("mPackageName"));
      a1.a(paramJSONObject.optBoolean("mIsAd"));
      a1.c(com.ss.android.a.a.d.a.a(paramJSONObject, "mTimeStamp"));
      a1.b(paramJSONObject.optInt("mVersionCode"));
      a1.c(paramJSONObject.optString("mVersionName"));
      a1.c(paramJSONObject.optInt("mDownloadId"));
      a1.b(paramJSONObject.optBoolean("mIsV3Event"));
      a1.d(paramJSONObject.optInt("mScene"));
      a1.d(paramJSONObject.optString("mEventTag"));
      a1.e(paramJSONObject.optString("mEventRefer"));
      a1.f(paramJSONObject.optString("mDownloadUrl"));
      a1.c(paramJSONObject.optBoolean("mEnableBackDialog"));
      a1.a = new AtomicBoolean(paramJSONObject.optBoolean("hasSendInstallFinish"));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    try {
      a1.a(paramJSONObject.optJSONObject("mExtras"));
      return a1;
    } catch (Exception exception) {
      a1.a((JSONObject)null);
      return a1;
    } 
  }
  
  public long a() {
    return this.b;
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  public void a(long paramLong) {
    this.b = paramLong;
  }
  
  public void a(String paramString) {
    this.f = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.l = paramJSONObject;
  }
  
  public void a(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public long b() {
    return this.c;
  }
  
  public void b(int paramInt) {
    this.h = paramInt;
  }
  
  public void b(long paramLong) {
    this.c = paramLong;
  }
  
  public void b(String paramString) {
    this.d = paramString;
  }
  
  public void b(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public int c() {
    return this.e;
  }
  
  public void c(int paramInt) {
    this.m = paramInt;
  }
  
  public void c(long paramLong) {
    this.k = paramLong;
  }
  
  public void c(String paramString) {
    this.i = paramString;
  }
  
  public void c(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public String d() {
    return this.f;
  }
  
  public void d(int paramInt) {
    this.r = paramInt;
  }
  
  public void d(String paramString) {
    this.o = paramString;
  }
  
  public long e() {
    return this.k;
  }
  
  public void e(String paramString) {
    this.p = paramString;
  }
  
  public String f() {
    return this.d;
  }
  
  public void f(String paramString) {
    this.g = paramString;
  }
  
  public boolean g() {
    return this.j;
  }
  
  public JSONObject h() {
    return this.l;
  }
  
  public int i() {
    return this.h;
  }
  
  public String j() {
    return this.i;
  }
  
  public int k() {
    return this.m;
  }
  
  public boolean l() {
    return this.q;
  }
  
  public int m() {
    return this.r;
  }
  
  public boolean n() {
    return this.n;
  }
  
  public String o() {
    return this.o;
  }
  
  public String p() {
    return this.p;
  }
  
  public String q() {
    return this.g;
  }
  
  public JSONObject r() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("mId", this.b);
      jSONObject.put("mExtValue", this.c);
      jSONObject.put("mLogExtra", this.d);
      jSONObject.put("mDownloadStatus", this.e);
      jSONObject.put("mPackageName", this.f);
      jSONObject.put("mIsAd", this.j);
      jSONObject.put("mTimeStamp", this.k);
      jSONObject.put("mExtras", this.l);
      jSONObject.put("mVersionCode", this.h);
      jSONObject.put("mVersionName", this.i);
      jSONObject.put("mDownloadId", this.m);
      jSONObject.put("mIsV3Event", this.q);
      jSONObject.put("mScene", this.r);
      jSONObject.put("mEventTag", this.o);
      jSONObject.put("mEventRefer", this.p);
      jSONObject.put("mDownloadUrl", this.g);
      jSONObject.put("mEnableBackDialog", this.n);
      jSONObject.put("hasSendInstallFinish", this.a.get());
      return jSONObject;
    } catch (Exception exception) {
      exception.printStackTrace();
      return jSONObject;
    } 
  }
  
  public c s() {
    return (new c.a()).a(this.b).b(this.c).a(this.d).b(this.f).a(this.l).a(this.j).a(this.h).g(this.i).d(this.g).a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadad\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */