package com.blued.android.framework.view.badgeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;

public class BadgeAnimator extends ValueAnimator {
  private BitmapFragment[][] a;
  
  private WeakReference<QBadgeView> b;
  
  public BadgeAnimator(Bitmap paramBitmap, PointF paramPointF, QBadgeView paramQBadgeView, boolean paramBoolean) {
    this.b = new WeakReference<QBadgeView>(paramQBadgeView);
    setFloatValues(new float[] { 0.0F, 1.0F });
    setDuration(500L);
    this.a = a(paramBitmap, paramPointF);
    addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            QBadgeView qBadgeView = BadgeAnimator.a(this.a).get();
            if (qBadgeView == null || !qBadgeView.isShown()) {
              this.a.cancel();
              return;
            } 
            qBadgeView.invalidate();
          }
        });
    addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramBoolean) {
          public void onAnimationEnd(Animator param1Animator) {
            QBadgeView qBadgeView = BadgeAnimator.a(this.b).get();
            if (qBadgeView != null) {
              qBadgeView.b();
              if (this.a)
                qBadgeView.e(5); 
            } 
          }
        });
  }
  
  private BitmapFragment[][] a(Bitmap paramBitmap, PointF paramPointF) {
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    float f1 = Math.min(j, k) / 6.0F;
    float f2 = paramPointF.x;
    float f3 = paramBitmap.getWidth() / 2.0F;
    float f4 = paramPointF.y;
    float f5 = paramBitmap.getHeight() / 2.0F;
    BitmapFragment[][] arrayOfBitmapFragment = (BitmapFragment[][])Array.newInstance(BitmapFragment.class, new int[] { (int)(k / f1), (int)(j / f1) });
    int i;
    for (i = 0; i < arrayOfBitmapFragment.length; i++) {
      int m;
      for (m = 0; m < (arrayOfBitmapFragment[i]).length; m++) {
        BitmapFragment bitmapFragment = new BitmapFragment(this);
        float f6 = m * f1;
        int n = (int)f6;
        float f7 = i * f1;
        bitmapFragment.e = paramBitmap.getPixel(n, (int)f7);
        bitmapFragment.b = f6 + f2 - f3;
        bitmapFragment.c = f7 + f4 - f5;
        bitmapFragment.d = f1;
        bitmapFragment.f = Math.max(j, k);
        arrayOfBitmapFragment[i][m] = bitmapFragment;
      } 
    } 
    paramBitmap.recycle();
    return arrayOfBitmapFragment;
  }
  
  public void a(Canvas paramCanvas) {
    int i = 0;
    while (i < this.a.length) {
      int j = 0;
      while (true) {
        BitmapFragment[][] arrayOfBitmapFragment = this.a;
        if (j < (arrayOfBitmapFragment[i]).length) {
          arrayOfBitmapFragment[i][j].a(Float.parseFloat(getAnimatedValue().toString()), paramCanvas);
          j++;
          continue;
        } 
        i++;
      } 
    } 
  }
  
  class BitmapFragment {
    Random a;
    
    float b;
    
    float c;
    
    float d;
    
    int e;
    
    int f;
    
    Paint g = new Paint();
    
    public BitmapFragment(BadgeAnimator this$0) {
      this.g.setAntiAlias(true);
      this.g.setStyle(Paint.Style.FILL);
      this.a = new Random();
    }
    
    public void a(float param1Float, Canvas param1Canvas) {
      this.g.setColor(this.e);
      this.b += this.a.nextInt(this.f) * 0.1F * (this.a.nextFloat() - 0.5F);
      this.c += this.a.nextInt(this.f) * 0.1F * (this.a.nextFloat() - 0.5F);
      float f1 = this.b;
      float f2 = this.c;
      float f3 = this.d;
      param1Canvas.drawCircle(f1, f2, f3 - param1Float * f3, this.g);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\badgeview\BadgeAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */