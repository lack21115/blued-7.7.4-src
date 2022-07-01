package org.chromium.content.browser.selection;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.Context;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.textclassifier.TextClassification;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public final class AdditionalMenuItemProviderImpl implements AdditionalMenuItemProvider {
  private final Map mAssistClickHandlers = new HashMap<Object, Object>();
  
  public final void addMenuItems(Context paramContext, Menu paramMenu, TextClassification paramTextClassification) {
    if (paramMenu == null || paramTextClassification == null)
      throw new VerifyError("bad dex opcode"); 
    int j = paramTextClassification.getActions().size();
    if (j > 0) {
      RemoteAction remoteAction = paramTextClassification.getActions().get(0);
      MenuItem menuItem = paramMenu.findItem(16908353);
      if (remoteAction.shouldShowIcon()) {
        menuItem.setIcon(remoteAction.getIcon().loadDrawable(paramContext));
      } else {
        menuItem.setIcon(null);
      } 
    } 
    int i;
    for (i = 1; i < j; i++) {
      AdditionalMenuItemProviderImpl$$Lambda$0 additionalMenuItemProviderImpl$$Lambda$0;
      RemoteAction remoteAction = paramTextClassification.getActions().get(i);
      CharSequence charSequence = remoteAction.getTitle();
      PendingIntent pendingIntent = remoteAction.getActionIntent();
      if (TextUtils.isEmpty(charSequence) || pendingIntent == null) {
        charSequence = null;
      } else {
        additionalMenuItemProviderImpl$$Lambda$0 = new AdditionalMenuItemProviderImpl$$Lambda$0(pendingIntent);
      } 
      if (additionalMenuItemProviderImpl$$Lambda$0 != null) {
        MenuItem menuItem = paramMenu.add(16908353, 0, i + 50, remoteAction.getTitle());
        menuItem.setContentDescription(remoteAction.getContentDescription());
        if (remoteAction.shouldShowIcon())
          menuItem.setIcon(remoteAction.getIcon().loadDrawable(paramContext)); 
        menuItem.setShowAsAction(1);
        this.mAssistClickHandlers.put(menuItem, additionalMenuItemProviderImpl$$Lambda$0);
      } 
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void clearMenuItemListeners() {
    this.mAssistClickHandlers.clear();
  }
  
  public final void performAction(MenuItem paramMenuItem, View paramView) {
    View.OnClickListener onClickListener = (View.OnClickListener)this.mAssistClickHandlers.get(paramMenuItem);
    if (onClickListener == null)
      return; 
    onClickListener.onClick(paramView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\AdditionalMenuItemProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */