package org.chromium.ui;

public interface DropdownItem {
  int getIconId();
  
  int getIconMarginResId();
  
  int getIconSizeResId();
  
  String getLabel();
  
  int getLabelFontColorResId();
  
  String getSublabel();
  
  int getSublabelFontSizeResId();
  
  boolean isBoldLabel();
  
  boolean isEnabled();
  
  boolean isGroupHeader();
  
  boolean isIconAtStart();
  
  boolean isMultilineLabel();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */