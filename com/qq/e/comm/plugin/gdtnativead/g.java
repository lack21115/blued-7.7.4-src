package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.r.a.a;
import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class g extends a<BaseNativeExpressAd> implements NEADI {
  private ADListener d;
  
  private int e;
  
  private LoadAdParams f;
  
  private VideoOption g;
  
  private int h = -1;
  
  private int i = -1;
  
  private int j = -1;
  
  private ADSize k;
  
  private Map<BaseNativeExpressAd, a> l = new HashMap<BaseNativeExpressAd, a>();
  
  public g(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, ADListener paramADListener) {
    super(paramContext, paramString2);
    this.d = paramADListener;
    this.k = paramADSize;
  }
  
  protected int a(BaseNativeExpressAd paramBaseNativeExpressAd) {
    long l = System.currentTimeMillis();
    int i = this.i;
    if (i >= 0)
      paramBaseNativeExpressAd.setMaxVideoDuration(i); 
    i = this.h;
    if (i >= 0)
      paramBaseNativeExpressAd.setMinVideoDuration(i); 
    i = this.j;
    if (i >= 0)
      paramBaseNativeExpressAd.setVideoPlayPolicy(i); 
    VideoOption videoOption = this.g;
    if (videoOption != null)
      paramBaseNativeExpressAd.setVideoOption(videoOption); 
    a a1 = new a(new a.a(this, paramBaseNativeExpressAd, l) {
          public void a() {
            if (g.d(this.c))
              return; 
            long l = System.currentTimeMillis();
            g.b(this.c, this.a, l - this.b, false, 70522);
            if (g.e(this.c) && g.b(this.c, this.a) && !g.f(this.c))
              this.c.a(); 
          }
          
          public boolean a(ADEvent param1ADEvent) {
            int i;
            boolean bool = g.a(this.c);
            boolean bool1 = false;
            if (bool)
              return false; 
            long l = System.currentTimeMillis();
            int j = this.a.getECPM();
            BaseNativeExpressAd baseNativeExpressAd1 = this.a;
            if (baseNativeExpressAd1 instanceof com.qq.e.comm.plugin.r.a) {
              i = j;
              if (j <= 0)
                i = ((com.qq.e.comm.plugin.r.a)baseNativeExpressAd1).getMediationPrice(); 
              bool = ((com.qq.e.comm.plugin.r.a)this.a).isContractAd();
            } else {
              bool = false;
              i = j;
            } 
            g g1 = this.c;
            BaseNativeExpressAd baseNativeExpressAd2 = this.a;
            g.a(g1, baseNativeExpressAd2, i, bool, baseNativeExpressAd2.getAdapterPriority());
            g.a(this.c, this.a, l - this.b, true, 70512);
            bool = bool1;
            if (g.b(this.c)) {
              bool = bool1;
              if (g.a(this.c, this.a)) {
                g.c(this.c);
                bool = true;
              } 
            } 
            return bool;
          }
          
          public void b() {
            g.a(this.c, this.a, 70542);
          }
          
          public void b(ADEvent param1ADEvent) {
            if (g.g(this.c) != null && g.c(this.c, this.a))
              g.g(this.c).onADEvent(param1ADEvent); 
          }
          
          public void c() {
            g.b(this.c, this.a, 70532);
          }
        }i());
    paramBaseNativeExpressAd.setAdListener(a1);
    this.l.put(paramBaseNativeExpressAd, a1);
    LoadAdParams loadAdParams = this.f;
    if (loadAdParams == null) {
      paramBaseNativeExpressAd.loadAD(this.e);
    } else {
      paramBaseNativeExpressAd.loadAD(this.e, loadAdParams);
    } 
    return 70502;
  }
  
  protected BaseNativeExpressAd a(c paramc) {
    if (paramc != null)
      try {
        return a.a(paramc.e(), this.k, this.b, paramc.b(), paramc.g());
      } catch (Exception exception) {
        a(70552, paramc);
        exception.printStackTrace();
      }  
    return null;
  }
  
  public void a() {
    ADListener aDListener = this.d;
    if (aDListener != null)
      aDListener.onADEvent(new ADEvent(1, new Object[] { Integer.valueOf(501) })); 
  }
  
  protected void b(BaseNativeExpressAd paramBaseNativeExpressAd) {
    if (paramBaseNativeExpressAd != null) {
      a a1 = this.l.get(paramBaseNativeExpressAd);
      if (a1 != null && this.d != null) {
        a1.b();
        Queue<ADEvent> queue = a1.a();
        if (queue != null && queue.size() > 0)
          for (ADEvent aDEvent : queue)
            this.d.onADEvent(aDEvent);  
      } 
    } else {
      a();
    } 
  }
  
  public void loadAd(int paramInt) {
    this.e = paramInt;
    this.f = null;
    c();
  }
  
  public void loadAd(int paramInt, LoadAdParams paramLoadAdParams) {
    this.e = paramInt;
    this.f = paramLoadAdParams;
    c();
  }
  
  public void setBrowserType(int paramInt) {}
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {}
  
  public void setMaxVideoDuration(int paramInt) {
    this.i = paramInt;
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.h = paramInt;
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    this.g = paramVideoOption;
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.j = paramInt;
  }
  
  static class a implements ADListener {
    private a.a a;
    
    private Queue<ADEvent> b = new LinkedList<ADEvent>();
    
    private boolean c;
    
    private boolean d;
    
    public a(a.a param1a, boolean param1Boolean) {
      this.a = param1a;
      this.c = param1Boolean;
    }
    
    private void a(ADEvent param1ADEvent) {
      if (this.d) {
        this.a.b(param1ADEvent);
        return;
      } 
      this.b.offer(param1ADEvent);
    }
    
    public Queue<ADEvent> a() {
      return this.b;
    }
    
    public void b() {
      this.d = true;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      if (this.a != null) {
        int i = param1ADEvent.getType();
        if (i != 1) {
          if (i != 2) {
            if (i != 5) {
              if (i == 6)
                this.a.b(); 
            } else {
              this.a.c();
            } 
            a(param1ADEvent);
            return;
          } 
          if (this.c) {
            this.d = this.a.a(param1ADEvent);
            if (this.d) {
              this.a.b(param1ADEvent);
              return;
            } 
          } else {
            this.b.offer(param1ADEvent);
            this.a.a(param1ADEvent);
            return;
          } 
        } else {
          this.a.a();
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */