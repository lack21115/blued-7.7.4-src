package org.chromium.ui.widget;

public final class UiWidgetFactory {
  private static UiWidgetFactory sFactory;
  
  public static UiWidgetFactory getInstance() {
    if (sFactory == null)
      sFactory = new UiWidgetFactory(); 
    return sFactory;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\widget\UiWidgetFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */