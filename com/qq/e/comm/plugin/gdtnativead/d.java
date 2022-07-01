package com.qq.e.comm.plugin.gdtnativead;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.qq.e.comm.util.GDTLogger;

class d implements Window.Callback {
  final Window.Callback a;
  
  public d(Window.Callback paramCallback) {
    if (paramCallback == null)
      GDTLogger.e("Window callback may not be null"); 
    this.a = paramCallback;
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent) {
    return this.a.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return this.a.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent) {
    return this.a.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    return this.a.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    return this.a.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent) {
    return this.a.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode) {
    this.a.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode) {
    this.a.onActionModeStarted(paramActionMode);
  }
  
  public void onAttachedToWindow() {
    this.a.onAttachedToWindow();
  }
  
  public void onContentChanged() {
    this.a.onContentChanged();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu) {
    return this.a.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt) {
    return this.a.onCreatePanelView(paramInt);
  }
  
  public void onDetachedFromWindow() {
    this.a.onDetachedFromWindow();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
    return this.a.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu) {
    return this.a.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu) {
    this.a.onPanelClosed(paramInt, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) {
    return this.a.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public boolean onSearchRequested() {
    return this.a.onSearchRequested();
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent) {
    return (Build.VERSION.SDK_INT >= 23) ? this.a.onSearchRequested(paramSearchEvent) : false;
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams) {
    this.a.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    this.a.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback) {
    return this.a.onWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? this.a.onWindowStartingActionMode(paramCallback, paramInt) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */