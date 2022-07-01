package com.qq.e.ads.splash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONObject;

public final class SplashAD {
  private volatile NSPVI a;
  
  private volatile ViewGroup b;
  
  private volatile SplashADListener c;
  
  private volatile LoadAdParams d;
  
  private volatile boolean e = false;
  
  private volatile boolean f;
  
  private int g;
  
  private int h;
  
  private volatile View i;
  
  public SplashAD(Context paramContext, View paramView, String paramString, SplashADListener paramSplashADListener, int paramInt) {
    this(paramContext, paramView, paramString, paramSplashADListener, paramInt, (View)null);
  }
  
  public SplashAD(Context paramContext, View paramView1, String paramString, SplashADListener paramSplashADListener, int paramInt, View paramView2) {
    this(paramContext, paramView1, paramString, paramSplashADListener, paramInt, (Map)null, paramView2);
  }
  
  public SplashAD(Context paramContext, View paramView1, String paramString, SplashADListener paramSplashADListener, int paramInt, Map paramMap, View paramView2) {
    if (GDTADManager.getInstance().isInitialized()) {
      a(paramContext, paramView1, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString, paramSplashADListener, paramInt, paramMap, paramView2);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    a(paramSplashADListener, 2003);
  }
  
  @Deprecated
  public SplashAD(Context paramContext, View paramView, String paramString1, String paramString2, SplashADListener paramSplashADListener, int paramInt) {
    this(paramContext, paramView, paramString1, paramString2, paramSplashADListener, paramInt, (View)null);
  }
  
  @Deprecated
  public SplashAD(Context paramContext, View paramView1, String paramString1, String paramString2, SplashADListener paramSplashADListener, int paramInt, View paramView2) {
    this(paramContext, paramView1, paramString1, paramString2, paramSplashADListener, paramInt, null, paramView2);
  }
  
  @Deprecated
  public SplashAD(Context paramContext, View paramView1, String paramString1, String paramString2, SplashADListener paramSplashADListener, int paramInt, Map paramMap, View paramView2) {
    GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
    a(paramContext, paramView1, paramString1, paramString2, paramSplashADListener, paramInt, paramMap, paramView2);
  }
  
  public SplashAD(Context paramContext, String paramString, SplashADListener paramSplashADListener) {
    this(paramContext, paramString, paramSplashADListener, 0);
  }
  
  public SplashAD(Context paramContext, String paramString, SplashADListener paramSplashADListener, int paramInt) {
    this(paramContext, (View)null, paramString, paramSplashADListener, paramInt);
  }
  
  @Deprecated
  public SplashAD(Context paramContext, String paramString1, String paramString2, SplashADListener paramSplashADListener) {
    this(paramContext, paramString1, paramString2, paramSplashADListener, 0);
  }
  
  @Deprecated
  public SplashAD(Context paramContext, String paramString1, String paramString2, SplashADListener paramSplashADListener, int paramInt) {
    this(paramContext, (View)null, paramString1, paramString2, paramSplashADListener, paramInt);
  }
  
  private void a(Context paramContext, View paramView1, String paramString1, String paramString2, SplashADListener paramSplashADListener, int paramInt, Map paramMap, View paramView2) {
    this.c = paramSplashADListener;
    if (StringUtil.isEmpty(paramString1) || StringUtil.isEmpty(paramString2) || paramContext == null) {
      GDTLogger.e(String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", new Object[] { paramString1, paramString2, paramContext }));
      paramInt = 2001;
    } else if (!a.a(paramContext)) {
      GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
      paramInt = 4002;
    } else {
      GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, paramContext, paramString1, paramString2, paramMap, paramInt, paramView1, paramView2, paramSplashADListener) {
            public void run() {
              if (GDTADManager.getInstance().initWith(this.a, this.b)) {
                char c;
                SplashAD splashAD;
                SplashADListener splashADListener;
                try {
                  return;
                } catch (a a) {
                
                } finally {
                  Exception exception = null;
                  GDTLogger.e("Unknown Exception", exception);
                  splashAD = this.i;
                  splashADListener = this.h;
                } 
                SplashAD.a(splashAD, splashADListener, c);
              } 
            }
          });
      return;
    } 
    a(paramSplashADListener, paramInt);
  }
  
  private void a(SplashADListener paramSplashADListener, int paramInt) {
    if (paramSplashADListener != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramSplashADListener, paramInt) {
            public void run() {
              this.a.onNoAD(a.a(this.b));
            }
          }); 
  }
  
  public final void fetchAdOnly() {
    if (this.a != null) {
      GDTLogger.e("splashAD fetchAdOnly");
      this.a.fetchAdOnly();
      return;
    } 
    this.f = true;
  }
  
  public final void fetchAndShowIn(ViewGroup paramViewGroup) {
    if (paramViewGroup == null) {
      GDTLogger.e("SplashAD fetchAndShowIn params null ");
      a(this.c, 2001);
      return;
    } 
    if (this.a != null) {
      this.a.fetchAndShowIn(paramViewGroup);
      return;
    } 
    this.b = paramViewGroup;
  }
  
  public final String getAdNetWorkName() {
    if (this.a != null)
      return this.a.getAdNetWorkName(); 
    GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onAdPresent\"");
    return null;
  }
  
  public final String getECPMLevel() {
    if (this.a != null)
      return this.a.getECPMLevel(); 
    GDTLogger.e("The ad does not support \"getECPMLevel\" or you should call this method after \"onAdPresent\"");
    return null;
  }
  
  public final Map getExt() {
    try {
      NSPVI nSPVI = this.a;
      return NSPVI.ext;
    } catch (Exception exception) {
      GDTLogger.e("splash ad can not get extra");
      exception.printStackTrace();
      return null;
    } 
  }
  
  public final void preLoad() {
    if (this.a != null) {
      this.a.preload();
      return;
    } 
    this.e = true;
  }
  
  public final void setAdLogoMargin(int paramInt1, int paramInt2) {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public final void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    if (this.a != null) {
      this.a.setLoadAdParams(paramLoadAdParams);
      return;
    } 
    this.d = paramLoadAdParams;
  }
  
  public final void setPreloadView(View paramView) {
    if (this.a != null) {
      this.a.setPreloadView(paramView);
      return;
    } 
    this.i = paramView;
  }
  
  public final void showAd(ViewGroup paramViewGroup) {
    if (paramViewGroup == null) {
      GDTLogger.e("SplashAD showAd params null ");
      a(this.c, 2001);
      return;
    } 
    if (this.a != null) {
      this.a.showAd(paramViewGroup);
      return;
    } 
    this.b = paramViewGroup;
  }
  
  class ADListenerAdapter implements ADListener {
    private ADListenerAdapter(SplashAD this$0) {}
    
    public void onADEvent(ADEvent param1ADEvent) {
      String str;
      if (SplashAD.i(this.a) == null) {
        str = "SplashADListener == null";
      } else {
        Object[] arrayOfObject = str.getParas();
        switch (str.getType()) {
          default:
            return;
          case 7:
            if (arrayOfObject.length == 1 && arrayOfObject[0] instanceof Long) {
              SplashAD.i(this.a).onADLoaded(((Long)arrayOfObject[0]).longValue());
              return;
            } 
            str = "Splash onADLoaded event get param error.";
            GDTLogger.e(str);
            return;
          case 6:
            SplashAD.i(this.a).onADExposure();
            return;
          case 5:
            if (arrayOfObject.length == 1 && arrayOfObject[0] instanceof Long) {
              SplashAD.i(this.a).onADTick(((Long)arrayOfObject[0]).longValue());
              return;
            } 
            str = "Splash onADTick event get param error.";
            GDTLogger.e(str);
            return;
          case 4:
            SplashAD.i(this.a).onADClicked();
            return;
          case 3:
            SplashAD.i(this.a).onADPresent();
            return;
          case 2:
            if (arrayOfObject.length > 0 && arrayOfObject[0] instanceof Integer) {
              SplashAD.i(this.a).onNoAD(a.a(((Integer)arrayOfObject[0]).intValue()));
              return;
            } 
            str = "Splash onNoAD event get params error.";
            GDTLogger.e(str);
            return;
          case 1:
            break;
        } 
        SplashAD.i(this.a).onADDismissed();
        return;
      } 
      GDTLogger.e(str);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\splash\SplashAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */