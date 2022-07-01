package com.soft.blued.ui.discover.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.superexpose.SuperExposeProtos;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.log.trackUtils.EventTrackSuperExpose;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import java.util.List;

public class FeedPromotionDlg extends Dialog {
  private View a;
  
  private View b;
  
  private ImageView c;
  
  private TextView d;
  
  private TextView e;
  
  private View f;
  
  private View g;
  
  private int h = 0;
  
  private String i;
  
  private AppConfigModel.FeedPromotion j;
  
  private Runnable k = new Runnable(this) {
      public void run() {
        FeedPromotionDlg.a(this.a, false, 0);
      }
    };
  
  public FeedPromotionDlg(Context paramContext, int paramInt, AppConfigModel.FeedPromotion paramFeedPromotion) {
    super(paramContext, paramInt);
    this.j = paramFeedPromotion;
    a();
  }
  
  private void a() {
    this.a = LayoutInflater.from(getContext()).inflate(2131493041, null);
    this.b = this.a.findViewById(2131296949);
    AppConfigModel.FeedPromotion feedPromotion = this.j;
    if (feedPromotion != null)
      this.h = feedPromotion.type; 
    if (b()) {
      this.f = this.a.findViewById(2131296947);
      this.f.setVisibility(0);
      this.g = this.a.findViewById(2131296946);
      this.g.setOnClickListener(new -$$Lambda$FeedPromotionDlg$eEHie-Ct5hjLLodtRV897LOwHjA(this));
      this.e = (TextView)this.a.findViewById(2131296945);
      this.c = (ImageView)this.a.findViewById(2131296948);
      if (BluedConfig.b().n() != null) {
        if (!TextUtils.isEmpty((BluedConfig.b().n()).btn))
          this.e.setText((BluedConfig.b().n()).btn); 
        if (!TextUtils.isEmpty((BluedConfig.b().n()).img))
          ImageLoader.a(null, (BluedConfig.b().n()).img).f().a(this.c); 
      } 
      this.d = (TextView)this.a.findViewById(2131296950);
      this.d.setText((BluedConfig.b().n()).text);
      this.e.setOnClickListener(new -$$Lambda$FeedPromotionDlg$jVtPi-uNmCgpfrBTBL7_5SzUzj0(this));
      EventTrackSuperExpose.a(SuperExposeProtos.Event.AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW);
    } else {
      this.f = this.a.findViewById(2131296765);
      this.f.setVisibility(0);
      TextView textView11 = (TextView)this.a.findViewById(2131300762);
      TextView textView10 = (TextView)this.a.findViewById(2131300761);
      TextView textView4 = (TextView)this.a.findViewById(2131301203);
      TextView textView5 = (TextView)this.a.findViewById(2131301202);
      TextView textView6 = (TextView)this.a.findViewById(2131301201);
      TextView textView7 = (TextView)this.a.findViewById(2131301200);
      TextView textView8 = (TextView)this.a.findViewById(2131300676);
      TextView textView9 = (TextView)this.a.findViewById(2131300673);
      TextView textView3 = (TextView)this.a.findViewById(2131300672);
      TextView textView1 = (TextView)this.a.findViewById(2131301204);
      TextView textView2 = (TextView)this.a.findViewById(2131301205);
      ImageView imageView = (ImageView)this.a.findViewById(2131297729);
      textView11.setText(this.j.title);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("动态上热门，用超级曝光");
      spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(2131100788)), 7, spannableStringBuilder.length(), 33);
      textView10.setText((CharSequence)spannableStringBuilder);
      List<String> list = this.j.subhead;
      String[] arrayOfString1 = ((String)list.get(0)).split("-");
      String[] arrayOfString2 = ((String)list.get(1)).split("-");
      textView4.setText(arrayOfString1[0]);
      textView5.setText(arrayOfString1[1]);
      textView6.setText(arrayOfString2[0]);
      textView7.setText(arrayOfString2[1]);
      textView8.setText(this.j.discount_text);
      textView9.getBackground().setAlpha(20);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.j.discount_money);
      stringBuilder2.append("");
      textView3.setText(stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("原价¥");
      stringBuilder1.append(this.j.origin_money);
      stringBuilder1.append("/次");
      textView1.setText(stringBuilder1.toString());
      textView1.setPaintFlags(textView1.getPaintFlags() | 0x10);
      textView2.setText(this.j.btn);
      textView2.setOnClickListener(new -$$Lambda$FeedPromotionDlg$gxfMzg0p96NQBk1OjLUakAi8X4w(this));
      imageView.setOnClickListener(new -$$Lambda$FeedPromotionDlg$qCIyIbuJfrYN6OUIVFPJDckfZks(this));
      EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_SHOW);
    } 
    setContentView(this.a);
    StatusBarHelper.a(getWindow());
    setCancelable(false);
  }
  
  private void a(boolean paramBoolean, int paramInt) {
    AppInfo.n().removeCallbacks(this.k);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(370L);
    alphaAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.66F, 0.01F, 0.34F, 1.0F));
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this, paramBoolean, paramInt) {
          public void onAnimationEnd(Animation param1Animation) {
            if (this.a) {
              WebViewShowInfoFragment.show(this.c.getContext(), FeedPromotionDlg.a(this.c), 0);
              int i = this.b;
              if (i == 2) {
                EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK);
              } else if (i == 1) {
                EventTrackSuperExpose.a(SuperExposeProtos.Event.AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY);
              } 
            } 
            this.c.dismiss();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.f.startAnimation((Animation)alphaAnimation);
    this.f.postDelayed(new Runnable(this) {
          public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
            alphaAnimation.setDuration(165L);
            alphaAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.17F, 0.17F, 0.83F, 1.0F));
            FeedPromotionDlg.b(this.a).startAnimation((Animation)alphaAnimation);
          }
        }200L);
  }
  
  private boolean b() {
    return (this.h == 0);
  }
  
  public void a(String paramString) {
    this.i = paramString;
  }
  
  protected void onCreate(Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 28) {
      WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
      layoutParams.layoutInDisplayCutoutMode = 1;
      getWindow().setAttributes(layoutParams);
    } 
    super.onCreate(paramBundle);
  }
  
  public void show() {
    super.show();
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.48F, 0.05F, 0.83F, 0.83F));
    alphaAnimation.setDuration(330L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(410L);
    alphaAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.66F, 0.01F, 0.34F, 1.0F));
    this.f.startAnimation((Animation)alphaAnimation);
    if (b())
      AppInfo.n().postDelayed(this.k, 2000L); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\view\FeedPromotionDlg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */