package org.chromium.android_webview;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import org.chromium.base.metrics.RecordUserAction;
import org.chromium.content.R;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content_public.browser.ActionModeCallbackHelper;
import org.chromium.content_public.browser.WebContents;

public class AwActionModeCallback implements ActionMode.Callback {
  private int mAllowedMenuItems;
  
  private final AwContents mAwContents;
  
  private final Context mContext;
  
  private final ActionModeCallbackHelper mHelper;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwActionModeCallback(Context paramContext, AwContents paramAwContents, WebContents paramWebContents) {
    this.mContext = paramContext;
    this.mAwContents = paramAwContents;
    this.mHelper = SelectionPopupControllerImpl.fromWebContents(paramWebContents).getActionModeCallbackHelper();
    this.mHelper.setAllowedMenuItems(0);
  }
  
  private int getAllowedMenu(int paramInt) {
    boolean bool1;
    boolean bool2 = true;
    if (paramInt == 2) {
      Intent intent = new Intent("android.intent.action.WEB_SEARCH");
      intent.putExtra("new_search", true);
      if (this.mContext.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
    } else {
      bool1 = true;
    } 
    if (bool1) {
      if ((this.mAwContents.mSettings.getDisabledActionModeMenuItems() & paramInt) != paramInt) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      if (bool1)
        return paramInt; 
    } 
    return 0;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
    AwContents awContents;
    if (!this.mHelper.isActionModeValid())
      return true; 
    if (paramMenuItem.getGroupId() == R.id.select_action_menu_text_processing_menus) {
      Intent intent = paramMenuItem.getIntent();
      RecordUserAction.record("MobileActionMode.ProcessTextIntent");
      assert false;
      throw new AssertionError();
    } 
    return this.mHelper.onActionItemClicked((ActionMode)activityNotFoundException, (MenuItem)awContents);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
    int i = getAllowedMenu(1) | getAllowedMenu(2) | getAllowedMenu(4);
    if (i != this.mAllowedMenuItems) {
      this.mHelper.setAllowedMenuItems(i);
      this.mAllowedMenuItems = i;
    } 
    this.mHelper.onCreateActionMode(paramActionMode, paramMenu);
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {
    this.mHelper.onDestroyActionMode();
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
    return this.mHelper.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwActionModeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */