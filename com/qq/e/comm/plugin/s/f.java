package com.qq.e.comm.plugin.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.plugin.ad.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class f extends a {
  private int J;
  
  private boolean K;
  
  private int L;
  
  private int M;
  
  private int N;
  
  private boolean O;
  
  private boolean P;
  
  private String Q;
  
  private int R;
  
  private boolean S;
  
  private int T;
  
  private String U;
  
  private List<h> V;
  
  private String W;
  
  private String X;
  
  private String Y;
  
  private int Z;
  
  private f aa;
  
  private String ab;
  
  private Boolean ac;
  
  private long ad = -1L;
  
  private int ae = -1;
  
  private int af = -1;
  
  private boolean ag;
  
  public f(String paramString1, String paramString2, String paramString3, e parame) {
    super(paramString1, paramString2, paramString3, parame);
  }
  
  public boolean L() {
    return this.ag;
  }
  
  public int O() {
    return this.af;
  }
  
  public int a() {
    return this.J;
  }
  
  public void a(long paramLong) {
    this.ad = paramLong;
  }
  
  public void a(f paramf) {
    this.aa = paramf;
  }
  
  public void a(String paramString) {
    this.Q = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    boolean bool = true;
    if (paramJSONObject == null || paramJSONObject.optInt("enable") != 1)
      bool = false; 
    this.ac = Boolean.valueOf(bool);
  }
  
  public String ak() {
    return this.X;
  }
  
  public String al() {
    return this.Y;
  }
  
  public f am() {
    return this.aa;
  }
  
  public String an() {
    return this.ab;
  }
  
  public long ao() {
    return this.ad;
  }
  
  public Boolean ap() {
    return this.ac;
  }
  
  public int aq() {
    return this.ae;
  }
  
  public void b(f paramf) {
    if (paramf != null)
      try {
        if (!TextUtils.isEmpty(paramf.q())) {
          this.f = paramf.q();
          this.H.put("apurl", this.f);
        } 
        if (!TextUtils.isEmpty(paramf.s())) {
          this.h = paramf.s();
          this.H.put("rl", this.h);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public boolean c() {
    return this.K;
  }
  
  public void d(boolean paramBoolean) {
    this.K = paramBoolean;
  }
  
  public boolean d() {
    return this.O;
  }
  
  public void e(List<h> paramList) {
    this.V = paramList;
  }
  
  public void e(boolean paramBoolean) {
    this.O = paramBoolean;
  }
  
  public boolean e() {
    return this.P;
  }
  
  public String f() {
    return this.Q;
  }
  
  public void f(boolean paramBoolean) {
    this.P = paramBoolean;
  }
  
  public int g() {
    return this.R;
  }
  
  public void g(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    this.ad = SystemClock.elapsedRealtime();
    super.g(paramJSONObject);
    i(paramJSONObject.optInt("cid"));
    int i = paramJSONObject.optInt("is_contract");
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    d(bool1);
    j(paramJSONObject.optInt("pv_fcs"));
    k(paramJSONObject.optInt("pv_limit"));
    l(paramJSONObject.optInt("price_mode"));
    if (paramJSONObject.optInt("need_empty_report") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    e(bool1);
    if (paramJSONObject.optInt("is_empty") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    f(bool1);
    a(paramJSONObject.optString("uoid"));
    m(paramJSONObject.optInt("rot_index", -1));
    boolean bool1 = bool2;
    if (paramJSONObject.optInt("offlinestop") == 1)
      bool1 = true; 
    g(bool1);
    n(paramJSONObject.optInt("timelife"));
    v(paramJSONObject.optString("ad_icon"));
    e(h.a(paramJSONObject.optJSONArray("slot")));
    w(paramJSONObject.optString("video_md5"));
    a(paramJSONObject.optJSONObject("open_mini_program"));
    y(paramJSONObject.optString("joint_loc"));
    x(paramJSONObject.optString("joint_uoid"));
    o(paramJSONObject.optInt("oneshot_report_type"));
    p(paramJSONObject.optInt("banner_start_time", -1));
    this.af = i.b(paramJSONObject);
    this.ag = a.f(paramJSONObject);
  }
  
  public void g(boolean paramBoolean) {
    this.S = paramBoolean;
  }
  
  public int h() {
    return this.T;
  }
  
  public void i(int paramInt) {
    this.J = paramInt;
  }
  
  public List<h> j() {
    return this.V;
  }
  
  public void j(int paramInt) {
    this.L = paramInt;
  }
  
  public String k() {
    return this.W;
  }
  
  public void k(int paramInt) {
    this.M = paramInt;
  }
  
  public void l(int paramInt) {
    this.N = paramInt;
  }
  
  public void m(int paramInt) {
    this.R = paramInt;
  }
  
  public void n(int paramInt) {
    this.T = paramInt;
  }
  
  public void o(int paramInt) {
    this.Z = paramInt;
  }
  
  public void p(int paramInt) {
    this.ae = paramInt;
  }
  
  public void q(int paramInt) {
    String str;
    List<h> list = j();
    Iterator<h> iterator2 = null;
    Iterator iterator = null;
    Iterator<h> iterator1 = iterator2;
    if (list != null) {
      iterator1 = iterator2;
      if (list.size() > 0) {
        iterator2 = list.iterator();
        iterator1 = iterator;
        while (iterator2.hasNext()) {
          String str1 = ((h)iterator2.next()).a(Integer.valueOf(paramInt));
          str = str1;
          if (!TextUtils.isEmpty(str1)) {
            str = str1;
            break;
          } 
        } 
      } 
    } 
    if (!TextUtils.isEmpty(str)) {
      if (!TextUtils.isEmpty(this.f))
        this.f = this.f.replace("__SERVER_DATA__", str); 
      List<g> list1 = R();
      if (list1 != null && list1.size() > 0)
        for (g g : list1) {
          if (g != null) {
            String str1 = g.a();
            if (!TextUtils.isEmpty(str1))
              g.a(str1.replace("__SERVER_DATA__", str)); 
          } 
        }  
      list1 = S();
      if (list1 != null && list1.size() > 0)
        for (g g : list1) {
          if (g != null) {
            String str1 = g.a();
            if (!TextUtils.isEmpty(str1))
              g.a(str1.replace("__SERVER_DATA__", str)); 
          } 
        }  
      if (!TextUtils.isEmpty(this.h))
        this.h = this.h.replace("__SERVER_DATA__", str); 
      List<String> list2 = T();
      if (list2 != null && list2.size() > 0) {
        list1 = new ArrayList<g>();
        Iterator<String> iterator3 = list2.iterator();
        while (iterator3.hasNext())
          list1.add(((String)iterator3.next()).replace("__SERVER_DATA__", str)); 
      } 
      list2 = U();
      if (list2 != null && list2.size() > 0) {
        list1 = new ArrayList<g>();
        Iterator<String> iterator3 = list2.iterator();
        while (iterator3.hasNext())
          list1.add(((String)iterator3.next()).replace("__SERVER_DATA__", str)); 
      } 
    } 
  }
  
  public void v(String paramString) {
    this.U = paramString;
  }
  
  public void w(String paramString) {
    this.W = paramString;
  }
  
  public void x(String paramString) {
    this.X = paramString;
  }
  
  public void y(String paramString) {
    this.Y = paramString;
  }
  
  public void z(String paramString) {
    this.ab = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\s\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */