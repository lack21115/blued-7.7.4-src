package org.chromium.content.browser.selection;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import org.chromium.content.R;
import org.chromium.ui.base.DeviceFormFactor;

final class FloatingPastePopupMenu$ActionModeCallback extends ActionMode.Callback2 {
  private FloatingPastePopupMenu$ActionModeCallback() {}
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
    int i = paramMenuItem.getItemId();
    if (i == R.id.select_action_menu_paste) {
      FloatingPastePopupMenu.access$300(FloatingPastePopupMenu.this).paste();
      paramActionMode.finish();
    } else if (i == R.id.select_action_menu_paste_as_plain_text) {
      FloatingPastePopupMenu.access$300(FloatingPastePopupMenu.this).pasteAsPlainText();
      paramActionMode.finish();
    } else if (i == R.id.select_action_menu_select_all) {
      FloatingPastePopupMenu.access$300(FloatingPastePopupMenu.this).selectAll();
      paramActionMode.finish();
    } else if (FloatingPastePopupMenu.access$100(FloatingPastePopupMenu.this) != null) {
      return FloatingPastePopupMenu.access$100(FloatingPastePopupMenu.this).onActionItemClicked(paramActionMode, paramMenuItem);
    } 
    return true;
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
    CharSequence charSequence;
    if (DeviceFormFactor.isNonMultiDisplayContextOnTablet(FloatingPastePopupMenu.access$200(FloatingPastePopupMenu.this))) {
      charSequence = FloatingPastePopupMenu.access$200(FloatingPastePopupMenu.this).getString(R.string.actionbar_textselection_title);
    } else {
      charSequence = null;
    } 
    paramActionMode.setTitle(charSequence);
    paramActionMode.setSubtitle(null);
    SelectionPopupControllerImpl.initializeMenu(FloatingPastePopupMenu.access$200(FloatingPastePopupMenu.this), paramActionMode, paramMenu);
    if (!FloatingPastePopupMenu.access$300(FloatingPastePopupMenu.this).canPaste())
      paramMenu.removeItem(R.id.select_action_menu_paste); 
    if (!FloatingPastePopupMenu.access$300(FloatingPastePopupMenu.this).canSelectAll())
      paramMenu.removeItem(R.id.select_action_menu_select_all); 
    if (!FloatingPastePopupMenu.access$300(FloatingPastePopupMenu.this).canPasteAsPlainText())
      paramMenu.removeItem(R.id.select_action_menu_paste_as_plain_text); 
    SelectionPopupControllerImpl.setPasteAsPlainTextMenuItemTitle(paramMenu);
    paramMenu.removeItem(R.id.select_action_menu_cut);
    paramMenu.removeItem(R.id.select_action_menu_copy);
    paramMenu.removeItem(R.id.select_action_menu_share);
    paramMenu.removeItem(R.id.select_action_menu_web_search);
    if (FloatingPastePopupMenu.access$100(FloatingPastePopupMenu.this) != null)
      FloatingPastePopupMenu.access$100(FloatingPastePopupMenu.this).onCreateActionMode(paramActionMode, paramMenu); 
    return true;
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode) {
    if (FloatingPastePopupMenu.access$100(FloatingPastePopupMenu.this) != null)
      FloatingPastePopupMenu.access$100(FloatingPastePopupMenu.this).onDestroyActionMode(paramActionMode); 
    FloatingPastePopupMenu.access$402(FloatingPastePopupMenu.this, null);
  }
  
  public final void onGetContentRect(ActionMode paramActionMode, View paramView, Rect paramRect) {
    paramRect.set(FloatingPastePopupMenu.access$500(FloatingPastePopupMenu.this));
  }
  
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
    return (FloatingPastePopupMenu.access$100(FloatingPastePopupMenu.this) != null) ? FloatingPastePopupMenu.access$100(FloatingPastePopupMenu.this).onPrepareActionMode(paramActionMode, paramMenu) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\FloatingPastePopupMenu$ActionModeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */