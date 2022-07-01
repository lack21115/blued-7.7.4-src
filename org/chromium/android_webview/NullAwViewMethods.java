package org.chromium.android_webview;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

final class NullAwViewMethods implements AwViewMethods {
  private AwContents mAwContents;
  
  private View mContainerView;
  
  private AwContents$InternalAccessDelegate mInternalAccessAdapter;
  
  public NullAwViewMethods(AwContents paramAwContents, AwContents$InternalAccessDelegate paramAwContents$InternalAccessDelegate, View paramView) {
    this.mAwContents = paramAwContents;
    this.mInternalAccessAdapter = paramAwContents$InternalAccessDelegate;
    this.mContainerView = paramView;
  }
  
  public final int computeHorizontalScrollOffset() {
    return 0;
  }
  
  public final int computeHorizontalScrollRange() {
    return 0;
  }
  
  public final void computeScroll() {}
  
  public final int computeVerticalScrollExtent() {
    return 0;
  }
  
  public final int computeVerticalScrollOffset() {
    return 0;
  }
  
  public final int computeVerticalScrollRange() {
    return 0;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return false;
  }
  
  public final AccessibilityNodeProvider getAccessibilityNodeProvider() {
    return null;
  }
  
  public final void onAttachedToWindow() {}
  
  public final boolean onCheckIsTextEditor() {
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onContainerViewOverScrolled$3b46042b(int paramInt1, int paramInt2) {}
  
  public final void onContainerViewScrollChanged$3b4dfe4b(int paramInt1, int paramInt2) {}
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return null;
  }
  
  public final void onDetachedFromWindow() {}
  
  public final boolean onDragEvent(DragEvent paramDragEvent) {
    return false;
  }
  
  public final void onDraw(Canvas paramCanvas) {
    paramCanvas.drawColor(this.mAwContents.getEffectiveBackgroundColor());
  }
  
  public final void onFocusChanged$23eb4535(boolean paramBoolean) {}
  
  public final boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    return false;
  }
  
  public final boolean onHoverEvent(MotionEvent paramMotionEvent) {
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return false;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2) {
    this.mInternalAccessAdapter.setMeasuredDimension(this.mContainerView.getMeasuredWidth(), this.mContainerView.getMeasuredHeight());
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return false;
  }
  
  public final void onVisibilityChanged$5359dc9a() {}
  
  public final void onWindowFocusChanged(boolean paramBoolean) {}
  
  public final void onWindowVisibilityChanged(int paramInt) {}
  
  public final boolean performAccessibilityAction$68e2e3ea() {
    return false;
  }
  
  public final void requestFocus() {}
  
  public final void setLayerType$42d5a443(int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\NullAwViewMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */