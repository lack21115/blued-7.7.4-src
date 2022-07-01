package org.chromium.content.browser.selection;

import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.SelectionClient;

final class SelectionPopupControllerImpl$SmartSelectionCallback implements SelectionClient.ResultCallback {
  private SelectionPopupControllerImpl$SmartSelectionCallback() {}
  
  public final void onClassified(SelectionClient.Result paramResult) {
    if (!SelectionPopupControllerImpl.this.mHasSelection) {
      SelectionPopupControllerImpl.access$902(SelectionPopupControllerImpl.this, null);
      return;
    } 
    if (paramResult.startAdjust > 0 || paramResult.endAdjust < 0) {
      SelectionPopupControllerImpl.access$902(SelectionPopupControllerImpl.this, null);
      SelectionPopupControllerImpl.this.showActionModeOrClearOnFailure();
      return;
    } 
    SelectionPopupControllerImpl.access$902(SelectionPopupControllerImpl.this, paramResult);
    if (paramResult.startAdjust != 0 || paramResult.endAdjust != 0) {
      WebContentsImpl webContentsImpl = SelectionPopupControllerImpl.access$700(SelectionPopupControllerImpl.this);
      int i = paramResult.startAdjust;
      int j = paramResult.endAdjust;
      webContentsImpl.nativeAdjustSelectionByCharacterOffset(webContentsImpl.mNativeWebContentsAndroid, i, j, true);
      return;
    } 
    if (SelectionPopupControllerImpl.access$1000(SelectionPopupControllerImpl.this) != null)
      SelectionPopupControllerImpl.access$1000(SelectionPopupControllerImpl.this).logSelectionModified(SelectionPopupControllerImpl.access$1100(SelectionPopupControllerImpl.this), SelectionPopupControllerImpl.access$1200(SelectionPopupControllerImpl.this), SelectionPopupControllerImpl.access$900(SelectionPopupControllerImpl.this)); 
    SelectionPopupControllerImpl.this.showActionModeOrClearOnFailure();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SelectionPopupControllerImpl$SmartSelectionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */