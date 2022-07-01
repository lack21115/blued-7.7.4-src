package org.chromium.android_webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.GestureListenerManagerImpl;
import org.chromium.content_public.browser.GestureStateListener;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;
import org.chromium.ui.resources.HandleViewResources;

public class PopupTouchHandleDrawable extends View implements DisplayAndroid.DisplayAndroidObserver {
  float mAlpha;
  
  private boolean mAttachedToWindow;
  
  final PopupWindow mContainer;
  
  ViewGroup mContainerView;
  
  private Runnable mDeferredHandleFadeInRunnable;
  
  private boolean mDelayVisibilityUpdateWAR;
  
  private float mDeviceScale;
  
  private Drawable mDrawable;
  
  private final ObserverList mDrawableObserverList;
  
  long mFadeStartTime;
  
  private boolean mFocused;
  
  private final GestureStateListener mGestureStateListener;
  
  boolean mHasPendingInvalidate;
  
  private Runnable mInvalidationRunnable;
  
  private boolean mMirrorHorizontal;
  
  private boolean mMirrorVertical;
  
  final long mNativeDrawable;
  
  private boolean mNeedsUpdateDrawable;
  
  private int mOrientation = 3;
  
  private float mOriginXDip;
  
  private float mOriginYDip;
  
  final ViewPositionObserver$Listener mParentPositionListener;
  
  ViewPositionObserver mParentPositionObserver;
  
  private int mParentPositionX;
  
  private int mParentPositionY;
  
  private boolean mRotationChanged;
  
  private boolean mScrolling;
  
  private final int[] mTempScreenCoords = new int[2];
  
  private boolean mTemporarilyHidden;
  
  private long mTemporarilyHiddenExpireTime;
  
  private Runnable mTemporarilyHiddenExpiredRunnable;
  
  private boolean mVisible;
  
  private WebContents mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private PopupTouchHandleDrawable(ObserverList paramObserverList, WebContents paramWebContents, ViewGroup paramViewGroup) {
    super(paramViewGroup.getContext());
    this.mDrawableObserverList = paramObserverList;
    this.mDrawableObserverList.addObserver(this);
    this.mWebContents = paramWebContents;
    this.mContainerView = paramViewGroup;
    WindowAndroid windowAndroid = this.mWebContents.getTopLevelNativeWindow();
    this.mDeviceScale = windowAndroid.mDisplayAndroid.mDipScale;
    this.mContainer = new PopupWindow(windowAndroid.getContext().get(), null, 16843464);
    this.mContainer.setSplitTouchEnabled(true);
    this.mContainer.setClippingEnabled(false);
    this.mContainer.setAnimationStyle(0);
    PopupWindow popupWindow = this.mContainer;
    if (Build.VERSION.SDK_INT >= 23) {
      popupWindow.setWindowLayoutType(1002);
    } else {
      try {
        PopupWindow.class.getMethod("setWindowLayoutType", new Class[] { int.class }).invoke(popupWindow, new Object[] { Integer.valueOf(1002) });
      } catch (NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException|RuntimeException noSuchMethodException) {}
    } 
    this.mContainer.setWidth(-2);
    this.mContainer.setHeight(-2);
    this.mAlpha = 0.0F;
    this.mVisible = false;
    setVisibility(4);
    this.mFocused = paramViewGroup.hasWindowFocus();
    this.mParentPositionObserver = new ViewPositionObserver((View)paramViewGroup);
    this.mParentPositionListener = new PopupTouchHandleDrawable$$Lambda$0(this);
    this.mGestureStateListener = new PopupTouchHandleDrawable$1(this);
    GestureListenerManagerImpl.fromWebContents(this.mWebContents).addListener(this.mGestureStateListener);
    this.mNativeDrawable = nativeInit(HandleViewResources.getHandleHorizontalPaddingRatio());
  }
  
  public static PopupTouchHandleDrawable create(ObserverList paramObserverList, WebContents paramWebContents, ViewGroup paramViewGroup) {
    return new PopupTouchHandleDrawable(paramObserverList, paramWebContents, paramViewGroup);
  }
  
  @CalledByNative
  private void destroy() {
    this.mDrawableObserverList.removeObserver(this);
    if (this.mWebContents == null)
      return; 
    hide();
    GestureListenerManagerImpl gestureListenerManagerImpl = GestureListenerManagerImpl.fromWebContents(this.mWebContents);
    if (gestureListenerManagerImpl != null)
      gestureListenerManagerImpl.removeListener(this.mGestureStateListener); 
    this.mWebContents = null;
  }
  
  private int getContainerPositionX() {
    return this.mParentPositionX + (int)(this.mOriginXDip * this.mDeviceScale);
  }
  
  private int getContainerPositionY() {
    return this.mParentPositionY + (int)(this.mOriginYDip * this.mDeviceScale);
  }
  
  private static Drawable getHandleDrawable(Context paramContext, int paramInt) {
    switch (paramInt) {
      default:
        assert false;
        throw new AssertionError();
      case 2:
        return HandleViewResources.getRightHandleDrawable(paramContext);
      case 1:
        return HandleViewResources.getCenterHandleDrawable(paramContext);
      case 0:
        break;
    } 
    return HandleViewResources.getLeftHandleDrawable(paramContext);
  }
  
  @CalledByNative
  private float getOriginXDip() {
    return this.mOriginXDip;
  }
  
  @CalledByNative
  private float getOriginYDip() {
    return this.mOriginYDip;
  }
  
  @CalledByNative
  private float getVisibleHeightDip() {
    return (this.mDrawable == null) ? 0.0F : (this.mDrawable.getIntrinsicHeight() / this.mDeviceScale);
  }
  
  @CalledByNative
  private float getVisibleWidthDip() {
    return (this.mDrawable == null) ? 0.0F : (this.mDrawable.getIntrinsicWidth() / this.mDeviceScale);
  }
  
  @CalledByNative
  private void hide() {
    this.mTemporarilyHiddenExpireTime = 0L;
    setTemporarilyHidden(false);
    this.mAlpha = 1.0F;
    if (this.mContainer.isShowing())
      try {
        this.mContainer.dismiss();
      } catch (IllegalArgumentException illegalArgumentException) {} 
    this.mParentPositionObserver.mListeners.clear();
  }
  
  private boolean isShowingAllowed() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAttachedToWindow : Z
    //   4: ifeq -> 295
    //   7: aload_0
    //   8: getfield mVisible : Z
    //   11: ifeq -> 295
    //   14: aload_0
    //   15: getfield mFocused : Z
    //   18: ifeq -> 295
    //   21: aload_0
    //   22: getfield mScrolling : Z
    //   25: ifne -> 295
    //   28: aload_0
    //   29: getfield mTemporarilyHidden : Z
    //   32: ifne -> 295
    //   35: aload_0
    //   36: getfield mOriginXDip : F
    //   39: fstore_1
    //   40: aload_0
    //   41: getfield mDeviceScale : F
    //   44: fstore_2
    //   45: aload_0
    //   46: getfield mOriginYDip : F
    //   49: fstore_3
    //   50: aload_0
    //   51: getfield mDeviceScale : F
    //   54: fstore #4
    //   56: iconst_2
    //   57: newarray float
    //   59: astore #7
    //   61: aload #7
    //   63: iconst_0
    //   64: fload_1
    //   65: fload_2
    //   66: fmul
    //   67: fastore
    //   68: aload #7
    //   70: iconst_1
    //   71: fload_3
    //   72: fload #4
    //   74: fmul
    //   75: fastore
    //   76: aload_0
    //   77: getfield mContainerView : Landroid/view/ViewGroup;
    //   80: astore #6
    //   82: aload #6
    //   84: ifnull -> 285
    //   87: aload #6
    //   89: aload_0
    //   90: getfield mContainerView : Landroid/view/ViewGroup;
    //   93: if_acmpeq -> 126
    //   96: aload #7
    //   98: iconst_0
    //   99: aload #7
    //   101: iconst_0
    //   102: faload
    //   103: aload #6
    //   105: invokevirtual getScrollX : ()I
    //   108: i2f
    //   109: fsub
    //   110: fastore
    //   111: aload #7
    //   113: iconst_1
    //   114: aload #7
    //   116: iconst_1
    //   117: faload
    //   118: aload #6
    //   120: invokevirtual getScrollY : ()I
    //   123: i2f
    //   124: fsub
    //   125: fastore
    //   126: aload_0
    //   127: getfield mDrawable : Landroid/graphics/drawable/Drawable;
    //   130: invokevirtual getIntrinsicWidth : ()I
    //   133: i2f
    //   134: fstore_1
    //   135: aload_0
    //   136: getfield mDrawable : Landroid/graphics/drawable/Drawable;
    //   139: invokevirtual getIntrinsicHeight : ()I
    //   142: i2f
    //   143: fstore_2
    //   144: aload #7
    //   146: iconst_0
    //   147: faload
    //   148: fload_1
    //   149: fadd
    //   150: fconst_0
    //   151: fcmpg
    //   152: iflt -> 279
    //   155: aload #7
    //   157: iconst_1
    //   158: faload
    //   159: fload_2
    //   160: fadd
    //   161: fconst_0
    //   162: fcmpg
    //   163: iflt -> 279
    //   166: aload #7
    //   168: iconst_0
    //   169: faload
    //   170: aload #6
    //   172: invokevirtual getWidth : ()I
    //   175: i2f
    //   176: fcmpl
    //   177: ifgt -> 279
    //   180: aload #7
    //   182: iconst_1
    //   183: faload
    //   184: aload #6
    //   186: invokevirtual getHeight : ()I
    //   189: i2f
    //   190: fcmpl
    //   191: ifle -> 197
    //   194: goto -> 279
    //   197: aload #6
    //   199: invokevirtual getMatrix : ()Landroid/graphics/Matrix;
    //   202: invokevirtual isIdentity : ()Z
    //   205: ifne -> 218
    //   208: aload #6
    //   210: invokevirtual getMatrix : ()Landroid/graphics/Matrix;
    //   213: aload #7
    //   215: invokevirtual mapPoints : ([F)V
    //   218: aload #7
    //   220: iconst_0
    //   221: aload #7
    //   223: iconst_0
    //   224: faload
    //   225: aload #6
    //   227: invokevirtual getLeft : ()I
    //   230: i2f
    //   231: fadd
    //   232: fastore
    //   233: aload #7
    //   235: iconst_1
    //   236: aload #7
    //   238: iconst_1
    //   239: faload
    //   240: aload #6
    //   242: invokevirtual getTop : ()I
    //   245: i2f
    //   246: fadd
    //   247: fastore
    //   248: aload #6
    //   250: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   253: astore #6
    //   255: aload #6
    //   257: instanceof android/view/View
    //   260: ifeq -> 273
    //   263: aload #6
    //   265: checkcast android/view/View
    //   268: astore #6
    //   270: goto -> 82
    //   273: aconst_null
    //   274: astore #6
    //   276: goto -> 82
    //   279: iconst_0
    //   280: istore #5
    //   282: goto -> 288
    //   285: iconst_1
    //   286: istore #5
    //   288: iload #5
    //   290: ifeq -> 295
    //   293: iconst_1
    //   294: ireturn
    //   295: iconst_0
    //   296: ireturn
  }
  
  private native long nativeInit(float paramFloat);
  
  private void onVisibilityInputChanged() {
    boolean bool1;
    if (!this.mContainer.isShowing())
      return; 
    boolean bool2 = isShowingAllowed();
    if (getVisibility() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1 == bool2)
      return; 
    if (this.mDeferredHandleFadeInRunnable != null)
      removeCallbacks(this.mDeferredHandleFadeInRunnable); 
    if (bool2) {
      if (this.mDeferredHandleFadeInRunnable == null)
        this.mDeferredHandleFadeInRunnable = new PopupTouchHandleDrawable$$Lambda$2(this); 
      postOnAnimation(this.mDeferredHandleFadeInRunnable);
      return;
    } 
    updateVisibility();
  }
  
  private void scheduleInvalidate() {
    if (this.mInvalidationRunnable == null)
      this.mInvalidationRunnable = new PopupTouchHandleDrawable$$Lambda$3(this); 
    if (this.mHasPendingInvalidate)
      return; 
    this.mHasPendingInvalidate = true;
    postOnAnimation(this.mInvalidationRunnable);
  }
  
  @CalledByNative
  private void setOrientation(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void setOrigin(float paramFloat1, float paramFloat2) {
    if (this.mOriginXDip == paramFloat1 && this.mOriginYDip == paramFloat2 && !this.mRotationChanged)
      return; 
    this.mOriginXDip = paramFloat1;
    this.mOriginYDip = paramFloat2;
    if (this.mVisible || this.mRotationChanged) {
      if (this.mRotationChanged)
        this.mRotationChanged = false; 
      scheduleInvalidate();
    } 
  }
  
  @CalledByNative
  private void setVisible(boolean paramBoolean) {
    if (this.mVisible == paramBoolean)
      return; 
    this.mVisible = paramBoolean;
    onVisibilityInputChanged();
  }
  
  @CalledByNative
  private void show() {
    if (this.mWebContents == null)
      return; 
    if (this.mContainer.isShowing())
      return; 
    ViewPositionObserver viewPositionObserver = this.mParentPositionObserver;
    viewPositionObserver.updatePosition();
    int i = viewPositionObserver.mPosition[0];
    viewPositionObserver = this.mParentPositionObserver;
    viewPositionObserver.updatePosition();
    updateParentPosition(i, viewPositionObserver.mPosition[1]);
    this.mParentPositionObserver.addListener(this.mParentPositionListener);
    this.mContainer.setContentView(this);
    try {
      this.mContainer.showAtLocation((View)this.mContainerView, 0, getContainerPositionX(), getContainerPositionY());
      return;
    } catch (android.view.WindowManager.BadTokenException badTokenException) {
      hide();
      return;
    } 
  }
  
  private void temporarilyHide() {
    if (!this.mContainer.isShowing())
      return; 
    this.mTemporarilyHiddenExpireTime = SystemClock.uptimeMillis() + 300L;
    setTemporarilyHidden(true);
  }
  
  @SuppressLint({"NewApi"})
  private void updateDrawableAndRequestLayout() {
    this.mNeedsUpdateDrawable = false;
    if (this.mDrawable == null)
      return; 
    this.mDrawable = getHandleDrawable(getContext(), this.mOrientation);
    if (this.mDrawable != null)
      this.mDrawable.setAlpha((int)(this.mAlpha * 255.0F)); 
    if (!isInLayout())
      requestLayout(); 
  }
  
  private void updateVisibility() {
    byte b;
    if (isShowingAllowed()) {
      b = 0;
    } else {
      b = 4;
    } 
    if (b == 0 && getVisibility() != 0 && !this.mDelayVisibilityUpdateWAR) {
      this.mDelayVisibilityUpdateWAR = true;
      scheduleInvalidate();
      return;
    } 
    this.mDelayVisibilityUpdateWAR = false;
    setVisibility(b);
  }
  
  final void doInvalidate() {
    if (!this.mContainer.isShowing())
      return; 
    updateVisibility();
    this.mContainer.update(getContainerPositionX(), getContainerPositionY(), getRight() - getLeft(), getBottom() - getTop());
    invalidate();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mAttachedToWindow = true;
    onVisibilityInputChanged();
    WindowAndroid windowAndroid = this.mWebContents.getTopLevelNativeWindow();
    if (windowAndroid != null) {
      windowAndroid.mDisplayAndroid.addObserver(this);
      this.mDeviceScale = windowAndroid.mDisplayAndroid.mDipScale;
      updateDrawableAndRequestLayout();
    } 
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mNeedsUpdateDrawable && this.mDeviceScale == (getResources().getDisplayMetrics()).density)
      updateDrawableAndRequestLayout(); 
  }
  
  public final void onDIPScaleChanged(float paramFloat) {
    if (this.mDeviceScale != paramFloat) {
      this.mDeviceScale = paramFloat;
      this.mNeedsUpdateDrawable = true;
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.mWebContents != null) {
      WindowAndroid windowAndroid = this.mWebContents.getTopLevelNativeWindow();
      if (windowAndroid != null)
        windowAndroid.mDisplayAndroid.removeObserver(this); 
    } 
    this.mAttachedToWindow = false;
    onVisibilityInputChanged();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    boolean bool;
    if (this.mDrawable == null)
      return; 
    if (this.mMirrorHorizontal || this.mMirrorVertical) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      float f1;
      paramCanvas.save();
      boolean bool1 = this.mMirrorHorizontal;
      float f2 = -1.0F;
      if (bool1) {
        f1 = -1.0F;
      } else {
        f1 = 1.0F;
      } 
      if (!this.mMirrorVertical)
        f2 = 1.0F; 
      paramCanvas.scale(f1, f2, getWidth() / 2.0F, getHeight() / 2.0F);
    } 
    if (this.mAlpha != 1.0F) {
      this.mAlpha = Math.min(1.0F, (float)(AnimationUtils.currentAnimationTimeMillis() - this.mFadeStartTime) / 200.0F);
      this.mDrawable.setAlpha((int)(this.mAlpha * 255.0F));
      scheduleInvalidate();
    } 
    this.mDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    this.mDrawable.draw(paramCanvas);
    if (bool)
      paramCanvas.restore(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.mDrawable == null) {
      setMeasuredDimension(0, 0);
      return;
    } 
    setMeasuredDimension(this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
  }
  
  public final void onRotationChanged(int paramInt) {
    this.mRotationChanged = true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.mWebContents == null)
      return false; 
    this.mContainerView.getLocationOnScreen(this.mTempScreenCoords);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getX();
    float f3 = this.mTempScreenCoords[0];
    float f4 = paramMotionEvent.getRawY();
    float f5 = paramMotionEvent.getY();
    float f6 = this.mTempScreenCoords[1];
    paramMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
    paramMotionEvent.offsetLocation(f1 - f2 - f3, f4 - f5 - f6);
    boolean bool = this.mWebContents.getEventForwarder().sendTouchEvent(paramMotionEvent, true);
    paramMotionEvent.recycle();
    return bool;
  }
  
  final void setTemporarilyHidden(boolean paramBoolean) {
    if (this.mTemporarilyHidden == paramBoolean)
      return; 
    this.mTemporarilyHidden = paramBoolean;
    if (this.mTemporarilyHidden) {
      if (this.mTemporarilyHiddenExpiredRunnable == null)
        this.mTemporarilyHiddenExpiredRunnable = new PopupTouchHandleDrawable$$Lambda$1(this); 
      removeCallbacks(this.mTemporarilyHiddenExpiredRunnable);
      long l = SystemClock.uptimeMillis();
      l = Math.max(0L, this.mTemporarilyHiddenExpireTime - l);
      postDelayed(this.mTemporarilyHiddenExpiredRunnable, l);
    } else if (this.mTemporarilyHiddenExpiredRunnable != null) {
      removeCallbacks(this.mTemporarilyHiddenExpiredRunnable);
    } 
    onVisibilityInputChanged();
  }
  
  final void updateParentPosition(int paramInt1, int paramInt2) {
    if (this.mParentPositionX == paramInt1 && this.mParentPositionY == paramInt2)
      return; 
    this.mParentPositionX = paramInt1;
    this.mParentPositionY = paramInt2;
    temporarilyHide();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\PopupTouchHandleDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */