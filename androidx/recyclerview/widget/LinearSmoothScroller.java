package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class LinearSmoothScroller extends RecyclerView.SmoothScroller {
  public static final int SNAP_TO_ANY = 0;
  
  public static final int SNAP_TO_END = 1;
  
  public static final int SNAP_TO_START = -1;
  
  protected final LinearInterpolator a = new LinearInterpolator();
  
  protected final DecelerateInterpolator b = new DecelerateInterpolator();
  
  protected PointF c;
  
  protected int d = 0;
  
  protected int e = 0;
  
  private final DisplayMetrics f;
  
  private boolean g = false;
  
  private float h;
  
  public LinearSmoothScroller(Context paramContext) {
    this.f = paramContext.getResources().getDisplayMetrics();
  }
  
  private int b(int paramInt1, int paramInt2) {
    paramInt2 = paramInt1 - paramInt2;
    return (paramInt1 * paramInt2 <= 0) ? 0 : paramInt2;
  }
  
  private float f() {
    if (!this.g) {
      this.h = a(this.f);
      this.g = true;
    } 
    return this.h;
  }
  
  protected float a(DisplayMetrics paramDisplayMetrics) {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int a(int paramInt) {
    return (int)Math.ceil(b(paramInt) / 0.3356D);
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction) {
    if (getChildCount() == 0) {
      e();
      return;
    } 
    this.d = b(this.d, paramInt1);
    this.e = b(this.e, paramInt2);
    if (this.d == 0 && this.e == 0)
      a(paramAction); 
  }
  
  protected void a(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction) {
    int i = calculateDxToMakeVisible(paramView, c());
    int j = calculateDyToMakeVisible(paramView, d());
    int k = a((int)Math.sqrt((i * i + j * j)));
    if (k > 0)
      paramAction.update(-i, -j, k, (Interpolator)this.b); 
  }
  
  protected void a(RecyclerView.SmoothScroller.Action paramAction) {
    PointF pointF = computeScrollVectorForPosition(getTargetPosition());
    if (pointF == null || (pointF.x == 0.0F && pointF.y == 0.0F)) {
      paramAction.jumpTo(getTargetPosition());
      e();
      return;
    } 
    a(pointF);
    this.c = pointF;
    this.d = (int)(pointF.x * 10000.0F);
    this.e = (int)(pointF.y * 10000.0F);
    int i = b(10000);
    paramAction.update((int)(this.d * 1.2F), (int)(this.e * 1.2F), (int)(i * 1.2F), (Interpolator)this.a);
  }
  
  protected int b(int paramInt) {
    return (int)Math.ceil((Math.abs(paramInt) * f()));
  }
  
  protected void b() {
    this.e = 0;
    this.d = 0;
    this.c = null;
  }
  
  protected int c() {
    PointF pointF = this.c;
    return (pointF == null || pointF.x == 0.0F) ? 0 : ((this.c.x > 0.0F) ? 1 : -1);
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramInt5 != -1) {
      if (paramInt5 != 0) {
        if (paramInt5 == 1)
          return paramInt4 - paramInt2; 
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
      } 
      paramInt1 = paramInt3 - paramInt1;
      if (paramInt1 > 0)
        return paramInt1; 
      paramInt1 = paramInt4 - paramInt2;
      return (paramInt1 < 0) ? paramInt1 : 0;
    } 
    return paramInt3 - paramInt1;
  }
  
  public int calculateDxToMakeVisible(View paramView, int paramInt) {
    RecyclerView.LayoutManager layoutManager = getLayoutManager();
    if (layoutManager == null || !layoutManager.canScrollHorizontally())
      return 0; 
    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return calculateDtToFit(layoutManager.getDecoratedLeft(paramView) - layoutParams.leftMargin, layoutManager.getDecoratedRight(paramView) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), paramInt);
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt) {
    RecyclerView.LayoutManager layoutManager = getLayoutManager();
    if (layoutManager == null || !layoutManager.canScrollVertically())
      return 0; 
    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return calculateDtToFit(layoutManager.getDecoratedTop(paramView) - layoutParams.topMargin, layoutManager.getDecoratedBottom(paramView) + layoutParams.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), paramInt);
  }
  
  protected int d() {
    PointF pointF = this.c;
    return (pointF == null || pointF.y == 0.0F) ? 0 : ((this.c.y > 0.0F) ? 1 : -1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\LinearSmoothScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */