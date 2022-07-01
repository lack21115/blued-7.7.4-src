package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;

public class LivePKResult extends FrameLayout implements View.OnClickListener {
  Runnable a = new Runnable(this) {
      public void run() {
        this.a.setVisibility(8);
      }
    };
  
  private TextView b;
  
  private TextView c;
  
  public LivePKResult(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LivePKResult(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b() {
    LayoutInflater.from(getContext()).inflate(R.layout.live_pk_result, (ViewGroup)this);
    this.b = (TextView)findViewById(R.id.tv_my_num);
    this.c = (TextView)findViewById(R.id.tv_other_num);
    setVisibility(8);
  }
  
  public void a() {
    removeCallbacks(this.a);
    setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.b.setText(String.valueOf(paramInt1));
    this.c.setText(String.valueOf(paramInt2));
    setVisibility(8);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(false);
    clearAnimation();
    startAnimation((Animation)alphaAnimation);
    setVisibility(0);
    removeCallbacks(this.a);
    postDelayed(this.a, 5000L);
  }
  
  public void onClick(View paramView) {}
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    setVisibility(8);
    removeCallbacks(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */