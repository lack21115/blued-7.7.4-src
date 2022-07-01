package org.chromium.android_webview;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public interface AwViewMethods {
  int computeHorizontalScrollOffset();
  
  int computeHorizontalScrollRange();
  
  void computeScroll();
  
  int computeVerticalScrollExtent();
  
  int computeVerticalScrollOffset();
  
  int computeVerticalScrollRange();
  
  boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  AccessibilityNodeProvider getAccessibilityNodeProvider();
  
  void onAttachedToWindow();
  
  boolean onCheckIsTextEditor();
  
  void onConfigurationChanged(Configuration paramConfiguration);
  
  void onContainerViewOverScrolled$3b46042b(int paramInt1, int paramInt2);
  
  void onContainerViewScrollChanged$3b4dfe4b(int paramInt1, int paramInt2);
  
  InputConnection onCreateInputConnection(EditorInfo paramEditorInfo);
  
  void onDetachedFromWindow();
  
  boolean onDragEvent(DragEvent paramDragEvent);
  
  void onDraw(Canvas paramCanvas);
  
  void onFocusChanged$23eb4535(boolean paramBoolean);
  
  boolean onGenericMotionEvent(MotionEvent paramMotionEvent);
  
  boolean onHoverEvent(MotionEvent paramMotionEvent);
  
  boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent);
  
  void onMeasure(int paramInt1, int paramInt2);
  
  void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  void onVisibilityChanged$5359dc9a();
  
  void onWindowFocusChanged(boolean paramBoolean);
  
  void onWindowVisibilityChanged(int paramInt);
  
  boolean performAccessibilityAction$68e2e3ea();
  
  void requestFocus();
  
  void setLayerType$42d5a443(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwViewMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */