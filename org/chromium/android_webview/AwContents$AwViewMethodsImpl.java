package org.chromium.android_webview;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.ZoomButtonsController;
import org.chromium.base.Log;
import org.chromium.base.TraceEvent;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.content_public.browser.WebContentsAccessibility;
import org.chromium.device.gamepad.GamepadList;
import org.chromium.ui.base.EventForwarder;

final class AwContents$AwViewMethodsImpl implements AwViewMethods {
  private final Rect mClipBoundsTemporary = new Rect();
  
  private ComponentCallbacks2 mComponentCallbacks;
  
  private int mLayerType = 0;
  
  private AwContents$AwViewMethodsImpl() {}
  
  private void updateHardwareAcceleratedFeaturesToggle() {
    boolean bool;
    null = AwContents.access$300(AwContents.this);
    if (AwContents.access$5600(AwContents.this) && AwContents.access$700(AwContents.this).isHardwareAccelerated() && (this.mLayerType == 0 || this.mLayerType == 2)) {
      bool = true;
    } else {
      bool = false;
    } 
    synchronized (null.mAwSettingsLock) {
      if (null.mEnableSupportedHardwareAcceleratedFeatures != bool) {
        null.mEnableSupportedHardwareAcceleratedFeatures = bool;
        null.mEventHandler.updateWebkitPreferencesLocked();
      } 
      return;
    } 
  }
  
  public final int computeHorizontalScrollOffset() {
    return (AwContents.access$4700(AwContents.this)).mDelegate.getContainerViewScrollX();
  }
  
  public final int computeHorizontalScrollRange() {
    return AwContents.access$4700(AwContents.this).computeHorizontalScrollRange();
  }
  
  public final void computeScroll() {
    if (AwContents.access$900(AwContents.this, 0))
      return; 
    AwContents.access$7000(AwContents.this, AwContents.access$1000(AwContents.this), AnimationUtils.currentAnimationTimeMillis());
  }
  
  public final int computeVerticalScrollExtent() {
    return (AwContents.access$4700(AwContents.this)).mContainerViewHeight;
  }
  
  public final int computeVerticalScrollOffset() {
    return (AwContents.access$4700(AwContents.this)).mDelegate.getContainerViewScrollY();
  }
  
  public final int computeVerticalScrollRange() {
    return AwContents.access$4700(AwContents.this).computeVerticalScrollRange();
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    if (AwContents.access$900(AwContents.this, 0))
      return false; 
    if (AwContents.isDpadEvent(paramKeyEvent))
      AwContents.access$300(AwContents.this).setSpatialNavigationEnabled(true); 
    if (GamepadList.dispatchKeyEvent(paramKeyEvent))
      return true; 
    if (AwContents.access$600(AwContents.this).hasWebViewClient() && AwContents.access$600(AwContents.this).shouldOverrideKeyEvent(paramKeyEvent))
      return AwContents.access$800(AwContents.this).super_dispatchKeyEvent(paramKeyEvent); 
    EventForwarder eventForwarder = AwContents.access$1400(AwContents.this).getEventForwarder();
    return (eventForwarder.mNativeEventForwarder == 0L) ? false : eventForwarder.nativeDispatchKeyEvent(eventForwarder.mNativeEventForwarder, paramKeyEvent);
  }
  
  public final AccessibilityNodeProvider getAccessibilityNodeProvider() {
    if (AwContents.access$900(AwContents.this, 0))
      return null; 
    WebContentsAccessibility webContentsAccessibility = AwContents.access$7100(AwContents.this);
    return (webContentsAccessibility != null) ? webContentsAccessibility.getAccessibilityNodeProvider() : null;
  }
  
  public final void onAttachedToWindow() {
    if (AwContents.access$900(AwContents.this, 0))
      return; 
    if (AwContents.access$5600(AwContents.this)) {
      Log.w("AwContents", "onAttachedToWindow called when already attached. Ignoring", new Object[0]);
      return;
    } 
    AwContents.access$5602(AwContents.this, true);
    AwContents.access$5900(AwContents.this).onAttachedToWindow();
    AwContents.access$6000(AwContents.this, AwContents.access$1000(AwContents.this), AwContents.access$700(AwContents.this).getWidth(), AwContents.access$700(AwContents.this).getHeight());
    updateHardwareAcceleratedFeaturesToggle();
    AwContents.access$6100(AwContents.this);
    AwContents.access$5200(AwContents.this).addReference();
    AwContents.updateDefaultLocale();
    AwContents.access$300(AwContents.this).updateAcceptLanguages();
    if (this.mComponentCallbacks != null)
      return; 
    this.mComponentCallbacks = new AwContents$AwComponentCallbacks(AwContents.this, (byte)0);
    AwContents.access$6300(AwContents.this).registerComponentCallbacks((ComponentCallbacks)this.mComponentCallbacks);
  }
  
  public final boolean onCheckIsTextEditor() {
    if (AwContents.access$900(AwContents.this, 0))
      return false; 
    ImeAdapterImpl imeAdapterImpl = ImeAdapterImpl.fromWebContents(AwContents.access$1400(AwContents.this));
    return (imeAdapterImpl != null) ? imeAdapterImpl.onCheckIsTextEditor() : false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {
    if (!AwContents.access$900(AwContents.this, 0)) {
      AwContents.access$5900(AwContents.this).onConfigurationChanged(paramConfiguration);
      AwContents.access$800(AwContents.this);
    } 
  }
  
  public final void onContainerViewOverScrolled$3b46042b(int paramInt1, int paramInt2) {
    int j = AwContents.access$700(AwContents.this).getScrollX();
    int i = AwContents.access$700(AwContents.this).getScrollY();
    AwScrollOffsetManager awScrollOffsetManager = AwContents.access$4700(AwContents.this);
    paramInt1 = awScrollOffsetManager.clampHorizontalScroll(paramInt1);
    paramInt2 = awScrollOffsetManager.clampVerticalScroll(paramInt2);
    awScrollOffsetManager.mDelegate.scrollContainerViewTo(paramInt1, paramInt2);
    awScrollOffsetManager.scrollNativeTo(awScrollOffsetManager.mDelegate.getContainerViewScrollX(), awScrollOffsetManager.mDelegate.getContainerViewScrollY());
    if (AwContents.access$5300(AwContents.this) != null) {
      OverScrollGlow overScrollGlow = AwContents.access$5300(AwContents.this);
      AwContents.access$700(AwContents.this).getScrollX();
      AwContents.access$700(AwContents.this).getScrollY();
      paramInt2 = (AwContents.access$4700(AwContents.this)).mMaxHorizontalScrollOffset;
      paramInt1 = (AwContents.access$4700(AwContents.this)).mMaxVerticalScrollOffset;
      if (overScrollGlow.mShouldPull && j == overScrollGlow.mHostView.getScrollX() && i == overScrollGlow.mHostView.getScrollY()) {
        if (paramInt2 > 0) {
          j += overScrollGlow.mOverScrollDeltaX;
          if (j < 0) {
            overScrollGlow.mEdgeGlowLeft.onPull(overScrollGlow.mOverScrollDeltaX / overScrollGlow.mHostView.getWidth());
            if (!overScrollGlow.mEdgeGlowRight.isFinished())
              overScrollGlow.mEdgeGlowRight.onRelease(); 
          } else if (j > paramInt2) {
            overScrollGlow.mEdgeGlowRight.onPull(overScrollGlow.mOverScrollDeltaX / overScrollGlow.mHostView.getWidth());
            if (!overScrollGlow.mEdgeGlowLeft.isFinished())
              overScrollGlow.mEdgeGlowLeft.onRelease(); 
          } 
          overScrollGlow.mOverScrollDeltaX = 0;
        } 
        if (paramInt1 > 0 || overScrollGlow.mHostView.getOverScrollMode() == 0) {
          paramInt2 = i + overScrollGlow.mOverScrollDeltaY;
          if (paramInt2 < 0) {
            overScrollGlow.mEdgeGlowTop.onPull(overScrollGlow.mOverScrollDeltaY / overScrollGlow.mHostView.getHeight());
            if (!overScrollGlow.mEdgeGlowBottom.isFinished())
              overScrollGlow.mEdgeGlowBottom.onRelease(); 
          } else if (paramInt2 > paramInt1) {
            overScrollGlow.mEdgeGlowBottom.onPull(overScrollGlow.mOverScrollDeltaY / overScrollGlow.mHostView.getHeight());
            if (!overScrollGlow.mEdgeGlowTop.isFinished())
              overScrollGlow.mEdgeGlowTop.onRelease(); 
          } 
          overScrollGlow.mOverScrollDeltaY = 0;
        } 
      } 
    } 
  }
  
  public final void onContainerViewScrollChanged$3b4dfe4b(int paramInt1, int paramInt2) {
    AwContents.access$1600(AwContents.this).removePostedViewScrolledAccessibilityEventCallback();
    AwContents.access$4700(AwContents.this).scrollNativeTo(paramInt1, paramInt2);
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return AwContents.access$900(AwContents.this, 0) ? null : ImeAdapterImpl.fromWebContents(AwContents.access$1400(AwContents.this)).onCreateInputConnection(paramEditorInfo);
  }
  
  public final void onDetachedFromWindow() {
    if (AwContents.access$900(AwContents.this, 0))
      return; 
    if (!AwContents.access$5600(AwContents.this)) {
      Log.w("AwContents", "onDetachedFromWindow called when already detached. Ignoring", new Object[0]);
      return;
    } 
    AwContents.access$5602(AwContents.this, false);
    AwContents.this.hideAutofillPopup();
    AwContents.access$6400(AwContents.this, AwContents.access$1000(AwContents.this));
    AwContents.access$5900(AwContents.this).onDetachedFromWindow();
    updateHardwareAcceleratedFeaturesToggle();
    AwContents.access$6100(AwContents.this);
    AwContents.access$5200(AwContents.this).removeReference();
    if (this.mComponentCallbacks != null) {
      AwContents.access$6300(AwContents.this).unregisterComponentCallbacks((ComponentCallbacks)this.mComponentCallbacks);
      this.mComponentCallbacks = null;
    } 
    AwContents.access$1600(AwContents.this).removePostedViewScrolledAccessibilityEventCallback();
    ZoomButtonsController zoomButtonsController = AwContents.access$1700(AwContents.this).getZoomController();
    if (zoomButtonsController != null)
      zoomButtonsController.setVisible(false); 
  }
  
  public final boolean onDragEvent(DragEvent paramDragEvent) {
    if (AwContents.access$900(AwContents.this, 0))
      return false; 
    EventForwarder eventForwarder = AwContents.access$1400(AwContents.this).getEventForwarder();
    ViewGroup viewGroup = AwContents.access$700(AwContents.this);
    if (eventForwarder.mNativeEventForwarder != 0L) {
      String[] arrayOfString;
      if (Build.VERSION.SDK_INT <= 23)
        return false; 
      ClipDescription clipDescription = paramDragEvent.getClipDescription();
      if (clipDescription == null) {
        arrayOfString = new String[0];
      } else {
        arrayOfString = arrayOfString.filterMimeTypes("text/*");
      } 
      if (paramDragEvent.getAction() == 1)
        return (arrayOfString != null && arrayOfString.length > 0 && eventForwarder.mIsDragDropEnabled); 
      StringBuilder stringBuilder = new StringBuilder("");
      if (paramDragEvent.getAction() == 3) {
        ClipData clipData = paramDragEvent.getClipData();
        int i1 = clipData.getItemCount();
        for (int n = 0; n < i1; n++)
          stringBuilder.append(clipData.getItemAt(n).coerceToStyledText(viewGroup.getContext())); 
      } 
      int[] arrayOfInt = new int[2];
      viewGroup.getLocationOnScreen(arrayOfInt);
      int i = (int)(paramDragEvent.getX() + eventForwarder.mCurrentTouchOffsetX);
      int j = (int)(paramDragEvent.getY() + eventForwarder.mCurrentTouchOffsetY);
      int k = arrayOfInt[0];
      int m = arrayOfInt[1];
      float f = eventForwarder.getEventSourceScaling();
      eventForwarder.nativeOnDragEvent(eventForwarder.mNativeEventForwarder, paramDragEvent.getAction(), (int)(i / f), (int)(j / f), (int)((k + i) / f), (int)((m + j) / f), arrayOfString, stringBuilder.toString());
      return true;
    } 
    return false;
  }
  
  public final void onDraw(Canvas paramCanvas) {
    if (AwContents.access$900(AwContents.this, 0)) {
      TraceEvent.instant("EarlyOut_destroyed");
      paramCanvas.drawColor(AwContents.this.getEffectiveBackgroundColor());
      return;
    } 
    if (!paramCanvas.isHardwareAccelerated() && !paramCanvas.getClipBounds(this.mClipBoundsTemporary)) {
      TraceEvent.instant("EarlyOut_software_empty_clip");
      return;
    } 
    AwScrollOffsetManager awScrollOffsetManager = AwContents.access$4700(AwContents.this);
    awScrollOffsetManager.scrollNativeTo(awScrollOffsetManager.mDelegate.getContainerViewScrollX(), awScrollOffsetManager.mDelegate.getContainerViewScrollY());
    int i = AwContents.access$700(AwContents.this).getScrollX();
    int j = AwContents.access$700(AwContents.this).getScrollY();
    Rect rect = AwContents.access$1800(AwContents.this);
    if (Build.VERSION.SDK_INT == 24 || Build.VERSION.SDK_INT == 25) {
      if (AwContents.access$4800(AwContents.this) == null) {
        AwContents.access$4802(AwContents.this, new Paint());
        AwContents.access$4800(AwContents.this).setColor(Color.argb(1, 0, 0, 0));
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(0.0F, 0.0F, 0.0F, 0.1F);
        AwContents.access$4800(AwContents.this).setColorFilter((ColorFilter)new ColorMatrixColorFilter(colorMatrix));
      } 
      paramCanvas.drawRect(0.0F, 0.0F, 1.0F, 1.0F, AwContents.access$4800(AwContents.this));
    } 
    boolean bool2 = AwContents.access$5000(AwContents.this, AwContents.access$1000(AwContents.this), paramCanvas, paramCanvas.isHardwareAccelerated(), i, j, rect.left, rect.top, rect.right, rect.bottom, AwContents$ForceAuxiliaryBitmapRendering.access$4900());
    if (paramCanvas.isHardwareAccelerated() && AwContents.access$5100(AwContents.this, AwContents.access$1000(AwContents.this))) {
      TraceEvent.instant("DrawBackgroundColor");
      paramCanvas.drawColor(AwContents.this.getEffectiveBackgroundColor());
    } 
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = bool2;
      if (paramCanvas.isHardwareAccelerated()) {
        bool1 = bool2;
        if (!AwContents$ForceAuxiliaryBitmapRendering.access$4900()) {
          AwGLFunctor awGLFunctor = AwContents.access$5200(AwContents.this);
          bool1 = awGLFunctor.mNativeDrawGLFunctor.requestDrawGL(paramCanvas, awGLFunctor.mFunctorReleasedCallback);
          if (bool1 && awGLFunctor.mFunctorReleasedCallback != null)
            awGLFunctor.addReference(); 
        } 
      } 
    } 
    if (bool1) {
      int k = AwContents.access$700(AwContents.this).getScrollX();
      int m = AwContents.access$700(AwContents.this).getScrollY();
      paramCanvas.translate(-(k - i), -(m - j));
    } else {
      TraceEvent.instant("NativeDrawFailed");
      paramCanvas.drawColor(AwContents.this.getEffectiveBackgroundColor());
    } 
    if (AwContents.access$5300(AwContents.this) != null) {
      OverScrollGlow overScrollGlow = AwContents.access$5300(AwContents.this);
      int k = (AwContents.access$4700(AwContents.this)).mMaxHorizontalScrollOffset;
      int i3 = (AwContents.access$4700(AwContents.this)).mMaxVerticalScrollOffset;
      int m = overScrollGlow.mHostView.getScrollX();
      int n = overScrollGlow.mHostView.getScrollY();
      int i1 = overScrollGlow.mHostView.getWidth();
      int i2 = overScrollGlow.mHostView.getHeight();
      if (!overScrollGlow.mEdgeGlowTop.isFinished()) {
        i = paramCanvas.save();
        paramCanvas.translate(m, Math.min(0, n));
        overScrollGlow.mEdgeGlowTop.setSize(i1, i2);
        j = overScrollGlow.mEdgeGlowTop.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(i);
      } else {
        j = 0;
      } 
      i = j;
      if (!overScrollGlow.mEdgeGlowBottom.isFinished()) {
        int i4 = paramCanvas.save();
        paramCanvas.translate((-i1 + m), (Math.max(i3, n) + i2));
        paramCanvas.rotate(180.0F, i1, 0.0F);
        overScrollGlow.mEdgeGlowBottom.setSize(i1, i2);
        bool3 = j | overScrollGlow.mEdgeGlowBottom.draw(paramCanvas);
        paramCanvas.restoreToCount(i4);
      } 
      boolean bool4 = bool3;
      if (!overScrollGlow.mEdgeGlowLeft.isFinished()) {
        i3 = paramCanvas.save();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate((-i2 - n), Math.min(0, m));
        overScrollGlow.mEdgeGlowLeft.setSize(i2, i1);
        bool4 = bool3 | overScrollGlow.mEdgeGlowLeft.draw(paramCanvas);
        paramCanvas.restoreToCount(i3);
      } 
      boolean bool3 = bool4;
      if (!overScrollGlow.mEdgeGlowRight.isFinished()) {
        i3 = paramCanvas.save();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(n, -(Math.max(m, k) + i1));
        overScrollGlow.mEdgeGlowRight.setSize(i2, i1);
        bool3 = bool4 | overScrollGlow.mEdgeGlowRight.draw(paramCanvas);
        paramCanvas.restoreToCount(i3);
      } 
      if (bool3)
        AwContents.access$1300(AwContents.this); 
    } 
    if (AwContents.access$5400(AwContents.this)) {
      AwContents.access$700(AwContents.this).getRootView().invalidate();
      AwContents.access$5402(AwContents.this, false);
    } 
  }
  
  public final void onFocusChanged$23eb4535(boolean paramBoolean) {
    if (AwContents.access$900(AwContents.this, 0))
      return; 
    AwContents.access$6602(AwContents.this, paramBoolean);
    AwContents.access$5900(AwContents.this).onViewFocusChanged(paramBoolean);
  }
  
  public final boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    if (AwContents.access$900(AwContents.this, 0))
      return false; 
    EventForwarder eventForwarder = AwContents.access$1400(AwContents.this).getEventForwarder();
    if (eventForwarder.mNativeEventForwarder == 0L)
      return false; 
    if ((paramMotionEvent.getSource() & 0x2) != 0 && paramMotionEvent.getToolType(0) == 3)
      eventForwarder.updateMouseEventState(paramMotionEvent); 
    return eventForwarder.nativeOnGenericMotionEvent(eventForwarder.mNativeEventForwarder, paramMotionEvent, paramMotionEvent.getEventTime());
  }
  
  public final boolean onHoverEvent(MotionEvent paramMotionEvent) {
    return AwContents.access$900(AwContents.this, 0) ? false : AwContents.access$1400(AwContents.this).getEventForwarder().onHoverEvent(paramMotionEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (AwContents.access$900(AwContents.this, 0))
      return false; 
    EventForwarder eventForwarder = AwContents.access$1400(AwContents.this).getEventForwarder();
    return (eventForwarder.mNativeEventForwarder == 0L) ? false : eventForwarder.nativeOnKeyUp(eventForwarder.mNativeEventForwarder, paramKeyEvent, paramInt);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2) {
    AwLayoutSizer awLayoutSizer = AwContents.access$1500(AwContents.this);
    int i = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    int n = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    int m = (int)((awLayoutSizer.mContentHeightCss * awLayoutSizer.mPageScaleFactor) * awLayoutSizer.mDIPScale);
    int j = (int)((awLayoutSizer.mContentWidthCss * awLayoutSizer.mPageScaleFactor) * awLayoutSizer.mDIPScale);
    boolean bool2 = false;
    if (n != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    awLayoutSizer.mWidthMeasurementIsFixed = bool1;
    if (i == 1073741824) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    awLayoutSizer.mHeightMeasurementIsFixed = bool1;
    boolean bool1 = bool2;
    if (i == Integer.MIN_VALUE) {
      bool1 = bool2;
      if (m > k)
        bool1 = true; 
    } 
    awLayoutSizer.mHeightMeasurementLimited = bool1;
    awLayoutSizer.mHeightMeasurementLimit = k;
    if (awLayoutSizer.mHeightMeasurementIsFixed || awLayoutSizer.mHeightMeasurementLimited) {
      paramInt1 = k;
    } else {
      paramInt1 = m;
    } 
    if (!awLayoutSizer.mWidthMeasurementIsFixed)
      paramInt2 = j; 
    i = paramInt1;
    if (paramInt1 < m)
      i = k | 0x1000000; 
    paramInt1 = paramInt2;
    if (paramInt2 < j)
      paramInt1 = paramInt2 | 0x1000000; 
    awLayoutSizer.mDelegate.setMeasuredDimension(paramInt1, i);
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (AwContents.access$900(AwContents.this, 0))
      return; 
    AwScrollOffsetManager awScrollOffsetManager = AwContents.access$4700(AwContents.this);
    awScrollOffsetManager.mContainerViewWidth = paramInt1;
    awScrollOffsetManager.mContainerViewHeight = paramInt2;
    AwContents.access$1500(AwContents.this).updateLayoutSettings();
    AwContents.access$6700(AwContents.this, AwContents.access$1000(AwContents.this), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   4: iconst_0
    //   5: invokestatic access$900 : (Lorg/chromium/android_webview/AwContents;I)Z
    //   8: ifeq -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: invokevirtual getActionMasked : ()I
    //   17: ifne -> 31
    //   20: aload_0
    //   21: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   24: invokestatic access$300 : (Lorg/chromium/android_webview/AwContents;)Lorg/chromium/android_webview/AwSettings;
    //   27: iconst_0
    //   28: invokevirtual setSpatialNavigationEnabled : (Z)V
    //   31: aload_0
    //   32: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   35: invokestatic access$4700 : (Lorg/chromium/android_webview/AwContents;)Lorg/chromium/android_webview/AwScrollOffsetManager;
    //   38: iconst_1
    //   39: invokevirtual setProcessingTouchEvent : (Z)V
    //   42: aload_0
    //   43: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   46: invokestatic access$1400 : (Lorg/chromium/android_webview/AwContents;)Lorg/chromium/content_public/browser/WebContents;
    //   49: invokeinterface getEventForwarder : ()Lorg/chromium/ui/base/EventForwarder;
    //   54: astore #11
    //   56: aload_1
    //   57: iconst_0
    //   58: invokevirtual getToolType : (I)I
    //   61: iconst_3
    //   62: if_icmpne -> 132
    //   65: getstatic android/os/Build$VERSION.SDK_INT : I
    //   68: istore #9
    //   70: aload_1
    //   71: invokevirtual getButtonState : ()I
    //   74: ifne -> 106
    //   77: aload_1
    //   78: invokevirtual getActionMasked : ()I
    //   81: ifeq -> 100
    //   84: aload_1
    //   85: invokevirtual getActionMasked : ()I
    //   88: iconst_2
    //   89: if_icmpeq -> 100
    //   92: aload_1
    //   93: invokevirtual getActionMasked : ()I
    //   96: iconst_1
    //   97: if_icmpne -> 106
    //   100: iconst_1
    //   101: istore #8
    //   103: goto -> 109
    //   106: iconst_0
    //   107: istore #8
    //   109: iload #9
    //   111: bipush #23
    //   113: if_icmplt -> 132
    //   116: iload #8
    //   118: ifne -> 132
    //   121: aload #11
    //   123: aload_1
    //   124: invokevirtual onMouseEvent : (Landroid/view/MotionEvent;)Z
    //   127: istore #10
    //   129: goto -> 141
    //   132: aload #11
    //   134: aload_1
    //   135: iconst_0
    //   136: invokevirtual sendTouchEvent : (Landroid/view/MotionEvent;Z)Z
    //   139: istore #10
    //   141: aload_0
    //   142: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   145: invokestatic access$4700 : (Lorg/chromium/android_webview/AwContents;)Lorg/chromium/android_webview/AwScrollOffsetManager;
    //   148: iconst_0
    //   149: invokevirtual setProcessingTouchEvent : (Z)V
    //   152: aload_1
    //   153: invokevirtual getActionMasked : ()I
    //   156: ifne -> 242
    //   159: aload_1
    //   160: invokevirtual getX : ()F
    //   163: fstore #7
    //   165: aload_1
    //   166: invokevirtual getY : ()F
    //   169: fstore #6
    //   171: aload_1
    //   172: invokevirtual getTouchMajor : ()F
    //   175: aload_1
    //   176: invokevirtual getTouchMinor : ()F
    //   179: invokestatic max : (FF)F
    //   182: fstore #5
    //   184: fload #7
    //   186: fstore #4
    //   188: fload #6
    //   190: fstore_3
    //   191: fload #5
    //   193: fstore_2
    //   194: invokestatic isUseZoomForDSFEnabled : ()Z
    //   197: ifne -> 224
    //   200: aload_0
    //   201: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   204: invokestatic access$5700 : (Lorg/chromium/android_webview/AwContents;)F
    //   207: fstore_2
    //   208: fload #7
    //   210: fload_2
    //   211: fdiv
    //   212: fstore #4
    //   214: fload #6
    //   216: fload_2
    //   217: fdiv
    //   218: fstore_3
    //   219: fload #5
    //   221: fload_2
    //   222: fdiv
    //   223: fstore_2
    //   224: aload_0
    //   225: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   228: aload_0
    //   229: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   232: invokestatic access$1000 : (Lorg/chromium/android_webview/AwContents;)J
    //   235: fload #4
    //   237: fload_3
    //   238: fload_2
    //   239: invokestatic access$5800 : (Lorg/chromium/android_webview/AwContents;JFFF)V
    //   242: aload_0
    //   243: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   246: invokestatic access$5300 : (Lorg/chromium/android_webview/AwContents;)Lorg/chromium/android_webview/OverScrollGlow;
    //   249: ifnull -> 336
    //   252: aload_1
    //   253: invokevirtual getActionMasked : ()I
    //   256: ifne -> 273
    //   259: aload_0
    //   260: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   263: invokestatic access$5300 : (Lorg/chromium/android_webview/AwContents;)Lorg/chromium/android_webview/OverScrollGlow;
    //   266: iconst_1
    //   267: putfield mShouldPull : Z
    //   270: iload #10
    //   272: ireturn
    //   273: aload_1
    //   274: invokevirtual getActionMasked : ()I
    //   277: iconst_1
    //   278: if_icmpeq -> 289
    //   281: aload_1
    //   282: invokevirtual getActionMasked : ()I
    //   285: iconst_3
    //   286: if_icmpne -> 336
    //   289: aload_0
    //   290: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   293: invokestatic access$5300 : (Lorg/chromium/android_webview/AwContents;)Lorg/chromium/android_webview/OverScrollGlow;
    //   296: iconst_0
    //   297: putfield mShouldPull : Z
    //   300: aload_0
    //   301: getfield this$0 : Lorg/chromium/android_webview/AwContents;
    //   304: invokestatic access$5300 : (Lorg/chromium/android_webview/AwContents;)Lorg/chromium/android_webview/OverScrollGlow;
    //   307: astore_1
    //   308: aload_1
    //   309: getfield mEdgeGlowTop : Landroid/widget/EdgeEffect;
    //   312: invokevirtual onRelease : ()V
    //   315: aload_1
    //   316: getfield mEdgeGlowBottom : Landroid/widget/EdgeEffect;
    //   319: invokevirtual onRelease : ()V
    //   322: aload_1
    //   323: getfield mEdgeGlowLeft : Landroid/widget/EdgeEffect;
    //   326: invokevirtual onRelease : ()V
    //   329: aload_1
    //   330: getfield mEdgeGlowRight : Landroid/widget/EdgeEffect;
    //   333: invokevirtual onRelease : ()V
    //   336: iload #10
    //   338: ireturn
  }
  
  public final void onVisibilityChanged$5359dc9a() {
    boolean bool;
    if (AwContents.access$700(AwContents.this).getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (AwContents.access$1900(AwContents.this) == bool)
      return; 
    AwContents.access$6800(AwContents.this, bool);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    if (AwContents.access$900(AwContents.this, 0))
      return; 
    AwContents.access$6502(AwContents.this, paramBoolean);
    AwContents.access$5900(AwContents.this).onWindowFocusChanged(paramBoolean);
  }
  
  public final void onWindowVisibilityChanged(int paramInt) {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (AwContents.access$2000(AwContents.this) == bool)
      return; 
    AwContents.access$6900(AwContents.this, bool);
  }
  
  public final boolean performAccessibilityAction$68e2e3ea() {
    if (AwContents.access$900(AwContents.this, 0))
      return false; 
    WebContentsAccessibility webContentsAccessibility = AwContents.access$7100(AwContents.this);
    return (webContentsAccessibility != null) ? webContentsAccessibility.performAction$68e2e3ea() : false;
  }
  
  public final void requestFocus() {
    if (AwContents.access$900(AwContents.this, 0))
      return; 
    if (!AwContents.access$700(AwContents.this).isInTouchMode() && AwContents.access$300(AwContents.this).shouldFocusFirstNode())
      AwContents.access$5500(AwContents.this, AwContents.access$1000(AwContents.this)); 
  }
  
  public final void setLayerType$42d5a443(int paramInt) {
    this.mLayerType = paramInt;
    updateHardwareAcceleratedFeaturesToggle();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$AwViewMethodsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */