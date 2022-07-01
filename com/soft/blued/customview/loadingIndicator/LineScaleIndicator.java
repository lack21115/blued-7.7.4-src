package com.soft.blued.customview.loadingIndicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class LineScaleIndicator extends BaseIndicatorController {
  float[] a = new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  
  public List<Animator> a() {
    ArrayList<ValueAnimator> arrayList = new ArrayList();
    for (int i = 0; i < 5; i++) {
      ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F, 1.0F });
      valueAnimator.setDuration(1000L);
      valueAnimator.setRepeatCount(-1);
      (new long[5])[0] = 100L;
      (new long[5])[1] = 200L;
      (new long[5])[2] = 300L;
      (new long[5])[3] = 400L;
      (new long[5])[4] = 500L;
      valueAnimator.setStartDelay((new long[5])[i]);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.b.a[this.a] = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
              this.b.e();
            }
          });
      valueAnimator.start();
      arrayList.add(valueAnimator);
    } 
    return (List)arrayList;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint) {
    float f1 = (c() / 11);
    float f2 = (d() / 2);
    int i;
    for (i = 0; i < 5; i++) {
      paramCanvas.save();
      float f3 = (i * 2 + 2);
      float f4 = f1 / 2.0F;
      paramCanvas.translate(f3 * f1 - f4, f2);
      paramCanvas.scale(1.0F, this.a[i]);
      paramCanvas.drawRoundRect(new RectF(-f1 / 2.0F, -d() / 2.5F, f4, d() / 2.5F), 5.0F, 5.0F, paramPaint);
      paramCanvas.restore();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\loadingIndicator\LineScaleIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */