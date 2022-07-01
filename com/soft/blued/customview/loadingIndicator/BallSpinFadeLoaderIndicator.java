package com.soft.blued.customview.loadingIndicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;

public class BallSpinFadeLoaderIndicator extends BaseIndicatorController {
  float[] a = new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  
  int[] b = new int[] { 255, 255, 255, 255, 255, 255, 255, 255 };
  
  Point a(int paramInt1, int paramInt2, float paramFloat, double paramDouble) {
    double d1 = (paramInt1 / 2);
    double d2 = paramFloat;
    return new Point(this, (float)(d1 + Math.cos(paramDouble) * d2), (float)((paramInt2 / 2) + d2 * Math.sin(paramDouble)));
  }
  
  public List<Animator> a() {
    ArrayList<ValueAnimator> arrayList = new ArrayList();
    int[] arrayOfInt = new int[9];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 120;
    arrayOfInt[2] = 240;
    arrayOfInt[3] = 360;
    arrayOfInt[4] = 480;
    arrayOfInt[5] = 600;
    arrayOfInt[6] = 720;
    arrayOfInt[7] = 780;
    arrayOfInt[8] = 840;
    for (int i = 0; i < 8; i++) {
      ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F, 1.0F });
      valueAnimator1.setDuration(1000L);
      valueAnimator1.setRepeatCount(-1);
      valueAnimator1.setStartDelay(arrayOfInt[i]);
      valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.b.a[this.a] = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
              this.b.e();
            }
          });
      valueAnimator1.start();
      ValueAnimator valueAnimator2 = ValueAnimator.ofInt(new int[] { 255, 77, 255 });
      valueAnimator2.setDuration(1000L);
      valueAnimator2.setRepeatCount(-1);
      valueAnimator2.setStartDelay(arrayOfInt[i]);
      valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.b.b[this.a] = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              this.b.e();
            }
          });
      valueAnimator2.start();
      arrayList.add(valueAnimator1);
      arrayList.add(valueAnimator2);
    } 
    return (List)arrayList;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint) {
    float f = (c() / 10);
    int i;
    for (i = 0; i < 8; i++) {
      paramCanvas.save();
      Point point = a(c(), d(), (c() / 2) - f, 0.7853981633974483D * i);
      paramCanvas.translate(point.a, point.b);
      float[] arrayOfFloat = this.a;
      paramCanvas.scale(arrayOfFloat[i], arrayOfFloat[i]);
      paramPaint.setAlpha(this.b[i]);
      paramCanvas.drawCircle(0.0F, 0.0F, f, paramPaint);
      paramCanvas.restore();
    } 
  }
  
  final class Point {
    public float a;
    
    public float b;
    
    public Point(BallSpinFadeLoaderIndicator this$0, float param1Float1, float param1Float2) {
      this.a = param1Float1;
      this.b = param1Float2;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\loadingIndicator\BallSpinFadeLoaderIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */