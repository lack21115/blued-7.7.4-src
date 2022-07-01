package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class k extends a<BaseNativeUnifiedAd> implements NUADI {
  private ADListener d;
  
  private int e;
  
  private Map<BaseNativeUnifiedAd, b> f = new HashMap<BaseNativeUnifiedAd, b>();
  
  private List<String> g;
  
  private int h;
  
  private int i = -1;
  
  private int j = 0;
  
  private int k = 0;
  
  private DownAPPConfirmPolicy l;
  
  private int m;
  
  private String n;
  
  public k(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    super(paramContext, paramString2);
    this.d = paramADListener;
  }
  
  private List<NativeUnifiedADData> a(ADEvent paramADEvent) {
    return (paramADEvent == null || paramADEvent.getType() != 1 || paramADEvent.getParas() == null || (paramADEvent.getParas()).length <= 0 || !(paramADEvent.getParas()[0] instanceof List) || ((List)paramADEvent.getParas()[0]).size() < 1 || !(((List)paramADEvent.getParas()[0]).get(0) instanceof NativeUnifiedADData)) ? new ArrayList<NativeUnifiedADData>() : (List<NativeUnifiedADData>)paramADEvent.getParas()[0];
  }
  
  private List<NativeUnifiedADData> a(List<NativeUnifiedADData> paramList, BaseNativeUnifiedAd paramBaseNativeUnifiedAd) {
    if (paramList == null)
      return new ArrayList<NativeUnifiedADData>(); 
    ArrayList<NativeUnifiedADData> arrayList = new ArrayList();
    Iterator<NativeUnifiedADData> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      arrayList.add(a.a(iterator.next(), new a(new a.a(this, paramBaseNativeUnifiedAd) {
                public void a() {}
                
                public boolean a(ADEvent param1ADEvent) {
                  return false;
                }
                
                public void b() {
                  k.c(this.b, this.a, 70342);
                }
                
                public void b(ADEvent param1ADEvent) {}
                
                public void c() {
                  k.d(this.b, this.a, 70332);
                }
              })));
    } 
    return arrayList;
  }
  
  protected int a(BaseNativeUnifiedAd paramBaseNativeUnifiedAd) {
    b b = new b(new a.a(this, paramBaseNativeUnifiedAd, System.currentTimeMillis()) {
          private void a(boolean param1Boolean) {
            int i;
            long l1 = System.currentTimeMillis();
            long l2 = this.b;
            k k1 = this.c;
            BaseNativeUnifiedAd baseNativeUnifiedAd = this.a;
            if (param1Boolean) {
              i = 70312;
            } else {
              i = 70322;
            } 
            k.a(k1, baseNativeUnifiedAd, l1 - l2, param1Boolean, i);
          }
          
          public void a() {
            a(false);
            if (k.d(this.c) && !k.e(this.c))
              this.c.a(); 
          }
          
          public boolean a(ADEvent param1ADEvent) {
            // Byte code:
            //   0: aload_0
            //   1: getfield c : Lcom/qq/e/comm/plugin/nativeadunified/k;
            //   4: aload_1
            //   5: invokestatic a : (Lcom/qq/e/comm/plugin/nativeadunified/k;Lcom/qq/e/comm/adevent/ADEvent;)Ljava/util/List;
            //   8: astore #5
            //   10: aload #5
            //   12: ifnull -> 125
            //   15: aload #5
            //   17: invokeinterface size : ()I
            //   22: ifle -> 125
            //   25: aload #5
            //   27: iconst_0
            //   28: invokeinterface get : (I)Ljava/lang/Object;
            //   33: checkcast com/qq/e/ads/nativ/NativeUnifiedADData
            //   36: astore #6
            //   38: iconst_m1
            //   39: istore_2
            //   40: aload #6
            //   42: ifnull -> 95
            //   45: aload #6
            //   47: invokeinterface getECPM : ()I
            //   52: istore_3
            //   53: iload_3
            //   54: istore_2
            //   55: aload #6
            //   57: instanceof com/qq/e/comm/plugin/r/a
            //   60: ifeq -> 95
            //   63: iload_3
            //   64: istore_2
            //   65: iload_3
            //   66: ifgt -> 80
            //   69: aload #6
            //   71: checkcast com/qq/e/comm/plugin/r/a
            //   74: invokeinterface getMediationPrice : ()I
            //   79: istore_2
            //   80: aload #6
            //   82: checkcast com/qq/e/comm/plugin/r/a
            //   85: invokeinterface isContractAd : ()Z
            //   90: istore #4
            //   92: goto -> 98
            //   95: iconst_0
            //   96: istore #4
            //   98: aload_0
            //   99: getfield c : Lcom/qq/e/comm/plugin/nativeadunified/k;
            //   102: astore #6
            //   104: aload_0
            //   105: getfield a : Lcom/qq/e/mediation/interfaces/BaseNativeUnifiedAd;
            //   108: astore #7
            //   110: aload #6
            //   112: aload #7
            //   114: iload_2
            //   115: iload #4
            //   117: aload #7
            //   119: invokevirtual getAdapterPriority : ()I
            //   122: invokestatic a : (Lcom/qq/e/comm/plugin/nativeadunified/k;Ljava/lang/Object;IZI)V
            //   125: aload_0
            //   126: iconst_1
            //   127: invokespecial a : (Z)V
            //   130: aload_0
            //   131: getfield c : Lcom/qq/e/comm/plugin/nativeadunified/k;
            //   134: invokestatic a : (Lcom/qq/e/comm/plugin/nativeadunified/k;)Z
            //   137: ifeq -> 190
            //   140: aload_0
            //   141: getfield c : Lcom/qq/e/comm/plugin/nativeadunified/k;
            //   144: aload_0
            //   145: getfield a : Lcom/qq/e/mediation/interfaces/BaseNativeUnifiedAd;
            //   148: invokestatic a : (Lcom/qq/e/comm/plugin/nativeadunified/k;Ljava/lang/Object;)Z
            //   151: ifeq -> 190
            //   154: aload_0
            //   155: getfield c : Lcom/qq/e/comm/plugin/nativeadunified/k;
            //   158: invokestatic b : (Lcom/qq/e/comm/plugin/nativeadunified/k;)Z
            //   161: ifne -> 190
            //   164: aload_1
            //   165: invokevirtual getParas : ()[Ljava/lang/Object;
            //   168: iconst_0
            //   169: aload_0
            //   170: getfield c : Lcom/qq/e/comm/plugin/nativeadunified/k;
            //   173: aload #5
            //   175: aload_0
            //   176: getfield a : Lcom/qq/e/mediation/interfaces/BaseNativeUnifiedAd;
            //   179: invokestatic a : (Lcom/qq/e/comm/plugin/nativeadunified/k;Ljava/util/List;Lcom/qq/e/mediation/interfaces/BaseNativeUnifiedAd;)Ljava/util/List;
            //   182: aastore
            //   183: aload_0
            //   184: getfield c : Lcom/qq/e/comm/plugin/nativeadunified/k;
            //   187: invokestatic c : (Lcom/qq/e/comm/plugin/nativeadunified/k;)V
            //   190: iconst_0
            //   191: ireturn
          }
          
          public void b() {
            k.a(this.c, this.a, 70342);
          }
          
          public void b(ADEvent param1ADEvent) {
            if (k.f(this.c) == null)
              return; 
            k.f(this.c).onADEvent(param1ADEvent);
          }
          
          public void c() {
            k.b(this.c, this.a, 70332);
          }
        }i());
    this.f.put(paramBaseNativeUnifiedAd, b);
    paramBaseNativeUnifiedAd.setAdListener(b);
    List<String> list = this.g;
    if (list != null)
      paramBaseNativeUnifiedAd.setCategories(list); 
    int i = this.h;
    if (i > 0)
      paramBaseNativeUnifiedAd.setMinVideoDuration(i); 
    i = this.i;
    if (i >= 0)
      paramBaseNativeUnifiedAd.setMaxVideoDuration(i); 
    paramBaseNativeUnifiedAd.setVideoADContainerRender(this.j);
    paramBaseNativeUnifiedAd.setVideoPlayPolicy(this.k);
    DownAPPConfirmPolicy downAPPConfirmPolicy = this.l;
    if (downAPPConfirmPolicy != null)
      paramBaseNativeUnifiedAd.setDownAPPConfirmPolicy(downAPPConfirmPolicy); 
    paramBaseNativeUnifiedAd.setBrowserType(this.m);
    if (paramBaseNativeUnifiedAd instanceof com.qq.e.comm.plugin.r.b)
      ((com.qq.e.comm.plugin.r.b)paramBaseNativeUnifiedAd).a(this.n); 
    paramBaseNativeUnifiedAd.loadData(this.e);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBaseNativeUnifiedAd.getClass().getSimpleName());
    stringBuilder.append(" load Ad");
    GDTLogger.d(stringBuilder.toString());
    return 70302;
  }
  
  protected BaseNativeUnifiedAd a(c paramc) {
    if (paramc != null)
      try {
        return a.a(paramc.e(), this.a, paramc.b(), paramc.g());
      } catch (Exception exception) {
        a(70352, paramc);
        exception.printStackTrace();
      }  
    return null;
  }
  
  public void a() {
    ADListener aDListener = this.d;
    if (aDListener != null)
      aDListener.onADEvent(new ADEvent(2, new Object[] { Integer.valueOf(501) })); 
  }
  
  protected void b(BaseNativeUnifiedAd paramBaseNativeUnifiedAd) {
    if (paramBaseNativeUnifiedAd != null) {
      b b = this.f.get(paramBaseNativeUnifiedAd);
      if (b == null) {
        a();
        return;
      } 
      for (ADEvent aDEvent : b.a()) {
        if (aDEvent.getType() == 1)
          aDEvent.getParas()[0] = a(a(aDEvent), paramBaseNativeUnifiedAd); 
        this.d.onADEvent(aDEvent);
      } 
      return;
    } 
    a();
  }
  
  public String getAdNetWorkName() {
    return k();
  }
  
  public void loadData(int paramInt) {
    this.e = paramInt;
    c();
  }
  
  public void loadData(int paramInt, LoadAdParams paramLoadAdParams) {
    loadData(paramInt);
  }
  
  public void setBrowserType(int paramInt) {
    this.m = paramInt;
  }
  
  public void setCategories(List<String> paramList) {
    this.g = paramList;
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    this.l = paramDownAPPConfirmPolicy;
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.i = paramInt;
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.h = paramInt;
  }
  
  public void setVastClassName(String paramString) {
    this.n = paramString;
  }
  
  public void setVideoADContainerRender(int paramInt) {
    this.j = paramInt;
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.k = paramInt;
  }
  
  static class a implements ADListener {
    private ADListener a;
    
    private a.a b;
    
    public a(a.a param1a) {
      this.b = param1a;
    }
    
    public void a(ADListener param1ADListener) {
      this.a = param1ADListener;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      this.a.onADEvent(param1ADEvent);
      if (param1ADEvent.getType() == 2) {
        this.b.b();
        return;
      } 
      if (param1ADEvent.getType() == 1)
        this.b.c(); 
    }
  }
  
  static class b implements ADListener {
    private a.a a;
    
    private Queue<ADEvent> b = new LinkedList<ADEvent>();
    
    private boolean c;
    
    public b(a.a param1a, boolean param1Boolean) {
      this.a = param1a;
      this.c = param1Boolean;
    }
    
    public Queue<ADEvent> a() {
      return this.b;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      if (param1ADEvent.getType() == 2) {
        this.a.a();
        return;
      } 
      if (param1ADEvent.getType() == 1) {
        if (this.c) {
          this.a.a(param1ADEvent);
          this.a.b(param1ADEvent);
          return;
        } 
        this.b.offer(param1ADEvent);
        this.a.a(param1ADEvent);
        return;
      } 
      if (SDKStatus.getSDKVersionCode() >= 70) {
        if (param1ADEvent.getType() == 3) {
          this.a.b();
          return;
        } 
        if (param1ADEvent.getType() == 4)
          this.a.c(); 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */