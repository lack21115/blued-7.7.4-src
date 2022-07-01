package com.bytedance.embedapplog.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.embedapplog.InitConfig;
import com.bytedance.embedapplog.d.a;
import com.bytedance.embedapplog.util.g;
import com.bytedance.embedapplog.util.i;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {
  private final Context a;
  
  private final InitConfig b;
  
  private final SharedPreferences c;
  
  private final SharedPreferences d;
  
  private final SharedPreferences e;
  
  private volatile JSONObject f;
  
  private volatile JSONObject g;
  
  private volatile HashSet<Integer> h;
  
  public h(Context paramContext, InitConfig paramInitConfig) {
    this.a = paramContext;
    this.b = paramInitConfig;
    this.e = this.a.getSharedPreferences("embed_applog_stats", 0);
    this.c = this.a.getSharedPreferences("embed_header_custom", 0);
    this.d = this.a.getSharedPreferences("embed_last_sp_session", 0);
  }
  
  public long A() {
    return this.e.getLong("session_interval", 30000L);
  }
  
  public long B() {
    return this.e.getLong("batch_event_interval", 30000L);
  }
  
  String C() {
    return null;
  }
  
  String D() {
    return this.b.getReleaseBuild();
  }
  
  String E() {
    return this.e.getString("user_agent", null);
  }
  
  public long F() {
    return 10000L;
  }
  
  public String G() {
    return this.b.getAppName();
  }
  
  public int H() {
    return this.b.getVersionCode();
  }
  
  public int I() {
    return this.b.getUpdateVersionCode();
  }
  
  public int J() {
    return this.b.getManifestVersionCode();
  }
  
  public String K() {
    return this.b.getVersion();
  }
  
  public String L() {
    return this.b.getTweakedChannel();
  }
  
  public String M() {
    return this.b.getAbClient();
  }
  
  public String N() {
    return this.b.getAbGroup();
  }
  
  public String O() {
    return this.b.getAbFeature();
  }
  
  public String P() {
    return this.b.getVersionMinor();
  }
  
  public String Q() {
    return (this.b.getAppImei() == null) ? "" : this.b.getAppImei();
  }
  
  public boolean R() {
    return this.b.isImeiEnable();
  }
  
  public InitConfig S() {
    return this.b;
  }
  
  public CharSequence T() {
    return this.b.getZiJieCloudPkg();
  }
  
  String a() {
    return this.b.getAliyunUdid();
  }
  
  public void a(long paramLong) {}
  
  void a(String paramString) {
    this.c.edit().putString("ab_sdk_version", paramString).apply();
  }
  
  public void a(String paramString, int paramInt) {
    this.d.edit().putString("session_last_day", paramString).putInt("session_order", paramInt).apply();
  }
  
  public void a(HashSet<String> paramHashSet1, HashSet<String> paramHashSet2) {}
  
  void a(JSONObject paramJSONObject) {
    String str;
    SharedPreferences.Editor editor = this.c.edit();
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    } else {
      str = "";
    } 
    editor.putString("header_custom_info", str).apply();
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean, String paramString) {
    if (com.bytedance.embedapplog.util.h.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setConfig, ");
      stringBuilder.append(paramJSONObject.toString());
      com.bytedance.embedapplog.util.h.a(stringBuilder.toString(), null);
    } 
    this.g = paramJSONObject;
    long l1 = System.currentTimeMillis();
    SharedPreferences.Editor editor = this.e.edit();
    long l2 = paramJSONObject.optInt("session_interval", 0);
    if (l2 > 0L && l2 <= 604800L) {
      editor.putLong("session_interval", l2 * 1000L);
    } else {
      editor.remove("session_interval");
    } 
    l2 = paramJSONObject.optInt("batch_event_interval", 0);
    if (l2 > 0L && l2 <= 604800L) {
      editor.putLong("batch_event_interval", l2 * 1000L);
    } else {
      editor.remove("batch_event_interval");
    } 
    int i = paramJSONObject.optInt("send_launch_timely", 0);
    if (i > 0 && i <= 604800L) {
      editor.putInt("send_launch_timely", i);
    } else {
      editor.remove("send_launch_timely");
    } 
    l2 = paramJSONObject.optInt("abtest_fetch_interval", 0);
    if (l2 > 20L && l2 <= 604800L) {
      editor.putLong("abtest_fetch_interval", l2 * 1000L);
    } else {
      editor.remove("abtest_fetch_interval");
    } 
    boolean bool = paramJSONObject.optBoolean("bav_log_collect", true);
    if (bool) {
      editor.putBoolean("bav_log_collect", true);
    } else {
      editor.remove("bav_log_collect");
    } 
    com.bytedance.embedapplog.util.h.a = bool;
    if (paramJSONObject.optBoolean("bav_ab_config", false)) {
      editor.putBoolean("bav_ab_config", true);
    } else {
      editor.remove("bav_ab_config");
    } 
    JSONArray jSONArray = paramJSONObject.optJSONArray("fingerprint_codes");
    if (jSONArray != null && jSONArray.length() > 0) {
      editor.putString("fingerprint_codes", jSONArray.toString());
    } else {
      editor.remove("fingerprint_codes");
    } 
    this.h = null;
    i = paramJSONObject.optInt("bav_monitor_rate", 0);
    if (i > 0 && i <= 100) {
      editor.putInt("bav_monitor_rate", i);
      g.a(true);
    } else {
      editor.remove("bav_monitor_rate");
      g.a(false);
    } 
    if (paramBoolean)
      editor.putLong("send_fingerprint_time", l1); 
    if (!TextUtils.isEmpty(paramString)) {
      editor.putString("last_wifi_bssid", paramString);
      editor.putLong("last_check_bssid_time", l1);
    } 
    editor.putLong("app_log_last_config_time", l1);
    editor.apply();
  }
  
  public boolean a(ArrayList<a> paramArrayList) {
    return true;
  }
  
  public String b() {
    return this.d.getString("session_last_day", "");
  }
  
  void b(String paramString) {
    this.c.edit().putString("user_unique_id", paramString).apply();
  }
  
  void b(JSONObject paramJSONObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAbConfig, ");
    stringBuilder.append(paramJSONObject.toString());
    com.bytedance.embedapplog.util.h.a(stringBuilder.toString(), null);
    this.c.edit().putString("ab_configure", paramJSONObject.toString()).apply();
    this.f = null;
  }
  
  public int c() {
    return this.d.getInt("session_order", 0);
  }
  
  public JSONObject c(String paramString) {
    return x().optJSONObject(paramString);
  }
  
  public SharedPreferences d() {
    return this.e;
  }
  
  void d(String paramString) {
    this.e.edit().putString("user_agent", paramString).apply();
  }
  
  public void e(String paramString) {
    this.c.edit().putString("ab_version", paramString).apply();
  }
  
  public boolean e() {
    return this.b.isPlayEnable();
  }
  
  public JSONObject f() {
    return this.g;
  }
  
  public long g() {
    return this.e.getLong("app_log_last_config_time", 0L);
  }
  
  public HashSet<Integer> h() {
    HashSet<Integer> hashSet2 = this.h;
    HashSet<Integer> hashSet1 = hashSet2;
    if (hashSet2 == null) {
      try {
        int i;
        JSONArray jSONArray = new JSONArray(this.e.getString("fingerprint_codes", "[]"));
        int j = jSONArray.length();
      } finally {
        hashSet1 = null;
        com.bytedance.embedapplog.util.h.a((Throwable)hashSet1);
      } 
      this.h = hashSet1;
    } 
    return hashSet1;
  }
  
  public Long i() {
    return (h().size() > 0) ? Long.valueOf(this.e.getLong("send_fingerprint_time", 0L)) : null;
  }
  
  public String j() {
    return this.e.getString("last_wifi_bssid", null);
  }
  
  public Long k() {
    return h().contains(Integer.valueOf(6)) ? Long.valueOf(this.e.getLong("last_check_bssid_time", 0L)) : null;
  }
  
  public int l() {
    return this.e.getInt("bav_monitor_rate", 0);
  }
  
  public String m() {
    return this.b.getAid();
  }
  
  String n() {
    return this.b.getChannel();
  }
  
  String o() {
    return this.b.getGoogleAid();
  }
  
  String p() {
    return this.b.getLanguage();
  }
  
  String q() {
    return this.b.getRegion();
  }
  
  String r() {
    return this.c.getString("header_custom_info", null);
  }
  
  String s() {
    return this.c.getString("ab_sdk_version", "");
  }
  
  String t() {
    return this.c.getString("user_unique_id", null);
  }
  
  public boolean u() {
    if (this.b.getProcess() == 0)
      this.b.setProcess(i.a(this.a).contains(":") ^ true); 
    return (this.b.getProcess() == 1);
  }
  
  public long v() {
    return this.e.getLong("abtest_fetch_interval", 0L);
  }
  
  public String w() {
    return !TextUtils.isEmpty(this.b.getAbVersion()) ? this.b.getAbVersion() : this.c.getString("ab_version", null);
  }
  
  public JSONObject x() {
    // Byte code:
    //   0: aload_0
    //   1: getfield f : Lorg/json/JSONObject;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull -> 76
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_2
    //   12: astore_1
    //   13: aload_0
    //   14: invokevirtual y : ()Z
    //   17: ifeq -> 49
    //   20: new org/json/JSONObject
    //   23: dup
    //   24: aload_0
    //   25: getfield c : Landroid/content/SharedPreferences;
    //   28: ldc_w 'ab_configure'
    //   31: ldc ''
    //   33: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: astore_1
    //   42: goto -> 49
    //   45: astore_1
    //   46: goto -> 72
    //   49: aload_1
    //   50: astore_2
    //   51: aload_1
    //   52: ifnonnull -> 63
    //   55: new org/json/JSONObject
    //   58: dup
    //   59: invokespecial <init> : ()V
    //   62: astore_2
    //   63: aload_0
    //   64: aload_2
    //   65: putfield f : Lorg/json/JSONObject;
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: areturn
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: aload_2
    //   77: areturn
    //   78: astore_1
    //   79: aload_2
    //   80: astore_1
    //   81: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   13	42	78	org/json/JSONException
    //   13	42	45	finally
    //   55	63	45	finally
    //   63	70	45	finally
    //   72	74	45	finally
  }
  
  public boolean y() {
    return this.e.getBoolean("bav_ab_config", false);
  }
  
  public boolean z() {
    return this.e.getBoolean("bav_log_collect", false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */