package com.qq.e.comm.plugin.gdtnativead;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ac.e;
import com.qq.e.comm.plugin.ad.a;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.f;
import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.c.e;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.s.c;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.plugin.w.a;
import com.qq.e.comm.plugin.w.a.c;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import org.json.JSONObject;

public class i {
  private h a;
  
  private a b;
  
  public i(h paramh, a parama) {
    this.a = paramh;
    this.b = parama;
  }
  
  private d.b a(int paramInt1, int paramInt2) {
    d.c c;
    int k = b.a(this.a.b());
    f f = c();
    boolean bool = d.a(this.a.c);
    String str = this.a.o();
    int j = paramInt2;
    if (paramInt2 == -1)
      if (bool && !b.g(this.a.c)) {
        j = 1;
      } else {
        j = 0;
      }  
    if (this.a.d.a_() == 48)
      j = 48; 
    if (this.a.o == 2) {
      c = d.c.b;
    } else {
      c = d.c.a;
    } 
    return (new d.b(j, c)).a(paramInt1).a(str).b(k).a(f);
  }
  
  private void a() {
    c c = this.a.d.l();
    if (c == null)
      return; 
    String str = c.c();
    if (!TextUtils.isEmpty(str))
      (new e(this.a.m)).a(str); 
  }
  
  private void a(int paramInt) {
    b(0);
    if (!this.a.f)
      this.a.k(); 
    d.a a1 = com.qq.e.comm.plugin.w.i.a(this.a.d);
    d.e e = new d.e(this.a.a(), e.i, this.a.b());
    d.b b = a(0, -1);
    b.i = a.a().b((View)this.a.l);
    if (!((Boolean)(com.qq.e.comm.plugin.w.a.i.a(this.a.a, a1, b, e, new com.qq.e.comm.plugin.w.a.i.a(this, paramInt) {
          public void a(String param1String, boolean param1Boolean) {
            if (this.a == 1 && param1Boolean)
              a.a(param1String); 
          }
        })).second).booleanValue())
      this.a.a(false); 
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    if (paramInt == 4) {
      h h1 = this.a;
      c c = h1.d(h1.g.d());
      if (c != null) {
        l.a().a(c.m(), 1);
        return;
      } 
    } else if (paramInt == 32) {
      h h1 = this.a;
      c c = h1.d(h1.g.d());
      if (c != null) {
        l.a().a(c.m());
        return;
      } 
    } else {
      a(null, 2, -1, paramBoolean);
    } 
  }
  
  private void a(String paramString, JSONObject paramJSONObject) {
    char c;
    if (paramString.equals(String.valueOf(1))) {
      c = '〈';
    } else if (paramString.equals(String.valueOf(2))) {
      a();
      c = '⌨';
    } else if (paramString.equals(String.valueOf(3))) {
      c = '〉';
    } else {
      return;
    } 
    a(paramJSONObject, 0, c);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt) {
    a(paramJSONObject, paramInt, -1, false);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt1, int paramInt2) {
    a(paramJSONObject, paramInt1, paramInt2, false);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt1, int paramInt2, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sendClickRequest:");
    stringBuilder.append(paramJSONObject);
    stringBuilder.append(", action:");
    stringBuilder.append(paramInt1);
    GDTLogger.d(stringBuilder.toString());
    if (!paramBoolean)
      b(paramInt1); 
    d.a a1 = com.qq.e.comm.plugin.w.i.a(this.a.d);
    d.e e = new d.e(this.a.a(), e.i, this.a.b());
    d.b b = a(paramInt1, paramInt2);
    b.i = a.a().b((View)this.a.l);
    d.a(this.a.a, a1, e, b);
  }
  
  private int b() {
    int j = this.a.k;
    null = true;
    if (j == 1) {
      j = this.a.c.optInt("producttype");
      if (j == 12 || j == 1000 || j == 38 || j == 25) {
        String str = this.a.c.optString("customized_invoke_url");
        if (bb.b(str)) {
          String str1 = d.e(this.a.c);
          String str2 = b.d(this.a.c);
          if (c.a(this.a.h, str1, str, str2, null)) {
            if (!this.a.f)
              this.a.k(); 
            return 2;
          } 
          return null;
        } 
      } 
    } 
    return 0;
  }
  
  private void b(int paramInt) {
    if (SDKStatus.getSDKVersionCode() >= 10) {
      h h2 = this.a;
      h2.a(6, new Object[] { h2.b, "" });
      return;
    } 
    h h1 = this.a;
    h1.a(6, new Object[] { h1.b });
  }
  
  private void b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   4: invokevirtual m : ()Z
    //   7: ifeq -> 247
    //   10: aload_0
    //   11: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   14: getfield i : Lcom/qq/e/ads/nativ/MediaView;
    //   17: ifnull -> 64
    //   20: aload_0
    //   21: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   24: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   27: ifnull -> 64
    //   30: aload_0
    //   31: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   34: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   37: invokevirtual getVisibility : ()I
    //   40: ifeq -> 64
    //   43: aload_0
    //   44: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   47: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   50: iconst_0
    //   51: invokevirtual setVisibility : (I)V
    //   54: aload_0
    //   55: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   58: getfield i : Lcom/qq/e/ads/nativ/MediaView;
    //   61: invokestatic a : (Landroid/view/ViewGroup;)V
    //   64: aload_0
    //   65: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   68: getfield c : Lorg/json/JSONObject;
    //   71: invokestatic c : (Lorg/json/JSONObject;)Z
    //   74: ifeq -> 94
    //   77: aload_0
    //   78: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   81: getfield k : I
    //   84: iconst_1
    //   85: if_icmpne -> 94
    //   88: aload_0
    //   89: iconst_m1
    //   90: invokespecial a : (I)V
    //   93: return
    //   94: aload_0
    //   95: invokespecial b : ()I
    //   98: istore_2
    //   99: iload_2
    //   100: iconst_2
    //   101: if_icmpne -> 113
    //   104: aload_0
    //   105: aload_1
    //   106: iconst_4
    //   107: invokespecial a : (Lorg/json/JSONObject;I)V
    //   110: goto -> 238
    //   113: aload_0
    //   114: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   117: getfield c : Lorg/json/JSONObject;
    //   120: invokestatic f : (Lorg/json/JSONObject;)Z
    //   123: ifeq -> 143
    //   126: aload_0
    //   127: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   130: getfield k : I
    //   133: iconst_1
    //   134: if_icmpne -> 143
    //   137: aload_0
    //   138: iload_2
    //   139: invokespecial a : (I)V
    //   142: return
    //   143: aload_0
    //   144: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   147: getfield k : I
    //   150: iconst_1
    //   151: if_icmpne -> 208
    //   154: aload_0
    //   155: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   158: getfield c : Lorg/json/JSONObject;
    //   161: invokestatic a : (Lorg/json/JSONObject;)Z
    //   164: ifeq -> 208
    //   167: aload_0
    //   168: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   171: getfield c : Lorg/json/JSONObject;
    //   174: invokestatic b : (Lorg/json/JSONObject;)Z
    //   177: ifne -> 208
    //   180: iload_2
    //   181: iconst_1
    //   182: if_icmpne -> 194
    //   185: aload_0
    //   186: aload_1
    //   187: iconst_3
    //   188: invokespecial a : (Lorg/json/JSONObject;I)V
    //   191: goto -> 200
    //   194: aload_0
    //   195: aload_1
    //   196: iconst_1
    //   197: invokespecial a : (Lorg/json/JSONObject;I)V
    //   200: aload_0
    //   201: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   204: astore_1
    //   205: goto -> 233
    //   208: aload_0
    //   209: iconst_0
    //   210: invokespecial b : (I)V
    //   213: aload_0
    //   214: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   217: astore_3
    //   218: aload_3
    //   219: astore_1
    //   220: iload_2
    //   221: iconst_1
    //   222: if_icmpne -> 233
    //   225: aload_3
    //   226: iconst_1
    //   227: invokevirtual a : (Z)V
    //   230: goto -> 238
    //   233: aload_1
    //   234: iconst_0
    //   235: invokevirtual a : (Z)V
    //   238: aload_0
    //   239: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   242: iconst_0
    //   243: putfield f : Z
    //   246: return
    //   247: aload_0
    //   248: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   251: getfield c : Lorg/json/JSONObject;
    //   254: ifnull -> 273
    //   257: aload_0
    //   258: getfield a : Lcom/qq/e/comm/plugin/gdtnativead/h;
    //   261: getfield e : Z
    //   264: ifeq -> 273
    //   267: aload_0
    //   268: aload_1
    //   269: iconst_0
    //   270: invokespecial a : (Lorg/json/JSONObject;I)V
    //   273: return
  }
  
  private boolean b(String paramString) {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString.equals(String.valueOf(1))) {
      bool1 = bool2;
      if (!paramString.equals(String.valueOf(2))) {
        if (paramString.equals(String.valueOf(3)))
          return true; 
        bool1 = false;
      } 
    } 
    return bool1;
  }
  
  private f c() {
    if (this.a.a == null) {
      GDTLogger.e("Native Express AD view is null");
      u.a(100332, 0, this.a.n);
    } else {
      View view = this.a.a.a();
      if (view != null) {
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect))
          return new f(true, view.getWidth(), view.getHeight(), rect.width(), rect.height(), view.toString()); 
        GDTLogger.d("Ad is not visible.");
      } 
    } 
    return null;
  }
  
  void a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("code", "InnerBrowser");
    d.e e = new d.e(this.a.a(), e.i, this.a.b());
    d.a(paramString, this.a.d.E(), e, a(0, -1), hashMap);
  }
  
  void a(JSONObject paramJSONObject) {
    f f = c();
    String str = paramJSONObject.optString("action");
    a a1 = this.a.d;
    if (b(str)) {
      if (e.a(a1)) {
        e.c((new f.a(a1, (View)this.a.l)).a(f).a(this.a.o()).a(), this.b);
      } else {
        a(str, paramJSONObject);
        return;
      } 
    } else if (e.a(a1)) {
      e.a((new f.a(a1, (View)this.a.l)).a(f).a(this.a.o()).a(), this.b);
    } else {
      b(paramJSONObject);
      return;
    } 
    b(0);
  }
  
  void a(boolean paramBoolean) {
    int j = this.a.g.h();
    a a1 = this.a.d;
    if (e.a(a1)) {
      e.b((new f.a(a1, (View)this.a.l)).a(c()).a(this.a.o()).f(paramBoolean ^ true).a(), this.b);
      if (!paramBoolean && j != 4 && j != 32) {
        b(0);
        return;
      } 
    } else {
      a(j, paramBoolean);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */