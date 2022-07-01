package com.bytedance.sdk.openadsdk.core.h;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.p;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class l implements e {
  private int A = 1;
  
  private String B;
  
  private String C;
  
  private int D = 1;
  
  private int E = 5;
  
  private String F;
  
  private String G;
  
  private int H;
  
  private int I;
  
  private int J = 0;
  
  private long K = 0L;
  
  private Set<String> L = Collections.synchronizedSet(new HashSet<String>());
  
  private Set<String> M = Collections.synchronizedSet(new HashSet<String>());
  
  private int N = 0;
  
  private int O = 1;
  
  private long P = 10000L;
  
  private int Q = 50;
  
  private int R = 30;
  
  private int S = 5;
  
  private int T = 3600;
  
  private String U = "pangolin.snssdk.com";
  
  private String V = "extlog.snssdk.com/service/2/app_log/";
  
  private int W = 100;
  
  private int X = 3000;
  
  private int a = 0;
  
  private int b = 0;
  
  private int c = 1023409663;
  
  private Map<String, a> d = new HashMap<String, a>();
  
  private Map<String, m> e = new HashMap<String, m>();
  
  private String f;
  
  private Set<String> g = new HashSet<String>();
  
  private String h;
  
  private Set<String> i = Collections.synchronizedSet(new HashSet<String>());
  
  private List<g> j = new CopyOnWriteArrayList<g>();
  
  private String k;
  
  private int l = 1;
  
  private int m = 0;
  
  private int n = 1;
  
  private String o = "com.oppo.market";
  
  private int p = 0;
  
  private String q = "com.huawei.appmarket";
  
  private int r = 1;
  
  private int s = 30;
  
  private int t = 1;
  
  private int u = 30;
  
  private int v = 10;
  
  private int w = 1;
  
  private int x = 0;
  
  private int y = 5;
  
  private int z = 2;
  
  private void U() {
    if (!TextUtils.isEmpty(this.h)) {
      try {
        JSONArray jSONArray = new JSONArray(this.h);
        int i = jSONArray.length();
        if (i > 0) {
          this.i.clear();
          for (int j = 0; j < i; j++) {
            String str = (String)jSONArray.opt(j);
            this.i.add(str);
          } 
        } 
        try {
          a.a(this.i);
          return;
        } finally {}
      } catch (Exception exception) {
        try {
          a.a(this.i);
          return;
        } finally {}
      } 
    } else {
      return;
    } 
  }
  
  private void V() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void W() {
    if (!TextUtils.isEmpty(this.f))
      try {
        JSONArray jSONArray = new JSONArray(this.f);
        int i = jSONArray.length();
        if (i > 0) {
          this.e.clear();
          for (int j = 0; j < i; j++) {
            m m = c(jSONArray.optJSONObject(j));
            if (m != null)
              this.e.put(m.a, m); 
          } 
        } 
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private ad X() {
    return ad.a("tt_sdk_settings", o.a());
  }
  
  private int a(boolean paramBoolean) {
    return paramBoolean ? 20 : 5;
  }
  
  private void a(m paramm) {
    a.a(paramm);
  }
  
  private void a(String paramString1, String paramString2) {
    if (b.b()) {
      a.a("tt_sdk_settings", "url_ads", this.U);
      a.a("tt_sdk_settings", "url_alog", this.V);
      a.a("tt_sdk_settings", "xpath", this.k);
      a.a("tt_sdk_settings", "duration", Long.valueOf(this.P));
      a.a("tt_sdk_settings", "max", Integer.valueOf(this.Q));
      a.a("tt_sdk_settings", "download_config_back_dialog", Integer.valueOf(this.l));
      a.a("tt_sdk_settings", "download_config_progressbar", Integer.valueOf(this.m));
      a.a("tt_sdk_settings", "download_config_hook", Integer.valueOf(this.n));
      a.a("tt_sdk_settings", "download_config_hook_oppo_arg1", this.o);
      a.a("tt_sdk_settings", "download_config_hook_oppo_arg4", Integer.valueOf(this.p));
      a.a("tt_sdk_settings", "download_config_hook_huawei_arg1", this.q);
      a.a("tt_sdk_settings", "download_config_dl_network", Integer.valueOf(this.r));
      a.a("tt_sdk_settings", "download_config_dl_size", Integer.valueOf(this.s));
      a.a("tt_sdk_settings", "download_config_enable_install_again", Integer.valueOf(this.t));
      a.a("tt_sdk_settings", "download_config_install_again_time", Integer.valueOf(this.u));
      a.a("tt_sdk_settings", "download_config_install_again_time_next", Integer.valueOf(this.v));
      a.a("tt_sdk_settings", "download_config_storage_internal", Integer.valueOf(this.w));
      a.a("tt_sdk_settings", "download_config_resume_notify_switch", Integer.valueOf(this.x));
      a.a("tt_sdk_settings", "download_config_resume_notify_time", Integer.valueOf(this.y));
      a.a("tt_sdk_settings", "download_config_resume_notify_count", Integer.valueOf(this.z));
      a.a("tt_sdk_settings", "download_config_if_open_market_window", Integer.valueOf(this.A));
      a.a("tt_sdk_settings", "pos_cache_time", Integer.valueOf(this.R));
      a.a("tt_sdk_settings", "vbtt", Integer.valueOf(this.S));
      a.a("tt_sdk_settings", "fetch_template", Integer.valueOf(this.T));
      a.a("tt_sdk_settings", "web_info_wifi_enable", Integer.valueOf(this.D));
      a.a("tt_sdk_settings", "web_info_page_count", Integer.valueOf(this.E));
      a.a("tt_sdk_settings", "splash_load_type", Integer.valueOf(this.H));
      a.a("tt_sdk_settings", "splash_check_type", Integer.valueOf(this.I));
      a.a("tt_sdk_settings", "if_both_open", Integer.valueOf(this.N));
      a.a("tt_sdk_settings", "support_tnc", Integer.valueOf(this.O));
      a.a("tt_sdk_settings", "pyload_h5", this.F);
      a.a("tt_sdk_settings", "playableLoadH5Url", this.G);
      a.a("tt_sdk_settings", "app_list_control", Integer.valueOf(this.J));
      a.a("tt_sdk_settings", "max_tpl_cnts", Integer.valueOf(this.W));
      a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", Integer.valueOf(this.X));
      a.a("tt_sdk_settings", "hit_app_list_time", Long.valueOf(this.K));
      a.a("tt_sdk_settings", "hit_app_list_data", this.L);
      a.a("tt_sdk_settings", "scheme_list_data", this.M);
      a.a("tt_sdk_settings", "sp_ov_skip_key", Integer.valueOf(this.a));
      a.a("tt_sdk_settings", "download_xiaomi_silence_install", Integer.valueOf(this.b));
      a.a("tt_sdk_settings", "download_exp_switch_temp", Integer.valueOf(this.c));
      if (!TextUtils.isEmpty(this.B))
        a.a("tt_sdk_settings", "ab_test_version", this.B); 
      if (!TextUtils.isEmpty(this.C))
        a.a("tt_sdk_settings", "ab_test_param", this.C); 
      if (!TextUtils.isEmpty(paramString2))
        a.a("tt_sdk_settings", "push_config", paramString2); 
      if (!TextUtils.isEmpty(paramString1))
        a.a("tt_sdk_settings", "ad_slot_conf", paramString1); 
      if (!TextUtils.isEmpty(this.h))
        a.a("tt_sdk_settings", "template_ids", this.h); 
      if (!TextUtils.isEmpty(this.f))
        a.a("tt_sdk_settings", "tpl_infos", this.f); 
      return;
    } 
    ad ad = X();
    ad.a("url_ads", this.U);
    ad.a("url_alog", this.V);
    ad.a("xpath", this.k);
    ad.a("duration", this.P);
    ad.a("max", this.Q);
    ad.a("download_config_back_dialog", this.l);
    ad.a("download_config_progressbar", this.m);
    ad.a("download_config_hook", this.n);
    ad.a("download_config_hook_oppo_arg1", this.o);
    ad.a("download_config_hook_oppo_arg4", this.p);
    ad.a("download_config_hook_huawei_arg1", this.q);
    ad.a("download_config_dl_network", this.r);
    ad.a("download_config_dl_size", this.s);
    ad.a("download_config_enable_install_again", this.t);
    ad.a("download_config_install_again_time", this.u);
    ad.a("download_config_install_again_time_next", this.v);
    ad.a("download_config_storage_internal", this.w);
    ad.a("download_config_resume_notify_switch", this.x);
    ad.a("download_config_resume_notify_time", this.y);
    ad.a("download_config_resume_notify_count", this.z);
    ad.a("download_config_if_open_market_window", this.A);
    ad.a("pos_cache_time", this.R);
    ad.a("fetch_template", this.T);
    ad.a("web_info_wifi_enable", this.D);
    ad.a("web_info_page_count", this.E);
    ad.a("pyload_h5", this.F);
    ad.a("playableLoadH5Url", this.G);
    ad.a("splash_load_type", this.H);
    ad.a("splash_check_type", this.I);
    ad.a("if_both_open", this.N);
    ad.a("support_tnc", this.O);
    ad.a("app_list_control", this.J);
    ad.a("max_tpl_cnts", this.W);
    ad.a("fetch_tpl_timeout_ctrl", this.X);
    ad.a("hit_app_list_time", this.K);
    ad.a("hit_app_list_data", this.L);
    ad.a("scheme_list_data", this.M);
    ad.a("sp_ov_skip_key", this.a);
    ad.a("download_xiaomi_silence_install", this.b);
    ad.a("download_exp_switch_temp", this.c);
    if (!TextUtils.isEmpty(this.B))
      ad.a("ab_test_version", this.B); 
    if (!TextUtils.isEmpty(this.C))
      ad.a("ab_test_param", this.C); 
    ad.a("vbtt", this.S);
    if (!TextUtils.isEmpty(paramString2))
      ad.a("push_config", paramString2); 
    if (!TextUtils.isEmpty(paramString1))
      ad.a("ad_slot_conf", paramString1); 
    if (!TextUtils.isEmpty(this.h))
      ad.a("template_ids", this.h); 
    if (!TextUtils.isEmpty(this.f))
      ad.a("tpl_infos", this.f); 
  }
  
  private static a b(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    String str = paramJSONObject.optString("code_id");
    int i = paramJSONObject.optInt("auto_play", 1);
    int j = paramJSONObject.optInt("voice_control", 1);
    int k = paramJSONObject.optInt("rv_preload", 2);
    int m = paramJSONObject.optInt("nv_preload", 1);
    int n = paramJSONObject.optInt("read_video_from_cache", 1);
    int i1 = paramJSONObject.optInt("proportion_watching", 100);
    int i2 = paramJSONObject.optInt("skip_time_displayed", 0);
    int i3 = paramJSONObject.optInt("video_skip_result", 2);
    int i4 = paramJSONObject.optInt("reg_creative_control", 1);
    int i5 = paramJSONObject.optInt("play_bar_show_time", 3);
    int i6 = paramJSONObject.optInt("rv_skip_time", -1);
    int i7 = paramJSONObject.optInt("endcard_close_time", -1);
    int i8 = paramJSONObject.optInt("playable_endcard_close_time", -1);
    int i9 = paramJSONObject.optInt("voice_control", 2);
    int i10 = paramJSONObject.optInt("if_show_win", 1);
    int i11 = paramJSONObject.optInt("sp_preload", 0);
    int i12 = paramJSONObject.optInt("stop_time", 1500);
    int i13 = paramJSONObject.optInt("native_playable_delay", 2);
    int i14 = paramJSONObject.optInt("time_out_control", -1);
    int i15 = paramJSONObject.optInt("playable_duration_time", 20);
    int i16 = paramJSONObject.optInt("playable_close_time", -1);
    int i17 = paramJSONObject.optInt("playable_reward_type", 0);
    int i18 = paramJSONObject.optInt("reward_is_callback", 0);
    JSONArray jSONArray = paramJSONObject.optJSONArray("parent_tpl_ids");
    return a.a().a(str).n(i).o(j).p(k).q(m).r(n).s(i1).t(i2).u(i3).v(i4).m(i5).l(i6).j(i7).i(i9).k(i8).w(i10).f(i11).g(i12).h(i13).e(i14).a(i16).d(i15).b(i17).c(i18).a(jSONArray);
  }
  
  private static m c(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    String str2 = paramJSONObject.optString("tpl_id", "");
    String str3 = paramJSONObject.optString("md5", "");
    String str1 = paramJSONObject.optString("url", "");
    return m.a().a(str2).b(str3).c(str1);
  }
  
  private int d(JSONObject paramJSONObject) {
    this.H = paramJSONObject.optInt("splash_load_type", 1);
    int i = this.H;
    return (i != 0 && i != 1 && i != 2 && i != 3) ? 1 : this.H;
  }
  
  private int e(JSONObject paramJSONObject) {
    this.I = paramJSONObject.optInt("splash_check_type", 1);
    int i = this.I;
    return (i != 0 && i != 1) ? 1 : this.I;
  }
  
  private void t(String paramString) {
    if (paramString == null)
      return; 
    try {
      int i;
      JSONArray jSONArray = new JSONArray(paramString);
      int j = jSONArray.length();
      return;
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  private a u(String paramString) {
    boolean bool = this.g.contains(paramString);
    return a.a().a(paramString).n(1).o(bool ^ true).p(2).q(1).r(1).s(100).t(0).v(1).m(3).l(-1).j(-1).i(2).k(-1).w(1).e(-1).a(-1).d(20).a((JSONArray)null);
  }
  
  public int A() {
    return this.p;
  }
  
  public String B() {
    return this.q;
  }
  
  public int C() {
    return this.t;
  }
  
  public int D() {
    return this.u;
  }
  
  public int E() {
    return this.v;
  }
  
  public boolean F() {
    return (this.w == 1);
  }
  
  public boolean G() {
    return (this.x == 1);
  }
  
  public int H() {
    return this.y;
  }
  
  public int I() {
    return this.z;
  }
  
  public int J() {
    return this.a;
  }
  
  public int K() {
    return this.b;
  }
  
  public int L() {
    return this.c;
  }
  
  public boolean M() {
    return (this.A == 1);
  }
  
  public List<String> N() {
    if (this.K + 172800000L < System.currentTimeMillis())
      return null; 
    ArrayList<String> arrayList = new ArrayList();
    Iterator<String> iterator = this.L.iterator();
    while (iterator.hasNext())
      arrayList.add(iterator.next()); 
    return arrayList;
  }
  
  public List<String> O() {
    if (this.K + 172800000L < System.currentTimeMillis())
      return null; 
    ArrayList<String> arrayList = new ArrayList();
    Iterator<String> iterator = this.M.iterator();
    while (iterator.hasNext())
      arrayList.add(iterator.next()); 
    return arrayList;
  }
  
  public boolean P() {
    return (this.J == 1);
  }
  
  public int Q() {
    return this.W;
  }
  
  public int R() {
    if (this.X <= 0)
      this.X = 3000; 
    return this.X;
  }
  
  public int S() {
    return this.S;
  }
  
  public List<g> T() {
    return this.j;
  }
  
  public int a(String paramString, boolean paramBoolean) {
    if (paramString == null)
      return a(paramBoolean); 
    a a = o.h().r(String.valueOf(paramString));
    return (a.v != -1) ? a.v : a(paramBoolean);
  }
  
  public void a() {
    boolean bool = b.b();
    int j = 0;
    int i = 0;
    if (bool) {
      this.U = a.b("tt_sdk_settings", "url_ads", "pangolin.snssdk.com");
      this.V = a.b("tt_sdk_settings", "url_alog", "extlog.snssdk.com/service/2/app_log/");
      this.k = a.b("tt_sdk_settings", "xpath", "");
      this.P = a.a("tt_sdk_settings", "duration", 10000L);
      this.Q = a.a("tt_sdk_settings", "max", 50);
      this.l = a.a("tt_sdk_settings", "download_config_back_dialog", 1);
      this.m = a.a("tt_sdk_settings", "download_config_progressbar", 0);
      this.n = a.a("tt_sdk_settings", "download_config_hook", 1);
      this.o = a.b("tt_sdk_settings", "download_config_hook_oppo_arg1", "com.oppo.market");
      this.p = a.a("tt_sdk_settings", "download_config_hook_oppo_arg4", 0);
      this.q = a.b("tt_sdk_settings", "download_config_hook_huawei_arg1", "com.huawei.appmarket");
      this.r = a.a("tt_sdk_settings", "download_config_dl_network", 1);
      this.s = a.a("tt_sdk_settings", "download_config_dl_size", 30);
      this.t = a.a("tt_sdk_settings", "download_config_enable_install_again", 1);
      this.u = a.a("tt_sdk_settings", "download_config_install_again_time", 30);
      this.v = a.a("tt_sdk_settings", "download_config_install_again_time_next", 10);
      this.w = a.a("tt_sdk_settings", "download_config_storage_internal", 1);
      this.x = a.a("tt_sdk_settings", "download_config_resume_notify_switch", 0);
      this.y = a.a("tt_sdk_settings", "download_config_resume_notify_time", 5);
      this.z = a.a("tt_sdk_settings", "download_config_resume_notify_count", 2);
      this.A = a.a("tt_sdk_settings", "download_config_if_open_market_window", 1);
      this.R = a.a("tt_sdk_settings", "pos_cache_time", 30);
      this.S = a.a("tt_sdk_settings", "vbtt", 5);
      this.T = a.a("tt_sdk_settings", "fetch_template", 3600);
      this.h = a.b("tt_sdk_settings", "template_ids", null);
      this.B = a.b("tt_sdk_settings", "ab_test_version", null);
      this.C = a.b("tt_sdk_settings", "ab_test_param", null);
      this.D = a.a("tt_sdk_settings", "web_info_wifi_enable", 1);
      this.E = a.a("tt_sdk_settings", "web_info_page_count", 5);
      this.F = a.b("tt_sdk_settings", "pyload_h5", null);
      this.G = a.b("tt_sdk_settings", "playableLoadH5Url", null);
      this.H = a.a("tt_sdk_settings", "splash_load_type", 1);
      this.I = a.a("tt_sdk_settings", "splash_check_type", 1);
      this.N = a.a("tt_sdk_settings", "if_both_open", 0);
      this.O = a.a("tt_sdk_settings", "support_tnc", 1);
      this.f = a.b("tt_sdk_settings", "tpl_infos", null);
      this.J = a.a("tt_sdk_settings", "app_list_control", 0);
      this.W = a.a("tt_sdk_settings", "max_tpl_cnts", 100);
      V();
      this.X = a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", 3000);
      this.K = a.a("tt_sdk_settings", "hit_app_list_time", 0L);
      this.L.clear();
      this.a = a.a("tt_sdk_settings", "sp_ov_skip_key", 0);
      this.b = a.a("tt_sdk_settings", "download_xiaomi_silence_install", 0);
      this.c = a.a("tt_sdk_settings", "download_exp_switch_temp", 1023409663);
      Set set1 = a.b("tt_sdk_settings", "hit_app_list_data", null);
      if (set1 != null && !set1.isEmpty())
        for (String str2 : set1)
          this.L.add(str2);  
      this.M.clear();
      set1 = a.b("tt_sdk_settings", "scheme_list_data", null);
      if (set1 != null && !set1.isEmpty())
        for (String str2 : set1)
          this.M.add(str2);  
      t(a.b("tt_sdk_settings", "push_config", null));
      U();
      W();
      String str1 = a.b("tt_sdk_settings", "ad_slot_conf", null);
      if (!TextUtils.isEmpty(str1))
        try {
          JSONArray jSONArray = new JSONArray(str1);
          j = jSONArray.length();
          if (j > 0) {
            this.d.clear();
            while (i < j) {
              a a = b(jSONArray.optJSONObject(i));
              if (a != null)
                this.d.put(a.a, a); 
              i++;
            } 
          } 
        } catch (Exception exception) {} 
      d.c();
      return;
    } 
    ad ad = X();
    this.U = ad.b("url_ads", "pangolin.snssdk.com");
    this.V = ad.b("url_alog", "extlog.snssdk.com/service/2/app_log/");
    this.k = ad.b("xpath", "");
    this.P = ad.b("duration", 10000L);
    this.Q = ad.b("max", 50);
    this.l = ad.b("download_config_back_dialog", 1);
    this.m = ad.b("download_config_progressbar", 0);
    this.n = ad.b("download_config_hook", 1);
    this.o = ad.b("download_config_hook_oppo_arg1", "com.oppo.market");
    this.p = ad.b("download_config_hook_oppo_arg4", 0);
    this.q = ad.b("download_config_hook_huawei_arg1", "com.huawei.appmarket");
    this.r = ad.b("download_config_dl_network", 1);
    this.s = ad.b("download_config_dl_size", 30);
    this.t = ad.b("download_config_enable_install_again", 1);
    this.u = ad.b("download_config_install_again_time", 30);
    this.v = ad.b("download_config_install_again_time_next", 10);
    this.w = ad.b("download_config_storage_internal", 1);
    this.x = ad.b("download_config_resume_notify_switch", 0);
    this.z = ad.b("download_config_resume_notify_count", 2);
    this.A = ad.b("download_config_if_open_market_window", 1);
    this.y = ad.b("download_config_resume_notify_time", 5);
    this.R = ad.b("pos_cache_time", 30);
    this.T = ad.b("fetch_template", 3600);
    this.B = ad.a("ab_test_version");
    this.C = ad.a("ab_test_param");
    this.S = ad.b("vbtt", 5);
    this.h = ad.b("template_ids", null);
    this.D = ad.b("web_info_wifi_enable", 1);
    this.E = ad.b("web_info_page_count", 5);
    this.F = ad.b("pyload_h5", null);
    this.G = ad.b("playableLoadH5Url", null);
    this.H = ad.b("splash_load_type", 1);
    this.I = ad.b("splash_check_type", 1);
    this.N = ad.b("if_both_open", 0);
    this.O = ad.b("support_tnc", 1);
    this.f = ad.b("tpl_infos", null);
    this.J = ad.b("app_list_control", 0);
    this.W = ad.b("max_tpl_cnts", 100);
    V();
    this.X = ad.b("fetch_tpl_timeout_ctrl", 3000);
    this.K = ad.b("hit_app_list_time", 0L);
    this.L.clear();
    this.a = ad.b("sp_ov_skip_key", 0);
    this.b = ad.b("download_xiaomi_silence_install", 0);
    this.c = ad.b("download_exp_switch_temp", 1023409663);
    Set set = ad.b("hit_app_list_data", null);
    if (set != null && !set.isEmpty())
      for (String str1 : set)
        this.L.add(str1);  
    this.M.clear();
    set = ad.b("scheme_list_data", null);
    if (set != null && !set.isEmpty())
      for (String str1 : set)
        this.M.add(str1);  
    t(ad.b("push_config", null));
    U();
    W();
    String str = ad.b("ad_slot_conf", null);
    if (!TextUtils.isEmpty(str))
      try {
        JSONArray jSONArray = new JSONArray(str);
        int k = jSONArray.length();
        if (k > 0) {
          this.d.clear();
          for (i = j; i < k; i++) {
            a a = b(jSONArray.optJSONObject(i));
            if (a != null)
              this.d.put(a.a, a); 
          } 
        } 
      } catch (Exception exception) {} 
    d.c();
  }
  
  public void a(JSONObject paramJSONObject) {
    a a;
    JSONObject jSONObject3 = paramJSONObject.optJSONObject("app_common_config");
    byte b = 0;
    if (jSONObject3 != null) {
      this.A = jSONObject3.optInt("if_open_market_window", 1);
      this.a = jSONObject3.optInt("skip_key", 0);
      this.b = jSONObject3.optInt("xiaomi_install", 0);
      this.c = jSONObject3.optInt("download_exp_switch_temp", 1023409663);
    } 
    this.U = paramJSONObject.optString("ads_url", "pangolin.snssdk.com");
    this.V = paramJSONObject.optString("app_log_url", "extlog.snssdk.com/service/2/app_log/");
    this.k = paramJSONObject.optString("xpath");
    this.R = paramJSONObject.optInt("pos_cache_time", 30);
    jSONObject3 = paramJSONObject.optJSONObject("feq_policy");
    if (jSONObject3 != null) {
      this.P = jSONObject3.optLong("duration") * 1000L;
      this.Q = jSONObject3.optInt("max");
    } 
    this.S = paramJSONObject.optInt("vbtt", 5);
    this.T = paramJSONObject.optInt("fetch_tpl_interval", 3600);
    a.c();
    jSONObject3 = paramJSONObject.optJSONObject("abtest");
    JSONArray jSONArray5 = null;
    if (jSONObject3 != null) {
      this.B = jSONObject3.optString("version");
      this.C = jSONObject3.optString("param");
    } else {
      this.C = null;
      this.B = null;
      if (b.b()) {
        a.a("tt_sdk_settings", "ab_test_version");
        a.a("tt_sdk_settings", "ab_test_param");
      } else {
        ad ad = X();
        ad.b("ab_test_version");
        ad.b("ab_test_param");
      } 
    } 
    jSONObject3 = paramJSONObject.optJSONObject("web_info");
    if (jSONObject3 != null) {
      this.D = jSONObject3.optInt("web_info_wifi_enable", 1);
      this.E = jSONObject3.optInt("web_info_page_count", 5);
    } 
    this.F = paramJSONObject.optString("pyload_h5");
    this.G = paramJSONObject.optString("pure_pyload_h5");
    this.H = d(paramJSONObject);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setting-》mSplashLoadType=");
    stringBuilder.append(this.H);
    t.e("splashLoad", stringBuilder.toString());
    this.I = e(paramJSONObject);
    stringBuilder = new StringBuilder();
    stringBuilder.append("setting-》mSplashCheckType=");
    stringBuilder.append(this.I);
    t.e("splashLoad", stringBuilder.toString());
    this.N = paramJSONObject.optInt("if_both_open", 0);
    this.O = paramJSONObject.optInt("support_tnc", 1);
    this.J = paramJSONObject.optInt("al", 0);
    this.W = paramJSONObject.optInt("max_tpl_cnts", 100);
    V();
    JSONObject jSONObject2 = paramJSONObject.optJSONObject("app_common_config");
    if (jSONObject2 != null)
      this.X = jSONObject2.optInt("fetch_tpl_timeout_ctrl", 3000); 
    this.K = System.currentTimeMillis();
    this.L.clear();
    JSONArray jSONArray3 = paramJSONObject.optJSONArray("spam_app_list");
    if (jSONArray3 != null) {
      int j = jSONArray3.length();
      for (int i = 0; i < j; i++) {
        jSONArray4 = (JSONArray)jSONArray3.optString(i);
        if (!TextUtils.isEmpty((CharSequence)jSONArray4))
          this.L.add((String)jSONArray4); 
      } 
    } 
    this.M.clear();
    jSONArray3 = paramJSONObject.optJSONArray("scheme_check_list");
    if (jSONArray3 != null) {
      int j = jSONArray3.length();
      for (int i = 0; i < j; i++) {
        jSONArray4 = (JSONArray)jSONArray3.optString(i);
        if (!TextUtils.isEmpty((CharSequence)jSONArray4))
          this.M.add((String)jSONArray4); 
      } 
    } 
    JSONObject jSONObject1 = paramJSONObject.optJSONObject("download_config");
    if (jSONObject1 != null) {
      this.l = jSONObject1.optInt("is_enable_back_dialog", 1);
      this.m = jSONObject1.optInt("landing_page_progressbar_visible", 0);
      this.n = jSONObject1.optInt("hook", 1);
      this.o = jSONObject1.optString("hook_oppo_arg1", "com.oppo.market");
      this.p = jSONObject1.optInt("hook_oppo_arg4", 0);
      this.q = jSONObject1.optString("hook_huawei_arg1", "com.huawei.appmarket");
      this.r = jSONObject1.optInt("dl_network", 1);
      this.s = jSONObject1.optInt("dl_size", 30);
      this.t = jSONObject1.optInt("is_enable_start_install_again", 1);
      this.u = jSONObject1.optInt("start_install_time", 30);
      this.v = jSONObject1.optInt("next_install_min_time", 10);
      this.w = jSONObject1.optInt("if_storage_internal", 1);
      this.x = jSONObject1.optInt("if_tips", 0);
      this.y = jSONObject1.optInt("min_failed_time", 5);
      this.z = jSONObject1.optInt("max_failes_count", 2);
    } 
    JSONArray jSONArray2 = paramJSONObject.optJSONArray("tpl_ids");
    if (jSONArray2 != null) {
      this.h = jSONArray2.toString();
      U();
    } 
    try {
      JSONArray jSONArray = paramJSONObject.optJSONArray("push_config");
    } finally {
      jSONArray2 = null;
    } 
    jSONArray2.printStackTrace();
    jSONArray2 = jSONArray4;
    JSONArray jSONArray6 = paramJSONObject.optJSONArray("ad_slot_conf_list");
    JSONArray jSONArray4 = jSONArray5;
    if (jSONArray6 != null) {
      String str2 = jSONArray6.toString();
      int i = jSONArray6.length();
      String str1 = str2;
      if (i > 0) {
        this.d.clear();
        int j = 0;
        while (true) {
          str1 = str2;
          if (j < i) {
            a = b(jSONArray6.optJSONObject(j));
            if (a != null)
              this.d.put(a.a, a); 
            j++;
            continue;
          } 
          break;
        } 
      } 
    } 
    JSONArray jSONArray1 = paramJSONObject.optJSONArray("tpl_infos");
    if (jSONArray1 != null) {
      this.f = jSONArray1.toString();
      int i = jSONArray1.length();
      if (i > 0) {
        this.e.clear();
        for (int j = b; j < i; j++) {
          m m = c(jSONArray1.optJSONObject(j));
          if (m != null) {
            this.e.put(m.a, m);
            a(m);
          } 
        } 
      } 
    } 
    d.c();
    a((String)a, (String)jSONArray2);
  }
  
  public boolean a(int paramInt) {
    return ((r(String.valueOf(paramInt))).c == 1);
  }
  
  public boolean a(String paramString) {
    int i = (o.h().r(String.valueOf(paramString))).e;
    if (i != 1) {
      if (i != 2) {
        if (i != 3);
        return false;
      } 
      return (w.c(o.a()) != 0);
    } 
    return w.d(o.a());
  }
  
  public String b() {
    return TextUtils.isEmpty(this.U) ? "pangolin.snssdk.com" : this.U;
  }
  
  public boolean b(int paramInt) {
    boolean bool = false;
    if (paramInt == 0)
      return false; 
    if ((o.h().r(String.valueOf(paramInt))).o == 1)
      bool = true; 
    return bool;
  }
  
  public boolean b(String paramString) {
    return ((r(String.valueOf(paramString))).h == 1);
  }
  
  public int c(int paramInt) {
    return (r(String.valueOf(paramInt))).b;
  }
  
  public int c(String paramString) {
    return (r(String.valueOf(paramString))).t;
  }
  
  public String c() {
    return TextUtils.isEmpty(this.V) ? "extlog.snssdk.com/service/2/app_log/" : this.V;
  }
  
  public int d(int paramInt) {
    return (r(String.valueOf(paramInt))).j;
  }
  
  public boolean d() {
    return (this.N == 1);
  }
  
  public boolean d(String paramString) {
    return (paramString == null) ? true : (((o.h().r(String.valueOf(paramString))).p == 1));
  }
  
  public boolean e() {
    return (this.O == 1);
  }
  
  public boolean e(String paramString) {
    return (paramString == null) ? true : (((o.h().r(String.valueOf(paramString))).q == 0));
  }
  
  public int f() {
    return this.r;
  }
  
  public int f(String paramString) {
    return (paramString == null) ? 1500 : (o.h().r(String.valueOf(paramString))).r;
  }
  
  public int g() {
    return this.s * 1024 * 1024;
  }
  
  public int g(String paramString) {
    return (o.h().r(String.valueOf(paramString))).l;
  }
  
  public String h() {
    return this.B;
  }
  
  public JSONArray h(String paramString) {
    try {
      a a = o.h().r(String.valueOf(paramString));
      if (a != null) {
        if (a.y == null)
          return null; 
        JSONArray jSONArray = new JSONArray();
        Iterator<String> iterator = a.y.iterator();
        while (iterator.hasNext()) {
          p p = a.a(iterator.next());
          if (p != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", p.b());
            jSONObject.put("md5", p.c());
            jSONArray.put(jSONObject);
          } 
        } 
        return jSONArray;
      } 
      return null;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String i() {
    return this.C;
  }
  
  public boolean i(String paramString) {
    try {
      a a = o.h().r(String.valueOf(paramString));
      if (a != null) {
        List<String> list = a.y;
        if (list != null)
          return true; 
      } 
    } catch (Exception exception) {}
    return false;
  }
  
  public int j(String paramString) {
    return (r(String.valueOf(paramString))).i;
  }
  
  public String j() {
    return this.k;
  }
  
  public int k(String paramString) {
    return (r(paramString)).k;
  }
  
  public long k() {
    return this.P;
  }
  
  public int l() {
    return this.Q;
  }
  
  public int l(String paramString) {
    return (paramString == null) ? -1 : (o.h().r(String.valueOf(paramString))).m;
  }
  
  public int m() {
    return this.R;
  }
  
  public boolean m(String paramString) {
    return (paramString == null) ? true : (((o.h().r(String.valueOf(paramString))).w != 1));
  }
  
  public int n() {
    return this.T;
  }
  
  public boolean n(String paramString) {
    return ((r(String.valueOf(paramString))).x == 0);
  }
  
  public int o() {
    return this.E;
  }
  
  public int o(String paramString) {
    return (paramString == null) ? 20 : (o.h().r(String.valueOf(paramString))).u;
  }
  
  public int p(String paramString) {
    return (paramString == null) ? -1 : (o.h().r(String.valueOf(paramString))).n;
  }
  
  public String p() {
    return this.F;
  }
  
  public String q() {
    return this.G;
  }
  
  public boolean q(String paramString) {
    return (paramString == null) ? true : (((o.h().r(String.valueOf(paramString))).f == 1));
  }
  
  public int r() {
    return this.H;
  }
  
  public a r(String paramString) {
    a a2 = this.d.get(paramString);
    a a1 = a2;
    if (a2 == null)
      a1 = u(paramString); 
    return a1;
  }
  
  public int s() {
    return this.I;
  }
  
  public void s(String paramString) {
    this.g.add(paramString);
  }
  
  public boolean t() {
    return (r() != 0);
  }
  
  public boolean u() {
    return (s() == 1);
  }
  
  public boolean v() {
    return (this.D == 1);
  }
  
  public boolean w() {
    return (this.l == 1);
  }
  
  public boolean x() {
    return (this.m == 1);
  }
  
  public boolean y() {
    return (this.n == 1);
  }
  
  public String z() {
    return this.o;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */