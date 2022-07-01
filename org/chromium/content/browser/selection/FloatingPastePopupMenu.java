package org.chromium.content.browser.selection;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.View;

@TargetApi(23)
public class FloatingPastePopupMenu implements PastePopupMenu {
  private ActionMode mActionMode;
  
  private final Context mContext;
  
  private final PastePopupMenu$PastePopupMenuDelegate mDelegate;
  
  private ActionMode.Callback mExternalCallback;
  
  private final View mParent;
  
  private Rect mSelectionRect;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public FloatingPastePopupMenu(Context paramContext, View paramView, PastePopupMenu$PastePopupMenuDelegate paramPastePopupMenu$PastePopupMenuDelegate, ActionMode.Callback paramCallback) {
    assert false;
    throw new AssertionError();
  }
  
  public final void hide() {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
      this.mActionMode = null;
    } 
  }
  
  public final void show(Rect paramRect) {
    this.mSelectionRect = paramRect;
    if (this.mActionMode != null) {
      this.mActionMode.invalidateContentRect();
      return;
    } 
    if (this.mActionMode == null) {
      ActionMode actionMode = this.mParent.startActionMode((ActionMode.Callback)new FloatingPastePopupMenu$ActionModeCallback(this, (byte)0), 1);
      if (actionMode != null) {
        LGEmailActionModeWorkaroundImpl.runIfNecessary(this.mContext, actionMode);
        assert false;
        throw new AssertionError();
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\FloatingPastePopupMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */