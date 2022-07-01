package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.intersitial2.fullscreen.b;
import com.qq.e.comm.plugin.intersitial2.fullscreen.d;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.f;
import com.qq.e.comm.plugin.util.g;
import com.qq.e.comm.plugin.util.m;
import com.qq.e.comm.plugin.util.v;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements DialogInterface.OnDismissListener, UIADI, a {
  private final a a;
  
  private final f b;
  
  private d c;
  
  private final UnifiedInterstitialADListener d;
  
  private volatile UnifiedInterstitialMediaListener e;
  
  private final String f;
  
  private final String g;
  
  private WeakReference<Activity> h;
  
  private Dialog i;
  
  private af j = new af();
  
  private boolean k;
  
  private boolean l = false;
  
  private final double m = g.a();
  
  private ImageView n = null;
  
  private c o = new c();
  
  private boolean p;
  
  private boolean q;
  
  public d(Activity paramActivity, String paramString1, String paramString2, UnifiedInterstitialADListener paramUnifiedInterstitialADListener) {
    this(paramActivity, paramString1, paramString2, l.a, paramUnifiedInterstitialADListener);
  }
  
  public d(Activity paramActivity, String paramString1, String paramString2, l paraml, UnifiedInterstitialADListener paramUnifiedInterstitialADListener) {
    this.f = paramString1;
    this.g = paramString2;
    this.h = new WeakReference<Activity>(paramActivity);
    this.d = paramUnifiedInterstitialADListener;
    this.a = new a(this, paramUnifiedInterstitialADListener, paramString2, new a(this) {
          public void a(boolean param1Boolean) {
            d.a(this.a, param1Boolean);
          }
        });
    this.b = new f((Context)paramActivity, new ADSize(-1, -2), paramString1, paramString2, paraml, this.a);
    this.c = new d((Context)paramActivity, new ADSize(-1, -2), paramString1, paramString2, paraml, this.a);
    this.o.a(paramString2);
  }
  
  private int a(Point paramPoint1, Point paramPoint2) {
    double d1 = this.m;
    if (d())
      d1 = g.b(); 
    ak.a("isVideo = %b, rate = %d", new Object[] { Boolean.valueOf(d()), Integer.valueOf((int)(100.0D * d1)) });
    if (paramPoint1.x < paramPoint1.y) {
      d1 *= paramPoint1.x;
      return (int)d1;
    } 
    if (paramPoint2.x < paramPoint2.y && g.a(this.g))
      return 0; 
    if (paramPoint1.x > 0 && paramPoint1.y > 0 && paramPoint2.x > 0 && paramPoint2.y > 0) {
      d1 = d1 * paramPoint2.x * paramPoint1.y / paramPoint2.y;
      return (int)d1;
    } 
    return 0;
  }
  
  private void a(boolean paramBoolean, Activity paramActivity) {
    String str;
    if (paramActivity == null) {
      str = "Activity param for doshow Method should not be null";
    } else if (str.getWindow() == null) {
      str = "Activity's Window should not be null";
    } else {
      ImageView imageView;
      e e = e.n;
      v.a(e, d(), this.o);
      Dialog dialog = this.i;
      if (dialog != null && dialog.isShowing()) {
        str = "UnifiedInterstitialAD is showing , please do not call show right now !";
      } else if (this.k) {
        str = "UnifiedInterstitialAD has shown , please loadAd again !";
      } else {
        byte b;
        NativeExpressADView nativeExpressADView = this.a.a();
        if (nativeExpressADView == null) {
          GDTLogger.e("cannot show before AD ready !");
          paramBoolean = d();
          b = 4014;
        } else {
          nativeExpressADView.setMediaListener(new NativeExpressMediaListener(this) {
                public void onVideoCached(NativeExpressADView param1NativeExpressADView) {}
                
                public void onVideoComplete(NativeExpressADView param1NativeExpressADView) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoComplete(); 
                  if (d.b(this.a) != null)
                    d.b(this.a).setVisibility(8); 
                }
                
                public void onVideoError(NativeExpressADView param1NativeExpressADView, AdError param1AdError) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoError(param1AdError); 
                  if (d.b(this.a) != null)
                    d.b(this.a).setVisibility(8); 
                }
                
                public void onVideoInit(NativeExpressADView param1NativeExpressADView) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoInit(); 
                }
                
                public void onVideoLoading(NativeExpressADView param1NativeExpressADView) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoLoading(); 
                }
                
                public void onVideoPageClose(NativeExpressADView param1NativeExpressADView) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoPageClose(); 
                }
                
                public void onVideoPageOpen(NativeExpressADView param1NativeExpressADView) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoPageOpen(); 
                }
                
                public void onVideoPause(NativeExpressADView param1NativeExpressADView) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoPause(); 
                }
                
                public void onVideoReady(NativeExpressADView param1NativeExpressADView, long param1Long) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoReady(param1Long); 
                }
                
                public void onVideoStart(NativeExpressADView param1NativeExpressADView) {
                  if (d.a(this.a) != null)
                    d.a(this.a).onVideoStart(); 
                  if (d.b(this.a) != null)
                    d.b(this.a).setVisibility(0); 
                }
              });
          this.i = new Dialog((Context)str);
          this.i.setOnDismissListener(this);
          this.i.setCanceledOnTouchOutside(false);
          this.i.setOwnerActivity((Activity)str);
          Window window = this.i.getWindow();
          if (window == null) {
            str = "Dialog Window should not be null";
          } else {
            Point point1;
            window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
            this.i.setFeatureDrawableAlpha(0, 0);
            this.i.requestWindowFeature(1);
            if (paramBoolean) {
              window.addFlags(2);
              window.clearFlags(32);
            } else {
              window.clearFlags(2);
              window.addFlags(32);
            } 
            if (nativeExpressADView.getParent() != null)
              ((ViewGroup)nativeExpressADView.getParent()).removeView((View)nativeExpressADView); 
            Point point2 = new Point();
            str.getWindowManager().getDefaultDisplay().getSize(point2);
            if (nativeExpressADView.getTag() instanceof Point) {
              point1 = (Point)nativeExpressADView.getTag();
            } else {
              point1 = new Point();
            } 
            int i = a(point2, point1);
            if (i <= 0) {
              GDTLogger.e("Layout Error !");
              paramBoolean = d();
              b = 4005;
            } else {
              if (d()) {
                if (window != null && g.c())
                  window.addFlags(16777216); 
                Context context = str.getApplicationContext();
                imageView = new ImageView(context);
                imageView.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAFQAAABUCAMAAAArteDzAAAAOVBMVEUAAAAAAADJyckAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD09PS+vr4AAAAAAADDw8P///8gbgZqAAAAEnRSTlNAAJsnBTwKMDQ4KxgU348dHJQg6cWiAAABv0lEQVRYw7TW0XKDIBCF4ZPssiCQxPr+D1vambZpko1Hhf+WmW9QEcBpLas3iWkKQJhSlFu101rvUS0y4alJihKoI0a4xaI7UJOAtwWxjahlEGXbgKqATJRF5wC6MFOoJWwq2TpaAzYW6hoq2JG8RTVjV1l9VCN2FtVDNWF36V4FMU9+rs9oxqHyK1RwMHlGKw5XH1ELOFywBzShQ+k/OqNL8z2qAV0KeocKOiV/qKFb9otmdCv/oAb0nSr4N8q/Vfif/nr5QMsbvPoLoKEFr7ssyxlO52W5OEPlG43eZJamuubiPUb8QhX+dJrqD3hpQwsYlTdRGipgVN6ENHQCo/ImphMMYFTeBAwVnMqbjbyBU3mzkQJO5U0IIjiVNxuZQKq02cgJrMqajQxgVdZ0SE89g2sIOuTxh3yoIUtqyOIf8psO2VCGbH1DNukRx8mQg2/IET3oMuFfez6bs4MTAEAYCIIf/Qrpv1krOBFhMKkhj9vdOs+elV7fDbQx81qMV3lKitFL5rkACYI8As4IRgrgFWhOJILQHULMCIVEZJfQckIgCtUJpKzQx0J0AyUv4gHIHP+DzE066hO53nPcBuKXGs07rkSBAAAAAElFTkSuQmCC"));
                b = am.a(context, 24);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b, b);
                layoutParams2.gravity = 53;
                b = am.a(context, 8);
                layoutParams2.rightMargin = b;
                layoutParams2.topMargin = b;
                nativeExpressADView.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
                this.n = new ImageView(context);
                FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(am.a(context, 46), am.a(context, 14));
                layoutParams1.gravity = 8388693;
                nativeExpressADView.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams1);
                this.n.setVisibility(8);
                g.a(this.n, e.n);
                imageView.setOnClickListener(new View.OnClickListener(this) {
                      public void onClick(View param1View) {
                        this.a.close();
                      }
                    });
              } 
              if (point1.x > 0 && point1.y > 0) {
                b = point1.y * i / point1.x;
              } else {
                b = -2;
              } 
              this.i.setContentView((View)nativeExpressADView, new ViewGroup.LayoutParams(i, b));
              this.j.a((Activity)str);
              if (f.a((Activity)str)) {
                this.i.show();
                this.k = true;
                y.a(new Runnable(this) {
                      public void run() {
                        d.c(this.a).onADOpened();
                      }
                    });
                return;
              } 
              str = "构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在show方法中指定Activity参数";
              GDTLogger.e(str);
            } 
            v.a((e)imageView, paramBoolean, b, this.o);
          } 
          GDTLogger.e(str);
        } 
        v.a((e)imageView, paramBoolean, b, this.o);
      } 
      GDTLogger.e(str);
      v.a((e)imageView, d(), 4015, this.o);
      return;
    } 
    GDTLogger.e(str);
  }
  
  private boolean d() {
    NativeExpressADView nativeExpressADView = this.a.a();
    if (nativeExpressADView != null) {
      String str = nativeExpressADView.getBoundData().getProperty("ad_info");
      try {
        boolean bool = m.a((new JSONObject(str)).optString("video"));
        if (!bool)
          return true; 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
    return false;
  }
  
  public int a() {
    return this.b.f();
  }
  
  public void a(JSONObject paramJSONObject) {
    this.o.b(paramJSONObject.optString("cl"));
    this.o.c(paramJSONObject.optString("traceid"));
  }
  
  public void b() {
    if (this.i != null && d()) {
      this.i.cancel();
      this.l = true;
    } 
  }
  
  public void c() {
    if (this.i != null && d()) {
      if (f.a(this.i.getOwnerActivity())) {
        this.i.show();
        this.l = false;
        return;
      } 
      GDTLogger.e("构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在show方法中指定Activity参数");
    } 
  }
  
  public void close() {
    Dialog dialog = this.i;
    if (dialog != null)
      dialog.dismiss(); 
  }
  
  public void destory() {
    NativeExpressADView nativeExpressADView = this.a.a();
    if (nativeExpressADView != null)
      nativeExpressADView.destroy(); 
    Dialog dialog = this.i;
    if (dialog != null)
      dialog.dismiss(); 
  }
  
  public String getAdNetWorkName() {
    return null;
  }
  
  public int getAdPatternType() {
    AdData adData;
    if (this.p) {
      AdData adData1 = this.a.b();
      adData = adData1;
      if (adData1 == null)
        return 0; 
    } else {
      NativeExpressADView nativeExpressADView = this.a.a();
      if (nativeExpressADView != null) {
        adData = nativeExpressADView.getBoundData();
        return adData.getAdPatternType();
      } 
      return 0;
    } 
    return adData.getAdPatternType();
  }
  
  public int getECPM() {
    String str;
    if (this.p) {
      AdData adData2 = this.a.b();
      AdData adData1 = adData2;
      return (adData2 == null) ? -1 : adData1.getECPM();
    } 
    NativeExpressADView nativeExpressADView = this.a.a();
    if (nativeExpressADView != null) {
      AdData adData = nativeExpressADView.getBoundData();
      if (adData != null)
        return adData.getECPM(); 
      str = "AD Parse failed, can't getECPM";
    } else {
      str = "Can't getECPM before AD ready!";
    } 
    GDTLogger.e(str);
    return -1;
  }
  
  public String getECPMLevel() {
    String str;
    if (this.p) {
      AdData adData2 = this.a.b();
      AdData adData1 = adData2;
      return (adData2 == null) ? null : adData1.getECPMLevel();
    } 
    NativeExpressADView nativeExpressADView = this.a.a();
    if (nativeExpressADView != null) {
      AdData adData = nativeExpressADView.getBoundData();
      if (adData != null)
        return adData.getECPMLevel(); 
      str = "AD Parse failed, can't getECPMLevel";
    } else {
      str = "Can't getECPMLevel before AD ready!";
    } 
    GDTLogger.e(str);
    return null;
  }
  
  public int getMediationPrice() {
    return this.b.getMediationPrice();
  }
  
  public boolean isContractAd() {
    return this.b.isContractAd();
  }
  
  public boolean isValid() {
    return this.q;
  }
  
  public void loadAd() {
    this.p = false;
    this.b.loadAd(e.n.c());
    Activity activity = this.h.get();
    if (activity != null) {
      Point point = new Point();
      activity.getWindowManager().getDefaultDisplay().getSize(point);
    } 
    this.k = false;
  }
  
  public void loadFullScreenAD() {
    this.p = true;
    this.c.loadAd(e.n.c());
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    if (this.l)
      return; 
    destory();
    this.j.a();
    y.a(new Runnable(this) {
          public void run() {
            d.c(this.a).onADClosed();
          }
        });
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    this.b.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy);
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.b.setMaxVideoDuration(paramInt);
    this.c.setMaxVideoDuration(paramInt);
  }
  
  public void setMediaListener(UnifiedInterstitialMediaListener paramUnifiedInterstitialMediaListener) {
    this.e = paramUnifiedInterstitialMediaListener;
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.b.setMinVideoDuration(paramInt);
    this.c.setMinVideoDuration(paramInt);
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    this.b.setVideoOption(paramVideoOption);
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.b.setVideoPlayPolicy(paramInt);
  }
  
  public void show() {
    Activity activity = this.h.get();
    if (activity == null) {
      GDTLogger.e("构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在show方法中指定Activity参数");
      return;
    } 
    show(activity);
  }
  
  public void show(Activity paramActivity) {
    a(true, paramActivity);
  }
  
  public void showAsPopupWindow() {
    Activity activity = this.h.get();
    if (activity == null) {
      GDTLogger.e("构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在showAsPopupWindown方法中指定Activity参数");
      return;
    } 
    showAsPopupWindow(activity);
  }
  
  public void showAsPopupWindow(Activity paramActivity) {
    a(false, paramActivity);
  }
  
  public void showFullScreenAD(Activity paramActivity) {
    char c1;
    if (paramActivity == null) {
      GDTLogger.e("Activity param for show should not be null");
      return;
    } 
    e e = e.v;
    v.a(e, true, this.o);
    JSONObject jSONObject = this.c.a();
    if (jSONObject == null) {
      GDTLogger.e("UnifiedInterstitial full screen video AD null , please loadAd again !");
      c1 = 'ྮ';
    } else {
      d d1 = this.c;
      if (d1 == null) {
        c1 = 'Ꭰ';
      } else {
        b.a(this.f, this.g, d1.g(), jSONObject, this.d, this.e, new a(this) {
              public void a(boolean param1Boolean) {
                d.a(this.a, param1Boolean);
              }
            });
        return;
      } 
    } 
    v.a(e, true, c1, this.o);
  }
  
  public static interface a {
    void a(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */