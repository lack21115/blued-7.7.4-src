package com.blued.android.module.live_china.same.loadingIndicator;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class BaseIndicatorController {
  private WeakReference<View> a;
  
  private List<Animator> b;
  
  public abstract List<Animator> a();
  
  public abstract void a(Canvas paramCanvas, Paint paramPaint);
  
  public void a(View paramView) {
    this.a = new WeakReference<View>(paramView);
  }
  
  public void a(AnimStatus paramAnimStatus) {
    List<Animator> list = this.b;
    if (list == null)
      return; 
    int j = list.size();
    for (int i = 0; i < j; i++) {
      Animator animator = this.b.get(i);
      boolean bool = animator.isRunning();
      int k = null.a[paramAnimStatus.ordinal()];
      if (k != 1) {
        if (k != 2) {
          if (k == 3 && bool)
            animator.cancel(); 
        } else if (bool) {
          animator.end();
        } 
      } else if (!bool) {
        animator.start();
      } 
    } 
  }
  
  public View b() {
    WeakReference<View> weakReference = this.a;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public int c() {
    return (b() != null) ? b().getWidth() : 0;
  }
  
  public int d() {
    return (b() != null) ? b().getHeight() : 0;
  }
  
  public void e() {
    if (b() != null)
      b().postInvalidate(); 
  }
  
  public void f() {
    this.b = a();
  }
  
  public enum AnimStatus {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\same\loadingIndicator\BaseIndicatorController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */