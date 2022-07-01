package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.widget.webview.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class k {
  private Map<String, Object> A;
  
  private a B;
  
  private boolean C;
  
  private int D;
  
  private String E;
  
  private int F = -200;
  
  private int G = 0;
  
  private d H = new d();
  
  private AdSlot I;
  
  private int J;
  
  private int K = 1;
  
  private String L;
  
  private int M = 0;
  
  private int N = 0;
  
  private int O = 0;
  
  private JSONObject P;
  
  private int a;
  
  private j b;
  
  private j c;
  
  private String d;
  
  private List<j> e = new ArrayList<j>();
  
  private String f;
  
  private List<String> g = new ArrayList<String>();
  
  private List<String> h = new ArrayList<String>();
  
  private String i;
  
  private String j;
  
  private String k;
  
  private String l = "0";
  
  private b m;
  
  private f n;
  
  private int o;
  
  private String p;
  
  private String q;
  
  private List<FilterWord> r = new ArrayList<FilterWord>();
  
  private int s = 0;
  
  private long t;
  
  private int u;
  
  private r v;
  
  private boolean w;
  
  private boolean x;
  
  private boolean y;
  
  private g z;
  
  private int af() {
    g g1 = this.z;
    return (g1 == null) ? 0 : g1.d();
  }
  
  private JSONObject b(FilterWord paramFilterWord) {
    if (paramFilterWord == null)
      return null; 
    try {
      return null;
    } finally {
      paramFilterWord = null;
    } 
  }
  
  public String A() {
    return this.p;
  }
  
  public int B() {
    return this.a;
  }
  
  public j C() {
    return this.b;
  }
  
  public j D() {
    return this.c;
  }
  
  public String E() {
    return this.d;
  }
  
  public List<j> F() {
    return this.e;
  }
  
  public String G() {
    return this.f;
  }
  
  public List<String> H() {
    return this.g;
  }
  
  public List<String> I() {
    return this.h;
  }
  
  public String J() {
    return this.i;
  }
  
  public String K() {
    return this.j;
  }
  
  public String L() {
    return this.k;
  }
  
  public String M() {
    return this.l;
  }
  
  public b N() {
    return this.m;
  }
  
  public f O() {
    return this.n;
  }
  
  public String P() {
    return this.q;
  }
  
  public int Q() {
    return this.o;
  }
  
  public List<FilterWord> R() {
    return this.r;
  }
  
  public long S() {
    return this.t;
  }
  
  public int T() {
    return this.u;
  }
  
  public boolean U() {
    return this.w;
  }
  
  public boolean V() {
    return this.x;
  }
  
  public boolean W() {
    return this.y;
  }
  
  public Map<String, Object> X() {
    return this.A;
  }
  
  public JSONObject Y() {
    return this.P;
  }
  
  public String Z() {
    return this.L;
  }
  
  public int a() {
    return this.M;
  }
  
  public void a(int paramInt) {
    this.M = paramInt;
  }
  
  public void a(long paramLong) {
    this.t = paramLong;
  }
  
  public void a(AdSlot paramAdSlot) {
    this.I = paramAdSlot;
  }
  
  public void a(FilterWord paramFilterWord) {
    this.r.add(paramFilterWord);
  }
  
  public void a(b paramb) {
    this.m = paramb;
  }
  
  public void a(d paramd) {
    this.H = paramd;
  }
  
  public void a(f paramf) {
    this.n = paramf;
  }
  
  public void a(g paramg) {
    this.z = paramg;
  }
  
  public void a(j paramj) {
    this.b = paramj;
  }
  
  public void a(a parama) {
    this.B = parama;
    d.a().b();
    com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this);
  }
  
  public void a(r paramr) {
    this.v = paramr;
  }
  
  public void a(String paramString) {
    this.E = paramString;
  }
  
  public void a(Map<String, Object> paramMap) {
    this.A = paramMap;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.P = paramJSONObject;
  }
  
  public void a(boolean paramBoolean) {
    this.C = paramBoolean;
  }
  
  public boolean aa() {
    if (this.e.isEmpty())
      return false; 
    if (this.o == 4 && this.e.size() < 3)
      return false; 
    Iterator<j> iterator = this.e.iterator();
    while (iterator.hasNext()) {
      if (!((j)iterator.next()).d())
        return false; 
    } 
    return true;
  }
  
  public int ab() {
    g g1 = this.z;
    return (g1 == null) ? -1 : g1.b();
  }
  
  public boolean ac() {
    return (ad() == 1);
  }
  
  public int ad() {
    return this.s;
  }
  
  public JSONObject ae() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("interaction_type", B());
      jSONObject.put("target_url", E());
      jSONObject.put("ad_id", M());
      jSONObject.put("source", A());
      jSONObject.put("screenshot", U());
      jSONObject.put("dislike_control", ad());
      jSONObject.put("play_bar_show_time", n());
      jSONObject.put("is_playable", q());
      jSONObject.put("playable_type", c());
      jSONObject.put("playable_style", d());
      jSONObject.put("play_bar_style", h());
      jSONObject.put("if_block_lp", a());
      j j1 = C();
      if (j1 != null && !TextUtils.isEmpty(j1.a())) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("url", j1.a());
        jSONObject3.put("height", j1.c());
        jSONObject3.put("width", j1.b());
        jSONObject.put("icon", jSONObject3);
      } 
      j1 = D();
      if (j1 != null && !TextUtils.isEmpty(j1.a())) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("url", j1.a());
        jSONObject3.put("height", j1.c());
        jSONObject3.put("width", j1.b());
        jSONObject.put("cover_image", jSONObject3);
      } 
      JSONObject jSONObject2 = Y();
      if (jSONObject2 != null)
        jSONObject.put("session_params", jSONObject2); 
      d d1 = i();
      if (d1 != null) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("click_upper_content_area", d1.a);
        jSONObject3.put("click_upper_non_content_area", d1.b);
        jSONObject3.put("click_lower_content_area", d1.c);
        jSONObject3.put("click_lower_non_content_area", d1.d);
        jSONObject3.put("click_button_area", d1.e);
        jSONObject3.put("click_video_area", d1.f);
        jSONObject.put("click_area", jSONObject3);
      } 
      AdSlot adSlot = j();
      if (adSlot != null)
        jSONObject.put("adslot", adSlot.toJsonObj()); 
      List<j> list = F();
      if (list != null) {
        JSONArray jSONArray = new JSONArray();
        for (j j2 : list) {
          JSONObject jSONObject3 = new JSONObject();
          jSONObject3.put("url", j2.a());
          jSONObject3.put("height", j2.c());
          jSONObject3.put("width", j2.b());
          jSONArray.put(jSONObject3);
        } 
        jSONObject.put("image", jSONArray);
      } 
      list = (List)H();
      if (list != null) {
        JSONArray jSONArray = new JSONArray();
        Iterator<j> iterator = list.iterator();
        while (iterator.hasNext())
          jSONArray.put(iterator.next()); 
        jSONObject.put("show_url", jSONArray);
      } 
      list = (List)I();
      if (list != null) {
        JSONArray jSONArray = new JSONArray();
        Iterator<j> iterator = list.iterator();
        while (iterator.hasNext())
          jSONArray.put(iterator.next()); 
        jSONObject.put("click_url", jSONArray);
      } 
      jSONObject.put("phone_num", G());
      jSONObject.put("title", J());
      jSONObject.put("description", K());
      jSONObject.put("ext", P());
      jSONObject.put("image_mode", Q());
      jSONObject.put("is_playable", q());
      jSONObject.put("intercept_flag", m());
      jSONObject.put("button_text", L());
      jSONObject.put("ad_logo", g());
      jSONObject.put("video_adaptation", f());
      jSONObject.put("feed_video_opentype", e());
      b b1 = N();
      if (b1 != null) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("app_name", b1.c());
        jSONObject3.put("package_name", b1.d());
        jSONObject3.put("download_url", b1.b());
        jSONObject3.put("score", b1.e());
        jSONObject3.put("comment_num", b1.f());
        jSONObject3.put("quick_app_url", b1.a());
        jSONObject3.put("app_size", b1.g());
        jSONObject.put("app", jSONObject3);
      } 
      f f1 = O();
      if (f1 != null) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("deeplink_url", f1.a());
        jSONObject3.put("fallback_url", f1.b());
        jSONObject3.put("fallback_type", f1.c());
        jSONObject.put("deep_link", jSONObject3);
      } 
      list = (List)R();
      if (list != null) {
        JSONArray jSONArray = new JSONArray();
        Iterator<j> iterator = list.iterator();
        while (iterator.hasNext()) {
          JSONObject jSONObject3 = b((FilterWord)iterator.next());
          if (jSONObject3 != null)
            jSONArray.put(jSONObject3); 
        } 
        jSONObject.put("filter_words", jSONArray);
      } 
      jSONObject.put("count_down", T());
      jSONObject.put("expiration_time", S());
      r r1 = z();
      if (r1 != null)
        jSONObject.put("video", r1.k()); 
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("auto_open", v());
      jSONObject1.put("download_mode", w());
      jSONObject1.put("support_multiple", af());
      jSONObject1.put("download_type", ab());
      jSONObject1.put("auto_control", l());
      jSONObject1.put("if_suspend_download", t());
      jSONObject.put("download_conf", jSONObject1);
      if (X() != null) {
        jSONObject1 = new JSONObject();
        Set<Map.Entry<String, Object>> set = X().entrySet();
        if (set != null && !set.isEmpty())
          for (Map.Entry<String, Object> entry : set)
            jSONObject1.put((String)entry.getKey(), entry.getValue());  
        jSONObject.put("media_ext", jSONObject1);
      } 
      a a1 = x();
      if (a1 != null) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("id", a1.b());
        jSONObject3.put("md5", a1.c());
        jSONObject3.put("url", a1.d());
        jSONObject3.put("data", a1.e());
        jSONObject3.put("diff_data", a1.f());
        jSONObject3.put("version", a1.a());
        jSONObject3.put("dynamic_creative", a1.g());
        jSONObject.put("tpl_info", jSONObject3);
      } 
      jSONObject.put("market_url", Z());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public void b(int paramInt) {
    this.D = paramInt;
  }
  
  public void b(j paramj) {
    this.c = paramj;
  }
  
  public void b(String paramString) {
    this.p = paramString;
  }
  
  public void b(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    this.a = 4;
    this.l = paramJSONObject.optString("id");
    this.p = paramJSONObject.optString("source");
    this.m = new b();
    this.m.d(paramJSONObject.optString("pkg_name"));
    this.m.c(paramJSONObject.optString("name"));
    this.m.b(paramJSONObject.optString("download_url"));
  }
  
  public void b(boolean paramBoolean) {
    this.w = paramBoolean;
  }
  
  public boolean b() {
    return (this.M == 1);
  }
  
  public int c() {
    return this.D;
  }
  
  public void c(int paramInt) {
    this.O = paramInt;
  }
  
  public void c(j paramj) {
    this.e.add(paramj);
  }
  
  public void c(String paramString) {
    this.d = paramString;
  }
  
  public void c(boolean paramBoolean) {
    this.x = paramBoolean;
  }
  
  public String d() {
    return this.E;
  }
  
  public void d(int paramInt) {
    this.N = paramInt;
  }
  
  public void d(String paramString) {
    this.f = paramString;
  }
  
  public void d(boolean paramBoolean) {
    this.y = paramBoolean;
  }
  
  public int e() {
    return this.O;
  }
  
  public void e(int paramInt) {
    this.K = paramInt;
  }
  
  public void e(String paramString) {
    this.i = paramString;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.l.equals(((k)paramObject).l) && this.q.equals(((k)paramObject).q));
    } 
    return false;
  }
  
  public int f() {
    return this.N;
  }
  
  public void f(int paramInt) {
    this.G = paramInt;
  }
  
  public void f(String paramString) {
    this.j = paramString;
  }
  
  public int g() {
    return this.K;
  }
  
  public void g(int paramInt) {
    this.J = paramInt;
  }
  
  public void g(String paramString) {
    this.k = paramString;
  }
  
  public int h() {
    return this.G;
  }
  
  public void h(int paramInt) {
    this.F = paramInt;
  }
  
  public void h(String paramString) {
    this.l = paramString;
  }
  
  public int hashCode() {
    return this.l.hashCode() * 31 + this.q.hashCode();
  }
  
  public d i() {
    return this.H;
  }
  
  public void i(int paramInt) {
    this.a = paramInt;
  }
  
  public void i(String paramString) {
    this.q = paramString;
  }
  
  public AdSlot j() {
    return this.I;
  }
  
  public void j(int paramInt) {
    this.o = paramInt;
  }
  
  public void j(String paramString) {
    this.L = paramString;
  }
  
  public void k(int paramInt) {
    this.u = paramInt;
  }
  
  public boolean k() {
    return (l() == 1);
  }
  
  public int l() {
    g g1 = this.z;
    return (g1 == null) ? 0 : g1.g();
  }
  
  public void l(int paramInt) {
    this.s = paramInt;
  }
  
  public int m() {
    return this.J;
  }
  
  public int n() {
    return this.F;
  }
  
  public boolean o() {
    r r1 = this.v;
    boolean bool = true;
    if (r1 != null) {
      if (r1.l() != 1)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public boolean p() {
    r r1 = this.v;
    return (r1 != null && r1.m() == 1);
  }
  
  public boolean q() {
    return this.C;
  }
  
  public boolean r() {
    return (q() && c() == 1);
  }
  
  public boolean s() {
    return (t() == 1);
  }
  
  public int t() {
    g g1 = this.z;
    return (g1 == null) ? 1 : g1.a();
  }
  
  public boolean u() {
    g g1 = this.z;
    return (g1 != null && g1.c());
  }
  
  public int v() {
    g g1 = this.z;
    return (g1 == null) ? 1 : g1.e();
  }
  
  public int w() {
    g g1 = this.z;
    return (g1 == null) ? 0 : g1.f();
  }
  
  public a x() {
    return this.B;
  }
  
  public g y() {
    return this.z;
  }
  
  public r z() {
    return this.v;
  }
  
  public static class a {
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    private String f;
    
    private String g;
    
    public String a() {
      return this.f;
    }
    
    public void a(String param1String) {
      this.f = param1String;
    }
    
    public String b() {
      return this.a;
    }
    
    public void b(String param1String) {
      this.a = param1String;
    }
    
    public String c() {
      return this.b;
    }
    
    public void c(String param1String) {
      this.b = param1String;
    }
    
    public String d() {
      return this.c;
    }
    
    public void d(String param1String) {
      this.c = param1String;
    }
    
    public String e() {
      return this.d;
    }
    
    public void e(String param1String) {
      this.d = param1String;
    }
    
    public String f() {
      return this.e;
    }
    
    public void f(String param1String) {
      this.e = param1String;
    }
    
    public String g() {
      return this.g;
    }
    
    public void g(String param1String) {
      this.g = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */