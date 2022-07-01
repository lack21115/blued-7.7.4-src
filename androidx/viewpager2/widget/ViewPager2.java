package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import androidx.viewpager2.adapter.StatefulAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ViewPager2 extends ViewGroup {
  public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
  
  public static final int ORIENTATION_HORIZONTAL = 0;
  
  public static final int ORIENTATION_VERTICAL = 1;
  
  public static final int SCROLL_STATE_DRAGGING = 1;
  
  public static final int SCROLL_STATE_IDLE = 0;
  
  public static final int SCROLL_STATE_SETTLING = 2;
  
  static boolean a = true;
  
  int b;
  
  boolean c = false;
  
  RecyclerView d;
  
  ScrollEventAdapter e;
  
  AccessibilityProvider f;
  
  private final Rect g = new Rect();
  
  private final Rect h = new Rect();
  
  private CompositeOnPageChangeCallback i = new CompositeOnPageChangeCallback(3);
  
  private RecyclerView.AdapterDataObserver j = new DataSetChangeObserver(this) {
      public void onChanged() {
        ViewPager2 viewPager2 = this.a;
        viewPager2.c = true;
        viewPager2.e.a();
      }
    };
  
  private LinearLayoutManager k;
  
  private int l = -1;
  
  private Parcelable m;
  
  private PagerSnapHelper n;
  
  private CompositeOnPageChangeCallback o;
  
  private FakeDrag p;
  
  private PageTransformerAdapter q;
  
  private RecyclerView.ItemAnimator r = null;
  
  private boolean s = false;
  
  private boolean t = true;
  
  private int u = -1;
  
  public ViewPager2(Context paramContext) {
    super(paramContext);
    a(paramContext, (AttributeSet)null);
  }
  
  public ViewPager2(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ViewPager2(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public ViewPager2(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    BasicAccessibilityProvider basicAccessibilityProvider;
    if (a) {
      PageAwareAccessibilityProvider pageAwareAccessibilityProvider = new PageAwareAccessibilityProvider(this);
    } else {
      basicAccessibilityProvider = new BasicAccessibilityProvider(this);
    } 
    this.f = basicAccessibilityProvider;
    this.d = new RecyclerViewImpl(this, paramContext);
    this.d.setId(ViewCompat.generateViewId());
    this.d.setDescendantFocusability(131072);
    this.k = new LinearLayoutManagerImpl(this, paramContext);
    this.d.setLayoutManager((RecyclerView.LayoutManager)this.k);
    this.d.setScrollingTouchSlop(1);
    b(paramContext, paramAttributeSet);
    this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.d.addOnChildAttachStateChangeListener(d());
    this.e = new ScrollEventAdapter(this);
    this.p = new FakeDrag(this, this.e, this.d);
    this.n = new PagerSnapHelperImpl(this);
    this.n.attachToRecyclerView(this.d);
    this.d.addOnScrollListener(this.e);
    this.o = new CompositeOnPageChangeCallback(3);
    this.e.a(this.o);
    OnPageChangeCallback onPageChangeCallback1 = new OnPageChangeCallback(this) {
        public void onPageScrollStateChanged(int param1Int) {
          if (param1Int == 0)
            this.a.a(); 
        }
        
        public void onPageSelected(int param1Int) {
          if (this.a.b != param1Int) {
            ViewPager2 viewPager2 = this.a;
            viewPager2.b = param1Int;
            viewPager2.f.onSetNewCurrentItem();
          } 
        }
      };
    OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback(this) {
        public void onPageSelected(int param1Int) {
          this.a.clearFocus();
          if (this.a.hasFocus())
            this.a.d.requestFocus(2); 
        }
      };
    this.o.a(onPageChangeCallback1);
    this.o.a(onPageChangeCallback2);
    this.f.onInitialize(this.o, this.d);
    this.o.a(this.i);
    this.q = new PageTransformerAdapter(this.k);
    this.o.a(this.q);
    RecyclerView recyclerView = this.d;
    attachViewToParent((View)recyclerView, 0, recyclerView.getLayoutParams());
  }
  
  private void a(RecyclerView.Adapter<?> paramAdapter) {
    if (paramAdapter != null)
      paramAdapter.registerAdapterDataObserver(this.j); 
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPager2);
    if (Build.VERSION.SDK_INT >= 29)
      saveAttributeDataForStyleable(paramContext, R.styleable.ViewPager2, paramAttributeSet, typedArray, 0, 0); 
    try {
      setOrientation(typedArray.getInt(R.styleable.ViewPager2_android_orientation, 0));
      return;
    } finally {
      typedArray.recycle();
    } 
  }
  
  private void b(RecyclerView.Adapter<?> paramAdapter) {
    if (paramAdapter != null)
      paramAdapter.unregisterAdapterDataObserver(this.j); 
  }
  
  private RecyclerView.OnChildAttachStateChangeListener d() {
    return new RecyclerView.OnChildAttachStateChangeListener(this) {
        public void onChildViewAttachedToWindow(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          if (layoutParams.width == -1 && layoutParams.height == -1)
            return; 
          throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
        
        public void onChildViewDetachedFromWindow(View param1View) {}
      };
  }
  
  private void e() {
    if (this.l == -1)
      return; 
    RecyclerView.Adapter adapter = getAdapter();
    if (adapter == null)
      return; 
    Parcelable parcelable = this.m;
    if (parcelable != null) {
      if (adapter instanceof StatefulAdapter)
        ((StatefulAdapter)adapter).restoreState(parcelable); 
      this.m = null;
    } 
    this.b = Math.max(0, Math.min(this.l, adapter.getItemCount() - 1));
    this.l = -1;
    this.d.scrollToPosition(this.b);
    this.f.onRestorePendingState();
  }
  
  void a() {
    PagerSnapHelper pagerSnapHelper = this.n;
    if (pagerSnapHelper != null) {
      View view = pagerSnapHelper.findSnapView((RecyclerView.LayoutManager)this.k);
      if (view == null)
        return; 
      int i = this.k.getPosition(view);
      if (i != this.b && getScrollState() == 0)
        this.o.onPageSelected(i); 
      this.c = false;
      return;
    } 
    throw new IllegalStateException("Design assumption violated.");
  }
  
  void a(int paramInt, boolean paramBoolean) {
    RecyclerView.Adapter adapter = getAdapter();
    if (adapter == null) {
      if (this.l != -1)
        this.l = Math.max(paramInt, 0); 
      return;
    } 
    if (adapter.getItemCount() <= 0)
      return; 
    int i = Math.min(Math.max(paramInt, 0), adapter.getItemCount() - 1);
    if (i == this.b && this.e.e())
      return; 
    if (i == this.b && paramBoolean)
      return; 
    double d1 = this.b;
    this.b = i;
    this.f.onSetNewCurrentItem();
    if (!this.e.e())
      d1 = this.e.h(); 
    this.e.a(i, paramBoolean);
    if (!paramBoolean) {
      this.d.scrollToPosition(i);
      return;
    } 
    double d2 = i;
    if (Math.abs(d2 - d1) > 3.0D) {
      RecyclerView recyclerView = this.d;
      if (d2 > d1) {
        paramInt = i - 3;
      } else {
        paramInt = i + 3;
      } 
      recyclerView.scrollToPosition(paramInt);
      recyclerView = this.d;
      recyclerView.post(new SmoothScrollToPosition(i, recyclerView));
      return;
    } 
    this.d.smoothScrollToPosition(i);
  }
  
  public void addItemDecoration(RecyclerView.ItemDecoration paramItemDecoration) {
    this.d.addItemDecoration(paramItemDecoration);
  }
  
  public void addItemDecoration(RecyclerView.ItemDecoration paramItemDecoration, int paramInt) {
    this.d.addItemDecoration(paramItemDecoration, paramInt);
  }
  
  boolean b() {
    return (this.k.getLayoutDirection() == 1);
  }
  
  public boolean beginFakeDrag() {
    return this.p.b();
  }
  
  void c() {
    View view = this.n.findSnapView((RecyclerView.LayoutManager)this.k);
    if (view == null)
      return; 
    int[] arrayOfInt = this.n.calculateDistanceToFinalSnap((RecyclerView.LayoutManager)this.k, view);
    if (arrayOfInt[0] != 0 || arrayOfInt[1] != 0)
      this.d.smoothScrollBy(arrayOfInt[0], arrayOfInt[1]); 
  }
  
  public boolean canScrollHorizontally(int paramInt) {
    return this.d.canScrollHorizontally(paramInt);
  }
  
  public boolean canScrollVertically(int paramInt) {
    return this.d.canScrollVertically(paramInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
    Parcelable parcelable = (Parcelable)paramSparseArray.get(getId());
    if (parcelable instanceof SavedState) {
      int i = ((SavedState)parcelable).a;
      paramSparseArray.put(this.d.getId(), paramSparseArray.get(i));
      paramSparseArray.remove(i);
    } 
    super.dispatchRestoreInstanceState(paramSparseArray);
    e();
  }
  
  public boolean endFakeDrag() {
    return this.p.c();
  }
  
  public boolean fakeDragBy(float paramFloat) {
    return this.p.a(paramFloat);
  }
  
  public CharSequence getAccessibilityClassName() {
    return this.f.handlesGetAccessibilityClassName() ? this.f.onGetAccessibilityClassName() : super.getAccessibilityClassName();
  }
  
  public RecyclerView.Adapter getAdapter() {
    return this.d.getAdapter();
  }
  
  public int getCurrentItem() {
    return this.b;
  }
  
  public RecyclerView.ItemDecoration getItemDecorationAt(int paramInt) {
    return this.d.getItemDecorationAt(paramInt);
  }
  
  public int getItemDecorationCount() {
    return this.d.getItemDecorationCount();
  }
  
  public int getOffscreenPageLimit() {
    return this.u;
  }
  
  public int getOrientation() {
    return this.k.getOrientation();
  }
  
  int getPageSize() {
    int i;
    int j;
    RecyclerView recyclerView = this.d;
    if (getOrientation() == 0) {
      j = recyclerView.getWidth() - recyclerView.getPaddingLeft();
      i = recyclerView.getPaddingRight();
    } else {
      j = recyclerView.getHeight() - recyclerView.getPaddingTop();
      i = recyclerView.getPaddingBottom();
    } 
    return j - i;
  }
  
  public int getScrollState() {
    return this.e.d();
  }
  
  public void invalidateItemDecorations() {
    this.d.invalidateItemDecorations();
  }
  
  public boolean isFakeDragging() {
    return this.p.a();
  }
  
  public boolean isUserInputEnabled() {
    return this.t;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    this.f.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = this.d.getMeasuredWidth();
    int j = this.d.getMeasuredHeight();
    this.g.left = getPaddingLeft();
    this.g.right = paramInt3 - paramInt1 - getPaddingRight();
    this.g.top = getPaddingTop();
    this.g.bottom = paramInt4 - paramInt2 - getPaddingBottom();
    Gravity.apply(8388659, i, j, this.g, this.h);
    this.d.layout(this.h.left, this.h.top, this.h.right, this.h.bottom);
    if (this.c)
      a(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    measureChild((View)this.d, paramInt1, paramInt2);
    int n = this.d.getMeasuredWidth();
    int j = this.d.getMeasuredHeight();
    int i = this.d.getMeasuredState();
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    n = Math.max(n + i1 + i2, getSuggestedMinimumWidth());
    j = Math.max(j + k + m, getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSizeAndState(n, paramInt1, i), resolveSizeAndState(j, paramInt2, i << 16));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.l = savedState.b;
    this.m = savedState.c;
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.d.getId();
    int j = this.l;
    int i = j;
    if (j == -1)
      i = this.b; 
    savedState.b = i;
    Parcelable parcelable = this.m;
    if (parcelable != null) {
      savedState.c = parcelable;
      return (Parcelable)savedState;
    } 
    RecyclerView.Adapter adapter = this.d.getAdapter();
    if (adapter instanceof StatefulAdapter)
      savedState.c = ((StatefulAdapter)adapter).saveState(); 
    return (Parcelable)savedState;
  }
  
  public void onViewAdded(View paramView) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(" does not support direct child views");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle) {
    return this.f.handlesPerformAccessibilityAction(paramInt, paramBundle) ? this.f.onPerformAccessibilityAction(paramInt, paramBundle) : super.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public void registerOnPageChangeCallback(OnPageChangeCallback paramOnPageChangeCallback) {
    this.i.a(paramOnPageChangeCallback);
  }
  
  public void removeItemDecoration(RecyclerView.ItemDecoration paramItemDecoration) {
    this.d.removeItemDecoration(paramItemDecoration);
  }
  
  public void removeItemDecorationAt(int paramInt) {
    this.d.removeItemDecorationAt(paramInt);
  }
  
  public void requestTransform() {
    if (this.q.a() == null)
      return; 
    double d = this.e.h();
    int i = (int)d;
    float f = (float)(d - i);
    int j = Math.round(getPageSize() * f);
    this.q.onPageScrolled(i, f, j);
  }
  
  public void setAdapter(RecyclerView.Adapter<?> paramAdapter) {
    RecyclerView.Adapter<?> adapter = this.d.getAdapter();
    this.f.onDetachAdapter(adapter);
    b(adapter);
    this.d.setAdapter(paramAdapter);
    this.b = 0;
    e();
    this.f.onAttachAdapter(paramAdapter);
    a(paramAdapter);
  }
  
  public void setCurrentItem(int paramInt) {
    setCurrentItem(paramInt, true);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean) {
    if (!isFakeDragging()) {
      a(paramInt, paramBoolean);
      return;
    } 
    throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
  }
  
  public void setLayoutDirection(int paramInt) {
    super.setLayoutDirection(paramInt);
    this.f.onSetLayoutDirection();
  }
  
  public void setOffscreenPageLimit(int paramInt) {
    if (paramInt >= 1 || paramInt == -1) {
      this.u = paramInt;
      this.d.requestLayout();
      return;
    } 
    throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
  }
  
  public void setOrientation(int paramInt) {
    this.k.setOrientation(paramInt);
    this.f.onSetOrientation();
  }
  
  public void setPageTransformer(PageTransformer paramPageTransformer) {
    if (paramPageTransformer != null) {
      if (!this.s) {
        this.r = this.d.getItemAnimator();
        this.s = true;
      } 
      this.d.setItemAnimator(null);
    } else if (this.s) {
      this.d.setItemAnimator(this.r);
      this.r = null;
      this.s = false;
    } 
    if (paramPageTransformer == this.q.a())
      return; 
    this.q.a(paramPageTransformer);
    requestTransform();
  }
  
  public void setUserInputEnabled(boolean paramBoolean) {
    this.t = paramBoolean;
    this.f.onSetUserInputEnabled();
  }
  
  public void unregisterOnPageChangeCallback(OnPageChangeCallback paramOnPageChangeCallback) {
    this.i.b(paramOnPageChangeCallback);
  }
  
  abstract class AccessibilityProvider {
    private AccessibilityProvider(ViewPager2 this$0) {}
    
    boolean handlesGetAccessibilityClassName() {
      return false;
    }
    
    boolean handlesLmPerformAccessibilityAction(int param1Int) {
      return false;
    }
    
    boolean handlesPerformAccessibilityAction(int param1Int, Bundle param1Bundle) {
      return false;
    }
    
    boolean handlesRvGetAccessibilityClassName() {
      return false;
    }
    
    void onAttachAdapter(RecyclerView.Adapter<?> param1Adapter) {}
    
    void onDetachAdapter(RecyclerView.Adapter<?> param1Adapter) {}
    
    String onGetAccessibilityClassName() {
      throw new IllegalStateException("Not implemented.");
    }
    
    void onInitialize(CompositeOnPageChangeCallback param1CompositeOnPageChangeCallback, RecyclerView param1RecyclerView) {}
    
    void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo param1AccessibilityNodeInfo) {}
    
    void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {}
    
    boolean onLmPerformAccessibilityAction(int param1Int) {
      throw new IllegalStateException("Not implemented.");
    }
    
    boolean onPerformAccessibilityAction(int param1Int, Bundle param1Bundle) {
      throw new IllegalStateException("Not implemented.");
    }
    
    void onRestorePendingState() {}
    
    CharSequence onRvGetAccessibilityClassName() {
      throw new IllegalStateException("Not implemented.");
    }
    
    void onRvInitializeAccessibilityEvent(AccessibilityEvent param1AccessibilityEvent) {}
    
    void onSetLayoutDirection() {}
    
    void onSetNewCurrentItem() {}
    
    void onSetOrientation() {}
    
    void onSetUserInputEnabled() {}
  }
  
  class BasicAccessibilityProvider extends AccessibilityProvider {
    BasicAccessibilityProvider(ViewPager2 this$0) {
      super(this$0);
    }
    
    public boolean handlesLmPerformAccessibilityAction(int param1Int) {
      return ((param1Int == 8192 || param1Int == 4096) && !this.b.isUserInputEnabled());
    }
    
    public boolean handlesRvGetAccessibilityClassName() {
      return true;
    }
    
    public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      if (!this.b.isUserInputEnabled()) {
        param1AccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
        param1AccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
        param1AccessibilityNodeInfoCompat.setScrollable(false);
      } 
    }
    
    public boolean onLmPerformAccessibilityAction(int param1Int) {
      if (handlesLmPerformAccessibilityAction(param1Int))
        return false; 
      throw new IllegalStateException();
    }
    
    public CharSequence onRvGetAccessibilityClassName() {
      if (handlesRvGetAccessibilityClassName())
        return "androidx.viewpager.widget.ViewPager"; 
      throw new IllegalStateException();
    }
  }
  
  static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
    private DataSetChangeObserver() {}
    
    public abstract void onChanged();
    
    public final void onItemRangeChanged(int param1Int1, int param1Int2) {
      onChanged();
    }
    
    public final void onItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      onChanged();
    }
    
    public final void onItemRangeInserted(int param1Int1, int param1Int2) {
      onChanged();
    }
    
    public final void onItemRangeMoved(int param1Int1, int param1Int2, int param1Int3) {
      onChanged();
    }
    
    public final void onItemRangeRemoved(int param1Int1, int param1Int2) {
      onChanged();
    }
  }
  
  class LinearLayoutManagerImpl extends LinearLayoutManager {
    LinearLayoutManagerImpl(ViewPager2 this$0, Context param1Context) {
      super(param1Context);
    }
    
    public void a(RecyclerView.State param1State, int[] param1ArrayOfint) {
      int i = this.a.getOffscreenPageLimit();
      if (i == -1) {
        super.a(param1State, param1ArrayOfint);
        return;
      } 
      i = this.a.getPageSize() * i;
      param1ArrayOfint[0] = i;
      param1ArrayOfint[1] = i;
    }
    
    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      super.onInitializeAccessibilityNodeInfo(param1Recycler, param1State, param1AccessibilityNodeInfoCompat);
      this.a.f.onLmInitializeAccessibilityNodeInfo(param1AccessibilityNodeInfoCompat);
    }
    
    public boolean performAccessibilityAction(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, int param1Int, Bundle param1Bundle) {
      return this.a.f.handlesLmPerformAccessibilityAction(param1Int) ? this.a.f.onLmPerformAccessibilityAction(param1Int) : super.performAccessibilityAction(param1Recycler, param1State, param1Int, param1Bundle);
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView param1RecyclerView, View param1View, Rect param1Rect, boolean param1Boolean1, boolean param1Boolean2) {
      return false;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OffscreenPageLimit {}
  
  public static abstract class OnPageChangeCallback {
    public void onPageScrollStateChanged(int param1Int) {}
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
    
    public void onPageSelected(int param1Int) {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Orientation {}
  
  class PageAwareAccessibilityProvider extends AccessibilityProvider {
    private final AccessibilityViewCommand c = new AccessibilityViewCommand(this) {
        public boolean perform(View param2View, AccessibilityViewCommand.CommandArguments param2CommandArguments) {
          ViewPager2 viewPager2 = (ViewPager2)param2View;
          this.a.a(viewPager2.getCurrentItem() + 1);
          return true;
        }
      };
    
    private final AccessibilityViewCommand d = new AccessibilityViewCommand(this) {
        public boolean perform(View param2View, AccessibilityViewCommand.CommandArguments param2CommandArguments) {
          ViewPager2 viewPager2 = (ViewPager2)param2View;
          this.a.a(viewPager2.getCurrentItem() - 1);
          return true;
        }
      };
    
    private RecyclerView.AdapterDataObserver e;
    
    PageAwareAccessibilityProvider(ViewPager2 this$0) {
      super(this$0);
    }
    
    private void a(AccessibilityNodeInfo param1AccessibilityNodeInfo) {
      boolean bool1;
      if (this.b.getAdapter() != null) {
        if (this.b.getOrientation() == 1) {
          bool1 = this.b.getAdapter().getItemCount();
        } else {
          int i = this.b.getAdapter().getItemCount();
          bool1 = false;
          AccessibilityNodeInfoCompat.wrap(param1AccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(bool1, i, false, 0));
        } 
      } else {
        bool1 = false;
      } 
      boolean bool2 = false;
      AccessibilityNodeInfoCompat.wrap(param1AccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(bool1, bool2, false, 0));
    }
    
    private void b(AccessibilityNodeInfo param1AccessibilityNodeInfo) {
      RecyclerView.Adapter adapter = this.b.getAdapter();
      if (adapter == null)
        return; 
      int i = adapter.getItemCount();
      if (i != 0) {
        if (!this.b.isUserInputEnabled())
          return; 
        if (this.b.b > 0)
          param1AccessibilityNodeInfo.addAction(8192); 
        if (this.b.b < i - 1)
          param1AccessibilityNodeInfo.addAction(4096); 
        param1AccessibilityNodeInfo.setScrollable(true);
      } 
    }
    
    void a() {
      ViewPager2 viewPager2 = this.b;
      int i = 16908360;
      ViewCompat.removeAccessibilityAction((View)viewPager2, 16908360);
      ViewCompat.removeAccessibilityAction((View)viewPager2, 16908361);
      ViewCompat.removeAccessibilityAction((View)viewPager2, 16908358);
      ViewCompat.removeAccessibilityAction((View)viewPager2, 16908359);
      if (this.b.getAdapter() == null)
        return; 
      int j = this.b.getAdapter().getItemCount();
      if (j == 0)
        return; 
      if (!this.b.isUserInputEnabled())
        return; 
      if (this.b.getOrientation() == 0) {
        int k;
        boolean bool = this.b.b();
        if (bool) {
          k = 16908360;
        } else {
          k = 16908361;
        } 
        if (bool)
          i = 16908361; 
        if (this.b.b < j - 1)
          ViewCompat.replaceAccessibilityAction((View)viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(k, null), null, this.c); 
        if (this.b.b > 0) {
          ViewCompat.replaceAccessibilityAction((View)viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, null), null, this.d);
          return;
        } 
      } else {
        if (this.b.b < j - 1)
          ViewCompat.replaceAccessibilityAction((View)viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, null), null, this.c); 
        if (this.b.b > 0)
          ViewCompat.replaceAccessibilityAction((View)viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, null), null, this.d); 
      } 
    }
    
    void a(int param1Int) {
      if (this.b.isUserInputEnabled())
        this.b.a(param1Int, true); 
    }
    
    public boolean handlesGetAccessibilityClassName() {
      return true;
    }
    
    public boolean handlesPerformAccessibilityAction(int param1Int, Bundle param1Bundle) {
      return (param1Int == 8192 || param1Int == 4096);
    }
    
    public void onAttachAdapter(RecyclerView.Adapter<?> param1Adapter) {
      a();
      if (param1Adapter != null)
        param1Adapter.registerAdapterDataObserver(this.e); 
    }
    
    public void onDetachAdapter(RecyclerView.Adapter<?> param1Adapter) {
      if (param1Adapter != null)
        param1Adapter.unregisterAdapterDataObserver(this.e); 
    }
    
    public String onGetAccessibilityClassName() {
      if (handlesGetAccessibilityClassName())
        return "androidx.viewpager.widget.ViewPager"; 
      throw new IllegalStateException();
    }
    
    public void onInitialize(CompositeOnPageChangeCallback param1CompositeOnPageChangeCallback, RecyclerView param1RecyclerView) {
      ViewCompat.setImportantForAccessibility((View)param1RecyclerView, 2);
      this.e = new ViewPager2.DataSetChangeObserver(this) {
          public void onChanged() {
            this.a.a();
          }
        };
      if (ViewCompat.getImportantForAccessibility((View)this.b) == 0)
        ViewCompat.setImportantForAccessibility((View)this.b, 1); 
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo param1AccessibilityNodeInfo) {
      a(param1AccessibilityNodeInfo);
      if (Build.VERSION.SDK_INT >= 16)
        b(param1AccessibilityNodeInfo); 
    }
    
    public boolean onPerformAccessibilityAction(int param1Int, Bundle param1Bundle) {
      if (handlesPerformAccessibilityAction(param1Int, param1Bundle)) {
        if (param1Int == 8192) {
          param1Int = this.b.getCurrentItem() - 1;
        } else {
          param1Int = this.b.getCurrentItem() + 1;
        } 
        a(param1Int);
        return true;
      } 
      throw new IllegalStateException();
    }
    
    public void onRestorePendingState() {
      a();
    }
    
    public void onRvInitializeAccessibilityEvent(AccessibilityEvent param1AccessibilityEvent) {
      param1AccessibilityEvent.setSource((View)this.b);
      param1AccessibilityEvent.setClassName(onGetAccessibilityClassName());
    }
    
    public void onSetLayoutDirection() {
      a();
    }
    
    public void onSetNewCurrentItem() {
      a();
    }
    
    public void onSetOrientation() {
      a();
    }
    
    public void onSetUserInputEnabled() {
      a();
      if (Build.VERSION.SDK_INT < 21)
        this.b.sendAccessibilityEvent(2048); 
    }
  }
  
  class null implements AccessibilityViewCommand {
    null(ViewPager2 this$0) {}
    
    public boolean perform(View param1View, AccessibilityViewCommand.CommandArguments param1CommandArguments) {
      ViewPager2 viewPager2 = (ViewPager2)param1View;
      this.a.a(viewPager2.getCurrentItem() + 1);
      return true;
    }
  }
  
  class null implements AccessibilityViewCommand {
    null(ViewPager2 this$0) {}
    
    public boolean perform(View param1View, AccessibilityViewCommand.CommandArguments param1CommandArguments) {
      ViewPager2 viewPager2 = (ViewPager2)param1View;
      this.a.a(viewPager2.getCurrentItem() - 1);
      return true;
    }
  }
  
  class null extends DataSetChangeObserver {
    null(ViewPager2 this$0) {}
    
    public void onChanged() {
      this.a.a();
    }
  }
  
  public static interface PageTransformer {
    void transformPage(View param1View, float param1Float);
  }
  
  class PagerSnapHelperImpl extends PagerSnapHelper {
    PagerSnapHelperImpl(ViewPager2 this$0) {}
    
    public View findSnapView(RecyclerView.LayoutManager param1LayoutManager) {
      return this.b.isFakeDragging() ? null : super.findSnapView(param1LayoutManager);
    }
  }
  
  class RecyclerViewImpl extends RecyclerView {
    RecyclerViewImpl(ViewPager2 this$0, Context param1Context) {
      super(param1Context);
    }
    
    public CharSequence getAccessibilityClassName() {
      return this.L.f.handlesRvGetAccessibilityClassName() ? this.L.f.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1AccessibilityEvent);
      param1AccessibilityEvent.setFromIndex(this.L.b);
      param1AccessibilityEvent.setToIndex(this.L.b);
      this.L.f.onRvInitializeAccessibilityEvent(param1AccessibilityEvent);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent param1MotionEvent) {
      return (this.L.isUserInputEnabled() && super.onInterceptTouchEvent(param1MotionEvent));
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      return (this.L.isUserInputEnabled() && super.onTouchEvent(param1MotionEvent));
    }
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public ViewPager2.SavedState createFromParcel(Parcel param2Parcel) {
          return createFromParcel(param2Parcel, (ClassLoader)null);
        }
        
        public ViewPager2.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return (Build.VERSION.SDK_INT >= 24) ? new ViewPager2.SavedState(param2Parcel, param2ClassLoader) : new ViewPager2.SavedState(param2Parcel);
        }
        
        public ViewPager2.SavedState[] newArray(int param2Int) {
          return new ViewPager2.SavedState[param2Int];
        }
      };
    
    int a;
    
    int b;
    
    Parcelable c;
    
    SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      a(param1Parcel, null);
    }
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      a(param1Parcel, param1ClassLoader);
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    private void a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readParcelable(param1ClassLoader);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeParcelable(this.c, param1Int);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public ViewPager2.SavedState createFromParcel(Parcel param1Parcel) {
      return createFromParcel(param1Parcel, (ClassLoader)null);
    }
    
    public ViewPager2.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return (Build.VERSION.SDK_INT >= 24) ? new ViewPager2.SavedState(param1Parcel, param1ClassLoader) : new ViewPager2.SavedState(param1Parcel);
    }
    
    public ViewPager2.SavedState[] newArray(int param1Int) {
      return new ViewPager2.SavedState[param1Int];
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScrollState {}
  
  static class SmoothScrollToPosition implements Runnable {
    private final int a;
    
    private final RecyclerView b;
    
    SmoothScrollToPosition(int param1Int, RecyclerView param1RecyclerView) {
      this.a = param1Int;
      this.b = param1RecyclerView;
    }
    
    public void run() {
      this.b.smoothScrollToPosition(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\widget\ViewPager2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */