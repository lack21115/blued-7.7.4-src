package com.soft.blued.http;

import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.EncryptTool;
import com.soft.blued.utils.BluedPreferences;
import java.net.URLEncoder;

public class BluedHttpUrl {
  public static final String a = k;
  
  private static String b = "https://argo.blued.cn";
  
  private static String c = "https://pay.blued.cn";
  
  private static String d = "https://sdk.blued.cn";
  
  private static String e = "https://health.blued.cn";
  
  private static String f = "h4.blued.cn";
  
  private static int g = 443;
  
  private static int h = 8080;
  
  private static String i = "blued.irisdt.cn";
  
  private static String j = "https://i.blued.cn";
  
  private static String k = "https://m.blued.cn";
  
  private static String l = "live-im.blued.cn";
  
  private static String m = "h8.blued.cn";
  
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(m());
    stringBuilder.append("/login");
    return stringBuilder.toString();
  }
  
  public static String a(int paramInt) {
    return H5Url.a(18, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3) {
    return H5Url.a(36, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public static String a(String paramString) {
    return H5Url.a(15, new Object[] { EncryptTool.b(paramString) });
  }
  
  public static String a(String paramString, int paramInt) {
    String str;
    try {
      paramString = AesCrypto.a(paramString);
    } catch (Exception exception) {
      str = "";
    } 
    return H5Url.a(19, new Object[] { Integer.valueOf(paramInt), str });
  }
  
  public static String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(k());
    stringBuilder.append("/forgot/input.html?type=");
    stringBuilder.append(1);
    return stringBuilder.toString();
  }
  
  public static String b(String paramString) {
    return H5Url.a(16, new Object[] { EncryptTool.b(paramString) });
  }
  
  public static void b(int paramInt) {
    g = paramInt;
    u();
  }
  
  public static String c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(k());
    stringBuilder.append("/forgot/input.html?type=");
    stringBuilder.append(2);
    return stringBuilder.toString();
  }
  
  public static String c(String paramString) {
    return H5Url.a(24, new Object[] { EncryptTool.b(paramString) });
  }
  
  public static void c(int paramInt) {
    h = paramInt;
    u();
  }
  
  public static String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(k());
    stringBuilder.append("/forgot/input.html?type=2&safe_email=1");
    return stringBuilder.toString();
  }
  
  public static String d(String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l());
      stringBuilder.append("/blued/medicine/yzshare?youzan=");
      stringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      return stringBuilder.toString();
    } catch (Exception exception) {
      return paramString;
    } 
  }
  
  public static String e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(k);
    stringBuilder.append("/msg/del_groupblocked.html");
    return stringBuilder.toString();
  }
  
  public static void e(String paramString) {
    k = paramString;
    u();
  }
  
  public static String f() {
    return "https://m.blued.cn/security.html";
  }
  
  public static void f(String paramString) {
    e = paramString;
    u();
  }
  
  public static String g() {
    return "http://native.blued.cn?action=vip_center_local&tab=0&detail=mine_vip_center";
  }
  
  public static void g(String paramString) {
    j = paramString;
    u();
  }
  
  public static void h(String paramString) {
    b = paramString;
    u();
  }
  
  public static boolean h() {
    return b.equals("https://argo.blued.cn");
  }
  
  public static void i() {
    h("http://106.75.100.161");
    i("https://pay-test.blued.cn");
    j("https://sdk-test.blued.cn");
    k("106.75.109.100");
    b(8080);
    c(8080);
    f("https://healthtest.blued.cn");
    l("blued-test.irisdt.cn");
    g("http://test.i.blued.cn");
    e("http://m-test.blued.cn");
    m("live-im-test.blued.cn");
    n("im-test.irisgw.cn");
  }
  
  public static void i(String paramString) {
    c = paramString;
    u();
  }
  
  public static void j() {
    h("https://argo.blued.cn");
    i("https://pay.blued.cn");
    j("https://sdk.blued.cn");
    k("h4.blued.cn");
    b(443);
    c(8080);
    f("https://health.blued.cn");
    l("blued.irisdt.cn");
    g("https://i.blued.cn");
    e("https://m.blued.cn");
    m("live-im.blued.cn");
    n("h8.blued.cn");
  }
  
  public static void j(String paramString) {
    d = paramString;
    u();
  }
  
  public static String k() {
    return k;
  }
  
  public static void k(String paramString) {
    f = paramString;
    u();
  }
  
  public static String l() {
    return e;
  }
  
  public static void l(String paramString) {
    i = paramString;
    u();
  }
  
  public static String m() {
    return j;
  }
  
  public static void m(String paramString) {
    l = paramString;
    u();
  }
  
  public static String n() {
    return b;
  }
  
  public static void n(String paramString) {
    m = paramString;
    u();
  }
  
  public static String o() {
    return c;
  }
  
  public static String p() {
    return d;
  }
  
  public static String q() {
    return f;
  }
  
  public static int r() {
    return g;
  }
  
  public static int s() {
    return h;
  }
  
  public static String t() {
    return i;
  }
  
  public static void u() {
    BluedPreferences.K(b);
    BluedPreferences.L(c);
    BluedPreferences.M(d);
    BluedPreferences.N(f);
    BluedPreferences.i(g);
    BluedPreferences.j(h);
    BluedPreferences.O(e);
    BluedPreferences.P(i);
    BluedPreferences.Q(j);
    BluedPreferences.R(k);
    BluedPreferences.S(l);
    BluedPreferences.T(m);
  }
  
  public static String v() {
    return m;
  }
  
  public static String w() {
    return l;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\BluedHttpUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */