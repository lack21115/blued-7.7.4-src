package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;

public class LinearSnapHelper extends SnapHelper {
  private OrientationHelper b;
  
  private OrientationHelper c;
  
  private int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, OrientationHelper paramOrientationHelper) {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper, int paramInt1, int paramInt2) {
    int[] arrayOfInt = calculateScrollDistance(paramInt1, paramInt2);
    float f = b(paramLayoutManager, paramOrientationHelper);
    if (f <= 0.0F)
      return 0; 
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {
      paramInt1 = arrayOfInt[0];
    } else {
      paramInt1 = arrayOfInt[1];
    } 
    return Math.round(paramInt1 / f);
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
  
  private float b(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper) {
    int m = paramLayoutManager.getChildCount();
    if (m == 0)
      return 1.0F; 
    int k = 0;
    View view1 = null;
    View view2 = null;
    int i = Integer.MAX_VALUE;
    int j;
    for (j = Integer.MIN_VALUE; k < m; j = i1) {
      int i1;
      View view4;
      View view3 = paramLayoutManager.getChildAt(k);
      int n = paramLayoutManager.getPosition(view3);
      if (n == -1) {
        view4 = view1;
        i1 = j;
      } else {
        int i2 = i;
        if (n < i) {
          view1 = view3;
          i2 = n;
        } 
        view4 = view1;
        i = i2;
        i1 = j;
        if (n > j) {
          view2 = view3;
          i1 = n;
          i = i2;
          view4 = view1;
        } 
      } 
      k++;
      view1 = view4;
    } 
    if (view1 != null) {
      if (view2 == null)
        return 1.0F; 
      int n = Math.min(paramOrientationHelper.getDecoratedStart(view1), paramOrientationHelper.getDecoratedStart(view2));
      n = Math.max(paramOrientationHelper.getDecoratedEnd(view1), paramOrientationHelper.getDecoratedEnd(view2)) - n;
      return (n == 0) ? 1.0F : (n * 1.0F / (j - i + 1));
    } 
    return 1.0F;
  }
  
  private OrientationHelper c(RecyclerView.LayoutManager paramLayoutManager) {
    OrientationHelper orientationHelper = this.b;
    if (orientationHelper == null || orientationHelper.a != paramLayoutManager)
      this.b = OrientationHelper.createVerticalHelper(paramLayoutManager); 
    return this.b;
  }
  
  private OrientationHelper d(RecyclerView.LayoutManager paramLayoutManager) {
    OrientationHelper orientationHelper = this.c;
    if (orientationHelper == null || orientationHelper.a != paramLayoutManager)
      this.c = OrientationHelper.createHorizontalHelper(paramLayoutManager); 
    return this.c;
  }
  
  public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager paramLayoutManager, View paramView) {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramLayoutManager, paramView, d(paramLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    } 
    if (paramLayoutManager.canScrollVertically()) {
      arrayOfInt[1] = a(paramLayoutManager, paramView, c(paramLayoutManager));
      return arrayOfInt;
    } 
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager) {
    return paramLayoutManager.canScrollVertically() ? a(paramLayoutManager, c(paramLayoutManager)) : (paramLayoutManager.canScrollHorizontally() ? a(paramLayoutManager, d(paramLayoutManager)) : null);
  }
  
  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2) {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
      return -1; 
    int j = paramLayoutManager.getItemCount();
    if (j == 0)
      return -1; 
    View view = findSnapView(paramLayoutManager);
    if (view == null)
      return -1; 
    int k = paramLayoutManager.getPosition(view);
    if (k == -1)
      return -1; 
    RecyclerView.SmoothScroller.ScrollVectorProvider scrollVectorProvider = (RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager;
    int i = j - 1;
    PointF pointF = scrollVectorProvider.computeScrollVectorForPosition(i);
    if (pointF == null)
      return -1; 
    if (paramLayoutManager.canScrollHorizontally()) {
      int m = a(paramLayoutManager, d(paramLayoutManager), paramInt1, 0);
      paramInt1 = m;
      if (pointF.x < 0.0F)
        paramInt1 = -m; 
    } else {
      paramInt1 = 0;
    } 
    if (paramLayoutManager.canScrollVertically()) {
      int m = a(paramLayoutManager, c(paramLayoutManager), 0, paramInt2);
      paramInt2 = m;
      if (pointF.y < 0.0F)
        paramInt2 = -m; 
    } else {
      paramInt2 = 0;
    } 
    if (paramLayoutManager.canScrollVertically())
      paramInt1 = paramInt2; 
    if (paramInt1 == 0)
      return -1; 
    paramInt2 = k + paramInt1;
    paramInt1 = paramInt2;
    if (paramInt2 < 0)
      paramInt1 = 0; 
    paramInt2 = paramInt1;
    if (paramInt1 >= j)
      paramInt2 = i; 
    return paramInt2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\LinearSnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */