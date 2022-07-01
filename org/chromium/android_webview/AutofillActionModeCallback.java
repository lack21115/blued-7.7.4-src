package org.chromium.android_webview;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import org.chromium.build.BuildHooksAndroid;
import org.chromium.components.autofill.AutofillProvider;

public final class AutofillActionModeCallback implements ActionMode.Callback {
  private final int mAutofillMenuItem;
  
  private final int mAutofillMenuItemTitle;
  
  private final AutofillProvider mAutofillProvider;
  
  private final Context mContext;
  
  public AutofillActionModeCallback(Context paramContext, AutofillProvider paramAutofillProvider) {
    this.mContext = paramContext;
    this.mAutofillProvider = paramAutofillProvider;
    this.mAutofillMenuItemTitle = BuildHooksAndroid.getIdentifier(this.mContext.getResources(), "autofill", "string", "android");
    this.mAutofillMenuItem = BuildHooksAndroid.getIdentifier(this.mContext.getResources(), "autofill", "id", "android");
  }
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
    if (paramMenuItem.getItemId() == this.mAutofillMenuItem) {
      this.mAutofillProvider.queryAutofillSuggestion();
      paramActionMode.finish();
      return true;
    } 
    return false;
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
    return (this.mAutofillMenuItemTitle != 0 && this.mAutofillMenuItem != 0);
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
    if (this.mAutofillMenuItemTitle != 0 && this.mAutofillProvider.shouldQueryAutofillSuggestion())
      paramMenu.add(0, this.mAutofillMenuItem, 196608, this.mAutofillMenuItemTitle).setShowAsActionFlags(5); 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AutofillActionModeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */