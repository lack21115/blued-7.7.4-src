package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.b.a;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.constants.a;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.g.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.m;

public class SplashAd {
  private a a;
  
  private int b = 4;
  
  private volatile String c = "init";
  
  private Context d;
  
  private SplashAdListener e = new r(this);
  
  private IOAdEventListener f = new s(this);
  
  public SplashAd(Context paramContext, ViewGroup paramViewGroup, SplashAdListener paramSplashAdListener, String paramString) {
    this(paramContext, paramViewGroup, paramSplashAdListener, paramString, true);
  }
  
  public SplashAd(Context paramContext, ViewGroup paramViewGroup, SplashAdListener paramSplashAdListener, String paramString, int paramInt) {
    this(paramContext, paramViewGroup, paramSplashAdListener, paramString, true, null, paramInt);
  }
  
  public SplashAd(Context paramContext, ViewGroup paramViewGroup, SplashAdListener paramSplashAdListener, String paramString, boolean paramBoolean) {
    this(paramContext, paramViewGroup, paramSplashAdListener, paramString, paramBoolean, null);
  }
  
  public SplashAd(Context paramContext, ViewGroup paramViewGroup, SplashAdListener paramSplashAdListener, String paramString, boolean paramBoolean, RequestParameters paramRequestParameters) {
    this(paramContext, paramViewGroup, paramSplashAdListener, paramString, true, paramRequestParameters, 4200);
  }
  
  public SplashAd(Context paramContext, ViewGroup paramViewGroup, SplashAdListener paramSplashAdListener, String paramString, boolean paramBoolean, RequestParameters paramRequestParameters, int paramInt) {
    try {
      this.d = paramContext;
      a.l = System.currentTimeMillis();
      a.m = 0L;
      a.n = 0L;
      a.o = 0L;
      a.p = 0L;
      a.q = 0L;
      a.r = 0L;
      if (!AppActivity.isAnti())
        a(paramViewGroup, paramContext); 
      if (paramSplashAdListener != null)
        this.e = paramSplashAdListener; 
      if (TextUtils.isEmpty(paramString)) {
        this.e.onAdFailed("请您输入正确的广告位ID");
        return;
      } 
      XAdView xAdView = new XAdView(paramContext);
      xAdView.setListener(new u(this, paramContext, xAdView, paramString, paramBoolean, paramInt, paramRequestParameters));
      xAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.addView((View)xAdView);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      a a1 = a.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("splash ad create failed: ");
      stringBuilder.append(exception.toString());
      a1.a(stringBuilder.toString());
      return;
    } 
  }
  
  private void a(ViewGroup paramViewGroup, Context paramContext) {
    try {
      paramViewGroup.addView((View)new SurfaceView(paramContext), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(0, 0));
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return;
    } 
  }
  
  @Deprecated
  public static void setAppSec(Context paramContext, String paramString) {}
  
  public static void setAppSid(Context paramContext, String paramString) {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(paramString);
  }
  
  public static void setBitmapDisplayMode(int paramInt) {
    a.a(paramInt);
  }
  
  public static void setMaxVideoCacheCapacityMb(int paramInt) {
    if (paramInt >= 15 && paramInt <= 100) {
      m.a(paramInt);
      return;
    } 
    m.a(30);
    XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "开屏设置视频最大缓存值有效范围在15~100M,默认30M", "");
  }
  
  public void destroy() {
    a a1 = this.a;
    if (a1 != null)
      a1.r(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\SplashAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */