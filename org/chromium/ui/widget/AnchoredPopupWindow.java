package org.chromium.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import org.chromium.base.ObserverList;

public final class AnchoredPopupWindow implements View.OnTouchListener, RectProvider$Observer {
  private final Rect mCachedPaddingRect = new Rect();
  
  private final Rect mCachedWindowRect = new Rect();
  
  private final Context mContext;
  
  private final PopupWindow.OnDismissListener mDismissListener = new AnchoredPopupWindow$2(this);
  
  private ObserverList mDismissListeners = new ObserverList();
  
  public boolean mDismissOnTouchInteraction;
  
  private final Runnable mDismissRunnable = new AnchoredPopupWindow$1(this);
  
  private final Handler mHandler;
  
  private int mHeight;
  
  public boolean mHorizontalOverlapAnchor;
  
  private boolean mIgnoreDismissal;
  
  public AnchoredPopupWindow$LayoutObserver mLayoutObserver;
  
  private int mMarginPx;
  
  public int mMaxWidthPx;
  
  public final PopupWindow mPopupWindow;
  
  private boolean mPositionBelow;
  
  private boolean mPositionToLeft;
  
  public int mPreferredHorizontalOrientation = 0;
  
  private int mPreferredVerticalOrientation = 0;
  
  private final RectProvider mRectProvider;
  
  private final View mRootView;
  
  private View.OnTouchListener mTouchListener;
  
  public boolean mUpdateOrientationOnChange;
  
  public boolean mVerticalOverlapAnchor;
  
  private int mWidth;
  
  private int mX;
  
  private int mY;
  
  public AnchoredPopupWindow(Context paramContext, View paramView1, Drawable paramDrawable, View paramView2, RectProvider paramRectProvider) {
    this.mContext = paramContext;
    this.mRootView = paramView1.getRootView();
    UiWidgetFactory.getInstance();
    this.mPopupWindow = new PopupWindow(this.mContext);
    this.mHandler = new Handler();
    this.mRectProvider = paramRectProvider;
    this.mPopupWindow.setWidth(-2);
    this.mPopupWindow.setHeight(-2);
    this.mPopupWindow.setBackgroundDrawable(paramDrawable);
    this.mPopupWindow.setContentView(paramView2);
    this.mPopupWindow.setTouchInterceptor(this);
    this.mPopupWindow.setOnDismissListener(this.mDismissListener);
  }
  
  private void showPopupWindow() {
    try {
      this.mPopupWindow.showAtLocation(this.mRootView, 8388659, this.mX, this.mY);
      return;
    } catch (android.view.WindowManager.BadTokenException badTokenException) {
      return;
    } 
  }
  
  public final void addOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mDismissListeners.addObserver(paramOnDismissListener);
  }
  
  public final void onRectChanged() {
    updatePopupLayout();
  }
  
  public final void onRectHidden() {
    this.mPopupWindow.dismiss();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    boolean bool;
    if (this.mTouchListener != null && this.mTouchListener.onTouch(paramView, paramMotionEvent)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (this.mDismissOnTouchInteraction)
      this.mPopupWindow.dismiss(); 
    return bool;
  }
  
  public final void show() {
    if (this.mPopupWindow.isShowing())
      return; 
    this.mRectProvider.startObserving(this);
    updatePopupLayout();
    showPopupWindow();
  }
  
  public final void updatePopupLayout() {
    boolean bool3 = this.mPositionBelow;
    boolean bool4 = this.mPositionToLeft;
    boolean bool2 = this.mPopupWindow.isShowing();
    boolean bool1 = false;
    if (bool2 && !this.mUpdateOrientationOnChange) {
      i = 1;
    } else {
      i = 0;
    } 
    this.mPopupWindow.getBackground().getPadding(this.mCachedPaddingRect);
    int i1 = this.mCachedPaddingRect.left + this.mCachedPaddingRect.right;
    int i2 = this.mCachedPaddingRect.top + this.mCachedPaddingRect.bottom;
    int j = this.mMaxWidthPx;
    int k = this.mRootView.getWidth() - (this.mMarginPx << 1);
    if (j == 0 || j >= k)
      j = k; 
    if (j > i1) {
      j -= i1;
    } else {
      j = 0;
    } 
    View view = this.mPopupWindow.getContentView();
    int i3 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
    view.measure(i3, View.MeasureSpec.makeMeasureSpec(0, 0));
    k = view.getMeasuredHeight();
    int i4 = view.getMeasuredWidth();
    this.mRootView.getWindowVisibleDisplayFrame(this.mCachedWindowRect);
    int[] arrayOfInt = new int[2];
    this.mRootView.getLocationOnScreen(arrayOfInt);
    this.mCachedWindowRect.offset(-arrayOfInt[0], -arrayOfInt[1]);
    Rect rect2 = this.mRectProvider.getRect();
    if (this.mVerticalOverlapAnchor) {
      j = rect2.bottom;
    } else {
      j = rect2.top;
    } 
    int m = j - this.mCachedWindowRect.top - i2 - this.mMarginPx;
    int n = this.mCachedWindowRect.bottom;
    if (this.mVerticalOverlapAnchor) {
      j = rect2.top;
    } else {
      j = rect2.bottom;
    } 
    n = n - j - i2 - this.mMarginPx;
    if (k <= n) {
      j = 1;
    } else {
      j = 0;
    } 
    if (k <= m) {
      k = 1;
    } else {
      k = 0;
    } 
    if ((j != 0 && n >= m) || k == 0)
      bool1 = true; 
    this.mPositionBelow = bool1;
    if (i && bool3 != this.mPositionBelow) {
      if (bool3 && j != 0)
        this.mPositionBelow = true; 
      if (!bool3 && k != 0)
        this.mPositionBelow = false; 
    } 
    if (this.mPreferredVerticalOrientation == 1 && j != 0)
      this.mPositionBelow = true; 
    if (this.mPreferredVerticalOrientation == 2 && k != 0)
      this.mPositionBelow = false; 
    if (this.mPreferredHorizontalOrientation == 0) {
      Rect rect = this.mCachedWindowRect;
      if (this.mHorizontalOverlapAnchor) {
        j = rect2.right;
      } else {
        j = rect2.left;
      } 
      k = j - rect.left;
      rect = this.mCachedWindowRect;
      bool1 = this.mHorizontalOverlapAnchor;
      int i5 = rect.right;
      if (bool1) {
        j = rect2.left;
      } else {
        j = rect2.right;
      } 
      j = i5 - j;
      i4 = i4 + i2 + this.mMarginPx;
      if (k >= j) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      boolean bool = bool1;
      if (i) {
        bool = bool1;
        if (bool1 != bool4) {
          bool2 = bool1;
          if (bool4) {
            bool2 = bool1;
            if (i4 <= k)
              bool2 = true; 
          } 
          bool = bool2;
          if (!bool4) {
            bool = bool2;
            if (i4 <= j)
              bool = false; 
          } 
        } 
      } 
      this.mPositionToLeft = bool;
    } 
    if (this.mPositionBelow) {
      i = n;
    } else {
      i = m;
    } 
    view.measure(i3, View.MeasureSpec.makeMeasureSpec(i, -2147483648));
    this.mWidth = view.getMeasuredWidth() + i1;
    this.mHeight = view.getMeasuredHeight() + i2;
    Rect rect1 = this.mCachedWindowRect;
    j = this.mWidth;
    m = this.mMarginPx;
    bool1 = this.mHorizontalOverlapAnchor;
    int i = this.mPreferredHorizontalOrientation;
    bool2 = this.mPositionToLeft;
    if (i == 1) {
      i = rect2.left + (rect2.width() - j) / 2 + m;
    } else if (bool2) {
      if (bool1) {
        i = rect2.right;
      } else {
        i = rect2.left;
      } 
      i -= j;
    } else if (bool1) {
      i = rect2.left;
    } else {
      i = rect2.right;
    } 
    n = rect1.right - j - m;
    if (m > n) {
      j = n;
    } else {
      j = m;
    } 
    k = n;
    if (m > n)
      k = m; 
    if (i < j) {
      k = j;
    } else if (i <= k) {
      k = i;
    } 
    this.mX = k;
    j = this.mHeight;
    bool1 = this.mVerticalOverlapAnchor;
    if (this.mPositionBelow) {
      if (bool1) {
        i = rect2.top;
      } else {
        i = rect2.bottom;
      } 
    } else {
      if (bool1) {
        i = rect2.bottom;
      } else {
        i = rect2.top;
      } 
      i -= j;
    } 
    this.mY = i;
    if (this.mLayoutObserver != null)
      this.mLayoutObserver.onPreLayoutChange$56a91b86(this.mPositionBelow, rect2); 
    if (this.mPopupWindow.isShowing() && this.mPositionBelow != bool3)
      try {
        this.mIgnoreDismissal = true;
        this.mPopupWindow.dismiss();
        showPopupWindow();
      } finally {
        this.mIgnoreDismissal = false;
      }  
    this.mPopupWindow.update(this.mX, this.mY, this.mWidth, this.mHeight);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\widget\AnchoredPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */