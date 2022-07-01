package org.chromium.content.browser.selection;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import org.chromium.content_public.browser.ActionModeCallbackHelper;

@TargetApi(23)
public final class FloatingActionModeCallback extends ActionMode.Callback2 {
  private final ActionMode.Callback mCallback;
  
  private final ActionModeCallbackHelper mHelper;
  
  public FloatingActionModeCallback(ActionModeCallbackHelper paramActionModeCallbackHelper, ActionMode.Callback paramCallback) {
    this.mHelper = paramActionModeCallbackHelper;
    this.mCallback = paramCallback;
  }
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
    return this.mCallback.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
    return (paramActionMode.getType() != 1) ? false : this.mCallback.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode) {
    this.mCallback.onDestroyActionMode(paramActionMode);
  }
  
  public final void onGetContentRect(ActionMode paramActionMode, View paramView, Rect paramRect) {
    this.mHelper.onGetContentRect$4c31e730(paramRect);
  }
  
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
    return this.mCallback.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\FloatingActionModeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */