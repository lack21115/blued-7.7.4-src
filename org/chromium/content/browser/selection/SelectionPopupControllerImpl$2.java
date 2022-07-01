package org.chromium.content.browser.selection;

final class SelectionPopupControllerImpl$2 implements PastePopupMenu$PastePopupMenuDelegate {
  public final boolean canPaste() {
    return SelectionPopupControllerImpl.access$800(SelectionPopupControllerImpl.this);
  }
  
  public final boolean canPasteAsPlainText() {
    return SelectionPopupControllerImpl.this.canPasteAsPlainText();
  }
  
  public final boolean canSelectAll() {
    return SelectionPopupControllerImpl.this.mCanSelectAllForPastePopup;
  }
  
  public final void paste() {
    SelectionPopupControllerImpl.this.mWebContents.paste();
    SelectionPopupControllerImpl.access$700(SelectionPopupControllerImpl.this).dismissTextHandles();
  }
  
  public final void pasteAsPlainText() {
    SelectionPopupControllerImpl.this.pasteAsPlainText();
    SelectionPopupControllerImpl.access$700(SelectionPopupControllerImpl.this).dismissTextHandles();
  }
  
  public final void selectAll() {
    SelectionPopupControllerImpl.this.selectAll();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SelectionPopupControllerImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */