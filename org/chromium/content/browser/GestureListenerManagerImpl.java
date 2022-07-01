package org.chromium.content.browser;

import android.content.res.Configuration;
import android.view.ViewGroup;
import org.chromium.base.ObserverList;
import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content.browser.webcontents.WebContentsUserData;
import org.chromium.content_public.browser.GestureListenerManager;
import org.chromium.content_public.browser.GestureStateListener;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

public class GestureListenerManagerImpl implements WindowEventObserver, GestureListenerManager {
  boolean mHasActiveFlingScroll;
  
  private boolean mIsTouchScrollInProgress;
  
  private final ObserverList.RewindableIterator mIterator;
  
  private final ObserverList mListeners;
  
  private long mNativeGestureListenerManager;
  
  ViewEventSink.InternalAccessDelegate mScrollDelegate;
  
  private ViewAndroidDelegate mViewDelegate;
  
  private final WebContentsImpl mWebContents;
  
  public GestureListenerManagerImpl(WebContents paramWebContents) {
    this.mWebContents = (WebContentsImpl)paramWebContents;
    this.mListeners = new ObserverList();
    this.mIterator = this.mListeners.rewindableIterator();
    this.mViewDelegate = this.mWebContents.getViewAndroidDelegate();
    WindowEventObserverManager.from((WebContents)this.mWebContents).addObserver(this);
    this.mNativeGestureListenerManager = nativeInit(this.mWebContents);
  }
  
  private void destroyPastePopup() {
    SelectionPopupControllerImpl selectionPopupControllerImpl = SelectionPopupControllerImpl.fromWebContents((WebContents)this.mWebContents);
    if (selectionPopupControllerImpl != null)
      selectionPopupControllerImpl.destroyPastePopup(); 
  }
  
  @CalledByNative
  private boolean filterTapOrPressEvent(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 == 5 && this.mViewDelegate.getContainerView().performLongClick())
      return true; 
    TapDisambiguator tapDisambiguator = TapDisambiguator.fromWebContents((WebContents)this.mWebContents);
    if (!tapDisambiguator.mPopupView.isShowing()) {
      float f1 = paramInt2;
      float f2 = paramInt3;
      PopupZoomer popupZoomer = tapDisambiguator.mPopupView;
      popupZoomer.mTouch.x = f1;
      popupZoomer.mTouch.y = f2;
    } 
    return false;
  }
  
  public static GestureListenerManagerImpl fromWebContents(WebContents paramWebContents) {
    return (GestureListenerManagerImpl)WebContentsUserData.fromWebContents(paramWebContents, GestureListenerManagerImpl.class, GestureListenerManagerImpl$UserDataFactoryLazyHolder.access$000());
  }
  
  private native long nativeInit(WebContentsImpl paramWebContentsImpl);
  
  private native void nativeResetGestureDetection(long paramLong);
  
  private native void nativeSetDoubleTapSupportEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetMultiTouchZoomSupportEnabled(long paramLong, boolean paramBoolean);
  
  @CalledByNative
  private void onDestroy() {
    this.mIterator.rewind();
    while (this.mIterator.hasNext())
      ((GestureStateListener)this.mIterator.next()).onDestroyed(); 
    this.mListeners.clear();
    this.mNativeGestureListenerManager = 0L;
  }
  
  @CalledByNative
  private void onEventAck(int paramInt, boolean paramBoolean) {
    switch (paramInt) {
      default:
        return;
      case 23:
        if (paramBoolean) {
          this.mViewDelegate.getContainerView().performHapticFeedback(0);
          this.mIterator.rewind();
          while (this.mIterator.hasNext())
            this.mIterator.next(); 
        } 
        return;
      case 21:
        destroyPastePopup();
        this.mIterator.rewind();
        while (this.mIterator.hasNext())
          this.mIterator.next(); 
        return;
      case 17:
        this.mIterator.rewind();
        while (this.mIterator.hasNext())
          ((GestureStateListener)this.mIterator.next()).onPinchEnded(); 
        return;
      case 16:
        this.mIterator.rewind();
        while (this.mIterator.hasNext())
          ((GestureStateListener)this.mIterator.next()).onPinchStarted(); 
        return;
      case 14:
        if (paramBoolean) {
          this.mHasActiveFlingScroll = true;
          setTouchScrollInProgress(false);
          this.mIterator.rewind();
          while (this.mIterator.hasNext()) {
            GestureStateListener gestureStateListener = (GestureStateListener)this.mIterator.next();
            verticalScrollOffset();
            verticalScrollExtent();
            gestureStateListener.onFlingStartGesture$255f295();
          } 
        } else {
          updateOnScrollEnd();
          return;
        } 
        return;
      case 13:
        if (paramBoolean) {
          destroyPastePopup();
          this.mIterator.rewind();
          while (this.mIterator.hasNext())
            ((GestureStateListener)this.mIterator.next()).onScrollUpdateGestureConsumed(); 
        } 
        return;
      case 12:
        updateOnScrollEnd();
        return;
      case 11:
        break;
    } 
    setTouchScrollInProgress(true);
    this.mIterator.rewind();
    while (this.mIterator.hasNext()) {
      GestureStateListener gestureStateListener = (GestureStateListener)this.mIterator.next();
      verticalScrollOffset();
      verticalScrollExtent();
      gestureStateListener.onScrollStarted$255f295();
    } 
  }
  
  @CalledByNative
  private void onFlingEnd() {
    this.mHasActiveFlingScroll = false;
    setTouchScrollInProgress(false);
    this.mIterator.rewind();
    while (this.mIterator.hasNext()) {
      this.mIterator.next();
      verticalScrollOffset();
      verticalScrollExtent();
    } 
  }
  
  @CalledByNative
  private void resetPopupsAndInput(boolean paramBoolean) {
    PopupController.hidePopupsAndClearSelection((WebContents)this.mWebContents);
    if (isScrollInProgress()) {
      boolean bool = this.mIsTouchScrollInProgress;
      setTouchScrollInProgress(false);
      if (bool)
        updateOnScrollEnd(); 
      if (this.mHasActiveFlingScroll) {
        onFlingEnd();
        this.mHasActiveFlingScroll = false;
      } 
    } 
    if (paramBoolean) {
      ImeAdapterImpl imeAdapterImpl = ImeAdapterImpl.fromWebContents((WebContents)this.mWebContents);
      if (imeAdapterImpl != null)
        imeAdapterImpl.resetAndHideKeyboard(); 
    } 
  }
  
  private void setTouchScrollInProgress(boolean paramBoolean) {
    this.mIsTouchScrollInProgress = paramBoolean;
    SelectionPopupControllerImpl.fromWebContents((WebContents)this.mWebContents).hideActionMode(paramBoolean);
  }
  
  private void updateOnScrollEnd() {
    setTouchScrollInProgress(false);
    this.mIterator.rewind();
    while (this.mIterator.hasNext()) {
      GestureStateListener gestureStateListener = (GestureStateListener)this.mIterator.next();
      verticalScrollOffset();
      verticalScrollExtent();
      gestureStateListener.onScrollEnded$255f295();
    } 
  }
  
  @CalledByNative
  private void updateOnTouchDown() {
    this.mIterator.rewind();
    while (this.mIterator.hasNext())
      this.mIterator.next(); 
  }
  
  @CalledByNative
  private void updateScrollInfo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, boolean paramBoolean) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    TraceEvent.begin("GestureListenerManagerImpl:updateScrollInfo");
    RenderCoordinatesImpl renderCoordinatesImpl = this.mWebContents.mRenderCoordinates;
    float f = renderCoordinatesImpl.mDeviceScaleFactor;
    ViewGroup viewGroup = this.mViewDelegate.getContainerView();
    paramFloat8 = viewGroup.getWidth();
    f *= paramFloat3;
    paramFloat6 = Math.max(paramFloat6, paramFloat8 / f);
    paramFloat7 = Math.max(paramFloat7, viewGroup.getHeight() / f);
    paramFloat8 = renderCoordinatesImpl.mContentWidthCss;
    boolean bool4 = false;
    if (paramFloat6 != paramFloat8 || paramFloat7 != renderCoordinatesImpl.mContentHeightCss) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramFloat4 != renderCoordinatesImpl.mMinPageScaleFactor || paramFloat5 != renderCoordinatesImpl.mMaxPageScaleFactor) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramFloat3 != renderCoordinatesImpl.mPageScaleFactor) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool3 || paramFloat1 != renderCoordinatesImpl.mScrollXCss || paramFloat2 != renderCoordinatesImpl.mScrollYCss) {
      bool3 = true;
    } else {
      bool3 = bool4;
    } 
    if (bool1 || bool3)
      TapDisambiguator.fromWebContents((WebContents)this.mWebContents).hidePopup(true); 
    if (bool3)
      this.mScrollDelegate.onScrollChanged((int)renderCoordinatesImpl.fromLocalCssToPix(paramFloat1), (int)renderCoordinatesImpl.fromLocalCssToPix(paramFloat2), (int)renderCoordinatesImpl.getScrollXPix(), (int)renderCoordinatesImpl.getScrollYPix()); 
    renderCoordinatesImpl.mScrollXCss = paramFloat1;
    renderCoordinatesImpl.mScrollYCss = paramFloat2;
    renderCoordinatesImpl.mPageScaleFactor = paramFloat3;
    renderCoordinatesImpl.mMinPageScaleFactor = paramFloat4;
    renderCoordinatesImpl.mMaxPageScaleFactor = paramFloat5;
    renderCoordinatesImpl.mTopContentOffsetYPix = paramFloat10;
    renderCoordinatesImpl.mContentWidthCss = paramFloat6;
    renderCoordinatesImpl.mContentHeightCss = paramFloat7;
    renderCoordinatesImpl.mLastFrameViewportHeightCss = paramFloat9;
    if (bool3 || paramBoolean) {
      verticalScrollOffset();
      verticalScrollExtent();
      this.mIterator.rewind();
      while (this.mIterator.hasNext())
        ((GestureStateListener)this.mIterator.next()).onScrollOffsetOrExtentChanged$255f295(); 
    } 
    if (bool2) {
      this.mIterator.rewind();
      while (this.mIterator.hasNext())
        ((GestureStateListener)this.mIterator.next()).onScaleLimitsChanged$2548a35(); 
    } 
    TraceEvent.end("GestureListenerManagerImpl:updateScrollInfo");
  }
  
  private int verticalScrollExtent() {
    RenderCoordinatesImpl renderCoordinatesImpl = this.mWebContents.mRenderCoordinates;
    return (int)Math.ceil(renderCoordinatesImpl.fromLocalCssToPix(renderCoordinatesImpl.mLastFrameViewportHeightCss));
  }
  
  private int verticalScrollOffset() {
    return (int)Math.floor(this.mWebContents.mRenderCoordinates.getScrollYPix());
  }
  
  public final void addListener(GestureStateListener paramGestureStateListener) {
    this.mListeners.addObserver(paramGestureStateListener);
  }
  
  public final boolean isScrollInProgress() {
    return (this.mIsTouchScrollInProgress || this.mHasActiveFlingScroll);
  }
  
  public final void onAttachedToWindow() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDIPScaleChanged(float paramFloat) {}
  
  public final void onDetachedFromWindow() {}
  
  public final void onRotationChanged(int paramInt) {}
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {}
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    if (!paramBoolean && this.mNativeGestureListenerManager != 0L)
      nativeResetGestureDetection(this.mNativeGestureListenerManager); 
    this.mIterator.rewind();
    while (this.mIterator.hasNext())
      ((GestureStateListener)this.mIterator.next()).onWindowFocusChanged(paramBoolean); 
  }
  
  public final void removeListener(GestureStateListener paramGestureStateListener) {
    this.mListeners.removeObserver(paramGestureStateListener);
  }
  
  public final void updateDoubleTapSupport(boolean paramBoolean) {
    if (this.mNativeGestureListenerManager == 0L)
      return; 
    nativeSetDoubleTapSupportEnabled(this.mNativeGestureListenerManager, paramBoolean);
  }
  
  public final void updateMultiTouchZoomSupport(boolean paramBoolean) {
    if (this.mNativeGestureListenerManager == 0L)
      return; 
    nativeSetMultiTouchZoomSupportEnabled(this.mNativeGestureListenerManager, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\GestureListenerManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */