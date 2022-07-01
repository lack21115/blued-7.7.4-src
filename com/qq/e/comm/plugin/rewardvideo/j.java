package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.comm.plugin.s.i;
import com.qq.e.comm.plugin.t.b;
import com.qq.e.comm.plugin.t.b.c;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.t.d;
import com.qq.e.comm.plugin.util.ae;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.as;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import yaq.gdtadv;

public class j implements RVADI, a {
  private static HashMap<Integer, WeakReference<j>> v = new HashMap<Integer, WeakReference<j>>();
  
  private LoadAdParams A = null;
  
  private boolean B = false;
  
  private final Map<String, m> C = new HashMap<String, m>(2);
  
  private final String a = getClass().getSimpleName();
  
  private final String b;
  
  private final l c;
  
  private final ADListener d;
  
  private final String e;
  
  private int f;
  
  private int g;
  
  private String[] h;
  
  private volatile boolean i = false;
  
  private long j = 0L;
  
  private int k = -1;
  
  private int l = -1;
  
  private boolean m;
  
  private String n;
  
  private int o;
  
  private int p = -1;
  
  private b q;
  
  private final Handler r = new a(this);
  
  private e s = e.a;
  
  private c t = new c();
  
  private final int u;
  
  private volatile WeakReference<l> w;
  
  private volatile WeakReference<g> x;
  
  private String y;
  
  private boolean z = true;
  
  public j(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    this(paramContext, paramString1, paramString2, l.a, paramADListener);
  }
  
  public j(Context paramContext, String paramString1, String paramString2, l paraml, ADListener paramADListener) {
    this.b = paramString2;
    this.t.a(paramString2);
    this.c = paraml;
    this.f = n.b();
    this.d = paramADListener;
    this.e = com.qq.e.comm.plugin.util.a.a(paramString1, paramString2, o.b());
    this.u = ae.a();
    v.put(Integer.valueOf(this.u), new WeakReference<j>(this));
    this.q = new b();
  }
  
  private c a(JSONObject paramJSONObject) {
    c c1 = new c();
    c1.a(this.b);
    if (paramJSONObject != null) {
      c1.b(paramJSONObject.optString("cl"));
      c1.c(paramJSONObject.optString("traceid"));
    } 
    return c1;
  }
  
  private void a(Context paramContext, boolean paramBoolean) {
    boolean bool;
    h.c(this.s, this.t);
    if (this.h == null) {
      bool = true;
    } else if (this.i) {
      bool = true;
    } else if (SystemClock.elapsedRealtime() > this.j) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      a(bool);
      h.a(this.s, bool, this.t);
      return;
    } 
    if (this.s != e.b) {
      b(paramContext, paramBoolean);
      return;
    } 
    a(paramContext, paramBoolean, this.h[0]);
  }
  
  private void a(Context paramContext, boolean paramBoolean, String paramString) {
    ak.a(this.a, "jumpToRewardPage");
    Intent intent = new Intent();
    intent.setClassName(paramContext, at.b());
    intent.putExtra("gdt_activity_delegate_name", "rewardPage");
    intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
    intent.putExtra("objectId", this.u);
    intent.putExtra("clickStartTime", System.currentTimeMillis());
    intent.putExtra("adinfo", paramString);
    intent.putExtra("posId", this.b);
    intent.putExtra("adThreadId", this.e);
    if (paramBoolean)
      intent.addFlags(268435456); 
    paramContext.startActivity(intent);
  }
  
  private void a(List<JSONObject> paramList) {
    e e1;
    this.g = paramList.size();
    this.j = n.c();
    this.h = new String[this.g];
    this.i = false;
    for (int i = 0; i < this.g; i++) {
      JSONObject jSONObject1 = paramList.get(i);
      this.h[i] = jSONObject1.toString();
    } 
    if (paramList.size() <= 0) {
      c(5014);
      return;
    } 
    JSONObject jSONObject = paramList.get(0);
    if (TextUtils.isEmpty(jSONObject.optString("video"))) {
      e1 = e.b;
    } else {
      e1 = e.a;
    } 
    this.s = e1;
    this.t.b(jSONObject.optString("cl"));
    this.t.c(jSONObject.optString("traceid"));
    this.k = com.qq.e.comm.plugin.s.a.d(jSONObject);
    this.l = -1;
    String str = jSONObject.optString("mp");
    if (!TextUtils.isEmpty(str))
      try {
        this.l = Integer.parseInt(new String(as.b(Base64.decode(str, 0)), com.qq.e.comm.plugin.f.a.a));
      } catch (com.qq.e.comm.plugin.util.as.b b1) {
        b1.printStackTrace();
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ad response mp origin value: ");
    stringBuilder.append(str);
    stringBuilder.append(" decryption value: ");
    stringBuilder.append(this.l);
    GDTLogger.d(stringBuilder.toString());
    this.n = jSONObject.optString("ecpm_level");
    this.o = jSONObject.optInt("video_duration");
    this.p = i.b(jSONObject);
    this.m = com.qq.e.comm.plugin.s.a.f(jSONObject);
  }
  
  private void a(boolean paramBoolean) {
    String str = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("callbackADCache, realAdCount : ");
    stringBuilder.append(this.g);
    ak.a(str, stringBuilder.toString());
    this.r.sendEmptyMessage(2);
    h.a(this.s, paramBoolean, true, this.t, null, null);
  }
  
  static j b(int paramInt) {
    WeakReference<j> weakReference = v.get(Integer.valueOf(paramInt));
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  private void b(Context paramContext, boolean paramBoolean) {
    String str;
    ak.a(this.a, "jumpToRewardVideo");
    Intent intent = new Intent();
    if ("l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation())) {
      if (m()) {
        str = at.e();
      } else {
        str = at.d();
      } 
    } else if (m()) {
      str = at.c();
    } else {
      str = at.b();
    } 
    intent.setClassName(paramContext, str);
    intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
    intent.putExtra("gdt_activity_delegate_name", "rewardVideo");
    intent.putExtra("adThreadId", this.e);
    intent.putExtra("posId", this.b);
    intent.putExtra("adinfo", this.h[0]);
    intent.putExtra("objectId", this.u);
    intent.putExtra("rewardVideoExpireTime", this.j);
    if (!TextUtils.isEmpty(this.y))
      intent.putExtra("styleUrl", this.y); 
    if (paramBoolean)
      intent.addFlags(268435456); 
    paramContext.startActivity(intent);
  }
  
  private void b(String paramString) {
    ak.b("gdt_tag_reward_video", "downloadHtmlFile（%s）", new Object[] { paramString });
    if (!TextUtils.isEmpty(paramString)) {
      File file = aj.e(paramString);
      if (file != null && !file.exists()) {
        ak.b("gdt_tag_reward_video", "start download , styleUrl = %s , file = %s", new Object[] { paramString, file });
        c c1 = new c(paramString, e.a.a, null);
        ak.a("gdt_tag_net", ak.a((e)c1));
        d.a().a((e)c1, c.a.a, new b(this, paramString, file) {
              public void a(e param1e, f param1f) {
                if (param1f.e() == 200) {
                  ak.b("gdt_tag_reward_video", "onResponse ok : %s  ", new Object[] { this.a });
                  try {
                    String str = param1f.d();
                    if (!TextUtils.isEmpty(str)) {
                      y.a(new Runnable(this, str) {
                            public void run() {
                              long l = System.currentTimeMillis();
                              aj.a(this.b.b, this.a);
                              ak.b("gdt_tag_reward_video", "HtmlFile write cost : %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                            }
                          });
                      return;
                    } 
                  } catch (IOException iOException) {
                    ak.b("gdt_tag_reward_video", "onResponse exception (%s)  ", new Object[] { iOException });
                  } 
                } 
              }
              
              public void a(Exception param1Exception) {
                ak.b("gdt_tag_reward_video", "onException (%s)  ", new Object[] { param1Exception });
              }
            });
        return;
      } 
      ak.b("gdt_tag_reward_video", "downloadHtmlFile is null or already exsits , downloadHtmlFile = %s", new Object[] { file });
    } 
  }
  
  private void b(String paramString, c paramc) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield B : Z
    //   6: ifeq -> 12
    //   9: goto -> 32
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield B : Z
    //   17: aload_0
    //   18: getfield s : Lcom/qq/e/comm/plugin/rewardvideo/e;
    //   21: iconst_0
    //   22: iconst_0
    //   23: aload_0
    //   24: getfield t : Lcom/qq/e/comm/plugin/y/c;
    //   27: aload_1
    //   28: aload_2
    //   29: invokestatic a : (Lcom/qq/e/comm/plugin/rewardvideo/e;ZZLcom/qq/e/comm/plugin/y/c;Ljava/lang/String;Lcom/qq/e/comm/plugin/j/c;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	35	finally
    //   12	32	35	finally
  }
  
  private void b(JSONObject paramJSONObject) {
    gdtadv.getVresult(170, 0, new Object[] { this, paramJSONObject });
  }
  
  private m c(String paramString) {
    m m2 = this.C.get(paramString);
    m m1 = m2;
    if (m2 == null) {
      m1 = new m();
      this.C.put(paramString, m1);
    } 
    return m1;
  }
  
  private void c(int paramInt) {
    if (this.q.b()) {
      ak.a(this.a, "reward Ad retry load");
      k();
    } else {
      a(501);
    } 
    h.a(paramInt, this.t);
  }
  
  private void c(JSONObject paramJSONObject) {
    e e1 = this.s;
    e e2 = e.b;
    boolean bool = false;
    if (e1 != e2) {
      c c1 = a(paramJSONObject);
      String str = paramJSONObject.optString("video");
      File file = aj.d(str);
      if (file == null || !file.exists()) {
        a(str, c1);
      } else {
        a(true);
        bool = true;
      } 
      h.b(this.s, bool, c1);
      return;
    } 
    a(false);
  }
  
  private void k() {
    gdtadv.getVresult(171, 0, new Object[] { this });
  }
  
  private void l() {
    this.y = null;
    String str = GDTADManager.getInstance().getSM().getStringForPlacement("rewardVideoExp", this.b);
    if (!TextUtils.isEmpty(str)) {
      String str1 = bb.a(str, "expId");
      if (!TextUtils.isEmpty(str1)) {
        try {
        
        } finally {
          Exception exception = null;
          ak.b("gdt_tag_reward_video", "error , expIdString = %s ,styleUrl = %s , throwable = %s", new Object[] { str1, str, exception });
        } 
      } else {
        ak.b("gdt_tag_reward_video", "error , expIdString cannot be empty ,styleUrl = %s", new Object[] { str });
      } 
    } 
  }
  
  private boolean m() {
    return (SDKStatus.getSDKVersionCode() >= 60 && Build.VERSION.SDK_INT != 26 && Build.VERSION.SDK_INT != 27);
  }
  
  public b a() {
    return (b)gdtadv.getobjresult(172, 0, new Object[] { this });
  }
  
  void a(int paramInt) {
    Message message = Message.obtain();
    message.what = 1;
    message.arg1 = paramInt;
    this.r.sendMessage(message);
  }
  
  void a(g paramg) {
    this.x = new WeakReference<g>(paramg);
  }
  
  void a(l paraml) {
    this.w = new WeakReference<l>(paraml);
    Iterator<m> iterator = this.C.values().iterator();
    while (iterator.hasNext())
      ((m)iterator.next()).a(paraml); 
  }
  
  void a(String paramString) {
    a(5002);
    b(paramString, (c)null);
  }
  
  void a(String paramString, c paramc) {
    a(5002);
    b(paramString, paramc);
  }
  
  void a(String paramString, c paramc) {
    l l1;
    File file1 = aj.f();
    File file2 = aj.d(paramString);
    if (file1 == null) {
      a(paramString, (c)null);
      if (this.w != null) {
        l1 = this.w.get();
        if (l1 != null) {
          l1.f();
          return;
        } 
      } 
    } else if (file2 == null || !file2.exists()) {
      b b1 = (new b.a()).b((String)l1).a(aj.a((String)l1)).a(file1).a();
      m m = c((String)l1);
      m.a(this);
      m.a((String)l1);
      m.a(paramc);
      com.qq.e.comm.plugin.aa.a.a.a().a(b1, (String)l1, m);
    } 
  }
  
  public int b() {
    return this.p;
  }
  
  void c() {
    a(false);
  }
  
  void d() {
    this.r.sendEmptyMessage(4);
  }
  
  void e() {
    Message message = Message.obtain(this.r, 3);
    Bundle bundle = new Bundle();
    bundle.putString("click_url", "");
    message.setData(bundle);
    this.r.sendMessage(message);
  }
  
  void f() {
    this.r.sendEmptyMessage(6);
  }
  
  void g() {
    this.i = true;
    this.r.sendEmptyMessage(9);
  }
  
  public String getAdNetWorkName() {
    return null;
  }
  
  public int getECPM() {
    return this.k;
  }
  
  public String getECPMLevel() {
    return this.n;
  }
  
  public long getExpireTimestamp() {
    return this.j;
  }
  
  public int getMediationPrice() {
    return this.l;
  }
  
  public int getRewardAdType() {
    return (this.s == e.b) ? 1 : 0;
  }
  
  public int getVideoDuration() {
    return this.o * 1000;
  }
  
  void h() {
    this.r.sendEmptyMessage(5);
  }
  
  public boolean hasShown() {
    return this.i;
  }
  
  void i() {
    this.r.sendEmptyMessage(7);
  }
  
  public boolean isContractAd() {
    return this.m;
  }
  
  public boolean j() {
    return this.z;
  }
  
  public void loadAD() {
    this.q.a();
    k();
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    this.A = paramLoadAdParams;
  }
  
  public void setVolumeOn(boolean paramBoolean) {
    this.z = paramBoolean;
  }
  
  public void showAD() {
    a(GDTADManager.getInstance().getAppContext(), true);
  }
  
  public void showAD(Activity paramActivity) {
    if (paramActivity == null) {
      GDTLogger.e("showAd(Activity activity) param activity can't be null");
      a(4001);
      return;
    } 
    a((Context)paramActivity, false);
  }
  
  class a extends Handler {
    a(j this$0) {
      super(Looper.getMainLooper());
    }
    
    public void handleMessage(Message param1Message) {
      ADEvent aDEvent2;
      String str1;
      ADEvent aDEvent1;
      ADListener aDListener2;
      Bundle bundle;
      String str2;
      ADListener aDListener1;
      ADListener aDListener3;
      switch (param1Message.what) {
        default:
          return;
        case 9:
          aDListener2 = j.b(this.a);
          aDEvent2 = new ADEvent(3);
          aDListener2.onADEvent(aDEvent2);
          return;
        case 8:
          aDListener2 = j.b(this.a);
          aDEvent2 = new ADEvent(1);
          aDListener2.onADEvent(aDEvent2);
          return;
        case 7:
          aDListener2 = j.b(this.a);
          aDEvent2 = new ADEvent(7);
          aDListener2.onADEvent(aDEvent2);
          return;
        case 6:
          aDListener2 = j.b(this.a);
          aDEvent2 = new ADEvent(5);
          aDListener2.onADEvent(aDEvent2);
          return;
        case 5:
          aDListener2 = j.b(this.a);
          aDEvent2 = new ADEvent(4);
          aDListener2.onADEvent(aDEvent2);
          return;
        case 4:
          aDListener2 = j.b(this.a);
          aDEvent2 = new ADEvent(8);
          aDListener2.onADEvent(aDEvent2);
          return;
        case 3:
          bundle = aDEvent2.getData();
          aDEvent2 = null;
          if (bundle != null)
            str1 = bundle.getString("click_url"); 
          aDListener3 = j.b(this.a);
          str2 = str1;
          if (TextUtils.isEmpty(str1))
            str2 = ""; 
          aDListener3.onADEvent(new ADEvent(6, new Object[] { str2 }));
          return;
        case 2:
          aDListener1 = j.b(this.a);
          aDEvent1 = new ADEvent(2);
          aDListener1.onADEvent(aDEvent1);
          return;
        case 1:
          break;
      } 
      j.b(this.a).onADEvent(new ADEvent(9, new Object[] { Integer.valueOf(((Message)aDEvent1).arg1) }));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */