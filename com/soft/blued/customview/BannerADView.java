package com.soft.blued.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageOptions;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.pay.alipay.AlipayUtils;
import com.soft.blued.ui.user.utils.ADClosePopOptionsUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.TTADUtils;
import java.io.File;

public class BannerADView extends LinearLayout {
  private UIFinishListener A;
  
  public Context a;
  
  public View b;
  
  private IRequestHost c;
  
  private View d;
  
  private ImageView e;
  
  private ImageView f;
  
  private ImageView g;
  
  private View h;
  
  private View i;
  
  private CardView j;
  
  private LinearLayout k;
  
  private UnifiedBannerView l;
  
  private ImageOptions m;
  
  private TTNativeAd n;
  
  private boolean o = true;
  
  private BluedADConstraintLayout p;
  
  private ADListener q;
  
  private View r;
  
  private ADConstants.AD_POSITION s;
  
  private ConstraintLayout t;
  
  private ImageView u;
  
  private TextView v;
  
  private TextView w;
  
  private TextView x;
  
  private ImageView y;
  
  private TextView z;
  
  public BannerADView(Context paramContext) {
    super(paramContext);
    a(paramContext, (AttributeSet)null);
  }
  
  public BannerADView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public BannerADView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView) {
    this.u = (ImageView)paramView.findViewById(2131297571);
    this.v = (TextView)paramView.findViewById(2131301453);
    this.w = (TextView)paramView.findViewById(2131301451);
    this.x = (TextView)paramView.findViewById(2131301452);
    this.y = (ImageView)paramView.findViewById(2131297569);
    this.z = (TextView)paramView.findViewById(2131300640);
  }
  
  private void a(BluedADExtra paramBluedADExtra) {
    this.i.setVisibility(8);
    this.t.setVisibility(8);
    this.l = c(paramBluedADExtra);
    this.l.loadAD();
  }
  
  private void a(BluedADExtra paramBluedADExtra, int paramInt) {
    if (paramBluedADExtra != null) {
      Logger.a("bluedad", paramBluedADExtra.adms_type);
      setVisibility(0);
      this.r.setVisibility(0);
      if ("3".equalsIgnoreCase(paramBluedADExtra.adms_type)) {
        this.p.setADData(paramBluedADExtra);
        a(paramBluedADExtra);
        return;
      } 
      if ("4".equalsIgnoreCase(paramBluedADExtra.adms_type)) {
        String str;
        if (this.s == ADConstants.AD_POSITION.a) {
          str = "945023692";
        } else if (this.s == ADConstants.AD_POSITION.b) {
          str = "942650960";
        } else if (this.s == ADConstants.AD_POSITION.j) {
          str = "945663231";
        } else {
          str = "945023683";
        } 
        this.p.setADData(paramBluedADExtra);
        a(paramBluedADExtra, paramInt, str);
        return;
      } 
      if (!StringUtils.e(paramBluedADExtra.ads_pics)) {
        this.z.setOnClickListener(new -$$Lambda$BannerADView$AkO8DwbaGtES1kn3Lf5Yw2kWcj0(this));
        this.p.a(paramBluedADExtra, new -$$Lambda$BannerADView$67J-crRme4TvXF7EAz9Q18E69PI(this, paramBluedADExtra));
        b(paramBluedADExtra, paramInt);
        return;
      } 
      setVisibility(8);
      return;
    } 
    setVisibility(8);
  }
  
  private void a(BluedADExtra paramBluedADExtra, int paramInt, String paramString) {
    Logger.a("TTBANNER", paramString);
    this.i.setVisibility(8);
    UnifiedBannerView unifiedBannerView = this.l;
    if (unifiedBannerView != null) {
      unifiedBannerView.setVisibility(8);
      this.l.destroy();
    } 
    int i = DensityUtils.a(this.a, 10.0F);
    int j = null.a[this.s.ordinal()];
    if (j == 1 || j == 2)
      i = 0; 
    ConstraintLayout constraintLayout = this.t;
    constraintLayout.setPadding(i, constraintLayout.getPaddingTop(), i, this.t.getPaddingBottom());
    if (this.o) {
      this.o = false;
      TTADUtils.a(this.a, paramInt, paramString, new TTADUtils.TTGetAdListener(this, paramBluedADExtra) {
            public void a() {
              Logger.a("TTBANNER", "get ad error");
              this.b.setVisibility(8);
              if (BannerADView.f(this.b) != null && BannerADView.d(this.b).isActive())
                BannerADView.f(this.b).b(); 
            }
            
            public void a(TTNativeAd param1TTNativeAd) {
              BannerADView.a(this.b, param1TTNativeAd);
              BannerADView.a(this.b, this.a);
            }
            
            public void b() {
              Logger.a("TTBANNER", "get ad error");
              this.b.setVisibility(8);
              if (BannerADView.f(this.b) != null && BannerADView.d(this.b).isActive())
                BannerADView.f(this.b).b(); 
            }
          });
      return;
    } 
    b(paramBluedADExtra);
  }
  
  private void b(BluedADExtra paramBluedADExtra) {
    TTNativeAd tTNativeAd2 = this.n;
    if (tTNativeAd2 == null || tTNativeAd2.getImageList() == null || this.n.getImageList().isEmpty()) {
      setVisibility(8);
      return;
    } 
    this.r.setOnClickListener(new -$$Lambda$BannerADView$OX0rbCXx2SrFPRDjNt5bmOSNXww(this, paramBluedADExtra));
    TTImage tTImage = this.n.getImageList().get(0);
    if (tTImage != null && tTImage.isValid()) {
      Logger.a("TTAD", tTImage.getImageUrl());
      ImageSize imageSize = new ImageSize();
      ImageFileLoader.a(this.c).a(tTImage.getImageUrl()).a(imageSize).a(new ImageFileLoader.OnLoadFileListener(this, imageSize) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              if (param1File != null && param1File.exists()) {
                BannerADView.g(this.b).setVisibility(0);
                float f1 = this.a.a();
                float f2 = this.a.b();
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("img:");
                stringBuilder1.append(f1);
                stringBuilder1.append(";");
                stringBuilder1.append(f2);
                Logger.a("bluedad", stringBuilder1.toString());
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)BannerADView.h(this.b).getLayoutParams();
                layoutParams.width = (int)(layoutParams.height * f1 / f2);
                BannerADView.h(this.b).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("imglp:");
                stringBuilder2.append(layoutParams.width);
                stringBuilder2.append(";");
                stringBuilder2.append(layoutParams.height);
                Logger.a("bluedad", stringBuilder2.toString());
                ImageLoader.a(BannerADView.d(this.b), param1File).a(BannerADView.c(this.b)).a(BannerADView.h(this.b));
                if (BannerADView.e(this.b) != null) {
                  BannerADView.e(this.b).a(layoutParams.height);
                  return;
                } 
              } else if (BannerADView.f(this.b) != null && BannerADView.d(this.b).isActive()) {
                BannerADView.f(this.b).b();
              } 
            }
          }).a();
    } 
    this.v.setText(this.n.getTitle());
    this.x.setText(this.n.getDescription());
    TTNativeAd tTNativeAd1 = this.n;
    if (tTNativeAd1 != null) {
      tTNativeAd1.registerViewForInteraction((ViewGroup)this.t, (View)this.z, new TTNativeAd.AdInteractionListener(this, paramBluedADExtra) {
            public void onAdClicked(View param1View, TTNativeAd param1TTNativeAd) {
              Logger.a("ttadclick", "onAdClicked");
              FindHttpUtils.a(this.a.click_url);
            }
            
            public void onAdCreativeClick(View param1View, TTNativeAd param1TTNativeAd) {
              Logger.a("ttadclick", "onAdCreativeClick");
              FindHttpUtils.a(this.a.click_url);
            }
            
            public void onAdShow(TTNativeAd param1TTNativeAd) {}
          });
      return;
    } 
  }
  
  private void b(BluedADExtra paramBluedADExtra, int paramInt) {
    Logger.a("bluedad", "showBluedAD");
    this.i.setVisibility(0);
    this.t.setVisibility(8);
    UnifiedBannerView unifiedBannerView = this.l;
    if (unifiedBannerView != null) {
      unifiedBannerView.setVisibility(8);
      this.l.destroy();
    } 
    if (paramBluedADExtra.can_close == 1) {
      this.f.setVisibility(0);
      this.r.setOnClickListener(new -$$Lambda$BannerADView$xXDkBTrdHblqmb2ekHQ0VPOTTYo(this, paramBluedADExtra));
    } else {
      this.f.setVisibility(8);
      this.r.setOnClickListener(null);
    } 
    if (paramBluedADExtra.is_show_adm_icon == 1) {
      this.g.setVisibility(0);
    } else {
      this.g.setVisibility(8);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ad.ads_pics:");
    stringBuilder.append(paramBluedADExtra.ads_pics);
    Logger.a("bluedad", stringBuilder.toString());
    ImageSize imageSize = new ImageSize();
    ImageFileLoader.a(this.c).a(paramBluedADExtra.ads_pics).a(imageSize).a(new ImageFileLoader.OnLoadFileListener(this, imageSize, paramInt) {
          public void onUIFinish(File param1File, Exception param1Exception) {
            if (param1File != null && param1File.exists()) {
              float f1 = this.a.a();
              float f2 = this.a.b();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("img:");
              stringBuilder1.append(f1);
              stringBuilder1.append(";");
              stringBuilder1.append(f2);
              Logger.a("bluedad", stringBuilder1.toString());
              FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams)BannerADView.a(this.c).getLayoutParams();
              layoutParams1.width = DensityUtils.a(this.c.a, this.b);
              layoutParams1.height = (int)(layoutParams1.width * f2 / f1);
              BannerADView.a(this.c).setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("imglp:");
              stringBuilder2.append(layoutParams1.width);
              stringBuilder2.append(";");
              stringBuilder2.append(layoutParams1.height);
              Logger.a("bluedad", stringBuilder2.toString());
              FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams)BannerADView.b(this.c).getLayoutParams();
              layoutParams2.height = layoutParams1.height;
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append("contentLP:");
              stringBuilder3.append(layoutParams2.width);
              stringBuilder3.append(";");
              stringBuilder3.append(layoutParams2.height);
              Logger.a("bluedad", stringBuilder3.toString());
              BannerADView.b(this.c).setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
              ImageLoader.a(BannerADView.d(this.c), param1File).a(BannerADView.c(this.c)).a(BannerADView.a(this.c));
              if (BannerADView.e(this.c) != null) {
                BannerADView.e(this.c).a(layoutParams1.height);
                return;
              } 
            } else if (BannerADView.f(this.c) != null && BannerADView.d(this.c).isActive()) {
              BannerADView.f(this.c).b();
            } 
          }
        }).a();
  }
  
  private UnifiedBannerView c(BluedADExtra paramBluedADExtra) {
    String str;
    UnifiedBannerView unifiedBannerView = this.l;
    if (unifiedBannerView != null)
      return unifiedBannerView; 
    if (this.s == ADConstants.AD_POSITION.j) {
      str = BluedConstant.c();
    } else {
      str = BluedConstant.b();
    } 
    this.l = new UnifiedBannerView((Activity)this.a, BluedConstant.a(), str, new UnifiedBannerADListener(this, paramBluedADExtra) {
          public void onADClicked() {
            FindHttpUtils.a(this.a.click_url);
          }
          
          public void onADCloseOverlay() {
            Logger.c("TXAD", new Object[] { "onADCloseOverlay" });
          }
          
          public void onADClosed() {}
          
          public void onADExposure() {
            Logger.c("TXAD", new Object[] { "onADExposure" });
          }
          
          public void onADLeftApplication() {
            Logger.c("TXAD", new Object[] { "onADLeftApplication" });
          }
          
          public void onADOpenOverlay() {
            Logger.c("TXAD", new Object[] { "onADOpenOverlay" });
          }
          
          public void onADReceive() {
            Logger.c("TXAD", new Object[] { "onADReceive" });
            BannerADView.i(this.b).setOnClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    Logger.a("TXAD", "tvTransparentClose.setOnClickListener");
                    ADClosePopOptionsUtils.a(this.a.b.a, this.a.a, BannerADView.i(this.a.b), BannerADView.j(this.a.b), new -$$Lambda$BannerADView$5$1$z6gnYLupP9GCjcOXXknV-CDIWkw(this));
                  }
                });
          }
          
          public void onNoAD(AdError param1AdError) {
            if (param1AdError != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(param1AdError.getErrorCode());
              stringBuilder.append(":");
              stringBuilder.append(param1AdError.getErrorMsg());
              Logger.c("TXAD", new Object[] { stringBuilder.toString() });
            } 
            this.b.a();
            if (BannerADView.f(this.b) != null && BannerADView.d(this.b).isActive())
              BannerADView.f(this.b).b(); 
          }
        });
    this.l.setRefresh(0);
    this.k.addView((View)this.l, (ViewGroup.LayoutParams)getUnifiedBannerLayoutParams());
    this.k.setVisibility(0);
    return this.l;
  }
  
  private FrameLayout.LayoutParams getUnifiedBannerLayoutParams() {
    int i = AppInfo.l - DensityUtils.a(this.a, 20.0F);
    return new FrameLayout.LayoutParams(i, Math.round(i / 6.4F));
  }
  
  public void a() {
    setVisibility(8);
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet) {
    this.a = paramContext;
    this.m = new ImageOptions();
    ImageOptions imageOptions = this.m;
    imageOptions.a = 2131231369;
    imageOptions.c = 2131231369;
    this.b = LayoutInflater.from(this.a).inflate(2131492918, (ViewGroup)this);
    this.d = this.b.findViewById(2131300299);
    this.e = (ImageView)this.b.findViewById(2131297419);
    this.f = (ImageView)this.b.findViewById(2131297420);
    this.g = (ImageView)this.b.findViewById(2131297421);
    this.h = this.b.findViewById(2131296573);
    this.i = this.b.findViewById(2131297092);
    this.j = (CardView)this.b.findViewById(2131297078);
    this.k = (LinearLayout)this.b.findViewById(2131299100);
    this.t = (ConstraintLayout)this.b.findViewById(2131297169);
    this.p = (BluedADConstraintLayout)this.b.findViewById(2131296419);
    this.r = this.b.findViewById(2131301447);
    a(this.b);
    if (paramAttributeSet != null) {
      TypedArray typedArray = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.BannerADView);
      boolean bool1 = typedArray.getBoolean(2, false);
      boolean bool2 = typedArray.getBoolean(1, false);
      float f = typedArray.getDimension(0, 0.0F);
      if (bool1)
        this.d.setVisibility(0); 
      if (bool2)
        this.h.setVisibility(0); 
      if (f > 0.0F)
        this.j.setRadius(f); 
    } 
    setVisibility(8);
  }
  
  public void a(IRequestHost paramIRequestHost, BluedADExtra paramBluedADExtra, ADConstants.AD_POSITION paramAD_POSITION, ADListener paramADListener) {
    int i;
    this.q = paramADListener;
    this.s = paramAD_POSITION;
    this.c = paramIRequestHost;
    if (paramAD_POSITION == ADConstants.AD_POSITION.a || paramAD_POSITION == ADConstants.AD_POSITION.e) {
      i = DensityUtils.b(this.a, AppInfo.l) - 20;
    } else if (paramAD_POSITION == ADConstants.AD_POSITION.c) {
      i = DensityUtils.b(this.a, AppInfo.l) - 6;
    } else {
      i = DensityUtils.b(this.a, AppInfo.l);
    } 
    if (!paramBluedADExtra.isShowUrlVisited) {
      this.o = true;
    } else {
      this.o = false;
    } 
    a(paramBluedADExtra, i);
  }
  
  public void b() {
    UnifiedBannerView unifiedBannerView = this.l;
    if (unifiedBannerView != null)
      unifiedBannerView.destroy(); 
  }
  
  public void setRadius(float paramFloat) {
    if (paramFloat > 0.0F)
      this.j.setRadius(DensityUtils.a(this.a, paramFloat)); 
  }
  
  public void setUIFinishListener(UIFinishListener paramUIFinishListener) {
    this.A = paramUIFinishListener;
  }
  
  public static interface ADListener {
    void a();
    
    void b();
  }
  
  public static interface UIFinishListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\BannerADView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */