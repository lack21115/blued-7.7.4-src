package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ab.b;
import com.qq.e.comm.plugin.ab.d.a;
import com.qq.e.comm.plugin.ab.d.f;
import com.qq.e.comm.plugin.ad.a;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.c.a.c;
import com.qq.e.comm.plugin.rewardvideo.b.a;
import com.qq.e.comm.plugin.rewardvideo.b.b;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class g implements ACTD, f {
  private String A;
  
  private String B;
  
  private String C;
  
  private com.qq.e.comm.plugin.ad.g D;
  
  private c E = new c();
  
  private f F;
  
  private long G;
  
  private boolean H = true;
  
  private boolean I = false;
  
  private boolean J = false;
  
  private boolean K = false;
  
  private boolean L = false;
  
  private Activity a;
  
  private a b;
  
  private long c;
  
  private long d;
  
  private long e;
  
  private String f;
  
  private boolean g;
  
  private b h;
  
  private az i;
  
  private int j;
  
  private a k;
  
  private boolean l = false;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private boolean p = false;
  
  private int q = -1;
  
  private String r;
  
  private d s;
  
  private j t;
  
  private boolean u = false;
  
  private b v;
  
  private ValueCallback<Uri[]> w;
  
  private ValueCallback<Uri> x;
  
  private String y;
  
  private String z;
  
  public g(Activity paramActivity) {
    this.a = paramActivity;
    this.j = GDTADManager.getInstance().getSM().getInteger("rewardPageCountDelayTime", 5);
    this.m = GDTADManager.getInstance().getSM().getInteger("rewardPageEffectiveTime", 15);
    this.n = GDTADManager.getInstance().getSM().getInteger("rewardPageCloseTime", 15);
    int i = this.n;
    int k = this.m;
    if (i > k)
      this.n = k; 
    this.D = new com.qq.e.comm.plugin.ad.g();
  }
  
  private void a(int paramInt, String paramString) {
    b(paramInt, paramString, null);
  }
  
  private void b(int paramInt, String paramString1, String paramString2) {
    if (GDTADManager.getInstance().getSM().getInteger("rpnaspl", 1) == 1)
      b.a(paramInt, this.c, this.E, paramString1, paramString2); 
  }
  
  private void e() {
    if (this.b.d()) {
      this.b.e();
      return;
    } 
    if (this.p) {
      b b1 = this.v;
      if (b1 != null)
        b1.a(this.f, b.e); 
      this.t.d();
      this.a.finish();
      a(2050005, this.f);
      return;
    } 
    if (this.l) {
      az az1 = this.i;
      if (az1 != null) {
        az1.d();
        h();
      } 
    } 
  }
  
  private void f() {
    this.i = new az(this, (this.m * 1000), 500L) {
        public void a() {
          g.a(this.a, true);
          if (g.d(this.a) != null) {
            String str;
            if (g.c(this.a) == null)
              return; 
            g.p(this.a).f();
            g.p(this.a).i();
            g.b(this.a, false);
            if (TextUtils.isEmpty(g.j(this.a))) {
              str = "恭喜获得奖励";
            } else {
              str = g.j(this.a);
            } 
            g.i(this.a).a(String.format(Locale.getDefault(), str, new Object[] { Integer.valueOf(g.k(this.a)) }));
            h.a(e.b, g.q(this.a));
          } 
        }
        
        public void a(long param1Long) {
          String str;
          if (TextUtils.isEmpty(g.h(this.a))) {
            str = "浏览页面 %d 秒可获得奖励";
          } else {
            str = g.h(this.a);
          } 
          int i = Math.round((float)param1Long / 1000.0F);
          if (i > 0) {
            g.i(this.a).a(String.format(Locale.getDefault(), str, new Object[] { Integer.valueOf(i) }));
          } else {
            if (TextUtils.isEmpty(g.j(this.a))) {
              str = "恭喜获得奖励";
            } else {
              str = g.j(this.a);
            } 
            g.i(this.a).a(String.format(Locale.getDefault(), str, new Object[] { Integer.valueOf(g.k(this.a)) }));
            g.a(this.a, true);
            g.b(this.a, false);
          } 
          g.l(this.a);
          if ((g.m(this.a) >= g.n(this.a) * 2 && g.n(this.a) < g.k(this.a)) || (g.m(this.a) >= g.k(this.a) * 2 && g.n(this.a) >= g.k(this.a))) {
            g.o(this.a);
            return;
          } 
        }
      };
    this.i.b();
  }
  
  private void g() {
    this.l = true;
    this.h.a().setVisibility(0);
  }
  
  private void h() {
    String str1;
    String str2;
    String str3;
    if (TextUtils.isEmpty(this.A)) {
      str1 = "浏览页面满 %d 秒即可获得奖励\n是否继续浏览页面";
    } else {
      str1 = this.A;
    } 
    if (TextUtils.isEmpty(this.B)) {
      str2 = "继续浏览";
    } else {
      str2 = this.B;
    } 
    if (TextUtils.isEmpty(this.C)) {
      str3 = "放弃奖励";
    } else {
      str3 = this.C;
    } 
    if (this.k == null)
      this.k = new a((Context)this.a); 
    this.k.setCancelable(false);
    if (!this.k.isShowing())
      this.k.show(); 
    LinearLayout linearLayout = this.k.a((Context)this.a, String.format(Locale.getDefault(), str1, new Object[] { Integer.valueOf(this.m) }), str2, str3);
    this.k.setContentView((View)linearLayout);
    if (this.k.getWindow() != null) {
      WindowManager.LayoutParams layoutParams = this.k.getWindow().getAttributes();
      linearLayout.measure(0, 0);
      layoutParams.width = linearLayout.getMeasuredWidth();
      layoutParams.height = linearLayout.getMeasuredHeight();
      layoutParams.gravity = 17;
      this.k.getWindow().setAttributes(layoutParams);
      this.k.getWindow().setBackgroundDrawable((Drawable)ar.a(am.a((Context)this.a, 10), -1, 255));
    } 
    this.k.a().setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (g.r(this.a) != null)
              g.r(this.a).a(g.s(this.a), b.e); 
            g.p(this.a).d();
            g.t(this.a).finish();
            g g1 = this.a;
            g.a(g1, 2050005, g.s(g1));
          }
        });
    this.k.b().setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            g.d(this.a).e();
            g.u(this.a).cancel();
          }
        });
  }
  
  private String i() {
    String str;
    View view = this.b.b();
    this.D.a().a(view.getHeight());
    this.D.a().b(view.getWidth());
    view = null;
    try {
      null = this.D.b();
      str = null;
      JSONObject jSONObject = new JSONObject(null);
      str = null;
      jSONObject.put("click_area", 5);
      str = null;
      if (this.G > 0L) {
        str = null;
        jSONObject.put("p", System.currentTimeMillis() - this.G);
      } 
      str = null;
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return str;
    } 
  }
  
  public void a(int paramInt) {
    if (paramInt == 100) {
      this.h.b();
      return;
    } 
    this.h.a(paramInt);
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {
    b b1 = this.v;
    if (b1 != null)
      b1.a("", b.d); 
    this.t.a(5027);
    h.a(false, paramInt, paramString2, paramString1, this.E);
    this.a.finish();
    if (!this.L) {
      this.L = true;
      b(2050004, paramString2, paramString1);
    } 
  }
  
  public void a(ValueCallback<Uri> paramValueCallback, Intent paramIntent) {
    if (paramValueCallback != null && paramIntent != null) {
      this.x = paramValueCallback;
      this.a.startActivityForResult(paramIntent, 2);
    } 
  }
  
  public void a(String paramString) {
    b b1 = this.v;
    if (b1 != null)
      b1.a(paramString, b.c); 
    if (!this.I) {
      this.I = true;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PageFinished url=");
      stringBuilder.append(paramString);
      GDTLogger.d(stringBuilder.toString());
      this.d = System.currentTimeMillis();
      stringBuilder = new StringBuilder();
      stringBuilder.append("页面加载完成，耗时：");
      stringBuilder.append(this.d - this.e);
      GDTLogger.d(stringBuilder.toString());
      h.a(true, 0, null, null, this.E);
      a(2050003, paramString);
    } 
  }
  
  public void a(String paramString, Bitmap paramBitmap) {
    b b1 = this.v;
    if (b1 != null)
      b1.a(paramString, b.b); 
    if (!this.K) {
      this.K = true;
      a(2050002, paramString);
    } 
  }
  
  public void b() {
    if (!this.u) {
      this.G = System.currentTimeMillis();
      this.D.a(2);
      h.b(e.b, this.E);
      a.a().a(this.b.b());
      this.b.b().post(new Runnable(this) {
            public void run() {
              if (g.c(this.a) != null) {
                if (g.c(this.a).b() == null)
                  return; 
                String str = g.g(this.a).q();
                b b = new b(g.g(this.a).D(), e.k, g.g(this.a).B());
                int i = g.b(this.a).a().m();
                i.a(g.b(this.a).a(g.c(this.a).b(), i, g.g(this.a).x(), null), a.a().b(g.c(this.a).b()), g.g(this.a), b, str, new d.b(this) {
                      public void a() {
                        GDTLogger.d("RewardPage exposure success");
                        String str = g.g(this.a.a).t();
                        if (!TextUtils.isEmpty(str))
                          ah.a(str); 
                        h.a(e.b, true, g.q(this.a.a));
                      }
                      
                      public void a(int param2Int, Exception param2Exception) {
                        GDTLogger.e("RewardPage exposure error");
                        h.a(e.b, false, g.q(this.a.a));
                      }
                    });
              } 
            }
          });
      this.t.h();
      this.u = true;
    } 
  }
  
  public void b(String paramString) {
    this.f = paramString;
    if (!this.J) {
      this.J = true;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("302 to url:");
      stringBuilder.append(paramString);
      GDTLogger.d(stringBuilder.toString());
      this.e = System.currentTimeMillis();
      stringBuilder = new StringBuilder();
      stringBuilder.append("点击到302耗时：");
      stringBuilder.append(this.e - this.c);
      GDTLogger.d(stringBuilder.toString());
      a(2050001, paramString);
    } 
  }
  
  public boolean b(ValueCallback<Uri[]> paramValueCallback, Intent paramIntent) {
    if (paramValueCallback != null && paramIntent != null) {
      this.w = paramValueCallback;
      this.a.startActivityForResult(paramIntent, 1);
      return true;
    } 
    return false;
  }
  
  public void c() {
    boolean bool;
    d d1 = this.s;
    if (d1 != null && d1.z() != null) {
      String str = this.s.z().d();
      bool = l.a().a(str);
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RewardPage onADClick status:");
    stringBuilder.append(bool);
    stringBuilder.append(" isFirstClickAd:");
    stringBuilder.append(this.H);
    GDTLogger.d(stringBuilder.toString());
    if ((bool == 4 || bool == 16 || bool == 32 || bool == '') && !this.H)
      return; 
    this.D.b(System.currentTimeMillis());
    this.D.a(2);
    this.F.a(this.s, i(), this.b.b());
    this.t.e();
    this.H = false;
  }
  
  public void c(String paramString) {}
  
  public void d() {
    if (this.i == null)
      f(); 
  }
  
  public void d_() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    // Byte code:
    //   0: iconst_1
    //   1: iload_1
    //   2: if_icmpne -> 63
    //   5: aload_0
    //   6: getfield w : Landroid/webkit/ValueCallback;
    //   9: ifnull -> 63
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpne -> 45
    //   17: aload_3
    //   18: ifnull -> 45
    //   21: aload_3
    //   22: invokevirtual getData : ()Landroid/net/Uri;
    //   25: astore #4
    //   27: aload #4
    //   29: ifnull -> 45
    //   32: iconst_1
    //   33: anewarray android/net/Uri
    //   36: astore_3
    //   37: aload_3
    //   38: iconst_0
    //   39: aload #4
    //   41: aastore
    //   42: goto -> 47
    //   45: aconst_null
    //   46: astore_3
    //   47: aload_0
    //   48: getfield w : Landroid/webkit/ValueCallback;
    //   51: aload_3
    //   52: invokeinterface onReceiveValue : (Ljava/lang/Object;)V
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield w : Landroid/webkit/ValueCallback;
    //   62: return
    //   63: iconst_2
    //   64: iload_1
    //   65: if_icmpne -> 109
    //   68: aload_0
    //   69: getfield x : Landroid/webkit/ValueCallback;
    //   72: ifnull -> 109
    //   75: iload_2
    //   76: iconst_m1
    //   77: if_icmpne -> 92
    //   80: aload_3
    //   81: ifnull -> 92
    //   84: aload_3
    //   85: invokevirtual getData : ()Landroid/net/Uri;
    //   88: astore_3
    //   89: goto -> 94
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_0
    //   95: getfield x : Landroid/webkit/ValueCallback;
    //   98: aload_3
    //   99: invokeinterface onReceiveValue : (Ljava/lang/Object;)V
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield x : Landroid/webkit/ValueCallback;
    //   109: return
  }
  
  public void onAfterCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroid/app/Activity;
    //   4: invokevirtual getWindow : ()Landroid/view/Window;
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_1
    //   11: aconst_null
    //   12: invokevirtual setBackgroundDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   15: new android/widget/FrameLayout
    //   18: dup
    //   19: aload_0
    //   20: getfield a : Landroid/app/Activity;
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: astore #4
    //   28: aload_0
    //   29: getfield a : Landroid/app/Activity;
    //   32: aload #4
    //   34: new android/view/ViewGroup$LayoutParams
    //   37: dup
    //   38: iconst_m1
    //   39: iconst_m1
    //   40: invokespecial <init> : (II)V
    //   43: invokevirtual setContentView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   46: aload_0
    //   47: aload_0
    //   48: getfield a : Landroid/app/Activity;
    //   51: invokevirtual getIntent : ()Landroid/content/Intent;
    //   54: ldc_w 'clickStartTime'
    //   57: invokestatic currentTimeMillis : ()J
    //   60: invokevirtual getLongExtra : (Ljava/lang/String;J)J
    //   63: putfield c : J
    //   66: aload_0
    //   67: getfield a : Landroid/app/Activity;
    //   70: invokevirtual getIntent : ()Landroid/content/Intent;
    //   73: ldc_w 'adinfo'
    //   76: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   79: astore #5
    //   81: aload_0
    //   82: getfield a : Landroid/app/Activity;
    //   85: invokevirtual getIntent : ()Landroid/content/Intent;
    //   88: ldc_w 'appid'
    //   91: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   94: astore #6
    //   96: aload_0
    //   97: getfield a : Landroid/app/Activity;
    //   100: invokevirtual getIntent : ()Landroid/content/Intent;
    //   103: ldc_w 'posId'
    //   106: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_1
    //   110: aload_0
    //   111: new com/qq/e/comm/plugin/rewardvideo/d
    //   114: dup
    //   115: aload #5
    //   117: aload #6
    //   119: aload_1
    //   120: aload_0
    //   121: getfield a : Landroid/app/Activity;
    //   124: invokevirtual getIntent : ()Landroid/content/Intent;
    //   127: ldc_w 'adThreadId'
    //   130: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   133: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   136: putfield s : Lcom/qq/e/comm/plugin/rewardvideo/d;
    //   139: aload_0
    //   140: getfield s : Lcom/qq/e/comm/plugin/rewardvideo/d;
    //   143: getstatic com/qq/e/comm/plugin/rewardvideo/e.b : Lcom/qq/e/comm/plugin/rewardvideo/e;
    //   146: invokevirtual a : (Lcom/qq/e/comm/plugin/rewardvideo/e;)V
    //   149: aload_0
    //   150: aload_0
    //   151: getfield s : Lcom/qq/e/comm/plugin/rewardvideo/d;
    //   154: invokevirtual a : ()Ljava/lang/String;
    //   157: putfield f : Ljava/lang/String;
    //   160: aload_0
    //   161: getfield s : Lcom/qq/e/comm/plugin/rewardvideo/d;
    //   164: invokevirtual an : ()Ljava/lang/String;
    //   167: astore #6
    //   169: aload #6
    //   171: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   174: ifne -> 194
    //   177: aload_0
    //   178: new com/qq/e/comm/plugin/ab/b
    //   181: dup
    //   182: aload #6
    //   184: aload_0
    //   185: getfield c : J
    //   188: invokespecial <init> : (Ljava/lang/String;J)V
    //   191: putfield v : Lcom/qq/e/comm/plugin/ab/b;
    //   194: aload_0
    //   195: getfield E : Lcom/qq/e/comm/plugin/y/c;
    //   198: aload_1
    //   199: invokevirtual a : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   202: pop
    //   203: aload_0
    //   204: getfield E : Lcom/qq/e/comm/plugin/y/c;
    //   207: aload_0
    //   208: getfield s : Lcom/qq/e/comm/plugin/rewardvideo/d;
    //   211: invokevirtual j : ()Ljava/lang/String;
    //   214: invokevirtual b : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   217: pop
    //   218: aload_0
    //   219: getfield E : Lcom/qq/e/comm/plugin/y/c;
    //   222: aload_0
    //   223: getfield s : Lcom/qq/e/comm/plugin/rewardvideo/d;
    //   226: invokevirtual H : ()Ljava/lang/String;
    //   229: invokevirtual c : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   232: pop
    //   233: aload_0
    //   234: aload_0
    //   235: getfield a : Landroid/app/Activity;
    //   238: invokevirtual getIntent : ()Landroid/content/Intent;
    //   241: ldc_w 'objectId'
    //   244: iconst_0
    //   245: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   248: invokestatic b : (I)Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   251: putfield t : Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   254: aload_0
    //   255: getfield t : Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   258: astore_1
    //   259: aload_1
    //   260: ifnonnull -> 307
    //   263: ldc_w 'RewardPage activity fail to create ! ad instance pass failed'
    //   266: invokestatic e : (Ljava/lang/String;)V
    //   269: aload_0
    //   270: getfield v : Lcom/qq/e/comm/plugin/ab/b;
    //   273: astore_1
    //   274: aload_1
    //   275: ifnull -> 289
    //   278: aload_1
    //   279: aload_0
    //   280: getfield f : Ljava/lang/String;
    //   283: getstatic com/qq/e/comm/plugin/ab/b.e : I
    //   286: invokevirtual a : (Ljava/lang/String;I)V
    //   289: aload_0
    //   290: getfield a : Landroid/app/Activity;
    //   293: invokevirtual finish : ()V
    //   296: aload_0
    //   297: ldc 2050005
    //   299: aload_0
    //   300: getfield f : Ljava/lang/String;
    //   303: invokespecial a : (ILjava/lang/String;)V
    //   306: return
    //   307: aload_1
    //   308: invokevirtual g : ()V
    //   311: aload_0
    //   312: getfield s : Lcom/qq/e/comm/plugin/rewardvideo/d;
    //   315: invokevirtual g : ()Z
    //   318: ifne -> 343
    //   321: aload_0
    //   322: getfield t : Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   325: sipush #5001
    //   328: invokevirtual a : (I)V
    //   331: aload_0
    //   332: getfield v : Lcom/qq/e/comm/plugin/ab/b;
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull -> 289
    //   340: goto -> 278
    //   343: aload_0
    //   344: getfield t : Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   347: aload_0
    //   348: invokevirtual a : (Lcom/qq/e/comm/plugin/rewardvideo/g;)V
    //   351: aload_0
    //   352: getfield s : Lcom/qq/e/comm/plugin/rewardvideo/d;
    //   355: invokevirtual l_ : ()Lorg/json/JSONObject;
    //   358: invokestatic a : (Lorg/json/JSONObject;)Z
    //   361: ifeq -> 405
    //   364: new org/json/JSONObject
    //   367: dup
    //   368: aload #5
    //   370: invokespecial <init> : (Ljava/lang/String;)V
    //   373: astore_1
    //   374: aload_0
    //   375: aload_1
    //   376: ldc_w 'ecpm'
    //   379: iconst_m1
    //   380: invokevirtual optInt : (Ljava/lang/String;I)I
    //   383: putfield q : I
    //   386: aload_0
    //   387: aload_1
    //   388: ldc_w 'ecpm_level'
    //   391: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   394: putfield r : Ljava/lang/String;
    //   397: goto -> 405
    //   400: astore_1
    //   401: aload_1
    //   402: invokevirtual printStackTrace : ()V
    //   405: aload_0
    //   406: new com/qq/e/comm/plugin/rewardvideo/b/b
    //   409: dup
    //   410: aload_0
    //   411: getfield a : Landroid/app/Activity;
    //   414: invokespecial <init> : (Landroid/content/Context;)V
    //   417: putfield h : Lcom/qq/e/comm/plugin/rewardvideo/b/b;
    //   420: iconst_1
    //   421: ldc_w 45.0
    //   424: aload_0
    //   425: getfield a : Landroid/app/Activity;
    //   428: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   431: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   434: invokestatic applyDimension : (IFLandroid/util/DisplayMetrics;)F
    //   437: f2i
    //   438: istore_2
    //   439: new android/widget/FrameLayout$LayoutParams
    //   442: dup
    //   443: iconst_m1
    //   444: iload_2
    //   445: invokespecial <init> : (II)V
    //   448: astore_1
    //   449: aload_1
    //   450: bipush #48
    //   452: putfield gravity : I
    //   455: aload_0
    //   456: getfield h : Lcom/qq/e/comm/plugin/rewardvideo/b/b;
    //   459: aload_1
    //   460: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   463: aload_0
    //   464: getfield h : Lcom/qq/e/comm/plugin/rewardvideo/b/b;
    //   467: ldc_w -16777216
    //   470: invokevirtual setBackgroundColor : (I)V
    //   473: aload_0
    //   474: getfield h : Lcom/qq/e/comm/plugin/rewardvideo/b/b;
    //   477: new com/qq/e/comm/plugin/rewardvideo/g$1
    //   480: dup
    //   481: aload_0
    //   482: invokespecial <init> : (Lcom/qq/e/comm/plugin/rewardvideo/g;)V
    //   485: invokevirtual a : (Landroid/view/View$OnClickListener;)V
    //   488: aload_0
    //   489: getfield h : Lcom/qq/e/comm/plugin/rewardvideo/b/b;
    //   492: invokestatic getDefault : ()Ljava/util/Locale;
    //   495: ldc_w '浏览页面 %d 秒可获得奖励'
    //   498: iconst_1
    //   499: anewarray java/lang/Object
    //   502: dup
    //   503: iconst_0
    //   504: aload_0
    //   505: getfield m : I
    //   508: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   511: aastore
    //   512: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   515: invokevirtual a : (Ljava/lang/String;)V
    //   518: aload_0
    //   519: getfield n : I
    //   522: ifgt -> 536
    //   525: aload_0
    //   526: getfield h : Lcom/qq/e/comm/plugin/rewardvideo/b/b;
    //   529: invokevirtual a : ()Landroid/widget/ImageView;
    //   532: iconst_0
    //   533: invokevirtual setVisibility : (I)V
    //   536: aload #4
    //   538: aload_0
    //   539: getfield h : Lcom/qq/e/comm/plugin/rewardvideo/b/b;
    //   542: invokevirtual addView : (Landroid/view/View;)V
    //   545: aload_3
    //   546: astore_1
    //   547: aload #5
    //   549: ifnull -> 604
    //   552: new org/json/JSONObject
    //   555: dup
    //   556: aload #5
    //   558: invokespecial <init> : (Ljava/lang/String;)V
    //   561: astore_1
    //   562: goto -> 604
    //   565: astore_1
    //   566: new java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial <init> : ()V
    //   573: astore #5
    //   575: aload #5
    //   577: ldc_w 'Parse adinfo failed:'
    //   580: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload #5
    //   586: aload_1
    //   587: invokevirtual getMessage : ()Ljava/lang/String;
    //   590: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload #5
    //   596: invokevirtual toString : ()Ljava/lang/String;
    //   599: invokestatic i : (Ljava/lang/String;)V
    //   602: aload_3
    //   603: astore_1
    //   604: aload_0
    //   605: new com/qq/e/comm/plugin/ab/d/e
    //   608: dup
    //   609: aload_0
    //   610: getfield a : Landroid/app/Activity;
    //   613: aload_1
    //   614: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;)V
    //   617: invokevirtual a : ()Lcom/qq/e/comm/plugin/ab/d/a;
    //   620: putfield b : Lcom/qq/e/comm/plugin/ab/d/a;
    //   623: aload_0
    //   624: getfield b : Lcom/qq/e/comm/plugin/ab/d/a;
    //   627: aload_0
    //   628: invokeinterface a : (Lcom/qq/e/comm/plugin/ab/d/f;)V
    //   633: aload_0
    //   634: getfield b : Lcom/qq/e/comm/plugin/ab/d/a;
    //   637: aload_0
    //   638: getfield f : Ljava/lang/String;
    //   641: invokeinterface a : (Ljava/lang/String;)V
    //   646: new android/widget/FrameLayout$LayoutParams
    //   649: dup
    //   650: iconst_m1
    //   651: iconst_m1
    //   652: invokespecial <init> : (II)V
    //   655: astore_1
    //   656: aload_1
    //   657: iload_2
    //   658: putfield topMargin : I
    //   661: aload_0
    //   662: getfield b : Lcom/qq/e/comm/plugin/ab/d/a;
    //   665: invokeinterface b : ()Landroid/view/View;
    //   670: aload_1
    //   671: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   674: aload_0
    //   675: getfield b : Lcom/qq/e/comm/plugin/ab/d/a;
    //   678: invokeinterface c : ()Lcom/qq/e/comm/plugin/ab/f/e;
    //   683: ldc_w 'rewardAD'
    //   686: new com/qq/e/comm/plugin/rewardvideo/a/a
    //   689: dup
    //   690: aload_0
    //   691: invokespecial <init> : (Lcom/qq/e/comm/plugin/rewardvideo/g;)V
    //   694: invokevirtual a : (Ljava/lang/String;Lcom/qq/e/comm/plugin/ab/f/a/c;)V
    //   697: aload_0
    //   698: getfield b : Lcom/qq/e/comm/plugin/ab/d/a;
    //   701: invokeinterface b : ()Landroid/view/View;
    //   706: new com/qq/e/comm/plugin/rewardvideo/g$2
    //   709: dup
    //   710: aload_0
    //   711: invokespecial <init> : (Lcom/qq/e/comm/plugin/rewardvideo/g;)V
    //   714: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   717: aload #4
    //   719: aload_0
    //   720: getfield b : Lcom/qq/e/comm/plugin/ab/d/a;
    //   723: invokeinterface b : ()Landroid/view/View;
    //   728: invokevirtual addView : (Landroid/view/View;)V
    //   731: new android/os/Handler
    //   734: dup
    //   735: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   738: invokespecial <init> : (Landroid/os/Looper;)V
    //   741: new com/qq/e/comm/plugin/rewardvideo/g$3
    //   744: dup
    //   745: aload_0
    //   746: invokespecial <init> : (Lcom/qq/e/comm/plugin/rewardvideo/g;)V
    //   749: aload_0
    //   750: getfield j : I
    //   753: sipush #1000
    //   756: imul
    //   757: i2l
    //   758: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   761: pop
    //   762: aload_0
    //   763: aload_0
    //   764: getfield a : Landroid/app/Activity;
    //   767: invokevirtual getIntent : ()Landroid/content/Intent;
    //   770: ldc_w 'rewardAdUnmetLeftTopText'
    //   773: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   776: putfield y : Ljava/lang/String;
    //   779: aload_0
    //   780: aload_0
    //   781: getfield a : Landroid/app/Activity;
    //   784: invokevirtual getIntent : ()Landroid/content/Intent;
    //   787: ldc_w 'rewardAdHasDoneLeftTopText'
    //   790: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   793: putfield z : Ljava/lang/String;
    //   796: aload_0
    //   797: aload_0
    //   798: getfield a : Landroid/app/Activity;
    //   801: invokevirtual getIntent : ()Landroid/content/Intent;
    //   804: ldc_w 'rewardAdCloseDialogText'
    //   807: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   810: putfield A : Ljava/lang/String;
    //   813: aload_0
    //   814: aload_0
    //   815: getfield a : Landroid/app/Activity;
    //   818: invokevirtual getIntent : ()Landroid/content/Intent;
    //   821: ldc_w 'rewardAdConfirmButtonText'
    //   824: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   827: putfield B : Ljava/lang/String;
    //   830: aload_0
    //   831: aload_0
    //   832: getfield a : Landroid/app/Activity;
    //   835: invokevirtual getIntent : ()Landroid/content/Intent;
    //   838: ldc_w 'rewardAdCancelButtonText'
    //   841: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   844: putfield C : Ljava/lang/String;
    //   847: aload_0
    //   848: new com/qq/e/comm/plugin/rewardvideo/f
    //   851: dup
    //   852: new com/qq/e/comm/plugin/rewardvideo/g$4
    //   855: dup
    //   856: aload_0
    //   857: aload_0
    //   858: getfield a : Landroid/app/Activity;
    //   861: invokespecial <init> : (Lcom/qq/e/comm/plugin/rewardvideo/g;Landroid/content/Context;)V
    //   864: invokespecial <init> : (Lcom/qq/e/comm/plugin/c/a/c;)V
    //   867: putfield F : Lcom/qq/e/comm/plugin/rewardvideo/f;
    //   870: return
    // Exception table:
    //   from	to	target	type
    //   364	397	400	org/json/JSONException
    //   552	562	565	java/lang/Exception
  }
  
  public void onBackPressed() {
    if (this.p)
      e(); 
  }
  
  public void onBeforeCreate(Bundle paramBundle) {
    this.a.requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21)
      this.a.getWindow().setStatusBarColor(-16777216); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy() {
    this.u = true;
    b b1 = this.v;
    if (b1 != null)
      b1.a(this.f, b.g); 
    a a1 = this.b;
    if (a1 != null) {
      a1.a();
      this.b = null;
    } 
    az az1 = this.i;
    if (az1 != null) {
      az1.c();
      this.i = null;
    } 
  }
  
  public void onPause() {
    if (this.i != null) {
      a a1 = this.k;
      if (a1 == null || !a1.isShowing())
        this.i.d(); 
    } 
    b b1 = this.v;
    if (b1 != null)
      b1.a(this.f, b.f); 
    try {
      if (this.b.b() != null) {
        this.b.b().getClass().getMethod("onPause", new Class[0]).invoke(this.b.b(), (Object[])null);
        this.g = true;
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InnerBrowser onPause err");
      stringBuilder.append(exception);
      GDTLogger.e(stringBuilder.toString());
    } 
  }
  
  public void onResume() {
    if (this.i != null) {
      a a1 = this.k;
      if (a1 == null || !a1.isShowing())
        this.i.e(); 
    } 
    try {
      if (this.g) {
        if (this.b.b() != null)
          this.b.b().getClass().getMethod("onResume", new Class[0]).invoke(this.b.b(), (Object[])null); 
        this.g = false;
        return;
      } 
    } catch (Exception exception) {
      GDTLogger.e("InnerBrowser onResume err");
    } 
  }
  
  public void onStop() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */