package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.blued.android.framework.R;

public class PinnedSectionListView extends ListView {
  AbsListView.OnScrollListener a;
  
  PinnedSection b;
  
  PinnedSection c;
  
  int d;
  
  private final Rect e = new Rect();
  
  private final PointF f = new PointF();
  
  private int g;
  
  private View h;
  
  private MotionEvent i;
  
  private GradientDrawable j;
  
  private int k;
  
  private int l;
  
  private final AbsListView.OnScrollListener m = new AbsListView.OnScrollListener(this) {
      public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {
        if (this.a.a != null)
          this.a.a.onScroll(param1AbsListView, param1Int1, param1Int2, param1Int3); 
        ListAdapter listAdapter = this.a.getAdapter();
        if (listAdapter != null) {
          if (param1Int2 == 0)
            return; 
          if (PinnedSectionListView.a(listAdapter, listAdapter.getItemViewType(param1Int1))) {
            if (this.a.getChildAt(0).getTop() == this.a.getPaddingTop()) {
              this.a.a();
              return;
            } 
            this.a.a(param1Int1, param1Int1, param1Int2);
            return;
          } 
          param1Int3 = this.a.b(param1Int1);
          if (param1Int3 > -1) {
            this.a.a(param1Int3, param1Int1, param1Int2);
            return;
          } 
          this.a.a();
        } 
      }
      
      public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
        if (this.a.a != null)
          this.a.a.onScrollStateChanged(param1AbsListView, param1Int); 
      }
    };
  
  private final DataSetObserver n = new DataSetObserver(this) {
      public void onChanged() {
        this.a.b();
      }
      
      public void onInvalidated() {
        this.a.b();
      }
    };
  
  public PinnedSectionListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public PinnedSectionListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2) {
    paramView.getHitRect(this.e);
    Rect rect = this.e;
    rect.top += this.d;
    rect = this.e;
    rect.bottom += this.d + getPaddingTop();
    rect = this.e;
    rect.left += getPaddingLeft();
    rect = this.e;
    rect.right -= getPaddingRight();
    return this.e.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  public static boolean a(ListAdapter paramListAdapter, int paramInt) {
    ListAdapter listAdapter = paramListAdapter;
    if (paramListAdapter instanceof HeaderViewListAdapter)
      listAdapter = ((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter(); 
    return ((PinnedSectionListAdapter)listAdapter).a(paramInt);
  }
  
  private void c() {
    setOnScrollListener(this.m);
    this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    a(true);
  }
  
  private void d() {
    this.h = null;
    MotionEvent motionEvent = this.i;
    if (motionEvent != null) {
      motionEvent.recycle();
      this.i = null;
    } 
  }
  
  private boolean e() {
    if (this.c == null)
      return false; 
    AdapterView.OnItemClickListener onItemClickListener = getOnItemClickListener();
    if (onItemClickListener != null) {
      View view = this.c.a;
      playSoundEffect(0);
      if (view != null)
        view.sendAccessibilityEvent(1); 
      onItemClickListener.onItemClick((AdapterView)this, view, this.c.b, this.c.c);
      return true;
    } 
    return false;
  }
  
  int a(int paramInt1, int paramInt2) {
    ListAdapter listAdapter = getAdapter();
    for (int i = 0; i < paramInt2; i++) {
      int j = paramInt1 + i;
      if (a(listAdapter, listAdapter.getItemViewType(j)))
        return j; 
    } 
    return -1;
  }
  
  void a() {
    PinnedSection pinnedSection = this.c;
    if (pinnedSection != null) {
      this.b = pinnedSection;
      this.c = null;
    } 
  }
  
  void a(int paramInt) {
    PinnedSection pinnedSection2 = this.b;
    this.b = null;
    PinnedSection pinnedSection1 = pinnedSection2;
    if (pinnedSection2 == null)
      pinnedSection1 = new PinnedSection(); 
    View view = getAdapter().getView(paramInt, pinnedSection1.a, (ViewGroup)this);
    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams)view.getLayoutParams();
    AbsListView.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new AbsListView.LayoutParams(-1, -2); 
    int j = View.MeasureSpec.getMode(layoutParams1.height);
    int k = View.MeasureSpec.getSize(layoutParams1.height);
    int i = j;
    if (j == 0)
      i = 1073741824; 
    int m = getHeight() - getListPaddingTop() - getListPaddingBottom();
    j = k;
    if (k > m)
      j = m; 
    k = View.MeasureSpec.makeMeasureSpec(getWidth() - getListPaddingLeft() - getListPaddingRight(), 1073741824);
    i = View.MeasureSpec.makeMeasureSpec(j, i);
    view.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-2, -2));
    view.measure(k, i);
    view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    this.d = 0;
    view.setBackgroundResource(R.drawable.group_distance_bg);
    pinnedSection1.a = view;
    pinnedSection1.b = paramInt;
    pinnedSection1.c = getAdapter().getItemId(paramInt);
    this.c = pinnedSection1;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt3 < 2) {
      a();
      return;
    } 
    PinnedSection pinnedSection = this.c;
    if (pinnedSection != null && pinnedSection.b != paramInt1)
      a(); 
    if (this.c == null)
      a(paramInt1); 
    if (++paramInt1 < getCount()) {
      paramInt1 = a(paramInt1, paramInt3 - paramInt1 - paramInt2);
      if (paramInt1 > -1) {
        View view = getChildAt(paramInt1 - paramInt2);
        paramInt1 = this.c.a.getBottom();
        paramInt2 = getPaddingTop();
        this.k = view.getTop() - paramInt1 + paramInt2;
        paramInt1 = this.k;
        if (paramInt1 < 0) {
          this.d = paramInt1;
          return;
        } 
        this.d = 0;
        return;
      } 
      this.d = 0;
      this.k = Integer.MAX_VALUE;
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.j == null) {
        this.j = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0") });
        this.l = (int)((getResources().getDisplayMetrics()).density * 8.0F);
        return;
      } 
    } else if (this.j != null) {
      this.j = null;
      this.l = 0;
    } 
  }
  
  int b(int paramInt) {
    ListAdapter listAdapter = getAdapter();
    int i = paramInt;
    if (listAdapter instanceof SectionIndexer) {
      SectionIndexer sectionIndexer = (SectionIndexer)listAdapter;
      int j = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(paramInt));
      i = paramInt;
      if (a(listAdapter, listAdapter.getItemViewType(j)))
        return j; 
    } 
    while (i >= 0) {
      if (a(listAdapter, listAdapter.getItemViewType(i)))
        return i; 
      i--;
    } 
    return -1;
  }
  
  void b() {
    a();
    ListAdapter listAdapter = getAdapter();
    if (listAdapter != null && listAdapter.getCount() > 0) {
      int i = getFirstVisiblePosition();
      int j = b(i);
      if (j == -1)
        return; 
      a(j, i, getLastVisiblePosition() - i);
    } 
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    if (this.c != null) {
      int i;
      int j = getListPaddingLeft();
      int k = getListPaddingTop();
      View view = this.c.a;
      paramCanvas.save();
      int m = view.getHeight();
      if (this.j == null) {
        i = 0;
      } else {
        i = Math.min(this.l, this.k);
      } 
      paramCanvas.clipRect(j, k, view.getWidth() + j, m + i + k);
      paramCanvas.translate(j, (k + this.d));
      drawChild(paramCanvas, this.c.a, getDrawingTime());
      GradientDrawable gradientDrawable = this.j;
      if (gradientDrawable != null && this.k > 0) {
        gradientDrawable.setBounds(this.c.a.getLeft(), this.c.a.getBottom(), this.c.a.getRight(), this.c.a.getBottom() + this.l);
        this.j.draw(paramCanvas);
      } 
      paramCanvas.restore();
    } 
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i == 0 && this.h == null) {
      PinnedSection pinnedSection = this.c;
      if (pinnedSection != null && a(pinnedSection.a, f1, f2)) {
        this.h = this.c.a;
        PointF pointF = this.f;
        pointF.x = f1;
        pointF.y = f2;
        this.i = MotionEvent.obtain(paramMotionEvent);
      } 
    } 
    View view = this.h;
    if (view != null) {
      if (a(view, f1, f2))
        this.h.dispatchTouchEvent(paramMotionEvent); 
      if (i == 1) {
        super.dispatchTouchEvent(paramMotionEvent);
        e();
        d();
        return true;
      } 
      if (i == 3) {
        d();
        return true;
      } 
      if (i == 2 && Math.abs(f2 - this.f.y) > this.g) {
        MotionEvent motionEvent = MotionEvent.obtain(paramMotionEvent);
        motionEvent.setAction(3);
        this.h.dispatchTouchEvent(motionEvent);
        motionEvent.recycle();
        super.dispatchTouchEvent(this.i);
        super.dispatchTouchEvent(paramMotionEvent);
        d();
      } 
      return true;
    } 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c != null && paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight() != this.c.a.getWidth())
      b(); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    super.onRestoreInstanceState(paramParcelable);
    post(new Runnable(this) {
          public void run() {
            this.a.b();
          }
        });
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    ListAdapter listAdapter = getAdapter();
    if (listAdapter != null)
      listAdapter.unregisterDataSetObserver(this.n); 
    if (paramListAdapter != null)
      paramListAdapter.registerDataSetObserver(this.n); 
    if (listAdapter != paramListAdapter)
      a(); 
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
    if (paramOnScrollListener == this.m) {
      super.setOnScrollListener(paramOnScrollListener);
      return;
    } 
    this.a = paramOnScrollListener;
  }
  
  public void setShadowVisible(boolean paramBoolean) {
    a(paramBoolean);
    PinnedSection pinnedSection = this.c;
    if (pinnedSection != null) {
      View view = pinnedSection.a;
      invalidate(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() + this.l);
    } 
  }
  
  static class PinnedSection {
    public View a;
    
    public int b;
    
    public long c;
  }
  
  public static interface PinnedSectionListAdapter extends ListAdapter {
    boolean a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PinnedSectionListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */