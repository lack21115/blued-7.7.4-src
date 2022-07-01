package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
  @Deprecated
  public static final int GAP_HANDLING_LAZY = 1;
  
  public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
  
  public static final int GAP_HANDLING_NONE = 0;
  
  public static final int HORIZONTAL = 0;
  
  public static final int VERTICAL = 1;
  
  private SavedState A;
  
  private int B;
  
  private final Rect C = new Rect();
  
  private final AnchorInfo D = new AnchorInfo(this);
  
  private boolean E = false;
  
  private boolean F = true;
  
  private int[] G;
  
  private final Runnable H = new Runnable(this) {
      public void run() {
        this.a.a();
      }
    };
  
  Span[] a;
  
  OrientationHelper b;
  
  OrientationHelper c;
  
  boolean d = false;
  
  boolean e = false;
  
  int f = -1;
  
  int g = Integer.MIN_VALUE;
  
  LazySpanLookup h = new LazySpanLookup();
  
  private int i = -1;
  
  private int j;
  
  private int k;
  
  private final LayoutState l;
  
  private BitSet m;
  
  private int n = 2;
  
  private boolean o;
  
  private boolean z;
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2) {
    this.j = paramInt2;
    setSpanCount(paramInt1);
    this.l = new LayoutState();
    l();
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    RecyclerView.LayoutManager.Properties properties = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(properties.orientation);
    setSpanCount(properties.spanCount);
    setReverseLayout(properties.reverseLayout);
    this.l = new LayoutState();
    l();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 == 0 && paramInt3 == 0)
      return paramInt1; 
    int i = View.MeasureSpec.getMode(paramInt1);
    return (i == Integer.MIN_VALUE || i == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i) : paramInt1;
  }
  
  private int a(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState) {
    int i;
    this.m.set(0, this.i, true);
    if (this.l.i) {
      if (paramLayoutState.e == 1) {
        i = Integer.MAX_VALUE;
      } else {
        i = Integer.MIN_VALUE;
      } 
    } else if (paramLayoutState.e == 1) {
      i = paramLayoutState.g + paramLayoutState.b;
    } else {
      i = paramLayoutState.f - paramLayoutState.b;
    } 
    a(paramLayoutState.e, i);
    if (this.e) {
      k = this.b.getEndAfterPadding();
    } else {
      k = this.b.getStartAfterPadding();
    } 
    int j;
    for (j = 0; paramLayoutState.a(paramState) && (this.l.i || !this.m.isEmpty()); j = 1) {
      int m;
      int n;
      int i1;
      Span span;
      View view = paramLayoutState.a(paramRecycler);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      int i2 = layoutParams.getViewLayoutPosition();
      j = this.h.c(i2);
      if (j == -1) {
        i1 = 1;
      } else {
        i1 = 0;
      } 
      if (i1) {
        if (layoutParams.b) {
          span = this.a[0];
        } else {
          span = a(paramLayoutState);
        } 
        this.h.a(i2, span);
      } else {
        span = this.a[j];
      } 
      layoutParams.a = span;
      if (paramLayoutState.e == 1) {
        addView(view);
      } else {
        addView(view, 0);
      } 
      a(view, layoutParams, false);
      if (paramLayoutState.e == 1) {
        if (layoutParams.b) {
          j = g(k);
        } else {
          j = span.b(k);
        } 
        m = this.b.getDecoratedMeasurement(view);
        if (i1 && layoutParams.b) {
          LazySpanLookup.FullSpanItem fullSpanItem = c(j);
          fullSpanItem.b = -1;
          fullSpanItem.a = i2;
          this.h.addFullSpanItem(fullSpanItem);
        } 
        n = m + j;
        m = j;
      } else {
        if (layoutParams.b) {
          j = f(k);
        } else {
          j = span.a(k);
        } 
        m = j - this.b.getDecoratedMeasurement(view);
        if (i1 && layoutParams.b) {
          LazySpanLookup.FullSpanItem fullSpanItem = d(j);
          fullSpanItem.b = 1;
          fullSpanItem.a = i2;
          this.h.addFullSpanItem(fullSpanItem);
        } 
        n = j;
      } 
      if (layoutParams.b && paramLayoutState.d == -1)
        if (i1) {
          this.E = true;
        } else {
          boolean bool;
          if (paramLayoutState.e == 1) {
            bool = h();
          } else {
            bool = i();
          } 
          if ((bool ^ true) != 0) {
            LazySpanLookup.FullSpanItem fullSpanItem = this.h.getFullSpanItem(i2);
            if (fullSpanItem != null)
              fullSpanItem.d = true; 
            this.E = true;
          } 
        }  
      a(view, layoutParams, paramLayoutState);
      if (c() && this.j == 1) {
        if (layoutParams.b) {
          j = this.c.getEndAfterPadding();
        } else {
          j = this.c.getEndAfterPadding() - (this.i - 1 - span.e) * this.k;
        } 
        i2 = this.c.getDecoratedMeasurement(view);
        i1 = j;
        j -= i2;
        i2 = i1;
      } else {
        if (layoutParams.b) {
          j = this.c.getStartAfterPadding();
        } else {
          j = span.e * this.k + this.c.getStartAfterPadding();
        } 
        i2 = this.c.getDecoratedMeasurement(view);
        i1 = j;
        i2 += j;
        j = i1;
      } 
      if (this.j == 1) {
        layoutDecoratedWithMargins(view, j, m, i2, n);
      } else {
        layoutDecoratedWithMargins(view, m, j, n, i2);
      } 
      if (layoutParams.b) {
        a(this.l.e, i);
      } else {
        a(span, this.l.e, i);
      } 
      a(paramRecycler, this.l);
      if (this.l.h && view.hasFocusable())
        if (layoutParams.b) {
          this.m.clear();
        } else {
          this.m.set(span.e, false);
        }  
    } 
    int k = 0;
    if (j == 0)
      a(paramRecycler, this.l); 
    if (this.l.e == -1) {
      i = f(this.b.getStartAfterPadding());
      i = this.b.getStartAfterPadding() - i;
    } else {
      i = g(this.b.getEndAfterPadding()) - this.b.getEndAfterPadding();
    } 
    j = k;
    if (i > 0)
      j = Math.min(paramLayoutState.b, i); 
    return j;
  }
  
  private int a(RecyclerView.State paramState) {
    return (getChildCount() == 0) ? 0 : ScrollbarHelper.a(paramState, this.b, a(this.F ^ true), b(this.F ^ true), this, this.F, this.e);
  }
  
  private Span a(LayoutState paramLayoutState) {
    int i;
    byte b;
    boolean bool = i(paramLayoutState.e);
    int j = -1;
    if (bool) {
      i = this.i - 1;
      b = -1;
    } else {
      i = 0;
      j = this.i;
      b = 1;
    } 
    int k = paramLayoutState.e;
    Span span2 = null;
    paramLayoutState = null;
    if (k == 1) {
      Span span;
      k = Integer.MAX_VALUE;
      int n = this.b.getStartAfterPadding();
      while (i != j) {
        span2 = this.a[i];
        int i2 = span2.b(n);
        int i1 = k;
        if (i2 < k) {
          span = span2;
          i1 = i2;
        } 
        i += b;
        k = i1;
      } 
      return span;
    } 
    k = Integer.MIN_VALUE;
    int m = this.b.getEndAfterPadding();
    Span span1 = span2;
    while (i != j) {
      span2 = this.a[i];
      int i1 = span2.a(m);
      int n = k;
      if (i1 > k) {
        span1 = span2;
        n = i1;
      } 
      i += b;
      k = n;
    } 
    return span1;
  }
  
  private void a(int paramInt1, int paramInt2) {
    for (int i = 0; i < this.i; i++) {
      if (!(this.a[i]).a.isEmpty())
        a(this.a[i], paramInt1, paramInt2); 
    } 
  }
  
  private void a(View paramView) {
    for (int i = this.i - 1; i >= 0; i--)
      this.a[i].b(paramView); 
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    calculateItemDecorationsForChild(paramView, this.C);
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = a(paramInt1, layoutParams.leftMargin + this.C.left, layoutParams.rightMargin + this.C.right);
    paramInt2 = a(paramInt2, layoutParams.topMargin + this.C.top, layoutParams.bottomMargin + this.C.bottom);
    if (paramBoolean) {
      paramBoolean = a(paramView, paramInt1, paramInt2, layoutParams);
    } else {
      paramBoolean = b(paramView, paramInt1, paramInt2, layoutParams);
    } 
    if (paramBoolean)
      paramView.measure(paramInt1, paramInt2); 
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, LayoutState paramLayoutState) {
    if (paramLayoutState.e == 1) {
      if (paramLayoutParams.b) {
        a(paramView);
        return;
      } 
      paramLayoutParams.a.b(paramView);
      return;
    } 
    if (paramLayoutParams.b) {
      b(paramView);
      return;
    } 
    paramLayoutParams.a.a(paramView);
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, boolean paramBoolean) {
    if (paramLayoutParams.b) {
      if (this.j == 1) {
        a(paramView, this.B, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true), paramBoolean);
        return;
      } 
      a(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.B, paramBoolean);
      return;
    } 
    if (this.j == 1) {
      a(paramView, getChildMeasureSpec(this.k, getWidthMode(), 0, paramLayoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true), paramBoolean);
      return;
    } 
    a(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), getChildMeasureSpec(this.k, getHeightMode(), 0, paramLayoutParams.height, false), paramBoolean);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, int paramInt) {
    while (getChildCount() > 0) {
      byte b = 0;
      View view = getChildAt(0);
      if (this.b.getDecoratedEnd(view) <= paramInt && this.b.getTransformedEndWithDecoration(view) <= paramInt) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.b) {
          int j;
          int i = 0;
          while (true) {
            j = b;
            if (i < this.i) {
              if ((this.a[i]).a.size() == 1)
                return; 
              i++;
              continue;
            } 
            break;
          } 
          while (j < this.i) {
            this.a[j].h();
            j++;
          } 
        } else {
          if (layoutParams.a.a.size() == 1)
            return; 
          layoutParams.a.h();
        } 
        removeAndRecycleView(view, paramRecycler);
      } 
    } 
  }
  
  private void a(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState) {
    if (paramLayoutState.a) {
      if (paramLayoutState.i)
        return; 
      if (paramLayoutState.b == 0) {
        if (paramLayoutState.e == -1) {
          b(paramRecycler, paramLayoutState.g);
          return;
        } 
        a(paramRecycler, paramLayoutState.f);
        return;
      } 
      if (paramLayoutState.e == -1) {
        int j = paramLayoutState.f - e(paramLayoutState.f);
        if (j < 0) {
          j = paramLayoutState.g;
        } else {
          j = paramLayoutState.g - Math.min(j, paramLayoutState.b);
        } 
        b(paramRecycler, j);
        return;
      } 
      int i = h(paramLayoutState.g) - paramLayoutState.g;
      if (i < 0) {
        i = paramLayoutState.f;
      } else {
        int j = paramLayoutState.f;
        i = Math.min(i, paramLayoutState.b) + j;
      } 
      a(paramRecycler, i);
    } 
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield D : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   4: astore #7
    //   6: aload_0
    //   7: getfield A : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$SavedState;
    //   10: ifnonnull -> 21
    //   13: aload_0
    //   14: getfield f : I
    //   17: iconst_m1
    //   18: if_icmpeq -> 39
    //   21: aload_2
    //   22: invokevirtual getItemCount : ()I
    //   25: ifne -> 39
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual removeAndRecycleAllViews : (Landroidx/recyclerview/widget/RecyclerView$Recycler;)V
    //   33: aload #7
    //   35: invokevirtual a : ()V
    //   38: return
    //   39: aload #7
    //   41: getfield e : Z
    //   44: istore #6
    //   46: iconst_1
    //   47: istore #5
    //   49: iload #6
    //   51: ifeq -> 78
    //   54: aload_0
    //   55: getfield f : I
    //   58: iconst_m1
    //   59: if_icmpne -> 78
    //   62: aload_0
    //   63: getfield A : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$SavedState;
    //   66: ifnull -> 72
    //   69: goto -> 78
    //   72: iconst_0
    //   73: istore #4
    //   75: goto -> 81
    //   78: iconst_1
    //   79: istore #4
    //   81: iload #4
    //   83: ifeq -> 133
    //   86: aload #7
    //   88: invokevirtual a : ()V
    //   91: aload_0
    //   92: getfield A : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$SavedState;
    //   95: ifnull -> 107
    //   98: aload_0
    //   99: aload #7
    //   101: invokespecial a : (Landroidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo;)V
    //   104: goto -> 120
    //   107: aload_0
    //   108: invokespecial m : ()V
    //   111: aload #7
    //   113: aload_0
    //   114: getfield e : Z
    //   117: putfield c : Z
    //   120: aload_0
    //   121: aload_2
    //   122: aload #7
    //   124: invokevirtual a : (Landroidx/recyclerview/widget/RecyclerView$State;Landroidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo;)V
    //   127: aload #7
    //   129: iconst_1
    //   130: putfield e : Z
    //   133: aload_0
    //   134: getfield A : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$SavedState;
    //   137: ifnonnull -> 184
    //   140: aload_0
    //   141: getfield f : I
    //   144: iconst_m1
    //   145: if_icmpne -> 184
    //   148: aload #7
    //   150: getfield c : Z
    //   153: aload_0
    //   154: getfield o : Z
    //   157: if_icmpne -> 171
    //   160: aload_0
    //   161: invokevirtual c : ()Z
    //   164: aload_0
    //   165: getfield z : Z
    //   168: if_icmpeq -> 184
    //   171: aload_0
    //   172: getfield h : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$LazySpanLookup;
    //   175: invokevirtual a : ()V
    //   178: aload #7
    //   180: iconst_1
    //   181: putfield d : Z
    //   184: aload_0
    //   185: invokevirtual getChildCount : ()I
    //   188: ifle -> 394
    //   191: aload_0
    //   192: getfield A : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$SavedState;
    //   195: astore #8
    //   197: aload #8
    //   199: ifnull -> 211
    //   202: aload #8
    //   204: getfield c : I
    //   207: iconst_1
    //   208: if_icmpge -> 394
    //   211: aload #7
    //   213: getfield d : Z
    //   216: ifeq -> 275
    //   219: iconst_0
    //   220: istore #4
    //   222: iload #4
    //   224: aload_0
    //   225: getfield i : I
    //   228: if_icmpge -> 394
    //   231: aload_0
    //   232: getfield a : [Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   235: iload #4
    //   237: aaload
    //   238: invokevirtual e : ()V
    //   241: aload #7
    //   243: getfield b : I
    //   246: ldc -2147483648
    //   248: if_icmpeq -> 266
    //   251: aload_0
    //   252: getfield a : [Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   255: iload #4
    //   257: aaload
    //   258: aload #7
    //   260: getfield b : I
    //   263: invokevirtual c : (I)V
    //   266: iload #4
    //   268: iconst_1
    //   269: iadd
    //   270: istore #4
    //   272: goto -> 222
    //   275: iload #4
    //   277: ifne -> 343
    //   280: aload_0
    //   281: getfield D : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   284: getfield f : [I
    //   287: ifnonnull -> 293
    //   290: goto -> 343
    //   293: iconst_0
    //   294: istore #4
    //   296: iload #4
    //   298: aload_0
    //   299: getfield i : I
    //   302: if_icmpge -> 394
    //   305: aload_0
    //   306: getfield a : [Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   309: iload #4
    //   311: aaload
    //   312: astore #8
    //   314: aload #8
    //   316: invokevirtual e : ()V
    //   319: aload #8
    //   321: aload_0
    //   322: getfield D : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   325: getfield f : [I
    //   328: iload #4
    //   330: iaload
    //   331: invokevirtual c : (I)V
    //   334: iload #4
    //   336: iconst_1
    //   337: iadd
    //   338: istore #4
    //   340: goto -> 296
    //   343: iconst_0
    //   344: istore #4
    //   346: iload #4
    //   348: aload_0
    //   349: getfield i : I
    //   352: if_icmpge -> 383
    //   355: aload_0
    //   356: getfield a : [Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   359: iload #4
    //   361: aaload
    //   362: aload_0
    //   363: getfield e : Z
    //   366: aload #7
    //   368: getfield b : I
    //   371: invokevirtual a : (ZI)V
    //   374: iload #4
    //   376: iconst_1
    //   377: iadd
    //   378: istore #4
    //   380: goto -> 346
    //   383: aload_0
    //   384: getfield D : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   387: aload_0
    //   388: getfield a : [Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   391: invokevirtual a : ([Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;)V
    //   394: aload_0
    //   395: aload_1
    //   396: invokevirtual detachAndScrapAttachedViews : (Landroidx/recyclerview/widget/RecyclerView$Recycler;)V
    //   399: aload_0
    //   400: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   403: iconst_0
    //   404: putfield a : Z
    //   407: aload_0
    //   408: iconst_0
    //   409: putfield E : Z
    //   412: aload_0
    //   413: aload_0
    //   414: getfield c : Landroidx/recyclerview/widget/OrientationHelper;
    //   417: invokevirtual getTotalSpace : ()I
    //   420: invokevirtual a : (I)V
    //   423: aload_0
    //   424: aload #7
    //   426: getfield a : I
    //   429: aload_2
    //   430: invokespecial b : (ILandroidx/recyclerview/widget/RecyclerView$State;)V
    //   433: aload #7
    //   435: getfield c : Z
    //   438: ifeq -> 496
    //   441: aload_0
    //   442: iconst_m1
    //   443: invokespecial b : (I)V
    //   446: aload_0
    //   447: aload_1
    //   448: aload_0
    //   449: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   452: aload_2
    //   453: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/LayoutState;Landroidx/recyclerview/widget/RecyclerView$State;)I
    //   456: pop
    //   457: aload_0
    //   458: iconst_1
    //   459: invokespecial b : (I)V
    //   462: aload_0
    //   463: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   466: aload #7
    //   468: getfield a : I
    //   471: aload_0
    //   472: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   475: getfield d : I
    //   478: iadd
    //   479: putfield c : I
    //   482: aload_0
    //   483: aload_1
    //   484: aload_0
    //   485: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   488: aload_2
    //   489: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/LayoutState;Landroidx/recyclerview/widget/RecyclerView$State;)I
    //   492: pop
    //   493: goto -> 548
    //   496: aload_0
    //   497: iconst_1
    //   498: invokespecial b : (I)V
    //   501: aload_0
    //   502: aload_1
    //   503: aload_0
    //   504: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   507: aload_2
    //   508: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/LayoutState;Landroidx/recyclerview/widget/RecyclerView$State;)I
    //   511: pop
    //   512: aload_0
    //   513: iconst_m1
    //   514: invokespecial b : (I)V
    //   517: aload_0
    //   518: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   521: aload #7
    //   523: getfield a : I
    //   526: aload_0
    //   527: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   530: getfield d : I
    //   533: iadd
    //   534: putfield c : I
    //   537: aload_0
    //   538: aload_1
    //   539: aload_0
    //   540: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   543: aload_2
    //   544: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/LayoutState;Landroidx/recyclerview/widget/RecyclerView$State;)I
    //   547: pop
    //   548: aload_0
    //   549: invokespecial n : ()V
    //   552: aload_0
    //   553: invokevirtual getChildCount : ()I
    //   556: ifle -> 597
    //   559: aload_0
    //   560: getfield e : Z
    //   563: ifeq -> 583
    //   566: aload_0
    //   567: aload_1
    //   568: aload_2
    //   569: iconst_1
    //   570: invokespecial b : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;Z)V
    //   573: aload_0
    //   574: aload_1
    //   575: aload_2
    //   576: iconst_0
    //   577: invokespecial c : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;Z)V
    //   580: goto -> 597
    //   583: aload_0
    //   584: aload_1
    //   585: aload_2
    //   586: iconst_1
    //   587: invokespecial c : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;Z)V
    //   590: aload_0
    //   591: aload_1
    //   592: aload_2
    //   593: iconst_0
    //   594: invokespecial b : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;Z)V
    //   597: iload_3
    //   598: ifeq -> 673
    //   601: aload_2
    //   602: invokevirtual isPreLayout : ()Z
    //   605: ifne -> 673
    //   608: aload_0
    //   609: getfield n : I
    //   612: ifeq -> 642
    //   615: aload_0
    //   616: invokevirtual getChildCount : ()I
    //   619: ifle -> 642
    //   622: aload_0
    //   623: getfield E : Z
    //   626: ifne -> 636
    //   629: aload_0
    //   630: invokevirtual b : ()Landroid/view/View;
    //   633: ifnull -> 642
    //   636: iconst_1
    //   637: istore #4
    //   639: goto -> 645
    //   642: iconst_0
    //   643: istore #4
    //   645: iload #4
    //   647: ifeq -> 673
    //   650: aload_0
    //   651: aload_0
    //   652: getfield H : Ljava/lang/Runnable;
    //   655: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)Z
    //   658: pop
    //   659: aload_0
    //   660: invokevirtual a : ()Z
    //   663: ifeq -> 673
    //   666: iload #5
    //   668: istore #4
    //   670: goto -> 676
    //   673: iconst_0
    //   674: istore #4
    //   676: aload_2
    //   677: invokevirtual isPreLayout : ()Z
    //   680: ifeq -> 690
    //   683: aload_0
    //   684: getfield D : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   687: invokevirtual a : ()V
    //   690: aload_0
    //   691: aload #7
    //   693: getfield c : Z
    //   696: putfield o : Z
    //   699: aload_0
    //   700: aload_0
    //   701: invokevirtual c : ()Z
    //   704: putfield z : Z
    //   707: iload #4
    //   709: ifeq -> 726
    //   712: aload_0
    //   713: getfield D : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   716: invokevirtual a : ()V
    //   719: aload_0
    //   720: aload_1
    //   721: aload_2
    //   722: iconst_0
    //   723: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;Z)V
    //   726: return
  }
  
  private void a(AnchorInfo paramAnchorInfo) {
    if (this.A.c > 0)
      if (this.A.c == this.i) {
        for (int i = 0; i < this.i; i++) {
          this.a[i].e();
          int k = this.A.d[i];
          int j = k;
          if (k != Integer.MIN_VALUE) {
            if (this.A.i) {
              j = this.b.getEndAfterPadding();
            } else {
              j = this.b.getStartAfterPadding();
            } 
            j = k + j;
          } 
          this.a[i].c(j);
        } 
      } else {
        this.A.a();
        SavedState savedState = this.A;
        savedState.a = savedState.b;
      }  
    this.z = this.A.j;
    setReverseLayout(this.A.h);
    m();
    if (this.A.a != -1) {
      this.f = this.A.a;
      paramAnchorInfo.c = this.A.i;
    } else {
      paramAnchorInfo.c = this.e;
    } 
    if (this.A.e > 1) {
      this.h.a = this.A.f;
      this.h.b = this.A.g;
    } 
  }
  
  private void a(Span paramSpan, int paramInt1, int paramInt2) {
    int i = paramSpan.getDeletedSize();
    if (paramInt1 == -1) {
      if (paramSpan.b() + i <= paramInt2) {
        this.m.set(paramSpan.e, false);
        return;
      } 
    } else if (paramSpan.d() - i >= paramInt2) {
      this.m.set(paramSpan.e, false);
    } 
  }
  
  private boolean a(Span paramSpan) {
    if (this.e) {
      if (paramSpan.d() < this.b.getEndAfterPadding())
        return (paramSpan.c((View)paramSpan.a.get(paramSpan.a.size() - 1))).b ^ true; 
    } else if (paramSpan.b() > this.b.getStartAfterPadding()) {
      return (paramSpan.c((View)paramSpan.a.get(0))).b ^ true;
    } 
    return false;
  }
  
  private int b(RecyclerView.State paramState) {
    return (getChildCount() == 0) ? 0 : ScrollbarHelper.a(paramState, this.b, a(this.F ^ true), b(this.F ^ true), this, this.F);
  }
  
  private void b(int paramInt) {
    boolean bool1;
    LayoutState layoutState = this.l;
    layoutState.e = paramInt;
    boolean bool2 = this.e;
    boolean bool = true;
    if (paramInt == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool2 == bool1) {
      paramInt = bool;
    } else {
      paramInt = -1;
    } 
    layoutState.d = paramInt;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3) {
    if (this.e) {
      int k = j();
    } else {
      int k = k();
    } 
    if (paramInt3 == 8) {
      if (paramInt1 < paramInt2) {
        i = paramInt2 + 1;
      } else {
        int k = paramInt1 + 1;
        i = paramInt2;
        this.h.b(i);
      } 
    } else {
      i = paramInt1 + paramInt2;
    } 
    int j = i;
    int i = paramInt1;
    this.h.b(i);
  }
  
  private void b(int paramInt, RecyclerView.State paramState) {
    // Byte code:
    //   0: aload_0
    //   1: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   4: astore #7
    //   6: iconst_0
    //   7: istore #5
    //   9: aload #7
    //   11: iconst_0
    //   12: putfield b : I
    //   15: aload #7
    //   17: iload_1
    //   18: putfield c : I
    //   21: aload_0
    //   22: invokevirtual isSmoothScrolling : ()Z
    //   25: ifeq -> 89
    //   28: aload_2
    //   29: invokevirtual getTargetScrollPosition : ()I
    //   32: istore_3
    //   33: iload_3
    //   34: iconst_m1
    //   35: if_icmpeq -> 89
    //   38: aload_0
    //   39: getfield e : Z
    //   42: istore #6
    //   44: iload_3
    //   45: iload_1
    //   46: if_icmpge -> 55
    //   49: iconst_1
    //   50: istore #4
    //   52: goto -> 58
    //   55: iconst_0
    //   56: istore #4
    //   58: iload #6
    //   60: iload #4
    //   62: if_icmpne -> 76
    //   65: aload_0
    //   66: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   69: invokevirtual getTotalSpace : ()I
    //   72: istore_1
    //   73: goto -> 91
    //   76: aload_0
    //   77: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   80: invokevirtual getTotalSpace : ()I
    //   83: istore_3
    //   84: iconst_0
    //   85: istore_1
    //   86: goto -> 93
    //   89: iconst_0
    //   90: istore_1
    //   91: iconst_0
    //   92: istore_3
    //   93: aload_0
    //   94: invokevirtual getClipToPadding : ()Z
    //   97: ifeq -> 135
    //   100: aload_0
    //   101: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   104: aload_0
    //   105: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   108: invokevirtual getStartAfterPadding : ()I
    //   111: iload_3
    //   112: isub
    //   113: putfield f : I
    //   116: aload_0
    //   117: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   120: aload_0
    //   121: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   124: invokevirtual getEndAfterPadding : ()I
    //   127: iload_1
    //   128: iadd
    //   129: putfield g : I
    //   132: goto -> 160
    //   135: aload_0
    //   136: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   139: aload_0
    //   140: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   143: invokevirtual getEnd : ()I
    //   146: iload_1
    //   147: iadd
    //   148: putfield g : I
    //   151: aload_0
    //   152: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   155: iload_3
    //   156: ineg
    //   157: putfield f : I
    //   160: aload_0
    //   161: getfield l : Landroidx/recyclerview/widget/LayoutState;
    //   164: astore_2
    //   165: aload_2
    //   166: iconst_0
    //   167: putfield h : Z
    //   170: aload_2
    //   171: iconst_1
    //   172: putfield a : Z
    //   175: iload #5
    //   177: istore #4
    //   179: aload_0
    //   180: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   183: invokevirtual getMode : ()I
    //   186: ifne -> 206
    //   189: iload #5
    //   191: istore #4
    //   193: aload_0
    //   194: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   197: invokevirtual getEnd : ()I
    //   200: ifne -> 206
    //   203: iconst_1
    //   204: istore #4
    //   206: aload_2
    //   207: iload #4
    //   209: putfield i : Z
    //   212: return
  }
  
  private void b(View paramView) {
    for (int i = this.i - 1; i >= 0; i--)
      this.a[i].a(paramView); 
  }
  
  private void b(RecyclerView.Recycler paramRecycler, int paramInt) {
    int i = getChildCount() - 1;
    while (i >= 0) {
      View view = getChildAt(i);
      if (this.b.getDecoratedStart(view) >= paramInt && this.b.getTransformedStartWithDecoration(view) >= paramInt) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.b) {
          int k;
          byte b = 0;
          int j = 0;
          while (true) {
            k = b;
            if (j < this.i) {
              if ((this.a[j]).a.size() == 1)
                return; 
              j++;
              continue;
            } 
            break;
          } 
          while (k < this.i) {
            this.a[k].g();
            k++;
          } 
        } else {
          if (layoutParams.a.a.size() == 1)
            return; 
          layoutParams.a.g();
        } 
        removeAndRecycleView(view, paramRecycler);
        i--;
      } 
    } 
  }
  
  private void b(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    int i = g(-2147483648);
    if (i == Integer.MIN_VALUE)
      return; 
    i = this.b.getEndAfterPadding() - i;
    if (i > 0) {
      i -= -a(-i, paramRecycler, paramState);
      if (paramBoolean && i > 0)
        this.b.offsetChildren(i); 
    } 
  }
  
  private int c(RecyclerView.State paramState) {
    return (getChildCount() == 0) ? 0 : ScrollbarHelper.b(paramState, this.b, a(this.F ^ true), b(this.F ^ true), this, this.F);
  }
  
  private LazySpanLookup.FullSpanItem c(int paramInt) {
    LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
    fullSpanItem.c = new int[this.i];
    for (int i = 0; i < this.i; i++)
      fullSpanItem.c[i] = paramInt - this.a[i].b(paramInt); 
    return fullSpanItem;
  }
  
  private void c(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    int i = f(2147483647);
    if (i == Integer.MAX_VALUE)
      return; 
    i -= this.b.getStartAfterPadding();
    if (i > 0) {
      i -= a(i, paramRecycler, paramState);
      if (paramBoolean && i > 0)
        this.b.offsetChildren(-i); 
    } 
  }
  
  private boolean c(RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    int i;
    if (this.o) {
      i = l(paramState.getItemCount());
    } else {
      i = k(paramState.getItemCount());
    } 
    paramAnchorInfo.a = i;
    paramAnchorInfo.b = Integer.MIN_VALUE;
    return true;
  }
  
  private LazySpanLookup.FullSpanItem d(int paramInt) {
    LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
    fullSpanItem.c = new int[this.i];
    for (int i = 0; i < this.i; i++)
      fullSpanItem.c[i] = this.a[i].a(paramInt) - paramInt; 
    return fullSpanItem;
  }
  
  private int e(int paramInt) {
    int j = this.a[0].a(paramInt);
    int i = 1;
    while (i < this.i) {
      int m = this.a[i].a(paramInt);
      int k = j;
      if (m > j)
        k = m; 
      i++;
      j = k;
    } 
    return j;
  }
  
  private int f(int paramInt) {
    int j = this.a[0].a(paramInt);
    int i = 1;
    while (i < this.i) {
      int m = this.a[i].a(paramInt);
      int k = j;
      if (m < j)
        k = m; 
      i++;
      j = k;
    } 
    return j;
  }
  
  private int g(int paramInt) {
    int j = this.a[0].b(paramInt);
    int i = 1;
    while (i < this.i) {
      int m = this.a[i].b(paramInt);
      int k = j;
      if (m > j)
        k = m; 
      i++;
      j = k;
    } 
    return j;
  }
  
  private int h(int paramInt) {
    int j = this.a[0].b(paramInt);
    int i = 1;
    while (i < this.i) {
      int m = this.a[i].b(paramInt);
      int k = j;
      if (m < j)
        k = m; 
      i++;
      j = k;
    } 
    return j;
  }
  
  private boolean i(int paramInt) {
    boolean bool;
    if (this.j == 0) {
      if (paramInt == -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return (bool != this.e);
    } 
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool == this.e) {
      bool = true;
    } else {
      bool = false;
    } 
    return (bool == c());
  }
  
  private int j(int paramInt) {
    boolean bool;
    int i = getChildCount();
    byte b = -1;
    if (i == 0) {
      paramInt = b;
      if (this.e)
        paramInt = 1; 
      return paramInt;
    } 
    if (paramInt < k()) {
      bool = true;
    } else {
      bool = false;
    } 
    return (bool != this.e) ? -1 : 1;
  }
  
  private int k(int paramInt) {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      int k = getPosition(getChildAt(i));
      if (k >= 0 && k < paramInt)
        return k; 
    } 
    return 0;
  }
  
  private int l(int paramInt) {
    for (int i = getChildCount() - 1; i >= 0; i--) {
      int j = getPosition(getChildAt(i));
      if (j >= 0 && j < paramInt)
        return j; 
    } 
    return 0;
  }
  
  private void l() {
    this.b = OrientationHelper.createOrientationHelper(this, this.j);
    this.c = OrientationHelper.createOrientationHelper(this, 1 - this.j);
  }
  
  private int m(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 17) ? ((paramInt != 33) ? ((paramInt != 66) ? ((paramInt != 130) ? Integer.MIN_VALUE : ((this.j == 1) ? 1 : Integer.MIN_VALUE)) : ((this.j == 0) ? 1 : Integer.MIN_VALUE)) : ((this.j == 1) ? -1 : Integer.MIN_VALUE)) : ((this.j == 0) ? -1 : Integer.MIN_VALUE)) : ((this.j == 1) ? 1 : (c() ? -1 : 1))) : ((this.j == 1) ? -1 : (c() ? 1 : -1));
  }
  
  private void m() {
    if (this.j == 1 || !c()) {
      this.e = this.d;
      return;
    } 
    this.e = this.d ^ true;
  }
  
  private void n() {
    if (this.c.getMode() == 1073741824)
      return; 
    int m = getChildCount();
    int j = 0;
    int i = 0;
    float f = 0.0F;
    while (i < m) {
      View view = getChildAt(i);
      float f1 = this.c.getDecoratedMeasurement(view);
      if (f1 >= f) {
        float f2 = f1;
        if (((LayoutParams)view.getLayoutParams()).isFullSpan())
          f2 = f1 * 1.0F / this.i; 
        f = Math.max(f, f2);
      } 
      i++;
    } 
    int n = this.k;
    int k = Math.round(f * this.i);
    i = k;
    if (this.c.getMode() == Integer.MIN_VALUE)
      i = Math.min(k, this.c.getTotalSpace()); 
    a(i);
    i = j;
    if (this.k == n)
      return; 
    while (i < m) {
      View view = getChildAt(i);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (!layoutParams.b)
        if (c() && this.j == 1) {
          view.offsetLeftAndRight(-(this.i - 1 - layoutParams.a.e) * this.k - -(this.i - 1 - layoutParams.a.e) * n);
        } else {
          j = layoutParams.a.e * this.k;
          k = layoutParams.a.e * n;
          if (this.j == 1) {
            view.offsetLeftAndRight(j - k);
          } else {
            view.offsetTopAndBottom(j - k);
          } 
        }  
      i++;
    } 
  }
  
  int a(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    if (getChildCount() != 0) {
      if (paramInt == 0)
        return 0; 
      a(paramInt, paramState);
      int i = a(paramRecycler, this.l, paramState);
      if (this.l.b >= i)
        if (paramInt < 0) {
          paramInt = -i;
        } else {
          paramInt = i;
        }  
      this.b.offsetChildren(-paramInt);
      this.o = this.e;
      LayoutState layoutState = this.l;
      layoutState.b = 0;
      a(paramRecycler, layoutState);
      return paramInt;
    } 
    return 0;
  }
  
  View a(boolean paramBoolean) {
    int j = this.b.getStartAfterPadding();
    int k = this.b.getEndAfterPadding();
    int m = getChildCount();
    View view = null;
    int i = 0;
    while (i < m) {
      View view2 = getChildAt(i);
      int n = this.b.getDecoratedStart(view2);
      View view1 = view;
      if (this.b.getDecoratedEnd(view2) > j)
        if (n >= k) {
          view1 = view;
        } else if (n < j) {
          if (!paramBoolean)
            return view2; 
          view1 = view;
          if (view == null)
            view1 = view2; 
        } else {
          return view2;
        }  
      i++;
      view = view1;
    } 
    return view;
  }
  
  void a(int paramInt) {
    this.k = paramInt / this.i;
    this.B = View.MeasureSpec.makeMeasureSpec(paramInt, this.c.getMode());
  }
  
  void a(int paramInt, RecyclerView.State paramState) {
    int i;
    byte b;
    if (paramInt > 0) {
      i = j();
      b = 1;
    } else {
      i = k();
      b = -1;
    } 
    this.l.a = true;
    b(i, paramState);
    b(b);
    LayoutState layoutState = this.l;
    layoutState.c = i + layoutState.d;
    this.l.b = Math.abs(paramInt);
  }
  
  void a(RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    if (b(paramState, paramAnchorInfo))
      return; 
    if (c(paramState, paramAnchorInfo))
      return; 
    paramAnchorInfo.b();
    paramAnchorInfo.a = 0;
  }
  
  boolean a() {
    if (getChildCount() != 0 && this.n != 0) {
      int i;
      int j;
      byte b;
      if (!isAttachedToWindow())
        return false; 
      if (this.e) {
        i = j();
        j = k();
      } else {
        i = k();
        j = j();
      } 
      if (i == 0 && b() != null) {
        this.h.a();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
      } 
      if (!this.E)
        return false; 
      if (this.e) {
        b = -1;
      } else {
        b = 1;
      } 
      LazySpanLookup lazySpanLookup = this.h;
      LazySpanLookup.FullSpanItem fullSpanItem1 = lazySpanLookup.getFirstFullSpanItemInRange(i, ++j, b, true);
      if (fullSpanItem1 == null) {
        this.E = false;
        this.h.a(j);
        return false;
      } 
      LazySpanLookup.FullSpanItem fullSpanItem2 = this.h.getFirstFullSpanItemInRange(i, fullSpanItem1.a, b * -1, true);
      if (fullSpanItem2 == null) {
        this.h.a(fullSpanItem1.a);
      } else {
        this.h.a(fullSpanItem2.a + 1);
      } 
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
    } 
    return false;
  }
  
  public void assertNotInLayoutOrScroll(String paramString) {
    if (this.A == null)
      super.assertNotInLayoutOrScroll(paramString); 
  }
  
  View b() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getChildCount : ()I
    //   4: iconst_1
    //   5: isub
    //   6: istore_1
    //   7: new java/util/BitSet
    //   10: dup
    //   11: aload_0
    //   12: getfield i : I
    //   15: invokespecial <init> : (I)V
    //   18: astore #7
    //   20: aload #7
    //   22: iconst_0
    //   23: aload_0
    //   24: getfield i : I
    //   27: iconst_1
    //   28: invokevirtual set : (IIZ)V
    //   31: aload_0
    //   32: getfield j : I
    //   35: istore_2
    //   36: iconst_m1
    //   37: istore #5
    //   39: iload_2
    //   40: iconst_1
    //   41: if_icmpne -> 56
    //   44: aload_0
    //   45: invokevirtual c : ()Z
    //   48: ifeq -> 56
    //   51: iconst_1
    //   52: istore_2
    //   53: goto -> 58
    //   56: iconst_m1
    //   57: istore_2
    //   58: aload_0
    //   59: getfield e : Z
    //   62: ifeq -> 70
    //   65: iconst_m1
    //   66: istore_3
    //   67: goto -> 76
    //   70: iload_1
    //   71: iconst_1
    //   72: iadd
    //   73: istore_3
    //   74: iconst_0
    //   75: istore_1
    //   76: iload_1
    //   77: istore #4
    //   79: iload_1
    //   80: iload_3
    //   81: if_icmpge -> 90
    //   84: iconst_1
    //   85: istore #5
    //   87: iload_1
    //   88: istore #4
    //   90: iload #4
    //   92: iload_3
    //   93: if_icmpeq -> 349
    //   96: aload_0
    //   97: iload #4
    //   99: invokevirtual getChildAt : (I)Landroid/view/View;
    //   102: astore #8
    //   104: aload #8
    //   106: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   109: checkcast androidx/recyclerview/widget/StaggeredGridLayoutManager$LayoutParams
    //   112: astore #9
    //   114: aload #7
    //   116: aload #9
    //   118: getfield a : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   121: getfield e : I
    //   124: invokevirtual get : (I)Z
    //   127: ifeq -> 158
    //   130: aload_0
    //   131: aload #9
    //   133: getfield a : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   136: invokespecial a : (Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;)Z
    //   139: ifeq -> 145
    //   142: aload #8
    //   144: areturn
    //   145: aload #7
    //   147: aload #9
    //   149: getfield a : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   152: getfield e : I
    //   155: invokevirtual clear : (I)V
    //   158: aload #9
    //   160: getfield b : Z
    //   163: ifeq -> 169
    //   166: goto -> 339
    //   169: iload #4
    //   171: iload #5
    //   173: iadd
    //   174: istore_1
    //   175: iload_1
    //   176: iload_3
    //   177: if_icmpeq -> 339
    //   180: aload_0
    //   181: iload_1
    //   182: invokevirtual getChildAt : (I)Landroid/view/View;
    //   185: astore #10
    //   187: aload_0
    //   188: getfield e : Z
    //   191: ifeq -> 233
    //   194: aload_0
    //   195: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   198: aload #8
    //   200: invokevirtual getDecoratedEnd : (Landroid/view/View;)I
    //   203: istore_1
    //   204: aload_0
    //   205: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   208: aload #10
    //   210: invokevirtual getDecoratedEnd : (Landroid/view/View;)I
    //   213: istore #6
    //   215: iload_1
    //   216: iload #6
    //   218: if_icmpge -> 224
    //   221: aload #8
    //   223: areturn
    //   224: iload_1
    //   225: iload #6
    //   227: if_icmpne -> 274
    //   230: goto -> 269
    //   233: aload_0
    //   234: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   237: aload #8
    //   239: invokevirtual getDecoratedStart : (Landroid/view/View;)I
    //   242: istore_1
    //   243: aload_0
    //   244: getfield b : Landroidx/recyclerview/widget/OrientationHelper;
    //   247: aload #10
    //   249: invokevirtual getDecoratedStart : (Landroid/view/View;)I
    //   252: istore #6
    //   254: iload_1
    //   255: iload #6
    //   257: if_icmple -> 263
    //   260: aload #8
    //   262: areturn
    //   263: iload_1
    //   264: iload #6
    //   266: if_icmpne -> 274
    //   269: iconst_1
    //   270: istore_1
    //   271: goto -> 276
    //   274: iconst_0
    //   275: istore_1
    //   276: iload_1
    //   277: ifeq -> 339
    //   280: aload #10
    //   282: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   285: checkcast androidx/recyclerview/widget/StaggeredGridLayoutManager$LayoutParams
    //   288: astore #10
    //   290: aload #9
    //   292: getfield a : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   295: getfield e : I
    //   298: aload #10
    //   300: getfield a : Landroidx/recyclerview/widget/StaggeredGridLayoutManager$Span;
    //   303: getfield e : I
    //   306: isub
    //   307: ifge -> 315
    //   310: iconst_1
    //   311: istore_1
    //   312: goto -> 317
    //   315: iconst_0
    //   316: istore_1
    //   317: iload_2
    //   318: ifge -> 327
    //   321: iconst_1
    //   322: istore #6
    //   324: goto -> 330
    //   327: iconst_0
    //   328: istore #6
    //   330: iload_1
    //   331: iload #6
    //   333: if_icmpeq -> 339
    //   336: aload #8
    //   338: areturn
    //   339: iload #4
    //   341: iload #5
    //   343: iadd
    //   344: istore #4
    //   346: goto -> 90
    //   349: aconst_null
    //   350: areturn
  }
  
  View b(boolean paramBoolean) {
    int j = this.b.getStartAfterPadding();
    int k = this.b.getEndAfterPadding();
    int i = getChildCount() - 1;
    View view;
    for (view = null; i >= 0; view = view1) {
      View view2 = getChildAt(i);
      int m = this.b.getDecoratedStart(view2);
      int n = this.b.getDecoratedEnd(view2);
      View view1 = view;
      if (n > j)
        if (m >= k) {
          view1 = view;
        } else if (n > k) {
          if (!paramBoolean)
            return view2; 
          view1 = view;
          if (view == null)
            view1 = view2; 
        } else {
          return view2;
        }  
      i--;
    } 
    return view;
  }
  
  boolean b(RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    boolean bool1 = paramState.isPreLayout();
    boolean bool = false;
    if (!bool1) {
      int i = this.f;
      if (i == -1)
        return false; 
      if (i < 0 || i >= paramState.getItemCount()) {
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        return false;
      } 
      SavedState savedState = this.A;
      if (savedState == null || savedState.a == -1 || this.A.c < 1) {
        View view = findViewByPosition(this.f);
        if (view != null) {
          if (this.e) {
            i = j();
          } else {
            i = k();
          } 
          paramAnchorInfo.a = i;
          if (this.g != Integer.MIN_VALUE) {
            if (paramAnchorInfo.c) {
              paramAnchorInfo.b = this.b.getEndAfterPadding() - this.g - this.b.getDecoratedEnd(view);
              return true;
            } 
            paramAnchorInfo.b = this.b.getStartAfterPadding() + this.g - this.b.getDecoratedStart(view);
            return true;
          } 
          if (this.b.getDecoratedMeasurement(view) > this.b.getTotalSpace()) {
            if (paramAnchorInfo.c) {
              i = this.b.getEndAfterPadding();
            } else {
              i = this.b.getStartAfterPadding();
            } 
            paramAnchorInfo.b = i;
            return true;
          } 
          i = this.b.getDecoratedStart(view) - this.b.getStartAfterPadding();
          if (i < 0) {
            paramAnchorInfo.b = -i;
            return true;
          } 
          i = this.b.getEndAfterPadding() - this.b.getDecoratedEnd(view);
          if (i < 0) {
            paramAnchorInfo.b = i;
            return true;
          } 
          paramAnchorInfo.b = Integer.MIN_VALUE;
          return true;
        } 
        paramAnchorInfo.a = this.f;
        i = this.g;
        if (i == Integer.MIN_VALUE) {
          if (j(paramAnchorInfo.a) == 1)
            bool = true; 
          paramAnchorInfo.c = bool;
          paramAnchorInfo.b();
        } else {
          paramAnchorInfo.a(i);
        } 
        paramAnchorInfo.d = true;
        return true;
      } 
      paramAnchorInfo.b = Integer.MIN_VALUE;
      paramAnchorInfo.a = this.f;
      return true;
    } 
    return false;
  }
  
  boolean c() {
    return (getLayoutDirection() == 1);
  }
  
  public boolean canScrollHorizontally() {
    return (this.j == 0);
  }
  
  public boolean canScrollVertically() {
    return (this.j == 1);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {
    if (this.j != 0)
      paramInt1 = paramInt2; 
    if (getChildCount() != 0) {
      if (paramInt1 == 0)
        return; 
      a(paramInt1, paramState);
      int[] arrayOfInt = this.G;
      if (arrayOfInt == null || arrayOfInt.length < this.i)
        this.G = new int[this.i]; 
      boolean bool = false;
      paramInt2 = 0;
      for (paramInt1 = 0; paramInt2 < this.i; paramInt1 = i) {
        if (this.l.d == -1) {
          i = this.l.f;
          j = this.a[paramInt2].a(this.l.f);
        } else {
          i = this.a[paramInt2].b(this.l.g);
          j = this.l.g;
        } 
        int j = i - j;
        int i = paramInt1;
        if (j >= 0) {
          this.G[paramInt1] = j;
          i = paramInt1 + 1;
        } 
        paramInt2++;
      } 
      Arrays.sort(this.G, 0, paramInt1);
      for (paramInt2 = bool; paramInt2 < paramInt1 && this.l.a(paramState); paramInt2++) {
        paramLayoutPrefetchRegistry.addPosition(this.l.c, this.G[paramInt2]);
        LayoutState layoutState = this.l;
        layoutState.c += this.l.d;
      } 
    } 
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState) {
    return b(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState) {
    return a(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState) {
    return c(paramState);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt) {
    paramInt = j(paramInt);
    PointF pointF = new PointF();
    if (paramInt == 0)
      return null; 
    if (this.j == 0) {
      pointF.x = paramInt;
      pointF.y = 0.0F;
      return pointF;
    } 
    pointF.x = 0.0F;
    pointF.y = paramInt;
    return pointF;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState) {
    return b(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState) {
    return a(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState) {
    return c(paramState);
  }
  
  int d() {
    View view;
    if (this.e) {
      view = b(true);
    } else {
      view = a(true);
    } 
    return (view == null) ? -1 : getPosition(view);
  }
  
  public int[] findFirstCompletelyVisibleItemPositions(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      paramArrayOfint = new int[this.i];
    } else if (paramArrayOfint.length < this.i) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
      stringBuilder.append(this.i);
      stringBuilder.append(", array size:");
      stringBuilder.append(paramArrayOfint.length);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    for (int i = 0; i < this.i; i++)
      paramArrayOfint[i] = this.a[i].findFirstCompletelyVisibleItemPosition(); 
    return paramArrayOfint;
  }
  
  public int[] findFirstVisibleItemPositions(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      paramArrayOfint = new int[this.i];
    } else if (paramArrayOfint.length < this.i) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
      stringBuilder.append(this.i);
      stringBuilder.append(", array size:");
      stringBuilder.append(paramArrayOfint.length);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    for (int i = 0; i < this.i; i++)
      paramArrayOfint[i] = this.a[i].findFirstVisibleItemPosition(); 
    return paramArrayOfint;
  }
  
  public int[] findLastCompletelyVisibleItemPositions(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      paramArrayOfint = new int[this.i];
    } else if (paramArrayOfint.length < this.i) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
      stringBuilder.append(this.i);
      stringBuilder.append(", array size:");
      stringBuilder.append(paramArrayOfint.length);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    for (int i = 0; i < this.i; i++)
      paramArrayOfint[i] = this.a[i].findLastCompletelyVisibleItemPosition(); 
    return paramArrayOfint;
  }
  
  public int[] findLastVisibleItemPositions(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      paramArrayOfint = new int[this.i];
    } else if (paramArrayOfint.length < this.i) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
      stringBuilder.append(this.i);
      stringBuilder.append(", array size:");
      stringBuilder.append(paramArrayOfint.length);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    for (int i = 0; i < this.i; i++)
      paramArrayOfint[i] = this.a[i].findLastVisibleItemPosition(); 
    return paramArrayOfint;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams() {
    return (this.j == 0) ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.j == 1) ? this.i : super.getColumnCountForAccessibility(paramRecycler, paramState);
  }
  
  public int getGapStrategy() {
    return this.n;
  }
  
  public int getOrientation() {
    return this.j;
  }
  
  public boolean getReverseLayout() {
    return this.d;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.j == 0) ? this.i : super.getRowCountForAccessibility(paramRecycler, paramState);
  }
  
  public int getSpanCount() {
    return this.i;
  }
  
  boolean h() {
    int j = this.a[0].b(-2147483648);
    for (int i = 1; i < this.i; i++) {
      if (this.a[i].b(-2147483648) != j)
        return false; 
    } 
    return true;
  }
  
  boolean i() {
    int j = this.a[0].a(-2147483648);
    for (int i = 1; i < this.i; i++) {
      if (this.a[i].a(-2147483648) != j)
        return false; 
    } 
    return true;
  }
  
  public void invalidateSpanAssignments() {
    this.h.a();
    requestLayout();
  }
  
  public boolean isAutoMeasureEnabled() {
    return (this.n != 0);
  }
  
  int j() {
    int i = getChildCount();
    return (i == 0) ? 0 : getPosition(getChildAt(i - 1));
  }
  
  int k() {
    return (getChildCount() == 0) ? 0 : getPosition(getChildAt(0));
  }
  
  public void offsetChildrenHorizontal(int paramInt) {
    super.offsetChildrenHorizontal(paramInt);
    for (int i = 0; i < this.i; i++)
      this.a[i].d(paramInt); 
  }
  
  public void offsetChildrenVertical(int paramInt) {
    super.offsetChildrenVertical(paramInt);
    for (int i = 0; i < this.i; i++)
      this.a[i].d(paramInt); 
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler) {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    removeCallbacks(this.H);
    for (int i = 0; i < this.i; i++)
      this.a[i].e(); 
    paramRecyclerView.requestLayout();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    if (getChildCount() == 0)
      return null; 
    paramView = findContainingItemView(paramView);
    if (paramView == null)
      return null; 
    m();
    int k = m(paramInt);
    if (k == Integer.MIN_VALUE)
      return null; 
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = layoutParams.b;
    Span span = layoutParams.a;
    if (k == 1) {
      paramInt = j();
    } else {
      paramInt = k();
    } 
    b(paramInt, paramState);
    b(k);
    LayoutState layoutState = this.l;
    layoutState.c = layoutState.d + paramInt;
    this.l.b = (int)(this.b.getTotalSpace() * 0.33333334F);
    layoutState = this.l;
    layoutState.h = true;
    int j = 0;
    layoutState.a = false;
    a(paramRecycler, layoutState, paramState);
    this.o = this.e;
    if (!bool1) {
      View view = span.getFocusableViewAfter(paramInt, k);
      if (view != null && view != paramView)
        return view; 
    } 
    if (i(k)) {
      int m;
      for (m = this.i - 1; m >= 0; m--) {
        View view = this.a[m].getFocusableViewAfter(paramInt, k);
        if (view != null && view != paramView)
          return view; 
      } 
    } else {
      int m;
      for (m = 0; m < this.i; m++) {
        View view = this.a[m].getFocusableViewAfter(paramInt, k);
        if (view != null && view != paramView)
          return view; 
      } 
    } 
    boolean bool2 = this.d;
    if (k == -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if ((bool2 ^ true) == paramInt) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (!bool1) {
      int m;
      if (paramInt != 0) {
        m = span.findFirstPartiallyVisibleItemPosition();
      } else {
        m = span.findLastPartiallyVisibleItemPosition();
      } 
      View view = findViewByPosition(m);
      if (view != null && view != paramView)
        return view; 
    } 
    int i = j;
    if (i(k)) {
      for (i = this.i - 1; i >= 0; i--) {
        if (i != span.e) {
          if (paramInt != 0) {
            j = this.a[i].findFirstPartiallyVisibleItemPosition();
          } else {
            j = this.a[i].findLastPartiallyVisibleItemPosition();
          } 
          View view = findViewByPosition(j);
          if (view != null && view != paramView)
            return view; 
        } 
      } 
    } else {
      while (i < this.i) {
        if (paramInt != 0) {
          j = this.a[i].findFirstPartiallyVisibleItemPosition();
        } else {
          j = this.a[i].findLastPartiallyVisibleItemPosition();
        } 
        View view = findViewByPosition(j);
        if (view != null && view != paramView)
          return view; 
        i++;
      } 
    } 
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0) {
      View view1 = a(false);
      View view2 = b(false);
      if (view1 != null) {
        if (view2 == null)
          return; 
        int i = getPosition(view1);
        int j = getPosition(view2);
        if (i < j) {
          paramAccessibilityEvent.setFromIndex(i);
          paramAccessibilityEvent.setToIndex(j);
          return;
        } 
        paramAccessibilityEvent.setFromIndex(j);
        paramAccessibilityEvent.setToIndex(i);
      } 
    } 
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    boolean bool;
    ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
    if (!(layoutParams1 instanceof LayoutParams)) {
      a(paramView, paramAccessibilityNodeInfoCompat);
      return;
    } 
    LayoutParams layoutParams = (LayoutParams)layoutParams1;
    if (this.j == 0) {
      int j = layoutParams.getSpanIndex();
      if (layoutParams.b) {
        bool = this.i;
      } else {
        bool = true;
      } 
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(j, bool, -1, -1, false, false));
      return;
    } 
    int i = layoutParams.getSpanIndex();
    if (layoutParams.b) {
      bool = this.i;
    } else {
      bool = true;
    } 
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, i, bool, false, false));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    b(paramInt1, paramInt2, 1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView) {
    this.h.a();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {
    b(paramInt1, paramInt2, 8);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    b(paramInt1, paramInt2, 2);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject) {
    b(paramInt1, paramInt2, 4);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    a(paramRecycler, paramState, true);
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState) {
    super.onLayoutCompleted(paramState);
    this.f = -1;
    this.g = Integer.MIN_VALUE;
    this.A = null;
    this.D.a();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (paramParcelable instanceof SavedState) {
      this.A = (SavedState)paramParcelable;
      requestLayout();
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = this.A;
    if (savedState != null)
      return new SavedState(savedState); 
    savedState = new SavedState();
    savedState.h = this.d;
    savedState.i = this.o;
    savedState.j = this.z;
    LazySpanLookup lazySpanLookup = this.h;
    int i = 0;
    if (lazySpanLookup != null && lazySpanLookup.a != null) {
      savedState.f = this.h.a;
      savedState.e = savedState.f.length;
      savedState.g = this.h.b;
    } else {
      savedState.e = 0;
    } 
    if (getChildCount() > 0) {
      if (this.o) {
        j = j();
      } else {
        j = k();
      } 
      savedState.a = j;
      savedState.b = d();
      int j = this.i;
      savedState.c = j;
      savedState.d = new int[j];
      while (i < this.i) {
        int k;
        if (this.o) {
          k = this.a[i].b(-2147483648);
          j = k;
          if (k != Integer.MIN_VALUE) {
            j = this.b.getEndAfterPadding();
          } else {
            continue;
          } 
        } else {
          k = this.a[i].a(-2147483648);
          j = k;
          if (k != Integer.MIN_VALUE) {
            j = this.b.getStartAfterPadding();
          } else {
            continue;
          } 
        } 
        j = k - j;
        continue;
        savedState.d[i] = j;
        i++;
      } 
    } else {
      savedState.a = -1;
      savedState.b = -1;
      savedState.c = 0;
    } 
    return savedState;
  }
  
  public void onScrollStateChanged(int paramInt) {
    if (paramInt == 0)
      a(); 
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return a(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt) {
    SavedState savedState = this.A;
    if (savedState != null && savedState.a != paramInt)
      this.A.b(); 
    this.f = paramInt;
    this.g = Integer.MIN_VALUE;
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2) {
    SavedState savedState = this.A;
    if (savedState != null)
      savedState.b(); 
    this.f = paramInt1;
    this.g = paramInt2;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return a(paramInt, paramRecycler, paramState);
  }
  
  public void setGapStrategy(int paramInt) {
    assertNotInLayoutOrScroll((String)null);
    if (paramInt == this.n)
      return; 
    if (paramInt == 0 || paramInt == 2) {
      this.n = paramInt;
      requestLayout();
      return;
    } 
    throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2) {
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.j == 1) {
      paramInt2 = chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      i = chooseSize(paramInt1, this.k * this.i + i, getMinimumWidth());
      paramInt1 = paramInt2;
      paramInt2 = i;
    } else {
      paramInt1 = chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      i = chooseSize(paramInt2, this.k * this.i + j, getMinimumHeight());
      paramInt2 = paramInt1;
      paramInt1 = i;
    } 
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setOrientation(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      assertNotInLayoutOrScroll((String)null);
      if (paramInt == this.j)
        return; 
      this.j = paramInt;
      OrientationHelper orientationHelper = this.b;
      this.b = this.c;
      this.c = orientationHelper;
      requestLayout();
      return;
    } 
    throw new IllegalArgumentException("invalid orientation.");
  }
  
  public void setReverseLayout(boolean paramBoolean) {
    assertNotInLayoutOrScroll((String)null);
    SavedState savedState = this.A;
    if (savedState != null && savedState.h != paramBoolean)
      this.A.h = paramBoolean; 
    this.d = paramBoolean;
    requestLayout();
  }
  
  public void setSpanCount(int paramInt) {
    assertNotInLayoutOrScroll((String)null);
    if (paramInt != this.i) {
      invalidateSpanAssignments();
      this.i = paramInt;
      this.m = new BitSet(this.i);
      this.a = new Span[this.i];
      for (paramInt = 0; paramInt < this.i; paramInt++)
        this.a[paramInt] = new Span(this, paramInt); 
      requestLayout();
    } 
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt) {
    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(paramRecyclerView.getContext());
    linearSmoothScroller.setTargetPosition(paramInt);
    startSmoothScroll(linearSmoothScroller);
  }
  
  public boolean supportsPredictiveItemAnimations() {
    return (this.A == null);
  }
  
  class AnchorInfo {
    int a;
    
    int b;
    
    boolean c;
    
    boolean d;
    
    boolean e;
    
    int[] f;
    
    AnchorInfo(StaggeredGridLayoutManager this$0) {
      a();
    }
    
    void a() {
      this.a = -1;
      this.b = Integer.MIN_VALUE;
      this.c = false;
      this.d = false;
      this.e = false;
      int[] arrayOfInt = this.f;
      if (arrayOfInt != null)
        Arrays.fill(arrayOfInt, -1); 
    }
    
    void a(int param1Int) {
      if (this.c) {
        this.b = this.g.b.getEndAfterPadding() - param1Int;
        return;
      } 
      this.b = this.g.b.getStartAfterPadding() + param1Int;
    }
    
    void a(StaggeredGridLayoutManager.Span[] param1ArrayOfSpan) {
      int j = param1ArrayOfSpan.length;
      int[] arrayOfInt = this.f;
      if (arrayOfInt == null || arrayOfInt.length < j)
        this.f = new int[this.g.a.length]; 
      for (int i = 0; i < j; i++)
        this.f[i] = param1ArrayOfSpan[i].a(-2147483648); 
    }
    
    void b() {
      int i;
      if (this.c) {
        i = this.g.b.getEndAfterPadding();
      } else {
        i = this.g.b.getStartAfterPadding();
      } 
      this.b = i;
    }
  }
  
  public static class LayoutParams extends RecyclerView.LayoutParams {
    public static final int INVALID_SPAN_ID = -1;
    
    StaggeredGridLayoutManager.Span a;
    
    boolean b;
    
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
    
    public final int getSpanIndex() {
      StaggeredGridLayoutManager.Span span = this.a;
      return (span == null) ? -1 : span.e;
    }
    
    public boolean isFullSpan() {
      return this.b;
    }
    
    public void setFullSpan(boolean param1Boolean) {
      this.b = param1Boolean;
    }
  }
  
  static class LazySpanLookup {
    int[] a;
    
    List<FullSpanItem> b;
    
    private void c(int param1Int1, int param1Int2) {
      List<FullSpanItem> list = this.b;
      if (list == null)
        return; 
      for (int i = list.size() - 1; i >= 0; i--) {
        FullSpanItem fullSpanItem = this.b.get(i);
        if (fullSpanItem.a >= param1Int1)
          if (fullSpanItem.a < param1Int1 + param1Int2) {
            this.b.remove(i);
          } else {
            fullSpanItem.a -= param1Int2;
          }  
      } 
    }
    
    private void d(int param1Int1, int param1Int2) {
      List<FullSpanItem> list = this.b;
      if (list == null)
        return; 
      for (int i = list.size() - 1; i >= 0; i--) {
        FullSpanItem fullSpanItem = this.b.get(i);
        if (fullSpanItem.a >= param1Int1)
          fullSpanItem.a += param1Int2; 
      } 
    }
    
    private int f(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: getfield b : Ljava/util/List;
      //   4: ifnonnull -> 9
      //   7: iconst_m1
      //   8: ireturn
      //   9: aload_0
      //   10: iload_1
      //   11: invokevirtual getFullSpanItem : (I)Landroidx/recyclerview/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
      //   14: astore #4
      //   16: aload #4
      //   18: ifnull -> 33
      //   21: aload_0
      //   22: getfield b : Ljava/util/List;
      //   25: aload #4
      //   27: invokeinterface remove : (Ljava/lang/Object;)Z
      //   32: pop
      //   33: aload_0
      //   34: getfield b : Ljava/util/List;
      //   37: invokeinterface size : ()I
      //   42: istore_3
      //   43: iconst_0
      //   44: istore_2
      //   45: iload_2
      //   46: iload_3
      //   47: if_icmpge -> 80
      //   50: aload_0
      //   51: getfield b : Ljava/util/List;
      //   54: iload_2
      //   55: invokeinterface get : (I)Ljava/lang/Object;
      //   60: checkcast androidx/recyclerview/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
      //   63: getfield a : I
      //   66: iload_1
      //   67: if_icmplt -> 73
      //   70: goto -> 82
      //   73: iload_2
      //   74: iconst_1
      //   75: iadd
      //   76: istore_2
      //   77: goto -> 45
      //   80: iconst_m1
      //   81: istore_2
      //   82: iload_2
      //   83: iconst_m1
      //   84: if_icmpeq -> 119
      //   87: aload_0
      //   88: getfield b : Ljava/util/List;
      //   91: iload_2
      //   92: invokeinterface get : (I)Ljava/lang/Object;
      //   97: checkcast androidx/recyclerview/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
      //   100: astore #4
      //   102: aload_0
      //   103: getfield b : Ljava/util/List;
      //   106: iload_2
      //   107: invokeinterface remove : (I)Ljava/lang/Object;
      //   112: pop
      //   113: aload #4
      //   115: getfield a : I
      //   118: ireturn
      //   119: iconst_m1
      //   120: ireturn
    }
    
    int a(int param1Int) {
      List<FullSpanItem> list = this.b;
      if (list != null)
        for (int i = list.size() - 1; i >= 0; i--) {
          if (((FullSpanItem)this.b.get(i)).a >= param1Int)
            this.b.remove(i); 
        }  
      return b(param1Int);
    }
    
    void a() {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null)
        Arrays.fill(arrayOfInt, -1); 
      this.b = null;
    }
    
    void a(int param1Int1, int param1Int2) {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null) {
        if (param1Int1 >= arrayOfInt.length)
          return; 
        int i = param1Int1 + param1Int2;
        e(i);
        arrayOfInt = this.a;
        System.arraycopy(arrayOfInt, i, arrayOfInt, param1Int1, arrayOfInt.length - param1Int1 - param1Int2);
        arrayOfInt = this.a;
        Arrays.fill(arrayOfInt, arrayOfInt.length - param1Int2, arrayOfInt.length, -1);
        c(param1Int1, param1Int2);
      } 
    }
    
    void a(int param1Int, StaggeredGridLayoutManager.Span param1Span) {
      e(param1Int);
      this.a[param1Int] = param1Span.e;
    }
    
    public void addFullSpanItem(FullSpanItem param1FullSpanItem) {
      if (this.b == null)
        this.b = new ArrayList<FullSpanItem>(); 
      int j = this.b.size();
      for (int i = 0; i < j; i++) {
        FullSpanItem fullSpanItem = this.b.get(i);
        if (fullSpanItem.a == param1FullSpanItem.a)
          this.b.remove(i); 
        if (fullSpanItem.a >= param1FullSpanItem.a) {
          this.b.add(i, param1FullSpanItem);
          return;
        } 
      } 
      this.b.add(param1FullSpanItem);
    }
    
    int b(int param1Int) {
      int[] arrayOfInt = this.a;
      if (arrayOfInt == null)
        return -1; 
      if (param1Int >= arrayOfInt.length)
        return -1; 
      int i = f(param1Int);
      if (i == -1) {
        arrayOfInt = this.a;
        Arrays.fill(arrayOfInt, param1Int, arrayOfInt.length, -1);
        return this.a.length;
      } 
      arrayOfInt = this.a;
      Arrays.fill(arrayOfInt, param1Int, ++i, -1);
      return i;
    }
    
    void b(int param1Int1, int param1Int2) {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null) {
        if (param1Int1 >= arrayOfInt.length)
          return; 
        int i = param1Int1 + param1Int2;
        e(i);
        arrayOfInt = this.a;
        System.arraycopy(arrayOfInt, param1Int1, arrayOfInt, i, arrayOfInt.length - param1Int1 - param1Int2);
        Arrays.fill(this.a, param1Int1, i, -1);
        d(param1Int1, param1Int2);
      } 
    }
    
    int c(int param1Int) {
      int[] arrayOfInt = this.a;
      return (arrayOfInt == null || param1Int >= arrayOfInt.length) ? -1 : arrayOfInt[param1Int];
    }
    
    int d(int param1Int) {
      int i;
      for (i = this.a.length; i <= param1Int; i *= 2);
      return i;
    }
    
    void e(int param1Int) {
      int[] arrayOfInt = this.a;
      if (arrayOfInt == null) {
        this.a = new int[Math.max(param1Int, 10) + 1];
        Arrays.fill(this.a, -1);
        return;
      } 
      if (param1Int >= arrayOfInt.length) {
        this.a = new int[d(param1Int)];
        System.arraycopy(arrayOfInt, 0, this.a, 0, arrayOfInt.length);
        int[] arrayOfInt1 = this.a;
        Arrays.fill(arrayOfInt1, arrayOfInt.length, arrayOfInt1.length, -1);
      } 
    }
    
    public FullSpanItem getFirstFullSpanItemInRange(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      List<FullSpanItem> list = this.b;
      if (list == null)
        return null; 
      int j = list.size();
      int i;
      for (i = 0; i < j; i++) {
        FullSpanItem fullSpanItem = this.b.get(i);
        if (fullSpanItem.a >= param1Int2)
          return null; 
        if (fullSpanItem.a >= param1Int1 && (param1Int3 == 0 || fullSpanItem.b == param1Int3 || (param1Boolean && fullSpanItem.d)))
          return fullSpanItem; 
      } 
      return null;
    }
    
    public FullSpanItem getFullSpanItem(int param1Int) {
      List<FullSpanItem> list = this.b;
      if (list == null)
        return null; 
      for (int i = list.size() - 1; i >= 0; i--) {
        FullSpanItem fullSpanItem = this.b.get(i);
        if (fullSpanItem.a == param1Int)
          return fullSpanItem; 
      } 
      return null;
    }
    
    static class FullSpanItem implements Parcelable {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
          public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel param3Parcel) {
            return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(param3Parcel);
          }
          
          public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int param3Int) {
            return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[param3Int];
          }
        };
      
      int a;
      
      int b;
      
      int[] c;
      
      boolean d;
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel param2Parcel) {
        this.a = param2Parcel.readInt();
        this.b = param2Parcel.readInt();
        int i = param2Parcel.readInt();
        boolean bool = true;
        if (i != 1)
          bool = false; 
        this.d = bool;
        i = param2Parcel.readInt();
        if (i > 0) {
          this.c = new int[i];
          param2Parcel.readIntArray(this.c);
        } 
      }
      
      int a(int param2Int) {
        int[] arrayOfInt = this.c;
        return (arrayOfInt == null) ? 0 : arrayOfInt[param2Int];
      }
      
      public int describeContents() {
        return 0;
      }
      
      public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FullSpanItem{mPosition=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mGapDir=");
        stringBuilder.append(this.b);
        stringBuilder.append(", mHasUnwantedGapAfter=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mGapPerSpan=");
        stringBuilder.append(Arrays.toString(this.c));
        stringBuilder.append('}');
        return stringBuilder.toString();
      }
      
      public void writeToParcel(Parcel param2Parcel, int param2Int) {
        throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
    }
    
    static final class null implements Parcelable.Creator<FullSpanItem> {
      public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel param2Parcel) {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(param2Parcel);
      }
      
      public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int param2Int) {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[param2Int];
      }
    }
  }
  
  static class FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel param3Parcel) {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(param3Parcel);
        }
        
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int param3Int) {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[param3Int];
        }
      };
    
    int a;
    
    int b;
    
    int[] c;
    
    boolean d;
    
    FullSpanItem() {}
    
    FullSpanItem(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.d = bool;
      i = param1Parcel.readInt();
      if (i > 0) {
        this.c = new int[i];
        param1Parcel.readIntArray(this.c);
      } 
    }
    
    int a(int param1Int) {
      int[] arrayOfInt = this.c;
      return (arrayOfInt == null) ? 0 : arrayOfInt[param1Int];
    }
    
    public int describeContents() {
      return 0;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FullSpanItem{mPosition=");
      stringBuilder.append(this.a);
      stringBuilder.append(", mGapDir=");
      stringBuilder.append(this.b);
      stringBuilder.append(", mHasUnwantedGapAfter=");
      stringBuilder.append(this.d);
      stringBuilder.append(", mGapPerSpan=");
      stringBuilder.append(Arrays.toString(this.c));
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.Creator<LazySpanLookup.FullSpanItem> {
    public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel param1Parcel) {
      return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(param1Parcel);
    }
    
    public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int param1Int) {
      return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[param1Int];
    }
  }
  
  public static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel param2Parcel) {
          return new StaggeredGridLayoutManager.SavedState(param2Parcel);
        }
        
        public StaggeredGridLayoutManager.SavedState[] newArray(int param2Int) {
          return new StaggeredGridLayoutManager.SavedState[param2Int];
        }
      };
    
    int a;
    
    int b;
    
    int c;
    
    int[] d;
    
    int e;
    
    int[] f;
    
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> g;
    
    boolean h;
    
    boolean i;
    
    boolean j;
    
    public SavedState() {}
    
    SavedState(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readInt();
      int i = this.c;
      if (i > 0) {
        this.d = new int[i];
        param1Parcel.readIntArray(this.d);
      } 
      this.e = param1Parcel.readInt();
      i = this.e;
      if (i > 0) {
        this.f = new int[i];
        param1Parcel.readIntArray(this.f);
      } 
      i = param1Parcel.readInt();
      boolean bool2 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.h = bool1;
      if (param1Parcel.readInt() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.i = bool1;
      boolean bool1 = bool2;
      if (param1Parcel.readInt() == 1)
        bool1 = true; 
      this.j = bool1;
      this.g = param1Parcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
    }
    
    public SavedState(SavedState param1SavedState) {
      this.c = param1SavedState.c;
      this.a = param1SavedState.a;
      this.b = param1SavedState.b;
      this.d = param1SavedState.d;
      this.e = param1SavedState.e;
      this.f = param1SavedState.f;
      this.h = param1SavedState.h;
      this.i = param1SavedState.i;
      this.j = param1SavedState.j;
      this.g = param1SavedState.g;
    }
    
    void a() {
      this.d = null;
      this.c = 0;
      this.e = 0;
      this.f = null;
      this.g = null;
    }
    
    void b() {
      this.d = null;
      this.c = 0;
      this.a = -1;
      this.b = -1;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel param1Parcel) {
      return new StaggeredGridLayoutManager.SavedState(param1Parcel);
    }
    
    public StaggeredGridLayoutManager.SavedState[] newArray(int param1Int) {
      return new StaggeredGridLayoutManager.SavedState[param1Int];
    }
  }
  
  class Span {
    ArrayList<View> a = new ArrayList<View>();
    
    int b = Integer.MIN_VALUE;
    
    int c = Integer.MIN_VALUE;
    
    int d = 0;
    
    final int e;
    
    Span(StaggeredGridLayoutManager this$0, int param1Int) {
      this.e = param1Int;
    }
    
    int a(int param1Int) {
      int i = this.b;
      if (i != Integer.MIN_VALUE)
        return i; 
      if (this.a.size() == 0)
        return param1Int; 
      a();
      return this.b;
    }
    
    int a(int param1Int1, int param1Int2, boolean param1Boolean) {
      return a(param1Int1, param1Int2, param1Boolean, true, false);
    }
    
    int a(int param1Int1, int param1Int2, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3) {
      byte b;
      int i = this.f.b.getStartAfterPadding();
      int j = this.f.b.getEndAfterPadding();
      if (param1Int2 > param1Int1) {
        b = 1;
      } else {
        b = -1;
      } 
      while (param1Int1 != param1Int2) {
        boolean bool1;
        View view = this.a.get(param1Int1);
        int k = this.f.b.getDecoratedStart(view);
        int m = this.f.b.getDecoratedEnd(view);
        boolean bool2 = false;
        if (param1Boolean3 ? (k <= j) : (k < j)) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (param1Boolean3 ? (m >= i) : (m > i))
          bool2 = true; 
        if (bool1 && bool2)
          if (param1Boolean1 && param1Boolean2) {
            if (k >= i && m <= j)
              return this.f.getPosition(view); 
          } else {
            if (param1Boolean2)
              return this.f.getPosition(view); 
            if (k < i || m > j)
              return this.f.getPosition(view); 
          }  
        param1Int1 += b;
      } 
      return -1;
    }
    
    void a() {
      View view = this.a.get(0);
      StaggeredGridLayoutManager.LayoutParams layoutParams = c(view);
      this.b = this.f.b.getDecoratedStart(view);
      if (layoutParams.b) {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = this.f.h.getFullSpanItem(layoutParams.getViewLayoutPosition());
        if (fullSpanItem != null && fullSpanItem.b == -1)
          this.b -= fullSpanItem.a(this.e); 
      } 
    }
    
    void a(View param1View) {
      StaggeredGridLayoutManager.LayoutParams layoutParams = c(param1View);
      layoutParams.a = this;
      this.a.add(0, param1View);
      this.b = Integer.MIN_VALUE;
      if (this.a.size() == 1)
        this.c = Integer.MIN_VALUE; 
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        this.d += this.f.b.getDecoratedMeasurement(param1View); 
    }
    
    void a(boolean param1Boolean, int param1Int) {
      int i;
      if (param1Boolean) {
        i = b(-2147483648);
      } else {
        i = a(-2147483648);
      } 
      e();
      if (i == Integer.MIN_VALUE)
        return; 
      if ((param1Boolean && i < this.f.b.getEndAfterPadding()) || (!param1Boolean && i > this.f.b.getStartAfterPadding()))
        return; 
      int j = i;
      if (param1Int != Integer.MIN_VALUE)
        j = i + param1Int; 
      this.c = j;
      this.b = j;
    }
    
    int b() {
      int i = this.b;
      if (i != Integer.MIN_VALUE)
        return i; 
      a();
      return this.b;
    }
    
    int b(int param1Int) {
      int i = this.c;
      if (i != Integer.MIN_VALUE)
        return i; 
      if (this.a.size() == 0)
        return param1Int; 
      c();
      return this.c;
    }
    
    int b(int param1Int1, int param1Int2, boolean param1Boolean) {
      return a(param1Int1, param1Int2, false, false, param1Boolean);
    }
    
    void b(View param1View) {
      StaggeredGridLayoutManager.LayoutParams layoutParams = c(param1View);
      layoutParams.a = this;
      this.a.add(param1View);
      this.c = Integer.MIN_VALUE;
      if (this.a.size() == 1)
        this.b = Integer.MIN_VALUE; 
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        this.d += this.f.b.getDecoratedMeasurement(param1View); 
    }
    
    StaggeredGridLayoutManager.LayoutParams c(View param1View) {
      return (StaggeredGridLayoutManager.LayoutParams)param1View.getLayoutParams();
    }
    
    void c() {
      ArrayList<View> arrayList = this.a;
      View view = arrayList.get(arrayList.size() - 1);
      StaggeredGridLayoutManager.LayoutParams layoutParams = c(view);
      this.c = this.f.b.getDecoratedEnd(view);
      if (layoutParams.b) {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = this.f.h.getFullSpanItem(layoutParams.getViewLayoutPosition());
        if (fullSpanItem != null && fullSpanItem.b == 1)
          this.c += fullSpanItem.a(this.e); 
      } 
    }
    
    void c(int param1Int) {
      this.b = param1Int;
      this.c = param1Int;
    }
    
    int d() {
      int i = this.c;
      if (i != Integer.MIN_VALUE)
        return i; 
      c();
      return this.c;
    }
    
    void d(int param1Int) {
      int i = this.b;
      if (i != Integer.MIN_VALUE)
        this.b = i + param1Int; 
      i = this.c;
      if (i != Integer.MIN_VALUE)
        this.c = i + param1Int; 
    }
    
    void e() {
      this.a.clear();
      f();
      this.d = 0;
    }
    
    void f() {
      this.b = Integer.MIN_VALUE;
      this.c = Integer.MIN_VALUE;
    }
    
    public int findFirstCompletelyVisibleItemPosition() {
      return this.f.d ? a(this.a.size() - 1, -1, true) : a(0, this.a.size(), true);
    }
    
    public int findFirstPartiallyVisibleItemPosition() {
      return this.f.d ? b(this.a.size() - 1, -1, true) : b(0, this.a.size(), true);
    }
    
    public int findFirstVisibleItemPosition() {
      return this.f.d ? a(this.a.size() - 1, -1, false) : a(0, this.a.size(), false);
    }
    
    public int findLastCompletelyVisibleItemPosition() {
      return this.f.d ? a(0, this.a.size(), true) : a(this.a.size() - 1, -1, true);
    }
    
    public int findLastPartiallyVisibleItemPosition() {
      return this.f.d ? b(0, this.a.size(), true) : b(this.a.size() - 1, -1, true);
    }
    
    public int findLastVisibleItemPosition() {
      return this.f.d ? a(0, this.a.size(), false) : a(this.a.size() - 1, -1, false);
    }
    
    void g() {
      int i = this.a.size();
      View view = this.a.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams layoutParams = c(view);
      layoutParams.a = null;
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        this.d -= this.f.b.getDecoratedMeasurement(view); 
      if (i == 1)
        this.b = Integer.MIN_VALUE; 
      this.c = Integer.MIN_VALUE;
    }
    
    public int getDeletedSize() {
      return this.d;
    }
    
    public View getFocusableViewAfter(int param1Int1, int param1Int2) {
      // Byte code:
      //   0: aconst_null
      //   1: astore #5
      //   3: aconst_null
      //   4: astore #4
      //   6: iload_2
      //   7: iconst_m1
      //   8: if_icmpne -> 119
      //   11: aload_0
      //   12: getfield a : Ljava/util/ArrayList;
      //   15: invokevirtual size : ()I
      //   18: istore_3
      //   19: iconst_0
      //   20: istore_2
      //   21: aload #4
      //   23: astore #5
      //   25: iload_2
      //   26: iload_3
      //   27: if_icmpge -> 230
      //   30: aload_0
      //   31: getfield a : Ljava/util/ArrayList;
      //   34: iload_2
      //   35: invokevirtual get : (I)Ljava/lang/Object;
      //   38: checkcast android/view/View
      //   41: astore #6
      //   43: aload_0
      //   44: getfield f : Landroidx/recyclerview/widget/StaggeredGridLayoutManager;
      //   47: getfield d : Z
      //   50: ifeq -> 70
      //   53: aload #4
      //   55: astore #5
      //   57: aload_0
      //   58: getfield f : Landroidx/recyclerview/widget/StaggeredGridLayoutManager;
      //   61: aload #6
      //   63: invokevirtual getPosition : (Landroid/view/View;)I
      //   66: iload_1
      //   67: if_icmple -> 230
      //   70: aload_0
      //   71: getfield f : Landroidx/recyclerview/widget/StaggeredGridLayoutManager;
      //   74: getfield d : Z
      //   77: ifne -> 96
      //   80: aload_0
      //   81: getfield f : Landroidx/recyclerview/widget/StaggeredGridLayoutManager;
      //   84: aload #6
      //   86: invokevirtual getPosition : (Landroid/view/View;)I
      //   89: iload_1
      //   90: if_icmplt -> 96
      //   93: aload #4
      //   95: areturn
      //   96: aload #4
      //   98: astore #5
      //   100: aload #6
      //   102: invokevirtual hasFocusable : ()Z
      //   105: ifeq -> 230
      //   108: iload_2
      //   109: iconst_1
      //   110: iadd
      //   111: istore_2
      //   112: aload #6
      //   114: astore #4
      //   116: goto -> 21
      //   119: aload_0
      //   120: getfield a : Ljava/util/ArrayList;
      //   123: invokevirtual size : ()I
      //   126: iconst_1
      //   127: isub
      //   128: istore_2
      //   129: aload #5
      //   131: astore #4
      //   133: aload #4
      //   135: astore #5
      //   137: iload_2
      //   138: iflt -> 230
      //   141: aload_0
      //   142: getfield a : Ljava/util/ArrayList;
      //   145: iload_2
      //   146: invokevirtual get : (I)Ljava/lang/Object;
      //   149: checkcast android/view/View
      //   152: astore #6
      //   154: aload_0
      //   155: getfield f : Landroidx/recyclerview/widget/StaggeredGridLayoutManager;
      //   158: getfield d : Z
      //   161: ifeq -> 181
      //   164: aload #4
      //   166: astore #5
      //   168: aload_0
      //   169: getfield f : Landroidx/recyclerview/widget/StaggeredGridLayoutManager;
      //   172: aload #6
      //   174: invokevirtual getPosition : (Landroid/view/View;)I
      //   177: iload_1
      //   178: if_icmpge -> 230
      //   181: aload_0
      //   182: getfield f : Landroidx/recyclerview/widget/StaggeredGridLayoutManager;
      //   185: getfield d : Z
      //   188: ifne -> 207
      //   191: aload_0
      //   192: getfield f : Landroidx/recyclerview/widget/StaggeredGridLayoutManager;
      //   195: aload #6
      //   197: invokevirtual getPosition : (Landroid/view/View;)I
      //   200: iload_1
      //   201: if_icmpgt -> 207
      //   204: aload #4
      //   206: areturn
      //   207: aload #4
      //   209: astore #5
      //   211: aload #6
      //   213: invokevirtual hasFocusable : ()Z
      //   216: ifeq -> 230
      //   219: iload_2
      //   220: iconst_1
      //   221: isub
      //   222: istore_2
      //   223: aload #6
      //   225: astore #4
      //   227: goto -> 133
      //   230: aload #5
      //   232: areturn
    }
    
    void h() {
      View view = this.a.remove(0);
      StaggeredGridLayoutManager.LayoutParams layoutParams = c(view);
      layoutParams.a = null;
      if (this.a.size() == 0)
        this.c = Integer.MIN_VALUE; 
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        this.d -= this.f.b.getDecoratedMeasurement(view); 
      this.b = Integer.MIN_VALUE;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\StaggeredGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */