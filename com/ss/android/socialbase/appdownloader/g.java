package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import com.ss.android.socialbase.appdownloader.c.e;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.l;
import com.ss.android.socialbase.downloader.d.p;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.notification.a;
import java.util.List;
import org.json.JSONObject;

public class g {
  private int A = 5;
  
  private int B;
  
  private boolean C;
  
  private String D;
  
  private boolean E;
  
  private boolean F;
  
  private boolean G;
  
  private boolean H;
  
  private com.ss.android.socialbase.downloader.b.g I = com.ss.android.socialbase.downloader.b.g.a;
  
  private int J = 150;
  
  private int K;
  
  private boolean L = true;
  
  private x M;
  
  private l N;
  
  private e O;
  
  private q P;
  
  private p Q;
  
  private boolean R;
  
  private ac S;
  
  private boolean T;
  
  private JSONObject U;
  
  private Activity a;
  
  private Context b;
  
  private String c;
  
  private List<String> d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private List<e> h;
  
  private boolean i = true;
  
  private boolean j = false;
  
  private boolean k = true;
  
  private boolean l = false;
  
  private w m;
  
  private w n;
  
  private String o;
  
  private String p = "application/vnd.android.package-archive";
  
  private boolean q;
  
  private h r;
  
  private i s;
  
  private r t;
  
  private a u;
  
  private boolean v;
  
  private boolean w;
  
  private String x;
  
  private String y;
  
  private boolean z;
  
  public g(Context paramContext, String paramString) {
    this.b = paramContext.getApplicationContext();
    this.c = paramString;
  }
  
  public boolean A() {
    return this.E;
  }
  
  public boolean B() {
    return this.F;
  }
  
  public r C() {
    return this.t;
  }
  
  public int D() {
    return this.J;
  }
  
  public int E() {
    return this.K;
  }
  
  public boolean F() {
    return this.G;
  }
  
  public boolean G() {
    return this.H;
  }
  
  public boolean H() {
    return this.L;
  }
  
  public boolean I() {
    return this.R;
  }
  
  public com.ss.android.socialbase.downloader.b.g J() {
    return this.I;
  }
  
  public boolean K() {
    return this.z;
  }
  
  public String L() {
    return this.f;
  }
  
  public x M() {
    return this.M;
  }
  
  public l N() {
    return this.N;
  }
  
  public e O() {
    return this.O;
  }
  
  public q P() {
    return this.P;
  }
  
  public ac Q() {
    return this.S;
  }
  
  public boolean R() {
    return this.T;
  }
  
  public List<String> S() {
    return this.d;
  }
  
  public p T() {
    return this.Q;
  }
  
  public JSONObject U() {
    return this.U;
  }
  
  public Activity a() {
    return this.a;
  }
  
  public g a(int paramInt) {
    this.A = paramInt;
    return this;
  }
  
  public g a(com.ss.android.socialbase.downloader.b.g paramg) {
    this.I = paramg;
    return this;
  }
  
  public g a(p paramp) {
    this.Q = paramp;
    return this;
  }
  
  public g a(q paramq) {
    this.P = paramq;
    return this;
  }
  
  public g a(w paramw) {
    this.m = paramw;
    return this;
  }
  
  public g a(h paramh) {
    this.r = paramh;
    return this;
  }
  
  public g a(i parami) {
    this.s = parami;
    return this;
  }
  
  public g a(String paramString) {
    this.e = paramString;
    return this;
  }
  
  public g a(List<e> paramList) {
    this.h = paramList;
    return this;
  }
  
  public g a(JSONObject paramJSONObject) {
    this.U = paramJSONObject;
    return this;
  }
  
  public g a(boolean paramBoolean) {
    this.i = paramBoolean;
    return this;
  }
  
  public Context b() {
    return this.b;
  }
  
  public g b(int paramInt) {
    this.B = paramInt;
    return this;
  }
  
  public g b(String paramString) {
    this.f = paramString;
    return this;
  }
  
  public g b(List<String> paramList) {
    this.d = paramList;
    return this;
  }
  
  public g b(boolean paramBoolean) {
    this.j = paramBoolean;
    return this;
  }
  
  public g c(int paramInt) {
    this.J = paramInt;
    return this;
  }
  
  public g c(String paramString) {
    this.g = paramString;
    return this;
  }
  
  public g c(boolean paramBoolean) {
    this.l = paramBoolean;
    return this;
  }
  
  public String c() {
    return this.c;
  }
  
  public g d(int paramInt) {
    this.K = paramInt;
    return this;
  }
  
  public g d(String paramString) {
    this.o = paramString;
    return this;
  }
  
  public g d(boolean paramBoolean) {
    this.q = paramBoolean;
    return this;
  }
  
  public String d() {
    return this.e;
  }
  
  public g e(String paramString) {
    this.p = paramString;
    return this;
  }
  
  public g e(boolean paramBoolean) {
    this.v = paramBoolean;
    return this;
  }
  
  public String e() {
    return this.g;
  }
  
  public g f(String paramString) {
    this.x = paramString;
    return this;
  }
  
  public g f(boolean paramBoolean) {
    this.w = paramBoolean;
    return this;
  }
  
  public List<e> f() {
    return this.h;
  }
  
  public g g(String paramString) {
    this.y = paramString;
    return this;
  }
  
  public g g(boolean paramBoolean) {
    this.C = paramBoolean;
    return this;
  }
  
  public boolean g() {
    return this.i;
  }
  
  public g h(String paramString) {
    this.D = paramString;
    return this;
  }
  
  public g h(boolean paramBoolean) {
    this.R = paramBoolean;
    return this;
  }
  
  public boolean h() {
    return this.j;
  }
  
  public g i(boolean paramBoolean) {
    this.E = paramBoolean;
    return this;
  }
  
  public boolean i() {
    return this.k;
  }
  
  public g j(boolean paramBoolean) {
    this.F = paramBoolean;
    return this;
  }
  
  public boolean j() {
    return this.l;
  }
  
  public g k(boolean paramBoolean) {
    this.G = paramBoolean;
    return this;
  }
  
  public w k() {
    return this.m;
  }
  
  public g l(boolean paramBoolean) {
    this.H = paramBoolean;
    return this;
  }
  
  public w l() {
    return this.n;
  }
  
  public g m(boolean paramBoolean) {
    this.L = paramBoolean;
    return this;
  }
  
  public String m() {
    return this.o;
  }
  
  public g n(boolean paramBoolean) {
    this.z = paramBoolean;
    return this;
  }
  
  public String n() {
    return this.p;
  }
  
  public boolean o() {
    return this.q;
  }
  
  public a p() {
    return this.u;
  }
  
  public i q() {
    return this.s;
  }
  
  public h r() {
    return this.r;
  }
  
  public boolean s() {
    return this.v;
  }
  
  public boolean t() {
    return this.w;
  }
  
  public String u() {
    return this.x;
  }
  
  public String v() {
    return this.y;
  }
  
  public int w() {
    return this.A;
  }
  
  public int x() {
    return this.B;
  }
  
  public boolean y() {
    return this.C;
  }
  
  public String z() {
    return this.D;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */