package com.soft.blued.customview.swipecard;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import com.soft.blued.R;

public class SwipeFlingAdapterView extends BaseFlingAdapterView {
  public View a = null;
  
  public int b;
  
  public int c;
  
  public int d;
  
  public int e;
  
  private int f;
  
  private int g = 20;
  
  private int h = 7;
  
  private int i = 3;
  
  private float j = 2.0F;
  
  private int k = 0;
  
  private Adapter l;
  
  private onFlingListener m;
  
  private AdapterDataSetObserver n;
  
  private boolean o = false;
  
  private OnItemClickListener p;
  
  private FlingCardListener q;
  
  private float r = 0.0F;
  
  private float s = 0.0F;
  
  private float t = 0.0F;
  
  private float u = 0.0F;
  
  public SwipeFlingAdapterView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SwipeFlingAdapterView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeFlingAdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SwipeFlingAdapterView, paramInt, 0);
    this.h = typedArray.getInt(0, this.h);
    this.i = typedArray.getInt(1, this.i);
    this.j = typedArray.getFloat(2, this.j);
    this.f = typedArray.getDimensionPixelOffset(3, 0);
    typedArray.recycle();
  }
  
  private void a(float paramFloat) {
    int i;
    int j;
    View view1;
    if (!this.o)
      return; 
    if (getTag(2131296875) == null) {
      i = 0;
    } else {
      i = ((Integer)getTag(2131296875)).intValue();
    } 
    if (getTag(2131300307) == null) {
      j = 0;
    } else {
      j = ((Integer)getTag(2131300307)).intValue();
    } 
    int k = j - 1;
    View view2 = null;
    if (i == k && i != 0) {
      view1 = getChildAt(this.k - 1);
    } else if (i < k) {
      int m = 1;
      int n;
      for (n = 1; m <= this.h / 2; n = i1) {
        int i1 = n;
        if (i + m < j)
          i1 = n + 1; 
        m++;
      } 
      view1 = getChildAt(this.k - n);
    } else {
      view1 = null;
    } 
    if (i < k)
      view2 = getChildAt(this.k - 1); 
    if (view2 != null && paramFloat <= 0.0F) {
      float f = 1.0F - paramFloat * 0.3F - 0.3F;
      view2.setScaleX(f);
      view2.setScaleY(f);
      i = this.c;
      j = this.f;
      view2.setX((int)((i + j) + j * paramFloat));
      if (view1 != null) {
        view1.setScaleX(0.7F);
        view1.setScaleY(0.7F);
        i = this.c;
        j = this.f;
        view1.setX((i - j + j * 0));
      } 
    } 
    if (view1 != null && paramFloat >= 0.0F) {
      float f = paramFloat * 0.3F + 1.0F - 0.3F;
      view1.setScaleX(f);
      view1.setScaleY(f);
      i = this.c;
      j = this.f;
      view1.setX((int)((i - j) + j * paramFloat));
      if (view2 != null) {
        view2.setScaleX(0.7F);
        view2.setScaleY(0.7F);
        i = this.c;
        j = this.f;
        view2.setX((i + j + j * 0));
      } 
    } 
  }
  
  private void a(int paramInt1, int paramInt2) {
    while (paramInt1 < Math.min(paramInt2, this.h)) {
      View view = this.l.getView(paramInt1, null, (ViewGroup)this);
      if (view.getVisibility() != 8) {
        a(view, paramInt1);
        this.k = paramInt1;
      } 
      paramInt1++;
    } 
  }
  
  private void a(View paramView, int paramInt) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int j = 0;
    addViewInLayout(paramView, 0, (ViewGroup.LayoutParams)layoutParams, true);
    if (paramView.isLayoutRequested()) {
      paramView.measure(getChildMeasureSpec(getWidthMeasureSpec(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(getHeightMeasureSpec(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
    } else {
      cleanupLayoutState(paramView);
    } 
    int m = paramView.getMeasuredWidth();
    int n = paramView.getMeasuredHeight();
    int k = layoutParams.gravity;
    int i = k;
    if (k == -1)
      i = 8388659; 
    if (Build.VERSION.SDK_INT > 16)
      j = getLayoutDirection(); 
    j = Gravity.getAbsoluteGravity(i, j);
    k = i & 0x70;
    i = j & 0x7;
    if (i != 1) {
      if (i != 8388613) {
        i = getPaddingLeft() + layoutParams.leftMargin;
      } else {
        i = getWidth() + getPaddingRight() - m;
        j = layoutParams.rightMargin;
        i -= j;
      } 
    } else {
      i = (getWidth() + getPaddingLeft() - getPaddingRight() - m) / 2 + layoutParams.leftMargin;
      j = layoutParams.rightMargin;
      i -= j;
    } 
    if (k != 16) {
      if (k != 80) {
        j = getPaddingTop() + layoutParams.topMargin;
      } else {
        k = getHeight() - getPaddingBottom() - n;
        j = layoutParams.bottomMargin;
        j = k - j;
      } 
    } else {
      k = (getHeight() + getPaddingTop() - getPaddingBottom() - n) / 2 + layoutParams.topMargin;
      j = layoutParams.bottomMargin;
      j = k - j;
    } 
    paramView.layout(i, j, m + i, n + j);
    b(paramView, paramInt);
  }
  
  private void b(View paramView, int paramInt) {
    if (paramInt >= 1 && paramInt < this.h) {
      int i;
      Object object = getTag(2131296875);
      int j = 0;
      if (object == null) {
        i = 0;
      } else {
        i = ((Integer)getTag(2131296875)).intValue();
      } 
      if (getTag(2131300307) != null)
        j = ((Integer)getTag(2131300307)).intValue(); 
      if (paramInt <= this.h / 2)
        if (i + paramInt < j) {
          paramView.offsetLeftAndRight(this.f);
          this.t = paramView.getX();
          this.u = paramView.getY();
        } else {
          paramView.offsetLeftAndRight(-this.f);
          this.r = paramView.getX();
          this.s = paramView.getY();
        }  
      if (paramInt > this.h / 2) {
        paramView.offsetLeftAndRight(-this.f);
        this.r = paramView.getX();
        this.s = paramView.getY();
      } 
      paramView.setScaleX(0.7F);
      paramView.setScaleY(0.7F);
    } 
  }
  
  private void setTopView(int paramInt) {
    if (getChildCount() > 0) {
      this.a = getChildAt(this.k);
      View view = this.a;
      if (view != null && this.m != null) {
        view.setTag(2131296875, getTag(2131296875));
        this.a.setTag(2131300307, getTag(2131300307));
        this.a.setTag(2131298110, Float.valueOf(this.r));
        this.a.setTag(2131298111, Float.valueOf(this.s));
        this.a.setTag(2131299682, Float.valueOf(this.t));
        this.a.setTag(2131299683, Float.valueOf(this.u));
        this.a.setTag(2131299826, Float.valueOf(0.7F));
        this.a.setTag(2131299825, Float.valueOf(0.7F));
        this.q = new FlingCardListener(this.a, this.l.getItem(0), this.j, new FlingCardListener.FlingListener(this) {
              public void a() {
                SwipeFlingAdapterView swipeFlingAdapterView = this.a;
                swipeFlingAdapterView.a = null;
                SwipeFlingAdapterView.a(swipeFlingAdapterView).a();
              }
              
              public void a(float param1Float1, float param1Float2) {
                SwipeFlingAdapterView.a(this.a, param1Float1);
                SwipeFlingAdapterView.a(this.a).a(param1Float1, param1Float2);
              }
              
              public void a(MotionEvent param1MotionEvent, View param1View, Object param1Object) {
                if (SwipeFlingAdapterView.b(this.a) != null)
                  SwipeFlingAdapterView.b(this.a).a(param1MotionEvent, param1View, param1Object); 
              }
              
              public void a(Object param1Object) {
                SwipeFlingAdapterView.a(this.a, false);
                SwipeFlingAdapterView.a(this.a).a(param1Object);
              }
              
              public void b(Object param1Object) {
                SwipeFlingAdapterView.a(this.a, false);
                SwipeFlingAdapterView.a(this.a).b(param1Object);
              }
            });
        this.a.setOnTouchListener(this.q);
      } 
    } 
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public Adapter getAdapter() {
    return this.l;
  }
  
  public View getSelectedView() {
    return this.a;
  }
  
  public FlingCardListener getTopCardListener() throws NullPointerException {
    FlingCardListener flingCardListener = this.q;
    if (flingCardListener != null)
      return flingCardListener; 
    throw new NullPointerException("flingCardListener is null");
  }
  
  public int getVisibleCount() {
    return this.h;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Adapter adapter = this.l;
    if (adapter != null) {
      if (this.o == true)
        return; 
      paramInt1 = adapter.getCount();
      if (paramInt1 == 0) {
        removeAllViewsInLayout();
      } else {
        removeAllViewsInLayout();
        a(0, paramInt1);
        setTopView(paramInt1);
      } 
      this.o = true;
      if (this.b == 0 && this.c == 0) {
        View view = this.a;
        if (view != null) {
          this.b = view.getTop();
          this.c = this.a.getLeft();
          this.d = this.a.getRight();
          this.e = this.a.getBottom();
          if (this.r == 0.0F) {
            paramInt2 = this.c;
            this.r = (int)(paramInt2 - this.t - paramInt2);
            this.s = this.u;
            this.a.setTag(2131298110, Float.valueOf(this.r));
            this.a.setTag(2131298111, Float.valueOf(this.s));
          } 
          if (this.t == 0.0F) {
            paramInt2 = this.c;
            this.t = (int)(paramInt2 + paramInt2 - this.r);
            this.u = this.s;
            this.a.setTag(2131299682, Float.valueOf(this.t));
            this.a.setTag(2131299683, Float.valueOf(this.u));
          } 
        } 
      } 
      if (paramInt1 < this.i) {
        onFlingListener onFlingListener1 = this.m;
        if (onFlingListener1 != null)
          onFlingListener1.a(paramInt1); 
      } 
    } 
  }
  
  public void setAdapter(Adapter paramAdapter) {
    Adapter adapter = this.l;
    if (adapter != null) {
      AdapterDataSetObserver adapterDataSetObserver = this.n;
      if (adapterDataSetObserver != null) {
        adapter.unregisterDataSetObserver(adapterDataSetObserver);
        this.n = null;
      } 
    } 
    this.l = paramAdapter;
    if (this.l != null && this.n == null) {
      this.n = new AdapterDataSetObserver();
      this.l.registerDataSetObserver(this.n);
    } 
  }
  
  public void setFlingListener(onFlingListener paramonFlingListener) {
    this.m = paramonFlingListener;
  }
  
  public void setMaxVisible(int paramInt) {
    this.h = paramInt;
  }
  
  public void setMinStackInAdapter(int paramInt) {
    this.i = paramInt;
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener) {
    this.p = paramOnItemClickListener;
  }
  
  class AdapterDataSetObserver extends DataSetObserver {
    private AdapterDataSetObserver(SwipeFlingAdapterView this$0) {}
    
    public void onChanged() {
      SwipeFlingAdapterView.a(this.a, false);
      this.a.requestLayout();
    }
    
    public void onInvalidated() {
      SwipeFlingAdapterView.a(this.a, false);
      this.a.requestLayout();
    }
  }
  
  public static interface OnItemClickListener {
    void a(MotionEvent param1MotionEvent, View param1View, Object param1Object);
  }
  
  public static interface onFlingListener {
    void a();
    
    void a(float param1Float1, float param1Float2);
    
    void a(int param1Int);
    
    void a(Object param1Object);
    
    void b(Object param1Object);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\swipecard\SwipeFlingAdapterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */