package com.baidu.mobads;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.a.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AdView extends RelativeLayout {
  protected static final String P_VERSION = "3.61";
  
  IOAdEventListener a = new a(this);
  
  private AtomicBoolean b = new AtomicBoolean(false);
  
  private a c;
  
  private AdViewListener d;
  
  public AdView(Context paramContext) {
    super(paramContext);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean, AdSize paramAdSize, String paramString) {
    super(paramContext, paramAttributeSet);
    XAdView xAdView = new XAdView(paramContext);
    this.c = new a(paramContext, (RelativeLayout)xAdView, paramString, paramBoolean);
    this.c.addEventListener("AdLoaded", this.a);
    this.c.addEventListener("AdError", this.a);
    this.c.addEventListener("AdStarted", this.a);
    this.c.addEventListener("AdUserClick", this.a);
    this.c.addEventListener("AdUserClose", this.a);
    xAdView.setListener(new c(this));
    addView((View)xAdView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public AdView(Context paramContext, AdSize paramAdSize, String paramString) {
    this(paramContext, true, paramAdSize, paramString);
  }
  
  public AdView(Context paramContext, String paramString) {
    this(paramContext, true, AdSize.Banner, paramString);
  }
  
  AdView(Context paramContext, boolean paramBoolean, AdSize paramAdSize, String paramString) {
    this(paramContext, (AttributeSet)null, paramBoolean, paramAdSize, paramString);
  }
  
  private void a() {
    if (!this.b.get()) {
      this.b.set(true);
      this.c.request();
    } 
  }
  
  @Deprecated
  public static void setAppSec(Context paramContext, String paramString) {}
  
  public static void setAppSid(Context paramContext, String paramString) {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(paramString);
  }
  
  public void destroy() {
    this.c.r();
  }
  
  @Deprecated
  public void setAlpha(float paramFloat) {}
  
  @Deprecated
  public void setBackgroundColor(int paramInt) {}
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    int i;
    XAdSDKFoundationFacade.getInstance().getAdLogger().d(new Object[] { "AdView.setLayoutParams=", Integer.valueOf(paramLayoutParams.width), Integer.valueOf(paramLayoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()) });
    int j = paramLayoutParams.width;
    int k = paramLayoutParams.height;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    int m = displayMetrics.widthPixels;
    int n = displayMetrics.heightPixels;
    float f = displayMetrics.density;
    XAdSDKFoundationFacade.getInstance().getAdLogger().d(new Object[] { "AdView.setLayoutParams", Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f) });
    if (j <= 0) {
      i = Math.min(m, n);
    } else {
      i = j;
      if (j > 0) {
        float f1 = j;
        float f2 = 200.0F * f;
        i = j;
        if (f1 < f2)
          i = (int)f2; 
      } 
    } 
    if (k <= 0) {
      j = (int)(Math.min(m, n) * 0.15F);
    } else {
      j = k;
      if (k > 0) {
        float f1 = k;
        f *= 30.0F;
        j = k;
        if (f1 < f)
          j = (int)f; 
      } 
    } 
    paramLayoutParams.width = i;
    paramLayoutParams.height = j;
    a a1 = this.c;
    if (a1 != null && a1.a() != null) {
      this.c.a().d(paramLayoutParams.width);
      this.c.a().e(paramLayoutParams.height);
    } 
    XAdSDKFoundationFacade.getInstance().getAdLogger().d(new Object[] { "AdView.setLayoutParams adapter", Integer.valueOf(paramLayoutParams.width), Integer.valueOf(paramLayoutParams.height) });
    super.setLayoutParams(paramLayoutParams);
  }
  
  public void setListener(AdViewListener paramAdViewListener) {
    this.d = paramAdViewListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */