package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.core.video.b.b;
import com.bytedance.sdk.openadsdk.d.b;
import com.bytedance.sdk.openadsdk.d.c;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.e.b;
import com.bytedance.sdk.openadsdk.e.c;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.s;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class x implements b, ak.a {
  private static final Map<String, Boolean> f = new ConcurrentHashMap<String, Boolean>();
  
  private boolean A = false;
  
  private boolean B = false;
  
  protected Map<String, Object> a;
  
  boolean b;
  
  boolean c = false;
  
  private WeakReference<WebView> d;
  
  private ak e;
  
  private WeakReference<Context> g;
  
  private c h;
  
  private String i;
  
  private String j;
  
  private int k;
  
  private String l;
  
  private k m;
  
  private boolean n = true;
  
  private j o;
  
  private g p;
  
  private JSONObject q;
  
  private d r;
  
  private com.bytedance.sdk.openadsdk.e.a s;
  
  private d t;
  
  private c u;
  
  private JSONObject v;
  
  private d w;
  
  private boolean x = true;
  
  private List<k> y;
  
  private HashMap<String, i> z;
  
  static {
    f.put("log_event", Boolean.TRUE);
    f.put("private", Boolean.TRUE);
    f.put("dispatch_message", Boolean.TRUE);
    f.put("custom_event", Boolean.TRUE);
    f.put("log_event_v3", Boolean.TRUE);
  }
  
  public x(Context paramContext) {
    this.g = new WeakReference<Context>(paramContext);
    this.e = new ak(Looper.getMainLooper(), this);
  }
  
  private void a(a parama) throws Exception {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString, int paramInt, i parami) {
    if (!TextUtils.isEmpty(paramString)) {
      HashMap<String, i> hashMap = this.z;
      if (hashMap == null)
        return; 
      i i1 = hashMap.get(paramString);
      if (i1 != null)
        i1.a(paramInt, parami); 
    } 
  }
  
  private void a(JSONObject paramJSONObject, int paramInt) throws Exception {
    JSONArray jSONArray = new JSONArray();
    Iterator<String> iterator = k().iterator();
    while (iterator.hasNext())
      jSONArray.put(iterator.next()); 
    paramJSONObject.put("appName", com.bytedance.sdk.openadsdk.a.a.a());
    paramJSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.a.a.e());
    paramJSONObject.put("aid", com.bytedance.sdk.openadsdk.a.a.b());
    paramJSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c());
    paramJSONObject.put("appVersion", com.bytedance.sdk.openadsdk.a.a.d());
    paramJSONObject.put("netType", com.bytedance.sdk.openadsdk.a.a.f());
    paramJSONObject.put("supportList", jSONArray);
    paramJSONObject.put("deviceId", com.bytedance.sdk.openadsdk.a.a.a(o.a()));
  }
  
  private void a(JSONObject paramJSONObject, b paramb) {
    if (paramb == null)
      return; 
    try {
      if (this.m == null || TextUtils.isEmpty(this.j)) {
        paramb.a(false, null);
        return;
      } 
      int i = ah.c(this.j);
      AdSlot adSlot = this.m.j();
      l l = new l();
      if (this.m.x() != null)
        l.e = 2; 
      JSONObject jSONObject2 = this.m.Y();
      JSONObject jSONObject1 = jSONObject2;
      if (jSONObject2 == null)
        jSONObject1 = new JSONObject(); 
      if (paramJSONObject != null) {
        Iterator<String> iterator = paramJSONObject.keys();
        while (iterator.hasNext()) {
          String str = iterator.next();
          jSONObject1.put(str, paramJSONObject.opt(str));
        } 
      } 
      l.g = jSONObject1;
      o.f().a(adSlot, l, i, new p.b(this, paramb) {
            public void a(int param1Int, String param1String) {
              this.a.a(false, null);
            }
            
            public void a(a param1a) {
              if (param1a.c() != null && !param1a.c().isEmpty()) {
                this.a.a(true, param1a.c());
                return;
              } 
              this.a.a(false, null);
            }
          });
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private boolean a(a parama, JSONObject paramJSONObject) {
    WeakReference<Context> weakReference1;
    Context context;
    c c1;
    d d1;
    if (this.b)
      try {
        JSONObject jSONObject = parama.d.optJSONObject("data");
        if (jSONObject != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("替换 download_url 前 appAdJson:");
          stringBuilder.append(jSONObject.toString());
          t.b("download_app_ad", stringBuilder.toString());
          jSONObject.put("download_url", this.m.N().b());
          stringBuilder = new StringBuilder();
          stringBuilder.append("替换 download_url 后 appAdJson::");
          stringBuilder.append(jSONObject.toString());
          t.c("download_app_ad", stringBuilder.toString());
        } 
      } finally {
        Exception exception;
      }  
    switch (parama.c) {
      default:
        return false;
      case "getNetworkData":
        b(parama, paramJSONObject);
        return false;
      case "getMaterialMeta":
        return l(paramJSONObject);
      case "send_temai_product_ids":
        k(parama.d);
        return false;
      case "getCurrentVideoState":
        return g(paramJSONObject);
      case "changeVideoState":
        f(parama.d);
        return false;
      case "muteVideo":
        e(parama.d);
        return false;
      case "skipVideo":
        l();
        return false;
      case "dynamicTrack":
        j(parama.d);
        return false;
      case "renderDidFinish":
        i(parama.d);
        return false;
      case "clickEvent":
        h(parama.d);
        return false;
      case "landscape_click":
        weakReference1 = this.g;
        if (weakReference1 != null) {
          context = weakReference1.get();
          if (context != null && context instanceof b) {
            ((b)context).P();
            return false;
          } 
        } 
        return false;
      case "unsubscribe_app_ad":
        c1 = this.h;
        if (c1 == null)
          return false; 
        c1.a(((a)context).d);
        return false;
      case "cancel_download_app_ad":
        c1 = this.h;
        if (c1 == null)
          return false; 
        c1.b(((a)context).d);
        return false;
      case "download_app_ad":
        d1 = this.w;
        if (d1 != null) {
          d1.a(this.x);
          return false;
        } 
        if (this.h == null)
          return false; 
        weakReference2 = this.g;
        if (weakReference2 != null) {
          Context context1 = weakReference2.get();
          if (context1 != null) {
            this.h.a(context1, ((a)context).d);
            return false;
          } 
        } 
        return false;
      case "subscribe_app_ad":
        break;
    } 
    p();
    WeakReference<Context> weakReference2 = this.g;
    if (weakReference2 != null) {
      Context context1 = weakReference2.get();
      if (context1 != null)
        this.h.a(context1, ((a)context).d, this.j, this.k, this.n); 
    } 
    return false;
  }
  
  private JSONArray b(List<k> paramList) {
    JSONArray jSONArray = new JSONArray();
    if (paramList == null)
      return jSONArray; 
    int m = paramList.size();
    for (int i = 0; i < m; i++)
      jSONArray.put(((k)paramList.get(i)).ae()); 
    return jSONArray;
  }
  
  private void b(a parama, JSONObject paramJSONObject) {
    if (parama == null)
      return; 
    try {
      a(parama.d, new b(this, paramJSONObject, parama) {
            public void a(boolean param1Boolean, List<k> param1List) {
              if (param1Boolean)
                try {
                  JSONArray jSONArray = x.a(this.c, param1List);
                  this.a.put("creatives", jSONArray);
                  x.a(this.c, this.b.b, this.a);
                  return;
                } catch (Exception exception) {
                  return;
                }  
              x.a(this.c, this.b.b, this.a);
            }
          });
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void b(String paramString, JSONObject paramJSONObject) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("__msg_type", "callback");
      jSONObject.put("__callback_id", paramString);
      if (paramJSONObject != null)
        jSONObject.put("__params", paramJSONObject); 
      m(jSONObject);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void c(String paramString, JSONObject paramJSONObject) {
    try {
      if (TextUtils.isEmpty(paramString))
        return; 
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("__msg_type", "event");
      jSONObject.put("__event_id", paramString);
      if (paramJSONObject != null)
        jSONObject.put("__params", paramJSONObject); 
      m(jSONObject);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void c(JSONObject paramJSONObject) throws Exception {
    if (!TextUtils.isEmpty(this.i))
      paramJSONObject.put("cid", this.i); 
    if (!TextUtils.isEmpty(this.j))
      paramJSONObject.put("log_extra", this.j); 
    if (!TextUtils.isEmpty(this.l))
      paramJSONObject.put("download_url", this.l); 
  }
  
  private void d(String paramString) {
    try {
      String str = new String(Base64.decode(paramString, 2));
      t.b("TTAndroidObject", str);
      JSONArray jSONArray = new JSONArray(str);
      int m = jSONArray.length();
      int i = 0;
      while (true) {
        if (i < m) {
          a a1 = new a();
          try {
            JSONObject jSONObject = jSONArray.optJSONObject(i);
            if (jSONObject != null) {
              a1.a = jSONObject.optString("__msg_type", null);
              a1.b = jSONObject.optString("__callback_id", null);
              a1.c = jSONObject.optString("func");
              a1.d = jSONObject.optJSONObject("params");
              a1.e = jSONObject.optInt("JSSDK");
            } 
          } finally {
            Exception exception;
          } 
          if (!TextUtils.isEmpty(a1.a) && !TextUtils.isEmpty(a1.c)) {
            Message message = this.e.obtainMessage(11);
            message.obj = a1;
            this.e.sendMessage(message);
          } 
          i++;
          continue;
        } 
        return;
      } 
    } catch (Exception exception) {
      if (t.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to parse jsbridge msg queue ");
        stringBuilder.append(paramString);
        t.d("TTAndroidObject", stringBuilder.toString());
        return;
      } 
      t.d("TTAndroidObject", "failed to parse jsbridge msg queue");
    } 
  }
  
  private void d(JSONObject paramJSONObject) throws Exception {
    k k1 = this.m;
    if (k1 != null && !TextUtils.isEmpty(k1.d()))
      paramJSONObject.put("playable_style", this.m.d()); 
  }
  
  private String e(String paramString) {
    if (this.o == null)
      paramString = ah.a(this.k); 
    return paramString;
  }
  
  private void e(JSONObject paramJSONObject) {
    if (this.p != null) {
      if (paramJSONObject == null)
        return; 
      try {
        boolean bool = paramJSONObject.optBoolean("mute", false);
        this.p.e(bool);
        return;
      } catch (Exception exception) {
        return;
      } 
    } 
  }
  
  private void f(String paramString) {
    if (paramString == null)
      return; 
    if (!paramString.startsWith("bytedance://"))
      return; 
    try {
      WebView webView;
      if (paramString.equals("bytedance://dispatch_message/")) {
        webView = j();
        if (webView != null) {
          s.a(webView, "javascript:ToutiaoJSBridge._fetchQueue()");
          return;
        } 
      } else if (webView.startsWith("bytedance://private/setresult/")) {
        int i = webView.indexOf('&', 30);
        if (i <= 0)
          return; 
        String str2 = webView.substring(30, i);
        String str1 = webView.substring(i + 1);
        if (str2.equals("SCENE_FETCHQUEUE") && str1.length() > 0)
          d(str1); 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void f(JSONObject paramJSONObject) {
    if (this.p != null) {
      if (paramJSONObject == null)
        return; 
      try {
        int i = paramJSONObject.optInt("stateType", -1);
        this.p.d(i);
        return;
      } catch (Exception exception) {
        return;
      } 
    } 
  }
  
  private boolean g(JSONObject paramJSONObject) {
    g g1 = this.p;
    if (g1 != null) {
      if (paramJSONObject == null)
        return false; 
      double d1 = g1.K();
      int i = this.p.L();
      try {
        paramJSONObject.put("currentTime", d1 / 1000.0D);
        paramJSONObject.put("state", i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("currentTime,state:");
        stringBuilder.append(i);
        t.b("TTAndroidObject", stringBuilder.toString());
        return true;
      } catch (Exception exception) {
        return false;
      } 
    } 
    return false;
  }
  
  private void h(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    try {
      double d1;
      double d2;
      double d3;
      double d4;
      double d5;
      double d6;
      double d7;
      double d9;
      double d10;
      String str = paramJSONObject.optString("adId");
      int m = paramJSONObject.optInt("areaType", 1);
      paramJSONObject = paramJSONObject.optJSONObject("clickInfo");
      double d8 = 0.0D;
      if (paramJSONObject != null) {
        d8 = paramJSONObject.optDouble("down_x", 0.0D);
        d5 = paramJSONObject.optDouble("down_y", 0.0D);
        d4 = paramJSONObject.optDouble("up_x", 0.0D);
        d3 = paramJSONObject.optDouble("up_y", 0.0D);
        d2 = paramJSONObject.optDouble("down_time", 0.0D);
        d6 = paramJSONObject.optDouble("up_time", 0.0D);
        d7 = paramJSONObject.optDouble("button_x", 0.0D);
        d1 = paramJSONObject.optDouble("button_y", 0.0D);
        double d11 = paramJSONObject.optDouble("button_width", 0.0D);
        d9 = paramJSONObject.optDouble("button_height", 0.0D);
        d10 = d1;
        d1 = d11;
      } else {
        d7 = 0.0D;
        d6 = d7;
        d5 = d6;
        d4 = d5;
        d3 = d4;
        d2 = d3;
        double d11 = d2;
        d1 = d11;
        d9 = d1;
        d10 = d11;
      } 
      i i = (new i.a()).d((int)d8).c((int)d5).b((int)d4).a((int)d3).b((long)d2).a((long)d6).e((int)d7).f((int)d10).g((int)d1).h((int)d9).a();
      if (this.o != null)
        this.o.a(m, i); 
      a(str, m, i);
      return;
    } catch (Exception exception) {
      j j1 = this.o;
      if (j1 != null)
        j1.a(-1, null); 
      return;
    } 
  }
  
  private void i(JSONObject paramJSONObject) {
    if (this.o != null) {
      if (paramJSONObject == null)
        return; 
      m m = new m();
      try {
        double d2;
        boolean bool = paramJSONObject.optBoolean("isRenderSuc");
        JSONObject jSONObject = paramJSONObject.optJSONObject("AdSize");
        double d1 = 0.0D;
        if (jSONObject != null) {
          d1 = jSONObject.optDouble("width");
          d2 = jSONObject.optDouble("height");
        } else {
          d2 = 0.0D;
        } 
        jSONObject = paramJSONObject.optJSONObject("videoInfo");
        if (jSONObject != null) {
          double d3 = jSONObject.optDouble("x");
          double d4 = jSONObject.optDouble("y");
          double d5 = jSONObject.optDouble("width");
          double d6 = jSONObject.optDouble("height");
          m.c(d3);
          m.d(d4);
          m.e(d5);
          m.f(d6);
        } 
        String str = paramJSONObject.optString("message", g.a(101));
        int i = paramJSONObject.optInt("code", 101);
        m.a(bool);
        m.a(d1);
        m.b(d2);
        m.a(str);
        m.a(i);
        this.o.a(m);
        return;
      } catch (Exception exception) {
        m.a(101);
        m.a(g.a(101));
        this.o.a(m);
      } 
    } 
  }
  
  private WebView j() {
    WeakReference<WebView> weakReference = this.d;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  private void j(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    try {
      Uri uri = Uri.parse(paramJSONObject.optString("trackData"));
      if ("bytedance".equals(uri.getScheme().toLowerCase()))
        q.a(uri, this); 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private List<String> k() {
    return Arrays.asList(new String[] { "appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds" });
  }
  
  private void k(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      if (this.r == null)
        return; 
      try {
        JSONArray jSONArray = paramJSONObject.optJSONArray("temaiProductIds");
        if (jSONArray != null && jSONArray.length() > 0) {
          this.r.a(true, jSONArray);
          return;
        } 
        this.r.a(false, null);
        return;
      } catch (Exception exception) {
        this.r.a(false, null);
      } 
    } 
  }
  
  private void l() {
    g g1 = this.p;
    if (g1 != null)
      g1.J(); 
  }
  
  private boolean l(JSONObject paramJSONObject) {
    try {
      paramJSONObject.put("creatives", b(this.y));
      return true;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  private JSONObject m() {
    JSONObject jSONObject = new JSONObject();
    if (o.h() != null)
      try {
        int i = ah.d(this.j);
        int m = o.h().g(String.valueOf(i));
        boolean bool = o.h().b(String.valueOf(i));
        jSONObject.put("voice_control", o.h().b(i));
        jSONObject.put("rv_skip_time", m);
        jSONObject.put("fv_skip_show", bool);
        k k1 = this.m;
        i = 0;
        if (k1 != null && this.m.ac()) {
          bool = true;
        } else {
          bool = false;
        } 
        jSONObject.put("show_dislike", bool);
        if (this.m != null)
          i = this.m.f(); 
        jSONObject.put("video_adaptation", i);
        return jSONObject;
      } catch (Exception exception) {
        return jSONObject;
      }  
    return jSONObject;
  }
  
  private void m(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    WebView webView = j();
    if (webView != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("javascript:ToutiaoJSBridge._handleMessageFromToutiao(");
      stringBuilder.append(paramJSONObject.toString());
      stringBuilder.append(")");
      String str = stringBuilder.toString();
      s.a(webView, str);
      if (t.a()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("js_msg ");
        stringBuilder1.append(str);
        t.a("TTAndroidObject", stringBuilder1.toString());
      } 
    } 
  }
  
  private JSONObject n(JSONObject paramJSONObject) {
    JSONObject jSONObject = paramJSONObject;
    if (this.a != null) {
      jSONObject = paramJSONObject;
      if (paramJSONObject == null)
        jSONObject = new JSONObject(); 
      try {
        paramJSONObject = new JSONObject();
        String str = jSONObject.optString("ad_extra_data", null);
        if (str != null)
          paramJSONObject = new JSONObject(str); 
        for (Map.Entry<String, Object> entry : this.a.entrySet())
          paramJSONObject.put((String)entry.getKey(), entry.getValue()); 
        jSONObject.put("ad_extra_data", paramJSONObject.toString());
        return jSONObject;
      } catch (Exception exception) {
        t.b(exception.toString());
      } 
    } 
    return jSONObject;
  }
  
  private void n() {
    List<k> list = this.y;
    if (list != null) {
      View view;
      if (list.size() <= 0)
        return; 
      this.z = new HashMap<String, i>();
      list = null;
      WeakReference<WebView> weakReference1 = this.d;
      if (weakReference1 != null)
        view = (View)weakReference1.get(); 
      WeakReference<Context> weakReference = this.g;
      if (weakReference != null) {
        Context context = weakReference.get();
        if (context == null)
          return; 
        for (k k1 : this.y) {
          String str = k1.M();
          i i = new i(context, k1, view);
          this.z.put(str, i);
        } 
      } 
    } 
  }
  
  private boolean o() {
    k k1 = this.m;
    if (k1 != null && k1.Y() != null && !this.m.q()) {
      if (this.A)
        return false; 
      if (this.m.Y().optInt("parent_type") != 2)
        return false; 
      int i = ah.c(this.j);
      if (i == 8 || i == 7) {
        this.A = true;
        return true;
      } 
      return false;
    } 
    return false;
  }
  
  private void p() {
    if (this.h == null)
      this.h = (c)com.bytedance.sdk.openadsdk.d.a.a(this, this.m); 
  }
  
  public k a() {
    return this.m;
  }
  
  public x a(int paramInt) {
    this.k = paramInt;
    return this;
  }
  
  public x a(WebView paramWebView) {
    this.d = new WeakReference<WebView>(paramWebView);
    return this;
  }
  
  public x a(d paramd) {
    this.w = paramd;
    return this;
  }
  
  public x a(k paramk) {
    this.m = paramk;
    return this;
  }
  
  public x a(g paramg) {
    this.p = paramg;
    return this;
  }
  
  public x a(j paramj) {
    this.o = paramj;
    return this;
  }
  
  public x a(d paramd) {
    this.r = paramd;
    return this;
  }
  
  public x a(com.bytedance.sdk.openadsdk.e.a parama) {
    this.s = parama;
    return this;
  }
  
  public x a(c paramc) {
    this.u = paramc;
    return this;
  }
  
  public x a(d paramd) {
    this.t = paramd;
    return this;
  }
  
  public x a(String paramString) {
    this.i = paramString;
    return this;
  }
  
  public x a(List<k> paramList) {
    this.y = paramList;
    return this;
  }
  
  public x a(Map<String, Object> paramMap) {
    this.a = paramMap;
    return this;
  }
  
  public x a(JSONObject paramJSONObject) {
    this.q = paramJSONObject;
    return this;
  }
  
  public x a(boolean paramBoolean) {
    this.b = paramBoolean;
    return this;
  }
  
  public void a(Message paramMessage) {
    if (paramMessage == null)
      return; 
    if (paramMessage.what != 11)
      return; 
    if (paramMessage.obj instanceof a)
      try {
        a((a)paramMessage.obj);
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public void a(String paramString, JSONObject paramJSONObject) {
    c(paramString, paramJSONObject);
  }
  
  public boolean a(Uri paramUri) {
    if (paramUri == null)
      return false; 
    try {
      if (!"bytedance".equals(paramUri.getScheme()))
        return false; 
      String str = paramUri.getHost();
      boolean bool = f.containsKey(str);
      return bool;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  @JavascriptInterface
  public String adInfo() {
    JSONObject jSONObject = new JSONObject();
    try {
      c(jSONObject);
    } catch (Exception exception) {}
    return jSONObject.toString();
  }
  
  @JavascriptInterface
  public String appInfo() {
    JSONObject jSONObject = new JSONObject();
    try {
      a(jSONObject, 0);
    } catch (Exception exception) {}
    return jSONObject.toString();
  }
  
  public x b(String paramString) {
    this.j = paramString;
    return this;
  }
  
  public x b(JSONObject paramJSONObject) {
    this.v = paramJSONObject;
    return this;
  }
  
  public x b(boolean paramBoolean) {
    this.B = paramBoolean;
    return this;
  }
  
  public void b(Uri paramUri) {
    try {
      JSONObject jSONObject;
      String str = paramUri.getHost();
      if ("log_event".equals(str) || "custom_event".equals(str) || "log_event_v3".equals(str)) {
        long l1;
        String str2 = paramUri.getQueryParameter("category");
        String str3 = paramUri.getQueryParameter("tag");
        String str4 = paramUri.getQueryParameter("label");
        long l2 = 0L;
        try {
          l1 = Long.parseLong(paramUri.getQueryParameter("value"));
        } catch (Exception exception) {
          l1 = 0L;
        } 
        try {
          long l = Long.parseLong(paramUri.getQueryParameter("ext_value"));
          l2 = l;
        } catch (Exception exception) {}
        str = null;
        String str5 = paramUri.getQueryParameter("extra");
        boolean bool = TextUtils.isEmpty(str5);
        String str1 = str;
        if (!bool)
          try {
            jSONObject = new JSONObject(str5);
          } catch (Exception exception) {
            str1 = str;
          }  
        if ("click".equals(str4))
          jSONObject = n((JSONObject)str1); 
        d.a(str2, e(str3), str4, l1, l2, jSONObject);
        return;
      } 
      if ("private".equals(str) || "dispatch_message".equals(str)) {
        f(jSONObject.toString());
        return;
      } 
      t.d("TTAndroidObject", "handlrUir: not match schema host");
      return;
    } catch (Exception exception) {
      t.b("TTAndroidObject", "handleUri exception: ", exception);
      return;
    } 
  }
  
  public boolean b() {
    k k1 = this.m;
    return (k1 != null && k1.b());
  }
  
  public x c(String paramString) {
    this.l = paramString;
    return this;
  }
  
  public x c(boolean paramBoolean) {
    this.x = paramBoolean;
    return this;
  }
  
  public boolean c() {
    return this.c;
  }
  
  @JavascriptInterface
  public void changeVideoState(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        f(jSONObject);
        return;
      } 
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, jSONObject) {
            public void run() {
              x.b(this.b, this.a);
            }
          });
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  @JavascriptInterface
  public void clickEvent(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        h(jSONObject);
        return;
      } 
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, jSONObject) {
            public void run() {
              x.c(this.b, this.a);
            }
          });
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void d() {
    a((JSONObject)null, new b(this) {
          public void a(boolean param1Boolean, List<k> param1List) {
            x.b(this.a, param1List);
            x.a(this.a);
            this.a.e();
          }
        });
  }
  
  @JavascriptInterface
  public void dynamicTrack(String paramString) {
    try {
      j(new JSONObject(paramString));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void e() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("material", b(this.y));
      a("materialMeta", jSONObject);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public String f() {
    return ah.a(this.k);
  }
  
  public void g() {
    c c1 = this.h;
    if (c1 != null)
      c1.a(); 
    if (o())
      d(); 
  }
  
  @JavascriptInterface
  public String getCurrentVideoState() {
    JSONObject jSONObject = new JSONObject();
    g(jSONObject);
    return jSONObject.toString();
  }
  
  @JavascriptInterface
  public String getTemplateInfo() {
    try {
      if (this.q != null)
        this.q.put("setting", m()); 
      return this.q.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public void h() {
    c c1 = this.h;
    if (c1 != null)
      c1.b(); 
  }
  
  public void i() {
    c c1 = this.h;
    if (c1 != null)
      c1.c(); 
  }
  
  @JavascriptInterface
  public void muteVideo(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        e(jSONObject);
        return;
      } 
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, jSONObject) {
            public void run() {
              x.a(this.b, this.a);
            }
          });
      return;
    } catch (Exception exception) {
      t.e("TTAndroidObject", "");
      return;
    } 
  }
  
  @JavascriptInterface
  public void renderDidFinish(String paramString) {
    try {
      i(new JSONObject(paramString));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  @JavascriptInterface
  public void skipVideo() {
    l();
  }
  
  public static class a {
    public String a;
    
    public String b;
    
    public String c;
    
    public JSONObject d;
    
    public int e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */