package com.qq.e.comm.plugin.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.m.l;
import com.qq.e.comm.plugin.rewardvideo.c;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ae;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.plugin.z.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class f extends l implements RVADI2 {
  private final int e;
  
  private com.qq.e.comm.plugin.rewardvideo.b f = new com.qq.e.comm.plugin.rewardvideo.b();
  
  private int g = 1;
  
  private b h;
  
  private long i;
  
  private i j;
  
  private VideoOption2 k;
  
  private ADListener l;
  
  private boolean m;
  
  private boolean n;
  
  private boolean o;
  
  private a p;
  
  private final Object q = new Object();
  
  public f(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    super(paramContext, paramString1, paramString2, null);
    this.h = new b(paramADListener);
    setVolumeOn(true);
    a(e.x);
    this.e = ae.a();
    a.a(this.e, this);
  }
  
  private void b(int paramInt) {
    Message message = Message.obtain(this.h, 107);
    message.arg1 = paramInt;
    this.h.sendMessage(message);
  }
  
  private void f() {
    this.h.removeMessages(100);
    this.h.removeMessages(101);
    this.h.removeMessages(102);
    this.h.removeMessages(103);
    this.h.removeMessages(104);
    this.h.removeMessages(105);
    this.h.removeMessages(106);
    this.h.removeMessages(108);
    this.h.removeMessages(107);
  }
  
  private void g() {
    synchronized (this.q) {
      if (this.j != null)
        this.j.destroy(); 
      this.j = null;
      return;
    } 
  }
  
  private boolean h() {
    boolean bool;
    if (this.j == null) {
      bool = true;
    } else if (hasShown()) {
      bool = true;
    } else if (SystemClock.elapsedRealtime() > getExpireTimestamp()) {
      bool = true;
    } else if (c()) {
      bool = true;
    } else if (this.j.b()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      b(bool);
      return false;
    } 
    return true;
  }
  
  public void a() {
    g.a(this.d);
  }
  
  public void a(int paramInt) {
    g.a(paramInt, this.d);
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean && this.f.b()) {
      loadAd(this.g);
      return;
    } 
    b(paramInt);
  }
  
  void a(View paramView) {
    i i1 = this.j;
    if (i1 != null)
      i1.a(paramView); 
    this.h.sendEmptyMessage(102);
  }
  
  void a(ADListener paramADListener) {
    this.l = paramADListener;
  }
  
  public void a(List<JSONObject> paramList) {
    if (this.m)
      return; 
    Pair pair = c.a(paramList);
    int j = ((Integer)pair.first).intValue();
    if (j != 0) {
      b(j);
      return;
    } 
    null = (List)pair.second;
    synchronized (this.q) {
      this.p = a.c;
      this.o = false;
      this.j = new i(this.a, this.b, this.c, null.get(0), this.k, this);
      if (this.j.o() == null || TextUtils.isEmpty(this.j.o().G())) {
        b(5002);
        return;
      } 
      this.j.setAdListener(new ADListener(this) {
            private void a() {
              if (f.b(this.a) && f.c(this.a) == f.a.a)
                f.a(this.a).sendEmptyMessage(101); 
            }
            
            private void a(ADEvent param1ADEvent) {
              if (f.d(this.a) != null)
                f.d(this.a).onADEvent(param1ADEvent); 
            }
            
            public void onADEvent(ADEvent param1ADEvent) {
              // Byte code:
              //   0: aload_1
              //   1: invokevirtual getType : ()I
              //   4: istore_2
              //   5: iload_2
              //   6: sipush #201
              //   9: if_icmpeq -> 202
              //   12: iload_2
              //   13: sipush #202
              //   16: if_icmpeq -> 132
              //   19: iload_2
              //   20: sipush #206
              //   23: if_icmpeq -> 183
              //   26: iload_2
              //   27: sipush #207
              //   30: if_icmpeq -> 170
              //   33: iload_2
              //   34: sipush #901
              //   37: if_icmpeq -> 132
              //   40: iload_2
              //   41: tableswitch default -> 76, 101 -> 152, 102 -> 138, 103 -> 117, 104 -> 90, 105 -> 77
              //   76: return
              //   77: aload_0
              //   78: aload_1
              //   79: invokespecial a : (Lcom/qq/e/comm/adevent/ADEvent;)V
              //   82: aload_0
              //   83: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   86: invokevirtual b : ()V
              //   89: return
              //   90: aload_0
              //   91: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   94: getstatic com/qq/e/comm/plugin/v/f$a.b : Lcom/qq/e/comm/plugin/v/f$a;
              //   97: invokestatic a : (Lcom/qq/e/comm/plugin/v/f;Lcom/qq/e/comm/plugin/v/f$a;)Lcom/qq/e/comm/plugin/v/f$a;
              //   100: pop
              //   101: aload_0
              //   102: aload_1
              //   103: invokespecial a : (Lcom/qq/e/comm/adevent/ADEvent;)V
              //   106: aload_0
              //   107: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   110: sipush #5022
              //   113: invokestatic a : (Lcom/qq/e/comm/plugin/v/f;I)V
              //   116: return
              //   117: aload_0
              //   118: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   121: getstatic com/qq/e/comm/plugin/v/f$a.a : Lcom/qq/e/comm/plugin/v/f$a;
              //   124: invokestatic a : (Lcom/qq/e/comm/plugin/v/f;Lcom/qq/e/comm/plugin/v/f$a;)Lcom/qq/e/comm/plugin/v/f$a;
              //   127: pop
              //   128: aload_0
              //   129: invokespecial a : ()V
              //   132: aload_0
              //   133: aload_1
              //   134: invokespecial a : (Lcom/qq/e/comm/adevent/ADEvent;)V
              //   137: return
              //   138: aload_0
              //   139: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   142: invokestatic a : (Lcom/qq/e/comm/plugin/v/f;)Lcom/qq/e/comm/plugin/v/f$b;
              //   145: astore_1
              //   146: bipush #103
              //   148: istore_2
              //   149: goto -> 163
              //   152: aload_0
              //   153: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   156: invokestatic a : (Lcom/qq/e/comm/plugin/v/f;)Lcom/qq/e/comm/plugin/v/f$b;
              //   159: astore_1
              //   160: bipush #105
              //   162: istore_2
              //   163: aload_1
              //   164: iload_2
              //   165: invokevirtual sendEmptyMessage : (I)Z
              //   168: pop
              //   169: return
              //   170: aload_0
              //   171: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   174: sipush #5002
              //   177: invokestatic a : (Lcom/qq/e/comm/plugin/v/f;I)V
              //   180: goto -> 132
              //   183: aload_0
              //   184: aload_1
              //   185: invokespecial a : (Lcom/qq/e/comm/adevent/ADEvent;)V
              //   188: aload_0
              //   189: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   192: invokestatic a : (Lcom/qq/e/comm/plugin/v/f;)Lcom/qq/e/comm/plugin/v/f$b;
              //   195: astore_1
              //   196: bipush #108
              //   198: istore_2
              //   199: goto -> 163
              //   202: aload_0
              //   203: getfield a : Lcom/qq/e/comm/plugin/v/f;
              //   206: iconst_1
              //   207: invokestatic a : (Lcom/qq/e/comm/plugin/v/f;Z)Z
              //   210: pop
              //   211: aload_0
              //   212: invokespecial a : ()V
              //   215: return
            }
          });
      this.j.render();
      this.i = n.c();
      this.n = false;
      b((List<NativeExpressADData2>)null);
      JSONObject jSONObject = this.j.o().b();
      ArrayList<JSONObject> arrayList = new ArrayList();
      arrayList.add(jSONObject);
      c.a().a(this.c, arrayList, this.d);
      u.a(1220002, this.d);
      return;
    } 
  }
  
  void b() {
    this.h.sendEmptyMessage(106);
  }
  
  public void b(List<NativeExpressADData2> paramList) {
    Message message = Message.obtain(this.h, 100);
    this.h.sendMessage(message);
  }
  
  boolean c() {
    return (this.p == a.b);
  }
  
  i d() {
    return this.j;
  }
  
  public void destroy() {
    g();
    this.m = true;
    f();
  }
  
  void e() {
    this.h.sendEmptyMessage(104);
  }
  
  public String getECPMLevel() {
    i i1 = this.j;
    return (i1 != null) ? i1.getECPMLevel() : null;
  }
  
  public long getExpireTimestamp() {
    return this.i;
  }
  
  public int getVideoDuration() {
    i i1 = this.j;
    return (i1 != null) ? i1.o().g() : 0;
  }
  
  public boolean hasShown() {
    return this.n;
  }
  
  public boolean isVideoCached() {
    return (this.o && this.p == a.a);
  }
  
  public void loadAD() {
    g();
    this.i = 0L;
    this.f.a();
    loadAd(this.g);
  }
  
  public void setVolumeOn(boolean paramBoolean) {
    this.k = (new VideoOption2.Builder()).setAutoPlayPolicy(VideoOption2.AutoPlayPolicy.ALWAYS).setAutoPlayMuted(paramBoolean ^ true).build();
  }
  
  public void showAD(Activity paramActivity) {
    String str;
    Context context;
    ab.a().a(this.c);
    if (!h())
      return; 
    this.n = true;
    Intent intent = new Intent();
    intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
    intent.putExtra("gdt_activity_delegate_name", "rewardVideo2");
    Activity activity = paramActivity;
    if (paramActivity == null) {
      intent.addFlags(268435456);
      context = GDTADManager.getInstance().getAppContext();
    } 
    if (this.j.o().h()) {
      str = at.d();
    } else {
      str = at.b();
    } 
    intent.setClassName(context, str);
    intent.putExtra("objectId", this.e);
    context.startActivity(intent);
  }
  
  enum a {
    a, b, c;
  }
  
  static class b extends Handler {
    private ADListener a;
    
    b(ADListener param1ADListener) {
      super(Looper.getMainLooper());
      this.a = param1ADListener;
    }
    
    public void handleMessage(Message param1Message) {
      ADListener aDListener1;
      ADListener aDListener2;
      ADEvent aDEvent1;
      ADEvent aDEvent2;
      ADListener aDListener3;
      switch (param1Message.what) {
        default:
          return;
        case 107:
          aDListener2 = this.a;
          aDEvent2 = new ADEvent(param1Message.what, new Object[] { Integer.valueOf(param1Message.arg1) });
          aDListener1 = aDListener2;
          aDEvent1 = aDEvent2;
          break;
        case 100:
        case 101:
        case 102:
        case 103:
        case 104:
        case 105:
        case 106:
        case 108:
          aDListener3 = this.a;
          aDEvent1 = new ADEvent(((Message)aDListener1).what);
          aDListener1 = aDListener3;
          break;
      } 
      aDListener1.onADEvent(aDEvent1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\v\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */