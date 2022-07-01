package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ai;

public class RewardDislikeToast extends FrameLayout {
  private Handler a = new Handler(Looper.getMainLooper());
  
  private TextView b;
  
  public RewardDislikeToast(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public RewardDislikeToast(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RewardDislikeToast(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setVisibility(8);
    setClickable(false);
    setFocusable(false);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.b = new TextView(paramContext);
    this.b.setClickable(false);
    this.b.setFocusable(false);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 17;
    int i = (int)ai.a(o.a(), 20.0F);
    int j = (int)ai.a(o.a(), 12.0F);
    this.b.setPadding(i, j, i, j);
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.b.setTextColor(-1);
    this.b.setTextSize(16.0F);
    this.b.setGravity(17);
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setShape(0);
    gradientDrawable.setColor(Color.parseColor("#CC000000"));
    gradientDrawable.setCornerRadius(ai.a(o.a(), 6.0F));
    this.b.setBackgroundDrawable((Drawable)gradientDrawable);
    addView((View)this.b);
  }
  
  public void a() {
    setVisibility(8);
    this.a.removeCallbacksAndMessages(null);
  }
  
  public void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.a.removeCallbacksAndMessages(null);
    this.a.post(new Runnable(this, paramString) {
          public void run() {
            if (RewardDislikeToast.a(this.b) != null)
              RewardDislikeToast.a(this.b).setText(String.valueOf(this.a)); 
            this.b.setVisibility(0);
          }
        });
    this.a.postDelayed(new Runnable(this) {
          public void run() {
            this.a.setVisibility(8);
          }
        },  2000L);
  }
  
  public void b() {
    setVisibility(8);
    this.a.removeCallbacksAndMessages(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\view\RewardDislikeToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */