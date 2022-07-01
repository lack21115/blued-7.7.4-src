package com.soft.blued.customview;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

public class VideoLoadingView extends View {
  private Paint a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private ValueAnimator e;
  
  public VideoLoadingView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public VideoLoadingView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.a = new Paint();
    this.a.setColor(Color.parseColor("#FFFFFF"));
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(5.0F);
    this.c = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    if (this.c == 0)
      this.c = 2160; 
    this.e = new ValueAnimator();
    ValueAnimator valueAnimator = this.e;
    int i = this.c;
    valueAnimator.setFloatValues(new float[] { (i / 15), i });
    this.e.setDuration(500L);
    this.e.setRepeatCount(-1);
    this.e.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            VideoLoadingView videoLoadingView = this.a;
            VideoLoadingView.a(videoLoadingView, (int)((1.0F - f / VideoLoadingView.a(videoLoadingView) / 2.0F) * 255.0F));
            VideoLoadingView.b(this.a, (int)f);
            this.a.invalidate();
          }
        });
    this.e.start();
  }
  
  public void a() {
    this.e.start();
  }
  
  public void b() {
    this.e.cancel();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    this.a.setAlpha(this.d);
    int i = this.c;
    int j = i / 2;
    int k = this.b;
    paramCanvas.drawLine((j - k / 2), 0.0F, (i / 2 + k / 2), 0.0F, this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\VideoLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */