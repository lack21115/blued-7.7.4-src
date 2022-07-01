package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.blued.android.framework.R;

public class StickyListHeadersListView extends FrameLayout {
  private WrapperViewList a;
  
  private View b;
  
  private Long c;
  
  private Integer d;
  
  private Integer e;
  
  private AbsListView.OnScrollListener f;
  
  private AdapterWrapper g;
  
  private boolean h = true;
  
  private boolean i = true;
  
  private boolean j = true;
  
  private int k = 0;
  
  private int l = 0;
  
  private int m = 0;
  
  private int n = 0;
  
  private int o = 0;
  
  private OnHeaderClickListener p;
  
  private OnStickyHeaderOffsetChangedListener q;
  
  private OnStickyHeaderChangedListener r;
  
  private AdapterWrapperDataSetObserver s;
  
  private Drawable t;
  
  private int u;
  
  public StickyListHeadersListView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public StickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new WrapperViewList(paramContext);
    this.t = this.a.getDivider();
    this.u = this.a.getDividerHeight();
    this.a.setDivider(null);
    this.a.setDividerHeight(0);
    if (paramAttributeSet != null) {
      TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.StickyListHeadersListView, 0, 0);
      try {
        boolean bool;
        paramInt = typedArray.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_padding, 0);
        this.l = typedArray.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingLeft, paramInt);
        this.m = typedArray.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingTop, paramInt);
        this.n = typedArray.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingRight, paramInt);
        this.o = typedArray.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingBottom, paramInt);
        setPadding(this.l, this.m, this.n, this.o);
        this.i = typedArray.getBoolean(R.styleable.StickyListHeadersListView_android_clipToPadding, true);
        super.setClipToPadding(true);
        this.a.setClipToPadding(this.i);
        paramInt = typedArray.getInt(R.styleable.StickyListHeadersListView_android_scrollbars, 512);
        WrapperViewList wrapperViewList = this.a;
        if ((paramInt & 0x200) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        wrapperViewList.setVerticalScrollBarEnabled(bool);
        wrapperViewList = this.a;
        if ((paramInt & 0x100) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        wrapperViewList.setHorizontalScrollBarEnabled(bool);
        if (Build.VERSION.SDK_INT >= 9)
          this.a.setOverScrollMode(typedArray.getInt(R.styleable.StickyListHeadersListView_android_overScrollMode, 0)); 
        this.a.setFadingEdgeLength(typedArray.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_fadingEdgeLength, this.a.getVerticalFadingEdgeLength()));
        paramInt = typedArray.getInt(R.styleable.StickyListHeadersListView_android_requiresFadingEdge, 0);
        if (paramInt == 4096) {
          this.a.setVerticalFadingEdgeEnabled(false);
          this.a.setHorizontalFadingEdgeEnabled(true);
        } else if (paramInt == 8192) {
          this.a.setVerticalFadingEdgeEnabled(true);
          this.a.setHorizontalFadingEdgeEnabled(false);
        } else {
          this.a.setVerticalFadingEdgeEnabled(false);
          this.a.setHorizontalFadingEdgeEnabled(false);
        } 
        this.a.setCacheColorHint(typedArray.getColor(R.styleable.StickyListHeadersListView_android_cacheColorHint, this.a.getCacheColorHint()));
        if (Build.VERSION.SDK_INT >= 11)
          this.a.setChoiceMode(typedArray.getInt(R.styleable.StickyListHeadersListView_android_choiceMode, this.a.getChoiceMode())); 
        this.a.setDrawSelectorOnTop(typedArray.getBoolean(R.styleable.StickyListHeadersListView_android_drawSelectorOnTop, false));
        this.a.setFastScrollEnabled(typedArray.getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollEnabled, this.a.isFastScrollEnabled()));
        if (Build.VERSION.SDK_INT >= 11)
          this.a.setFastScrollAlwaysVisible(typedArray.getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollAlwaysVisible, this.a.isFastScrollAlwaysVisible())); 
        this.a.setScrollBarStyle(typedArray.getInt(R.styleable.StickyListHeadersListView_android_scrollbarStyle, 0));
        if (typedArray.hasValue(R.styleable.StickyListHeadersListView_android_listSelector))
          this.a.setSelector(typedArray.getDrawable(R.styleable.StickyListHeadersListView_android_listSelector)); 
        this.a.setScrollingCacheEnabled(typedArray.getBoolean(R.styleable.StickyListHeadersListView_android_scrollingCache, this.a.isScrollingCacheEnabled()));
        if (typedArray.hasValue(R.styleable.StickyListHeadersListView_android_divider))
          this.t = typedArray.getDrawable(R.styleable.StickyListHeadersListView_android_divider); 
        this.u = typedArray.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_dividerHeight, this.u);
        this.a.setTranscriptMode(typedArray.getInt(R.styleable.StickyListHeadersListView_android_transcriptMode, 0));
        this.h = typedArray.getBoolean(R.styleable.StickyListHeadersListView_hasStickyHeaders, true);
        this.j = typedArray.getBoolean(R.styleable.StickyListHeadersListView_isDrawingListUnderStickyHeader, true);
      } finally {
        typedArray.recycle();
      } 
    } 
    this.a.a(new WrapperViewListLifeCycleListener());
    this.a.setOnScrollListener(new WrapperListScrollListener());
    addView((View)this.a);
  }
  
  private void a(View paramView) {
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (layoutParams == null) {
      paramView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
      return;
    } 
    if (layoutParams.height == -1 || layoutParams.width == -2) {
      layoutParams.height = -2;
      layoutParams.width = -1;
      paramView.setLayoutParams(layoutParams);
    } 
  }
  
  private void b() {
    View view = this.b;
    if (view != null) {
      removeView(view);
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.a.a(0);
      c();
    } 
  }
  
  private void b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Lcom/blued/android/framework/view/stickylistheaders/AdapterWrapper;
    //   4: astore #6
    //   6: iconst_0
    //   7: istore #5
    //   9: aload #6
    //   11: ifnonnull -> 19
    //   14: iconst_0
    //   15: istore_2
    //   16: goto -> 25
    //   19: aload #6
    //   21: invokevirtual getCount : ()I
    //   24: istore_2
    //   25: iload_2
    //   26: ifeq -> 183
    //   29: aload_0
    //   30: getfield h : Z
    //   33: ifne -> 37
    //   36: return
    //   37: iload_1
    //   38: aload_0
    //   39: getfield a : Lcom/blued/android/framework/view/stickylistheaders/WrapperViewList;
    //   42: invokevirtual getHeaderViewsCount : ()I
    //   45: isub
    //   46: istore_3
    //   47: iload_3
    //   48: istore_1
    //   49: aload_0
    //   50: getfield a : Lcom/blued/android/framework/view/stickylistheaders/WrapperViewList;
    //   53: invokevirtual getChildCount : ()I
    //   56: ifle -> 83
    //   59: iload_3
    //   60: istore_1
    //   61: aload_0
    //   62: getfield a : Lcom/blued/android/framework/view/stickylistheaders/WrapperViewList;
    //   65: iconst_0
    //   66: invokevirtual getChildAt : (I)Landroid/view/View;
    //   69: invokevirtual getBottom : ()I
    //   72: aload_0
    //   73: invokespecial d : ()I
    //   76: if_icmpge -> 83
    //   79: iload_3
    //   80: iconst_1
    //   81: iadd
    //   82: istore_1
    //   83: aload_0
    //   84: getfield a : Lcom/blued/android/framework/view/stickylistheaders/WrapperViewList;
    //   87: invokevirtual getChildCount : ()I
    //   90: ifeq -> 98
    //   93: iconst_1
    //   94: istore_3
    //   95: goto -> 100
    //   98: iconst_0
    //   99: istore_3
    //   100: iload_3
    //   101: ifeq -> 138
    //   104: aload_0
    //   105: getfield a : Lcom/blued/android/framework/view/stickylistheaders/WrapperViewList;
    //   108: invokevirtual getFirstVisiblePosition : ()I
    //   111: ifne -> 138
    //   114: aload_0
    //   115: getfield a : Lcom/blued/android/framework/view/stickylistheaders/WrapperViewList;
    //   118: iconst_0
    //   119: invokevirtual getChildAt : (I)Landroid/view/View;
    //   122: invokevirtual getTop : ()I
    //   125: aload_0
    //   126: invokespecial d : ()I
    //   129: if_icmplt -> 138
    //   132: iconst_1
    //   133: istore #4
    //   135: goto -> 141
    //   138: iconst_0
    //   139: istore #4
    //   141: iload_1
    //   142: iload_2
    //   143: iconst_1
    //   144: isub
    //   145: if_icmpgt -> 155
    //   148: iload #5
    //   150: istore_2
    //   151: iload_1
    //   152: ifge -> 157
    //   155: iconst_1
    //   156: istore_2
    //   157: iload_3
    //   158: ifeq -> 179
    //   161: iload_2
    //   162: ifne -> 179
    //   165: iload #4
    //   167: ifeq -> 173
    //   170: goto -> 179
    //   173: aload_0
    //   174: iload_1
    //   175: invokespecial c : (I)V
    //   178: return
    //   179: aload_0
    //   180: invokespecial b : ()V
    //   183: return
  }
  
  private void b(View paramView) {
    if (paramView != null)
      measureChild(paramView, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - this.l - this.n, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0)); 
  }
  
  private void c() {
    int i;
    View view = this.b;
    if (view != null) {
      int m = view.getMeasuredHeight();
      Integer integer = this.e;
      if (integer != null) {
        i = integer.intValue();
      } else {
        i = 0;
      } 
      i = m + i + this.k;
    } else {
      i = d();
    } 
    int k = this.a.getChildCount();
    for (int j = 0; j < k; j++) {
      view = this.a.getChildAt(j);
      if (view instanceof WrapperView) {
        WrapperView wrapperView = (WrapperView)view;
        if (wrapperView.a()) {
          View view1 = wrapperView.d;
          if (wrapperView.getTop() < i) {
            if (view1.getVisibility() != 4)
              view1.setVisibility(4); 
          } else if (view1.getVisibility() != 0) {
            view1.setVisibility(0);
          } 
        } 
      } 
    } 
  }
  
  private void c(int paramInt) {
    int i;
    Integer integer = this.d;
    if (integer == null || integer.intValue() != paramInt) {
      this.d = Integer.valueOf(paramInt);
      long l = this.g.a(paramInt);
      Long long_ = this.c;
      if (long_ == null || long_.longValue() != l) {
        this.c = Long.valueOf(l);
        View view = this.g.b(this.d.intValue(), this.b, (ViewGroup)this);
        if (this.b != view)
          if (view != null) {
            c(view);
          } else {
            throw new NullPointerException("header may not be null");
          }  
        a(this.b);
        b(this.b);
        OnStickyHeaderChangedListener onStickyHeaderChangedListener = this.r;
        if (onStickyHeaderChangedListener != null)
          onStickyHeaderChangedListener.a(this, this.b, paramInt, this.c.longValue()); 
        this.e = null;
      } 
    } 
    int j = this.b.getMeasuredHeight();
    int k = d();
    byte b = 0;
    paramInt = 0;
    while (true) {
      i = b;
      if (paramInt < this.a.getChildCount()) {
        View view = this.a.getChildAt(paramInt);
        if (view instanceof WrapperView && ((WrapperView)view).a()) {
          i = 1;
        } else {
          i = 0;
        } 
        boolean bool = this.a.a(view);
        if (view.getTop() >= d() && (i || bool)) {
          i = Math.min(view.getTop() - j + k, 0);
          break;
        } 
        paramInt++;
        continue;
      } 
      break;
    } 
    setHeaderOffet(i);
    if (!this.j)
      this.a.a(this.b.getMeasuredHeight() + this.e.intValue()); 
    c();
  }
  
  private void c(View paramView) {
    View view = this.b;
    if (view != null)
      removeView(view); 
    this.b = paramView;
    addView(this.b);
    if (this.p != null)
      this.b.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              StickyListHeadersListView.OnHeaderClickListener onHeaderClickListener = StickyListHeadersListView.d(this.a);
              StickyListHeadersListView stickyListHeadersListView = this.a;
              onHeaderClickListener.a(stickyListHeadersListView, StickyListHeadersListView.a(stickyListHeadersListView), StickyListHeadersListView.b(this.a).intValue(), StickyListHeadersListView.c(this.a).longValue(), true);
            }
          }); 
    this.b.setClickable(true);
  }
  
  private int d() {
    byte b;
    int i = this.k;
    if (this.i) {
      b = this.m;
    } else {
      b = 0;
    } 
    return i + b;
  }
  
  private boolean d(int paramInt) {
    boolean bool = true;
    if (paramInt != 0) {
      if (this.g.a(paramInt) != this.g.a(paramInt - 1))
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  private boolean e(int paramInt) {
    if (Build.VERSION.SDK_INT < paramInt) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Api lvl must be at least ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" to call this method");
      Log.e("StickyListHeaders", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private void setHeaderOffet(int paramInt) {
    Integer integer = this.e;
    if (integer == null || integer.intValue() != paramInt) {
      this.e = Integer.valueOf(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        this.b.setTranslationY(this.e.intValue());
      } else {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
        marginLayoutParams.topMargin = this.e.intValue();
        this.b.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      } 
      OnStickyHeaderOffsetChangedListener onStickyHeaderOffsetChangedListener = this.q;
      if (onStickyHeaderOffsetChangedListener != null)
        onStickyHeaderOffsetChangedListener.a(this, this.b, -this.e.intValue()); 
    } 
  }
  
  public int a(int paramInt) {
    if (!d(Math.max(0, paramInt - getHeaderViewsCount()))) {
      View view = this.g.b(paramInt, (View)null, (ViewGroup)this.a);
      if (view != null) {
        a(view);
        b(view);
        return view.getMeasuredHeight();
      } 
      throw new NullPointerException("header may not be null");
    } 
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2) {
    int i;
    AdapterWrapper adapterWrapper = this.g;
    int j = 0;
    if (adapterWrapper == null) {
      i = 0;
    } else {
      i = a(paramInt1);
    } 
    if (!this.i)
      j = this.m; 
    this.a.setSelectionFromTop(paramInt1, paramInt2 + i - j);
  }
  
  public boolean a() {
    return this.h;
  }
  
  public boolean canScrollVertically(int paramInt) {
    return this.a.canScrollVertically(paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    if (this.a.getVisibility() == 0 || this.a.getAnimation() != null)
      drawChild(paramCanvas, (View)this.a, 0L); 
  }
  
  public StickyListHeadersAdapter getAdapter() {
    AdapterWrapper adapterWrapper = this.g;
    return (adapterWrapper == null) ? null : adapterWrapper.a;
  }
  
  @Deprecated
  public boolean getAreHeadersSticky() {
    return a();
  }
  
  public int getCheckedItemCount() {
    return e(11) ? this.a.getCheckedItemCount() : 0;
  }
  
  public long[] getCheckedItemIds() {
    return e(8) ? this.a.getCheckedItemIds() : null;
  }
  
  public int getCheckedItemPosition() {
    return this.a.getCheckedItemPosition();
  }
  
  public SparseBooleanArray getCheckedItemPositions() {
    return this.a.getCheckedItemPositions();
  }
  
  public int getCount() {
    return this.a.getCount();
  }
  
  public Drawable getDivider() {
    return this.t;
  }
  
  public int getDividerHeight() {
    return this.u;
  }
  
  public View getEmptyView() {
    return this.a.getEmptyView();
  }
  
  public int getFirstVisiblePosition() {
    return this.a.getFirstVisiblePosition();
  }
  
  public int getFooterViewsCount() {
    return this.a.getFooterViewsCount();
  }
  
  public int getHeaderViewsCount() {
    return this.a.getHeaderViewsCount();
  }
  
  public int getLastVisiblePosition() {
    return this.a.getLastVisiblePosition();
  }
  
  public int getListChildCount() {
    return this.a.getChildCount();
  }
  
  public int getOverScrollMode() {
    return e(9) ? this.a.getOverScrollMode() : 0;
  }
  
  public int getPaddingBottom() {
    return this.o;
  }
  
  public int getPaddingLeft() {
    return this.l;
  }
  
  public int getPaddingRight() {
    return this.n;
  }
  
  public int getPaddingTop() {
    return this.m;
  }
  
  public int getScrollBarStyle() {
    return this.a.getScrollBarStyle();
  }
  
  public int getStickyHeaderTopOffset() {
    return this.k;
  }
  
  public ListView getWrappedList() {
    return this.a;
  }
  
  public boolean isHorizontalScrollBarEnabled() {
    return this.a.isHorizontalScrollBarEnabled();
  }
  
  public boolean isVerticalScrollBarEnabled() {
    return this.a.isVerticalScrollBarEnabled();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    WrapperViewList wrapperViewList = this.a;
    wrapperViewList.layout(0, 0, wrapperViewList.getMeasuredWidth(), getHeight());
    View view = this.b;
    if (view != null) {
      paramInt1 = ((ViewGroup.MarginLayoutParams)view.getLayoutParams()).topMargin + d();
      view = this.b;
      view.layout(this.l, paramInt1, view.getMeasuredWidth() + this.l, this.b.getMeasuredHeight() + paramInt1);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    b(this.b);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    super.onRestoreInstanceState((Parcelable)View.BaseSavedState.EMPTY_STATE);
    this.a.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState() {
    if (super.onSaveInstanceState() == View.BaseSavedState.EMPTY_STATE)
      return this.a.onSaveInstanceState(); 
    throw new IllegalStateException("Handling non empty state of parent class is not implemented");
  }
  
  public void setAdapter(StickyListHeadersAdapter paramStickyListHeadersAdapter) {
    if (paramStickyListHeadersAdapter == null) {
      this.a.setAdapter(null);
      b();
      return;
    } 
    AdapterWrapper adapterWrapper = this.g;
    if (adapterWrapper != null)
      adapterWrapper.unregisterDataSetObserver(this.s); 
    if (paramStickyListHeadersAdapter instanceof android.widget.SectionIndexer) {
      this.g = new SectionIndexerAdapterWrapper(getContext(), paramStickyListHeadersAdapter);
    } else {
      this.g = new AdapterWrapper(getContext(), paramStickyListHeadersAdapter);
    } 
    this.s = new AdapterWrapperDataSetObserver();
    this.g.registerDataSetObserver(this.s);
    if (this.p != null) {
      this.g.a(new AdapterWrapperHeaderClickHandler());
    } else {
      this.g.a((AdapterWrapper.OnHeaderClickListener)null);
    } 
    this.g.a(this.t, this.u);
    this.a.setAdapter(this.g);
    b();
  }
  
  public void setAreHeadersSticky(boolean paramBoolean) {
    this.h = paramBoolean;
    if (!paramBoolean) {
      b();
    } else {
      b(this.a.a());
    } 
    this.a.invalidate();
  }
  
  public void setBlockLayoutChildren(boolean paramBoolean) {
    this.a.a(paramBoolean);
  }
  
  public void setChoiceMode(int paramInt) {
    this.a.setChoiceMode(paramInt);
  }
  
  public void setClipToPadding(boolean paramBoolean) {
    WrapperViewList wrapperViewList = this.a;
    if (wrapperViewList != null)
      wrapperViewList.setClipToPadding(paramBoolean); 
    this.i = paramBoolean;
  }
  
  public void setDivider(Drawable paramDrawable) {
    this.t = paramDrawable;
    AdapterWrapper adapterWrapper = this.g;
    if (adapterWrapper != null)
      adapterWrapper.a(this.t, this.u); 
  }
  
  public void setDividerHeight(int paramInt) {
    this.u = paramInt;
    AdapterWrapper adapterWrapper = this.g;
    if (adapterWrapper != null)
      adapterWrapper.a(this.t, this.u); 
  }
  
  public void setDrawingListUnderStickyHeader(boolean paramBoolean) {
    this.j = paramBoolean;
    this.a.a(0);
  }
  
  public void setEmptyView(View paramView) {
    this.a.setEmptyView(paramView);
  }
  
  public void setFastScrollAlwaysVisible(boolean paramBoolean) {
    if (e(11))
      this.a.setFastScrollAlwaysVisible(paramBoolean); 
  }
  
  public void setFastScrollEnabled(boolean paramBoolean) {
    this.a.setFastScrollEnabled(paramBoolean);
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean) {
    this.a.setHorizontalScrollBarEnabled(paramBoolean);
  }
  
  public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener paramMultiChoiceModeListener) {
    if (e(11))
      this.a.setMultiChoiceModeListener(paramMultiChoiceModeListener); 
  }
  
  public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener) {
    this.a.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }
  
  public void setOnHeaderClickListener(OnHeaderClickListener paramOnHeaderClickListener) {
    this.p = paramOnHeaderClickListener;
    AdapterWrapper adapterWrapper = this.g;
    if (adapterWrapper != null) {
      View view;
      if (this.p != null) {
        adapterWrapper.a(new AdapterWrapperHeaderClickHandler());
        view = this.b;
        if (view != null) {
          view.setOnClickListener(new View.OnClickListener(this) {
                public void onClick(View param1View) {
                  StickyListHeadersListView.OnHeaderClickListener onHeaderClickListener = StickyListHeadersListView.d(this.a);
                  StickyListHeadersListView stickyListHeadersListView = this.a;
                  onHeaderClickListener.a(stickyListHeadersListView, StickyListHeadersListView.a(stickyListHeadersListView), StickyListHeadersListView.b(this.a).intValue(), StickyListHeadersListView.c(this.a).longValue(), true);
                }
              });
          return;
        } 
      } else {
        view.a((AdapterWrapper.OnHeaderClickListener)null);
      } 
    } 
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.a.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener) {
    this.a.setOnItemLongClickListener(paramOnItemLongClickListener);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
    this.f = paramOnScrollListener;
  }
  
  public void setOnStickyHeaderChangedListener(OnStickyHeaderChangedListener paramOnStickyHeaderChangedListener) {
    this.r = paramOnStickyHeaderChangedListener;
  }
  
  public void setOnStickyHeaderOffsetChangedListener(OnStickyHeaderOffsetChangedListener paramOnStickyHeaderOffsetChangedListener) {
    this.q = paramOnStickyHeaderOffsetChangedListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener) {
    if (paramOnTouchListener != null) {
      this.a.setOnTouchListener(new View.OnTouchListener(this, paramOnTouchListener) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              return this.a.onTouch((View)this.b, param1MotionEvent);
            }
          });
      return;
    } 
    this.a.setOnTouchListener(null);
  }
  
  public void setOverScrollMode(int paramInt) {
    if (e(9)) {
      WrapperViewList wrapperViewList = this.a;
      if (wrapperViewList != null)
        wrapperViewList.setOverScrollMode(paramInt); 
    } 
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramInt3;
    this.o = paramInt4;
    WrapperViewList wrapperViewList = this.a;
    if (wrapperViewList != null)
      wrapperViewList.setPadding(paramInt1, paramInt2, paramInt3, paramInt4); 
    super.setPadding(0, 0, 0, 0);
    requestLayout();
  }
  
  public void setScrollBarStyle(int paramInt) {
    this.a.setScrollBarStyle(paramInt);
  }
  
  public void setSelection(int paramInt) {
    a(paramInt, 0);
  }
  
  public void setSelector(int paramInt) {
    this.a.setSelector(paramInt);
  }
  
  public void setSelector(Drawable paramDrawable) {
    this.a.setSelector(paramDrawable);
  }
  
  public void setStickyHeaderTopOffset(int paramInt) {
    this.k = paramInt;
    b(this.a.a());
  }
  
  public void setTranscriptMode(int paramInt) {
    this.a.setTranscriptMode(paramInt);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean) {
    this.a.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  public boolean showContextMenu() {
    return this.a.showContextMenu();
  }
  
  class AdapterWrapperDataSetObserver extends DataSetObserver {
    private AdapterWrapperDataSetObserver(StickyListHeadersListView this$0) {}
    
    public void onChanged() {
      StickyListHeadersListView.e(this.a);
    }
    
    public void onInvalidated() {
      StickyListHeadersListView.e(this.a);
    }
  }
  
  class AdapterWrapperHeaderClickHandler implements AdapterWrapper.OnHeaderClickListener {
    private AdapterWrapperHeaderClickHandler(StickyListHeadersListView this$0) {}
    
    public void a(View param1View, int param1Int, long param1Long) {
      StickyListHeadersListView.d(this.a).a(this.a, param1View, param1Int, param1Long, false);
    }
  }
  
  public static interface OnHeaderClickListener {
    void a(StickyListHeadersListView param1StickyListHeadersListView, View param1View, int param1Int, long param1Long, boolean param1Boolean);
  }
  
  public static interface OnStickyHeaderChangedListener {
    void a(StickyListHeadersListView param1StickyListHeadersListView, View param1View, int param1Int, long param1Long);
  }
  
  public static interface OnStickyHeaderOffsetChangedListener {
    void a(StickyListHeadersListView param1StickyListHeadersListView, View param1View, int param1Int);
  }
  
  class WrapperListScrollListener implements AbsListView.OnScrollListener {
    private WrapperListScrollListener(StickyListHeadersListView this$0) {}
    
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {
      if (StickyListHeadersListView.f(this.a) != null)
        StickyListHeadersListView.f(this.a).onScroll(param1AbsListView, param1Int1, param1Int2, param1Int3); 
      StickyListHeadersListView stickyListHeadersListView = this.a;
      StickyListHeadersListView.a(stickyListHeadersListView, StickyListHeadersListView.g(stickyListHeadersListView).a());
    }
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      if (StickyListHeadersListView.f(this.a) != null)
        StickyListHeadersListView.f(this.a).onScrollStateChanged(param1AbsListView, param1Int); 
    }
  }
  
  class WrapperViewListLifeCycleListener implements WrapperViewList.LifeCycleListener {
    private WrapperViewListLifeCycleListener(StickyListHeadersListView this$0) {}
    
    public void a(Canvas param1Canvas) {
      if (Build.VERSION.SDK_INT < 8) {
        StickyListHeadersListView stickyListHeadersListView = this.a;
        StickyListHeadersListView.a(stickyListHeadersListView, StickyListHeadersListView.g(stickyListHeadersListView).a());
      } 
      if (StickyListHeadersListView.a(this.a) != null) {
        if (StickyListHeadersListView.h(this.a)) {
          param1Canvas.save();
          param1Canvas.clipRect(0, StickyListHeadersListView.i(this.a), this.a.getRight(), this.a.getBottom());
          StickyListHeadersListView stickyListHeadersListView1 = this.a;
          StickyListHeadersListView.a(stickyListHeadersListView1, param1Canvas, StickyListHeadersListView.a(stickyListHeadersListView1), 0L);
          param1Canvas.restore();
          return;
        } 
        StickyListHeadersListView stickyListHeadersListView = this.a;
        StickyListHeadersListView.b(stickyListHeadersListView, param1Canvas, StickyListHeadersListView.a(stickyListHeadersListView), 0L);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\StickyListHeadersListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */