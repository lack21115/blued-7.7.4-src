package org.chromium.content_public.browser;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;

public abstract class ActionModeCallbackHelper {
  public static final ActionModeCallbackHelper$EmptyActionCallback EMPTY_CALLBACK = new ActionModeCallbackHelper$EmptyActionCallback((byte)0);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String sanitizeQuery(String paramString, int paramInt) {
    return SelectionPopupControllerImpl.sanitizeQuery(paramString, paramInt);
  }
  
  public abstract String getSelectedText();
  
  public abstract boolean isActionModeValid();
  
  public abstract boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem);
  
  public abstract void onCreateActionMode(ActionMode paramActionMode, Menu paramMenu);
  
  public abstract void onDestroyActionMode();
  
  public abstract void onGetContentRect$4c31e730(Rect paramRect);
  
  public abstract boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu);
  
  public abstract void setAllowedMenuItems(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\ActionModeCallbackHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */