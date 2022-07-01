package com.soft.blued.customview.loadingIndicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.List;

public class LineScalePulseOutIndicator extends LineScaleIndicator {
  public List<Animator> a() {
    ArrayList<ValueAnimator> arrayList = new ArrayList();
    for (int i = 0; i < 5; i++) {
      ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F, 1.0F });
      valueAnimator.setDuration(900L);
      valueAnimator.setRepeatCount(-1);
      (new long[5])[0] = 500L;
      (new long[5])[1] = 250L;
      (new long[5])[2] = 0L;
      (new long[5])[3] = 250L;
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\loadingIndicator\LineScalePulseOutIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */