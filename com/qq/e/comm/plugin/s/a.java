package com.qq.e.comm.plugin.s;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.ad.k;
import com.qq.e.comm.plugin.ad.s;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.as;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class a {
  protected boolean A;
  
  protected String B;
  
  protected int C = -1;
  
  protected int D = -1;
  
  protected int E;
  
  protected i F;
  
  protected e G;
  
  public JSONObject H;
  
  protected c I;
  
  private String J;
  
  private int K;
  
  private String L;
  
  private int M;
  
  private int N;
  
  private List<g> O;
  
  private List<g> P;
  
  private List<String> Q;
  
  private List<String> R;
  
  private boolean S;
  
  private k T;
  
  private String U;
  
  private String V;
  
  private int W;
  
  private String X;
  
  private s Y;
  
  private boolean Z;
  
  protected String a;
  
  private String aa;
  
  private e ab;
  
  protected String b;
  
  protected String c;
  
  protected String d;
  
  protected String e;
  
  protected String f;
  
  protected String g;
  
  protected String h;
  
  protected String i;
  
  protected int j;
  
  protected String k;
  
  protected String l;
  
  protected String m;
  
  protected boolean n;
  
  protected boolean o;
  
  protected String p;
  
  protected j q;
  
  protected String r;
  
  protected int s;
  
  protected String t;
  
  protected float u;
  
  protected float v;
  
  protected float w;
  
  protected float x;
  
  protected String y;
  
  protected String z;
  
  public a() {}
  
  public a(String paramString1, String paramString2, String paramString3, e parame) {
    this.y = paramString1;
    this.B = paramString2;
    this.z = paramString3;
    this.G = parame;
  }
  
  private void a() {
    this.ab = new e(this.H.optJSONObject("posCfg"));
  }
  
  public static int d(JSONObject paramJSONObject) {
    return paramJSONObject.optInt("ecpm", -1);
  }
  
  private void d(boolean paramBoolean) {
    this.Z = paramBoolean;
  }
  
  public static int e(JSONObject paramJSONObject) {
    String str = paramJSONObject.optString("mp");
    if (!TextUtils.isEmpty(str)) {
      byte b1;
      try {
        b1 = Integer.valueOf(new String(as.b(Base64.decode(str, 0)), com.qq.e.comm.plugin.f.a.a)).intValue();
      } catch (com.qq.e.comm.plugin.util.as.b b2) {
        b2.printStackTrace();
        b1 = -1;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ad response mp origin value: ");
      stringBuilder.append(str);
      stringBuilder.append(" decryption value: ");
      stringBuilder.append(b1);
      GDTLogger.d(stringBuilder.toString());
      return b1;
    } 
    byte b = -1;
  }
  
  public static boolean f(JSONObject paramJSONObject) {
    return i(paramJSONObject.optInt("buyingtype", 1));
  }
  
  public static s h(JSONObject paramJSONObject) {
    return (paramJSONObject == null) ? null : new s(paramJSONObject.optString("wxappid"), paramJSONObject.optJSONObject("wechat_ad_trace_data"), paramJSONObject.optString("wechat_app_username"), paramJSONObject.optString("wechat_app_path"), paramJSONObject.optString("wechat_app_token"));
  }
  
  private static boolean i(int paramInt) {
    return (paramInt != 1);
  }
  
  public String A() {
    return this.l;
  }
  
  public String B() {
    return this.B;
  }
  
  public e C() {
    return this.G;
  }
  
  public String D() {
    return this.z;
  }
  
  public JSONObject E() {
    return this.H;
  }
  
  public int F() {
    return this.K;
  }
  
  public String G() {
    return this.L;
  }
  
  public String H() {
    return this.m;
  }
  
  public int I() {
    return this.C;
  }
  
  public String J() {
    return this.J;
  }
  
  public int K() {
    return this.D;
  }
  
  public boolean L() {
    return i(this.E);
  }
  
  public String M() {
    return this.h;
  }
  
  public String N() {
    return this.f;
  }
  
  public int O() {
    i i1 = this.F;
    return (i1 != null) ? i1.a() : -1;
  }
  
  public int P() {
    return this.M;
  }
  
  public int Q() {
    return this.N;
  }
  
  public List<g> R() {
    return this.O;
  }
  
  public List<g> S() {
    return this.P;
  }
  
  public List<String> T() {
    return this.Q;
  }
  
  public List<String> U() {
    return this.R;
  }
  
  public void V() {
    List<g> list = this.O;
    if (list != null && list.size() > 0)
      for (g g : this.O) {
        if (g != null)
          ah.a(g.a()); 
      }  
  }
  
  public void W() {
    List<g> list = this.P;
    if (list != null && list.size() > 0)
      for (g g : this.P) {
        if (g != null)
          ac.a(g.a()); 
      }  
  }
  
  public void X() {
    List<String> list = this.Q;
    if (list != null && list.size() > 0) {
      Iterator<String> iterator = this.Q.iterator();
      while (iterator.hasNext())
        ah.a(iterator.next()); 
    } 
  }
  
  public void Y() {
    List<String> list = this.R;
    if (list != null && list.size() > 0) {
      Iterator<String> iterator = this.R.iterator();
      while (iterator.hasNext())
        ac.a(iterator.next()); 
    } 
  }
  
  public e Z() {
    return this.ab;
  }
  
  public void a(int paramInt) {
    this.j = paramInt;
  }
  
  public void a(e parame) {
    this.G = parame;
  }
  
  public void a(j paramj) {
    this.q = paramj;
  }
  
  public void a(k paramk) {
    this.T = paramk;
  }
  
  public void a(s params) {
    this.Y = params;
  }
  
  public void a(i parami) {
    this.F = parami;
  }
  
  public void a(List<g> paramList) {
    this.O = paramList;
  }
  
  public void a(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public int a_() {
    return this.j;
  }
  
  public boolean aa() {
    return this.S;
  }
  
  public k ab() {
    return this.T;
  }
  
  public String ac() {
    return this.U;
  }
  
  public String ad() {
    return this.V;
  }
  
  public int ae() {
    return this.W;
  }
  
  public String af() {
    return this.X;
  }
  
  public s ag() {
    return this.Y;
  }
  
  public boolean ah() {
    return (Build.VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(G()));
  }
  
  public boolean ai() {
    return this.Z;
  }
  
  public String aj() {
    return this.aa;
  }
  
  public void b(int paramInt) {
    this.K = paramInt;
  }
  
  public void b(String paramString) {
    this.a = paramString;
  }
  
  public void b(List<g> paramList) {
    this.P = paramList;
  }
  
  public void b(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      this.I = new c(paramJSONObject); 
  }
  
  public void b(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public void c(int paramInt) {
    this.C = paramInt;
  }
  
  public void c(String paramString) {
    this.b = paramString;
  }
  
  public void c(List<String> paramList) {
    this.Q = paramList;
  }
  
  public void c(JSONObject paramJSONObject) {
    this.H = paramJSONObject;
  }
  
  public void c(boolean paramBoolean) {
    this.S = paramBoolean;
  }
  
  public void d(int paramInt) {
    this.D = paramInt;
  }
  
  public void d(String paramString) {
    this.c = paramString;
  }
  
  public void d(List<String> paramList) {
    this.R = paramList;
  }
  
  public void e(int paramInt) {
    this.E = paramInt;
  }
  
  public void e(String paramString) {
    this.d = paramString;
  }
  
  public void f(int paramInt) {
    this.M = paramInt;
  }
  
  public void f(String paramString) {
    this.e = paramString;
  }
  
  public void g(int paramInt) {
    this.N = paramInt;
  }
  
  public void g(String paramString) {
    this.f = paramString;
  }
  
  public void g(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    c(paramJSONObject);
    b(paramJSONObject.optString("cl"));
    c(paramJSONObject.optString("txt"));
    d(paramJSONObject.optString("desc"));
    e(paramJSONObject.optString("img"));
    f(paramJSONObject.optString("img2"));
    g(paramJSONObject.optString("apurl"));
    h(paramJSONObject.optString("v_apurl"));
    i(paramJSONObject.optString("rl"));
    j(paramJSONObject.optString("customizedpingurl"));
    a(paramJSONObject.optInt("producttype"));
    p(paramJSONObject.optString("traceid"));
    n(paramJSONObject.optString("landing_page_report_url"));
    b(paramJSONObject.optJSONObject("component"));
    String str1 = paramJSONObject.optString("negative_feedback_url");
    byte b = -1;
    c(paramJSONObject.optInt("ecpm", -1));
    String str2 = paramJSONObject.optString("mp");
    int m = b;
    if (!TextUtils.isEmpty(str2))
      try {
        m = Integer.valueOf(new String(as.b(Base64.decode(str2, 0)), com.qq.e.comm.plugin.f.a.a)).intValue();
      } catch (com.qq.e.comm.plugin.util.as.b b1) {
        b1.printStackTrace();
        m = b;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ad response mp origin value: ");
    stringBuilder.append(str2);
    stringBuilder.append(" decryption value: ");
    stringBuilder.append(m);
    GDTLogger.d(stringBuilder.toString());
    d(m);
    q(paramJSONObject.optString("ecpm_level"));
    boolean bool = true;
    e(paramJSONObject.optInt("buyingtype", 1));
    if (!TextUtils.isEmpty(str1))
      k(str1.replace("__ACT_TYPE__", "2001")); 
    a(d.a(paramJSONObject));
    if (v())
      a(d.d(paramJSONObject)); 
    b(d.b(paramJSONObject));
    l(paramJSONObject.optString("template_id"));
    m(paramJSONObject.optString("video_tracking_url"));
    a(i.a(paramJSONObject));
    b(paramJSONObject.optInt("sub_type"));
    o(paramJSONObject.optString("video"));
    f(paramJSONObject.optInt("video_width"));
    g(paramJSONObject.optInt("video_height"));
    a(g.a(paramJSONObject.optJSONArray("report_url")));
    b(g.a(paramJSONObject.optJSONArray("report_url_sdk")));
    c(d.a(paramJSONObject.optJSONArray("click_mo_url")));
    d(d.a(paramJSONObject.optJSONArray("click_mo_url_sdk")));
    a(q.a(paramJSONObject));
    r(paramJSONObject.optString("video_widget_url"));
    s(paramJSONObject.optString("button_txt"));
    h(paramJSONObject.optInt("mini_program_type"));
    t(paramJSONObject.optString("customized_invoke_url"));
    a(h(paramJSONObject));
    if (paramJSONObject.optInt("app_store") != 1)
      bool = false; 
    d(bool);
    u(paramJSONObject.optString("productid"));
    a();
  }
  
  public void h(int paramInt) {
    this.W = paramInt;
  }
  
  public void h(String paramString) {
    this.g = paramString;
  }
  
  public String i() {
    return this.c;
  }
  
  public void i(String paramString) {
    this.h = paramString;
  }
  
  public void j(String paramString) {
    this.i = paramString;
  }
  
  public void k(String paramString) {
    this.k = paramString;
  }
  
  public c l() {
    return this.I;
  }
  
  public void l(String paramString) {
    this.p = paramString;
  }
  
  public String m() {
    return this.a;
  }
  
  public void m(String paramString) {
    this.r = paramString;
  }
  
  public String n() {
    return this.b;
  }
  
  public void n(String paramString) {
    this.l = paramString;
  }
  
  public String o() {
    return this.d;
  }
  
  public void o(String paramString) {
    this.L = paramString;
  }
  
  public String p() {
    return this.e;
  }
  
  public void p(String paramString) {
    this.m = paramString;
  }
  
  public String q() {
    return this.f;
  }
  
  public void q(String paramString) {
    this.J = paramString;
  }
  
  public String r() {
    return this.g;
  }
  
  public void r(String paramString) {
    this.U = paramString;
  }
  
  public String s() {
    return this.h;
  }
  
  public void s(String paramString) {
    this.V = paramString;
  }
  
  public String t() {
    return this.i;
  }
  
  public void t(String paramString) {
    this.X = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BaseAdInfo{cl='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", txt='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", desc='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", img='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", apurl='");
    stringBuilder.append(this.f);
    stringBuilder.append('\'');
    stringBuilder.append(", customizedpingurl='");
    stringBuilder.append(this.i);
    stringBuilder.append('\'');
    stringBuilder.append(", negative_feedback_url='");
    stringBuilder.append(this.k);
    stringBuilder.append('\'');
    stringBuilder.append(", isAppAd=");
    stringBuilder.append(this.n);
    stringBuilder.append(", appInfo=");
    j j1 = this.q;
    String str2 = "";
    if (j1 != null) {
      str1 = j1.toString();
    } else {
      str1 = "";
    } 
    stringBuilder.append(str1);
    stringBuilder.append(", duration=");
    stringBuilder.append(this.s);
    stringBuilder.append(", background_url='");
    stringBuilder.append(this.t);
    stringBuilder.append('\'');
    stringBuilder.append(", leftPadding=");
    stringBuilder.append(this.u);
    stringBuilder.append(", topPadding=");
    stringBuilder.append(this.v);
    stringBuilder.append(", widthRatio=");
    stringBuilder.append(this.w);
    stringBuilder.append(", heightRatio=");
    stringBuilder.append(this.x);
    stringBuilder.append(", hideDescVertical=");
    stringBuilder.append(this.A);
    stringBuilder.append(", appId=");
    stringBuilder.append(this.y);
    stringBuilder.append(", posId=");
    stringBuilder.append(this.B);
    stringBuilder.append(", adThreadId=");
    stringBuilder.append(this.z);
    stringBuilder.append(", adJson=");
    stringBuilder.append(this.H);
    stringBuilder.append(", adType=");
    stringBuilder.append(this.G);
    stringBuilder.append(", sspExt=");
    i i1 = this.F;
    String str1 = str2;
    if (i1 != null)
      str1 = i1.toString(); 
    stringBuilder.append(str1);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public String u() {
    return this.k;
  }
  
  public void u(String paramString) {
    this.aa = paramString;
  }
  
  public boolean v() {
    return this.n;
  }
  
  public boolean w() {
    return this.o;
  }
  
  public String x() {
    return this.p;
  }
  
  public String y() {
    return this.r;
  }
  
  public j z() {
    return this.q;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\s\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */