package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
  public static final int DEFAULT_SPAN_COUNT = -1;
  
  boolean a = false;
  
  int b = -1;
  
  int[] c;
  
  View[] d;
  
  final SparseIntArray e = new SparseIntArray();
  
  final SparseIntArray f = new SparseIntArray();
  
  SpanSizeLookup g = new DefaultSpanSizeLookup();
  
  final Rect h = new Rect();
  
  private boolean z;
  
  public GridLayoutManager(Context paramContext, int paramInt) {
    super(paramContext);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean) {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount((getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2)).spanCount);
  }
  
  private int a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt) {
    if (!paramState.isPreLayout())
      return this.g.b(paramInt, this.b); 
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. ");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 0;
    } 
    return this.g.b(i, this.b);
  }
  
  private void a(float paramFloat, int paramInt) {
    b(Math.max(Math.round(paramFloat * this.b), paramInt));
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramBoolean = a(paramView, paramInt1, paramInt2, layoutParams);
    } else {
      paramBoolean = b(paramView, paramInt1, paramInt2, layoutParams);
    } 
    if (paramBoolean)
      paramView.measure(paramInt1, paramInt2); 
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect rect = layoutParams.d;
    int j = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
    int i = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
    int k = a(layoutParams.a, layoutParams.b);
    if (this.i == 1) {
      i = getChildMeasureSpec(k, paramInt, i, layoutParams.width, false);
      paramInt = getChildMeasureSpec(this.j.getTotalSpace(), getHeightMode(), j, layoutParams.height, true);
    } else {
      paramInt = getChildMeasureSpec(k, paramInt, j, layoutParams.height, false);
      i = getChildMeasureSpec(this.j.getTotalSpace(), getWidthMode(), i, layoutParams.width, true);
    } 
    a(paramView, i, paramInt, paramBoolean);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt, boolean paramBoolean) {
    byte b;
    int j = 0;
    int i = -1;
    if (paramBoolean) {
      boolean bool = false;
      b = 1;
      i = paramInt;
      paramInt = bool;
    } else {
      paramInt--;
      b = -1;
    } 
    while (paramInt != i) {
      View view = this.d[paramInt];
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      layoutParams.b = c(paramRecycler, paramState, getPosition(view));
      layoutParams.a = j;
      j += layoutParams.b;
      paramInt += b;
    } 
  }
  
  static int[] a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #4
    //   3: aload_0
    //   4: ifnull -> 28
    //   7: aload_0
    //   8: arraylength
    //   9: iload_1
    //   10: iconst_1
    //   11: iadd
    //   12: if_icmpne -> 28
    //   15: aload_0
    //   16: astore #8
    //   18: aload_0
    //   19: aload_0
    //   20: arraylength
    //   21: iconst_1
    //   22: isub
    //   23: iaload
    //   24: iload_2
    //   25: if_icmpeq -> 35
    //   28: iload_1
    //   29: iconst_1
    //   30: iadd
    //   31: newarray int
    //   33: astore #8
    //   35: iconst_0
    //   36: istore #5
    //   38: aload #8
    //   40: iconst_0
    //   41: iconst_0
    //   42: iastore
    //   43: iload_2
    //   44: iload_1
    //   45: idiv
    //   46: istore #6
    //   48: iload_2
    //   49: iload_1
    //   50: irem
    //   51: istore #7
    //   53: iconst_0
    //   54: istore_3
    //   55: iload #5
    //   57: istore_2
    //   58: iload #4
    //   60: iload_1
    //   61: if_icmpgt -> 118
    //   64: iload_2
    //   65: iload #7
    //   67: iadd
    //   68: istore_2
    //   69: iload_2
    //   70: ifle -> 94
    //   73: iload_1
    //   74: iload_2
    //   75: isub
    //   76: iload #7
    //   78: if_icmpge -> 94
    //   81: iload #6
    //   83: iconst_1
    //   84: iadd
    //   85: istore #5
    //   87: iload_2
    //   88: iload_1
    //   89: isub
    //   90: istore_2
    //   91: goto -> 98
    //   94: iload #6
    //   96: istore #5
    //   98: iload_3
    //   99: iload #5
    //   101: iadd
    //   102: istore_3
    //   103: aload #8
    //   105: iload #4
    //   107: iload_3
    //   108: iastore
    //   109: iload #4
    //   111: iconst_1
    //   112: iadd
    //   113: istore #4
    //   115: goto -> 58
    //   118: aload #8
    //   120: areturn
  }
  
  private int b(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt) {
    if (!paramState.isPreLayout())
      return this.g.a(paramInt, this.b); 
    int i = this.f.get(paramInt, -1);
    if (i != -1)
      return i; 
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 0;
    } 
    return this.g.a(i, this.b);
  }
  
  private int b(RecyclerView.State paramState) {
    if (getChildCount() != 0) {
      if (paramState.getItemCount() == 0)
        return 0; 
      b();
      View view1 = a(isSmoothScrollbarEnabled() ^ true, true);
      View view2 = b(isSmoothScrollbarEnabled() ^ true, true);
      if (view1 != null) {
        if (view2 == null)
          return 0; 
        if (!isSmoothScrollbarEnabled())
          return this.g.b(paramState.getItemCount() - 1, this.b) + 1; 
        int i = this.j.getDecoratedEnd(view2);
        int j = this.j.getDecoratedStart(view1);
        int k = this.g.b(getPosition(view1), this.b);
        int m = this.g.b(getPosition(view2), this.b);
        int n = this.g.b(paramState.getItemCount() - 1, this.b);
        return (int)((i - j) / (m - k + 1) * (n + 1));
      } 
    } 
    return 0;
  }
  
  private void b(int paramInt) {
    this.c = a(this.c, this.b, paramInt);
  }
  
  private void b(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt) {
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    int i = b(paramRecycler, paramState, paramAnchorInfo.b);
    if (paramInt != 0) {
      while (i > 0 && paramAnchorInfo.b > 0) {
        paramAnchorInfo.b--;
        i = b(paramRecycler, paramState, paramAnchorInfo.b);
      } 
    } else {
      int j = paramState.getItemCount();
      paramInt = paramAnchorInfo.b;
      while (paramInt < j - 1) {
        int m = paramInt + 1;
        int k = b(paramRecycler, paramState, m);
        if (k > i) {
          paramInt = m;
          i = k;
        } 
      } 
      paramAnchorInfo.b = paramInt;
    } 
  }
  
  private int c(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt) {
    if (!paramState.isPreLayout())
      return this.g.getSpanSize(paramInt); 
    int i = this.e.get(paramInt, -1);
    if (i != -1)
      return i; 
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 1;
    } 
    return this.g.getSpanSize(i);
  }
  
  private int c(RecyclerView.State paramState) {
    if (getChildCount() != 0) {
      if (paramState.getItemCount() == 0)
        return 0; 
      b();
      boolean bool = isSmoothScrollbarEnabled();
      View view1 = a(bool ^ true, true);
      View view2 = b(bool ^ true, true);
      if (view1 != null) {
        if (view2 == null)
          return 0; 
        int j = this.g.b(getPosition(view1), this.b);
        int k = this.g.b(getPosition(view2), this.b);
        int i = Math.min(j, k);
        j = Math.max(j, k);
        k = this.g.b(paramState.getItemCount() - 1, this.b);
        if (this.k) {
          i = Math.max(0, k + 1 - j - 1);
        } else {
          i = Math.max(0, i);
        } 
        if (!bool)
          return i; 
        j = Math.abs(this.j.getDecoratedEnd(view2) - this.j.getDecoratedStart(view1));
        k = this.g.b(getPosition(view1), this.b);
        int m = this.g.b(getPosition(view2), this.b);
        float f = j / (m - k + 1);
        return Math.round(i * f + (this.j.getStartAfterPadding() - this.j.getDecoratedStart(view1)));
      } 
    } 
    return 0;
  }
  
  private void h() {
    this.e.clear();
    this.f.clear();
  }
  
  private void i() {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      LayoutParams layoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      int k = layoutParams.getViewLayoutPosition();
      this.e.put(k, layoutParams.getSpanSize());
      this.f.put(k, layoutParams.getSpanIndex());
    } 
  }
  
  private void j() {
    int i;
    int j;
    if (getOrientation() == 1) {
      i = getWidth() - getPaddingRight();
      j = getPaddingLeft();
    } else {
      i = getHeight() - getPaddingBottom();
      j = getPaddingTop();
    } 
    b(i - j);
  }
  
  private void k() {
    View[] arrayOfView = this.d;
    if (arrayOfView == null || arrayOfView.length != this.b)
      this.d = new View[this.b]; 
  }
  
  int a(int paramInt1, int paramInt2) {
    if (this.i == 1 && a()) {
      int[] arrayOfInt1 = this.c;
      int i = this.b;
      return arrayOfInt1[i - paramInt1] - arrayOfInt1[i - paramInt1 - paramInt2];
    } 
    int[] arrayOfInt = this.c;
    return arrayOfInt[paramInt2 + paramInt1] - arrayOfInt[paramInt1];
  }
  
  View a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3) {
    byte b;
    b();
    int i = this.j.getStartAfterPadding();
    int j = this.j.getEndAfterPadding();
    if (paramInt2 > paramInt1) {
      b = 1;
    } else {
      b = -1;
    } 
    View view2 = null;
    View view1;
    for (view1 = null; paramInt1 != paramInt2; view1 = view4) {
      View view5 = getChildAt(paramInt1);
      int k = getPosition(view5);
      View view3 = view2;
      View view4 = view1;
      if (k >= 0) {
        view3 = view2;
        view4 = view1;
        if (k < paramInt3)
          if (b(paramRecycler, paramState, k) != 0) {
            view3 = view2;
            view4 = view1;
          } else if (((RecyclerView.LayoutParams)view5.getLayoutParams()).isItemRemoved()) {
            view3 = view2;
            view4 = view1;
            if (view1 == null) {
              view4 = view5;
              view3 = view2;
            } 
          } else if (this.j.getDecoratedStart(view5) >= j || this.j.getDecoratedEnd(view5) < i) {
            view3 = view2;
            view4 = view1;
            if (view2 == null) {
              view3 = view5;
              view4 = view1;
            } 
          } else {
            return view5;
          }  
      } 
      paramInt1 += b;
      view2 = view3;
    } 
    return (view2 != null) ? view2 : view1;
  }
  
  void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt) {
    super.a(paramRecycler, paramState, paramAnchorInfo, paramInt);
    j();
    if (paramState.getItemCount() > 0 && !paramState.isPreLayout())
      b(paramRecycler, paramState, paramAnchorInfo, paramInt); 
    k();
  }
  
  void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult) {
    StringBuilder stringBuilder;
    int k;
    int m;
    boolean bool;
    int i2 = this.j.getModeInOther();
    if (i2 != 1073741824) {
      k = 1;
    } else {
      k = 0;
    } 
    if (getChildCount() > 0) {
      m = this.c[this.b];
    } else {
      m = 0;
    } 
    if (k)
      j(); 
    if (paramLayoutState.e == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.b;
    if (!bool)
      i = b(paramRecycler, paramState, paramLayoutState.d) + c(paramRecycler, paramState, paramLayoutState.d); 
    int n = 0;
    while (n < this.b && paramLayoutState.a(paramState) && i > 0) {
      int i3 = paramLayoutState.d;
      int i4 = c(paramRecycler, paramState, i3);
      if (i4 <= this.b) {
        i -= i4;
        if (i < 0)
          break; 
        View view = paramLayoutState.a(paramRecycler);
        if (view == null)
          break; 
        this.d[n] = view;
        n++;
        continue;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Item at position ");
      stringBuilder.append(i3);
      stringBuilder.append(" requires ");
      stringBuilder.append(i4);
      stringBuilder.append(" spans but GridLayoutManager has only ");
      stringBuilder.append(this.b);
      stringBuilder.append(" spans.");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    if (n == 0) {
      paramLayoutChunkResult.mFinished = true;
      return;
    } 
    float f = 0.0F;
    a((RecyclerView.Recycler)stringBuilder, paramState, n, bool);
    int j = 0;
    i = 0;
    while (j < n) {
      View view = this.d[j];
      if (paramLayoutState.l == null) {
        if (bool) {
          addView(view);
        } else {
          addView(view, 0);
        } 
      } else if (bool) {
        addDisappearingView(view);
      } else {
        addDisappearingView(view, 0);
      } 
      calculateItemDecorationsForChild(view, this.h);
      a(view, i2, false);
      int i4 = this.j.getDecoratedMeasurement(view);
      int i3 = i;
      if (i4 > i)
        i3 = i4; 
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      float f2 = this.j.getDecoratedMeasurementInOther(view) * 1.0F / layoutParams.b;
      float f1 = f;
      if (f2 > f)
        f1 = f2; 
      j++;
      i = i3;
      f = f1;
    } 
    j = i;
    if (k) {
      a(f, m);
      k = 0;
      i = 0;
      while (true) {
        j = i;
        if (k < n) {
          View view = this.d[k];
          a(view, 1073741824, true);
          m = this.j.getDecoratedMeasurement(view);
          j = i;
          if (m > i)
            j = m; 
          k++;
          i = j;
          continue;
        } 
        break;
      } 
    } 
    for (i = 0; i < n; i++) {
      View view = this.d[i];
      if (this.j.getDecoratedMeasurement(view) != j) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        Rect rect = layoutParams.d;
        m = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        k = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int i3 = a(layoutParams.a, layoutParams.b);
        if (this.i == 1) {
          k = getChildMeasureSpec(i3, 1073741824, k, layoutParams.width, false);
          m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);
        } else {
          k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
          m = getChildMeasureSpec(i3, 1073741824, m, layoutParams.height, false);
        } 
        a(view, k, m, true);
      } 
    } 
    int i1 = 0;
    paramLayoutChunkResult.mConsumed = j;
    if (this.i == 1) {
      if (paramLayoutState.f == -1) {
        i = paramLayoutState.b;
        k = i - j;
        j = i;
        i = k;
      } else {
        i = paramLayoutState.b;
        j = i + j;
      } 
      k = 0;
      m = 0;
    } else if (paramLayoutState.f == -1) {
      m = paramLayoutState.b;
      k = m - j;
      i = 0;
      j = 0;
    } else {
      k = paramLayoutState.b;
      i = 0;
      boolean bool1 = false;
      m = k + j;
      j = bool1;
    } 
    while (i1 < n) {
      View view = this.d[i1];
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (this.i == 1) {
        if (a()) {
          i2 = getPaddingLeft() + this.c[this.b - layoutParams.a];
          int i5 = this.j.getDecoratedMeasurementInOther(view);
          k = i2;
          int i4 = i;
          m = j;
          i = i2 - i5;
          j = i4;
        } else {
          i2 = getPaddingLeft() + this.c[layoutParams.a];
          int i5 = this.j.getDecoratedMeasurementInOther(view);
          k = i2;
          int i4 = i;
          m = j;
          i2 = i5 + i2;
          i = k;
          j = i4;
          k = i2;
        } 
      } else {
        int i4 = getPaddingTop() + this.c[layoutParams.a];
        i2 = this.j.getDecoratedMeasurementInOther(view);
        i = k;
        j = i4;
        i4 = i2 + i4;
        k = m;
        m = i4;
      } 
      layoutDecoratedWithMargins(view, i, j, k, m);
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        paramLayoutChunkResult.mIgnoreConsumed = true; 
      paramLayoutChunkResult.mFocusable |= view.hasFocusable();
      int i3 = i1 + 1;
      i1 = k;
      k = i;
      i = j;
      j = m;
      m = i1;
      i1 = i3;
    } 
    Arrays.fill((Object[])this.d, (Object)null);
  }
  
  void a(RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {
    int j = this.b;
    int i;
    for (i = 0; i < this.b && paramLayoutState.a(paramState) && j > 0; i++) {
      int k = paramLayoutState.d;
      paramLayoutPrefetchRegistry.addPosition(k, Math.max(0, paramLayoutState.g));
      j -= this.g.getSpanSize(k);
      paramLayoutState.d += paramLayoutState.e;
    } 
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState) {
    return this.z ? c(paramState) : super.computeHorizontalScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState) {
    return this.z ? b(paramState) : super.computeHorizontalScrollRange(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState) {
    return this.z ? c(paramState) : super.computeVerticalScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState) {
    return this.z ? b(paramState) : super.computeVerticalScrollRange(paramState);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams() {
    return (this.i == 0) ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.i == 1) ? this.b : ((paramState.getItemCount() < 1) ? 0 : (a(paramRecycler, paramState, paramState.getItemCount() - 1) + 1));
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.i == 0) ? this.b : ((paramState.getItemCount() < 1) ? 0 : (a(paramRecycler, paramState, paramState.getItemCount() - 1) + 1));
  }
  
  public int getSpanCount() {
    return this.b;
  }
  
  public SpanSizeLookup getSpanSizeLookup() {
    return this.g;
  }
  
  public boolean isUsingSpansToEstimateScrollbarDimensions() {
    return this.z;
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual findContainingItemView : (Landroid/view/View;)Landroid/view/View;
    //   5: astore #22
    //   7: aconst_null
    //   8: astore #23
    //   10: aload #22
    //   12: ifnonnull -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload #22
    //   19: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   22: checkcast androidx/recyclerview/widget/GridLayoutManager$LayoutParams
    //   25: astore #24
    //   27: aload #24
    //   29: getfield a : I
    //   32: istore #15
    //   34: aload #24
    //   36: getfield a : I
    //   39: aload #24
    //   41: getfield b : I
    //   44: iadd
    //   45: istore #16
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload_3
    //   51: aload #4
    //   53: invokespecial onFocusSearchFailed : (Landroid/view/View;ILandroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)Landroid/view/View;
    //   56: ifnonnull -> 61
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: iload_2
    //   63: invokevirtual a : (I)I
    //   66: iconst_1
    //   67: if_icmpne -> 76
    //   70: iconst_1
    //   71: istore #21
    //   73: goto -> 79
    //   76: iconst_0
    //   77: istore #21
    //   79: iload #21
    //   81: aload_0
    //   82: getfield k : Z
    //   85: if_icmpeq -> 93
    //   88: iconst_1
    //   89: istore_2
    //   90: goto -> 95
    //   93: iconst_0
    //   94: istore_2
    //   95: iload_2
    //   96: ifeq -> 116
    //   99: aload_0
    //   100: invokevirtual getChildCount : ()I
    //   103: iconst_1
    //   104: isub
    //   105: istore #7
    //   107: iconst_m1
    //   108: istore #6
    //   110: iconst_m1
    //   111: istore #8
    //   113: goto -> 128
    //   116: aload_0
    //   117: invokevirtual getChildCount : ()I
    //   120: istore #6
    //   122: iconst_0
    //   123: istore #7
    //   125: iconst_1
    //   126: istore #8
    //   128: aload_0
    //   129: getfield i : I
    //   132: iconst_1
    //   133: if_icmpne -> 149
    //   136: aload_0
    //   137: invokevirtual a : ()Z
    //   140: ifeq -> 149
    //   143: iconst_1
    //   144: istore #9
    //   146: goto -> 152
    //   149: iconst_0
    //   150: istore #9
    //   152: aload_0
    //   153: aload_3
    //   154: aload #4
    //   156: iload #7
    //   158: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;I)I
    //   161: istore #17
    //   163: aconst_null
    //   164: astore_1
    //   165: iconst_m1
    //   166: istore #11
    //   168: iconst_0
    //   169: istore #12
    //   171: iconst_0
    //   172: istore_2
    //   173: iconst_m1
    //   174: istore #5
    //   176: iload #6
    //   178: istore #10
    //   180: iload #11
    //   182: istore #6
    //   184: iload #7
    //   186: istore #11
    //   188: iload #11
    //   190: iload #10
    //   192: if_icmpeq -> 581
    //   195: aload_0
    //   196: aload_3
    //   197: aload #4
    //   199: iload #11
    //   201: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;I)I
    //   204: istore #7
    //   206: aload_0
    //   207: iload #11
    //   209: invokevirtual getChildAt : (I)Landroid/view/View;
    //   212: astore #24
    //   214: aload #24
    //   216: aload #22
    //   218: if_acmpne -> 224
    //   221: goto -> 581
    //   224: aload #24
    //   226: invokevirtual hasFocusable : ()Z
    //   229: ifeq -> 250
    //   232: iload #7
    //   234: iload #17
    //   236: if_icmpeq -> 250
    //   239: aload #23
    //   241: ifnull -> 247
    //   244: goto -> 581
    //   247: goto -> 571
    //   250: aload #24
    //   252: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   255: checkcast androidx/recyclerview/widget/GridLayoutManager$LayoutParams
    //   258: astore #25
    //   260: aload #25
    //   262: getfield a : I
    //   265: istore #18
    //   267: aload #25
    //   269: getfield a : I
    //   272: aload #25
    //   274: getfield b : I
    //   277: iadd
    //   278: istore #19
    //   280: aload #24
    //   282: invokevirtual hasFocusable : ()Z
    //   285: ifeq -> 305
    //   288: iload #18
    //   290: iload #15
    //   292: if_icmpne -> 305
    //   295: iload #19
    //   297: iload #16
    //   299: if_icmpne -> 305
    //   302: aload #24
    //   304: areturn
    //   305: aload #24
    //   307: invokevirtual hasFocusable : ()Z
    //   310: ifeq -> 318
    //   313: aload #23
    //   315: ifnull -> 330
    //   318: aload #24
    //   320: invokevirtual hasFocusable : ()Z
    //   323: ifne -> 336
    //   326: aload_1
    //   327: ifnonnull -> 336
    //   330: iconst_1
    //   331: istore #7
    //   333: goto -> 484
    //   336: iload #18
    //   338: iload #15
    //   340: invokestatic max : (II)I
    //   343: istore #7
    //   345: iload #19
    //   347: iload #16
    //   349: invokestatic min : (II)I
    //   352: iload #7
    //   354: isub
    //   355: istore #20
    //   357: aload #24
    //   359: invokevirtual hasFocusable : ()Z
    //   362: ifeq -> 408
    //   365: iload #20
    //   367: iload #12
    //   369: if_icmple -> 375
    //   372: goto -> 330
    //   375: iload #20
    //   377: iload #12
    //   379: if_icmpne -> 481
    //   382: iload #18
    //   384: iload #6
    //   386: if_icmple -> 395
    //   389: iconst_1
    //   390: istore #7
    //   392: goto -> 398
    //   395: iconst_0
    //   396: istore #7
    //   398: iload #9
    //   400: iload #7
    //   402: if_icmpne -> 481
    //   405: goto -> 330
    //   408: aload #23
    //   410: ifnonnull -> 481
    //   413: iconst_1
    //   414: istore #14
    //   416: iconst_1
    //   417: istore #7
    //   419: aload_0
    //   420: aload #24
    //   422: iconst_0
    //   423: iconst_1
    //   424: invokevirtual isViewPartiallyVisible : (Landroid/view/View;ZZ)Z
    //   427: istore #21
    //   429: iload_2
    //   430: istore #13
    //   432: iload #21
    //   434: ifeq -> 481
    //   437: iload #20
    //   439: iload #13
    //   441: if_icmple -> 451
    //   444: iload #14
    //   446: istore #7
    //   448: goto -> 484
    //   451: iload #20
    //   453: iload #13
    //   455: if_icmpne -> 481
    //   458: iload #18
    //   460: iload #5
    //   462: if_icmple -> 468
    //   465: goto -> 471
    //   468: iconst_0
    //   469: istore #7
    //   471: iload #9
    //   473: iload #7
    //   475: if_icmpne -> 481
    //   478: goto -> 330
    //   481: iconst_0
    //   482: istore #7
    //   484: iload #7
    //   486: ifeq -> 571
    //   489: aload #24
    //   491: invokevirtual hasFocusable : ()Z
    //   494: ifeq -> 536
    //   497: aload #25
    //   499: getfield a : I
    //   502: istore #6
    //   504: iload #19
    //   506: iload #16
    //   508: invokestatic min : (II)I
    //   511: istore #7
    //   513: iload #18
    //   515: iload #15
    //   517: invokestatic max : (II)I
    //   520: istore #12
    //   522: iload #7
    //   524: iload #12
    //   526: isub
    //   527: istore #12
    //   529: aload #24
    //   531: astore #23
    //   533: goto -> 571
    //   536: aload #25
    //   538: getfield a : I
    //   541: istore #5
    //   543: iload #19
    //   545: iload #16
    //   547: invokestatic min : (II)I
    //   550: istore_2
    //   551: iload #18
    //   553: iload #15
    //   555: invokestatic max : (II)I
    //   558: istore #7
    //   560: aload #24
    //   562: astore_1
    //   563: iload_2
    //   564: iload #7
    //   566: isub
    //   567: istore_2
    //   568: goto -> 571
    //   571: iload #11
    //   573: iload #8
    //   575: iadd
    //   576: istore #11
    //   578: goto -> 188
    //   581: aload #23
    //   583: ifnull -> 589
    //   586: aload #23
    //   588: areturn
    //   589: aload_1
    //   590: areturn
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
    if (!(layoutParams1 instanceof LayoutParams)) {
      a(paramView, paramAccessibilityNodeInfoCompat);
      return;
    } 
    LayoutParams layoutParams = (LayoutParams)layoutParams1;
    int i = a(paramRecycler, paramState, layoutParams.getViewLayoutPosition());
    if (this.i == 0) {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams.getSpanIndex(), layoutParams.getSpanSize(), i, 1, false, false));
      return;
    } 
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, layoutParams.getSpanIndex(), layoutParams.getSpanSize(), false, false));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    this.g.invalidateSpanIndexCache();
    this.g.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView) {
    this.g.invalidateSpanIndexCache();
    this.g.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {
    this.g.invalidateSpanIndexCache();
    this.g.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    this.g.invalidateSpanIndexCache();
    this.g.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject) {
    this.g.invalidateSpanIndexCache();
    this.g.invalidateSpanGroupIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    if (paramState.isPreLayout())
      i(); 
    super.onLayoutChildren(paramRecycler, paramState);
    h();
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState) {
    super.onLayoutCompleted(paramState);
    this.a = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    j();
    k();
    return super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    j();
    k();
    return super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2) {
    int[] arrayOfInt;
    if (this.c == null)
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2); 
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.i == 1) {
      paramInt2 = chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      arrayOfInt = this.c;
      i = chooseSize(paramInt1, arrayOfInt[arrayOfInt.length - 1] + i, getMinimumWidth());
      paramInt1 = paramInt2;
      paramInt2 = i;
    } else {
      paramInt1 = chooseSize(paramInt1, arrayOfInt.width() + i, getMinimumWidth());
      arrayOfInt = this.c;
      i = chooseSize(paramInt2, arrayOfInt[arrayOfInt.length - 1] + j, getMinimumHeight());
      paramInt2 = paramInt1;
      paramInt1 = i;
    } 
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setSpanCount(int paramInt) {
    if (paramInt == this.b)
      return; 
    this.a = true;
    if (paramInt >= 1) {
      this.b = paramInt;
      this.g.invalidateSpanIndexCache();
      requestLayout();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Span count should be at least 1. Provided ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setSpanSizeLookup(SpanSizeLookup paramSpanSizeLookup) {
    this.g = paramSpanSizeLookup;
  }
  
  public void setStackFromEnd(boolean paramBoolean) {
    if (!paramBoolean) {
      super.setStackFromEnd(false);
      return;
    } 
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public void setUsingSpansToEstimateScrollbarDimensions(boolean paramBoolean) {
    this.z = paramBoolean;
  }
  
  public boolean supportsPredictiveItemAnimations() {
    return (this.n == null && !this.a);
  }
  
  public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
    public int getSpanIndex(int param1Int1, int param1Int2) {
      return param1Int1 % param1Int2;
    }
    
    public int getSpanSize(int param1Int) {
      return 1;
    }
  }
  
  public static class LayoutParams extends RecyclerView.LayoutParams {
    public static final int INVALID_SPAN_ID = -1;
    
    int a = -1;
    
    int b = 0;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
    
    public LayoutParams(RecyclerView.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public int getSpanIndex() {
      return this.a;
    }
    
    public int getSpanSize() {
      return this.b;
    }
  }
  
  public static abstract class SpanSizeLookup {
    final SparseIntArray a = new SparseIntArray();
    
    final SparseIntArray b = new SparseIntArray();
    
    private boolean c = false;
    
    private boolean d = false;
    
    static int a(SparseIntArray param1SparseIntArray, int param1Int) {
      int j = param1SparseIntArray.size() - 1;
      int i = 0;
      while (i <= j) {
        int k = i + j >>> 1;
        if (param1SparseIntArray.keyAt(k) < param1Int) {
          i = k + 1;
          continue;
        } 
        j = k - 1;
      } 
      param1Int = i - 1;
      return (param1Int >= 0 && param1Int < param1SparseIntArray.size()) ? param1SparseIntArray.keyAt(param1Int) : -1;
    }
    
    int a(int param1Int1, int param1Int2) {
      if (!this.c)
        return getSpanIndex(param1Int1, param1Int2); 
      int i = this.a.get(param1Int1, -1);
      if (i != -1)
        return i; 
      param1Int2 = getSpanIndex(param1Int1, param1Int2);
      this.a.put(param1Int1, param1Int2);
      return param1Int2;
    }
    
    int b(int param1Int1, int param1Int2) {
      if (!this.d)
        return getSpanGroupIndex(param1Int1, param1Int2); 
      int i = this.b.get(param1Int1, -1);
      if (i != -1)
        return i; 
      param1Int2 = getSpanGroupIndex(param1Int1, param1Int2);
      this.b.put(param1Int1, param1Int2);
      return param1Int2;
    }
    
    public int getSpanGroupIndex(int param1Int1, int param1Int2) {
      // Byte code:
      //   0: aload_0
      //   1: getfield d : Z
      //   4: ifeq -> 86
      //   7: aload_0
      //   8: getfield b : Landroid/util/SparseIntArray;
      //   11: iload_1
      //   12: invokestatic a : (Landroid/util/SparseIntArray;I)I
      //   15: istore_3
      //   16: iload_3
      //   17: iconst_m1
      //   18: if_icmpeq -> 86
      //   21: aload_0
      //   22: getfield b : Landroid/util/SparseIntArray;
      //   25: iload_3
      //   26: invokevirtual get : (I)I
      //   29: istore #7
      //   31: iload_3
      //   32: iconst_1
      //   33: iadd
      //   34: istore #6
      //   36: aload_0
      //   37: iload_3
      //   38: iload_2
      //   39: invokevirtual a : (II)I
      //   42: istore #4
      //   44: aload_0
      //   45: iload_3
      //   46: invokevirtual getSpanSize : (I)I
      //   49: iload #4
      //   51: iadd
      //   52: istore #8
      //   54: iload #8
      //   56: istore_3
      //   57: iload #7
      //   59: istore #4
      //   61: iload #6
      //   63: istore #5
      //   65: iload #8
      //   67: iload_2
      //   68: if_icmpne -> 94
      //   71: iload #7
      //   73: iconst_1
      //   74: iadd
      //   75: istore #4
      //   77: iconst_0
      //   78: istore_3
      //   79: iload #6
      //   81: istore #5
      //   83: goto -> 94
      //   86: iconst_0
      //   87: istore_3
      //   88: iconst_0
      //   89: istore #4
      //   91: iconst_0
      //   92: istore #5
      //   94: aload_0
      //   95: iload_1
      //   96: invokevirtual getSpanSize : (I)I
      //   99: istore #9
      //   101: iload #5
      //   103: istore #6
      //   105: iload #6
      //   107: iload_1
      //   108: if_icmpge -> 177
      //   111: aload_0
      //   112: iload #6
      //   114: invokevirtual getSpanSize : (I)I
      //   117: istore #7
      //   119: iload_3
      //   120: iload #7
      //   122: iadd
      //   123: istore #8
      //   125: iload #8
      //   127: iload_2
      //   128: if_icmpne -> 142
      //   131: iload #4
      //   133: iconst_1
      //   134: iadd
      //   135: istore #5
      //   137: iconst_0
      //   138: istore_3
      //   139: goto -> 164
      //   142: iload #8
      //   144: istore_3
      //   145: iload #4
      //   147: istore #5
      //   149: iload #8
      //   151: iload_2
      //   152: if_icmple -> 164
      //   155: iload #4
      //   157: iconst_1
      //   158: iadd
      //   159: istore #5
      //   161: iload #7
      //   163: istore_3
      //   164: iload #6
      //   166: iconst_1
      //   167: iadd
      //   168: istore #6
      //   170: iload #5
      //   172: istore #4
      //   174: goto -> 105
      //   177: iload #4
      //   179: istore_1
      //   180: iload_3
      //   181: iload #9
      //   183: iadd
      //   184: iload_2
      //   185: if_icmple -> 193
      //   188: iload #4
      //   190: iconst_1
      //   191: iadd
      //   192: istore_1
      //   193: iload_1
      //   194: ireturn
    }
    
    public int getSpanIndex(int param1Int1, int param1Int2) {
      // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: invokevirtual getSpanSize : (I)I
      //   5: istore #8
      //   7: iload #8
      //   9: iload_2
      //   10: if_icmpne -> 15
      //   13: iconst_0
      //   14: ireturn
      //   15: aload_0
      //   16: getfield c : Z
      //   19: ifeq -> 57
      //   22: aload_0
      //   23: getfield a : Landroid/util/SparseIntArray;
      //   26: iload_1
      //   27: invokestatic a : (Landroid/util/SparseIntArray;I)I
      //   30: istore #5
      //   32: iload #5
      //   34: iflt -> 57
      //   37: aload_0
      //   38: getfield a : Landroid/util/SparseIntArray;
      //   41: iload #5
      //   43: invokevirtual get : (I)I
      //   46: aload_0
      //   47: iload #5
      //   49: invokevirtual getSpanSize : (I)I
      //   52: iadd
      //   53: istore_3
      //   54: goto -> 117
      //   57: iconst_0
      //   58: istore #4
      //   60: iconst_0
      //   61: istore_3
      //   62: iload #4
      //   64: iload_1
      //   65: if_icmpge -> 126
      //   68: aload_0
      //   69: iload #4
      //   71: invokevirtual getSpanSize : (I)I
      //   74: istore #6
      //   76: iload_3
      //   77: iload #6
      //   79: iadd
      //   80: istore #7
      //   82: iload #7
      //   84: iload_2
      //   85: if_icmpne -> 97
      //   88: iconst_0
      //   89: istore_3
      //   90: iload #4
      //   92: istore #5
      //   94: goto -> 117
      //   97: iload #4
      //   99: istore #5
      //   101: iload #7
      //   103: istore_3
      //   104: iload #7
      //   106: iload_2
      //   107: if_icmple -> 117
      //   110: iload #6
      //   112: istore_3
      //   113: iload #4
      //   115: istore #5
      //   117: iload #5
      //   119: iconst_1
      //   120: iadd
      //   121: istore #4
      //   123: goto -> 62
      //   126: iload #8
      //   128: iload_3
      //   129: iadd
      //   130: iload_2
      //   131: if_icmpgt -> 136
      //   134: iload_3
      //   135: ireturn
      //   136: iconst_0
      //   137: ireturn
    }
    
    public abstract int getSpanSize(int param1Int);
    
    public void invalidateSpanGroupIndexCache() {
      this.b.clear();
    }
    
    public void invalidateSpanIndexCache() {
      this.a.clear();
    }
    
    public boolean isSpanGroupIndexCacheEnabled() {
      return this.d;
    }
    
    public boolean isSpanIndexCacheEnabled() {
      return this.c;
    }
    
    public void setSpanGroupIndexCacheEnabled(boolean param1Boolean) {
      if (!param1Boolean)
        this.b.clear(); 
      this.d = param1Boolean;
    }
    
    public void setSpanIndexCacheEnabled(boolean param1Boolean) {
      if (!param1Boolean)
        this.b.clear(); 
      this.c = param1Boolean;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\GridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */