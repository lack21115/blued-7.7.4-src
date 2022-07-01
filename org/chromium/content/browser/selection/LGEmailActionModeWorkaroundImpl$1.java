package org.chromium.content.browser.selection;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import org.chromium.base.ThreadUtils;

final class LGEmailActionModeWorkaroundImpl$1 extends ActionMode.Callback2 {
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
    return c.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
    return c.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode) {
    ThreadUtils.postOnUiThread(new LGEmailActionModeWorkaroundImpl$1$1(this, paramActionMode));
  }
  
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
    return c.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\LGEmailActionModeWorkaroundImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */