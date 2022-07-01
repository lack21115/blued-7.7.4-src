package com.geetest.onelogin.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebViewClient;
import com.cmic.sso.sdk.AuthRegisterViewConfig;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.a.e;
import com.geetest.onelogin.a.f;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.c.a;
import com.geetest.onelogin.config.AuthRegisterViewConfig;
import com.geetest.onelogin.config.OneLoginThemeConfig;
import com.geetest.onelogin.h.a;
import com.geetest.onelogin.i.c;
import com.geetest.onelogin.i.d;
import com.geetest.onelogin.i.e;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.j;
import com.geetest.onelogin.j.l;
import com.geetest.onelogin.j.p;
import com.geetest.onelogin.listener.AbstractOneLoginListener;
import com.geetest.onelogin.listener.CustomInterface;
import com.geetest.onelogin.listener.SecurityPhoneListener;
import com.geetest.onelogin.listener.a.a;
import com.geetest.onelogin.listener.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private static volatile b a;
  
  private WebViewClient A = null;
  
  private volatile boolean B = true;
  
  private boolean C = false;
  
  private boolean D = false;
  
  private final Handler E = new Handler(this, Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        if (param1Message.what != 1)
          return; 
        b.a(this.a, true);
        b.a(this.a, 10000, param1Message.arg1, (AbstractOneLoginListener)null);
      }
    };
  
  private Context b;
  
  private volatile boolean c;
  
  private volatile boolean d = false;
  
  private boolean e = true;
  
  private String f = "https://onepass.geetest.com";
  
  private d g;
  
  private String h;
  
  private f i = new f();
  
  private e j;
  
  private d k;
  
  private AbstractOneLoginListener l;
  
  private AbstractOneLoginListener m;
  
  private Map<AbstractOneLoginListener, Boolean> n;
  
  private Runnable o;
  
  private ScheduledExecutorService p;
  
  private volatile boolean q = false;
  
  private volatile boolean r = false;
  
  private int s = -1;
  
  private volatile boolean t = false;
  
  private volatile boolean u = false;
  
  private boolean v;
  
  private int w = 1;
  
  private OneLoginThemeConfig x;
  
  private boolean y = false;
  
  private HashMap<String, AuthRegisterViewConfig> z = new HashMap<String, AuthRegisterViewConfig>();
  
  private boolean T() {
    if (this.s == 1)
      return false; 
    this.s = 0;
    h.b("current mode: 0");
    return true;
  }
  
  private boolean U() {
    if (this.s == 0)
      return false; 
    this.s = 1;
    h.b("current mode: 1");
    return true;
  }
  
  private void V() {
    if (!D() && this.b != null) {
      Log.e("Geetest_OneLogin", "reinit in preGetTokenConfig");
      a(this.b);
    } 
    if (this.i.b()) {
      h.b("已预配置运营商参数");
      return;
    } 
    String str = e();
    d d1 = new d();
    d1.setProcessId(str);
    d1.setAppId(this.h);
    d1.setApiServer(this.f);
    d1.setRandom(l.a(str));
    if (this.b == null) {
      h.c("当前传入的 Context 为 null");
      return;
    } 
    if (TextUtils.isEmpty(this.h)) {
      h.c("当前传入的 APP_ID 为 null");
      return;
    } 
    this.j = new e(this.b);
    this.j.a(d1);
  }
  
  private int a(int paramInt) {
    int i = paramInt;
    if (paramInt < 1000)
      i = 1000; 
    paramInt = i;
    if (i > 15000)
      paramInt = 15000; 
    return paramInt;
  }
  
  private AuthRegisterViewConfig a(AuthRegisterViewConfig paramAuthRegisterViewConfig) {
    if (paramAuthRegisterViewConfig != null)
      return (new AuthRegisterViewConfig.Builder()).setView(paramAuthRegisterViewConfig.getView()).setRootViewId(paramAuthRegisterViewConfig.getRootViewId()).setCustomInterface(new CustomInterface(this, paramAuthRegisterViewConfig) {
            public void onClick(Context param1Context) {
              if (this.a.getCustomInterface() != null)
                this.a.getCustomInterface().onClick(param1Context); 
            }
          }).build(); 
    h.c("addOneLoginRegisterViewConfig error, authRegisterViewConfig is null");
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, AbstractOneLoginListener paramAbstractOneLoginListener) {
    if (!D() && this.b != null) {
      Log.e("Geetest_OneLogin", "reinit in realPreToken");
      a(this.b);
    } 
    h.b("开始预取号");
    p.a().a("PRE_GET_TOKEN:P");
    a.a(this.b, this.e);
    a(paramAbstractOneLoginListener, true);
    String str = e();
    this.g = new d();
    this.g.setProcessId(str);
    this.g.setAppId(this.h);
    this.g.setApiServer(this.f);
    this.g.setSdkTimeout(paramInt1);
    this.g.setRequestTimeout(paramInt2);
    this.g.setRandom(l.a(str));
    if (this.b == null) {
      h.c("当前传入的 Context 为 null");
      c.a(this.g, a.a(a.i, this.g, a.a("The Context is null")), true);
      return;
    } 
    if (TextUtils.isEmpty(this.h)) {
      h.c("当前传入的 APP_ID 为 null");
      c.a(this.g, a.a(a.a, this.g, a.a("The APP_ID is null")), true);
      return;
    } 
    if (this.j == null)
      this.j = new e(this.b); 
    this.j.b(this.g);
  }
  
  private void a(int paramInt, AbstractOneLoginListener paramAbstractOneLoginListener) {
    h.b("准备预取号");
    p.a().a("preTokenInner");
    d d1 = this.g;
    if (d1 != null && !d1.isPreGetTokenComplete()) {
      if (k()) {
        h.d("请勿重复调用 register 进行多次预取号");
        return;
      } 
      h.d("请勿重复调用 preGetToken 进行多次预取号");
      return;
    } 
    paramInt = a(paramInt);
    this.v = true;
    P();
    this.w = 1;
    if (paramAbstractOneLoginListener == null) {
      this.q = true;
      a(10000, paramInt, (AbstractOneLoginListener)null);
      return;
    } 
    this.q = false;
    a(paramInt, paramInt, paramAbstractOneLoginListener);
  }
  
  private void a(AbstractOneLoginListener paramAbstractOneLoginListener, boolean paramBoolean) {
    if (this.n == null)
      this.n = new HashMap<AbstractOneLoginListener, Boolean>(); 
    if (paramBoolean) {
      AbstractOneLoginListener abstractOneLoginListener = this.l;
      if (abstractOneLoginListener != null)
        this.n.put(abstractOneLoginListener, Boolean.valueOf(false)); 
      this.l = paramAbstractOneLoginListener;
    } else {
      AbstractOneLoginListener abstractOneLoginListener = this.m;
      if (abstractOneLoginListener != null)
        this.n.put(abstractOneLoginListener, Boolean.valueOf(false)); 
      this.m = paramAbstractOneLoginListener;
    } 
    this.n.put(paramAbstractOneLoginListener, Boolean.valueOf(true));
  }
  
  private void b(OneLoginThemeConfig paramOneLoginThemeConfig, AbstractOneLoginListener paramAbstractOneLoginListener) {
    if (E()) {
      c.a("requestToken checkPreToken 1");
      c(paramOneLoginThemeConfig, paramAbstractOneLoginListener);
      return;
    } 
    c.a("requestToken checkPreToken 2");
    c.b(this.g);
    a(this.g.getRequestTimeout(), this.g.getRequestTimeout(), (AbstractOneLoginListener)new com.geetest.onelogin.listener.b(this, paramOneLoginThemeConfig, paramAbstractOneLoginListener) {
          public void onResult(JSONObject param1JSONObject) {
            if (!b.b(this.c)) {
              b.b(this.c, true);
              try {
                if (param1JSONObject.getInt("status") == 200) {
                  b.a(this.c, this.a, this.b);
                  return;
                } 
                this.b.onResult(param1JSONObject);
                return;
              } catch (JSONException jSONException) {
                this.b.onResult(param1JSONObject);
              } 
            } 
          }
        });
  }
  
  private void c(OneLoginThemeConfig paramOneLoginThemeConfig, AbstractOneLoginListener paramAbstractOneLoginListener) {
    h.b("开始取号");
    if (k() && paramOneLoginThemeConfig != null)
      c.a(this.g); 
    boolean bool = false;
    a(paramAbstractOneLoginListener, false);
    this.g.setMessage(null);
    this.g.setRequestTokenComplete(false);
    this.g.setRequestTokenSuccess(false);
    c.a(this.g.getNumber());
    this.k = new d(this.b, this.g);
    d d1 = this.k;
    if (paramOneLoginThemeConfig == null)
      bool = true; 
    d1.a(bool);
  }
  
  private void checkPreToken(SecurityPhoneListener paramSecurityPhoneListener) {
    if (E()) {
      c.a("requestSecurityPhone checkPreToken 1");
      if (k())
        c.a(this.g); 
      paramSecurityPhoneListener.onSuccess(this.g.getNumber());
      return;
    } 
    c.a("requestSecurityPhone checkPreToken 2");
    c.b(this.g);
    a(this.g.getRequestTimeout(), this.g.getRequestTimeout(), (AbstractOneLoginListener)new com.geetest.onelogin.listener.b(this, paramSecurityPhoneListener) {
          public void onResult(JSONObject param1JSONObject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("checkPreToken->realPreToken isRequest=");
            stringBuilder.append(b.b(this.b));
            stringBuilder.append(", jsonObject=");
            stringBuilder.append(param1JSONObject);
            c.a(stringBuilder.toString());
            if (!b.b(this.b)) {
              b.b(this.b, true);
              try {
                if (param1JSONObject.getInt("status") == 200) {
                  if (this.b.k())
                    c.a(b.c(this.b)); 
                  this.a.onSuccess(b.c(this.b).getNumber());
                  return;
                } 
                this.a.onFailed(param1JSONObject);
                return;
              } catch (JSONException jSONException) {
                this.a.onFailed(param1JSONObject);
              } 
            } 
          }
        });
  }
  
  public static b w() {
    // Byte code:
    //   0: getstatic com/geetest/onelogin/f/b.a : Lcom/geetest/onelogin/f/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/geetest/onelogin/f/b
    //   8: monitorenter
    //   9: getstatic com/geetest/onelogin/f/b.a : Lcom/geetest/onelogin/f/b;
    //   12: ifnonnull -> 25
    //   15: new com/geetest/onelogin/f/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/geetest/onelogin/f/b.a : Lcom/geetest/onelogin/f/b;
    //   25: ldc com/geetest/onelogin/f/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/geetest/onelogin/f/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/geetest/onelogin/f/b.a : Lcom/geetest/onelogin/f/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public OneLoginThemeConfig A() {
    OneLoginThemeConfig oneLoginThemeConfig2 = this.x;
    OneLoginThemeConfig oneLoginThemeConfig1 = oneLoginThemeConfig2;
    if (oneLoginThemeConfig2 == null)
      oneLoginThemeConfig1 = (new OneLoginThemeConfig.Builder()).build(); 
    return oneLoginThemeConfig1;
  }
  
  public void B() {
    d d1 = this.k;
    if (d1 != null) {
      if (!this.D)
        return; 
      d1.b();
    } 
  }
  
  public void C() {
    h.b("dismissAuthActivity is called");
    d d1 = this.k;
    if (d1 == null)
      return; 
    d1.c();
  }
  
  public boolean D() {
    return this.c;
  }
  
  public boolean E() {
    d d1 = this.g;
    return (d1 != null && d1.isPreTokenSuccess() && this.g.isPreTokenValidate() && this.g.isPreGetTokenComplete() && !J() && !H() && !j.a(this.g, this.b));
  }
  
  public boolean F() {
    d d1 = this.g;
    return (d1 != null && d1.isPreTokenSuccess());
  }
  
  public boolean G() {
    d d1 = this.g;
    return (d1 != null && d1.isPreGetTokenComplete());
  }
  
  public boolean H() {
    d d1 = this.g;
    return (d1 != null && d1.isRequestTokenSuccess());
  }
  
  public boolean I() {
    d d1 = this.g;
    return (d1 != null && d1.isRequestTokenComplete());
  }
  
  public boolean J() {
    d d1 = this.g;
    return (d1 != null) ? d1.isAccessCodeExpired() : true;
  }
  
  public String K() {
    d d1 = this.g;
    return (d1 == null) ? null : d1.getNumber();
  }
  
  public void L() {
    c.b();
  }
  
  public void M() {
    this.l = null;
    this.m = null;
  }
  
  public void N() {
    this.z = null;
  }
  
  public void O() {
    this.A = null;
  }
  
  public void P() {
    this.E.removeCallbacksAndMessages(null);
  }
  
  public void Q() {
    ScheduledExecutorService scheduledExecutorService = this.p;
    if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown())
      this.p.shutdownNow(); 
  }
  
  public void R() {
    d d2 = this.g;
    if (d2 != null)
      d2.setCanceled(true); 
    e e1 = this.j;
    if (e1 != null)
      e1.a(); 
    d d1 = this.k;
    if (d1 != null)
      d1.a(); 
    this.b = null;
    this.l = null;
    this.m = null;
    this.x = null;
    this.A = null;
    a = null;
    this.i.e();
    this.c = false;
    this.d = false;
    this.n.clear();
    a.b();
    h.b("cancel is called");
  }
  
  public void S() {
    try {
      if (this.k != null)
        this.k.a(); 
      if (this.m != null)
        this.n.put(this.m, Boolean.valueOf(false)); 
      if (this.n != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cancelRequestToken requestListener=");
        stringBuilder.append(this.m);
        stringBuilder.append(", state=");
        stringBuilder.append(this.n.get(this.m));
        c.a(stringBuilder.toString());
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(long paramLong) {
    int i = this.w;
    if (i >= 5) {
      if (this.v) {
        P();
        this.v = false;
      } 
      return;
    } 
    this.w = i + 1;
    if (F()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("预取号将在");
      stringBuilder.append(paramLong / 1000L);
      stringBuilder.append("秒后失效，失效后自动开始第");
      stringBuilder.append(this.w);
      stringBuilder.append("次重试");
      h.b(stringBuilder.toString());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong / 1000L);
      stringBuilder.append("秒后开始第");
      stringBuilder.append(this.w);
      stringBuilder.append("次重试");
      h.b(stringBuilder.toString());
    } 
    long l = SystemClock.uptimeMillis();
    if (this.o == null)
      this.o = new Runnable(this) {
          public void run() {
            Message message = b.a(this.a).obtainMessage(1);
            message.arg1 = 10000;
            message.sendToTarget();
          }
        }; 
    this.E.postAtTime(this.o, l + paramLong);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(Context paramContext) {
    if (this.c)
      return; 
    a.a(paramContext);
    if (!a.c())
      h.d("请尽量只在主进程初始化"); 
    if (paramContext == null)
      h.d("当前传入的 Context 为 null"); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SDK 版本为: 2.1.4.1, Android 版本为: ");
    stringBuilder.append(Build.VERSION.RELEASE);
    h.b(stringBuilder.toString());
    if (paramContext == null) {
      paramContext = a.a();
    } else {
      paramContext = paramContext.getApplicationContext();
    } 
    this.b = paramContext;
    this.c = true;
    this.n = new HashMap<AbstractOneLoginListener, Boolean>();
    c.a(1);
    p.a().a(false);
  }
  
  public void a(Context paramContext, String paramString) {
    this.h = paramString;
    this.d = true;
    a(paramContext);
    V();
  }
  
  public void a(WebViewClient paramWebViewClient) {
    this.A = paramWebViewClient;
  }
  
  public void a(OneLoginThemeConfig paramOneLoginThemeConfig, AbstractOneLoginListener paramAbstractOneLoginListener) {
    d d1;
    if (i())
      h.d("请先进行预取号，再调用取号"); 
    h.b("准备取号");
    P();
    this.w = 5;
    if (!D() && this.b != null) {
      c.a("reinit in requestToken");
      a(this.b);
    } 
    if (paramAbstractOneLoginListener == null) {
      h.d("当前传入的 AbstractOneLoginListener 为 null");
      return;
    } 
    a(paramAbstractOneLoginListener, false);
    if (paramOneLoginThemeConfig != null) {
      this.x = paramOneLoginThemeConfig;
      this.B = paramOneLoginThemeConfig.isPrivacyState();
    } 
    this.q = false;
    this.r = false;
    if (this.g == null) {
      d1 = new d();
      d1.setAppId(this.h);
      d1.setApiServer(this.f);
      if (paramOneLoginThemeConfig == null) {
        c.a(d1, a.d(a.b, d1, a.a(c("requestToken"))), false);
        return;
      } 
      c.a(d1, a.b(a.b, d1, a.a(c("requestToken"))), false);
      return;
    } 
    if (!G()) {
      h.c("当前预取号没有完成");
      if (k()) {
        this.t = true;
        return;
      } 
      d1 = new d();
      d1.setAppId(this.g.getAppId());
      d1.setOperator(this.g.getOperator());
      d1.setProcessId(this.g.getProcessId());
      d1.setApiServer(this.f);
      if (paramOneLoginThemeConfig == null) {
        c.a(d1, a.d(a.b, d1, a.a("Current preGetToken is not finished")), false);
        return;
      } 
      c.a(d1, a.b(a.b, d1, a.a("Current preGetToken is not finished")), false);
      return;
    } 
    if (k()) {
      b(paramOneLoginThemeConfig, (AbstractOneLoginListener)d1);
      return;
    } 
    c(paramOneLoginThemeConfig, (AbstractOneLoginListener)d1);
  }
  
  public void a(String paramString) {
    this.f = paramString;
  }
  
  public void a(String paramString, int paramInt) {
    if (!U()) {
      h.d("register 模式错误，请不要新老逻辑混用");
      return;
    } 
    if (TextUtils.isEmpty(this.h))
      this.h = paramString; 
    a(paramInt, (AbstractOneLoginListener)null);
  }
  
  public void a(String paramString, int paramInt, AbstractOneLoginListener paramAbstractOneLoginListener) {
    if (!T()) {
      h.d("preGetToken 模式错误，请不要新老逻辑混用");
      return;
    } 
    if (TextUtils.isEmpty(this.h))
      this.h = paramString; 
    a(paramInt, paramAbstractOneLoginListener);
  }
  
  @Deprecated
  public void a(String paramString, AuthRegisterViewConfig paramAuthRegisterViewConfig) {
    AuthRegisterViewConfig authRegisterViewConfig = a(paramAuthRegisterViewConfig);
    if (authRegisterViewConfig != null)
      a(paramString, authRegisterViewConfig); 
  }
  
  public void a(String paramString, AuthRegisterViewConfig paramAuthRegisterViewConfig) {
    if (this.z == null)
      this.z = new HashMap<String, AuthRegisterViewConfig>(); 
    this.y = true;
    this.z.put(paramString, paramAuthRegisterViewConfig);
  }
  
  public void a(String paramString1, String paramString2, int paramInt) {
    a.a(paramString1, paramString2, a(paramInt));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2) && !TextUtils.isEmpty(paramString3)) {
      if (paramInt <= 0)
        return; 
      String str = paramString1.toLowerCase();
      e e2 = this.i.c(str);
      e e1 = e2;
      if (e2 == null)
        e1 = new e(); 
      e1.a(str);
      e1.b(paramString2);
      e1.c(paramString3);
      e1.a(paramInt);
      this.i.a(str, e1);
      if (this.i.c() >= 3)
        this.i.a(true); 
    } 
  }
  
  public void a(ScheduledExecutorService paramScheduledExecutorService) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setTokenTimeoutService old_tokenTimeoutService=");
    stringBuilder.append(this.p);
    stringBuilder.append(", new_tokenTimeoutService=");
    stringBuilder.append(paramScheduledExecutorService);
    c.a(stringBuilder.toString());
    Q();
    this.p = paramScheduledExecutorService;
  }
  
  public void a(JSONObject paramJSONObject, String paramString) {
    d d1 = this.k;
    if (d1 == null) {
      h.c("callBackResult requestToken is null");
      return;
    } 
    d1.a(paramJSONObject, paramString);
  }
  
  public void a(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString) {
    byte b1;
    if (paramBoolean) {
      b1 = 1;
    } else {
      b1 = 6;
    } 
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "Geetest_OneLogin"; 
    h.a(b1, str);
    this.e = paramBoolean;
  }
  
  public boolean a() {
    return this.e;
  }
  
  public Context b() {
    return this.b;
  }
  
  public String b(Context paramContext) {
    return j.b(paramContext);
  }
  
  public void b(String paramString) {
    this.i.a(paramString);
  }
  
  public void b(boolean paramBoolean) {
    this.D = paramBoolean;
  }
  
  public String c(String paramString) {
    String str;
    if (k()) {
      str = "register";
    } else {
      str = "preGetToken";
    } 
    return String.format("Please call %s before calling %s", new Object[] { str, paramString });
  }
  
  public void c() {
    h.b("privatization mode is enabled");
    this.C = true;
  }
  
  public void c(boolean paramBoolean) {
    byte b1;
    if (paramBoolean) {
      b1 = 1;
    } else {
      b1 = 6;
    } 
    h.a(b1, "Geetest_OneLogin");
    this.e = paramBoolean;
  }
  
  public String d(String paramString) {
    String str;
    if (k()) {
      str = "register";
    } else {
      str = "preGetToken";
    } 
    return String.format("Please call %s while %s", new Object[] { str, paramString });
  }
  
  public boolean d() {
    return this.C;
  }
  
  public String e() {
    return l.a();
  }
  
  public boolean f() {
    return this.y;
  }
  
  public HashMap<String, AuthRegisterViewConfig> g() {
    return this.z;
  }
  
  public WebViewClient h() {
    return this.A;
  }
  
  public boolean i() {
    return (this.s == -1);
  }
  
  public boolean j() {
    return (this.s == 0);
  }
  
  public boolean k() {
    return (this.s == 1);
  }
  
  public d l() {
    return this.g;
  }
  
  public f m() {
    return this.i;
  }
  
  public AbstractOneLoginListener n() {
    return this.l;
  }
  
  public AbstractOneLoginListener o() {
    return this.m;
  }
  
  public boolean p() {
    AbstractOneLoginListener abstractOneLoginListener = this.l;
    return (abstractOneLoginListener != null) ? ((Boolean)this.n.get(abstractOneLoginListener)).booleanValue() : false;
  }
  
  public boolean q() {
    AbstractOneLoginListener abstractOneLoginListener = this.m;
    return (abstractOneLoginListener != null) ? ((Boolean)this.n.get(abstractOneLoginListener)).booleanValue() : false;
  }
  
  public void r() {
    if (this.i.c() >= 1)
      this.i.a(true); 
  }
  
  public void requestSecurityPhone(SecurityPhoneListener paramSecurityPhoneListener) {
    if (i()) {
      h.d("请先进行预取号，再获取脱敏手机号");
      return;
    } 
    h.b("准备获取脱敏手机号");
    P();
    this.w = 5;
    if (!D() && this.b != null) {
      c.a("reinit in requestToken");
      a(this.b);
    } 
    if (paramSecurityPhoneListener == null) {
      h.d("当前传入的 SecurityPhoneListener 为 null");
      return;
    } 
    this.q = false;
    this.r = false;
    d d1 = this.g;
    if (d1 == null) {
      d1 = new d();
      d1.setApiServer(this.f);
      paramSecurityPhoneListener.onFailed(a.c(a.b, d1, a.a(c("requestSecurityPhone"))));
      return;
    } 
    d1.setSecurityPhoneListener(paramSecurityPhoneListener);
    if (!G()) {
      h.c("当前预取号没有完成");
      if (k()) {
        this.u = true;
        return;
      } 
      d1 = new d();
      d1.setApiServer(this.f);
      paramSecurityPhoneListener.onFailed(a.c(a.b, d1, a.a("Current preGetToken is not finished")));
      return;
    } 
    checkPreToken(paramSecurityPhoneListener);
  }
  
  public boolean s() {
    return this.q;
  }
  
  public boolean t() {
    return this.B;
  }
  
  public boolean u() {
    return this.D;
  }
  
  public boolean v() {
    return (this.t || this.u);
  }
  
  public String x() {
    return "2.1.4.1";
  }
  
  public void y() {
    c.a();
  }
  
  public void z() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("preSuccess hasPendingRequestToken=");
    stringBuilder.append(this.t);
    stringBuilder.append(", hasPendingRequestSecPhone=");
    stringBuilder.append(this.u);
    c.a(stringBuilder.toString());
    if (this.t) {
      h.c("当前预取号完成");
      this.t = false;
      b(this.x, this.m);
    } 
    if (this.u) {
      h.c("当前预取号完成");
      this.u = false;
      checkPreToken(this.g.getSecurityPhoneListener());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */