package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;

public class PagerSnapHelper extends SnapHelper {
  private OrientationHelper b;
  
  private OrientationHelper c;
  
  private int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, OrientationHelper paramOrientationHelper) {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
  }
  
  private View a(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper) {
    int k = paramLayoutManager.getChildCount();
    View view = null;
    if (k == 0)
      return null; 
    int m = paramOrientationHelper.getStartAfterPadding();
    int n = paramOrientationHelper.getTotalSpace() / 2;
    int j = Integer.MAX_VALUE;
    int i = 0;
    while (i < k) {
      View view1 = paramLayoutManager.getChildAt(i);
      int i2 = Math.abs(paramOrientationHelper.getDecoratedStart(view1) + paramOrientationHelper.getDecoratedMeasurement(view1) / 2 - m + n);
      int i1 = j;
      if (i2 < j) {
        view = view1;
        i1 = i2;
      } 
      i++;
      j = i1;
    } 
    return view;
  }
  
  private boolean a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2) {
    return paramLayoutManager.canScrollHorizontally() ? ((paramInt1 > 0)) : ((paramInt2 > 0));
  }
  
  private boolean c(RecyclerView.LayoutManager paramLayoutManager) {
    int i = paramLayoutManager.getItemCount();
    if (paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
      RecyclerView.SmoothScroller.ScrollVectorProvider scrollVectorProvider = (RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager;
      boolean bool = true;
      PointF pointF = scrollVectorProvider.computeScrollVectorForPosition(i - 1);
      if (pointF != null) {
        if (pointF.x >= 0.0F) {
          if (pointF.y < 0.0F)
            return true; 
          bool = false;
        } 
        return bool;
      } 
    } 
    return false;
  }
  
  private OrientationHelper d(RecyclerView.LayoutManager paramLayoutManager) {
    return paramLayoutManager.canScrollVertically() ? e(paramLayoutManager) : (paramLayoutManager.canScrollHorizontally() ? f(paramLayoutManager) : null);
  }
  
  private OrientationHelper e(RecyclerView.LayoutManager paramLayoutManager) {
    OrientationHelper orientationHelper = this.b;
    if (orientationHelper == null || orientationHelper.a != paramLayoutManager)
      this.b = OrientationHelper.createVerticalHelper(paramLayoutManager); 
    return this.b;
  }
  
  private OrientationHelper f(RecyclerView.LayoutManager paramLayoutManager) {
    OrientationHelper orientationHelper = this.c;
    if (orientationHelper == null || orientationHelper.a != paramLayoutManager)
      this.c = OrientationHelper.createHorizontalHelper(paramLayoutManager); 
    return this.c;
  }
  
  protected LinearSmoothScroller a(RecyclerView.LayoutManager paramLayoutManager) {
    return !(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) ? null : new LinearSmoothScroller(this, this.a.getContext()) {
        protected float a(DisplayMetrics param1DisplayMetrics) {
          return 100.0F / param1DisplayMetrics.densityDpi;
        }
        
        protected void a(View param1View, RecyclerView.State param1State, RecyclerView.SmoothScroller.Action param1Action) {
          PagerSnapHelper pagerSnapHelper = this.f;
          int[] arrayOfInt = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.a.getLayoutManager(), param1View);
          int i = arrayOfInt[0];
          int j = arrayOfInt[1];
          int k = a(Math.max(Math.abs(i), Math.abs(j)));
          if (k > 0)
            param1Action.update(i, j, k, (Interpolator)this.b); 
        }
        
        protected int b(int param1Int) {
          return Math.min(100, super.b(param1Int));
        }
      };
  }
  
  public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager paramLayoutManager, View paramView) {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramLayoutManager, paramView, f(paramLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    } 
    if (paramLayoutManager.canScrollVertically()) {
      arrayOfInt[1] = a(paramLayoutManager, paramView, e(paramLayoutManager));
      return arrayOfInt;
    } 
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager) {
    return paramLayoutManager.canScrollVertically() ? a(paramLayoutManager, e(paramLayoutManager)) : (paramLayoutManager.canScrollHorizontally() ? a(paramLayoutManager, f(paramLayoutManager)) : null);
  }
  
  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2) {
    int m = paramLayoutManager.getItemCount();
    if (m == 0)
      return -1; 
    OrientationHelper orientationHelper = d(paramLayoutManager);
    if (orientationHelper == null)
      return -1; 
    int n = paramLayoutManager.getChildCount();
    int j = 0;
    View view2 = null;
    View view1 = null;
    int i = Integer.MIN_VALUE;
    int k;
    for (k = Integer.MAX_VALUE; j < n; k = i1) {
      int i1;
      View view4;
      View view3 = paramLayoutManager.getChildAt(j);
      if (view3 == null) {
        view4 = view2;
        i1 = k;
      } else {
        int i3 = a(paramLayoutManager, view3, orientationHelper);
        View view = view1;
        int i2 = i;
        if (i3 <= 0) {
          view = view1;
          i2 = i;
          if (i3 > i) {
            view = view3;
            i2 = i3;
          } 
        } 
        view1 = view;
        i = i2;
        view4 = view2;
        i1 = k;
        if (i3 >= 0) {
          view1 = view;
          i = i2;
          view4 = view2;
          i1 = k;
          if (i3 < k) {
            i1 = i3;
            view4 = view3;
            i = i2;
            view1 = view;
          } 
        } 
      } 
      j++;
      view2 = view4;
    } 
    boolean bool = a(paramLayoutManager, paramInt1, paramInt2);
    if (bool && view2 != null)
      return paramLayoutManager.getPosition(view2); 
    if (!bool && view1 != null)
      return paramLayoutManager.getPosition(view1); 
    if (!bool)
      view1 = view2; 
    if (view1 == null)
      return -1; 
    paramInt2 = paramLayoutManager.getPosition(view1);
    if (c(paramLayoutManager) == bool) {
      paramInt1 = -1;
    } else {
      paramInt1 = 1;
    } 
    paramInt1 = paramInt2 + paramInt1;
    return (paramInt1 >= 0) ? ((paramInt1 >= m) ? -1 : paramInt1) : -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\PagerSnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */