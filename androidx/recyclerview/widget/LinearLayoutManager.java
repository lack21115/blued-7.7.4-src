package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
  public static final int HORIZONTAL = 0;
  
  public static final int INVALID_OFFSET = -2147483648;
  
  public static final int VERTICAL = 1;
  
  private LayoutState a;
  
  private boolean b;
  
  private boolean c = false;
  
  private boolean d = false;
  
  private boolean e = true;
  
  private boolean f;
  
  private final LayoutChunkResult g = new LayoutChunkResult();
  
  private int h = 2;
  
  int i = 1;
  
  OrientationHelper j;
  
  boolean k = false;
  
  int l = -1;
  
  int m = Integer.MIN_VALUE;
  
  SavedState n = null;
  
  final AnchorInfo o = new AnchorInfo();
  
  private int[] z = new int[2];
  
  public LinearLayoutManager(Context paramContext) {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean) {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    RecyclerView.LayoutManager.Properties properties = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(properties.orientation);
    setReverseLayout(properties.reverseLayout);
    setStackFromEnd(properties.stackFromEnd);
  }
  
  private int a(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    int i = this.j.getEndAfterPadding() - paramInt;
    if (i > 0) {
      i = -a(-i, paramRecycler, paramState);
      if (paramBoolean) {
        paramInt = this.j.getEndAfterPadding() - paramInt + i;
        if (paramInt > 0) {
          this.j.offsetChildren(paramInt);
          return paramInt + i;
        } 
      } 
      return i;
    } 
    return 0;
  }
  
  private View a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return this.k ? c(paramRecycler, paramState) : d(paramRecycler, paramState);
  }
  
  private void a(int paramInt1, int paramInt2) {
    boolean bool;
    this.a.c = this.j.getEndAfterPadding() - paramInt2;
    LayoutState layoutState = this.a;
    if (this.k) {
      bool = true;
    } else {
      bool = true;
    } 
    layoutState.e = bool;
    layoutState = this.a;
    layoutState.d = paramInt1;
    layoutState.f = 1;
    layoutState.b = paramInt2;
    layoutState.g = Integer.MIN_VALUE;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState) {
    this.a.m = d();
    this.a.f = paramInt1;
    int[] arrayOfInt = this.z;
    boolean bool = false;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    a(paramState, arrayOfInt);
    int i = Math.max(0, this.z[0]);
    int j = Math.max(0, this.z[1]);
    if (paramInt1 == 1)
      bool = true; 
    LayoutState layoutState = this.a;
    if (bool) {
      paramInt1 = j;
    } else {
      paramInt1 = i;
    } 
    layoutState.h = paramInt1;
    layoutState = this.a;
    if (!bool)
      i = j; 
    layoutState.i = i;
    paramInt1 = -1;
    if (bool) {
      layoutState = this.a;
      layoutState.h += this.j.getEndPadding();
      View view = j();
      LayoutState layoutState1 = this.a;
      if (!this.k)
        paramInt1 = 1; 
      layoutState1.e = paramInt1;
      this.a.d = getPosition(view) + this.a.e;
      this.a.b = this.j.getDecoratedEnd(view);
      paramInt1 = this.j.getDecoratedEnd(view) - this.j.getEndAfterPadding();
    } else {
      View view = i();
      LayoutState layoutState1 = this.a;
      layoutState1.h += this.j.getStartAfterPadding();
      layoutState1 = this.a;
      if (this.k)
        paramInt1 = 1; 
      layoutState1.e = paramInt1;
      this.a.d = getPosition(view) + this.a.e;
      this.a.b = this.j.getDecoratedStart(view);
      paramInt1 = -this.j.getDecoratedStart(view) + this.j.getStartAfterPadding();
    } 
    layoutState = this.a;
    layoutState.c = paramInt2;
    if (paramBoolean)
      layoutState.c -= paramInt1; 
    this.a.g = paramInt1;
  }
  
  private void a(AnchorInfo paramAnchorInfo) {
    a(paramAnchorInfo.b, paramAnchorInfo.c);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2) {
    if (paramInt1 == paramInt2)
      return; 
    int i = paramInt1;
    if (paramInt2 > paramInt1) {
      while (--paramInt2 >= paramInt1) {
        removeAndRecycleViewAt(paramInt2, paramRecycler);
        paramInt2--;
      } 
    } else {
      while (i > paramInt2) {
        removeAndRecycleViewAt(i, paramRecycler);
        i--;
      } 
    } 
  }
  
  private void a(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState) {
    if (paramLayoutState.a) {
      if (paramLayoutState.m)
        return; 
      int i = paramLayoutState.g;
      int j = paramLayoutState.i;
      if (paramLayoutState.f == -1) {
        c(paramRecycler, i, j);
        return;
      } 
      b(paramRecycler, i, j);
    } 
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2) {
    if (paramState.willRunPredictiveAnimations() && getChildCount() != 0 && !paramState.isPreLayout()) {
      if (!supportsPredictiveItemAnimations())
        return; 
      List<RecyclerView.ViewHolder> list = paramRecycler.getScrapList();
      int m = list.size();
      int n = getPosition(getChildAt(0));
      int i = 0;
      int k = 0;
      int j = 0;
      while (i < m) {
        RecyclerView.ViewHolder viewHolder = list.get(i);
        if (!viewHolder.m()) {
          boolean bool;
          int i1 = viewHolder.getLayoutPosition();
          byte b = 1;
          if (i1 < n) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool != this.k)
            b = -1; 
          if (b == -1) {
            k += this.j.getDecoratedMeasurement(viewHolder.itemView);
          } else {
            j += this.j.getDecoratedMeasurement(viewHolder.itemView);
          } 
        } 
        i++;
      } 
      this.a.l = list;
      if (k > 0) {
        e(getPosition(i()), paramInt1);
        LayoutState layoutState = this.a;
        layoutState.h = k;
        layoutState.c = 0;
        layoutState.assignPositionFromScrapList();
        a(paramRecycler, this.a, paramState, false);
      } 
      if (j > 0) {
        a(getPosition(j()), paramInt2);
        LayoutState layoutState = this.a;
        layoutState.h = j;
        layoutState.c = 0;
        layoutState.assignPositionFromScrapList();
        a(paramRecycler, this.a, paramState, false);
      } 
      this.a.l = null;
    } 
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    boolean bool;
    if (a(paramState, paramAnchorInfo))
      return; 
    if (b(paramRecycler, paramState, paramAnchorInfo))
      return; 
    paramAnchorInfo.b();
    if (this.d) {
      bool = paramState.getItemCount() - 1;
    } else {
      bool = false;
    } 
    paramAnchorInfo.b = bool;
  }
  
  private boolean a(RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    boolean bool = paramState.isPreLayout();
    boolean bool1 = false;
    if (!bool) {
      int i = this.l;
      if (i == -1)
        return false; 
      if (i < 0 || i >= paramState.getItemCount()) {
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        return false;
      } 
      paramAnchorInfo.b = this.l;
      SavedState savedState = this.n;
      if (savedState != null && savedState.a()) {
        paramAnchorInfo.d = this.n.c;
        if (paramAnchorInfo.d) {
          paramAnchorInfo.c = this.j.getEndAfterPadding() - this.n.b;
          return true;
        } 
        paramAnchorInfo.c = this.j.getStartAfterPadding() + this.n.b;
        return true;
      } 
      if (this.m == Integer.MIN_VALUE) {
        View view = findViewByPosition(this.l);
        if (view != null) {
          if (this.j.getDecoratedMeasurement(view) > this.j.getTotalSpace()) {
            paramAnchorInfo.b();
            return true;
          } 
          if (this.j.getDecoratedStart(view) - this.j.getStartAfterPadding() < 0) {
            paramAnchorInfo.c = this.j.getStartAfterPadding();
            paramAnchorInfo.d = false;
            return true;
          } 
          if (this.j.getEndAfterPadding() - this.j.getDecoratedEnd(view) < 0) {
            paramAnchorInfo.c = this.j.getEndAfterPadding();
            paramAnchorInfo.d = true;
            return true;
          } 
          if (paramAnchorInfo.d) {
            i = this.j.getDecoratedEnd(view) + this.j.getTotalSpaceChange();
          } else {
            i = this.j.getDecoratedStart(view);
          } 
          paramAnchorInfo.c = i;
          return true;
        } 
        if (getChildCount() > 0) {
          i = getPosition(getChildAt(0));
          if (this.l < i) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool == this.k)
            bool1 = true; 
          paramAnchorInfo.d = bool1;
        } 
        paramAnchorInfo.b();
        return true;
      } 
      bool = this.k;
      paramAnchorInfo.d = bool;
      if (bool) {
        paramAnchorInfo.c = this.j.getEndAfterPadding() - this.m;
        return true;
      } 
      paramAnchorInfo.c = this.j.getStartAfterPadding() + this.m;
      return true;
    } 
    return false;
  }
  
  private int b(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    int i = paramInt - this.j.getStartAfterPadding();
    if (i > 0) {
      int j = -a(i, paramRecycler, paramState);
      i = j;
      if (paramBoolean) {
        paramInt = paramInt + j - this.j.getStartAfterPadding();
        i = j;
        if (paramInt > 0) {
          this.j.offsetChildren(-paramInt);
          i = j - paramInt;
        } 
      } 
      return i;
    } 
    return 0;
  }
  
  private int b(RecyclerView.State paramState) {
    if (getChildCount() == 0)
      return 0; 
    b();
    return ScrollbarHelper.a(paramState, this.j, a(this.e ^ true, true), b(this.e ^ true, true), this, this.e, this.k);
  }
  
  private View b(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return this.k ? d(paramRecycler, paramState) : c(paramRecycler, paramState);
  }
  
  private void b(AnchorInfo paramAnchorInfo) {
    e(paramAnchorInfo.b, paramAnchorInfo.c);
  }
  
  private void b(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2) {
    if (paramInt1 < 0)
      return; 
    int i = paramInt1 - paramInt2;
    paramInt2 = getChildCount();
    if (this.k) {
      for (paramInt1 = --paramInt2; paramInt1 >= 0; paramInt1--) {
        View view = getChildAt(paramInt1);
        if (this.j.getDecoratedEnd(view) > i || this.j.getTransformedEndWithDecoration(view) > i) {
          a(paramRecycler, paramInt2, paramInt1);
          return;
        } 
      } 
    } else {
      for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
        View view = getChildAt(paramInt1);
        if (this.j.getDecoratedEnd(view) > i || this.j.getTransformedEndWithDecoration(view) > i) {
          a(paramRecycler, 0, paramInt1);
          break;
        } 
      } 
    } 
  }
  
  private boolean b(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    View view1;
    int j = getChildCount();
    int i = 0;
    if (j == 0)
      return false; 
    View view2 = getFocusedChild();
    if (view2 != null && paramAnchorInfo.a(view2, paramState)) {
      paramAnchorInfo.assignFromViewAndKeepVisibleRect(view2, getPosition(view2));
      return true;
    } 
    if (this.b != this.d)
      return false; 
    if (paramAnchorInfo.d) {
      view1 = a(paramRecycler, paramState);
    } else {
      view1 = b((RecyclerView.Recycler)view1, paramState);
    } 
    if (view1 != null) {
      paramAnchorInfo.assignFromView(view1, getPosition(view1));
      if (!paramState.isPreLayout() && supportsPredictiveItemAnimations()) {
        if (this.j.getDecoratedStart(view1) >= this.j.getEndAfterPadding() || this.j.getDecoratedEnd(view1) < this.j.getStartAfterPadding())
          i = 1; 
        if (i) {
          if (paramAnchorInfo.d) {
            i = this.j.getEndAfterPadding();
          } else {
            i = this.j.getStartAfterPadding();
          } 
          paramAnchorInfo.c = i;
        } 
      } 
      return true;
    } 
    return false;
  }
  
  private int c(RecyclerView.State paramState) {
    if (getChildCount() == 0)
      return 0; 
    b();
    return ScrollbarHelper.a(paramState, this.j, a(this.e ^ true, true), b(this.e ^ true, true), this, this.e);
  }
  
  private View c(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return a(paramRecycler, paramState, 0, getChildCount(), paramState.getItemCount());
  }
  
  private void c(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2) {
    int j = getChildCount();
    if (paramInt1 < 0)
      return; 
    int i = this.j.getEnd() - paramInt1 + paramInt2;
    if (this.k) {
      for (paramInt1 = 0; paramInt1 < j; paramInt1++) {
        View view = getChildAt(paramInt1);
        if (this.j.getDecoratedStart(view) < i || this.j.getTransformedStartWithDecoration(view) < i) {
          a(paramRecycler, 0, paramInt1);
          return;
        } 
      } 
    } else {
      paramInt2 = j - 1;
      for (paramInt1 = paramInt2; paramInt1 >= 0; paramInt1--) {
        View view = getChildAt(paramInt1);
        if (this.j.getDecoratedStart(view) < i || this.j.getTransformedStartWithDecoration(view) < i) {
          a(paramRecycler, paramInt2, paramInt1);
          break;
        } 
      } 
    } 
  }
  
  private int d(RecyclerView.State paramState) {
    if (getChildCount() == 0)
      return 0; 
    b();
    return ScrollbarHelper.b(paramState, this.j, a(this.e ^ true, true), b(this.e ^ true, true), this, this.e);
  }
  
  private View d(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return a(paramRecycler, paramState, getChildCount() - 1, -1, paramState.getItemCount());
  }
  
  private void e(int paramInt1, int paramInt2) {
    this.a.c = paramInt2 - this.j.getStartAfterPadding();
    LayoutState layoutState = this.a;
    layoutState.d = paramInt1;
    if (this.k) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    } 
    layoutState.e = paramInt1;
    layoutState = this.a;
    layoutState.f = -1;
    layoutState.b = paramInt2;
    layoutState.g = Integer.MIN_VALUE;
  }
  
  private void h() {
    if (this.i == 1 || !a()) {
      this.k = this.c;
      return;
    } 
    this.k = this.c ^ true;
  }
  
  private View i() {
    boolean bool;
    if (this.k) {
      bool = getChildCount() - 1;
    } else {
      bool = false;
    } 
    return getChildAt(bool);
  }
  
  private View j() {
    int i;
    if (this.k) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    } 
    return getChildAt(i);
  }
  
  private View k() {
    return this.k ? m() : n();
  }
  
  private View l() {
    return this.k ? n() : m();
  }
  
  private View m() {
    return b(0, getChildCount());
  }
  
  private View n() {
    return b(getChildCount() - 1, -1);
  }
  
  int a(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 17) ? ((paramInt != 33) ? ((paramInt != 66) ? ((paramInt != 130) ? Integer.MIN_VALUE : ((this.i == 1) ? 1 : Integer.MIN_VALUE)) : ((this.i == 0) ? 1 : Integer.MIN_VALUE)) : ((this.i == 1) ? -1 : Integer.MIN_VALUE)) : ((this.i == 0) ? -1 : Integer.MIN_VALUE)) : ((this.i == 1) ? 1 : (a() ? -1 : 1))) : ((this.i == 1) ? -1 : (a() ? 1 : -1));
  }
  
  int a(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    if (getChildCount() != 0) {
      byte b;
      if (paramInt == 0)
        return 0; 
      b();
      this.a.a = true;
      if (paramInt > 0) {
        b = 1;
      } else {
        b = -1;
      } 
      int i = Math.abs(paramInt);
      a(b, i, true, paramState);
      int j = this.a.g + a(paramRecycler, this.a, paramState, false);
      if (j < 0)
        return 0; 
      if (i > j)
        paramInt = b * j; 
      this.j.offsetChildren(-paramInt);
      this.a.k = paramInt;
      return paramInt;
    } 
    return 0;
  }
  
  int a(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState, boolean paramBoolean) {
    int j = paramLayoutState.c;
    if (paramLayoutState.g != Integer.MIN_VALUE) {
      if (paramLayoutState.c < 0)
        paramLayoutState.g += paramLayoutState.c; 
      a(paramRecycler, paramLayoutState);
    } 
    int i = paramLayoutState.c + paramLayoutState.h;
    LayoutChunkResult layoutChunkResult = this.g;
    while (true) {
      while (true)
        break; 
      if (paramBoolean) {
        Object object = SYNTHETIC_LOCAL_VARIABLE_6;
        if (layoutChunkResult.mFocusable)
          break; 
      } 
    } 
    return j - paramLayoutState.c;
  }
  
  @Deprecated
  protected int a(RecyclerView.State paramState) {
    return paramState.hasTargetScrollPosition() ? this.j.getTotalSpace() : 0;
  }
  
  View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    char c1;
    b();
    char c2 = 'ŀ';
    if (paramBoolean1) {
      c1 = '怃';
    } else {
      c1 = 'ŀ';
    } 
    if (!paramBoolean2)
      c2 = Character.MIN_VALUE; 
    return (this.i == 0) ? this.r.a(paramInt1, paramInt2, c1, c2) : this.s.a(paramInt1, paramInt2, c1, c2);
  }
  
  View a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3) {
    View view;
    byte b;
    b();
    int i = this.j.getStartAfterPadding();
    int j = this.j.getEndAfterPadding();
    if (paramInt2 > paramInt1) {
      b = 1;
    } else {
      b = -1;
    } 
    paramState = null;
    for (paramRecycler = null; paramInt1 != paramInt2; paramRecycler = recycler) {
      View view1;
      View view2 = getChildAt(paramInt1);
      int k = getPosition(view2);
      RecyclerView.State state = paramState;
      RecyclerView.Recycler recycler = paramRecycler;
      if (k >= 0) {
        state = paramState;
        recycler = paramRecycler;
        if (k < paramInt3)
          if (((RecyclerView.LayoutParams)view2.getLayoutParams()).isItemRemoved()) {
            state = paramState;
            recycler = paramRecycler;
            if (paramRecycler == null) {
              View view3 = view2;
              state = paramState;
            } 
          } else if (this.j.getDecoratedStart(view2) >= j || this.j.getDecoratedEnd(view2) < i) {
            state = paramState;
            recycler = paramRecycler;
            if (paramState == null) {
              view1 = view2;
              recycler = paramRecycler;
            } 
          } else {
            return view2;
          }  
      } 
      paramInt1 += b;
      view = view1;
    } 
    return (View)((view != null) ? view : paramRecycler);
  }
  
  View a(boolean paramBoolean1, boolean paramBoolean2) {
    return this.k ? a(getChildCount() - 1, -1, paramBoolean1, paramBoolean2) : a(0, getChildCount(), paramBoolean1, paramBoolean2);
  }
  
  void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo, int paramInt) {}
  
  void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LayoutState paramLayoutState, LayoutChunkResult paramLayoutChunkResult) {
    int i;
    int j;
    int k;
    int m;
    View view = paramLayoutState.a(paramRecycler);
    if (view == null) {
      paramLayoutChunkResult.mFinished = true;
      return;
    } 
    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
    if (paramLayoutState.l == null) {
      boolean bool1;
      boolean bool2 = this.k;
      if (paramLayoutState.f == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool2 == bool1) {
        addView(view);
      } else {
        addView(view, 0);
      } 
    } else {
      boolean bool1;
      boolean bool2 = this.k;
      if (paramLayoutState.f == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool2 == bool1) {
        addDisappearingView(view);
      } else {
        addDisappearingView(view, 0);
      } 
    } 
    measureChildWithMargins(view, 0, 0);
    paramLayoutChunkResult.mConsumed = this.j.getDecoratedMeasurement(view);
    if (this.i == 1) {
      if (a()) {
        i = getWidth() - getPaddingRight();
        m = i - this.j.getDecoratedMeasurementInOther(view);
      } else {
        m = getPaddingLeft();
        i = this.j.getDecoratedMeasurementInOther(view) + m;
      } 
      if (paramLayoutState.f == -1) {
        k = paramLayoutState.b;
        int n = paramLayoutState.b - paramLayoutChunkResult.mConsumed;
        j = i;
        i = n;
      } else {
        int n = paramLayoutState.b;
        k = paramLayoutState.b + paramLayoutChunkResult.mConsumed;
        j = i;
        i = n;
      } 
    } else {
      j = getPaddingTop();
      i = this.j.getDecoratedMeasurementInOther(view) + j;
      if (paramLayoutState.f == -1) {
        k = paramLayoutState.b;
        m = paramLayoutState.b;
        int i1 = paramLayoutChunkResult.mConsumed;
        int n = i;
        m -= i1;
        i = j;
        j = k;
        k = n;
      } else {
        int n = paramLayoutState.b;
        int i1 = paramLayoutState.b + paramLayoutChunkResult.mConsumed;
        m = j;
        k = i;
        j = i1;
        i = m;
        m = n;
      } 
    } 
    layoutDecoratedWithMargins(view, m, i, j, k);
    if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
      paramLayoutChunkResult.mIgnoreConsumed = true; 
    paramLayoutChunkResult.mFocusable = view.hasFocusable();
  }
  
  void a(RecyclerView.State paramState, LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {
    int i = paramLayoutState.d;
    if (i >= 0 && i < paramState.getItemCount())
      paramLayoutPrefetchRegistry.addPosition(i, Math.max(0, paramLayoutState.g)); 
  }
  
  public void a(RecyclerView.State paramState, int[] paramArrayOfint) {
    int j;
    boolean bool;
    int i = a(paramState);
    if (this.a.f == -1) {
      j = 0;
      bool = i;
    } else {
      bool = false;
      j = i;
    } 
    paramArrayOfint[0] = bool;
    paramArrayOfint[1] = j;
  }
  
  protected boolean a() {
    return (getLayoutDirection() == 1);
  }
  
  public void assertNotInLayoutOrScroll(String paramString) {
    if (this.n == null)
      super.assertNotInLayoutOrScroll(paramString); 
  }
  
  View b(int paramInt1, int paramInt2) {
    char c1;
    char c2;
    b();
    if (paramInt2 > paramInt1) {
      c1 = '\001';
    } else if (paramInt2 < paramInt1) {
      c1 = '￿';
    } else {
      c1 = Character.MIN_VALUE;
    } 
    if (!c1)
      return getChildAt(paramInt1); 
    if (this.j.getDecoratedStart(getChildAt(paramInt1)) < this.j.getStartAfterPadding()) {
      c1 = '䄄';
      c2 = '䀄';
    } else {
      c1 = '၁';
      c2 = 'ခ';
    } 
    return (this.i == 0) ? this.r.a(paramInt1, paramInt2, c1, c2) : this.s.a(paramInt1, paramInt2, c1, c2);
  }
  
  View b(boolean paramBoolean1, boolean paramBoolean2) {
    return this.k ? a(0, getChildCount(), paramBoolean1, paramBoolean2) : a(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  void b() {
    if (this.a == null)
      this.a = c(); 
  }
  
  LayoutState c() {
    return new LayoutState();
  }
  
  public boolean canScrollHorizontally() {
    return (this.i == 0);
  }
  
  public boolean canScrollVertically() {
    return (this.i == 1);
  }
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {
    if (this.i != 0)
      paramInt1 = paramInt2; 
    if (getChildCount() != 0) {
      if (paramInt1 == 0)
        return; 
      b();
      if (paramInt1 > 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = -1;
      } 
      a(paramInt2, Math.abs(paramInt1), true, paramState);
      a(paramState, this.a, paramLayoutPrefetchRegistry);
    } 
  }
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {
    boolean bool1;
    SavedState savedState = this.n;
    byte b = -1;
    if (savedState != null && savedState.a()) {
      bool1 = this.n.c;
      i = this.n.a;
    } else {
      h();
      boolean bool2 = this.k;
      int k = this.l;
      bool1 = bool2;
      i = k;
      if (k == -1)
        if (bool2) {
          i = paramInt - 1;
          bool1 = bool2;
        } else {
          i = 0;
          bool1 = bool2;
        }  
    } 
    if (!bool1)
      b = 1; 
    boolean bool = false;
    int j = i;
    for (int i = bool; i < this.h && j >= 0 && j < paramInt; i++) {
      paramLayoutPrefetchRegistry.addPosition(j, 0);
      j += b;
    } 
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState) {
    return c(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState) {
    return b(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState) {
    return d(paramState);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt) {
    if (getChildCount() == 0)
      return null; 
    boolean bool1 = false;
    int i = getPosition(getChildAt(0));
    boolean bool = true;
    if (paramInt < i)
      bool1 = true; 
    paramInt = bool;
    if (bool1 != this.k)
      paramInt = -1; 
    return (this.i == 0) ? new PointF(paramInt, 0.0F) : new PointF(0.0F, paramInt);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState) {
    return c(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState) {
    return b(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState) {
    return d(paramState);
  }
  
  boolean d() {
    return (this.j.getMode() == 0 && this.j.getEnd() == 0);
  }
  
  boolean e() {
    return (getHeightMode() != 1073741824 && getWidthMode() != 1073741824 && g());
  }
  
  public int findFirstCompletelyVisibleItemPosition() {
    View view = a(0, getChildCount(), true, false);
    return (view == null) ? -1 : getPosition(view);
  }
  
  public int findFirstVisibleItemPosition() {
    View view = a(0, getChildCount(), false, true);
    return (view == null) ? -1 : getPosition(view);
  }
  
  public int findLastCompletelyVisibleItemPosition() {
    View view = a(getChildCount() - 1, -1, true, false);
    return (view == null) ? -1 : getPosition(view);
  }
  
  public int findLastVisibleItemPosition() {
    View view = a(getChildCount() - 1, -1, false, true);
    return (view == null) ? -1 : getPosition(view);
  }
  
  public View findViewByPosition(int paramInt) {
    int i = getChildCount();
    if (i == 0)
      return null; 
    int j = paramInt - getPosition(getChildAt(0));
    if (j >= 0 && j < i) {
      View view = getChildAt(j);
      if (getPosition(view) == paramInt)
        return view; 
    } 
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams() {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public int getInitialPrefetchItemCount() {
    return this.h;
  }
  
  public int getOrientation() {
    return this.i;
  }
  
  public boolean getRecycleChildrenOnDetach() {
    return this.f;
  }
  
  public boolean getReverseLayout() {
    return this.c;
  }
  
  public boolean getStackFromEnd() {
    return this.d;
  }
  
  public boolean isAutoMeasureEnabled() {
    return true;
  }
  
  public boolean isSmoothScrollbarEnabled() {
    return this.e;
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler) {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.f) {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    } 
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    View view1;
    View view2;
    h();
    if (getChildCount() == 0)
      return null; 
    paramInt = a(paramInt);
    if (paramInt == Integer.MIN_VALUE)
      return null; 
    b();
    a(paramInt, (int)(this.j.getTotalSpace() * 0.33333334F), false, paramState);
    LayoutState layoutState = this.a;
    layoutState.g = Integer.MIN_VALUE;
    layoutState.a = false;
    a(paramRecycler, layoutState, paramState, true);
    if (paramInt == -1) {
      view1 = l();
    } else {
      view1 = k();
    } 
    if (paramInt == -1) {
      view2 = i();
    } else {
      view2 = j();
    } 
    return view2.hasFocusable() ? ((view1 == null) ? null : view2) : view1;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0) {
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    } 
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    AnchorInfo anchorInfo;
    SavedState savedState = this.n;
    int k = -1;
    if ((savedState != null || this.l != -1) && paramState.getItemCount() == 0) {
      removeAndRecycleAllViews(paramRecycler);
      return;
    } 
    savedState = this.n;
    if (savedState != null && savedState.a())
      this.l = this.n.a; 
    b();
    this.a.a = false;
    h();
    View view = getFocusedChild();
    if (!this.o.e || this.l != -1 || this.n != null) {
      this.o.a();
      anchorInfo = this.o;
      anchorInfo.d = this.k ^ this.d;
      a(paramRecycler, paramState, anchorInfo);
      this.o.e = true;
    } else if (anchorInfo != null && (this.j.getDecoratedStart((View)anchorInfo) >= this.j.getEndAfterPadding() || this.j.getDecoratedEnd((View)anchorInfo) <= this.j.getStartAfterPadding())) {
      this.o.assignFromViewAndKeepVisibleRect((View)anchorInfo, getPosition((View)anchorInfo));
    } 
    LayoutState layoutState = this.a;
    if (layoutState.k >= 0) {
      i = 1;
    } else {
      i = -1;
    } 
    layoutState.f = i;
    int[] arrayOfInt = this.z;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    a(paramState, arrayOfInt);
    int m = Math.max(0, this.z[0]) + this.j.getStartAfterPadding();
    int n = Math.max(0, this.z[1]) + this.j.getEndPadding();
    int i = m;
    int j = n;
    if (paramState.isPreLayout()) {
      int i1 = this.l;
      i = m;
      j = n;
      if (i1 != -1) {
        i = m;
        j = n;
        if (this.m != Integer.MIN_VALUE) {
          View view1 = findViewByPosition(i1);
          i = m;
          j = n;
          if (view1 != null) {
            if (this.k) {
              j = this.j.getEndAfterPadding() - this.j.getDecoratedEnd(view1);
              i = this.m;
            } else {
              i = this.j.getDecoratedStart(view1) - this.j.getStartAfterPadding();
              j = this.m;
            } 
            i = j - i;
            if (i > 0) {
              i = m + i;
              j = n;
            } else {
              j = n - i;
              i = m;
            } 
          } 
        } 
      } 
    } 
    if (this.o.d ? this.k : !this.k)
      k = 1; 
    a(paramRecycler, paramState, this.o, k);
    detachAndScrapAttachedViews(paramRecycler);
    this.a.m = d();
    this.a.j = paramState.isPreLayout();
    this.a.i = 0;
    if (this.o.d) {
      b(this.o);
      LayoutState layoutState1 = this.a;
      layoutState1.h = i;
      a(paramRecycler, layoutState1, paramState, false);
      k = this.a.b;
      n = this.a.d;
      i = j;
      if (this.a.c > 0)
        i = j + this.a.c; 
      a(this.o);
      layoutState1 = this.a;
      layoutState1.h = i;
      layoutState1.d += this.a.e;
      a(paramRecycler, this.a, paramState, false);
      m = this.a.b;
      j = k;
      i = m;
      if (this.a.c > 0) {
        i = this.a.c;
        e(n, k);
        layoutState1 = this.a;
        layoutState1.h = i;
        a(paramRecycler, layoutState1, paramState, false);
        j = this.a.b;
        i = m;
      } 
    } else {
      a(this.o);
      LayoutState layoutState1 = this.a;
      layoutState1.h = j;
      a(paramRecycler, layoutState1, paramState, false);
      k = this.a.b;
      n = this.a.d;
      j = i;
      if (this.a.c > 0)
        j = i + this.a.c; 
      b(this.o);
      layoutState1 = this.a;
      layoutState1.h = j;
      layoutState1.d += this.a.e;
      a(paramRecycler, this.a, paramState, false);
      m = this.a.b;
      j = m;
      i = k;
      if (this.a.c > 0) {
        i = this.a.c;
        a(n, k);
        layoutState1 = this.a;
        layoutState1.h = i;
        a(paramRecycler, layoutState1, paramState, false);
        i = this.a.b;
        j = m;
      } 
    } 
    m = j;
    k = i;
    if (getChildCount() > 0) {
      if ((this.k ^ this.d) != 0) {
        m = a(i, paramRecycler, paramState, true);
        k = j + m;
        j = i + m;
        i = b(k, paramRecycler, paramState, false);
      } else {
        m = b(j, paramRecycler, paramState, true);
        k = j + m;
        j = i + m;
        i = a(j, paramRecycler, paramState, false);
      } 
      m = k + i;
      k = j + i;
    } 
    a(paramRecycler, paramState, m, k);
    if (!paramState.isPreLayout()) {
      this.j.onLayoutComplete();
    } else {
      this.o.a();
    } 
    this.b = this.d;
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState) {
    super.onLayoutCompleted(paramState);
    this.n = null;
    this.l = -1;
    this.m = Integer.MIN_VALUE;
    this.o.a();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (paramParcelable instanceof SavedState) {
      this.n = (SavedState)paramParcelable;
      requestLayout();
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = this.n;
    if (savedState != null)
      return new SavedState(savedState); 
    savedState = new SavedState();
    if (getChildCount() > 0) {
      b();
      int i = this.b ^ this.k;
      savedState.c = i;
      if (i != 0) {
        View view1 = j();
        savedState.b = this.j.getEndAfterPadding() - this.j.getDecoratedEnd(view1);
        savedState.a = getPosition(view1);
        return savedState;
      } 
      View view = i();
      savedState.a = getPosition(view);
      savedState.b = this.j.getDecoratedStart(view) - this.j.getStartAfterPadding();
      return savedState;
    } 
    savedState.b();
    return savedState;
  }
  
  public void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    b();
    h();
    paramInt1 = getPosition(paramView1);
    paramInt2 = getPosition(paramView2);
    if (paramInt1 < paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    } 
    if (this.k) {
      if (paramInt1 == 1) {
        scrollToPositionWithOffset(paramInt2, this.j.getEndAfterPadding() - this.j.getDecoratedStart(paramView2) + this.j.getDecoratedMeasurement(paramView1));
        return;
      } 
      scrollToPositionWithOffset(paramInt2, this.j.getEndAfterPadding() - this.j.getDecoratedEnd(paramView2));
      return;
    } 
    if (paramInt1 == -1) {
      scrollToPositionWithOffset(paramInt2, this.j.getDecoratedStart(paramView2));
      return;
    } 
    scrollToPositionWithOffset(paramInt2, this.j.getDecoratedEnd(paramView2) - this.j.getDecoratedMeasurement(paramView1));
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.i == 1) ? 0 : a(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt) {
    this.l = paramInt;
    this.m = Integer.MIN_VALUE;
    SavedState savedState = this.n;
    if (savedState != null)
      savedState.b(); 
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2) {
    this.l = paramInt1;
    this.m = paramInt2;
    SavedState savedState = this.n;
    if (savedState != null)
      savedState.b(); 
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.i == 0) ? 0 : a(paramInt, paramRecycler, paramState);
  }
  
  public void setInitialPrefetchItemCount(int paramInt) {
    this.h = paramInt;
  }
  
  public void setOrientation(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      assertNotInLayoutOrScroll((String)null);
      if (paramInt != this.i || this.j == null) {
        this.j = OrientationHelper.createOrientationHelper(this, paramInt);
        this.o.a = this.j;
        this.i = paramInt;
        requestLayout();
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("invalid orientation:");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setReverseLayout(boolean paramBoolean) {
    assertNotInLayoutOrScroll((String)null);
    if (paramBoolean == this.c)
      return; 
    this.c = paramBoolean;
    requestLayout();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public void setStackFromEnd(boolean paramBoolean) {
    assertNotInLayoutOrScroll((String)null);
    if (this.d == paramBoolean)
      return; 
    this.d = paramBoolean;
    requestLayout();
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt) {
    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(paramRecyclerView.getContext());
    linearSmoothScroller.setTargetPosition(paramInt);
    startSmoothScroll(linearSmoothScroller);
  }
  
  public boolean supportsPredictiveItemAnimations() {
    return (this.n == null && this.b == this.d);
  }
  
  static class AnchorInfo {
    OrientationHelper a;
    
    int b;
    
    int c;
    
    boolean d;
    
    boolean e;
    
    AnchorInfo() {
      a();
    }
    
    void a() {
      this.b = -1;
      this.c = Integer.MIN_VALUE;
      this.d = false;
      this.e = false;
    }
    
    boolean a(View param1View, RecyclerView.State param1State) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      return (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < param1State.getItemCount());
    }
    
    public void assignFromView(View param1View, int param1Int) {
      if (this.d) {
        this.c = this.a.getDecoratedEnd(param1View) + this.a.getTotalSpaceChange();
      } else {
        this.c = this.a.getDecoratedStart(param1View);
      } 
      this.b = param1Int;
    }
    
    public void assignFromViewAndKeepVisibleRect(View param1View, int param1Int) {
      int i = this.a.getTotalSpaceChange();
      if (i >= 0) {
        assignFromView(param1View, param1Int);
        return;
      } 
      this.b = param1Int;
      if (this.d) {
        param1Int = this.a.getEndAfterPadding() - i - this.a.getDecoratedEnd(param1View);
        this.c = this.a.getEndAfterPadding() - param1Int;
        if (param1Int > 0) {
          i = this.a.getDecoratedMeasurement(param1View);
          int j = this.c;
          int k = this.a.getStartAfterPadding();
          i = j - i - k + Math.min(this.a.getDecoratedStart(param1View) - k, 0);
          if (i < 0) {
            this.c += Math.min(param1Int, -i);
            return;
          } 
        } 
      } else {
        int j = this.a.getDecoratedStart(param1View);
        param1Int = j - this.a.getStartAfterPadding();
        this.c = j;
        if (param1Int > 0) {
          int k = this.a.getDecoratedMeasurement(param1View);
          int m = this.a.getEndAfterPadding();
          int n = this.a.getDecoratedEnd(param1View);
          i = this.a.getEndAfterPadding() - Math.min(0, m - i - n) - j + k;
          if (i < 0)
            this.c -= Math.min(param1Int, -i); 
        } 
      } 
    }
    
    void b() {
      int i;
      if (this.d) {
        i = this.a.getEndAfterPadding();
      } else {
        i = this.a.getStartAfterPadding();
      } 
      this.c = i;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AnchorInfo{mPosition=");
      stringBuilder.append(this.b);
      stringBuilder.append(", mCoordinate=");
      stringBuilder.append(this.c);
      stringBuilder.append(", mLayoutFromEnd=");
      stringBuilder.append(this.d);
      stringBuilder.append(", mValid=");
      stringBuilder.append(this.e);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public static class LayoutChunkResult {
    public int mConsumed;
    
    public boolean mFinished;
    
    public boolean mFocusable;
    
    public boolean mIgnoreConsumed;
    
    void a() {
      this.mConsumed = 0;
      this.mFinished = false;
      this.mIgnoreConsumed = false;
      this.mFocusable = false;
    }
  }
  
  static class LayoutState {
    boolean a = true;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
    
    int g;
    
    int h = 0;
    
    int i = 0;
    
    boolean j = false;
    
    int k;
    
    List<RecyclerView.ViewHolder> l = null;
    
    boolean m;
    
    private View a() {
      int j = this.l.size();
      for (int i = 0; i < j; i++) {
        View view = ((RecyclerView.ViewHolder)this.l.get(i)).itemView;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        if (!layoutParams.isItemRemoved() && this.d == layoutParams.getViewLayoutPosition()) {
          assignPositionFromScrapList(view);
          return view;
        } 
      } 
      return null;
    }
    
    View a(RecyclerView.Recycler param1Recycler) {
      if (this.l != null)
        return a(); 
      View view = param1Recycler.getViewForPosition(this.d);
      this.d += this.e;
      return view;
    }
    
    boolean a(RecyclerView.State param1State) {
      int i = this.d;
      return (i >= 0 && i < param1State.getItemCount());
    }
    
    public void assignPositionFromScrapList() {
      assignPositionFromScrapList(null);
    }
    
    public void assignPositionFromScrapList(View param1View) {
      param1View = nextViewInLimitedList(param1View);
      if (param1View == null) {
        this.d = -1;
        return;
      } 
      this.d = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).getViewLayoutPosition();
    }
    
    public View nextViewInLimitedList(View param1View) {
      int k = this.l.size();
      View view = null;
      int j = Integer.MAX_VALUE;
      int i = 0;
      while (i < k) {
        View view2 = ((RecyclerView.ViewHolder)this.l.get(i)).itemView;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view2.getLayoutParams();
        View view1 = view;
        int m = j;
        if (view2 != param1View)
          if (layoutParams.isItemRemoved()) {
            view1 = view;
            m = j;
          } else {
            int n = (layoutParams.getViewLayoutPosition() - this.d) * this.e;
            if (n < 0) {
              view1 = view;
              m = j;
            } else {
              view1 = view;
              m = j;
              if (n < j) {
                view1 = view2;
                if (n == 0)
                  return view1; 
                m = n;
              } 
            } 
          }  
        i++;
        view = view1;
        j = m;
      } 
      return view;
    }
  }
  
  public static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public LinearLayoutManager.SavedState createFromParcel(Parcel param2Parcel) {
          return new LinearLayoutManager.SavedState(param2Parcel);
        }
        
        public LinearLayoutManager.SavedState[] newArray(int param2Int) {
          return new LinearLayoutManager.SavedState[param2Int];
        }
      };
    
    int a;
    
    int b;
    
    boolean c;
    
    public SavedState() {}
    
    SavedState(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.c = bool;
    }
    
    public SavedState(SavedState param1SavedState) {
      this.a = param1SavedState.a;
      this.b = param1SavedState.b;
      this.c = param1SavedState.c;
    }
    
    boolean a() {
      return (this.a >= 0);
    }
    
    void b() {
      this.a = -1;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public LinearLayoutManager.SavedState createFromParcel(Parcel param1Parcel) {
      return new LinearLayoutManager.SavedState(param1Parcel);
    }
    
    public LinearLayoutManager.SavedState[] newArray(int param1Int) {
      return new LinearLayoutManager.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */