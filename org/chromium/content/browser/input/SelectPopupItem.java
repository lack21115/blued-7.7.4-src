package org.chromium.content.browser.input;

import org.chromium.ui.DropdownItemBase;

public final class SelectPopupItem extends DropdownItemBase {
  final String mLabel;
  
  final int mType;
  
  public SelectPopupItem(String paramString, int paramInt) {
    this.mLabel = paramString;
    this.mType = paramInt;
  }
  
  public final String getLabel() {
    return this.mLabel;
  }
  
  public final boolean isEnabled() {
    return (this.mType == 2 || this.mType == 0);
  }
  
  public final boolean isGroupHeader() {
    return (this.mType == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SelectPopupItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */