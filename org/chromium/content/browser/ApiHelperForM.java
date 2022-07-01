package org.chromium.content.browser;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.View;
import org.chromium.base.annotations.DoNotInline;
import org.chromium.content.browser.selection.FloatingActionModeCallback;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content_public.browser.ActionModeCallbackHelper;

@TargetApi(23)
@DoNotInline
public final class ApiHelperForM {
  public static ActionMode startActionMode(View paramView, SelectionPopupControllerImpl paramSelectionPopupControllerImpl, ActionMode.Callback paramCallback) {
    return paramView.startActionMode((ActionMode.Callback)new FloatingActionModeCallback((ActionModeCallbackHelper)paramSelectionPopupControllerImpl, paramCallback), 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ApiHelperForM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */