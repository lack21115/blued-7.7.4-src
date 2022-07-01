package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.c.a.c;
import com.qq.e.comm.plugin.c.e;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.nativeadunified.c;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.plugin.w.a.c;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.a.i;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

class g {
  private b a;
  
  private c b;
  
  private Context c;
  
  private com.qq.e.comm.plugin.c.a.a d;
  
  private String e;
  
  public g(Context paramContext, b paramb, c paramc) {
    this.c = paramContext;
    this.a = paramb;
    this.b = paramc;
    this.d = (com.qq.e.comm.plugin.c.a.a)new c(this, this.c) {
        public void a(com.qq.e.comm.plugin.s.a param1a) {
          super.a(param1a);
          g g1 = this.b;
          g.a(g1, null, false, g.a(g1));
        }
        
        public void b(com.qq.e.comm.plugin.s.a param1a) {
          super.b(param1a);
          g g1 = this.b;
          g.a(g1, null, false, g.a(g1));
        }
        
        public void c(String param1String) {
          super.c(param1String);
          g g1 = this.b;
          g.a(g1, param1String, false, g.a(g1));
        }
      };
  }
  
  private a a() {
    if (this.b.a_() == 12 || this.b.a_() == 1000 || this.b.a_() == 38 || this.b.a_() == 25) {
      String str = this.b.e();
      if (bb.b(str)) {
        String str1 = d.d(this.b.E()).d();
        return c.a(this.c, str1, str, this.b.m(), null) ? a.c : a.b;
      } 
    } 
    return a.a;
  }
  
  private void a(String paramString, a parama) {
    d.a a1 = i.a(this.b);
    d.e e = new d.e(this.a.b, e.w, this.a.a);
    d.b b1 = d.a(0, -1, this.b, this.a.f.q(), paramString, this.a.c);
    b1.i = com.qq.e.comm.plugin.ad.a.a().b(this.a.f.q());
    if (!((Boolean)(i.a(this.a.f.q(), a1, b1, e, new i.a(this, parama) {
          public void a(String param1String, boolean param1Boolean) {
            if (this.a == g.a.b && param1Boolean)
              com.qq.e.comm.plugin.w.a.a(param1String); 
          }
        })).second).booleanValue() && this.b.ah())
      a(false, paramString); 
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2) {
    if (c.a() != null) {
      GDTLogger.e("广告点击太快");
      return;
    } 
    c.a(this.a);
    c.a(paramBoolean);
    this.a.f.u();
    c.a(d.a(0, -1, this.b, this.a.f.q(), paramString2, this.a.c));
    c.a(new d.e(this.a.b, e.w, this.a.a));
    Intent intent = new Intent();
    Context context = this.c.getApplicationContext();
    intent.setClassName(context.getApplicationContext(), at.b());
    intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
    intent.putExtra("gdt_activity_delegate_name", "detailPage");
    intent.putExtra("antiSpam", paramString2);
    intent.putExtra("url", paramString1);
    if (this.a.d != null)
      intent.putExtra("detailPageMuted", this.a.d.isDetailPageMuted()); 
    intent.addFlags(268435456);
    context.startActivity(intent);
  }
  
  private void a(boolean paramBoolean, String paramString) {
    a(null, paramBoolean, paramString);
  }
  
  private boolean a(String paramString, JSONObject paramJSONObject) {
    b b1;
    paramJSONObject = paramJSONObject.optJSONObject("componentInfo");
    if (paramJSONObject == null)
      return false; 
    int i = paramJSONObject.optInt("type", -1);
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return false; 
        b1 = this.a;
        i = 9002;
      } else {
        d.a(this.c, this.b);
        b1 = this.a;
        i = 9000;
      } 
    } else {
      b1 = this.a;
      i = 9001;
    } 
    b1.a(paramString, 0, i);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject) {
    paramJSONObject = paramJSONObject.optJSONObject("componentInfo");
    boolean bool = true;
    if (paramJSONObject != null) {
      int i = paramJSONObject.optInt("type", -1);
      boolean bool1 = bool;
      if (i != 1) {
        bool1 = bool;
        if (i != 2) {
          if (i == 3)
            return true; 
        } else {
          return bool1;
        } 
      } else {
        return bool1;
      } 
    } 
    return false;
  }
  
  private void b(String paramString) {
    String str;
    this.a.c(200);
    if (TextUtils.isEmpty(paramString) || this.a.f == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ExpressAdDataController click error params: ");
      stringBuilder.append(paramString);
      stringBuilder.append("  mAdViewController: ");
      stringBuilder.append(this.a.f);
      paramString = stringBuilder.toString();
    } else {
      try {
        JSONObject jSONObject = new JSONObject(paramString);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      if (jSONException == null) {
        str = "ExpressAdDataController click error json parse error";
      } else {
        this.a.a((View)null);
        this.e = d.a(str.optString("clickInfo"));
        f f = (new f.a(this.b, this.a.f.q())).a(this.e).a();
        if (a((JSONObject)str)) {
          e.c(f, this.d);
        } else {
          e.a(f, this.d);
        } 
        this.a.a(101, new Object[0]);
        return;
      } 
    } 
    GDTLogger.e(str);
  }
  
  private int c(String paramString) {
    String str;
    a a1;
    this.a.c(200);
    if (TextUtils.isEmpty(paramString) || this.a.f == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ExpressAdDataController click error params: ");
      stringBuilder.append(paramString);
      stringBuilder.append("  mAdViewController: ");
      stringBuilder.append(this.a.f);
      paramString = stringBuilder.toString();
      GDTLogger.e(paramString);
      return 201;
    } 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      jSONException = null;
    } 
    if (jSONException == null) {
      str = "ExpressAdDataController click error json parse error";
    } else {
      this.a.a((View)null);
      this.e = d.a(str.optString("clickInfo"));
      if (a(this.e, (JSONObject)str))
        return 202; 
      boolean bool1 = this.b.ah();
      boolean bool = false;
      if (!bool1) {
        this.a.a(this.e, 0);
        return 206;
      } 
      if (b.b(this.b)) {
        a(this.e, (a)null);
        return 203;
      } 
      a1 = a();
      if (a.c == a1) {
        this.a.a(this.e, 4);
        return 204;
      } 
      if (b.f(this.b.E())) {
        a(this.e, a1);
        return 205;
      } 
      bool1 = this.b.v();
      byte b1 = 1;
      if (bool1 && (!this.b.w() || this.b.aa())) {
        b b2 = this.a;
        String str1 = this.e;
        if (a1 == a.b)
          b1 = 3; 
        b2.a(str1, b1);
      } else if (a1 == a.b) {
        bool = true;
      } 
      a(bool, this.e);
      return 206;
    } 
    GDTLogger.e((String)a1);
    return 201;
  }
  
  void a(View paramView, String paramString) {
    e.b((new f.a(this.b, paramView)).a(paramString).a(), this.d);
  }
  
  void a(String paramString) {
    if (e.a(this.b)) {
      b(paramString);
      return;
    } 
    int i = c(paramString);
    if (i != 201) {
      this.a.a(101, new Object[0]);
      this.a.c(i);
    } 
  }
  
  enum a {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */