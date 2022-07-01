package com.soft.blued.ui.feed.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;

public class FeedVoteView extends RelativeLayout {
  private int a = 0;
  
  private int b = 0;
  
  private int c;
  
  private int d = 500;
  
  private String e = "#80000000";
  
  private ImageView f = new ImageView(getContext());
  
  private View g = new View(getContext());
  
  private View h = new View(getContext());
  
  private TextView i = new TextView(getContext());
  
  private ImageView j = new ImageView(getContext());
  
  private int[] k = new int[] { Color.parseColor("#777AFF"), Color.parseColor("#AA4FFF") };
  
  private int[] l = new int[] { -1, -1 };
  
  private boolean m = false;
  
  private boolean n = false;
  
  private boolean o = false;
  
  public FeedVoteView(Context paramContext) {
    super(paramContext);
    c();
  }
  
  public FeedVoteView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public FeedVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a() {
    this.g.setVisibility(0);
    this.i.setVisibility(0);
    this.h.setVisibility(0);
    if (this.n) {
      this.j.setVisibility(0);
    } else {
      this.j.setVisibility(8);
    } 
    this.f.setVisibility(8);
  }
  
  private void b() {
    this.g.setVisibility(8);
    this.i.setVisibility(8);
    this.h.setVisibility(8);
    this.j.setVisibility(8);
    this.f.setVisibility(0);
  }
  
  private void c() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(15);
    addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
    this.f.setImageResource(2131234482);
    this.g.setBackgroundColor(Color.parseColor(this.e));
    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.g, (ViewGroup.LayoutParams)layoutParams);
    this.h.setId(2131301694);
    layoutParams = new RelativeLayout.LayoutParams(DensityUtils.a(getContext(), 5.0F), 0);
    layoutParams.addRule(14);
    layoutParams.addRule(12);
    addView(this.h, (ViewGroup.LayoutParams)layoutParams);
    this.i.setTextSize(15.0F);
    this.i.setTextColor(-1);
    this.i.setText("0%");
    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(14);
    layoutParams.addRule(2, this.h.getId());
    layoutParams.bottomMargin = DensityUtils.a(getContext(), 5.0F);
    addView((View)this.i, (ViewGroup.LayoutParams)layoutParams);
    layoutParams = new RelativeLayout.LayoutParams(DensityUtils.a(getContext(), 60.0F), DensityUtils.a(getContext(), 60.0F));
    layoutParams.addRule(14);
    layoutParams.topMargin = DensityUtils.a(getContext(), 85.0F);
    addView((View)this.j, (ViewGroup.LayoutParams)layoutParams);
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            FeedVoteView feedVoteView = this.a;
            FeedVoteView.a(feedVoteView, DensityUtils.a(feedVoteView.getContext(), 120.0F));
            if (FeedVoteView.a(this.a) != 0) {
              feedVoteView = this.a;
              feedVoteView.setPercent(FeedVoteView.a(feedVoteView));
            } 
            if (FeedVoteView.b(this.a))
              FeedVoteView.c(this.a); 
          }
        });
    setVoted(this.m);
  }
  
  public void a(IRequestHost paramIRequestHost) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, this.b });
    valueAnimator.setDuration(this.d);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)FeedVoteView.d(this.a).getLayoutParams();
            layoutParams.height = (int)f;
            FeedVoteView.d(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator.start();
    if (this.n) {
      String str;
      if (this.o) {
        str = "vote_anim_purple.png";
      } else {
        str = "vote_anim_white.png";
      } 
      ImageLoader.c(paramIRequestHost, str).b(500).g().a(new ImageLoader.OnAnimationStateListener(this, paramIRequestHost) {
            public void a() {}
            
            public void b() {
              int i;
              IRequestHost iRequestHost = this.a;
              if (FeedVoteView.f(this.b)) {
                i = 2131234483;
              } else {
                i = 2131234484;
              } 
              ImageLoader.a(iRequestHost, i).a(FeedVoteView.e(this.b));
            }
          }).a(this.j);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    this.a = DensityUtils.a(getContext(), 120.0F);
  }
  
  public void setDecorateResource(int paramInt) {
    this.f.setImageResource(paramInt);
  }
  
  public void setLeft(boolean paramBoolean) {
    this.o = paramBoolean;
    RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    if (paramBoolean) {
      layoutParams2.rightMargin = DensityUtils.a(getContext(), 1.5F);
      layoutParams1.rightMargin = DensityUtils.a(getContext(), 1.5F);
      layoutParams1.addRule(11);
      this.f.setImageResource(2131234481);
    } else {
      layoutParams1.leftMargin = DensityUtils.a(getContext(), 1.5F);
      layoutParams2.leftMargin = DensityUtils.a(getContext(), 1.5F);
    } 
    this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
  }
  
  public void setPercent(int paramInt) {
    int[] arrayOfInt;
    this.c = paramInt;
    this.b = (int)(paramInt / 100.0F * this.a);
    TextView textView = this.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("%");
    textView.setText(stringBuilder.toString());
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    layoutParams.height = this.b;
    this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
    if (this.o) {
      arrayOfInt = this.k;
    } else {
      arrayOfInt = this.l;
    } 
    GradientDrawable gradientDrawable = new GradientDrawable(orientation, arrayOfInt);
    gradientDrawable.setCornerRadii(new float[] { DensityUtils.a(getContext(), 20.0F), DensityUtils.a(getContext(), 20.0F), DensityUtils.a(getContext(), 20.0F), DensityUtils.a(getContext(), 20.0F), 0.0F, 0.0F, 0.0F, 0.0F });
    this.h.setBackground((Drawable)gradientDrawable);
    ImageView imageView = this.j;
    if (this.o) {
      paramInt = 2131234483;
    } else {
      paramInt = 2131234484;
    } 
    imageView.setImageResource(paramInt);
  }
  
  public void setShowOk(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public void setVoted(boolean paramBoolean) {
    this.m = paramBoolean;
    if (paramBoolean) {
      a();
      return;
    } 
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\view\FeedVoteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */