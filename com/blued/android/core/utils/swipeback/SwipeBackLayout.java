package com.blued.android.core.utils.swipeback;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.blued.blued_core.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwipeBackLayout extends FrameLayout {
  private static final int[] a = new int[] { 1, 2, 8, 11 };
  
  private int b;
  
  private float c = 0.3F;
  
  private boolean d = true;
  
  private View e;
  
  private ViewDragHelper f = ViewDragHelper.create((ViewGroup)this, 2.0F, new ViewDragCallback());
  
  private float g;
  
  private int h;
  
  private int i;
  
  private List<SwipeListener> j;
  
  private Drawable k;
  
  private Drawable l;
  
  private Drawable m;
  
  private float n;
  
  private boolean o;
  
  private Rect p = new Rect();
  
  private int q;
  
  public SwipeBackLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet);
    setEdgeTrackingEnabled(1);
    a(R.drawable.blued_swipeback_shadow, 1);
    float f = (getResources().getDisplayMetrics()).density;
    this.f.setMinVelocity(f * 100.0F);
  }
  
  private void a(Canvas paramCanvas, View paramView) {
    Rect rect = this.p;
    paramView.getHitRect(rect);
    int i = this.b;
    if ((i & 0x1) != 0) {
      this.k.setBounds(rect.left - this.k.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
      this.k.setAlpha((int)(this.n * 255.0F));
      this.k.draw(paramCanvas);
      return;
    } 
    if ((i & 0x2) != 0) {
      this.l.setBounds(rect.right, rect.top, rect.right + this.l.getIntrinsicWidth(), rect.bottom);
      this.l.setAlpha((int)(this.n * 255.0F));
      this.l.draw(paramCanvas);
      return;
    } 
    if ((i & 0x8) != 0) {
      this.m.setBounds(rect.left, rect.bottom, rect.right, rect.bottom + this.m.getIntrinsicHeight());
      this.m.setAlpha((int)(this.n * 255.0F));
      this.m.draw(paramCanvas);
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    a(getResources().getDrawable(paramInt1), paramInt2);
  }
  
  public void a(Activity paramActivity) {
    TypedArray typedArray = paramActivity.getTheme().obtainStyledAttributes(new int[] { 16842836 });
    int i = typedArray.getResourceId(0, 0);
    typedArray.recycle();
    ViewGroup viewGroup1 = (ViewGroup)paramActivity.getWindow().getDecorView();
    ViewGroup viewGroup2 = (ViewGroup)viewGroup1.getChildAt(0);
    viewGroup2.setBackgroundResource(i);
    viewGroup1.removeView((View)viewGroup2);
    addView((View)viewGroup2);
    setContentView((View)viewGroup2);
    a(new SwipeBackListenerActivityAdapter(paramActivity));
    viewGroup1.addView((View)this);
  }
  
  public void a(Drawable paramDrawable, int paramInt) {
    if ((paramInt & 0x1) != 0) {
      this.k = paramDrawable;
    } else if ((paramInt & 0x2) != 0) {
      this.l = paramDrawable;
    } else if ((paramInt & 0x8) != 0) {
      this.m = paramDrawable;
    } 
    invalidate();
  }
  
  public void a(SwipeListener paramSwipeListener) {
    if (this.j == null)
      this.j = new ArrayList<SwipeListener>(); 
    this.j.add(paramSwipeListener);
  }
  
  public void computeScroll() {
    this.n = 1.0F - this.g;
    if (this.f.continueSettling(true))
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    boolean bool;
    if (paramView == this.e) {
      bool = true;
    } else {
      bool = false;
    } 
    boolean bool1 = super.drawChild(paramCanvas, paramView, paramLong);
    if (this.n > 0.0F && bool && this.f.getViewDragState() != 0)
      a(paramCanvas, paramView); 
    return bool1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (!this.d)
      return false; 
    try {
      return this.f.shouldInterceptTouchEvent(paramMotionEvent);
    } catch (Exception exception) {
      return false;
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.o = true;
    View view = this.e;
    if (view != null) {
      paramInt1 = this.h;
      view.layout(paramInt1, this.i, view.getMeasuredWidth() + paramInt1, this.i + this.e.getMeasuredHeight());
    } 
    this.o = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!this.d)
      return false; 
    try {
      this.f.processTouchEvent(paramMotionEvent);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void requestLayout() {
    if (!this.o)
      super.requestLayout(); 
  }
  
  public void setContentView(View paramView) {
    this.e = paramView;
  }
  
  public void setEdgeTrackingEnabled(int paramInt) {
    this.b = paramInt;
    this.q = paramInt;
    this.f.setEdgeTrackingEnabled(this.b);
  }
  
  public void setEnableGesture(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public void setScrollThresHold(float paramFloat) {
    if (paramFloat < 1.0F && paramFloat > 0.0F) {
      this.c = paramFloat;
      return;
    } 
    throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
  }
  
  @Deprecated
  public void setSwipeListener(SwipeListener paramSwipeListener) {
    a(paramSwipeListener);
  }
  
  public static interface SwipeListener {
    void a();
    
    void a(int param1Int);
    
    void a(int param1Int, float param1Float);
    
    void a(int param1Int1, int param1Int2, float param1Float1, float param1Float2, float param1Float3);
  }
  
  public static interface SwipeListenerEx extends SwipeListener {
    void b();
  }
  
  class ViewDragCallback extends ViewDragHelper.Callback {
    private boolean b;
    
    private ViewDragCallback(SwipeBackLayout this$0) {}
    
    public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
      int i = SwipeBackLayout.d(this.a);
      param1Int2 = 0;
      if ((i & 0x1) != 0)
        return Math.min(param1View.getWidth(), Math.max(param1Int1, 0)); 
      if ((SwipeBackLayout.d(this.a) & 0x2) != 0)
        param1Int2 = Math.min(0, Math.max(param1Int1, -param1View.getWidth())); 
      return param1Int2;
    }
    
    public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
      int i = SwipeBackLayout.d(this.a);
      param1Int2 = 0;
      if ((i & 0x8) != 0)
        param1Int2 = Math.min(0, Math.max(param1Int1, -param1View.getHeight())); 
      return param1Int2;
    }
    
    public int getViewHorizontalDragRange(View param1View) {
      return SwipeBackLayout.a(this.a) & 0x3;
    }
    
    public int getViewVerticalDragRange(View param1View) {
      return SwipeBackLayout.a(this.a) & 0x8;
    }
    
    public void onViewDragStateChanged(int param1Int) {
      super.onViewDragStateChanged(param1Int);
      if (SwipeBackLayout.c(this.a) != null && !SwipeBackLayout.c(this.a).isEmpty()) {
        Iterator<SwipeBackLayout.SwipeListener> iterator = SwipeBackLayout.c(this.a).iterator();
        while (iterator.hasNext())
          ((SwipeBackLayout.SwipeListener)iterator.next()).a(param1Int, SwipeBackLayout.i(this.a)); 
      } 
    }
    
    public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      super.onViewPositionChanged(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
      if ((SwipeBackLayout.d(this.a) & 0x1) != 0) {
        SwipeBackLayout swipeBackLayout = this.a;
        SwipeBackLayout.a(swipeBackLayout, Math.abs(param1Int1 / (SwipeBackLayout.e(swipeBackLayout).getWidth() + SwipeBackLayout.f(this.a).getIntrinsicWidth())));
      } else if ((SwipeBackLayout.d(this.a) & 0x2) != 0) {
        SwipeBackLayout swipeBackLayout = this.a;
        SwipeBackLayout.a(swipeBackLayout, Math.abs(param1Int1 / (SwipeBackLayout.e(swipeBackLayout).getWidth() + SwipeBackLayout.g(this.a).getIntrinsicWidth())));
      } else if ((SwipeBackLayout.d(this.a) & 0x8) != 0) {
        SwipeBackLayout swipeBackLayout = this.a;
        SwipeBackLayout.a(swipeBackLayout, Math.abs(param1Int2 / (SwipeBackLayout.e(swipeBackLayout).getHeight() + SwipeBackLayout.h(this.a).getIntrinsicHeight())));
      } 
      SwipeBackLayout.b(this.a, param1Int1);
      SwipeBackLayout.c(this.a, param1Int2);
      this.a.invalidate();
      if (SwipeBackLayout.i(this.a) < SwipeBackLayout.j(this.a) && !this.b)
        this.b = true; 
      if (SwipeBackLayout.c(this.a) != null && !SwipeBackLayout.c(this.a).isEmpty()) {
        Iterator<SwipeBackLayout.SwipeListener> iterator = SwipeBackLayout.c(this.a).iterator();
        while (iterator.hasNext())
          ((SwipeBackLayout.SwipeListener)iterator.next()).a(SwipeBackLayout.b(this.a).getViewDragState(), SwipeBackLayout.i(this.a)); 
      } 
      if (SwipeBackLayout.c(this.a) != null && !SwipeBackLayout.c(this.a).isEmpty() && SwipeBackLayout.b(this.a).getViewDragState() == 1 && SwipeBackLayout.i(this.a) >= SwipeBackLayout.j(this.a) && this.b) {
        this.b = false;
        Iterator<SwipeBackLayout.SwipeListener> iterator = SwipeBackLayout.c(this.a).iterator();
        while (iterator.hasNext())
          ((SwipeBackLayout.SwipeListener)iterator.next()).a(); 
      } 
      if (SwipeBackLayout.i(this.a) >= 1.0F && SwipeBackLayout.c(this.a) != null && !SwipeBackLayout.c(this.a).isEmpty())
        for (SwipeBackLayout.SwipeListener swipeListener : SwipeBackLayout.c(this.a)) {
          if (swipeListener instanceof SwipeBackLayout.SwipeListenerEx)
            ((SwipeBackLayout.SwipeListenerEx)swipeListener).b(); 
        }  
    }
    
    public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getWidth : ()I
      //   4: istore #4
      //   6: aload_1
      //   7: invokevirtual getHeight : ()I
      //   10: istore #7
      //   12: aload_0
      //   13: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   16: invokestatic d : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)I
      //   19: istore #8
      //   21: iconst_0
      //   22: istore #5
      //   24: iconst_0
      //   25: istore #6
      //   27: iload #8
      //   29: iconst_1
      //   30: iand
      //   31: ifeq -> 97
      //   34: fload_2
      //   35: fconst_0
      //   36: fcmpl
      //   37: istore #5
      //   39: iload #5
      //   41: ifgt -> 76
      //   44: iload #5
      //   46: ifne -> 70
      //   49: aload_0
      //   50: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   53: invokestatic i : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)F
      //   56: aload_0
      //   57: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   60: invokestatic j : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)F
      //   63: fcmpl
      //   64: ifle -> 70
      //   67: goto -> 76
      //   70: iconst_0
      //   71: istore #4
      //   73: goto -> 94
      //   76: iload #4
      //   78: aload_0
      //   79: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   82: invokestatic f : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)Landroid/graphics/drawable/Drawable;
      //   85: invokevirtual getIntrinsicWidth : ()I
      //   88: iadd
      //   89: bipush #10
      //   91: iadd
      //   92: istore #4
      //   94: goto -> 255
      //   97: aload_0
      //   98: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   101: invokestatic d : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)I
      //   104: iconst_2
      //   105: iand
      //   106: ifeq -> 170
      //   109: fload_2
      //   110: fconst_0
      //   111: fcmpg
      //   112: iflt -> 148
      //   115: fload_2
      //   116: fconst_0
      //   117: fcmpl
      //   118: ifne -> 142
      //   121: aload_0
      //   122: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   125: invokestatic i : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)F
      //   128: aload_0
      //   129: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   132: invokestatic j : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)F
      //   135: fcmpl
      //   136: ifle -> 142
      //   139: goto -> 148
      //   142: iconst_0
      //   143: istore #4
      //   145: goto -> 167
      //   148: iload #4
      //   150: aload_0
      //   151: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   154: invokestatic f : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)Landroid/graphics/drawable/Drawable;
      //   157: invokevirtual getIntrinsicWidth : ()I
      //   160: iadd
      //   161: bipush #10
      //   163: iadd
      //   164: ineg
      //   165: istore #4
      //   167: goto -> 255
      //   170: iload #6
      //   172: istore #4
      //   174: aload_0
      //   175: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   178: invokestatic d : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)I
      //   181: bipush #8
      //   183: iand
      //   184: ifeq -> 255
      //   187: fload_3
      //   188: fconst_0
      //   189: fcmpg
      //   190: iflt -> 225
      //   193: iload #6
      //   195: istore #4
      //   197: fload_3
      //   198: fconst_0
      //   199: fcmpl
      //   200: ifne -> 255
      //   203: iload #6
      //   205: istore #4
      //   207: aload_0
      //   208: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   211: invokestatic i : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)F
      //   214: aload_0
      //   215: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   218: invokestatic j : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)F
      //   221: fcmpl
      //   222: ifle -> 255
      //   225: iload #7
      //   227: aload_0
      //   228: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   231: invokestatic h : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)Landroid/graphics/drawable/Drawable;
      //   234: invokevirtual getIntrinsicHeight : ()I
      //   237: iadd
      //   238: bipush #10
      //   240: iadd
      //   241: ineg
      //   242: istore #6
      //   244: iload #5
      //   246: istore #4
      //   248: iload #6
      //   250: istore #5
      //   252: goto -> 258
      //   255: iconst_0
      //   256: istore #5
      //   258: aload_0
      //   259: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   262: invokestatic b : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)Landroidx/customview/widget/ViewDragHelper;
      //   265: aload_0
      //   266: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   269: invokestatic e : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)Landroid/view/View;
      //   272: iload #4
      //   274: iload #5
      //   276: invokevirtual smoothSlideViewTo : (Landroid/view/View;II)Z
      //   279: pop
      //   280: aload_0
      //   281: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   284: invokevirtual invalidate : ()V
      //   287: aload_0
      //   288: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   291: invokestatic c : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)Ljava/util/List;
      //   294: ifnull -> 364
      //   297: aload_0
      //   298: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   301: invokestatic c : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)Ljava/util/List;
      //   304: invokeinterface isEmpty : ()Z
      //   309: ifne -> 364
      //   312: aload_0
      //   313: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   316: invokestatic c : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)Ljava/util/List;
      //   319: invokeinterface iterator : ()Ljava/util/Iterator;
      //   324: astore_1
      //   325: aload_1
      //   326: invokeinterface hasNext : ()Z
      //   331: ifeq -> 364
      //   334: aload_1
      //   335: invokeinterface next : ()Ljava/lang/Object;
      //   340: checkcast com/blued/android/core/utils/swipeback/SwipeBackLayout$SwipeListener
      //   343: iload #4
      //   345: iload #5
      //   347: fload_2
      //   348: fload_3
      //   349: aload_0
      //   350: getfield a : Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;
      //   353: invokestatic i : (Lcom/blued/android/core/utils/swipeback/SwipeBackLayout;)F
      //   356: invokeinterface a : (IIFFF)V
      //   361: goto -> 325
      //   364: return
    }
    
    public boolean tryCaptureView(View param1View, int param1Int) {
      boolean bool;
      int k = SwipeBackLayout.b(this.a).isEdgeTouched(SwipeBackLayout.a(this.a), param1Int);
      int j = 1;
      if (k) {
        if (SwipeBackLayout.b(this.a).isEdgeTouched(1, param1Int)) {
          SwipeBackLayout.a(this.a, 1);
        } else if (SwipeBackLayout.b(this.a).isEdgeTouched(2, param1Int)) {
          SwipeBackLayout.a(this.a, 2);
        } else if (SwipeBackLayout.b(this.a).isEdgeTouched(8, param1Int)) {
          SwipeBackLayout.a(this.a, 8);
        } 
        if (SwipeBackLayout.c(this.a) != null && !SwipeBackLayout.c(this.a).isEmpty()) {
          Iterator<SwipeBackLayout.SwipeListener> iterator = SwipeBackLayout.c(this.a).iterator();
          while (iterator.hasNext())
            ((SwipeBackLayout.SwipeListener)iterator.next()).a(SwipeBackLayout.d(this.a)); 
        } 
        this.b = true;
      } 
      if (SwipeBackLayout.a(this.a) == 1 || SwipeBackLayout.a(this.a) == 2) {
        bool = SwipeBackLayout.b(this.a).checkTouchSlop(2, param1Int);
      } else if (SwipeBackLayout.a(this.a) == 8) {
        bool = SwipeBackLayout.b(this.a).checkTouchSlop(1, param1Int);
      } else {
        if (SwipeBackLayout.a(this.a) == 11) {
          param1Int = j;
        } else {
          param1Int = 0;
        } 
        return k & param1Int;
      } 
      int i = true ^ bool;
      return k & i;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\swipeback\SwipeBackLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */