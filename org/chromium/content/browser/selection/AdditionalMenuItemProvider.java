package org.chromium.content.browser.selection;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.textclassifier.TextClassification;

public interface AdditionalMenuItemProvider {
  void addMenuItems(Context paramContext, Menu paramMenu, TextClassification paramTextClassification);
  
  void clearMenuItemListeners();
  
  void performAction(MenuItem paramMenuItem, View paramView);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\AdditionalMenuItemProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */