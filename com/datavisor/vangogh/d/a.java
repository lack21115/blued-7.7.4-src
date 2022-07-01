package com.datavisor.vangogh.d;

import android.content.Context;
import com.datavisor.vangogh.a.b;
import com.datavisor.vangogh.a.c;
import com.datavisor.vangogh.a.d;
import com.datavisor.vangogh.a.e;
import com.datavisor.vangogh.b.b;
import com.datavisor.vangogh.b.c;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.f.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
  public static int a;
  
  private static Map<String, String> b = new TreeMap<String, String>();
  
  private static long c = 0L;
  
  static {
    a = 0;
  }
  
  public static Map<String, String> a(Context paramContext) {
    long l1 = System.currentTimeMillis();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("d8", b.a().c());
    hashMap.put("d17", b.a().o(paramContext));
    hashMap.put("d18", b.a().p(paramContext));
    hashMap.put("d19", b.a().s(paramContext));
    hashMap.put("d20", b.a().q());
    hashMap.put("d24", b.a().t(paramContext));
    hashMap.put("d26", b.a().s());
    hashMap.put("d27", b.a().t());
    hashMap.put("d28", b.a().u(paramContext));
    hashMap.put("d29", b.a().v(paramContext));
    hashMap.put("d30", b.a().y(paramContext));
    hashMap.put("d33", b.a().C(paramContext));
    hashMap.put("d35", b.a().B(paramContext));
    hashMap.put("d36", b.a().A(paramContext));
    hashMap.put("d38", b.a().u());
    hashMap.put("d39", b.a().P(paramContext));
    hashMap.put("d40", b.a().Q(paramContext));
    hashMap.put("d54", b.a().G(paramContext));
    hashMap.put("d61", b.a().J(paramContext));
    hashMap.put("d73", b.a().f(paramContext));
    hashMap.put("d74", b.a().g(paramContext));
    hashMap.put("d76", b.a().q(paramContext));
    hashMap.put("d83", b.a().j());
    hashMap.put("d84", b.a().k());
    hashMap.put("d85", b.a().l());
    hashMap.put("d86", b.a().m());
    hashMap.put("d87", b.a().n());
    hashMap.put("d88", b.a().j(paramContext));
    hashMap.put("d91", b.a().r(paramContext));
    hashMap.put("d92", b.a().S(paramContext));
    hashMap.put("n1", c.a().b(paramContext));
    hashMap.put("n2", c.a().d(paramContext));
    hashMap.put("n3", c.a().c(paramContext));
    hashMap.put("n4", c.a().e(paramContext));
    hashMap.put("n9", c.a().f(paramContext));
    hashMap.put("n10", c.a().b());
    hashMap.put("n11", c.a().d());
    hashMap.put("n12", c.a().c());
    hashMap.put("c6", e.a(paramContext).a());
    hashMap.put("v1", e.a(paramContext).a(crypto.convert("H6i37Q==")));
    hashMap.put("v2", e.a(paramContext).a(crypto.convert("H6iqxnPZqQ==")));
    hashMap.put("v4", b.a().m(paramContext));
    hashMap.put("v6", b.a().n(paramContext));
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((e.a(paramContext)).a);
    stringBuilder2.append("");
    hashMap.put("v7", stringBuilder2.toString());
    a(paramContext, (Map)hashMap);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(a);
    stringBuilder1.append("");
    hashMap.put("v5", stringBuilder1.toString());
    long l2 = System.currentTimeMillis();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(c);
    stringBuilder1.append("");
    hashMap.put("d79", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(l2 - l1);
    stringBuilder1.append("");
    hashMap.put("d80", stringBuilder1.toString());
    return (Map)hashMap;
  }
  
  public static Map<String, String> a(Context paramContext, String paramString) {
    if (!com.datavisor.vangogh.f.a.a(b))
      return b; 
    long l = System.currentTimeMillis();
    b.put("d1", b.a().a(paramContext));
    b.put("d2", b.a().b(paramContext));
    b.put("d3", b.a().c(paramContext));
    b.put("d4", b.a().d(paramContext));
    b.put("d5", b.a().h(paramContext));
    b.put("d6", b.a().i(paramContext));
    b.put("d7", b.a().b());
    b.put("d9", b.a().d());
    b.put("d12", b.a().i(paramContext));
    b.put("d13", b.a().e());
    b.put("d14", b.a().f());
    b.put("d15", "Android");
    b.put("d16", b.a().g());
    b.put("d25", b.a().r());
    b.put("d34", b.a().i());
    b.put("d41", b.a().h());
    b.put("d42", b.a().o());
    b.put("d43", b.a().p());
    b.put("d46", b.a().D(paramContext));
    b.put("d47", b.a().v());
    b.put("d48", b.a().w());
    b.put("d49", b.a().x());
    b.put("d50", b.a().y());
    b.put("d51", b.a().E(paramContext));
    b.put("d52", b.a().F(paramContext));
    b.put("d58", b.a().z());
    b.put("d59", b.a().H(paramContext));
    b.put("d60", b.a().I(paramContext));
    b.put("d62", b.a().K(paramContext));
    b.put("d63", b.a().L(paramContext));
    b.put("d64", b.a().M(paramContext));
    b.put("d65", b.a().N(paramContext));
    b.put("d66", b.a().O(paramContext));
    b.put("d68", b.a().R(paramContext));
    b.put("d78", b.a().k(paramContext));
    b.put("d90", b.a().l(paramContext));
    b.put("d71", b.a().e(paramContext));
    b.put("d72", b.a().c(paramContext, "wlan0"));
    b.put("d75", b.a().c(paramContext, "wlan1"));
    b.put("a1", com.datavisor.vangogh.b.a.a().c(paramContext));
    b.put("a2", com.datavisor.vangogh.b.a.a().d(paramContext));
    b.put("a3", com.datavisor.vangogh.b.a.a().b(paramContext));
    b.put("a6", com.datavisor.vangogh.b.a.a().b());
    b.put("a8", com.datavisor.vangogh.b.a.a().h(paramContext));
    b.put("a9", com.datavisor.vangogh.b.a.a().f(paramContext));
    b.put("a10", com.datavisor.vangogh.b.a.a().g(paramContext));
    b.put("a17", com.datavisor.vangogh.b.a.a().e(paramContext));
    b.put("c1", d.a(paramContext).a());
    b.put("c3", b.a(paramContext).a());
    b.put("c9", c.a(paramContext).a(paramString));
    b.put("c8", com.datavisor.vangogh.a.a.a(paramContext).a());
    b.put("d77", c(paramContext));
    b.put("d44", b.a().z(paramContext));
    c = System.currentTimeMillis() - l;
    return b;
  }
  
  public static void a() {
    a = 0;
    b.clear();
  }
  
  private static void a(Context paramContext, Map<String, String> paramMap) {
    JSONObject jSONObject = b.a(paramContext).c(crypto.convert("PJKRy3nQrcEZUQ=="));
    if (jSONObject != null) {
      try {
        JSONObject jSONObject1 = jSONObject.getJSONObject(crypto.convert("K4yR2Ws="));
        Iterator<String> iterator = jSONObject1.keys();
      } finally {
        paramContext = null;
      } 
      try {
        JSONObject jSONObject1 = jSONObject.getJSONObject(crypto.convert("OJOa"));
        Iterator<String> iterator = jSONObject1.keys();
      } finally {
        paramContext = null;
      } 
      try {
        jSONObject = jSONObject.getJSONObject(crypto.convert("PZeSzGs="));
        Iterator<String> iterator = jSONObject.keys();
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  public static Map<String, String> b(Context paramContext) {
    long l1 = System.currentTimeMillis();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("d13", b.a().e());
    hashMap.put("d14", b.a().f());
    hashMap.put("d15", "Android");
    hashMap.put("d24", b.a().t(paramContext));
    hashMap.put("d26", b.a().s());
    hashMap.put("d28", b.a().u(paramContext));
    hashMap.put("d29", b.a().v(paramContext));
    hashMap.put("d30", b.a().y(paramContext));
    hashMap.put("d33", b.a().C(paramContext));
    hashMap.put("d35", b.a().B(paramContext));
    hashMap.put("d36", b.a().A(paramContext));
    hashMap.put("d39", b.a().P(paramContext));
    hashMap.put("d40", b.a().Q(paramContext));
    hashMap.put("d42", b.a().o());
    hashMap.put("d43", b.a().p());
    hashMap.put("d44", b.a().z(paramContext));
    hashMap.put("d54", b.a().G(paramContext));
    hashMap.put("d61", b.a().J(paramContext));
    hashMap.put("n1", c.a().b(paramContext));
    hashMap.put("n2", c.a().d(paramContext));
    hashMap.put("n3", c.a().c(paramContext));
    hashMap.put("n4", c.a().e(paramContext));
    hashMap.put("n9", c.a().f(paramContext));
    hashMap.put("v1", e.a(paramContext).a(crypto.convert("H6i37Q==")));
    hashMap.put("v2", e.a(paramContext).a(crypto.convert("H6iqxnPZqQ==")));
    hashMap.put("c8", com.datavisor.vangogh.a.a.a(paramContext).a());
    hashMap.put("d77", c(paramContext));
    a(paramContext, (Map)hashMap);
    long l2 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l2 - l1);
    stringBuilder.append("");
    hashMap.put("d81", stringBuilder.toString());
    return (Map)hashMap;
  }
  
  private static String c(Context paramContext) {
    JSONObject jSONObject = b.a(paramContext).c(crypto.convert("PZeSzH3ErtMb"));
    if (jSONObject != null)
      try {
        int i;
        JSONArray jSONArray1 = jSONObject.getJSONArray(crypto.convert("PZeSzGs="));
      } finally {
        jSONObject = null;
        d.a((Throwable)jSONObject);
      }  
    return "empty";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */