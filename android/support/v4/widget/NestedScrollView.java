package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;

public class NestedScrollView extends FrameLayout implements NestedScrollingChild2, NestedScrollingParent {
  private static final NestedScrollView$AccessibilityDelegate ACCESSIBILITY_DELEGATE = new NestedScrollView$AccessibilityDelegate();
  
  private static final int[] SCROLLVIEW_STYLEABLE = new int[] { 16843130 };
  
  private int mActivePointerId = -1;
  
  private final NestedScrollingChildHelper mChildHelper;
  
  private View mChildToScrollTo = null;
  
  private EdgeEffect mEdgeGlowBottom;
  
  private EdgeEffect mEdgeGlowTop;
  
  private boolean mFillViewport;
  
  private boolean mIsBeingDragged = false;
  
  private boolean mIsLaidOut = false;
  
  private boolean mIsLayoutDirty = true;
  
  private int mLastMotionY;
  
  private long mLastScroll;
  
  private int mLastScrollerY;
  
  private int mMaximumVelocity;
  
  private int mMinimumVelocity;
  
  private int mNestedYOffset;
  
  private final NestedScrollingParentHelper mParentHelper;
  
  private NestedScrollView$SavedState mSavedState;
  
  private final int[] mScrollConsumed = new int[2];
  
  private final int[] mScrollOffset = new int[2];
  
  private OverScroller mScroller = new OverScroller(getContext());
  
  private boolean mSmoothScrollingEnabled = true;
  
  private final Rect mTempRect = new Rect();
  
  private int mTouchSlop;
  
  private VelocityTracker mVelocityTracker;
  
  private float mVerticalScrollFactor;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public NestedScrollView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, SCROLLVIEW_STYLEABLE, paramInt, 0);
    boolean bool = typedArray.getBoolean(0, false);
    if (bool != this.mFillViewport) {
      this.mFillViewport = bool;
      requestLayout();
    } 
    typedArray.recycle();
    this.mParentHelper = new NestedScrollingParentHelper();
    this.mChildHelper = new NestedScrollingChildHelper((View)this);
    setNestedScrollingEnabled(true);
    ViewCompat.setAccessibilityDelegate((View)this, ACCESSIBILITY_DELEGATE);
  }
  
  private boolean arrowScroll(int paramInt) {
    View view2 = findFocus();
    View view1 = view2;
    if (view2 == this)
      view1 = null; 
    view2 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view1, paramInt);
    int i = (int)(getHeight() * 0.5F);
    if (view2 != null && isWithinDeltaOfScreen(view2, i, getHeight())) {
      view2.getDrawingRect(this.mTempRect);
      offsetDescendantRectToMyCoords(view2, this.mTempRect);
      doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      view2.requestFocus(paramInt);
    } else {
      int j;
      if (paramInt == 33 && getScrollY() < i) {
        j = getScrollY();
      } else {
        j = i;
        if (paramInt == 130) {
          j = i;
          if (getChildCount() > 0) {
            int k = getChildAt(0).getBottom() - getScrollY() + getHeight() - getPaddingBottom();
            j = i;
            if (k < i)
              j = k; 
          } 
        } 
      } 
      if (j == 0)
        return false; 
      if (paramInt != 130)
        j = -j; 
      doScrollY(j);
    } 
    if (view1 != null && view1.isFocused() && isOffScreen(view1)) {
      paramInt = getDescendantFocusability();
      setDescendantFocusability(131072);
      requestFocus();
      setDescendantFocusability(paramInt);
    } 
    return true;
  }
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt2 >= paramInt3 || paramInt1 < 0) ? 0 : ((paramInt2 + paramInt1 > paramInt3) ? (paramInt3 - paramInt2) : paramInt1);
  }
  
  private int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect) {
    int i = getChildCount();
    boolean bool = false;
    if (i == 0)
      return 0; 
    int m = getHeight();
    i = getScrollY();
    int k = i + m;
    int n = getVerticalFadingEdgeLength();
    int j = i;
    if (paramRect.top > 0)
      j = i + n; 
    i = k;
    if (paramRect.bottom < getChildAt(0).getHeight())
      i = k - n; 
    if (paramRect.bottom > i && paramRect.top > j) {
      if (paramRect.height() > m) {
        j = paramRect.top - j + 0;
      } else {
        j = paramRect.bottom - i + 0;
      } 
      return Math.min(j, getChildAt(0).getBottom() - i);
    } 
    k = bool;
    if (paramRect.top < j) {
      k = bool;
      if (paramRect.bottom < i) {
        if (paramRect.height() > m) {
          i = 0 - i - paramRect.bottom;
        } else {
          i = 0 - j - paramRect.top;
        } 
        k = Math.max(i, -getScrollY());
      } 
    } 
    return k;
  }
  
  private boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt3) {
    return this.mChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, paramInt3);
  }
  
  private boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, int paramInt5) {
    return this.mChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, paramInt5);
  }
  
  private void doScrollY(int paramInt) {
    if (paramInt != 0) {
      if (this.mSmoothScrollingEnabled) {
        smoothScrollBy(0, paramInt);
        return;
      } 
      scrollBy(0, paramInt);
    } 
  }
  
  private void endDrag() {
    this.mIsBeingDragged = false;
    recycleVelocityTracker();
    stopNestedScroll(0);
    if (this.mEdgeGlowTop != null) {
      this.mEdgeGlowTop.onRelease();
      this.mEdgeGlowBottom.onRelease();
    } 
  }
  
  private void ensureGlows() {
    if (getOverScrollMode() != 2) {
      if (this.mEdgeGlowTop == null) {
        Context context = getContext();
        this.mEdgeGlowTop = new EdgeEffect(context);
        this.mEdgeGlowBottom = new EdgeEffect(context);
        return;
      } 
    } else {
      this.mEdgeGlowTop = null;
      this.mEdgeGlowBottom = null;
    } 
  }
  
  private void flingWithNestedDispatch(int paramInt) {
    boolean bool;
    int i = getScrollY();
    if ((i > 0 || paramInt > 0) && (i < getScrollRange() || paramInt < 0)) {
      bool = true;
    } else {
      bool = false;
    } 
    float f = paramInt;
    if (!dispatchNestedPreFling(0.0F, f)) {
      dispatchNestedFling(0.0F, f, bool);
      if (getChildCount() > 0) {
        startNestedScroll(2, 1);
        this.mScroller.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
        this.mLastScrollerY = getScrollY();
        ViewCompat.postInvalidateOnAnimation((View)this);
      } 
    } 
  }
  
  private boolean fullScroll(int paramInt) {
    int i;
    if (paramInt == 130) {
      i = 1;
    } else {
      i = 0;
    } 
    int j = getHeight();
    this.mTempRect.top = 0;
    this.mTempRect.bottom = j;
    if (i) {
      i = getChildCount();
      if (i > 0) {
        View view = getChildAt(i - 1);
        this.mTempRect.bottom = view.getBottom() + getPaddingBottom();
        this.mTempRect.top = this.mTempRect.bottom - j;
      } 
    } 
    return scrollAndFocus(paramInt, this.mTempRect.top, this.mTempRect.bottom);
  }
  
  private boolean hasNestedScrollingParent(int paramInt) {
    return this.mChildHelper.hasNestedScrollingParent(paramInt);
  }
  
  private void initVelocityTrackerIfNotExists() {
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain(); 
  }
  
  private boolean isOffScreen(View paramView) {
    return !isWithinDeltaOfScreen(paramView, 0, getHeight());
  }
  
  private static boolean isViewDescendantOf(View paramView1, View paramView2) {
    if (paramView1 == paramView2)
      return true; 
    ViewParent viewParent = paramView1.getParent();
    return (viewParent instanceof ViewGroup && isViewDescendantOf((View)viewParent, paramView2));
  }
  
  private boolean isWithinDeltaOfScreen(View paramView, int paramInt1, int paramInt2) {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    return (this.mTempRect.bottom + paramInt1 >= getScrollY() && this.mTempRect.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.mLastMotionY = (int)paramMotionEvent.getY(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null)
        this.mVelocityTracker.clear(); 
    } 
  }
  
  private boolean overScrollByCompat$30fc967d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getOverScrollMode : ()I
    //   4: istore #11
    //   6: aload_0
    //   7: invokevirtual computeHorizontalScrollRange : ()I
    //   10: aload_0
    //   11: invokevirtual computeHorizontalScrollExtent : ()I
    //   14: if_icmple -> 23
    //   17: iconst_1
    //   18: istore #9
    //   20: goto -> 26
    //   23: iconst_0
    //   24: istore #9
    //   26: aload_0
    //   27: invokevirtual computeVerticalScrollRange : ()I
    //   30: aload_0
    //   31: invokevirtual computeVerticalScrollExtent : ()I
    //   34: if_icmple -> 43
    //   37: iconst_1
    //   38: istore #10
    //   40: goto -> 46
    //   43: iconst_0
    //   44: istore #10
    //   46: iload #11
    //   48: ifeq -> 71
    //   51: iload #11
    //   53: iconst_1
    //   54: if_icmpne -> 65
    //   57: iload #9
    //   59: ifeq -> 65
    //   62: goto -> 71
    //   65: iconst_0
    //   66: istore #9
    //   68: goto -> 74
    //   71: iconst_1
    //   72: istore #9
    //   74: iload #11
    //   76: ifeq -> 99
    //   79: iload #11
    //   81: iconst_1
    //   82: if_icmpne -> 93
    //   85: iload #10
    //   87: ifeq -> 93
    //   90: goto -> 99
    //   93: iconst_0
    //   94: istore #10
    //   96: goto -> 102
    //   99: iconst_1
    //   100: istore #10
    //   102: iload_3
    //   103: iload_1
    //   104: iadd
    //   105: istore_3
    //   106: iload #9
    //   108: ifne -> 116
    //   111: iconst_0
    //   112: istore_1
    //   113: goto -> 119
    //   116: iload #7
    //   118: istore_1
    //   119: iload #4
    //   121: iload_2
    //   122: iadd
    //   123: istore #4
    //   125: iload #10
    //   127: ifne -> 135
    //   130: iconst_0
    //   131: istore_2
    //   132: goto -> 138
    //   135: iload #8
    //   137: istore_2
    //   138: iload_1
    //   139: ineg
    //   140: istore #7
    //   142: iload_1
    //   143: iload #5
    //   145: iadd
    //   146: istore_1
    //   147: iload_2
    //   148: ineg
    //   149: istore #5
    //   151: iload_2
    //   152: iload #6
    //   154: iadd
    //   155: istore #6
    //   157: iload_3
    //   158: iload_1
    //   159: if_icmple -> 170
    //   162: iconst_1
    //   163: istore #12
    //   165: iload_1
    //   166: istore_2
    //   167: goto -> 187
    //   170: iload_3
    //   171: iload #7
    //   173: if_icmpge -> 182
    //   176: iload #7
    //   178: istore_1
    //   179: goto -> 162
    //   182: iload_3
    //   183: istore_2
    //   184: iconst_0
    //   185: istore #12
    //   187: iload #4
    //   189: iload #6
    //   191: if_icmple -> 203
    //   194: iload #6
    //   196: istore_1
    //   197: iconst_1
    //   198: istore #13
    //   200: goto -> 222
    //   203: iload #4
    //   205: iload #5
    //   207: if_icmpge -> 216
    //   210: iload #5
    //   212: istore_1
    //   213: goto -> 197
    //   216: iload #4
    //   218: istore_1
    //   219: iconst_0
    //   220: istore #13
    //   222: iload #13
    //   224: ifeq -> 252
    //   227: aload_0
    //   228: iconst_1
    //   229: invokespecial hasNestedScrollingParent : (I)Z
    //   232: ifne -> 252
    //   235: aload_0
    //   236: getfield mScroller : Landroid/widget/OverScroller;
    //   239: iload_2
    //   240: iload_1
    //   241: iconst_0
    //   242: iconst_0
    //   243: iconst_0
    //   244: aload_0
    //   245: invokevirtual getScrollRange : ()I
    //   248: invokevirtual springBack : (IIIIII)Z
    //   251: pop
    //   252: aload_0
    //   253: iload_2
    //   254: iload_1
    //   255: iload #12
    //   257: iload #13
    //   259: invokevirtual onOverScrolled : (IIZZ)V
    //   262: iload #12
    //   264: ifne -> 276
    //   267: iload #13
    //   269: ifeq -> 274
    //   272: iconst_1
    //   273: ireturn
    //   274: iconst_0
    //   275: ireturn
    //   276: iconst_1
    //   277: ireturn
  }
  
  private void recycleVelocityTracker() {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    } 
  }
  
  private boolean scrollAndFocus(int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getHeight : ()I
    //   4: istore #4
    //   6: aload_0
    //   7: invokevirtual getScrollY : ()I
    //   10: istore #10
    //   12: iload #4
    //   14: iload #10
    //   16: iadd
    //   17: istore #11
    //   19: iload_1
    //   20: bipush #33
    //   22: if_icmpne -> 31
    //   25: iconst_1
    //   26: istore #6
    //   28: goto -> 34
    //   31: iconst_0
    //   32: istore #6
    //   34: aload_0
    //   35: iconst_2
    //   36: invokevirtual getFocusables : (I)Ljava/util/ArrayList;
    //   39: astore #18
    //   41: aload #18
    //   43: invokeinterface size : ()I
    //   48: istore #12
    //   50: aconst_null
    //   51: astore #16
    //   53: iconst_0
    //   54: istore #7
    //   56: iconst_0
    //   57: istore #8
    //   59: iload #7
    //   61: iload #12
    //   63: if_icmpge -> 285
    //   66: aload #18
    //   68: iload #7
    //   70: invokeinterface get : (I)Ljava/lang/Object;
    //   75: checkcast android/view/View
    //   78: astore #17
    //   80: aload #17
    //   82: invokevirtual getTop : ()I
    //   85: istore #9
    //   87: aload #17
    //   89: invokevirtual getBottom : ()I
    //   92: istore #13
    //   94: aload #16
    //   96: astore #15
    //   98: iload #8
    //   100: istore #5
    //   102: iload_2
    //   103: iload #13
    //   105: if_icmpge -> 268
    //   108: aload #16
    //   110: astore #15
    //   112: iload #8
    //   114: istore #5
    //   116: iload #9
    //   118: iload_3
    //   119: if_icmpge -> 268
    //   122: iload_2
    //   123: iload #9
    //   125: if_icmpge -> 140
    //   128: iload #13
    //   130: iload_3
    //   131: if_icmpge -> 140
    //   134: iconst_1
    //   135: istore #4
    //   137: goto -> 143
    //   140: iconst_0
    //   141: istore #4
    //   143: aload #16
    //   145: ifnonnull -> 159
    //   148: aload #17
    //   150: astore #15
    //   152: iload #4
    //   154: istore #5
    //   156: goto -> 268
    //   159: iload #6
    //   161: ifeq -> 174
    //   164: iload #9
    //   166: aload #16
    //   168: invokevirtual getTop : ()I
    //   171: if_icmplt -> 189
    //   174: iload #6
    //   176: ifne -> 195
    //   179: iload #13
    //   181: aload #16
    //   183: invokevirtual getBottom : ()I
    //   186: if_icmple -> 195
    //   189: iconst_1
    //   190: istore #9
    //   192: goto -> 198
    //   195: iconst_0
    //   196: istore #9
    //   198: iload #8
    //   200: ifeq -> 232
    //   203: aload #16
    //   205: astore #15
    //   207: iload #8
    //   209: istore #5
    //   211: iload #4
    //   213: ifeq -> 268
    //   216: aload #16
    //   218: astore #15
    //   220: iload #8
    //   222: istore #5
    //   224: iload #9
    //   226: ifeq -> 268
    //   229: goto -> 260
    //   232: iload #4
    //   234: ifeq -> 247
    //   237: aload #17
    //   239: astore #15
    //   241: iconst_1
    //   242: istore #5
    //   244: goto -> 268
    //   247: aload #16
    //   249: astore #15
    //   251: iload #8
    //   253: istore #5
    //   255: iload #9
    //   257: ifeq -> 268
    //   260: aload #17
    //   262: astore #15
    //   264: iload #8
    //   266: istore #5
    //   268: iload #7
    //   270: iconst_1
    //   271: iadd
    //   272: istore #7
    //   274: aload #15
    //   276: astore #16
    //   278: iload #5
    //   280: istore #8
    //   282: goto -> 59
    //   285: aload #16
    //   287: astore #15
    //   289: aload #16
    //   291: ifnonnull -> 297
    //   294: aload_0
    //   295: astore #15
    //   297: iload_2
    //   298: iload #10
    //   300: if_icmplt -> 315
    //   303: iload_3
    //   304: iload #11
    //   306: if_icmpgt -> 315
    //   309: iconst_0
    //   310: istore #14
    //   312: goto -> 341
    //   315: iload #6
    //   317: ifeq -> 328
    //   320: iload_2
    //   321: iload #10
    //   323: isub
    //   324: istore_2
    //   325: goto -> 333
    //   328: iload_3
    //   329: iload #11
    //   331: isub
    //   332: istore_2
    //   333: aload_0
    //   334: iload_2
    //   335: invokespecial doScrollY : (I)V
    //   338: iconst_1
    //   339: istore #14
    //   341: aload #15
    //   343: aload_0
    //   344: invokevirtual findFocus : ()Landroid/view/View;
    //   347: if_acmpeq -> 357
    //   350: aload #15
    //   352: iload_1
    //   353: invokevirtual requestFocus : (I)Z
    //   356: pop
    //   357: iload #14
    //   359: ireturn
  }
  
  private void scrollToChild(View paramView) {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    if (i != 0)
      scrollBy(0, i); 
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2) {
    if (getChildCount() == 0)
      return; 
    if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L) {
      paramInt1 = getHeight();
      int i = getPaddingBottom();
      int j = getPaddingTop();
      i = Math.max(0, getChildAt(0).getHeight() - paramInt1 - i - j);
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt2 + paramInt1, i));
      this.mScroller.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      ViewCompat.postInvalidateOnAnimation((View)this);
    } else {
      if (!this.mScroller.isFinished())
        this.mScroller.abortAnimation(); 
      scrollBy(paramInt1, paramInt2);
    } 
    this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
  }
  
  private boolean startNestedScroll(int paramInt1, int paramInt2) {
    return this.mChildHelper.startNestedScroll(paramInt1, paramInt2);
  }
  
  private void stopNestedScroll(int paramInt) {
    this.mChildHelper.stopNestedScroll(paramInt);
  }
  
  public void addView(View paramView) {
    if (getChildCount() <= 0) {
      super.addView(paramView);
      return;
    } 
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt) {
    if (getChildCount() <= 0) {
      super.addView(paramView, paramInt);
      return;
    } 
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    if (getChildCount() <= 0) {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    } 
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    if (getChildCount() <= 0) {
      super.addView(paramView, paramLayoutParams);
      return;
    } 
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public int computeHorizontalScrollExtent() {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset() {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange() {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll() {
    boolean bool1 = this.mScroller.computeScrollOffset();
    boolean bool = false;
    if (bool1) {
      this.mScroller.getCurrX();
      int k = this.mScroller.getCurrY();
      int j = k - this.mLastScrollerY;
      int i = j;
      if (dispatchNestedPreScroll(0, j, this.mScrollConsumed, (int[])null, 1))
        i = j - this.mScrollConsumed[1]; 
      if (i != 0) {
        j = getScrollRange();
        int m = getScrollY();
        overScrollByCompat$30fc967d(0, i, getScrollX(), m, 0, j, 0, 0);
        int n = getScrollY() - m;
        if (!dispatchNestedScroll(0, n, 0, i - n, (int[])null, 1)) {
          i = getOverScrollMode();
          if (i == 0 || (i == 1 && j > 0)) {
            i = 1;
          } else {
            i = bool;
          } 
          if (i != 0) {
            ensureGlows();
            if (k <= 0 && m > 0) {
              this.mEdgeGlowTop.onAbsorb((int)this.mScroller.getCurrVelocity());
            } else if (k >= j && m < j) {
              this.mEdgeGlowBottom.onAbsorb((int)this.mScroller.getCurrVelocity());
            } 
          } 
        } 
      } 
      this.mLastScrollerY = k;
      ViewCompat.postInvalidateOnAnimation((View)this);
      return;
    } 
    if (hasNestedScrollingParent(1))
      stopNestedScroll(1); 
    this.mLastScrollerY = 0;
  }
  
  public int computeVerticalScrollExtent() {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset() {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange() {
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0)
      return i; 
    j = getChildAt(0).getBottom();
    int k = getScrollY();
    int m = Math.max(0, j - i);
    if (k < 0)
      return j - k; 
    i = j;
    if (k > m)
      i = j + k - m; 
    return i;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial dispatchKeyEvent : (Landroid/view/KeyEvent;)Z
    //   5: ifne -> 435
    //   8: aload_0
    //   9: getfield mTempRect : Landroid/graphics/Rect;
    //   12: invokevirtual setEmpty : ()V
    //   15: aload_0
    //   16: iconst_0
    //   17: invokevirtual getChildAt : (I)Landroid/view/View;
    //   20: astore #6
    //   22: aload #6
    //   24: ifnull -> 59
    //   27: aload #6
    //   29: invokevirtual getHeight : ()I
    //   32: istore_2
    //   33: aload_0
    //   34: invokevirtual getHeight : ()I
    //   37: iload_2
    //   38: aload_0
    //   39: invokevirtual getPaddingTop : ()I
    //   42: iadd
    //   43: aload_0
    //   44: invokevirtual getPaddingBottom : ()I
    //   47: iadd
    //   48: if_icmpge -> 56
    //   51: iconst_1
    //   52: istore_2
    //   53: goto -> 61
    //   56: goto -> 59
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: ifne -> 143
    //   65: aload_0
    //   66: invokevirtual isFocused : ()Z
    //   69: ifeq -> 137
    //   72: aload_1
    //   73: invokevirtual getKeyCode : ()I
    //   76: iconst_4
    //   77: if_icmpeq -> 137
    //   80: aload_0
    //   81: invokevirtual findFocus : ()Landroid/view/View;
    //   84: astore #6
    //   86: aload #6
    //   88: astore_1
    //   89: aload #6
    //   91: aload_0
    //   92: if_acmpne -> 97
    //   95: aconst_null
    //   96: astore_1
    //   97: invokestatic getInstance : ()Landroid/view/FocusFinder;
    //   100: aload_0
    //   101: aload_1
    //   102: sipush #130
    //   105: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull -> 134
    //   113: aload_1
    //   114: aload_0
    //   115: if_acmpeq -> 134
    //   118: aload_1
    //   119: sipush #130
    //   122: invokevirtual requestFocus : (I)Z
    //   125: ifeq -> 134
    //   128: iconst_1
    //   129: istore #5
    //   131: goto -> 426
    //   134: goto -> 137
    //   137: iconst_0
    //   138: istore #5
    //   140: goto -> 426
    //   143: aload_1
    //   144: invokevirtual getAction : ()I
    //   147: ifne -> 423
    //   150: aload_1
    //   151: invokevirtual getKeyCode : ()I
    //   154: istore_3
    //   155: bipush #33
    //   157: istore_2
    //   158: iload_3
    //   159: bipush #62
    //   161: if_icmpeq -> 251
    //   164: iload_3
    //   165: tableswitch default -> 188, 19 -> 222, 20 -> 191
    //   188: goto -> 423
    //   191: aload_1
    //   192: invokevirtual isAltPressed : ()Z
    //   195: ifne -> 210
    //   198: aload_0
    //   199: sipush #130
    //   202: invokespecial arrowScroll : (I)Z
    //   205: istore #5
    //   207: goto -> 426
    //   210: aload_0
    //   211: sipush #130
    //   214: invokespecial fullScroll : (I)Z
    //   217: istore #5
    //   219: goto -> 426
    //   222: aload_1
    //   223: invokevirtual isAltPressed : ()Z
    //   226: ifne -> 240
    //   229: aload_0
    //   230: bipush #33
    //   232: invokespecial arrowScroll : (I)Z
    //   235: istore #5
    //   237: goto -> 426
    //   240: aload_0
    //   241: bipush #33
    //   243: invokespecial fullScroll : (I)Z
    //   246: istore #5
    //   248: goto -> 426
    //   251: aload_1
    //   252: invokevirtual isShiftPressed : ()Z
    //   255: ifeq -> 261
    //   258: goto -> 265
    //   261: sipush #130
    //   264: istore_2
    //   265: iload_2
    //   266: sipush #130
    //   269: if_icmpne -> 277
    //   272: iconst_1
    //   273: istore_3
    //   274: goto -> 279
    //   277: iconst_0
    //   278: istore_3
    //   279: aload_0
    //   280: invokevirtual getHeight : ()I
    //   283: istore #4
    //   285: iload_3
    //   286: ifeq -> 354
    //   289: aload_0
    //   290: getfield mTempRect : Landroid/graphics/Rect;
    //   293: aload_0
    //   294: invokevirtual getScrollY : ()I
    //   297: iload #4
    //   299: iadd
    //   300: putfield top : I
    //   303: aload_0
    //   304: invokevirtual getChildCount : ()I
    //   307: istore_3
    //   308: iload_3
    //   309: ifle -> 351
    //   312: aload_0
    //   313: iload_3
    //   314: iconst_1
    //   315: isub
    //   316: invokevirtual getChildAt : (I)Landroid/view/View;
    //   319: astore_1
    //   320: aload_0
    //   321: getfield mTempRect : Landroid/graphics/Rect;
    //   324: getfield top : I
    //   327: iload #4
    //   329: iadd
    //   330: aload_1
    //   331: invokevirtual getBottom : ()I
    //   334: if_icmple -> 351
    //   337: aload_0
    //   338: getfield mTempRect : Landroid/graphics/Rect;
    //   341: aload_1
    //   342: invokevirtual getBottom : ()I
    //   345: iload #4
    //   347: isub
    //   348: putfield top : I
    //   351: goto -> 386
    //   354: aload_0
    //   355: getfield mTempRect : Landroid/graphics/Rect;
    //   358: aload_0
    //   359: invokevirtual getScrollY : ()I
    //   362: iload #4
    //   364: isub
    //   365: putfield top : I
    //   368: aload_0
    //   369: getfield mTempRect : Landroid/graphics/Rect;
    //   372: getfield top : I
    //   375: ifge -> 386
    //   378: aload_0
    //   379: getfield mTempRect : Landroid/graphics/Rect;
    //   382: iconst_0
    //   383: putfield top : I
    //   386: aload_0
    //   387: getfield mTempRect : Landroid/graphics/Rect;
    //   390: aload_0
    //   391: getfield mTempRect : Landroid/graphics/Rect;
    //   394: getfield top : I
    //   397: iload #4
    //   399: iadd
    //   400: putfield bottom : I
    //   403: aload_0
    //   404: iload_2
    //   405: aload_0
    //   406: getfield mTempRect : Landroid/graphics/Rect;
    //   409: getfield top : I
    //   412: aload_0
    //   413: getfield mTempRect : Landroid/graphics/Rect;
    //   416: getfield bottom : I
    //   419: invokespecial scrollAndFocus : (III)Z
    //   422: pop
    //   423: iconst_0
    //   424: istore #5
    //   426: iload #5
    //   428: ifeq -> 433
    //   431: iconst_1
    //   432: ireturn
    //   433: iconst_0
    //   434: ireturn
    //   435: iconst_1
    //   436: ireturn
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
    if (nestedScrollingChildHelper.mIsNestedScrollingEnabled) {
      ViewParent viewParent = nestedScrollingChildHelper.getNestedScrollingParentForType(0);
      if (viewParent != null)
        return ViewParentCompat.onNestedFling(viewParent, nestedScrollingChildHelper.mView, paramFloat1, paramFloat2, paramBoolean); 
    } 
    return false;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
    if (nestedScrollingChildHelper.mIsNestedScrollingEnabled) {
      ViewParent viewParent = nestedScrollingChildHelper.getNestedScrollingParentForType(0);
      if (viewParent != null)
        return ViewParentCompat.onNestedPreFling(viewParent, nestedScrollingChildHelper.mView, paramFloat1, paramFloat2); 
    } 
    return false;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return this.mChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, 0);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return this.mChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, 0);
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    if (this.mEdgeGlowTop != null) {
      int i = getScrollY();
      if (!this.mEdgeGlowTop.isFinished()) {
        int j = paramCanvas.save();
        int k = getWidth();
        int m = getPaddingLeft();
        int n = getPaddingRight();
        paramCanvas.translate(getPaddingLeft(), Math.min(0, i));
        this.mEdgeGlowTop.setSize(k - m - n, getHeight());
        if (this.mEdgeGlowTop.draw(paramCanvas))
          ViewCompat.postInvalidateOnAnimation((View)this); 
        paramCanvas.restoreToCount(j);
      } 
      if (!this.mEdgeGlowBottom.isFinished()) {
        int j = paramCanvas.save();
        int k = getWidth() - getPaddingLeft() - getPaddingRight();
        int m = getHeight();
        paramCanvas.translate((-k + getPaddingLeft()), (Math.max(getScrollRange(), i) + m));
        paramCanvas.rotate(180.0F, k, 0.0F);
        this.mEdgeGlowBottom.setSize(k, m);
        if (this.mEdgeGlowBottom.draw(paramCanvas))
          ViewCompat.postInvalidateOnAnimation((View)this); 
        paramCanvas.restoreToCount(j);
      } 
    } 
  }
  
  protected float getBottomFadingEdgeStrength() {
    if (getChildCount() == 0)
      return 0.0F; 
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = getChildAt(0).getBottom() - getScrollY() - j - k;
    return (j < i) ? (j / i) : 1.0F;
  }
  
  public int getNestedScrollAxes() {
    return this.mParentHelper.mNestedScrollAxes;
  }
  
  final int getScrollRange() {
    int j = getChildCount();
    int i = 0;
    if (j > 0)
      i = Math.max(0, getChildAt(0).getHeight() - getHeight() - getPaddingBottom() - getPaddingTop()); 
    return i;
  }
  
  protected float getTopFadingEdgeStrength() {
    if (getChildCount() == 0)
      return 0.0F; 
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    return (j < i) ? (j / i) : 1.0F;
  }
  
  public boolean hasNestedScrollingParent() {
    return this.mChildHelper.hasNestedScrollingParent(0);
  }
  
  public boolean isNestedScrollingEnabled() {
    return this.mChildHelper.mIsNestedScrollingEnabled;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2) {
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + paramInt2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mIsLaidOut = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      if (paramMotionEvent.getAction() != 8)
        return false; 
      if (!this.mIsBeingDragged) {
        float f = paramMotionEvent.getAxisValue(9);
        if (f != 0.0F) {
          if (this.mVerticalScrollFactor == 0.0F) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
              this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
              throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            } 
          } 
          int i = (int)(f * this.mVerticalScrollFactor);
          int j = getScrollRange();
          int m = getScrollY();
          int k = m - i;
          if (k < 0) {
            i = 0;
          } else {
            i = k;
            if (k > j)
              i = j; 
          } 
          if (i != m) {
            super.scrollTo(getScrollX(), i);
            return true;
          } 
        } 
      } 
    } 
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getAction : ()I
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_2
    //   7: if_icmpne -> 19
    //   10: aload_0
    //   11: getfield mIsBeingDragged : Z
    //   14: ifeq -> 19
    //   17: iconst_1
    //   18: ireturn
    //   19: iload_2
    //   20: sipush #255
    //   23: iand
    //   24: istore_2
    //   25: iload_2
    //   26: bipush #6
    //   28: if_icmpeq -> 433
    //   31: iload_2
    //   32: tableswitch default -> 64, 0 -> 256, 1 -> 205, 2 -> 67, 3 -> 205
    //   64: goto -> 438
    //   67: aload_0
    //   68: getfield mActivePointerId : I
    //   71: istore_2
    //   72: iload_2
    //   73: iconst_m1
    //   74: if_icmpeq -> 438
    //   77: aload_1
    //   78: iload_2
    //   79: invokevirtual findPointerIndex : (I)I
    //   82: istore_3
    //   83: iload_3
    //   84: iconst_m1
    //   85: if_icmpne -> 127
    //   88: new java/lang/StringBuilder
    //   91: dup
    //   92: ldc_w 'Invalid pointerId='
    //   95: invokespecial <init> : (Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: iload_2
    //   101: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_1
    //   106: ldc_w ' in onInterceptTouchEvent'
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc_w 'NestedScrollView'
    //   116: aload_1
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   123: pop
    //   124: goto -> 438
    //   127: aload_1
    //   128: iload_3
    //   129: invokevirtual getY : (I)F
    //   132: f2i
    //   133: istore_2
    //   134: iload_2
    //   135: aload_0
    //   136: getfield mLastMotionY : I
    //   139: isub
    //   140: invokestatic abs : (I)I
    //   143: aload_0
    //   144: getfield mTouchSlop : I
    //   147: if_icmple -> 438
    //   150: iconst_2
    //   151: aload_0
    //   152: invokevirtual getNestedScrollAxes : ()I
    //   155: iand
    //   156: ifne -> 438
    //   159: aload_0
    //   160: iconst_1
    //   161: putfield mIsBeingDragged : Z
    //   164: aload_0
    //   165: iload_2
    //   166: putfield mLastMotionY : I
    //   169: aload_0
    //   170: invokespecial initVelocityTrackerIfNotExists : ()V
    //   173: aload_0
    //   174: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   177: aload_1
    //   178: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield mNestedYOffset : I
    //   186: aload_0
    //   187: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   190: astore_1
    //   191: aload_1
    //   192: ifnull -> 202
    //   195: aload_1
    //   196: iconst_1
    //   197: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   202: goto -> 438
    //   205: aload_0
    //   206: iconst_0
    //   207: putfield mIsBeingDragged : Z
    //   210: aload_0
    //   211: iconst_m1
    //   212: putfield mActivePointerId : I
    //   215: aload_0
    //   216: invokespecial recycleVelocityTracker : ()V
    //   219: aload_0
    //   220: getfield mScroller : Landroid/widget/OverScroller;
    //   223: aload_0
    //   224: invokevirtual getScrollX : ()I
    //   227: aload_0
    //   228: invokevirtual getScrollY : ()I
    //   231: iconst_0
    //   232: iconst_0
    //   233: iconst_0
    //   234: aload_0
    //   235: invokevirtual getScrollRange : ()I
    //   238: invokevirtual springBack : (IIIIII)Z
    //   241: ifeq -> 248
    //   244: aload_0
    //   245: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   248: aload_0
    //   249: iconst_0
    //   250: invokespecial stopNestedScroll : (I)V
    //   253: goto -> 438
    //   256: aload_1
    //   257: invokevirtual getY : ()F
    //   260: f2i
    //   261: istore_3
    //   262: aload_1
    //   263: invokevirtual getX : ()F
    //   266: f2i
    //   267: istore_2
    //   268: aload_0
    //   269: invokevirtual getChildCount : ()I
    //   272: ifle -> 338
    //   275: aload_0
    //   276: invokevirtual getScrollY : ()I
    //   279: istore #4
    //   281: aload_0
    //   282: iconst_0
    //   283: invokevirtual getChildAt : (I)Landroid/view/View;
    //   286: astore #5
    //   288: iload_3
    //   289: aload #5
    //   291: invokevirtual getTop : ()I
    //   294: iload #4
    //   296: isub
    //   297: if_icmplt -> 335
    //   300: iload_3
    //   301: aload #5
    //   303: invokevirtual getBottom : ()I
    //   306: iload #4
    //   308: isub
    //   309: if_icmpge -> 335
    //   312: iload_2
    //   313: aload #5
    //   315: invokevirtual getLeft : ()I
    //   318: if_icmplt -> 335
    //   321: iload_2
    //   322: aload #5
    //   324: invokevirtual getRight : ()I
    //   327: if_icmpge -> 335
    //   330: iconst_1
    //   331: istore_2
    //   332: goto -> 340
    //   335: goto -> 338
    //   338: iconst_0
    //   339: istore_2
    //   340: iload_2
    //   341: ifne -> 356
    //   344: aload_0
    //   345: iconst_0
    //   346: putfield mIsBeingDragged : Z
    //   349: aload_0
    //   350: invokespecial recycleVelocityTracker : ()V
    //   353: goto -> 438
    //   356: aload_0
    //   357: iload_3
    //   358: putfield mLastMotionY : I
    //   361: aload_0
    //   362: aload_1
    //   363: iconst_0
    //   364: invokevirtual getPointerId : (I)I
    //   367: putfield mActivePointerId : I
    //   370: aload_0
    //   371: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   374: ifnonnull -> 387
    //   377: aload_0
    //   378: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   381: putfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   384: goto -> 394
    //   387: aload_0
    //   388: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   391: invokevirtual clear : ()V
    //   394: aload_0
    //   395: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   398: aload_1
    //   399: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   402: aload_0
    //   403: getfield mScroller : Landroid/widget/OverScroller;
    //   406: invokevirtual computeScrollOffset : ()Z
    //   409: pop
    //   410: aload_0
    //   411: aload_0
    //   412: getfield mScroller : Landroid/widget/OverScroller;
    //   415: invokevirtual isFinished : ()Z
    //   418: iconst_1
    //   419: ixor
    //   420: putfield mIsBeingDragged : Z
    //   423: aload_0
    //   424: iconst_2
    //   425: iconst_0
    //   426: invokespecial startNestedScroll : (II)Z
    //   429: pop
    //   430: goto -> 438
    //   433: aload_0
    //   434: aload_1
    //   435: invokespecial onSecondaryPointerUp : (Landroid/view/MotionEvent;)V
    //   438: aload_0
    //   439: getfield mIsBeingDragged : Z
    //   442: ireturn
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mIsLayoutDirty = false;
    if (this.mChildToScrollTo != null && isViewDescendantOf(this.mChildToScrollTo, (View)this))
      scrollToChild(this.mChildToScrollTo); 
    this.mChildToScrollTo = null;
    if (!this.mIsLaidOut) {
      if (this.mSavedState != null) {
        scrollTo(getScrollX(), this.mSavedState.scrollPosition);
        this.mSavedState = null;
      } 
      if (getChildCount() > 0) {
        paramInt1 = getChildAt(0).getMeasuredHeight();
      } else {
        paramInt1 = 0;
      } 
      paramInt1 = Math.max(0, paramInt1 - paramInt4 - paramInt2 - getPaddingBottom() - getPaddingTop());
      if (getScrollY() > paramInt1) {
        scrollTo(getScrollX(), paramInt1);
      } else if (getScrollY() < 0) {
        scrollTo(getScrollX(), 0);
      } 
    } 
    scrollTo(getScrollX(), getScrollY());
    this.mIsLaidOut = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.mFillViewport)
      return; 
    if (View.MeasureSpec.getMode(paramInt2) == 0)
      return; 
    if (getChildCount() > 0) {
      View view = getChildAt(0);
      paramInt2 = getMeasuredHeight();
      if (view.getMeasuredHeight() < paramInt2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        view.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
      } 
    } 
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (!paramBoolean) {
      flingWithNestedDispatch((int)paramFloat2);
      return true;
    } 
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint, (int[])null);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 = getScrollY();
    scrollBy(0, paramInt4);
    paramInt1 = getScrollY() - paramInt1;
    dispatchNestedScroll(0, paramInt1, 0, paramInt4 - paramInt1, (int[])null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.mParentHelper.mNestedScrollAxes = paramInt;
    startNestedScroll(2);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    int i;
    View view;
    if (paramInt == 2) {
      i = 130;
    } else {
      i = paramInt;
      if (paramInt == 1)
        i = 33; 
    } 
    if (paramRect == null) {
      view = FocusFinder.getInstance().findNextFocus((ViewGroup)this, null, i);
    } else {
      view = FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, paramRect, i);
    } 
    return (view == null) ? false : (isOffScreen(view) ? false : view.requestFocus(i, paramRect));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof NestedScrollView$SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    NestedScrollView$SavedState nestedScrollView$SavedState = (NestedScrollView$SavedState)paramParcelable;
    super.onRestoreInstanceState(nestedScrollView$SavedState.getSuperState());
    this.mSavedState = nestedScrollView$SavedState;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState() {
    NestedScrollView$SavedState nestedScrollView$SavedState = new NestedScrollView$SavedState(super.onSaveInstanceState());
    nestedScrollView$SavedState.scrollPosition = getScrollY();
    return (Parcelable)nestedScrollView$SavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View view = findFocus();
    if (view != null) {
      if (this == view)
        return; 
      if (isWithinDeltaOfScreen(view, 0, paramInt4)) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      } 
      return;
    } 
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    return ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView) {
    this.mParentHelper.mNestedScrollAxes = 0;
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    StringBuilder stringBuilder;
    VelocityTracker velocityTracker;
    int j;
    int k;
    int m;
    int n;
    initVelocityTrackerIfNotExists();
    MotionEvent motionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
      this.mNestedYOffset = 0; 
    motionEvent.offsetLocation(0.0F, this.mNestedYOffset);
    switch (i) {
      case 6:
        onSecondaryPointerUp(paramMotionEvent);
        this.mLastMotionY = (int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId));
        break;
      case 5:
        i = paramMotionEvent.getActionIndex();
        this.mLastMotionY = (int)paramMotionEvent.getY(i);
        this.mActivePointerId = paramMotionEvent.getPointerId(i);
        break;
      case 3:
        if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))
          ViewCompat.postInvalidateOnAnimation((View)this); 
        this.mActivePointerId = -1;
        endDrag();
        break;
      case 2:
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (k == -1) {
          stringBuilder = new StringBuilder("Invalid pointerId=");
          stringBuilder.append(this.mActivePointerId);
          stringBuilder.append(" in onTouchEvent");
          Log.e("NestedScrollView", stringBuilder.toString());
          break;
        } 
        m = (int)stringBuilder.getY(k);
        i = this.mLastMotionY - m;
        j = i;
        if (dispatchNestedPreScroll(0, i, this.mScrollConsumed, this.mScrollOffset, 0)) {
          j = i - this.mScrollConsumed[1];
          motionEvent.offsetLocation(0.0F, this.mScrollOffset[1]);
          this.mNestedYOffset += this.mScrollOffset[1];
        } 
        i = j;
        if (!this.mIsBeingDragged) {
          i = j;
          if (Math.abs(j) > this.mTouchSlop) {
            ViewParent viewParent = getParent();
            if (viewParent != null)
              viewParent.requestDisallowInterceptTouchEvent(true); 
            this.mIsBeingDragged = true;
            if (j > 0) {
              i = j - this.mTouchSlop;
            } else {
              i = j + this.mTouchSlop;
            } 
          } 
        } 
        if (this.mIsBeingDragged) {
          this.mLastMotionY = m - this.mScrollOffset[1];
          int i1 = getScrollY();
          m = getScrollRange();
          j = getOverScrollMode();
          if (j == 0 || (j == 1 && m > 0)) {
            j = 1;
          } else {
            j = 0;
          } 
          if (overScrollByCompat$30fc967d(0, i, 0, getScrollY(), 0, m, 0, 0) && !hasNestedScrollingParent(0))
            this.mVelocityTracker.clear(); 
          int i2 = getScrollY() - i1;
          if (dispatchNestedScroll(0, i2, 0, i - i2, this.mScrollOffset, 0)) {
            this.mLastMotionY -= this.mScrollOffset[1];
            motionEvent.offsetLocation(0.0F, this.mScrollOffset[1]);
            this.mNestedYOffset += this.mScrollOffset[1];
            break;
          } 
          if (j != 0) {
            ensureGlows();
            j = i1 + i;
            if (j < 0) {
              EdgeEffectCompat.onPull(this.mEdgeGlowTop, i / getHeight(), stringBuilder.getX(k) / getWidth());
              if (!this.mEdgeGlowBottom.isFinished())
                this.mEdgeGlowBottom.onRelease(); 
            } else if (j > m) {
              EdgeEffectCompat.onPull(this.mEdgeGlowBottom, i / getHeight(), 1.0F - stringBuilder.getX(k) / getWidth());
              if (!this.mEdgeGlowTop.isFinished())
                this.mEdgeGlowTop.onRelease(); 
            } 
            if (this.mEdgeGlowTop != null && (!this.mEdgeGlowTop.isFinished() || !this.mEdgeGlowBottom.isFinished()))
              ViewCompat.postInvalidateOnAnimation((View)this); 
          } 
        } 
        break;
      case 1:
        velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        i = (int)velocityTracker.getYVelocity(this.mActivePointerId);
        if (Math.abs(i) > this.mMinimumVelocity) {
          flingWithNestedDispatch(-i);
        } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
          ViewCompat.postInvalidateOnAnimation((View)this);
        } 
        this.mActivePointerId = -1;
        endDrag();
        break;
      case 0:
        if (getChildCount() == 0)
          return false; 
        n = this.mScroller.isFinished() ^ true;
        this.mIsBeingDragged = n;
        if (n != 0) {
          ViewParent viewParent = getParent();
          if (viewParent != null)
            viewParent.requestDisallowInterceptTouchEvent(true); 
        } 
        if (!this.mScroller.isFinished())
          this.mScroller.abortAnimation(); 
        this.mLastMotionY = (int)velocityTracker.getY();
        this.mActivePointerId = velocityTracker.getPointerId(0);
        startNestedScroll(2, 0);
        break;
    } 
    if (this.mVelocityTracker != null)
      this.mVelocityTracker.addMovement(motionEvent); 
    motionEvent.recycle();
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2) {
    if (!this.mIsLayoutDirty) {
      scrollToChild(paramView2);
    } else {
      this.mChildToScrollTo = paramView2;
    } 
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
    boolean bool;
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      if (paramBoolean) {
        scrollBy(0, i);
        return bool;
      } 
      smoothScrollBy(0, i);
    } 
    return bool;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    if (paramBoolean)
      recycleVelocityTracker(); 
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout() {
    this.mIsLayoutDirty = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {
    if (getChildCount() > 0) {
      View view = getChildAt(0);
      paramInt1 = clamp(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), view.getWidth());
      paramInt2 = clamp(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), view.getHeight());
      if (paramInt1 != getScrollX() || paramInt2 != getScrollY())
        super.scrollTo(paramInt1, paramInt2); 
    } 
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
    if (nestedScrollingChildHelper.mIsNestedScrollingEnabled)
      ViewCompat.stopNestedScroll(nestedScrollingChildHelper.mView); 
    nestedScrollingChildHelper.mIsNestedScrollingEnabled = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState() {
    return true;
  }
  
  public final void smoothScrollTo(int paramInt1, int paramInt2) {
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY());
  }
  
  public boolean startNestedScroll(int paramInt) {
    return this.mChildHelper.startNestedScroll(paramInt, 0);
  }
  
  public void stopNestedScroll() {
    this.mChildHelper.stopNestedScroll(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\NestedScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */