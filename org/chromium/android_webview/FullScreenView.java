package org.chromium.android_webview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;

public final class FullScreenView extends FrameLayout {
  private final AwContents mAwContents;
  
  AwViewMethods mAwViewMethods;
  
  FullScreenView$InternalAccessAdapter mInternalAccessAdapter;
  
  public FullScreenView(Context paramContext, AwViewMethods paramAwViewMethods, AwContents paramAwContents) {
    super(paramContext);
    this.mAwViewMethods = paramAwViewMethods;
    this.mAwContents = paramAwContents;
    this.mInternalAccessAdapter = new FullScreenView$InternalAccessAdapter(this, (byte)0);
  }
  
  public final int computeHorizontalScrollOffset() {
    return this.mAwViewMethods.computeHorizontalScrollOffset();
  }
  
  public final int computeHorizontalScrollRange() {
    return this.mAwViewMethods.computeHorizontalScrollRange();
  }
  
  public final void computeScroll() {
    this.mAwViewMethods.computeScroll();
  }
  
  public final int computeVerticalScrollExtent() {
    return this.mAwViewMethods.computeVerticalScrollExtent();
  }
  
  public final int computeVerticalScrollOffset() {
    return this.mAwViewMethods.computeVerticalScrollOffset();
  }
  
  public final int computeVerticalScrollRange() {
    return this.mAwViewMethods.computeVerticalScrollRange();
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getKeyCode() == 4 && paramKeyEvent.getAction() == 1 && this.mAwContents.isFullScreen()) {
      this.mAwContents.requestExitFullscreen();
      return true;
    } 
    return this.mAwViewMethods.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final AccessibilityNodeProvider getAccessibilityNodeProvider() {
    return this.mAwViewMethods.getAccessibilityNodeProvider();
  }
  
  protected final void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mAwViewMethods.onAttachedToWindow();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {
    this.mAwViewMethods.onConfigurationChanged(paramConfiguration);
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return this.mAwViewMethods.onCreateInputConnection(paramEditorInfo);
  }
  
  public final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.mAwViewMethods.onDetachedFromWindow();
  }
  
  public final void onDraw(Canvas paramCanvas) {
    this.mAwViewMethods.onDraw(paramCanvas);
  }
  
  public final void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.mAwViewMethods.onFocusChanged$23eb4535(paramBoolean);
  }
  
  public final boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    return this.mAwViewMethods.onGenericMotionEvent(paramMotionEvent);
  }
  
  public final boolean onHoverEvent(MotionEvent paramMotionEvent) {
    return this.mAwViewMethods.onHoverEvent(paramMotionEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return this.mAwViewMethods.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2) {
    this.mAwViewMethods.onMeasure(paramInt1, paramInt2);
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    this.mAwViewMethods.onContainerViewOverScrolled$3b46042b(paramInt1, paramInt2);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mAwViewMethods.onContainerViewScrollChanged$3b4dfe4b(paramInt1, paramInt2);
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mAwViewMethods.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.mAwViewMethods.onTouchEvent(paramMotionEvent);
  }
  
  protected final void onVisibilityChanged(View paramView, int paramInt) {
    super.onVisibilityChanged(paramView, paramInt);
    this.mAwViewMethods.onVisibilityChanged$5359dc9a();
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    this.mAwViewMethods.onWindowFocusChanged(paramBoolean);
  }
  
  public final void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    this.mAwViewMethods.onWindowVisibilityChanged(paramInt);
  }
  
  public final boolean performAccessibilityAction(int paramInt, Bundle paramBundle) {
    return this.mAwViewMethods.performAccessibilityAction$68e2e3ea();
  }
  
  public final boolean requestFocus(int paramInt, Rect paramRect) {
    this.mAwViewMethods.requestFocus();
    return super.requestFocus(paramInt, paramRect);
  }
  
  public final void setLayerType(int paramInt, Paint paramPaint) {
    super.setLayerType(paramInt, paramPaint);
    this.mAwViewMethods.setLayerType$42d5a443(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\FullScreenView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */