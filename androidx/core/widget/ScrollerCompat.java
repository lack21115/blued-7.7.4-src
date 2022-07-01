package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class ScrollerCompat {
  OverScroller a;
  
  ScrollerCompat(Context paramContext, Interpolator paramInterpolator) {
    OverScroller overScroller;
    if (paramInterpolator != null) {
      overScroller = new OverScroller(paramContext, paramInterpolator);
    } else {
      overScroller = new OverScroller((Context)overScroller);
    } 
    this.a = overScroller;
  }
  
  @Deprecated
  public static ScrollerCompat create(Context paramContext) {
    return create(paramContext, null);
  }
  
  @Deprecated
  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator) {
    return new ScrollerCompat(paramContext, paramInterpolator);
  }
  
  @Deprecated
  public void abortAnimation() {
    this.a.abortAnimation();
  }
  
  @Deprecated
  public boolean computeScrollOffset() {
    return this.a.computeScrollOffset();
  }
  
  @Deprecated
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  @Deprecated
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
    this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  @Deprecated
  public float getCurrVelocity() {
    return this.a.getCurrVelocity();
  }
  
  @Deprecated
  public int getCurrX() {
    return this.a.getCurrX();
  }
  
  @Deprecated
  public int getCurrY() {
    return this.a.getCurrY();
  }
  
  @Deprecated
  public int getFinalX() {
    return this.a.getFinalX();
  }
  
  @Deprecated
  public int getFinalY() {
    return this.a.getFinalY();
  }
  
  @Deprecated
  public boolean isFinished() {
    return this.a.isFinished();
  }
  
  @Deprecated
  public boolean isOverScrolled() {
    return this.a.isOverScrolled();
  }
  
  @Deprecated
  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3) {
    this.a.notifyHorizontalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3) {
    this.a.notifyVerticalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    return this.a.springBack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  @Deprecated
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.a.startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @Deprecated
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    this.a.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\ScrollerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */