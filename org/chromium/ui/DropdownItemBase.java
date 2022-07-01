package org.chromium.ui;

public class DropdownItemBase implements DropdownItem {
  public int getIconId() {
    return 0;
  }
  
  public final int getIconMarginResId() {
    return R$dimen.dropdown_icon_margin;
  }
  
  public final int getIconSizeResId() {
    return 0;
  }
  
  public String getLabel() {
    return null;
  }
  
  public int getLabelFontColorResId() {
    return R$drawable.dropdown_label_color;
  }
  
  public String getSublabel() {
    return null;
  }
  
  public final int getSublabelFontSizeResId() {
    return R$dimen.text_size_small;
  }
  
  public boolean isBoldLabel() {
    return false;
  }
  
  public boolean isEnabled() {
    return true;
  }
  
  public boolean isGroupHeader() {
    return false;
  }
  
  public boolean isIconAtStart() {
    return false;
  }
  
  public boolean isMultilineLabel() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownItemBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */