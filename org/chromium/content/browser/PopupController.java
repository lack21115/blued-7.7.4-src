package org.chromium.content.browser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content.browser.webcontents.WebContentsUserData;
import org.chromium.content_public.browser.WebContents;

public class PopupController {
  private final List mHideablePopups = new ArrayList();
  
  private PopupController() {}
  
  public static PopupController fromWebContents(WebContents paramWebContents) {
    return (PopupController)WebContentsUserData.fromWebContents(paramWebContents, PopupController.class, PopupController$UserDataFactoryLazyHolder.access$100());
  }
  
  public static void hideAll(WebContents paramWebContents) {
    if (paramWebContents == null)
      return; 
    PopupController popupController = fromWebContents(paramWebContents);
    if (popupController != null)
      popupController.hideAllPopups(); 
  }
  
  public static void hidePopupsAndClearSelection(WebContents paramWebContents) {
    if (paramWebContents == null)
      return; 
    SelectionPopupControllerImpl selectionPopupControllerImpl = SelectionPopupControllerImpl.fromWebContents(paramWebContents);
    if (selectionPopupControllerImpl != null)
      selectionPopupControllerImpl.destroyActionModeAndUnselect(); 
    hideAll(paramWebContents);
  }
  
  public static void register(WebContents paramWebContents, PopupController$HideablePopup paramPopupController$HideablePopup) {
    if (paramWebContents == null)
      return; 
    fromWebContents(paramWebContents).registerPopup(paramPopupController$HideablePopup);
  }
  
  public final void hideAllPopups() {
    Iterator<PopupController$HideablePopup> iterator = this.mHideablePopups.iterator();
    while (iterator.hasNext())
      ((PopupController$HideablePopup)iterator.next()).hide(); 
  }
  
  public final void registerPopup(PopupController$HideablePopup paramPopupController$HideablePopup) {
    this.mHideablePopups.add(paramPopupController$HideablePopup);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\PopupController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */